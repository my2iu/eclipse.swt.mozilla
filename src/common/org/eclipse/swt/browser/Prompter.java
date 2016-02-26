/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.browser;

import org.eclipse.swt.*;
import org.eclipse.swt.internal.*;
import org.eclipse.swt.internal.mozilla.*;
import org.eclipse.swt.widgets.*;

class Prompter {
	XPCOMObject supports;
	XPCOMObject prompt;
	int refCount = 0;
	long /*int*/ parent;

Prompter () {
	createCOMInterfaces ();
}

int AddRef () {
	refCount++;
	return refCount;
}

void createCOMInterfaces () {
	/* Create each of the interfaces that this object implements */
	supports = new XPCOMObject (new int[] {2, 0, 0}) {
		@Override
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		@Override
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		@Override
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
	};

	prompt = new XPCOMObject (new int[] {2, 0, 0, 2, 4, 3, 5, 9, 6, 6, 7, 6}) {
		@Override
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		@Override
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		@Override
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
		@Override
		public long /*int*/ method3 (long /*int*/[] args) {return Alert (args[0], args[1] );}
		@Override
		public long /*int*/ method4 (long /*int*/[] args) {return AlertCheck (args[0], args[1], args[2], args[3]);}
		@Override
		public long /*int*/ method5 (long /*int*/[] args) {return Confirm (args[0], args[1], args[2]);}
		@Override
		public long /*int*/ method6 (long /*int*/[] args) {return ConfirmCheck (args[0], args[1], args[2], args[3], args[4]);}
		@Override
		public long /*int*/ method7 (long /*int*/[] args) {return ConfirmEx (args[0], args[1], (int)/*64*/args[2], args[3], args[4], args[5], args[6], args[7], args[8]);}
		@Override
		public long /*int*/ method8 (long /*int*/[] args) {return Prompt (args[0], args[1], args[2], args[3], args[4], args[5]);}
		@Override
		public long /*int*/ method9 (long /*int*/[] args) {return PromptPassword (args[0], args[1], args[2], args[3], args[4], args[5]);}
		@Override
		public long /*int*/ method10 (long /*int*/[] args) {return PromptUsernameAndPassword (args[0], args[1], args[2], args[3], args[4], args[5], args[6]);}
		@Override
		public long /*int*/ method11 (long /*int*/[] args) {return Select (args[0], args[1], (int)/*64*/args[2], args[3], args[4], args[5]);}
	};
}

void disposeCOMInterfaces () {
	if (supports != null) {
		supports.dispose ();
		supports = null;
	}
	if (prompt != null) {
		prompt.dispose ();
		prompt = null;
	}
}

long /*int*/ getAddress () {
	return prompt.getAddress ();
}

int QueryInterface (long /*int*/ riid, long /*int*/ ppvObject) {
	if (riid == 0 || ppvObject == 0) return XPCOM.NS_ERROR_NO_INTERFACE;
	nsID guid = new nsID ();
	XPCOM.memmove (guid, riid, nsID.sizeof);

	if (guid.Equals (XPCOM.NS_ISUPPORTS_IID)) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {supports.getAddress ()}, C.PTR_SIZEOF);
		AddRef ();
		return XPCOM.NS_OK;
	}
	if (guid.Equals (IIDStore.GetIID (nsIPrompt.class))) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {prompt.getAddress ()}, C.PTR_SIZEOF);
		AddRef ();
		return XPCOM.NS_OK;
	}
	XPCOM.memmove (ppvObject, new long /*int*/[] {0}, C.PTR_SIZEOF);
	return XPCOM.NS_ERROR_NO_INTERFACE;
}

int Release () {
	refCount--;
	if (refCount == 0) disposeCOMInterfaces ();
	return refCount;
}

Browser getBrowser () {
	if (parent == 0) return null;
	return Mozilla.getBrowser (parent);
}

