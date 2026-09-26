/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class WirelessChargingServiceTracker
implements ServiceTrackerCustomizer {
    private final ServiceTracker tracker;
    private final String[] trackedServices;
    private final ServiceTrackerCustomizer customizer;
    private final LogChannel log;

    public WirelessChargingServiceTracker(BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer, LogChannel logChannel) {
        this.log = logChannel;
        this.trackedServices = new String[]{string};
        this.customizer = serviceTrackerCustomizer;
        this.tracker = new ServiceTracker(bundleContext, this.trackedServices, (ServiceTrackerCustomizer)this);
    }

    public WirelessChargingServiceTracker(BundleContext bundleContext, String[] stringArray, ServiceTrackerCustomizer serviceTrackerCustomizer, LogChannel logChannel) {
        this.log = logChannel;
        this.trackedServices = stringArray;
        this.customizer = serviceTrackerCustomizer;
        this.tracker = new ServiceTracker(bundleContext, this.trackedServices, (ServiceTrackerCustomizer)this);
    }

    public void openTracker() {
        this.log.log(1078071040, "[WirelessChargingServiceTracker#openTracker] %1", (Object)this);
        this.tracker.open();
    }

    public void closeTracker() {
        this.log.log(1078071040, "[WirelessChargingServiceTracker#closeTracker] %1", (Object)this);
        this.tracker.close();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("WirelessChargingServiceTracker: trackedServices=[");
        for (int i2 = 0; i2 < this.trackedServices.length; ++i2) {
            buffer.append(this.trackedServices[i2]);
            if (i2 >= this.trackedServices.length - 1) continue;
            buffer.append(", ");
        }
        buffer.append("]");
        buffer.append(", customizer=c");
        buffer.append(this.customizer);
        return buffer.toString();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.log.log(1078071040, "[WirelessChargingServiceTracker#addingService] reference=%1", (Object)serviceReference);
        return this.customizer.addingService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        this.log.log(1078071040, "[WirelessChargingServiceTracker#modifiedService] reference=%1, service=%2", (Object)serviceReference, object);
        this.customizer.modifiedService(serviceReference, object);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(1078071040, "[WirelessChargingServiceTracker#removedService] reference=%1, service=%2", (Object)serviceReference, object);
        this.customizer.removedService(serviceReference, object);
    }
}

