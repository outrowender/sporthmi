/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMulti;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MenuIndexIterator
implements Iterator {
    private final MenuController menu;
    private final MenuItemIndex end;
    private final boolean down;
    private MenuItemIndex next;

    public MenuIndexIterator(MenuController menuController, MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, boolean bl, boolean bl2) {
        boolean bl3;
        if (menuItemIndex2 != null && !menuItemIndex.equals(menuItemIndex2) && (bl3 = menuItemIndex.isBefore(menuItemIndex2)) != bl) {
            throw new IllegalArgumentException("Order of start (" + menuItemIndex + ") and end (" + menuItemIndex2 + ") index is incompatible with iteration direction (" + (bl ? "down" : "up") + ")");
        }
        this.menu = menuController;
        this.end = menuItemIndex2;
        this.down = bl;
        this.next = this.calculateFirstIterationIndex(menuItemIndex, bl2);
    }

    private MenuItemIndex calculateFirstIterationIndex(MenuItemIndex menuItemIndex, boolean bl) {
        if (bl && this.menu.isValidMenuItemIndex(menuItemIndex)) {
            return menuItemIndex;
        }
        MenuItemIndex menuItemIndex2 = this.menu.getLastMenuItem();
        if (menuItemIndex2 == null) {
            return null;
        }
        if (menuItemIndex2.isBefore(menuItemIndex)) {
            if (this.down) {
                return null;
            }
            return menuItemIndex2;
        }
        return this.findNextMenuItem(menuItemIndex);
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public Object next() {
        if (this.next == null) {
            throw new NoSuchElementException("There are no more menu items");
        }
        MenuItemIndex menuItemIndex = this.next;
        this.next = this.findNextMenuItem(menuItemIndex);
        return menuItemIndex;
    }

    public void remove() {
        throw new IllegalStateException("Remove menu items is not supported");
    }

    private MenuItemIndex findNextMenuItem(MenuItemIndex menuItemIndex) {
        if (menuItemIndex.equals(this.end)) {
            return null;
        }
        int n = this.down ? 1 : -1;
        int n2 = menuItemIndex.widget;
        int n3 = menuItemIndex.widgetPart;
        AbstractWidget abstractWidget = this.getMenuChild(n2);
        if (this.isActiveMenuItem(abstractWidget) && this.hasNextMenuItemInWidget(abstractWidget, n3)) {
            n3 = this.getNextWidgetPart(abstractWidget, n3);
        } else {
            do {
                if (this.isWidgetIndexAfterEnd(n2 += n)) {
                    return null;
                }
                if (this.isValidWidgetIndex(n2)) continue;
                return null;
            } while (!this.isActiveMenuItem(abstractWidget = this.getMenuChild(n2)) || !this.hasMenuItemInWidget(abstractWidget));
            n3 = this.getFirstMenuItem(abstractWidget);
        }
        return new MenuItemIndex(n2, n3);
    }

    private int getNextWidgetPart(AbstractWidget abstractWidget, int n) {
        int n2 = n + (this.down ? 1 : -1);
        n2 = Math.min(n2, MenuController.getLastSubitemIndex((IMenuItemMulti)((Object)abstractWidget)));
        n2 = Math.max(n2, 0);
        return n2;
    }

    private boolean isWidgetIndexAfterEnd(int n) {
        if (this.end == null) {
            return false;
        }
        if (this.down) {
            return n > this.end.widget;
        }
        return n < this.end.widget;
    }

    private boolean isActiveMenuItem(AbstractWidget abstractWidget) {
        return this.menu.isActiveMenuItem(abstractWidget);
    }

    private AbstractWidget getMenuChild(int n) {
        return this.menu.getChild(n);
    }

    private int getFirstMenuItem(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof IMenuItemMulti) {
            return this.down ? 0 : MenuController.getLastSubitemIndex((IMenuItemMulti)((Object)abstractWidget));
        }
        return 0;
    }

    private boolean hasNextMenuItemInWidget(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof IMenuItemMulti) {
            IMenuItemMulti iMenuItemMulti = (IMenuItemMulti)((Object)abstractWidget);
            if (MenuController.isEmpty(iMenuItemMulti)) {
                return false;
            }
            if (this.down) {
                return n < MenuController.getLastSubitemIndex(iMenuItemMulti);
            }
            return n > 0;
        }
        return false;
    }

    private boolean hasMenuItemInWidget(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof IMenuItemMulti) {
            return !MenuController.isEmpty((IMenuItemMulti)((Object)abstractWidget));
        }
        return true;
    }

    private boolean isValidWidgetIndex(int n) {
        return n >= 0 && n < this.menu.getChildrenSize();
    }
}

