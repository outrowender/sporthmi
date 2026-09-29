/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.atip.utils.reactive.properties.Property;

class AudioManager$HMIAudioServiceListenerImpl$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pConnection;
    private final /* synthetic */ int val$pTerminalID;
    private final /* synthetic */ AudioManager$HMIAudioServiceListenerImpl this$1;

    AudioManager$HMIAudioServiceListenerImpl$4(AudioManager$HMIAudioServiceListenerImpl audioManager$HMIAudioServiceListenerImpl, String string, int n, int n2) {
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
            ((Property)AudioManager.access$4200(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).get((Object)new Integer(this.val$pConnection))).accept(AudioState.STARTED);
        }
        Object object = AudioManager.access$2700(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1));
        synchronized (object) {
            if (!AudioManager.access$1700(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).isActiveAudioConnection(this.val$pConnection)) {
                return;
            }
            AudioManager.access$300(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).log(1078071040, "<- [%1.startConnection] %2", (Object)"AudioManager.HMIAudioServiceListenerImpl", (long)this.val$pConnection);
            if (AudioManager.access$1700(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).getState(this.val$pConnection).is(AudioState.RELEASED)) {
                return;
            }
            AudioManager$HMIAudioServiceListenerImpl.access$4300(this.this$1, "startConnection", this.val$pConnection, this.val$pTerminalID, AudioState.STARTED);
            AudioConnectionState audioConnectionState = AudioManager.access$1700(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1)).getAudioConnectionState(this.val$pConnection);
            AudioManager.access$4400(AudioManager$HMIAudioServiceListenerImpl.access$3700(this.this$1), audioConnectionState);
        }
    }
}

