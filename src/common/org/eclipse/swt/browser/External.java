/*******************************************************************************
 * Copyright (c) 2008, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Neil Rashbrook <neil@parkwaycc.co.uk> - Bug 429739
 *     Matthew Painter <matthew.painter@import.io>
 *     Red Hat Inc. - generification
 *******************************************************************************/
package org.eclipse.swt.browser;


import org.eclipse.swt.*;
import org.eclipse.swt.internal.*;
import org.eclipse.swt.internal.mozilla.*;

class External {
	public static final String EXTERNAL_IID_STR =
		"ded01d20-ba6f-11dd-ad8b-0800200c9a66"; //$NON-NLS-1$

	public static final nsID EXTERNAL_IID =
		new nsID(EXTERNAL_IID_STR);

	XPCOMObject supports;
	XPCOMObject external;
	XPCOMObject classInfo;
	XPCOMObject securityCheckedComponent;
	XPCOMObject scriptObjectOwner;
	int refCount = 0;

	static final String CALLJAVA = "callJava"; //$NON-NLS-1$

	static Callback CallJavaProc;
	static {
		CallJavaProc = new Callback (External.class, CALLJAVA, 3);
		if (CallJavaProc.getAddress () == 0) SWT.error (SWT.ERROR_NO_MORE_CALLBACKS);
	}

External () {
	createCOMInterfaces ();
}

/* external */

/*
 * This is the BrowserFunction entry point for XULRunner releases >= 4 because
 * QueryInterface answers an nsIScriptObjectOwner implementation (which points
 * at this function) iff the detected XULRunner version is >= 4.
 */
static long /*int*/ callJava (long /*int*/ cx, long /*int*/ argc, long /*int*/ vp) {
	int jsval_sizeof = 8;
	long /*int*/ argsPtr = vp + 2 * jsval_sizeof;
	nsIVariant resultVariant = null;

	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetServiceManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
	result[0] = 0;
	rc = serviceManager.GetService (XPCOM.NS_IXPCONNECT_CID, IIDStore.GetIID (nsIXPConnect.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIXPConnect connect = new nsIXPConnect (result[0]);
	result[0] = 0;

	/* extract the first argument value (the function id) */
	rc = connect.JSValToVariant (cx, argsPtr, result);
	if (rc == XPCOM.NS_OK && result[0] != 0) {
		nsIVariant idVariant = new nsIVariant (result[0]);
		result[0] = 0;
		short[] dataType = new short[1];
		rc = idVariant.GetDataType (dataType);
		if (rc == XPCOM.NS_OK && dataType[0] == nsIDataType.VTYPE_INT32) {
			int[] intResult = new int[1];
			rc = idVariant.GetAsInt32 (intResult); /* PRInt32 */
			if (rc == XPCOM.NS_OK) {
				int functionId = intResult[0];

				/* get the second argument variant (the token string) */
				argsPtr += jsval_sizeof;
				rc = connect.JSValToVariant (cx, argsPtr, result);
				if (rc == XPCOM.NS_OK && result[0] != 0) {
					long /*int*/ tokenVariant = result[0];
					result[0] = 0;

					/* get the third argument variant (the invocation args) */
					argsPtr += jsval_sizeof;
					rc = connect.JSValToVariant (cx, argsPtr, result);
					if (rc == XPCOM.NS_OK && result[0] != 0) {
						long /*int*/ argsVariant = result[0];
						result[0] = 0;

						/* invoke the BrowserFunction */
						resultVariant = new nsIVariant (invokeFunction (functionId, tokenVariant, argsVariant));
						new nsISupports (argsVariant).Release ();
					}
					new nsISupports (tokenVariant).Release ();
				}
			}
		}
		idVariant.Release ();
	}
	result[0] = 0;

	/* if the BrowserFunction could not be invoked for some reason then return null to JS */
	if (resultVariant == null) {
		rc = XPCOM.NS_GetComponentManager (result);
		if (rc != XPCOM.NS_OK) Mozilla.error (rc);
		if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
		nsIComponentManager componentManager = new nsIComponentManager (result[0]);
		result[0] = 0;
		resultVariant = convertToJS (null, componentManager);
		componentManager.Release ();
	}

	/* convert the resulting variant to a jsval */
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
	rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	serviceManager.Release();

	nsIMemory memory = new nsIMemory (result[0]);
	result[0] = 0;
	long /*int*/ jsVal = memory.Alloc (jsval_sizeof);
	C.memset (jsVal, 0, jsval_sizeof);
	long /*int*/ globalObject = 0;
	globalObject = XPCOM.JS_GetGlobalObject (Mozilla.getJSLibPathBytes (), cx);
	rc = connect.VariantToJS (cx, globalObject, resultVariant.getAddress (), jsVal);
	resultVariant.Release ();
	connect.Release ();

	long /*int*/ returnValue = XPCOM.JS_FALSE;
	if (rc == XPCOM.NS_OK) {
		/* write the jsval to the return value slot */
		C.memmove (vp, jsVal, jsval_sizeof);
		returnValue = XPCOM.JS_TRUE;
	}
	memory.Free (jsVal);
	memory.Release ();
	return returnValue;
}

/* this is the BrowserFunction entry point when the detected XULRunner version is < 4 */
static int callJava (int functionId, long /*int*/ tokenVariant, long /*int*/ argsVariant, long /*int*/ returnPtr) {
	long /*int*/ resultVariant = invokeFunction (functionId, tokenVariant, argsVariant);
	C.memmove (returnPtr, new long /*int*/[] {resultVariant}, C.PTR_SIZEOF);
	return XPCOM.NS_OK;
}

static Object convertToJava (nsIVariant variant) {
	short[] dataType = new short[1];
	int rc = variant.GetDataType (dataType);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	switch (dataType[0]) {
		case nsIDataType.VTYPE_EMPTY:
		case nsIDataType.VTYPE_VOID:
			return null;
		case nsIDataType.VTYPE_EMPTY_ARRAY:
			return new Object[0];
		case nsIDataType.VTYPE_BOOL:
			int[] boolResult = new int[1]; /*PRInt32*/
			rc = variant.GetAsBool (boolResult);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
			return new Boolean (boolResult[0] != 0);
		case nsIDataType.VTYPE_INT32:
			int[] intResult = new int[1]; /*PRInt32*/
			rc = variant.GetAsInt32 (intResult);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
			return new Double (intResult[0]);
		case nsIDataType.VTYPE_DOUBLE:
			long /*int*/ doubleReturn = C.malloc (8);
			rc = variant.GetAsDouble (doubleReturn);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
			double[] doubleResult = new double[1];
			C.memmove (doubleResult, doubleReturn, 8);
			C.free (doubleReturn);
			return new Double (doubleResult[0]);
		case nsIDataType.VTYPE_WSTRING_SIZE_IS:
			int[] size = new int[1]; /* PRInt32 */
			long /*int*/[] wString = new long /*int*/[1];
			rc = variant.GetAsWStringWithSize (size, wString);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
			char[] chars = new char[size[0]];
			C.memmove (chars, wString[0], size[0] * 2);
			return new String (chars);
		case nsIDataType.VTYPE_ARRAY:
			Object[] arrayReturn = new Object[0];
			long /*int*/ iid = C.malloc (nsID.sizeof);
			C.memset (iid, 0, nsID.sizeof);
			int[] count = new int[1]; /* PRUint32 */
			short[] currentType = new short[1];
			long /*int*/[] ptr = new long /*int*/[1];
			rc = variant.GetAsArray (currentType, iid, count, ptr);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
			if (ptr[0] == 0) Mozilla.error (XPCOM.NS_ERROR_NULL_POINTER);
			nsID id = new nsID ();
			XPCOM.memmove (id, iid, nsID.sizeof);
			C.free (iid);

			long /*int*/[] result = new long /*int*/[1];
			rc = XPCOM.NS_GetServiceManager (result);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
			if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

			nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
			result[0] = 0;
			byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
			rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
			if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
			serviceManager.Release ();

			nsIMemory memory = new nsIMemory (result[0]);
			result[0] = 0;

			if (id.Equals (IIDStore.GetIID (nsIVariant.class))) {
				arrayReturn = new Object[count[0]];
				for (int i = 0; i < count[0]; i++) {
					long /*int*/[] arrayPtr = new long /*int*/[1];
					C.memmove (arrayPtr, ptr[0] + i * C.PTR_SIZEOF, C.PTR_SIZEOF);
					nsISupports supports = new nsISupports (arrayPtr[0]);
					rc = supports.QueryInterface (id, result);
					if (rc != XPCOM.NS_OK) Mozilla.error (rc);
					if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
					supports.Release ();

					nsIVariant currentVariant = new nsIVariant (result[0]);
					result[0] = 0;
					if (rc != XPCOM.NS_OK) Mozilla.error (rc);
					try {
						arrayReturn[i] = convertToJava (currentVariant);
						currentVariant.Release ();
					} catch (IllegalArgumentException e) {
						/* invalid argument value type */
						currentVariant.Release ();
						memory.Free (ptr[0]);
						memory.Release ();
						throw e;
					}
				}
			} else {
				switch (currentType[0]) {
					case nsIDataType.VTYPE_DOUBLE:
						arrayReturn = new Object[count[0]];
						for (int i = 0; i < count[0]; i++) {
							double[] doubleValue = new double[1];
							C.memmove (doubleValue, ptr[0] + i * 8, 8);
							arrayReturn[i] = new Double (doubleValue[0]);
						}
						break;
					case nsIDataType.VTYPE_BOOL:
						arrayReturn = new Object[count[0]];
						for (int i = 0; i < count[0]; i++) {
							/* mozilla's representation of boolean changed from 4 bytes to 1 byte as of XULRunner 4.x */
							if (MozillaVersion.CheckVersion (MozillaVersion.VERSION_XR10)) {
								byte[] byteValue = new byte[1];
								C.memmove (byteValue, ptr[0] + i, 1);
								arrayReturn[i] = new Boolean (byteValue[0] != 0);
							} else {
								int[] boolValue = new int[1]; /* PRUInt32 */
								C.memmove (boolValue, ptr[0] + i * 4, 4);
								arrayReturn[i] = new Boolean (boolValue[0] != 0);
							}
						}
						break;
					case nsIDataType.VTYPE_INT32:
						arrayReturn = new Object[count[0]];
						for (int i = 0; i < count[0]; i++) {
							int[] intValue = new int[1]; /* PRInt32 */
							C.memmove (intValue, ptr[0] + i * 4, 4);
							arrayReturn[i] = new Double (intValue[0]);
						}
						break;
					case nsIDataType.VTYPE_WCHAR_STR:
						arrayReturn = new Object[count[0]];
						for (int i = 0; i < count[0]; i++) {
							long /*int*/ currentPtr = ptr[0] + i * C.PTR_SIZEOF;
							long /*int*/[] stringPtr = new long /*int*/[1];
							C.memmove (stringPtr, currentPtr, C.PTR_SIZEOF);
							int length = XPCOM.strlen_PRUnichar (stringPtr[0]);
							char[] dest = new char[length];
							XPCOM.memmove (dest, stringPtr[0], length * 2);
							arrayReturn[i] = new String (dest);
						}
						break;
					default:
						memory.Free (ptr[0]);
						memory.Release ();
						SWT.error (SWT.ERROR_INVALID_ARGUMENT);
				}
			}
			memory.Free (ptr[0]);
			memory.Release ();
			return arrayReturn;
	}
	SWT.error (SWT.ERROR_INVALID_ARGUMENT);
	return null;
}

static nsIVariant convertToJS (Object value, nsIComponentManager componentManager) {
	long /*int*/[] result = new long /*int*/[1];
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_VARIANT_CONTRACTID, true);
	int rc = componentManager.CreateInstanceByContractID (aContractID, 0, IIDStore.GetIID (nsIWritableVariant.class), result);
	nsIWritableVariant variant = new nsIWritableVariant (result[0]);
	result[0] = 0;

	if (value == null) {
		rc = variant.SetAsEmpty ();
		if (rc != XPCOM.NS_OK) Mozilla.error (rc);
		return variant;
	}
	if (value instanceof String) {
		String stringValue = (String)value;
		int length = stringValue.length ();
		char[] chars = new char[length];
		stringValue.getChars (0, length, chars, 0);
		rc = variant.SetAsWStringWithSize (length, chars);
		if (rc != XPCOM.NS_OK) Mozilla.error (rc);
		return variant;
	}
	if (value instanceof Boolean) {
		Boolean booleanValue = (Boolean)value;
		rc = variant.SetAsBool (booleanValue.booleanValue () ? 1 : 0);
		if (rc != XPCOM.NS_OK) Mozilla.error (rc);
		return variant;
	}
	if (value instanceof Number) {
		Number numberValue = (Number)value;
		rc = variant.SetAsDouble (numberValue.doubleValue ());
		if (rc != XPCOM.NS_OK) Mozilla.error (rc);
		return variant;
	}
	if (value instanceof Object[]) {
		Object[] arrayValue = (Object[])value;
		int length = arrayValue.length;
		if (length == 0) {
			rc = variant.SetAsEmptyArray ();
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
		} else {
			long /*int*/ arrayPtr = C.malloc (C.PTR_SIZEOF * length);
			for (int i = 0; i < length; i++) {
				Object currentObject = arrayValue[i];
				try {
					nsIVariant currentVariant = convertToJS (currentObject, componentManager);
					C.memmove (arrayPtr + C.PTR_SIZEOF * i, new long /*int*/[] {currentVariant.getAddress ()}, C.PTR_SIZEOF);
				} catch (SWTException e) {
					/* invalid return value type */
					C.free (arrayPtr);
					variant.Release ();
					/* release the variants that had previously been added to the array */
					for (int j = 0; j < i; j++) {
						long /*int*/[] ptr = new long /*int*/[1];
						C.memmove (ptr, arrayPtr + C.PTR_SIZEOF * j, C.PTR_SIZEOF);
						new nsISupports (ptr[0]).Release ();
					}
					throw e;
				}
			}
			long /*int*/ idPtr = C.malloc (nsID.sizeof);
			XPCOM.memmove (idPtr, IIDStore.GetIID (nsIVariant.class), nsID.sizeof);
			rc = variant.SetAsArray (nsIDataType.VTYPE_INTERFACE_IS, idPtr, length, arrayPtr);
			C.free (idPtr);
			C.free (arrayPtr);
			if (rc != XPCOM.NS_OK) Mozilla.error (rc);
		}
		return variant;
	}

	variant.Release ();
	SWT.error (SWT.ERROR_INVALID_RETURN_VALUE);
	return null;
}

static long /*int*/ invokeFunction (int functionId, long /*int*/ tokenVariant, long /*int*/ args) {
	Integer key = new Integer (functionId);
	BrowserFunction function = Mozilla.AllFunctions.get (key);
	Object returnValue = null;

	if (function != null) {
		try {
			nsIVariant variant = new nsIVariant (tokenVariant);
			Object temp = convertToJava (variant);
			if (temp instanceof String) {
				String token = (String)temp;
				if (token.equals (function.token)) {
					variant = new nsIVariant (args);
					temp = convertToJava (variant);
					if (temp instanceof Object[]) {
						Object[] arguments = (Object[])temp;
						try {
							returnValue = function.function (arguments);
						} catch (Exception e) {
							/* exception during function invocation */
							returnValue = WebBrowser.CreateErrorString (e.getLocalizedMessage ());
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			/* invalid argument value type */
			if (function.isEvaluate) {
				/* notify the evaluate function so that a java exception can be thrown */
				function.function (new String[] {WebBrowser.CreateErrorString (new SWTException (SWT.ERROR_INVALID_RETURN_VALUE).getLocalizedMessage ())});
			}
			returnValue = WebBrowser.CreateErrorString (e.getLocalizedMessage ());
		}
	}

	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetComponentManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	nsIComponentManager componentManager = new nsIComponentManager (result[0]);
	result[0] = 0;
	nsIVariant variant;
	try {
		variant = convertToJS (returnValue, componentManager);
	} catch (SWTException e) {
		/* invalid return value type */
		variant = convertToJS (WebBrowser.CreateErrorString (e.getLocalizedMessage ()), componentManager);
	}
	componentManager.Release ();

	return variant.getAddress ();
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

	classInfo = new XPCOMObject (new int[] {2, 0, 0, 2, 2, 1, 1, 1, 1, 1, 1}) {
		@Override
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		@Override
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		@Override
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
		@Override
		public long /*int*/ method3 (long /*int*/[] args) {return getInterfaces (args[0], args[1]);}
		@Override
		public long /*int*/ method4 (long /*int*/[] args) {return getHelperForLanguage ((int)/*64*/args[0], args[1]);}
		@Override
		public long /*int*/ method5 (long /*int*/[] args) {return getContractID (args[0]);}
		@Override
		public long /*int*/ method6 (long /*int*/[] args) {return getClassDescription (args[0]);}
		@Override
		public long /*int*/ method7 (long /*int*/[] args) {return getClassID (args[0]);}
		@Override
		public long /*int*/ method8 (long /*int*/[] args) {return getImplementationLanguage (args[0]);}
		@Override
		public long /*int*/ method9 (long /*int*/[] args) {return getFlags (args[0]);}
		@Override
		public long /*int*/ method10 (long /*int*/[] args) {return getClassIDNoAlloc (args[0]);}
	};

	securityCheckedComponent = new XPCOMObject (new int[] {2, 0, 0, 2, 3, 3, 3}) {
		@Override
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		@Override
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		@Override
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
		@Override
		public long /*int*/ method3 (long /*int*/[] args) {return canCreateWrapper (args[0], args[1]);}
		@Override
		public long /*int*/ method4 (long /*int*/[] args) {return canCallMethod (args[0], args[1], args[2]);}
		@Override
		public long /*int*/ method5 (long /*int*/[] args) {return canGetProperty (args[0], args[1], args[2]);}
		@Override
		public long /*int*/ method6 (long /*int*/[] args) {return canSetProperty (args[0], args[1], args[2]);}
	};

	external = new XPCOMObject (new int[] {2, 0, 0, 4}) {
		@Override
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		@Override
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		@Override
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
		@Override
		public long /*int*/ method3 (long /*int*/[] args) {return callJava ((int)/*64*/args[0], args[1], args[2], args[3]);}
	};

	scriptObjectOwner = new XPCOMObject (new int[] {2, 0, 0, 2, 1}) {
		@Override
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		@Override
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		@Override
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
		@Override
		public long /*int*/ method3 (long /*int*/[] args) {return getScriptObject (args[0], args[1]);}
		@Override
		public long /*int*/ method4 (long /*int*/[] args) {return setScriptObject (args[0]);}
	};
}

void disposeCOMInterfaces () {
	if (supports != null) {
		supports.dispose ();
		supports = null;
	}
	if (classInfo != null) {
		classInfo.dispose ();
		classInfo = null;
	}
	if (securityCheckedComponent != null) {
		securityCheckedComponent.dispose ();
		securityCheckedComponent = null;
	}
	if (external != null) {
		external.dispose ();
		external = null;
	}
	if (scriptObjectOwner != null) {
		scriptObjectOwner.dispose ();
		scriptObjectOwner = null;
	}
}

long /*int*/ getAddress () {
	return external.getAddress ();
}

int QueryInterface (long /*int*/ riid, long /*int*/ ppvObject) {
	if (riid == 0 || ppvObject == 0) return XPCOM.NS_ERROR_NO_INTERFACE;
	nsID guid = new nsID ();
	XPCOM.memmove (guid, riid, nsID.sizeof);

	if (guid.Equals (XPCOM.NS_ISUPPORTS_IID)) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {supports.getAddress ()}, C.PTR_SIZEOF);
		AddRef();
		return XPCOM.NS_OK;
	}
	if (guid.Equals (IIDStore.GetIID (nsIClassInfo.class))) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {classInfo.getAddress ()}, C.PTR_SIZEOF);
		AddRef();
		return XPCOM.NS_OK;
	}
	if (guid.Equals (XPCOM.NS_ISECURITYCHECKEDCOMPONENT_IID)) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {securityCheckedComponent.getAddress ()}, C.PTR_SIZEOF);
		AddRef();
		return XPCOM.NS_OK;
	}
	if (guid.Equals (EXTERNAL_IID)) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {external.getAddress ()}, C.PTR_SIZEOF);
		AddRef();
		return XPCOM.NS_OK;
	}

	if (MozillaVersion.CheckVersion (MozillaVersion.VERSION_XR10)) {
		if (guid.Equals (XPCOM.NS_ISCRIPTOBJECTOWNER_IID)) {
			XPCOM.memmove (ppvObject, new long /*int*/[] {scriptObjectOwner.getAddress ()}, C.PTR_SIZEOF);
			AddRef();
			return XPCOM.NS_OK;
		}
	}

	XPCOM.memmove (ppvObject, new long /*int*/[] {0}, C.PTR_SIZEOF);
	return XPCOM.NS_ERROR_NO_INTERFACE;
}

