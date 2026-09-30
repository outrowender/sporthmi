/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

public interface DSIWLAN {
    public static final String IPL_COMM_UUID = "cb957d6d-4fc4-57ce-9169-f70096df25aa";
    public static final String IPL_COMM_INTERFACE_KEY = "99c7079e-21cf-55ef-9908-8802a5f2a7d7";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.14";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.14";

    public static interface Consts {
        public static final String VERSION = "2.11.14";
        public static final int CRYPTOMODELS_CM_PLAINTEXT = 1;
        public static final int CRYPTOMODELS_CM_WEP64 = 2;
        public static final int CRYPTOMODELS_CM_WEP128 = 3;
        public static final int CRYPTOMODELS_CM_TKIP = 4;
        public static final int CRYPTOMODELS_CM_AES_CCMP = 5;
        public static final int CRYPTOMODELS_CM_WPA2_TKIP = 6;
        public static final int CRYPTOMODELS_CM_WPA2_AES_CCMP = 7;
        public static final int CRYPTOMODELS_CM_WPA_TKIP_CCMP = 8;
        public static final int CRYPTOMODELS_CM_WPA2_TKIP_CCMP = 9;
        public static final int CRYPTOMODELS_CM_WAPI = 10;
        public static final int AUTHENTICATIONMODELS_AM_NONE = 1;
        public static final int AUTHENTICATIONMODELS_AM_PSK = 2;
        public static final int AUTHENTICATIONMODELS_AM_EAP_802_1X = 3;
        public static final int ROLES_ROLE_AP = 1;
        public static final int ROLES_ROLE_CLIENT = 2;
        public static final int ROLES_ROLE_ADHOC = 3;
        public static final int ROLES_ROLE_AP_CLIENT_COMBINED = 4;
        public static final int RESULT_RESULT_OK = 0;
        public static final int RESULT_ERROR_NOT_SUPPORTED = 1;
        public static final int RESULT_ERROR_INVALID_PARAMETER = 2;
        public static final int RESULT_ERROR_REQUEST_TOO_EARLY = 3;
        public static final int RESULT_ERROR_INVALID_PASSWORD = 4;
        public static final int RESULT_RESULT_ABORTED = 5;
        public static final int RESULT_ERROR_GENERAL = 6;
        public static final int RESULT_RESULT_PASSWORD_REQUIRED = 7;
        public static final int RESULT_RESULT_TIMEOUT = 8;
        public static final int RESULT_ERROR_SECURITYISSUE = 9;
        public static final int ERRORS_OK = 0;
        public static final int ERRORS_ERROR_NOT_SUPPORTED = 1;
        public static final int ERRORS_ERROR_INVALID_PARAMETER = 2;
        public static final int ERRORS_ERROR_REQUEST_TOO_EARLY = 3;
        public static final int RFSTATES_RF_OFF = 0;
        public static final int RFSTATES_RF_ON = 1;
        public static final int RFSTATES_RF_NOT_OPERATIONAL = 2;
        public static final int RFSTATES_RF_NOT_OPERATIONAL_TEMPERATURE = 3;
        public static final int RFSTATES_RF_NOT_ALLOWED = 4;
        public static final int STARTUPSTATES_SUS_BOOTING = 1;
        public static final int STARTUPSTATES_SUS_READY = 2;
        public static final int STARTUPSTATES_SUS_FAILED = 3;
        public static final int WPSMODE_PUSHBUTTON = 1;
        public static final int WPSMODE_PIN = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

