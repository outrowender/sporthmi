/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaSessionPlayer;

public interface IMediaPlayerSession {
    public static final int STATE_NOT_READY = 0;
    public static final int STATE_READY = 1;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PAUSED = 3;
    public static final int STATE_SEEKING = 4;
    public static final int STATE_STOPPED_END_OF_FILE_REACHED = 5;
    public static final int STATE_STOPPED_WITH_ERROR = 6;
    public static final int STATE_STOPPED = 7;

    public int getAudioConnection();

    public int getType();

    public String getName();

    public void onActive(IMediaSessionPlayer var1);

    public void onSuspend();

    public void onClose();

    public void updateState(int var1);

    public void updatePlayPosition(int var1, int var2);
}

