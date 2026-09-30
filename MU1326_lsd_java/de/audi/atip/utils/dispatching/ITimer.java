/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

public interface ITimer {
    public void start();

    public void restart();

    public boolean cancel();

    public boolean isRunning();
}

