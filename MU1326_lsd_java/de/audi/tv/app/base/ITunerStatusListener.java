/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

public interface ITunerStatusListener {
    public void onTunerAvailable();

    public void onTunerUnavailable();

    public void onEsmEntered();

    public void onEsmLeft();

    public void onDsiLockStateChanged(boolean var1);

    public void onHighTemperatureShutdown();
}

