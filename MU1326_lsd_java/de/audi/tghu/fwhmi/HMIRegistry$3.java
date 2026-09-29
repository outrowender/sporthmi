/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.HMIApplication;
import de.audi.tghu.fwhmi.HMIRegistry;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class HMIRegistry$3
implements ServiceTrackerCustomizer {
    private final /* synthetic */ HMIRegistry this$0;

    HMIRegistry$3(HMIRegistry hMIRegistry) {
        this.this$0 = hMIRegistry;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.bc.getService(serviceReference);
        String string = (String)serviceReference.getProperty("ApplicationName");
        this.this$0.log.log(-2137614336, "HMIRegistry: adding HMIApplication: service: %1 name: %2", object, (Object)string);
        HMIRegistry.access$600(this.this$0, (HMIApplication)object);
        HMIRegistry.access$100(this.this$0);
        this.this$0.fwHMI.checkForPostConnecting((HMIApplication)object);
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        this.this$0.log.log(-2137614336, "HMIRegistry: modified HMIApplication (ignored): service: %1", object);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("ApplicationName");
        this.this$0.log.log(-2137614336, "HMIRegistry: removed HMIApplication: service: %1 applicationName: %2", object, object2);
        HMIRegistry.access$700(this.this$0, (HMIApplication)object, serviceReference);
    }
}

