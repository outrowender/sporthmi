/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.evo.source.SourceHMIHandler;
import de.audi.atip.interapp.phone.ITelServiceMedia;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SourceHMIHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SourceHMIHandler this$0;

    SourceHMIHandler$1(SourceHMIHandler sourceHMIHandler) {
        this.this$0 = sourceHMIHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        SourceHMIHandler.access$002(this.this$0, null);
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SourceHMIHandler.access$100(this.this$0).main().log(1078071040, "[%1.addingService] Phone service found.", (Object)"SourceHMIHandler");
        SourceHMIHandler.access$002(this.this$0, (ITelServiceMedia)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        return SourceHMIHandler.access$000(this.this$0);
    }
}

