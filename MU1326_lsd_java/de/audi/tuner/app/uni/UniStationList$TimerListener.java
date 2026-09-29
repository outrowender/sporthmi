/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.uni.UniStationList;
import de.audi.tuner.app.uni.UniStationList$1;
import java.util.List;

class UniStationList$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ UniStationList this$0;

    private UniStationList$TimerListener(UniStationList uniStationList) {
        this.this$0 = uniStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(UniStationList.access$1300(this.this$0))) {
            List list = UniStationList.access$600(this.this$0);
            synchronized (list) {
                UniStationList.access$1402(this.this$0, null);
                UniStationList.access$1200(this.this$0);
            }
        }
        List list = UniStationList.access$600(this.this$0);
        synchronized (list) {
            UniStationList.access$1502(this.this$0, null);
            UniStationList.access$1200(this.this$0);
        }
    }

    /* synthetic */ UniStationList$TimerListener(UniStationList uniStationList, UniStationList$1 uniStationList$1) {
        this(uniStationList);
    }
}

