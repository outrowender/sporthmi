/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler$1;
import java.util.ArrayList;
import java.util.List;

class DabFlatListHandler$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ DabFlatListHandler this$0;

    private DabFlatListHandler$TimerListener(DabFlatListHandler dabFlatListHandler) {
        this.this$0 = dabFlatListHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(DabFlatListHandler.access$1300(this.this$0))) {
            List list = DabFlatListHandler.access$500(this.this$0);
            synchronized (list) {
                DabFlatListHandler.access$1402(this.this$0, new ArrayList(0));
                DabFlatListHandler.access$700(this.this$0);
            }
        }
        List list = DabFlatListHandler.access$500(this.this$0);
        synchronized (list) {
            DabFlatListHandler.access$700(this.this$0);
        }
    }

    /* synthetic */ DabFlatListHandler$TimerListener(DabFlatListHandler dabFlatListHandler, DabFlatListHandler$1 dabFlatListHandler$1) {
        this(dabFlatListHandler);
    }
}

