/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DABTuner$1;

class DABTuner$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ DABTuner this$0;

    private DABTuner$TunerActionProxyListenerExt(DABTuner dABTuner) {
        this.this$0 = dABTuner;
    }

    @Override
    public void stationSeekLeft() {
        DABTuner.access$1300((DABTuner)this.this$0).dabDSI.log(1078071040, "[DABTuner.TunerActionProxyListenerExt.stationSeekLeft] entered!");
        if (DABTuner.access$1100(this.this$0)) {
            this.this$0.abortSeek();
        }
    }

    @Override
    public void tunerAbortScan() {
        DABTuner.access$1300((DABTuner)this.this$0).dabDSI.log(1078071040, "[DABTuner.TunerActionProxyListenerExt.tunerAbortScan] entered!");
        if (DABTuner.access$1400(this.this$0)) {
            this.this$0.forceStationListUpdate(false);
        }
    }

    @Override
    public void hmiActivatedTuner() {
        DABTuner.access$1300((DABTuner)this.this$0).dabDSI.log(1078071040, "[DABTuner.TunerActionProxyListenerExt.hmiActivatedTuner] entered!");
    }

    @Override
    public void hmiDeactivatedTuner() {
        DABTuner.access$1300((DABTuner)this.this$0).dabDSI.log(1078071040, "[DABTuner.TunerActionProxyListenerExt.hmiDeactivatedTuner] entered!");
    }

    /* synthetic */ DABTuner$TunerActionProxyListenerExt(DABTuner dABTuner, DABTuner$1 dABTuner$1) {
        this(dABTuner);
    }
}

