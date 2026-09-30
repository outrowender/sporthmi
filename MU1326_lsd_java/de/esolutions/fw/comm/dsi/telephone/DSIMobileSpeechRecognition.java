/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

public interface DSIMobileSpeechRecognition {
    public static final String IPL_COMM_UUID = "db970b0f-3c89-5e05-bfb4-2413a989dec1";
    public static final String IPL_COMM_INTERFACE_KEY = "2b54b56d-1a82-5bc4-adc7-cee4cb037b15";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.27";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.27";

    public static interface Consts {
        public static final String VERSION = "2.11.27";
        public static final int RESULT_OK = 0;
        public static final int RESULT_ABORTED = 1;
        public static final int RESULT_ERROR_UNSPECIFIED = 2;
        public static final int RESULT_ERROR_SPEECHRECOGNITION_NOT_STARTED = 3;
        public static final int RESULT_ERROR_SPEECH_RECOGNITION_NOT_AVAILABLE = 4;
        public static final int RESULT_ERROR_SPEECH_RECOGNITION_ALREADY_ACTIVE = 5;
        public static final int MOBILESPEECHRECOGNITIONSTATUS_NOT_ACTIVE = 0;
        public static final int MOBILESPEECHRECOGNITIONSTATUS_ACTIVE = 1;
        public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_NOT_AVAILABLE = 0;
        public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_AVAILABLE = 1;
        public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_UNKNOWN = 2;
        public static final int MOBILESPEECHRECOGNITIONTYPE_UNKNOWN = 0;
        public static final int MOBILESPEECHRECOGNITIONTYPE_GENERIC = 1;
        public static final int MOBILESPEECHRECOGNITIONTYPE_SIRI = 2;
        public static final int MOBILESPEECHRECOGNITIONTYPE_GOOGLE_NOW = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

