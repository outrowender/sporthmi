/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.screen;

public interface IScreenStateListener {
    public void screenVisible(int var1);

    public void screenHidden(int var1);

    public void notifyScreenConnected(int var1);

    public void notifyScreenFadedOut(int var1);
}

