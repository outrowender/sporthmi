/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$1;

class SeekActiveContentHandler$ActionProxyListener
extends TunerActionProxyListener {
    private final /* synthetic */ SeekActiveContentHandler this$0;

    private SeekActiveContentHandler$ActionProxyListener(SeekActiveContentHandler seekActiveContentHandler) {
        this.this$0 = seekActiveContentHandler;
    }

    @Override
    public void sdarsReplaceListLeft() {
        SeekActiveContentHandler.access$1500(this.this$0);
    }

    @Override
    public void hmiDeactivatedTuner() {
        SeekActiveContentHandler.access$1500(this.this$0);
    }

    /* synthetic */ SeekActiveContentHandler$ActionProxyListener(SeekActiveContentHandler seekActiveContentHandler, SeekActiveContentHandler$1 seekActiveContentHandler$1) {
        this(seekActiveContentHandler);
    }
}

