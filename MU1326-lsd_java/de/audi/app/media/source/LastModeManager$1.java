/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.LastModeManager;

class LastModeManager$1
implements Runnable {
    private final /* synthetic */ LastModeManager this$0;

    LastModeManager$1(LastModeManager lastModeManager) {
        this.this$0 = lastModeManager;
    }

    @Override
    public void run() {
        LastModeManager.access$000(this.this$0).main().log(1078071040, "[%1.onStartupFinished]", (Object)"LastModeManager");
        LastModeManager.access$100(this.this$0);
    }

    public String toString() {
        return "LastModeManager.onStartupFinished";
    }
}

