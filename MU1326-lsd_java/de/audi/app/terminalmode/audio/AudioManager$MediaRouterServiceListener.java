/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$1;
import de.audi.app.terminalmode.audio.AudioManager$MediaRouterServiceListener$1;
import de.audi.app.terminalmode.audio.IMediaRoutesChangeListener;
import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener;
import de.audi.atip.util.Util;
import java.util.Iterator;

final class AudioManager$MediaRouterServiceListener
implements ATIPMediaRouterServiceListener {
    private static final String LOGCLASS;
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$MediaRouterServiceListener(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void updateActiveAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$MediaRouterServiceListener$1(this, "AudioManager.updateActiveAudioRoutes", aTIPAudioRouteArray));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setMediaRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        AudioManager.access$300(this.this$0).log(1078071040, "[%1.setMediaRoutes] %2", (Object)"AudioManager.MediaRouterServiceListener", (Object)Arrays2.toString(aTIPAudioRouteArray));
        Object object = AudioManager.access$3400(this.this$0);
        synchronized (object) {
            for (int i2 = 0; i2 < aTIPAudioRouteArray.length; ++i2) {
                if (26 == aTIPAudioRouteArray[i2].getRoutingInput()) continue;
                AudioManager.access$3500(this.this$0).put(Util.createInteger(aTIPAudioRouteArray[i2].getRoutingOutput()), aTIPAudioRouteArray[i2]);
            }
        }
        this.notifyMediaRoutesChanged();
    }

    private void notifyMediaRoutesChanged() {
        AudioManager.access$300(this.this$0).log(1078071040, "[%1.notifyMediaRoutesChanged]", (Object)"AudioManager.MediaRouterServiceListener");
        Iterator iterator = AudioManager.access$3600(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaRoutesChangeListener)iterator.next()).mediaRoutesChanged();
            }
            catch (Exception exception) {
                AudioManager.access$300(this.this$0).log(10000, "[%1.notifyMediaRoutesChanged]", (Object)"AudioManager.MediaRouterServiceListener", (Throwable)exception);
            }
        }
    }

    /* synthetic */ AudioManager$MediaRouterServiceListener(AudioManager audioManager, AudioManager$1 audioManager$1) {
        this(audioManager);
    }

    static /* synthetic */ AudioManager access$3200(AudioManager$MediaRouterServiceListener audioManager$MediaRouterServiceListener) {
        return audioManager$MediaRouterServiceListener.this$0;
    }

    static /* synthetic */ void access$3300(AudioManager$MediaRouterServiceListener audioManager$MediaRouterServiceListener, ATIPAudioRoute[] aTIPAudioRouteArray) {
        audioManager$MediaRouterServiceListener.setMediaRoutes(aTIPAudioRouteArray);
    }
}

