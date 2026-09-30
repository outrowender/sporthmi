/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

public interface IMediaService {
    public static final int SOURCE_CD_SINGLE = 1;
    public static final int SOURCE_CD_CHANGER = 2;
    public static final int SOURCE_DVD_SINGLE = 3;
    public static final int SOURCE_DVD_CHANGER = 4;
    public static final int SOURCE_SDCARD = 5;
    public static final int SOURCE_HDD = 6;
    public static final int SOURCE_TVTUNER = 7;
    public static final int SOURCE_AV_IN = 8;
    public static final int SOURCE_AUX = 9;
    public static final int SOURCE_USB = 10;
    public static final int SOURCE_BT = 11;
    public static final int SOURCE_WLAN = 12;
    public static final int SOURCE_ONLINE = 13;
    public static final int MEDIA_PLAYBACKSTATE_UNDEFINED = 0;
    public static final int MEDIA_PLAYBACKSTATE_PLAYING = 1;
    public static final int MEDIA_PLAYBACKSTATE_PAUSED = 2;
    public static final int MEDIA_PLAYBACKSTATE_SEEK_FORWARD = 3;
    public static final int MEDIA_PLAYBACKSTATE_SEEK_BACKWARD = 4;
    public static final int MEDIA_PLAYBACKSTATE_PLAYING_MENU = 5;
    public static final int MEDIA_PLAYBACKSTATE_STOPPED = 6;

    public int getTerminalID();

    public void activateSource(int var1, int var2);
}

