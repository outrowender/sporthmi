/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData$LayoutItemsComparator;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.VisibleMenuListItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class MenuLayoutData
implements WidgetConstants {
    public boolean alignTop = true;
    public int cursorOffsetBefore;
    public int cursorOffsetAfter;
    public int cursorHeightBefore;
    public int cursorHeightAfter;
    public float cursorBorderVisibleBefore = 1.0f;
    public float cursorBorderVisibleAfter = 1.0f;
    public int infolineHeightBefore;
    public int infolineHeightAfter;
    public int viewportOffsetBefore;
    public int viewportOffsetAfter;
    public MenuItemIndex moveGapIndexBefore = null;
    public MenuItemIndex moveGapIndexAfter = null;
    public List layoutItems = new ArrayList(10);
    private int cachedIndex1;
    private MenuItemMetaData cachedItem1;
    private int cachedIndex2;
    private MenuItemMetaData cachedItem2;
    private boolean cache1LastUsed;

    public int getScrollDistance() {
        return this.viewportOffsetAfter - this.viewportOffsetBefore;
    }

    public MenuItemMetaData findAnimationItem(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null) {
            return null;
        }
        MenuItemMetaData menuItemMetaData = this.findCachedAnimationItem(menuItemIndex);
        if (menuItemMetaData != null) {
            return menuItemMetaData;
        }
        int n = this.findUncachedAnimationItemListIndex(menuItemIndex);
        if (n >= 0) {
            return (MenuItemMetaData)this.layoutItems.get(n);
        }
        return null;
    }

    public int findAnimationItemListIndex(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null) {
            return -1;
        }
        int n = this.findCachedAnimationItemListIndex(menuItemIndex);
        if (n != -1) {
            return n;
        }
        return this.findUncachedAnimationItemListIndex(menuItemIndex);
    }

    private int findCachedAnimationItemListIndex(MenuItemIndex menuItemIndex) {
        if (this.isItemCached(menuItemIndex, this.cachedItem1)) {
            if (this.isCachedIndexCorrect(this.cachedItem1, this.cachedIndex1)) {
                this.cache1LastUsed = true;
                return this.cachedIndex1;
            }
            this.cachedItem1 = null;
            this.cachedIndex1 = -1;
            this.cache1LastUsed = false;
            return -1;
        }
        if (this.isItemCached(menuItemIndex, this.cachedItem2)) {
            if (this.isCachedIndexCorrect(this.cachedItem2, this.cachedIndex2)) {
                this.cache1LastUsed = false;
                return this.cachedIndex2;
            }
            this.cachedItem2 = null;
            this.cachedIndex2 = -1;
            this.cache1LastUsed = true;
            return -1;
        }
        return -1;
    }

    private MenuItemMetaData findCachedAnimationItem(MenuItemIndex menuItemIndex) {
        if (this.isItemCached(menuItemIndex, this.cachedItem1)) {
            if (!this.cachedItem1.remove) {
                this.cache1LastUsed = true;
                return this.cachedItem1;
            }
            this.cachedItem1 = null;
            this.cachedIndex1 = -1;
            this.cache1LastUsed = false;
            return null;
        }
        if (this.isItemCached(menuItemIndex, this.cachedItem2)) {
            if (!this.cachedItem2.remove) {
                this.cache1LastUsed = false;
                return this.cachedItem2;
            }
            this.cachedItem2 = null;
            this.cachedIndex2 = -1;
            this.cache1LastUsed = true;
            return null;
        }
        return null;
    }

    private boolean isItemCached(MenuItemIndex menuItemIndex, MenuItemMetaData menuItemMetaData) {
        return menuItemMetaData != null && menuItemIndex.equals(menuItemMetaData.index);
    }

    private boolean isCachedIndexCorrect(MenuItemMetaData menuItemMetaData, int n) {
        return !menuItemMetaData.remove && this.layoutItems.size() > n && this.layoutItems.get(n) == menuItemMetaData;
    }

    private int findUncachedAnimationItemListIndex(MenuItemIndex menuItemIndex) {
        int n = Collections.binarySearch(this.layoutItems, menuItemIndex, MenuLayoutData$LayoutItemsComparator.instance);
        if (n >= 0) {
            this.storeItemInCache(n);
        }
        return n;
    }

    protected void storeItemInCache(int n) {
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.layoutItems.get(n);
        if (this.cache1LastUsed) {
            this.cachedItem2 = menuItemMetaData;
            this.cachedIndex2 = n;
        } else {
            this.cachedItem1 = menuItemMetaData;
            this.cachedIndex1 = n;
        }
        this.cache1LastUsed = !this.cache1LastUsed;
    }

    public void removeItemFromCache(MenuItemMetaData menuItemMetaData) {
        if (this.cachedItem1 == menuItemMetaData) {
            this.cachedItem1 = null;
            this.cachedIndex1 = -1;
            this.cache1LastUsed = false;
        }
        if (this.cachedItem2 == menuItemMetaData) {
            this.cachedItem2 = null;
            this.cachedIndex2 = -1;
            this.cache1LastUsed = true;
        }
    }

    public void reset() {
        this.alignTop = true;
        this.cursorHeightBefore = 0;
        this.cursorHeightAfter = 0;
        this.cursorOffsetBefore = 0;
        this.cursorOffsetAfter = 0;
        this.cursorBorderVisibleBefore = 1.0f;
        this.cursorBorderVisibleAfter = 1.0f;
        this.infolineHeightBefore = 0;
        this.infolineHeightAfter = 0;
        this.viewportOffsetBefore = 0;
        this.viewportOffsetAfter = 0;
        this.cachedItem1 = null;
        this.cachedItem2 = null;
        this.cachedIndex1 = -1;
        this.cachedIndex2 = -1;
    }

    public MenuItemMetaData getCachedItem1() {
        return this.cachedItem1;
    }

    public MenuItemMetaData getCachedItem2() {
        return this.cachedItem2;
    }

    static boolean hasNext(ListIterator listIterator, boolean bl) {
        return bl ? listIterator.hasNext() : listIterator.hasPrevious();
    }

    static Object next(ListIterator listIterator, boolean bl) {
        return bl ? listIterator.next() : listIterator.previous();
    }

    static int nextIndex(ListIterator listIterator, boolean bl) {
        return bl ? listIterator.nextIndex() : listIterator.previousIndex();
    }

    static Object peekNextItem(ListIterator listIterator, boolean bl) {
        Object object = MenuLayoutData.next(listIterator, bl);
        MenuLayoutData.next(listIterator, !bl);
        return object;
    }

    static boolean isBefore(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, boolean bl) {
        if (bl) {
            return menuItemIndex.isBefore(menuItemIndex2);
        }
        return menuItemIndex2.isBefore(menuItemIndex);
    }

    public String formatLayoutItemsDetailedLogMessage() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.layoutItems.size(); ++i2) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.layoutItems.get(i2);
            if (i2 > 0) {
                buffer.append("\n");
            }
            buffer.append(i2).append(": ");
            buffer.append("index ").append(menuItemMetaData.index);
            if (menuItemMetaData instanceof VisibleMenuListItem) {
                VisibleMenuListItem visibleMenuListItem = (VisibleMenuListItem)menuItemMetaData;
                buffer.append(", recordSet ").append(visibleMenuListItem.recordSet);
            }
            if (menuItemMetaData.remove) {
                buffer.append(", [removed]");
            }
            if (menuItemMetaData.widget == null) continue;
            buffer.append(", \"").append(menuItemMetaData.widget.getDiagnosisText()).append("\"");
        }
        return buffer.toString();
    }
}

