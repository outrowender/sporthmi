/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

public abstract class AbstractDispatcherRunnable
implements Runnable {
    private final String logStr;

    public AbstractDispatcherRunnable(String string) {
        this.logStr = string;
    }

    public String toString() {
        return this.logStr;
    }
}

