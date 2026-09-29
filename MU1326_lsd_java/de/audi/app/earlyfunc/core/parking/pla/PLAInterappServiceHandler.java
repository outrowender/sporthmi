/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.earlyfunc.core.parking.pla.IPLAInterappServiceHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAInterappServiceHandler$1;
import de.audi.app.earlyfunc.core.parking.pla.PLAInterappStatus;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAInterappService;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusCallbackListener;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusListener;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;

public class PLAInterappServiceHandler
implements IPLAInterappService,
IPLAInterappServiceHandler {
    private final Object mutex = new Object();
    private final CarServiceProvider serviceProvider;
    private final ICarApplication application;
    private final LogChannel logChannel;
    private final ArrayList listeners = new ArrayList(1);
    private final IPLAStatusCallbackListener callbackListener;
    private volatile int lastUpdateMode;
    private volatile IPLAStatus status;
    static /* synthetic */ Class class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService;

    public PLAInterappServiceHandler(ICarApplication iCarApplication, LogChannel logChannel, IPLAStatusCallbackListener iPLAStatusCallbackListener) {
        this.serviceProvider = new CarServiceProvider((class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService == null ? (class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService = PLAInterappServiceHandler.class$("de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAInterappService")) : class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService).getName(), this, null, iCarApplication.getBundleContext(), logChannel);
        this.application = iCarApplication;
        this.logChannel = logChannel;
        this.callbackListener = iPLAStatusCallbackListener;
        this.lastUpdateMode = -1;
        this.status = null;
    }

    @Override
    public void init() {
        this.serviceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.serviceProvider.stopService();
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = -1;
            this.status = null;
            if (this.isCallbackListener()) {
                for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                    IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                    iPLAStatusListener.unregisterCallbackListener(this.callbackListener);
                }
            }
            this.listeners.clear();
        }
    }

    public boolean hasListeners() {
        return 0 < this.listeners.size();
    }

    public boolean isCallbackListener() {
        return null != this.callbackListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePLAStatusIdleMode() {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#updatePLAStatusIdleMode] Standby...");
        }
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = 0;
            this.status = null;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                try {
                    iPLAStatusListener.updatePLAStatusIdleMode();
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[PLAInterappServiceHandler#updatePLAStatusIdleMode] Exception occured within the listener.", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePLAStatusStandbyMode(IPLAStatus iPLAStatus) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#updatePLAStatusStandbyMode] Standby...");
        }
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = 6;
            this.status = iPLAStatus;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                try {
                    iPLAStatusListener.updatePLAStatusStandbyMode(iPLAStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[PLAInterappServiceHandler#updatePLAStatusStandbyMode] Exception occured within the listener.", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePLAStatusSearchMode(IPLAStatus iPLAStatus) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#updatePLAStatusSearchMode] status='%1'", (Object)iPLAStatus.toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = 1;
            this.status = iPLAStatus;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                try {
                    iPLAStatusListener.updatePLAStatusSearchMode(iPLAStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[PLAInterappServiceHandler#updatePLAStatusSearchMode] Exception occured within the listener.", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePLAStatusInSelectionMode(IPLAStatus iPLAStatus) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#updatePLAStatusInSelectionMode] status='%1'", (Object)iPLAStatus.toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = 2;
            this.status = iPLAStatus;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                try {
                    iPLAStatusListener.updatePLAStatusInSelectionMode(iPLAStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[PLAInterappServiceHandler#updatePLAStatusInSelectionMode] Exception occured within the listener.", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePLAStatusOutSelectionMode(IPLAStatus iPLAStatus) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#updatePLAStatusOutSelectionMode] status='%1'", (Object)iPLAStatus.toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = 3;
            this.status = iPLAStatus;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                try {
                    iPLAStatusListener.updatePLAStatusOutSelectionMode(iPLAStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[PLAInterappServiceHandler#updatePLAStatusOutSelectionMode] Exception occured within the listener.", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePLAStatusParkInActive(IPLAStatus iPLAStatus) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#updatePLAStatusParkInActive] status='%1'", (Object)iPLAStatus.toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = 4;
            this.status = iPLAStatus;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                try {
                    iPLAStatusListener.updatePLAStatusParkInActive(iPLAStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[PLAInterappServiceHandler#updatePLAStatusParkInActive] Exception occured within the listener.", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatePLAStatusParkOutActive(IPLAStatus iPLAStatus) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#updatePLAStatusParkOutActive] status='%1'", (Object)iPLAStatus.toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.lastUpdateMode = 5;
            this.status = iPLAStatus;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                IPLAStatusListener iPLAStatusListener = (IPLAStatusListener)this.listeners.get(i2);
                try {
                    iPLAStatusListener.updatePLAStatusParkOutActive(iPLAStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[PLAInterappServiceHandler#updatePLAStatusParkOutActive] Exception occured within the listener.", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerStatusListener(IPLAStatusListener iPLAStatusListener) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#registerStatusListener] ...");
        }
        Object object = this.mutex;
        synchronized (object) {
            if (!this.listeners.contains(iPLAStatusListener)) {
                if (this.isCallbackListener()) {
                    iPLAStatusListener.registerCallbackListener(this.callbackListener);
                }
                this.listeners.add(iPLAStatusListener);
                if (-1 != this.lastUpdateMode) {
                    this.application.getJobDispatcher().execute(new PLAInterappServiceHandler$1(this, iPLAStatusListener));
                }
            } else {
                this.logChannel.log(-1601830656, "[PLAInterappServiceHandler#registerStatusListener] Listener already registered.");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterStatusListener(IPLAStatusListener iPLAStatusListener) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[PLAInterappServiceHandler#unregisterStatusListener] ...");
        }
        Object object = this.mutex;
        synchronized (object) {
            if (this.isCallbackListener()) {
                iPLAStatusListener.unregisterCallbackListener(this.callbackListener);
            }
            this.listeners.remove(iPLAStatusListener);
        }
    }

    @Override
    public IPLAStatus getDefaultPLAStatus() {
        return new PLAInterappStatus(0, null != this.status ? this.status.isSystemActiveOPS() : false, 0, false, false, 0, false);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ Object access$000(PLAInterappServiceHandler pLAInterappServiceHandler) {
        return pLAInterappServiceHandler.mutex;
    }

    static /* synthetic */ int access$100(PLAInterappServiceHandler pLAInterappServiceHandler) {
        return pLAInterappServiceHandler.lastUpdateMode;
    }

    static /* synthetic */ IPLAStatus access$200(PLAInterappServiceHandler pLAInterappServiceHandler) {
        return pLAInterappServiceHandler.status;
    }

    static /* synthetic */ LogChannel access$300(PLAInterappServiceHandler pLAInterappServiceHandler) {
        return pLAInterappServiceHandler.logChannel;
    }
}

