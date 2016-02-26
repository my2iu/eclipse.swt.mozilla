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
 * -  Copyright (C) 2003, 2014 IBM Corp.  All Rights Reserved.
 *    Neil Rashbrook <neil@parkwaycc.co.uk> - Bug 429739
 *
 * ***** END LICENSE BLOCK ***** */
package org.eclipse.swt.internal.mozilla;

import org.eclipse.swt.internal.*;

/** @jniclass flags=cpp */
public class XPCOM extends C {
	public static final String CONTENT_MAYBETEXT = "application/x-vnd.mozilla.maybe-text"; //$NON-NLS-1$
	public static final String CONTENT_MULTIPART = "multipart/x-mixed-replace"; //$NON-NLS-1$
	public static final String DOMEVENT_FOCUS = "focus"; //$NON-NLS-1$
	public static final String DOMEVENT_UNLOAD = "unload"; //$NON-NLS-1$
	public static final String DOMEVENT_MOUSEDOWN = "mousedown"; //$NON-NLS-1$
	public static final String DOMEVENT_MOUSEUP = "mouseup"; //$NON-NLS-1$
	public static final String DOMEVENT_MOUSEMOVE = "mousemove"; //$NON-NLS-1$
	public static final String DOMEVENT_MOUSEDRAG = "draggesture"; //$NON-NLS-1$
	public static final String DOMEVENT_MOUSEWHEEL = "DOMMouseScroll"; //$NON-NLS-1$
	public static final String DOMEVENT_MOUSEOVER = "mouseover"; //$NON-NLS-1$
	public static final String DOMEVENT_MOUSEOUT = "mouseout"; //$NON-NLS-1$
	public static final String DOMEVENT_KEYDOWN = "keydown"; //$NON-NLS-1$
	public static final String DOMEVENT_KEYPRESS = "keypress"; //$NON-NLS-1$
	public static final String DOMEVENT_KEYUP = "keyup"; //$NON-NLS-1$

	/* CID constants */
	public static final nsID EXTERNAL_CID = new nsID ("f2c59ad0-bd76-11dd-ad8b-0800200c9a66"); //$NON-NLS-1$
	public static final nsID NS_APPSHELL_CID =	new nsID("2d96b3df-c051-11d1-a827-0040959a28c9"); //$NON-NLS-1$
	public static final nsID NS_AUTHPROMPTER_CID = new nsID("e2112d6a-0e28-421f-b46a-25c0b308cbd0"); //$NON-NLS-1$
	public static final nsID NS_CATEGORYMANAGER_CID = new nsID("16d222a6-1dd2-11b2-b693-f38b02c021b2"); //$NON-NLS-1$
	public static final nsID NS_DOWNLOAD_CID = new nsID("e3fa9D0a-1dd1-11b2-bdef-8c720b597445"); //$NON-NLS-1$
	public static final nsID NS_FILEPICKER_CID = new nsID("54ae32f8-1dd2-11b2-a209-df7c505370f8"); //$NON-NLS-1$
	public static final nsID NS_HELPERAPPLAUNCHERDIALOG_CID = new nsID("e68578eb-6ec2-4169-ae19-8c6243f0abe1"); //$NON-NLS-1$
	public static final nsID NS_INPUTSTREAMCHANNEL_CID = new nsID("6ddb050c-0d04-11d4-986e-00c04fa0cf4a"); //$NON-NLS-1$
	public static final nsID NS_IOSERVICE_CID =	new nsID("9ac9e770-18bc-11d3-9337-00104ba0fd40"); //$NON-NLS-1$
	public static final nsID NS_LOADGROUP_CID = new nsID("e1c61582-2a84-11d3-8cce-0060b0fc14a3"); //$NON-NLS-1$
	public static final nsID NS_PROMPTER_CID = new nsID("f2112d6a-0e28-421f-b46a-25c0b308cbd0"); //$NON-NLS-1$
	public static final nsID NS_PROMPTSERVICE_CID = new nsID("a2112d6a-0e28-421f-b46a-25c0b308cbd0"); //$NON-NLS-1$
	public static final nsID NS_IWEBBROWSER_CID = new nsID ("F1EAC761-87E9-11d3-AF80-00A024FFC08C"); //$NON-NLS-1$
	public static final nsID NS_IWEBBROWSER_31_CID = new nsID ("cda5863a-aa9c-411e-be49-ea0d525ab4b5"); //$NON-NLS-1$
	public static final nsID NS_IXPCONNECT_CID = new nsID ("CB6593E0-F9B2-11d2-BDD6-000064657374"); //$NON-NLS-1$

