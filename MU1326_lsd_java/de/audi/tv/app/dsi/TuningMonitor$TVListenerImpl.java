/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.tv.app.TVUtil;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.TuningMonitor;
import de.audi.tv.app.dsi.TuningMonitor$1;
import java.util.Iterator;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TuningMonitor$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ TuningMonitor this$0;

    private TuningMonitor$TVListenerImpl(TuningMonitor tuningMonitor) {
        this.this$0 = tuningMonitor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSelectedService(ProgramInfo programInfo) {
        Object object = TuningMonitor.access$400(this.this$0);
        synchronized (object) {
            TuningMonitor.access$502(this.this$0, programInfo);
            if (TuningMonitor.access$600(this.this$0).isEmpty()) {
                TuningMonitor.access$700(this.this$0).updateSelectedServiceDebounced(programInfo);
            } else {
                this.logTunedServices();
                if (TVUtil.equalsNamePID(this.this$0.getLastTunedService(), programInfo.serviceInfo)) {
                    TuningMonitor.access$600(this.this$0).clear();
                    TuningMonitor.access$800(this.this$0).cancel();
                    TuningMonitor.access$900(this.this$0).cancel();
                    TuningMonitor.access$1000(this.this$0, programInfo);
                } else if (!this.wasServiceRequested(programInfo)) {
                    TuningMonitor.access$1100(this.this$0).log(-2137614336, "[TuningMonitor.updateSelectedService] diverged - start to reconcile");
                    TuningMonitor.access$900(this.this$0).restart();
                } else {
                    TuningMonitor.access$900(this.this$0).cancel();
                    TuningMonitor.access$1100(this.this$0).log(-2137614336, "[TuningMonitor.updateSelectedService] tuning is still in progress, wait");
                }
            }
        }
    }

    private boolean wasServiceRequested(ProgramInfo programInfo) {
        Iterator iterator = TuningMonitor.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ServiceInfo serviceInfo = (ServiceInfo)iterator.next();
            if (!TVUtil.equalsNamePID(serviceInfo, programInfo.serviceInfo)) continue;
            return true;
        }
        return false;
    }

    private void logTunedServices() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        Iterator iterator = TuningMonitor.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ServiceInfo serviceInfo = (ServiceInfo)iterator.next();
            stringBuffer.append(serviceInfo.name);
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
        TuningMonitor.access$1100(this.this$0).log(-2137614336, "[TuningMonitor.updateSelectedService] was tuning %1", (Object)stringBuffer.toString());
    }

    /* synthetic */ TuningMonitor$TVListenerImpl(TuningMonitor tuningMonitor, TuningMonitor$1 tuningMonitor$1) {
        this(tuningMonitor);
    }
}

