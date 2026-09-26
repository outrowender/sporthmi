/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.osgi;

import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractTrackerCustomizer
implements ServiceTrackerCustomizer {
    private final LogChannel log;
    private final BundleContext bundleContext;

    public AbstractTrackerCustomizer(LogChannel logChannel, BundleContext bundleContext) {
        this.log = logChannel;
        this.bundleContext = bundleContext;
    }

    @Override
    public final Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        this.log.log(1078071040, "[AbtractTrackerCustomizer#addingService] Service interfaces = %1, service implementation = %2", (Object)this.getServiceInterfaces(serviceReference), (Object)this.getServiceClass(object));
        boolean bl = false;
        try {
            this.addService(serviceReference, object);
            bl = true;
        }
        catch (Exception exception) {
            this.log.log(10000, "[AbtractTrackerCustomizer#addingService] Error adding service: %1", (Throwable)exception);
            this.bundleContext.ungetService(serviceReference);
        }
        return bl ? object : null;
    }

    @Override
    public final void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public final void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(-1601830656, "[AbtractTrackerCustomizer#removedService] Service interfaces = %1, service implementation = %2", (Object)this.getServiceInterfaces(serviceReference), (Object)this.getServiceClass(object));
        try {
            this.removeService(serviceReference, object);
        }
        catch (Exception exception) {
            this.log.log(10000, "[AbtractTrackerCustomizer#removedService] Error removing service: %1", (Throwable)exception);
        }
        this.bundleContext.ungetService(serviceReference);
    }

    protected abstract void addService(ServiceReference serviceReference, Object object) {
    }

    protected abstract void removeService(ServiceReference serviceReference, Object object) {
    }

    private String getServiceInterfaces(ServiceReference serviceReference) {
        Object[] objectArray = (String[])serviceReference.getProperty("objectClass");
        return DictationUtil.arrayToString(objectArray, false);
    }

    private String getServiceClass(Object object) {
        return object.getClass().getName();
    }
}

