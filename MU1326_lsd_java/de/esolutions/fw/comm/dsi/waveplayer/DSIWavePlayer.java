/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.waveplayer;

public interface DSIWavePlayer {
    public static final String IPL_COMM_UUID = "9846d1eb-d14c-58b0-88b2-e11d65778272";
    public static final String IPL_COMM_INTERFACE_KEY = "87c016b9-ed3b-5265-b3d7-b233684d480a";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.7";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.7";

    public static interface Consts {
        public static final String VERSION = "2.11.7";
        public static final int AUDIOMODE_START = 0;
        public static final int AUDIOMODE_REPEAT = 1;
        public static final int AUDIOMODE_ABORT = 2;
        public static final int AUDIOMODE_STARTED = 3;
        public static final int AUDIOMODE_STOPPED = 4;
        public static final int AUDIOMODE_ABORTED = 5;
        public static final int AUDIOMODE_ERROR_BUSY = 6;
        public static final int AUDIOMODE_ERROR_NOT_POSSIBLE = 7;
        public static final int AUDIOMODE_ERROR_REGISTRATION_MISSING = 8;
        public static final int AUDIOMODE_ERROR_INTERNAL = 9;
        public static final int AUDIOSTATE_ACTIVE = 0;
        public static final int AUDIOSTATE_IDLE = 1;
        public static final int TONEID_RINGTONE_1 = 0;
        public static final int TONEID_RINGTONE_2 = 1;
        public static final int TONEID_RINGTONE_3 = 2;
        public static final int TONEID_RINGTONE_4 = 3;
        public static final int TONEID_RINGTONE_5 = 4;
        public static final int TONEID_RINGTONE_6 = 5;
        public static final int TONEID_RINGTONE_7 = 6;
        public static final int TONEID_RINGTONE_8 = 7;
        public static final int TONEID_RINGTONE_9 = 8;
        public static final int TONEID_RINGTONE_10 = 9;
        public static final int TONEID_HEARTBEAT = 10;
        public static final int TONEID_STREETVIEW = 11;
        public static final int TONEID_SMS_MAIL = 12;
        public static final int TONEID_TOUCHSCREEN = 13;
        public static final int TONEID_BEEP = 14;
        public static final int TONEID_WARNING_1 = 15;
        public static final int TONEID_WARNING_2 = 16;
        public static final int TONEID_BEEP_2 = 17;
        public static final int TONEID_SMS_MAIL_2 = 18;
        public static final int TONEID_BEEP_3 = 19;
        public static final int TONEID_TOUCHSCREEN_2 = 20;
        public static final int TONEID_NAVPOI = 21;
        public static final int PLAYTONERESULT_SUCCESS = 0;
        public static final int PLAYTONERESULT_INVALID_TONE_ID = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

