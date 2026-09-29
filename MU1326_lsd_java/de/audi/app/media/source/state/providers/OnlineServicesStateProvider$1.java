/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.source.state.providers.OnlineServicesStateProvider;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class OnlineServicesStateProvider$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ OnlineServicesStateProvider this$0;

    OnlineServicesStateProvider$1(OnlineServicesStateProvider onlineServicesStateProvider) {
        this.this$0 = onlineServicesStateProvider;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        OnlineServicesStateProvider.access$000(this.this$0).log(1078071040, "[%1.addingService]", (Object)"OnlineServicesStateProvider");
        OnlineServiceProvider onlineServiceProvider = (OnlineServiceProvider)OnlineServicesStateProvider.access$100(this.this$0).getService(serviceReference);
        OnlineServicesStateProvider.access$200(this.this$0, onlineServiceProvider);
        return onlineServiceProvider;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        OnlineServicesStateProvider.access$100(this.this$0).releaseService(serviceReference);
        OnlineServicesStateProvider.access$200(this.this$0, null);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

