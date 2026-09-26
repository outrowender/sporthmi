/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AMFMTuner$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class AMFMTuner$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ AMFMTuner this$0;

    private AMFMTuner$TunerActionProxyListenerExt(AMFMTuner aMFMTuner) {
        this.this$0 = aMFMTuner;
    }

    @Override
    public void stationSeekLeft() {
        if (AMFMTuner.access$900(this.this$0)) {
            this.this$0.abortSeek();
        }
    }

    @Override
    public void tunerAbortScan() {
        if (this.this$0.isForcedStationListUpdateRunning()) {
            this.this$0.forceStationListUpdate(false);
        }
    }

    /* synthetic */ AMFMTuner$TunerActionProxyListenerExt(AMFMTuner aMFMTuner, AMFMTuner$1 aMFMTuner$1) {
        this(aMFMTuner);
    }
}

