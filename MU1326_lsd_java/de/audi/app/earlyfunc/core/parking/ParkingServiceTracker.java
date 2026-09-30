/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ParkingServiceTracker
implements ServiceTrackerCustomizer {
    private ServiceTracker tracker;
    private final BundleContext bundleContext;
    private final String[] trackedServices;
    private final ServiceTrackerCustomizer customizer;
    private final LogChannel logChannel;

    public ParkingServiceTracker(BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.trackedServices = new String[]{string};
        this.customizer = serviceTrackerCustomizer;
        this.logChannel = logChannel;
    }

    public ParkingServiceTracker(BundleContext bundleContext, String[] stringArray, ServiceTrackerCustomizer serviceTrackerCustomizer, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.trackedServices = stringArray;
        this.customizer = serviceTrackerCustomizer;
        this.logChannel = logChannel;
    }

    public void openTracker() {
        this.logChannel.log(1000000, "[ParkingServiceTracker#openTracker] %1", (Object)this);
        this.tracker = new ServiceTracker(this.bundleContext, this.trackedServices, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    public void closeTracker() {
        this.logChannel.log(1000000, "[ParkingServiceTracker#closeTracker] %1", (Object)this);
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        this.logChannel.log(1000000, "[ParkingServiceTracker#addingService] reference=%1", (Object)serviceReference);
        return this.customizer.addingService(serviceReference);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(1000000, "[ParkingServiceTracker#modifiedService] reference=%1, service=%2", (Object)serviceReference, object);
        this.customizer.modifiedService(serviceReference, object);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(1000000, "[ParkingServiceTracker#modifiedService] reference=%1, service=%2", (Object)serviceReference, object);
        this.customizer.removedService(serviceReference, object);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ParkingServiceTracker: trackedServices=[");
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
}

