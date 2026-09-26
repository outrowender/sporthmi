/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.amfm.HdTagging;
import de.audi.tuner.app.amfm.HdTagging$1;

class HdTagging$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ HdTagging this$0;

    private HdTagging$TimerListener(HdTagging hdTagging) {
        this.this$0 = hdTagging;
    }

    @Override
    public void fireTimer(Timer timer) {
        HdTagging.access$600(this.this$0);
    }

    /* synthetic */ HdTagging$TimerListener(HdTagging hdTagging, HdTagging$1 hdTagging$1) {
        this(hdTagging);
    }
}

