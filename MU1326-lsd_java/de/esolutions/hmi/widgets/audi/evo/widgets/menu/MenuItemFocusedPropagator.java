/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.MenuModelGUI;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import java.util.Iterator;

public class MenuItemFocusedPropagator
implements IWidgetLogChannel,
WidgetConstants {
    private final MenuController menu;
    private MenuItemIndex focusedIndexFiredToModel;
    private Long focusedUniqueIdFiredToModel;
    private MenuItemIndex focusedIndexFiredToWidgets;
    private MenuItemIndex focusedIndexFiredToCallbacks;

    public MenuItemFocusedPropagator(MenuController menuController) {
        this.menu = menuController;
    }

    public void initialize() {
        this.focusedIndexFiredToWidgets = null;
        this.focusedIndexFiredToModel = null;
        this.focusedUniqueIdFiredToModel = null;
    }

    public void initializeItemsFocusedFlag(MenuItemIndex menuItemIndex) {
        int n = 0;
        Iterator iterator = this.menu.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (this.menu.isMenuItem(abstractWidget)) {
                boolean bl = menuItemIndex != null && menuItemIndex.widget == n;
                this.callSetFocused(abstractWidget, bl);
            }
            ++n;
        }
    }

    public void prepareForRemove() {
        this.focusedIndexFiredToWidgets = null;
        this.focusedIndexFiredToModel = null;
        this.focusedUniqueIdFiredToModel = null;
    }

    public void adjustForRemoveMenuChild(int n) {
        if (this.focusedIndexFiredToCallbacks != null) {
            this.focusedIndexFiredToCallbacks = this.focusedIndexFiredToCallbacks.adjustForRemoveMenuChild(n);
        }
        if (this.focusedIndexFiredToWidgets != null) {
            this.focusedIndexFiredToWidgets = this.focusedIndexFiredToWidgets.adjustForRemoveMenuChild(n);
        }
        if (this.focusedIndexFiredToModel != null) {
            this.focusedIndexFiredToModel = this.focusedIndexFiredToModel.adjustForRemoveMenuChild(n);
            if (this.focusedIndexFiredToModel == null) {
                this.focusedUniqueIdFiredToModel = null;
            }
        }
    }

    public void focusedIndexChanged(MenuItemIndex menuItemIndex) {
        boolean bl;
        if (this.shouldFireNotFocusedToItemOnAnimationStart()) {
            this.fireItemNotFocusedToItem();
        }
        if (!(bl = Util.equals(menuItemIndex, this.menu.getFocusedIndex())) && this.menu.isFireNotFocusedToModelOnAnimationStart()) {
            this.fireItemFocusedToModel(null, null);
        }
        this.fireItemFocusStartToCallbacks(menuItemIndex);
    }

    public void fireItemFocused() {
        if (!this.menu.isConnectedSubtree()) {
            return;
        }
        this.fireItemFocusedInternal();
    }

    void fireItemFocusedDuringConnect() {
        this.fireItemFocusedInternal();
    }

    private void fireItemFocusedInternal() {
        if (!this.menu.shouldRender()) {
            menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemFocusedInternal: dont fire itemfocused for item %1, because menu not visible (%2)", (Object)this.menu.getFocusedIndex(), (Object)this.menu);
            return;
        }
        this.fireItemFocusedToModel();
        this.fireItemFocusedToWidgets();
        this.fireItemFocusedToCallbacks();
    }

    private void fireItemFocusedToModel() {
        Long l = this.calculateUniqueIDForFocus();
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        this.fireItemFocusedToModel(menuItemIndex, l);
    }

    private void fireItemFocusedToModel(MenuItemIndex menuItemIndex, Long l) {
        if (Util.equals(menuItemIndex, this.focusedIndexFiredToModel) && Util.equals(l, this.focusedUniqueIdFiredToModel)) {
            return;
        }
        if (menuItemIndex != null) {
            if (this.isUniqueIdOfPendingListRow(l)) {
                menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemFocusedToModel: don't fire itemFocused, because rowId is not available for focused index: %1 (%2)", (Object)menuItemIndex, (Object)this.menu);
                return;
            }
            int n = this.menu.getMenuItemID(menuItemIndex);
            WidgetFocusAdvice widgetFocusAdvice = this.menu.createFocusAdviceForCursorPosition();
            this.focusedIndexFiredToModel = menuItemIndex;
            this.focusedUniqueIdFiredToModel = l;
            this.fireItemFocusedToModel(n, l, widgetFocusAdvice);
        } else {
            this.focusedIndexFiredToModel = menuItemIndex;
            this.focusedUniqueIdFiredToModel = l;
            this.fireItemNotFocusedToModel();
        }
    }

    private boolean isUniqueIdOfPendingListRow(Long l) {
        return l == null;
    }

    private boolean isListRowPending() {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        if (menuItemIndex == null) {
            return false;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.menu.getChild(menuItemIndex.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            Long l = ((IMenuItemMultiItem)((Object)abstractWidgetController)).getUniqueIDForItemIndex(menuItemIndex.widgetPart);
            return this.isUniqueIdOfPendingListRow(l);
        }
        return false;
    }

    private Long calculateUniqueIDForFocus() {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        if (menuItemIndex == null) {
            return null;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.menu.getChild(menuItemIndex.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidgetController)).getUniqueIDForItemIndex(menuItemIndex.widgetPart);
        }
        return Util.createLong(-1L);
    }

    private void fireItemFocusedToModel(int n, long l, WidgetFocusAdvice widgetFocusAdvice) {
        Object object = this.menu.getModel();
        if (object instanceof MenuModelGUI) {
            menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemFocusedToModel: notify menuModel, item: %2, rowID: %3, focusAdvice: %1", (Object)widgetFocusAdvice, (long)n, l);
            ((MenuModelGUI)object).itemFocused(n, widgetFocusAdvice, l, this.menu.getTerminal().getTerminalID());
        } else if (this.menu.isComboBoxMenu()) {
            this.menu.getParentComboBox().menuItemFocused(n);
        }
    }

    private void fireItemNotFocusedToModel() {
        Object object = this.menu.getModel();
        if (object instanceof MenuModelGUI) {
            menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemNotFocusedToModel: no focused item for menu model.");
            ((MenuModelGUI)object).itemFocused(-1, null, -1L, this.menu.getTerminal().getTerminalID());
        } else if (this.menu.isComboBoxMenu()) {
            this.menu.getParentComboBox().menuItemFocusCleared();
        }
    }

    private void fireItemFocusedToWidgets() {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        if (Util.equals(menuItemIndex, this.focusedIndexFiredToWidgets)) {
            return;
        }
        this.fireItemNotFocusedToItem();
        this.focusedIndexFiredToWidgets = menuItemIndex;
        this.fireItemFocusedToItem();
        this.menu.updateFocusedPropertyObject();
        this.closeFocusedRelatedPopup();
        this.menu.restartFocusDetailTimers();
    }

    private void fireItemNotFocusedToItem() {
        if (this.shouldFireItemNotFocusedToItem()) {
            AbstractWidget abstractWidget = this.menu.getChild(this.focusedIndexFiredToWidgets.widget);
            menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemNotFocusedToItem: un-focus previously focused item: %1, widget: %2", (Object)this.focusedIndexFiredToWidgets, (Object)abstractWidget);
            if (abstractWidget instanceof IMenuItemMultiItem) {
                ((IMenuItemMultiItem)((Object)abstractWidget)).itemFocused(-1);
            } else {
                this.callSetFocused(abstractWidget, false);
            }
            this.focusedIndexFiredToWidgets = null;
        }
    }

    private void fireItemFocusedToItem() {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        if (menuItemIndex == null) {
            menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemFocusedToItem: no item is focused");
            return;
        }
        AbstractWidget abstractWidget = this.menu.getChild(menuItemIndex.widget);
        menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemFocusedToItem: notify focused item %1, widget: %2", (Object)menuItemIndex, (Object)abstractWidget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            ((IMenuItemMultiItem)((Object)abstractWidget)).itemFocused(menuItemIndex.widgetPart);
        } else {
            this.callSetFocused(abstractWidget, true);
        }
    }

    private void callSetFocused(AbstractWidget abstractWidget, boolean bl) {
        if (abstractWidget instanceof IMenuItemSingle) {
            abstractWidget.setFocused(bl);
        }
    }

    private void closeFocusedRelatedPopup() {
        int n = this.menu.getOpenFocusRelatedPartialPopup();
        if (n != -1) {
            menuLogCh.log(1078071040, "MenuItemFocusedPropagator#closeFocusedRelatedPopup: close focus related popup: %1", (long)n);
            this.menu.getTerminal().getPartialPopupManager().hidePopup(n);
        }
    }

    private void fireItemFocusStartToCallbacks(MenuItemIndex menuItemIndex) {
        this.menu.notifyCallbacksFocusChanged(menuItemIndex);
        this.focusedIndexFiredToCallbacks = null;
    }

    private void fireItemFocusedToCallbacks() {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        if (this.isListRowPending()) {
            menuLogCh.log(-2137614336, "MenuItemFocusedPropagator#fireItemFocusedToCallbacks: don't fire itemFocused, because list row %1 is not yet loaded (%2)", (Object)menuItemIndex, (Object)this.menu);
            return;
        }
        if (Util.equals(menuItemIndex, this.focusedIndexFiredToCallbacks)) {
            return;
        }
        this.focusedIndexFiredToCallbacks = menuItemIndex;
        this.menu.notifyCallbacksFocusChangeFinished();
    }

    private boolean shouldFireNotFocusedToItemOnAnimationStart() {
        if (this.focusedIndexFiredToWidgets == null) {
            return false;
        }
        AbstractWidget abstractWidget = this.menu.getChild(this.focusedIndexFiredToWidgets.widget);
        return abstractWidget instanceof IMenuItemSingle;
    }

    private boolean shouldFireItemNotFocusedToItem() {
        if (this.focusedIndexFiredToWidgets == null) {
            return false;
        }
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        if (menuItemIndex == null) {
            return true;
        }
        return menuItemIndex.widget != this.focusedIndexFiredToWidgets.widget;
    }
}

