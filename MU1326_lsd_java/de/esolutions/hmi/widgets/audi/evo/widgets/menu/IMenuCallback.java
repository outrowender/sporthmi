/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public interface IMenuCallback {
    public void menuLayouted();

    public void viewportUpdated(boolean var1);

    public void setActiveMenuController(MenuController var1);

    public void menuFocusChanged(MenuItemIndex var1);

    public void menuFocusChangeFinished();

    public void menuSelectionChanged(MenuItemIndex var1, Long var2, MenuUpdateDelta var3);

    public void setHideOverlayDecoratorDuringScrolling(boolean var1);
}

