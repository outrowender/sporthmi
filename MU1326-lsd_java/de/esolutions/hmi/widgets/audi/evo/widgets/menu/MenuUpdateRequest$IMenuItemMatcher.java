/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;

public interface MenuUpdateRequest$IMenuItemMatcher {
    default public boolean matches(MenuItemIndex menuItemIndex) {
    }

    default public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
    }
}

