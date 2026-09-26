/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.sound.SoundHandler;

class SoundHandler$ActionProxyListenerExt
extends ActionProxyListener {
    private final /* synthetic */ SoundHandler this$0;

    SoundHandler$ActionProxyListenerExt(SoundHandler soundHandler) {
        this.this$0 = soundHandler;
        super(0);
    }

    @Override
    public void balanceFaderLeft() {
        this.this$0.getBalanceFader(this.terminalID).setActiveStatus(0);
        if (SoundHandler.access$000(this.this$0).isPorsche()) {
            this.this$0.getBalanceFader(this.terminalID).writeBackModelValue();
        }
    }

    @Override
    public void balanceFaderEntered() {
        if (SoundHandler.access$000(this.this$0).isPorsche()) {
            this.this$0.getBalanceFader(this.terminalID).writeBackModelValue();
        }
    }
}

