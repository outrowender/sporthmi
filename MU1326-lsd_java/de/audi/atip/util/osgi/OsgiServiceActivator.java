/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.IOsgiServiceClient;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OsgiServiceActivator
implements BundleActivator,
ServiceTrackerCustomizer {
    private final LogChannel log;
    private final Class clazz;
    private final IOsgiServiceClient client;
    private volatile BundleContext context = null;
    private volatile ServiceTracker tracker = null;

    public OsgiServiceActivator(Class clazz, IOsgiServiceClient iOsgiServiceClient, LogChannel logChannel) {
        this.log = logChannel;
        this.clazz = clazz;
        this.client = iOsgiServiceClient;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.context.getService(serviceReference);
        if (this.clazz.isInstance(object)) {
            this.client.setService(object);
        } else {
            this.context.ungetService(serviceReference);
            object = null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(-1601830656, "[OsgiServiceActivator] removed Service %1", (Object)this.clazz.getName());
        this.client.setService(null);
        this.context.ungetService(serviceReference);
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        this.tracker = new ServiceTracker(bundleContext, this.clazz.getName(), (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
    }
}

