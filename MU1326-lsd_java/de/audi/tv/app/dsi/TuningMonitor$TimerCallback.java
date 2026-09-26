/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.dsi.TuningMonitor;
import de.audi.tv.app.dsi.TuningMonitor$1;
import java.util.List;

class TuningMonitor$TimerCallback
extends DefaultTimerListener {
    private final /* synthetic */ TuningMonitor this$0;

    private TuningMonitor$TimerCallback(TuningMonitor tuningMonitor) {
        this.this$0 = tuningMonitor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        List list = TuningMonitor.access$600(this.this$0);
        synchronized (list) {
            TuningMonitor.access$1100(this.this$0).log(-2137614336, "[TuningMonitor.TimerCallback.fireTimer] selectService takes too long, clear the list");
            TuningMonitor.access$600(this.this$0).clear();
        }
    }

    /* synthetic */ TuningMonitor$TimerCallback(TuningMonitor tuningMonitor, TuningMonitor$1 tuningMonitor$1) {
        this(tuningMonitor);
    }
}

