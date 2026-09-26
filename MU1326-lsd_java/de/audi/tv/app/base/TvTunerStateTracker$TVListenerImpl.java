/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

class TvTunerStateTracker$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ TvTunerStateTracker this$0;

    private TvTunerStateTracker$TVListenerImpl(TvTunerStateTracker tvTunerStateTracker) {
        this.this$0 = tvTunerStateTracker;
    }

    @Override
    public void updateMessageService(int n) {
        boolean bl = n == 1;
        TvTunerStateTracker.access$600(this.this$0).sendMessage(bl ? 9 : 10);
        if (n == 3) {
            TvTunerStateTracker.access$600(this.this$0).sendMessage(15);
        }
    }

    @Override
    public void updateTunerState(int n) {
        boolean bl = n == 1;
        TvTunerStateTracker.access$600(this.this$0).sendMessage(bl ? 6 : 7);
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(8, startUpConfig);
    }

    /* synthetic */ TvTunerStateTracker$TVListenerImpl(TvTunerStateTracker tvTunerStateTracker, TvTunerStateTracker$1 tvTunerStateTracker$1) {
        this(tvTunerStateTracker);
    }
}

