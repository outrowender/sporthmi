/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sync;

public interface IWaitSyncer {
    public boolean isTriggered();

    public boolean isWaiting();

    public void waitForTrigger();

    public void trigger();

    public void cancel();
}

