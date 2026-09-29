/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.app.media.audio.NullToneService;
import de.audi.atip.interapp.audio.ToneService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$5
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$5(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$1500(this.this$0).audio().log(-1601830656, "[%1.removedService]", (Object)"AudioManager");
        AudioManager.access$1602(this.this$0, new NullToneService(AudioManager.access$1700(this.this$0).audio()));
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$1800(this.this$0).audio().log(-1601830656, "[%1.modifiedService]", (Object)"AudioManager");
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioManager.access$1900(this.this$0).audio().log(14808325, "[%1.addingService] media tone service found.", (Object)"AudioManager");
        AudioManager.access$1602(this.this$0, (ToneService)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        return AudioManager.access$1600(this.this$0);
    }
}

