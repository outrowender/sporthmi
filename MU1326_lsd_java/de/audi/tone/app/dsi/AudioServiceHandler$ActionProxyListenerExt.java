/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.dsi;

import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.dsi.AudioServiceHandler;

class AudioServiceHandler$ActionProxyListenerExt
extends ActionProxyListener {
    private final /* synthetic */ AudioServiceHandler this$0;

    AudioServiceHandler$ActionProxyListenerExt(AudioServiceHandler audioServiceHandler) {
        this.this$0 = audioServiceHandler;
        super(0);
    }

    @Override
    public void demute() {
        this.this$0.releaseConnection(this.terminalID, 8);
    }
}

