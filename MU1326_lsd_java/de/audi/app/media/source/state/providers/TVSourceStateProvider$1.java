/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.source.state.providers.TVSourceStateProvider;
import de.audi.atip.interapp.tv.ITVService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TVSourceStateProvider$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TVSourceStateProvider this$0;

    TVSourceStateProvider$1(TVSourceStateProvider tVSourceStateProvider) {
        this.this$0 = tVSourceStateProvider;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TVSourceStateProvider.access$000(this.this$0).log(1078071040, "[%1.addingService]", (Object)"TVSourceStateProvider");
        ITVService iTVService = (ITVService)TVSourceStateProvider.access$100(this.this$0).getService(serviceReference);
        this.this$0.updateTVService(iTVService);
        return iTVService;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TVSourceStateProvider.access$000(this.this$0).log(1078071040, "[%1.removedService]", (Object)"TVSourceStateProvider");
        TVSourceStateProvider.access$100(this.this$0).releaseService(serviceReference);
        this.this$0.updateTVService(null);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

