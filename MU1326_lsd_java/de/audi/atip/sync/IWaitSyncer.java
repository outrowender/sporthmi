/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sync;

public interface IWaitSyncer {
    default public boolean isTriggered() {
    }

    default public boolean isWaiting() {
    }

    default public void waitForTrigger() {
    }

    default public void trigger() {
    }

    default public void cancel() {
    }
}

