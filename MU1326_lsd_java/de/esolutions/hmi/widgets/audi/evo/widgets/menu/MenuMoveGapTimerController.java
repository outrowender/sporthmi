/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.AbstractMenuIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class MenuMoveGapTimerController
extends AbstractMenuIdleTimerController {
    public MenuMoveGapTimerController() {
        super(menuLogCh);
        this.startTimerAutomatically = true;
        this.fireWhenOptionDrawerOpen = true;
        this.fireWhenSelectionDrawerOpen = true;
        this.fireWhenSdsActive = true;
        this.fireWhenScrollAnimationRunning = true;
        this.fireWhenFocusPopupOpen = true;
        this.fireWhenTouchfieldFocused = false;
        this.fireWhenMoveModeActive = true;
        this.idleTime = 500;
    }

    protected void timerFired() {
        MenuController menuController = this.getMenu();
        if (menuController != null) {
            menuController.moveGapToFocusedIndex();
        }
    }

    protected boolean shouldExecuteActionInMenu(MenuController menuController) {
        return super.shouldExecuteActionInMenu(menuController) && menuController.hasMoveItem();
    }

    public void menuMoveModeChanged() {
        MenuController menuController = this.getMenu();
        if (menuController == null) {
            return;
        }
        if (!this.isMoveModeActive(menuController)) {
            this.cancelTimer();
        } else if (this.isEnabled()) {
            this.lc.log(10000000, "%1#menuMoveModeChanged, move mode active - start timer.", (Object)this.logPrefix);
            this.restartTimer();
        }
    }
}

