/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.startup.LastmodeHandler;
import de.esolutions.fw.util.commons.Buffer;

class LastmodeHandler$2
implements Runnable {
    int activeAudioAppOnTerminal;
    int terminalId;
    private final /* synthetic */ int[] val$activeAudioApp;
    private final /* synthetic */ IAudioFocusClient val$registeredClient;
    private final /* synthetic */ LastmodeHandler this$0;

    LastmodeHandler$2(LastmodeHandler lastmodeHandler, int[] nArray, IAudioFocusClient iAudioFocusClient) {
        this.this$0 = lastmodeHandler;
        this.val$activeAudioApp = nArray;
        this.val$registeredClient = iAudioFocusClient;
    }

    @Override
    public void run() {
        try {
            for (int i2 = 0; i2 < 8; ++i2) {
                this.terminalId = i2;
                this.activeAudioAppOnTerminal = this.val$activeAudioApp[i2];
                if (this.activeAudioAppOnTerminal == 0) continue;
                this.val$registeredClient.updateAudioFocus(i2, this.activeAudioAppOnTerminal);
            }
        }
        catch (Exception exception) {
            this.this$0.lcAudioDSI.log(10000, "[LastmodeHandler.registerAudioClient] appId:%1 Failed calling  on terminal %2", (long)this.activeAudioAppOnTerminal, (long)this.terminalId);
            this.this$0.lcAudioDSI.log(10000, "[LastmodeHandler.registerAudioClient]", (Throwable)exception);
        }
    }

    public String toString() {
        return new Buffer("UpdateAudioFocusRunnable:").append(" terminalID=").append(this.terminalId).append(" appId=").append(this.activeAudioAppOnTerminal).append(')').toString();
    }
}

