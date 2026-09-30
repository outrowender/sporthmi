/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.screenstate;

public interface IScreenStateListener {
    public void notifyScreenVisible(int var1);

    public void notifyScreenHidden(int var1);

    public void notifyScreenConnected(int var1);

    public void notifyScreenFadedOut(int var1);
}

