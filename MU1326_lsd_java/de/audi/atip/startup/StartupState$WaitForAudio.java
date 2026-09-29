/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupState;
import de.audi.atip.startup.StartupState$1;

class StartupState$WaitForAudio
implements Runnable {
    private final /* synthetic */ StartupState this$0;

    private StartupState$WaitForAudio(StartupState startupState) {
        this.this$0 = startupState;
    }

    public String toString() {
        return "WaitForAudio()";
    }

    @Override
    public void run() {
        if (StartupState.access$100(this.this$0).isSMRunning() && StartupState.access$200(this.this$0)) {
            StartupState.access$300(this.this$0).log(1078071040, "StartupState: waiting for Audio");
            this.this$0.getSyncAudio().waitForTrigger();
            if (!this.this$0.getSyncAudio().isTriggered()) {
                StartupState.access$100(this.this$0).logStartupEvent(StartupState.access$300(this.this$0), 10000, "WaitForAudio#run() - Waiting for Audio timed out!");
            }
            StartupState.access$300(this.this$0).log(1078071040, "StartupState: waiting for Audio done!");
        }
    }

    /* synthetic */ StartupState$WaitForAudio(StartupState startupState, StartupState$1 startupState$1) {
        this(startupState);
    }
}

