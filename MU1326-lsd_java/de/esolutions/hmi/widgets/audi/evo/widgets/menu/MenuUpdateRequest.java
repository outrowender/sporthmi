/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$MatchAllOrNoneItems;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$MatchItemsRange;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$MatchMenuChildWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$MatchSingleItem;

public class MenuUpdateRequest
implements IWidgetLogChannel {
    public static final MenuUpdateRequest$IMenuItemMatcher UPDATE_ALL = new MenuUpdateRequest$MatchAllOrNoneItems(true);
    public static final MenuUpdateRequest$IMenuItemMatcher UPDATE_NONE = new MenuUpdateRequest$MatchAllOrNoneItems(false);
    public MenuItemIndex focusIndex;
    public FocusAdvice focusAdvice;
    public Boolean customAlignmentTop;
    public boolean avoidPartiallyFilledViewport = true;
    public MenuUpdateRequest$IMenuItemMatcher updateItems;

    public MenuUpdateRequest() {
    }

    public MenuUpdateRequest(MenuItemIndex menuItemIndex, FocusAdvice focusAdvice, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher) {
        this.focusIndex = menuItemIndex;
        this.focusAdvice = focusAdvice;
        this.updateItems = menuUpdateRequest$IMenuItemMatcher;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(super.getClass().getName());
        buffer.append("[");
        if (this.focusIndex != null) {
            buffer.append("focusIndex=").append(this.focusIndex).append(", ");
        }
        if (this.customAlignmentTop != null) {
            buffer.append("topAlign=").append(this.customAlignmentTop).append(", ");
        }
        if (this.focusAdvice != null) {
            buffer.append("focusAdvice=").append(this.focusAdvice).append(", ");
        }
        buffer.append("avoidPartialFilled=").append(this.avoidPartiallyFilledViewport).append(", ");
        if (this.updateItems != null) {
            buffer.append("updateItems=").append(this.updateItems);
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static MenuUpdateRequest$IMenuItemMatcher combineMenuItemMatcher(MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher2) {
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchAllOrNoneItems) {
            return MenuUpdateRequest$MatchAllOrNoneItems.access$000((MenuUpdateRequest$MatchAllOrNoneItems)menuUpdateRequest$IMenuItemMatcher) ? menuUpdateRequest$IMenuItemMatcher : menuUpdateRequest$IMenuItemMatcher2;
        }
        if (menuUpdateRequest$IMenuItemMatcher2 instanceof MenuUpdateRequest$MatchAllOrNoneItems) {
            return MenuUpdateRequest$MatchAllOrNoneItems.access$000((MenuUpdateRequest$MatchAllOrNoneItems)menuUpdateRequest$IMenuItemMatcher2) ? menuUpdateRequest$IMenuItemMatcher2 : menuUpdateRequest$IMenuItemMatcher;
        }
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchMenuChildWidget) {
            int n = MenuUpdateRequest$MatchMenuChildWidget.access$100((MenuUpdateRequest$MatchMenuChildWidget)menuUpdateRequest$IMenuItemMatcher);
            return MenuUpdateRequest.isCoveredByMenuChildUpdate(n, menuUpdateRequest$IMenuItemMatcher2) ? menuUpdateRequest$IMenuItemMatcher : UPDATE_ALL;
        }
        if (menuUpdateRequest$IMenuItemMatcher2 instanceof MenuUpdateRequest$MatchMenuChildWidget) {
            int n = MenuUpdateRequest$MatchMenuChildWidget.access$100((MenuUpdateRequest$MatchMenuChildWidget)menuUpdateRequest$IMenuItemMatcher2);
            return MenuUpdateRequest.isCoveredByMenuChildUpdate(n, menuUpdateRequest$IMenuItemMatcher) ? menuUpdateRequest$IMenuItemMatcher2 : UPDATE_ALL;
        }
        MenuItemIndex menuItemIndex = MenuUpdateRequest.getMatcherEdgeIndex(menuUpdateRequest$IMenuItemMatcher, true);
        MenuItemIndex menuItemIndex2 = MenuUpdateRequest.getMatcherEdgeIndex(menuUpdateRequest$IMenuItemMatcher2, true);
        MenuItemIndex menuItemIndex3 = MenuUpdateRequest.getMatcherEdgeIndex(menuUpdateRequest$IMenuItemMatcher, false);
        MenuItemIndex menuItemIndex4 = MenuUpdateRequest.getMatcherEdgeIndex(menuUpdateRequest$IMenuItemMatcher2, false);
        if (menuItemIndex == null || menuItemIndex2 == null || menuItemIndex3 == null || menuItemIndex4 == null) {
            return UPDATE_ALL;
        }
        MenuItemIndex menuItemIndex5 = menuItemIndex.isBefore(menuItemIndex2) ? menuItemIndex : menuItemIndex2;
        MenuItemIndex menuItemIndex6 = menuItemIndex3.isBefore(menuItemIndex4) ? menuItemIndex4 : menuItemIndex3;
        return new MenuUpdateRequest$MatchItemsRange(menuItemIndex5, menuItemIndex6);
    }

    private static boolean isCoveredByMenuChildUpdate(int n, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher) {
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchAllOrNoneItems) {
            return !MenuUpdateRequest$MatchAllOrNoneItems.access$000((MenuUpdateRequest$MatchAllOrNoneItems)menuUpdateRequest$IMenuItemMatcher);
        }
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchItemsRange) {
            MenuUpdateRequest$MatchItemsRange menuUpdateRequest$MatchItemsRange = (MenuUpdateRequest$MatchItemsRange)menuUpdateRequest$IMenuItemMatcher;
            return MenuUpdateRequest$MatchItemsRange.access$200((MenuUpdateRequest$MatchItemsRange)menuUpdateRequest$MatchItemsRange).widget == n && MenuUpdateRequest$MatchItemsRange.access$300((MenuUpdateRequest$MatchItemsRange)menuUpdateRequest$MatchItemsRange).widget == n;
        }
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchMenuChildWidget) {
            return MenuUpdateRequest$MatchMenuChildWidget.access$100((MenuUpdateRequest$MatchMenuChildWidget)menuUpdateRequest$IMenuItemMatcher) == n;
        }
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchSingleItem) {
            return MenuUpdateRequest$MatchSingleItem.access$400((MenuUpdateRequest$MatchSingleItem)((MenuUpdateRequest$MatchSingleItem)menuUpdateRequest$IMenuItemMatcher)).widget == n;
        }
        menuLogCh.log(10000, "MenuUpdateRequest#isCoveredByMenuChildUpdate: unknown items matcher: %1", (Object)menuUpdateRequest$IMenuItemMatcher);
        return false;
    }

    private static MenuItemIndex getMatcherEdgeIndex(MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher, boolean bl) {
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchItemsRange) {
            MenuUpdateRequest$MatchItemsRange menuUpdateRequest$MatchItemsRange = (MenuUpdateRequest$MatchItemsRange)menuUpdateRequest$IMenuItemMatcher;
            return bl ? MenuUpdateRequest$MatchItemsRange.access$200(menuUpdateRequest$MatchItemsRange) : MenuUpdateRequest$MatchItemsRange.access$300(menuUpdateRequest$MatchItemsRange);
        }
        if (menuUpdateRequest$IMenuItemMatcher instanceof MenuUpdateRequest$MatchSingleItem) {
            return MenuUpdateRequest$MatchSingleItem.access$400((MenuUpdateRequest$MatchSingleItem)menuUpdateRequest$IMenuItemMatcher);
        }
        menuLogCh.log(10000, "MenuUpdateRequest#getMatcherEdgeIndex: unknown items matcher: %1", (Object)menuUpdateRequest$IMenuItemMatcher);
        return null;
    }
}

