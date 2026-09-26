/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.audio.intra.DefaultSoundListener;
import de.audi.audio.volume.VolumeLimits;
import de.audi.audio.volume.VolumeLimits$1;
import de.esolutions.fw.util.commons.Buffer;

class VolumeLimits$SoundListener
extends DefaultSoundListener {
    private final /* synthetic */ VolumeLimits this$0;

    private VolumeLimits$SoundListener(VolumeLimits volumeLimits) {
        this.this$0 = volumeLimits;
    }

    @Override
    public void updateActiveAmplifiers(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateVolumeRange(int n, int n2) {
        Buffer buffer;
        Object object = VolumeLimits.access$200(this.this$0);
        synchronized (object) {
            VolumeLimits.access$602(this.this$0, n);
            VolumeLimits.access$702(this.this$0, n2);
            buffer = VolumeLimits.access$400(this.this$0);
        }
        VolumeLimits.access$500(this.this$0).log(-2137614336, "[VolumeLimits.updateVolumeRange] %1", (Object)buffer);
    }

    /* synthetic */ VolumeLimits$SoundListener(VolumeLimits volumeLimits, VolumeLimits$1 volumeLimits$1) {
        this(volumeLimits);
    }
}

