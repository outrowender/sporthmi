/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.SdarsSpellerHandler;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$1;

class SdarsSpellerHandler$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ SdarsSpellerHandler this$0;

    private SdarsSpellerHandler$TunerActionProxyListenerExt(SdarsSpellerHandler sdarsSpellerHandler) {
        this.this$0 = sdarsSpellerHandler;
    }

    @Override
    public void spellerLeft() {
        SdarsSpellerHandler.access$900(this.this$0).cancel();
        SdarsSpellerHandler.access$1000(this.this$0).cancel();
        SdarsSpellerHandler.access$700(this.this$0).clear();
        SdarsSpellerHandler.access$800(this.this$0, "");
    }

    /* synthetic */ SdarsSpellerHandler$TunerActionProxyListenerExt(SdarsSpellerHandler sdarsSpellerHandler, SdarsSpellerHandler$1 sdarsSpellerHandler$1) {
        this(sdarsSpellerHandler);
    }
}

