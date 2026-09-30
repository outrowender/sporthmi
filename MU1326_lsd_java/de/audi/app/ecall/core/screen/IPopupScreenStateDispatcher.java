/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.screen;

import de.audi.app.ecall.core.screen.IPopupStateListener;
import de.audi.app.ecall.core.screen.IScreenStateListener;

public interface IPopupScreenStateDispatcher {
    public void init();

    public void deinit();

    public void addPopupStateListener(int var1, IPopupStateListener var2);

    public void removePopupStateListener(int var1, IPopupStateListener var2);

    public void addScreenStateListener(int var1, IScreenStateListener var2);

    public void removeScreenStateListener(int var1, IScreenStateListener var2);

    public void notifyPopupVisible(int var1, int var2);

    public void notifyPopupHidden(int var1, int var2);

    public void notifyPopupRemoved(int var1, int var2);

    public void notifyScreenVisible(int var1, int var2);

    public void notifyScreenHidden(int var1, int var2);

    public void notifyScreenFadedOut(int var1, int var2);

    public void notifyScreenConnected(int var1, int var2);
}

