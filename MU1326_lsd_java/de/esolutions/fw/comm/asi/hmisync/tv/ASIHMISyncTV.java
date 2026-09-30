/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public interface ASIHMISyncTV {
    public static final String IPL_COMM_UUID = "3b9b7c34-a5a9-4acd-a935-dde0b43bf263";
    public static final String IPL_COMM_INTERFACE_KEY = "625d5dc3-8ed0-5a34-9759-b22cba16e480";
    public static final String IPL_COMM_INTERFACE_VERSION = "3.4.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final byte TV_TMK_YELLOW = 0;
        public static final byte TV_TMK_GREEN = 1;
        public static final byte TV_TMK_RED = 2;
        public static final byte TV_TMK_BLUE = 3;
        public static final byte TV_TMK_ENTER = 4;
        public static final byte TV_TMK_HOME = 5;
        public static final byte TV_TMK_JS_NORTH = 6;
        public static final byte TV_TMK_JS_SOUTH = 7;
        public static final byte TV_TMK_JS_WEST = 8;
        public static final byte TV_TMK_JS_EAST = 9;
        public static final byte TV_TMK_NUM1 = 10;
        public static final byte TV_TMK_NUM2 = 11;
        public static final byte TV_TMK_NUM3 = 12;
        public static final byte TV_TMK_NUM4 = 13;
        public static final byte TV_TMK_NUM5 = 14;
        public static final byte TV_TMK_NUM6 = 15;
        public static final byte TV_TMK_NUM7 = 16;
        public static final byte TV_TMK_NUM8 = 17;
        public static final byte TV_TMK_NUM9 = 18;
        public static final byte TV_TMK_NUM0 = 19;
        public static final byte TV_TMK_STOP = 20;
        public static final byte TV_TMK_MIX_MODE = 21;
        public static final byte TV_TMK_ZOOM_MODE = 22;
        public static final byte TV_TMK_PAGEFLIP_UP = 23;
        public static final byte TV_TMK_PAGEFLIP_DOWN = 24;
        public static final byte TV_TMK_PAGEFLIP_WEST = 25;
        public static final byte TV_TMK_PAGEFLIP_EAST = 26;
        public static final byte TV_TMK_BACK = 27;
        public static final byte TV_TMK_NEXT = 28;
        public static final byte TV_TMK_PREVIOUS = 29;
        public static final byte TV_TMK_SETUP = 30;
        public static final byte TV_TMK_MENU = 31;
        public static final byte TV_TMK_JOYST_NORTHEAST = 32;
        public static final byte TV_TMK_JOYST_NORTHWEST = 33;
        public static final byte TV_TMK_JOYST_SOUTHEAST = 34;
        public static final byte TV_TMK_JOYST_SOUTHWEST = 35;
        public static final byte TV_TMK_NUM = 36;
        public static final byte TV_TMK_START = 37;
        public static final byte TV_TMK_MIX_OFF = 38;
        public static final byte TV_TMK_D = 39;
        public static final byte TV_TMK_SCREEN = 40;
        public static final byte TV_TMK_MODE = 41;
        public static final byte TV_TMK_ZOOM_OFF = 42;
        public static final byte TV_TMK_RESET = 43;
        public static final byte TV_TMK_DELETE = 44;
        public static final byte TV_TMK_YES = 45;
        public static final byte TV_TMK_NO = 46;
        public static final byte TV_TMK_ZOOM_PLUS = 47;
        public static final byte TV_TMK_ZOOM_MINUS = 48;
        public static final byte TV_SEARCH_AUTO_UP = 0;
        public static final byte TV_SEARCH_AUTO_DOWN = 1;
        public static final byte TV_SEARCH_MANUAL_UP = 2;
        public static final byte TV_SEARCH_MANUAL_DOWN = 3;
        public static final byte TV_SEARCH_STATUS_RUNNING = 0;
        public static final byte TV_SEARCH_STATUS_IDLE = 1;
        public static final byte TV_SEARCH_STATUS_ABORTED = 2;
        public static final byte TV_SEARCH_STATUS_READY = 3;
        public static final byte TV_TM_UNAVAILABLE = 0;
        public static final byte TV_TM_OFF = 1;
        public static final byte TV_TM_TV = 2;
        public static final byte TV_TM_EPG = 3;
        public static final byte TV_TM_TELETEXT = 4;
        public static final byte TV_TM_SEARCH = 5;
        public static final byte TV_TM_DATABROADCAST_DVB = 6;
        public static final byte TV_TM_DATABROADCAST_ISDB = 7;
        public static final byte TV_TM_DATABROADCAST_DTMB_CMMB = 8;
        public static final byte TV_TM_DATABROADCAST_DMB = 9;
        public static final byte TV_TM_DATABROADCAST_ATSC = 10;
        public static final byte TV_TM_DATABROADCAST_1 = 11;
        public static final byte TV_TM_DATABROADCAST_2 = 12;
        public static final byte TV_TM_BWS = 13;
        public static final byte TV_TM_SLS_DLS = 14;
        public static final byte TV_TM_TXT = 15;
        public static final byte TV_TM_CAS = 16;
        public static final byte TV_TM_VISUAL_AUDIO = 17;
        public static final byte TV_TM_ENGINEERING = 18;
        public static final byte TV_TM_AV = 19;
        public static final byte TV_TM_INIT_TV = 20;
        public static final byte TV_TM_INIT_AV = 21;
        public static final byte TV_TM_OTHER = 127;
        public static final int TV_STATION_FLAG_UNAVAILABLE = 0;
        public static final int TV_STATION_FLAG_LOADING = 1;
        public static final int TV_STATION_FLAG_AVAILABLE = 2;
        public static final long TV_STATE_MUTE_MASK = 3L;
        public static final long TV_STATE_MUTE_OK = 0L;
        public static final long TV_STATE_MUTE_DROP_OUT = 1L;
        public static final long TV_STATE_MUTE_NO_RECEPTION = 2L;
        public static final long TV_STATE_MUTE_NO_AUDIO_SERVICE = 3L;
        public static final long TV_CONFIG_LINKING = 1L;
        public static final long TV_CONFIG_AV_SRC = 2L;
        public static final long TV_CONFIG_TV_NORM = 4L;
        public static final long TV_CONFIG_AUDIO_CHANNELS = 8L;
        public static final long TV_CONFIG_VIDEO_FORMAT = 16L;
        public static final long TV_CONFIG_AV_NORM = 32L;
        public static final long TV_CONFIG_AV_FORMAT = 64L;
        public static final long TV_CONFIG_SUBTITLE = 128L;
        public static final long TV_CONFIG_EWS = 256L;
        public static final long TV_CONFIG_LOGO_LIST = 512L;
        public static final long TV_CONFIG_CAS = 1024L;
        public static final long TV_CONFIG_SKIP = 2048L;
        public static final long TV_CONFIG_VISUAL_AUDIO = 4096L;
        public static final long TV_CONFIG_LIST_SORTING = 8192L;
        public static final long TV_CONFIG_PARENTAL_CONTROL = 16384L;
        public static final long TV_CONFIG_TM_TELETEXT = 32768L;
        public static final long TV_CONFIG_TM_DVB = 65536L;
        public static final long TV_CONFIG_TM_ISDB = 131072L;
        public static final long TV_CONFIG_TM_DTMB = 262144L;
        public static final long TV_CONFIG_TM_DMB = 524288L;
        public static final long TV_CONFIG_TM_ATSC = 0x100000L;
        public static final long TV_CONFIG_TM_DB1 = 0x200000L;
        public static final long TV_CONFIG_TM_DB2 = 0x400000L;
        public static final long TV_CONFIG_TM_BWS = 0x800000L;
        public static final long TV_CONFIG_TM_SLS = 0x1000000L;
        public static final long TV_CONFIG_TM_TXT = 0x2000000L;
        public static final long TV_CONFIG_TM_CAS = 0x4000000L;
        public static final long TV_CONFIG_TM_EPG = 0x8000000L;
        public static final long TV_CONFIG_TM_VISUAL_AUDIO = 0x10000000L;
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 12;
        public static final short updateRequestIDs = 20;
        public static final short updateReplyIDs = 19;
        public static final short updateStationInfo = 23;
        public static final short updateActiveStationInfo = 21;
        public static final short updateActiveTVStationState = 22;
        public static final short updateTunerConfig = 24;
        public static final short updatePanelKeySet = 14;
        public static final short updateSeekStatus = 16;
        public static final short updateTerminalMode = 18;
        public static final short updateParentalSettings = 15;

        public static short[] getIDs() {
            return new short[]{12, 20, 19, 23, 21, 22, 24, 14, 16, 18, 15};
        }
    }

    public static class RequestIDs {
        public static final short setActiveStation = 7;
        public static final short logonToTV = 4;
        public static final short logoffFromTV = 3;
        public static final short sendPressedPanelKey = 6;
        public static final short searchChannel = 5;
        public static final short setTerminalMode = 11;
        public static final short setNotification_8 = 8;
        public static final short setNotification_10 = 10;
        public static final short setNotification_9 = 9;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{7, 4, 3, 6, 5, 11, 8, 10, 9, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 12L;
        public static final long RequestIDs = 20L;
        public static final long ReplyIDs = 19L;
        public static final long StationInfo = 23L;
        public static final long ActiveStationInfo = 21L;
        public static final long ActiveTVStationState = 22L;
        public static final long TunerConfig = 24L;
        public static final long PanelKeySet = 14L;
        public static final long SeekStatus = 16L;
        public static final long TerminalMode = 18L;
        public static final long ParentalSettings = 15L;
    }
}

