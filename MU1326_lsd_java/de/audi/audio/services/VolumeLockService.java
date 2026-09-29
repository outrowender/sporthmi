/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.services;

import de.audi.atip.audio.TerminalMapper;
import de.audi.atip.interapp.audio.IVolumeLockService;
import de.audi.audio.store.VolumelockMap;

public class VolumeLockService
implements IVolumeLockService {
    @Override
    public boolean isActive(int n, int n2) {
        return VolumelockMap.INSTANCE.isActive(n, TerminalMapper.toAudioTerminal(n2));
    }
}

