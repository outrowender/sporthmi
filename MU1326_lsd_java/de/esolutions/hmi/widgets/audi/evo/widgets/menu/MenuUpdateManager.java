/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.FocusAdviceHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateManager$MatcherWrapperAfterIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import java.util.Iterator;
import java.util.ListIterator;

public class MenuUpdateManager
implements WidgetConstants {
    private static final LogChannel LC = IWidgetLogChannel.menuLogCh;
    private final MenuLayoutData layoutData;
    private final MenuController menu;

    public MenuUpdateManager(MenuController menuController, MenuLayoutData menuLayoutData) {
        this.menu = menuController;
        this.layoutData = menuLayoutData;
    }

    public void updateViewport(MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta) {
        LC.log(-2137614336, "MenuUpdateManager#updateViewport: ++++ start updateViewport. old viewport: %1, old alignment: %4, request: %2 (%3)", (Object)menuUpdateDelta.getOldViewport(), (Object)menuUpdateRequest, (Object)this.menu, (Object)(this.layoutData.alignTop ? "top" : "bottom"));
        if (this.menu.isLayoutItemsDirty()) {
            LC.log(-1601830656, "MenuUpdateManager#updateViewport: layoutItems are not up to date. refresh all");
            menuUpdateRequest.updateItems = MenuUpdateRequest.UPDATE_ALL;
        }
        this.updateMenuAlignment(menuUpdateRequest);
        ListIterator listIterator = this.updateFocusedItem(menuUpdateRequest, menuUpdateDelta);
        if (listIterator == null) {
            this.clearMenu(menuUpdateDelta);
            return;
        }
        MenuItemMetaData menuItemMetaData = this.getFocusedItem(listIterator);
        LC.log(-2137614336, "MenuUpdateManager#updateViewport: found focus item: %1", (Object)menuItemMetaData);
        boolean bl = this.updateFromFocusToViewportEdge(listIterator, menuUpdateRequest.updateItems, menuUpdateRequest.focusAdvice, menuUpdateDelta.getOldViewport(), menuUpdateDelta);
        this.adjustIteratorForAlignedViewportEdge(listIterator, bl);
        MenuViewport menuViewport = this.updateToOppositeViewportEdge(true, listIterator, menuUpdateRequest, menuItemMetaData, menuUpdateDelta.getOldViewport(), menuUpdateDelta);
        LC.log(-2137614336, "MenuUpdateManager#updateViewport: found viewport: %1, alignment: %2", (Object)menuViewport, (Object)(this.layoutData.alignTop ? "top" : "bottom"));
        this.updateItemsOutsideViewport(menuViewport, menuUpdateRequest.updateItems, menuUpdateDelta);
        MenuItemIndex menuItemIndex = this.getFocusedIndexInViewport(menuItemMetaData, menuViewport);
        if (menuItemIndex != null) {
            menuItemIndex = this.menu.getUnfocusableVisibleEdge(menuItemIndex, false, menuViewport);
        }
        LC.log(-2137614336, "MenuUpdateManager#updateViewport: new layoutItems: %1", (Object)this.layoutData.layoutItems);
        LC.log(-2137614336, "MenuUpdateManager#updateViewport: ---- end updateViewport. new viewport: %1, new focus: %2, new alignment: %3", (Object)menuViewport, (Object)menuItemMetaData, (Object)(this.layoutData.alignTop ? "top" : "bottom"));
        this.menu.setViewport(menuViewport);
        this.menu.setFocusedIndex(menuItemIndex);
    }

    private void updateMenuAlignment(MenuUpdateRequest menuUpdateRequest) {
        boolean bl = this.shouldAlignTop(menuUpdateRequest);
        if (bl != this.layoutData.alignTop) {
            LC.log(-2137614336, "MenuUpdateManager#updateMenuAlignment: change alignment to: %1", (Object)(bl ? "top" : "bottom"));
            this.layoutData.alignTop = bl;
        }
    }

    private boolean shouldAlignTop(MenuUpdateRequest menuUpdateRequest) {
        if (menuUpdateRequest.customAlignmentTop != null) {
            return menuUpdateRequest.customAlignmentTop;
        }
        FocusAdvice focusAdvice = menuUpdateRequest.focusAdvice;
        if (focusAdvice == FocusAdvice.VIEWPORT_FIRST_POSITION || focusAdvice == FocusAdvice.VIEWPORT_SECOND_POSITION) {
            return true;
        }
        if (focusAdvice instanceof WidgetFocusAdvice) {
            return ((WidgetFocusAdvice)focusAdvice).isTopAligned();
        }
        return this.layoutData.alignTop;
    }

    private MenuItemIndex getFocusedIndexInViewport(MenuItemMetaData menuItemMetaData, MenuViewport menuViewport) {
        MenuItemIndex menuItemIndex = menuItemMetaData.index;
        if (menuViewport.contains(menuItemIndex)) {
            return menuItemIndex;
        }
        LC.log(10000, "MenuUpdateManager#getFocusedIndexInViewport: focusItem %1 is outside of viewport: %2", (Object)menuItemMetaData, (Object)menuViewport);
        if (menuViewport.isEmpty()) {
            return null;
        }
        if (menuItemIndex.isBefore(menuViewport.start)) {
            return menuViewport.start;
        }
        return menuViewport.end;
    }

    ListIterator updateFocusedItem(MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta) {
        ListIterator listIterator;
        int n;
        boolean bl;
        MenuItemIndex menuItemIndex = menuUpdateRequest.focusIndex;
        if (menuItemIndex == null) {
            menuItemIndex = this.menu.getFirstMenuItem();
            if (menuItemIndex == null) {
                return null;
            }
            LC.log(-2137614336, "MenuUpdateManager#updateFocusedItem: request has no focus, use first item instead: %1", (Object)menuItemIndex);
        }
        boolean bl2 = bl = (n = this.layoutData.findAnimationItemListIndex(menuItemIndex)) >= 0;
        if (!bl) {
            n = -n - 1;
        }
        if (bl && !menuUpdateRequest.updateItems.matches(menuItemIndex)) {
            int n2 = this.isTopAlign() ? n + 1 : n;
            return this.layoutData.layoutItems.listIterator(n2);
        }
        if (this.menu.isValidMenuItemIndex(menuItemIndex)) {
            listIterator = this.layoutData.layoutItems.listIterator(n);
            this.updateNextItemUntilIndex(menuItemIndex, false, listIterator, true, menuUpdateRequest.updateItems, menuUpdateDelta);
            if (menuUpdateDelta.latestItem != null && !menuUpdateDelta.latestItem.remove) {
                if (!this.isTopAlign()) {
                    listIterator.previous();
                }
                return listIterator;
            }
        } else if (bl) {
            listIterator = this.layoutData.layoutItems.listIterator(n);
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)listIterator.next();
            LC.log(-2137614336, "MenuUpdateManager#updateFocusedItem: item %1 is not valid any more, remove it.", (Object)menuItemMetaData.index);
            menuUpdateDelta.itemRemoved(menuItemMetaData);
            this.destroyItem(listIterator, menuItemMetaData);
        } else {
            listIterator = this.layoutData.layoutItems.listIterator(n);
        }
        LC.log(-1601830656, "MenuUpdateManager#updateFocusedItem: requested focused index %1 is invalid", (Object)menuItemIndex);
        boolean bl3 = this.findNearestFocusItem(menuItemIndex, listIterator, this.isTopAlign(), menuUpdateRequest, menuUpdateDelta);
        if (bl3) {
            return listIterator;
        }
        bl3 = this.findNearestFocusItem(menuItemIndex, listIterator, !this.isTopAlign(), menuUpdateRequest, menuUpdateDelta);
        if (bl3) {
            MenuLayoutData.next(listIterator, this.isTopAlign());
            return listIterator;
        }
        LC.log(-2137614336, "MenuUpdateManager#updateFocusedItem: menu is empty");
        return null;
    }

    MenuItemMetaData getFocusedItem(ListIterator listIterator) {
        return (MenuItemMetaData)MenuLayoutData.peekNextItem(listIterator, !this.isTopAlign());
    }

    private boolean findNearestFocusItem(MenuItemIndex menuItemIndex, ListIterator listIterator, boolean bl, MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta) {
        Iterator iterator = this.menu.iterator(menuItemIndex, bl, false);
        while (iterator.hasNext() || MenuLayoutData.hasNext(listIterator, bl)) {
            MenuItemIndex menuItemIndex2 = iterator.hasNext() ? (MenuItemIndex)iterator.next() : null;
            do {
                this.updateNextItemUntilIndex(menuItemIndex2, false, listIterator, bl, menuUpdateRequest.updateItems, menuUpdateDelta);
                if (menuUpdateDelta.latestItem == null || menuUpdateDelta.latestItem.remove) continue;
                LC.log(-2137614336, "MenuUpdateManager#findNearestFocusItem: nearest item: %2, downward: %1", bl, (Object)menuUpdateDelta.latestItem);
                return true;
            } while (!menuUpdateDelta.requestedItemReached);
        }
        LC.log(-2137614336, "MenuUpdateManager#findNearestFocusItem: no alternative focus item in this direction. downward: %1", bl);
        return false;
    }

    boolean updateFromFocusToViewportEdge(ListIterator listIterator, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher, FocusAdvice focusAdvice, MenuViewport menuViewport, MenuUpdateDelta menuUpdateDelta) {
        boolean bl = !this.isTopAlign();
        FocusAdviceHandler focusAdviceHandler = new FocusAdviceHandler(focusAdvice, menuViewport, this.layoutData, this.menu);
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)MenuLayoutData.next(listIterator, bl);
        focusAdviceHandler.initialize(menuItemMetaData);
        int n = focusAdviceHandler.evaluateFocusPosition(menuItemMetaData);
        if (n == 0) {
            LC.log(-2137614336, "MenuUpdateManager#updateFromFocusToViewportEdge: viewport edge: %1 (best match), focusAdvice: %2", (Object)menuItemMetaData, (Object)focusAdvice);
            return true;
        }
        if (n == 4) {
            this.layoutData.alignTop = bl;
            LC.log(-2137614336, "MenuUpdateManager#updateFromFocusToViewportEdge: change alignment at initial item %1 to %3, focusAdvice: %2", (Object)menuItemMetaData, (Object)focusAdvice, (Object)(this.layoutData.alignTop ? "top" : "bottom"));
            return this.updateFromFocusToViewportEdge(listIterator, menuUpdateRequest$IMenuItemMatcher, focusAdvice, menuViewport, menuUpdateDelta);
        }
        if (n != 1) {
            LC.log(-2137614336, "MenuUpdateManager#updateFromFocusToViewportEdge: first item %1 is already bad, use it anyway. focusAdvice: %2", (Object)menuItemMetaData, (Object)focusAdvice);
            return true;
        }
        MenuItemMetaData menuItemMetaData2 = menuItemMetaData;
        Iterator iterator = this.menu.iterator(menuItemMetaData.index, bl, false);
        while (iterator.hasNext() || MenuLayoutData.hasNext(listIterator, bl)) {
            MenuItemIndex menuItemIndex = iterator.hasNext() ? (MenuItemIndex)iterator.next() : null;
            do {
                this.updateNextItemUntilIndex(menuItemIndex, false, listIterator, bl, menuUpdateRequest$IMenuItemMatcher, menuUpdateDelta);
                MenuItemMetaData menuItemMetaData3 = menuUpdateDelta.latestItem;
                if (menuItemMetaData3 == null) continue;
                int n2 = focusAdviceHandler.evaluateFocusPosition(menuItemMetaData3);
                if (n2 == 0) {
                    LC.log(-2137614336, "MenuUpdateManager#updateFromFocusToViewportEdge: viewport edge: %1 (best match), focusAdvice: %2", (Object)menuItemMetaData3, (Object)focusAdvice);
                    return true;
                }
                if (n2 == 2) {
                    LC.log(-2137614336, "MenuUpdateManager#updateFromFocusToViewportEdge: viewport edge: %1 (next item is worse), focusAdvice: %2", (Object)menuItemMetaData2, (Object)focusAdvice);
                    return false;
                }
                if (n2 == 3 || n2 == 4) {
                    this.iterateUntil(listIterator, menuItemMetaData, !bl);
                    MenuLayoutData.next(listIterator, bl);
                    this.layoutData.alignTop = bl;
                    LC.log(-2137614336, "MenuUpdateManager#updateFromFocusToViewportEdge: change alignment to %3, current item: %1, focusAdvice: %2", (Object)menuItemMetaData3, (Object)focusAdvice, (Object)(this.layoutData.alignTop ? "top" : "bottom"));
                    FocusAdvice focusAdvice2 = n2 == 3 ? FocusAdvice.VIEWPORT_FIRST_POSITION : focusAdvice;
                    return this.updateFromFocusToViewportEdge(listIterator, menuUpdateRequest$IMenuItemMatcher, focusAdvice2, menuViewport, menuUpdateDelta);
                }
                menuItemMetaData2 = menuItemMetaData3;
            } while (!menuUpdateDelta.requestedItemReached);
        }
        LC.log(-2137614336, "MenuUpdateManager#updateFromFocusToViewportEdge: viewport edge: %1, focusAdvice: %2", (Object)menuItemMetaData2, (Object)focusAdvice);
        return true;
    }

    private void iterateUntil(ListIterator listIterator, MenuItemMetaData menuItemMetaData, boolean bl) {
        while (MenuLayoutData.hasNext(listIterator, bl)) {
            MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)MenuLayoutData.next(listIterator, bl);
            if (!Util.equals(menuItemMetaData2, menuItemMetaData)) continue;
            return;
        }
        LC.log(10000, "MenuUpdateManager#iterateUntil: destination item not found: %2, downward: %1, layoutItems: %3", bl, (Object)menuItemMetaData, (Object)this.layoutData.layoutItems);
    }

    MenuItemMetaData adjustIteratorForAlignedViewportEdge(ListIterator listIterator, boolean bl) {
        if (!bl) {
            MenuLayoutData.next(listIterator, this.isTopAlign());
        }
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)MenuLayoutData.peekNextItem(listIterator, this.isTopAlign());
        while (menuItemMetaData.remove) {
            if (!MenuLayoutData.hasNext(listIterator, this.isTopAlign())) {
                LC.log(10000, "MenuUpdateManager#adjustIteratorForAlignedViewportEdge: end of items reached. items: %2. was exactAfterEdge: %1", bl, (Object)this.layoutData.layoutItems);
                return menuItemMetaData;
            }
            MenuLayoutData.next(listIterator, this.isTopAlign());
            menuItemMetaData = (MenuItemMetaData)MenuLayoutData.peekNextItem(listIterator, this.isTopAlign());
        }
        return menuItemMetaData;
    }

    MenuViewport updateToOppositeViewportEdge(boolean bl, ListIterator listIterator, MenuUpdateRequest menuUpdateRequest, MenuItemMetaData menuItemMetaData, MenuViewport menuViewport, MenuUpdateDelta menuUpdateDelta) {
        MenuItemMetaData menuItemMetaData2;
        boolean bl2 = this.isTopAlign();
        MenuUpdateManager$MatcherWrapperAfterIndex menuUpdateManager$MatcherWrapperAfterIndex = new MenuUpdateManager$MatcherWrapperAfterIndex(menuItemMetaData.index, bl2, menuUpdateRequest.updateItems);
        int n = this.menu.getLayout().getContentAreaHeight();
        MenuItemMetaData menuItemMetaData3 = menuItemMetaData2 = (MenuItemMetaData)MenuLayoutData.peekNextItem(listIterator, bl2);
        boolean bl3 = true;
        Iterator iterator = this.menu.iterator(menuItemMetaData2.index, bl2, true);
        while (iterator.hasNext() || MenuLayoutData.hasNext(listIterator, bl2)) {
            MenuItemIndex menuItemIndex = iterator.hasNext() ? (MenuItemIndex)iterator.next() : null;
            do {
                this.updateNextItemUntilIndex(menuItemIndex, false, listIterator, bl2, menuUpdateManager$MatcherWrapperAfterIndex, menuUpdateDelta);
                MenuItemMetaData menuItemMetaData4 = menuUpdateDelta.latestItem;
                if (menuItemMetaData4 == null) continue;
                int n2 = menuItemMetaData4.heightAfter;
                boolean bl4 = bl2;
                if (bl3) {
                    bl3 = false;
                    n2 += this.menu.getMenuItemGlassplateInsets(menuItemMetaData4, bl4);
                } else {
                    n2 += this.menu.getLayout().getItemsGap();
                }
                int n3 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData4, !bl4);
                int n4 = n - (n2 + n3);
                if (n4 < 0) {
                    LC.log(-2137614336, "MenuUpdateManager#updateToOppositeViewportEdge: opposite viewport edge: %1 (remaining space: %3), aligned edge: %2", (Object)menuItemMetaData3, (Object)menuItemMetaData2, (long)n);
                    if (!(bl2 || bl || this.shouldUseItemToFillViewport(menuItemMetaData4, menuItemMetaData, menuViewport, bl2, menuUpdateRequest.focusAdvice))) {
                        LC.log(-2137614336, "MenuUpdateManager#updateToOppositeViewportEdge: don't show item %1 partially, so change alignment to top", (Object)menuItemMetaData4);
                        this.layoutData.alignTop = true;
                    }
                    return this.createMenuViewport(menuItemMetaData2, menuItemMetaData3, menuUpdateDelta);
                }
                if (!bl2 && !this.shouldUseItemToFillViewport(menuItemMetaData4, menuItemMetaData, menuViewport, bl2, menuUpdateRequest.focusAdvice)) {
                    LC.log(-2137614336, "MenuUpdateManager#updateToOppositeViewportEdge: stop at %1, don't fill with item %2, remaining height: %3", (Object)menuItemMetaData3, (Object)menuItemMetaData4, (long)n);
                    MenuLayoutData.next(listIterator, !bl2);
                    return this.oppositeViewportEdgeReached(bl, listIterator, menuUpdateRequest, menuItemMetaData2, menuItemMetaData3, menuViewport, menuUpdateDelta);
                }
                if (n4 <= this.menu.getLayout().getItemsGap()) {
                    LC.log(-2137614336, "MenuUpdateManager#updateToOppositeViewportEdge: opposite viewport edge: %1 (exact fit, remaining empty space: %3), aligned edge: %2, set alignment to top.", (Object)menuItemMetaData4, (Object)menuItemMetaData2, (long)n4);
                    this.layoutData.alignTop = true;
                    return this.createMenuViewport(menuItemMetaData2, menuItemMetaData4, menuUpdateDelta);
                }
                n -= n2;
                if (menuItemMetaData4.remove) continue;
                menuItemMetaData3 = menuItemMetaData4;
            } while (!menuUpdateDelta.requestedItemReached);
        }
        LC.log(-2137614336, "MenuUpdateManager#updateToOppositeViewportEdge: end of menu reached at %1, remaining height: %2", (Object)menuItemMetaData3, (long)n);
        return this.oppositeViewportEdgeReached(bl, listIterator, menuUpdateRequest, menuItemMetaData2, menuItemMetaData3, menuViewport, menuUpdateDelta);
    }

    private MenuViewport oppositeViewportEdgeReached(boolean bl, ListIterator listIterator, MenuUpdateRequest menuUpdateRequest, MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2, MenuViewport menuViewport, MenuUpdateDelta menuUpdateDelta) {
        if (bl) {
            this.layoutData.alignTop = !this.layoutData.alignTop;
            LC.log(-2137614336, "MenuUpdateManager#oppositeViewportEdgeReached: try to fill viewport, change alignment to %1", (Object)(this.layoutData.alignTop ? "top" : "bottom"));
            return this.updateToOppositeViewportEdge(false, listIterator, menuUpdateRequest, menuItemMetaData, menuViewport, menuUpdateDelta);
        }
        LC.log(-2137614336, "MenuUpdateManager#oppositeViewportEdgeReached: too few items. started from: %1, set alignment to top.", (Object)menuItemMetaData);
        this.layoutData.alignTop = true;
        return this.createMenuViewport(menuItemMetaData, menuItemMetaData2, menuUpdateDelta);
    }

    private MenuItemIndex getAlreadyAcceptedViewportEdge(MenuItemMetaData menuItemMetaData, MenuViewport menuViewport, boolean bl) {
        if (menuViewport != null && !menuViewport.isEmpty()) {
            MenuItemIndex menuItemIndex;
            MenuItemIndex menuItemIndex2 = menuItemIndex = bl ? menuViewport.end : menuViewport.start;
            if (MenuLayoutData.isBefore(menuItemIndex, menuItemMetaData.index, bl)) {
                return menuItemMetaData.index;
            }
            return menuItemIndex;
        }
        return menuItemMetaData.index;
    }

    boolean shouldUseItemToFillViewport(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2, MenuViewport menuViewport, boolean bl, FocusAdvice focusAdvice) {
        MenuItemIndex menuItemIndex = this.getAlreadyAcceptedViewportEdge(menuItemMetaData2, menuViewport, bl);
        return this.shouldUseItemToFillViewport(menuItemMetaData, menuItemIndex, menuItemMetaData2.index, bl, focusAdvice);
    }

    private boolean shouldUseItemToFillViewport(MenuItemMetaData menuItemMetaData, MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, boolean bl, FocusAdvice focusAdvice) {
        AbstractWidget abstractWidget;
        if (focusAdvice == FocusAdvice.VIEWPORT_FIRST_POSITION && MenuLayoutData.isBefore(menuItemIndex2, menuItemMetaData.index, bl)) {
            return false;
        }
        if (menuItemIndex.widget == menuItemMetaData.index.widget) {
            return true;
        }
        if (!MenuLayoutData.isBefore(menuItemIndex, menuItemMetaData.index, bl)) {
            return true;
        }
        if (!this.menu.getInitialization().isInitialAvoidPartiallyEmptyViewport() && (abstractWidget = this.menu.getChild(menuItemMetaData.index.widget)) instanceof TouchController) {
            return false;
        }
        abstractWidget = this.menu.getChild(menuItemIndex.widget);
        return !(abstractWidget instanceof TouchController) || focusAdvice == FocusAdvice.VIEWPORT_LAST_POSITION;
    }

    private MenuViewport createMenuViewport(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2, MenuUpdateDelta menuUpdateDelta) {
        if (menuItemMetaData.index.isBefore(menuItemMetaData2.index)) {
            menuUpdateDelta.viewportStartItem = menuItemMetaData;
            menuUpdateDelta.viewportEndItem = menuItemMetaData2;
            return new MenuViewport(menuItemMetaData.index, menuItemMetaData2.index);
        }
        menuUpdateDelta.viewportStartItem = menuItemMetaData2;
        menuUpdateDelta.viewportEndItem = menuItemMetaData;
        return new MenuViewport(menuItemMetaData2.index, menuItemMetaData.index);
    }

    void updateItemsOutsideViewport(MenuViewport menuViewport, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher, MenuUpdateDelta menuUpdateDelta) {
        int n = this.updateRemainingLayoutItems(this.layoutData.layoutItems.listIterator(), true, menuViewport.start, menuUpdateRequest$IMenuItemMatcher, menuUpdateDelta);
        int n2 = this.updateRemainingLayoutItems(this.layoutData.layoutItems.listIterator(this.layoutData.layoutItems.size()), false, menuViewport.end, menuUpdateRequest$IMenuItemMatcher, menuUpdateDelta);
        if (this.layoutData.layoutItems.isEmpty()) {
            return;
        }
        int n3 = this.layoutData.alignTop ? n : n2;
        int n4 = this.layoutData.alignTop ? n2 : n;
        int n5 = this.layoutData.alignTop ? 0 : this.layoutData.layoutItems.size() - 1;
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.layoutData.layoutItems.get(n5);
        int n6 = this.layoutData.alignTop ? this.layoutData.layoutItems.size() - 1 : 0;
        MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)this.layoutData.layoutItems.get(n6);
        if (n3 == 0 && this.needsAdditionalMoveItemBeforeViewport(menuItemMetaData.index)) {
            this.createAdditionalItemOutsideViewport(menuItemMetaData.index, !this.layoutData.alignTop, menuUpdateDelta);
        }
        if (n4 <= 1 && this.needsAdditionalMoveItemAfterViewport(menuItemMetaData2.index)) {
            this.createAdditionalItemOutsideViewport(menuItemMetaData2.index, this.layoutData.alignTop, menuUpdateDelta);
        }
    }

    private void createAdditionalItemOutsideViewport(MenuItemIndex menuItemIndex, boolean bl, MenuUpdateDelta menuUpdateDelta) {
        Iterator iterator = this.menu.iterator(menuItemIndex, bl, false);
        if (!iterator.hasNext()) {
            LC.log(-1601830656, "MenuUpdateManager#createAdditionalItemBefore: can not create additional item after %1, because end of menu is reached.", (Object)menuItemIndex);
            return;
        }
        MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
        ListIterator listIterator = bl ? this.layoutData.layoutItems.listIterator(this.layoutData.layoutItems.size()) : this.layoutData.layoutItems.listIterator();
        this.updateNextItemUntilIndex(menuItemIndex2, false, listIterator, bl, MenuUpdateRequest.UPDATE_NONE, menuUpdateDelta);
    }

    private int updateRemainingLayoutItems(ListIterator listIterator, boolean bl, MenuItemIndex menuItemIndex, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher, MenuUpdateDelta menuUpdateDelta) {
        if (!MenuLayoutData.hasNext(listIterator, bl)) {
            return 0;
        }
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)MenuLayoutData.peekNextItem(listIterator, bl);
        int n = 0;
        Iterator iterator = this.menu.iterator(menuItemMetaData.index, bl, true);
        while (iterator.hasNext()) {
            MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
            if (MenuLayoutData.isBefore(menuItemIndex, menuItemIndex2, bl)) {
                return n;
            }
            do {
                MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)MenuLayoutData.peekNextItem(listIterator, bl);
                if (menuItemMetaData2.index.equals(menuItemIndex) && menuItemIndex2.equals(menuItemIndex)) {
                    return n;
                }
                this.updateNextItemUntilIndex(menuItemIndex2, false, listIterator, bl, menuUpdateRequest$IMenuItemMatcher, menuUpdateDelta);
                if (menuUpdateDelta.latestItem == null) continue;
                ++n;
            } while (!menuUpdateDelta.requestedItemReached);
        }
        return n;
    }

    private void updateNextItemUntilIndex(MenuItemIndex menuItemIndex, boolean bl, ListIterator listIterator, boolean bl2, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher, MenuUpdateDelta menuUpdateDelta) {
        MenuItemMetaData menuItemMetaData;
        if (menuItemIndex == null) {
            MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)MenuLayoutData.next(listIterator, bl2);
            if (!menuItemMetaData2.remove && menuUpdateRequest$IMenuItemMatcher.matches(menuItemMetaData2.index)) {
                LC.log(-2137614336, "MenuUpdateManager#updateNextItemUntilIndex: item %1 is not valid any more, remove it.", (Object)menuItemMetaData2.index);
                menuUpdateDelta.itemRemoved(menuItemMetaData2);
                this.destroyItem(listIterator, menuItemMetaData2);
                menuUpdateDelta.store(null, true);
            } else {
                menuUpdateDelta.store(menuItemMetaData2, true);
            }
            return;
        }
        if (MenuLayoutData.hasNext(listIterator, bl2)) {
            menuItemMetaData = (MenuItemMetaData)MenuLayoutData.next(listIterator, bl2);
            if (MenuLayoutData.isBefore(menuItemIndex, menuItemMetaData.index, bl2)) {
                MenuLayoutData.next(listIterator, !bl2);
            } else {
                this.updateItemDuringIteration(menuItemIndex, bl, menuItemMetaData, listIterator, menuUpdateRequest$IMenuItemMatcher, menuUpdateDelta);
                return;
            }
        }
        LC.log(14808325, "MenuUpdateManager#updateNextItemUntilIndex: insert item: %2, fadeIn: %1", bl, (Object)menuItemIndex);
        menuItemMetaData = this.menu.createMenuItem(menuItemIndex);
        menuUpdateDelta.store(menuItemMetaData, true);
        if (menuItemMetaData != null) {
            this.itemAdded(menuItemMetaData, bl, menuUpdateDelta);
            listIterator.add(menuItemMetaData);
            if (!bl2) {
                listIterator.previous();
            }
        } else {
            LC.log(-1601830656, "MenuUpdateManager#updateNextItemUntilIndex: can not create item %1, probably removed from model", (Object)menuItemIndex);
        }
    }

    private void updateItemDuringIteration(MenuItemIndex menuItemIndex, boolean bl, MenuItemMetaData menuItemMetaData, ListIterator listIterator, MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher, MenuUpdateDelta menuUpdateDelta) {
        if (menuItemMetaData.remove) {
            menuUpdateDelta.store(menuItemMetaData, false);
        } else if (menuItemIndex.equals(menuItemMetaData.index)) {
            if (menuUpdateRequest$IMenuItemMatcher.matches(menuItemMetaData.index)) {
                this.updateItemItself(menuItemMetaData, bl, listIterator, menuUpdateDelta);
            } else {
                menuUpdateDelta.store(menuItemMetaData, true);
            }
        } else if (menuUpdateRequest$IMenuItemMatcher.matches(menuItemMetaData.index)) {
            LC.log(-2137614336, "MenuUpdateManager#updateItemsUntilIndex: item %1 is not valid any more, remove it.", (Object)menuItemMetaData.index);
            menuUpdateDelta.itemRemoved(menuItemMetaData);
            this.destroyItem(listIterator, menuItemMetaData);
            menuUpdateDelta.store(null, false);
        } else {
            menuUpdateDelta.store(menuItemMetaData, false);
        }
    }

    private void updateItemItself(MenuItemMetaData menuItemMetaData, boolean bl, ListIterator listIterator, MenuUpdateDelta menuUpdateDelta) {
        MenuItemMetaData menuItemMetaData2 = this.menu.updateMenuItem(menuItemMetaData);
        menuUpdateDelta.store(menuItemMetaData2, true);
        if (!Util.equals(menuItemMetaData, menuItemMetaData2)) {
            this.layoutData.removeItemFromCache(menuItemMetaData);
            menuUpdateDelta.itemRemoved(menuItemMetaData);
            if (menuItemMetaData2 != null) {
                LC.log(-2137614336, "MenuUpdateManager#updateItemItself: item %2 is not valid any more, replace it (fadeIn: %1).", bl, (Object)menuItemMetaData.index);
                this.itemAdded(menuItemMetaData2, bl, menuUpdateDelta);
                listIterator.set(menuItemMetaData2);
            } else {
                LC.log(1078071040, "MenuUpdateManager#updateItemItself: item %1 is not valid and could not be replaced, probably removed from model.", (Object)menuItemMetaData.index);
                listIterator.remove();
            }
        } else if (bl) {
            LC.log(-1601830656, "MenuUpdateManager#updateItemItself: item %1 already existed with height %2, but should fade in.", (Object)menuItemMetaData.index, (long)menuItemMetaData.heightBefore);
            this.setupForFadeIn(menuItemMetaData);
        }
    }

    private void itemAdded(MenuItemMetaData menuItemMetaData, boolean bl, MenuUpdateDelta menuUpdateDelta) {
        if (bl) {
            this.setupForFadeIn(menuItemMetaData);
        } else {
            menuUpdateDelta.itemAdded(menuItemMetaData);
        }
    }

    private void setupForFadeIn(MenuItemMetaData menuItemMetaData) {
        menuItemMetaData.heightBefore = -this.menu.getLayout().getItemsGap();
        menuItemMetaData.opacityBefore = 0.0f;
    }

    private void clearMenu(MenuUpdateDelta menuUpdateDelta) {
        this.menu.setFocusedIndex(null);
        this.menu.setViewport(new MenuViewport(null, null));
        menuUpdateDelta.heightDeltaAbove = 0;
        menuUpdateDelta.heightDeltaBelow = 0;
        menuUpdateDelta.itemsDeltaAbove = 0;
        menuUpdateDelta.itemsDeltaBelow = 0;
    }

    private boolean isTopAlign() {
        return this.layoutData.alignTop;
    }

    public void destroyUnusedItems() {
        ListIterator listIterator;
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.isEmpty()) {
            LC.log(-2137614336, "MenuUpdateManager#destroyUnusedItems: viewport is empty, destroy all items");
            this.destroyAllItems();
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        MenuItemMetaData menuItemMetaData = null;
        ListIterator listIterator2 = listIterator = this.layoutData.alignTop ? this.layoutData.layoutItems.listIterator() : this.layoutData.layoutItems.listIterator(this.layoutData.layoutItems.size());
        while (MenuLayoutData.hasNext(listIterator, this.layoutData.alignTop)) {
            MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)MenuLayoutData.next(listIterator, this.layoutData.alignTop);
            if (menuItemMetaData2.remove || !this.menu.isValidMenuItemIndex(menuItemMetaData2.index)) {
                LC.log(-2137614336, "MenuUpdateManager#destroyUnusedItems: destroy item: %2 (was removed: %1)", menuItemMetaData2.remove, (Object)menuItemMetaData2.index, (Object)null);
                this.destroyItem(listIterator, menuItemMetaData2);
                continue;
            }
            if (menuViewport.contains(menuItemMetaData2.index)) {
                bl = true;
                bl2 = true;
                continue;
            }
            if (bl2) {
                bl2 = false;
                bl3 = this.needsAdditionalMoveItemAfterViewport(menuItemMetaData2.index);
                continue;
            }
            if (bl3) {
                bl3 = false;
                continue;
            }
            if (!bl) {
                if (menuItemMetaData != null) {
                    LC.log(14808325, "MenuUpdateManager#destroyUnusedItems: destroy item %2 before viewport: %3 (was removed: %1)", menuItemMetaData.remove, (Object)menuItemMetaData.index, (Object)menuViewport);
                    this.destroyPreviousItem(listIterator, menuItemMetaData, menuItemMetaData2, this.layoutData.alignTop);
                    menuItemMetaData = null;
                }
                menuItemMetaData = menuItemMetaData2;
                continue;
            }
            LC.log(14808325, "MenuUpdateManager#destroyUnusedItems: destroy item %2 outside of viewport: %3 (was removed: %1)", menuItemMetaData2.remove, (Object)menuItemMetaData2.index, (Object)menuViewport);
            this.destroyItem(listIterator, menuItemMetaData2);
        }
        LC.log(-2137614336, "MenuUpdateManager#destroyUnusedItems: new layoutItems: %1", (Object)this.layoutData.layoutItems);
    }

    public void destroyItems(int n, int n2) {
        if (n == n2) {
            return;
        }
        LC.log(-2137614336, "MenuUpdateManager#destroyItems: destroy items from %1 to %2", (long)n, (long)n2);
        boolean bl = n < n2;
        int n3 = bl ? 1 : -1;
        int n4 = bl ? n : n + 1;
        ListIterator listIterator = this.layoutData.layoutItems.listIterator(n4);
        for (int i2 = n; i2 != n2; i2 += n3) {
            if (!MenuLayoutData.hasNext(listIterator, bl)) {
                LC.log(-1601830656, "MenuUpdateManager#destroyItems: end of list reached at index %1", (long)i2);
                return;
            }
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)MenuLayoutData.next(listIterator, bl);
            LC.log(14808325, "MenuUpdateManager#destroyItems: destroy item: %2 (was removed: %1), list index: %3", (Object)menuItemMetaData.remove, (Object)menuItemMetaData.index, (long)i2);
            this.destroyItem(listIterator, menuItemMetaData);
        }
    }

    private void destroyPreviousItem(ListIterator listIterator, MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2, boolean bl) {
        Object object = MenuLayoutData.next(listIterator, !bl);
        if (!Util.equals(menuItemMetaData2, object)) {
            LC.log(10000, "MenuUpdateManager#destroyPreviousItem: mismatch at current item. Expected: %1, was: %2, requested remove item: %3", (Object)menuItemMetaData2, object, (Object)menuItemMetaData);
            return;
        }
        MenuItemMetaData menuItemMetaData3 = (MenuItemMetaData)MenuLayoutData.next(listIterator, !bl);
        if (menuItemMetaData != menuItemMetaData3) {
            LC.log(10000, "MenuUpdateManager#destroyPreviousItem: mismatch at previous item. Expected: %1, was: %2, current item: %3", (Object)menuItemMetaData, (Object)menuItemMetaData3, (Object)menuItemMetaData2);
            return;
        }
        listIterator.remove();
        this.destroyItem(menuItemMetaData3);
        Object object2 = MenuLayoutData.next(listIterator, bl);
        if (!Util.equals(menuItemMetaData2, object2)) {
            LC.log(10000, "MenuUpdateManager#destroyPreviousItem: mismatch at current item after remove. Expected: %1, was: %2, requested remove item: %3", (Object)menuItemMetaData2, object2, (Object)menuItemMetaData);
            return;
        }
    }

    private boolean needsAdditionalMoveItemAfterViewport(MenuItemIndex menuItemIndex) {
        if (!this.menu.hasMoveItem()) {
            return false;
        }
        MenuItemIndex menuItemIndex2 = this.layoutData.moveGapIndexAfter;
        MenuItemIndex menuItemIndex3 = this.menu.getMoveItemIndex();
        boolean bl = this.layoutData.alignTop ? menuItemIndex.isBefore(menuItemIndex3) : menuItemIndex3.isBefore(menuItemIndex);
        return !bl && this.isMoveGapAfterViewport(menuItemIndex2, menuItemIndex3, menuItemIndex);
    }

    private boolean needsAdditionalMoveItemBeforeViewport(MenuItemIndex menuItemIndex) {
        if (!this.menu.hasMoveItem()) {
            return false;
        }
        MenuItemIndex menuItemIndex2 = this.layoutData.moveGapIndexAfter;
        MenuItemIndex menuItemIndex3 = this.menu.getMoveItemIndex();
        boolean bl = this.layoutData.alignTop ? menuItemIndex3.isBefore(menuItemIndex) : menuItemIndex.isBefore(menuItemIndex3);
        return !bl && this.isMoveGapBeforeViewport(menuItemIndex2, menuItemIndex3, menuItemIndex);
    }

    private boolean isMoveGapAfterViewport(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, MenuItemIndex menuItemIndex3) {
        boolean bl = menuItemIndex2.isBefore(menuItemIndex);
        if (bl == this.layoutData.alignTop && !menuItemIndex2.equals(menuItemIndex)) {
            return this.layoutData.alignTop ? !menuItemIndex.isBefore(menuItemIndex3) : !menuItemIndex3.isBefore(menuItemIndex);
        }
        return this.layoutData.alignTop ? menuItemIndex3.isBefore(menuItemIndex) : menuItemIndex.isBefore(menuItemIndex3);
    }

    private boolean isMoveGapBeforeViewport(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, MenuItemIndex menuItemIndex3) {
        boolean bl = menuItemIndex2.isBefore(menuItemIndex);
        if (bl == this.layoutData.alignTop && !menuItemIndex2.equals(menuItemIndex)) {
            return this.layoutData.alignTop ? !menuItemIndex3.isBefore(menuItemIndex) : !menuItemIndex.isBefore(menuItemIndex3);
        }
        return this.layoutData.alignTop ? menuItemIndex.isBefore(menuItemIndex3) : menuItemIndex3.isBefore(menuItemIndex);
    }

    public void destroyRemovedItems() {
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            if (!menuItemMetaData.remove || menuItemMetaData.heightBefore != menuItemMetaData.heightAfter) continue;
            LC.log(-2137614336, "MenuUpdateManager#destroyRemovedItems: destroy item: %2 (was removed: %1)", menuItemMetaData.remove, (Object)menuItemMetaData.index);
            this.destroyItem(iterator, menuItemMetaData);
        }
    }

    public void destroyAllItems() {
        LC.log(-2137614336, "MenuUpdateManager#destroyAllItems for %1", (Object)this.menu);
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            LC.log(14808325, "MenuUpdateManager#destroyAllItems: destroy item: %2 (was removed: %1)", menuItemMetaData.remove, (Object)menuItemMetaData.index, (Object)null);
            this.destroyItem(iterator, menuItemMetaData);
        }
    }

    public boolean updateItemsForFastUpdate(MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta) {
        if (this.layoutData.layoutItems.isEmpty()) {
            LC.log(-2137614336, "MenuUpdateManager#updateItemsForFastUpdate: layoutItems are empty, no refresh required");
            return true;
        }
        MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher = menuUpdateRequest.updateItems;
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.layoutData.layoutItems.get(0);
        MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)this.layoutData.layoutItems.get(this.layoutData.layoutItems.size() - 1);
        if (!menuUpdateRequest$IMenuItemMatcher.mayMatchInRange(menuItemMetaData.index, menuItemMetaData2.index)) {
            LC.log(-2137614336, "MenuUpdateManager#updateItemsForFastUpdate: no layoutItem (from %1 to %2) is affected by matcher: %3", (Object)menuItemMetaData, (Object)menuItemMetaData2, (Object)menuUpdateRequest$IMenuItemMatcher);
            return true;
        }
        ListIterator listIterator = this.layoutData.layoutItems.listIterator();
        while (listIterator.hasNext()) {
            MenuItemMetaData menuItemMetaData3 = (MenuItemMetaData)listIterator.next();
            if (menuItemMetaData3.remove) {
                menuUpdateDelta.store(menuItemMetaData3, false);
                continue;
            }
            if (!menuUpdateRequest$IMenuItemMatcher.matches(menuItemMetaData3.index)) continue;
            int n = menuItemMetaData3.heightAfter;
            this.updateItemItself(menuItemMetaData3, false, listIterator, menuUpdateDelta);
            MenuItemMetaData menuItemMetaData4 = menuUpdateDelta.latestItem;
            if (menuItemMetaData4 == null) {
                LC.log(-2137614336, "MenuUpdateManager#updateItemsForFastUpdate: item %1 was removed, so recalculate viewport", (Object)menuItemMetaData3);
                return false;
            }
            int n2 = menuItemMetaData4.heightAfter;
            if (n2 == n) continue;
            LC.log(-2137614336, "MenuUpdateManager#updateItemsForFastUpdate: height of item %1 has changed from %2 to %3, so recalculate viewport", (Object)menuItemMetaData3, (long)n, (long)n2);
            return false;
        }
        LC.log(-2137614336, "MenuUpdateManager#updateItemsForFastUpdate: layoutItems between %1 and %2 updated without height change for matcher: %3", (Object)menuItemMetaData, (Object)menuItemMetaData2, (Object)menuUpdateRequest$IMenuItemMatcher);
        return true;
    }

    public int setupInsertedItems(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, boolean bl, MenuUpdateDelta menuUpdateDelta) {
        boolean bl2;
        LC.log(-2137614336, "MenuUpdateManager#setupInsertedItems: setup inserted items from %1 to %2", (Object)menuItemIndex, (Object)menuItemIndex2);
        int n = this.layoutData.findAnimationItemListIndex(menuItemIndex);
        boolean bl3 = bl2 = n >= 0;
        if (!bl2) {
            n = -n - 1;
        }
        ListIterator listIterator = this.layoutData.layoutItems.listIterator(n);
        boolean bl4 = !menuItemIndex2.isBefore(menuItemIndex);
        int n2 = 0;
        Iterator iterator = this.menu.iterator(menuItemIndex, menuItemIndex2, true);
        while (iterator.hasNext()) {
            MenuItemIndex menuItemIndex3 = (MenuItemIndex)iterator.next();
            do {
                this.updateNextItemUntilIndex(menuItemIndex3, bl, listIterator, bl4, MenuUpdateRequest.UPDATE_ALL, menuUpdateDelta);
            } while (!menuUpdateDelta.requestedItemReached);
            if (menuUpdateDelta.latestItem == null) continue;
            n2 += this.menu.getLayout().getItemsGap();
            n2 += menuUpdateDelta.latestItem.heightAfter;
        }
        return n2;
    }

    private void destroyItem(Iterator iterator, MenuItemMetaData menuItemMetaData) {
        iterator.remove();
        this.destroyItem(menuItemMetaData);
    }

    private void destroyItem(MenuItemMetaData menuItemMetaData) {
        this.menu.destroyMenuItem(menuItemMetaData);
        this.layoutData.removeItemFromCache(menuItemMetaData);
    }

    public MenuLayoutData getLayoutData() {
        return this.layoutData;
    }

    public MenuController getMenu() {
        return this.menu;
    }
}

