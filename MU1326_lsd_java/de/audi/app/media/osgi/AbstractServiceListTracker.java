/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.osgi;

import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractServiceListTracker
implements ServiceTrackerCustomizer {
    private static final String LOGCLASS = "AbstractServiceListTracker";
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

    protected abstract Class getTrackedServiceClass();

    protected abstract void serviceAdded(Object var1);

    protected abstract void serviceRemoved(Object var1);

    protected abstract boolean checkServiceProperties(Dictionary var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init() {
        this.logger.log(1000000, "[%1.init] [%2]", (Object)LOGCLASS, (Object)this.getTrackedServiceClass().getName());
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
        this.logger.log(1000000, "[%1.deinit] [%2]", (Object)LOGCLASS, (Object)this.getTrackedServiceClass().getName());
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
    public Object addingService(ServiceReference serviceReference) {
        if (!this.checkServiceProperties(new PropertyDictonary(serviceReference))) {
            return null;
        }
        Object object = this.serviceManager.getService(serviceReference);
        if (object == null) {
            this.serviceManager.releaseService(serviceReference);
            return null;
        }
        this.logger.log(1000000, "[%1.addingService] '%2'", (Object)LOGCLASS, object);
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
    public void removedService(ServiceReference serviceReference, Object object) {
        if (!this.checkServiceProperties(new PropertyDictonary(serviceReference))) {
            return;
        }
        if (object == null) {
            return;
        }
        this.logger.log(1000000, "[%1.removedService] '%2'", (Object)LOGCLASS, object);
        this.serviceRemoved(object);
        this.serviceManager.releaseService(serviceReference);
        Object object2 = this.mutex;
        synchronized (object2) {
            LinkedList linkedList = new LinkedList(this.foundServices);
            linkedList.remove(object);
            this.foundServices = linkedList;
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    private class PropertyDictonary
    extends Dictionary {
        private final ServiceReference reference;

        public PropertyDictonary(ServiceReference serviceReference) {
            this.reference = serviceReference;
        }

        public int size() {
            return this.reference.getPropertyKeys().length;
        }

        public Object remove(Object object) {
            return null;
        }

        public Object put(Object object, Object object2) {
            return null;
        }

        public Enumeration keys() {
            return null;
        }

        public boolean isEmpty() {
            return false;
        }

        public Object get(Object object) {
            return this.reference.getProperty(object.toString());
        }

        public Enumeration elements() {
            return null;
        }
    }
}

