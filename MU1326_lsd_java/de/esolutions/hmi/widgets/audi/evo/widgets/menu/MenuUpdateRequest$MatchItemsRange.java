/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;

public class MenuUpdateRequest$MatchItemsRange
implements MenuUpdateRequest$IMenuItemMatcher {
    private final MenuItemIndex from;
    private final MenuItemIndex to;

    public MenuUpdateRequest$MatchItemsRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        this.from = menuItemIndex;
        this.to = menuItemIndex2;
    }

    @Override
    public boolean matches(MenuItemIndex menuItemIndex) {
        return !menuItemIndex.isBefore(this.from) && !this.to.isBefore(menuItemIndex);
    }

    @Override
    public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        if (menuItemIndex2 != null && MenuLayoutData.isBefore(menuItemIndex2, this.from, true)) {
            return false;
        }
        return menuItemIndex == null || !MenuLayoutData.isBefore(this.to, menuItemIndex, true);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.from == null ? 0 : this.from.hashCode());
        n = 31 * n + (this.to == null ? 0 : this.to.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof MenuUpdateRequest$MatchItemsRange)) {
            return false;
        }
        MenuUpdateRequest$MatchItemsRange menuUpdateRequest$MatchItemsRange = (MenuUpdateRequest$MatchItemsRange)object;
        if (this.from == null ? menuUpdateRequest$MatchItemsRange.from != null : !this.from.equals(menuUpdateRequest$MatchItemsRange.from)) {
            return false;
        }
        return !(this.to == null ? menuUpdateRequest$MatchItemsRange.to != null : !this.to.equals(menuUpdateRequest$MatchItemsRange.to));
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append("[from=").append(this.from).append(", to=").append(this.to).append("]").toString();
    }

    static /* synthetic */ MenuItemIndex access$200(MenuUpdateRequest$MatchItemsRange menuUpdateRequest$MatchItemsRange) {
        return menuUpdateRequest$MatchItemsRange.from;
    }

    static /* synthetic */ MenuItemIndex access$300(MenuUpdateRequest$MatchItemsRange menuUpdateRequest$MatchItemsRange) {
        return menuUpdateRequest$MatchItemsRange.to;
    }
}

