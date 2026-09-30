/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.service;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class CarServiceTracker
implements ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private final LogChannel logChannel;
    private final CarServiceTrackerListener trackerListener;
    private volatile ServiceTracker serviceTracker = null;
    private ServiceReference serviceRef;

    public CarServiceTracker(CarServiceTrackerListener carServiceTrackerListener, BundleContext bundleContext, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.logChannel = logChannel;
        this.trackerListener = carServiceTrackerListener;
    }

    public void startTracking() {
        this.getLogChannel().log(1000000, "[CarServiceTracker#startTracking] tracking service: %1", (Object)this.trackerListener.getTrackedServiceClazzName());
        this.serviceTracker = new ServiceTracker(this.bundleContext, this.trackerListener.getTrackedServiceClazzName(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void stopTracking() {
        this.getLogChannel().log(1000000, "[CarServiceTracker#stopTracking] tracking service: %1", (Object)this.trackerListener.getTrackedServiceClazzName());
        if (this.serviceTracker != null) {
            this.serviceTracker.close();
            this.serviceTracker = null;
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        this.getLogChannel().log(1000000, "[CarServiceTracker#addingService] service: %1", (Object)this.trackerListener.getTrackedServiceClazzName());
        this.serviceRef = serviceReference;
        Object object = this.bundleContext.getService(serviceReference);
        this.trackerListener.serviceAvailable(object);
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.getLogChannel().log(1000000, "[CarServiceTracker#removedService] service: %1", (Object)this.trackerListener.getTrackedServiceClazzName());
        this.trackerListener.serviceRemoved();
        this.bundleContext.ungetService(serviceReference);
    }

    private LogChannel getLogChannel() {
        return this.logChannel;
    }

    public Integer getServiceInstance() {
        if (this.serviceRef != null) {
            return (Integer)this.serviceRef.getProperty("DEVICE_INSTANCE");
        }
        return new Integer(-1);
    }
}

