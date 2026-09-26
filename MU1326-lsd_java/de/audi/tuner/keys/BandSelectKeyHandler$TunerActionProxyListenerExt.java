/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.keys.BandSelectKeyHandler;
import de.audi.tuner.keys.BandSelectKeyHandler$1;

class BandSelectKeyHandler$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ BandSelectKeyHandler this$0;

    private BandSelectKeyHandler$TunerActionProxyListenerExt(BandSelectKeyHandler bandSelectKeyHandler) {
        this.this$0 = bandSelectKeyHandler;
    }

    @Override
    public void tunTmpBandChangeEntered() {
        this.this$0.logger.hmi.log(-2137614336, "[BandSelectKeyHandler#tunTmpBandChangeEntered], isBandChangeAllowed = %1, isTunerVisible = %2", this.this$0.status.isPowerStateON(), this.this$0.status.isTunerVisible());
        if (this.this$0.status.isPowerStateON() && this.this$0.status.isTunerVisible()) {
            this.this$0.status.setTmpScreenActive(true);
            BandSelectKeyHandler.access$300(this.this$0, BandSelectKeyHandler.access$200(this.this$0));
            BandSelectKeyHandler.access$202(this.this$0, false);
        } else {
            this.this$0.logger.hmi.log(-2137614336, "Standby active or tuner hidden -> Do nothing");
            this.this$0.models.getChoiceModel(-410582784).setStatus(1);
        }
    }

    @Override
    public void tunTmpBandChangeLeft() {
        this.this$0.logger.hmi.log(-2137614336, "[BandSelectKeyHandler#tunTmpBandChangeLeft]");
        this.this$0.status.setTmpScreenActive(false);
        BandSelectKeyHandler.access$402(this.this$0, -1);
        BandSelectKeyHandler.access$202(this.this$0, true);
    }

    /* synthetic */ BandSelectKeyHandler$TunerActionProxyListenerExt(BandSelectKeyHandler bandSelectKeyHandler, BandSelectKeyHandler$1 bandSelectKeyHandler$1) {
        this(bandSelectKeyHandler);
    }
}

