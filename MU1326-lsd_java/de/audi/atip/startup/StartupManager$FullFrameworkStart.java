/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$1;

class StartupManager$FullFrameworkStart
implements Runnable {
    private final /* synthetic */ StartupManager this$0;

    private StartupManager$FullFrameworkStart(StartupManager startupManager) {
        this.this$0 = startupManager;
    }

    public final String toString() {
        return "FullFrameworkStart";
    }

    @Override
    public final void run() {
        try {
            StartupManager.access$600(this.this$0);
        }
        catch (Exception exception) {
            this.this$0.logStartupEvent(StartupManager.access$300(this.this$0), 10000, "FullFrameworkStart#run() - Full Framework start failed!", exception);
            throw new FrameworkException("Full Framework start failed!", exception);
        }
    }

    /* synthetic */ StartupManager$FullFrameworkStart(StartupManager startupManager, StartupManager$1 startupManager$1) {
        this(startupManager);
    }
}

