/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.interapp.ISourceActivator;

class NullSourceActivator
implements ISourceActivator {
    private LogChannel log;

    public NullSourceActivator(LogChannel logChannel) {
        this.log = logChannel;
    }

    @Override
    public void activate(int n) {
        this.log.log(-1601830656, "[NullCombiSourceActivator.activate] source: %1", (long)n);
    }
}

