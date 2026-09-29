/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;

public class MenuUpdateRequest$MatchAllOrNoneItems
implements MenuUpdateRequest$IMenuItemMatcher {
    private final boolean matchAll;

    public MenuUpdateRequest$MatchAllOrNoneItems(boolean bl) {
        this.matchAll = bl;
    }

    @Override
    public boolean matches(MenuItemIndex menuItemIndex) {
        return this.matchAll;
    }

    @Override
    public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        return this.matchAll;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.matchAll ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof MenuUpdateRequest$MatchAllOrNoneItems)) {
            return false;
        }
        MenuUpdateRequest$MatchAllOrNoneItems menuUpdateRequest$MatchAllOrNoneItems = (MenuUpdateRequest$MatchAllOrNoneItems)object;
        return this.matchAll == menuUpdateRequest$MatchAllOrNoneItems.matchAll;
    }

    public boolean isMatchAll() {
        return this.matchAll;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append("[").append(this.matchAll ? "all" : "none").append("]").toString();
    }

    static /* synthetic */ boolean access$000(MenuUpdateRequest$MatchAllOrNoneItems menuUpdateRequest$MatchAllOrNoneItems) {
        return menuUpdateRequest$MatchAllOrNoneItems.matchAll;
    }
}

