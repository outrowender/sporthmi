/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.media;

public interface IOnlineMediaSession {
    public static final String STATE_NOT_READY = "MEDIA_NOT_READY";
    public static final String STATE_READY = "MEDIA_READY";
    public static final String STATE_PLAYING = "MEDIA_PLAYING";
    public static final String STATE_PAUSED = "MEDIA_PAUSED";
    public static final String STATE_CLOSED = "MEDIA_CLOSED";
    public static final String STATE_SEEK = "MEDIA_SEEKING";
    public static final String STATE_ERROR = "MEDIA_ERROR";
    public static final String STATE_EOF = "MEDIA_EOF";
    public static final String STATE_BUFFER_UNDERRUN = "MEDIA_BUFFER_UNDERRUN";
    public static final String BUFFER_FILLED = "MEDIA_BUFFER_FILLED";
    public static final String BUFFER_UNDEFINED = "MEDIA_BUFFER_UNDEFINED";
    public static final String BUFFER_UNDERRUN = "MEDIA_BUFFER_UNDERRUN";
    public static final String STATE_METADATA_CHANGED = "MEDIA_METADATA_CHANGED";
    public static final String BUFFER_FILLED_CHANGED = "MEDIA_BUFFER_FILLED_CHANGED";
    public static final String EVENT_SHUFFLE_CHANGED = "MEDIA_SHUFFLE_CHANGED";
    public static final String EVENT_REPEAT_CHANGED = "MEDIA_REPEAT_CHANGED";
    public static final String EVENT_SESSION_UPDATE = "MEDIA_SESSION_UPDATE";
    public static final String EVENT_SKIP = "MEDIA_SKIP";

    public String getState();

    public String getLastError();

    public String getServiceID();

    public int getTimeCurrent();

    public int getTimeTotal();

    public int getBufferLevel();

    public String getBufferStatus();

    public boolean isRepeatEnabled();

    public boolean isSeekEnabled();

    public boolean isSkipEnabled();

    public boolean isShuffleEnabled();

    public String getName();

    public long getChangedTrackId();

    public boolean isForward();

    public int getSkipCount();
}

