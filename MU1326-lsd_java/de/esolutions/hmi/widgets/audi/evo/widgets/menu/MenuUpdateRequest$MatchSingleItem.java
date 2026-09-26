/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;

public class MenuUpdateRequest$MatchSingleItem
implements MenuUpdateRequest$IMenuItemMatcher {
    private final MenuItemIndex matchIndex;

    public MenuUpdateRequest$MatchSingleItem(MenuItemIndex menuItemIndex) {
        this.matchIndex = menuItemIndex;
    }

    @Override
    public boolean matches(MenuItemIndex menuItemIndex) {
        return this.matchIndex.equals(menuItemIndex);
    }

    @Override
    public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        if (menuItemIndex2 != null && MenuLayoutData.isBefore(menuItemIndex2, this.matchIndex, true)) {
            return false;
        }
        return menuItemIndex == null || !MenuLayoutData.isBefore(this.matchIndex, menuItemIndex, true);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.matchIndex == null ? 0 : this.matchIndex.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof MenuUpdateRequest$MatchSingleItem)) {
            return false;
        }
        MenuUpdateRequest$MatchSingleItem menuUpdateRequest$MatchSingleItem = (MenuUpdateRequest$MatchSingleItem)object;
        return !(this.matchIndex == null ? menuUpdateRequest$MatchSingleItem.matchIndex != null : !this.matchIndex.equals(menuUpdateRequest$MatchSingleItem.matchIndex));
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append("[").append(this.matchIndex).append("]").toString();
    }

    static /* synthetic */ MenuItemIndex access$400(MenuUpdateRequest$MatchSingleItem menuUpdateRequest$MatchSingleItem) {
        return menuUpdateRequest$MatchSingleItem.matchIndex;
    }
}

