/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.CoverStackController;
import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.FolderOpenFocusAdvice;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;

public class MenuModelEventHandler
implements IWidgetLogChannel,
WidgetConstants {
    private final MenuController menu;
    private final ListController listWidget;
    private final int listWidgetIndex;
    private final ModelUpdateEvent event;
    private boolean requiredSelectionUpdate = false;
    private boolean requiredItemsRefresh = false;
    private boolean requiredViewportUpdate = false;
    private MenuUpdateRequest.IMenuItemMatcher requiredUpdateItems = MenuUpdateRequest.UPDATE_NONE;
    private MenuItemIndex requestedFocusedIndex = null;
    private FocusAdvice focusAdvice;
    private boolean refreshImmediately = false;
    private Boolean nowPlayingModeChange = null;
    private final boolean oldNowPlayingModeActive;
    private final boolean oldFocusedItemExpanded;
    private boolean mergeCursors = false;
    static /* synthetic */ Class class$de$audi$atip$hmi$model$menu$focus$WidgetFocusAdvice;

    public MenuModelEventHandler(MenuController menuController, ModelUpdateEvent modelUpdateEvent) {
        this.event = modelUpdateEvent;
        this.menu = menuController;
        this.listWidget = null;
        this.listWidgetIndex = -1;
        this.oldNowPlayingModeActive = this.isNowPlayingModeActive(menuController);
        this.oldFocusedItemExpanded = menuController.hasExpandedItem();
    }

    public MenuModelEventHandler(MenuController menuController, ListController listController, ModelUpdateEvent modelUpdateEvent) {
        this.event = modelUpdateEvent;
        this.menu = menuController;
        this.listWidget = listController;
        this.listWidgetIndex = menuController.getChildren().indexOf(listController);
        this.oldNowPlayingModeActive = this.isNowPlayingModeActive(menuController);
        this.oldFocusedItemExpanded = menuController.hasExpandedItem();
    }

    private boolean isNowPlayingModeActive(MenuController menuController) {
        return menuController instanceof NowPlayingMenuController && ((NowPlayingMenuController)menuController).isNowPlayingActive();
    }

    public void processEvent() {
        if (this.listWidget != null) {
            if (this.listWidgetIndex == -1) {
                menuLogCh.log(100000, "MenuModelEventHandler#processEvent: The list is not a child of the menu. List: %1: Menu: %2", (Object)this.listWidget, (Object)this.menu);
                return;
            }
            menuLogCh.log(10000000, "MenuModelEventHandler#processEvent: model event from list %3, event type: %2 (%1)", (Object)this.menu, (long)this.event.getUpdateType(), (long)this.listWidgetIndex);
        } else {
            menuLogCh.log(10000000, "MenuModelEventHandler#processEvent: model event from menu, event type: %2 (%1)", (Object)this.menu, (long)this.event.getUpdateType());
        }
        this.menu.updatePreferredSize();
        if (this.menu.tryPostponeRefresh()) {
            menuLogCh.log(10000000, "MenuModelEventHandler#processEvent: postpone refresh (%1)", (Object)this.menu);
            return;
        }
        this.event.consume();
        CoverStackController coverStackController = this.menu.getCoverStack();
        if (coverStackController != null) {
            coverStackController.setUpdateState(false);
        }
        MenuUpdateDelta menuUpdateDelta = this.createUpdateDelta();
        this.focusAdvice = this.menu.createFocusAdviceForCursorPosition();
        long l = this.getCurrentTime();
        this.menu.getAnimationManager().adjustAnimationStartValuesForRestart(true, l);
        boolean bl = this.menu.getAnimationManager().isScrollingControlledBySeparateAnimation();
        if (this.event.getModelType() == 100) {
            this.processModelGroupEvent(this.event, menuUpdateDelta);
        } else {
            this.processSingleModelEvent(this.event, menuUpdateDelta);
        }
        this.processSelectionUpdate(menuUpdateDelta);
        this.applyCursorMergeChange();
        this.refreshItemsAfterEvents(menuUpdateDelta, bl, l);
        this.processCursorMerge();
        this.restoreFocusedItemExpansion();
        this.menu.updateInfoline();
        this.processNowPlayingModeChanges();
        this.menu.clearAllCaches();
        if (!this.menu.getAnimationManager().isScrollAnimationRunning()) {
            this.menu.getItemFocusedPropagator().fireItemFocused();
        }
        this.menu.updateFocusedPropertyObject();
        this.menu.updateOptionDrawerFocusedProperty();
        if (coverStackController != null) {
            coverStackController.setUpdateState(true);
        }
        menuLogCh.log(10000000, "MenuModelEventHandler#processEvent: finished event processing. (%1)", (Object)this.menu);
    }

    private void applyCursorMergeChange() {
        if (this.menu.isRadiotextMenu()) {
            this.focusAdvice = this.menu.createFocusAdviceForCursorPosition();
            menuLogCh.log(10000000, "MenuModelEventHandler#applyCursorMergeChange: radiotext new focusAdvice: %1", (Object)this.focusAdvice);
        }
    }

    private void refreshItemsAfterEvents(MenuUpdateDelta menuUpdateDelta, boolean bl, long l) {
        if (this.requiredViewportUpdate) {
            this.menu.getAnimationManager().refresh(this.createUpdateRequest(menuUpdateDelta, this.focusAdvice), menuUpdateDelta, this.refreshImmediately, bl);
        } else if (this.requiredItemsRefresh) {
            this.menu.getAnimationManager().refreshItemsForFastUpdate(this.createUpdateRequest(menuUpdateDelta, this.focusAdvice), menuUpdateDelta, this.refreshImmediately, bl);
        } else if (this.requestedFocusedIndex != null) {
            this.menu.getAnimationManager().focus(this.createUpdateRequest(menuUpdateDelta, this.focusAdvice), true, true, l);
            this.menu.getKeyEventHandler().clearCache();
        } else {
            this.menu.getAnimationManager().refreshAnimations(bl);
        }
    }

    private MenuUpdateRequest createUpdateRequest(MenuUpdateDelta menuUpdateDelta, FocusAdvice focusAdvice) {
        return new MenuUpdateRequest(this.getFocusedIndexForRefresh(menuUpdateDelta), focusAdvice, this.requiredUpdateItems);
    }

    private MenuItemIndex getFocusedIndexForRefresh(MenuUpdateDelta menuUpdateDelta) {
        if (this.requestedFocusedIndex != null) {
            return this.requestedFocusedIndex;
        }
        MenuItemIndex menuItemIndex = menuUpdateDelta.getOldFocusedIndex();
        if (menuItemIndex == null) {
            return null;
        }
        Long l = this.menu.getFocusedUniqueID();
        MenuItemIndex menuItemIndex2 = this.menu.getMenuItemIndexForUniqueID(l, menuItemIndex);
        if (!Util.equals(menuItemIndex, menuItemIndex2)) {
            menuLogCh.log(100000, "MenuModelEventHandler#getFocusedIdForRefresh: expected item %1, but found item %2 for row ID %3", (Object)menuItemIndex, (Object)menuItemIndex2, (Object)l);
        }
        return menuItemIndex2;
    }

    private MenuUpdateDelta createUpdateDelta() {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        MenuItemMetaData menuItemMetaData = this.menu.getAnimationManager().getLayoutData().findAnimationItem(menuItemIndex);
        return new MenuUpdateDelta(this.menu.getViewport(), menuItemIndex, menuItemMetaData, this.menu.getSelectedIndex());
    }

    private void processModelGroupEvent(ModelUpdateEvent modelUpdateEvent, MenuUpdateDelta menuUpdateDelta) {
        ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
        menuLogCh.log(10000000, "MenuModelEventHandler#processModelGroupEvent: Start processing ModelGroupEvent: %1 with %2 nested events", (Object)modelUpdateEvent, (long)modelUpdateEventArray.length);
        for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
            int n;
            ModelUpdateEvent modelUpdateEvent2 = modelUpdateEventArray[i2];
            int n2 = n = this.listWidget != null ? this.listWidget.getModelID() : this.menu.getModelID();
            if (modelUpdateEvent2.getModelId() == n) {
                menuLogCh.log(10000000, "MenuModelEventHandler#processModelGroupEvent: process nested event %2: %1", (Object)modelUpdateEvent2, (long)i2);
                if (this.listWidget != null) {
                    this.listWidget.setCurrentProcessedNestedEvent(i2);
                }
                this.processSingleModelEvent(modelUpdateEvent2, menuUpdateDelta);
                continue;
            }
            menuLogCh.log(10000000, "MenuModelEventHandler#processModelGroupEvent: nested event %2 comes from a different model. expected model ID: %3, event: %1", (Object)modelUpdateEvent2, (long)i2, (long)n);
        }
        menuLogCh.log(10000000, "MenuModelEventHandler#processModelGroupEvent: Finished processing ModelGroupEvent: %1", (Object)modelUpdateEvent);
    }

    private void processSingleModelEvent(ModelUpdateEvent modelUpdateEvent, MenuUpdateDelta menuUpdateDelta) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 19) {
            this.processTrigger(modelUpdateEvent);
            return;
        }
        if (n == 23) {
            this.processItemFocusedEvent(modelUpdateEvent.getClientData3());
            return;
        }
        if (modelUpdateEvent.getModelType() == 2 && n == 1) {
            this.menu.updateVisibleItemFromModel();
            return;
        }
        if (this.refreshImmediately) {
            menuLogCh.log(10000000, "MenuModelEventHandler#processSingleModelEvent: 'refreshImmediately' already set, no special handling required for event: %1", (Object)modelUpdateEvent);
            return;
        }
        if (n == 9) {
            this.processRowRemoveEvent(modelUpdateEvent, menuUpdateDelta);
        } else if (n == 7) {
            this.processRowAddEvent(modelUpdateEvent, menuUpdateDelta);
        } else if (n == 8 || n == 10 || n == 20) {
            this.processRowChanged(modelUpdateEvent);
        } else if (n == 1 || n == 22) {
            this.requiredSelectionUpdate = true;
            this.menu.relayout();
        } else if (n == 5) {
            this.requiredSelectionUpdate = true;
            this.requiredItemsRefresh = true;
            this.requiredViewportUpdate = true;
            this.addRequiredUpdateItems(new MenuUpdateRequest.MatchMenuChildWidget(this.listWidgetIndex));
            this.menu.relayout();
        } else if (n == 16 || n == 14 || n == 6 || n == 21 || n == 12) {
            this.refreshImmediately = true;
            this.requiredSelectionUpdate = true;
            this.requiredItemsRefresh = true;
            this.requiredViewportUpdate = true;
            this.addRequiredUpdateItems(new MenuUpdateRequest.MatchMenuChildWidget(this.listWidgetIndex));
            this.menu.relayout();
        } else if (n != 2) {
            menuLogCh.log(100000, "MenuModelEventHandler#processSingleModelEvent: unknown update type %2 from model event: %1", (Object)modelUpdateEvent, (long)n);
        }
    }

    private void processItemFocusedEvent(ModelUpdateData modelUpdateData) {
        Object object = modelUpdateData.get(ModelUpdateData.Key.ITEMID);
        Object object2 = modelUpdateData.get(ModelUpdateData.Key.UNIQUEID);
        Object object3 = modelUpdateData.get(ModelUpdateData.Key.FOCUS_ADVICE);
        menuLogCh.log(10000000, "MenuModelEventHandler#processItemFocusedEvent: itemId: %1, uniqueId: %2, focusAdvice: %3", object, object2, object3);
        if (!(object instanceof Integer)) {
            menuLogCh.log(10000, "MenuModelEventHandler#processItemFocusedEvent: itemId is not an integer: %1", object);
            return;
        }
        int n = (Integer)object;
        int n2 = this.menu.getChildIndexForWidgetId(n, true);
        if (n2 == -1) {
            return;
        }
        if (object3 != null && !(object3 instanceof FocusAdvice)) {
            menuLogCh.log(10000, "MenuModelEventHandler#processItemFocusedEvent: focusAdvice does not implement FocusAdvice: %1", object3);
            return;
        }
        AbstractWidget abstractWidget = this.menu.getChild(n2);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            if (!(object2 instanceof Long)) {
                menuLogCh.log(10000, "MenuModelEventHandler#processItemFocusedEvent: uniqueId is not an integer: %1, itemId: %2, menu item: %3", object2, object, (Object)abstractWidget);
                return;
            }
            long l = (Long)object2;
            int n3 = ((IMenuItemMultiItem)((Object)abstractWidget)).getItemIndexForUniqueID(l);
            if (n3 == -1) {
                menuLogCh.log(100000, "MenuModelEventHandler#processItemFocusedEvent: no item found for uniqueID %2, multiItem-index %3, multiItem: %1", (Object)abstractWidget, l, (long)n2);
                return;
            }
            this.requestedFocusedIndex = new MenuItemIndex(n2, n3);
            this.focusAdvice = (FocusAdvice)object3;
        } else if (abstractWidget instanceof IMenuItemSingle) {
            this.requestedFocusedIndex = new MenuItemIndex(n2, 0);
            this.focusAdvice = (FocusAdvice)object3;
        } else {
            menuLogCh.log(10000, "MenuModelEventHandler#processItemFocusedEvent: unknown menuItem type: %1", (Object)abstractWidget);
        }
    }

    private void processRowRemoveEvent(ModelUpdateEvent modelUpdateEvent, MenuUpdateDelta menuUpdateDelta) {
        int n;
        MenuItemIndex menuItemIndex;
        ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
        if (modelUpdateData != null) {
            int n2 = modelUpdateData.getInt(ModelUpdateData.Key.INDEX);
            menuItemIndex = new MenuItemIndex(this.listWidgetIndex, n2);
            n = modelUpdateData.getInt(ModelUpdateData.Key.COUNT);
        } else {
            menuItemIndex = new MenuItemIndex(this.listWidgetIndex, modelUpdateEvent.getClientData1());
            n = 1;
        }
        if (!this.menu.hasMoveItem() || n != 1 || !this.menu.getMoveItemIndex().equals(menuItemIndex)) {
            this.menu.getAnimationManager().remove(menuItemIndex, n, menuUpdateDelta);
        } else {
            menuLogCh.log(10000000, "MenuModelEventHandler#processRowRemoveEvent: remove item from move mode source position %1.", (Object)menuItemIndex);
        }
        this.requiredSelectionUpdate = true;
        this.requiredItemsRefresh = true;
        this.requiredViewportUpdate = true;
        this.addRequiredUpdateItems(new MenuUpdateRequest.MatchMenuChildWidget(this.listWidgetIndex));
        this.menu.relayout();
    }

    private void processRowAddEvent(ModelUpdateEvent modelUpdateEvent, MenuUpdateDelta menuUpdateDelta) {
        ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
        if (modelUpdateData != null) {
            MenuItemIndex menuItemIndex = this.getListItemIndex(this.listWidgetIndex, modelUpdateData, ModelUpdateData.Key.INDEX);
            int n = modelUpdateData.getInt(ModelUpdateData.Key.COUNT);
            ModelTrigger modelTrigger = (ModelTrigger)modelUpdateData.get(ModelUpdateData.Key.TRIGGER);
            if (modelTrigger == ModelTrigger.OPEN_FOLDER) {
                menuUpdateDelta.cursorMergeEnabled = false;
                MenuItemIndex menuItemIndex2 = new MenuItemIndex(this.listWidgetIndex, menuItemIndex.widgetPart - 1);
                boolean bl = menuItemIndex2.equals(menuUpdateDelta.getOldFocusedIndex());
                int n2 = this.menu.getAnimationManager().openFolder(menuItemIndex2, n, menuUpdateDelta);
                if (n2 != 0 && bl) {
                    if (this.focusAdvice instanceof WidgetFocusAdvice) {
                        WidgetFocusAdvice widgetFocusAdvice = (WidgetFocusAdvice)this.focusAdvice;
                        this.focusAdvice = new FolderOpenFocusAdvice(n2, widgetFocusAdvice.getPixel(), widgetFocusAdvice.isTopAligned());
                    } else {
                        menuLogCh.log(100000, "MenuModelEventHandler#processRowAddEvent: focusAdvice is already set: %1", (Object)this.focusAdvice);
                    }
                }
                menuLogCh.log(10000000, "MenuModelEventHandler#processRowAddEvent: open folder. new items at: %1, length: %2, newItemsHeight: %3", (Object)menuItemIndex, (long)n, (long)n2);
            } else {
                this.addItemsWithMoveModeCheck(menuItemIndex, n, menuUpdateDelta);
            }
        } else {
            this.addItemsWithMoveModeCheck(new MenuItemIndex(this.listWidgetIndex, modelUpdateEvent.getClientData1()), 1, menuUpdateDelta);
        }
        this.requiredSelectionUpdate = true;
        this.requiredItemsRefresh = true;
        this.requiredViewportUpdate = true;
        this.addRequiredUpdateItems(new MenuUpdateRequest.MatchMenuChildWidget(this.listWidgetIndex));
    }

    private void addItemsWithMoveModeCheck(MenuItemIndex menuItemIndex, int n, MenuUpdateDelta menuUpdateDelta) {
        if (!this.menu.hasMoveItem() || n != 1 || !menuItemIndex.equals(menuUpdateDelta.getOldFocusedIndex())) {
            this.menu.getAnimationManager().add(menuItemIndex, n, menuUpdateDelta);
        } else {
            menuLogCh.log(10000000, "MenuModelEventHandler#addItemsWithMoveModeCheck: insert item at move mode destination position %1.", (Object)menuItemIndex);
        }
    }

    private void processRowChanged(ModelUpdateEvent modelUpdateEvent) {
        ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
        if (modelUpdateData != null) {
            MenuItemIndex menuItemIndex = this.getListItemIndex(this.listWidgetIndex, modelUpdateData, ModelUpdateData.Key.INDEX);
            int n = modelUpdateData.getInt(ModelUpdateData.Key.COUNT);
            if (n > 0) {
                this.checkChangeUnfocusableToFocusable(menuItemIndex, n);
                MenuItemIndex menuItemIndex2 = new MenuItemIndex(this.listWidgetIndex, menuItemIndex.widgetPart + n - 1);
                menuLogCh.log(10000000, "MenuModelEventHandler#processRowChanged: rows changed: %1 until %2", (Object)menuItemIndex, (Object)menuItemIndex2);
                this.addRequiredUpdateItems(new MenuUpdateRequest.MatchItemsRange(menuItemIndex, menuItemIndex2));
            } else {
                menuLogCh.log(10000000, "MenuModelEventHandler#processRowChanged: rows changed, but length=0, so ignore it.");
            }
        } else {
            MenuItemIndex menuItemIndex = new MenuItemIndex(this.listWidgetIndex, modelUpdateEvent.getClientData1());
            menuLogCh.log(10000000, "MenuModelEventHandler#processRowChanged: row changed: %1", (Object)menuItemIndex);
            this.addRequiredUpdateItems(new MenuUpdateRequest.MatchSingleItem(menuItemIndex));
        }
        this.requiredItemsRefresh = true;
    }

    private void checkChangeUnfocusableToFocusable(MenuItemIndex menuItemIndex, int n) {
        boolean bl;
        boolean bl2;
        if (n != 1) {
            return;
        }
        if (!this.menu.getViewport().contains(menuItemIndex)) {
            return;
        }
        MenuItemMetaData menuItemMetaData = this.menu.getAnimationManager().getLayoutData().findAnimationItem(menuItemIndex);
        if (menuItemMetaData == null) {
            return;
        }
        if (!menuItemMetaData.isRealized()) {
            return;
        }
        if (!(menuItemMetaData.widget instanceof MenuItemController)) {
            return;
        }
        boolean bl3 = ((MenuItemController)menuItemMetaData.widget).isFocusable();
        boolean bl4 = this.menu.isMenuItemFocusable(menuItemIndex);
        boolean bl5 = bl2 = !bl3 && bl4;
        if (!bl2) {
            return;
        }
        if (menuItemIndex.equals(this.menu.getFocusedIndex())) {
            return;
        }
        MenuItemIndex menuItemIndex2 = this.menu.getUnfocusableVisibleEdge(this.menu.getFocusedIndex(), true, this.menu.getViewport());
        boolean bl6 = bl = menuItemIndex.widget == menuItemIndex2.widget && menuItemIndex.widgetPart == menuItemIndex2.widgetPart + 1;
        if (!bl) {
            return;
        }
        if (this.requestedFocusedIndex == null) {
            this.requestedFocusedIndex = menuItemIndex;
            this.requiredViewportUpdate = true;
            if (this.focusAdvice == null || this.focusAdvice.getClass() == (class$de$audi$atip$hmi$model$menu$focus$WidgetFocusAdvice == null ? (class$de$audi$atip$hmi$model$menu$focus$WidgetFocusAdvice = MenuModelEventHandler.class$("de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice")) : class$de$audi$atip$hmi$model$menu$focus$WidgetFocusAdvice)) {
                this.focusAdvice = FocusAdvice.KEEP_POSITION;
            }
        }
    }

    private void processTrigger(ModelUpdateEvent modelUpdateEvent) {
        ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
        if (modelUpdateData == ModelTrigger.ACTIVATE_NOW_PLAYING) {
            menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger activate nowPlaying mode");
            this.nowPlayingModeChange = Boolean.TRUE;
        } else if (modelUpdateData == ModelTrigger.TOGGLE_NOW_PLAYING) {
            menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger toggle nowPlaying mode. was active: %1", this.oldNowPlayingModeActive);
            this.nowPlayingModeChange = this.oldNowPlayingModeActive ? Boolean.FALSE : Boolean.TRUE;
        } else if (modelUpdateData == ModelTrigger.JOIN_CURSOR) {
            menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger merge cursor");
            this.mergeCursors = true;
        } else if (modelUpdateData == ModelTrigger.JOIN_CURSOR_NO_SCROLLING) {
            if (this.menu.getAnimationManager().isScrollAnimationRunning()) {
                menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger mergeCursorNoScrolling. No cursor merge, because menu is scrolling.");
            } else {
                menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger mergeCursorNoScrolling. no scrolling active, so merge cursors.");
                this.mergeCursors = true;
            }
        } else if (modelUpdateData == ModelTrigger.ACTIVATE_MOVE_MODE) {
            if (!this.menu.hasMoveItem()) {
                menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger activate move mode");
                this.menu.activateMoveModeOnFocus();
            } else {
                menuLogCh.log(100000, "MenuModelEventHandler#processTrigger(ActivateMoveMode): move mode is already active. move item: %1", (Object)this.menu.getMoveItemIndex());
            }
        } else if (modelUpdateData == ModelTrigger.DEACTIVATE_MOVE_MODE) {
            if (this.menu.hasMoveItem()) {
                menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger deactivate move mode");
                this.menu.deactivateMoveMode();
            } else {
                menuLogCh.log(100000, "MenuModelEventHandler#processTrigger(DeactivateMoveMode): move mode was not yet activated.");
            }
        } else if (modelUpdateData == ModelTrigger.RESET_CURSOR_POS) {
            menuLogCh.log(10000000, "MenuModelEventHandler#processTrigger: trigger reset cursor pos");
            this.menu.jumpToTop();
        } else {
            menuLogCh.log(100000, "MenuModelEventHandler#processTrigger: unknown trigger: %1", (Object)modelUpdateData);
        }
    }

    private void processSelectionUpdate(MenuUpdateDelta menuUpdateDelta) {
        if (this.requiredSelectionUpdate) {
            if (this.listWidget != null) {
                this.menu.updateSelection(this.listWidget, this.listWidgetIndex, menuUpdateDelta);
            } else {
                menuLogCh.log(10000000, "MenuModelEventHandler#processSelectionUpdate: update selection from whole menu");
                this.menu.updateSelection();
            }
        }
    }

    private void processCursorMerge() {
        if (this.mergeCursors) {
            this.menu.mergeCursors(FocusAdvice.KEEP_POSITION);
        }
    }

    private void processNowPlayingModeChanges() {
        if (!(this.menu instanceof NowPlayingMenuController)) {
            if (this.nowPlayingModeChange != null) {
                menuLogCh.log(100000, "MenuModelEventHandler#processNowPlayingModeChanges: can not process requested NPS change (%1), because menu is not a NowPlayingMenu: %2", (Object)(this.nowPlayingModeChange != false ? "activate" : "deactivate"), (Object)this.menu);
            }
            return;
        }
        this.menu.manageLayout();
        NowPlayingMenuController nowPlayingMenuController = (NowPlayingMenuController)this.menu;
        this.setupImplicitNowPlayingChangeRequest(nowPlayingMenuController);
        if (this.nowPlayingModeChange == null) {
            if (this.oldNowPlayingModeActive && !nowPlayingMenuController.isNowPlayingActive()) {
                menuLogCh.log(10000000, "MenuModelEventHandler#processNowPlayingModeChanges: restore old NPS state: %1", this.oldNowPlayingModeActive);
                nowPlayingMenuController.activateNowPlayingOnFocus(true);
            }
        } else if (this.nowPlayingModeChange.booleanValue()) {
            menuLogCh.log(10000000, "MenuModelEventHandler#processNowPlayingModeChanges: activate NowPlayingScreen as requested");
            nowPlayingMenuController.activateNowPlayingOnFocus(false);
        } else {
            menuLogCh.log(10000000, "MenuModelEventHandler#processNowPlayingModeChanges: deactivate NowPlayingScreen as requested");
            nowPlayingMenuController.deactivateNowPlaying(false);
        }
    }

    private void setupImplicitNowPlayingChangeRequest(NowPlayingMenuController nowPlayingMenuController) {
        if (this.menu.hasMoveItem()) {
            if (nowPlayingMenuController.isNowPlayingActive()) {
                menuLogCh.log(10000000, "MenuModelEventHandler#setupImplicitNowPlayingChangeRequest: deactivate NPS, because MoveMode is active");
                this.nowPlayingModeChange = Boolean.FALSE;
                return;
            }
            if (Boolean.TRUE.equals(this.nowPlayingModeChange)) {
                menuLogCh.log(10000000, "MenuModelEventHandler#setupImplicitNowPlayingChangeRequest: can not activate NPS, because MoveMode is active");
                this.nowPlayingModeChange = Boolean.FALSE;
                return;
            }
        }
        if (!(this.menu.hasSelectedItem() && Util.equals(this.menu.getFocusedIndex(), this.menu.getSelectedIndex()) || !nowPlayingMenuController.isNowPlayingActive())) {
            menuLogCh.log(10000000, "MenuModelEventHandler#setupImplicitNowPlayingChangeRequest: deactivate NPS, because there is no selected item any more");
            this.nowPlayingModeChange = Boolean.FALSE;
            return;
        }
    }

    private void restoreFocusedItemExpansion() {
        if (this.oldFocusedItemExpanded && !this.menu.hasExpandedItem()) {
            menuLogCh.log(10000000, "MenuModelEventHandler#restoreFocusedItemExpansion: restore expansion on focused item");
            this.menu.expandFocusedItem(true);
        }
    }

    private MenuItemIndex getListItemIndex(int n, ModelUpdateData modelUpdateData, ModelUpdateData.Key key) {
        int n2 = modelUpdateData.getInt(key);
        return new MenuItemIndex(n, n2);
    }

    private void addRequiredUpdateItems(MenuUpdateRequest.IMenuItemMatcher iMenuItemMatcher) {
        this.requiredUpdateItems = MenuUpdateRequest.combineMenuItemMatcher(this.requiredUpdateItems, iMenuItemMatcher);
    }

    protected long getCurrentTime() {
        return AbstractWidget.framework.getMonotonicTime();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

