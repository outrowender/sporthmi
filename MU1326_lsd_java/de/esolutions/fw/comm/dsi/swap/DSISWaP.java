/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap;

public interface DSISWaP {
    public static final String IPL_COMM_UUID = "b82b0691-ac00-5dac-8503-d963791ab441";
    public static final String IPL_COMM_INTERFACE_KEY = "83eb2cf5-0bdf-5136-8819-e2a5100f6116";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public static interface Consts {
        public static final String VERSION = "2.11.11";
        public static final int CRYPTERR_NOT_INITIALIZED = 0;
        public static final int CRYPTERR_OK = 1;
        public static final int CRYPTERR_READ_ERROR = 2;
        public static final int CRYPTERR_WRITE_ERROR = 3;
        public static final int CRYPTERR_CRYPTO_ERROR = 4;
        public static final int CRYPTERR_ALGORITHM_UNKNOWN = 5;
        public static final int CRYPTERR_WRONG_KEY_SIZE = 6;
        public static final int CRYPTERR_OUT_OF_MEMORY = 7;
        public static final int FSC_NOT_INITIALIZED = -1;
        public static final int FSC_OK = 0;
        public static final int FSC_INVALID_SIZE = 2;
        public static final int FSC_INVALID_FORMAT = 3;
        public static final int FSC_INVALID_CONTENT = 4;
        public static final int FSC_INVALID_SIGNATURE = 5;
        public static final int FSC_OTP_SWID_MISMATCH = 6;
        public static final int FSC_VIN_MISMATCH = 7;
        public static final int FSCSTATE_STATE_NOT_INITIALIZED = -1;
        public static final int FSCSTATE_LEGAL = 0;
        public static final int FSCSTATE_ILLEGAL = 1;
        public static final int FSCSTATE_SUPPORTED = 2;
        public static final int FSCSTATE_TEMP = 3;
        public static final int FSCSTATE_PERM = 4;
        public static final int MEDIUM_NOT_INITIALIZED = 0;
        public static final int MEDIUM_NFS = 1;
        public static final int MEDIUM_INTERNAL_DRIVE = 2;
        public static final int MEDIUM_USB_FS = 3;
        public static final int MEDIUM_SD_1 = 4;
        public static final int MEDIUM_SD_2 = 5;
        public static final int MEDIUM_CIFS = 6;
        public static final int MEDIUM_OTA = 7;
        public static final int MEDIUM_FS = 8;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

