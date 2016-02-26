/*******************************************************************************
 * Copyright (c) 2003, 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.browser;

import java.io.*;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.internal.*;
import org.eclipse.swt.internal.gtk.*;
import org.eclipse.swt.internal.mozilla.*;
import org.eclipse.swt.widgets.*;

class MozillaDelegate {
	Browser browser;
	Shell eventShell;
	long /*int*/ mozillaHandle, embedHandle;
	boolean hasFocus;
	Listener listener;
	static Callback eventCallback;
	static long /*int*/ eventProc;
	static Boolean IsXULRunner24;
	static final int STOP_PROPOGATE = 1;
	static final String LIB_FIX_XULRUNNER10 = "libswt-xulrunner-fix10.so"; //$NON-NLS-1$
	static final String LIB_FIX_XULRUNNER31 = "libswt-xulrunner-fix31.so"; //$NON-NLS-1$
	static final String LIB_XPCOM = "libxpcom.so"; //$NON-NLS-1$
	static final String LIB_XUL = "libxul.so"; //$NON-NLS-1$

	static boolean IsSparc;
	static {
		String osName = System.getProperty ("os.name").toLowerCase (); //$NON-NLS-1$
		String osArch = System.getProperty ("os.arch").toLowerCase (); //$NON-NLS-1$
		IsSparc = (osName.startsWith ("sunos") || osName.startsWith ("solaris")) && osArch.startsWith("sparc"); //$NON-NLS-1$
	}

MozillaDelegate (Browser browser) {
	super ();
	/*
	* The mozilla libraries on SPARC need the C++ runtime library to be loaded, but they do not declare
	* this dependency because they usually get it for free as a result of the mozilla executable pulling it
	* in.  Load this library here and scope it globally so that the mozilla libraries can resolve.
	*/
	if (IsSparc) {
		byte[] buffer = Converter.wcsToMbcs (null, "libCrun.so.1", true); //$NON-NLS-1$
		OS.dlopen (buffer, OS.RTLD_NOW | OS.RTLD_GLOBAL);
	}
	if (OS.GTK3) {
		String errorString = " [Browser style SWT.MOZILLA and Java system property org.eclipse.swt.browser.DefaultType=mozilla are not supported with GTK 3 as XULRunner is not ported for GTK 3 yet]"; // $NON-NLS-1$
		SWT.error (SWT.ERROR_NO_HANDLES, null, errorString);
	}
	this.browser = browser;
}

static long /*int*/ eventProc (long /*int*/ handle, long /*int*/ gdkEvent, long /*int*/ pointer) {
	long /*int*/ parent = OS.gtk_widget_get_parent (handle);
	parent = OS.gtk_widget_get_parent (parent);
	if (parent == 0) return 0;
	Widget widget = Display.getCurrent ().findWidget (parent);
	if (widget != null && widget instanceof Browser) {
		return ((Mozilla)((Browser)widget).webBrowser).delegate.gtk_event (handle, gdkEvent, pointer);
	}
	return 0;
}

static Browser findBrowser (long /*int*/ handle) {
	/*
	* Note.  On GTK, Mozilla is embedded into a GtkHBox handle
	* and not directly into the parent Composite handle.
	*/
	long /*int*/ parent = OS.gtk_widget_get_parent (handle);
	Display display = Display.getCurrent ();
	return (Browser)display.findWidget (parent);
}

static String getCacheParentPath () {
	return getProfilePath ();
}

static String[] getJSLibraryNames () {
	return new String[] {"libxul.so"}; //$NON-NLS-1$
}

static String getJSLibraryName_Pre10() {
	return "libmozjs.so"; //$NON-NLS-1$
}

static String getLibraryName (String mozillaPath) {
	/*
	 * The name of the Gecko library to glue to changed between the XULRunner 10 and
	 * 24 releases.  However it's not possible to programmatically know the version
	 * of a XULRunner that's being used before it has been glued.  To determine the
	 * appropriate Gecko library name to return, look for the presence of an "xpcom"
	 * library in the mozilla path, which is present in all supported XULRunner releases
	 * prior to XULRunner 24.  If this library is there then return it, and if it's not
	 * there then assume that XULRunner 24 is being used and return the new library name
	 * instead ("xul").
	 */
	if (IsXULRunner24 == null) { /* IsXULRunner24 not yet initialized */
		IsXULRunner24 = new File (mozillaPath, LIB_XPCOM).exists () ? Boolean.FALSE : Boolean.TRUE;
	}
	return IsXULRunner24.booleanValue () ? LIB_XUL : LIB_XPCOM;
}

