/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sdis;

import de.audi.atip.interapp.sdis.ISDISBlockingListener;
import de.audi.tv.app.sdis.TVASIProvider;
import de.audi.tv.app.sdis.TVASIProvider$1;

class TVASIProvider$BlockingListener
implements ISDISBlockingListener {
    private final /* synthetic */ TVASIProvider this$0;

    private TVASIProvider$BlockingListener(TVASIProvider tVASIProvider) {
        this.this$0 = tVASIProvider;
    }

    @Override
    public void updateLockState(int n) {
    }

    @Override
    public void updateBlockState(int n) {
        TVASIProvider.access$300(this.this$0).log(1078071040, "[TVASIProvider.updateBlockState] %1", (long)n);
        if ((n & 1) == 1) {
            TVASIProvider.access$402(this.this$0, true);
        } else {
            TVASIProvider.access$402(this.this$0, false);
        }
    }

    /* synthetic */ TVASIProvider$BlockingListener(TVASIProvider tVASIProvider, TVASIProvider$1 tVASIProvider$1) {
        this(tVASIProvider);
    }
}

