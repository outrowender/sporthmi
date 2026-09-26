/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.audio;

import de.audi.app.messaging.core.audio.AudioManager;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.WavePlayer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class AudioManager$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$1(AudioManager audioManager, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = audioManager;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        if (object instanceof HMIAudioService) {
            AudioManager.access$100(this.this$0, (HMIAudioService)object);
        } else {
            AudioManager.access$200(this.this$0, ((WavePlayer)object).getSystemTonePlayer());
        }
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        if (object instanceof HMIAudioService) {
            AudioManager.access$300(this.this$0);
        } else {
            AudioManager.access$400(this.this$0);
        }
    }
}

