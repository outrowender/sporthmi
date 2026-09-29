/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.TuningMonitor;
import de.audi.tv.app.dsi.TuningMonitor$1;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TuningMonitor$DSICallListenerImpl
extends DSICallListener {
    private final /* synthetic */ TuningMonitor this$0;

    private TuningMonitor$DSICallListenerImpl(TuningMonitor tuningMonitor) {
        this.this$0 = tuningMonitor;
    }

    @Override
    public synchronized void selectService(ServiceInfo serviceInfo, boolean bl) {
        TuningMonitor.access$600(this.this$0).add(serviceInfo);
        TuningMonitor.access$800(this.this$0).restart();
        TuningMonitor.access$900(this.this$0).cancel();
    }

    /* synthetic */ TuningMonitor$DSICallListenerImpl(TuningMonitor tuningMonitor, TuningMonitor$1 tuningMonitor$1) {
        this(tuningMonitor);
    }
}

