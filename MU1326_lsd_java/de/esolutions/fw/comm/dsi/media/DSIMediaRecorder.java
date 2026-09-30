/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

public interface DSIMediaRecorder {
    public static final String IPL_COMM_UUID = "31aeac40-9014-5c16-af5d-f77598bbb5b9";
    public static final String IPL_COMM_INTERFACE_KEY = "efe392c7-7424-5995-a658-1fb2cc8b2a75";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public static interface Consts {
        public static final String VERSION = "2.11.52";
        public static final int IMPORTSTATUS_IDLE = 0;
        public static final int IMPORTSTATUS_IMPORTING = 1;
        public static final int IMPORTSTATUS_PRE_PROCESSING = 2;
        public static final int IMPORTSTATUS_POST_PROCESSING = 3;
        public static final int IMPORTSTATUS_SUCCESS = 4;
        public static final int IMPORTSTATUS_ABORTED = 5;
        public static final int IMPORTSTATUS_SUSPEND = 6;
        public static final int IMPORTSTATUS_READY_FOR_SELECTION = 7;
        public static final int IMPORTSTATUS_READY_FOR_RESUME = 8;
        public static final int DELETIONSTATUS_IDLE = 0;
        public static final int DELETIONSTATUS_DELETING = 1;
        public static final int DELETIONSTATUS_PRE_PROCESSING = 2;
        public static final int DELETIONSTATUS_POST_PROCESSING = 3;
        public static final int DELETIONSTATUS_SUCCESS = 4;
        public static final int DELETIONSTATUS_ABORTED = 5;
        public static final int DELETIONSTATUS_FINISHED_WITH_ERRORS = 6;
        public static final int DELETIONSTATUS_READY_FOR_SELECTION = 7;
        public static final int ENCODINGQUALITY_MAX = 0;
        public static final int ENCODINGQUALITY_HIGH = 1;
        public static final int ENCODINGQUALITY_MEDIUM = 2;
        public static final int ENCODINGQUALITY_LOW = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

