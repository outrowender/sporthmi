/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.services;

import de.audi.atip.audio.TerminalMapper;
import de.audi.atip.interapp.audio.IVolumeMapService;
import de.audi.audio.volume.VolumeMap;

public class VolumeMapService
implements IVolumeMapService {
    public int getVolume(int n, int n2) {
        return VolumeMap.INSTANCE.getVolume(TerminalMapper.toAudioTerminal(n2), n);
    }
}

