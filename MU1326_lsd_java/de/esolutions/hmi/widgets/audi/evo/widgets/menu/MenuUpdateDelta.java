/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;

public class MenuUpdateDelta {
    private MenuViewport oldViewport;
    public boolean oldViewportEndItemRemoved = false;
    private MenuItemIndex oldFocusedIndex;
    private final MenuItemMetaData oldFocusedItem;
    private MenuItemIndex oldSelectedIndex;
    public boolean cursorMergeEnabled = true;
    MenuItemMetaData latestItem;
    boolean requestedItemReached;
    public int itemsDeltaAbove = 0;
    public int itemsDeltaBelow = 0;
    public int heightDeltaAbove = 0;
    public int heightDeltaBelow = 0;
    public int itemsDeltaTotal = 0;
    public int heightDeltaTotal = 0;
    public MenuItemMetaData viewportStartItem;
    public MenuItemMetaData viewportEndItem;

    public MenuUpdateDelta(MenuViewport menuViewport, MenuItemIndex menuItemIndex, MenuItemMetaData menuItemMetaData, MenuItemIndex menuItemIndex2) {
        this.oldViewport = menuViewport;
        this.oldFocusedIndex = menuItemIndex;
        this.oldFocusedItem = menuItemMetaData;
        this.oldSelectedIndex = menuItemIndex2;
    }

    public void itemAdded(MenuItemMetaData menuItemMetaData) {
        this.heightDeltaTotal += menuItemMetaData.heightBefore;
        ++this.itemsDeltaTotal;
        if (this.isAboveViewport(menuItemMetaData)) {
            this.heightDeltaAbove += menuItemMetaData.heightBefore;
            ++this.itemsDeltaAbove;
        } else if (this.isBelowViewport(menuItemMetaData)) {
            this.heightDeltaBelow += menuItemMetaData.heightBefore;
            ++this.itemsDeltaBelow;
        }
    }

    public void itemRemoved(MenuItemMetaData menuItemMetaData) {
        this.heightDeltaTotal -= menuItemMetaData.heightBefore;
        --this.itemsDeltaTotal;
        if (this.isAboveViewport(menuItemMetaData)) {
            this.heightDeltaAbove -= menuItemMetaData.heightBefore;
            --this.itemsDeltaAbove;
        } else if (this.isBelowViewport(menuItemMetaData)) {
            this.heightDeltaBelow -= menuItemMetaData.heightBefore;
            --this.itemsDeltaBelow;
        }
    }

    private boolean isAboveViewport(MenuItemMetaData menuItemMetaData) {
        if (this.oldViewport.isEmpty()) {
            return false;
        }
        return menuItemMetaData.index.isBefore(this.oldViewport.start);
    }

    private boolean isBelowViewport(MenuItemMetaData menuItemMetaData) {
        if (this.oldViewport.isEmpty()) {
            return false;
        }
        if (this.oldViewportEndItemRemoved) {
            return !menuItemMetaData.index.isBefore(this.oldViewport.end);
        }
        return this.oldViewport.end.isBefore(menuItemMetaData.index);
    }

    public void store(MenuItemMetaData menuItemMetaData, boolean bl) {
        this.requestedItemReached = bl;
        this.latestItem = menuItemMetaData;
    }

    public MenuViewport getOldViewport() {
        return this.oldViewport;
    }

    public void setOldViewport(MenuViewport menuViewport) {
        this.oldViewport = menuViewport;
    }

    public MenuItemIndex getOldFocusedIndex() {
        return this.oldFocusedIndex;
    }

    public void setOldFocusedIndex(MenuItemIndex menuItemIndex) {
        this.oldFocusedIndex = menuItemIndex;
    }

    public MenuItemMetaData getOldFocusedItem() {
        return this.oldFocusedItem;
    }

    public MenuItemIndex getOldSelectedIndex() {
        return this.oldSelectedIndex;
    }

    public void setOldSelectedIndex(MenuItemIndex menuItemIndex) {
        this.oldSelectedIndex = menuItemIndex;
    }
}

