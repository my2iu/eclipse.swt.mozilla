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


public class nsIComponentRegistrar extends nsISupports {

	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + 12;

	static final String NS_ICOMPONENTREGISTRAR_IID_STR = "2417cbfe-65ad-48a6-b4b6-eb84db174392";

	static {
		IIDStore.RegisterIID(nsIComponentRegistrar.class, MozillaVersion.VERSION_BASE, new nsID(NS_ICOMPONENTREGISTRAR_IID_STR));
	}

	public nsIComponentRegistrar(long /*int*/ address) {
		super(address);
	}

	public int AutoRegister(long /*int*/ aSpec) {
		return XPCOM.VtblCall(this.getMethodIndex("autoRegister"), getAddress(), aSpec);
	}

	public int RegisterFactory(nsID aClass, byte[] aClassName, byte[] aContractID, long /*int*/ aFactory) {
		return XPCOM.VtblCall(this.getMethodIndex("registerFactory"), getAddress(), aClass, aClassName, aContractID, aFactory);
	}
}
