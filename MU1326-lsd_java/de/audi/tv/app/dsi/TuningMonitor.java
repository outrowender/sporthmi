/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.TuningMonitor$DSICallListenerImpl;
import de.audi.tv.app.dsi.TuningMonitor$ReconcileTimerListener;
import de.audi.tv.app.dsi.TuningMonitor$TVListenerImpl;
import de.audi.tv.app.dsi.TuningMonitor$TimerCallback;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TuningMonitor {
    private static final int UPDATE_SELECTED_RECONCILE_TIME;
    private static final int SELECT_SERVICE_COMMAND_TIMEOUT;
    private static final boolean DBG;
    public final DefaultTVListener tvListener;
    public final DSICallListener dsiCallListener;
    private final List tunedServices;
    private ProgramInfo lastTunedProgramInfo;
    private final LogChannel lc;
    private final Timer selectTimeoutTimer;
    private final Timer reconcileTimer;
    private final TVEventDispatcher tvEventDispatcher;
    private final Object mutex = new Object();

    public TuningMonitor(LogChannel logChannel, TVEventDispatcher tVEventDispatcher) {
        this(logChannel, 0, 1000, tVEventDispatcher);
    }

    public TuningMonitor(LogChannel logChannel, long l, int n, TVEventDispatcher tVEventDispatcher) {
        this.lc = logChannel;
        this.tvEventDispatcher = tVEventDispatcher;
        this.tvListener = new TuningMonitor$TVListenerImpl(this, null);
        this.dsiCallListener = new TuningMonitor$DSICallListenerImpl(this, null);
        this.tunedServices = new ArrayList();
        this.selectTimeoutTimer = new Timer("selectServiceTimeout", l, true, new TuningMonitor$TimerCallback(this, null));
        this.reconcileTimer = new Timer("TVupdateSelectedServiceDebounce", n, true, new TuningMonitor$ReconcileTimerListener(this, null));
    }

    private void notifyListeners(ProgramInfo programInfo) {
        try {
            this.tvEventDispatcher.updateSelectedServiceDebounced(programInfo);
        }
        catch (Exception exception) {
            this.lc.log(10000, "<- [TuningMonitor.notifyListeners]", (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceInfo getLastTunedService() {
        ServiceInfo serviceInfo;
        List list = this.tunedServices;
        synchronized (list) {
            serviceInfo = !this.tunedServices.isEmpty() ? (ServiceInfo)this.tunedServices.get(this.tunedServices.size() - 1) : null;
        }
        return serviceInfo;
    }

    static /* synthetic */ Object access$400(TuningMonitor tuningMonitor) {
        return tuningMonitor.mutex;
    }

    static /* synthetic */ ProgramInfo access$502(TuningMonitor tuningMonitor, ProgramInfo programInfo) {
        tuningMonitor.lastTunedProgramInfo = programInfo;
        return tuningMonitor.lastTunedProgramInfo;
    }

    static /* synthetic */ List access$600(TuningMonitor tuningMonitor) {
        return tuningMonitor.tunedServices;
    }

    static /* synthetic */ TVEventDispatcher access$700(TuningMonitor tuningMonitor) {
        return tuningMonitor.tvEventDispatcher;
    }

    static /* synthetic */ Timer access$800(TuningMonitor tuningMonitor) {
        return tuningMonitor.selectTimeoutTimer;
    }

    static /* synthetic */ Timer access$900(TuningMonitor tuningMonitor) {
        return tuningMonitor.reconcileTimer;
    }

    static /* synthetic */ void access$1000(TuningMonitor tuningMonitor, ProgramInfo programInfo) {
        tuningMonitor.notifyListeners(programInfo);
    }

    static /* synthetic */ LogChannel access$1100(TuningMonitor tuningMonitor) {
        return tuningMonitor.lc;
    }

    static /* synthetic */ ProgramInfo access$500(TuningMonitor tuningMonitor) {
        return tuningMonitor.lastTunedProgramInfo;
    }
}

