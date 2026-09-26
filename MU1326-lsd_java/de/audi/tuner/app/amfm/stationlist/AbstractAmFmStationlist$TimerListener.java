/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$1;

class AbstractAmFmStationlist$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ AbstractAmFmStationlist this$0;

    private AbstractAmFmStationlist$TimerListener(AbstractAmFmStationlist abstractAmFmStationlist) {
        this.this$0 = abstractAmFmStationlist;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(AbstractAmFmStationlist.access$500(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                AbstractAmFmStationlist.access$602(this.this$0, null);
                this.this$0.doListUpdate(false);
            }
        }
        if (timer.equals(AbstractAmFmStationlist.access$700(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                AbstractAmFmStationlist.access$802(this.this$0, null);
                this.this$0.doListUpdate(false);
            }
        }
        if (timer.equals(AbstractAmFmStationlist.access$900(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                if (AbstractAmFmStationlist.access$1000(this.this$0) && !AbstractAmFmStationlist.access$1100(this.this$0)) {
                    AbstractAmFmStationlist.access$1002(this.this$0, false);
                    this.this$0.doListUpdate(false);
                }
            }
        }
    }

    /* synthetic */ AbstractAmFmStationlist$TimerListener(AbstractAmFmStationlist abstractAmFmStationlist, AbstractAmFmStationlist$1 abstractAmFmStationlist$1) {
        this(abstractAmFmStationlist);
    }
}

