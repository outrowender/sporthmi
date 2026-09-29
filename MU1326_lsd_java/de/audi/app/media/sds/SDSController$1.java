/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.SDSController;
import de.audi.atip.interapp.SDSService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SDSController$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SDSController this$0;

    SDSController$1(SDSController sDSController) {
        this.this$0 = sDSController;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        SDSController.access$000(this.this$0).sds().log(1078071040, "[%1.removedService] SDS service removed", (Object)"SDSController");
        SDSController.access$100(this.this$0).releaseService(serviceReference);
        SDSController.access$202(this.this$0, null);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SDSController.access$202(this.this$0, (SDSService)SDSController.access$100(this.this$0).getService(serviceReference));
        SDSController.access$300(this.this$0).sds().log(1078071040, "[%1.addingService] '%2'", (Object)"SDSController", (Object)SDSController.access$200(this.this$0));
        return SDSController.access$200(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

