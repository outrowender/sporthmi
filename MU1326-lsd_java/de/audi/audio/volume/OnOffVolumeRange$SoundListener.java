/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.audio.intra.DefaultSoundListener;
import de.audi.audio.volume.OnOffVolumeRange;
import de.audi.audio.volume.OnOffVolumeRange$1;

class OnOffVolumeRange$SoundListener
extends DefaultSoundListener {
    private final /* synthetic */ OnOffVolumeRange this$0;

    private OnOffVolumeRange$SoundListener(OnOffVolumeRange onOffVolumeRange) {
        this.this$0 = onOffVolumeRange;
    }

    @Override
    public void updateVolume(int n, int n2, int n3) {
        OnOffVolumeRange.access$100(this.this$0, n, n2, n3);
    }

    @Override
    public void updateVolumeRange(int n, int n2) {
        OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(-2137614336, "%1.SoundListener.updateVolumeRange] min:%2, max:%3", (Object)OnOffVolumeRange.access$200(this.this$0), (long)n, (long)n2);
        this.this$0.updateLimits(n, n2);
        OnOffVolumeRange.access$402(this.this$0, n);
        OnOffVolumeRange.access$502(this.this$0, n2);
    }

    /* synthetic */ OnOffVolumeRange$SoundListener(OnOffVolumeRange onOffVolumeRange, OnOffVolumeRange$1 onOffVolumeRange$1) {
        this(onOffVolumeRange);
    }
}

