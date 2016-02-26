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


public class nsIFile extends nsISupports {

	/*
	 * Note: The following value is likely wrong for XULRunner 24 because nsIFile is referenced
	 * (which initializes this value) before it has been determined whether XULRunner 24
	 * is being used or not.  However this does not currently cause a problem because the
	 * only reference to it is nsILocalFile.LAST_METHOD_ID, which is currently not used.
	 */
	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + (IsXULRVersionOrLater(MozillaVersion.VERSION_XR24) ? 62 : 45);

	static final String NS_IFILE_IID_STR = "c8c0a080-0868-11d3-915f-d9d889d48e3c";
	static final String NS_IFILE_24_IID_STR = "272a5020-64f5-485c-a8c4-44b2882ae0a2";
	static final String NS_IFILE_31_IID_STR = "a99a6a06-f90d-4659-8fce-c2f87feb1167";
    static final String NS_IFILE_38_IID_STR = "dfb5a307-7ecf-41dd-aee2-f1d623459c44";

	static {
		IIDStore.RegisterIID(nsIFile.class, MozillaVersion.VERSION_BASE, new nsID(NS_IFILE_IID_STR));
		IIDStore.RegisterIID(nsIFile.class, MozillaVersion.VERSION_XR24, new nsID(NS_IFILE_24_IID_STR));
		IIDStore.RegisterIID(nsIFile.class, MozillaVersion.VERSION_XR31, new nsID(NS_IFILE_31_IID_STR));
		IIDStore.RegisterIID(nsIFile.class, MozillaVersion.VERSION_XR38, new nsID(NS_IFILE_38_IID_STR));
	}

	public nsIFile(long /*int*/ address) {
		super(address);
	}

	public static final int NORMAL_FILE_TYPE = 0;
	public static final int DIRECTORY_TYPE = 1;

	public int Create(int type, int permissions) {
		/*
		 * Finding the method index by name using getMethodIndex() fails if
		 * mozilla profile directory is missing. Hence, use method index
		 * directly to support nsIFile.Create operation in the absence of
		 * profile directory.
		 */
		return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 4, getAddress(), type, permissions);
	}

	public int GetLeafName(long /*int*/ aLeafName) {
		return XPCOM.VtblCall(this.getGetterIndex("leafName"), getAddress(), aLeafName);
	}

	public int GetPath(long /*int*/ aPath) {
		return XPCOM.VtblCall(this.getGetterIndex("path"), getAddress(), aPath);
	}
}
