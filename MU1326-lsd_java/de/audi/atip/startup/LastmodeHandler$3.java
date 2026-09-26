/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.startup.LastmodeHandler;
import de.esolutions.fw.util.commons.Buffer;

class LastmodeHandler$3
implements Runnable {
    private final /* synthetic */ IAudioFocusClient[] val$updateClients;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ int val$appId;
    private final /* synthetic */ LastmodeHandler this$0;

    LastmodeHandler$3(LastmodeHandler lastmodeHandler, IAudioFocusClient[] iAudioFocusClientArray, int n, int n2) {
        this.this$0 = lastmodeHandler;
        this.val$updateClients = iAudioFocusClientArray;
        this.val$terminalID = n;
        this.val$appId = n2;
    }

    @Override
    public void run() {
        for (int i2 = 0; i2 < this.val$updateClients.length; ++i2) {
            try {
                this.this$0.lcAudioDSI.log(-2137614336, "[LastmodeHandler.setActiveAudioApp] update audio focus of %1 on terminal %2", (Object)this.val$updateClients[i2], (long)this.val$terminalID);
                this.val$updateClients[i2].updateAudioFocus(this.val$terminalID, this.val$appId);
                continue;
            }
            catch (Exception exception) {
                this.this$0.lcAudioDSI.log(10000, "[LastmodeHandler.setActiveAudioApp] appId:%2 Failed calling %1 on terminal %3", (Object)this.val$updateClients[i2], (long)this.val$appId, (long)this.val$terminalID);
                this.this$0.lcAudioDSI.log(10000, "[LastmodeHandler.setActiveAudioApp]", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return new Buffer("UpdateAudioFocusRunnable:").append(" terminalID=").append(this.val$terminalID).append(" appId=").append(this.val$appId).append(')').toString();
    }
}

