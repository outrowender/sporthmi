/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public class MenuIconDecoratorController
extends IconController
implements IMenuCallback {
    private void setValueForFocusedMenuItem() {
        MenuController menuController = this.getMenu();
        if (menuController == null) {
            return;
        }
        if (!menuController.hasFocusedItem()) {
            menuItemLogCh.log(-2137614336, "MenuIconDecoratorController#menuFocusChangeFinished: no focused item");
            this.setValue(-1);
        } else {
            MenuItemIndex menuItemIndex = menuController.getFocusedIndex();
            AbstractWidget abstractWidget = menuController.getChild(menuItemIndex.widget);
            if (abstractWidget instanceof IMenuItem) {
                int n = ((IMenuItem)((Object)abstractWidget)).getWidgetID();
                menuItemLogCh.log(-2137614336, "MenuIconDecoratorController#menuFocusChangeFinished: set value %2 for focused item %1", (Object)menuItemIndex, (long)n);
                this.setValue(n);
            } else {
                menuItemLogCh.log(-2137614336, "MenuIconDecoratorController#menuFocusChangeFinished: focused widget %1 is not a menuItem: %2", (Object)menuItemIndex, (Object)abstractWidget);
                this.setValue(-1);
            }
        }
    }

    private MenuController getMenu() {
        if (this.parent instanceof MenuController) {
            return (MenuController)this.parent;
        }
        menuItemLogCh.log(10000, "MenuIconDecoratorController#getMenu: parent is not a menu: %1", (Object)this.parent);
        return null;
    }

    @Override
    public void menuFocusChangeFinished() {
        this.setValueForFocusedMenuItem();
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
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
    }

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