static String getProfilePath () {
	String baseDir = System.getProperty ("user.home"); //$NON-NLS-1$

	/*
	 * Bug in Sun JRE.  Under some circumstances the value of java property "user.home" is
	 * "?", even when the HOME environment variable has a valid value.  If this happens
	 * then attempt to read the value from the environment directly.
	 */
	if (baseDir.equals ("?")) { //$NON-NLS-1$
		long /*int*/ ptr = C.getenv (wcsToMbcs (null, "HOME", true)); //$NON-NLS-1$
		if (ptr != 0) {
			int length = C.strlen (ptr);
			byte[] bytes = new byte[length];
			C.memmove (bytes, ptr, length);
			baseDir = new String (mbcsToWcs (null, bytes));
		}
	}

	return baseDir + Mozilla.SEPARATOR_OS + ".mozilla" + Mozilla.SEPARATOR_OS + "eclipse"; //$NON-NLS-1$ //$NON-NLS-2$
}

static String getSWTInitLibraryName () {
	return "swt-xpcominit"; //$NON-NLS-1$
}

static void loadAdditionalLibraries (String mozillaPath, boolean isGlued) {
	/*
	 * This function is invoked twice, once before gluing (the fix library for
	 * XULRunner 24/XULRunner 31, if appropriate, must be loaded before attempting to glue),
	 * and once after gluing (to load the XULRunner 10 fix library, if appropriate).
	 */
	String libName = null;
	if (!isGlued) {
		if (IsXULRunner24 == null) { /* IsXULRunner24 not yet initialized */
			IsXULRunner24 = new File (mozillaPath, LIB_XPCOM).exists () ? Boolean.FALSE : Boolean.TRUE;
		}
		if (IsXULRunner24.booleanValue ()) {
			/*
			* Works around https://bugzilla.mozilla.org/show_bug.cgi?id=720682
			* and https://bugzilla.mozilla.org/show_bug.cgi?id=763327.
			*/
			/*
			 * LIB_FIX_XULRUNNER31 is built against XULRunner 31 SDK and it is used as the fix library
			 * for both XULRunner 24 and XULRunner 31.
			 */
			libName = LIB_FIX_XULRUNNER31;
		}
	} else {
		/*
		* This is the second invocation of loadAdditionalLibraries(), so the
		* specific xulrunner runtime version is now better known.
		*/
		if (MozillaVersion.CheckVersion (MozillaVersion.VERSION_XR10, true)) {
			/* works around https://bugzilla.mozilla.org/show_bug.cgi?id=720682 */
			libName = LIB_FIX_XULRUNNER10;
		}
	}

	if (libName == null) return;

	File libsDir = new File (getProfilePath () + "/libs/" + Mozilla.OS () + '/' + Mozilla.Arch ()); //$NON-NLS-1$
	File file = new File (libsDir, libName);
	if (!file.exists()) {
		java.io.InputStream is = Library.class.getResourceAsStream ('/' + libName);
		if (is != null) {
			if (!libsDir.exists ()) {
				libsDir.mkdirs ();
			}
			int read;
			byte [] buffer = new byte [4096];
			try {
				FileOutputStream os = new FileOutputStream (file);
				while ((read = is.read (buffer)) != -1) {
					os.write(buffer, 0, read);
				}
				os.close ();
				is.close ();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		}
	}
	if (file.exists ()) {
		byte[] bytes = Converter.wcsToMbcs (null, file.getAbsolutePath (), true);
		OS.dlopen (bytes, OS.RTLD_NOW | OS.RTLD_GLOBAL);
	}
}

static char[] mbcsToWcs (String codePage, byte [] buffer) {
	return Converter.mbcsToWcs (codePage, buffer);
}

static boolean needsSpinup () {
	return true;
}

static byte[] wcsToMbcs (String codePage, String string, boolean terminate) {
	return Converter.wcsToMbcs (codePage, string, terminate);
}

void addWindowSubclass () {
}

int createBaseWindow (nsIBaseWindow baseWindow) {
	return baseWindow.Create ();
}

long /*int*/ getHandle () {
	/*
	* Bug in Mozilla Linux GTK.  Embedding Mozilla into a GtkFixed
	* handle causes problems with some Mozilla plug-ins.  For some
	* reason, the Flash plug-in causes the child of the GtkFixed
	* handle to be resized to 1 when the Flash document is loaded.
	* That could be due to gtk_container_resize_children being called
	* by Mozilla - or one of its plug-ins - on the GtkFixed handle,
	* causing the child of the GtkFixed handle to be resized to 1.
	* The workaround is to embed Mozilla into a GtkHBox handle.
	*/
	if (OS.GTK3) {
		embedHandle = OS.gtk_box_new (OS.GTK_ORIENTATION_HORIZONTAL, 0);
		OS.gtk_box_set_homogeneous (embedHandle, false);
	} else {
		embedHandle = OS.gtk_hbox_new (false, 0);
	}
	OS.gtk_container_add (browser.handle, embedHandle);
	OS.gtk_widget_show (embedHandle);
	return embedHandle;
}

Point getNativeSize (int width, int height) {
	return new Point (width, height);
}

long /*int*/ getSiteWindow () {
	return embedHandle;
}

long /*int*/ gtk_event (long /*int*/ handle, long /*int*/ gdkEvent, long /*int*/ pointer) {
	GdkEvent event = new GdkEvent ();
	OS.memmove (event, gdkEvent, GdkEvent.sizeof);
	if (event.type == OS.GDK_BUTTON_PRESS) {
		if (!hasFocus) browser.setFocus ();
	}

	/*
	* Stop the propagation of events that are not consumed by Mozilla, before
	* they reach the parent embedder.  These event have already been received.
	*/
	if (pointer == STOP_PROPOGATE) return 1;
	return 0;
}

void handleFocus () {
	if (hasFocus) return;
	hasFocus = true;
	listener = new Listener () {
		@Override
		public void handleEvent (Event event) {
			if (event.widget == browser) return;
			if (event.type != SWT.Dispose) {
				((Mozilla)browser.webBrowser).Deactivate ();
				hasFocus = false;
			}
			eventShell.getDisplay ().removeFilter (SWT.FocusIn, this);
			eventShell.removeListener (SWT.Deactivate, this);
			eventShell.removeListener (SWT.Dispose, this);
			eventShell = null;
			listener = null;
		}
	};
	eventShell = browser.getShell ();
	eventShell.getDisplay ().addFilter (SWT.FocusIn, listener);
	eventShell.addListener (SWT.Deactivate, listener);
	eventShell.addListener (SWT.Dispose, listener);
}

void handleMouseDown () {
	int shellStyle = browser.getShell ().getStyle ();
	if ((shellStyle & SWT.ON_TOP) != 0 && (((shellStyle & SWT.NO_FOCUS) == 0) || ((browser.getStyle () & SWT.NO_FOCUS) == 0))) {
		browser.getDisplay ().asyncExec (new Runnable () {
			@Override
			public void run () {
				if (browser == null || browser.isDisposed ()) return;
				((Mozilla)browser.webBrowser).Activate ();
			}
		});
	}
}

boolean hookEnterExit () {
	return false;
}

void init () {
	if (eventCallback == null) {
		eventCallback = new Callback (getClass (), "eventProc", 3); //$NON-NLS-1$
		eventProc = eventCallback.getAddress ();
		if (eventProc == 0) {
			browser.dispose ();
			Mozilla.error (SWT.ERROR_NO_MORE_CALLBACKS);
		}
	}

	/*
	* Feature in Mozilla.  GtkEvents such as key down, key pressed may be consumed
	* by Mozilla and never be received by the parent embedder.  The workaround
	* is to find the top Mozilla gtk widget that receives all the Mozilla GtkEvents,
	* i.e. the first child of the parent embedder. Then hook event callbacks and
	* forward the event to the parent embedder before Mozilla received and consumed
	* them.
	*/
	long /*int*/ list = OS.gtk_container_get_children (embedHandle);
	if (list != 0) {
		mozillaHandle = OS.g_list_data (list);
		OS.g_list_free (list);

		if (mozillaHandle != 0) {
			/* Note. Callback to get events before Mozilla receives and consumes them. */
			OS.g_signal_connect (mozillaHandle, OS.event, eventProc, 0);

			/*
			* Note.  Callback to get the events not consumed by Mozilla - and to block
			* them so that they don't get propagated to the parent handle twice.
			* This hook is set after Mozilla and is therefore called after Mozilla's
			* handler because GTK dispatches events in their order of registration.
			*/
			OS.g_signal_connect (mozillaHandle, OS.key_press_event, eventProc, STOP_PROPOGATE);
			OS.g_signal_connect (mozillaHandle, OS.key_release_event, eventProc, STOP_PROPOGATE);
			OS.g_signal_connect (mozillaHandle, OS.button_press_event, eventProc, STOP_PROPOGATE);
		}
	}
}

void onDispose (long /*int*/ embedHandle) {
	if (listener != null) {
		eventShell.getDisplay ().removeFilter (SWT.FocusIn, listener);
		eventShell.removeListener (SWT.Deactivate, listener);
		eventShell.removeListener (SWT.Dispose, listener);
		eventShell = null;
		listener = null;
	}
	browser = null;
}

void removeWindowSubclass () {
}

boolean sendTraverse () {
	return true;
}

void setSize (long /*int*/ embedHandle, int width, int height) {
	OS.gtk_widget_set_size_request (embedHandle, width, height);
}

}
