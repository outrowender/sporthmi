/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$1;

class TvTunerStateTracker$TVEventListenerImpl
extends TVEventDefaultListener {
    private final /* synthetic */ TvTunerStateTracker this$0;

    private TvTunerStateTracker$TVEventListenerImpl(TvTunerStateTracker tvTunerStateTracker) {
        this.this$0 = tvTunerStateTracker;
    }

    @Override
    public void makeFactoryReset() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(12);
    }

    /* synthetic */ TvTunerStateTracker$TVEventListenerImpl(TvTunerStateTracker tvTunerStateTracker, TvTunerStateTracker$1 tvTunerStateTracker$1) {
        this(tvTunerStateTracker);
    }
}