String getLabel (int buttonFlag, int index, long /*int*/ buttonTitle) {
	String label = null;
	int flag = (buttonFlag & (0xff * index)) / index;
	switch (flag) {
		case nsIPrompt.BUTTON_TITLE_CANCEL: label = SWT.getMessage ("SWT_Cancel"); break; //$NON-NLS-1$
		case nsIPrompt.BUTTON_TITLE_NO: label = SWT.getMessage ("SWT_No"); break; //$NON-NLS-1$
		case nsIPrompt.BUTTON_TITLE_OK: label = SWT.getMessage ("SWT_OK"); break; //$NON-NLS-1$
		case nsIPrompt.BUTTON_TITLE_SAVE: label = SWT.getMessage ("SWT_Save"); break; //$NON-NLS-1$
		case nsIPrompt.BUTTON_TITLE_YES: label = SWT.getMessage ("SWT_Yes"); break; //$NON-NLS-1$
		case nsIPrompt.BUTTON_TITLE_IS_STRING: {
			int length = XPCOM.strlen_PRUnichar (buttonTitle);
			char[] dest = new char[length];
			XPCOM.memmove (dest, buttonTitle, length * 2);
			label = new String (dest);
		}
	}
	return label;
}

void setParent(long /*int*/ aParent) {
	parent = aParent;
}

/* nsIPrompt */

int Alert (long /*int*/ aDialogTitle, long /*int*/ aText) {
	final Browser browser = getBrowser ();

	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);

	/*
	* If mozilla is re-navigating to a page with a bad certificate in order
	* to get its certificate info then do not show cert error message alerts.
	*/
	if (browser != null) {
		Mozilla mozilla = (Mozilla)browser.webBrowser;
		if (mozilla.isRetrievingBadCert) return XPCOM.NS_OK;
	}

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	MessageBox messageBox = new MessageBox (shell, SWT.OK | SWT.ICON_WARNING);
	messageBox.setText (titleLabel);
	messageBox.setMessage (textLabel);
	messageBox.open ();
	return XPCOM.NS_OK;
}

int AlertCheck (long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aCheckMsg, long /*int*/ aCheckState) {
	Browser browser = getBrowser ();

	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aCheckMsg);
	dest = new char[length];
	XPCOM.memmove (dest, aCheckMsg, length * 2);
	String checkLabel = new String (dest);

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	boolean[] check = new boolean[1];
	if (aCheckState != 0) XPCOM.memmove (check, aCheckState);
	dialog.alertCheck (titleLabel, textLabel, checkLabel, check);
	if (aCheckState != 0) XPCOM.memmove (aCheckState, check);
	return XPCOM.NS_OK;
}

int Confirm (long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ _retval) {
	Browser browser = getBrowser ();

	if (browser != null && ((Mozilla)browser.webBrowser).ignoreAllMessages) {
		XPCOM.memmove (_retval, new boolean[] {true});
		return XPCOM.NS_OK;
	}

	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	MessageBox messageBox = new MessageBox (shell, SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION);
	messageBox.setText (titleLabel);
	messageBox.setMessage (textLabel);
	int id = messageBox.open ();
	boolean[] result = {id == SWT.OK};
	XPCOM.memmove (_retval, result);
	return XPCOM.NS_OK;
}

int ConfirmCheck (long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	return XPCOM.NS_ERROR_NOT_IMPLEMENTED;
}

int ConfirmEx (long /*int*/ aDialogTitle, long /*int*/ aText, int aButtonFlags, long /*int*/ aButton0Title, long /*int*/ aButton1Title, long /*int*/ aButton2Title, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	Browser browser = getBrowser ();

	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);

	String checkLabel = null;
	if (aCheckMsg != 0) {
		length = XPCOM.strlen_PRUnichar (aCheckMsg);
		dest = new char[length];
		XPCOM.memmove (dest, aCheckMsg, length * 2);
		checkLabel = new String (dest);
	}

	String button0Label = getLabel (aButtonFlags, nsIPrompt.BUTTON_POS_0, aButton0Title);
	String button1Label = getLabel (aButtonFlags, nsIPrompt.BUTTON_POS_1, aButton1Title);
	String button2Label = getLabel (aButtonFlags, nsIPrompt.BUTTON_POS_2, aButton2Title);

	int defaultIndex = 0;
	if ((aButtonFlags & nsIPrompt.BUTTON_POS_1_DEFAULT) != 0) {
		defaultIndex = 1;
	} else if ((aButtonFlags & nsIPrompt.BUTTON_POS_2_DEFAULT) != 0) {
		defaultIndex = 2;
	}

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	boolean[] check = new boolean[1];
	int[] result = new int[1];
	if (aCheckState != 0) XPCOM.memmove (check, aCheckState);
	dialog.confirmEx (titleLabel, textLabel, checkLabel, button0Label, button1Label, button2Label, defaultIndex, check, result);
	if (aCheckState != 0) XPCOM.memmove (aCheckState, check);
	XPCOM.memmove (_retval, result, 4);
	return XPCOM.NS_OK;
}

