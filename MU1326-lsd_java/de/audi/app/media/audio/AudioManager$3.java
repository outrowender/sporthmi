/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$3
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$3(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioManager.access$800(this.this$0).audio().log(1078071040, "[%1.addingService] Audio Drawer manager found.", (Object)"AudioManager");
        AudioManager.access$902(this.this$0, (AudioDrawerContext)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        AudioManager.access$1000(this.this$0);
        return AudioManager.access$900(this.this$0);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$1100(this.this$0).audio().log(1078071040, "[%1.addingService] Audio Drawer manager removed", (Object)"AudioManager");
        AudioManager.access$902(this.this$0, null);
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

