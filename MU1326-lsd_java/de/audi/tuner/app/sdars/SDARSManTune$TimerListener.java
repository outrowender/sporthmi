/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSManTune$1;

class SDARSManTune$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ SDARSManTune this$0;

    private SDARSManTune$TimerListener(SDARSManTune sDARSManTune) {
        this.this$0 = sDARSManTune;
    }

    @Override
    public void fireTimer(Timer timer) {
        SDARSManTune.access$1100(this.this$0);
    }

    /* synthetic */ SDARSManTune$TimerListener(SDARSManTune sDARSManTune, SDARSManTune$1 sDARSManTune$1) {
        this(sDARSManTune);
    }
}

