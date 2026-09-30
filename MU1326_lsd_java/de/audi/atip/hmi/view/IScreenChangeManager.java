/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IViewSizeManager;

public interface IScreenChangeManager {
    public int getScreenChangeState();

    public void reinitScreen(IScreenData var1, boolean var2);

    public void removeCurrentConnectedPopup(IScreenData var1);

    public void showHighestPrioPopup(IScreenData var1);

    public void showScreen(IScreenData var1);

    public void setFocus(int var1);

    public Screen getScreen(IScreenData var1);

    public void notifyScreenFadedOut(Screen var1);

    public void notifyScreenConnected(Screen var1);

    public void setViewSizeManager(IViewSizeManager var1);

    public IViewSizeManager getViewSizeManager();
}

