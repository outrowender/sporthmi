/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

public interface DSIDataConfiguration {
    public static final String IPL_COMM_UUID = "6f242ae7-d62e-555f-a51f-1b658fcd1390";
    public static final String IPL_COMM_INTERFACE_KEY = "dd69ea9b-1ce5-5e11-a4ed-663f5d66eb9a";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.14";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.14";

    public static interface Consts {
        public static final String VERSION = "2.11.14";
        public static final int RESULT_RESULT_OK = 0;
        public static final int RESULT_RESULT_ABORTED = 1;
        public static final int RESULT_ERROR_GENERAL = 2;
        public static final int RESULT_ERROR_PROFILE_NOT_EXISTS = 3;
        public static final int RESULT_ERROR_NOT_SUPPORTED = 4;
        public static final int RESULT_ERROR_MAX_PROFILES = 5;
        public static final int RESULT_ERROR_DENIED = 6;
        public static final int RESULT_ERROR_CONNECTION_REFUSED = 7;
        public static final int RESULT_ERROR_APPLICATION_NOT_EXISTS = 8;
        public static final int CONNECTIONMODE_AUTOMATIC = 0;
        public static final int CONNECTIONMODE_MANUAL = 1;
        public static final int CONNECTIONMODE_NEVER = 2;
        public static final int REQUEST_ON = 1;
        public static final int REQUEST_OFF = 2;
        public static final int ROAMINGSTATE_ROAMING_ACTIVE = 0;
        public static final int ROAMINGSTATE_ROAMING_DEACTIVE = 1;
        public static final int DATAAUTHENTICATION_NORMAL = 0;
        public static final int DATAAUTHENTICATION_SECURED = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

