/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface IAnnouncementStateService {
    public static final String ANN_STATE_CLIENT_ID;
    public static final Integer PHONE_RINGTONE;
    public static final Integer TA;
    public static final Integer NAVI;
    public static final int PHONE_MUTE;
    public static final int PHONE_DEMUTE;
    public static final int TA_ANN_OFF;
    public static final int TA_ANN_FM;
    public static final int TA_ANN_FM_DAB;
    public static final int NAVI_ANN_COMPLETE;
    public static final int NAVI_ANN_COMPACT;
    public static final int NAVI_ANN_TRAFFIC;
    public static final int NAVI_ANN_OFF;

    default public void setAnnouncementState(int n) {
    }

    static {
        PHONE_RINGTONE = new Integer(0);
        TA = new Integer(1);
        NAVI = new Integer(2);
    }
}