int Release () {
	refCount--;
	if (refCount == 0) disposeCOMInterfaces ();
	return refCount;
}

/* nsIClassInfo */

int getClassDescription (long /*int*/ _retValue) {
	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetServiceManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
	result[0] = 0;
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
	rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	serviceManager.Release ();

	nsIMemory memory = new nsIMemory (result[0]);
	result[0] = 0;
	byte[] bytes = MozillaDelegate.wcsToMbcs (null, "external", true); //$NON-NLS-1$
	long /*int*/ ptr = memory.Alloc (bytes.length);
	C.memmove (ptr, bytes, bytes.length);
	C.memmove (_retValue, new long /*int*/[] {ptr}, C.PTR_SIZEOF);
	memory.Release ();

	return XPCOM.NS_OK;
}

int getClassID (long /*int*/ _retValue) {
	return XPCOM.NS_OK;
}

int getClassIDNoAlloc (long /*int*/ _retValue) {
	return XPCOM.NS_OK;
}

int getContractID (long /*int*/ _retValue) {
	return XPCOM.NS_OK;
}

int getFlags (long /*int*/ flags) {
	C.memmove (flags, new int[] {nsIClassInfo.DOM_OBJECT}, 4); /* PRUint32 */
	return XPCOM.NS_OK;
}

