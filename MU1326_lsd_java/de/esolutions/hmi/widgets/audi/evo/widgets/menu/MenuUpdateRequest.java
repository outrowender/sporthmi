/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;

public class MenuUpdateRequest
implements IWidgetLogChannel {
    public static final IMenuItemMatcher UPDATE_ALL = new MatchAllOrNoneItems(true);
    public static final IMenuItemMatcher UPDATE_NONE = new MatchAllOrNoneItems(false);
    public MenuItemIndex focusIndex;
    public FocusAdvice focusAdvice;
    public Boolean customAlignmentTop;
    public boolean avoidPartiallyFilledViewport = true;
    public IMenuItemMatcher updateItems;

    public MenuUpdateRequest() {
    }

    public MenuUpdateRequest(MenuItemIndex menuItemIndex, FocusAdvice focusAdvice, IMenuItemMatcher iMenuItemMatcher) {
        this.focusIndex = menuItemIndex;
        this.focusAdvice = focusAdvice;
        this.updateItems = iMenuItemMatcher;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.getClass().getName());
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

    public static IMenuItemMatcher combineMenuItemMatcher(IMenuItemMatcher iMenuItemMatcher, IMenuItemMatcher iMenuItemMatcher2) {
        if (iMenuItemMatcher instanceof MatchAllOrNoneItems) {
            return ((MatchAllOrNoneItems)iMenuItemMatcher).matchAll ? iMenuItemMatcher : iMenuItemMatcher2;
        }
        if (iMenuItemMatcher2 instanceof MatchAllOrNoneItems) {
            return ((MatchAllOrNoneItems)iMenuItemMatcher2).matchAll ? iMenuItemMatcher2 : iMenuItemMatcher;
        }
        if (iMenuItemMatcher instanceof MatchMenuChildWidget) {
            int n = ((MatchMenuChildWidget)iMenuItemMatcher).widgetIndex;
            return MenuUpdateRequest.isCoveredByMenuChildUpdate(n, iMenuItemMatcher2) ? iMenuItemMatcher : UPDATE_ALL;
        }
        if (iMenuItemMatcher2 instanceof MatchMenuChildWidget) {
            int n = ((MatchMenuChildWidget)iMenuItemMatcher2).widgetIndex;
            return MenuUpdateRequest.isCoveredByMenuChildUpdate(n, iMenuItemMatcher) ? iMenuItemMatcher2 : UPDATE_ALL;
        }
        MenuItemIndex menuItemIndex = MenuUpdateRequest.getMatcherEdgeIndex(iMenuItemMatcher, true);
        MenuItemIndex menuItemIndex2 = MenuUpdateRequest.getMatcherEdgeIndex(iMenuItemMatcher2, true);
        MenuItemIndex menuItemIndex3 = MenuUpdateRequest.getMatcherEdgeIndex(iMenuItemMatcher, false);
        MenuItemIndex menuItemIndex4 = MenuUpdateRequest.getMatcherEdgeIndex(iMenuItemMatcher2, false);
        if (menuItemIndex == null || menuItemIndex2 == null || menuItemIndex3 == null || menuItemIndex4 == null) {
            return UPDATE_ALL;
        }
        MenuItemIndex menuItemIndex5 = menuItemIndex.isBefore(menuItemIndex2) ? menuItemIndex : menuItemIndex2;
        MenuItemIndex menuItemIndex6 = menuItemIndex3.isBefore(menuItemIndex4) ? menuItemIndex4 : menuItemIndex3;
        return new MatchItemsRange(menuItemIndex5, menuItemIndex6);
    }

    private static boolean isCoveredByMenuChildUpdate(int n, IMenuItemMatcher iMenuItemMatcher) {
        if (iMenuItemMatcher instanceof MatchAllOrNoneItems) {
            return !((MatchAllOrNoneItems)iMenuItemMatcher).matchAll;
        }
        if (iMenuItemMatcher instanceof MatchItemsRange) {
            MatchItemsRange matchItemsRange = (MatchItemsRange)iMenuItemMatcher;
            return ((MatchItemsRange)matchItemsRange).from.widget == n && ((MatchItemsRange)matchItemsRange).to.widget == n;
        }
        if (iMenuItemMatcher instanceof MatchMenuChildWidget) {
            return ((MatchMenuChildWidget)iMenuItemMatcher).widgetIndex == n;
        }
        if (iMenuItemMatcher instanceof MatchSingleItem) {
            return ((MatchSingleItem)((MatchSingleItem)iMenuItemMatcher)).matchIndex.widget == n;
        }
        menuLogCh.log(10000, "MenuUpdateRequest#isCoveredByMenuChildUpdate: unknown items matcher: %1", (Object)iMenuItemMatcher);
        return false;
    }

    private static MenuItemIndex getMatcherEdgeIndex(IMenuItemMatcher iMenuItemMatcher, boolean bl) {
        if (iMenuItemMatcher instanceof MatchItemsRange) {
            MatchItemsRange matchItemsRange = (MatchItemsRange)iMenuItemMatcher;
            return bl ? matchItemsRange.from : matchItemsRange.to;
        }
        if (iMenuItemMatcher instanceof MatchSingleItem) {
            return ((MatchSingleItem)iMenuItemMatcher).matchIndex;
        }
        menuLogCh.log(10000, "MenuUpdateRequest#getMatcherEdgeIndex: unknown items matcher: %1", (Object)iMenuItemMatcher);
        return null;
    }

    public static class MatchItemsRange
    implements IMenuItemMatcher {
        private final MenuItemIndex from;
        private final MenuItemIndex to;

        public MatchItemsRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
            this.from = menuItemIndex;
            this.to = menuItemIndex2;
        }

        public boolean matches(MenuItemIndex menuItemIndex) {
            return !menuItemIndex.isBefore(this.from) && !this.to.isBefore(menuItemIndex);
        }

        public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
            if (menuItemIndex2 != null && MenuLayoutData.isBefore(menuItemIndex2, this.from, true)) {
                return false;
            }
            return menuItemIndex == null || !MenuLayoutData.isBefore(this.to, menuItemIndex, true);
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + (this.from == null ? 0 : this.from.hashCode());
            n = 31 * n + (this.to == null ? 0 : this.to.hashCode());
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof MatchItemsRange)) {
                return false;
            }
            MatchItemsRange matchItemsRange = (MatchItemsRange)object;
            if (this.from == null ? matchItemsRange.from != null : !this.from.equals(matchItemsRange.from)) {
                return false;
            }
            return !(this.to == null ? matchItemsRange.to != null : !this.to.equals(matchItemsRange.to));
        }

        public String toString() {
            return new StringBuffer().append(this.getClass().getName()).append("[from=").append(this.from).append(", to=").append(this.to).append("]").toString();
        }
    }

    public static class MatchSingleItem
    implements IMenuItemMatcher {
        private final MenuItemIndex matchIndex;

        public MatchSingleItem(MenuItemIndex menuItemIndex) {
            this.matchIndex = menuItemIndex;
        }

        public boolean matches(MenuItemIndex menuItemIndex) {
            return this.matchIndex.equals(menuItemIndex);
        }

        public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
            if (menuItemIndex2 != null && MenuLayoutData.isBefore(menuItemIndex2, this.matchIndex, true)) {
                return false;
            }
            return menuItemIndex == null || !MenuLayoutData.isBefore(this.matchIndex, menuItemIndex, true);
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + (this.matchIndex == null ? 0 : this.matchIndex.hashCode());
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof MatchSingleItem)) {
                return false;
            }
            MatchSingleItem matchSingleItem = (MatchSingleItem)object;
            return !(this.matchIndex == null ? matchSingleItem.matchIndex != null : !this.matchIndex.equals(matchSingleItem.matchIndex));
        }

        public String toString() {
            return new StringBuffer().append(this.getClass().getName()).append("[").append(this.matchIndex).append("]").toString();
        }
    }

    public static interface IMenuItemMatcher {
        public boolean matches(MenuItemIndex var1);

        public boolean mayMatchInRange(MenuItemIndex var1, MenuItemIndex var2);
    }

    public static class MatchAllOrNoneItems
    implements IMenuItemMatcher {
        private final boolean matchAll;

        public MatchAllOrNoneItems(boolean bl) {
            this.matchAll = bl;
        }

        public boolean matches(MenuItemIndex menuItemIndex) {
            return this.matchAll;
        }

        public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
            return this.matchAll;
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + (this.matchAll ? 1231 : 1237);
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof MatchAllOrNoneItems)) {
                return false;
            }
            MatchAllOrNoneItems matchAllOrNoneItems = (MatchAllOrNoneItems)object;
            return this.matchAll == matchAllOrNoneItems.matchAll;
        }

        public boolean isMatchAll() {
            return this.matchAll;
        }

        public String toString() {
            return new StringBuffer().append(this.getClass().getName()).append("[").append(this.matchAll ? "all" : "none").append("]").toString();
        }
    }

    public static class MatchMenuChildWidget
    implements IMenuItemMatcher {
        private final int widgetIndex;

        public MatchMenuChildWidget(int n) {
            this.widgetIndex = n;
        }

        public boolean matches(MenuItemIndex menuItemIndex) {
            return menuItemIndex.widget == this.widgetIndex;
        }

        public boolean mayMatchInRange(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
            if (menuItemIndex2 != null && menuItemIndex2.widget < this.widgetIndex) {
                return false;
            }
            return menuItemIndex == null || menuItemIndex.widget <= this.widgetIndex;
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.widgetIndex;
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof MatchMenuChildWidget)) {
                return false;
            }
            MatchMenuChildWidget matchMenuChildWidget = (MatchMenuChildWidget)object;
            return this.widgetIndex == matchMenuChildWidget.widgetIndex;
        }

        public String toString() {
            return new StringBuffer().append(this.getClass().getName()).append("[index=").append(this.widgetIndex).append("]").toString();
        }
    }
}

