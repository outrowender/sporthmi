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
    @Override
    public void menuLayouted() {
    }

    @Override
    public void viewportUpdated(boolean bl) {
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
    }

    @Override
    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    @Override
    public void menuFocusChangeFinished() {
    }

    @Override
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