int getHelperForLanguage (int language, long /*int*/ _retValue) {
	C.memmove (_retValue, new long /*int*/[] {0}, C.PTR_SIZEOF);
	return XPCOM.NS_OK;
}

int getImplementationLanguage (long /*int*/ _retValue) {
	C.memmove (_retValue, new int[] {5}, 4); /* nsIProgrammingLanguage.JAVA */ /* PRUint */
	return XPCOM.NS_OK;
}

int getInterfaces (long /*int*/ count, long /*int*/ array) {
	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetServiceManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
	result[0] = 0;
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
	rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	serviceManager.Release ();

	nsIMemory memory = new nsIMemory (result[0]);
	result[0] = 0;
	long /*int*/ securityCheckedComponentIID = memory.Alloc (nsID.sizeof);
	XPCOM.memmove (securityCheckedComponentIID, XPCOM.NS_ISECURITYCHECKEDCOMPONENT_IID, nsID.sizeof);
	long /*int*/ externalIID = memory.Alloc (nsID.sizeof);
	XPCOM.memmove (externalIID, EXTERNAL_IID, nsID.sizeof);
	long /*int*/ ptrArray = memory.Alloc (3 * C.PTR_SIZEOF);
	C.memmove (ptrArray, new long /*int*/[] {securityCheckedComponentIID}, C.PTR_SIZEOF);
	C.memmove (ptrArray + C.PTR_SIZEOF, new long /*int*/[] {externalIID}, C.PTR_SIZEOF);

	C.memmove (array, new long /*int*/[] {ptrArray}, C.PTR_SIZEOF);
	memory.Release ();

	C.memmove (count, new int[] {2}, 4); /* PRUint */
	return XPCOM.NS_OK;
}

