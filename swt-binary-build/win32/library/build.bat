@rem ***************************************************************************
@rem Copyright (c) 2000, 2013 IBM Corporation and others.
@rem All rights reserved. This program and the accompanying materials
@rem are made available under the terms of the Eclipse Public License v1.0
@rem which accompanies this distribution, and is available at
@rem http://www.eclipse.org/legal/epl-v10.html
@rem
@rem Contributors:
@rem      IBM Corporation - initial API and implementation
@rem ***************************************************************************

@echo off

IF EXIST C:\BUILD\swt-builddir set SWT_BUILDDIR=C:\BUILD\swt-builddir
IF x.%SWT_BUILDDIR%==x. set SWT_BUILDDIR=S:\swt-builddir
echo SWT build dir: %SWT_BUILDDIR%
IF x.%MSSDK%==x. set MSSDK="%SWT_BUILDDIR%\MSSDKs\Windows Server 2003 SP1 SDK"
IF x.%WEBKIT_HOME%==x. set WEBKIT_HOME="%SWT_BUILDDIR%\webkit"

IF x.%1==x.x86 GOTO X86
IF x.%1==x.x86_64 GOTO X86_64
IF x.%1==x.ia64 GOTO IA64

:X86
IF "x.%OUTPUT_DIR%"=="x." set OUTPUT_DIR=..\..\..\org.eclipse.swt.win32.win32.x86
IF x.%JAVA_HOME%==x. set JAVA_HOME=%SWT_BUILDDIR%\ibm-java2-sdk-50-win-i386
IF x.%BUILD_XULRUNNER%==x.true GOTO XULRUNNER
IF x.%2%==x.make_xulrunner GOTO XULRUNNER
call "%SWT_BUILDDIR%\MSVCs\Microsoft Visual Studio 8\Common7\Tools\vsvars32.bat"
call %MSSDK%\setenv /XP32 /RETAIL
IF x.%1==x.x86 shift
GOTO MAKE

:XULRUNNER
IF x.%DEV_TOOLS%==x. set DEV_TOOLS=%SWT_BUILDDIR%
set MSSDK="%SWT_BUILDDIR%\MSSDKs\feb2003"
call %SWT_BUILDDIR%\MSVCs\msvc60\vc98\bin\vcvars32.bat
call %MSSDK%\setenv /XP32 /RETAIL
IF x.%XULRUNNER_SDK%==x. set XULRUNNER_SDK=%SWT_BUILDDIR%\gecko-sdk
IF x.%1==x.x86 shift
GOTO MAKE

:X86_64

set PROCESSOR_ARCHITECTURE=AMD64
IF "x.%OUTPUT_DIR%"=="x." set OUTPUT_DIR=..\..\..\org.eclipse.swt.win32.win32.x86_64
IF x.%JAVA_HOME%==x. set JAVA_HOME=%SWT_BUILDDIR%\ibm-sdk50-x86_64
set CFLAGS=-DJNI64
IF x.%BUILD_XULRUNNER%==x.true GOTO XULRUNNER64
IF x.%2%==x.make_xulrunner_64 GOTO XULRUNNER64
call %MSSDK%\setenv /X64 /RETAIL
shift
GOTO MAKE

:XULRUNNER64
set MSSDK="%SWT_BUILDDIR%\MSSDKs\Windows 7 SDK v7.1"
call %MSSDK%\bin\setenv /x64 /Release
IF x.%XULRUNNER_SDK%==x. set XULRUNNER_SDK=%SWT_BUILDDIR%\gecko10-sdk-x86_64
set MOZILLACFLAGS=-DJNI64
shift
GOTO MAKE

:IA64

set PROCESSOR_ARCHITECTURE=AMD64
call %MSSDK%\setenv /SRV64 /RETAIL
IF "x.%OUTPUT_DIR%"=="x." set OUTPUT_DIR=..\..\..\org.eclipse.swt.win32.win32.ia64
IF x.%JAVA_HOME%==x. set JAVA_HOME=%SWT_BUILDDIR%\ibm-sdk142-ia64
set CFLAGS=-DJNI64
shift
GOTO MAKE

:MAKE
nmake -f make_win32.mak %1 %2 %3 %4 %5 %6 %7 %8 %9
