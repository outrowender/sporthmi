/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.sdis;

import de.audi.app.tuner.sdis.TunerASIProvider;
import de.audi.app.tuner.sdis.TunerASIProvider$1;
import de.audi.atip.interapp.sdis.ISDISBlockingListener;

class TunerASIProvider$BlockingListener
implements ISDISBlockingListener {
    private final /* synthetic */ TunerASIProvider this$0;

    private TunerASIProvider$BlockingListener(TunerASIProvider tunerASIProvider) {
        this.this$0 = tunerASIProvider;
    }

    @Override
    public void updateLockState(int n) {
    }

    @Override
    public void updateBlockState(int n) {
        this.this$0.log.log(1078071040, "[TunerASIProvider.BlockingListener.updateBlockState] %1", (long)n);
        if ((n & 1) == 1) {
            TunerASIProvider.access$302(this.this$0, true);
        } else {
            TunerASIProvider.access$302(this.this$0, false);
        }
    }

    /* synthetic */ TunerASIProvider$BlockingListener(TunerASIProvider tunerASIProvider, TunerASIProvider$1 tunerASIProvider$1) {
        this(tunerASIProvider);
    }
}

