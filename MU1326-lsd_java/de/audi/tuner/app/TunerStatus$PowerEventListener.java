/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.TunerStatus$1;
import de.audi.tuner.ifc.IPowerEvent;

class TunerStatus$PowerEventListener
implements IPowerEvent {
    private final /* synthetic */ TunerStatus this$0;

    private TunerStatus$PowerEventListener(TunerStatus tunerStatus) {
        this.this$0 = tunerStatus;
    }

    @Override
    public void notifyPowerEvent(int n, int n2) {
        if (n2 < 8) {
            TunerStatus.access$300((TunerStatus)this.this$0)[n2] = n;
        }
        if (n2 == 0) {
            TunerStatus.access$300((TunerStatus)this.this$0)[7] = n;
        }
    }

    /* synthetic */ TunerStatus$PowerEventListener(TunerStatus tunerStatus, TunerStatus$1 tunerStatus$1) {
        this(tunerStatus);
    }
}

