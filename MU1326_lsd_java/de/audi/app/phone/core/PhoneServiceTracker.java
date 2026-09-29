/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class PhoneServiceTracker
implements ServiceTrackerCustomizer {
    private ServiceTracker tracker;
    private final String[] trackedServices;
    private final ServiceTrackerCustomizer customizer;
    private final LogChannel log;
    private final BundleContext bundleContext;

    public PhoneServiceTracker(BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer, LogChannel logChannel) {
        this.log = logChannel;
        this.trackedServices = new String[]{string};
        this.customizer = serviceTrackerCustomizer;
        this.bundleContext = bundleContext;
    }

    public PhoneServiceTracker(BundleContext bundleContext, String[] stringArray, ServiceTrackerCustomizer serviceTrackerCustomizer, LogChannel logChannel) {
        this.log = logChannel;
        this.trackedServices = stringArray;
        this.customizer = serviceTrackerCustomizer;
        this.bundleContext = bundleContext;
    }

    public void openTracker() {
        this.log.log(1078071040, "[PhoneServiceTracker#openTracker] %1", (Object)this);
        this.tracker = new ServiceTracker(this.bundleContext, this.trackedServices, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    public void closeTracker() {
        this.log.log(1078071040, "[PhoneServiceTracker#closeTracker] %1", (Object)this);
        this.tracker.close();
        this.tracker = null;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PhoneServiceTracker: trackedServices=[");
        for (int i2 = 0; i2 < this.trackedServices.length; ++i2) {
            buffer.append(this.trackedServices[i2]);
            if (i2 >= this.trackedServices.length - 1) continue;
            buffer.append(", ");
        }
        buffer.append("]");
        buffer.append(", customizer=");
        buffer.append(this.customizer);
        return buffer.toString();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.log.log(1078071040, "[PhoneServiceTracker#addingService] reference=%1", (Object)serviceReference);
        return this.customizer.addingService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        this.log.log(1078071040, "[PhoneServiceTracker#modifiedService] reference=%1, service=%2", (Object)serviceReference, object);
        this.customizer.modifiedService(serviceReference, object);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(1078071040, "[PhoneServiceTracker#removedService] reference=%1, service=%2", (Object)serviceReference, object);
        this.customizer.removedService(serviceReference, object);
    }
}