/* nsIScriptObjectOwner */

int getScriptObject (long /*int*/ aContext, long /*int*/ aScriptObject) {
	byte[] jsLibPath = Mozilla.getJSLibPathBytes ();
	long /*int*/ nativeContext = XPCOM.nsIScriptContext_GetNativeContext (aContext);
	long /*int*/ globalJSObject = XPCOM.JS_GetGlobalObject (jsLibPath, nativeContext);
	long /*int*/ newObject = XPCOM.JS_NewObject (jsLibPath, nativeContext, 0, 0, globalJSObject);

	byte[] functionName = MozillaDelegate.wcsToMbcs (null, CALLJAVA, true);
	int flags = XPCOM.JSPROP_ENUMERATE | XPCOM.JSPROP_READONLY | XPCOM.JSPROP_PERMANENT;
	XPCOM.JS_DefineFunction (jsLibPath, nativeContext, newObject, functionName, XPCOM.CALLBACK_JSNative (CallJavaProc.getAddress ()), 3, flags);
	XPCOM.memmove (aScriptObject, new long /*int*/[] {newObject}, C.PTR_SIZEOF);
	return XPCOM.NS_OK;
}

int setScriptObject (long /*int*/ aScriptObject) {
	return XPCOM.NS_COMFALSE;
}

