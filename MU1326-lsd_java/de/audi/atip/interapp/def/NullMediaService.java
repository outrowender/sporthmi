/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.log.LogChannel;

public class NullMediaService
extends NullService
implements IMediaService {
    public NullMediaService(LogChannel logChannel) {
        super(logChannel, "MediaService");
    }

    @Override
    public int getTerminalID() {
        super.log();
        return 0;
    }

    @Override
    public void activateSource(int n, int n2) {
        super.log();
    }
}

