/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextHistory$1;

class RadioTextHistory$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ RadioTextHistory this$0;

    private RadioTextHistory$TimerListener(RadioTextHistory radioTextHistory) {
        this.this$0 = radioTextHistory;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(RadioTextHistory.access$400(this.this$0))) {
            Object object = RadioTextHistory.access$500(this.this$0);
            synchronized (object) {
                boolean bl = RadioTextHistory.access$600(this.this$0);
                if (bl) {
                    RadioTextHistory.access$700(this.this$0);
                }
            }
        } else if (timer.equals(RadioTextHistory.access$800(this.this$0))) {
            RadioTextHistory.access$300(this.this$0).log(14808325, "[%1RadioTextHistory.TimerListener.fireTimer] newChoiceValue %2", (Object)RadioTextHistory.access$900(this.this$0), (Object)"RT_WAITING_TIMEOUT");
            this.this$0.models.setChoiceDataUpdateMediator(RadioTextHistory.access$1000(this.this$0), 2);
        }
    }

    /* synthetic */ RadioTextHistory$TimerListener(RadioTextHistory radioTextHistory, RadioTextHistory$1 radioTextHistory$1) {
        this(radioTextHistory);
    }
}

