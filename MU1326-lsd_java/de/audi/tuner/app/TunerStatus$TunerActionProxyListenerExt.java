/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.TunerStatus$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class TunerStatus$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ TunerStatus this$0;

    private TunerStatus$TunerActionProxyListenerExt(TunerStatus tunerStatus) {
        this.this$0 = tunerStatus;
    }

    @Override
    public void stationListEntered() {
        TunerStatus.access$200(this.this$0).getChoiceModel(-595132160).setValue(TunerStatus.access$200(this.this$0).getActiveTuner());
    }

    /* synthetic */ TunerStatus$TunerActionProxyListenerExt(TunerStatus tunerStatus, TunerStatus$1 tunerStatus$1) {
        this(tunerStatus);
    }
}

