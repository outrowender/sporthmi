/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DabRadioTextHistory;
import de.audi.tuner.app.dab.DabRadioTextHistory$1;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;

class DabRadioTextHistory$DSIDownListener
extends DABDsiDownInfo {
    private final /* synthetic */ DabRadioTextHistory this$0;

    private DabRadioTextHistory$DSIDownListener(DabRadioTextHistory dabRadioTextHistory) {
        this.this$0 = dabRadioTextHistory;
    }

    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        DabRadioTextHistory.access$200(this.this$0, true);
    }

    /* synthetic */ DabRadioTextHistory$DSIDownListener(DabRadioTextHistory dabRadioTextHistory, DabRadioTextHistory$1 dabRadioTextHistory$1) {
        this(dabRadioTextHistory);
    }
}

