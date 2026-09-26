/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPController;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class CombiBAPController$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ CombiBAPController this$0;

    CombiBAPController$1(CombiBAPController combiBAPController) {
        this.this$0 = combiBAPController;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.logCombi.log(1078071040, "[%1.removedService] BAP service removed", (Object)"CombiBAPController");
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
        CombiBAPController.access$002(this.this$0, CombiBAPController.access$100(this.this$0));
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.logCombi.log(1078071040, "[%1.addingService] Found BAP service", (Object)"CombiBAPController");
        CombiBAPController.access$002(this.this$0, (CombiBAPServiceMedia)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        CombiBAPController.access$200(this.this$0);
        return CombiBAPController.access$000(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

