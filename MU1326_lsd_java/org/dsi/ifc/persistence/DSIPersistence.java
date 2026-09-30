/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.persistence;

import org.dsi.ifc.base.DSIBase;

public interface DSIPersistence
extends DSIBase {
    public static final String VERSION = "2.11.6";
    public static final int IN_VALUECHANGEDINT = 3000;
    public static final int IN_VALUECHANGEDSTRING = 3001;
    public static final int IN_VALUECHANGEDARRAY = 3002;
    public static final int IN_VALUECHANGEDSTRINGARRAY = 3003;
    public static final int IN_VALUECHANGEDBUFFER = 3004;
    public static final int ATTR_ACTIVESQLDATABASEMEDIUM = 1;
    public static final int ERRORCODE_NO_ERRORS = 0;
    public static final int ERRORCODE_INVALID_NAMESPACE = 1;
    public static final int ERRORCODE_INVALID_KEY = 2;
    public static final int ERRORCODE_NOSPACE = 3;
    public static final int ERRORCODE_TRANSACTION_FAILED = 4;
    public static final int ERRORCODE_CORRUPT_DATA = 5;
    public static final int ERRORCODE_NO_DEVICE_AVAILABLE = 6;
    public static final int ERRORCODE_WRONG_PARAMETER_LENGTH = 7;
    public static final int ERRORCODE_STATUS_TIME_OUT = 8;
    public static final int ERRORCODE_DEVICE_BUSY = 9;
    public static final int ERRORCODE_DUMMY_DATA = 10;
    public static final int ERRORCODE_NOT_NOTIFIED = 11;
    public static final int ERRORCODE_INVALID_TIMEOUT = 12;
    public static final int ERRORCODE_ALREADY_PENDING = 13;
    public static final int ERRORCODE_NOT_SUBSCRIBED = 14;
    public static final int ERRORCODE_OVERLOAD = 15;
    public static final int IMPORTANCE_ESSENTIAL = -1;
    public static final int IMPORTANCE_DISPENSABLE = -2;
    public static final int NAMESPACE_SIS = 0;
    public static final int NAMESPACE_ENGINEERING = 1;
    public static final int NAMESPACE_EEPROM = 2;
    public static final int NAMESPACE_IOC = 3;
    public static final int NAMESPACE_DATABASE = 4;
    public static final int NAMESPACE_IRC = 5;
    public static final int NAMESPACE_RAC = 6;
    public static final int NAMESPACE_NDR = 7;
    public static final int MEDIUM_RAM = 0;
    public static final int MEDIUM_FLASH = 1;
    public static final int ENGINEERINGSESSIONHOST_OTHER = 0;
    public static final int ENGINEERINGSESSIONHOST_GREEN_MENU = 1;
    public static final int ENGINEERINGSESSIONHOST_DIAGNOSIS = 2;
    public static final int DIAGNOSEMODE_UNDEFINED = 0;
    public static final int DIAGNOSEMODE_START = 1;
    public static final int DIAGNOSEMODE_STOP = 2;
    public static final int DIAGNOSE_FERNSTEUERUNGS_MODE_START = 3;
    public static final int DIAGNOSE_FERNSTEUERUNGS_MODE_STOP = 4;
    public static final int TYPE_BYTEARRAY = 0;
    public static final int TYPE_INTEGER = 1;
    public static final int TYPE_INTEGERARRAY = 2;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_STRINGARRAY = 4;
    public static final int RT_WRITEINT = 1000;
    public static final int RT_READINT = 1001;
    public static final int RT_WRITEBUFFER = 1002;
    public static final int RT_READBUFFER = 1003;
    public static final int RT_WRITESTRING = 1004;
    public static final int RT_READSTRING = 1005;
    public static final int RT_WRITEARRAY = 1006;
    public static final int RT_READARRAY = 1007;
    public static final int RT_WRITESTRINGARRAY = 1008;
    public static final int RT_READSTRINGARRAY = 1009;
    public static final int RT_ENTERENGINEERINGSESSION = 1012;
    public static final int RT_EXITENGINEERINGSESSION = 1013;
    public static final int RT_GETVISIBLESYSTEMLANGUAGES = 1014;
    public static final int RT_FLUSHSQLDATABASE = 1015;
    public static final int RT_SETSQLDATABASEMEDIUM = 1016;
    public static final int RT_BEGINTRANSACTION = 1017;
    public static final int RT_ENDTRANSACTION = 1018;
    public static final int RT_READINTTIMEOUT = 1019;
    public static final int RT_READBUFFERTIMEOUT = 1020;
    public static final int RT_READSTRINGTIMEOUT = 1021;
    public static final int RT_READARRAYTIMEOUT = 1022;
    public static final int RT_READSTRINGARRAYTIMEOUT = 1023;
    public static final int RT_SUBSCRIBE = 1024;
    public static final int RT_UNSUBSCRIBE = 1025;
    public static final int RT_UNSUBSCRIBEALL = 1026;
    public static final int RP_WRITEINT = 2000;
    public static final int RP_READINT = 2001;
    public static final int RP_WRITEBUFFER = 2002;
    public static final int RP_READBUFFER = 2003;
    public static final int RP_WRITESTRING = 2004;
    public static final int RP_READSTRING = 2005;
    public static final int RP_WRITEARRAY = 2006;
    public static final int RP_READARRAY = 2007;
    public static final int RP_WRITESTRINGARRAY = 2008;
    public static final int RP_READSTRINGARRAY = 2009;
    public static final int RP_GETVISIBLESYSTEMLANGUAGES = 2012;
    public static final int RP_FLUSHSQLDATABASE = 2013;
    public static final int RP_BEGINTRANSACTION = 2014;
    public static final int RP_ENDTRANSACTION = 2015;
    public static final int RP_UNSUBSCRIBE = 2016;

    public void writeInt(int var1, long var2, int var4);

    public void readInt(int var1, long var2);

    public void readIntTimeout(int var1, long var2, int var4);

    public void writeBuffer(int var1, long var2, byte[] var4);

    public void readBuffer(int var1, long var2);

    public void readBufferTimeout(int var1, long var2, int var4);

    public void writeString(int var1, long var2, String var4);

    public void readString(int var1, long var2);

    public void readStringTimeout(int var1, long var2, int var4);

    public void writeArray(int var1, long var2, int[] var4);

    public void readArray(int var1, long var2);

    public void readArrayTimeout(int var1, long var2, int var4);

    public void writeStringArray(int var1, long var2, String[] var4);

    public void readStringArray(int var1, long var2);

    public void readStringArrayTimeout(int var1, long var2, int var4);

    public void enterEngineeringSession(int var1);

    public void exitEngineeringSession(int var1);

    public void getVisibleSystemLanguages();

    public void flushSQLDatabase();

    public void setSQLDatabaseMedium(int var1);

    public void beginTransaction(int var1);

    public void endTransaction(int var1, boolean var2);

    public void subscribe(int var1, int[] var2, long[] var3, int var4);

    public void unsubscribe(int var1, int[] var2, long[] var3);

    public void unsubscribeAll(int var1);
}