	/* IID constants */
	public static final nsID NS_IAUTHPROMPT2_IID = new nsID ("651395eb-8612-4876-8ac0-a88d4dce9e1e"); //$NON-NLS-1$
	public static final nsID NS_IBADCERTLISTENER2_IID = new nsID ("2c3d268c-ad82-49f3-99aa-e9ffddd7a0dc"); //$NON-NLS-1$
	public static final nsID NS_ICONTEXTMENULISTENER_IID = new nsID ("3478b6b0-3875-11d4-94ef-0020183bf181"); //$NON-NLS-1$
	public static final nsID NS_IDIRECTORYSERVICE_IID = new nsID ("57a66a60-d43a-11d3-8cc2-00609792278c"); //$NON-NLS-1$
	public static final nsID NS_IDIRECTORYSERVICEPROVIDER_IID = new nsID ("bbf8cab0-d43a-11d3-8cc2-00609792278c"); //$NON-NLS-1$
	public static final nsID NS_IDIRECTORYSERVICEPROVIDER2_IID = new nsID ("2f977d4b-5485-11d4-87e2-0010a4e75ef2"); //$NON-NLS-1$
	public static final nsID NS_IDOWNLOAD_IID = new nsID ("06cb92f2-1dd2-11b2-95f2-96dfdfb804a1"); //$NON-NLS-1$
	public static final nsID NS_IDOWNLOAD_1_8_IID = new nsID ("9e1fd9f2-9727-4926-85cd-f16c375bba6d"); //$NON-NLS-1$
	public static final nsID NS_IFACTORY_IID = new nsID ("00000001-0000-0000-c000-000000000046"); //$NON-NLS-1$
	public static final nsID NS_IHELPERAPPLAUNCHERDIALOG_IID = new nsID ("d7ebddf0-4c84-11d4-807a-00600811a9c3"); //$NON-NLS-1$
	public static final nsID NS_IHELPERAPPLAUNCHERDIALOG_1_9_IID = new nsID ("f3704fdc-8ae6-4eba-a3c3-f02958ac0649"); //$NON-NLS-1$
	public static final nsID NS_IHTTPHEADERVISITOR_IID = new nsID("0cf40717-d7c1-4a94-8c1e-d6c9734101bb"); //$NON-NLS-1$
	public static final nsID NS_IHTTPHEADERVISITOR_10_IID = new nsID("35412859-b9d9-423c-8866-2d4559fdd2be"); //$NON-NLS-1$
	public static final nsID NS_IPROGRESSDIALOG_IID = new nsID("88a478b3-af65-440a-94dc-ed9b154d2990"); //$NON-NLS-1$
	public static final nsID NS_IPROGRESSDIALOG_1_8_IID = new nsID("20e790a2-76c6-462d-851a-22ab6cbbe48b"); //$NON-NLS-1$
	public static final nsID NS_IPROMPT_IID = new nsID("a63f70c0-148b-11d3-9333-00104ba0fd40"); //$NON-NLS-1$
	public static final nsID NS_IPROMPTFACTORY_IID = new nsID ("2532b748-75db-4732-9173-78d3bf34f694"); //$NON-NLS-1$
	public static final nsID NS_IPROMPTSERVICE_IID = new nsID ("1630c61a-325e-49ca-8759-a31b16c47aa5"); //$NON-NLS-1$
	public static final nsID NS_IPROMPTSERVICE2_IID = new nsID ("cf86d196-dbee-4482-9dfa-3477aa128319"); //$NON-NLS-1$
	public static final nsID NS_ISCRIPTOBJECTOWNER_IID = new nsID ("8f6bca7e-ce42-11d1-b724-00600891d8c9"); //$NON-NLS-1$
	public static final nsID NS_ISECURITYCHECKEDCOMPONENT_IID = new nsID ("0dad9e8c-a12d-4dcb-9a6f-7d09839356e1"); //$NON-NLS-1$
	public static final nsID NS_ISUPPORTS_IID = new nsID ("00000000-0000-0000-c000-000000000046"); //$NON-NLS-1$
	public static final nsID NS_ISUPPORTSWEAKREFERENCE_IID = new nsID ("9188bc86-f92e-11d2-81ef-0060083a0bcf"); //$NON-NLS-1$
	public static final nsID NS_ITOOLTIPLISTENER_IID = new nsID ("44b78386-1dd2-11b2-9ad2-e4eee2ca1916"); //$NON-NLS-1$
	public static final nsID NS_IURICONTENTLISTENER_IID = new nsID ("94928ab3-8b63-11d3-989d-001083010e9b"); //$NON-NLS-1$
	public static final nsID NS_IWEAKREFERENCE_IID = new nsID ("9188bc85-f92e-11d2-81ef-0060083a0bcf"); //$NON-NLS-1$
	public static final nsID NS_IWEBBROWSERCHROMEFOCUS_IID = new nsID ("d2206418-1dd1-11b2-8e55-acddcd2bcfb8"); //$NON-NLS-1$
	public static final nsID NS_IWINDOWCREATOR_IID = new nsID ("30465632-a777-44cc-90f9-8145475ef999"); //$NON-NLS-1$
	public static final nsID NS_IWINDOWCREATOR2_IID = new nsID ("f673ec81-a4b0-11d6-964b-eb5a2bf216fc"); //$NON-NLS-1$
	public static final nsID NS_IXPCSCRIPTABLE_IID = new nsID ("155d1863-2b0b-4f5e-b800-05184944156b"); //$NON-NLS-1$

