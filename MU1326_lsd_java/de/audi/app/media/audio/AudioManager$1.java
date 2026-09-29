/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$1(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
        if (!HMIAudioService.CLIENT_MEDIA.equals(object2)) {
            return;
        }
        AudioManager.access$000(this.this$0).audio().log(1078071040, "[%1.removedService] Audio service removed.", (Object)"AudioManager");
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
        AudioManager.access$200(this.this$0, new NullHMIAudioService(AudioManager.access$100(this.this$0).audio()));
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = serviceReference.getProperty("AUDIO_CLIENT_ID");
        if (!HMIAudioService.CLIENT_MEDIA.equals(object)) {
            return null;
        }
        Object object2 = this.this$0.getTerminal().getServiceManager().getService(serviceReference);
        AudioManager.access$300(this.this$0).audio().log(1078071040, "[%1.addingService] Audio service found.", (Object)"AudioManager");
        AudioManager.access$200(this.this$0, (HMIAudioService)object2);
        return object2;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

