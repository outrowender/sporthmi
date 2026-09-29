/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuIndexIteratorWithLength;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuScrollAnimationFunction;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$IMenuItemMatcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MenuAnimationManager
implements AnimationListener,
ATIPEventListener,
IWidgetLogChannel,
WidgetConstants {
    public static final int UNFOCUSABLE_CURSOR_GLASSPLATE_INSETS;
    private static final int CURSOR_BOUNCE_NO_MOVE_DURATION;
    private static final int ONE_ANIMATION_TARGET;
    public static final int ANIMATION_TYPE;
    public static final int DEFAULT_SCROLL_ANIMATION_INTERVAL;
    static final int SCROLL_ANIMATION_INTERVAL;
    private final MenuController menu;
    private AbstractAnimation animation;
    private AbstractAnimation cursorBounceAnimation;
    private TimerEvent cursorBounceNoMoveTimerEvent;
    private Job cursorBounceNoMoveTimerJob;
    private AbstractAnimation moveGapAnimation;
    private AbstractAnimation scrollAnimation;
    MenuScrollAnimationFunction scrollAnimationFunction = new MenuScrollAnimationFunction();
    private MenuLayoutData layoutData = new MenuLayoutData();
    private int lastSlowScrollViewportOffset;
    private int shortAnimationScrollDistance;
    private int cursorBounceTargetOffset;
    public AnimationListener animationCallback;

    public MenuAnimationManager(MenuController menuController) {
        this.menu = menuController;
    }

    public void disconnect() {
        this.stopShortAnimation();
        this.animation = null;
        this.stopMoveGapAnimation();
        this.moveGapAnimation = null;
        this.stopCursorBounceAnimation();
        this.cursorBounceAnimation = null;
        this.stopCursorBounceTimer();
        this.cursorBounceNoMoveTimerEvent = null;
        this.cursorBounceNoMoveTimerJob = null;
        this.stopScrollAnimation();
        this.scrollAnimation = null;
        this.resetSlowScrollMode();
        new MenuUpdateManager(this.menu, this.layoutData).destroyAllItems();
        this.layoutData.reset();
        this.shortAnimationScrollDistance = 0;
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(78);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private AbstractAnimation getMoveGapAnimation() {
        if (this.moveGapAnimation == null) {
            this.moveGapAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(79);
            this.moveGapAnimation.addListener(this);
        }
        return this.moveGapAnimation;
    }

    private AbstractAnimation getCursorBounceAnimation() {
        if (this.cursorBounceAnimation == null) {
            this.cursorBounceAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(106);
            this.cursorBounceAnimation.addListener(this);
        }
        return this.cursorBounceAnimation;
    }

    private AbstractAnimation getScrollAnimation() {
        if (this.scrollAnimation == null) {
            this.scrollAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(1);
            this.scrollAnimation.addListener(this);
        }
        return this.scrollAnimation;
    }

    public MenuScrollAnimationFunction getScrollAnimationFunction() {
        return this.scrollAnimationFunction;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.menu.getTerminal().getIAnimationController();
    }

    public void focus(MenuItemIndex menuItemIndex) {
        this.focus(menuItemIndex, FocusAdvice.KEEP_POSITION, false);
    }

    public void focus(MenuItemIndex menuItemIndex, FocusAdvice focusAdvice, boolean bl) {
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(menuItemIndex, focusAdvice, MenuUpdateRequest.UPDATE_NONE);
        this.focus(menuUpdateRequest, bl, bl, this.getCurrentTime());
    }

    public void focus(MenuUpdateRequest menuUpdateRequest, boolean bl, boolean bl2) {
        this.focus(menuUpdateRequest, bl, bl2, this.getCurrentTime());
    }

    public void focus(MenuUpdateRequest menuUpdateRequest, boolean bl, boolean bl2, long l) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#focus: +++ Focus menu item: %2 (immediately: %1, complete request: %3)", (Object)bl, (Object)menuUpdateRequest.focusIndex, (Object)menuUpdateRequest);
        if (!this.focusChangeRequiresAction(menuUpdateRequest.focusIndex, menuUpdateRequest.focusAdvice)) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#focus: --- old and new focus are equal.");
            return;
        }
        if (!Util.equals(menuUpdateRequest.focusIndex, this.menu.getFocusedIndex())) {
            this.menu.prepareForFocusChange(bl);
        }
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        MenuViewport menuViewport = this.menu.getViewport();
        boolean bl3 = !bl && this.shouldAnimateFocusChange(menuUpdateRequest.focusIndex);
        boolean bl4 = !bl && this.shouldAnimateFocusChangeScrolling(menuUpdateRequest.focusIndex);
        this.adjustAnimationStartValuesForRestart(bl3, l);
        boolean bl5 = this.isScrollingControlledBySeparateAnimation();
        MenuItemMetaData menuItemMetaData = this.layoutData.findAnimationItem(menuItemIndex);
        this.setupItemsAnimated(menuUpdateRequest, menuViewport);
        boolean bl6 = !bl && (bl3 || this.isShortAnimationRunning());
        this.adjustCursor(menuItemMetaData, this.layoutData.findAnimationItem(this.menu.getFocusedIndex()), bl6);
        boolean bl7 = !bl && bl5;
        this.handleAnimationsAfterUpdate(bl3, bl4 || bl7, bl2, this.isSlowViewportScrollingRunning(), true);
        menuLogCh.log(-2137614336, "MenuAnimationManager#focus: --- Focus finished for item: %1 (%2)", (Object)menuUpdateRequest.focusIndex, (Object)this.menu);
    }

    boolean focusChangeRequiresAction(MenuItemIndex menuItemIndex, FocusAdvice focusAdvice) {
        MenuItemIndex menuItemIndex2 = this.menu.getFocusedIndex();
        if (!Util.equals(menuItemIndex2, menuItemIndex)) {
            return true;
        }
        if (menuItemIndex == null) {
            return false;
        }
        if (focusAdvice == FocusAdvice.KEEP_POSITION) {
            boolean bl = this.menu.getViewport().contains(menuItemIndex);
            return !bl;
        }
        if (focusAdvice == FocusAdvice.VIEWPORT_FIRST_POSITION) {
            boolean bl = menuItemIndex.equals(this.menu.getViewport().start);
            return !bl || !this.layoutData.alignTop;
        }
        if (focusAdvice == FocusAdvice.VIEWPORT_LAST_POSITION) {
            boolean bl = menuItemIndex.equals(this.menu.getViewport().end);
            return !bl;
        }
        return true;
    }

    public void heightChanged(MenuItemIndex menuItemIndex, FocusAdvice focusAdvice, boolean bl) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#heightChanged: +++ height changed of item: %1, immediately: %2, (%3)", (Object)menuItemIndex, (Object)bl, (Object)this.menu);
        MenuItemMetaData menuItemMetaData = this.layoutData.findAnimationItem(menuItemIndex);
        if (menuItemMetaData == null || menuItemMetaData.remove) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#heightChanged: --- item %1 is not visible or removed. item: %2", (Object)menuItemIndex, (Object)menuItemMetaData);
            return;
        }
        MenuItemIndex menuItemIndex2 = this.menu.getFocusedIndex();
        boolean bl2 = this.menu.isExpanded(menuItemIndex);
        int n = this.menu.getMenuItemHeight(menuItemMetaData, bl2);
        int n2 = this.menu.getInfolinePreferredHeight();
        if (menuItemMetaData.heightAfter == n && this.layoutData.infolineHeightAfter == n2) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#heightChanged: --- height has not changed: %1, infolineHeight: %2", (long)n, (long)n2);
            return;
        }
        menuLogCh.log(-2137614336, "MenuAnimationManager#heightChanged: height changed for item %1 from %2 to %3", (Object)menuItemMetaData, (long)menuItemMetaData.heightAfter, (long)n);
        this.adjustAnimationStartValuesForRestart(!bl, this.getCurrentTime());
        boolean bl3 = this.isScrollingControlledBySeparateAnimation();
        this.setupItemsForHeightChange(menuItemMetaData, n, focusAdvice, bl);
        this.layoutData.infolineHeightAfter = n2;
        MenuItemMetaData menuItemMetaData2 = this.layoutData.findAnimationItem(menuItemIndex2);
        this.adjustCursor(menuItemMetaData2, menuItemMetaData2, true);
        this.handleAnimationsAfterUpdate(!bl, !bl && bl3);
        menuLogCh.log(-2137614336, "MenuAnimationManager#heightChanged: --- height changed finished for item: %1", (Object)menuItemIndex);
    }

    private void handleAnimationsAfterUpdate(boolean bl, boolean bl2) {
        this.handleAnimationsAfterUpdate(bl, bl2, true, this.isSlowViewportScrollingRunning(), false);
    }

    private void handleAnimationsAfterUpdate(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (this.layoutData.getScrollDistance() != 0) {
            this.scrollAnimationFunction.startAnimation(this.layoutData.viewportOffsetBefore, this.layoutData.viewportOffsetAfter, bl4, bl5);
        }
        if (!bl2 && !bl && bl3) {
            this.stopScrollAnimation();
        } else {
            this.startAnimation(bl, bl2);
        }
        if (!this.isShortAnimationRunning()) {
            this.resetShortAnimationStartValues();
        }
        if (!this.isAnimationRunning()) {
            if (bl3) {
                this.destroyUnusedItems();
            }
            this.updateMenuImmediately();
        }
    }

    void adjustCursor(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2, boolean bl) {
        if (menuItemMetaData2 != null) {
            this.adjustCursorLayoutAfter(menuItemMetaData2);
            if (bl && menuItemMetaData != null) {
                this.layoutData.cursorOffsetBefore -= this.calculateHeightDistance(menuItemMetaData, menuItemMetaData2, false, true);
                int n = this.menu.getMenuItemMargin(menuItemMetaData, true);
                int n2 = this.menu.getMenuItemMargin(menuItemMetaData2, true);
                this.layoutData.cursorOffsetBefore += n - n2;
                this.layoutData.cursorHeightBefore -= n + this.menu.getMenuItemMargin(menuItemMetaData, false);
                this.layoutData.cursorHeightBefore += n2 + this.menu.getMenuItemMargin(menuItemMetaData2, false);
                int n3 = this.menu.getMenuItemFilledInsets(menuItemMetaData, true);
                int n4 = this.menu.getMenuItemFilledInsets(menuItemMetaData2, true);
                this.layoutData.cursorOffsetBefore -= n3 - n4;
                this.layoutData.cursorHeightBefore += n3 + this.menu.getMenuItemFilledInsets(menuItemMetaData, false);
                this.layoutData.cursorHeightBefore -= n4 + this.menu.getMenuItemFilledInsets(menuItemMetaData2, false);
            } else {
                this.layoutData.cursorOffsetBefore = this.layoutData.cursorOffsetAfter;
                this.layoutData.cursorHeightBefore = this.layoutData.cursorHeightAfter;
                this.layoutData.cursorBorderVisibleBefore = this.layoutData.cursorBorderVisibleAfter;
            }
        }
    }

    public void adjustCursorLayoutAfter(MenuItemMetaData menuItemMetaData) {
        int n = this.menu.getMenuItemNoCursorArea(menuItemMetaData, true);
        int n2 = this.menu.getMenuItemNoCursorArea(menuItemMetaData, false);
        int n3 = menuItemMetaData.heightAfter - n - n2;
        int n4 = n;
        if (!this.menu.isMenuItemFocusable(menuItemMetaData)) {
            int n5 = this.getUnfocusableLineHeightUntilVisibleEdge(menuItemMetaData.index, false);
            int n6 = this.getUnfocusableLineHeightUntilVisibleEdge(menuItemMetaData.index, true);
            n3 += n5 + n6;
            n4 = -n5;
            this.layoutData.cursorBorderVisibleAfter = 0.0f;
        } else {
            this.layoutData.cursorBorderVisibleAfter = 1.0f;
        }
        this.setCursorHeightAfter(n3);
        this.setCursorOffsetAfter(n4);
        menuLogCh.log(-2137614336, "MenuAnimationManager#adjustCursor: change cursor height from %1 to %2, cursor offset: %3", (long)this.layoutData.cursorHeightAfter, (long)this.layoutData.cursorHeightAfter, (long)this.layoutData.cursorOffsetAfter);
    }

    public int getFocusableHeightForItem(MenuItemIndex menuItemIndex) {
        int n = this.menu.getMenuItemHeight(menuItemIndex, this.menu.isExpanded(menuItemIndex));
        if (this.menu.isMenuItemFocusable(menuItemIndex)) {
            return n;
        }
        n += this.getUnfocusableLineHeightUntilVisibleEdge(menuItemIndex, true);
        return n += this.getUnfocusableLineHeightUntilVisibleEdge(menuItemIndex, false);
    }

    private int getUnfocusableLineHeightUntilVisibleEdge(MenuItemIndex menuItemIndex, boolean bl) {
        MenuItemIndex menuItemIndex2;
        MenuViewport menuViewport = this.menu.getViewport();
        MenuItemIndex menuItemIndex3 = menuItemIndex;
        int n = 0;
        Iterator iterator = this.menu.iterator(menuItemIndex, bl, false);
        while (iterator.hasNext() && !this.menu.isMenuItemFocusable(menuItemIndex2 = (MenuItemIndex)iterator.next())) {
            if (menuViewport.contains(menuItemIndex2)) {
                n += this.menu.getLayout().getItemsGap() + this.menu.getMenuItemHeight(menuItemIndex2, this.menu.isExpanded(menuItemIndex2));
                menuItemIndex3 = menuItemIndex2;
                continue;
            }
            n += this.calculateUnfocusableLineHeightForPartialItem(menuViewport, menuItemIndex, menuItemIndex3, n, bl);
            break;
        }
        int n2 = this.menu.getMenuItemMargin(menuItemIndex3, !bl);
        int n3 = this.menu.getMenuItemMargin(menuItemIndex, !bl);
        return n += n3 - n2;
    }

    private int calculateUnfocusableLineHeightForPartialItem(MenuViewport menuViewport, MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, int n, boolean bl) {
        if (menuViewport.isEmpty()) {
            menuLogCh.log(-1601830656, "MenuAnimationManager#calculateUnfocusableLineHeightForPartialItem: viewport is empty. Focused item: %1", (Object)menuItemIndex);
            return 0;
        }
        if (this.layoutData.alignTop != bl) {
            int n2 = this.menu.getLayout().getContentInsetsVert() + this.menu.getMenuItemGlassplateInsets(menuItemIndex2, !bl) - this.menu.getMenuItemFilledInsets(menuItemIndex2, !bl);
            return Math.max(0, n2 - 5);
        }
        MenuItemIndex menuItemIndex3 = bl ? menuViewport.start : menuViewport.end;
        MenuItemMetaData menuItemMetaData = this.layoutData.findAnimationItem(menuItemIndex);
        MenuItemMetaData menuItemMetaData2 = this.layoutData.findAnimationItem(menuItemIndex3);
        if (menuItemMetaData == null || menuItemMetaData2 == null) {
            menuLogCh.log(-1601830656, "MenuAnimationManager#calculateUnfocusableLineHeightForPartialItem: item %1 or %2 not found in layoutItems: %3", (Object)menuItemIndex, (Object)menuItemIndex3, (Object)this.layoutData.layoutItems);
            return 0;
        }
        int n3 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData2, bl);
        int n4 = n3 + Math.abs(this.calculateHeightDistance(menuItemMetaData, menuItemMetaData2, true, bl));
        int n5 = n4 + menuItemMetaData.heightAfter;
        int n6 = this.menu.getLayout().getContentAreaHeight();
        int n7 = n6 - n5 - n;
        return n7 - 5 + this.menu.getLayout().getContentInsetsVert() - this.menu.getMenuItemFilledInsets(menuItemIndex2, !bl);
    }

    public void remove(MenuItemIndex menuItemIndex, int n, MenuUpdateDelta menuUpdateDelta) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#remove: +++ Removed rows at: %1, length: %3 (%2)", (Object)menuItemIndex, (Object)this.menu, (long)n);
        this.setupItemsForRemove(menuItemIndex, n);
        this.adjustIndicesForRemove(menuItemIndex, n, menuUpdateDelta);
        menuLogCh.log(-2137614336, "MenuAnimationManager#remove: --- Remove finished for item: %1, length: %2", (Object)menuItemIndex, (long)n);
    }

    Iterator iteratorRemovedItems(MenuItemIndex menuItemIndex, int n) {
        return new MenuIndexIteratorWithLength(menuItemIndex, n);
    }

    public void add(MenuItemIndex menuItemIndex, int n, MenuUpdateDelta menuUpdateDelta) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#add: +++ Row added at index: %1, length: %3 (%2)", (Object)menuItemIndex, (Object)this.menu, (long)n);
        this.adjustIndicesForAdd(menuItemIndex, n, menuUpdateDelta);
        menuLogCh.log(-2137614336, "MenuAnimationManager#add: --- Add finished for item: %1", (Object)menuItemIndex);
    }

    public int openFolder(MenuItemIndex menuItemIndex, int n, MenuUpdateDelta menuUpdateDelta) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#openFolder: +++ openFolder at parent item: %1, childrenCount: %3 (%2)", (Object)menuItemIndex, (Object)this.menu, (long)n);
        MenuViewport menuViewport = menuUpdateDelta.getOldViewport();
        MenuItemIndex menuItemIndex2 = new MenuItemIndex(menuItemIndex.widget, menuItemIndex.widgetPart + 1);
        if (!menuViewport.contains(menuItemIndex)) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#openFolder: parent item %1 is outside of the viewport: %2 --> normal add", (Object)menuItemIndex, (Object)menuViewport);
            this.add(menuItemIndex2, n, menuUpdateDelta);
            return 0;
        }
        this.adjustIndicesForAdd(menuItemIndex2, n, menuUpdateDelta);
        int n2 = this.setupItemsForOpenFolder(menuItemIndex2, n, menuUpdateDelta);
        menuLogCh.log(-2137614336, "MenuAnimationManager#openFolder: --- openFolder finished for item: %1, new items height: %2", (Object)menuItemIndex, (long)n2);
        return n2;
    }

    public void refreshItemsForFastUpdate(MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher) {
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(this.getFocusedIndexWithStableRowId(), this.menu.createFocusAdviceForCursorPosition(), menuUpdateRequest$IMenuItemMatcher);
        MenuUpdateDelta menuUpdateDelta = this.createDelta();
        this.adjustAnimationStartValuesForRestart(false, this.getCurrentTime());
        this.refreshItemsForFastUpdate(menuUpdateRequest, menuUpdateDelta, true, false);
    }

    public void refresh(MenuUpdateRequest$IMenuItemMatcher menuUpdateRequest$IMenuItemMatcher) {
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(this.getFocusedIndexWithStableRowId(), this.menu.createFocusAdviceForCursorPosition(), menuUpdateRequest$IMenuItemMatcher);
        MenuUpdateDelta menuUpdateDelta = this.createDelta();
        this.adjustAnimationStartValuesForRestart(false, this.getCurrentTime());
        this.refresh(menuUpdateRequest, menuUpdateDelta, true, false);
    }

    private MenuUpdateDelta createDelta() {
        MenuViewport menuViewport = this.menu.getViewport();
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        MenuItemMetaData menuItemMetaData = this.layoutData.findAnimationItem(menuItemIndex);
        MenuItemIndex menuItemIndex2 = this.menu.getSelectedIndex();
        return new MenuUpdateDelta(menuViewport, menuItemIndex, menuItemMetaData, menuItemIndex2);
    }

    public void refresh(MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta, boolean bl, boolean bl2) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#refresh: +++ Refresh items for request: %1, immediately: %2 (%3)", (Object)menuUpdateRequest, (Object)bl, (Object)this.menu);
        if (menuUpdateDelta.getOldViewport().isEmpty()) {
            MenuItemIndex menuItemIndex = this.menu.getFirstMenuItem();
            if (menuItemIndex != null) {
                menuLogCh.log(-2137614336, "MenuAnimationManager#refresh: menu was empty, select first item: %1", (Object)menuItemIndex);
                this.focus(menuItemIndex);
            } else {
                menuLogCh.log(-2137614336, "MenuAnimationManager#refresh: menu was empty and stays empty");
            }
            return;
        }
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        MenuItemMetaData menuItemMetaData = this.layoutData.findAnimationItem(menuItemIndex);
        this.setupItemsAnimated(menuUpdateRequest, menuUpdateDelta.getOldViewport(), menuUpdateDelta);
        MenuItemMetaData menuItemMetaData2 = this.layoutData.findAnimationItem(this.menu.getFocusedIndex());
        this.adjustCursor(menuItemMetaData, menuItemMetaData2, this.isShortAnimationRunning());
        this.handleAnimationsAfterUpdate(!bl && this.shouldStartShortAnimation(), !bl && bl2);
        menuLogCh.log(-2137614336, "MenuAnimationManager#refresh: --- Refresh finished");
    }

    private boolean shouldStartShortAnimation() {
        if (this.layoutData.cursorOffsetBefore != this.layoutData.cursorOffsetAfter) {
            return true;
        }
        if (this.layoutData.cursorHeightBefore != this.layoutData.cursorHeightAfter) {
            return true;
        }
        if (this.layoutData.cursorBorderVisibleBefore != this.layoutData.cursorBorderVisibleAfter) {
            return true;
        }
        if (this.shortAnimationScrollDistance != 0) {
            return true;
        }
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            if (menuItemMetaData.heightBefore == menuItemMetaData.heightAfter) continue;
            return true;
        }
        return false;
    }

    public void refreshItemsForFastUpdate(MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta, boolean bl, boolean bl2) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#refreshItemsForFastUpdate: +++ Refresh items heights for request: %1, immediately: %2 (%3)", (Object)menuUpdateRequest, (Object)bl, (Object)this.menu);
        boolean bl3 = this.tryFastUpdate(menuUpdateRequest, menuUpdateDelta);
        if (bl3) {
            MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
            if (menuItemIndex != null && menuUpdateRequest.updateItems.matches(menuItemIndex)) {
                this.menu.setFocusedIndex(menuItemIndex);
            }
            MenuItemMetaData menuItemMetaData = this.layoutData.findAnimationItem(menuItemIndex);
            this.adjustCursor(menuItemMetaData, menuItemMetaData, this.isShortAnimationRunning());
            this.handleAnimationsAfterUpdate(!bl && this.shouldStartShortAnimation(), !bl && bl2);
        } else {
            this.refresh(menuUpdateRequest, menuUpdateDelta, bl, bl2);
        }
        menuLogCh.log(-2137614336, "MenuAnimationManager#refreshItemsForFastUpdate: --- Refresh Items Heights finished");
    }

    private boolean tryFastUpdate(MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta) {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        MenuItemIndex menuItemIndex2 = this.getFocusedIndexWithStableRowId();
        if (!Util.equals(menuItemIndex2, menuItemIndex)) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#tryFastUpdate: focus item must be changed from %1 to %2, so recalculate viewport", (Object)menuItemIndex, (Object)menuItemIndex2);
            return false;
        }
        boolean bl = new MenuUpdateManager(this.menu, this.layoutData).updateItemsForFastUpdate(menuUpdateRequest, menuUpdateDelta);
        return bl;
    }

    public void refreshAnimations(boolean bl) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#refreshAnimations: Refresh animations only. ScrollingWasRunning: %1 (%2)", bl, (Object)this.menu);
        this.handleAnimationsAfterUpdate(this.shouldStartShortAnimation(), bl);
    }

    public void subclicksChanged() {
        boolean bl = this.menu.getLayout().isFocusCursorVisible();
        menuLogCh.log(-2137614336, "MenuAnimationManager#subclicksChanged. Cursor visible: %1", bl);
        if (bl) {
            this.adjustAnimationStartValuesForRestart(true, this.getCurrentTime());
            boolean bl2 = this.isScrollingControlledBySeparateAnimation();
            this.handleAnimationsAfterUpdate(true, bl2);
        }
    }

    boolean shouldAnimateRemove(MenuItemIndex menuItemIndex, int n) {
        if (!this.menu.shouldRenderRecursive()) {
            return false;
        }
        Iterator iterator = this.iteratorRemovedItems(menuItemIndex, n);
        while (iterator.hasNext()) {
            MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
            if (this.layoutData.findAnimationItem(menuItemIndex2) == null) continue;
            return true;
        }
        return false;
    }

    boolean shouldAnimateFocusChange(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null) {
            return false;
        }
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.isEmpty()) {
            return false;
        }
        if (!this.menu.hasFocusedItem()) {
            return false;
        }
        if (menuItemIndex.equals(this.menu.getFocusedIndex())) {
            return false;
        }
        if (!this.menu.getLayout().isFocusCursorVisible()) {
            return false;
        }
        return this.menu.shouldRenderRecursive();
    }

    boolean shouldAnimateFocusChangeScrolling(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null) {
            return false;
        }
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.isEmpty()) {
            return false;
        }
        if (menuViewport.contains(menuItemIndex)) {
            return false;
        }
        return this.menu.shouldRenderRecursive();
    }

    void adjustItemsIndicesForRemove(MenuItemIndex menuItemIndex, int n) {
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            menuItemMetaData.index = menuItemMetaData.index.adjustForRemove(menuItemIndex, n);
        }
    }

    void adjustItemsIndicesForAdd(MenuItemIndex menuItemIndex, int n) {
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            menuItemMetaData.index = menuItemMetaData.index.adjustForAdd(menuItemIndex, n);
        }
    }

    public void adjustAnimationStartValuesForRestart(boolean bl, long l) {
        if (bl) {
            this.adjustShortAnimationStartValuesForRestart();
        }
        this.adjustScrollAnimationStartValuesForRestart(l);
    }

    private void adjustShortAnimationStartValuesForRestart() {
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            if (menuItemMetaData.heightBefore != menuItemMetaData.heightAfter) {
                menuItemMetaData.heightBefore = this.round(this.getMenuItemHeight(menuItemMetaData));
            }
            if (menuItemMetaData.opacityBefore == menuItemMetaData.getOpacityAfter()) continue;
            menuItemMetaData.opacityBefore = this.getMenuItemOpacityRaw(menuItemMetaData);
        }
        this.layoutData.cursorOffsetBefore = this.round(this.getFocusCursorOffset());
        this.layoutData.cursorHeightBefore = this.getFocusCursorHeight();
        this.layoutData.cursorBorderVisibleBefore = this.getFocusCursorBorderVisible();
        this.layoutData.infolineHeightBefore = this.getInfolineHeight();
        this.menu.adjustAnimationStartValuesForRestart();
    }

    private void adjustScrollAnimationStartValuesForRestart(long l) {
        int n;
        int n2 = this.layoutData.getScrollDistance();
        if (this.isScrollingControlledByShortAnimation() && n2 != this.shortAnimationScrollDistance) {
            menuLogCh.log(-1601830656, "MenuAnimationManager#adjustScrollAnimationStartValuesForRestart: inconsistent shortAnimationScrollDistance (%1) and actual scroll distance (%2)", (long)this.shortAnimationScrollDistance, (long)n2);
            this.shortAnimationScrollDistance = 0;
        }
        boolean bl = this.isScrollingControlledByShortAnimation();
        if (this.isScrollAnimationRunning()) {
            this.scrollAnimationFunction.updateProgress(l);
        }
        if (this.layoutData.viewportOffsetBefore != (n = this.getViewportOffset())) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#adjustScrollAnimationStartValuesForRestart: change viewportOffsetBefore: %1 -> %2", (long)this.layoutData.viewportOffsetBefore, (long)n);
            this.layoutData.viewportOffsetBefore = n;
        }
        if (bl) {
            int n3 = this.layoutData.getScrollDistance();
            menuLogCh.log(-2137614336, "MenuAnimationManager#adjustScrollAnimationStartValuesForRestart: change shortAnimationScrollDistance: %1 -> %2", (long)this.shortAnimationScrollDistance, (long)n3);
            this.shortAnimationScrollDistance = n3;
        }
    }

    boolean setupItemsForRemove(MenuItemIndex menuItemIndex, int n) {
        boolean bl = false;
        Iterator iterator = this.iteratorRemovedItems(menuItemIndex, n);
        while (iterator.hasNext()) {
            MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
            MenuItemMetaData menuItemMetaData = this.layoutData.findAnimationItem(menuItemIndex2);
            if (menuItemMetaData == null) continue;
            this.markItemForRemove(menuItemMetaData);
            bl = true;
        }
        return bl;
    }

    private void markItemForRemove(MenuItemMetaData menuItemMetaData) {
        menuItemMetaData.heightAfter = -this.menu.getLayout().getItemsGap();
        menuItemMetaData.remove = true;
    }

    void adjustIndicesForRemove(MenuItemIndex menuItemIndex, int n, MenuUpdateDelta menuUpdateDelta) {
        Object object;
        MenuItemIndex menuItemIndex2;
        this.adjustItemsIndicesForRemove(menuItemIndex, n);
        MenuItemIndex menuItemIndex3 = menuUpdateDelta.getOldFocusedIndex();
        if (menuItemIndex3 != null) {
            menuItemIndex2 = menuItemIndex3.adjustForRemove(menuItemIndex, n);
            menuUpdateDelta.setOldFocusedIndex(menuItemIndex2);
            menuLogCh.log(-2137614336, "MenuAnimationManager#adjustIndicesForRemove: adjust focused index: %1 -> %2", (Object)menuItemIndex3, (Object)menuItemIndex2);
        }
        if ((menuItemIndex2 = menuUpdateDelta.getOldSelectedIndex()) != null) {
            object = menuItemIndex2.adjustForRemove(menuItemIndex, n);
            menuUpdateDelta.setOldSelectedIndex((MenuItemIndex)object);
            menuLogCh.log(-2137614336, "MenuAnimationManager#adjustIndicesForRemove: adjust selected index: %1 -> %2", (Object)menuItemIndex2, object);
        }
        object = menuUpdateDelta.getOldViewport();
        if (this.isItemRemoved(((MenuViewport)object).end, menuItemIndex, n)) {
            menuUpdateDelta.oldViewportEndItemRemoved = true;
        }
        menuUpdateDelta.setOldViewport(((MenuViewport)object).adjustForRemove(menuItemIndex, n));
    }

    private boolean isItemRemoved(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, int n) {
        if (menuItemIndex == null) {
            return false;
        }
        if (menuItemIndex.widget != menuItemIndex2.widget) {
            return false;
        }
        return menuItemIndex.widgetPart >= menuItemIndex2.widgetPart && menuItemIndex.widgetPart <= menuItemIndex2.widgetPart + n;
    }

    int setupItemsForOpenFolder(MenuItemIndex menuItemIndex, int n, MenuUpdateDelta menuUpdateDelta) {
        MenuItemIndex menuItemIndex2 = new MenuItemIndex(menuItemIndex.widget, menuItemIndex.widgetPart + n - 1);
        int n2 = new MenuUpdateManager(this.menu, this.layoutData).setupInsertedItems(menuItemIndex, menuItemIndex2, true, menuUpdateDelta);
        return n2;
    }

    private void adjustIndicesForAdd(MenuItemIndex menuItemIndex, int n, MenuUpdateDelta menuUpdateDelta) {
        Object object;
        MenuItemIndex menuItemIndex2;
        MenuItemIndex menuItemIndex3 = menuUpdateDelta.getOldFocusedIndex();
        if (menuItemIndex3 != null) {
            menuItemIndex2 = menuItemIndex3.adjustForAdd(menuItemIndex, n);
            menuUpdateDelta.setOldFocusedIndex(menuItemIndex2);
            menuLogCh.log(-2137614336, "MenuAnimationManager#adjustIndicesForAdd: adjust focused index: %1 -> %2", (Object)menuItemIndex3, (Object)menuItemIndex2);
        }
        if ((menuItemIndex2 = menuUpdateDelta.getOldSelectedIndex()) != null) {
            object = menuItemIndex2.adjustForAdd(menuItemIndex, n);
            menuUpdateDelta.setOldSelectedIndex((MenuItemIndex)object);
            menuLogCh.log(-2137614336, "MenuAnimationManager#adjustIndicesForAdd: adjust selected index: %1 -> %2", (Object)menuItemIndex2, object);
        }
        this.adjustItemsIndicesForAdd(menuItemIndex, n);
        object = menuUpdateDelta.getOldViewport().adjustForAdd(menuItemIndex, n);
        menuUpdateDelta.setOldViewport((MenuViewport)object);
    }

    void setupItemsForHeightChange(MenuItemMetaData menuItemMetaData, int n, FocusAdvice focusAdvice, boolean bl) {
        if (this.shouldUpdateViewportOnHeightChange(menuItemMetaData)) {
            menuItemMetaData.heightAfter = n;
            MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(this.getFocusedIndexWithStableRowId(), focusAdvice, MenuUpdateRequest.UPDATE_NONE);
            this.setupItemsAnimated(menuUpdateRequest, this.menu.getViewport());
        } else {
            menuItemMetaData.heightAfter = n;
            int n2 = this.getCurrentGlassplateInsets();
            MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
            MenuItemMetaData menuItemMetaData2 = this.layoutData.findAnimationItem(menuItemIndex);
            MenuItemIndex menuItemIndex2 = this.menu.getSelectedIndex();
            this.adjustViewportOffsetForItemsChange(n2, new MenuUpdateDelta(this.menu.getViewport(), menuItemIndex, menuItemMetaData2, menuItemIndex2));
        }
        if (bl) {
            menuItemMetaData.heightBefore = n;
        }
    }

    private boolean shouldUpdateViewportOnHeightChange(MenuItemMetaData menuItemMetaData) {
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.contains(menuItemMetaData.index)) {
            return true;
        }
        if (menuViewport.isEmpty()) {
            return true;
        }
        boolean bl = menuViewport.end.isBefore(menuItemMetaData.index);
        MenuItemIndex menuItemIndex = bl ? menuViewport.end : menuViewport.start;
        Iterator iterator = this.menu.iterator(menuItemIndex, bl, false);
        if (!iterator.hasNext()) {
            return true;
        }
        MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
        return menuItemMetaData.index.equals(menuItemIndex2);
    }

    MenuItemIndex getFocusedIndexWithStableRowId() {
        MenuItemIndex menuItemIndex;
        if (!this.menu.hasFocusedItem()) {
            return null;
        }
        Long l = this.menu.getFocusedUniqueID();
        MenuItemIndex menuItemIndex2 = this.menu.getFocusedIndex();
        if (!menuItemIndex2.equals(menuItemIndex = this.menu.getMenuItemIndexForUniqueID(l, menuItemIndex2))) {
            menuLogCh.log(-1601830656, "MenuAnimationManager#getFocusedIndexWithStableRowId: expected item %1, but found item %2 for row ID %3", (Object)menuItemIndex2, (Object)menuItemIndex, (Object)l);
            return menuItemIndex;
        }
        return menuItemIndex2;
    }

    void setupItemsAnimated(MenuUpdateRequest menuUpdateRequest, MenuViewport menuViewport) {
        MenuUpdateDelta menuUpdateDelta = new MenuUpdateDelta(menuViewport, null, null, null);
        this.setupItemsAnimated(menuUpdateRequest, menuViewport, menuUpdateDelta);
    }

    void setupItemsAnimated(MenuUpdateRequest menuUpdateRequest, MenuViewport menuViewport, MenuUpdateDelta menuUpdateDelta) {
        boolean bl = this.layoutData.alignTop;
        int n = this.getCurrentGlassplateInsets();
        this.setupItems(menuUpdateRequest, menuUpdateDelta);
        if (!menuViewport.isEmpty()) {
            if (this.layoutData.alignTop != bl) {
                this.adjustViewportOffsetForAlignmentChange(menuUpdateDelta);
                n *= -1;
            }
            this.adjustViewportOffsetForItemsChange(n, menuUpdateDelta);
        }
    }

    private int getCurrentGlassplateInsets() {
        int n = this.layoutData.alignTop ? 0 : this.layoutData.layoutItems.size() - 1;
        return this.layoutData.layoutItems.isEmpty() ? 0 : this.menu.getMenuItemGlassplateInsets((MenuItemMetaData)this.layoutData.layoutItems.get(n), this.layoutData.alignTop);
    }

    private void adjustViewportOffsetForItemsChange(int n, MenuUpdateDelta menuUpdateDelta) {
        MenuItemIndex menuItemIndex;
        MenuViewport menuViewport = this.menu.getViewport();
        if (this.layoutData.layoutItems.isEmpty()) {
            menuLogCh.log(-1601830656, "MenuAnimationManager#setupItemsAnimated: layoutItems are empty. viewport: %1, focus: %2", (Object)menuViewport, (Object)this.menu.getFocusedIndex());
            return;
        }
        int n2 = this.layoutData.alignTop ? 0 : this.layoutData.layoutItems.size() - 1;
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.layoutData.layoutItems.get(n2);
        this.layoutData.viewportOffsetBefore = this.layoutData.viewportOffsetBefore + (this.layoutData.alignTop ? -menuUpdateDelta.heightDeltaAbove : menuUpdateDelta.heightDeltaBelow);
        int n3 = this.layoutData.alignTop ? -menuUpdateDelta.itemsDeltaAbove : menuUpdateDelta.itemsDeltaBelow;
        this.layoutData.viewportOffsetBefore += n3 * this.menu.getLayout().getItemsGap();
        int n4 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData, this.layoutData.alignTop);
        int n5 = n - n4;
        this.layoutData.viewportOffsetBefore = this.layoutData.viewportOffsetBefore + (this.layoutData.alignTop ? n5 : -n5);
        MenuItemMetaData menuItemMetaData2 = this.layoutData.alignTop ? menuUpdateDelta.viewportStartItem : menuUpdateDelta.viewportEndItem;
        MenuItemIndex menuItemIndex2 = menuItemIndex = this.layoutData.alignTop ? menuViewport.start : menuViewport.end;
        if (menuItemMetaData2 == null || !Util.equals(menuItemMetaData2.index, menuItemIndex)) {
            menuItemMetaData2 = this.layoutData.findAnimationItem(menuItemIndex);
        }
        if (menuItemMetaData2 != null) {
            int n6 = this.calculateHeightDistance(menuItemMetaData, menuItemMetaData2, true, this.layoutData.alignTop);
            this.layoutData.viewportOffsetAfter = -n6;
            int n7 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData2, this.layoutData.alignTop);
            int n8 = n4 - n7;
            this.layoutData.viewportOffsetAfter = this.layoutData.viewportOffsetAfter + (this.layoutData.alignTop ? -n8 : n8);
        } else {
            menuLogCh.log(-1601830656, "MenuAnimationManager#setupItemsAnimated: viewport edge not found for viewport: %1", (Object)menuViewport);
        }
    }

    void adjustViewportOffsetForAlignmentChange(MenuUpdateDelta menuUpdateDelta) {
        int n = 0;
        int n2 = 0;
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            n += menuItemMetaData.heightBefore;
            n2 += menuItemMetaData.heightAfter - menuItemMetaData.heightBefore;
            if (!iterator.hasNext()) continue;
            n += this.menu.getLayout().getItemsGap();
        }
        int n3 = n - menuUpdateDelta.heightDeltaTotal - menuUpdateDelta.itemsDeltaTotal * this.menu.getLayout().getItemsGap();
        int n4 = n3 - this.menu.getLayout().getContentAreaHeight();
        if (this.layoutData.alignTop) {
            n4 *= -1;
            n2 *= -1;
        }
        this.layoutData.viewportOffsetBefore += n4;
        this.layoutData.viewportOffsetAfter += n4 + n2;
        menuLogCh.log(-2137614336, "MenuAnimationManager#adjustViewportOffsetForAlignmentChange: menu alignment changed. adjust viewport offset by %1", (long)n4);
    }

    void setupItems(MenuUpdateRequest menuUpdateRequest, MenuUpdateDelta menuUpdateDelta) {
        MenuUpdateManager menuUpdateManager = new MenuUpdateManager(this.menu, this.layoutData);
        menuUpdateManager.updateViewport(menuUpdateRequest, menuUpdateDelta);
    }

    public int calculateHeightDistance(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2, boolean bl, boolean n) {
        ListIterator listIterator;
        if (menuItemMetaData == menuItemMetaData2) {
            return 0;
        }
        int n2 = 0;
        boolean bl2 = false;
        ListIterator listIterator2 = listIterator = n != 0 ? this.layoutData.layoutItems.listIterator() : this.layoutData.layoutItems.listIterator(this.layoutData.layoutItems.size());
        while (MenuLayoutData.hasNext(listIterator, n != 0)) {
            int n3;
            MenuItemMetaData menuItemMetaData3 = (MenuItemMetaData)MenuLayoutData.next(listIterator, n != 0);
            if (menuItemMetaData3 == menuItemMetaData || menuItemMetaData3 == menuItemMetaData2) {
                if (!bl2) {
                    bl2 = true;
                } else {
                    n3 = menuItemMetaData3 == menuItemMetaData2 ? 1 : 0;
                    return n3 == n ? n2 : -n2;
                }
            }
            if (!bl2) continue;
            n3 = bl ? menuItemMetaData3.heightAfter : menuItemMetaData3.heightBefore;
            n2 += n3;
            n2 += this.menu.getLayout().getItemsGap();
        }
        menuLogCh.log(-1601830656, "MenuAnimationManager#calculateHeightDistance: item %1 or %2 not found in layoutItems: %3", (Object)menuItemMetaData, (Object)menuItemMetaData2, (Object)this.layoutData.layoutItems);
        return 0;
    }

    public void startSlowViewportScrolling(MenuItemIndex menuItemIndex) {
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.contains(menuItemIndex)) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuAnimationManager#startSlowViewportScrolling: +++ startSlowScroll to menu item: %1", (Object)menuItemIndex);
        MenuItemIndex menuItemIndex2 = this.menu.getFocusedIndex();
        this.adjustAnimationStartValuesForRestart(false, this.getCurrentTime());
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(menuItemIndex, FocusAdvice.KEEP_POSITION, MenuUpdateRequest.UPDATE_NONE);
        this.setupItemsAnimated(menuUpdateRequest, menuViewport);
        this.menu.setFocusedIndex(menuItemIndex2);
        this.handleAnimationsAfterUpdate(false, true, true, true, false);
        this.lastSlowScrollViewportOffset = this.getViewportOffset();
        menuLogCh.log(-2137614336, "MenuAnimationManager#startSlowViewportScrolling: --- startSlowScroll finished for menu item: %1", (Object)menuItemIndex);
    }

    public void deactivateSlowViewportScrolling() {
        int n;
        this.layoutData.viewportOffsetBefore = n = this.getViewportOffset();
        if (this.layoutData.getScrollDistance() != 0) {
            this.scrollAnimationFunction.startAnimation(this.layoutData.viewportOffsetBefore, this.layoutData.viewportOffsetAfter, false, true);
        } else {
            this.scrollAnimationFunction.resetSlowScrollMode();
        }
    }

    public void brakeFastViewportScrolling(boolean bl) {
        if (!this.isFastViewportScrollingRunning()) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#brakeFastViewportScrolling: no fast scroll running");
            return;
        }
        menuLogCh.log(-2137614336, "MenuAnimationManager#brakeFastViewportScrolling: +++ brake fast scroll. hardBrake: %1 (%2)", bl, (Object)this.menu);
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        long l = this.getCurrentTime();
        this.scrollAnimationFunction.updateProgress(l);
        this.menu.relayout();
        menuLayoutLogCh.log(-2137614336, "MenuAnimationManager#brakeFastViewportScrolling: relayout menu to get current viewport");
        this.menu.manageLayout();
        MenuViewport menuViewport = this.menu.getLayout().getCurrentViewport();
        boolean bl2 = this.isViewportScrollingDownward();
        MenuItemIndex menuItemIndex2 = this.getBrakeItem(menuViewport, bl2, bl);
        menuLogCh.log(-2137614336, "MenuAnimationManager#brakeFastViewportScrolling: current visible item: %1, brake at item: %2, old destination: %3", (Object)menuViewport, (Object)menuItemIndex2, (Object)menuItemIndex);
        if (menuItemIndex2 == null) {
            menuLogCh.log(-1601830656, "MenuAnimationManager#brakeFastViewportScrolling: no newFocus found. Current layout-viewport: %1", (Object)menuViewport);
            return;
        }
        int n = this.menu.getMenuItemHeight(menuItemIndex2, false);
        int n2 = this.menu.getHeight() / 2 - n;
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(menuItemIndex2, new WidgetFocusAdvice(n2, !bl2), MenuUpdateRequest.UPDATE_NONE);
        this.focus(menuUpdateRequest, bl, bl, l);
        this.menu.updateOptionDrawerFocusedProperty();
        if (bl) {
            this.stopScrollAnimation();
        } else {
            this.layoutData.cursorOffsetBefore = this.layoutData.cursorOffsetAfter;
            this.layoutData.cursorHeightBefore = this.layoutData.cursorHeightBefore;
            this.layoutData.cursorBorderVisibleBefore = this.layoutData.cursorBorderVisibleAfter;
        }
        menuLogCh.log(-2137614336, "MenuAnimationManager#brakeFastViewportScrolling: --- brake fast scroll finished");
    }

    private MenuItemIndex getBrakeItem(MenuViewport menuViewport, boolean bl, boolean bl2) {
        if (menuViewport.isEmpty()) {
            return null;
        }
        MenuItemMetaData menuItemMetaData = this.menu.getLayout().getCurrentItemUnderFocus(bl);
        if (menuItemMetaData != null) {
            return menuItemMetaData.index;
        }
        if (bl2) {
            return this.getViewportCenterItem(menuViewport, bl);
        }
        return bl ? menuViewport.end : menuViewport.start;
    }

    private MenuItemIndex getViewportCenterItem(MenuViewport menuViewport, boolean bl) {
        if (menuViewport.isEmpty()) {
            return null;
        }
        Iterator iterator = this.menu.iterator(menuViewport.start, menuViewport.end, true);
        Iterator iterator2 = this.menu.iterator(menuViewport.end, menuViewport.start, true);
        while (iterator.hasNext() && iterator2.hasNext()) {
            MenuItemIndex menuItemIndex;
            MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
            if (menuItemIndex2.equals(menuItemIndex = (MenuItemIndex)iterator2.next())) {
                return menuItemIndex2;
            }
            if (!menuItemIndex.isBefore(menuItemIndex2)) continue;
            return bl ? menuItemIndex2 : menuItemIndex;
        }
        menuLogCh.log(10000, "MenuAnimationManager#getViewportCenterItem: no center item found. Viewport: %1", (Object)menuViewport);
        return menuViewport.start;
    }

    public void startCursorBounce(boolean bl) {
        int n = this.layoutData.cursorHeightAfter / 2;
        if (!bl) {
            n *= -1;
        }
        if (this.isCursorBounceRunning()) {
            if (this.isCursorBounceAnimationRunning()) {
                if (this.cursorBounceTargetOffset != n) {
                    menuLogCh.log(-2137614336, "MenuAnimationManager#startCursorBounce: restart cursor bounce. target: %1", (long)n);
                    this.cursorBounceTargetOffset = n;
                    this.getCursorBounceAnimation().setTarget(n);
                } else {
                    menuLogCh.log(-2137614336, "MenuAnimationManager#startCursorBounce: cursor bounce already running. target: %1", (long)n);
                }
            } else {
                this.restartCursorBounceNoMoveTimer();
            }
        } else {
            menuLogCh.log(-2137614336, "MenuAnimationManager#startCursorBounce: start cursor bounce. target: %1", (long)n);
            this.cursorBounceTargetOffset = n;
            this.getCursorBounceAnimation().startDynamicAnimation(0.0f, n, 106, false, this.menu);
        }
    }

    public boolean isCursorBounceTurnaroundReached() {
        return this.cursorBounceTargetOffset == 0;
    }

    public boolean isSlowViewportScrollingRunning() {
        return this.scrollAnimationFunction.isSlowScrollActive();
    }

    public boolean isFastViewportScrollingRunning() {
        return this.isScrollAnimationRunning() && !this.scrollAnimationFunction.isSlowScrollActive();
    }

    public boolean isViewportScrollingDownward() {
        return this.scrollAnimationFunction.getTarget() < this.scrollAnimationFunction.getStart();
    }

    private void updateMenuImmediately() {
        this.menu.relayout();
        this.menu.getItemFocusedPropagator().fireItemFocused();
    }

    protected void startAnimation(boolean bl, boolean bl2) {
        int n;
        if (!bl && !bl2) {
            return;
        }
        this.logStartAnimation(bl, bl2);
        if (bl) {
            this.startShortAnimation();
        }
        if ((n = this.layoutData.getScrollDistance()) != 0) {
            if (bl2 && n != this.shortAnimationScrollDistance) {
                if (!this.isScrollAnimationRunning()) {
                    this.startScrollAnimation();
                }
                this.shortAnimationScrollDistance = 0;
            } else if (bl) {
                this.shortAnimationScrollDistance = n;
                this.stopScrollAnimation();
            } else {
                menuLogCh.log(-2137614336, "MenuAnimationManager#startAnimation: expected start scroll animation, but scroll distance %1 didn't change. shortScrollDistance: %2", (long)n, (long)this.shortAnimationScrollDistance);
            }
        }
    }

    private void logStartAnimation(boolean bl, boolean bl2) {
        Object object;
        if (!menuLogCh.isDebug()) {
            return;
        }
        Buffer buffer = new Buffer(150);
        buffer.append("shortAnim: ").append(bl).append(", scrollAnim: ").append(bl2).append(", shortScroll: ").append(this.shortAnimationScrollDistance);
        Buffer buffer2 = new Buffer(this.layoutData.layoutItems.size() * 8);
        Object object2 = this.layoutData.layoutItems.iterator();
        while (object2.hasNext()) {
            object = (MenuItemMetaData)object2.next();
            this.logValueChange(((MenuItemMetaData)object).heightBefore, ((MenuItemMetaData)object).heightAfter, buffer2);
            if (!object2.hasNext()) continue;
            buffer2.append(", ");
        }
        object2 = this.logValueChange(this.layoutData.viewportOffsetBefore, this.layoutData.viewportOffsetAfter, null);
        object = this.logValueChange(this.layoutData.cursorOffsetBefore, this.layoutData.cursorOffsetAfter, null);
        Buffer buffer3 = this.logValueChange(this.layoutData.cursorHeightBefore, this.layoutData.cursorHeightAfter, null);
        Buffer buffer4 = new Buffer(100 + ((Buffer)object2).length() + ((Buffer)object).length() + buffer3.length());
        buffer4.append("Viewport offset: ").append(object2).append(", cursor offset: ").append(object).append(", cursor height: ").append(buffer3);
        menuLogCh.log(-2137614336, "MenuAnimationManager#startAnimation: %1,  %2,   item heights: %3", (Object)buffer, (Object)buffer4, (Object)buffer2);
    }

    private Buffer logValueChange(int n, int n2, Buffer buffer) {
        if (buffer == null) {
            buffer = new Buffer(10);
        }
        buffer.append(n);
        if (n != n2) {
            buffer.append("->").append(n2);
        }
        return buffer;
    }

    protected void startShortAnimation() {
        if (this.getAnimation().isAnimating()) {
            this.getAnimation().setTarget(this.animation.getTarget() + 31300);
        } else {
            this.getAnimation().startDynamicAnimation(0.0f, 31300, 78, false, this.menu);
        }
    }

    protected void startScrollAnimation() {
        menuLogCh.log(-2137614336, "MenuAnimationManager#startScrollAnimation: start endless animation for scrolling. TimerInterval: %1 ms", (long)SCROLL_ANIMATION_INTERVAL);
        this.getScrollAnimation().startEndlessAnimation(SCROLL_ANIMATION_INTERVAL, this.menu);
    }

    public void startMoveGapAnimation() {
        this.stopMoveGapAnimation();
        int n = this.menu.getLayout().getMoveGapHeight();
        this.getMoveGapAnimation().startDynamicAnimation(0.0f, n, 79, false, this.menu);
    }

    private void restartCursorBounceNoMoveTimer() {
        this.stopCursorBounceTimer();
        if (this.cursorBounceNoMoveTimerEvent == null) {
            this.cursorBounceNoMoveTimerEvent = new TimerEvent(this);
        }
        menuLogCh.log(-2137614336, "MenuAnimationManager#restartCursorBounceNoMoveTimer. Start timer with delay %1 ms", (long)0);
        this.cursorBounceNoMoveTimerJob = AbstractWidget.hmiService.getEventDispatcher().postEvent(this.cursorBounceNoMoveTimerEvent, 0);
    }

    @Override
    public void animate(int n, float f2, int n2) {
        if (this.animationCallback != null) {
            this.animationCallback.animate(n, f2, n2);
        }
        this.animate(n, f2);
    }

    public void animate(int n, float f2) {
        if (this.isScrollAnimation(n)) {
            this.scrollAnimationFunction.updateProgress(this.getCurrentTime());
            menuLogCh.log(-2137614336, "MenuAnimationManager#animate: scroll animation. scroll distance: %1, progress: %2", (double)this.scrollAnimationFunction.getValue(), (double)this.scrollAnimationFunction.getProgress(), 0.0);
            this.menu.getKeyEventHandler().animateSlowViewportScrolling(this.getSlowScrollViewportOffset());
            if (this.isScrollAnimationTargetReached()) {
                this.resetSlowScrollMode();
                this.stopScrollAnimation();
            }
        } else {
            menuLogCh.log(-2137614336, "MenuAnimationManager#animate: short animation of type: %1", (long)n);
            if (this.menu instanceof AnimationListener) {
                ((AnimationListener)((Object)this.menu)).animate(n, f2, 0);
            }
        }
        this.menu.relayout();
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.cursorBounceNoMoveTimerEvent)) {
            this.cursorBounceNoMoveTimerJob = null;
            menuLogCh.log(-2137614336, "MenuKeyEventHandler#processEvent: cursor bounce noMove timer fired. Start bounce step 3. Bounce offset: %2. (%1)", (Object)this.menu, (long)this.cursorBounceTargetOffset);
            int n = this.cursorBounceTargetOffset;
            this.cursorBounceTargetOffset = 0;
            this.getCursorBounceAnimation().startDynamicAnimation(n, 0.0f, 106, false, this.menu);
        }
    }

    int getSlowScrollViewportOffset() {
        int n = this.getViewportOffset();
        int n2 = n - this.lastSlowScrollViewportOffset;
        this.lastSlowScrollViewportOffset = n;
        return n2;
    }

    protected boolean isScrollAnimationTargetReached() {
        return this.scrollAnimationFunction.isTargetReached();
    }

    protected void stopScrollAnimation() {
        if (this.isScrollAnimationRunning()) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#stopScrollAnimation: stop endless animation for scrolling");
            this.scrollAnimation.stopAnimation();
        }
    }

    protected void stopShortAnimation() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
    }

    protected void stopMoveGapAnimation() {
        if (this.isMoveGapAnimationRunning()) {
            this.moveGapAnimation.stopAnimation();
        }
    }

    protected void stopCursorBounceAnimation() {
        if (this.isCursorBounceAnimationRunning()) {
            this.cursorBounceAnimation.stopAnimation();
        }
    }

    protected void stopCursorBounceTimer() {
        if (this.cursorBounceNoMoveTimerJob != null) {
            this.cursorBounceNoMoveTimerJob.cancel();
            this.cursorBounceNoMoveTimerJob = null;
        }
    }

    private void resetSlowScrollMode() {
        this.getScrollAnimationFunction().resetSlowScrollMode();
    }

    public boolean isScrollAnimation(int n) {
        return this.scrollAnimation != null && n == this.scrollAnimation.getType();
    }

    protected boolean isAnimationRunning() {
        return this.isShortAnimationRunning() || this.isScrollAnimationRunning();
    }

    public boolean isShortAnimationRunning() {
        return this.animation != null && this.animation.isAnimating();
    }

    public boolean isMoveGapAnimationRunning() {
        return this.moveGapAnimation != null && this.moveGapAnimation.isAnimating();
    }

    public boolean isScrollAnimationRunning() {
        return this.scrollAnimation != null && this.scrollAnimation.isAnimating();
    }

    private boolean isCursorBounceAnimationRunning() {
        return this.cursorBounceAnimation != null && this.cursorBounceAnimation.isAnimating();
    }

    private boolean isCursorBounceNoMoveTimerRunning() {
        return this.cursorBounceNoMoveTimerJob != null && !this.cursorBounceNoMoveTimerJob.isCanceled();
    }

    public boolean isCursorBounceRunning() {
        return this.isCursorBounceAnimationRunning() || this.isCursorBounceNoMoveTimerRunning();
    }

    public float getAnimationProgress() {
        return this.animation.getProgress();
    }

    protected float getScrollAnimationProgress() {
        if (this.isScrollingControlledByShortAnimation()) {
            return this.getAnimationProgress();
        }
        return this.scrollAnimationFunction.getProgress();
    }

    public boolean isScrollingControlledByShortAnimation() {
        return this.shortAnimationScrollDistance != 0;
    }

    public boolean isScrollingControlledBySeparateAnimation() {
        if (this.layoutData.getScrollDistance() == 0) {
            return false;
        }
        return !this.isScrollingControlledByShortAnimation();
    }

    public float getMoveGapAnimationProgress() {
        return this.isMoveGapAnimationRunning() ? this.moveGapAnimation.getProgress() : 1.0f;
    }

    float getAnimatedValue(int n, int n2) {
        if (n == n2) {
            return n2;
        }
        if (!this.isShortAnimationRunning()) {
            if (n != n2) {
                menuLogCh.log(-1601830656, "MenuAnimationManager#getAnimatedValue: No animation running, but source and target values are different: %1, %2", (long)n, (long)n2);
            }
            return n2;
        }
        float f2 = this.getAnimationProgress();
        if (f2 == 1.0f) {
            return n2;
        }
        int n3 = n2 - n;
        float f3 = (float)n3 * f2;
        return (float)n + f3;
    }

    float getAnimatedValueF(float f2, float f3) {
        if (f2 == f3) {
            return f3;
        }
        if (!this.isShortAnimationRunning()) {
            if (f2 != f3) {
                menuLogCh.log(-1601830656, "MenuAnimationManager#getAnimatedValueF: No animation running, but source and target values are different: %1, %2", (double)f2, (double)f3, 0.0);
            }
            return f3;
        }
        float f4 = this.getAnimationProgress();
        if (f4 == 1.0f) {
            return f3;
        }
        float f5 = f3 - f2;
        float f6 = f5 * f4;
        return f2 + f6;
    }

    int round(float f2) {
        return Math.round(f2);
    }

    @Override
    public void animationStarted(int n, int n2) {
        if (this.animationCallback != null) {
            this.animationCallback.animationStarted(n, n2);
        }
    }

    @Override
    public void animationFinished(int n, int n2) {
        menuLogCh.log(-2137614336, "MenuAnimationManager#animationFinished: animationType: %2, id: %3 (%1)", (Object)this.menu, (long)n, (long)n2);
        if (this.animationCallback != null) {
            this.animationCallback.animationFinished(n, n2);
        }
        if (this.isScrollAnimation(n)) {
            this.scrollAnimationFunction.updateProgress(this.getCurrentTime());
            this.destroyUnusedItems();
            this.resetSlowScrollMode();
            this.menu.getKeyEventHandler().scrollAnimationFinished();
            this.menu.notifyTimerScrollAnimationFinished();
        } else if (n == 78) {
            if (this.menu instanceof AnimationListener) {
                ((AnimationListener)((Object)this.menu)).animationFinished(n, n2);
            }
            this.shortAnimationScrollDistance = 0;
            this.resetShortAnimationStartValues();
            new MenuUpdateManager(this.menu, this.layoutData).destroyRemovedItems();
        } else if (n == 106) {
            if (!this.isCursorBounceTurnaroundReached()) {
                menuLogCh.log(-2137614336, "MenuAnimationManager#animationFinished: cursor bounce step 1 finished, start timer for step 2. bounce offset: %2 (%1)", (Object)this.menu, (long)this.cursorBounceTargetOffset);
                this.restartCursorBounceNoMoveTimer();
            } else {
                menuLogCh.log(-2137614336, "MenuAnimationManager#animationFinished: cursor bounce step 3 finished. (%1)", (Object)this.menu);
            }
        }
        if (!this.isAnimationRunning()) {
            menuLogCh.log(-2137614336, "MenuAnimationManager#animationFinished: last animation finished, do a full refresh (%1)", (Object)this.menu);
            this.refresh(MenuUpdateRequest.UPDATE_ALL);
            this.menu.getItemFocusedPropagator().fireItemFocused();
        } else {
            menuLogCh.log(-2137614336, "MenuAnimationManager#animationFinished: don't fireItemFocused at animation finished (type %1). short animation running: %2, scroll animation running: %3", (Object)Util.createInteger(n), (Object)this.isShortAnimationRunning(), (Object)this.isScrollAnimationRunning());
        }
        this.menu.relayout();
    }

    private void resetShortAnimationStartValues() {
        this.layoutData.cursorOffsetBefore = this.layoutData.cursorOffsetAfter;
        this.layoutData.cursorHeightBefore = this.layoutData.cursorHeightAfter;
        this.layoutData.cursorBorderVisibleBefore = this.layoutData.cursorBorderVisibleAfter;
        this.layoutData.infolineHeightBefore = this.layoutData.infolineHeightAfter;
        Iterator iterator = this.layoutData.layoutItems.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            menuItemMetaData.heightBefore = menuItemMetaData.heightAfter;
            menuItemMetaData.opacityBefore = menuItemMetaData.getOpacityAfter();
        }
    }

    private void destroyUnusedItems() {
        new MenuUpdateManager(this.menu, this.layoutData).destroyUnusedItems();
        if (this.layoutData.layoutItems.isEmpty()) {
            this.layoutData.viewportOffsetAfter = 0;
            this.layoutData.viewportOffsetBefore = 0;
        } else {
            int n = this.layoutData.alignTop ? 0 : this.layoutData.layoutItems.size() - 1;
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.layoutData.layoutItems.get(n);
            MenuItemIndex menuItemIndex = this.layoutData.alignTop ? this.menu.getViewport().start : this.menu.getViewport().end;
            MenuItemMetaData menuItemMetaData2 = this.layoutData.findAnimationItem(menuItemIndex);
            if (menuItemMetaData2 != null) {
                int n2 = this.calculateHeightDistance(menuItemMetaData, menuItemMetaData2, true, this.layoutData.alignTop);
                if (n2 != 0 && !this.menu.hasMoveItem()) {
                    menuLogCh.log(-1601830656, "MenuAnimationManager#destroyUnusedItems: no move cursor, but viewport offset is: %1", (long)(-n2));
                }
                this.layoutData.viewportOffsetAfter = -n2;
                this.layoutData.viewportOffsetBefore = -n2;
                int n3 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData, this.layoutData.alignTop);
                int n4 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData2, this.layoutData.alignTop);
                int n5 = n3 - n4;
                this.layoutData.viewportOffsetBefore = this.layoutData.viewportOffsetBefore + (this.layoutData.alignTop ? -n5 : n5);
                this.layoutData.viewportOffsetAfter = this.layoutData.viewportOffsetAfter + (this.layoutData.alignTop ? -n5 : n5);
            } else {
                menuLogCh.log(-1601830656, "MenuAnimationManager#destroyUnusedItems: viewport edge not found for viewport: %1", (Object)this.menu.getViewport());
                this.layoutData.viewportOffsetAfter = 0;
                this.layoutData.viewportOffsetBefore = 0;
            }
        }
    }

    public int getViewportOffset() {
        if (!this.isScrollAnimationRunning() && !this.isScrollingControlledByShortAnimation()) {
            if (this.layoutData.viewportOffsetBefore != this.layoutData.viewportOffsetAfter) {
                menuLogCh.log(-1601830656, "MenuAnimationManager#getAnimatedValue: No animation running, but source and target values are different: %1, %2", (long)this.layoutData.viewportOffsetBefore, (long)this.layoutData.viewportOffsetAfter);
            }
            return this.layoutData.viewportOffsetAfter;
        }
        float f2 = this.getScrollAnimationProgress();
        if (f2 == 1.0f) {
            return this.layoutData.viewportOffsetAfter;
        }
        int n = this.layoutData.getScrollDistance();
        float f3 = (float)n * f2;
        return this.round((float)this.layoutData.viewportOffsetBefore + f3);
    }

    public int getCursorBounceOffset() {
        if (this.isCursorBounceRunning()) {
            if (this.isCursorBounceAnimationRunning()) {
                return Math.round(this.cursorBounceAnimation.getValue());
            }
            return this.cursorBounceTargetOffset;
        }
        return 0;
    }

    public float getFocusCursorOffset() {
        return this.getAnimatedValue(this.layoutData.cursorOffsetBefore, this.layoutData.cursorOffsetAfter);
    }

    public int getFocusCursorHeight() {
        return this.round(this.getAnimatedValue(this.layoutData.cursorHeightBefore, this.layoutData.cursorHeightAfter));
    }

    public float getFocusCursorBorderVisible() {
        return this.getAnimatedValueF(this.layoutData.cursorBorderVisibleBefore, this.layoutData.cursorBorderVisibleAfter);
    }

    public int getInfolineHeight() {
        return this.round(this.getAnimatedValue(this.layoutData.infolineHeightBefore, this.layoutData.infolineHeightAfter));
    }

    public float getMenuItemHeight(MenuItemMetaData menuItemMetaData) {
        return this.getAnimatedValue(menuItemMetaData.heightBefore, menuItemMetaData.heightAfter);
    }

    private float getMenuItemOpacityRaw(MenuItemMetaData menuItemMetaData) {
        return this.getAnimatedValueF(menuItemMetaData.opacityBefore, menuItemMetaData.getOpacityAfter());
    }

    public float getMenuItemRenderOpacity(MenuItemMetaData menuItemMetaData) {
        int n;
        float f2 = this.getMenuItemOpacityRaw(menuItemMetaData);
        if (f2 <= (n = 0x6666663F)) {
            return 0.0f;
        }
        return (f2 - n) / (1.0f - n);
    }

    public void setCursorOffsetAfter(int n) {
        this.layoutData.cursorOffsetAfter = n;
    }

    public void setCursorHeightAfter(int n) {
        this.layoutData.cursorHeightAfter = n;
    }

    public List getLayoutItems() {
        return Collections.unmodifiableList(this.layoutData.layoutItems);
    }

    public MenuLayoutData getLayoutData() {
        return this.layoutData;
    }

    int getViewportOffsetBefore() {
        return this.layoutData.viewportOffsetBefore;
    }

    int getViewportOffsetAfter() {
        return this.layoutData.viewportOffsetAfter;
    }

    int getCursorOffsetBefore() {
        return this.layoutData.cursorOffsetBefore;
    }

    int getCursorOffsetAfter() {
        return this.layoutData.cursorOffsetAfter;
    }

    int getCursorHeightBefore() {
        return this.layoutData.cursorHeightBefore;
    }

    public int getCursorHeightAfter() {
        return this.layoutData.cursorHeightAfter;
    }

    void test_setAnimationValues(int n, int n2, int n3, int n4, int n5, int n6) {
        this.layoutData.viewportOffsetBefore = n;
        this.layoutData.viewportOffsetAfter = n2;
        this.layoutData.cursorOffsetBefore = n3;
        this.layoutData.cursorOffsetAfter = n4;
        this.layoutData.cursorHeightBefore = n5;
        this.layoutData.cursorHeightAfter = n6;
    }

    void test_setLastSlowScrollViewportOffset(int n) {
        this.lastSlowScrollViewportOffset = n;
    }

    void test_setLayoutData(MenuLayoutData menuLayoutData) {
        this.layoutData = menuLayoutData;
    }

    protected long getCurrentTime() {
        return AbstractWidget.framework.getMonotonicTime();
    }

    static {
        DEFAULT_SCROLL_ANIMATION_INTERVAL = AbstractWidget.isVariantStd() ? 30 : 20;
        SCROLL_ANIMATION_INTERVAL = Integer.getInteger("scrollAnimationInterval", DEFAULT_SCROLL_ANIMATION_INTERVAL);
    }
}