	/* contract ID constants */
	public static final String EXECUTE_CONTRACTID = "@eclipse.org/execute;1"; //$NON-NLS-1$
	public static final String EXTERNAL_CONTRACTID = "@eclipse.org/external;1"; //$NON-NLS-1$
	public static final String NS_AUTHPROMPTER_CONTRACTID = "@mozilla.org/passwordmanager/authpromptfactory;1"; //$NON-NLS-1$
	public static final String NS_CERTOVERRIDE_CONTRACTID = "@mozilla.org/security/certoverride;1"; //$NON-NLS-1$
	public static final String NS_CERTIFICATEDIALOGS_CONTRACTID = "@mozilla.org/nsCertificateDialogs;1"; //$NON-NLS-1$
	public static final String NS_CONTEXTSTACK_CONTRACTID = "@mozilla.org/js/xpc/ContextStack;1"; //$NON-NLS-1$
	public static final String NS_COOKIEMANAGER_CONTRACTID = "@mozilla.org/cookiemanager;1"; //$NON-NLS-1$
	public static final String NS_COOKIESERVICE_CONTRACTID = "@mozilla.org/cookieService;1"; //$NON-NLS-1$
	public static final String NS_DIRECTORYSERVICE_CONTRACTID = "@mozilla.org/file/directory_service;1"; //$NON-NLS-1$
	public static final String NS_DOMSERIALIZER_CONTRACTID = "@mozilla.org/xmlextras/xmlserializer;1"; //$NON-NLS-1$
	public static final String NS_DOWNLOAD_CONTRACTID = "@mozilla.org/download;1"; //$NON-NLS-1$
	public static final String NS_FILEPICKER_CONTRACTID = "@mozilla.org/filepicker;1"; //$NON-NLS-1$
	public static final String NS_FOCUSMANAGER_CONTRACTID = "@mozilla.org/focus-manager;1"; //$NON-NLS-1$
	public static final String NS_HELPERAPPLAUNCHERDIALOG_CONTRACTID = "@mozilla.org/helperapplauncherdialog;1"; //$NON-NLS-1$
	public static final String NS_INTERFACEINFOMANAGER_CONTRACTID = "@mozilla.org/xpti/interfaceinfomanager-service;1";
	public static final String NS_MEMORY_CONTRACTID = "@mozilla.org/xpcom/memory-service;1"; //$NON-NLS-1$
	public static final String NS_MIMEINPUTSTREAM_CONTRACTID = "@mozilla.org/network/mime-input-stream;1"; //$NON-NLS-1$
	public static final String NS_SCRIPTSECURITYMANAGER_CONTRACTID = "@mozilla.org/scriptsecuritymanager;1"; //$NON-NLS-1$
	public static final String NS_OBSERVER_CONTRACTID = "@mozilla.org/observer-service;1"; //$NON-NLS-1$
	public static final String NS_PREFLOCALIZEDSTRING_CONTRACTID = "@mozilla.org/pref-localizedstring;1"; //$NON-NLS-1$
	public static final String NS_PREFSERVICE_CONTRACTID = "@mozilla.org/preferences-service;1"; //$NON-NLS-1$
	public static final String NS_PROMPTER_CONTRACTID = "@mozilla.org/prompter;1"; //$NON-NLS-1$
	public static final String NS_PROMPTSERVICE_CONTRACTID = "@mozilla.org/embedcomp/prompt-service;1"; //$NON-NLS-1$
	public static final String NS_TRANSFER_CONTRACTID = "@mozilla.org/transfer;1"; //$NON-NLS-1$
	public static final String NS_VARIANT_CONTRACTID = "@mozilla.org/variant;1"; //$NON-NLS-1$
	public static final String NS_WEBNAVIGATIONINFO_CONTRACTID = "@mozilla.org/webnavigation-info;1"; //$NON-NLS-1$
	public static final String NS_WINDOWWATCHER_CONTRACTID = "@mozilla.org/embedcomp/window-watcher;1"; //$NON-NLS-1$

	/* directory service constants */
	public static final String NS_APP_APPLICATION_REGISTRY_DIR = "AppRegD"; //$NON-NLS-1$
	public static final String NS_APP_CACHE_PARENT_DIR = "cachePDir"; //$NON-NLS-1$
	public static final String NS_APP_HISTORY_50_FILE = "UHist"; //$NON-NLS-1$
	public static final String NS_APP_LOCALSTORE_50_FILE = "LclSt"; //$NON-NLS-1$
	public static final String NS_APP_PLUGINS_DIR_LIST = "APluginsDL"; //$NON-NLS-1$
	public static final String NS_APP_PREF_DEFAULTS_50_DIR = "PrfDef"; //$NON-NLS-1$
	public static final String NS_APP_PREFS_50_DIR = "PrefD"; //$NON-NLS-1$
	public static final String NS_APP_PREFS_50_FILE = "PrefF"; //$NON-NLS-1$
	public static final String NS_APP_USER_CHROME_DIR = "UChrm"; //$NON-NLS-1$
	public static final String NS_APP_USER_MIMETYPES_50_FILE = "UMimTyp"; //$NON-NLS-1$
	public static final String NS_APP_USER_PROFILE_50_DIR = "ProfD"; //$NON-NLS-1$
	public static final String NS_GRE_COMPONENT_DIR = "GreComsD"; //$NON-NLS-1$
	public static final String NS_GRE_DIR = "GreD"; //$NON-NLS-1$
	public static final String NS_OS_CURRENT_PROCESS_DIR = "CurProcD"; //$NON-NLS-1$
	public static final String NS_OS_HOME_DIR = "Home"; //$NON-NLS-1$
	public static final String NS_OS_TEMP_DIR = "TmpD"; //$NON-NLS-1$
	public static final String NS_XPCOM_COMPONENT_DIR = "ComsD"; //$NON-NLS-1$
	public static final String NS_XPCOM_CURRENT_PROCESS_DIR = "XCurProcD"; //$NON-NLS-1$
	public static final String NS_XPCOM_INIT_CURRENT_PROCESS_DIR = "MozBinD"; //$NON-NLS-1$

