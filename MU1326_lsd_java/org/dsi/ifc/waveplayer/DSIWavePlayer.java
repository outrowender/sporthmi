/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.waveplayer;

import org.dsi.ifc.base.DSIBase;

public interface DSIWavePlayer
extends DSIBase {
    public static final String VERSION = "2.11.7";
    public static final int RT_SETPLAYTONE = 1000;
    public static final int RT_AUDIOTRIGGER = 1001;
    public static final int RT_AUDIOTRIGGERDEFAULTTONE = 1002;
    public static final int ATTR_PLAYTONE = 1;
    public static final int ATTR_AUDIOREQUEST = 2;
    public static final int RP_SETPLAYTONE = 2000;
    public static final int RP_AUDIOTRIGGERRESPONSE = 2001;
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

    public void audioTrigger(int var1);

    public void audioTriggerDefaultTone(int var1);

    public void setPlayTone(int var1);
}

