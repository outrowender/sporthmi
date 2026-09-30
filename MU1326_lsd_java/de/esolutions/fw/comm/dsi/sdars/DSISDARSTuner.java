/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars;

public interface DSISDARSTuner {
    public static final String IPL_COMM_UUID = "71545be7-a6cd-5b11-8d6f-8ad74622d1d2";
    public static final String IPL_COMM_INTERFACE_KEY = "1cf54f88-f4f8-527a-a836-8da4ae327e83";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.20";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.20";

    public static interface Consts {
        public static final String VERSION = "2.11.20";
        public static final int UNDEFINEDVALUES_SID = 255;
        public static final int UNDEFINEDVALUES_STATION_NUMBER = 255;
        public static final int UNDEFINEDVALUES_CATEGORY_NUMBER = 255;
        public static final int UNDEFINEDVALUES_SIGNAL = 0;
        public static final int STATIONSELECTIONMODE_SID = 4;
        public static final int SELECTSTATIONSTATUS_UNDEFINED = 0;
        public static final int SELECTSTATIONSTATUS_RUNNING = 1;
        public static final int SELECTSTATIONSTATUS_ABORTED = 2;
        public static final int SELECTSTATIONSTATUS_DONE = 3;
        public static final int SELECTSTATIONSTATUS_INVALID = 4;
        public static final int SELECTSTATIONSTATUS_NOT_SUBSCRIBED = 5;
        public static final int SELECTSTATIONSTATUS_GCI_UPDATE_RUNNING = 6;
        public static final int SUBSCRIPTION_UNDEFINED = 0;
        public static final int SUBSCRIPTION_UNSUBSCRIBED = 1;
        public static final int SUBSCRIPTION_SUBSCRIBED = 2;
        public static final int SUBSCRIPTION_SUSPENDALERT = 3;
        public static final int SUBSCRIPTION_SUSPENDED = 4;
        public static final int EPGFLAG_UNDEFINED = 0;
        public static final int EPGFLAG_FEATURED = 1;
        public static final int EPGFLAG_HIGHLIGHTED = 2;
        public static final int EPGFLAG_LIVE = 4;
        public static final int EPGFLAG_NEW = 8;
        public static final int AUDIOSTATUS_UNDEFINED = 0;
        public static final int AUDIOSTATUS_MUTE_ON = 1;
        public static final int AUDIOSTATUS_MUTE_OFF = 2;
        public static final int LISTUPDATESTATUS_UNDEFINED = 0;
        public static final int LISTUPDATESTATUS_RUNNING = 1;
        public static final int LISTUPDATESTATUS_LIST_STABLE = 2;
        public static final int UPDATESTATUS_UNDEFINED = 0;
        public static final int UPDATESTATUS_RUNNING = 1;
        public static final int UPDATESTATUS_STABLE = 2;
        public static final int SIGNALQUALITY_UNDEFINED = 0;
        public static final int SIGNALQUALITY_NO_SIGNAL = 1;
        public static final int SIGNALQUALITY_WEAK = 2;
        public static final int SIGNALQUALITY_GOOD = 3;
        public static final int SIGNALQUALITY_EXCELLENT = 4;
        public static final int SIGNALSTATUS_UNDEFINED = 0;
        public static final int SIGNALSTATUS_NOT_PRESENT = 1;
        public static final int SIGNALSTATUS_PRESENT = 2;
        public static final int ANTENNASTATUS_UNDEFINED = 0;
        public static final int ANTENNASTATUS_NOT_CONNECTED = 1;
        public static final int ANTENNASTATUS_CONNECTED = 2;
        public static final int DEVICETYPE_UNDEFINED = 0;
        public static final int DEVICETYPE_NONE = 1;
        public static final int DEVICETYPE_UNKNOWN = 2;
        public static final int DEVICETYPE_RU = 3;
        public static final int DEVICETYPE_UNAVAILABLE = 4;
        public static final int RESETTYPE_UNDEFINED = 0;
        public static final int RESETTYPE_TO_DEFAULT = 1;
        public static final int AVAILABILITY_NOTAVAILABLE = 1;
        public static final int AVAILABILITY_AVAILABLE = 2;
        public static final int RESETTYPE_ANONYMIZE = 2;
        public static final int INFORMATION_UNKNOWN = 0;
        public static final int INFORMATION_EPGCHANNELLIST = 1;
        public static final int INFORMATION_RADIOTEXT2 = 2;
        public static final int INFORMATION_CHANNELART = 4;
        public static final int INFORMATION_BACKGROUNDART = 8;
        public static final int INFORMATION_ALBUMART = 16;
        public static final int INFORMATION_GENREART = 32;
        public static final int INFORMATION_STUDIOART = 64;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

