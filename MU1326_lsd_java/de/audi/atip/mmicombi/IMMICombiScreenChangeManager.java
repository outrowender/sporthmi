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
    public static final int REQUESTED_TYPE_UNDEFINED = 0;
    public static final int REQUESTED_TYPE_SHOW_SCREEN = 1;
    public static final int REQUESTED_TYPE_SHOW_POPUP = 2;
    public static final int REQUESTED_TYPE_REMOVE_POPUP = 3;
    public static final int REQUESTED_TYPE_VIEW_SIZE_CHANGED = 4;
    public static final int REQUESTED_TYPE_DRAWER_STATE_CHANGED = 5;
    public static final int REQUESTED_TYPE_MMI_OFF_CHANGED = 6;
    public static final int REQUESTED_TYPE_POPUP_QUIT = 7;

    public int getCurrentMMICombiContext();

    public MMICombiDisplayStatus getLastConfirmedDisplayStatus();

    public void setScreenChangeManager(IScreenChangeManager var1);

    public void setPopupManager(IMMICombiPopupManager var1);

    public int getMappedMMICombiContext(int var1);

    public void setMMIOff(boolean var1);

    public IMMICombiEventListener getMMICombiEventListener();

    public int getDrawerState();

    public void requestPopupQuit();

    public IViewSizeManager getViewSizeManager();

    public void setKdKVisible(boolean var1);
}

