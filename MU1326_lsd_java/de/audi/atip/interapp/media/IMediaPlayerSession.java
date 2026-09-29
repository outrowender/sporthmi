/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaSessionPlayer;

public interface IMediaPlayerSession {
    public static final int STATE_NOT_READY;
    public static final int STATE_READY;
    public static final int STATE_PLAYING;
    public static final int STATE_PAUSED;
    public static final int STATE_SEEKING;
    public static final int STATE_STOPPED_END_OF_FILE_REACHED;
    public static final int STATE_STOPPED_WITH_ERROR;
    public static final int STATE_STOPPED;

    default public int getAudioConnection() {
    }

    default public int getType() {
    }

    default public String getName() {
    }

    default public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
    }

    default public void onSuspend() {
    }

    default public void onClose() {
    }

    default public void updateState(int n) {
    }

    default public void updatePlayPosition(int n, int n2) {
    }
}

