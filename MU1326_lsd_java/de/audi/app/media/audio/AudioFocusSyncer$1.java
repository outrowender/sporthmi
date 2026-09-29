/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioFocusSyncer;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioFocusSyncer$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AudioFocusSyncer this$0;

    AudioFocusSyncer$1(AudioFocusSyncer audioFocusSyncer) {
        this.this$0 = audioFocusSyncer;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.log.log(1078071040, "[%1.addingService] Audio focus manager found.", (Object)"AudioFocusSyncer");
        this.this$0.audioFocusManager = (IAudioFocusManager)this.this$0.getTerminal().getServiceManager().getService(serviceReference);
        return this.this$0.audioFocusManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.log.log(1078071040, "[%1.addingService] Audio focus manager removed", (Object)"AudioFocusSyncer");
        this.this$0.audioFocusManager = new NullAudioFocusManager(this.this$0.log);
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

