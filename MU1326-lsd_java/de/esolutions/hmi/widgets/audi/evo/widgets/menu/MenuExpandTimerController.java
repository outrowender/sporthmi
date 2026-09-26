/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.AbstractMenuIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class MenuExpandTimerController
extends AbstractMenuIdleTimerController {
    public MenuExpandTimerController() {
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

    @Override
    protected void timerFired() {
        MenuController menuController = this.getMenu();
        if (menuController != null) {
            menuController.expandFocusedItem(false);
        }
    }
}

