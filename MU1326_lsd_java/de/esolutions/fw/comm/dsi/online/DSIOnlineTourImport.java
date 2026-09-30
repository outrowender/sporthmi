/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

public interface DSIOnlineTourImport {
    public static final String IPL_COMM_UUID = "7797f1e4-6a7e-55d2-9334-e401df4fcfc5";
    public static final String IPL_COMM_INTERFACE_KEY = "18ed9baa-6e17-501d-a3b4-1c607288a1f5";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public static interface Consts {
        public static final String VERSION = "2.11.42";
        public static final int DOWNLOADSTATUS_SUCCESS = 0;
        public static final int DOWNLOADSTATUS_STARTED = 1;
        public static final int DOWNLOADSTATUS_DISMISSED = 2;
        public static final int DOWNLOADSTATUS_ERROR = 3;
        public static final int DOWNLOADSTATUS_ERROR_CONNECTIVITY = 4;
        public static final int IMPORTSTATUS_SUCCESS = 0;
        public static final int IMPORTSTATUS_FAILURE = 1;
        public static final int IMPORTSTATUS_ABORTED = 2;
        public static final int IMPORTSTATUS_ABORTED_POWERDOWN = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

