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
 * -  Copyright (C) 2003, 2012 IBM Corp.  All Rights Reserved.
 *
 * ***** END LICENSE BLOCK ***** */
package org.eclipse.swt.internal.mozilla;


public class nsICertificateDialogs extends nsISupports {

	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + (IsXULRVersionOrLater(MozillaVersion.VERSION_XR24) ? 5 : 6);

	static final String NS_ICERTIFICATEDIALOGS_IID_STR = "a03ca940-09be-11d5-ac5d-000064657374";
	static final String NS_ICERTIFICATEDIALOGS_24_IID_STR = "da871dab-f69e-4173-ab26-99fcd47b0e85";

	static {
		IIDStore.RegisterIID(nsICertificateDialogs.class, MozillaVersion.VERSION_BASE, new nsID(NS_ICERTIFICATEDIALOGS_IID_STR));
		IIDStore.RegisterIID(nsICertificateDialogs.class, MozillaVersion.VERSION_XR24, new nsID(NS_ICERTIFICATEDIALOGS_24_IID_STR));
	}

	public nsICertificateDialogs(long /*int*/ address) {
		super(address);
	}

	public int ViewCert(long /*int*/ ctx, long /*int*/ cert) {
		return XPCOM.VtblCall(this.getMethodIndex("viewCert"), getAddress(), ctx, cert);
	}
}
