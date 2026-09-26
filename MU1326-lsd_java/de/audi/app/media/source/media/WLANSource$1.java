/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.source.media.WLANSource;
import de.audi.atip.interapp.WlanService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class WLANSource$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ WLANSource this$0;

    WLANSource$1(WLANSource wLANSource) {
        this.this$0 = wLANSource;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        WLANSource.access$000(this.this$0).main().log(1078071040, "[%1.removedService] WLAN service removed.", (Object)"WLANSource");
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
        WLANSource.access$102(this.this$0, null);
        WLANSource.access$202(this.this$0, null);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        WlanService wlanService = (WlanService)this.this$0.getTerminal().getServiceManager().getService(serviceReference);
        WLANSource.access$300(this.this$0).main().log(1078071040, "[%1.addingService] WLAN service found.", (Object)"WLANSource");
        WLANSource.access$102(this.this$0, wlanService);
        return WLANSource.access$100(this.this$0);
    }
}

