/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.AbstractMenuIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public class MenuMergeTimerController
extends AbstractMenuIdleTimerController
implements IMenuCallback {
    public MenuMergeTimerController() {
        super(menuLogCh);
        this.startTimerAutomatically = true;
        this.fireWhenOptionDrawerOpen = false;
        this.fireWhenSelectionDrawerOpen = false;
        this.fireWhenSdsActive = false;
        this.fireWhenScrollAnimationRunning = false;
        this.fireWhenTouchfieldFocused = false;
        this.fireWhenMoveModeActive = false;
        this.idleTime = 0;
    }

    @Override
    protected void timerFired() {
        MenuController menuController = this.getMenu();
        if (menuController != null) {
            menuController.mergeCursors(FocusAdvice.KEEP_POSITION);
        }
    }

    @Override
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
        this.keepCursorsMerged(menuItemIndex, l, menuUpdateDelta);
    }

    private void keepCursorsMerged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
        MenuController menuController = this.getMenu();
        if (menuController == null) {
            return;
        }
        MenuItemIndex menuItemIndex2 = menuController.getFocusedIndex();
        if (menuUpdateDelta != null) {
            if (!menuUpdateDelta.cursorMergeEnabled) {
                return;
            }
            if (menuUpdateDelta.getOldFocusedIndex() != null) {
                menuItemIndex2 = menuUpdateDelta.getOldFocusedIndex();
            }
            if (menuUpdateDelta.getOldSelectedIndex() != null) {
                menuItemIndex = menuUpdateDelta.getOldSelectedIndex();
            }
        }
        if (this.isMerged(menuItemIndex2, menuItemIndex, menuController) && this.shouldExecuteAction()) {
            menuLogCh.log(-2137614336, "MenuMergeTimerController#menuSelectionChanged: move focus (%1) with selection to stay merged", (Object)menuItemIndex2);
            menuController.mergeCursors(this.getFocusAdviceForKeepMerged(menuController, l));
        }
    }

    boolean isMerged(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, MenuController menuController) {
        if (menuItemIndex == null || menuItemIndex2 == null) {
            return false;
        }
        if (menuItemIndex2.equals(menuItemIndex)) {
            return true;
        }
        if (menuController.isMenuItemFocusable(menuItemIndex)) {
            return false;
        }
        MenuItemIndex menuItemIndex3 = menuController.getUnfocusableVisibleEdge(menuItemIndex, false);
        MenuItemIndex menuItemIndex4 = menuController.getUnfocusableVisibleEdge(menuItemIndex, true);
        return !menuItemIndex2.isBefore(menuItemIndex3) && !menuItemIndex4.isBefore(menuItemIndex2);
    }

    private FocusAdvice getFocusAdviceForKeepMerged(MenuController menuController, Long l) {
        if (l != null && Util.equals(l, menuController.getSelectedUniqueID())) {
            return menuController.createFocusAdviceForCursorPosition();
        }
        return FocusAdvice.KEEP_POSITION;
    }

    @Override
    public void menuLayouted() {
    }

    @Override
    public void viewportUpdated(boolean bl) {
    }

    @Override
    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    @Override
    public void menuFocusChangeFinished() {
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
    }

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

