/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface IAnnouncementStateService {
    public static final String ANN_STATE_CLIENT_ID = "ANN_STATE_CLIENT_ID";
    public static final Integer PHONE_RINGTONE = new Integer(0);
    public static final Integer TA = new Integer(1);
    public static final Integer NAVI = new Integer(2);
    public static final int PHONE_MUTE = 0;
    public static final int PHONE_DEMUTE = 1;
    public static final int TA_ANN_OFF = 10;
    public static final int TA_ANN_FM = 11;
    public static final int TA_ANN_FM_DAB = 12;
    public static final int NAVI_ANN_COMPLETE = 20;
    public static final int NAVI_ANN_COMPACT = 21;
    public static final int NAVI_ANN_TRAFFIC = 22;
    public static final int NAVI_ANN_OFF = 23;

    public void setAnnouncementState(int var1);
}

