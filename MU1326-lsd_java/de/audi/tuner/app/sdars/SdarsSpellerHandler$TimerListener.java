/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.SdarsSpellerHandler;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$1;

class SdarsSpellerHandler$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ SdarsSpellerHandler this$0;

    private SdarsSpellerHandler$TimerListener(SdarsSpellerHandler sdarsSpellerHandler) {
        this.this$0 = sdarsSpellerHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(SdarsSpellerHandler.access$900(this.this$0))) {
            SdarsSpellerHandler.access$700(this.this$0).clear();
            SdarsSpellerHandler.access$800(this.this$0, "");
        } else {
            SdarsSpellerHandler.access$1500(this.this$0).keyTyped(0, 0, 0);
        }
    }

    /* synthetic */ SdarsSpellerHandler$TimerListener(SdarsSpellerHandler sdarsSpellerHandler, SdarsSpellerHandler$1 sdarsSpellerHandler$1) {
        this(sdarsSpellerHandler);
    }
}

