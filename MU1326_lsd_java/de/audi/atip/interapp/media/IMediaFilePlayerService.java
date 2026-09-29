/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaFilePlayerSession;

public interface IMediaFilePlayerService {
    default public void open(IMediaFilePlayerSession iMediaFilePlayerSession) {
    }

    default public void close(IMediaFilePlayerSession iMediaFilePlayerSession) {
    }
}

