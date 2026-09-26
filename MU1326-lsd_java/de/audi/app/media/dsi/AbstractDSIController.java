/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.IDSIControllerStateListener;
import de.audi.app.media.dsi.JobNotifyDSIState;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractDSIController
implements IDSIController,
ServiceTrackerCustomizer {
    private static final String LOGCLASS;
    private final IServiceManager serviceManager;
    private final DispatcherBase dispatcher;
    protected final LogChannel logger;
    private final Object startupMutex = new Object();
    private final Object dsiStateChangeMutex = new Object();
    private final int instanceID;
    private final boolean startDSIService;
    private final String logDSIClassName;
    private boolean isServiceStartupTriggered = false;
    private IDSIControllerStateListener stateListener;
    private boolean dsiAvailable;
    private volatile IServiceTracker dsiServiceTracker;
    private volatile ServiceRegistration dsiServiceListenerRegistration;

    public AbstractDSIController(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, boolean bl, LogChannel logChannel) {
        if (iServiceManager == null || logChannel == null || iFrameworkAccess == null || dispatcherBase == null) {
            throw new IllegalArgumentException();
        }
        this.serviceManager = iServiceManager;
        this.logger = logChannel;
        this.instanceID = n;
        this.startDSIService = bl;
        this.dispatcher = dispatcherBase;
        this.logDSIClassName = this.getDSIServiceClass().getName().substring(this.getDSIServiceClass().getName().lastIndexOf(".") + 1);
    }

    protected abstract Class getDSIServiceClass() {
    }

    protected abstract DSIListener getDSIListener() {
    }

    protected abstract Class getDSIListenerClass() {
    }

    protected abstract void addDSIService(DSIBase dSIBase) {
    }

    protected abstract void removeDSIService() {
    }

    protected final void clearAttributeNotification(DSIBase dSIBase) {
        if (dSIBase == null) {
            return;
        }
        this.logger.log(1078071040, "[%1.clearAttributeNotification] Clear notifications.", (Object)"AbstractDSIController");
        dSIBase.clearNotification(this.getDSIListener());
    }

    protected final String getNameOfDSIServiceClass() {
        return this.logDSIClassName;
    }

    protected final IServiceManager getServiceManager() {
        return this.serviceManager;
    }

    @Override
    public final int getInstanceID() {
        return this.instanceID;
    }

    @Override
    public void init() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit] [%2,%3]", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
        Object object = this.startupMutex;
        synchronized (object) {
            this.isServiceStartupTriggered = false;
        }
        this.serviceManager.stopDSIService(this.getDSIServiceClass().getName(), this.instanceID);
        if (this.dsiServiceTracker != null) {
            this.dsiServiceTracker.close();
            this.dsiServiceTracker = null;
        }
        if (this.dsiServiceListenerRegistration != null) {
            this.dsiServiceListenerRegistration.unregister();
            this.dsiServiceListenerRegistration = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void startDSI() {
        if (this.logger.isInfo()) {
            this.logger.log(1078071040, "[%1.startDSI] [%2,%3] listenerOnly='%4'.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)String.valueOf(this.instanceID), (Object)String.valueOf(!this.startDSIService));
        }
        Object object = this.startupMutex;
        synchronized (object) {
            if (this.isServiceStartupTriggered) {
                this.logger.log(1078071040, "[%1.startDSI] [%2,%3] Already started.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
                return;
            }
            this.dsiServiceTracker = this.getServiceManager().createServiceTracker(this.getDSIServiceClass(), this);
            this.dsiServiceTracker.open();
            if (this.dsiServiceListenerRegistration == null) {
                this.dsiServiceListenerRegistration = this.serviceManager.registerDSIListener(this.instanceID, this.getDSIListenerClass().getName(), this.getDSIListener());
            }
            if (this.startDSIService) {
                this.isServiceStartupTriggered = this.serviceManager.startDSIService(this.getDSIServiceClass().getName(), this.instanceID);
                this.logger.log(1078071040, "[%1.startDSI] [%2,%3] isServiceStartupTriggered: %4.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)new Integer(this.instanceID), (Object)this.isServiceStartupTriggered);
            } else {
                this.logger.log(1078071040, "[%1.startDSI] [%2,%3] Listner only active.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
                this.isServiceStartupTriggered = true;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isStarted() {
        Object object = this.startupMutex;
        synchronized (object) {
            return this.isServiceStartupTriggered;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setStateListener(IDSIControllerStateListener iDSIControllerStateListener) {
        Object object = this.dsiStateChangeMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.setStateListener] [%2,%3] '%4'", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)new Integer(this.instanceID), (Object)iDSIControllerStateListener);
            this.stateListener = iDSIControllerStateListener;
            if (this.stateListener == null) {
                return;
            }
            this.notifyAvailabilityState(this.isDSIAvailable());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IDSIControllerStateListener getStateListener() {
        Object object = this.dsiStateChangeMutex;
        synchronized (object) {
            return this.stateListener;
        }
    }

    private void setDSIAvailable(boolean bl) {
        this.dsiAvailable = bl;
        this.notifyAvailabilityState(this.dsiAvailable);
    }

    private boolean isDSIAvailable() {
        return this.dsiAvailable;
    }

    private void notifyAvailabilityState(boolean bl) {
        this.logger.log(1078071040, "[%1.notifyAvailabilityState] [%2,%3] '%4'", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)new Integer(this.instanceID), (Object)String.valueOf(bl));
        if (this.stateListener == null) {
            this.logger.log(1078071040, "[%1.notifyAvailabilityState] [%2,%3] No listener", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)new Integer(this.instanceID));
            return;
        }
        this.dispatcher.execute(new JobNotifyDSIState(this, bl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final Object addingService(ServiceReference serviceReference) {
        Integer n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
        if (n == null) {
            this.logger.log(10000, "[%1.addingService] [%2,%3] No DEVICE_INSTANCE property. Ignore.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
            return null;
        }
        if (n != this.instanceID) {
            this.logger.log(-2137614336, "[%1.addingService] [%2,%3] Wrong instance '%4'. Ignore.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)String.valueOf(this.instanceID), (Object)String.valueOf(n));
            return null;
        }
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        if (!this.getDSIServiceClass().getName().equals(string)) {
            this.logger.log(-2137614336, "[%1.addingService] [%2,%3] Wrong DEVICE_NAME '%4'. Ignore.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)String.valueOf(this.instanceID), (Object)string);
            return null;
        }
        this.logger.log(1078071040, "[%1.addingService] [%2,%3] Service found.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
        Object object = this.getServiceManager().getService(serviceReference);
        this.addDSIService((DSIBase)object);
        Object object2 = this.dsiStateChangeMutex;
        synchronized (object2) {
            this.setDSIAvailable(true);
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void removedService(ServiceReference serviceReference, Object object) {
        Integer n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
        if (n == null) {
            this.logger.log(10000, "[%1.removedService] [%2,%3] No DEVICE_INSTANCE property. Ignore.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
            return;
        }
        if (n != this.instanceID) {
            this.logger.log(-2137614336, "[%1.removedService] [%2,%3] Wrong instance '%4'. Ignore.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (Object)String.valueOf(this.instanceID), (Object)String.valueOf(n));
            return;
        }
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        if (!this.getDSIServiceClass().getName().equals(string)) {
            this.logger.log(-2137614336, "[%1.removedService] [%2,%3] Wrong DEVICE_NAME. Ignore.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
            return;
        }
        this.logger.log(1078071040, "[%1.removedService] [%2,%3] Service removed.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
        this.serviceManager.releaseService(serviceReference);
        this.removeDSIService();
        Object object2 = this.dsiStateChangeMutex;
        synchronized (object2) {
            this.setDSIAvailable(false);
        }
    }

    @Override
    public final void modifiedService(ServiceReference serviceReference, Object object) {
        this.logger.log(1078071040, "[%1.modifiedService] [%2,%3] Service modified.", (Object)"AbstractDSIController", (Object)this.logDSIClassName, (long)this.instanceID);
    }
}

