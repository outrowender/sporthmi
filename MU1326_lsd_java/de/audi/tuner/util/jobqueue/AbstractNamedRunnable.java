/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util.jobqueue;

public abstract class AbstractNamedRunnable
implements Runnable {
    private final String name;

    public AbstractNamedRunnable(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}

