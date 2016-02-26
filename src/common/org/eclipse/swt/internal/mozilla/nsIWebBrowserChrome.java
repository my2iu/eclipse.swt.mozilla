/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mozilla Communicator client code, released March 31, 1998.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by Netscape are Copyright (C) 1998-1999
 * Netscape Communications Corporation.  All Rights Reserved.
 *
 * Contributor(s):
 *
 * IBM
 * -  Binding to permit interfacing between Mozilla and SWT
 * -  Copyright (C) 2003, 2013 IBM Corp.  All Rights Reserved.
 *
 * ***** END LICENSE BLOCK ***** */
package org.eclipse.swt.internal.mozilla;


public class nsIWebBrowserChrome extends nsISupports {

	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + 10;

	static final String NS_IWEBBROWSERCHROME_IID_STR = "ba434c60-9d52-11d3-afb0-00a024ffc08c";
	static final String NS_IWEBBROWSERCHROME_24_IID_STR = "e8c414c4-dc38-4ba3-ab4e-ec4cbbe22907";

	static {
		IIDStore.RegisterIID(nsIWebBrowserChrome.class, MozillaVersion.VERSION_BASE, new nsID(NS_IWEBBROWSERCHROME_IID_STR));
		IIDStore.RegisterIID(nsIWebBrowserChrome.class, MozillaVersion.VERSION_XR24, new nsID(NS_IWEBBROWSERCHROME_24_IID_STR));
	}

	public nsIWebBrowserChrome(long /*int*/ address) {
		super(address);
	}

	public static final int STATUS_SCRIPT = 1;
	public static final int STATUS_SCRIPT_DEFAULT = 2;
	public static final int STATUS_LINK = 3;

	public int GetWebBrowser(long /*int*/[] aWebBrowser) {
		return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 2, getAddress(), aWebBrowser);
	}

	public static final int CHROME_DEFAULT = 1;
	public static final int CHROME_WINDOW_BORDERS = 2;
	public static final int CHROME_WINDOW_CLOSE = 4;
	public static final int CHROME_WINDOW_RESIZE = 8;
	public static final int CHROME_MENUBAR = 16;
	public static final int CHROME_TOOLBAR = 32;
	public static final int CHROME_LOCATIONBAR = 64;
	public static final int CHROME_STATUSBAR = 128;
	public static final int CHROME_PERSONAL_TOOLBAR = 256;
	public static final int CHROME_SCROLLBARS = 512;
	public static final int CHROME_TITLEBAR = 1024;
	public static final int CHROME_EXTRA = 2048;
	public static final int CHROME_WITH_SIZE = 4096;
	public static final int CHROME_WITH_POSITION = 8192;
	public static final int CHROME_WINDOW_MIN = 16384;
	public static final int CHROME_WINDOW_POPUP = 32768;
	public static final int CHROME_WINDOW_RAISED = 33554432;
	public static final int CHROME_WINDOW_LOWERED = 67108864;
	public static final int CHROME_CENTER_SCREEN = 134217728;
	public static final int CHROME_DEPENDENT = 268435456;
	public static final int CHROME_MODAL = 536870912;
	public static final int CHROME_OPENAS_DIALOG = 1073741824;
	public static final int CHROME_OPENAS_CHROME = -2147483648;
	public static final int CHROME_ALL = 4094;

	public int SetChromeFlags(int aChromeFlags) {
		return XPCOM.VtblCall(this.getSetterIndex("chromeFlags"), getAddress(), aChromeFlags);
	}
}
