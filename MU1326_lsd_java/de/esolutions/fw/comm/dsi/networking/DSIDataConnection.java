/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

public interface DSIDataConnection {
    public static final String IPL_COMM_UUID = "8e406e53-2d4b-5482-b80c-ad8e9a744fe0";
    public static final String IPL_COMM_INTERFACE_KEY = "f7a37456-332f-5327-a18c-38ab3fdee94c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.14";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.14";

    public static interface Consts {
        public static final String VERSION = "2.11.14";
        public static final int DATACONTEXTSTATE_ATTACHED_GPRS = 0;
        public static final int DATACONTEXTSTATE_ATTACHED_EDGE = 1;
        public static final int DATACONTEXTSTATE_ATTACHED_UMTS = 2;
        public static final int DATACONTEXTSTATE_ATTACHED_HSDPA = 3;
        public static final int DATACONTEXTSTATE_NOT_ATTACHED = 4;
        public static final int DATACONTEXTSTATE_DATA_DIAGNOSE_NOT_ALLOWED = 5;
        public static final int DATACONTEXTSTATE_DATA_NOT_FUNCTIONAL = 6;
        public static final int RESULT_RESULT_OK = 0;
        public static final int RESULT_RESULT_ABORTED = 1;
        public static final int RESULT_ERROR_GENERAL = 2;
        public static final int RESULT_ERROR_CONNECTION_REQUEST_RUNNING = 3;
        public static final int RESULT_ERROR_PROFILE_NOT_EXISTS = 4;
        public static final int RESULT_ERROR_SYSTEM_ERROR = 5;
        public static final int RESULT_ERROR_TIME_OUT = 6;
        public static final int RESULT_ERROR_NOT_SUPPORTED = 7;
        public static final int RESULT_ERROR_DENIED = 8;
        public static final int RESULT_ERROR_CONNECTION_REFUSED = 9;
        public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_UNKNOWN = 0;
        public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_FULL = 1;
        public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_LIMITED = 2;
        public static final int CONNECTION_IDLE_ALLOWED = 21;
        public static final int CONNECTION_CONNECTED_ALLOWED = 22;
        public static final int CONNECTION_PENDING = 23;
        public static final int CONNECTION_BLOCKED = 24;
        public static final int CONNECTION_UNKNOWN = 25;
        public static final int CONNECTION_LOCAL_NET = 26;
        public static final int ROAMING_ACTIVE = 11;
        public static final int ROAMING_NOT_ACTIVE = 12;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

