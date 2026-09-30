/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu;

public interface DSIAsiaTrafficInfoMenu {
    public static final String IPL_COMM_UUID = "fa4f10d9-2b63-564c-bbd7-535897ef84a4";
    public static final String IPL_COMM_INTERFACE_KEY = "cd138e00-16ad-5992-a972-9f622be59d0c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public static interface Consts {
        public static final String VERSION = "2.11.1";
        public static final int TRAFFICTYPE_UNKNOWN = 0;
        public static final int TRAFFICTYPE_DSRC_TRAFFIC_VOICE_MESSAGE = 1;
        public static final int TRAFFICTYPE_DSRC_VICS_TRAFFIC_MESSAGE = 2;
        public static final int TRAFFICTYPE_FM_PICTOGRAM = 3;
        public static final int TRAFFICTYPE_FM_TEXT = 4;
        public static final int TRAFFICTYPE_EMERGENCYEVENT = 5;
        public static final int TRAFFICTYPE_TRAFFICMINIMAP = 6;
        public static final int INTERRUPTTYPE_UNKNOWN = 0;
        public static final int INTERRUPTTYPE_BEACONLV1_EMERGENCY = 1;
        public static final int INTERRUPTTYPE_BEACONLV1_WARNING = 2;
        public static final int INTERRUPTTYPE_BEACONLV1_TEXT = 3;
        public static final int INTERRUPTTYPE_BEACONLV1_FIGURE = 4;
        public static final int INTERRUPTTYPE_FM_VICSLV1_EMERGENCY = 5;
        public static final int INTERRUPTTYPE_FM_VICSLV1_TEXT = 6;
        public static final int INTERRUPTTYPE_FM_VICSLV1_FIGURE = 7;
        public static final int INTERRUPTTYPE_DSRC_EMERGENCY_ID20 = 8;
        public static final int INTERRUPTTYPE_DSRC_SAFE_DRIVING_SUPPORT_ID36 = 9;
        public static final int INTERRUPTTYPE_DSRC_WARNING_INFORMATION_ID37 = 10;
        public static final int INTERRUPTTYPE_DSRC_SIMPLE_FIGURE_INFORMATION_ID23 = 11;
        public static final int INTERRUPTTYPE_DSRC_GENERAL_INFORMATION_ID38 = 12;
        public static final int INTERRUPTTYPE_DSRC_WIDE_RANGE_INFORMATION_ID22 = 13;
        public static final int INTERRUPTTYPE_DSRC_NEW_EMERGENCY_INFORMATION_ID49 = 14;
        public static final int INTERRUPTTYPE_DSRC_LOCAL_SAFE_DRIVING_SUPPORT_INFORMATION_ID52 = 15;
        public static final int INTERRUPTTYPE_DSRC_LOCAL_WARNING_INFORMATION_ID53 = 16;
        public static final int INTERRUPTTYPE_DSRC_LOCAL_GENERAL_INFORMATION_ID54 = 17;
        public static final int INTERRUPTTYPE_DSRC_ELECTRONIC_TRAFFIC_SIGN_INFORMATION_ID56 = 18;
        public static final int INTERRUPTTYPE_DSRC_OTHER_GENERAL_INFORMATION_ID59 = 19;
        public static final int INTERRUPTTYPE_DSRC_LONG_SENTENCE_READ_OUT_INFORMATION_ID39 = 20;
        public static final int INTERRUPTTYPE_TRAFFIC_MINI_MAP = 21;
        public static final int RECEPTIONSTATUS_UNKNOWN = 0;
        public static final int RECEPTIONSTATUS_DETECTING = 1;
        public static final int RECEPTIONSTATUS_RECEIVED = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

