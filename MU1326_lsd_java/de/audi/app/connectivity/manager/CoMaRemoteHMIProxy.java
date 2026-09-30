/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.atip.interapp.IConnectivityRHMIService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class CoMaRemoteHMIProxy
implements ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private final LogChannel log;
    private ServiceTracker serviceTracker;
    private IConnectivityRHMIService rhmi;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityRHMIService;

    CoMaRemoteHMIProxy(BundleContext bundleContext, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.log = logChannel;
    }

    void connectAppServer(String string) {
        if (this.rhmi != null) {
            this.rhmi.activateSource(string);
        } else {
            this.log.log(100000, "CoMaRemoteHMIProxy#connectAppServer(): IConnectivityRHMIService not available!");
        }
    }

    void disconnectAppServer(String string) {
        if (this.rhmi != null) {
            this.rhmi.deactivateSource(string);
        } else {
            this.log.log(100000, "CoMaRemoteHMIProxy#disConnectAppServer(): IConnectivityRHMIService not available!");
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IConnectivityRHMIService) {
            this.rhmi = (IConnectivityRHMIService)object;
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectivityRHMIService) {
            this.rhmi = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectivityRHMIService) {
            this.rhmi = (IConnectivityRHMIService)object;
        }
    }

    void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$IConnectivityRHMIService == null ? (class$de$audi$atip$interapp$IConnectivityRHMIService = CoMaRemoteHMIProxy.class$("de.audi.atip.interapp.IConnectivityRHMIService")) : class$de$audi$atip$interapp$IConnectivityRHMIService).getName(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    void deinit() {
        this.rhmi = null;
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

