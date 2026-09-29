/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler;

class AbstractAmFmSpellerHandler$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ AbstractAmFmSpellerHandler this$0;

    AbstractAmFmSpellerHandler$TimerListener(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler) {
        this.this$0 = abstractAmFmSpellerHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(this.this$0.clearTimer)) {
            AbstractAmFmSpellerHandler.access$400(this.this$0);
        } else {
            AbstractAmFmSpellerHandler.access$200(this.this$0);
        }
    }
}

