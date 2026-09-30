/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver;

public interface DSIKombiPictureServer {
    public static final String IPL_COMM_UUID = "e2ec2c1a-6feb-5795-ad64-808237e9eb04";
    public static final String IPL_COMM_INTERFACE_KEY = "b5b5ee5e-67a7-517b-8bd4-22d8ed778502";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.4";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.4";

    public static interface Consts {
        public static final String VERSION = "2.11.4";
        public static final int SOURCETYPE_NOSOURCE = 0;
        public static final int SOURCETYPE_FM = 1;
        public static final int SOURCETYPE_AM = 2;
        public static final int SOURCETYPE_DAB = 3;
        public static final int SOURCETYPE_SDARS_XM = 4;
        public static final int SOURCETYPE_SDARS_SIRIUS = 5;
        public static final int SOURCETYPE_CD = 6;
        public static final int SOURCETYPE_CD_CHANGER = 7;
        public static final int SOURCETYPE_DVD = 8;
        public static final int SOURCETYPE_TV = 9;
        public static final int SOURCETYPE_HDD = 10;
        public static final int SOURCETYPE_SD = 11;
        public static final int SOURCETYPE_TPMEMO_TIM = 12;
        public static final int SOURCETYPE_AUX_IN_AUDIO = 13;
        public static final int SOURCETYPE_AUX_IN_VIDEO = 14;
        public static final int SOURCETYPE_PORTABLE_DEVICE = 15;
        public static final int SOURCETYPE_GENERIC_PLAYER = 16;
        public static final int SOURCETYPE_AM_TI = 17;
        public static final int SOURCETYPE_DVD_CHANGER = 18;
        public static final int SOURCETYPE_USB = 19;
        public static final int SOURCETYPE_JUKEBOX = 20;
        public static final int SOURCETYPE_BT_STREAM = 21;
        public static final int SOURCETYPE_BT_RCP = 22;
        public static final int SOURCETYPE_DVB_VIDEO = 23;
        public static final int SOURCETYPE_DVB_AUDIO = 24;
        public static final int SOURCETYPE_FLASHMEMORY = 25;
        public static final int SOURCETYPE_AUX_IN_VIDEO_TV = 32;
        public static final int SOURCETYPE_HDMI = 33;
        public static final int SOURCETYPE_ONLINE_MASS_STORAGE = 28;
        public static final int SOURCETYPE_ONLINE_RADIO = 35;
        public static final int SOURCETYPE_UNKNOWN = 255;
        public static final int COVERARTTYPE_NOPICTURE = 0;
        public static final int COVERARTTYPE_NORMAL = 1;
        public static final int COVERARTTYPE_DEFAULT = 2;
        public static final int ICONTYPE_ACTIVESOURCE = 0;
        public static final int ICONTYPE_SOURCELIST = 1;
        public static final int PHONEINSTANCE_MAIN = 0;
        public static final int PHONEINSTANCE_FIRST = 1;
        public static final int PHONEINSTANCE_SECOND = 2;
        public static final int PHONEINSTANCE_THIRD = 3;
        public static final int ID_INVALID = 0;
        public static final int ID_UNKNOWN = 65535;
        public static final int ADDRESSTYPE_BAP = 0;
        public static final int ADDRESSTYPE_MOST = 1;
        public static final int IDTYPE_COVERART = 0;
        public static final int IDTYPE_ADDRESSBOOKCONTACT = 1;
        public static final int IDTYPE_STATIONART = 2;
        public static final int CALLID_NOCALL = 254;
        public static final int CALLID_UNKNOWN = 255;
        public static final int ACTIVECALLPICTURETYPE_NOPICTURE = 0;
        public static final int ACTIVECALLPICTURETYPE_CONTACT = 1;
        public static final int ACTIVECALLPICTURETYPE_INFO = 2;
        public static final int ACTIVECALLPICTURETYPE_SERVICE = 3;
        public static final int ACTIVECALLPICTURETYPE_EMERGENCY = 4;
        public static final int ACTIVECALLPICTURETYPE_CONFERENCE = 5;
        public static final int ACTIVECALLPICTURETYPE_DEFAULT = 6;
        public static final int ADBCONTACTPICTURETYPES_NOPICTURE = 0;
        public static final int ADBCONTACTPICTURETYPES_CONTACT = 1;
        public static final int ADBCONTACTPICTURETYPES_DEFAULT = 2;
        public static final int STATIONARTTYPE_NOPICTURE = 0;
        public static final int STATIONARTTYPE_NORMAL = 1;
        public static final int STATIONARTTYPE_DEFAULT = 2;
        public static final int AVAILABLEPICTURESOURCES_ONLINEAVAILABLE = 1;
        public static final int AVAILABLEPICTURESOURCES_AUDIOAVAILABLE = 2;
        public static final int AVAILABLEPICTURESOURCES_NAVIGATIONAVAILABLE = 4;
        public static final int AVAILABLEPICTURESOURCES_TELEPHONEAVAILABLE = 8;
        public static final int AVAILABLEPICTURESOURCES_PICNAVAVAILABLE = 16;
        public static final int AVAILABLEPICTURESOURCES_BRANDINGAVAILABLE = 32;
        public static final int LISTPOSTYPE_ARBITRARY = 0;
        public static final int LISTPOSTYPE_8BYTE = 1;
        public static final int PSSOURCETYPE_ONLINE = 0;
        public static final int PSSOURCETYPE_AUDIO = 1;
        public static final int PSSOURCETYPE_NAVIGATION = 2;
        public static final int PSSOURCETYPE_TELEPHONE = 3;
        public static final int PSSOURCETYPE_PICNAV = 4;
        public static final int PSSOURCETYPE_BRANDING = 5;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

