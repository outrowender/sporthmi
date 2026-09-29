/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IScreenChangeManager;
import de.audi.atip.mmicombi.IMMICombiEventListener;
import de.audi.atip.mmicombi.IMMICombiPopupManager;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;

public interface IMMICombiScreenChangeManager {
    public static final int REQUESTED_TYPE_UNDEFINED;
    public static final int REQUESTED_TYPE_SHOW_SCREEN;
    public static final int REQUESTED_TYPE_SHOW_POPUP;
    public static final int REQUESTED_TYPE_REMOVE_POPUP;
    public static final int REQUESTED_TYPE_VIEW_SIZE_CHANGED;
    public static final int REQUESTED_TYPE_DRAWER_STATE_CHANGED;
    public static final int REQUESTED_TYPE_MMI_OFF_CHANGED;
    public static final int REQUESTED_TYPE_POPUP_QUIT;

    default public int getCurrentMMICombiContext() {
    }

    default public MMICombiDisplayStatus getLastConfirmedDisplayStatus() {
    }

    default public void setScreenChangeManager(IScreenChangeManager iScreenChangeManager) {
    }

    default public void setPopupManager(IMMICombiPopupManager iMMICombiPopupManager) {
    }

    default public int getMappedMMICombiContext(int n) {
    }

    default public void setMMIOff(boolean bl) {
    }

    default public IMMICombiEventListener getMMICombiEventListener() {
    }

    default public int getDrawerState() {
    }

    default public void requestPopupQuit() {
    }

    default public IViewSizeManager getViewSizeManager() {
    }

    default public void setKdKVisible(boolean bl) {
    }
}

