/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$AudioFocusClient;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;

class AudioManager$AudioFocusClient$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pTerminalID;
    private final /* synthetic */ int val$pAppId;
    private final /* synthetic */ AudioManager$AudioFocusClient this$1;

    AudioManager$AudioFocusClient$1(AudioManager$AudioFocusClient audioManager$AudioFocusClient, String string, int n, int n2) {
        this.this$1 = audioManager$AudioFocusClient;
        this.val$pTerminalID = n;
        this.val$pAppId = n2;
        super(string);
    }

    @Override
    public void run() {
        boolean bl;
        if (0 != this.val$pTerminalID) {
            AudioManager.access$300(AudioManager$AudioFocusClient.access$2200(this.this$1)).log(1078071040, "<- [%1.updateAudioFocus] '%3' (terminalID='%2') Ignore.", (Object)"AudioManager.AudioFocusClient", (long)this.val$pTerminalID, (long)this.val$pAppId);
            return;
        }
        boolean bl2 = bl = this.val$pAppId == 43 || this.val$pAppId == 48;
        if (AudioManager.access$300(AudioManager$AudioFocusClient.access$2200(this.this$1)).isInfo()) {
            AudioManager.access$300(AudioManager$AudioFocusClient.access$2200(this.this$1)).log(1078071040, "<- [%1.updateAudioFocus] '%3' (terminalID='%2')", (Object)"AudioManager.AudioFocusClient", (Object)new Integer(this.val$pTerminalID), (Object)(bl ? "TERMINALMODE" : "OTHER"));
        }
        if (!bl) {
            AudioManager.access$300(AudioManager$AudioFocusClient.access$2200(this.this$1)).log(14808325, "<- [%1.updateAudioFocus] switch off App=%2", (Object)"AudioManager.AudioFocusClient", (long)this.val$pAppId);
            AudioManager.access$2300(AudioManager$AudioFocusClient.access$2200(this.this$1)).setValue(this.val$pAppId);
            AudioManager.access$2402(AudioManager$AudioFocusClient.access$2200(this.this$1), this.val$pAppId);
            AudioManager.access$2000(AudioManager$AudioFocusClient.access$2200(this.this$1)).getChoiceModel(5536).setValue(AudioManager.access$2500(AudioManager$AudioFocusClient.access$2200(this.this$1), AudioManager.access$2400(AudioManager$AudioFocusClient.access$2200(this.this$1))));
            AudioManager.access$2000(AudioManager$AudioFocusClient.access$2200(this.this$1)).getFramework().getStorageMgr().setInt(1008, 2, AudioManager.access$2400(AudioManager$AudioFocusClient.access$2200(this.this$1)));
        } else {
            AudioManager.access$300(AudioManager$AudioFocusClient.access$2200(this.this$1)).log(14808325, "<- [%1.updateAudioFocus] switch off App=Media", (Object)"AudioManager.AudioFocusClient");
            AudioManager.access$2300(AudioManager$AudioFocusClient.access$2200(this.this$1)).setValue(2);
        }
        AudioManager$AudioFocusClient.access$2600(this.this$1, this.val$pTerminalID, bl, true);
    }
}

