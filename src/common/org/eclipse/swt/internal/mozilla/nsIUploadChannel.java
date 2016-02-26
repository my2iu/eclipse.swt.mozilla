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
 * -  Copyright (C) 2011, 2012 IBM Corp.  All Rights Reserved.
 *
 * ***** END LICENSE BLOCK ***** */
package org.eclipse.swt.internal.mozilla;


public class nsIUploadChannel extends nsISupports {

	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + 2;

	static final String NS_IUPLOADCHANNEL_IID_STR = "ddf633d8-e9a4-439d-ad88-de636fd9bb75";
	static final String NS_IUPLOADCHANNEL_24_IID_STR = "5cfe15bd-5adb-4a7f-9e55-4f5a67d15794";

	static {
		IIDStore.RegisterIID(nsIUploadChannel.class, MozillaVersion.VERSION_BASE, new nsID(NS_IUPLOADCHANNEL_IID_STR));
		IIDStore.RegisterIID(nsIUploadChannel.class, MozillaVersion.VERSION_XR24, new nsID(NS_IUPLOADCHANNEL_24_IID_STR));
	}

	public nsIUploadChannel(long /*int*/ address) {
		super(address);
	}

	public int GetUploadStream(long /*int*/[] aUploadStream) {
		return XPCOM.VtblCall(this.getGetterIndex("uploadStream"), getAddress(), aUploadStream);
	}
}
