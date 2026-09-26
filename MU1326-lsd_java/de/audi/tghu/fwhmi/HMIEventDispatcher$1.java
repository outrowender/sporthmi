/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.fwhmi.HMIEventDispatcher;

class HMIEventDispatcher$1
implements TimerListener {
    private final /* synthetic */ HMIEventDispatcher this$0;

    HMIEventDispatcher$1(HMIEventDispatcher hMIEventDispatcher) {
        this.this$0 = hMIEventDispatcher;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        HMIEventDispatcher.access$300(this.this$0).log(14808325, "Heartbeat!");
    }
}

