/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;

public interface IMediaOnlinePlayerService {
    default public void open(IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
    }

    default public void close(IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
    }
}

