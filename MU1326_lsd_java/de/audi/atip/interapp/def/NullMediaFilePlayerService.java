/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;

public class NullMediaFilePlayerService
extends NullService
implements IMediaFilePlayerService {
    public NullMediaFilePlayerService(LogChannel logChannel) {
        super(logChannel, "NullMediaFilePlayerService");
    }

    @Override
    public void open(IMediaFilePlayerSession iMediaFilePlayerSession) {
        super.log("open");
    }

    @Override
    public void close(IMediaFilePlayerSession iMediaFilePlayerSession) {
        super.log("close");
    }
}

