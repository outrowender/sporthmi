/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

public interface IMediaService {
    public static final int SOURCE_CD_SINGLE;
    public static final int SOURCE_CD_CHANGER;
    public static final int SOURCE_DVD_SINGLE;
    public static final int SOURCE_DVD_CHANGER;
    public static final int SOURCE_SDCARD;
    public static final int SOURCE_HDD;
    public static final int SOURCE_TVTUNER;
    public static final int SOURCE_AV_IN;
    public static final int SOURCE_AUX;
    public static final int SOURCE_USB;
    public static final int SOURCE_BT;
    public static final int SOURCE_WLAN;
    public static final int SOURCE_ONLINE;
    public static final int MEDIA_PLAYBACKSTATE_UNDEFINED;
    public static final int MEDIA_PLAYBACKSTATE_PLAYING;
    public static final int MEDIA_PLAYBACKSTATE_PAUSED;
    public static final int MEDIA_PLAYBACKSTATE_SEEK_FORWARD;
    public static final int MEDIA_PLAYBACKSTATE_SEEK_BACKWARD;
    public static final int MEDIA_PLAYBACKSTATE_PLAYING_MENU;
    public static final int MEDIA_PLAYBACKSTATE_STOPPED;

    default public int getTerminalID() {
    }

    default public void activateSource(int n, int n2) {
    }
}

