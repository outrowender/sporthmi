/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.HMIBundle;
import de.audi.tghu.fwhmi.HMIRegistry;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class HMIRegistry$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ HMIRegistry this$0;

    HMIRegistry$2(HMIRegistry hMIRegistry) {
        this.this$0 = hMIRegistry;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = null;
        Object object2 = serviceReference.getProperty("Skin");
        if (object2 != null) {
            object = this.this$0.bc.getService(serviceReference);
            HMIRegistry.access$300(this.this$0, (String)object2, (HMIBundle)object);
            HMIRegistry.access$400(this.this$0).add((HMIBundle)object);
            this.this$0.log.log(1078071040, "HMIRegistry: adding HMIBundle: service: %1, skin: %2", object, object2);
            HMIRegistry.access$100(this.this$0);
        } else {
            this.this$0.log.log(-1601830656, "HMIRegistry: adding HMIBundle failed: service: %1, no skin given!", object);
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("Skin");
        this.this$0.log.log(-2137614336, "HMIRegistry: removed HMIBundle: service: %1 skin: %2", object, object2);
        if (object2 != null) {
            HMIRegistry.access$400(this.this$0).remove((HMIBundle)object);
            HMIRegistry.access$500(this.this$0, (String)object2, (HMIBundle)object, serviceReference);
        } else {
            this.this$0.log.log(-1601830656, "HMIRegistry: removed HMIBundle failed: service: %1, no skin given!", object);
        }
    }
}

