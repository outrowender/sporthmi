/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.audio.AudioEnv;
import de.audi.audio.CombiServiceHandler;
import de.audi.audio.InterAppHandler;
import de.audi.audio.volume.OnOffVolumeRange;
import java.util.Arrays;

public final class OnOffVolumeRange$Controller {
    private final OnOffVolumeRange[] onOffVolRanges = new OnOffVolumeRange[8];

    public OnOffVolumeRange$Controller(AudioEnv audioEnv, InterAppHandler interAppHandler, CombiServiceHandler combiServiceHandler) {
        OnOffVolumeRange onOffVolumeRange = new OnOffVolumeRange(audioEnv, interAppHandler, combiServiceHandler, 0);
        Arrays.fill(this.onOffVolRanges, onOffVolumeRange);
    }

    public OnOffVolumeRange getRange(int n) {
        return this.onOffVolRanges[n];
    }
}