int Prompt (long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aValue, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	Browser browser = getBrowser ();
	String titleLabel = null, textLabel, checkLabel = null;
	String[] valueLabel = new String[1];
	char[] dest;
	int length;
	if (aDialogTitle != 0) {
		length = XPCOM.strlen_PRUnichar (aDialogTitle);
		dest = new char[length];
		XPCOM.memmove (dest, aDialogTitle, length * 2);
		titleLabel = new String (dest);
	}

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	textLabel = new String (dest);

	long /*int*/[] valueAddr = new long /*int*/[1];
	XPCOM.memmove (valueAddr, aValue, C.PTR_SIZEOF);
	if (valueAddr[0] != 0) {
		length = XPCOM.strlen_PRUnichar (valueAddr[0]);
		dest = new char[length];
		XPCOM.memmove (dest, valueAddr[0], length * 2);
		valueLabel[0] = new String (dest);
	}

	if (aCheckMsg != 0) {
		length = XPCOM.strlen_PRUnichar (aCheckMsg);
		if (length > 0) {
			dest = new char[length];
			XPCOM.memmove (dest, aCheckMsg, length * 2);
			checkLabel = new String (dest);
		}
	}

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	boolean[] check = new boolean[1], result = new boolean[1];
	if (aCheckState != 0) XPCOM.memmove (check, aCheckState);
	dialog.prompt (titleLabel, textLabel, checkLabel, valueLabel, check, result);

	XPCOM.memmove (_retval, result);
	if (result[0]) {
		/*
		* User selected OK. User name and password are returned as PRUnichar values. Any default
		* value that we override must be freed using the nsIMemory service.
		*/
		if (valueLabel[0] != null) {
			long /*int*/[] result2 = new long /*int*/[1];
			int rc = XPCOM.NS_GetServiceManager (result2);
			if (rc != XPCOM.NS_OK) SWT.error (rc);
			if (result2[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);

			nsIServiceManager serviceManager = new nsIServiceManager (result2[0]);
			result2[0] = 0;
			byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
			rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result2);
			if (rc != XPCOM.NS_OK) SWT.error (rc);
			if (result2[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);
			serviceManager.Release ();

			nsIMemory memory = new nsIMemory (result2[0]);
			result2[0] = 0;

			int cnt = valueLabel[0].length ();
			char[] buffer = new char[cnt + 1];
			valueLabel[0].getChars (0, cnt, buffer, 0);
			int size = buffer.length * 2;
			long /*int*/ ptr = memory.Alloc (size);
			XPCOM.memmove (ptr, buffer, size);
			XPCOM.memmove (aValue, new long /*int*/[] {ptr}, C.PTR_SIZEOF);

			if (valueAddr[0] != 0) {
				memory.Free (valueAddr[0]);
			}
			memory.Release ();
		}
	}
	if (aCheckState != 0) XPCOM.memmove (aCheckState, check);
	return XPCOM.NS_OK;
}

int PromptAuth(long /*int*/ aChannel, int level, long /*int*/ authInfo, long /*int*/ _retval) {
	nsIAuthInformation auth = new nsIAuthInformation (authInfo);

	Browser browser = getBrowser ();
	if (browser != null) {
		Mozilla mozilla = (Mozilla)browser.webBrowser;
		/*
		 * Do not invoke the listeners if this challenge has been failed too many
		 * times because a listener is likely giving incorrect credentials repeatedly
		 * and will do so indefinitely.
		 */
		if (mozilla.authCount++ < 3) {
			for (int i = 0; i < mozilla.authenticationListeners.length; i++) {
				AuthenticationEvent event = new AuthenticationEvent (browser);
				event.location = mozilla.lastNavigateURL;
				mozilla.authenticationListeners[i].authenticate (event);
				if (!event.doit) {
					XPCOM.memmove (_retval, new boolean[] {false});
					return XPCOM.NS_OK;
				}
				if (event.user != null && event.password != null) {
					nsEmbedString string = new nsEmbedString (event.user);
					int rc = auth.SetUsername (string.getAddress ());
					if (rc != XPCOM.NS_OK) SWT.error (rc);
					string.dispose ();
					string = new nsEmbedString (event.password);
					rc = auth.SetPassword (string.getAddress ());
					if (rc != XPCOM.NS_OK) SWT.error (rc);
					string.dispose ();
					XPCOM.memmove (_retval, new boolean[] {true});
					return XPCOM.NS_OK;
				}
			}
		}
	}

	/* no listener handled the challenge, so show an authentication dialog */

	String checkLabel = null;
	boolean[] checkValue = new boolean[1];
	String[] userLabel = new String[1], passLabel = new String[1];

	String title = SWT.getMessage ("SWT_Authentication_Required"); //$NON-NLS-1$

	/* get initial username and password values */

	nsEmbedString ptr = new nsEmbedString ();
	int rc = auth.GetUsername (ptr.getAddress());
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	userLabel[0] = ptr.toString ();
	ptr.dispose ();

	ptr = new nsEmbedString ();
	rc = auth.GetPassword (ptr.getAddress());
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	passLabel[0] = ptr.toString ();
	ptr.dispose ();

	/* compute the message text */

	ptr = new nsEmbedString ();
	rc = auth.GetRealm (ptr.getAddress());
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	String realm = ptr.toString ();
	ptr.dispose ();

	nsIChannel channel = new nsIChannel (aChannel);
	long /*int*/[] uri = new long /*int*/[1];
	rc = channel.GetURI (uri);
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	if (uri[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIURI nsURI = new nsIURI (uri[0]);
	long /*int*/ host = XPCOM.nsEmbedCString_new ();
	rc = nsURI.GetHost (host);
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	int length = XPCOM.nsEmbedCString_Length (host);
	long /*int*/ buffer = XPCOM.nsEmbedCString_get (host);
	byte[] bytes = new byte[length];
	XPCOM.memmove (bytes, buffer, length);
	String hostString = new String (bytes);
	XPCOM.nsEmbedCString_delete (host);
	nsURI.Release ();

	String message;
	if (realm.length () > 0 && hostString.length () > 0) {
		message = Compatibility.getMessage ("SWT_Enter_Username_and_Password", new String[] {realm, hostString}); //$NON-NLS-1$
	} else {
		message = ""; //$NON-NLS-1$
	}

	/* open the prompter */
	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	boolean[] result = new boolean[1];
	dialog.promptUsernameAndPassword (title, message, checkLabel, userLabel, passLabel, checkValue, result);

	XPCOM.memmove (_retval, result);
	if (result[0]) {	/* User selected OK */
		nsEmbedString string = new nsEmbedString (userLabel[0]);
		rc = auth.SetUsername(string.getAddress ());
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		string.dispose ();

		string = new nsEmbedString (passLabel[0]);
		rc = auth.SetPassword(string.getAddress ());
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		string.dispose ();
	}

	return XPCOM.NS_OK;
}

int PromptUsernameAndPassword (long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aUsername, long /*int*/ aPassword, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	Browser browser = getBrowser ();
	String user = null, password = null;

	if (browser != null) {
		Mozilla mozilla = (Mozilla)browser.webBrowser;
		/*
		 * Do not invoke the listeners if this challenge has been failed too many
		 * times because a listener is likely giving incorrect credentials repeatedly
		 * and will do so indefinitely.
		 */
		if (mozilla.authCount++ < 3) {
			for (int i = 0; i < mozilla.authenticationListeners.length; i++) {
				AuthenticationEvent event = new AuthenticationEvent (browser);
				event.location = mozilla.lastNavigateURL;
				mozilla.authenticationListeners[i].authenticate (event);
				if (!event.doit) {
					XPCOM.memmove (_retval, new boolean[] {false});
					return XPCOM.NS_OK;
				}
				if (event.user != null && event.password != null) {
					user = event.user;
					password = event.password;
					XPCOM.memmove (_retval, new boolean[] {true});
					break;
				}
			}
		}
	}

	if (user == null) {
		/* no listener handled the challenge, so show an authentication dialog */

		String titleLabel, textLabel, checkLabel = null;
		String[] userLabel = new String[1], passLabel = new String[1];
		char[] dest;
		int length;
		if (aDialogTitle != 0) {
			length = XPCOM.strlen_PRUnichar (aDialogTitle);
			dest = new char[length];
			XPCOM.memmove (dest, aDialogTitle, length * 2);
			titleLabel = new String (dest);
		} else {
			titleLabel = SWT.getMessage ("SWT_Authentication_Required");	//$NON-NLS-1$
		}

		length = XPCOM.strlen_PRUnichar (aText);
		dest = new char[length];
		XPCOM.memmove (dest, aText, length * 2);
		textLabel = new String (dest);

		long /*int*/[] userAddr = new long /*int*/[1];
		XPCOM.memmove (userAddr, aUsername, C.PTR_SIZEOF);
		if (userAddr[0] != 0) {
			length = XPCOM.strlen_PRUnichar (userAddr[0]);
			dest = new char[length];
			XPCOM.memmove (dest, userAddr[0], length * 2);
			userLabel[0] = new String (dest);
		}

		long /*int*/[] passAddr = new long /*int*/[1];
		XPCOM.memmove (passAddr, aPassword, C.PTR_SIZEOF);
		if (passAddr[0] != 0) {
			length = XPCOM.strlen_PRUnichar (passAddr[0]);
			dest = new char[length];
			XPCOM.memmove (dest, passAddr[0], length * 2);
			passLabel[0] = new String (dest);
		}

		if (aCheckMsg != 0) {
			length = XPCOM.strlen_PRUnichar (aCheckMsg);
			if (length > 0) {
				dest = new char[length];
				XPCOM.memmove (dest, aCheckMsg, length * 2);
				checkLabel = new String (dest);
			}
		}

		Shell shell = browser == null ? new Shell () : browser.getShell ();
		PromptDialog dialog = new PromptDialog (shell);
		boolean[] check = new boolean[1], result = new boolean[1];
		if (aCheckState != 0) XPCOM.memmove (check, aCheckState);
		dialog.promptUsernameAndPassword (titleLabel, textLabel, checkLabel, userLabel, passLabel, check, result);

		XPCOM.memmove (_retval, result);
		if (result[0]) {
			/* User selected OK */
			user = userLabel[0];
			password = passLabel[0];
		}
		if (aCheckState != 0) XPCOM.memmove (aCheckState, check);
	}

	if (user != null) {
		/*
		* User name and password are returned as PRUnichar values. Any default
		* value that we override must be freed using the nsIMemory service.
		*/
		long /*int*/[] userAddr = new long /*int*/[1];
		XPCOM.memmove (userAddr, aUsername, C.PTR_SIZEOF);
		long /*int*/[] passAddr = new long /*int*/[1];
		XPCOM.memmove (passAddr, aPassword, C.PTR_SIZEOF);

		long /*int*/[] result = new long /*int*/[1];
		int rc = XPCOM.NS_GetServiceManager (result);
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		if (result[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);

		nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
		result[0] = 0;
		byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
		rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		if (result[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);
		serviceManager.Release ();

		nsIMemory memory = new nsIMemory (result[0]);
		result[0] = 0;
		if (userAddr[0] != 0) memory.Free (userAddr[0]);
		if (passAddr[0] != 0) memory.Free (passAddr[0]);
		memory.Release ();

		/* write the name and password values */

		int cnt = user.length ();
		char[] buffer = new char[cnt + 1];
		user.getChars (0, cnt, buffer, 0);
		int size = buffer.length * 2;
		long /*int*/ ptr = C.malloc (size);
		XPCOM.memmove (ptr, buffer, size);
		XPCOM.memmove (aUsername, new long /*int*/[] {ptr}, C.PTR_SIZEOF);

		cnt = password.length ();
		buffer = new char[cnt + 1];
		password.getChars (0, cnt, buffer, 0);
		size = buffer.length * 2;
		ptr = C.malloc (size);
		XPCOM.memmove (ptr, buffer, size);
		XPCOM.memmove (aPassword, new long /*int*/[] {ptr}, C.PTR_SIZEOF);
	}

	return XPCOM.NS_OK;
}

int PromptPassword (long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aPassword, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	return XPCOM.NS_ERROR_NOT_IMPLEMENTED;
}

int Select (long /*int*/ aDialogTitle, long /*int*/ aText, int aCount, long /*int*/ aSelectList, long /*int*/ aOutSelection, long /*int*/ _retval) {
	return XPCOM.NS_ERROR_NOT_IMPLEMENTED;
}

}
