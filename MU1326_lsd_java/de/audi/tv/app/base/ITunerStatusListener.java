/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

public interface ITunerStatusListener {
    default public void onTunerAvailable() {
    }

    default public void onTunerUnavailable() {
    }

    default public void onEsmEntered() {
    }

    default public void onEsmLeft() {
    }

    default public void onDsiLockStateChanged(boolean bl) {
    }

    default public void onHighTemperatureShutdown() {
    }
}

