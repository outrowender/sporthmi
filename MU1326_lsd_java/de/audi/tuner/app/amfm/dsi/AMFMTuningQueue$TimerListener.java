/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.amfm.dsi.AMFMTuningQueue;
import de.audi.tuner.app.amfm.dsi.AMFMTuningQueue$1;

class AMFMTuningQueue$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ AMFMTuningQueue this$0;

    private AMFMTuningQueue$TimerListener(AMFMTuningQueue aMFMTuningQueue) {
        this.this$0 = aMFMTuningQueue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        AMFMTuningQueue.access$200((AMFMTuningQueue)this.this$0).amfmDSI.log(10000, "[AMFMTuningQueue.fireTimer] Tune takes too long (timeout:%1)!", timer.getDelay());
        Object object = AMFMTuningQueue.access$300(this.this$0);
        synchronized (object) {
            if (AMFMTuningQueue.access$400(this.this$0) != 0) {
                AMFMTuningQueue.access$800(this.this$0, AMFMTuningQueue.access$400(this.this$0), AMFMTuningQueue.access$500(this.this$0), AMFMTuningQueue.access$600(this.this$0), AMFMTuningQueue.access$700(this.this$0));
                AMFMTuningQueue.access$402(this.this$0, 0);
            }
        }
    }

    /* synthetic */ AMFMTuningQueue$TimerListener(AMFMTuningQueue aMFMTuningQueue, AMFMTuningQueue$1 aMFMTuningQueue$1) {
        this(aMFMTuningQueue);
    }
}

