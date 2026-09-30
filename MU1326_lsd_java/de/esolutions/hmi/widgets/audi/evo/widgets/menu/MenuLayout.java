/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.RectangleParameters;
import de.esolutions.hmi.widgets.audi.base.SystemProperties;
import de.esolutions.hmi.widgets.audi.base.TabLayoutManager;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeManager;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.BaselineWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ViewSizeAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuSDSEventHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuSDSNumbersController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuScrollAnimationFunction;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MultiLineMenuItemController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MenuLayout
implements WidgetConstants,
IWidgetLogChannel {
    public static final int SCROLLBAR_X_LAYOUT_MANUAL = 0;
    public static final int SCROLLBAR_X_LAYOUT_DYN_RIGHT = 1;
    public static final int SCROLLBAR_X_LAYOUT_DYN_LEFT = 2;
    public static final int SCROLLBAR_X_LAYOUT_MIN_VALUE = 0;
    public static final int SCROLLBAR_X_LAYOUT_MAX_VALUE = 2;
    private static final int CURSOR_MIN_HEIGHT = 10;
    private static final int FOCUS_CURSOR_BORDER = 2;
    private static final int DEFAULT_SDS_NUMBER_COUNT = 6;
    public static final int DEFAULT_TABULATOR_ALIGNMENT = 1;
    private static final float MOVE_MODE_ITEM_OPACITY = 0.5f;
    private static final boolean SHOW_STATISTICS = SystemProperties.getBoolean("MenuShowStatistics", false);
    private static final double PxPerFrameToPxPerMs = 0.06;
    private static float stroboscopeSpeedStart = 1.0f;
    private static float stroboscopeSpeedKeep = 0.7f;
    private static float stroboscopeConstantSpeed = 0.03f;
    private static float stroboscopeDefaultSpeedFactor = 500.0f;
    private static float stroboscopeMaxSpeedFactor = 2.0f;
    private MenuController menu;
    private int itemsGap = 17;
    private int focusCursorLeftOffset = 0;
    private int selectionCursorLeftOffset = 0;
    private int focusCursorRightOffset = 0;
    private int selectionCursorRightOffset = 0;
    private int backgroundInsetsVert = 5;
    private int backgroundXOffset = 0;
    private int backgroundY = 0;
    private int backgroundHeight = 0;
    private int contentLeftOffset = 21;
    private int contentRightOffset = 22;
    private int contentRightOffsetSmallStage = -1;
    private int optionsIconAdditionalRightInsets = 0;
    private int sdsNumbersGlasplateGap = 5;
    private int[] tabulatorIDs;
    private int[] tabulatorAlignments;
    private int[] tabulatorSizes;
    private int firstVisibleItem;
    private int lastVisibleItem;
    private float firstItemVisibleRatio;
    private float lastItemVisibleRatio;
    private int lastFocusPosition;
    private int lastFocusHeight;
    private int m_scrollbarLayoutMode = 0;
    private int m_scrollbarOffset = 0;
    private RectangleParameters backgroundBounds;
    private MenuItemMetaData moveItem;
    private boolean stroboscopeActive = false;
    private long stroboscopeLastTime;
    int stroboscopeLastYPos;

    public MenuLayout(MenuController menuController) {
        this.menu = menuController;
    }

    public void disconnect() {
        this.destroyCachedMoveItem();
        this.backgroundBounds = null;
        this.stroboscopeActive = false;
    }

    public void layout() {
        menuLayoutLogCh.log(10000000, "MenuLayout#layout: --- layout %1", (Object)this.menu);
        boolean bl = this.menu.isSDSActive() && this.menu.getChildOfRole(6) != null;
        IntList intList = bl ? new IntList(6) : null;
        ArrayList arrayList = bl ? new ArrayList(6) : null;
        boolean bl2 = this.isOptionsIconVisible();
        this.firstVisibleItem = -1;
        this.lastVisibleItem = -1;
        this.lastFocusPosition = 0;
        this.lastFocusHeight = 0;
        MenuLayoutTempData menuLayoutTempData = this.createTempData();
        this.iterateThroughLayoutItems(menuLayoutTempData, intList, arrayList, bl2);
        this.layoutUnreachableItems(menuLayoutTempData.yChild, menuLayoutTempData.first, bl2);
        this.layoutMoveItem(menuLayoutTempData, bl2);
        this.applyTabulators(bl2);
        if (!menuLayoutTempData.focusCursorVisible) {
            this.hideWidgetOfRole(1);
        }
        if (!menuLayoutTempData.selectionCursorVisible) {
            this.hideWidgetOfRole(2);
            this.hideWidgetOfRole(11);
        }
        if (!menuLayoutTempData.infolineVisible) {
            this.hideWidgetOfRole(13);
        }
        this.layoutSdsNumbers(intList, arrayList);
        this.layoutBackground();
        this.layoutScrollbar();
        this.logLayout(menuLayoutTempData);
        this.showStatistics();
        this.orderVisibleEdges(menuLayoutTempData);
        menuLayoutLogCh.log(10000000, "MenuLayout#layout: +++ layout finished for menu %1", (Object)this.menu);
    }

    private void iterateThroughLayoutItems(MenuLayoutTempData menuLayoutTempData, IntList intList, List list, boolean bl) {
        ListIterator listIterator;
        List list2 = this.getLayoutItems();
        ListIterator listIterator2 = listIterator = menuLayoutTempData.alignTop ? list2.listIterator() : list2.listIterator(list2.size());
        while (MenuLayoutData.hasNext(listIterator, menuLayoutTempData.alignTop)) {
            int n;
            int n2;
            int n3 = MenuLayoutData.nextIndex(listIterator, menuLayoutTempData.alignTop);
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)MenuLayoutData.next(listIterator, menuLayoutTempData.alignTop);
            this.prepareIterationStep(menuItemMetaData, menuLayoutTempData);
            float f2 = this.menu.getAnimationManager().getMenuItemHeight(menuItemMetaData);
            float f3 = menuLayoutTempData.alignTop ? menuLayoutTempData.yChild : (float)(this.menu.getHeight() - 1) - menuLayoutTempData.yChild;
            int n4 = Math.round(f3);
            int n5 = Math.round(f2);
            if (!menuLayoutTempData.alignTop) {
                n4 -= n5 - 1;
            }
            if (this.isVisible(n2 = (n4 = this.setupStroboscope(menuLayoutTempData, n4, n5)) + (n = Math.round(menuLayoutTempData.alignTop ? menuLayoutTempData.moveCursorGapOffset : -menuLayoutTempData.moveCursorGapOffset)), n5)) {
                this.setupVisibleMenuItem(n3, menuItemMetaData, n2, n5, menuLayoutTempData, intList, list, bl);
            } else {
                if (this.hasIterationPassedVisibleItems(menuLayoutTempData, menuItemMetaData)) {
                    this.setupInvisibleMenuItem(menuItemMetaData, menuLayoutTempData);
                    this.destroyPassedInvisibleItems(n3, menuLayoutTempData);
                    return;
                }
                this.setupInvisibleMenuItem(menuItemMetaData, menuLayoutTempData);
            }
            this.setupItemDependentWidgets(menuItemMetaData, f3, n2, n5, menuLayoutTempData);
            this.cleanupIterationStep(menuItemMetaData, menuLayoutTempData, f2);
        }
    }

    private void destroyPassedInvisibleItems(int n, MenuLayoutTempData menuLayoutTempData) {
        int n2 = this.getLayoutItems().size();
        menuLogCh.log(10000000, "MenuLayout#destroyPassedInvisibleItems: last visible list index: %2, layoutItems length: %3, menu alignment: %1", (Object)(menuLayoutTempData.alignTop ? "top" : "bottom"), (long)this.lastVisibleItem, (long)n2);
        int n3 = menuLayoutTempData.alignTop ? n2 - 1 : 0;
        new MenuUpdateManager(this.menu, this.getLayoutData()).destroyItems(n3, n);
        if (!menuLayoutTempData.alignTop) {
            int n4 = n;
            this.firstVisibleItem -= n4;
            this.lastVisibleItem -= n4;
        }
    }

    private boolean hasIterationPassedVisibleItems(MenuLayoutTempData menuLayoutTempData, MenuItemMetaData menuItemMetaData) {
        MenuItemIndex menuItemIndex;
        if (this.lastVisibleItem == -1) {
            return false;
        }
        if (MenuController.isEqualMultiLineItem(menuLayoutTempData.multiLineStartItem, menuItemMetaData)) {
            return false;
        }
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.isEmpty()) {
            return false;
        }
        boolean bl = this.getLayoutData().alignTop;
        MenuItemIndex menuItemIndex2 = menuItemIndex = bl ? menuViewport.end : menuViewport.start;
        return MenuLayoutData.isBefore(menuItemIndex, menuItemMetaData.index, bl);
    }

    private void prepareIterationStep(MenuItemMetaData menuItemMetaData, MenuLayoutTempData menuLayoutTempData) {
        if (menuLayoutTempData.first) {
            menuLayoutTempData.yChild += (float)this.menu.getMenuItemGlassplateInsets(menuItemMetaData, menuLayoutTempData.alignTop);
            menuLayoutTempData.moveCursorGapOffset = this.calculateInitialMoveCursorGapOffset(menuItemMetaData);
        }
        if (this.isMoveGap(menuItemMetaData, menuLayoutTempData.alignTop, true)) {
            menuLayoutTempData.moveCursorGapOffset += this.getMoveGapHeightBefore();
        }
        if (this.isMoveGap(menuItemMetaData, menuLayoutTempData.alignTop, false)) {
            menuLayoutTempData.moveCursorGapOffset += this.getMoveGapHeightAfter();
        }
    }

    private void cleanupIterationStep(MenuItemMetaData menuItemMetaData, MenuLayoutTempData menuLayoutTempData, float f2) {
        menuLayoutTempData.yChild += f2 + (float)this.itemsGap;
        if (this.isMoveItem(menuItemMetaData)) {
            menuLayoutTempData.moveCursorGapOffset -= f2 + (float)this.itemsGap;
        }
        if (this.isMoveGap(menuItemMetaData, !menuLayoutTempData.alignTop, true)) {
            menuLayoutTempData.moveCursorGapOffset += this.getMoveGapHeightBefore();
        }
        if (this.isMoveGap(menuItemMetaData, !menuLayoutTempData.alignTop, false)) {
            menuLayoutTempData.moveCursorGapOffset += this.getMoveGapHeightAfter();
        }
        menuLayoutTempData.first = false;
    }

    private void setupVisibleMenuItem(int n, MenuItemMetaData menuItemMetaData, int n2, int n3, MenuLayoutTempData menuLayoutTempData, IntList intList, List list, boolean bl) {
        if (this.firstVisibleItem == -1) {
            this.firstVisibleItem = n;
            this.firstItemVisibleRatio = this.getVisibleRatio(menuItemMetaData, n2, n3);
        }
        this.lastVisibleItem = n;
        this.lastItemVisibleRatio = this.getVisibleRatio(menuItemMetaData, n2, n3);
        if (this.isMoveItem(menuItemMetaData)) {
            menuLayoutTempData.moveLayoutItem = menuItemMetaData;
        } else {
            if (!MenuController.isEqualMultiLineItem(menuLayoutTempData.multiLineStartItem, menuItemMetaData)) {
                menuLayoutTempData.multiLineStartItem = menuItemMetaData;
            }
            if (menuLayoutTempData.multiLineStartItem == menuItemMetaData || !menuLayoutTempData.alignTop) {
                menuLayoutTempData.multiLineY = n2;
            }
            int n4 = Math.max(menuItemMetaData.heightBefore, menuItemMetaData.heightAfter);
            this.layoutMenuItemWidget(menuItemMetaData, menuLayoutTempData.multiLineY, n3, n4, true, false, menuLayoutTempData.multiLineStartItem, bl);
            this.storeSDSNumberPosition(intList, list, menuItemMetaData, n2);
        }
    }

    private void setupInvisibleMenuItem(MenuItemMetaData menuItemMetaData, MenuLayoutTempData menuLayoutTempData) {
        if (this.isMoveItem(menuItemMetaData)) {
            menuLayoutTempData.moveLayoutItem = menuItemMetaData;
        } else {
            if (!MenuController.isEqualMultiLineItem(menuLayoutTempData.multiLineStartItem, menuItemMetaData)) {
                menuLayoutTempData.multiLineStartItem = null;
            }
            this.hideMenuItemWidget(menuItemMetaData, menuLayoutTempData.multiLineStartItem);
        }
    }

    private void setupItemDependentWidgets(MenuItemMetaData menuItemMetaData, float f2, int n, int n2, MenuLayoutTempData menuLayoutTempData) {
        if (this.isFocused(menuItemMetaData)) {
            if (this.menu.isFocusCursorVisible()) {
                menuLayoutTempData.focusCursorPosition = this.layoutFocusCursor(menuItemMetaData, f2, n2);
                menuLayoutTempData.focusCursorVisible = true;
            } else {
                menuLayoutLogCh.log(10000000, "MenuLayout#layout: focus cursor is hidden by menu. Focused item: %1", (Object)menuItemMetaData);
            }
        }
        if (this.isSelected(menuItemMetaData)) {
            this.layoutSelectionCursor(menuItemMetaData, n, n2);
            menuLayoutTempData.selectionCursorVisible = true;
        }
        if (this.hasInfoline(menuItemMetaData)) {
            this.layoutInfoline(menuItemMetaData, n, n2);
            menuLayoutTempData.infolineVisible = true;
        }
    }

    private void layoutUnreachableItems(float f2, boolean bl, boolean bl2) {
        boolean bl3 = this.getLayoutData().alignTop;
        List list = this.menu.getUnreachableItemsMetaData();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            if (!menuItemMetaData.widget.isVisible() || !menuItemMetaData.widget.isVisibleOnCurrentStage()) continue;
            if (bl) {
                f2 += (float)this.menu.getMenuItemGlassplateInsets(menuItemMetaData, bl3);
            }
            float f3 = bl3 ? f2 : (float)(this.menu.getHeight() - 1) - f2;
            int n = menuItemMetaData.heightAfter;
            int n2 = Math.round(f3);
            if (!bl3) {
                n2 -= n - 1;
            }
            if (this.isVisible(n2, n)) {
                this.layoutMenuItemWidget(menuItemMetaData, n2, n, n, true, false, menuItemMetaData, bl2);
            } else {
                this.hideMenuItemWidget(menuItemMetaData, null);
            }
            f2 += (float)(n + this.itemsGap);
            bl = false;
        }
    }

    private void storeSDSNumberPosition(IntList intList, List list, MenuItemMetaData menuItemMetaData, int n) {
        if (intList == null || list == null) {
            return;
        }
        if (this.isItemPositionValidForSDSNumber(menuItemMetaData) && this.isSdsItem(menuItemMetaData)) {
            int n2;
            if (menuItemMetaData.widget instanceof BaselineWidget) {
                n2 = ((BaselineWidget)((Object)menuItemMetaData.widget)).getBaseline();
                intList.add(n + n2);
            } else {
                intList.add(n);
            }
            n2 = (menuItemMetaData.isRealized() ? menuItemMetaData.widget.isEnabled() : this.menu.isEnabled(menuItemMetaData.index)) ? 1 : 0;
            list.add(n2 != 0);
        }
    }

    private boolean isItemPositionValidForSDSNumber(MenuItemMetaData menuItemMetaData) {
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.contains(menuItemMetaData.index)) {
            return true;
        }
        if (menuViewport.isEmpty()) {
            return false;
        }
        return menuViewport.end.isBefore(menuItemMetaData.index);
    }

    private int[] layoutFocusCursor(MenuItemMetaData menuItemMetaData, float f2, int n) {
        float f3 = this.menu.getAnimationManager().getFocusCursorOffset();
        int n2 = this.menu.getMenuItemMargin(menuItemMetaData, true);
        int n3 = this.menu.getMenuItemMargin(menuItemMetaData, false);
        int n4 = this.menu.getMenuItemFilledInsets(menuItemMetaData, true);
        int n5 = this.menu.getMenuItemFilledInsets(menuItemMetaData, false);
        int n6 = Math.round(f2 + f3) + n2 - n4;
        int n7 = this.menu.getAnimationManager().getFocusCursorHeight();
        int n8 = n7 - n2 - n3 + n4 + n5;
        if (!this.getLayoutData().alignTop) {
            n6 -= n - 1;
        }
        this.lastFocusPosition = n6;
        this.lastFocusHeight = n8;
        int n9 = this.menu.getAnimationManager().getCursorBounceOffset();
        int n10 = this.menu.getKeyEventHandler().cursorSwipeOffset;
        int n11 = this.menu.getKeyEventHandler().cursorSwipeHeightOffset;
        int n12 = 0;
        int n13 = n6 + n10 - n12 + n9;
        int n14 = n8 + n11;
        AbstractWidget abstractWidget = this.menu.getChildOfRole(1);
        if (menuLayoutLogCh.isDebug()) {
            Object object;
            int n15 = n13 + Math.max(10, n14) - 1;
            String string = "Y: itemY(" + f2 + ") + animationOffset(" + f3 + ") + marginTop(" + n2 + ") - filledInsetsTop(" + n4 + ") + bounce(" + n9 + ") + swipeOffset(" + n10 + ") - swipeHeight/2(" + n12 + ")";
            String string2 = "Height: animHeight(" + n7 + ") + swipeHeight(" + n11 + ") - marginTop(" + n2 + ") - marginBottom(" + n3 + ") + filledInsetsTop(" + n4 + ") + filledInsetsBottom(" + n5 + ")";
            Buffer buffer = new Buffer();
            buffer.append(string).append(",    ").append(string2);
            if (abstractWidget instanceof FocusCursorController) {
                object = (FocusCursorController)abstractWidget;
                String string3 = "optionsInDrawer: " + this.menu.hasOptionsInDrawer() + ", optionsIconVisibleInViewSize: " + ((FocusCursorController)object).isOptionsIconVisibleForViewSize() + ", optionsIconVisible: " + ((FocusCursorController)object).isOptionsIconVisible();
                buffer.append(",   ").append(string3);
            }
            object = "y: " + n13 + " - " + n15 + " (height Max(" + n14 + ", " + 10 + ")";
            menuLayoutLogCh.log(10000000, "MenuLayout#layoutFocusCursor: focusCursorPosition: %1, focused item: %2, Details: %3", object, (Object)menuItemMetaData, (Object)buffer);
        }
        this.layoutCursor(1, 0, n13, n14);
        if (abstractWidget instanceof FocusCursorController) {
            FocusCursorController focusCursorController = (FocusCursorController)abstractWidget;
            focusCursorController.setBorderTopVisible(this.menu.getAnimationManager().getFocusCursorBorderVisible());
            focusCursorController.setBorderBottomVisible(this.menu.getAnimationManager().getFocusCursorBorderVisible());
            focusCursorController.setMoveMode(this.menu.hasMoveItem());
            focusCursorController.setOptionsIconVisibleForFocusedItem(this.menu.hasOptionsInDrawer());
            int n16 = 0;
            if (menuItemMetaData.widget instanceof IMenuItemSingle) {
                n16 = ((IMenuItemSingle)((Object)menuItemMetaData.widget)).getOptionIconYOffset();
            }
            focusCursorController.setOptionIconYOffset(n16);
        }
        return new int[]{n13, n14};
    }

    private void layoutSelectionCursor(MenuItemMetaData menuItemMetaData, int n, int n2) {
        menuLayoutLogCh.log(10000000, "MenuLayout#layoutSelectionCursor: selection cursor at position %2 for item: %1", (Object)menuItemMetaData, (long)n);
        int n3 = this.menu.getMenuItemMargin(menuItemMetaData, true);
        int n4 = this.menu.getMenuItemMargin(menuItemMetaData, false);
        int n5 = n + n3;
        int n6 = n2 - n3 - n4;
        this.layoutCursor(2, 0, n5, n6);
        this.layoutC2Icon(11, 0, n5);
    }

    private void layoutInfoline(MenuItemMetaData menuItemMetaData, int n, int n2) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.menu.getChildOfRole(13);
        if (abstractWidgetController == null) {
            return;
        }
        int n3 = n + (n2 - 1) - this.menu.getMenuItemMargin(menuItemMetaData, true);
        int n4 = this.menu.getAnimationManager().getInfolineHeight();
        int n5 = n3 - (n4 - 1);
        int n6 = this.getInfolineWidth();
        menuLayoutLogCh.log(10000000, "MenuLayout#layoutInfoline: infoline at position %2 for item: %1", (Object)menuItemMetaData, (long)n5);
        abstractWidgetController.setBounds(this.contentLeftOffset, n5, n6, n4);
        abstractWidgetController.setOnScreen(true);
    }

    private void layoutMoveItem(MenuLayoutTempData menuLayoutTempData, boolean bl) {
        MenuItemMetaData menuItemMetaData;
        if (!menuLayoutTempData.focusCursorVisible || menuLayoutTempData.focusCursorPosition == null) {
            return;
        }
        if (menuLayoutTempData.moveLayoutItem != null || !this.menu.hasMoveItem()) {
            this.destroyCachedMoveItem();
        }
        if (!this.menu.hasMoveItem()) {
            return;
        }
        if (menuLayoutTempData.moveLayoutItem == null) {
            this.prepareCachedMoveItem();
            if (this.moveItem == null) {
                return;
            }
            menuItemMetaData = this.moveItem;
        } else {
            menuItemMetaData = menuLayoutTempData.moveLayoutItem;
        }
        this.layoutMenuItemWidget(menuItemMetaData, menuLayoutTempData.focusCursorPosition[0], menuLayoutTempData.focusCursorPosition[1], menuItemMetaData.heightAfter, false, true, null, bl);
        if (menuItemMetaData != null && this.isSelected(menuItemMetaData)) {
            this.layoutSelectionCursor(menuItemMetaData, menuLayoutTempData.focusCursorPosition[0], menuLayoutTempData.focusCursorPosition[1]);
            menuLayoutTempData.selectionCursorVisible = true;
        }
    }

    private void prepareCachedMoveItem() {
        if (this.moveItem != null && this.moveItem.index.equals(this.menu.getMoveItemIndex())) {
            return;
        }
        this.destroyCachedMoveItem();
        this.moveItem = this.menu.createMenuItem(this.menu.getMoveItemIndex());
        if (this.moveItem == null) {
            menuLayoutLogCh.log(100000, "MenuLayout#layoutMoveItem: move item %1 can not be created", (Object)this.menu.getMoveItemIndex());
            return;
        }
    }

    private void destroyCachedMoveItem() {
        if (this.moveItem != null) {
            this.menu.destroyMenuItem(this.moveItem);
        }
        this.moveItem = null;
    }

    private boolean isSdsItem(MenuItemMetaData menuItemMetaData) {
        MenuSDSEventHandler menuSDSEventHandler = this.menu.getSdsEventHandler();
        if (menuSDSEventHandler != null) {
            return menuSDSEventHandler.isSdsItem(menuItemMetaData.index);
        }
        return false;
    }

    private void layoutScrollbar() {
        if (this.m_scrollbarLayoutMode == 0) {
            return;
        }
        AbstractWidget abstractWidget = this.menu.getChildOfRole(3);
        if (abstractWidget == null) {
            return;
        }
        if (!(abstractWidget instanceof ScrollbarController)) {
            menuLayoutLogCh.log(100000, "MenuLayout#layoutScrollbar: wrong scrollbar attached, not instance of ScrollbarController: %1", (Object)abstractWidget);
            return;
        }
        ScrollbarController scrollbarController = (ScrollbarController)abstractWidget;
        int n = this.m_scrollbarLayoutMode == 1 ? this.menu.getWidth() : 0;
        scrollbarController.setX(n + this.m_scrollbarOffset);
    }

    private int setupStroboscope(MenuLayoutTempData menuLayoutTempData, int n, int n2) {
        if (menuLayoutTempData.first) {
            int n3 = this.calculateStroboscopeAdjustment(n, n2);
            if (!menuLayoutTempData.alignTop) {
                n3 *= -1;
            }
            n += n3;
            menuLayoutTempData.yChild += (float)n3;
        }
        return n;
    }

    private int calculateStroboscopeAdjustment(int n, int n2) {
        int n3;
        boolean bl = this.stroboscopeActive;
        this.stroboscopeActive = this.shouldActivateStroboscope();
        if (bl != this.stroboscopeActive) {
            menuLogCh.log(10000000, "MenuLayout#adjustViewportOffsetForStroboscope: stroboscope state changed. now active: %1", this.stroboscopeActive);
        }
        if (!this.stroboscopeActive) {
            return 0;
        }
        long l = AbstractWidget.framework.getMonotonicTime();
        if (!bl) {
            n3 = 0;
            this.stroboscopeLastYPos = n;
        } else {
            n3 = (int)(l - this.stroboscopeLastTime);
        }
        this.stroboscopeLastTime = l;
        float f2 = this.menu.getAnimationManager().getScrollAnimationFunction().getSpeed();
        int n4 = n2 + this.getItemsGap();
        int n5 = this.menu.getFlatMenuItemCount();
        int n6 = this.calculateStroboscopeAdjustment(n, n3, f2, n4, n5);
        menuLayoutLogCh.log(10000000, "MenuLayout#adjustViewportOffsetForStroboscope: stroboscope adjustment: %1, itemY: %2, itemHeight: %3", (long)n6, (long)n, (long)n2);
        return n6;
    }

    int calculateStroboscopeAdjustment(int n, float f2, float f3, int n2, int n3) {
        float f4 = stroboscopeDefaultSpeedFactor / (float)n3;
        f4 = Math.min(f4, stroboscopeMaxSpeedFactor);
        float f5 = stroboscopeConstantSpeed * f2 + f4 * (f3 * f2) / (float)n2;
        if (this.menu.getAnimationManager().isViewportScrollingDownward()) {
            f5 *= -1.0f;
        }
        float f6 = n - this.stroboscopeLastYPos;
        f6 = f5 + (float)(n2 * (int)((f6 - f5) / (float)n2));
        f6 = (float)this.stroboscopeLastYPos + f6 - (float)n;
        this.stroboscopeLastYPos = (int)((float)n + f6);
        return (int)f6 - 1;
    }

    private boolean shouldActivateStroboscope() {
        if (!this.menu.getAnimationManager().isScrollAnimationRunning()) {
            return false;
        }
        MenuScrollAnimationFunction menuScrollAnimationFunction = this.menu.getAnimationManager().getScrollAnimationFunction();
        if (menuScrollAnimationFunction.isSlowScrollActive()) {
            return false;
        }
        float f2 = menuScrollAnimationFunction.getSpeed();
        float f3 = this.stroboscopeActive ? stroboscopeSpeedKeep : stroboscopeSpeedStart;
        return f2 > f3;
    }

    public boolean isStroboscopeActive() {
        return this.stroboscopeActive;
    }

    public boolean isVisible(int n, int n2) {
        if (n + n2 - 1 < 0) {
            return false;
        }
        return n <= this.menu.getHeight() - 1;
    }

    public float getVisibleRatio(MenuItemMetaData menuItemMetaData, int n, int n2) {
        if (n2 <= 0) {
            return 1.0f;
        }
        int n3 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData, true);
        int n4 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData, false);
        int n5 = n2 + n3 + n4;
        int n6 = n - n3;
        int n7 = n6 + n5 - 1;
        if (n6 < 0) {
            int n8 = Math.max(0, n7 + 1);
            return Math.min(1.0f, (float)n8 / (float)n5);
        }
        if (n7 > this.menu.getHeight() - 1) {
            int n9 = Math.max(0, this.menu.getHeight() - n6);
            return Math.min(1.0f, (float)n9 / (float)n5);
        }
        return 1.0f;
    }

    private void layoutMenuItemWidget(MenuItemMetaData menuItemMetaData, int n, int n2, int n3, boolean bl, boolean bl2, MenuItemMetaData menuItemMetaData2, boolean bl3) {
        MenuItemIndex menuItemIndex;
        int n4;
        int n5;
        MenuItemMetaData menuItemMetaData3;
        boolean bl4;
        if (!menuItemMetaData.isRealized() && !(bl4 = this.menu.realizeMenuItem(menuItemMetaData))) {
            menuLayoutLogCh.log(100000, "MenuLayout#layoutMenuItemWidget: can not realize item: %1, y: %2, height: %3", (Object)menuItemMetaData.index, (long)n, (long)n2);
            return;
        }
        AbstractWidgetController abstractWidgetController = menuItemMetaData.widget;
        MenuLayoutData menuLayoutData = this.getLayoutData();
        MenuItemMetaData menuItemMetaData4 = menuItemMetaData3 = menuLayoutData.alignTop ? menuItemMetaData2 : menuItemMetaData;
        if (bl) {
            int n6 = this.menu.getMenuItemMargin(menuItemMetaData, true);
            int n7 = this.menu.getMenuItemMargin(menuItemMetaData, false);
            n5 = menuItemMetaData.isMultiLine() ? this.menu.getMenuItemMargin(menuItemMetaData3, true) : n6;
            n += n5;
            n4 = -n6 - n7;
            if (this.hasInfoline(menuItemMetaData)) {
                n2 -= this.menu.getAnimationManager().getInfolineHeight();
                n3 -= Math.max(menuLayoutData.infolineHeightBefore, menuLayoutData.infolineHeightAfter);
            }
            n2 += n4;
            n3 += n4;
        }
        if (menuItemMetaData.isMultiLine() && abstractWidgetController instanceof IMenuItemMultiLine) {
            IMenuItemMultiLine iMenuItemMultiLine = (IMenuItemMultiLine)((Object)abstractWidgetController);
            n2 = menuItemMetaData2 == menuItemMetaData ? (n2 += iMenuItemMultiLine.getFilledInsets(true) + iMenuItemMultiLine.getFilledInsets(false)) : (n2 += abstractWidgetController.getHeight() + this.getItemsGap());
            iMenuItemMultiLine.setVisibleAreaBounds(n -= iMenuItemMultiLine.getFilledInsets(true), menuItemMetaData3.index.widgetPart, n2);
        } else {
            ((AbstractWidget)abstractWidgetController).setY(n);
            if (abstractWidgetController instanceof MenuItemController) {
                ((AbstractWidget)abstractWidgetController).setHeight(n3);
                ((MenuItemController)abstractWidgetController).setClippingHeight(n2);
            } else {
                ((AbstractWidget)abstractWidgetController).setHeight(n2);
            }
        }
        ((AbstractWidget)abstractWidgetController).setX(this.contentLeftOffset);
        if (this.menu.isComboBoxMenu() && abstractWidgetController instanceof MenuItemController) {
            if (((ComboBoxController)this.menu.getParent()).getType() == 1) {
                GridLayout gridLayout = (GridLayout)((MenuItemController)abstractWidgetController).getLayoutManager();
                ((AxisConstraints)gridLayout.getColumnConstraints()).gaps = new int[]{10, 5, 5, 20};
                ((AbstractWidget)abstractWidgetController).setWidth(20 + (this.menu.getWidth() - this.contentLeftOffset - this.getActiveContentRightOffset(this.shouldIncludeOptionsIconSpace(abstractWidgetController, bl3))));
            } else {
                GridLayout gridLayout = (GridLayout)((MenuItemController)abstractWidgetController).getLayoutManager();
                Layout layout = ((HMITerminalImpl)abstractWidgetController.getTerminal()).getLayout();
                n5 = layout.getIntegerConstant(33);
                n4 = layout.getIntegerConstant(35);
                int n8 = layout.getIntegerConstant(32);
                ((AxisConstraints)gridLayout.getColumnConstraints()).gaps = new int[]{n8 + n5 + n4, 5, 5, 20};
                ((AbstractWidget)abstractWidgetController).setWidth(n8 + n5 + n4 + 5 + 5 + 20 + (this.menu.getWidth() - this.contentLeftOffset - this.getActiveContentRightOffset(this.shouldIncludeOptionsIconSpace(abstractWidgetController, bl3))));
            }
        } else {
            ((AbstractWidget)abstractWidgetController).setWidth(this.menu.getWidth() - this.contentLeftOffset - this.getActiveContentRightOffset(this.shouldIncludeOptionsIconSpace(abstractWidgetController, bl3)));
        }
        float f2 = this.menu.getAnimationManager().getMenuItemRenderOpacity(menuItemMetaData);
        float f3 = this.menu.getViewSizeChangeContentOpacity() * this.getNowPlayingOpacity(menuItemMetaData) * f2;
        MenuItemIndex menuItemIndex2 = menuItemIndex = this.menu.hasMoveItem() ? this.menu.getMoveItemIndex() : this.menu.getFocusedIndex();
        if (menuItemMetaData.index.equals(menuItemIndex)) {
            float f4 = this.menu.getItemOpacityOptionDrawerOpen();
            f3 *= f4;
            AbstractWidget abstractWidget = this.menu.getChildOfRole(1);
            if (abstractWidget != null) {
                abstractWidget.setOpacity(f4);
            }
        } else {
            f3 *= this.menu.getOpenComboboxOpacity();
            if (this.menu.hasMoveItem()) {
                f3 *= 0.5f;
            }
        }
        abstractWidgetController.setOpacity(f3);
        this.menu.setMenuItemVisible(abstractWidgetController, f3 > 0.0f);
        if (abstractWidgetController instanceof MenuItemController) {
            MenuItemController menuItemController = (MenuItemController)abstractWidgetController;
            menuItemController.setMoving(bl2);
        }
        if (abstractWidgetController instanceof IMenuItemSingle) {
            IMenuItemSingle iMenuItemSingle = (IMenuItemSingle)((Object)abstractWidgetController);
            iMenuItemSingle.setOptionsIconSpace(bl3 ? this.optionsIconAdditionalRightInsets : 0);
        }
    }

    private float getNowPlayingOpacity(MenuItemMetaData menuItemMetaData) {
        if (this.menu instanceof NowPlayingMenuController) {
            NowPlayingMenuController nowPlayingMenuController = (NowPlayingMenuController)this.menu;
            if (nowPlayingMenuController.isNowPlayingItem(menuItemMetaData.index)) {
                return 1.0f;
            }
            return nowPlayingMenuController.getNowPlayingFadeOutOpacity();
        }
        return 1.0f;
    }

    private void hideMenuItemWidget(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2) {
        if (menuItemMetaData2 != null) {
            return;
        }
        if (menuItemMetaData.isRealized()) {
            menuLayoutLogCh.log(10000000, "MenuLayout#hideMenuItemWidget: hide item %1, because it's not visible", (Object)menuItemMetaData.index);
            this.menu.destroyMenuItem(menuItemMetaData);
        }
    }

    private void applyTabulators(boolean bl) {
        if (this.tabulatorIDs == null) {
            return;
        }
        for (int i2 = 0; i2 < this.tabulatorIDs.length; ++i2) {
            int n = this.calculateTabulatorValue(i2, bl);
            this.setTabulatorInMenuItem(this.tabulatorIDs[i2], n);
        }
    }

    private void setTabulatorInMenuItem(int n, int n2) {
        if (n2 == -1) {
            return;
        }
        Iterator iterator = this.getLayoutItems().iterator();
        while (iterator.hasNext()) {
            boolean bl;
            LayoutContainerController layoutContainerController;
            LayoutManager layoutManager;
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            if (!menuItemMetaData.isRealized() || !(menuItemMetaData.widget instanceof LayoutContainerController) || !((layoutManager = (layoutContainerController = (LayoutContainerController)menuItemMetaData.widget).getLayoutManager()) instanceof TabLayoutManager) || !(bl = ((TabLayoutManager)layoutManager).setTabulator(n, n2))) continue;
            layoutContainerController.invalidateChildrenBounds();
        }
    }

    protected List getLayoutItems() {
        return this.menu.getAnimationManager().getLayoutItems();
    }

    protected MenuLayoutData getLayoutData() {
        return this.menu.getAnimationManager().getLayoutData();
    }

    int calculateTabulatorValue(int n, boolean bl) {
        int n2;
        if (this.tabulatorSizes != null && this.tabulatorSizes[n] != -1) {
            return this.tabulatorSizes[n];
        }
        int n3 = -1;
        int n4 = -1;
        List list = this.menu.getChildren();
        for (n2 = 0; n2 < list.size(); ++n2) {
            AbstractWidget abstractWidget = (AbstractWidget)list.get(n2);
            if (!this.menu.isActiveMenuItem(abstractWidget) || !(abstractWidget instanceof IMenuItem)) continue;
            abstractWidget.setWidth(this.menu.getWidth() - this.contentLeftOffset - this.getActiveContentRightOffset(this.shouldIncludeOptionsIconSpace(abstractWidget, bl)));
            int n5 = ((IMenuItem)((Object)abstractWidget)).getSizeForTabulator(this.tabulatorIDs[n]);
            if (n5 == -1) continue;
            n4 = Math.max(n4, n5);
            n3 = n3 != -1 ? Math.min(n3, n5) : n5;
        }
        n2 = this.tabulatorAlignments != null ? this.tabulatorAlignments[n] : 1;
        switch (n2) {
            case 3: {
                return n4;
            }
            case 2: {
                return (n4 - n3) / 2;
            }
            case 1: {
                return n3;
            }
        }
        menuLayoutLogCh.log(100000, "MenuLayout#calculateTabulatorValue: Unknown tabulator alignment: %1, tabID: %2", (long)n2, (long)this.tabulatorIDs[n]);
        return n3;
    }

    private boolean isFocused(MenuItemMetaData menuItemMetaData) {
        return menuItemMetaData.index.equals(this.menu.getFocusedIndex()) && !menuItemMetaData.remove;
    }

    private boolean isSelected(MenuItemMetaData menuItemMetaData) {
        return menuItemMetaData.index.equals(this.menu.getSelectedIndex()) && !menuItemMetaData.remove;
    }

    private boolean hasInfoline(MenuItemMetaData menuItemMetaData) {
        return (menuItemMetaData.index.equals(this.menu.getInfolineItemIndex()) || menuItemMetaData.index.equals(this.menu.getPreviousInfolineItemIndex())) && !menuItemMetaData.remove;
    }

    private boolean isMoveItem(MenuItemMetaData menuItemMetaData) {
        return menuItemMetaData.index.equals(this.menu.getMoveItemIndex()) && !menuItemMetaData.remove;
    }

    private boolean isMoveGap(MenuItemMetaData menuItemMetaData, boolean bl, boolean bl2) {
        MenuItemIndex menuItemIndex;
        MenuItemIndex menuItemIndex2 = menuItemIndex = bl2 ? this.getLayoutData().moveGapIndexBefore : this.getLayoutData().moveGapIndexAfter;
        if (menuItemMetaData.remove || menuItemIndex == null || !this.menu.hasMoveItem()) {
            return false;
        }
        if (!menuItemMetaData.index.equals(menuItemIndex)) {
            return false;
        }
        boolean bl3 = menuItemIndex.isBefore(this.menu.getMoveItemIndex());
        return bl == bl3;
    }

    public int getMoveGapHeight() {
        if (!this.menu.hasMoveItem()) {
            return 0;
        }
        int n = this.menu.getMenuItemHeight(this.menu.getMoveItemIndex(), this.menu.isExpanded(this.menu.getMoveItemIndex()));
        return n + this.itemsGap;
    }

    private float calculateInitialMoveCursorGapOffset(MenuItemMetaData menuItemMetaData) {
        if (!this.menu.hasMoveItem()) {
            return 0.0f;
        }
        MenuLayoutData menuLayoutData = this.getLayoutData();
        MenuItemIndex menuItemIndex = menuItemMetaData.index;
        boolean bl = menuLayoutData.alignTop;
        float f2 = 0.0f;
        boolean bl2 = MenuLayoutData.isBefore(menuLayoutData.moveGapIndexBefore, menuItemIndex, bl);
        boolean bl3 = MenuLayoutData.isBefore(menuLayoutData.moveGapIndexAfter, menuItemIndex, bl);
        boolean bl4 = MenuLayoutData.isBefore(this.menu.getMoveItemIndex(), menuItemIndex, bl);
        if (bl2 && !bl4) {
            f2 += this.getMoveGapHeightBefore();
        }
        if (bl3 && !bl4) {
            f2 += this.getMoveGapHeightAfter();
        }
        if (!bl3 && bl4) {
            f2 -= this.getMoveGapHeightAfter();
        }
        if (!bl2 && bl4) {
            f2 -= this.getMoveGapHeightBefore();
        }
        return f2;
    }

    private float getMoveGapHeightBefore() {
        return (float)this.getMoveGapHeight() * (1.0f - this.menu.getAnimationManager().getMoveGapAnimationProgress());
    }

    private float getMoveGapHeightAfter() {
        return (float)this.getMoveGapHeight() * this.menu.getAnimationManager().getMoveGapAnimationProgress();
    }

    private void hideWidgetOfRole(int n) {
        AbstractWidget abstractWidget = this.menu.getChildOfRole(n);
        if (abstractWidget == null) {
            return;
        }
        abstractWidget.setOnScreen(false);
    }

    private void layoutCursor(int n, int n2, int n3, int n4) {
        this.assertCursorRole(n);
        AbstractWidget abstractWidget = this.menu.getChildOfRole(n);
        if (abstractWidget == null) {
            return;
        }
        boolean bl = n == 1;
        int n5 = bl ? this.focusCursorLeftOffset : this.selectionCursorLeftOffset;
        int n6 = bl ? this.focusCursorRightOffset : this.selectionCursorRightOffset;
        int n7 = Math.max(10, n4);
        if (this.isVisible(n3 - 2, n7 + 4)) {
            abstractWidget.setX(n2 + n5 + this.contentLeftOffset);
            abstractWidget.setY(n3);
            abstractWidget.setHeight(n7);
            abstractWidget.setWidth(this.menu.getWidth() - n5 - n6 - this.contentLeftOffset - this.getActiveContentRightOffset(true));
            boolean bl2 = bl ? this.menu.isFocusCursorVisible() : true;
            abstractWidget.setOnScreen(bl2);
        } else {
            abstractWidget.setOnScreen(false);
        }
    }

    public boolean isFocusCursorVisible() {
        AbstractWidget abstractWidget = this.menu.getChildOfRole(1);
        return abstractWidget != null && abstractWidget.isOnScreen();
    }

    private void layoutC2Icon(int n, int n2, int n3) {
        AbstractWidget abstractWidget = this.menu.getChildOfRole(n);
        if (abstractWidget == null) {
            return;
        }
        Layout layout = ((HMITerminalImpl)abstractWidget.getTerminal()).getLayout();
        abstractWidget.setX(n2 + layout.getIntegerConstant(33));
        abstractWidget.setY(n3 + layout.getIntegerConstant(11));
        abstractWidget.setHeight(((AbstractWidgetController)abstractWidget).getPreferredHeight());
        abstractWidget.setWidth(((AbstractWidgetController)abstractWidget).getPreferredWidth());
        abstractWidget.setOnScreen(true);
    }

    private void assertCursorRole(int n) {
        if (n != 1 && n != 2) {
            throw new IllegalArgumentException("Illegal role: " + n);
        }
    }

    private void layoutBackground() {
        AbstractWidget abstractWidget = this.menu.getChildOfRole(4);
        if (abstractWidget == null) {
            return;
        }
        int n = this.backgroundHeight > 0 ? this.backgroundHeight : this.menu.getHeight();
        if (this.backgroundBounds == null) {
            int n2 = this.menu.getWidth() - this.backgroundXOffset;
            abstractWidget.setBounds(this.backgroundXOffset, this.backgroundY, n2, n);
        } else {
            int n3 = this.backgroundBounds.getX() - this.menu.getX();
            int n4 = this.backgroundBounds.getY() - this.menu.getY();
            int n5 = this.backgroundBounds.getWidth() - this.backgroundXOffset;
            int n6 = this.backgroundBounds.getHeight();
            abstractWidget.setBounds(n3, n4, n5, n6);
        }
    }

    private void layoutSdsNumbers(IntList intList, List list) {
        AbstractWidget abstractWidget = this.menu.getChildOfRole(6);
        if (abstractWidget == null) {
            return;
        }
        if (!(abstractWidget instanceof MenuSDSNumbersController)) {
            menuLayoutLogCh.log(100000, "MenuLayout#layoutSdsNumbers: SDSNumbersWidget is not a MenuSDSNumbersController: %1", (Object)abstractWidget);
            return;
        }
        MenuSDSNumbersController menuSDSNumbersController = (MenuSDSNumbersController)abstractWidget;
        if (this.menu.isSDSActive() && intList != null && list != null) {
            int n;
            int[] nArray = intList.toArray();
            boolean[] blArray = new boolean[list.size()];
            for (n = 0; n < blArray.length; ++n) {
                blArray[n] = (Boolean)list.get(n);
            }
            if (!this.getLayoutData().alignTop) {
                for (n = 0; n < nArray.length / 2; ++n) {
                    int n2 = nArray[n];
                    nArray[n] = nArray[nArray.length - n - 1];
                    nArray[nArray.length - n - 1] = n2;
                    boolean bl = blArray[n];
                    blArray[n] = blArray[blArray.length - n - 1];
                    blArray[blArray.length - n - 1] = bl;
                }
            }
            menuSDSNumbersController.setNumberPositionsY(nArray);
            menuSDSNumbersController.setNumbersEnabled(blArray);
            n = 0;
            menuSDSNumbersController.setBounds(n, 0, this.menu.getWidth(), this.menu.getHeight());
            menuSDSNumbersController.setNumbersOpacity(this.getSdsNumbersOpacity());
            menuSDSNumbersController.setOnScreen(true);
            menuSDSNumbersController.setCompositesDirty(true);
        } else {
            menuSDSNumbersController.setNumberPositionsY(null);
            menuSDSNumbersController.setNumbersEnabled(null);
            menuSDSNumbersController.setOnScreen(false);
        }
    }

    private MenuLayoutTempData createTempData() {
        boolean bl = this.getLayoutData().alignTop;
        int n = this.menu.getAnimationManager().getViewportOffset();
        if (!bl) {
            n *= -1;
        }
        float f2 = n + this.getContentInsetsVert();
        return new MenuLayoutTempData(bl, n, f2);
    }

    private void orderVisibleEdges(MenuLayoutTempData menuLayoutTempData) {
        if (!menuLayoutTempData.alignTop) {
            int n = this.firstVisibleItem;
            this.firstVisibleItem = this.lastVisibleItem;
            this.lastVisibleItem = n;
        }
    }

    private void logLayout(MenuLayoutTempData menuLayoutTempData) {
        if (menuLayoutLogCh.isDebug()) {
            List list = this.getLayoutItems();
            Object object = list.isEmpty() ? null : (menuLayoutTempData.alignTop ? list.get(0) : list.get(list.size() - 1));
            Object object2 = this.firstVisibleItem != -1 && list.size() > this.firstVisibleItem ? list.get(this.firstVisibleItem) : null;
            Object object3 = this.lastVisibleItem != -1 && list.size() > this.lastVisibleItem ? list.get(this.lastVisibleItem) : null;
            String string = "first visible: " + object2 + " with " + this.firstItemVisibleRatio + " %, last visible: " + object3 + " with " + this.lastItemVisibleRatio + " %";
            menuLayoutLogCh.log(10000000, "MenuLayout#layout: first item: %1 at %3. %2", object, (Object)string, (long)menuLayoutTempData.viewportOffset);
        }
    }

    private void showStatistics() {
        if (!SHOW_STATISTICS) {
            return;
        }
        float f2 = this.menu.getAnimationManager().getScrollAnimationFunction().getSpeed();
        f2 = (float)((int)(f2 * 100.0f)) / 100.0f;
        String[] stringArray = new String[]{"Scroll speed: " + f2 + " px/ms", "Stroboscope: " + this.stroboscopeActive};
        this.menu.getTerminal().getStatistics().showStatistics(18, stringArray, false);
    }

    private float getSdsNumbersOpacity() {
        if (this.menu.getAnimationManager().isScrollAnimationRunning()) {
            return 0.0f;
        }
        return 1.0f;
    }

    public int getContentAreaHeight() {
        return this.menu.getHeight() - this.getContentInsetsVert() * 2;
    }

    public int getActiveContentRightOffset(boolean bl) {
        if (AbstractWidget.isScreenResolution1440() && this.menu.isConnected() && this.isSmallStage()) {
            if (this.contentRightOffsetSmallStage != -1) {
                return this.contentRightOffsetSmallStage;
            }
            return this.contentRightOffset;
        }
        if (bl) {
            return this.contentRightOffset;
        }
        return this.contentRightOffset + this.optionsIconAdditionalRightInsets;
    }

    private boolean isSmallStage() {
        ExtHMITerminalEvo extHMITerminalEvo = (ExtHMITerminalEvo)this.menu.getTerminal();
        ViewSizeManager viewSizeManager = (ViewSizeManager)extHMITerminalEvo.getViewSizeManager();
        ViewSizeAnimationManager viewSizeAnimationManager = viewSizeManager.getViewSizeAnimationManager();
        float[] fArray = viewSizeAnimationManager.getCurrentWeights();
        int n = Math.round(fArray[0]);
        return (float)n == ScreenWidgetEVO.SMALL_STAGE[0];
    }

    public boolean isOptionsIconVisible() {
        AbstractWidget abstractWidget = this.menu.getChildOfRole(1);
        if (abstractWidget instanceof FocusCursorController) {
            FocusCursorController focusCursorController = (FocusCursorController)abstractWidget;
            return focusCursorController.shouldShowOptionsIconForAnyItem();
        }
        return false;
    }

    public boolean shouldIncludeOptionsIconSpace(AbstractWidget abstractWidget) {
        return this.shouldIncludeOptionsIconSpace(abstractWidget, this.isOptionsIconVisible());
    }

    private boolean shouldIncludeOptionsIconSpace(AbstractWidget abstractWidget, boolean bl) {
        if (!bl) {
            return true;
        }
        return abstractWidget instanceof TouchController || abstractWidget instanceof MenuItemController || abstractWidget instanceof IMenuItemMultiItem || abstractWidget instanceof MultiLineMenuItemController || abstractWidget instanceof MultilineTextFieldController;
    }

    public int[] getFocusCursorDistanceFromGlassplate() {
        if (this.lastFocusHeight == 0 && this.lastFocusPosition == 0) {
            return null;
        }
        int[] nArray = new int[2];
        int n = this.lastFocusPosition + this.lastFocusHeight - 1;
        int n2 = this.menu.getHeight() - 1 - n;
        nArray[0] = this.lastFocusPosition;
        nArray[1] = n2;
        return nArray;
    }

    public MenuViewport getCurrentViewport() {
        if (this.firstVisibleItem == -1 || this.lastVisibleItem == -1) {
            return new MenuViewport(null, null);
        }
        List list = this.getLayoutItems();
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)list.get(this.firstVisibleItem);
        MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)list.get(this.lastVisibleItem);
        return new MenuViewport(menuItemMetaData.index, menuItemMetaData2.index);
    }

    public MenuItemMetaData getCurrentItemUnderFocus(boolean bl) {
        ListIterator listIterator;
        if (this.lastFocusHeight == 0 && this.lastFocusPosition == 0) {
            return null;
        }
        int n = this.lastFocusPosition + this.lastFocusHeight - 1;
        if (n < 0 || this.lastFocusPosition > this.menu.getHeight()) {
            return null;
        }
        List list = this.getLayoutItems();
        if (list.isEmpty()) {
            return null;
        }
        boolean bl2 = false;
        ListIterator listIterator2 = listIterator = bl ? list.listIterator() : list.listIterator(list.size());
        while (MenuLayoutData.hasNext(listIterator, bl)) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)MenuLayoutData.next(listIterator, bl);
            if (menuItemMetaData.isRealized()) {
                boolean bl3;
                boolean bl4;
                int n2 = menuItemMetaData.widget.getY();
                if (n2 == this.lastFocusPosition) {
                    return menuItemMetaData;
                }
                boolean bl5 = bl4 = n2 < this.lastFocusPosition;
                boolean bl6 = bl ? !bl4 : (bl3 = bl4);
                if (bl3) {
                    return menuItemMetaData;
                }
                int n3 = n2 + menuItemMetaData.widget.getHeight() - 1;
                bl2 = n2 <= n && n3 >= this.lastFocusPosition;
                continue;
            }
            if (!bl2) continue;
            return menuItemMetaData;
        }
        menuLogCh.log(100000, "MenuLayout#getCurrentItemUnderFocus: no item under focus found. Cursor pos: %3, downward: %1, layoutItems: %2", (Object)bl, (Object)list, (long)this.lastFocusPosition);
        return null;
    }

    public int getContentInsetsVert() {
        return this.backgroundInsetsVert;
    }

    public int getItemsGap() {
        return this.itemsGap;
    }

    public int getFocusCursorXOffset() {
        return this.focusCursorLeftOffset;
    }

    public void setFocusCursorXOffset(int n) {
        this.focusCursorLeftOffset = n;
    }

    public int getSelectionCursorXOffset() {
        return this.selectionCursorLeftOffset;
    }

    public void setSelectionCursorXOffset(int n) {
        this.selectionCursorLeftOffset = n;
    }

    public int getBackgroundXOffset() {
        return this.backgroundXOffset;
    }

    public void setBackgroundXOffset(int n) {
        this.backgroundXOffset = n;
    }

    public int getContentLeftOffset() {
        return this.contentLeftOffset;
    }

    public void setScrollbarLayoutMode(int n) {
        this.m_scrollbarLayoutMode = AnimUtils.clamp(0, 2, n);
    }

    public int getScrollbarLayoutMode() {
        return this.m_scrollbarLayoutMode;
    }

    public void setScrollbarOffset(int n) {
        this.m_scrollbarOffset = n;
    }

    public int getScrollbarOffset() {
        return this.m_scrollbarOffset;
    }

    public void setContentLeftOffset(int n) {
        this.contentLeftOffset = n;
    }

    public void setContentRightOffset(int n) {
        this.contentRightOffset = n;
    }

    public int getContentRightOffset() {
        return this.contentRightOffset;
    }

    public int getContentWidth() {
        return this.menu.getWidth() - this.contentLeftOffset - this.getActiveContentRightOffset(true);
    }

    public int getInfolineWidth() {
        return this.getContentWidth();
    }

    public void setItemsGap(int n) {
        this.itemsGap = n;
    }

    public int[] getTabulatorIDs() {
        return this.tabulatorIDs;
    }

    public void setTabulatorIDs(int[] nArray) {
        this.tabulatorIDs = nArray;
    }

    public int[] getTabulatorAlignments() {
        return this.tabulatorAlignments;
    }

    public void setTabulatorAlignments(int[] nArray) {
        this.tabulatorAlignments = nArray;
    }

    public int[] getTabulatorSizes() {
        return this.tabulatorSizes;
    }

    public void setTabulatorSizes(int[] nArray) {
        this.tabulatorSizes = nArray;
    }

    public void setBackgroundInsetsVert(int n) {
        this.backgroundInsetsVert = n;
    }

    public int getSdsNumbersGlasplateGap() {
        return this.sdsNumbersGlasplateGap;
    }

    public void setSdsNumbersGlasplateGap(int n) {
        this.sdsNumbersGlasplateGap = n;
    }

    public int getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public int getLastVisibleItem() {
        return this.lastVisibleItem;
    }

    public int getSelectionCursorLeftOffset() {
        return this.selectionCursorLeftOffset;
    }

    public void setSelectionCursorLeftOffset(int n) {
        this.selectionCursorLeftOffset = n;
    }

    public int getSelectionCursorRightOffset() {
        return this.selectionCursorRightOffset;
    }

    public void setSelectionCursorRightOffset(int n) {
        this.selectionCursorRightOffset = n;
    }

    public int getContentRightOffsetSmallStage() {
        return this.contentRightOffsetSmallStage;
    }

    public void setContentRightOffsetSmallStage(int n) {
        this.contentRightOffsetSmallStage = n;
    }

    public int getOptionsIconAdditionalRightInsets() {
        return this.optionsIconAdditionalRightInsets;
    }

    public void setOptionsIconAdditionalRightInsets(int n) {
        this.optionsIconAdditionalRightInsets = n;
    }

    public int getLastFocusPosition() {
        return this.lastFocusPosition;
    }

    public int getLastFocusHeight() {
        return this.lastFocusHeight;
    }

    public float getFirstItemVisibleRatio() {
        return this.firstItemVisibleRatio;
    }

    public float getLastItemVisibleRatio() {
        return this.lastItemVisibleRatio;
    }

    public MenuItemMetaData getMoveItem() {
        return this.moveItem;
    }

    public void setBackgroundBounds(RectangleParameters rectangleParameters) {
        this.backgroundBounds = rectangleParameters;
        this.layoutBackground();
    }

    public void setBackgroundVerticalDimension(int n, int n2) {
        this.backgroundY = n;
        this.backgroundHeight = n2;
    }

    static class MenuLayoutTempData {
        boolean first = true;
        boolean focusCursorVisible = false;
        boolean selectionCursorVisible = false;
        boolean infolineVisible = false;
        int[] focusCursorPosition = null;
        float moveCursorGapOffset = 0.0f;
        int multiLineY = 0;
        MenuItemMetaData multiLineStartItem = null;
        MenuItemMetaData moveLayoutItem = null;
        float yChild;
        final int viewportOffset;
        final boolean alignTop;

        public MenuLayoutTempData(boolean bl, int n, float f2) {
            this.alignTop = bl;
            this.viewportOffset = n;
            this.yChild = f2;
        }
    }
}

