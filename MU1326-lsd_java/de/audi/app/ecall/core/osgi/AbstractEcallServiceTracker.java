/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.osgi;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractEcallServiceTracker
extends AbstractEcallComponent
implements ServiceTrackerCustomizer {
    private final EcallServiceTracker serviceTracker;
    private final Class trackedServiceClazz;
    private volatile Object service;

    public AbstractEcallServiceTracker(IEcallApplication iEcallApplication, String string, Class clazz) {
        super(iEcallApplication, string);
        this.trackedServiceClazz = clazz;
        this.serviceTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), clazz.getName(), (ServiceTrackerCustomizer)this, this.log);
    }

    @Override
    public void init() {
        super.init();
        this.serviceTracker.openTracker();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.serviceTracker.closeTracker();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (this.trackedServiceClazz.isInstance(object)) {
            this.service = object;
            this.serviceAvailable(object);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (this.trackedServiceClazz.isInstance(object) && this.service != null && this.service.equals(object)) {
            this.serviceRemoved();
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    protected abstract void serviceAvailable(Object object) {
    }

    protected abstract void serviceRemoved() {
    }
}

