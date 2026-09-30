/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.TIJPVolumeServiceListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullTIJPVolumeService
extends NullService
implements TIJPVolumeServiceListener {
    public NullTIJPVolumeService(LogChannel logChannel) {
        super(logChannel, "NullTIJPVolumeService");
    }

    public void abortReadOut() {
        this.log();
    }
}

