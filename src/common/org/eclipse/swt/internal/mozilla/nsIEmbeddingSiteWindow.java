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


public class nsIEmbeddingSiteWindow extends nsISupports {

	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + (IsXULRVersionOrLater(MozillaVersion.VERSION_XR24) ? 9 : 8);

	static final String NS_IEMBEDDINGSITEWINDOW_IID_STR = "3e5432cd-9568-4bd1-8cbe-d50aba110743";
	static final String NS_IEMBEDDINGSITEWINDOW_24_IID_STR = "0b976267-4aaa-4f36-a2d4-27b5ca8d73bb";

	static {
		IIDStore.RegisterIID(nsIEmbeddingSiteWindow.class, MozillaVersion.VERSION_BASE, new nsID(NS_IEMBEDDINGSITEWINDOW_IID_STR));
		IIDStore.RegisterIID(nsIEmbeddingSiteWindow.class, MozillaVersion.VERSION_XR24, new nsID(NS_IEMBEDDINGSITEWINDOW_24_IID_STR));
	}

	public nsIEmbeddingSiteWindow(long /*int*/ address) {
		super(address);
	}

	public static final int DIM_FLAGS_POSITION = 1;
	public static final int DIM_FLAGS_SIZE_INNER = 2;
	public static final int DIM_FLAGS_SIZE_OUTER = 4;

	public int GetSiteWindow(long /*int*/[] aSiteWindow) {
		return XPCOM.VtblCall(this.getGetterIndex("siteWindow"), getAddress(), aSiteWindow);
	}
}
