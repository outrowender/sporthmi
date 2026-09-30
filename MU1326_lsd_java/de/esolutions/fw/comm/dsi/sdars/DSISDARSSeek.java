/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars;

public interface DSISDARSSeek {
    public static final String IPL_COMM_UUID = "9e54d97e-d65c-5f83-a944-5384734faa03";
    public static final String IPL_COMM_INTERFACE_KEY = "af95dcaf-b043-5eed-846c-b5ed68028411";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.20";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.20";

    public static interface Consts {
        public static final String VERSION = "2.11.20";
        public static final int RESETTYPE_TO_DEFAULT = 1;
        public static final int TYPEOFCONTENT_UNKNOWN = 0;
        public static final int TYPEOFCONTENT_SONGARTIST = 1;
        public static final int TYPEOFCONTENT_LEAGUE = 2;
        public static final int TYPEOFCONTENT_TEAM = 3;
        public static final int TYPEOFCONTENT_TRAFFICWX = 4;
        public static final int SEEKCONTENTID_UNLINKED = 0;
        public static final int SEEKTYPE_UNKNOWN = 0;
        public static final int SEEKTYPE_SONG = 1;
        public static final int SEEKTYPE_ARTIST = 2;
        public static final int SEEKTYPE_LEAGUE = 3;
        public static final int SEEKTYPE_TEAMA = 4;
        public static final int SEEKTYPE_TEAMB = 5;
        public static final int SEEKTYPE_TRAFFICWX = 6;
        public static final int SEEKINFO_UNDEFINED = 0;
        public static final int SEEKINFO_SHORTARTISTNAME = 1;
        public static final int SEEKINFO_LONGARTISTNAME = 2;
        public static final int SEEKINFO_SHORTPROGRAMTITLE = 3;
        public static final int SEEKINFO_LONGPROGRAMTITLE = 4;
        public static final int SEEKINFO_SHORTTEAMA = 5;
        public static final int SEEKINFO_LONGTEAMA = 6;
        public static final int SEEKINFO_SHORTTEAMB = 7;
        public static final int SEEKINFO_LONGTEAMB = 8;
        public static final int SEEKINFO_NAMETEAMA = 9;
        public static final int SEEKINFO_NICKNAMETEAMA = 10;
        public static final int SEEKINFO_ABBREVIATIONTEAMA = 11;
        public static final int SEEKINFO_NAMETEAMB = 12;
        public static final int SEEKINFO_NICKNAMETEAMB = 13;
        public static final int SEEKINFO_ABBREVIATIONTEAMB = 14;
        public static final int SEEKINFO_LEAGUE_NAME = 15;
        public static final int SEEKINFO_LEAGUE_ABBREVIATION = 16;
        public static final int STATE_ACTIVATED = 1;
        public static final int STATE_INACTIVATED = 2;
        public static final int SEEKCOMMAND_ADD = 1;
        public static final int SEEKCOMMAND_REMOVE = 2;
        public static final int SEEKCOMMANDRESULT_OK = 1;
        public static final int SEEKCOMMANDRESULT_NOK = 2;
        public static final int SEEKMANAGEACTION_ACTIVATE = 1;
        public static final int SEEKMANAGEACTION_DEACTIVATE = 2;
        public static final int SEEKMANAGEACTION_DELETE = 3;
        public static final int SEEKMANAGEMENTRESULT_OK = 1;
        public static final int SEEKMANAGEMENTRESULT_NOK = 2;
        public static final int ALERTTYPE_START = 1;
        public static final int ALERTTYPE_END = 2;
        public static final int RESETSEEKTYPE_UNDEFINED = 0;
        public static final int RESETSEEKTYPE_TO_DEFAULT = 1;
        public static final int RESETSEEKTYPE_ANONYMIZE = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

