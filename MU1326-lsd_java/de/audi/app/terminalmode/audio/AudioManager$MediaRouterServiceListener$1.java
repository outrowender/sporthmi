/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$MediaRouterServiceListener;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.atip.interapp.audio.ATIPAudioRoute;

class AudioManager$MediaRouterServiceListener$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ATIPAudioRoute[] val$activeRoutes;
    private final /* synthetic */ AudioManager$MediaRouterServiceListener this$1;

    AudioManager$MediaRouterServiceListener$1(AudioManager$MediaRouterServiceListener audioManager$MediaRouterServiceListener, String string, ATIPAudioRoute[] aTIPAudioRouteArray) {
        this.this$1 = audioManager$MediaRouterServiceListener;
        this.val$activeRoutes = aTIPAudioRouteArray;
        super(string);
    }

    @Override
    public void run() {
        AudioManager.access$300(AudioManager$MediaRouterServiceListener.access$3200(this.this$1)).log(1078071040, "<- [%1.updateActiveAudioRoutes] %2", (Object)"AudioManager.MediaRouterServiceListener", (Object)Arrays2.toString(this.val$activeRoutes));
        AudioManager$MediaRouterServiceListener.access$3300(this.this$1, this.val$activeRoutes);
    }
}

