/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.esolutions.fw.util.commons.Buffer;

public class SkipJob
implements Runnable {
    private final IPlayerModificationListener playerModificationListener;
    private final int count;
    private final String logClass;

    public SkipJob(IPlayerModificationListener iPlayerModificationListener, int n, String string) {
        this.playerModificationListener = iPlayerModificationListener;
        this.count = n;
        this.logClass = string;
    }

    @Override
    public void run() {
        this.playerModificationListener.skip(this.count > 0, Math.abs(this.count));
    }

    public String toString() {
        return new Buffer().append(this.logClass).append(".skip(").append(this.count).append(")").toString();
    }
}

