/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.app.media.audio.AudioManager$1;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener;

class AudioManager$MediaRouterServiceListener
implements ATIPMediaRouterServiceListener {
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$MediaRouterServiceListener(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void updateActiveAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        AudioManager.access$2600(this.this$0).audio().log(1078071040, "[%1.updateActiveAudioRoutes]", (Object)"AudioManager");
        if (this.this$0.filePlayerACStarted) {
            return;
        }
        for (int i2 = 0; i2 < aTIPAudioRouteArray.length; ++i2) {
            if (1 != aTIPAudioRouteArray[i2].getRoutingOutput()) continue;
            this.this$0.currentMPL1Route = aTIPAudioRouteArray[i2].getRoutingInput();
            AudioManager.access$2700(this.this$0).audio().log(1078071040, "[%1.updateActiveAudioRoutes] %2", (Object)"AudioManager", (long)this.this$0.currentMPL1Route);
        }
    }

    /* synthetic */ AudioManager$MediaRouterServiceListener(AudioManager audioManager, AudioManager$1 audioManager$1) {
        this(audioManager);
    }
}

