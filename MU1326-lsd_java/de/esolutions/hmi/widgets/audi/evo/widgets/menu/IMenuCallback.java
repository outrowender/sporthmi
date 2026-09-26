/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public interface IMenuCallback {
    default public void menuLayouted() {
    }

    default public void viewportUpdated(boolean bl) {
    }

    default public void setActiveMenuController(MenuController menuController) {
    }

    default public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    default public void menuFocusChangeFinished() {
    }

    default public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    default public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

