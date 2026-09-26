/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.SDARSLabels;

class SDARSLabels$DelayedGracenoteCoverartRequestTimerListener
extends DefaultTimerListener {
    private final int sIDForRegistration;
    private final /* synthetic */ SDARSLabels this$0;

    public SDARSLabels$DelayedGracenoteCoverartRequestTimerListener(SDARSLabels sDARSLabels, int n) {
        this.this$0 = sDARSLabels;
        this.sIDForRegistration = n;
    }

    @Override
    public void fireTimer(Timer timer) {
        SDARSLabels.access$800(this.this$0, this.sIDForRegistration);
    }
}

