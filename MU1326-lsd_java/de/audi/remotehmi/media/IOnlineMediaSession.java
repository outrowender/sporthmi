/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.media;

public interface IOnlineMediaSession {
    public static final String STATE_NOT_READY;
    public static final String STATE_READY;
    public static final String STATE_PLAYING;
    public static final String STATE_PAUSED;
    public static final String STATE_CLOSED;
    public static final String STATE_SEEK;
    public static final String STATE_ERROR;
    public static final String STATE_EOF;
    public static final String STATE_BUFFER_UNDERRUN;
    public static final String BUFFER_FILLED;
    public static final String BUFFER_UNDEFINED;
    public static final String BUFFER_UNDERRUN;
    public static final String STATE_METADATA_CHANGED;
    public static final String BUFFER_FILLED_CHANGED;
    public static final String EVENT_SHUFFLE_CHANGED;
    public static final String EVENT_REPEAT_CHANGED;
    public static final String EVENT_SESSION_UPDATE;
    public static final String EVENT_SKIP;

    default public String getState() {
    }

    default public String getLastError() {
    }

    default public String getServiceID() {
    }

    default public int getTimeCurrent() {
    }

    default public int getTimeTotal() {
    }

    default public int getBufferLevel() {
    }

    default public String getBufferStatus() {
    }

    default public boolean isRepeatEnabled() {
    }

    default public boolean isSeekEnabled() {
    }

    default public boolean isSkipEnabled() {
    }

    default public boolean isShuffleEnabled() {
    }

    default public String getName() {
    }

    default public long getChangedTrackId() {
    }

    default public boolean isForward() {
    }

    default public int getSkipCount() {
    }
}

