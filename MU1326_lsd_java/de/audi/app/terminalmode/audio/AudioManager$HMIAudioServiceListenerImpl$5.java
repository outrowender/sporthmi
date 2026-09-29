/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.atip.utils.reactive.properties.Property;

class AudioManager$HMIAudioServiceListenerImpl$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pConnection;
    private final /* synthetic */ int val$pTerminalID;
    private final /* synthetic */ AudioManager$HMIAudioServiceListenerImpl this$1;

    AudioManager$HMIAudioServiceListenerImpl$5(AudioManager$HMIAudioServiceListenerImpl audioManager$HMIAudioServiceListenerImpl, String string, int n, int n2) {
        this.this$1 = audioManager$HMIAudioServiceListenerImpl;
        this.val$pConnection = n;
        this.val$pTerminalID = n2;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        if (AudioManager.access$4200(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).containsKey((Object)new Integer(this.val$pConnection))) {
            ((Property)AudioManager.access$4200(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).get((Object)new Integer(this.val$pConnection))).accept(AudioState.ERROR);
        }
        Object object = AudioManager.access$2700(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1));
        synchronized (object) {
            if (!AudioManager.access$1700(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).isActiveAudioConnection(this.val$pConnection)) {
                return;
            }
            if (AudioManager$HMIAudioServiceListenerImpl.access$4300(this.this$1, "errorConnection", this.val$pConnection, this.val$pTerminalID, AudioState.ERROR)) {
                if (!AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1).hasAudioFocus()) {
                    return;
                }
                if (3 >= AudioManager.access$3900(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1))) {
                    AudioManager.access$300(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).log(1078071040, "<- [%1.errorConnection] Max retries reached.", (Object)"AudioManager.HMIAudioServiceListenerImpl");
                    return;
                }
                AudioManager.access$300(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).log(1078071040, "<- [%1.errorConnection] Request connection again", (Object)"AudioManager.HMIAudioServiceListenerImpl");
                AudioManager.access$3908(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1));
                AudioManager.access$1800(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).requestConnection(this.val$pConnection, AudioManager.access$2000(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).getTerminalId(), 0);
            }
        }
    }
}