	/* XPCOM constants */
	public static final int NS_OK =  0;
	public static final int NS_COMFALSE = 1;
	public static final int NS_BINDING_ABORTED = 0x804B0002;
	public static final int NS_ERROR_BASE = 0xc1f30000;
	public static final int NS_ERROR_NOT_INITIALIZED =  NS_ERROR_BASE + 1;
	public static final int NS_ERROR_ALREADY_INITIALIZED = NS_ERROR_BASE + 2;
	public static final int NS_ERROR_NOT_IMPLEMENTED =  0x80004001;
	public static final int NS_NOINTERFACE =  0x80004002;
	public static final int NS_ERROR_NO_INTERFACE =  NS_NOINTERFACE;
	public static final int NS_ERROR_INVALID_POINTER =  0x80004003;
	public static final int NS_ERROR_NULL_POINTER = NS_ERROR_INVALID_POINTER;
	public static final int NS_ERROR_ABORT = 0x80004004;
	public static final int NS_ERROR_FAILURE = 0x80004005;
	public static final int NS_ERROR_UNEXPECTED = 0x8000ffff;
	public static final int NS_ERROR_OUT_OF_MEMORY = 0x8007000e;
	public static final int NS_ERROR_ILLEGAL_VALUE = 0x80070057;
	public static final int NS_ERROR_INVALID_ARG = NS_ERROR_ILLEGAL_VALUE;
	public static final int NS_ERROR_NO_AGGREGATION = 0x80040110;
	public static final int NS_ERROR_NOT_AVAILABLE = 0x80040111;
	public static final int NS_ERROR_FACTORY_NOT_REGISTERED = 0x80040154;
	public static final int NS_ERROR_FACTORY_REGISTER_AGAIN = 0x80040155;
	public static final int NS_ERROR_FACTORY_NOT_LOADED = 0x800401f8;
	public static final int NS_ERROR_FACTORY_NO_SIGNATURE_SUPPORT = NS_ERROR_BASE + 0x101;
	public static final int NS_ERROR_FACTORY_EXISTS = NS_ERROR_BASE + 0x100;
	public static final int NS_ERROR_HTMLPARSER_UNRESOLVEDDTD = 0x804e03f3;
	public static final int NS_ERROR_FILE_NOT_FOUND = 0x80520012;
	public static final int NS_ERROR_FILE_UNRECOGNIZED_PATH = 0x80520001;
	public static final int SEC_ERROR_EXPIRED_ISSUER_CERTIFICATE = 0x805A1FE2;
	public static final int SEC_ERROR_CA_CERT_INVALID = 0x805A1FDC;
	public static final int SEC_ERROR_EXPIRED_CERTIFICATE = 0x805A1FF5;
	public static final int SEC_ERROR_INADEQUATE_KEY_USAGE = 0x805A1FA6;
	public static final int SEC_ERROR_UNKNOWN_ISSUER = 0x805A1FF3;
	public static final int SEC_ERROR_UNTRUSTED_CERT = 0x805A1FEB;
	public static final int SEC_ERROR_UNTRUSTED_ISSUER = 0x805A1FEC;
	public static final int SSL_ERROR_BAD_CERT_DOMAIN = 0x805A2FF4;
	public static final int USE_JSSTUB_FOR_ADDPROPERTY = 1 << 17;
	public static final int WANT_POSTCREATE = 4;

