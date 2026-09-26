/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$1;

class StartupManager$ReleaseMute
implements Runnable {
    private final /* synthetic */ StartupManager this$0;

    private StartupManager$ReleaseMute(StartupManager startupManager) {
        this.this$0 = startupManager;
    }

    @Override
    public void run() {
        StartupManager.access$100(this.this$0).getPowerMgr().releaseStandbyMute();
    }

    public String toString() {
        return "ReleaseMute";
    }

    /* synthetic */ StartupManager$ReleaseMute(StartupManager startupManager, StartupManager$1 startupManager$1) {
        this(startupManager);
    }
}

