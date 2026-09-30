/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.AbstractMenuIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class InfolineTimerController
extends AbstractMenuIdleTimerController {
    public InfolineTimerController() {
        super(menuLogCh);
        this.startTimerAutomatically = false;
        this.fireWhenOptionDrawerOpen = false;
        this.fireWhenSelectionDrawerOpen = false;
        this.fireWhenSdsActive = false;
        this.fireWhenScrollAnimationRunning = false;
        this.fireWhenTouchfieldFocused = false;
        this.fireWhenFocusPopupOpen = false;
        this.fireWhenMoveModeActive = false;
        this.idleTime = 11000;
    }

    protected void timerFired() {
        MenuController menuController = this.getMenu();
        if (menuController != null) {
            menuController.showInfolineOnFocusedItem(false);
            this.triggerRepaint();
        }
    }

    protected boolean shouldExecuteActionInMenu(MenuController menuController) {
        if (!super.shouldExecuteActionInMenu(menuController)) {
            return false;
        }
        if (!this.hasFocusedItem(menuController)) {
            this.lc.log(10000000, "%1#shouldExecuteActionInMenu: no focused item.", (Object)this.logPrefix);
            return false;
        }
        if (this.isNowPlayingModeActive()) {
            this.lc.log(10000000, "%1#shouldExecuteActionInMenu: nowPlayingMode is active.", (Object)this.logPrefix);
            this.restartTimer();
            return false;
        }
        if (!menuController.shouldRenderRecursive()) {
            this.restartTimer();
            return false;
        }
        return true;
    }

    private boolean hasFocusedItem(MenuController menuController) {
        return menuController.hasFocusedItem();
    }

    private boolean isNowPlayingModeActive() {
        if (this.parent instanceof NowPlayingMenuController) {
            return ((NowPlayingMenuController)this.parent).isNowPlayingActive();
        }
        return false;
    }
}

