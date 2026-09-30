/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.osgi;

import de.audi.app.messaging.core.util.Arrays;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractMessagingTrackerCustomizer
implements ServiceTrackerCustomizer {
    private final LogChannel log;
    private final BundleContext bundleContext;

    public AbstractMessagingTrackerCustomizer(LogChannel logChannel, BundleContext bundleContext) {
        this.log = logChannel;
        this.bundleContext = bundleContext;
    }

    public final Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (this.log.isInfo()) {
            this.log.log(1000000, "[AbstractMessagingTrackerCustomizer#addingService] Service interfaces = %1, service implementation = %2@%3", (Object)this.getServiceInterfaces(serviceReference), (Object)this.getServiceClass(object), (long)System.identityHashCode(object));
        }
        boolean bl = false;
        try {
            this.addService(serviceReference, object);
            bl = true;
        }
        catch (Exception exception) {
            this.log.log(10000, "[AbstractMessagingTrackerCustomizer#addingService] Error adding service: ", (Throwable)exception);
            this.bundleContext.ungetService(serviceReference);
        }
        return bl ? object : null;
    }

    public final void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public final void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(100000, "[AbstractMessagingTrackerCustomizer#removedService] Service interfaces = %1, service implementation = %2@%3", (Object)this.getServiceInterfaces(serviceReference), (Object)this.getServiceClass(object), (long)System.identityHashCode(object));
        try {
            this.removeService(serviceReference, object);
        }
        catch (Exception exception) {
            this.log.log(10000, "[AbstractMessagingTrackerCustomizer#removedService] Error removing service: ", (Throwable)exception);
        }
        this.bundleContext.ungetService(serviceReference);
    }

    protected abstract void addService(ServiceReference var1, Object var2) throws RuntimeException;

    protected abstract void removeService(ServiceReference var1, Object var2);

    private String getServiceInterfaces(ServiceReference serviceReference) {
        Object[] objectArray = (String[])serviceReference.getProperty("objectClass");
        return Arrays.toString(objectArray);
    }

    private String getServiceClass(Object object) {
        return object.getClass().getName();
    }
}

