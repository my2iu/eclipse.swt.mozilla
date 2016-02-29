#*******************************************************************************
# Copyright (c) 2000, 2015 IBM Corporation and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     IBM Corporation - initial API and implementation
#*******************************************************************************

# Makefile for SWT libraries on Windows

# assumes these variables are set in the environment from which nmake is run
#	JAVA_HOME
#	OUTPUT_DIR

!include <make_common.mak>
!include <win32.mak>

SWT_PREFIX  = swt
WS_PREFIX   = win32
SWT_VERSION = $(maj_ver)$(min_ver)

# Uncomment for Native Stats tool
#NATIVE_STATS = -DNATIVE_STATS

XULRUNNER_PREFIX = swt-xulrunner
#XULRUNNER_LIB = $(XULRUNNER_PREFIX)-$(WS_PREFIX)-$(SWT_VERSION).dll
XULRUNNER_LIB = $(XULRUNNER_PREFIX).dll
XULRUNNER_LIBS = Advapi32.lib $(XULRUNNER_SDK)\lib\xpcomglue.lib $(XULRUNNER_SDK)\lib\mozalloc.lib
XULRUNNER_OBJS = xpcom.obj xpcom_custom.obj xpcom_structs.obj xpcom_stats.obj
XPCOMINIT_OBJS = xpcominit.obj xpcominit_structs.obj xpcominit_stats.obj

MOZILLACFLAGS = -c \
	-O1 \
	$(MOZILLACFLAGS) \
	-DSWT_VERSION=$(SWT_VERSION) \
	$(NATIVE_STATS) \
	-MD \
	-DMOZILLA_STRICT_API=1 \
	-W3 \
	-I. \
	-DWIN32 \
	-DNO__1XPCOMGlueShutdown \
	-DNO__1Call__IIIIII \
	-DNO_GREVersionRange \
	-DNO__1GRE_1GetGREPathWithProperties \
	-DNO_GREProperty \
	-FImozilla/Char16.h \
	-I$(JAVA_HOME)/include \
	-I$(JAVA_HOME)/include/win32 \
	-I"$(XULRUNNER_SDK)\include\nspr" \
	-I"$(XULRUNNER_SDK)\include\mozilla-config.h" -I"$(XULRUNNER_SDK)\include"

#CFLAGS = $(cdebug) $(cflags) $(cvarsmt) $(CFLAGS) \
CFLAGS = -O1 -DNDEBUG $(cflags) $(cvarsmt) $(CFLAGS) \
	-DSWT_VERSION=$(SWT_VERSION) $(NATIVE_STATS) -DUSE_ASSEMBLER \
	/I"$(JAVA_HOME)\include" /I"$(JAVA_HOME)\include\win32" /I.
RCFLAGS = $(rcflags) $(rcvars) $(RCFLAGS) -DSWT_FILE_VERSION=\"$(maj_ver).$(min_ver)\" -DSWT_COMMA_VERSION=$(comma_ver)

all: make_xulrunner

xpcom_custom.obj: xpcom_custom.cpp
	cl $(MOZILLACFLAGS) xpcom_custom.cpp
xpcom_stats.obj: xpcom_stats.cpp
	cl $(MOZILLACFLAGS) xpcom_stats.cpp
xpcom_structs.obj: xpcom_structs.cpp
	cl $(MOZILLACFLAGS) xpcom_structs.cpp
xpcom.obj: xpcom.cpp
	cl $(MOZILLACFLAGS) xpcom.cpp
xpcominit_stats.obj: xpcominit_stats.cpp
	cl $(MOZILLACFLAGS) xpcominit_stats.cpp
xpcominit_structs.obj: xpcominit_structs.cpp
	cl $(MOZILLACFLAGS) xpcominit_structs.cpp
xpcominit.obj: xpcominit.cpp
	cl $(MOZILLACFLAGS) xpcominit.cpp

.c.obj:
	cl $(CFLAGS) $*.c

.cpp.obj:
	cl $(CFLAGS) $*.cpp

	
make_xulrunner: $(XULRUNNER_OBJS) $(XPCOMINIT_OBJS) swt_xpcom.res
	echo $(ldebug) $(dlllflags) >templrf
	echo $(XULRUNNER_LIBS) >>templrf
	echo $(XULRUNNER_OBJS) $(XPCOMINIT_OBJS) >>templrf
	echo swt_xpcom.res >>templrf
	echo -out:$(XULRUNNER_LIB) >>templrf
	link @templrf
	del templrf

make_xulrunner_64: $(XULRUNNER_OBJS) swt_xpcom.res
	echo /RELEASE $(dlllflags) >templrf
	echo $(XULRUNNER_LIBS) >>templrf
	echo $(XULRUNNER_OBJS) >>templrf
	echo swt_xpcom.res >>templrf
	echo -out:$(XULRUNNER_LIB) >>templrf
	link @templrf
	del templrf
	
swt_xpcom.res:
	rc $(RCFLAGS) -DSWT_ORG_FILENAME=\"$(XULRUNNER_LIB)\" -r -fo swt_xpcom.res swt_xpcom.rc

swt_xpcominit.res:
	rc $(RCFLAGS) -DSWT_ORG_FILENAME=\"$(XPCOMINIT_LIB)\" -r -fo swt_xpcom.res swt_xpcom.rc

install:
	copy *.dll "$(OUTPUT_DIR)"

clean:
    del *.obj *.res *.dll *.lib *.exp
