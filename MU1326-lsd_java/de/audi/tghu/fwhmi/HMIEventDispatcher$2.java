/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.fwhmi.HMIEventDispatcher;

class HMIEventDispatcher$2
implements TimerListener {
    private final /* synthetic */ HMIEventDispatcher this$0;

    HMIEventDispatcher$2(HMIEventDispatcher hMIEventDispatcher) {
        this.this$0 = hMIEventDispatcher;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        String[] stringArray = this.this$0.getStatisticData();
        HMIEventDispatcher.access$400(this.this$0).log(1078071040, "%1 - %2 - %3", (Object)stringArray[0], (Object)stringArray[1], (Object)stringArray[2]);
    }
}

