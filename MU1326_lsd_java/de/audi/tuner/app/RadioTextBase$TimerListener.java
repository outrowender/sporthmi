/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.RadioTextBase;
import de.audi.tuner.app.RadioTextBase$1;

class RadioTextBase$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ RadioTextBase this$0;

    private RadioTextBase$TimerListener(RadioTextBase radioTextBase) {
        this.this$0 = radioTextBase;
    }

    @Override
    public void fireTimer(Timer timer) {
        RadioTextBase.access$200(this.this$0).setText(RadioTextBase.access$100(this.this$0));
        RadioTextBase.access$300(this.this$0).flush();
        RadioTextBase.access$402(this.this$0, false);
    }

    /* synthetic */ RadioTextBase$TimerListener(RadioTextBase radioTextBase, RadioTextBase$1 radioTextBase$1) {
        this(radioTextBase);
    }
}

