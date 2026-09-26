/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.tv.app.TVSDISActivator;
import de.audi.tv.app.TVSDISActivator$1;
import de.audi.tv.app.sdis.NullSDISBlockingService;
import org.osgi.framework.ServiceReference;

class TVSDISActivator$BlockingServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ TVSDISActivator this$0;

    private TVSDISActivator$BlockingServiceTracker(TVSDISActivator tVSDISActivator) {
        this.this$0 = tVSDISActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ISDISBlockingService iSDISBlockingService = (ISDISBlockingService)TVSDISActivator.access$200(this.this$0).getService(serviceReference);
        if (iSDISBlockingService != null) {
            TVSDISActivator.access$300(this.this$0).log(-2137614336, "[TVSDISActivator.BlockingServiceTracker.addingService] Blocking service registered.");
            TVSDISActivator.access$400((TVSDISActivator)this.this$0).parentalEnforcement.setService(iSDISBlockingService);
            return iSDISBlockingService;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TVSDISActivator.access$400((TVSDISActivator)this.this$0).parentalEnforcement.setService(new NullSDISBlockingService());
        TVSDISActivator.access$500(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ TVSDISActivator$BlockingServiceTracker(TVSDISActivator tVSDISActivator, TVSDISActivator$1 tVSDISActivator$1) {
        this(tVSDISActivator);
    }
}