	/* JSAPI constants */
	public static final int JSPROP_ENUMERATE = 0x1;
	public static final int JSPROP_PERMANENT = 0x4;
	public static final int JSPROP_READONLY = 0x2;
	public static final int JS_FALSE = 0x0;
	public static final int JS_TRUE = 0x1;

public static final native int nsDynamicFunctionLoad_sizeof ();

public static void memmove(long /*int*/ dest, boolean[] src) {
	if (MozillaVersion.CheckVersion (MozillaVersion.VERSION_XR10)) {
		memmove (dest, new byte[] {src[0] ? (byte)1 : 0}, 1);
	} else {
		memmove (dest, new int[] {src[0] ? 1 : 0}, 4);
	}
}

public static void memmove(boolean[] dest, long /*int*/ src) {
	if (MozillaVersion.CheckVersion (MozillaVersion.VERSION_XR10)) {
		byte[] result = new byte[1];
		memmove (result, src, 1);
		dest[0] = result[0] != 0;
	} else {
		int[] result = new int[1];
		memmove (result, src, 4);
		dest[0] = result[0] != 0;
	}
}

/**
 * @param dest cast=(void *)
 * @param src cast=(const void *),flags=no_out critical
 * @param size cast=(size_t)
 */
public static final native void memmove(long /*int*/ dest, nsDynamicFunctionLoad src, long /*int*/ size);
/**
 * @param dest cast=(void *)
 * @param src cast=(const void *)
 * @param nbytes cast=(size_t)
 */
public static final native void memmove(nsID dest, long /*int*/ src, int nbytes);
/**
 * @param dest cast=(void *)
 * @param src cast=(const void *)
 * @param nbytes cast=(size_t)
 */
public static final native void memmove(long /*int*/ dest, nsID src, int nbytes);
/** @method flags=no_gen */
public static final native int strlen_PRUnichar(long /*int*/ s);

/** @method flags=no_gen */
public static final native long /*int*/ CALLBACK_GetScriptableFlags24(long /*int*/ func);
/** @method flags=no_gen */
public static final native long /*int*/ CALLBACK_JSNative(long /*int*/ func);

/** @method flags=no_gen */
public static final native long /*int*/ _JS_DefineFunction(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, byte[] name, long /*int*/ call, int nargs, int flags);
public static final long /*int*/ JS_DefineFunction(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, byte[] name, long /*int*/ call, int nargs, int flags) {
	lock.lock();
	try {
		return _JS_DefineFunction(mozillaPath, cx, obj, name, call, nargs, flags);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native long /*int*/ _JS_DefineFunction24(long /*int*/ cx, long /*int*/ obj, byte[] name, long /*int*/ call, int nargs, int flags);
public static final long /*int*/ JS_DefineFunction24(long /*int*/ cx, long /*int*/ obj, byte[] name, long /*int*/ call, int nargs, int flags) {
	lock.lock();
	try {
		return _JS_DefineFunction24(cx, obj, name, call, nargs, flags);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native int _JS_EvaluateUCScriptForPrincipals(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, long /*int*/ principals, char[] chars, int length, byte[] filename, int lineno, long /*int*/[] retVal);
public static final int JS_EvaluateUCScriptForPrincipals(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, long /*int*/ principals, char[] chars, int length, byte[] filename, int lineno, long /*int*/[] retVal) {
	lock.lock();
	try {
		return _JS_EvaluateUCScriptForPrincipals(mozillaPath, cx, obj, principals, chars, length, filename, lineno, retVal);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native int _JS_EvaluateUCScriptForPrincipals191(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, long /*int*/ principals, char[] chars, int length, byte[] filename, int lineno, long /*int*/ retVal);
public static final int JS_EvaluateUCScriptForPrincipals191(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, long /*int*/ principals, char[] chars, int length, byte[] filename, int lineno, long /*int*/ retVal) {
	lock.lock();
	try {
		return _JS_EvaluateUCScriptForPrincipals191(mozillaPath, cx, obj, principals, chars, length, filename, lineno, retVal);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native int _JS_EvaluateUCScriptForPrincipals24(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, long /*int*/ principals, char[] chars, int length, byte[] filename, int lineno, long /*int*/ retVal);
public static final int JS_EvaluateUCScriptForPrincipals24(byte[] mozillaPath, long /*int*/ cx, long /*int*/ obj, long /*int*/ principals, char[] chars, int length, byte[] filename, int lineno, long /*int*/ retVal) {
	lock.lock();
	try {
		return _JS_EvaluateUCScriptForPrincipals24(mozillaPath, cx, obj, principals, chars, length, filename, lineno, retVal);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native long /*int*/ _JS_GetGlobalForScopeChain24(long /*int*/ cx);
public static final long /*int*/ JS_GetGlobalForScopeChain24(long /*int*/ cx) {
	lock.lock();
	try {
		return _JS_GetGlobalForScopeChain24(cx);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native long /*int*/ _JS_GetGlobalObject(byte[] mozillaPath, long /*int*/ cx);
public static final long /*int*/ JS_GetGlobalObject(byte[] mozillaPath, long /*int*/ cx) {
	lock.lock();
	try {
		return _JS_GetGlobalObject(mozillaPath, cx);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native long /*int*/ _JS_NewObject(byte[] mozillaPath, long /*int*/ cx, long /*int*/ clasp, long /*int*/ proto, long /*int*/ parent);
public static final long /*int*/ JS_NewObject(byte[] mozillaPath, long /*int*/ cx, long /*int*/ clasp, long /*int*/ proto, long /*int*/ parent) {
	lock.lock();
	try {
		return _JS_NewObject(mozillaPath, cx, clasp, proto, parent);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native boolean _NS_Free(byte[] mozillaPath, long /*int*/ aPtr);
public static final boolean NS_Free(byte[] mozillaPath, long /*int*/ aPtr) {
	lock.lock();
	try {
		return _NS_Free(mozillaPath, aPtr);
	} finally {
		lock.unlock();
	}
}
/** @param result cast=(nsIComponentManager**) */
public static final native int _NS_GetComponentManager(long /*int*/[] result);
public static final int NS_GetComponentManager(long /*int*/[] result) {
	lock.lock();
	try {
		return _NS_GetComponentManager(result);
	} finally {
		lock.unlock();
	}
}
/** @param result cast=(nsIServiceManager**) */
public static final native int _NS_GetServiceManager(long /*int*/[] result);
public static final int NS_GetServiceManager(long /*int*/[] result) {
	lock.lock();
	try {
		return _NS_GetServiceManager(result);
	} finally {
		lock.unlock();
	}
}
/**
 * @param result cast=(nsIServiceManager **)
 * @param binDirectory cast=(nsIFile *)
 * @param appFileLocationProvider cast=(nsIDirectoryServiceProvider *)
 */
public static final native int _NS_InitXPCOM2(long /*int*/ result, long /*int*/ binDirectory, long /*int*/ appFileLocationProvider);
public static final int NS_InitXPCOM2(long /*int*/ result, long /*int*/ binDirectory, long /*int*/ appFileLocationProvider) {
	lock.lock();
	try {
		return _NS_InitXPCOM2(result, binDirectory, appFileLocationProvider);
	} finally {
		lock.unlock();
	}
}
/**
 * @param path cast=(nsAString *),flags=struct
 * @param result cast=(nsIFile**)
 */
public static final native int _NS_NewLocalFile(long /*int*/ path, int followLinks, long /*int*/[] result);
public static final int NS_NewLocalFile(long /*int*/ path, int followLinks, long /*int*/[] result) {
	lock.lock();
	try {
		return _NS_NewLocalFile(path, followLinks, result);
	} finally {
		lock.unlock();
	}
}
/** @method flags=new */
public static final native long /*int*/ _nsEmbedCString_new();
public static final long /*int*/ nsEmbedCString_new() {
	lock.lock();
	try {
		return _nsEmbedCString_new();
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=new
 * @param aString cast=(const char *)
 */
public static final native long /*int*/ _nsEmbedCString_new(byte[] aString, int length);
public static final long /*int*/ nsEmbedCString_new(byte[] aString, int length) {
	lock.lock();
	try {
		return _nsEmbedCString_new(aString, length);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=new
 * @param aString cast=(const char *)
 */
public static final native long /*int*/ _nsEmbedCString_new(long /*int*/ aString, int length);
public static final long /*int*/ nsEmbedCString_new(long /*int*/ aString, int length) {
	lock.lock();
	try {
		return _nsEmbedCString_new(aString, length);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=delete
 * @param ptr cast=(nsEmbedCString *)
 */
public static final native void _nsEmbedCString_delete(long /*int*/ ptr);
public static final void nsEmbedCString_delete(long /*int*/ ptr) {
	lock.lock();
	try {
		_nsEmbedCString_delete(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsEmbedCString *)
 */
public static final native int _nsEmbedCString_Length(long /*int*/ ptr);
public static final int nsEmbedCString_Length(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsEmbedCString_Length(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsIScriptGlobalObject *)
 */
public static final native int _nsIScriptGlobalObject_EnsureScriptEnvironment(long /*int*/ ptr, int lang);
public static final int nsIScriptGlobalObject_EnsureScriptEnvironment(long /*int*/ ptr, int lang) {
	lock.lock();
	try {
		return _nsIScriptGlobalObject_EnsureScriptEnvironment(ptr, lang);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native int _nsIScriptGlobalObject24_EnsureScriptEnvironment(long /*int*/ ptr);
public static final int nsIScriptGlobalObject24_EnsureScriptEnvironment(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsIScriptGlobalObject24_EnsureScriptEnvironment(ptr);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native long /*int*/ _nsIScriptGlobalObject24_GetGlobalJSObject(long /*int*/ ptr);
public static final long /*int*/ nsIScriptGlobalObject24_GetGlobalJSObject(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsIScriptGlobalObject24_GetGlobalJSObject(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsIScriptGlobalObject *)
 */
public static final native long /*int*/ _nsIScriptGlobalObject_GetScriptContext(long /*int*/ ptr, int lang);
public static final long /*int*/ nsIScriptGlobalObject_GetScriptContext(long /*int*/ ptr, int lang) {
	lock.lock();
	try {
		return _nsIScriptGlobalObject_GetScriptContext(ptr, lang);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native long /*int*/ _nsIScriptGlobalObject24_GetScriptContext(long /*int*/ ptr);
public static final long /*int*/ nsIScriptGlobalObject24_GetScriptContext(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsIScriptGlobalObject24_GetScriptContext(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsIScriptContext *)
 */
public static final native long /*int*/ _nsIScriptContext_GetNativeContext(long /*int*/ ptr);
public static final long /*int*/ nsIScriptContext_GetNativeContext(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsIScriptContext_GetNativeContext(ptr);
	} finally {
		lock.unlock();
	}
}
/** @method flags=no_gen */
public static final native long /*int*/ _nsIScriptContext24_GetNativeContext(long /*int*/ ptr);
public static final long /*int*/ nsIScriptContext24_GetNativeContext(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsIScriptContext24_GetNativeContext(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsEmbedCString *)
 */
public static final native long /*int*/ _nsEmbedCString_get(long /*int*/ ptr);
public static final long /*int*/ nsEmbedCString_get(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsEmbedCString_get(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=delete
 * @param ptr cast=(nsID *)
 */
public static final native void _nsID_delete(long /*int*/ ptr);
public static final void nsID_delete(long /*int*/ ptr) {
	lock.lock();
	try {
		_nsID_delete(ptr);
	} finally {
		lock.unlock();
	}
}
/** @method flags=new */
public static final native long /*int*/ _nsID_new();
public static final long /*int*/ nsID_new() {
	lock.lock();
	try {
		return _nsID_new();
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsID *)
 * @param other cast=(nsID *),flags=struct
 */
public static final native int _nsID_Equals(long /*int*/ ptr, long /*int*/ other);
public static final int nsID_Equals(long /*int*/ ptr, long /*int*/ other) {
	lock.lock();
	try {
		return _nsID_Equals(ptr, other);
	} finally {
		lock.unlock();
	}
}
/** @method flags=new */
public static final native long /*int*/ _nsEmbedString_new();
public static final long /*int*/ nsEmbedString_new() {
	lock.lock();
	try {
		return _nsEmbedString_new();
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=new
 * @param aString cast=(PRUnichar *)
 */
public static final native long /*int*/ _nsEmbedString_new(char[] aString);
public static final long /*int*/ nsEmbedString_new(char[] aString) {
	lock.lock();
	try {
		return _nsEmbedString_new(aString);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=delete
 * @param ptr cast=(nsEmbedString *)
 */
public static final native void _nsEmbedString_delete(long /*int*/ ptr);
public static final void nsEmbedString_delete(long /*int*/ ptr) {
	lock.lock();
	try {
		_nsEmbedString_delete(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsEmbedString *)
 */
public static final native int _nsEmbedString_Length(long /*int*/ ptr);
public static final int nsEmbedString_Length(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsEmbedString_Length(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsEmbedString *)
 */
public static final native long /*int*/ _nsEmbedString_get(long /*int*/ ptr);
public static final long /*int*/ nsEmbedString_get(long /*int*/ ptr) {
	lock.lock();
	try {
		return _nsEmbedString_get(ptr);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr cast=(nsIMemory *)
 * @param size cast=(size_t)
 */
public static final native long /*int*/ _nsIMemory_Alloc(long /*int*/ ptr, int size);
public static final long /*int*/ nsIMemory_Alloc(long /*int*/ ptr, int size) {
	lock.lock();
	try {
		return _nsIMemory_Alloc(ptr, size);
	} finally {
		lock.unlock();
	}
}
/**
 * @method flags=cpp
 * @param ptr1 cast=(nsIMemory *)
 * @param ptr2 cast=(void *)
 * @param size cast=(size_t)
 */
public static final native long /*int*/ _nsIMemory_Realloc(long /*int*/ ptr1, long /*int*/ ptr2, int size);
public static final long /*int*/ nsIMemory_Realloc(long /*int*/ ptr1, long /*int*/ ptr2, int size) {
	lock.lock();
	try {
		return _nsIMemory_Realloc(ptr1, ptr2, size);
	} finally {
		lock.unlock();
	}
}
/** @param functionLoad cast=(const nsDynamicFunctionLoad *) */
public static final native int _XPCOMGlueLoadXULFunctions (long /*int*/ functionLoad);
public static final int XPCOMGlueLoadXULFunctions (long /*int*/ functionLoad) {
	lock.lock();
	try {
		return _XPCOMGlueLoadXULFunctions(functionLoad);
	} finally {
		lock.unlock();
	}
}
/** @param place cast=(const char *) */
public static final native int _XPCOMGlueStartup(byte[] place);
public static final int XPCOMGlueStartup(byte[] place) {
	lock.lock();
	try {
		return _XPCOMGlueStartup(place);
	} finally {
		lock.unlock();
	}
}
public static final native int _XPCOMGlueShutdown();
public static final int XPCOMGlueShutdown() {
	lock.lock();
	try {
		return _XPCOMGlueShutdown();
	} finally {
		lock.unlock();
	}
}

public static final native int _Call(long /*int*/ ptr);
public static final int Call(long /*int*/ ptr) {
	lock.lock();
	try {
		return _Call(ptr);
	} finally {
		lock.unlock();
	}
}

/**
 * @param ptr cast=(nsWriteSegmentFun)
 * @param aInStream cast=(nsIInputStream *)
 * @param aClosure cast=(void *)
 * @param aFromSegment cast=(const char *)
 * @param aWriteCount cast=(PRUint32 *)
 */
public static final native long /*int*/ _Call(long /*int*/ ptr, long /*int*/ aInStream, long /*int*/ aClosure, byte[] aFromSegment, int aToOffset, int aCount, int[] aWriteCount);
public static final long /*int*/ Call(long /*int*/ ptr, long /*int*/ aInStream, long /*int*/ aClosure, byte[] aFromSegment, int aToOffset, int aCount, int[] aWriteCount) {
	lock.lock();
	try {
		return _Call(ptr, aInStream, aClosure, aFromSegment, aToOffset, aCount, aWriteCount);
	} finally {
		lock.unlock();
	}
}

/**
 * @param ptr cast=(SWT_XREInitEmbedding)
 * @param aLibXULDirectory cast=(nsILocalFile *)
 * @param aAppDirectory cast=(nsILocalFile *)
 * @param aAppDirProvider cast=(nsIDirectoryServiceProvider *)
 * @param aStaticComponents cast=(nsStaticModuleInfo const *)
 */
public static final native int _Call(long /*int*/ ptr, long /*int*/ aLibXULDirectory, long /*int*/ aAppDirectory, long /*int*/ aAppDirProvider, long /*int*/ aStaticComponents, int aStaticComponentsCount);
public static final int Call(long /*int*/ ptr, long /*int*/ aLibXULDirectory, long /*int*/ aAppDirectory, long /*int*/ aAppDirProvider, long /*int*/ aStaticComponents, int aStaticComponentsCount) {
	lock.lock();
	try {
		return _Call(ptr, aLibXULDirectory, aAppDirectory, aAppDirProvider, aStaticComponents, aStaticComponentsCount);
	} finally {
		lock.unlock();
	}
}

/**
 * @param ptr cast=(SWT_XREInitEmbedding2)
 * @param aLibXULDirectory cast=(nsIFile *)
 * @param aAppDirectory cast=(nsIFile *)
 * @param aAppDirProvider cast=(nsIDirectoryServiceProvider *)
 */
public static final native int _Call(long /*int*/ ptr, long /*int*/ aLibXULDirectory, long /*int*/ aAppDirectory, long /*int*/ aAppDirProvider);
public static final int Call(long /*int*/ ptr, long /*int*/ aLibXULDirectory, long /*int*/ aAppDirectory, long /*int*/ aAppDirProvider) {
	lock.lock();
	try {
		return _Call(ptr, aLibXULDirectory, aAppDirectory, aAppDirProvider);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, double arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, double arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, float arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, float arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, float[] arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, float[] arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long[] arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long[] arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, short arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, short arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, short[] arg0);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, short[] arg0) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, short[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, short[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, short[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, short[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, short arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, short arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, nsID arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, nsID arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, nsID arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, nsID arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, long[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, long[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, int arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, int arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, long arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, long arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, int[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, int[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, long[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, long[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, char[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, char[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long [] arg0, long [] arg1);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long [] arg0, long [] arg1) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, long arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, long arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long [] arg0, long [] arg1, long [] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long [] arg0, long [] arg1, long [] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, long[] arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, long[] arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, long[] arg1, long [] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, long[] arg1, long [] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, long [] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, long [] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, int arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, int arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, long arg1, long [] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, long arg1, long [] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long arg1, long arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long arg1, long arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, nsID arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, nsID arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, nsID arg1, long [] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, nsID arg1, long [] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, nsID arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, nsID arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, nsID arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, nsID arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int[] arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int[] arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int[] arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int[] arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long[] arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long[] arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, long arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, nsID arg1, long arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, char[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, char[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, char[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, char[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, short arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, short arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, short arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, short arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, long arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, long arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, int arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, int arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, short arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, short arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, short arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, short arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, float arg0, float arg1, int[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, float arg0, float arg1, int[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, float arg0, float arg1, long[] arg2);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, float arg0, float arg1, long[] arg2) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, short arg0, int arg1, int arg2, int arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, short arg0, int arg1, int arg2, int arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, short arg0, long arg1, int arg2, long arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, short arg0, long arg1, int arg2, long arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, nsID arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, nsID arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long arg1, nsID arg2, long[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, long arg1, nsID arg2, long[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, int arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, int arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, long arg2, long[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, long arg2, long[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, long [] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, long [] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, char[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, char[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, char[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, char[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1, int[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1, int[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int[] arg2, long[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int[] arg2, long[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, int arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, int arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, long arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, long arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, int arg1, nsID arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, int arg1, nsID arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, long arg1, nsID arg2, long [] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, long arg1, nsID arg2, long [] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, int[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, int[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, long [] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, long [] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2, byte[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2, byte[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2, byte[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2, byte[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2, int arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2, int arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2, long arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2, long arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, short[] arg0, int arg1, int[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, short[] arg0, int arg1, int[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, short[] arg0, long arg1, int[] arg2, long[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, short[] arg0, long arg1, int[] arg2, long[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long[] arg2, long[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long[] arg2, long[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int[] arg2, int[] arg3);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int[] arg2, int[] arg3) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, int arg1, int arg2, int arg3, int arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, int arg1, int arg2, int arg3, int arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, int arg1, long arg2, long arg3, long arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, char[] arg0, int arg1, long arg2, long arg3, long arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, int arg3, long[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, int arg3, long[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int[] arg2, int[] arg3, int[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int[] arg1, int[] arg2, int[] arg3, int[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, int arg2, int[] arg3, int[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, long arg2, long [] arg3, int[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, int arg1, long arg2, long [] arg3, int[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2, int arg3, int arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, byte[] arg2, int arg3, int arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2, long arg3, int arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, byte[] arg2, long arg3, int arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, nsID arg1, int arg2, int arg3, int[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, nsID arg1, int arg2, int arg3, int[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, nsID arg1, long arg2, long arg3, long[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, nsID arg1, long arg2, long arg3, long[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, int arg3, int arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, int arg3, int arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int arg3, long[] arg4);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int arg3, long[] arg4) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, byte[] arg2, byte[] arg3, int arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, byte[] arg1, byte[] arg2, byte[] arg3, int arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, byte[] arg2, byte[] arg3, long arg4, long[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, byte[] arg1, byte[] arg2, byte[] arg3, long arg4, long[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2, int arg3, long arg4, int arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2, int arg3, long arg4, int arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, char[] arg2, int arg3, long arg4, int arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, char[] arg2, int arg3, long arg4, int arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2, long arg3, long arg4, long arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2, long arg3, long arg4, long arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, char[] arg2, long arg3, long arg4, long arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, char[] arg2, long arg3, long arg4, long arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1, int[] arg2, int[] arg3, int[] arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int[] arg0, int[] arg1, int[] arg2, int[] arg3, int[] arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long[] arg0, long[] arg1, long[] arg2, long[] arg3, long[] arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long[] arg0, long[] arg1, long[] arg2, long[] arg3, long[] arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int arg3, int arg4, int arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, int arg3, int arg4, int arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int [] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4, long[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4, long[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, int arg3, byte[] arg4, byte[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, int arg3, byte[] arg4, byte[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, long arg3, byte[] arg4, byte[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, nsID arg0, byte[] arg1, byte[] arg2, long arg3, byte[] arg4, byte[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, long arg2, long arg3, long arg4, long arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, long arg2, long arg3, long arg4, long arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4, long arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4, long arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, char[] arg3, int[] arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, byte[] arg2, int arg3, int arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, byte[] arg2, int arg3, int arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, byte[] arg2, int arg3, int arg4, long[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, byte[] arg0, byte[] arg1, byte[] arg2, int arg3, int arg4, long[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int[] arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int[] arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int[] arg4, long [] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int[] arg4, long [] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2, char[] arg3, int arg4, int [] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, char[] arg2, char[] arg3, int arg4, int [] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, char[] arg2, char[] arg3, int arg4, long[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, char[] arg2, char[] arg3, int arg4, long[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, byte[] arg3, byte[] arg4, int arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, byte[] arg3, byte[] arg4, int arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, byte[] arg3, byte[] arg4, long arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, byte[] arg3, byte[] arg4, long arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int[] arg3, int[] arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int[] arg3, int[] arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, int[] arg3, int[] arg4, int[] arg5);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, int[] arg3, int[] arg4, int[] arg5) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int arg3, int[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int arg3, int[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, int arg3, long[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, int arg3, long[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int[] arg3, char[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int[] arg3, char[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, long[] arg3, char[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, long[] arg3, char[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, char[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, char[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, long arg3, char[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, int arg2, long arg3, char[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, long arg4, int arg5, int arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, long arg4, int arg5, int arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4, long arg5, long arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, long arg4, long arg5, long arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, long arg3, int[] arg4, int[] arg5, int[] arg6);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, long arg2, long arg3, int[] arg4, int[] arg5, int[] arg6) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int[] arg3, int[] arg4, char[] arg5, int[] arg6, int[] arg7);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int[] arg3, int[] arg4, char[] arg5, int[] arg6, int[] arg7) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, long[] arg3, long [] arg4, char[] arg5, int[] arg6, int[] arg7);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, long[] arg3, long [] arg4, char[] arg5, int[] arg6, int[] arg7) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long arg1, long arg2, long arg3, long arg4, long arg5, long arg6, long[] arg7);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, long arg1, long arg2, long arg3, long arg4, long arg5, long arg6, long[] arg7) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, char[] arg6, int[] arg7, int[] arg8);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, char[] arg6, int[] arg7, int[] arg8) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, int arg4, long arg5, char[] arg6, int[] arg7, long [] arg8);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, long arg3, int arg4, long arg5, char[] arg6, int[] arg7, long [] arg8) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int arg3, char[] arg4, char[] arg5, char[] arg6, char[] arg7, int[] arg8, int[] arg9);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, char[] arg1, char[] arg2, int arg3, char[] arg4, char[] arg5, char[] arg6, char[] arg7, int[] arg8, int[] arg9) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, int arg3, char[] arg4, char[] arg5, char[] arg6, char[] arg7, int[] arg8, int[] arg9);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, char[] arg1, char[] arg2, int arg3, char[] arg4, char[] arg5, char[] arg6, char[] arg7, int[] arg8, int[] arg9) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, char[] arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int[] arg10, int[] arg11);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, char[] arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int[] arg10, int[] arg11) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int arg3, char[] arg4, long arg5, long arg6, int arg7, long arg8, int arg9, long [] arg10, long [] arg11);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int arg3, char[] arg4, long arg5, long arg6, int arg7, long arg8, int arg9, long [] arg10, long [] arg11) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, char[] arg4, byte[] arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int[] arg11, int[] arg12);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, char[] arg4, byte[] arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int[] arg11, int[] arg12) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int arg3, char[] arg4, byte[] arg5, long arg6, long arg7, int arg8, long arg9, int arg10, long [] arg11, long [] arg12);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, long arg1, long arg2, int arg3, char[] arg4, byte[] arg5, long arg6, long arg7, int arg8, long arg9, int arg10, long [] arg11, long [] arg12) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, int arg14);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, int arg14) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
	} finally {
		lock.unlock();
	}
}
static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, long arg14);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, long arg14) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, int arg14, float arg15, short arg16);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, int arg14, float arg15, short arg16) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
	} finally {
		lock.unlock();
	}
}

static final native int _VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, long arg14, float arg15, short arg16);
static final int VtblCall(int fnNumber, long /*int*/ ppVtbl, long arg0, int arg1, int arg2, long arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, short arg13, long arg14, float arg15, short arg16) {
	lock.lock();
	try {
		return _VtblCall(fnNumber, ppVtbl, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
	} finally {
		lock.unlock();
	}
}
}
