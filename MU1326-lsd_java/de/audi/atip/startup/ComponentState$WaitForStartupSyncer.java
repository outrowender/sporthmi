/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.ComponentState$1;
import de.audi.atip.startup.StartupSyncer;
import de.esolutions.fw.util.commons.Buffer;

class ComponentState$WaitForStartupSyncer
implements Runnable {
    private final StartupSyncer sync;

    private ComponentState$WaitForStartupSyncer(StartupSyncer startupSyncer) {
        this.sync = startupSyncer;
    }

    public String toString() {
        return new Buffer(50).append("WaitForStartupSyncer(").append(this.sync).append(')').toString();
    }

    @Override
    public void run() {
        this.sync.waitForTrigger();
    }

    /* synthetic */ ComponentState$WaitForStartupSyncer(StartupSyncer startupSyncer, ComponentState$1 componentState$1) {
        this(startupSyncer);
    }
}

