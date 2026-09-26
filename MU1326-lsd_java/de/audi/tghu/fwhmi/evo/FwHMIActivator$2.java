/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.interapp.SDSService;
import de.audi.tghu.fwhmi.evo.FwHMIActivator;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class FwHMIActivator$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ FwHMIActivator this$0;

    FwHMIActivator$2(FwHMIActivator fwHMIActivator) {
        this.this$0 = fwHMIActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = FwHMIActivator.access$400(this.this$0).getBundleCxt().getService(serviceReference);
        if (object instanceof SDSService) {
            FwHMIActivator.access$100(this.this$0).setSDSService((SDSService)object);
        } else {
            FwHMIActivator.access$500(this.this$0).getBundleCxt().ungetService(serviceReference);
            object = null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        FwHMIActivator.access$100(this.this$0).setSDSService(null);
        FwHMIActivator.access$600(this.this$0).getBundleCxt().ungetService(serviceReference);
    }
}

