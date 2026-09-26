/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.HMIModelBank;
import de.audi.tghu.fwhmi.HMIRegistry;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class HMIRegistry$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ HMIRegistry this$0;

    HMIRegistry$1(HMIRegistry hMIRegistry) {
        this.this$0 = hMIRegistry;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.bc.getService(serviceReference);
        HMIRegistry.access$000(this.this$0, (HMIModelBank)object);
        ((HMIModelBank)object).isRegistered(true);
        this.this$0.log.log(1078071040, "HMIRegistry: adding HMIModelBank: service: %1,", object);
        HMIRegistry.access$100(this.this$0);
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.log.log(-2137614336, "HMIRegistry: removed HMIModelBank: service: %1", object);
        HMIRegistry.access$200(this.this$0, (HMIModelBank)object, serviceReference);
    }
}

