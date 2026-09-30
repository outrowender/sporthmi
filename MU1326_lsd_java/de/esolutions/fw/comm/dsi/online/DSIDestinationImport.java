/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

public interface DSIDestinationImport {
    public static final String IPL_COMM_UUID = "6b656195-4771-5f51-b911-925109bca7da";
    public static final String IPL_COMM_INTERFACE_KEY = "c5552d41-a2e8-561f-9070-c1d68be3b2ca";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public static interface Consts {
        public static final String VERSION = "2.11.42";
        public static final int STATUS_OK = 0;
        public static final int ERROR_SERVER_NOT_AVAILABLE = 1000;
        public static final int ERROR_SERVER_DATA_FORMAT_INVALID = 1003;
        public static final int IMPORTSTATUS_OK_IN_PROGRESS = 3001;
        public static final int IMPORTSTATUS_OK_COMPLETED = 3002;
        public static final int IMPORTSTATUS_ERROR_OUT_OF_MEM = 3003;
        public static final int IMPORTSTATUS_ERROR_GENERIC = 3004;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