/* nsISecurityCheckedComponent */

int canCreateWrapper (long /*int*/ iid, long /*int*/ _retVal) {
	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetServiceManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
	result[0] = 0;
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
	rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	serviceManager.Release ();

	nsIMemory memory = new nsIMemory (result[0]);
	result[0] = 0;
	byte[] bytes = MozillaDelegate.wcsToMbcs (null, "allAccess", true); //$NON-NLS-1$
	long /*int*/ ptr = memory.Alloc (bytes.length);
	C.memmove (ptr, bytes, bytes.length);
	C.memmove (_retVal, new long /*int*/[] {ptr}, C.PTR_SIZEOF);
	memory.Release ();

	return XPCOM.NS_OK;
}

int canCallMethod (long /*int*/ iid, long /*int*/ methodName, long /*int*/ _retVal) {
	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetServiceManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
	result[0] = 0;
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
	rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	serviceManager.Release ();

	nsIMemory memory = new nsIMemory (result[0]);
	result[0] = 0;
	int length = XPCOM.strlen_PRUnichar (methodName);
	char[] dest = new char[length];
	XPCOM.memmove (dest, methodName, length * 2);
	String string = new String (dest);
	byte[] bytes;
	if (string.equals (CALLJAVA)) {
		bytes = MozillaDelegate.wcsToMbcs (null, "allAccess", true); //$NON-NLS-1$
	} else {
		bytes = MozillaDelegate.wcsToMbcs (null, "noAccess", true); //$NON-NLS-1$
	}
	long /*int*/ ptr = memory.Alloc (bytes.length);
	C.memmove (ptr, bytes, bytes.length);
	C.memmove (_retVal, new long /*int*/[] {ptr}, C.PTR_SIZEOF);
	memory.Release ();

	return XPCOM.NS_OK;
}

