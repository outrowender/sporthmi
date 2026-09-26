/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.trafficlight;

import de.audi.app.online.evo.trafficlight.TrafficLightOnlineHandler;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TrafficLightOnlineServiceTrackerCustomizer
implements ServiceTrackerCustomizer {
    private final TrafficLightOnlineHandler trafficLightOnlineHandler;
    private final BundleContext context;
    private final LogChannel logChannel;

    public TrafficLightOnlineServiceTrackerCustomizer(TrafficLightOnlineHandler trafficLightOnlineHandler, LogChannel logChannel, BundleContext bundleContext) {
        this.context = bundleContext;
        this.logChannel = logChannel;
        this.trafficLightOnlineHandler = trafficLightOnlineHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnlineService) {
            this.trafficLightOnlineHandler.setOnlineService(null);
            this.context.ungetService(serviceReference);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.context.getService(serviceReference);
        Object object2 = serviceReference.getProperty("ONLINE_APP_ID");
        this.logChannel.log(-2137614336, "TrafficLightOnlineServiceTrackerCustomizer#addingService: got property %1 for service %2", object2, object);
        if (object instanceof IOnlineService && object2 != null && object2.equals("service_trafficlight")) {
            this.trafficLightOnlineHandler.setOnlineService((IOnlineService)object);
            return object;
        }
        this.context.ungetService(serviceReference);
        return null;
    }
}

