/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AudioManager$6
implements ServiceTrackerCustomizer {
    private final /* synthetic */ IServiceManager val$serviceManager;
    private final /* synthetic */ AudioManager this$0;

    AudioManager$6(AudioManager audioManager, IServiceManager iServiceManager) {
        this.this$0 = audioManager;
        this.val$serviceManager = iServiceManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioManager.access$300(this.this$0).log(14808325, "[%1.addingService] Audio Drawer manager found. %2 ", (Object)"AudioManager", (Object)serviceReference.toString());
        AudioManager.access$802(this.this$0, (AudioDrawerContext)this.val$serviceManager.getService(serviceReference));
        AudioManager.access$900(this.this$0);
        return AudioManager.access$800(this.this$0);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AudioManager.access$300(this.this$0).log(-1601830656, "[%1.addingService] Audio Drawer manager removed", (Object)"AudioManager");
        AudioManager.access$802(this.this$0, null);
        this.val$serviceManager.releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

