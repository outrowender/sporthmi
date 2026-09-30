/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner;

public interface DSITVTuner {
    public static final String IPL_COMM_UUID = "14a92548-0290-5316-bbad-c3d3c6c32a0f";
    public static final String IPL_COMM_INTERFACE_KEY = "5ba9aeef-717c-58a6-be8e-ebec30f4beb0";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public static interface Consts {
        public static final String VERSION = "2.11.9";
        public static final int TUNERSTATE_INACTIVE = 0;
        public static final int TUNERSTATE_ACTIVE = 1;
        public static final int RESPONSERESULT_FAILURE = 0;
        public static final int RESPONSERESULT_SUCCESS = 1;
        public static final int SOURCETYPE_TV = 0;
        public static final int SOURCETYPE_AV = 1;
        public static final int SEEKDIRECTION_UP = 1;
        public static final int SEEKDIRECTION_DOWN = 2;
        public static final int SEEKMODE_CHANNEL = 1;
        public static final int SEEKMODE_AUTO = 2;
        public static final int STYPE_UNKNOWN = 0;
        public static final int STYPE_DTV = 1;
        public static final int STYPE_DTV_HDTV = 2;
        public static final int STYPE_AUDIO = 3;
        public static final int STYPE_DATA = 4;
        public static final int STYPE_CAS_PAYTV = 5;
        public static final int STYPE_VISUAL_AUDIO = 6;
        public static final int STYPE_ISDB_SUBSERVICE_1 = 7;
        public static final int STYPE_ISDB_SUBSERVICE_2 = 8;
        public static final int STYPE_CMMB = 9;
        public static final int STYPE_CMMB_AUDIO = 10;
        public static final int STYPE_DTV_SUBSERVICE_2 = 11;
        public static final int STYPE_DTV_SUBSERVICE_3 = 12;
        public static final int STYPE_DTV_SUBSERVICE_4 = 13;
        public static final int STYPE_DTV_SUBSERVICE_5 = 14;
        public static final int STYPE_DUMMY = 15;
        public static final int MUTESTATE_AUDIO_GOOD = 0;
        public static final int MUTESTATE_DROP_OUT = 1;
        public static final int MUTESTATE_NO_RECEPTION = 2;
        public static final int MUTESTATE_NO_AUDIO_SERVICE = 3;
        public static final int SERVICEFLAG_NOT_AVAILABLE = 0;
        public static final int SERVICEFLAG_LOADING = 1;
        public static final int SERVICEFLAG_FULL_AVAILABLE = 2;
        public static final int AVNORM_AUTO = 0;
        public static final int AVNORM_PAL = 1;
        public static final int AVNORM_NTSC = 2;
        public static final int TERMINALMODE_OFF_TV_AV_MODE = 0;
        public static final int TERMINALMODE_TELETEXT = 1;
        public static final int TERMINALMODE_DB_DVB = 2;
        public static final int TERMINALMODE_DB_ISDB = 3;
        public static final int TERMINALMODE_DB_DTMB_CMMB = 4;
        public static final int TERMINALMODE_DB_DMB = 5;
        public static final int TERMINALMODE_DB_ATSC = 6;
        public static final int TERMINALMODE_DB1 = 7;
        public static final int TERMINALMODE_DB2 = 8;
        public static final int TERMINALMODE_BWS = 9;
        public static final int TERMINALMODE_SLS_DLS = 10;
        public static final int TERMINALMODE_TXT = 11;
        public static final int TERMINALMODE_CAS = 12;
        public static final int TERMINALMODE_EPG = 13;
        public static final int TERMINALMODE_VISUAL_AUDIO = 14;
        public static final int TERMINALMODE_TV_ENGINEERING = 15;
        public static final int SCREENMODE_MU_SPEED_DISCLAIMER_OFF = 0;
        public static final int SCREENMODE_MU_SPEED_DISCLAIMER_ON = 1;
        public static final int TMTOUCHPADBEHAVIOUR_NO_COORD = 0;
        public static final int TMTOUCHPADBEHAVIOUR_COORD = 1;
        public static final int TMTOUCHPADBEHAVIOUR_MAP_TO_JOYSTICK = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

