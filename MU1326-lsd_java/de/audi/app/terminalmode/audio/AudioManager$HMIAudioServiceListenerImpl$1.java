/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;

class AudioManager$HMIAudioServiceListenerImpl$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$available;
    private final /* synthetic */ AudioManager$HMIAudioServiceListenerImpl this$1;

    AudioManager$HMIAudioServiceListenerImpl$1(AudioManager$HMIAudioServiceListenerImpl audioManager$HMIAudioServiceListenerImpl, String string, boolean bl) {
        this.this$1 = audioManager$HMIAudioServiceListenerImpl;
        this.val$available = bl;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object = AudioManager.access$2700(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1));
        synchronized (object) {
            AudioManager.access$300(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).log(1078071040, "<- [%1.updateAMAvailable] '%2'", (Object)"AudioManager.HMIAudioServiceListenerImpl", (Object)(this.val$available ? "AVAILABLE" : "NOT AVAILABLE"));
            AudioManager.access$3802(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1), this.val$available);
            if (AudioManager.access$3800(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1))) {
                AudioManager.access$3902(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1), 0);
                AudioManager.access$4000(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1));
            }
        }
    }
}

