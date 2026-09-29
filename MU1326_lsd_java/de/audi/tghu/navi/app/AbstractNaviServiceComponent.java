/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractNaviServiceComponent
implements BundleActivator,
ServiceTrackerCustomizer {
    protected final LogChannel logChannel;
    protected volatile ServiceTracker tracker = null;
    private volatile BundleContext context = null;

    public AbstractNaviServiceComponent(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        this.tracker = new ServiceTracker(bundleContext, this.getTrackedService(), (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.onStart();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        this.onStop();
        this.context = null;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = null;
        if (this.context != null && !this.trackedServiceAdded(object = this.context.getService(serviceReference))) {
            this.context.ungetService(serviceReference);
            this.logChannel.log(-1601830656, "[AbstractNaviServiceComponent] not adding unwanted service!");
            object = null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (this.context != null) {
            this.context.ungetService(serviceReference);
        }
        this.trackedServiceRemoved(object);
    }

    protected abstract String[] getTrackedService() {
    }

    protected abstract boolean trackedServiceAdded(Object object) {
    }

    protected abstract boolean trackedServiceRemoved(Object object) {
    }

    protected abstract void onStart() {
    }

    protected abstract void onStop() {
    }
}

