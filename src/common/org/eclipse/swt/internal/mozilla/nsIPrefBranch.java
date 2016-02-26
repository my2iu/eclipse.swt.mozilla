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


public class nsIPrefBranch extends nsISupports {

	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + (IsXULRVersionOrLater(MozillaVersion.VERSION_XR24) ? 21 : 18);

	static final String NS_IPREFBRANCH_IID_STR = "56c35506-f14b-11d3-99d3-ddbfac2ccf65";
	static final String NS_IPREFBRANCH_10_IID_STR = "e162bfa0-01bd-4e9f-9843-8fb2efcd6d1f";
	static final String NS_IPREFBRANCH_24_IID_STR = "55d25e49-793f-4727-a69f-de8b15f4b985";

	static {
		IIDStore.RegisterIID(nsIPrefBranch.class, MozillaVersion.VERSION_BASE, new nsID(NS_IPREFBRANCH_IID_STR));
		IIDStore.RegisterIID(nsIPrefBranch.class, MozillaVersion.VERSION_XR10, new nsID(NS_IPREFBRANCH_10_IID_STR));
		IIDStore.RegisterIID(nsIPrefBranch.class, MozillaVersion.VERSION_XR24, new nsID(NS_IPREFBRANCH_24_IID_STR));
	}

	public nsIPrefBranch(long /*int*/ address) {
		super(address);
	}

	public static final int PREF_INVALID = 0;
	public static final int PREF_STRING = 32;
	public static final int PREF_INT = 64;
	public static final int PREF_BOOL = 128;

	public int SetBoolPref(byte[] aPrefName, int aValue) {
		return XPCOM.VtblCall(this.getMethodIndex("setBoolPref"), getAddress(), aPrefName, aValue);
	}

	public int GetIntPref(byte[] aPrefName, int[] _retval) {
		return XPCOM.VtblCall(this.getMethodIndex("getIntPref"), getAddress(), aPrefName, _retval);
	}

	public int SetIntPref(byte[] aPrefName, int aValue) {
		return XPCOM.VtblCall(this.getMethodIndex("setIntPref"), getAddress(), aPrefName, aValue);
	}

	public int GetComplexValue(byte[] aPrefName, nsID aType, long /*int*/[] aValue) {
		return XPCOM.VtblCall(this.getMethodIndex("getComplexValue"), getAddress(), aPrefName, aType, aValue);
	}

	public int SetComplexValue(byte[] aPrefName, nsID aType, long /*int*/ aValue) {
		return XPCOM.VtblCall(this.getMethodIndex("setComplexValue"), getAddress(), aPrefName, aType, aValue);
	}

	public int ClearUserPref(byte[] aPrefName) {
		return XPCOM.VtblCall(this.getMethodIndex("clearUserPref"), getAddress(), aPrefName);
	}
}
