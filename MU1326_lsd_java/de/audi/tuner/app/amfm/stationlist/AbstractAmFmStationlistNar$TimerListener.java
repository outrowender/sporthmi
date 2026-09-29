/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$1;

class AbstractAmFmStationlistNar$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ AbstractAmFmStationlistNar this$0;

    private AbstractAmFmStationlistNar$TimerListener(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        this.this$0 = abstractAmFmStationlistNar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(AbstractAmFmStationlistNar.access$300(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                AbstractAmFmStationlistNar.access$400(this.this$0).clear();
                this.this$0.doListUpdate(false);
            }
        }
        if (timer.equals(AbstractAmFmStationlistNar.access$500(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                AbstractAmFmStationlistNar.access$600(this.this$0).clear();
                this.this$0.doListUpdate(false);
            }
        }
        if (timer.equals(AbstractAmFmStationlistNar.access$700(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                if (AbstractAmFmStationlistNar.access$800(this.this$0) && !AbstractAmFmStationlistNar.access$900(this.this$0)) {
                    AbstractAmFmStationlistNar.access$802(this.this$0, false);
                    this.this$0.doListUpdate(false);
                }
            }
        }
    }

    /* synthetic */ AbstractAmFmStationlistNar$TimerListener(AbstractAmFmStationlistNar abstractAmFmStationlistNar, AbstractAmFmStationlistNar$1 abstractAmFmStationlistNar$1) {
        this(abstractAmFmStationlistNar);
    }
}

