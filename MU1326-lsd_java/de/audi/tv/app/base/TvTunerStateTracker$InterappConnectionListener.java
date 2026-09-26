/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$1;
import de.audi.tv.app.interapp.IInterappConnectionListener;

class TvTunerStateTracker$InterappConnectionListener
implements IInterappConnectionListener {
    private final /* synthetic */ TvTunerStateTracker this$0;

    private TvTunerStateTracker$InterappConnectionListener(TvTunerStateTracker tvTunerStateTracker) {
        this.this$0 = tvTunerStateTracker;
    }

    @Override
    public void onGotInterappConnection() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(13);
    }

    @Override
    public void onLostInterappConnection() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(14);
    }

    /* synthetic */ TvTunerStateTracker$InterappConnectionListener(TvTunerStateTracker tvTunerStateTracker, TvTunerStateTracker$1 tvTunerStateTracker$1) {
        this(tvTunerStateTracker);
    }
}

