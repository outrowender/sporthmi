/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

public interface DSIUnifiedTuner {
    public static final String IPL_COMM_UUID = "38d5c860-7e89-5e0f-92f0-0597231d802f";
    public static final String IPL_COMM_INTERFACE_KEY = "62c2f93a-0678-562e-83c7-7e458ea295eb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public static interface Consts {
        public static final String VERSION = "2.11.36";
        public static final int DEVICETYPE_NONE = 1;
        public static final int DEVICETYPE_RU = 3;
        public static final int STATIONFOLLOWINGMODE_AUTO = 1;
        public static final int STATIONFOLLOWINGMODE_STAYANALOG = 2;
        public static final int STATIONFOLLOWINGMODE_STAYDIGITAL = 3;
        public static final int STATIONFOLLOWINGMODE_OFF = 4;
        public static final int SOFTLINKSWITCH_OFF = 0;
        public static final int SOFTLINKSWITCH_ON = 1;
        public static final int REGMODE_OFF = 0;
        public static final int REGMODE_ON = 1;
        public static final int REGMODE_AUTO = 2;
        public static final int AUDIOSTATUS_ANALOG = 1;
        public static final int AUDIOSTATUS_DIGITAL = 2;
        public static final int AUDIOSTATUS_MUTE = 3;
        public static final int LISTMODE_AUTO = 1;
        public static final int LISTMODE_SHOWALTERNATIVES = 2;
        public static final int TPAVAILABILITY_UNKNOWN = 0;
        public static final int TPAVAILABILITY_NO = 1;
        public static final int TPAVAILABILITY_DIRECT = 2;
        public static final int TPAVAILABILITY_LINKED = 3;
        public static final int SELECTSTATIONMODE_FM = 1;
        public static final int SELECTSTATIONMODE_DAB = 2;
        public static final int RADIOTEXTSOURCE_FM = 1;
        public static final int RADIOTEXTSOURCE_DAB = 2;
        public static final int SCROLLINGPS_UNKNOWN = 0;
        public static final int SCROLLINGPS_FALSE = 1;
        public static final int SCROLLINGPS_TRUE = 2;
        public static final int SELECTSTATIONSTATUS_UNDEFINED = 0;
        public static final int SELECTSTATIONSTATUS_RUNNING = 1;
        public static final int SELECTSTATIONSTATUS_DONE = 2;
        public static final int SELECTSTATIONSTATUS_ABORTED = 3;
        public static final int SELECTSTATIONSTATUS_FAILURE = 4;
        public static final int DEVICEUSAGE_AVAILABLE = 0;
        public static final int DEVICEUSAGE_USED = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

