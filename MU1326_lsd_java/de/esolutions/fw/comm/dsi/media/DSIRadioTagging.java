/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

public interface DSIRadioTagging {
    public static final String IPL_COMM_UUID = "ad066dac-3241-5d34-b029-32d72a092966";
    public static final String IPL_COMM_INTERFACE_KEY = "70f39a0c-498b-54a6-9ada-1e10bc686e8e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public static interface Consts {
        public static final String VERSION = "2.11.52";
        public static final int TAGRESULT_OK = 0;
        public static final int TAGRESULT_ERROR = 1;
        public static final int TAGRESULT_TARGETMEMORY_FULL = 2;
        public static final int DEVICESTATUS_NODEVICE = 0;
        public static final int DEVICESTATUS_AVAILABLE = 1;
        public static final int DEVICESTATUS_NOT_SUPPORTED = 2;
        public static final int DEVICESTATUS_ERROR = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

