/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABLabels;
import de.audi.tuner.app.dab.DABLabels$1;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;

class DABLabels$DsiDownListener
extends DABDsiDownInfo {
    private final /* synthetic */ DABLabels this$0;

    private DABLabels$DsiDownListener(DABLabels dABLabels) {
        this.this$0 = dABLabels;
    }

    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        DABLabels.access$202(this.this$0, dabStation);
        DABLabels.access$302(this.this$0, dabReceptionStatus);
        DABLabels.access$400(this.this$0, dabStation, dabReceptionStatus);
    }

    /* synthetic */ DABLabels$DsiDownListener(DABLabels dABLabels, DABLabels$1 dABLabels$1) {
        this(dABLabels);
    }
}

