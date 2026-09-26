/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupManager;

final class StartupManager$LogEvent {
    private final long timestamp;
    private final String msg;
    private final /* synthetic */ StartupManager this$0;

    StartupManager$LogEvent(StartupManager startupManager, String string) {
        this.this$0 = startupManager;
        this.timestamp = startupManager.getFramework().getMonotonicTime();
        this.msg = string;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.timestamp).append("] ").append(this.msg).toString();
    }
}

