/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public abstract class MenuCallbackAdapter
implements IMenuCallback {
    public void menuLayouted() {
    }

    public void viewportUpdated(boolean bl) {
    }

    public void setActiveMenuController(MenuController menuController) {
    }

    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    public void menuFocusChangeFinished() {
    }

    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

