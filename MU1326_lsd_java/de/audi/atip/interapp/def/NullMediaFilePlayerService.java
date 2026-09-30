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

    public void open(IMediaFilePlayerSession iMediaFilePlayerSession) {
        super.log("open");
    }

    public void close(IMediaFilePlayerSession iMediaFilePlayerSession) {
        super.log("close");
    }
}

