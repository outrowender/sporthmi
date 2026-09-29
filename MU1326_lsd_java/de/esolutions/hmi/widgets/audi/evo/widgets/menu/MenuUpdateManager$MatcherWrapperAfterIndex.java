/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;

class MenuUpdateManager$MatcherWrapperAfterIndex
implements MenuUpdateRequest$IMenuItemMatcher {
    private MenuItemIndex alreadyUpdatedUntil;
    private boolean downward;
    private MenuUpdateRequest$IMenuItemMatcher delegate;

    public MenuUpdateManager$MatcherWrapperAfterIndex(MenuItemIndex menuItemIndex, boolean bl, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher) {
        this.alreadyUpdatedUntil = menuItemIndex;
        this.downward = bl;
        this.delegate = menuUpdateRequest$IMenuItemMatcher;
    }

    @Override
    public boolean matches(MenuItemIndex menuItemIndex) {
        return this.delegate.matches(menuItemIndex) && MenuLayoutData.isBefore(this.alreadyUpdatedUntil, menuItemIndex, this.downward);
    }

    @Override
    public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        return this.delegate.mayMatchInRange(menuItemIndex, menuItemIndex2);
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append("[updatedUntil=").append(this.alreadyUpdatedUntil).append(", ").append(this.downward ? "down" : "up").append(", delegate=").append(this.delegate).append("]").toString();
    }
}

