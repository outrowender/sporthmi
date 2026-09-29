/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.NullToneService;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.interapp.audio.ToneService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$5
implements ServiceTrackerCustomizer {
    private final /* synthetic */ IServiceManager val$serviceManager;
    private final /* synthetic */ AudioManager this$0;

    AudioManager$5(AudioManager audioManager, IServiceManager iServiceManager) {
        this.this$0 = audioManager;
        this.val$serviceManager = iServiceManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$300(this.this$0).log(-1601830656, "[%1.removedService]", (Object)"AudioManager");
        AudioManager.access$702(this.this$0, new NullToneService(AudioManager.access$300(this.this$0)));
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioManager.access$300(this.this$0).log(14808325, "[%1.addingService] tone service found.", (Object)"AudioManager");
        AudioManager.access$702(this.this$0, (ToneService)this.val$serviceManager.getService(serviceReference));
        return AudioManager.access$700(this.this$0);
    }
}

