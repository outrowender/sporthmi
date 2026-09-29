/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IViewSizeManager;

public interface IScreenChangeManager {
    default public int getScreenChangeState() {
    }

    default public void reinitScreen(IScreenData iScreenData, boolean bl) {
    }

    default public void removeCurrentConnectedPopup(IScreenData iScreenData) {
    }

    default public void showHighestPrioPopup(IScreenData iScreenData) {
    }

    default public void showScreen(IScreenData iScreenData) {
    }

    default public void setFocus(int n) {
    }

    default public Screen getScreen(IScreenData iScreenData) {
    }

    default public void notifyScreenFadedOut(Screen screen) {
    }

    default public void notifyScreenConnected(Screen screen) {
    }

    default public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
    }

    default public IViewSizeManager getViewSizeManager() {
    }
}

