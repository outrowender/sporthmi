/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.OnlineContent;
import de.audi.atip.interapp.audio.ToneService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class OnlineContent$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ OnlineContent this$0;

    OnlineContent$2(OnlineContent onlineContent) {
        this.this$0 = onlineContent;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        OnlineContent.access$1700(this.this$0).main().log(1078071040, "[%1.removedService] tone service removed.", (Object)"OnlineContent");
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
        OnlineContent.access$1802(this.this$0, null);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ToneService toneService = (ToneService)this.this$0.getTerminal().getServiceManager().getService(serviceReference);
        OnlineContent.access$1900(this.this$0).main().log(1078071040, "[%1.addingService] tone service found.", (Object)"OnlineContent");
        OnlineContent.access$1802(this.this$0, toneService);
        if (OnlineContent.access$500(this.this$0).isOnPlayback()) {
            this.this$0.notifyAudioSettings();
        }
        return OnlineContent.access$1800(this.this$0);
    }
}

