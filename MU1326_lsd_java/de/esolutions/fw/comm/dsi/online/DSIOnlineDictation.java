/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

public interface DSIOnlineDictation {
    public static final String IPL_COMM_UUID = "82592248-678e-568c-8edd-2ba6fb084404";
    public static final String IPL_COMM_INTERFACE_KEY = "903c28c7-80c3-50cf-b8f5-e56b1ce25449";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public static interface Consts {
        public static final String VERSION = "2.11.42";
        public static final int STATUS_OK_INIT = 10;
        public static final int STATUS_OK_DICTATION_COMPLETE = 11;
        public static final int STATUS_OK_DICTATION_CANCELED = 12;
        public static final int STATUS_ERROR_CAR_HARDWARE = 21;
        public static final int STATUS_ERROR_CAR_DSI = 22;
        public static final int STATUS_ERROR_CAR_CONNECTIVITY_SETUP = 23;
        public static final int STATUS_ERROR_CAR_CONNECTIVITY_ERROR = 24;
        public static final int STATUS_ERROR_DICTATION_SSL_HANDSHAKE_FAILED = 31;
        public static final int STATUS_ERROR_DICTATION_TIMEOUT = 41;
        public static final int STATUS_ERROR_DICTATION_CONNECTION_CLOSED = 42;
        public static final int STATUS_ERROR_DICTATION_CONNECTION_REJECTED = 43;
        public static final int STATUS_ERROR_DICTATION_PARSE = 44;
        public static final int STATUS_ERROR_DICTATION_HOST_UNRESOLVABLE = 45;
        public static final int STATUS_ERROR_DICTATION_UNKNOWN_ERROR = 46;
        public static final int STATUS_ERROR_DICTATION_INVALID_INPUT = 47;
        public static final int STATUS_ERROR_DICTATION_URL_INVALID = 48;
        public static final int STATUS_ERROR_DICTATION_PROVIDER_TIMEOUT = 51;
        public static final int STATUS_ERROR_DICTATION_PROVIDER_CONNECTION_CLOSED = 52;
        public static final int STATUS_ERROR_DICTATION_PROVIDER_CONNECTION_REJECTED = 53;
        public static final int STATUS_ERROR_DICTATION_PROVIDER_PARSE = 54;
        public static final int STATUS_ERROR_DICTATION_PROVIDER_HOST_UNRESOLVABLE = 55;
        public static final int STATUS_ERROR_DICTATION_PROVIDER_UNKNOWN_ERROR = 56;
        public static final int STATUS_ERROR_LANGUAGE_NOT_SUPPORTED = 61;
        public static final int STATUS_ERROR_VOICE_RECOGNITION_FAILED = 62;
        public static final int STATUS_ERROR_PROFANITY_DETECTED = 63;
        public static final int STATUS_ERROR_DICTATION_DISABLED = 64;
        public static final int STATUS_ERROR_DICTATION_UPLOAD_FAILED = 71;
        public static final int STATUS_ERROR_DICTATION_CHECKSUM_FAILED = 72;
        public static final int STATUS_ERROR_DICTATION_FORCED_UPLOAD = 73;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

