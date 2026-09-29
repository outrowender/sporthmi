/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.MenuModel$FocusedMenuItem;
import de.audi.atip.hmi.model.menu.MenuModelGUI;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidgetStorageObject;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.WidgetPersistenceManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMulti;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuMergeTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.WidgetStorageObjectMenu;
import java.util.Iterator;

public class MenuLayoutInitialization
implements IWidgetLogChannel,
WidgetConstants {
    private int[] initialFocusWidgetIDs;
    private FocusAdvice initialFocusAdvice = FocusAdvice.KEEP_POSITION;
    private boolean initialAvoidPartiallyEmptyViewport = true;
    private boolean persistentLayout = true;
    private MenuUpdateRequest initialRequestFromPersistence;
    private final MenuController menu;

    public MenuLayoutInitialization(MenuController menuController) {
        this.menu = menuController;
    }

    public void preparePersistenceForConnect(InitializationContext initializationContext) {
        this.initialRequestFromPersistence = this.getInitialFocusForPersistence(initializationContext);
    }

    public void initLayout() {
        this.hideAllItems();
        this.updateInitialSelection();
        this.updateInitialFocus();
        this.updateInitialExpansion();
    }

    public void disconnect() {
        if (this.shouldUsePersistenceForWidget()) {
            this.saveLayout();
        }
    }

    private void hideAllItems() {
        Iterator iterator = this.menu.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!this.menu.isMenuItem(abstractWidget) || abstractWidget instanceof IMenuItemMultiItem) continue;
            this.menu.setMenuItemVisible(abstractWidget, false);
        }
    }

    private void updateInitialSelection() {
        this.menu.setInitialSelectedIndex(this.menu.calculateSelection());
    }

    private void updateInitialExpansion() {
        if (this.menu.hasExpandTimerWidget()) {
            this.menu.expandFocusedItem(true);
        }
    }

    public void updateInitialFocus() {
        MenuUpdateRequest menuUpdateRequest = this.getInitialFocusRequestWithoutAutoMerge();
        if (menuUpdateRequest != null) {
            this.focusInitialItem(menuUpdateRequest);
            return;
        }
        menuUpdateRequest = this.getInitialFocusRequestWithAutoMerge();
        if (menuUpdateRequest != null) {
            this.focusInitialItem(menuUpdateRequest);
            this.applyInitialCursorMerge();
            return;
        }
        this.menu.setFocusedIndex(null);
        this.menu.setViewport(new MenuViewport(null, null));
        this.menu.relayout();
    }

    private void focusInitialItem(MenuUpdateRequest menuUpdateRequest) {
        this.menu.getItemFocusedPropagator().initializeItemsFocusedFlag(menuUpdateRequest.focusIndex);
        this.menu.getAnimationManager().focus(menuUpdateRequest, true, true);
        if (!Util.equals(menuUpdateRequest.focusIndex, this.menu.getFocusedIndex())) {
            menuLogCh.log(-1601830656, "MenuLayoutInitialization#focusInitialItem: unexpected initial focus: %1, expected: %2", (Object)this.menu.getFocusedIndex(), (Object)menuUpdateRequest.focusIndex);
            this.menu.refreshAllItems();
        }
    }

    private MenuUpdateRequest getInitialFocusRequestWithoutAutoMerge() {
        MenuUpdateRequest menuUpdateRequest = this.getInitialFocusFromScreenData();
        if (menuUpdateRequest != null) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#getInitialFocusRequestWithoutAutoMerge: initial update request from screen data: %1", (Object)menuUpdateRequest);
            return menuUpdateRequest;
        }
        if (this.initialRequestFromPersistence != null) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#getInitialFocusRequestWithoutAutoMerge: initial update request from persistence: %1", (Object)this.initialRequestFromPersistence);
            return this.initialRequestFromPersistence;
        }
        menuUpdateRequest = this.getInitialFocusForModel();
        if (menuUpdateRequest != null) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#getInitialFocusRequestWithoutAutoMerge: initial update request from model: %1", (Object)menuUpdateRequest);
            return menuUpdateRequest;
        }
        return null;
    }

    private MenuUpdateRequest getInitialFocusRequestWithAutoMerge() {
        MenuUpdateRequest menuUpdateRequest = this.getInitialFocusForFixedIndex();
        if (menuUpdateRequest != null) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#getInitialFocusRequestWithAutoMerge: initial update request from fixed configuration: %1", (Object)menuUpdateRequest);
            return menuUpdateRequest;
        }
        menuUpdateRequest = this.getInitialFocusForFirstItem();
        if (menuUpdateRequest != null) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#getInitialFocusRequestWithAutoMerge: initial update request for first item: %1", (Object)menuUpdateRequest);
            return menuUpdateRequest;
        }
        menuLogCh.log(-2137614336, "MenuLayoutInitialization#getInitialFocusRequestWithAutoMerge: menu is empty");
        return null;
    }

    private MenuUpdateRequest getInitialFocusForPersistence(InitializationContext initializationContext) {
        MenuItemIndex menuItemIndex;
        if (!this.shouldUsePersistenceForEnterScreen(initializationContext)) {
            return null;
        }
        if (!this.shouldUsePersistenceForWidget()) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#getInitialFocusRequestForPersistence: don't use persistence. persistentLayout: %1", this.persistentLayout);
            return null;
        }
        WidgetStorageObjectMenu widgetStorageObjectMenu = this.loadLayout();
        if (widgetStorageObjectMenu == null) {
            return null;
        }
        MenuItemIndex menuItemIndex2 = widgetStorageObjectMenu.getFocusedIndex();
        Long l = widgetStorageObjectMenu.getFocusedUniqueID();
        if (l != null && (menuItemIndex = this.menu.getMenuItemIndexForUniqueID(l, menuItemIndex2)) != null && !menuItemIndex.equals(menuItemIndex2)) {
            menuLogCh.log(-1601830656, "MenuLayoutInitialization#getInitialFocusRequestForPersistence: expected item %1, but found item %2 for rowID %3", (Object)menuItemIndex2, (Object)menuItemIndex, (Object)l);
            menuItemIndex2 = menuItemIndex;
        }
        if (menuItemIndex2 != null) {
            return new MenuUpdateRequest(menuItemIndex2, widgetStorageObjectMenu.getFocusAdvice(), MenuUpdateRequest.UPDATE_NONE);
        }
        menuLogCh.log(-1601830656, "MenuLayoutInitialization#getInitialFocusRequestForPersistence: storage object has no focusedIndex: %1", (Object)widgetStorageObjectMenu);
        return null;
    }

    private MenuUpdateRequest getInitialFocusFromScreenData() {
        if (this.menu.getInitContext() == null || this.menu.getInitContext().getInitialCursorPosition() == -1) {
            return null;
        }
        int n = this.menu.getInitContext().getInitialCursorPosition();
        MenuItemIndex menuItemIndex = this.getActiveMenuItemForInternalId(n);
        if (menuItemIndex == null) {
            return null;
        }
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(menuItemIndex, this.initialFocusAdvice, MenuUpdateRequest.UPDATE_NONE);
        menuUpdateRequest.avoidPartiallyFilledViewport = this.initialAvoidPartiallyEmptyViewport;
        return menuUpdateRequest;
    }

    private MenuUpdateRequest getInitialFocusForModel() {
        Object object = this.menu.getModel();
        if (object == null || !(object instanceof MenuModelGUI)) {
            return null;
        }
        MenuModel$FocusedMenuItem menuModel$FocusedMenuItem = ((MenuModelGUI)object).getLastFocusedMenuItem();
        if (menuModel$FocusedMenuItem == null) {
            return null;
        }
        int n = menuModel$FocusedMenuItem.getMenuItemID();
        int n2 = this.menu.getChildIndexForWidgetId(n, true);
        if (n2 == -1) {
            menuLogCh.log(-1601830656, "MenuLayoutInitialization#getInitialFocusForModel: no menu item found for widgetID: %1", (long)n);
            return null;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.menu.getChild(n2);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            long l = menuModel$FocusedMenuItem.getUniqueListRowID();
            int n3 = ((IMenuItemMultiItem)((Object)abstractWidgetController)).getItemIndexForUniqueID(l);
            if (n3 == -1) {
                menuLogCh.log(-1601830656, "MenuLayoutInitialization#getInitialFocusForModel: no list row found for uniqueID: %1, widgetID: %2", l, (long)n);
                return null;
            }
            return new MenuUpdateRequest(new MenuItemIndex(n2, n3), menuModel$FocusedMenuItem.getAdvice(), MenuUpdateRequest.UPDATE_NONE);
        }
        return new MenuUpdateRequest(new MenuItemIndex(n2, 0), menuModel$FocusedMenuItem.getAdvice(), MenuUpdateRequest.UPDATE_NONE);
    }

    private MenuUpdateRequest getInitialFocusForFixedIndex() {
        MenuItemIndex menuItemIndex = this.getActiveMenuItemForWidgetIds(this.initialFocusWidgetIDs);
        if (menuItemIndex == null) {
            return null;
        }
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(menuItemIndex, this.initialFocusAdvice, MenuUpdateRequest.UPDATE_NONE);
        menuUpdateRequest.avoidPartiallyFilledViewport = this.initialAvoidPartiallyEmptyViewport;
        return menuUpdateRequest;
    }

    private MenuUpdateRequest getInitialFocusForFirstItem() {
        MenuItemIndex menuItemIndex = this.getFocusIndexForFirstItem();
        if (menuItemIndex == null) {
            return null;
        }
        MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(menuItemIndex, this.initialFocusAdvice, MenuUpdateRequest.UPDATE_NONE);
        menuUpdateRequest.avoidPartiallyFilledViewport = this.initialAvoidPartiallyEmptyViewport;
        return menuUpdateRequest;
    }

    private MenuItemIndex getFocusIndexForFirstItem() {
        MenuItemIndex menuItemIndex = this.menu.getFirstMenuItem();
        if (menuItemIndex == null) {
            return null;
        }
        if (this.initialAvoidPartiallyEmptyViewport) {
            return menuItemIndex;
        }
        return this.getFirstNonTouchfieldItem();
    }

    private MenuItemIndex getFirstNonTouchfieldItem() {
        MenuItemIndex menuItemIndex = this.menu.getFirstMenuItem();
        Iterator iterator = this.menu.iterator(menuItemIndex, true, true);
        while (iterator.hasNext()) {
            MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
            boolean bl = this.menu.getChild(menuItemIndex2.widget) instanceof TouchController;
            if (bl) continue;
            return menuItemIndex2;
        }
        menuLogCh.log(1078071040, "MenuController#getFirstNonTouchfieldItem: menu contains only touchfield items.");
        return menuItemIndex;
    }

    private MenuItemIndex getActiveMenuItemForWidgetIds(int[] nArray) {
        if (nArray == null || nArray.length == 0) {
            return null;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            MenuItemIndex menuItemIndex = this.getActiveMenuItemForWidgetId(nArray[i2]);
            if (menuItemIndex == null) continue;
            return menuItemIndex;
        }
        menuLogCh.log(-2137614336, "MenuLayoutInitialization#getActiveMenuItemForWidgetIds: no valid item found for widgetIDs of length: %1", (long)nArray.length);
        return null;
    }

    private MenuItemIndex getActiveMenuItemForWidgetId(int n) {
        if (n == -1) {
            return null;
        }
        int n2 = this.menu.getChildIndexForWidgetId(n);
        if (n2 != -1) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.menu.getChild(n2);
            return this.getFocusableItemOfWidget(abstractWidgetController, n, n2);
        }
        menuLogCh.log(-1601830656, "MenuLayoutInitialization#getActiveMenuItemForWidgetId: no child found for widgetID: %1", (long)n);
        return null;
    }

    private MenuItemIndex getActiveMenuItemForInternalId(int n) {
        if (n == -1) {
            return null;
        }
        int n2 = 0;
        Iterator iterator = this.menu.getChildren().iterator();
        while (iterator.hasNext()) {
            MenuItemController menuItemController;
            int n3;
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (this.menu.isActiveMenuItem(abstractWidgetController) && abstractWidgetController instanceof MenuItemController && (n3 = (menuItemController = (MenuItemController)abstractWidgetController).getInternalID()) == n) {
                return new MenuItemIndex(n2, 0);
            }
            ++n2;
        }
        menuLogCh.log(-1601830656, "MenuLayoutInitialization#getActiveMenuItemForInternalId: no child found for internalID: %1", (long)n);
        return null;
    }

    private MenuItemIndex getFocusableItemOfWidget(AbstractWidgetController abstractWidgetController, int n, int n2) {
        if (this.menu.isActiveMenuItem(abstractWidgetController)) {
            if (abstractWidgetController instanceof IMenuItemMulti) {
                IMenuItemMulti iMenuItemMulti = (IMenuItemMulti)((Object)abstractWidgetController);
                if (MenuController.isEmpty(iMenuItemMulti)) {
                    menuLogCh.log(-2137614336, "MenuLayoutInitialization#getActiveMenuItemForWidgetId: multiItem %1 with ID %2 is empty", (long)n2, (long)n);
                    return null;
                }
                MenuItemIndex menuItemIndex = new MenuItemIndex(n2, 0);
                menuLogCh.log(-2137614336, "MenuLayoutInitialization#getActiveMenuItemForWidgetId: found multiItem with ID %2, focus item: %1", (Object)menuItemIndex, (long)n);
                return menuItemIndex;
            }
            MenuItemIndex menuItemIndex = new MenuItemIndex(n2, 0);
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#getActiveMenuItemForWidgetId: found singleItem with ID %2, focus item: %1", (Object)menuItemIndex, (long)n);
            return menuItemIndex;
        }
        menuLogCh.log(-2137614336, "MenuLayoutInitialization#getActiveMenuItemForWidgetId: widget %3 with ID %2 is not an active menu item: %1", (Object)abstractWidgetController, (long)n, (long)n2);
        return null;
    }

    private boolean shouldUsePersistenceForEnterScreen(InitializationContext initializationContext) {
        if (!initializationContext.isReinit()) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#shouldUsePersistenceForEnterScreen: load persistence, because reInit flag is not set");
            return true;
        }
        if (initializationContext.isStayOnFocusedElement()) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#shouldUsePersistenceForEnterScreen: load persistence, because StayOnFocusedElement flag is set");
            return true;
        }
        return false;
    }

    private boolean shouldUsePersistenceForWidget() {
        return this.persistentLayout && this.menu.isMainAreaMenu();
    }

    private void applyInitialCursorMerge() {
        if (this.menu.hasSelectedItem() && this.isCursorMergeWidgetEnabled()) {
            this.menu.mergeCursors(FocusAdvice.KEEP_POSITION);
        }
    }

    private boolean isCursorMergeWidgetEnabled() {
        MenuMergeTimerController menuMergeTimerController = this.menu.getCursorMergeWidget();
        return menuMergeTimerController != null && menuMergeTimerController.isEnabled();
    }

    private void saveLayout() {
        WidgetPersistenceManager widgetPersistenceManager = this.menu.getTerminalImpl().getWidgetPersistenceManager();
        widgetPersistenceManager.store(this.createPersistentStorageObject());
    }

    private WidgetStorageObjectMenu createPersistentStorageObject() {
        WidgetStorageObjectMenu widgetStorageObjectMenu = new WidgetStorageObjectMenu();
        widgetStorageObjectMenu.setFocusedIndex(this.menu.getFocusedIndex());
        widgetStorageObjectMenu.setFocusedUniqueID(this.menu.getFocusedUniqueID());
        widgetStorageObjectMenu.setFocusAdvice(this.menu.createFocusAdviceForCursorPosition());
        return widgetStorageObjectMenu;
    }

    private WidgetStorageObjectMenu loadLayout() {
        WidgetPersistenceManager widgetPersistenceManager = this.menu.getTerminalImpl().getWidgetPersistenceManager();
        AbstractWidgetStorageObject abstractWidgetStorageObject = widgetPersistenceManager.read();
        if (abstractWidgetStorageObject == null) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#loadLayout: storage object is null");
            return null;
        }
        if (abstractWidgetStorageObject instanceof WidgetStorageObjectMenu) {
            menuLogCh.log(-2137614336, "MenuLayoutInitialization#loadLayout: loaded storage object: %1", (Object)abstractWidgetStorageObject);
            return (WidgetStorageObjectMenu)abstractWidgetStorageObject;
        }
        menuLogCh.log(10000, "MenuLayoutInitialization#loadLayout: loaded wrong storage object: %1", (Object)abstractWidgetStorageObject);
        return null;
    }

    public int[] getInitialFocusWidgetIDs() {
        return this.initialFocusWidgetIDs;
    }

    public void setInitialFocusWidgetIDs(int[] nArray) {
        this.initialFocusWidgetIDs = nArray;
    }

    public FocusAdvice getInitialFocusAdvice() {
        return this.initialFocusAdvice;
    }

    public void setInitialFocusAdvice(FocusAdvice focusAdvice) {
        this.initialFocusAdvice = focusAdvice;
    }

    public boolean isInitialAvoidPartiallyEmptyViewport() {
        return this.initialAvoidPartiallyEmptyViewport;
    }

    public void setInitialAvoidPartiallyEmptyViewport(boolean bl) {
        this.initialAvoidPartiallyEmptyViewport = bl;
    }

    public boolean isPersistentLayout() {
        return this.persistentLayout;
    }

    public void setPersistentLayout(boolean bl) {
        this.persistentLayout = bl;
    }
}

