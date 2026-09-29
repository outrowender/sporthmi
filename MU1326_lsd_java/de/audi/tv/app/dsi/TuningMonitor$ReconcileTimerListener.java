/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.dsi.TuningMonitor;
import de.audi.tv.app.dsi.TuningMonitor$1;

final class TuningMonitor$ReconcileTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ TuningMonitor this$0;

    private TuningMonitor$ReconcileTimerListener(TuningMonitor tuningMonitor) {
        this.this$0 = tuningMonitor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = TuningMonitor.access$400(this.this$0);
        synchronized (object) {
            TuningMonitor.access$1100(this.this$0).log(-2137614336, "<- [TuningMonitor.ReconcileTimerListener.fireTimer] %1 ", (Object)TuningMonitor.access$500(this.this$0));
            TuningMonitor.access$600(this.this$0).clear();
            TuningMonitor.access$800(this.this$0).cancel();
            TuningMonitor.access$1000(this.this$0, TuningMonitor.access$500(this.this$0));
        }
    }

    /* synthetic */ TuningMonitor$ReconcileTimerListener(TuningMonitor tuningMonitor, TuningMonitor$1 tuningMonitor$1) {
        this(tuningMonitor);
    }
}

