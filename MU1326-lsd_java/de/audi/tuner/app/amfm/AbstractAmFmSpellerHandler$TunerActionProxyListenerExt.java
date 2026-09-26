/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class AbstractAmFmSpellerHandler$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ AbstractAmFmSpellerHandler this$0;

    private AbstractAmFmSpellerHandler$TunerActionProxyListenerExt(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler) {
        this.this$0 = abstractAmFmSpellerHandler;
    }

    @Override
    public void spellerLeft() {
        AbstractAmFmSpellerHandler.access$400(this.this$0);
    }

    /* synthetic */ AbstractAmFmSpellerHandler$TunerActionProxyListenerExt(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler, AbstractAmFmSpellerHandler$1 abstractAmFmSpellerHandler$1) {
        this(abstractAmFmSpellerHandler);
    }
}

