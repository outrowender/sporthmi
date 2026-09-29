/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public abstract class AbstractMenuIdleTimerController
extends AbstractIdleTimerController {
    protected boolean fireWhenSdsActive = true;
    protected boolean fireWhenTouchfieldFocused = true;
    protected boolean fireWhenScrollAnimationRunning = true;
    protected boolean fireWhenFocusPopupOpen = false;
    protected boolean fireWhenMoveModeActive = false;

    public AbstractMenuIdleTimerController(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public AbstractMenuIdleTimerController(LogChannel logChannel) {
        super(logChannel);
    }

    protected MenuController getMenu() {
        if (this.parent instanceof MenuController) {
            return (MenuController)this.parent;
        }
        this.lc.log(10000, "%1#getMenu - parent is not a menu: %2", (Object)this.logPrefix, (Object)this.parent);
        return null;
    }

    public void menuSDSActiveChanged() {
        if (this.fireWhenSdsActive) {
            return;
        }
        MenuController menuController = this.getMenu();
        if (menuController == null) {
            return;
        }
        if (menuController.isSDSActive()) {
            this.cancelTimer();
        } else if (this.isEnabled()) {
            this.lc.log(-2137614336, "%1#menuSDSActiveChanged - start timer.", (Object)this.logPrefix);
            this.restartTimer();
        }
    }

    public void menuMoveModeChanged() {
        if (this.fireWhenMoveModeActive) {
            return;
        }
        MenuController menuController = this.getMenu();
        if (menuController == null) {
            return;
        }
        if (this.isMoveModeActive(menuController)) {
            this.cancelTimer();
        } else if (this.isEnabled()) {
            this.lc.log(-2137614336, "%1#menuMoveModeChanged - start timer.", (Object)this.logPrefix);
            this.restartTimer();
        }
    }

    public void menuAnimationScrollFinished() {
        if (this.fireWhenScrollAnimationRunning) {
            return;
        }
        if (this.isEnabled()) {
            this.lc.log(-2137614336, "%1#menuAnimationFinished - start timer.", (Object)this.logPrefix);
            this.restartTimer();
        }
    }

    @Override
    protected boolean shouldExecuteAction() {
        if (!super.shouldExecuteAction()) {
            return false;
        }
        MenuController menuController = this.getMenu();
        if (menuController == null) {
            return false;
        }
        return this.shouldExecuteActionInMenu(menuController);
    }

    protected boolean shouldExecuteActionInMenu(MenuController menuController) {
        if (!this.fireWhenSdsActive && this.isSDSActive(menuController)) {
            this.lc.log(-2137614336, "%1#shouldExecuteActionInMenu: SDS is active.", (Object)this.logPrefix);
            return false;
        }
        if (!this.fireWhenTouchfieldFocused && this.isTouchfieldFocused(menuController)) {
            this.lc.log(-2137614336, "%1#shouldExecuteActionInMenu: touchfield is focused.", (Object)this.logPrefix);
            return false;
        }
        if (!this.fireWhenScrollAnimationRunning && this.isScrollAnimationRunning(menuController)) {
            this.lc.log(-2137614336, "%1#shouldExecuteActionInMenu: scroll animation is running.", (Object)this.logPrefix);
            return false;
        }
        if (!this.fireWhenFocusPopupOpen && this.isFocusPopupOpen(menuController)) {
            this.lc.log(-2137614336, "%1#shouldExecuteActionInMenu: focus related popup is open.", (Object)this.logPrefix);
            this.restartTimer();
            return false;
        }
        if (!this.fireWhenMoveModeActive && this.isMoveModeActive(menuController)) {
            this.lc.log(-2137614336, "%1#shouldExecuteActionInMenu: move mode is open.", (Object)this.logPrefix);
            return false;
        }
        return true;
    }

    protected boolean isMoveModeActive(MenuController menuController) {
        return menuController.hasMoveItem();
    }

    protected boolean isSDSActive(MenuController menuController) {
        return menuController.isSDSActive();
    }

    protected boolean isScrollAnimationRunning(MenuController menuController) {
        return menuController.getAnimationManager().isScrollAnimationRunning();
    }

    protected boolean isTouchfieldFocused(MenuController menuController) {
        if (!menuController.hasFocusedItem()) {
            return false;
        }
        AbstractWidget abstractWidget = menuController.getChild(menuController.getFocusedIndex().widget);
        return abstractWidget instanceof TouchController;
    }

    protected boolean isFocusPopupOpen(MenuController menuController) {
        return menuController.getOpenFocusRelatedPartialPopup() != -1;
    }

    public boolean isFireWhenSdsActive() {
        return this.fireWhenSdsActive;
    }

    public void setFireWhenSdsActive(boolean bl) {
        this.fireWhenSdsActive = bl;
    }

    public boolean isFireWhenTouchfieldFocused() {
        return this.fireWhenTouchfieldFocused;
    }

    public void setFireWhenTouchfieldFocused(boolean bl) {
        this.fireWhenTouchfieldFocused = bl;
    }

    public boolean isFireWhenScrollAnimationRunning() {
        return this.fireWhenScrollAnimationRunning;
    }

    public void setFireWhenScrollAnimationRunning(boolean bl) {
        this.fireWhenScrollAnimationRunning = bl;
    }

    public boolean isFireWhenFocusPopupOpen() {
        return this.fireWhenFocusPopupOpen;
    }

    public void setFireWhenFocusPopupOpen(boolean bl) {
        this.fireWhenFocusPopupOpen = bl;
    }
}

