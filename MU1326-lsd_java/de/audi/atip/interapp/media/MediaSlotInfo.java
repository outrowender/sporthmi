/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

public interface MediaSlotInfo {
    public static final int MEDIATYPE_UNDEFINED;
    public static final int MEDIATYPE_CDAUDIO;
    public static final int MEDIATYPE_FILESYTEM;
    public static final int MEDIATYPE_DVDV;
    public static final int MEDIATYPE_DVDA;
    public static final int MEDIATYPE_AUDIO_STREAM;
    public static final int MEDIATYPE_VIDEO_STREAM;
    public static final int MEDIATYPE_REMOTE_CONTROL_PLAYER;
    public static final int MEDIATYPE_SYSTEM_UPDATE;
    public static final int MEDIATYPE_NAVIGATION_DATABASE;
    public static final int MEDIATYPE_IPOD;

    default public int getSlotIdx() {
    }

    default public String getName() {
    }

    default public String getMountPoint() {
    }

    default public boolean isEmpty() {
    }

    default public boolean isReadOnly() {
    }

    default public int getType() {
    }

    default public int getSourceType() {
    }

    default public boolean isSyncedSource() {
    }
}

