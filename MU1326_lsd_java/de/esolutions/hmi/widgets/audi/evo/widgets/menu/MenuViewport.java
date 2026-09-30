/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;

public class MenuViewport {
    public final MenuItemIndex start;
    public final MenuItemIndex end;

    public MenuViewport(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        if (menuItemIndex == null != (menuItemIndex2 == null)) {
            throw new IllegalArgumentException("Viewport bounds must either both or none be null. Start: " + menuItemIndex + ", End: " + menuItemIndex2);
        }
        this.start = menuItemIndex;
        this.end = menuItemIndex2;
    }

    public boolean contains(MenuItemIndex menuItemIndex) {
        if (this.isEmpty()) {
            return false;
        }
        if (!this.containsWidget(menuItemIndex.widget)) {
            return false;
        }
        if (menuItemIndex.widget == this.start.widget && menuItemIndex.widgetPart < this.start.widgetPart) {
            return false;
        }
        return menuItemIndex.widget != this.end.widget || menuItemIndex.widgetPart <= this.end.widgetPart;
    }

    public boolean containsWidget(int n) {
        if (this.isEmpty()) {
            return false;
        }
        return n >= this.start.widget && n <= this.end.widget;
    }

    public boolean isEmpty() {
        return this.start == null;
    }

    public String toString() {
        return this.start + " / " + this.end;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MenuViewport)) {
            return false;
        }
        MenuViewport menuViewport = (MenuViewport)object;
        if (this.isEmpty()) {
            return menuViewport.isEmpty();
        }
        return this.start.equals(menuViewport.start) && this.end.equals(menuViewport.end);
    }

    public int hashCode() {
        if (this.isEmpty()) {
            return 1;
        }
        return (17 + this.start.hashCode()) * 31 + this.end.hashCode();
    }

    public MenuViewport adjustForRemove(MenuItemIndex menuItemIndex, int n) {
        if (this.isEmpty()) {
            return this;
        }
        MenuItemIndex menuItemIndex2 = this.start.adjustForRemove(menuItemIndex, n);
        MenuItemIndex menuItemIndex3 = this.end.adjustForRemove(menuItemIndex, n);
        if (menuItemIndex2 == this.start && menuItemIndex3 == this.end) {
            return this;
        }
        return new MenuViewport(menuItemIndex2, menuItemIndex3);
    }

    public MenuViewport adjustForAdd(MenuItemIndex menuItemIndex, int n) {
        if (this.isEmpty()) {
            return this;
        }
        MenuItemIndex menuItemIndex2 = this.start.adjustForAdd(menuItemIndex, n);
        MenuItemIndex menuItemIndex3 = this.end.adjustForAdd(menuItemIndex, n);
        if (menuItemIndex2 == this.start && menuItemIndex3 == this.end) {
            return this;
        }
        return new MenuViewport(menuItemIndex2, menuItemIndex3);
    }
}

