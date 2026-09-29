/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$2(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioManager.access$400(this.this$0).audio().log(1078071040, "[%1.addingService] Audio focus manager found.", (Object)"AudioManager");
        AudioManager.access$502(this.this$0, (IAudioFocusManager)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        return AudioManager.access$500(this.this$0);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$600(this.this$0).audio().log(1078071040, "[%1.addingService] Audio focus manager removed", (Object)"AudioManager");
        AudioManager.access$502(this.this$0, new NullAudioFocusManager(AudioManager.access$700(this.this$0).audio()));
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

