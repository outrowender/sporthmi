/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.osgi;

import de.audi.app.terminalmode.osgi.AbstractServiceListTracker$PropertyDictonary;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractServiceListTracker
implements ServiceTrackerCustomizer {
    private static final String LOGCLASS;
    private final Object mutex = new Object();
    private final IServiceManager serviceManager;
    protected final LogChannel logger;
    private final IServiceTracker serviceTracker;
    private List foundServices;

    public AbstractServiceListTracker(LogChannel logChannel, IServiceManager iServiceManager) {
        this.logger = logChannel;
        this.serviceManager = iServiceManager;
        this.serviceTracker = iServiceManager.createServiceTracker(this.getTrackedServiceClass(), this);
    }

    protected abstract Class getTrackedServiceClass() {
    }

    protected abstract void serviceAdded(Object object) {
    }

    protected abstract void serviceRemoved(Object object) {
    }

    protected abstract boolean checkServiceProperties(Dictionary dictionary) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init() {
        this.logger.log(14808325, "[%1.init] [%2]", (Object)"AbstractServiceListTracker", (Object)this.getTrackedServiceClass().getName());
        Object object = this.mutex;
        synchronized (object) {
            this.foundServices = new ArrayList(0);
        }
        this.serviceTracker.open();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit] [%2]", (Object)"AbstractServiceListTracker", (Object)this.getTrackedServiceClass().getName());
        this.serviceTracker.close();
        Object object = this.mutex;
        synchronized (object) {
            this.foundServices = new ArrayList(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getServices() {
        Object object = this.mutex;
        synchronized (object) {
            return this.foundServices;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (!this.checkServiceProperties(new AbstractServiceListTracker$PropertyDictonary(this, serviceReference))) {
            return null;
        }
        Object object = this.serviceManager.getService(serviceReference);
        if (object == null) {
            this.serviceManager.releaseService(serviceReference);
            return null;
        }
        this.logger.log(1078071040, "[%1.addingService] '%2'", (Object)"AbstractServiceListTracker", object);
        Object object2 = this.mutex;
        synchronized (object2) {
            ArrayList arrayList = new ArrayList(this.foundServices.size() + 1);
            arrayList.addAll(this.foundServices);
            arrayList.add(object);
            this.foundServices = arrayList;
            this.serviceAdded(object);
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (!this.checkServiceProperties(new AbstractServiceListTracker$PropertyDictonary(this, serviceReference))) {
            return;
        }
        if (object == null) {
            return;
        }
        this.logger.log(1078071040, "[%1.removedService] '%2'", (Object)"AbstractServiceListTracker", object);
        this.serviceRemoved(object);
        this.serviceManager.releaseService(serviceReference);
        Object object2 = this.mutex;
        synchronized (object2) {
            LinkedList linkedList = new LinkedList(this.foundServices);
            linkedList.remove(object);
            this.foundServices = linkedList;
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

