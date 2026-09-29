/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$4
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$4(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$1200(this.this$0).audio().log(-1601830656, "[%1.removedService]", (Object)"AudioManager");
        AudioManager.access$1302(this.this$0, null);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioManager.access$1400(this.this$0).audio().log(14808325, "[%1.addingService] Media router serrive found.", (Object)"AudioManager");
        AudioManager.access$1302(this.this$0, (ATIPMediaRouterService)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        return AudioManager.access$1300(this.this$0);
    }
}

