/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import java.util.Comparator;

public class MenuLayoutData$LayoutItemsComparator
implements Comparator {
    public static final MenuLayoutData$LayoutItemsComparator instance = new MenuLayoutData$LayoutItemsComparator();

    private MenuLayoutData$LayoutItemsComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        boolean bl;
        MenuItemIndex menuItemIndex;
        MenuItemMetaData menuItemMetaData;
        boolean bl2;
        MenuItemIndex menuItemIndex2;
        if (object instanceof MenuItemIndex) {
            menuItemIndex2 = (MenuItemIndex)object;
            bl2 = false;
        } else {
            menuItemMetaData = (MenuItemMetaData)object;
            menuItemIndex2 = menuItemMetaData.index;
            bl2 = menuItemMetaData.remove;
        }
        if (object2 instanceof MenuItemIndex) {
            menuItemIndex = (MenuItemIndex)object2;
            bl = false;
        } else {
            menuItemMetaData = (MenuItemMetaData)object2;
            menuItemIndex = menuItemMetaData.index;
            bl = menuItemMetaData.remove;
        }
        int n = menuItemIndex2.compareTo(menuItemIndex);
        if (n != 0) {
            return n;
        }
        if (bl2) {
            return -1;
        }
        if (bl) {
            return 1;
        }
        return 0;
    }
}

