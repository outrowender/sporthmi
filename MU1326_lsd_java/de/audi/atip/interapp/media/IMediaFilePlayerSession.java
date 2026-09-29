/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaPlayerSession;

public interface IMediaFilePlayerSession
extends IMediaPlayerSession {
    public static final int TYPE_BOARDBOOK;
    public static final int TYPE_RINGTONE;

    default public void updateVideoContext(int n) {
    }
}

