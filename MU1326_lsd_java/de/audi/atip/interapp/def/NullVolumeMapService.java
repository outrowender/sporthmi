/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.IVolumeMapService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullVolumeMapService
extends NullService
implements IVolumeMapService {
    public NullVolumeMapService(LogChannel logChannel) {
        super(logChannel, "IVolumeMapService");
    }

    public int getVolume(int n, int n2) {
        this.log("getVolume");
        return 0;
    }
}

