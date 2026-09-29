/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.LastmodeHandler;
import de.esolutions.fw.util.commons.Buffer;

class LastmodeHandler$1
implements Runnable {
    private final /* synthetic */ int val$lastmode;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ LastmodeHandler this$0;

    LastmodeHandler$1(LastmodeHandler lastmodeHandler, int n, int n2) {
        this.this$0 = lastmodeHandler;
        this.val$lastmode = n;
        this.val$terminalID = n2;
    }

    public String toString() {
        Buffer buffer = new Buffer(32);
        buffer.append("enqueueLastmodeChange(").append(this.val$lastmode).append(')');
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void run() {
        int n = this.val$lastmode;
        if (LastmodeHandler.access$000(this.this$0, this.val$lastmode)) {
            this.this$0.logChannel.log(1078071040, "LastmodeHandler: process ENTERTAINMENT lastmode");
            n = this.this$0.getLastmodeAudio(this.val$terminalID);
            if (-1 == n) {
                this.this$0.logChannel.log(10000, "LastmodeHandler#enqueueLastmodeChange: the last mode audio isn't defined yet!");
                n = 1;
            }
        }
        if (this.this$0.isValidLastmode(n)) {
            try {
                this.this$0.logChannel.log(-2137614336, "LastmodeHandler: freezeQueues! ");
                LastmodeHandler.access$100(this.this$0).getStartupDispatcher().suspend();
                if (this.this$0.getLastmode(this.val$terminalID) != n) {
                    int n2 = this.this$0.getLastmodeAudio(this.val$terminalID);
                    if (!this.this$0.isLastmodeAudioReached(this.val$terminalID)) {
                        if (this.this$0.isValidAudioLastmode(n) && n != n2) {
                            this.this$0.logChannel.log(1078071040, "LastmodeHandler: lastmode audio changed to %1, before %2 was completely restored!", (long)n, (long)n2);
                            this.this$0.setLastmodeAudio(this.val$terminalID, n);
                            LastmodeHandler.access$200(this.this$0, this.val$terminalID);
                        }
                        this.this$0.setLastmode(this.val$terminalID, n, true);
                        LastmodeHandler.access$300(this.this$0, this.val$terminalID);
                        return;
                    }
                    if (!LastmodeHandler.access$400(this.this$0, this.val$terminalID)) {
                        boolean bl;
                        this.this$0.logChannel.log(1078071040, "LastmodeHandler: lastmode app changed to %1, before %2 was completely restored!", (long)n, (long)this.this$0.getLastmode(this.val$terminalID));
                        this.this$0.setLastmode(this.val$terminalID, n, true);
                        boolean bl2 = bl = n2 != this.this$0.getLastmodeAudio(this.val$terminalID);
                        if (bl) {
                            LastmodeHandler.access$500(this.this$0, this.val$terminalID);
                        }
                        LastmodeHandler.access$600(this.this$0, this.val$terminalID).cancel();
                        LastmodeHandler.access$700(this.this$0, this.val$terminalID, false);
                        LastmodeHandler.access$100(this.this$0).getSyncNav().cancel();
                        LastmodeHandler.access$100(this.this$0).getSyncSDS().cancel();
                        this.this$0.logChannel.log(1078071040, "LastmodeHandler: lastmode app change enqueued!");
                        return;
                    }
                    this.this$0.logChannel.log(1078071040, "LastmodeHandler: change to %1, after %2 was restored!", (long)n, (long)this.this$0.getLastmode(this.val$terminalID));
                    this.this$0.setLastmode(this.val$terminalID, n, true);
                    ComponentState componentState = LastmodeHandler.access$100(this.this$0).getComponentState(n);
                    if (componentState == null || componentState.isStarted() || LastmodeHandler.access$100(this.this$0).getAppStateManager().mustWaitForMU(componentState.getDomainId())) return;
                    int n3 = this.val$terminalID;
                    if (this.val$terminalID == -1) {
                        n3 = this.this$0.availableTerminalIDs[0];
                    }
                    if (n2 != n && this.this$0.isValidAudioLastmode(n)) {
                        LastmodeHandler.access$500(this.this$0, n3);
                    }
                    componentState.enqueueStartFull(LastmodeHandler.access$800(this.this$0, n3).getLastmodeAppQueue(), true);
                    LastmodeHandler.access$100(this.this$0).getSyncNav().cancel();
                    LastmodeHandler.access$100(this.this$0).getSyncSDS().cancel();
                    return;
                }
                this.this$0.logChannel.log(1078071040, "LastmodeHandler: skip enqueueLastModeChange, because the Lastmode is the same!");
                return;
            }
            finally {
                LastmodeHandler.access$100(this.this$0).getStartupDispatcher().resume();
                this.this$0.logChannel.log(-2137614336, "LastmodeHandler: unfreezeQueues! ");
            }
        } else {
            this.this$0.logChannel.log(10000, "LastmodeHandler.enqueueLastmodeChange(): %1 is not a valid LastMode!", (long)n);
        }
    }
}

