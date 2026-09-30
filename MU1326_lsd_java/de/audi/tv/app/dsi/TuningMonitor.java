/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TuningMonitor {
    private static final int UPDATE_SELECTED_RECONCILE_TIME = 1000;
    private static final int SELECT_SERVICE_COMMAND_TIMEOUT = 15000;
    private static final boolean DBG = true;
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
        this(logChannel, 15000L, 1000, tVEventDispatcher);
    }

    public TuningMonitor(LogChannel logChannel, long l, int n, TVEventDispatcher tVEventDispatcher) {
        this.lc = logChannel;
        this.tvEventDispatcher = tVEventDispatcher;
        this.tvListener = new TVListenerImpl();
        this.dsiCallListener = new DSICallListenerImpl();
        this.tunedServices = new ArrayList();
        this.selectTimeoutTimer = new Timer("selectServiceTimeout", l, true, new TimerCallback());
        this.reconcileTimer = new Timer("TVupdateSelectedServiceDebounce", n, true, new ReconcileTimerListener());
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

    private class TimerCallback
    extends DefaultTimerListener {
        private TimerCallback() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            List list = TuningMonitor.this.tunedServices;
            synchronized (list) {
                TuningMonitor.this.lc.log(10000000, "[TuningMonitor.TimerCallback.fireTimer] selectService takes too long, clear the list");
                TuningMonitor.this.tunedServices.clear();
            }
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateSelectedService(ProgramInfo programInfo) {
            Object object = TuningMonitor.this.mutex;
            synchronized (object) {
                TuningMonitor.this.lastTunedProgramInfo = programInfo;
                if (TuningMonitor.this.tunedServices.isEmpty()) {
                    TuningMonitor.this.tvEventDispatcher.updateSelectedServiceDebounced(programInfo);
                } else {
                    this.logTunedServices();
                    if (TVUtil.equalsNamePID(TuningMonitor.this.getLastTunedService(), programInfo.serviceInfo)) {
                        TuningMonitor.this.tunedServices.clear();
                        TuningMonitor.this.selectTimeoutTimer.cancel();
                        TuningMonitor.this.reconcileTimer.cancel();
                        TuningMonitor.this.notifyListeners(programInfo);
                    } else if (!this.wasServiceRequested(programInfo)) {
                        TuningMonitor.this.lc.log(10000000, "[TuningMonitor.updateSelectedService] diverged - start to reconcile");
                        TuningMonitor.this.reconcileTimer.restart();
                    } else {
                        TuningMonitor.this.reconcileTimer.cancel();
                        TuningMonitor.this.lc.log(10000000, "[TuningMonitor.updateSelectedService] tuning is still in progress, wait");
                    }
                }
            }
        }

        private boolean wasServiceRequested(ProgramInfo programInfo) {
            Iterator iterator = TuningMonitor.this.tunedServices.iterator();
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
            Iterator iterator = TuningMonitor.this.tunedServices.iterator();
            while (iterator.hasNext()) {
                ServiceInfo serviceInfo = (ServiceInfo)iterator.next();
                stringBuffer.append(serviceInfo.name);
                stringBuffer.append(", ");
            }
            stringBuffer.append(']');
            TuningMonitor.this.lc.log(10000000, "[TuningMonitor.updateSelectedService] was tuning %1", (Object)stringBuffer.toString());
        }
    }

    private class DSICallListenerImpl
    extends DSICallListener {
        private DSICallListenerImpl() {
        }

        public synchronized void selectService(ServiceInfo serviceInfo, boolean bl) {
            TuningMonitor.this.tunedServices.add(serviceInfo);
            TuningMonitor.this.selectTimeoutTimer.restart();
            TuningMonitor.this.reconcileTimer.cancel();
        }
    }

    private final class ReconcileTimerListener
    extends DefaultTimerListener {
        private ReconcileTimerListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            Object object = TuningMonitor.this.mutex;
            synchronized (object) {
                TuningMonitor.this.lc.log(10000000, "<- [TuningMonitor.ReconcileTimerListener.fireTimer] %1 ", (Object)TuningMonitor.this.lastTunedProgramInfo);
                TuningMonitor.this.tunedServices.clear();
                TuningMonitor.this.selectTimeoutTimer.cancel();
                TuningMonitor.this.notifyListeners(TuningMonitor.this.lastTunedProgramInfo);
            }
        }
    }
}

