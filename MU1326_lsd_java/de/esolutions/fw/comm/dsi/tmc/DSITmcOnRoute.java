/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

public interface DSITmcOnRoute {
    public static final String IPL_COMM_UUID = "b700d80c-8e5f-5e0b-a9ca-81e66f057b76";
    public static final String IPL_COMM_INTERFACE_KEY = "c7282ec4-73cf-5263-9499-610f930a34a0";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public static interface Consts {
        public static final String VERSION = "2.11.36";
        public static final int TMCWARNINGMODE_OFF = 0;
        public static final int TMCWARNINGMODE_CONGESTION_ACOUSTICAL_ONLY = 1;
        public static final int TMCWARNINGMODE_CONGESTION_VISUAL_ONLY = 2;
        public static final int TMCWARNINGMODE_CONGESTION_ACOUSTIC_AND_VISUAL = 3;
        public static final int BLOCKREQUESTRESULTCODE_OK = 0;
        public static final int BLOCKREQUESTRESULTCODE_FAILED = 1;
        public static final int NAVICOREAVAILABLETOCHANGEBLOCKINGS_READY = 0;
        public static final int NAVICOREAVAILABLETOCHANGEBLOCKINGS_BUSY = 1;
        public static final int FLOWSEVERITY_UNKNOWN = 0;
        public static final int FLOWSEVERITY_FREE_FLOW = 1;
        public static final int FLOWSEVERITY_HEAVY_TRAFFIC = 2;
        public static final int FLOWSEVERITY_SLOW_TRAFFIC = 3;
        public static final int FLOWSEVERITY_QUEUING_TRAFFIC = 4;
        public static final int FLOWSEVERITY_QUEUING_STATIONARY = 5;
        public static final int FLOWSEVERITY_NO_TRAFFIC_FLOW = 6;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

