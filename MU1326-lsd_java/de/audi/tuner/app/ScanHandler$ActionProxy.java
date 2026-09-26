/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.ScanHandler;
import de.audi.tuner.app.ScanHandler$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class ScanHandler$ActionProxy
extends TunerActionProxyListener {
    private final /* synthetic */ ScanHandler this$0;

    private ScanHandler$ActionProxy(ScanHandler scanHandler) {
        this.this$0 = scanHandler;
    }

    @Override
    public void tunTmpBandChangeEntered() {
        this.this$0.abortScan();
    }

    @Override
    public void tunerAbortScan() {
        this.this$0.abortScan();
    }

    @Override
    public void hmiDeactivatedTuner() {
        this.this$0.abortScan();
    }

    /* synthetic */ ScanHandler$ActionProxy(ScanHandler scanHandler, ScanHandler$1 scanHandler$1) {
        this(scanHandler);
    }
}

