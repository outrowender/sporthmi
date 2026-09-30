/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.persistence;

public interface DSIPersistence {
    public static final String IPL_COMM_UUID = "e0f8829c-7990-5dd2-b13d-5d15671ccd6b";
    public static final String IPL_COMM_INTERFACE_KEY = "c1e23993-ffb9-5051-a603-07b199fdd2d4";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.6";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.6";

    public static interface Consts {
        public static final String VERSION = "2.11.6";
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
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

