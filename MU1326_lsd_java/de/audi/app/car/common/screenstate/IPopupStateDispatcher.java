/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.screenstate;

import de.audi.app.car.common.screenstate.IPartialPopupStateListener;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.app.car.common.screenstate.IScreenStateListener;

public interface IPopupStateDispatcher {
    public void init();

    public void deinit();

    public void addPopupStateListener(int var1, IPopupStateListener var2);

    public void removePopupStateListener(int var1, IPopupStateListener var2);

    public void addScreenStateListener(int var1, IScreenStateListener var2);

    public void removeScreenStateListener(int var1, IScreenStateListener var2);

    public void addPartialPopupStateListener(int var1, IPartialPopupStateListener var2);

    public void removePartialPopupStateListener(int var1, IPartialPopupStateListener var2);

    public void notifyPopupVisible(int var1, int var2);

    public void notifyPopupHidden(int var1, int var2);

    public void notifyPopupRemoved(int var1, int var2);

    public void notifyScreenVisible(int var1, int var2);

    public void notifyScreenHidden(int var1, int var2);

    public void notifyScreenFadedOut(int var1, int var2);

    public void notifyScreenConnected(int var1, int var2);
}

