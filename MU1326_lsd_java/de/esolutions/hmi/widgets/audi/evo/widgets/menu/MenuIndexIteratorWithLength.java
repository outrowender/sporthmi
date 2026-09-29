/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import java.util.Iterator;

public class MenuIndexIteratorWithLength
implements Iterator {
    private final MenuItemIndex startIndex;
    private final int length;
    private int next = 0;

    public MenuIndexIteratorWithLength(MenuItemIndex menuItemIndex, int n) {
        this.startIndex = menuItemIndex;
        this.length = n;
    }

    @Override
    public boolean hasNext() {
        return this.next < this.length;
    }

    @Override
    public Object next() {
        MenuItemIndex menuItemIndex = this.getNextIndex();
        ++this.next;
        return menuItemIndex;
    }

    private MenuItemIndex getNextIndex() {
        if (this.next == 0) {
            return this.startIndex;
        }
        return new MenuItemIndex(this.startIndex.widget, this.startIndex.widgetPart + this.next);
    }

    @Override
    public void remove() {
        throw new IllegalStateException("Remove menu items is not supported");
    }
}

