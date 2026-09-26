/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.ISourceChanger;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$1;

class TvTunerStateTracker$SwitchSourceListener
implements ISourceChanger {
    private final /* synthetic */ TvTunerStateTracker this$0;

    private TvTunerStateTracker$SwitchSourceListener(TvTunerStateTracker tvTunerStateTracker) {
        this.this$0 = tvTunerStateTracker;
    }

    @Override
    public void switchSource(int n, boolean bl) {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(11, n);
    }

    /* synthetic */ TvTunerStateTracker$SwitchSourceListener(TvTunerStateTracker tvTunerStateTracker, TvTunerStateTracker$1 tvTunerStateTracker$1) {
        this(tvTunerStateTracker);
    }
}

