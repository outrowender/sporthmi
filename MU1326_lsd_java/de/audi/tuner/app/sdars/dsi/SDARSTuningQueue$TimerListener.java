/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.dsi.SDARSTuningQueue;
import de.audi.tuner.app.sdars.dsi.SDARSTuningQueue$1;

class SDARSTuningQueue$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ SDARSTuningQueue this$0;

    private SDARSTuningQueue$TimerListener(SDARSTuningQueue sDARSTuningQueue) {
        this.this$0 = sDARSTuningQueue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        SDARSTuningQueue.access$200(this.this$0).log(10000, "[SDARSTuningQueue.fireTimer] Tune takes too long (timeout:%1)!", timer.getDelay());
        Object object = SDARSTuningQueue.access$300(this.this$0);
        synchronized (object) {
            SDARSTuningQueue.access$402(this.this$0, false);
            if (SDARSTuningQueue.access$500(this.this$0) != 0) {
                SDARSTuningQueue.access$600(this.this$0, SDARSTuningQueue.access$500(this.this$0));
                SDARSTuningQueue.access$502(this.this$0, 0);
            }
        }
    }

    /* synthetic */ SDARSTuningQueue$TimerListener(SDARSTuningQueue sDARSTuningQueue, SDARSTuningQueue$1 sDARSTuningQueue$1) {
        this(sDARSTuningQueue);
    }
}

