/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.startup.StartupManager;

class StartupManager$LastmodeSWDLReached
implements Runnable {
    final int terminalID;
    private final /* synthetic */ StartupManager this$0;

    public StartupManager$LastmodeSWDLReached(StartupManager startupManager, int n) {
        this.this$0 = startupManager;
        this.terminalID = n;
    }

    public final String toString() {
        return "LastmodeSWDLReached terminalID:";
    }

    @Override
    public final void run() {
        if (StartupManager.access$800(this.this$0).activateLastmodeApp(StartupManager.access$700(this.this$0).getSwdlLastmode(), this.terminalID)) {
            StartupManager.access$800(this.this$0).setLastmode(this.terminalID, StartupManager.access$700(this.this$0).getSwdlLastmode(), false);
            StartupManager.access$902(this.this$0, true);
            StartupManager.access$1000(this.this$0);
            StartupManager.access$300(this.this$0).log(1078071040, "StartupManager: lastmode app is active!");
            this.this$0.switchToBackgroundPriority();
            try {
                StartupManager.access$100(this.this$0).getMsgDistrib().sendMessage(6);
                StartupManager.access$600(this.this$0);
            }
            catch (Exception exception) {
                StartupManager.access$300(this.this$0).log(10000, "StartupManager: Framework.startFull failed!", (Throwable)exception);
                throw new FrameworkException("Full Framework start failed!", exception);
            }
        }
    }
}

