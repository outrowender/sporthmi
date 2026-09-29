/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.IVolumeLockService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullVolumeLockService
extends NullService
implements IVolumeLockService {
    public NullVolumeLockService(LogChannel logChannel) {
        super(logChannel, "IVolumeLockService");
    }

    @Override
    public boolean isActive(int n, int n2) {
        this.log("isActive");
        return false;
    }
}

