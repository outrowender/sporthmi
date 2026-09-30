/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

public interface DSITunerAnnouncement {
    public static final String IPL_COMM_UUID = "ee3f6934-dd48-5603-bf9a-11ccfd95c0a4";
    public static final String IPL_COMM_INTERFACE_KEY = "9bf19f4c-9eb4-5099-a836-01deaaa1c281";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public static interface Consts {
        public static final String VERSION = "2.11.36";
        public static final int ANNOUNCEMENTTYPE_UNDEFINED = 0;
        public static final int ANNOUNCEMENTTYPE_FM_TA = 1;
        public static final int ANNOUNCEMENTTYPE_FM_PTY31 = 2;
        public static final int ANNOUNCEMENTTYPE_FM_EON_TA = 3;
        public static final int ANNOUNCEMENTTYPE_DAB_ALARM = 4;
        public static final int ANNOUNCEMENTTYPE_DAB_TRAFFIC = 5;
        public static final int ANNOUNCEMENTTYPE_DAB_TRANSPORT = 6;
        public static final int ANNOUNCEMENTTYPE_DAB_WARNING = 7;
        public static final int ANNOUNCEMENTTYPE_DAB_NEWS = 8;
        public static final int ANNOUNCEMENTTYPE_DAB_AREA_WEATHER = 9;
        public static final int ANNOUNCEMENTTYPE_DAB_EVENT_ANNOUNCEMENT = 10;
        public static final int ANNOUNCEMENTTYPE_DAB_SPECIAL_EVENT = 11;
        public static final int ANNOUNCEMENTTYPE_DAB_PROGRAM_INFORMATION = 12;
        public static final int ANNOUNCEMENTTYPE_DAB_SPORT_REPORT = 13;
        public static final int ANNOUNCEMENTTYPE_DAB_FINANCIAL_REPORT = 14;
        public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_1 = 15;
        public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_2 = 16;
        public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_3 = 17;
        public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_4 = 18;
        public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_5 = 19;
        public static final int ANNOUNCEMENTTYPE_NONE = 20;
        public static final int ANNOUNCEMENTTYPE_ALL = 21;
        public static final int ANNOUNCEMENTTYPE_DAB_SEAMLESS_FM_TA = 22;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

