/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$3
implements ServiceTrackerCustomizer {
    private final /* synthetic */ IServiceManager val$serviceManager;
    private final /* synthetic */ AudioManager this$0;

    AudioManager$3(AudioManager audioManager, IServiceManager iServiceManager) {
        this.this$0 = audioManager;
        this.val$serviceManager = iServiceManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioManager.access$300(this.this$0).log(14808325, "[%1.addingService] Audio focus manager found.", (Object)"AudioManager");
        AudioManager.access$502(this.this$0, (IAudioFocusManager)this.val$serviceManager.getService(serviceReference));
        return AudioManager.access$500(this.this$0);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$300(this.this$0).log(-1601830656, "[%1.removedService] Audio focus manager removed", (Object)"AudioManager");
        AudioManager.access$502(this.this$0, new NullAudioFocusManager(AudioManager.access$300(this.this$0)));
        this.val$serviceManager.releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

