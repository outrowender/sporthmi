/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$1;
import de.audi.tv.app.settings.parental.IChildLockListener;

class TvTunerStateTracker$ChildLockListener
implements IChildLockListener {
    private final /* synthetic */ TvTunerStateTracker this$0;

    private TvTunerStateTracker$ChildLockListener(TvTunerStateTracker tvTunerStateTracker) {
        this.this$0 = tvTunerStateTracker;
    }

    @Override
    public void onChildLockEnabled() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(0);
    }

    @Override
    public void onChildLockDisabled() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(1);
    }

    @Override
    public void parentalLevelSettingChanged(int n) {
        TvTunerStateTracker.access$700((TvTunerStateTracker)this.this$0).childLockListener.parentalLevelSettingChanged(n);
    }

    /* synthetic */ TvTunerStateTracker$ChildLockListener(TvTunerStateTracker tvTunerStateTracker, TvTunerStateTracker$1 tvTunerStateTracker$1) {
        this(tvTunerStateTracker);
    }
}

