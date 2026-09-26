/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Monitor;

public abstract class AbstractArrayJobListMonitor
extends Monitor {
    public AbstractArrayJobListMonitor(LogChannel logChannel) {
        super(logChannel);
    }

    public abstract void notifyJobFinished(int n) {
    }

    public abstract void notifyJobCancelled(int n) {
    }
}

