/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ IServiceManager val$serviceManager;
    private final /* synthetic */ AudioManager this$0;

    AudioManager$2(AudioManager audioManager, IServiceManager iServiceManager) {
        this.this$0 = audioManager;
        this.val$serviceManager = iServiceManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
        if (!HMIAudioService.CLIENT_MEDIA.equals(object2)) {
            return;
        }
        AudioManager.access$300(this.this$0).log(-1601830656, "[%1.removedService] Audio service removed.", (Object)"AudioManager");
        this.val$serviceManager.releaseService(serviceReference);
        AudioManager.access$400(this.this$0, new NullHMIAudioService(AudioManager.access$300(this.this$0)));
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = serviceReference.getProperty("AUDIO_CLIENT_ID");
        if (!HMIAudioService.CLIENT_MEDIA.equals(object)) {
            return null;
        }
        Object object2 = this.val$serviceManager.getService(serviceReference);
        AudioManager.access$300(this.this$0).log(14808325, "[%1.addingService] Audio service found.", (Object)"AudioManager");
        AudioManager.access$400(this.this$0, (HMIAudioService)object2);
        return object2;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

