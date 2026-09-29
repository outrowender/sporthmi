/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;

public class MenuUpdateRequest$MatchMenuChildWidget
implements MenuUpdateRequest$IMenuItemMatcher {
    private final int widgetIndex;

    public MenuUpdateRequest$MatchMenuChildWidget(int n) {
        this.widgetIndex = n;
    }

    @Override
    public boolean matches(MenuItemIndex menuItemIndex) {
        return menuItemIndex.widget == this.widgetIndex;
    }

    @Override
    public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        if (menuItemIndex2 != null && menuItemIndex2.widget < this.widgetIndex) {
            return false;
        }
        return menuItemIndex == null || menuItemIndex.widget <= this.widgetIndex;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.widgetIndex;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof MenuUpdateRequest$MatchMenuChildWidget)) {
            return false;
        }
        MenuUpdateRequest$MatchMenuChildWidget menuUpdateRequest$MatchMenuChildWidget = (MenuUpdateRequest$MatchMenuChildWidget)object;
        return this.widgetIndex == menuUpdateRequest$MatchMenuChildWidget.widgetIndex;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append("[index=").append(this.widgetIndex).append("]").toString();
    }

    static /* synthetic */ int access$100(MenuUpdateRequest$MatchMenuChildWidget menuUpdateRequest$MatchMenuChildWidget) {
        return menuUpdateRequest$MatchMenuChildWidget.widgetIndex;
    }
}

