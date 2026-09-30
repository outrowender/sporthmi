/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

public interface MediaSlotInfo {
    public static final int MEDIATYPE_UNDEFINED = 0;
    public static final int MEDIATYPE_CDAUDIO = 1;
    public static final int MEDIATYPE_FILESYTEM = 2;
    public static final int MEDIATYPE_DVDV = 3;
    public static final int MEDIATYPE_DVDA = 4;
    public static final int MEDIATYPE_AUDIO_STREAM = 5;
    public static final int MEDIATYPE_VIDEO_STREAM = 6;
    public static final int MEDIATYPE_REMOTE_CONTROL_PLAYER = 7;
    public static final int MEDIATYPE_SYSTEM_UPDATE = 8;
    public static final int MEDIATYPE_NAVIGATION_DATABASE = 9;
    public static final int MEDIATYPE_IPOD = 10;

    public int getSlotIdx();

    public String getName();

    public String getMountPoint();

    public boolean isEmpty();

    public boolean isReadOnly();

    public int getType();

    public int getSourceType();

    public boolean isSyncedSource();
}

