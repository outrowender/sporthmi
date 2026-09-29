/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.interapp.audio.ATIPAudioService;
import de.audi.audio.AudioEnv;
import de.audi.audio.volume.OnOffVolumeRange;
import de.audi.audio.volume.OnOffVolumeRange$Controller;

public class ATIPAudioServiceImpl
implements ATIPAudioService {
    private final OnOffVolumeRange$Controller controller;
    private int defaultMinVolume;
    private int defaultMaxVolume;
    private AudioEnv env;

    public ATIPAudioServiceImpl(AudioEnv audioEnv, OnOffVolumeRange$Controller onOffVolumeRange$Controller) {
        this.env = audioEnv;
        this.controller = onOffVolumeRange$Controller;
    }

    @Override
    public void volumeMenuEntered(int n, int n2, boolean bl) {
        this.env.lcMain.log(-2137614336, "[ATIPAudioServiceImpl.volumeMenuEntered] min:%1 max:%2, mapOnOffToDDS: %3", (long)n, (long)n2, bl);
        OnOffVolumeRange onOffVolumeRange = this.controller.getRange(0);
        this.defaultMinVolume = onOffVolumeRange.getDefaultMin();
        this.defaultMaxVolume = onOffVolumeRange.getDefaultMax();
        onOffVolumeRange.updateLimits(n, n2);
        onOffVolumeRange.volumeMenuActive(bl);
    }

    @Override
    public void volumeMenuLeft() {
        this.env.lcMain.log(-2137614336, "[ATIPAudioServiceImpl.volumeMenuLeft] min:%1 max:%2", (long)this.defaultMinVolume, (long)this.defaultMaxVolume);
        OnOffVolumeRange onOffVolumeRange = this.controller.getRange(0);
        onOffVolumeRange.volumeMenuActive(false);
        onOffVolumeRange.updateLimits(this.defaultMinVolume, this.defaultMaxVolume);
    }
}

