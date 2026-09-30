/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

public interface DSIOnlineTraffic {
    public static final String IPL_COMM_UUID = "12bc15c1-5424-583d-92e1-5442fafc4f7f";
    public static final String IPL_COMM_INTERFACE_KEY = "f3a652c2-a019-53a6-b8d4-710ffeff48f3";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public static interface Consts {
        public static final String VERSION = "2.11.42";
        public static final int REQUEST_CONSUMER_READY = 1;
        public static final int REQUEST_WANTONLINETRAFFICDATA = 2;
        public static final int TRAFFICDATASTATUS_IDLE = 0;
        public static final int TRAFFICDATASTATUS_NO_DATA_AVAILABLE = 1;
        public static final int TRAFFICDATASTATUS_PREPARING_DATA = 2;
        public static final int TRAFFICDATASTATUS_DATA_AVAILABLE = 3;
        public static final int TRAFFICDATASTATUS_NO_DATA_FOR_THIS_AREA = 4;
        public static final int TRAFFICDATASTATUS_DISABLED = 5;
        public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_OK = 0;
        public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_BUSY = 1;
        public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_NOT_AVAILABLE = 2;
        public static final int ONLINETRAFFICCONSUMERSTATE_DATA_ERROR = 3;
        public static final int UPDATERATE_DATA_WANTED_STD_INTERVAL = 1;
        public static final int UPDATERATE_DATA_WANTED_SHORT_INTERVAL = 2;
        public static final int UPDATERATE_DATA_WANTED_IMMEDIATELY = 3;
        public static final int UPDATERATE_NOT_INTERESTED_IN_DATA = 0;
        public static final long FCDVALID_TIME = 1L;
        public static final long FCDVALID_POSITION = 2L;
        public static final long FCDVALID_FORMOFWAY = 4L;
        public static final long FCDVALID_FUNCTIONALROADCLASS = 8L;
        public static final long FCDVALID_ROADNUMBER = 16L;
        public static final long FCDVALID_HEADING = 32L;
        public static final long FCDVALID_SPEED = 64L;
        public static final long FCDVALID_TEMPERATURE = 128L;
        public static final long FCDVALID_RAIN = 256L;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

