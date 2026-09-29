/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.content.media.fileplayer.AbstractPlayerSession;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;

public class FilePlayerSession
extends AbstractPlayerSession
implements IMediaFilePlayerSession {
    public FilePlayerSession(LogChannel logChannel, IMediaFilePlayerSession iMediaFilePlayerSession) {
        super(logChannel, iMediaFilePlayerSession);
    }

    @Override
    public void updateVideoContext(int n) {
        ((IMediaFilePlayerSession)this.clientSession).updateVideoContext(n);
    }
}

