/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.app.combi.CombiBAPServiceHandler$1;

class CombiBAPServiceHandler$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ CombiBAPServiceHandler this$0;

    private CombiBAPServiceHandler$TunerActionProxyListenerExt(CombiBAPServiceHandler combiBAPServiceHandler) {
        this.this$0 = combiBAPServiceHandler;
    }

    @Override
    public void manualTuneEntered() {
        CombiBAPServiceHandler.access$300(this.this$0, true);
    }

    @Override
    public void manualTuneLeft() {
        CombiBAPServiceHandler.access$300(this.this$0, false);
    }

    /* synthetic */ CombiBAPServiceHandler$TunerActionProxyListenerExt(CombiBAPServiceHandler combiBAPServiceHandler, CombiBAPServiceHandler$1 combiBAPServiceHandler$1) {
        this(combiBAPServiceHandler);
    }
}

