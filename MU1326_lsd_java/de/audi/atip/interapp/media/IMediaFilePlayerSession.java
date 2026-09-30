/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaPlayerSession;

public interface IMediaFilePlayerSession
extends IMediaPlayerSession {
    public static final int TYPE_BOARDBOOK = 0;
    public static final int TYPE_RINGTONE = 1;

    public void updateVideoContext(int var1);
}

