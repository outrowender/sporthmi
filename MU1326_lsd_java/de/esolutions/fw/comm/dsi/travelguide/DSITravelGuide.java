/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide;

public interface DSITravelGuide {
    public static final String IPL_COMM_UUID = "375a0462-7d36-50c5-89ae-91e39a81851f";
    public static final String IPL_COMM_INTERFACE_KEY = "cc5c2ccc-acd7-501a-a3c3-4347cd1c5255";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public static interface Consts {
        public static final String VERSION = "2.11.0";
        public static final int RESULTCODE_OK = 0;
        public static final int RESULTCODE_ERROR = 1;
        public static final int RESULTCODE_NOT_OPERABLE = 2;
        public static final int RESULTCODE_UNSUPPORTED = 3;
        public static final int FAILUREREASON_NONE = 0;
        public static final int FAILUREREASON_UNSPECIFIED = 1;
        public static final int FAILUREREASON_MEMORY_FULL = 2;
        public static final int FAILUREREASON_DUPLICATE = 3;
        public static final int WINDOWSTEP_CURRENT_PAGE = 0;
        public static final int WINDOWSTEP_NEXT_PAGE = 1;
        public static final int WINDOWSTEP_PREVIOUS_PAGE = 2;
        public static final int WINDOWSTEP_FIRST_PAGE = 4;
        public static final int WINDOWSTEP_GOTO_POSITION = 6;
        public static final int LISTITEMSTATUS_AVAILABLE = 0;
        public static final int LISTITEMSTATUS_DOWNLOADING = 1;
        public static final int LISTITEMSTATUS_IMPORTING = 2;
        public static final int LISTITEMSTATUS_UPDATING = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

