/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FunctionWheelHandler;
import de.audi.tuner.app.amfm.FunctionWheelHandler$1;

class FunctionWheelHandler$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ FunctionWheelHandler this$0;

    private FunctionWheelHandler$TimerListener(FunctionWheelHandler functionWheelHandler) {
        this.this$0 = functionWheelHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        FunctionWheelHandler.access$500((FunctionWheelHandler)this.this$0).amfmDeepDebug.log(-2137614336, "[FWH.fireTimer] %1", (Object)timer.getName());
        if (timer.equals(FunctionWheelHandler.access$1300(this.this$0))) {
            AMFMStation aMFMStation = new AMFMStation();
            aMFMStation.frequency = FunctionWheelHandler.access$900(this.this$0);
            aMFMStation.pi = -1;
            aMFMStation.waveband = FunctionWheelHandler.access$1100((FunctionWheelHandler)this.this$0).waveband;
            aMFMStation.serviceId = 1;
            FunctionWheelHandler.access$1600(this.this$0).tuneStation(aMFMStation, true, false, 0);
            FunctionWheelHandler.access$1600((FunctionWheelHandler)this.this$0).audio.demute();
        } else {
            if (timer.equals(FunctionWheelHandler.access$700(this.this$0))) {
                Object object = FunctionWheelHandler.access$1700(this.this$0);
                synchronized (object) {
                    if (FunctionWheelHandler.access$1800(this.this$0) != null) {
                        FunctionWheelHandler.access$1400(this.this$0, FunctionWheelHandler.access$1800(this.this$0));
                        FunctionWheelHandler.access$1802(this.this$0, null);
                    }
                }
            }
            if (timer.equals(FunctionWheelHandler.access$800(this.this$0))) {
                Object object = FunctionWheelHandler.access$1700(this.this$0);
                synchronized (object) {
                    if (FunctionWheelHandler.access$1900(this.this$0) != null) {
                        FunctionWheelHandler.access$1400(this.this$0, new AMFMStation(FunctionWheelHandler.access$1900(this.this$0)));
                        FunctionWheelHandler.access$1902(this.this$0, null);
                    }
                }
            }
        }
    }

    /* synthetic */ FunctionWheelHandler$TimerListener(FunctionWheelHandler functionWheelHandler, FunctionWheelHandler$1 functionWheelHandler$1) {
        this(functionWheelHandler);
    }
}

