/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.interapp.combi.bap.PartialPopupBAPService;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerMMICombi;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class PartialPopupManagerMMICombi$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ PartialPopupManagerMMICombi this$0;

    PartialPopupManagerMMICombi$1(PartialPopupManagerMMICombi partialPopupManagerMMICombi) {
        this.this$0 = partialPopupManagerMMICombi;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.bAPService = (PartialPopupBAPService)PartialPopupManagerMMICombi.access$200(this.this$0).getService(serviceReference);
        return this.this$0.bAPService;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.bAPService = null;
    }
}

