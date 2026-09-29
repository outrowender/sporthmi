/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.volume.VolumeLimits;
import de.audi.audio.volume.VolumeLimits$1;
import de.esolutions.fw.util.commons.Buffer;

class VolumeLimits$Audiolistener
extends DefaultAudioListener {
    private final /* synthetic */ VolumeLimits this$0;

    private VolumeLimits$Audiolistener(VolumeLimits volumeLimits) {
        this.this$0 = volumeLimits;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateActiveConnection(int n, int n2) {
        Buffer buffer;
        Object object = VolumeLimits.access$200(this.this$0);
        synchronized (object) {
            VolumeLimits.access$302(this.this$0, n);
            buffer = VolumeLimits.access$400(this.this$0);
        }
        VolumeLimits.access$500(this.this$0).log(-2137614336, "[VolumeLimits.updateActiveConnection] %1", (Object)buffer);
    }

    /* synthetic */ VolumeLimits$Audiolistener(VolumeLimits volumeLimits, VolumeLimits$1 volumeLimits$1) {
        this(volumeLimits);
    }
}

