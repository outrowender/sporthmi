/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

public class MenuItemIndex
implements Comparable {
    public static final int SINGLE_ITEM_PART = 0;
    public final int widget;
    public final int widgetPart;

    public static MenuItemIndex min(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        if (menuItemIndex == null) {
            return menuItemIndex2;
        }
        if (menuItemIndex2 == null) {
            return menuItemIndex;
        }
        if (menuItemIndex.isBefore(menuItemIndex2)) {
            return menuItemIndex;
        }
        return menuItemIndex2;
    }

    public static MenuItemIndex max(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        if (menuItemIndex == null) {
            return menuItemIndex2;
        }
        if (menuItemIndex2 == null) {
            return menuItemIndex;
        }
        if (menuItemIndex.isBefore(menuItemIndex2)) {
            return menuItemIndex2;
        }
        return menuItemIndex;
    }

    public MenuItemIndex(int n, int n2) {
        this.widget = n;
        this.widgetPart = n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MenuItemIndex)) {
            return false;
        }
        MenuItemIndex menuItemIndex = (MenuItemIndex)object;
        return this.widget == menuItemIndex.widget && this.widgetPart == menuItemIndex.widgetPart;
    }

    public int hashCode() {
        return (17 + this.widget) * 31 + this.widgetPart;
    }

    public int compareTo(Object object) {
        MenuItemIndex menuItemIndex = (MenuItemIndex)object;
        int n = this.widget - menuItemIndex.widget;
        if (n != 0) {
            return n;
        }
        return this.widgetPart - menuItemIndex.widgetPart;
    }

    public boolean isBefore(MenuItemIndex menuItemIndex) {
        return this.compareTo(menuItemIndex) < 0;
    }

    public String toString() {
        return this.widget + "(" + this.widgetPart + ")";
    }

    public MenuItemIndex adjustForRemove(MenuItemIndex menuItemIndex, int n) {
        if (this.needsAdjustmentForRemove(menuItemIndex)) {
            int n2 = Math.max(menuItemIndex.widgetPart, this.widgetPart - n);
            return new MenuItemIndex(this.widget, n2);
        }
        return this;
    }

    private boolean needsAdjustmentForRemove(MenuItemIndex menuItemIndex) {
        return menuItemIndex.widget == this.widget && menuItemIndex.widgetPart < this.widgetPart;
    }

    public MenuItemIndex adjustForRemoveMenuChild(int n) {
        if (this.widget == n) {
            return null;
        }
        if (this.widget > n) {
            return new MenuItemIndex(this.widget - 1, this.widgetPart);
        }
        return this;
    }

    public MenuItemIndex adjustForAdd(MenuItemIndex menuItemIndex, int n) {
        if (this.needsAdjustmentForAdd(menuItemIndex)) {
            return new MenuItemIndex(this.widget, this.widgetPart + n);
        }
        return this;
    }

    public boolean needsAdjustmentForAdd(MenuItemIndex menuItemIndex) {
        return menuItemIndex.widget == this.widget && menuItemIndex.widgetPart <= this.widgetPart;
    }
}