int canGetProperty (long /*int*/ iid, long /*int*/ propertyName, long /*int*/ _retVal) {
	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetServiceManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
	result[0] = 0;
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
	rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	serviceManager.Release ();

	nsIMemory memory = new nsIMemory (result[0]);
	result[0] = 0;
	byte[] bytes = MozillaDelegate.wcsToMbcs (null, "noAccess", true); //$NON-NLS-1$
	long /*int*/ ptr = memory.Alloc (bytes.length);
	C.memmove (ptr, bytes, bytes.length);
	C.memmove (_retVal, new long /*int*/[] {ptr}, C.PTR_SIZEOF);
	memory.Release ();

	return XPCOM.NS_OK;
}

int canSetProperty (long /*int*/ iid, long /*int*/ propertyName, long /*int*/ _retVal) {
	long /*int*/[] result = new long /*int*/[1];
	int rc = XPCOM.NS_GetServiceManager (result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
	result[0] = 0;
	byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
	rc = serviceManager.GetServiceByContractID (aContractID, IIDStore.GetIID (nsIMemory.class), result);
	if (rc != XPCOM.NS_OK) Mozilla.error (rc);
	if (result[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);
	serviceManager.Release ();

	nsIMemory memory = new nsIMemory (result[0]);
	result[0] = 0;
	byte[] bytes = MozillaDelegate.wcsToMbcs (null, "noAccess", true); //$NON-NLS-1$
	long /*int*/ ptr = memory.Alloc (bytes.length);
	C.memmove (ptr, bytes, bytes.length);
	C.memmove (_retVal, new long /*int*/[] {ptr}, C.PTR_SIZEOF);
	memory.Release ();

	return XPCOM.NS_OK;
}

}
