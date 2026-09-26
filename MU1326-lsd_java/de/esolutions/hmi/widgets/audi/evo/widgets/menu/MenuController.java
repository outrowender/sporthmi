/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IFocusedPropertyProvider;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.PreferredDynamicHeight;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.SDSEventListener;
import de.esolutions.hmi.widgets.audi.base.TabLayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.DrawerConditionEngine;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CoverStackController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.OptionDrawerIcon;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.AbstractMenuIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IInfoLineRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallbackProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMulti;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfolineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfolineTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuExpandTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuIndexIterator;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemFocusedPropagator;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuKeyEventHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutInitialization;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuMergeTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuModelEventHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuSDSEventHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuSDSNumbersController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest$MatchMenuChildWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MultiLineMenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLines;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SubElementMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MenuController
extends AbstractWidgetController
implements ListManager,
LayoutContainer,
IViewSizeAnimatable,
IFocusedPropertyProvider,
SelectionProvider,
SDSEventListener {
    public static final int MENU_HEIGHT_IDX_SELECTION;
    public static final int MENU_HEIGHT_IDX_TOTAL;
    private List menuCallbacks = null;
    public static final int ROLE_CURSOR_FOCUS;
    public static final int ROLE_CURSOR_SELECTION;
    public static final int ROLE_SCROLLBAR;
    public static final int ROLE_BACKGROUND;
    public static final int ROLE_TOUCHFIELD;
    public static final int ROLE_SDS_NUMBERS;
    public static final int ROLE_NOT_MENU_ITEM;
    public static final int ROLE_SEPARATING_LINES;
    public static final int ROLE_TOUCHFIELD_MEDIA_RADIO;
    public static final int ROLE_NOW_PLAYING_ONLY;
    public static final int ROLE_ICON_C2;
    public static final int ROLE_START_CALL;
    public static final int ROLE_INFOLINE;
    public static final int ROLE_TITLE;
    public static final int ROLE_LONGPRESS;
    public static final int ROLE_UNREACHABLE_ITEM_AT_END_OF_MENU;
    public static final int ROLE_NOW_PLAYING_ONLY_CLIPPED;
    private CompositeRenderer renderer;
    private AbstractWidget focusCursor;
    private AbstractWidget selectionCursor;
    private AbstractWidget c2Icon;
    private ScrollbarController scrollbar;
    private AbstractWidget background;
    private AbstractWidget sdsNumbersWidget;
    private SeparatingLines separatingLines;
    private InfolineController infoline;
    private AbstractWidget title;
    private CoverStackController coverStack;
    private List touchfields = Collections.EMPTY_LIST;
    private List startCall = Collections.EMPTY_LIST;
    private List longpressItems = Collections.EMPTY_LIST;
    private List otherNonMenuItems = Collections.EMPTY_LIST;
    private List unreachableItemWidgets = Collections.EMPTY_LIST;
    private List unreachableItemsMetaData = null;
    private boolean hideOverlayDecoratorDuringScrolling = true;
    protected List nowPlayingOnly = Collections.EMPTY_LIST;
    private List nowPlayingOnlyClipped = Collections.EMPTY_LIST;
    private MenuViewport viewport = new MenuViewport(null, null);
    private MenuItemIndex focusedIndex;
    private Long focusedUniqueID;
    private MenuItemIndex selectedIndex;
    private Long selectedUniqueID;
    private MenuItemIndex expandedItem;
    private MenuItemIndex infolineItemIndex;
    protected MenuAnimationManager animationManager = this.createAnimationController();
    protected MenuKeyEventHandler keyEventHandler = new MenuKeyEventHandler(this);
    protected MenuSDSEventHandler sdsEventHandler;
    private MenuLayout layout = new MenuLayout(this);
    private MenuLayoutInitialization initialization = new MenuLayoutInitialization(this);
    private MenuItemFocusedPropagator itemFocusedPropagator = new MenuItemFocusedPropagator(this);
    private boolean longpressAvailable = false;
    private int defaultDisabledInfolineTextId = -1;
    private int[] infolineTextIdsDisabled = null;
    public static final float VIEW_SIZE_RESIZE_PART;
    private float viewSizeChangeContentOpacity = 1.0f;
    private boolean touchScrollMode;
    private boolean layoutDirty;
    private boolean layoutItemsDirty;
    private boolean calculatePreferredSize = false;
    private int calculatedPreferredWidth = -1;
    private int calculatedPreferredHeight = -1;
    private boolean autoConfigureTabulators = true;
    private MenuItemIndex moveItemIndex = null;
    private boolean registerAsFocusPropertyProvider = true;
    private IFocusedPropertyObject focusedPropertyObject;
    private float contentTransX;
    private float contentTransY;
    private float contentOpacity = 1.0f;
    private boolean comboBoxOpen = false;
    private float openComboboxOpacity;
    private boolean clipContent = false;
    private int clipOffsetTop = 3;
    private int clipOffsetBottom = -3;
    private AbstractWidgetController currentChoiceModelVisibleWidget = null;
    private float itemOpacityOptionDrawerOpen = 1.0f;
    private List focusCursorHideReasons;
    private boolean fireNotFocusedToModelOnAnimationStart;
    private boolean currentOptionIconVisibilityForViewSize = false;
    private int focusedIndexBeforeMerge = -1;
    private MenuItemIndex previousInfolineItemIndex = null;

    public static boolean isEmpty(IMenuItemMulti iMenuItemMulti) {
        return iMenuItemMulti.getSubItemCount() == 0;
    }

    public static int getLastSubitemIndex(IMenuItemMulti iMenuItemMulti) {
        return iMenuItemMulti.getSubItemCount() - 1;
    }

    public static boolean isEqualMultiLineItem(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2) {
        if (menuItemMetaData == null || menuItemMetaData2 == null) {
            return false;
        }
        if (!menuItemMetaData.isMultiLine() || !menuItemMetaData2.isMultiLine()) {
            return false;
        }
        return menuItemMetaData.index.widget == menuItemMetaData2.index.widget;
    }

    public MenuItemIndex getPreviousInfolineItemIndex() {
        return this.previousInfolineItemIndex;
    }

    protected MenuAnimationManager createAnimationController() {
        return new MenuAnimationManager(this);
    }

    public void createInfolineWidgets(IInfoLineRenderer iInfoLineRenderer) {
        InfolineController infolineController = new InfolineController();
        iInfoLineRenderer.setController(infolineController);
        infolineController.setRenderer(iInfoLineRenderer);
        this.add(infolineController, 13);
        this.add(new InfolineTimerController(), 7);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(CompositeRenderer compositeRenderer) {
        this.renderer = compositeRenderer;
        if (compositeRenderer != null) {
            compositeRenderer.setClipping(false);
        }
    }

    @Override
    protected void afterConnected() {
        super.afterConnected();
        this.viewport = new MenuViewport(null, null);
        this.focusedIndex = null;
        this.focusedUniqueID = null;
        this.itemFocusedPropagator.initialize();
        this.invalidateChildrenBounds();
        if (this.autoConfigureTabulators) {
            this.autoConfigureTabulators();
        }
        this.initialization.initLayout();
        this.updatePreferredSize();
        this.notifyCallbacksViewportChanged(true);
        this.itemFocusedPropagator.fireItemFocusedDuringConnect();
        this.notifySdsOnConnect();
    }

    @Override
    protected void initializeWidget() {
        menuLogCh.log(-2137614336, "MenuController#initializeWidget: %1", (Object)this);
        super.initializeWidget();
        this.focusCursorHideReasons = null;
        if (this.registerAsFocusPropertyProvider && this.isMainAreaMenu() && this.isVisible()) {
            this.getDrawerFocusManager().registerFocusPropertyProvider(this);
        }
        this.viewSizeChangeContentOpacity = 1.0f;
        this.touchScrollMode = false;
        this.infolineItemIndex = null;
        this.previousInfolineItemIndex = null;
        this.expandedItem = null;
        this.moveItemIndex = null;
        this.notifyDrawerFocusManagerForMoveModeActive(false);
        this.keyEventHandler.connect();
        this.initialization.preparePersistenceForConnect(this.initContext);
        this.contentTransX = 0.0f;
        this.contentTransY = 0.0f;
        this.contentOpacity = 1.0f;
        this.openComboboxOpacity = 1.0f;
        if (this.model instanceof ChoiceModelGUI) {
            if (this.currentChoiceModelVisibleWidget == null) {
                this.setAllItemsInvisible();
            }
            this.updateVisibleItemFromModel();
        }
        this.propagateSizeToMenuItems();
    }

    private IDrawerFocusManagerEvo getDrawerFocusManager() {
        return this.terminal.getDrawerFocusManager();
    }

    @Override
    public void setVisible(boolean bl) {
        menuLogCh.log(-2137614336, "MenuController#setVisible(%1) - Called. %2", bl, (Object)this);
        if (this.registerAsFocusPropertyProvider && this.isMainAreaMenu() && this.terminal != null) {
            if (bl) {
                this.getDrawerFocusManager().registerFocusPropertyProvider(this);
            } else {
                this.getDrawerFocusManager().deRegisterFocusPropertyProvider(this);
            }
        }
        super.setVisible(bl);
    }

    private void setAllItemsInvisible() {
        MenuItemIndex menuItemIndex = this.getFirstMenuItem();
        if (menuItemIndex != null) {
            Iterator iterator = this.iterator(menuItemIndex, true, true);
            while (iterator.hasNext()) {
                MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
                this.getChild(menuItemIndex2.widget).setVisible(false);
            }
        }
    }

    @Override
    public void disconnecting() {
        menuLogCh.log(-2137614336, "MenuController#disconnecting: %1", (Object)this);
        if (this.isMainAreaMenu()) {
            this.getDrawerFocusManager().deRegisterFocusPropertyProvider(this);
        }
        this.initialization.disconnect();
        this.animationManager.disconnect();
        this.keyEventHandler.disconnect();
        this.layout.disconnect();
        super.disconnecting();
    }

    @Override
    public void predisconnecting() {
        if (this.hasMoveItem()) {
            this.cancelMoveMode();
        }
        super.predisconnecting();
    }

    private void notifySdsOnConnect() {
        if (!this.isMainAreaMenu()) {
            menuLogCh.log(-2137614336, "MenuController#notifySdsOnConnect: Menu is not the main area menu (%1)", (Object)this);
            return;
        }
        if (!this.isSdsScreen()) {
            menuLogCh.log(-2137614336, "MenuController#notifySdsOnConnect: Screen %2 is not a SDS screen (%1)", (Object)this, (long)this.getScreenId());
            return;
        }
        if (!this.isActive()) {
            menuLogCh.log(-2137614336, "MenuController#notifySdsOnConnect: Menu is not active (%1)", (Object)this);
            return;
        }
        if (!this.isVisibleRecursive()) {
            menuLogCh.log(-2137614336, "MenuController#notifySdsOnConnect: Menu is not visible (%1)", (Object)this);
            return;
        }
        if (AbstractWidget.sdsService == null) {
            menuLogCh.log(-1601830656, "MenuController#notifySdsOnConnect: SDS Service is null (%1)", (Object)this);
            return;
        }
        boolean bl = this.mayMenuBeScrollable();
        int n = this.terminal.getTerminalID();
        int n2 = this.getScreenId();
        menuLogCh.log(-2137614336, "MenuController#notifySdsOnConnect: Menu is scrollable: %3, screen ID: %1, terminal ID: %2", (long)n2, (long)n, bl);
        AbstractWidget.sdsService.screenConnected(n2, n, bl);
    }

    private boolean isSdsScreen() {
        Screen screen = this.initContext.getScreen();
        if (screen instanceof ScreenWidgetEVO) {
            return ((ScreenWidgetEVO)screen).isNotifySdsForVisibility();
        }
        return false;
    }

    private boolean mayMenuBeScrollable() {
        Object object;
        Object object2 = this.getChildren().iterator();
        while (object2.hasNext()) {
            object = (AbstractWidget)object2.next();
            if (!(object instanceof IMenuItemMultiItem)) continue;
            return true;
        }
        object2 = this.getFirstMenuItem();
        object = this.getLastMenuItem();
        MenuViewport menuViewport = this.getViewport();
        return !menuViewport.contains((MenuItemIndex)object2) || !menuViewport.contains((MenuItemIndex)object);
    }

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        menuLogCh.log(-2137614336, "MenuController#handleFocusChanged: focus event: %2, drawerState: %3. %1", (Object)this, (long)n, (long)n2);
        super.handleFocusChanged(n, n2, n3);
        if (n == 2) {
            this.keyEventHandler.focusGained();
            if (n2 == 64 || n2 == 32) {
                this.initialization.updateInitialFocus();
            }
        } else {
            this.keyEventHandler.focusLost();
            this.animationManager.brakeFastViewportScrolling(true);
        }
        this.updateFocusedPropertyObject();
    }

    public void relayout() {
        this.invalidateChildrenBounds();
    }

    private void invalidateChildrenBounds() {
        this.setLayoutDirty(true);
        this.setCompositesDirty(true);
    }

    public float getItemOpacityOptionDrawerOpen() {
        return this.itemOpacityOptionDrawerOpen;
    }

    public void setItemOpacityOptionDrawerOpen(float f2) {
        if (f2 == this.itemOpacityOptionDrawerOpen) {
            return;
        }
        this.itemOpacityOptionDrawerOpen = f2;
        this.relayout();
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (this.shouldRender()) {
            this.managePostponedRefresh();
            this.manageLayout();
        }
        super.render(redrawContext);
    }

    public boolean shouldRenderRecursive() {
        AbstractWidget abstractWidget = this;
        int n = 100;
        for (int i2 = 0; i2 < n; ++i2) {
            if (abstractWidget == null) {
                return true;
            }
            if (!abstractWidget.shouldRender()) {
                return false;
            }
            abstractWidget = abstractWidget.getParent();
        }
        menuLogCh.log(10000, "MenuController#shouldRenderHierarchy: climbed up %2 levels in the hierarchy without finding the top. Widget: %1", (Object)this, (long)n);
        return true;
    }

    public boolean isVisibleRecursive() {
        AbstractWidget abstractWidget = this;
        int n = 100;
        for (int i2 = 0; i2 < n; ++i2) {
            if (abstractWidget == null) {
                return true;
            }
            if (!abstractWidget.isVisible()) {
                return false;
            }
            abstractWidget = abstractWidget.getParent();
        }
        menuLogCh.log(10000, "MenuController#isVisibleRecursive: climbed up %2 levels in the hierarchy without finding the top. Widget: %1", (Object)this, (long)n);
        return true;
    }

    public void manageLayout() {
        if (this.isLayoutDirty()) {
            this.layout.layout();
            this.setLayoutDirty(false);
            this.notifyCallbacksMenuLayouted();
        }
    }

    boolean tryPostponeRefresh() {
        if (this.shouldRenderRecursive()) {
            return false;
        }
        this.setLayoutItemsDirty(true);
        return true;
    }

    public void managePostponedRefresh() {
        if (this.isLayoutItemsDirty()) {
            menuLogCh.log(-2137614336, "MenuController#managePostPonedRefresh: refresh now. (%1)", (Object)this);
            this.setLayoutItemsDirty(false);
            if (this.model instanceof ChoiceModelGUI) {
                this.updateVisibleItemFromModel();
            }
            this.refreshAllItems();
            this.updateSelection();
            this.updateFocusedPropertyObject();
            this.itemFocusedPropagator.fireItemFocused();
            this.relayout();
            this.setLayoutItemsDirty(false);
        }
    }

    private void setLayoutDirty(boolean bl) {
        this.layoutDirty = bl;
    }

    public boolean isLayoutDirty() {
        return this.layoutDirty;
    }

    public boolean isLayoutItemsDirty() {
        return this.layoutItemsDirty;
    }

    private void setLayoutItemsDirty(boolean bl) {
        this.layoutItemsDirty = bl;
        if (bl) {
            this.setCompositesDirty(true);
        }
    }

    private void ensureMergeTimerRunning() {
        MenuMergeTimerController menuMergeTimerController = this.getCursorMergeWidget();
        if (menuMergeTimerController != null && !menuMergeTimerController.isTimerRunning()) {
            menuLogCh.log(-2137614336, "MenuController#ensureMergeTimerRunning: merge timer is not running, so restart it");
            menuMergeTimerController.restartTimer();
        }
    }

    MenuMergeTimerController getCursorMergeWidget() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof MenuMergeTimerController)) continue;
            return (MenuMergeTimerController)abstractWidgetController;
        }
        return null;
    }

    boolean hasExpandTimerWidget() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof MenuExpandTimerController)) continue;
            return true;
        }
        return false;
    }

    public void destroyMenuItem(MenuItemMetaData menuItemMetaData) {
        AbstractWidget abstractWidget = this.getChild(menuItemMetaData.index.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            ((IMenuItemMultiItem)((Object)abstractWidget)).destroyMenuItem(menuItemMetaData);
        } else {
            if (menuItemMetaData.widget != abstractWidget) {
                throw new IllegalArgumentException(new StringBuffer().append("Specified widget and index are inconsistent: ").append(menuItemMetaData.index).append(": specified: ").append(menuItemMetaData.widget).append(", actual: ").append(abstractWidget).toString());
            }
            this.setMenuItemVisible(menuItemMetaData.widget, false);
        }
        this.relayout();
    }

    protected void setMenuItemVisible(AbstractWidget abstractWidget, boolean bl) {
        if (bl) {
            abstractWidget.setOnScreen(true);
        } else {
            abstractWidget.setOnScreen(false);
        }
    }

    protected boolean isActiveMenuItem(AbstractWidget abstractWidget) {
        return this.isMenuItem(abstractWidget) && abstractWidget.isVisible() && abstractWidget.isVisibleOnCurrentStage() && (!this.hasMoveItem() || !this.shouldHideInMoveMode(abstractWidget));
    }

    private boolean shouldHideInMoveMode(AbstractWidget abstractWidget) {
        return !(abstractWidget instanceof IMenuItemMultiItem);
    }

    public boolean isMenuItem(AbstractWidget abstractWidget) {
        if (this.unreachableItemWidgets != null && this.unreachableItemWidgets.contains(abstractWidget)) {
            return false;
        }
        return abstractWidget instanceof IMenuItem;
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (!this.menuModelStatusOk()) {
            menuLogCh.log(-1601830656, "MenuController#keyTurned: status of menuModel %1 is %2!", this.model, (long)((AbstractModel)this.model).getStatus());
            return;
        }
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#keyTurned: received user event: %1 (%2)", (Object)wheelButtonEvent, (Object)this);
        this.managePostponedRefresh();
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.keyTurned(wheelButtonEvent);
        }
        if (this.hasFocusedItem()) {
            object = this.animationManager.getLayoutData().findAnimationItem(this.focusedIndex);
            if (object == null) {
                menuLogCh.log(-1601830656, "MenuController#keyTurned: Focused item can not be found. Focused index: %1", (Object)this.focusedIndex);
            } else if (!((MenuItemMetaData)object).isRealized()) {
                menuLogCh.log(-2137614336, "MenuController#keyTurned: Focused item is not realized. Focused index: %1", (Object)this.focusedIndex);
            } else {
                ((MenuItemMetaData)object).widget.keyTurned(wheelButtonEvent);
            }
        }
        if (!wheelButtonEvent.isConsumed()) {
            this.keyEventHandler.keyTurned(wheelButtonEvent);
        }
    }

    private boolean isSpellerActive() {
        if (this.focusedIndex == null) {
            return false;
        }
        Object object = this.getChildren().get(this.focusedIndex.widget);
        return object instanceof TouchController;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.focusedIndexBeforeMerge = this.focusedIndex != null ? this.focusedIndex.widgetPart : -1;
        if (!this.menuModelStatusOk()) {
            menuLogCh.log(-2137614336, "MenuController#keyPressed: ignore keyPress because of status of menuModel %1. Status: %2!", this.model, (long)((AbstractModel)this.model).getStatus());
            return;
        }
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#keyPressed: received user event: %1, focused item: %2 (%3)", (Object)keyEvent, (Object)this.focusedIndex, (Object)this);
        int n = keyEvent.getKeyCode();
        if (n != 17 && n != 15) {
            if (this.isKeyCodeForOptionDrawer(n)) {
                this.keyEventHandler.brakeFastViewportScrolling(true);
            }
            return;
        }
        this.managePostponedRefresh();
        Iterator iterator = this.otherNonMenuItems.iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            abstractWidgetController.keyPressed(keyEvent);
        }
        this.keyEventHandler.keyPressed(keyEvent);
        if (!keyEvent.isConsumed()) {
            if (this.isLongPressKeyEvent(n)) {
                this.keyEventHandler.startLongpressTimer();
                keyEvent.setSdsAction(3);
            } else {
                this.handleKeyPressOnItem(keyEvent);
            }
        }
    }

    private boolean isKeyCodeForOptionDrawer(int n) {
        if (this.isLTR()) {
            return n == 11;
        }
        return n == 9;
    }

    private void handleKeyPressOnItem(KeyEvent keyEvent) {
        AbstractWidget abstractWidget;
        int n = keyEvent.getKeyCode();
        if (this.hasFocusedItem()) {
            if (this.animationManager.isScrollAnimationRunning()) {
                menuLogCh.log(1078071040, "MenuController#keyPressed: ignore event, because scroll animation is running");
                keyEvent.setSdsAction(3);
                if (n == 17) {
                    keyEvent.consume(false);
                }
            } else {
                this.itemFocusedPropagator.fireItemFocused();
                this.checkSDSEventHandlerCreated();
                if (this.sdsEventHandler != null && n == 17) {
                    this.sdsEventHandler.keyPressedOnMenuItem(keyEvent, this.focusedIndex);
                }
                abstractWidget = this.getChild(this.focusedIndex.widget);
                this.fireKeyPressedToChild(keyEvent, abstractWidget);
                this.handleInfolineOnKeyPress(keyEvent, abstractWidget);
            }
        }
        if (this.shouldCancelMoveMode(keyEvent)) {
            this.cancelMoveMode();
            keyEvent.consume();
        }
        if (!(n != 15 || keyEvent.isConsumed() || (abstractWidget = this.getVisibleTouchfield()) == null || ((TouchController)abstractWidget).getInputData().isEmpty() || ((TouchController)abstractWidget).isAllInputLocked())) {
            this.jumpToTouchInput();
            ((TouchController)abstractWidget).handleSpellerLastMode();
            keyEvent.consume(true);
        }
    }

    private TouchController getVisibleTouchfield() {
        Iterator iterator = this.touchfields.iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!this.isActiveMenuItem(abstractWidgetController)) continue;
            return (TouchController)abstractWidgetController;
        }
        return null;
    }

    private boolean isLongPressKeyEvent(int n) {
        return !this.isSpellerActive() && n == 17 && this.isLongpressAvailable();
    }

    private boolean menuModelStatusOk() {
        return this.model == null || this.model instanceof AbstractModel && ((AbstractModel)this.model).getStatus() == 1;
    }

    private void fireKeyPressedToChild(KeyEvent keyEvent, AbstractWidget abstractWidget) {
        if (!keyEvent.isConsumed()) {
            if (abstractWidget instanceof IMenuItemMultiItem) {
                IMenuItemMultiItem iMenuItemMultiItem = (IMenuItemMultiItem)((Object)abstractWidget);
                iMenuItemMultiItem.keyPressed(keyEvent, this.focusedIndex.widgetPart);
            } else {
                abstractWidget.keyPressed(keyEvent);
            }
        }
    }

    private void handleInfolineOnKeyPress(KeyEvent keyEvent, AbstractWidget abstractWidget) {
        if (!keyEvent.isConsumed() && keyEvent.getKeyCode() == 17 && !this.isEnabled(this.focusedIndex)) {
            boolean bl = this.showInfolineOnFocusedItem(false);
            if (!bl && abstractWidget.isFunctional()) {
                int n = abstractWidget.getEvent();
                this.fireSMEvent(this.terminal.getTerminalID(), n);
            }
            keyEvent.consume();
        }
    }

    private boolean shouldCancelMoveMode(KeyEvent keyEvent) {
        if (keyEvent.isConsumed()) {
            return false;
        }
        if (!this.hasMoveItem()) {
            return false;
        }
        if (keyEvent.getKeyCode() == 15) {
            return true;
        }
        if (keyEvent instanceof JoystickEvent) {
            int n = ((JoystickEvent)keyEvent).getDirection();
            return n == 8;
        }
        return false;
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        AbstractWidgetController abstractWidgetController;
        if (!this.menuModelStatusOk()) {
            menuLogCh.log(-1601830656, "MenuController#keyMoved: status of menuModel %1 is %2!", this.model, (long)((AbstractModel)this.model).getStatus());
            return;
        }
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#keyMoved: received user event: %1 (%2)", (Object)joystickEvent, (Object)this);
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.keyMoved(joystickEvent);
        }
        if (this.isOptionDrawerDirection(joystickEvent.getDirection())) {
            this.keyEventHandler.brakeFastViewportScrolling(true);
        }
        if (this.hasFocusedItem()) {
            this.itemFocusedPropagator.fireItemFocused();
            object = this.getChild(this.focusedIndex.widget);
            ((AbstractWidget)object).keyMoved(joystickEvent);
        }
        if (!joystickEvent.isConsumed() && joystickEvent.getDirection() == 2 && !this.hasMoveItem()) {
            boolean bl = this.jumpToTouchInput();
            abstractWidgetController = this.getVisibleTouchfield();
            if (bl && abstractWidgetController != null) {
                ((TouchController)abstractWidgetController).handleSpellerLastMode();
                joystickEvent.consume(true);
            }
        }
        if (this.shouldCancelMoveMode(joystickEvent)) {
            this.cancelMoveMode();
            joystickEvent.consume();
        }
    }

    public boolean jumpToTouchInput() {
        TouchController touchController = this.getVisibleTouchfield();
        if (touchController != null && this.isActiveMenuItem(touchController)) {
            MenuItemIndex menuItemIndex = this.getMenuItemIndex(touchController);
            if (!this.hasFocusedItem() || !this.getFocusedIndex().equals(menuItemIndex)) {
                menuLogCh.log(-2137614336, "MenuController#jumpToTouchInput: focus touchfield with index: %1", (Object)menuItemIndex);
                this.focusItemImmediately(menuItemIndex, FocusAdvice.VIEWPORT_FIRST_POSITION);
                return true;
            }
        }
        return false;
    }

    public void jumpToTop() {
        MenuItemIndex menuItemIndex = this.getFirstMenuItem();
        if (menuItemIndex == null) {
            menuLogCh.log(-2137614336, "MenuController#jumpToTop: menu is empty");
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#jumpToTop: focus first item: %1", (Object)menuItemIndex);
        this.focusItemImmediately(menuItemIndex, FocusAdvice.VIEWPORT_FIRST_POSITION);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        Object object;
        int n = keyEvent.getKeyCode();
        if (!this.menuModelStatusOk()) {
            menuLogCh.log(-2137614336, "MenuController#keyReleased: ignore keyRelease because of status of menuModel %1. Status: %2!", this.model, (long)((AbstractModel)this.model).getStatus());
            if (!this.isLongPressKeyEvent(n)) {
                keyEvent.setSdsAction(3);
            }
            return;
        }
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#keyReleased: received user event: %1 (%2)", (Object)keyEvent, (Object)this);
        if (n != 17 && n != 15) {
            return;
        }
        this.managePostponedRefresh();
        if (this.isLongPressKeyEvent(n)) {
            boolean bl = this.keyEventHandler.cancelLongpressTimer();
            if (bl) {
                object = new KeyEvent(null, 10401, 17, keyEvent.getTerminalID());
                this.handleKeyPressOnItem((KeyEvent)object);
                keyEvent.setSdsAction(((KeyEvent)object).getSdsAction());
                if (((ATIPEvent)object).isConsumed()) {
                    keyEvent.consume(((KeyEvent)object).isRepaintNeeded());
                }
            }
        } else {
            keyEvent.setSdsAction(3);
        }
        Object object2 = this.otherNonMenuItems.iterator();
        while (object2.hasNext()) {
            object = (AbstractWidgetController)object2.next();
            ((AbstractWidget)object).keyReleased(keyEvent);
        }
        this.keyEventHandler.keyReleased(keyEvent);
        if (this.hasFocusedItem()) {
            this.itemFocusedPropagator.fireItemFocused();
            object2 = this.getChild(this.focusedIndex.widget);
            if (object2 instanceof IMenuItemMultiItem) {
                object = (IMenuItemMultiItem)object2;
                object.setFocusedCursorBeforeMerge(this.focusedIndexBeforeMerge);
                object.keyReleased(keyEvent, this.focusedIndex.widgetPart);
            } else {
                ((AbstractWidget)object2).keyReleased(keyEvent);
            }
        }
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#touchPadCharactersRecognized: received user event: %1 (%2)", (Object)touchEvent, (Object)this);
        this.touchScrollMode |= this.keyEventHandler.isCursorSwipeGesture(touchEvent);
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.touchPadCharactersRecognized(touchEvent);
        }
        if (!this.touchScrollMode && !touchEvent.isConsumed() && this.hasFocusedItem() && !this.animationManager.isScrollAnimationRunning()) {
            this.itemFocusedPropagator.fireItemFocused();
            object = this.getChild(this.focusedIndex.widget);
            if (!(object instanceof IMenuItemMultiItem)) {
                ((AbstractWidget)object).touchPadCharactersRecognized(touchEvent);
            }
        }
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#touchPadPositionMoved: received user event: %1 (%2)", (Object)touchEvent, (Object)this);
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.touchPadPositionMoved(touchEvent);
        }
        if (this.hasFocusedItem() && (object = this.getChild(this.focusedIndex.widget)) != null) {
            ((AbstractWidget)object).touchPadPositionMoved(touchEvent);
        }
        this.touchScrollMode |= this.keyEventHandler.isCursorSwipeGesture(touchEvent);
        this.keyEventHandler.touchPadPositionMoved(touchEvent);
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#touchPadPressed: received user event: %1 (%2)", (Object)touchEvent, (Object)this);
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.touchPadPressed(touchEvent);
        }
        if (this.hasFocusedItem() && (object = this.getChild(this.focusedIndex.widget)) != null) {
            ((AbstractWidget)object).touchPadPressed(touchEvent);
        }
        this.touchScrollMode = false;
        if (!touchEvent.isConsumed()) {
            this.keyEventHandler.touchPadPressed(touchEvent);
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#touchPadReleased: received user event: %1 (%2)", (Object)touchEvent, (Object)this);
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.touchPadReleased(touchEvent);
        }
        if (this.hasFocusedItem() && (object = this.getChild(this.focusedIndex.widget)) != null) {
            ((AbstractWidget)object).touchPadReleased(touchEvent);
        }
        this.keyEventHandler.touchPadReleased(touchEvent);
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#touchPadApproached: received user event: %1 (%2)", (Object)touchEvent, (Object)this);
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.touchPadApproached(touchEvent);
        }
        if (this.hasFocusedItem() && (object = this.getChild(this.focusedIndex.widget)) != null) {
            ((AbstractWidget)object).touchPadApproached(touchEvent);
        }
        if (!touchEvent.isConsumed()) {
            this.keyEventHandler.touchPadApproached(touchEvent);
        }
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
        if (!this.shouldHandleKeyEvents()) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#touchPadAbandoned: received user event: %1 (%2)", (Object)touchEvent, (Object)this);
        Object object = this.otherNonMenuItems.iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            abstractWidgetController.touchPadAbandoned(touchEvent);
        }
        if (this.hasFocusedItem() && (object = this.getChild(this.focusedIndex.widget)) != null) {
            ((AbstractWidget)object).touchPadAbandoned(touchEvent);
        }
        if (!touchEvent.isConsumed()) {
            this.keyEventHandler.touchPadAbandoned(touchEvent);
        }
    }

    private boolean shouldHandleKeyEvents() {
        return this.hasState(39);
    }

    @Override
    public void processSDSEvent(SDSEvent sDSEvent) {
        if (this.sdsEventHandler != null) {
            this.sdsEventHandler.processSDSEvent(sDSEvent);
        } else {
            menuLogCh.log(10000, "MenuController#processSDSEvent: no SDS event handler (%2). Event: %1", (Object)sDSEvent, (Object)this);
        }
    }

    public void focusItem(MenuItemIndex menuItemIndex) {
        this.animationManager.focus(menuItemIndex);
        this.keyEventHandler.clearCache();
    }

    public void focusItemImmediately(MenuItemIndex menuItemIndex) {
        this.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
    }

    public void focusItemImmediately(MenuItemIndex menuItemIndex, FocusAdvice focusAdvice) {
        this.animationManager.focus(menuItemIndex, focusAdvice, true);
        this.keyEventHandler.clearCache();
    }

    public void focusItemImmediately(MenuUpdateRequest menuUpdateRequest) {
        this.animationManager.focus(menuUpdateRequest, true, true);
        this.keyEventHandler.clearCache();
    }

    public void mergeCursors(FocusAdvice focusAdvice) {
        this.managePostponedRefresh();
        if (!this.hasSelectedItem()) {
            menuLogCh.log(-2137614336, "MenuController#mergeCursors: no selected item. Focus: %1", (Object)this.focusedIndex);
            return;
        }
        if (this.selectedIndex.equals(this.focusedIndex)) {
            menuLogCh.log(-2137614336, "MenuController#mergeCursors: already merged at Index: %1 (focused ID: %2 --> %3)", (Object)this.selectedIndex, (Object)this.focusedUniqueID, (Object)this.selectedUniqueID);
            this.focusedUniqueID = this.selectedUniqueID;
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#mergeCursors: merge cursors. focus: %1, selection: %2", (Object)this.focusedIndex, (Object)this.selectedIndex);
        this.focusItemImmediately(this.selectedIndex, focusAdvice);
    }

    public boolean scrollPage(boolean bl) {
        String string = bl ? "down" : "up";
        MenuViewport menuViewport = this.getViewport();
        if (menuViewport.isEmpty()) {
            MenuItemIndex menuItemIndex;
            MenuItemIndex menuItemIndex2 = menuItemIndex = bl ? this.getLastMenuItem() : this.getFirstMenuItem();
            if (menuItemIndex != null) {
                menuLogCh.log(-2137614336, "MenuController#scrollPage: menu was empty, direction: %1, so goto edge item: %2", (Object)string, (Object)menuItemIndex);
                this.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
                return true;
            }
            menuLogCh.log(-2137614336, "MenuController#scrollPage: menu is empty, direction: %1", (Object)string);
            return false;
        }
        MenuItemIndex menuItemIndex = bl ? menuViewport.end : menuViewport.start;
        Iterator iterator = this.iterator(menuItemIndex, bl, false);
        if (!iterator.hasNext()) {
            menuLogCh.log(-2137614336, "MenuController#scrollPage: end of menu reached at viewport: %2, direction: %1", (Object)string, (Object)menuViewport);
            return false;
        }
        MenuItemIndex menuItemIndex3 = (MenuItemIndex)iterator.next();
        MenuItemIndex menuItemIndex4 = this.calculateOppositeViewportItem(menuItemIndex3, bl);
        menuLogCh.log(-2137614336, "MenuController#scrollPage: old viewport: %2, direction: %1, new viewport edge: %3", (Object)string, (Object)menuViewport, (Object)menuItemIndex4);
        this.focusItemImmediately(menuItemIndex4, FocusAdvice.KEEP_POSITION);
        return true;
    }

    private MenuItemIndex calculateOppositeViewportItem(MenuItemIndex menuItemIndex, boolean bl) {
        if (menuItemIndex == null) {
            return null;
        }
        MenuItemIndex menuItemIndex2 = menuItemIndex;
        int n = this.getMenuItemGlassplateInsets(menuItemIndex, true);
        Iterator iterator = this.iterator(menuItemIndex, bl, true);
        for (int i2 = this.getLayout().getContentAreaHeight(); i2 > n && iterator.hasNext(); i2 -= this.getLayout().getItemsGap()) {
            boolean bl2;
            MenuItemIndex menuItemIndex3 = (MenuItemIndex)iterator.next();
            if (!bl) {
                n = this.getMenuItemGlassplateInsets(menuItemIndex3, true);
            }
            if ((i2 -= this.getMenuItemHeight(menuItemIndex3, bl2 = this.isExpanded(menuItemIndex3))) < n) continue;
            menuItemIndex2 = menuItemIndex3;
        }
        return menuItemIndex2;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        menuLogCh.log(-2137614336, "MenuController#processModelUpdateEvent: received event: %1 (%2)", (Object)modelUpdateEvent, (Object)this);
        new MenuModelEventHandler(this, modelUpdateEvent).processEvent();
    }

    void updateVisibleItemFromModel() {
        int n;
        int n2;
        if (this.currentChoiceModelVisibleWidget != null) {
            this.currentChoiceModelVisibleWidget.setVisible(false);
        }
        if ((n2 = this.getChildIndexForWidgetId(n = ((ChoiceModelGUI)this.model).getValue())) != -1) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(n2);
            abstractWidgetController.setVisible(true);
            this.currentChoiceModelVisibleWidget = abstractWidgetController;
            menuLogCh.log(-2137614336, "MenuController#updateVisibleItemFromModel: current visible item: %1 with ID %2", (long)n2, (long)n);
        } else {
            menuLogCh.log(-1601830656, "MenuController#updateVisibleItemFromModel: Did not find a widget with widgetID=%1. Nothing will be set to visible!", (long)n);
            this.currentChoiceModelVisibleWidget = null;
        }
    }

    public int getMenuItemID(MenuItemIndex menuItemIndex) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItem) {
            return this.getFocusWidgetId((IMenuItem)((Object)abstractWidget));
        }
        menuLogCh.log(10000, "MenuController#getMenuItemID: item %3 does not implement IMenuItem: %2 (%1)", (Object)this, (Object)abstractWidget, (Object)menuItemIndex);
        return -1;
    }

    public int getChildIndexForWidgetId(int n) {
        return this.getChildIndexForWidgetId(n, false);
    }

    int getChildIndexForWidgetId(int n, boolean bl) {
        if (n == -1) {
            menuLogCh.log(-1601830656, "MenuController#getChildForWidgetId: widgetId is -1");
            return -1;
        }
        int n2 = 0;
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (this.isMenuItem(abstractWidgetController)) {
                if (abstractWidgetController instanceof IMenuItem) {
                    int n3;
                    IMenuItem iMenuItem = (IMenuItem)((Object)abstractWidgetController);
                    int n4 = n3 = bl ? this.getFocusWidgetId(iMenuItem) : iMenuItem.getWidgetID();
                    if (n3 == n) {
                        return n2;
                    }
                } else {
                    menuLogCh.log(-1601830656, "MenuController#getChildForWidgetId: menu item does not implement IMenuItem: %1 (%2)", (Object)abstractWidgetController, (Object)this);
                }
            }
            ++n2;
        }
        menuLogCh.log(-1601830656, "MenuController#getChildForWidgetId: no widget found for ID %3, useFocusID: %2, (%1)", (Object)this, (Object)bl, (long)n);
        return -1;
    }

    private int getFocusWidgetId(IMenuItem iMenuItem) {
        if (iMenuItem instanceof ListController && ((ListController)iMenuItem).getModelID() != -1) {
            return ((ListController)iMenuItem).getModelID();
        }
        int n = iMenuItem.getWidgetID();
        if (n != -1) {
            return n;
        }
        if (iMenuItem instanceof AbstractWidgetController) {
            return ((AbstractWidgetController)((Object)iMenuItem)).getModelID();
        }
        return -1;
    }

    @Override
    public void listModelChanged(ListController listController, ModelUpdateEvent modelUpdateEvent) {
        new MenuModelEventHandler(this, listController, modelUpdateEvent).processEvent();
    }

    public void updateOptionDrawerFocusedProperty() {
        if (this.registerAsFocusPropertyProvider && this.isMainAreaMenu() && this.getDrawerFocusManager().getDrawerTargetState() == 8) {
            IFocusedPropertyObject iFocusedPropertyObject = this.getCurrentFocusedPropertyObject();
            menuLogCh.log(-2137614336, "MenuController#updateOptionDrawerFocusedProperty: +++ start update options with focus property: %1. (%2)", (Object)iFocusedPropertyObject, (Object)this);
            this.terminal.getDrawerConditionEngine().setFocusedProperty(iFocusedPropertyObject);
            menuLogCh.log(-2137614336, "MenuController#updateOptionDrawerFocusedProperty: --- finished update options with focus property: %1. (%2)", (Object)iFocusedPropertyObject, (Object)this);
        }
    }

    @Override
    public void selectionChanged(AbstractWidgetController abstractWidgetController) {
        int n = this.getChildren().indexOf(abstractWidgetController);
        this.updateSelection(abstractWidgetController, n, null);
        this.relayout();
    }

    protected void updateSelection(AbstractWidgetController abstractWidgetController, int n, MenuUpdateDelta menuUpdateDelta) {
        MenuItemIndex menuItemIndex = this.getSelectionOfChild(abstractWidgetController, n);
        if (menuItemIndex != null) {
            menuLogCh.log(-2137614336, "MenuController#updateSelection: changed selection to: %1 for child: %2", (Object)menuItemIndex, (Object)abstractWidgetController);
            this.setSelectedIndex(menuItemIndex, menuUpdateDelta);
        } else if (this.selectedIndex != null && this.selectedIndex.widget == n) {
            menuLogCh.log(-2137614336, "MenuController#updateSelection: clear selection %1 from child: %2", (Object)this.selectedIndex, (Object)abstractWidgetController);
            this.setSelectedIndex(null, menuUpdateDelta);
        }
    }

    protected void updateSelection() {
        this.setSelectedIndex(this.calculateSelection());
    }

    MenuItemIndex calculateSelection() {
        int n = 0;
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            MenuItemIndex menuItemIndex = this.getSelectionOfChild(abstractWidget, n);
            if (menuItemIndex != null) {
                return menuItemIndex;
            }
            ++n;
        }
        return null;
    }

    MenuItemIndex getSelectionOfChild(AbstractWidget abstractWidget, int n) {
        if (this.isActiveMenuItem(abstractWidget)) {
            if (abstractWidget instanceof IMenuItemMultiItem) {
                int n2 = ((IMenuItemMultiItem)((Object)abstractWidget)).getSelectedIndex();
                if (n2 != -1) {
                    return new MenuItemIndex(n, n2);
                }
            } else if (abstractWidget instanceof IMenuItemSingle && ((IMenuItemSingle)((Object)abstractWidget)).isSelected()) {
                return new MenuItemIndex(n, 0);
            }
        }
        return null;
    }

    public void collapse(boolean bl) {
        if (this.hasExpandedItem()) {
            this.collapse(this.expandedItem, bl);
        }
    }

    public void collapse(MenuItemIndex menuItemIndex, boolean bl) {
        if (menuItemIndex.equals(this.expandedItem)) {
            menuLogCh.log(-2137614336, "MenuController#collapse: collapse expanded item %1 (%2)", (Object)menuItemIndex, (Object)this);
            this.expandedItem = null;
            this.propagateExpansion(menuItemIndex, false);
            this.animationManager.heightChanged(menuItemIndex, this.createFocusAdviceForCursorPosition(), bl);
            this.clearAllCaches();
        }
    }

    public void expand(MenuItemIndex menuItemIndex, boolean bl) {
        if (menuItemIndex.equals(this.expandedItem)) {
            menuLogCh.log(-2137614336, "MenuController#expand: item %1 is already expanded (%2)", (Object)menuItemIndex, (Object)this);
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#expand: expand item %1 (%2)", (Object)menuItemIndex, (Object)this);
        if (this.expandedItem != null) {
            this.collapse(this.expandedItem, bl);
        }
        this.expandedItem = menuItemIndex;
        this.propagateExpansion(menuItemIndex, true);
        this.animationManager.heightChanged(menuItemIndex, this.createFocusAdviceForCursorPosition(), bl);
        this.clearAllCaches();
    }

    public void expandFocusedItem(boolean bl) {
        if (!this.hasFocusedItem()) {
            menuLogCh.log(-1601830656, "MenuController#expandFocusedItem: there is no focused item (%1)", (Object)this);
            return;
        }
        this.expand(this.focusedIndex, bl);
    }

    public boolean hasExpandedItem() {
        return this.expandedItem != null;
    }

    private void propagateExpansion(MenuItemIndex menuItemIndex, boolean bl) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemSingle) {
            ((IMenuItemSingle)((Object)abstractWidget)).showExtended(bl);
        } else if (abstractWidget instanceof IMenuItemMultiItem) {
            ((IMenuItemMultiItem)((Object)abstractWidget)).showExtended(bl, menuItemIndex.widgetPart);
            MenuItemMetaData menuItemMetaData = this.animationManager.getLayoutData().findAnimationItem(menuItemIndex);
            if (menuItemMetaData != null && menuItemMetaData.widget instanceof IMenuItemSingle) {
                ((IMenuItemSingle)((Object)menuItemMetaData.widget)).showExtended(bl);
            }
        }
    }

    public void updateInfoline() {
        if (this.isInfolineVisible()) {
            this.showInfolineOnFocusedItem(true);
        }
    }

    public boolean showInfolineOnFocusedItem(boolean bl) {
        if (AbstractWidget.framework.getScreenRes() == 0) {
            return false;
        }
        if (!this.hasFocusedItem()) {
            menuLogCh.log(-1601830656, "MenuController#showInfolineOnFocusedItem: there is no focused item");
            return false;
        }
        if (this.infoline == null) {
            menuLogCh.log(-1601830656, "MenuController#showInfolineOnFocusedItem: there is no infoLine widget in this menu");
            return false;
        }
        AbstractWidget abstractWidget = this.getChild(this.focusedIndex.widget);
        if (abstractWidget instanceof MenuItemController) {
            ((MenuItemController)abstractWidget).updateInfoLineText();
        }
        String string = this.infoline.getText();
        String string2 = this.getInfolineText(this.focusedIndex);
        boolean bl2 = Util.equals(this.infolineItemIndex, this.focusedIndex);
        if (Util.equals(string, string2) && bl2) {
            menuLogCh.log(-2137614336, "MenuController#showInfolineOnFocusedItem: infoline text for item %1 has not changed: \"%2\"", (Object)this.focusedIndex, (Object)string2);
            return this.isInfolineVisible();
        }
        if (string2 == null || string2.length() == 0) {
            menuLogCh.log(-2137614336, "MenuController#showInfolineOnFocusedItem: item %1 has no infoline text", (Object)this.focusedIndex);
            if (this.isInfolineVisible()) {
                this.hideInfoline(bl);
            }
            return false;
        }
        menuLogCh.log(-2137614336, "MenuController#showInfolineOnFocusedItem: show infoline for item %2, immediately: %1, text: \"%3\"", bl, (Object)this.focusedIndex, (Object)string2);
        if (this.isInfolineVisible()) {
            menuLogCh.log(-2137614336, "MenuController#showInfolineOnFocusedItem: old infoline was: item %1, \"%2\"", (Object)this.infolineItemIndex, (Object)string);
            if (!bl2) {
                this.hideInfoline(true);
            }
        }
        this.infoline.setText(string2);
        this.infolineItemIndex = this.focusedIndex;
        this.previousInfolineItemIndex = null;
        this.infolineChanged(this.focusedIndex, bl);
        return true;
    }

    public void hideInfoline(boolean bl) {
        if (this.infolineItemIndex == null) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#hideInfoline: hide infoline from item %2, immediately: %1", bl, (Object)this.infolineItemIndex);
        MenuItemIndex menuItemIndex = this.infolineItemIndex;
        if (!bl) {
            this.previousInfolineItemIndex = this.infolineItemIndex;
        } else {
            this.layout.getLayoutData().infolineHeightBefore = 0;
            this.layout.getLayoutData().infolineHeightAfter = 0;
        }
        this.infolineItemIndex = null;
        this.infolineChanged(menuItemIndex, bl);
    }

    private void infolineChanged(MenuItemIndex menuItemIndex, boolean bl) {
        if (this.tryPostponeRefresh()) {
            menuLogCh.log(-2137614336, "MenuController#infolineChanged: postpone refresh for index %1, (%2)", (Object)menuItemIndex, (Object)this);
            this.previousInfolineItemIndex = null;
            if (!this.isInfolineVisible()) {
                this.layout.getLayoutData().infolineHeightBefore = 0;
                this.layout.getLayoutData().infolineHeightAfter = 0;
            }
            return;
        }
        this.animationManager.heightChanged(menuItemIndex, this.createFocusAdviceForCursorPosition(), bl);
        this.clearAllCaches();
        this.notifyScrollbarInfolineChanged();
        this.relayout();
    }

    public boolean isInfolineVisible() {
        return this.infolineItemIndex != null;
    }

    private String getInfolineText(MenuItemIndex menuItemIndex) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemSingle) {
            IMenuItemSingle iMenuItemSingle = (IMenuItemSingle)((Object)abstractWidget);
            if (iMenuItemSingle.hasInfolineText()) {
                return iMenuItemSingle.getInfolineText();
            }
            if (!abstractWidget.isEnabled()) {
                return this.getDefaultDisabledInfolineText();
            }
            return null;
        }
        if (abstractWidget instanceof IMenuItemMultiItem) {
            IMenuItemMultiItem iMenuItemMultiItem = (IMenuItemMultiItem)((Object)abstractWidget);
            if (iMenuItemMultiItem.hasInfolineText(menuItemIndex.widgetPart)) {
                return iMenuItemMultiItem.getInfolineText(menuItemIndex.widgetPart);
            }
            if (!iMenuItemMultiItem.isEnabled(menuItemIndex.widgetPart)) {
                return this.getDefaultDisabledInfolineText();
            }
            return null;
        }
        return null;
    }

    private String getDefaultDisabledInfolineText() {
        if (this.defaultDisabledInfolineTextId == -1) {
            return null;
        }
        if (!this.isConnected()) {
            menuLogCh.log(10000, "MenuController#getDefaultDisabledInfolineText: menu is not connected: %1", (Object)this);
            return null;
        }
        int n = this.terminal.getViewSizeManager().getCurrentViewSize();
        return this.getInitContext().getScreenFactory().getText(this.defaultDisabledInfolineTextId, n);
    }

    public void clearAllCaches() {
        this.keyEventHandler.clearCache();
        if (this.scrollbar != null) {
            this.scrollbar.clearCache();
        }
    }

    public void notifyScrollbarInfolineChanged() {
        if (this.scrollbar != null) {
            this.scrollbar.infolineChanged();
        }
    }

    public boolean isEnabled(MenuItemIndex menuItemIndex) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidget)).isEnabled(menuItemIndex.widgetPart);
        }
        return abstractWidget.isEnabled();
    }

    public void updateMultiItemsLengths() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            this.updateMultiItemLength(abstractWidget);
        }
    }

    private void updateMultiItemLength(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof IMenuItemMultiItem) {
            ((IMenuItemMultiItem)((Object)abstractWidget)).updateSubItemCount();
        }
    }

    public MenuItemMetaData updateMenuItem(MenuItemMetaData menuItemMetaData) {
        AbstractWidget abstractWidget = this.getChild(menuItemMetaData.index.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            boolean bl = ((IMenuItemMultiItem)((Object)abstractWidget)).updateMenuItem(menuItemMetaData);
            if (bl) {
                this.updateItemHeight(menuItemMetaData);
                return menuItemMetaData;
            }
            return this.replaceItem(menuItemMetaData);
        }
        this.updateItemHeight(menuItemMetaData);
        return menuItemMetaData;
    }

    private void updateItemHeight(MenuItemMetaData menuItemMetaData) {
        int n;
        if (!menuItemMetaData.remove && menuItemMetaData.heightAfter != (n = this.getMenuItemHeight(menuItemMetaData, this.isExpanded(menuItemMetaData.index)))) {
            menuLogCh.log(-2137614336, "MenuController#updateItemHeight: item %1 height changed from %2 to %3", (Object)menuItemMetaData, (long)menuItemMetaData.heightAfter, (long)n);
            menuItemMetaData.heightAfter = n;
            if (this.isInfolineVisible()) {
                this.layout.getLayoutData().infolineHeightAfter = this.getInfolinePreferredHeight();
            }
        }
    }

    protected MenuItemMetaData replaceItem(MenuItemMetaData menuItemMetaData) {
        this.destroyMenuItem(menuItemMetaData);
        return this.createMenuItem(menuItemMetaData.index);
    }

    public Iterator iterator(MenuItemIndex menuItemIndex, boolean bl, boolean bl2) {
        return new MenuIndexIterator(this, menuItemIndex, null, bl, bl2);
    }

    public Iterator iterator(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, boolean bl) {
        boolean bl2 = menuItemIndex.isBefore(menuItemIndex2);
        return this.iterator(menuItemIndex, menuItemIndex2, bl2, bl);
    }

    public Iterator iterator(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2, boolean bl, boolean bl2) {
        return new MenuIndexIterator(this, menuItemIndex, menuItemIndex2, bl, bl2);
    }

    public MenuItemIndex getFirstMenuItem() {
        int n = 0;
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (this.isActiveMenuItem(abstractWidget)) {
                if (abstractWidget instanceof IMenuItemMulti) {
                    IMenuItemMulti iMenuItemMulti = (IMenuItemMulti)((Object)abstractWidget);
                    if (!MenuController.isEmpty(iMenuItemMulti)) {
                        return new MenuItemIndex(n, 0);
                    }
                } else {
                    return new MenuItemIndex(n, 0);
                }
            }
            ++n;
        }
        return null;
    }

    public MenuItemIndex getLastMenuItem() {
        int n = this.getChildrenSize() - 1;
        ListIterator listIterator = this.getChildren().listIterator(this.getChildrenSize());
        while (listIterator.hasPrevious()) {
            AbstractWidget abstractWidget = (AbstractWidget)listIterator.previous();
            if (this.isActiveMenuItem(abstractWidget)) {
                if (abstractWidget instanceof IMenuItemMulti) {
                    IMenuItemMulti iMenuItemMulti = (IMenuItemMulti)((Object)abstractWidget);
                    if (!MenuController.isEmpty(iMenuItemMulti)) {
                        return new MenuItemIndex(n, MenuController.getLastSubitemIndex(iMenuItemMulti));
                    }
                } else {
                    return new MenuItemIndex(n, 0);
                }
            }
            --n;
        }
        return null;
    }

    public MenuItemIndex getMenuItemIndex(AbstractWidget abstractWidget) {
        if (abstractWidget.getParent() == this) {
            int n = this.getChildren().indexOf(abstractWidget);
            if (n == -1) {
                return null;
            }
            return new MenuItemIndex(n, 0);
        }
        menuLogCh.log(10000, "MenuController#getMenuItemIndex: currently only supported for single-items. Widget: %1", (Object)abstractWidget);
        return null;
    }

    public boolean isValidMenuItemIndex(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null || menuItemIndex.widget < 0 || menuItemIndex.widget >= this.getChildrenSize()) {
            return false;
        }
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (!this.isActiveMenuItem(abstractWidget)) {
            return false;
        }
        if (abstractWidget instanceof IMenuItemMulti) {
            IMenuItemMulti iMenuItemMulti = (IMenuItemMulti)((Object)abstractWidget);
            if (MenuController.isEmpty(iMenuItemMulti)) {
                return false;
            }
            return menuItemIndex.widgetPart >= 0 && menuItemIndex.widgetPart <= MenuController.getLastSubitemIndex(iMenuItemMulti);
        }
        return menuItemIndex.widgetPart == 0;
    }

    public int getFlatMenuItemCount() {
        List list = this.getChildren();
        int n = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!this.isActiveMenuItem(abstractWidget)) continue;
            if (abstractWidget instanceof IMenuItemMulti) {
                IMenuItemMulti iMenuItemMulti = (IMenuItemMulti)((Object)abstractWidget);
                n += iMenuItemMulti.getSubItemCount();
                continue;
            }
            ++n;
        }
        return n;
    }

    public int getFlatIndex(MenuItemIndex menuItemIndex) {
        List list = this.getChildren();
        int n = 0;
        if (!this.isValidMenuItemIndex(menuItemIndex)) {
            return -1;
        }
        for (int i2 = 0; i2 < menuItemIndex.widget; ++i2) {
            AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
            if (!this.isActiveMenuItem(abstractWidget)) continue;
            if (abstractWidget instanceof IMenuItemMulti) {
                IMenuItemMulti iMenuItemMulti = (IMenuItemMulti)((Object)abstractWidget);
                n += iMenuItemMulti.getSubItemCount();
                continue;
            }
            ++n;
        }
        AbstractWidget abstractWidget = (AbstractWidget)list.get(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMulti) {
            int n2 = menuItemIndex.widgetPart - 0;
            return n + n2;
        }
        return n;
    }

    public int getMenuItemHeight(MenuItemMetaData menuItemMetaData, boolean bl) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(menuItemMetaData.index.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidgetController)).getPreferredMenuItemHeight(menuItemMetaData, bl) + this.getAdditionalInfoLineHeight(menuItemMetaData.index);
        }
        if (menuItemMetaData.isMultiLine()) {
            return this.getMenuItemHeightMultiLine((IMenuItemMultiLine)((Object)abstractWidgetController), menuItemMetaData.index) + this.getAdditionalInfoLineHeight(menuItemMetaData.index);
        }
        return this.getMenuItemHeight(abstractWidgetController, bl) + this.getAdditionalInfoLineHeight(menuItemMetaData.index);
    }

    public int getMenuItemHeight(MenuItemIndex menuItemIndex, boolean bl) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidget)).getPreferredMenuItemHeight(menuItemIndex.widgetPart, bl) + this.getAdditionalInfoLineHeight(menuItemIndex);
        }
        if (this.isMultiLineItem(abstractWidget)) {
            return this.getMenuItemHeightMultiLine((IMenuItemMultiLine)((Object)abstractWidget), menuItemIndex) + this.getAdditionalInfoLineHeight(menuItemIndex);
        }
        return this.getMenuItemHeight(abstractWidget, bl) + this.getAdditionalInfoLineHeight(menuItemIndex);
    }

    private int getAdditionalInfoLineHeight(MenuItemIndex menuItemIndex) {
        if (this.infoline != null && Util.equals(this.infolineItemIndex, menuItemIndex)) {
            return this.getInfolinePreferredHeight();
        }
        return 0;
    }

    public int getInfolinePreferredHeight() {
        if (this.infoline != null && this.infolineItemIndex != null) {
            return this.infoline.getPreferredHeight(this.layout.getInfolineWidth());
        }
        return 0;
    }

    private int getMenuItemHeightMultiLine(IMenuItemMultiLine iMenuItemMultiLine, MenuItemIndex menuItemIndex) {
        int n = iMenuItemMultiLine.getPreferredLineHeight(menuItemIndex.widgetPart);
        int n2 = menuItemIndex.widgetPart;
        n -= this.getLayout().getItemsGap();
        if (n2 == 0) {
            n += iMenuItemMultiLine.getMargin(true) + iMenuItemMultiLine.getFilledInsets(true);
        }
        if (n2 == MenuController.getLastSubitemIndex(iMenuItemMultiLine)) {
            n += iMenuItemMultiLine.getMargin(false) + iMenuItemMultiLine.getFilledInsets(false);
        }
        return n;
    }

    private int getMenuItemHeight(AbstractWidget abstractWidget, boolean bl) {
        if (abstractWidget instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidget)).getPreferredHeight(bl, this.layout.getContentWidth());
        }
        if (abstractWidget instanceof PreferredDynamicHeight) {
            return ((PreferredDynamicHeight)((Object)abstractWidget)).getPreferredHeight(this.layout.getContentWidth());
        }
        if (abstractWidget instanceof AbstractWidgetController) {
            return ((AbstractWidgetController)abstractWidget).getPreferredHeight();
        }
        return abstractWidget.getHeight();
    }

    public int getMenuItemGlassplateInsets(MenuItemMetaData menuItemMetaData, boolean bl) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(menuItemMetaData.index.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidgetController)).getGlassplateInsets(menuItemMetaData, bl);
        }
        if (menuItemMetaData.isMultiLine()) {
            return this.getMenuItemGlassplateInsetsMultiLine((IMenuItemMultiLine)((Object)abstractWidgetController), menuItemMetaData.index, bl);
        }
        return this.getMenuItemGlassplateInsets(abstractWidgetController, bl);
    }

    public int getMenuItemGlassplateInsets(MenuItemIndex menuItemIndex, boolean bl) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidget)).getGlassplateInsets(menuItemIndex.widgetPart, bl);
        }
        if (this.isMultiLineItem(abstractWidget)) {
            return this.getMenuItemGlassplateInsetsMultiLine((IMenuItemMultiLine)((Object)abstractWidget), menuItemIndex, bl);
        }
        return this.getMenuItemGlassplateInsets(abstractWidget, bl);
    }

    private int getMenuItemGlassplateInsetsMultiLine(IMenuItemMultiLine iMenuItemMultiLine, MenuItemIndex menuItemIndex, boolean bl) {
        int n = iMenuItemMultiLine.getGlassplateInsets(bl);
        int n2 = menuItemIndex.widgetPart;
        if (bl && n2 > 0) {
            n += iMenuItemMultiLine.getFilledInsets(true);
        } else if (!bl && n2 < MenuController.getLastSubitemIndex(iMenuItemMultiLine)) {
            n += iMenuItemMultiLine.getFilledInsets(false);
        }
        return n;
    }

    private int getMenuItemGlassplateInsets(AbstractWidget abstractWidget, boolean bl) {
        if (abstractWidget instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidget)).getGlassplateInsets(bl);
        }
        return 0;
    }

    public int getMenuItemMargin(MenuItemMetaData menuItemMetaData, boolean bl) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(menuItemMetaData.index.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidgetController)).getMargin(menuItemMetaData, bl);
        }
        if (menuItemMetaData.isMultiLine()) {
            return this.getMenuItemMarginMultiLine((IMenuItemMultiLine)((Object)abstractWidgetController), menuItemMetaData.index, bl);
        }
        return this.getMenuItemMargin(abstractWidgetController, bl);
    }

    public int getMenuItemMargin(MenuItemIndex menuItemIndex, boolean bl) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidget)).getMargin(menuItemIndex.widgetPart, bl);
        }
        if (this.isMultiLineItem(abstractWidget)) {
            return this.getMenuItemMarginMultiLine((IMenuItemMultiLine)((Object)abstractWidget), menuItemIndex, bl);
        }
        return this.getMenuItemMargin(abstractWidget, bl);
    }

    private int getMenuItemMarginMultiLine(IMenuItemMultiLine iMenuItemMultiLine, MenuItemIndex menuItemIndex, boolean bl) {
        int n = menuItemIndex.widgetPart;
        if (bl && n == 0) {
            return iMenuItemMultiLine.getMargin(true) + iMenuItemMultiLine.getFilledInsets(true);
        }
        if (!bl && n == MenuController.getLastSubitemIndex(iMenuItemMultiLine)) {
            return iMenuItemMultiLine.getMargin(false) + iMenuItemMultiLine.getFilledInsets(false);
        }
        return 0;
    }

    private int getMenuItemMargin(AbstractWidget abstractWidget, boolean bl) {
        if (abstractWidget instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidget)).getMargin(bl);
        }
        return 0;
    }

    public int getMenuItemNoCursorArea(MenuItemMetaData menuItemMetaData, boolean bl) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(menuItemMetaData.index.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidgetController)).getNoCursorArea(menuItemMetaData, bl);
        }
        return this.getMenuItemNoCursorArea(abstractWidgetController, bl);
    }

    public int getMenuItemNoCursorArea(MenuItemIndex menuItemIndex, boolean bl) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidget)).getNoCursorArea(menuItemIndex.widgetPart, bl);
        }
        return this.getMenuItemNoCursorArea(abstractWidget, bl);
    }

    private int getMenuItemNoCursorArea(AbstractWidget abstractWidget, boolean bl) {
        if (abstractWidget instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidget)).getNoCursorArea(bl);
        }
        return 0;
    }

    public int getMenuItemFilledInsets(MenuItemMetaData menuItemMetaData, boolean bl) {
        if (!menuItemMetaData.isMultiLine()) {
            return 0;
        }
        if (!menuItemMetaData.isRealized()) {
            boolean bl2 = this.realizeMenuItem(menuItemMetaData);
            if (!bl2) {
                menuLogCh.log(-1601830656, "MenuController#getFilledInsets: can not realize multiLine item: %1", (Object)menuItemMetaData);
                return 0;
            }
            this.setMenuItemVisible(menuItemMetaData.widget, false);
        }
        if (menuItemMetaData.widget instanceof IMenuItemMultiLine) {
            IMenuItemMultiLine iMenuItemMultiLine = (IMenuItemMultiLine)((Object)menuItemMetaData.widget);
            return iMenuItemMultiLine.getFilledInsets(bl);
        }
        menuLogCh.log(-1601830656, "MenuController#getFilledInsets: multiLine item %1 has no MultiLineWidget: %2", (Object)menuItemMetaData, (Object)menuItemMetaData.widget);
        return 0;
    }

    public int getMenuItemFilledInsets(MenuItemIndex menuItemIndex, boolean bl) {
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (!this.isMultiLineItem(abstractWidget)) {
            return 0;
        }
        IMenuItemMultiLine iMenuItemMultiLine = (IMenuItemMultiLine)((Object)abstractWidget);
        return iMenuItemMultiLine.getFilledInsets(bl);
    }

    public boolean isMenuItemFocusable(MenuItemMetaData menuItemMetaData) {
        return this.isMenuItemFocusable(menuItemMetaData.index);
    }

    public boolean isMenuItemFocusable(MenuItemIndex menuItemIndex) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(menuItemIndex.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidgetController)).isFocusable(menuItemIndex.widgetPart);
        }
        if (abstractWidgetController instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidgetController)).isFocusable();
        }
        menuLogCh.log(-1601830656, "MenuController#isMenuItemFocusable: unknown menu item widget: %1", (Object)abstractWidgetController);
        return true;
    }

    protected MenuItemMetaData createMenuItem(MenuItemIndex menuItemIndex) {
        MenuItemMetaData menuItemMetaData;
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(menuItemIndex.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            menuItemMetaData = ((IMenuItemMultiItem)((Object)abstractWidgetController)).createMenuItem(menuItemIndex.widgetPart);
            if (menuItemMetaData == null) {
                menuLogCh.log(-1601830656, "MenuController#createMenuItem: item %1 could not be created. MultiWidget: %2", (Object)menuItemIndex, (Object)abstractWidgetController);
                return null;
            }
            menuItemMetaData.index = menuItemIndex;
            menuItemMetaData.setInitialHeight(this.getMenuItemHeight(menuItemMetaData, this.isExpanded(menuItemIndex)));
        } else {
            menuItemMetaData = new MenuItemMetaData();
            menuItemMetaData.widget = abstractWidgetController;
            menuItemMetaData.index = menuItemIndex;
            if (this.isMultiLineItem(abstractWidgetController)) {
                menuItemMetaData.multiLine = true;
                menuItemMetaData.setInitialHeight(this.getMenuItemHeightMultiLine((IMenuItemMultiLine)((Object)abstractWidgetController), menuItemIndex));
            } else {
                menuItemMetaData.setInitialHeight(this.getMenuItemHeight(abstractWidgetController, this.isExpanded(menuItemIndex)));
            }
        }
        menuLogCh.log(14808325, "MenuController#createMenuItem: item %1 created with height: %2", (Object)menuItemIndex, (long)menuItemMetaData.heightAfter);
        if (menuItemMetaData.isRealized()) {
            this.setMenuItemVisible(menuItemMetaData.widget, false);
        }
        this.relayout();
        return menuItemMetaData;
    }

    public boolean realizeMenuItem(MenuItemMetaData menuItemMetaData) {
        if (menuItemMetaData.isRealized()) {
            return true;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(menuItemMetaData.index.widget);
        if (abstractWidgetController instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidgetController)).realizeMenuItem(menuItemMetaData);
        }
        return true;
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (n == 1) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.focusCursor = abstractWidget;
        } else if (n == 2) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.selectionCursor = abstractWidget;
        } else if (n == 11) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.c2Icon = abstractWidget;
        } else if (n == 3) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.scrollbar = (ScrollbarController)abstractWidget;
        } else if (n == 4) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.background = abstractWidget;
        } else if (n == 9 || n == 5) {
            this.checkRoleIsEmpty(n, abstractWidget);
            if (this.touchfields.isEmpty()) {
                this.touchfields = new ArrayList(2);
            }
            this.touchfields.add(abstractWidget);
        } else if (n == 6) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.sdsNumbersWidget = abstractWidget;
        } else if (n == 7) {
            if (this.otherNonMenuItems.isEmpty()) {
                this.otherNonMenuItems = new ArrayList(2);
            }
            this.otherNonMenuItems.add(abstractWidget);
        } else if (n == 8) {
            this.separatingLines = (SeparatingLines)abstractWidget;
        } else if (n == 10) {
            if (this.nowPlayingOnly.isEmpty()) {
                this.nowPlayingOnly = new ArrayList(2);
            }
            this.nowPlayingOnly.add(abstractWidget);
        } else if (n == 17) {
            if (this.nowPlayingOnlyClipped.isEmpty()) {
                this.nowPlayingOnlyClipped = new ArrayList(2);
            }
            this.nowPlayingOnlyClipped.add(abstractWidget);
        } else if (n == 16) {
            if (this.unreachableItemWidgets.isEmpty()) {
                this.unreachableItemWidgets = new ArrayList(2);
            }
            this.unreachableItemWidgets.add(abstractWidget);
        } else if (n == 12) {
            if (this.startCall.isEmpty()) {
                this.startCall = new ArrayList(2);
            }
            this.startCall.add(abstractWidget);
        } else if (n == 15) {
            if (this.longpressItems.isEmpty()) {
                this.longpressItems = new ArrayList(2);
            }
            this.longpressItems.add(abstractWidget);
        } else if (n == 13) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.infoline = (InfolineController)abstractWidget;
        } else if (n == 14) {
            this.checkRoleIsEmpty(n, abstractWidget);
            this.title = abstractWidget;
        } else {
            menuLogCh.log(10000, "MenuController#add: unknown role %2 for child widget %1", (Object)abstractWidget, (long)n);
        }
        this.add(abstractWidget);
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof IMenuCallback) {
            this.addCallback((IMenuCallback)((Object)abstractWidget));
        } else if (abstractWidget instanceof IMenuCallbackProvider) {
            this.addCallback(((IMenuCallbackProvider)((Object)abstractWidget)).getMenuCallback());
        }
        if (abstractWidget instanceof CoverStackController) {
            this.coverStack = (CoverStackController)abstractWidget;
        }
        this.willAddChild(abstractWidget);
        super.add(abstractWidget);
        this.childAdded(abstractWidget);
    }

    @Override
    public void addWithPosition(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof IMenuCallback) {
            this.addCallback((IMenuCallback)((Object)abstractWidget));
        }
        this.willAddChild(abstractWidget);
        super.addWithPosition(abstractWidget, n);
        this.childAdded(abstractWidget);
    }

    private void willAddChild(AbstractWidget abstractWidget) {
        if (this.isConnected() && abstractWidget instanceof IMenuItemMulti) {
            ((IMenuItemMulti)((Object)abstractWidget)).setMenuSize(this.layout.getContentWidth(), this.layout.getContentAreaHeight(), this.getCurrentOptionsIconSpace());
        }
    }

    private void childAdded(AbstractWidget abstractWidget) {
        if (this.isConnectedSubtree()) {
            if (this.isMenuItem(abstractWidget)) {
                if (!(abstractWidget instanceof IMenuItemMultiItem)) {
                    this.setMenuItemVisible(abstractWidget, false);
                }
                if (this.autoConfigureTabulators) {
                    this.autoConfigureTabulators();
                }
            }
            this.invalidateLayout(abstractWidget);
        }
    }

    private void addCallback(IMenuCallback iMenuCallback) {
        if (this.menuCallbacks == null) {
            this.menuCallbacks = new ArrayList(2);
        }
        this.menuCallbacks.add(iMenuCallback);
    }

    private void checkRoleIsEmpty(int n, AbstractWidget abstractWidget) {
        AbstractWidget abstractWidget2 = this.getChildOfRole(n);
        if (abstractWidget2 != null) {
            menuLogCh.log(-1601830656, "MenuController#add: two children with same role: %3, old child: %1, new child: %2", (Object)abstractWidget2, (Object)abstractWidget, (long)n);
        }
    }

    public void prepareForFocusChange(boolean bl) {
        if (!this.hasFocusedItem()) {
            return;
        }
        this.hideInfoline(bl);
        this.collapse(bl);
    }

    public void prepareForRemove() {
        menuLogCh.log(-2137614336, "MenuController#prepareForRemove: prepare menu for removing items. %1", (Object)this);
        this.setLayoutItemsDirty(true);
    }

    @Override
    public void remove(AbstractWidget abstractWidget) {
        boolean bl;
        boolean bl2 = this.isMenuItem(abstractWidget);
        boolean bl3 = bl = this.autoConfigureTabulators && this.isConnected() && bl2;
        if (bl2) {
            this.adjustIndicesForRemoveItem(abstractWidget);
        }
        super.remove(abstractWidget);
        if (abstractWidget.equals(this.focusCursor)) {
            this.focusCursor = null;
        }
        if (abstractWidget.equals(this.selectionCursor)) {
            this.selectionCursor = null;
        }
        if (abstractWidget.equals(this.scrollbar)) {
            this.scrollbar = null;
        }
        if (abstractWidget.equals(this.background)) {
            this.background = null;
        }
        if (!this.touchfields.isEmpty()) {
            this.touchfields.remove(abstractWidget);
        }
        if (abstractWidget.equals(this.sdsNumbersWidget)) {
            this.sdsNumbersWidget = null;
        }
        if (!this.otherNonMenuItems.isEmpty()) {
            this.otherNonMenuItems.remove(abstractWidget);
        }
        if (!this.nowPlayingOnlyClipped.isEmpty()) {
            this.nowPlayingOnlyClipped.remove(abstractWidget);
        }
        if (!this.nowPlayingOnly.isEmpty()) {
            this.nowPlayingOnly.remove(abstractWidget);
        }
        if (!this.unreachableItemWidgets.isEmpty()) {
            this.unreachableItemWidgets.remove(abstractWidget);
        }
        if (this.menuCallbacks != null && abstractWidget instanceof IMenuCallback) {
            this.menuCallbacks.remove(abstractWidget);
        }
        if (abstractWidget.equals(this.separatingLines)) {
            this.separatingLines = null;
        }
        if (abstractWidget.equals(this.infoline)) {
            this.infoline = null;
        }
        if (abstractWidget.equals(this.title)) {
            this.title = null;
        }
        if (bl) {
            this.autoConfigureTabulators();
        }
    }

    private void adjustIndicesForRemoveItem(AbstractWidget abstractWidget) {
        Object object;
        int n = this.getChildren().indexOf(abstractWidget);
        if (n == -1) {
            menuLogCh.log(10000, "MenuController#adjustIndicesForRemoveItem: removed widget not found in children list: %1, (%2)", (Object)abstractWidget, (Object)this);
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#adjustIndicesForRemoveItem: removed menu child with index %3: %1, (%2)", (Object)abstractWidget, (Object)this, (long)n);
        this.deactivateMoveMode();
        this.collapse(true);
        if (this.isInfolineVisible()) {
            object = this.infolineItemIndex.adjustForRemoveMenuChild(n);
            if (object == null) {
                this.hideInfoline(true);
            } else {
                this.infolineItemIndex = object;
            }
        }
        if (this.hasFocusedItem()) {
            object = this.focusedIndex.adjustForRemoveMenuChild(n);
            if (object == null) {
                menuLogCh.log(-2137614336, "MenuController#adjustIndicesForRemoveItem: focused item %1 was removed", (Object)this.focusedIndex);
                this.focusedUniqueID = null;
            }
            this.focusedIndex = object;
            this.itemFocusedPropagator.adjustForRemoveMenuChild(n);
        }
        if (this.hasSelectedItem()) {
            this.selectedIndex = this.selectedIndex.adjustForRemoveMenuChild(n);
        }
        object = this.animationManager.getLayoutData().layoutItems.iterator();
        while (object.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)object.next();
            MenuItemIndex menuItemIndex = menuItemMetaData.index.adjustForRemoveMenuChild(n);
            if (menuItemIndex == null) {
                object.remove();
                continue;
            }
            menuItemMetaData.index = menuItemIndex;
        }
    }

    public AbstractWidget getChildOfRole(int n) {
        switch (n) {
            case 1: {
                return this.focusCursor;
            }
            case 2: {
                return this.selectionCursor;
            }
            case 3: {
                return this.scrollbar;
            }
            case 4: {
                return this.background;
            }
            case 5: 
            case 9: {
                return this.getVisibleTouchfield();
            }
            case 6: {
                return this.sdsNumbersWidget;
            }
            case 8: {
                return this.separatingLines;
            }
            case 11: {
                return this.c2Icon;
            }
            case 12: {
                menuLogCh.log(10000, "MenuController#getChildOfRole method not supported for this role: %1 - use getChildrenOfRole() instead", (long)n);
                return null;
            }
            case 13: {
                return this.infoline;
            }
            case 14: {
                return this.title;
            }
        }
        menuLogCh.log(10000, "MenuController#getChildOfRole: unknown role: %1", (long)n);
        return null;
    }

    public List getChildrenOfRole(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 8: 
            case 11: 
            case 13: 
            case 14: {
                menuLogCh.log(10000, "MenuController#getChildrenOfRole method not supported for this role: %1 - use getChildOfRole() instead", (long)n);
                return null;
            }
            case 5: 
            case 9: {
                return this.touchfields;
            }
            case 12: {
                return this.startCall;
            }
            case 15: {
                return this.longpressItems;
            }
            case 16: {
                return this.unreachableItemWidgets;
            }
        }
        menuLogCh.log(10000, "MenuController#getChildOfRole: unknown role: %1", (long)n);
        return null;
    }

    public List getNowPlayingOnlyWidgets() {
        return this.nowPlayingOnly;
    }

    public List getNowPlayingOnlyClippedWidgets() {
        return this.nowPlayingOnlyClipped;
    }

    public List getUnreachableItemWidgets() {
        return this.unreachableItemWidgets;
    }

    public List getUnreachableItemsMetaData() {
        if (this.unreachableItemWidgets.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        if (this.unreachableItemsMetaData == null) {
            this.unreachableItemsMetaData = new ArrayList(this.unreachableItemWidgets.size());
            Iterator iterator = this.unreachableItemWidgets.iterator();
            while (iterator.hasNext()) {
                AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
                int n = this.getChildren().indexOf(abstractWidgetController);
                MenuItemMetaData menuItemMetaData = this.createMenuItem(new MenuItemIndex(n, 0));
                this.unreachableItemsMetaData.add(menuItemMetaData);
            }
        }
        return this.unreachableItemsMetaData;
    }

    private void updateUnreachableItemsMetaData() {
        if (this.unreachableItemsMetaData == null) {
            return;
        }
        Iterator iterator = this.unreachableItemsMetaData.iterator();
        while (iterator.hasNext()) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)iterator.next();
            this.updateMenuItem(menuItemMetaData);
        }
    }

    public void setViewport(MenuViewport menuViewport) {
        menuLogCh.log(-2137614336, "MenuController#setViewport: Viewport: %1  -->  %2", (Object)this.viewport, (Object)menuViewport);
        if (menuViewport == null) {
            throw new IllegalArgumentException("Viewport must not be null.");
        }
        MenuViewport menuViewport2 = this.viewport;
        this.viewport = menuViewport;
        if (this.isConnectedSubtree()) {
            boolean bl = !Util.equals(menuViewport2, menuViewport);
            this.notifyCallbacksViewportChanged(bl);
        }
    }

    public MenuViewport getViewport() {
        return this.viewport;
    }

    public void setFocusedIndex(MenuItemIndex menuItemIndex) {
        MenuItemIndex menuItemIndex2 = this.focusedIndex;
        Long l = this.hasMoveItem() ? null : this.getUniqueIDForIndex(menuItemIndex);
        menuLogCh.log(-2137614336, "MenuController#setFocusedIndex: focused index: %1  -->  %2 (ID: %3 --> %4)", (Object)menuItemIndex2, (Object)menuItemIndex, (Object)this.focusedUniqueID, (Object)l);
        boolean bl = Util.equals(menuItemIndex2, menuItemIndex);
        boolean bl2 = this.focusedUniqueID != null && l != null ? this.focusedUniqueID.equals(l) : bl;
        this.focusedIndex = menuItemIndex;
        this.focusedUniqueID = l;
        this.keyEventHandler.clearCache();
        if (this.focusedIndex != null) {
            this.ensureMergeTimerRunning();
        }
        if (!bl) {
            this.cancelFocusDetailTimers();
        }
        this.itemFocusedPropagator.focusedIndexChanged(menuItemIndex2);
        if (!bl2 || !bl) {
            this.focusedItemHasChanged(bl, bl2);
        }
    }

    protected void focusedItemHasChanged(boolean bl, boolean bl2) {
        if (this.isInfolineVisible()) {
            this.hideInfoline(true);
            if (bl2) {
                this.showInfolineOnFocusedItem(true);
            }
        }
        if (this.hasExpandedItem() && !bl) {
            this.collapse(true);
            this.expandFocusedItem(true);
        }
        if (this.focusedPropertyObject != null) {
            this.updateFocusedPropertyObject();
        }
    }

    private Long getUniqueIDForIndex(MenuItemIndex menuItemIndex) {
        AbstractWidget abstractWidget;
        Long l = null;
        if (menuItemIndex != null && (abstractWidget = this.getChild(menuItemIndex.widget)) instanceof IMenuItemMultiItem) {
            l = ((IMenuItemMultiItem)((Object)abstractWidget)).getUniqueIDForItemIndex(menuItemIndex.widgetPart);
        }
        return l;
    }

    public WidgetFocusAdvice createFocusAdviceForCursorPosition() {
        return new WidgetFocusAdvice(this.getFocusAdviceDistance(), this.animationManager.getLayoutData().alignTop);
    }

    private int getFocusAdviceDistance() {
        MenuItemIndex menuItemIndex;
        if (this.getViewport().isEmpty() || !this.hasFocusedItem()) {
            return 0;
        }
        boolean bl = this.animationManager.getLayoutData().alignTop;
        MenuItemIndex menuItemIndex2 = menuItemIndex = bl ? this.viewport.start : this.viewport.end;
        if (this.focusedIndex.equals(menuItemIndex)) {
            return 0;
        }
        MenuItemMetaData menuItemMetaData = this.animationManager.getLayoutData().findAnimationItem(menuItemIndex);
        MenuItemMetaData menuItemMetaData2 = this.animationManager.getLayoutData().findAnimationItem(this.focusedIndex);
        if (menuItemMetaData != null && menuItemMetaData2 != null) {
            int n = Math.abs(this.animationManager.calculateHeightDistance(menuItemMetaData, menuItemMetaData2, true, bl));
            int n2 = this.getMenuItemGlassplateInsets(menuItemMetaData, bl);
            return n + n2;
        }
        if (menuItemMetaData != null) {
            menuLogCh.log(10000, "MenuController#getFocusAdviceDistance: viewport edge %1 not found in layoutItems. Viewport: %2", (Object)menuItemIndex, (Object)this.viewport);
        }
        if (menuItemMetaData2 != null) {
            menuLogCh.log(10000, "MenuController#getFocusAdviceDistance: focused item %1 not found in layoutItems", (Object)this.focusedIndex);
        }
        return 0;
    }

    protected void restartFocusDetailTimers() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractMenuIdleTimerController abstractMenuIdleTimerController;
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!this.isFocusDetailTimer(abstractWidgetController) || (abstractMenuIdleTimerController = (AbstractMenuIdleTimerController)abstractWidgetController).isTimerRunning() || !abstractMenuIdleTimerController.isConnected()) continue;
            abstractMenuIdleTimerController.restartTimer();
        }
    }

    protected void cancelFocusDetailTimers() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!this.isFocusDetailTimer(abstractWidgetController)) continue;
            AbstractMenuIdleTimerController abstractMenuIdleTimerController = (AbstractMenuIdleTimerController)abstractWidgetController;
            abstractMenuIdleTimerController.cancelTimer();
        }
    }

    private boolean isFocusDetailTimer(AbstractWidgetController abstractWidgetController) {
        return abstractWidgetController instanceof InfolineTimerController || abstractWidgetController instanceof MenuExpandTimerController;
    }

    public void notifyCallbacksMenuLayouted() {
        if (this.menuCallbacks == null) {
            return;
        }
        Iterator iterator = this.menuCallbacks.iterator();
        while (iterator.hasNext()) {
            IMenuCallback iMenuCallback = (IMenuCallback)iterator.next();
            iMenuCallback.menuLayouted();
        }
    }

    public void notifyCallbacksViewportChanged(boolean bl) {
        if (this.menuCallbacks == null) {
            return;
        }
        Iterator iterator = this.menuCallbacks.iterator();
        while (iterator.hasNext()) {
            IMenuCallback iMenuCallback = (IMenuCallback)iterator.next();
            iMenuCallback.viewportUpdated(bl);
        }
    }

    public void notifyCallbacksFocusChanged(MenuItemIndex menuItemIndex) {
        if (this.menuCallbacks == null) {
            return;
        }
        Iterator iterator = this.menuCallbacks.iterator();
        while (iterator.hasNext()) {
            IMenuCallback iMenuCallback = (IMenuCallback)iterator.next();
            iMenuCallback.menuFocusChanged(menuItemIndex);
        }
    }

    public void notifyCallbacksFocusChangeFinished() {
        if (this.menuCallbacks == null) {
            return;
        }
        Iterator iterator = this.menuCallbacks.iterator();
        while (iterator.hasNext()) {
            IMenuCallback iMenuCallback = (IMenuCallback)iterator.next();
            iMenuCallback.menuFocusChangeFinished();
        }
    }

    public void notifyCallbacksSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
        if (this.menuCallbacks == null) {
            return;
        }
        Iterator iterator = this.menuCallbacks.iterator();
        while (iterator.hasNext()) {
            IMenuCallback iMenuCallback = (IMenuCallback)iterator.next();
            iMenuCallback.menuSelectionChanged(menuItemIndex, l, menuUpdateDelta);
        }
    }

    @Override
    public IFocusedPropertyObject getCurrentFocusedPropertyObject() {
        this.updateFocusedPropertyObject();
        return this.focusedPropertyObject;
    }

    private IFocusedPropertyObject calculateFocusedPropertyObject() {
        if (this.hasFocusedItem()) {
            AbstractWidget abstractWidget = this.getChild(this.focusedIndex.widget);
            if (abstractWidget instanceof IMenuItemMultiItem) {
                return ((IMenuItemMultiItem)((Object)abstractWidget)).getPropertiesForLine(this.focusedIndex.widgetPart);
            }
            if (abstractWidget instanceof IMenuItemSingle) {
                return ((IMenuItemSingle)((Object)abstractWidget)).getProperty();
            }
        }
        return null;
    }

    public void updateFocusedPropertyObject() {
        boolean bl = this.hasFocusedPropertyObject();
        this.focusedPropertyObject = this.calculateFocusedPropertyObject();
        boolean bl2 = this.hasFocusedPropertyObject();
        if (menuLogCh.isDebug()) {
            boolean bl3 = this.hasNotContextSpecificOptions();
            Buffer buffer = new Buffer();
            buffer.append("has focusProperty: ").append(bl2).append(" (before: ").append(bl);
            buffer.append(", has NotContextSpecificOptions: ").append(bl3).append(")");
            menuLogCh.log(-2137614336, "MenuController#updateFocusedPropertyObject: screen: %4, focus: %1, %2, focusProperty: %3", (Object)this.focusedIndex, (Object)buffer, (Object)this.focusedPropertyObject, (long)this.getScreenId());
        }
        if (bl != bl2) {
            this.getDrawerFocusManager().updateOptionDrawerContent();
            this.relayout();
        }
    }

    public boolean hasOptionsInDrawer() {
        boolean bl = false;
        DrawerController drawerController = (DrawerController)this.getDrawerFocusManager().getOptionDrawer();
        if (drawerController != null) {
            bl = drawerController.canOpen();
        }
        boolean bl2 = this.hasNotContextSpecificOptions();
        boolean bl3 = this.hasOptionsForFocusedItem();
        if (menuLogCh.isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("MenuController#hasOptionsInDrawer screen: ").append(this.getScreenId());
            buffer.append(", hasNotContextSpecificOptions: ").append(bl2);
            buffer.append(", hasOptionsForFocusedItem: ").append(bl3);
            buffer.append(", optionDrawerCanOpen: ").append(bl);
            menuLogCh.log(-2137614336, buffer.toString());
        }
        return (bl2 || bl3) && bl;
    }

    private boolean hasNotContextSpecificOptions() {
        IDrawerConditionEngine iDrawerConditionEngine = this.getTerminalImpl().getDrawerConditionEngine();
        return iDrawerConditionEngine instanceof DrawerConditionEngine && ((DrawerConditionEngine)iDrawerConditionEngine).hasNotContextSpecificEntries();
    }

    private boolean hasOptionsForFocusedItem() {
        if (!this.hasFocusedItem() || !this.hasFocusedPropertyObject()) {
            menuLogCh.log(-2137614336, "MenuController#hasOptionsForFocusedItem !hasFocusedItem(): %1, !hasFocusedPropertyObject(): %2", !this.hasFocusedItem(), !this.hasFocusedPropertyObject());
            return false;
        }
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.getTerminalImpl().getDrawerFocusManager();
        if (iDrawerFocusManagerEvo == null) {
            menuLogCh.log(-2137614336, "MenuController#hasOptionsForFocusedItem drawerManager == null");
            return false;
        }
        DrawerController drawerController = (DrawerController)iDrawerFocusManagerEvo.getOptionDrawer();
        if (drawerController == null) {
            menuLogCh.log(-2137614336, "MenuController#hasOptionsForFocusedItem optionsDrawer == null");
            return false;
        }
        int n = drawerController.getContentType();
        switch (n) {
            case 0: {
                menuLogCh.log(-2137614336, "MenuController#hasOptionsForFocusedItem DrawerController.CONTENT_TYPE_DEFAULT");
                return true;
            }
            case 1: {
                AbstractWidget abstractWidget = this.getChild(this.focusedIndex.widget);
                menuLogCh.log(-2137614336, "MenuController#hasOptionsForFocusedItem DrawerController.CONTENT_TYPE_SPELLER_OPTIONS");
                return abstractWidget instanceof TouchController;
            }
        }
        menuLogCh.log(10000, "MenuController#hasOptionsForFocusedItem: unknown contentType %2 for options drawer: %1", (Object)drawerController, (long)n);
        return true;
    }

    boolean hasFocusedPropertyObject() {
        return this.focusedPropertyObject != null;
    }

    public int getOpenFocusRelatedPartialPopup() {
        if (!this.isConnected()) {
            return -1;
        }
        if (!this.isMainAreaMenu()) {
            return -1;
        }
        for (int i2 = 0; i2 < 14; ++i2) {
            AbstractPartialPopupController abstractPartialPopupController;
            IPartialPopupController iPartialPopupController = this.terminal.getPartialPopupManager().getCurrentVisiblePopup(i2);
            if (!(iPartialPopupController instanceof AbstractPartialPopupController) || !(abstractPartialPopupController = (AbstractPartialPopupController)iPartialPopupController).isRelatedToMainAreaFocus()) continue;
            return iPartialPopupController.getID();
        }
        return -1;
    }

    public MenuItemIndex getFocusedIndex() {
        return this.focusedIndex;
    }

    public boolean hasFocusedItem() {
        return this.focusedIndex != null;
    }

    public Long getFocusedUniqueID() {
        return this.focusedUniqueID;
    }

    public MenuItemIndex getMenuItemIndexForUniqueID(Long l, MenuItemIndex menuItemIndex) {
        if (l == null) {
            return menuItemIndex;
        }
        AbstractWidget abstractWidget = this.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            IMenuItemMultiItem iMenuItemMultiItem = (IMenuItemMultiItem)((Object)abstractWidget);
            Long l2 = iMenuItemMultiItem.getUniqueIDForItemIndex(menuItemIndex.widgetPart);
            if (l.equals(l2)) {
                return menuItemIndex;
            }
            int n = iMenuItemMultiItem.getItemIndexForUniqueID(l);
            if (n != -1) {
                return new MenuItemIndex(menuItemIndex.widget, n);
            }
            menuLogCh.log(-1601830656, "MenuController#getMenuItemIndexForUniqueID: unique ID %3 not found, use index %1 with ID %2", (Object)menuItemIndex, (Object)l2, (Object)l);
            return menuItemIndex;
        }
        return menuItemIndex;
    }

    public MenuItemIndex getSelectedIndex() {
        return this.selectedIndex;
    }

    public Long getSelectedUniqueID() {
        return this.selectedUniqueID;
    }

    public void setSelectedIndex(MenuItemIndex menuItemIndex) {
        this.setSelectedIndex(menuItemIndex, null);
    }

    private void setSelectedIndex(MenuItemIndex menuItemIndex, MenuUpdateDelta menuUpdateDelta) {
        MenuItemIndex menuItemIndex2 = this.selectedIndex;
        Long l = this.selectedUniqueID;
        Long l2 = this.getUniqueIDForIndex(menuItemIndex);
        menuLogCh.log(-2137614336, "MenuController#setSelectedIndex: selected index: %1  -->  %2 (ID %3 -> %4)", (Object)menuItemIndex2, (Object)menuItemIndex, (Object)l, (Object)l2);
        this.selectedIndex = menuItemIndex;
        this.selectedUniqueID = l2;
        if (this.selectedIndex != null) {
            this.ensureMergeTimerRunning();
        }
        this.notifyCallbacksSelectionChanged(menuItemIndex2, l, menuUpdateDelta);
    }

    void setInitialSelectedIndex(MenuItemIndex menuItemIndex) {
        menuLogCh.log(-2137614336, "MenuController#setInitialSelectedIndex: initial selected index: %1", (Object)menuItemIndex);
        this.selectedIndex = menuItemIndex;
        this.selectedUniqueID = this.getUniqueIDForIndex(menuItemIndex);
    }

    public boolean hasSelectedItem() {
        return this.selectedIndex != null;
    }

    public MenuAnimationManager getAnimationManager() {
        return this.animationManager;
    }

    public MenuKeyEventHandler getKeyEventHandler() {
        return this.keyEventHandler;
    }

    public MenuLayout getLayout() {
        return this.layout;
    }

    public MenuLayoutInitialization getInitialization() {
        return this.initialization;
    }

    public MenuItemFocusedPropagator getItemFocusedPropagator() {
        return this.itemFocusedPropagator;
    }

    public MenuSDSEventHandler getSdsEventHandler() {
        return this.sdsEventHandler;
    }

    public void updatePreferredSize() {
        int n;
        if (!this.calculatePreferredSize) {
            return;
        }
        boolean bl = false;
        if (this.preferredWidth == -1) {
            n = this.getPreferredWidth();
            this.calculatedPreferredWidth = this.calculatePreferredWidth();
            if (n != this.getPreferredWidth()) {
                bl = true;
            }
        }
        if (this.preferredHeight == -1) {
            n = this.getPreferredHeight();
            this.calculatedPreferredHeight = this.calculateMenuHeight(this.getFirstMenuItem(), null)[1];
            if (n != this.getPreferredHeight()) {
                bl = true;
            }
        }
        if (bl) {
            this.invalidateParentLayout();
        }
    }

    @Override
    public int getPreferredHeight() {
        int n = super.getPreferredHeight();
        if (n != -1) {
            return n;
        }
        return this.calculatedPreferredHeight;
    }

    @Override
    public int getPreferredWidth() {
        int n = super.getPreferredWidth();
        if (n != -1) {
            return n;
        }
        return this.calculatedPreferredWidth;
    }

    @Override
    public void invalidateLayout(AbstractWidget abstractWidget) {
        if (!this.isConnectedSubtree()) {
            return;
        }
        if (abstractWidget instanceof AbstractWidgetController && !((AbstractWidgetController)abstractWidget).isConnectedSubtree()) {
            return;
        }
        if (abstractWidget != null && !this.isMenuItem(abstractWidget)) {
            if (abstractWidget.equals(this.sdsNumbersWidget)) {
                this.setCompositesDirty(true);
                this.relayout();
            } else if (this.unreachableItemWidgets.contains(abstractWidget)) {
                this.updateUnreachableItemsMetaData();
                this.setCompositesDirty(true);
                this.relayout();
            }
            return;
        }
        this.updatePreferredSize();
        if (this.tryPostponeRefresh()) {
            menuLogCh.log(-2137614336, "MenuController#invalidateLayout: postpone refresh. child widget: %1, (%2)", (Object)abstractWidget, (Object)this);
            return;
        }
        int n = this.getChildren().indexOf(abstractWidget);
        if (n == -1) {
            menuLogCh.log(-1601830656, "MenuController#invalidateLayout: unknown child widget: %1 (%2)", (Object)abstractWidget, (Object)this);
            this.refreshAllItems();
        } else {
            menuLogCh.log(-2137614336, "MenuController#invalidateLayout: invalidate layout for child index: %3, widget: %1 (%2)", (Object)abstractWidget, (Object)this, (long)n);
            this.updateSelection((AbstractWidgetController)abstractWidget, n, null);
            this.refresh(n);
        }
    }

    public int[] calculateMenuHeight(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        int[] nArray = new int[]{0, 0};
        int n = this.getLayout().getItemsGap();
        int n2 = 0;
        int n3 = 0;
        boolean bl = false;
        int n4 = 0;
        if (menuItemIndex != null) {
            Iterator iterator = this.iterator(menuItemIndex, true, true);
            while (iterator.hasNext()) {
                MenuItemIndex menuItemIndex3 = (MenuItemIndex)iterator.next();
                if (n2 == 0) {
                    n2 += this.getMenuItemGlassplateInsets(menuItemIndex3, true);
                } else {
                    n2 += n;
                    if (!bl) {
                        n3 += n;
                    }
                }
                n4 = this.getMenuItemGlassplateInsets(menuItemIndex3, false);
                int n5 = this.getMenuItemHeight(menuItemIndex3, false);
                n2 += n5;
                if (bl |= menuItemIndex3.equals(menuItemIndex2)) continue;
                n3 += n5;
            }
            if (!bl) {
                n3 = 0;
            }
            n2 += n4;
            nArray = new int[]{n3, n2 += this.getLayout().getContentInsetsVert() * 2};
        }
        return nArray;
    }

    private int calculatePreferredWidth() {
        int n = 0;
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!this.isActiveMenuItem(abstractWidgetController)) continue;
            if (abstractWidgetController instanceof IMenuItemSingle) {
                IMenuItemSingle iMenuItemSingle = (IMenuItemSingle)((Object)abstractWidgetController);
                iMenuItemSingle.setOptionsIconSpace(this.getCurrentOptionsIconSpace());
            }
            int n2 = abstractWidgetController.getPreferredWidth();
            int n3 = n2 + this.getLayout().getContentLeftOffset() + this.getLayout().getActiveContentRightOffset(this.getLayout().shouldIncludeOptionsIconSpace(abstractWidgetController));
            n = Math.max(n, n3);
        }
        return n;
    }

    private int getCurrentOptionsIconSpace() {
        boolean bl = false;
        if (this.focusCursor instanceof FocusCursorController) {
            bl = ((FocusCursorController)this.focusCursor).shouldShowOptionsIconForAnyItem();
        }
        return bl ? this.getLayout().getOptionsIconAdditionalRightInsets() : 0;
    }

    public void refreshViewport() {
        this.animationManager.refresh(MenuUpdateRequest.UPDATE_NONE);
    }

    public void refreshAllItems() {
        this.updateMultiItemsLengths();
        this.animationManager.refresh(MenuUpdateRequest.UPDATE_ALL);
        this.clearAllCaches();
    }

    public void refresh(int n) {
        AbstractWidget abstractWidget = this.getChild(n);
        this.updateMultiItemLength(abstractWidget);
        this.animationManager.refresh(new MenuUpdateRequest$MatchMenuChildWidget(n));
        this.clearAllCaches();
    }

    public MenuItemIndex getExpandedItem() {
        return this.expandedItem;
    }

    public void setExpandedItem(MenuItemIndex menuItemIndex) {
        this.expandedItem = menuItemIndex;
    }

    public boolean isExpanded(MenuItemIndex menuItemIndex) {
        return menuItemIndex.equals(this.expandedItem);
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)((Object)this.getInitContext().getScreen());
        if (abstractWidgetController instanceof AbstractScreenWidget && ((AbstractScreenWidget)abstractWidgetController).getSmallStageType() == 3) {
            return;
        }
        this.viewSizeChangeContentOpacity = f2 <= 0x6666663F ? 0.0f : (f2 - 0x6666663F) / -791884739;
        this.handleStageChangeDuringAnimation(bl);
        this.relayout();
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        this.viewSizeChangeContentOpacity = 1.0f;
        this.handleStageChangeDuringAnimation(bl);
        this.relayout();
    }

    private boolean isOptionsIconVisibleForViewSize() {
        if (this.focusCursor instanceof FocusCursorController) {
            FocusCursorController focusCursorController = (FocusCursorController)this.focusCursor;
            return focusCursorController.isOptionsIconVisibleForViewSize();
        }
        return false;
    }

    private void handleStageChangeDuringAnimation(boolean bl) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = false;
        boolean bl5 = bl3 = ((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1;
        if (bl3 && this.currentOptionIconVisibilityForViewSize != (bl2 = this.isOptionsIconVisibleForViewSize())) {
            this.currentOptionIconVisibilityForViewSize = bl2;
            bl4 = true;
        }
        if (!bl && !bl4) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#handleStageChangeDuringAnimation: stage changed, update menu %1", (Object)this);
        if (this.isInfolineVisible()) {
            this.showInfolineOnFocusedItem(true);
        }
        this.updateUnreachableItemsMetaData();
        this.animationManager.refreshItemsForFastUpdate(MenuUpdateRequest.UPDATE_ALL);
        this.relayout();
        this.clearAllCaches();
        this.updatePreferredSize();
    }

    public void setItemsGap(int n) {
        this.layout.setItemsGap(n);
    }

    public void setVerticalBackgroundInsets(int n) {
        this.layout.setBackgroundInsetsVert(n);
    }

    public OptionDrawerIcon getOptionIcon() {
        if (!this.isMainAreaMenu()) {
            return null;
        }
        if (this.terminal == null) {
            return null;
        }
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.getDrawerFocusManager();
        if (iDrawerFocusManagerEvo == null) {
            return null;
        }
        DrawerController drawerController = (DrawerController)iDrawerFocusManagerEvo.getOptionDrawer();
        if (drawerController == null) {
            return null;
        }
        DrawerIcon drawerIcon = drawerController.getDrawerIcon();
        if (drawerIcon == null) {
            return null;
        }
        if (drawerIcon instanceof OptionDrawerIcon) {
            return (OptionDrawerIcon)drawerIcon;
        }
        return null;
    }

    public boolean isMainAreaMenu() {
        AbstractWidget abstractWidget = this.getParent();
        return this.isMainAreaMenu(abstractWidget);
    }

    private boolean isMainAreaMenu(AbstractWidget abstractWidget) {
        AbstractScreenWidget abstractScreenWidget;
        if (abstractWidget == null) {
            return false;
        }
        if (abstractWidget instanceof MenuController) {
            return false;
        }
        AbstractWidget abstractWidget2 = abstractWidget.getParent();
        if (abstractWidget2 instanceof AbstractScreenWidget && abstractWidget.equals((abstractScreenWidget = (AbstractScreenWidget)abstractWidget2).getMainArea())) {
            return true;
        }
        return this.isMainAreaMenu(abstractWidget2);
    }

    public boolean isComboBoxMenu() {
        return this.getParent() instanceof ComboBoxController;
    }

    public ComboBoxController getParentComboBox() {
        return (ComboBoxController)this.getParent();
    }

    public void setFocusCursorVisible(boolean bl, Object object) {
        if (bl) {
            if (this.focusCursorHideReasons != null && this.focusCursorHideReasons.contains(object)) {
                this.focusCursorHideReasons.remove(object);
            } else {
                menuLogCh.log(-2137614336, "MenuController#setFocusCursorVisible: show cursor, but source '%1' was not in list of hide causes: %2", object, (Object)this.focusCursorHideReasons);
            }
        } else {
            if (this.focusCursorHideReasons == null) {
                this.focusCursorHideReasons = new ArrayList(2);
            }
            if (this.focusCursorHideReasons.contains(object)) {
                menuLogCh.log(-2137614336, "MenuController#setFocusCursorVisible: hide cursor, but source '%1' is already in list of hide causes: %2", object, (Object)this.focusCursorHideReasons);
            } else {
                this.focusCursorHideReasons.add(object);
            }
        }
        menuLogCh.log(-2137614336, "MenuController#setFocusCursorVisible: visible: %1, reason: '%2', remaining hide reasons: %3", bl, object, (Object)this.focusCursorHideReasons);
        this.relayout();
    }

    public boolean isFocusCursorVisible() {
        return this.focusCursorHideReasons == null || this.focusCursorHideReasons.isEmpty();
    }

    public float getViewSizeChangeContentOpacity() {
        return this.viewSizeChangeContentOpacity;
    }

    @Override
    public String getInternalInfo() {
        Buffer buffer = new Buffer();
        buffer.append(" focusedDisplayLine=\"");
        buffer.append(this.getFocusedDisplayLineForDiag());
        buffer.append("\"");
        buffer.append(" focusedInternalID=\"");
        buffer.append(this.getFocusedInternalIDForDiag());
        buffer.append("\"");
        return buffer.toString();
    }

    private int getFocusedDisplayLineForDiag() {
        if (!this.hasFocusedItem()) {
            return -1;
        }
        int n = 0;
        Iterator iterator = this.iterator(this.getFirstMenuItem(), this.getFocusedIndex(), true);
        while (iterator.hasNext()) {
            iterator.next();
            ++n;
        }
        return n - 1;
    }

    private int getFocusedInternalIDForDiag() {
        if (!this.hasFocusedItem()) {
            return -1;
        }
        AbstractWidget abstractWidget = this.getChild(this.focusedIndex.widget);
        if (abstractWidget instanceof SubElementMenuController) {
            if (abstractWidget.getChildren().get(0) != null) {
                return ((MenuItemController)abstractWidget.getChildren().get(0)).getInternalID();
            }
            return -1;
        }
        if (abstractWidget instanceof MenuItemController) {
            return ((MenuItemController)abstractWidget).getInternalID();
        }
        if (abstractWidget instanceof MultiLineMenuItemController) {
            return ((MultiLineMenuItemController)abstractWidget).getInternalID();
        }
        return -1;
    }

    public boolean isTouchScrollMode() {
        return this.touchScrollMode;
    }

    public void setSDSSymbolsVisible(boolean bl) {
        this.setSDSActive(bl);
    }

    public void setSDSActive(boolean bl) {
        AbstractWidget abstractWidget;
        if (this.isSDSActive() == bl) {
            return;
        }
        menuLogCh.log(-2137614336, "MenuController#setSDSActive: SDS active: %1, has SDS numbers widget: %2 (%3)", (Object)bl, (Object)(this.sdsNumbersWidget != null ? 1 : 0), (Object)this);
        if (this.sdsEventHandler == null && bl) {
            this.createSDSEventHandler();
        }
        if (this.sdsEventHandler != null) {
            this.sdsEventHandler.setSdsActive(bl);
        }
        if ((abstractWidget = this.getChildOfRole(6)) != null && this.isConnected()) {
            ((MenuSDSNumbersController)abstractWidget).setSdsActive(bl);
        }
        this.notifyChildrenSDSActiveChanged();
        this.relayout();
    }

    private void checkSDSEventHandlerCreated() {
        if (this.sdsEventHandler == null && AbstractWidget.sdsService != null && AbstractWidget.sdsService.isSDSActive()) {
            this.createSDSEventHandler();
        }
    }

    private void createSDSEventHandler() {
        this.sdsEventHandler = new MenuSDSEventHandler(this);
        this.addCallback(this.sdsEventHandler);
    }

    public void notifyChildrenSDSActiveChanged() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (abstractWidget instanceof TouchController) {
                ((TouchController)abstractWidget).setSDSActive(this.isSDSActive());
                continue;
            }
            if (!(abstractWidget instanceof AbstractMenuIdleTimerController) || !this.isConnected()) continue;
            ((AbstractMenuIdleTimerController)abstractWidget).menuSDSActiveChanged();
        }
    }

    public void notifyTimerScrollAnimationFinished() {
        Iterator iterator = this.otherNonMenuItems.iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!(abstractWidget instanceof AbstractMenuIdleTimerController)) continue;
            ((AbstractMenuIdleTimerController)abstractWidget).menuAnimationScrollFinished();
        }
    }

    public void notifyTimerMoveModeChanged() {
        Iterator iterator = this.otherNonMenuItems.iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!(abstractWidget instanceof AbstractMenuIdleTimerController)) continue;
            ((AbstractMenuIdleTimerController)abstractWidget).menuMoveModeChanged();
        }
    }

    public boolean isSDSActive() {
        return this.sdsEventHandler != null && this.sdsEventHandler.isSdsActive();
    }

    @Override
    public IPresetPopupData getPresetPopupData() {
        if (this.focusedIndex == null) {
            menuLogCh.log(1078071040, "MenuController#getPresetPopupData no focusedIndex - return null");
            return null;
        }
        AbstractWidget abstractWidget = this.getChild(this.focusedIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            this.restartCursorMergeTimerOnPresetPopup();
            return ((IMenuItemMultiItem)((Object)abstractWidget)).getPresetPopupData(this.focusedIndex.widgetPart);
        }
        if (abstractWidget instanceof IMenuItemSingle) {
            this.restartCursorMergeTimerOnPresetPopup();
            return ((IMenuItemSingle)((Object)abstractWidget)).getPresetPopupData();
        }
        if (abstractWidget instanceof MenuItemController) {
            this.restartCursorMergeTimerOnPresetPopup();
            return ((MenuItemController)abstractWidget).getPresetPopupData();
        }
        menuLogCh.log(1078071040, "MenuController#getPresetPopupData unknown focused menu item: %1 ", (Object)abstractWidget);
        return null;
    }

    private void restartCursorMergeTimerOnPresetPopup() {
        MenuMergeTimerController menuMergeTimerController = this.getCursorMergeWidget();
        if (menuMergeTimerController != null && menuMergeTimerController.isTimerRunning()) {
            menuLogCh.log(-2137614336, "MenuController#getPresetPopupData: restart merge timer");
            menuMergeTimerController.restartTimer();
        }
    }

    public MenuItemIndex getUnfocusableVisibleEdge(MenuItemIndex menuItemIndex, boolean bl) {
        return this.getUnfocusableVisibleEdge(menuItemIndex, bl, this.getViewport());
    }

    public MenuItemIndex getUnfocusableVisibleEdge(MenuItemIndex menuItemIndex, boolean bl, MenuViewport menuViewport) {
        if (!this.isMenuItemFocusable(menuItemIndex)) {
            MenuItemIndex menuItemIndex2 = menuItemIndex;
            Iterator iterator = this.iterator(menuItemIndex, bl, false);
            while (iterator.hasNext()) {
                MenuItemIndex menuItemIndex3 = (MenuItemIndex)iterator.next();
                if (this.isMenuItemFocusable(menuItemIndex3)) {
                    menuLogCh.log(-2137614336, "MenuController#getUnfocusableVisibleEdge: use last unfocusable item %1 for source: %2", (Object)menuItemIndex2, (Object)menuItemIndex);
                    return menuItemIndex2;
                }
                if (!menuViewport.contains(menuItemIndex3)) {
                    menuLogCh.log(-2137614336, "MenuController#getUnfocusableVisibleEdge: use last visible unfocusable item %1 for source: %2, viewport: %3", (Object)menuItemIndex2, (Object)menuItemIndex, (Object)menuViewport);
                    return menuItemIndex2;
                }
                menuItemIndex2 = menuItemIndex3;
            }
            menuLogCh.log(-2137614336, "MenuController#getUnfocusableVisibleEdge: use menu's last item %1 for source: %2", (Object)menuItemIndex2, (Object)menuItemIndex);
            return menuItemIndex2;
        }
        return menuItemIndex;
    }

    public boolean isMultiLineItem(AbstractWidget abstractWidget) {
        return abstractWidget instanceof IMenuItemMultiLine && ((IMenuItemMultiLine)((Object)abstractWidget)).isScrollLineByLine();
    }

    protected void autoConfigureTabulators() {
        int[] nArray = this.collectTabulatorIDs();
        this.getLayout().setTabulatorIDs(nArray);
        if (nArray != null) {
            int[] nArray2 = new int[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray2[i2] = this.getDefaultTabulatorAlignment(nArray[i2]);
            }
            this.getLayout().setTabulatorAlignments(nArray2);
        }
    }

    private int getDefaultTabulatorAlignment(int n) {
        if (n == 9 || n == 2) {
            return 3;
        }
        return 1;
    }

    private int[] collectTabulatorIDs() {
        Object object;
        ArrayList arrayList = new ArrayList(5);
        Object object2 = this.getChildren().iterator();
        while (object2.hasNext()) {
            int[] nArray;
            AbstractWidget abstractWidget = (AbstractWidget)object2.next();
            if (!this.isMenuItem(abstractWidget) || !(abstractWidget instanceof LayoutContainerController) || !((object = ((LayoutContainerController)abstractWidget).getLayoutManager()) instanceof TabLayoutManager) || (nArray = ((TabLayoutManager)object).getTabulatorIDs()) == null) continue;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                Integer n;
                if (nArray[i2] == -1 || arrayList.contains(n = Util.createInteger(nArray[i2]))) continue;
                arrayList.add(n);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        object2 = new int[arrayList.size()];
        for (int i3 = 0; i3 < ((Object)object2).length; ++i3) {
            object = (Integer)arrayList.get(i3);
            object2[i3] = (Integer)object;
        }
        return object2;
    }

    public void adjustAnimationStartValuesForRestart() {
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        int n5 = this.width;
        if (n4 < 0) {
            n4 = this.getHeight();
        }
        int n6 = this.height;
        super.setBounds(n, n2, n3, n4);
        this.sizeChanged(n5, n6);
    }

    @Override
    public void setWidth(int n) {
        int n2 = this.width;
        super.setWidth(n);
        this.sizeChanged(n2, this.height);
    }

    @Override
    public void setHeight(int n) {
        if (n < 0) {
            n = this.getHeight();
        }
        int n2 = this.height;
        super.setHeight(n);
        this.sizeChanged(this.width, n2);
    }

    private void sizeChanged(int n, int n2) {
        if (n == this.width && n2 == this.height) {
            return;
        }
        if (!this.isConnected()) {
            return;
        }
        this.propagateSizeToMenuItems();
        if (this.tryPostponeRefresh()) {
            menuLogCh.log(-2137614336, "MenuController#sizeChanged: postpone refresh (%1)", (Object)this);
        } else {
            this.refreshAllItems();
            this.relayout();
        }
    }

    private void propagateSizeToMenuItems() {
        int n = this.layout.getContentWidth();
        int n2 = this.layout.getContentAreaHeight();
        int n3 = this.getCurrentOptionsIconSpace();
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!this.isMenuItem(abstractWidget) || !(abstractWidget instanceof IMenuItemMulti)) continue;
            ((IMenuItemMulti)((Object)abstractWidget)).setMenuSize(n, n2, n3);
        }
    }

    public boolean isCalculatePreferredSize() {
        return this.calculatePreferredSize;
    }

    public void setCalculatePreferredSize(boolean bl) {
        this.calculatePreferredSize = bl;
    }

    public void setExpandListToMaxHeight(boolean bl) {
        this.setCalculatePreferredSize(bl);
    }

    public void setInitialFocusWidgetID(int n) {
        this.initialization.setInitialFocusWidgetIDs(new int[]{n});
    }

    public void setInitialFocusAdvice(FocusAdvice focusAdvice) {
        this.initialization.setInitialFocusAdvice(focusAdvice);
    }

    public void setInitialAvoidPartiallyEmptyViewport(boolean bl) {
        this.initialization.setInitialAvoidPartiallyEmptyViewport(bl);
    }

    public boolean isAutoConfigureTabulators() {
        return this.autoConfigureTabulators;
    }

    public void setAutoConfigureTabulators(boolean bl) {
        this.autoConfigureTabulators = bl;
    }

    public MenuItemIndex getInfolineItemIndex() {
        return this.infolineItemIndex;
    }

    public MenuItemIndex getMoveItemIndex() {
        return this.moveItemIndex;
    }

    public void setMoveItemIndex(MenuItemIndex menuItemIndex) {
        this.moveItemIndex = menuItemIndex;
        this.relayout();
        this.notifyTimerMoveModeChanged();
        this.notifyDrawerFocusManagerForMoveModeActive(menuItemIndex != null);
    }

    private void notifyDrawerFocusManagerForMoveModeActive(boolean bl) {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo;
        if (this.terminal != null && (iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager()) != null) {
            iDrawerFocusManagerEvo.setMenuMoveModeActive(bl);
        }
    }

    public void activateMoveModeOnFocus() {
        if (!this.hasFocusedItem()) {
            menuLogCh.log(10000, "MenuController#activateMoveCursorOnFocus: menu has no focused item. Viewport: %1", (Object)this.viewport);
            return;
        }
        boolean bl = this.hasMoveItem();
        this.setMoveItemIndex(this.focusedIndex);
        this.getAnimationManager().getLayoutData().moveGapIndexBefore = this.focusedIndex;
        this.getAnimationManager().getLayoutData().moveGapIndexAfter = this.focusedIndex;
        this.relayout();
        if (!bl) {
            Iterator iterator = this.getChildren().iterator();
            while (iterator.hasNext()) {
                AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
                if (!this.isMenuItem(abstractWidget) || !this.shouldHideInMoveMode(abstractWidget)) continue;
                abstractWidget.setOnScreen(false);
            }
            this.animationManager.refresh(MenuUpdateRequest.UPDATE_ALL);
        }
    }

    public void deactivateMoveMode() {
        boolean bl = this.hasMoveItem();
        this.setMoveItemIndex(null);
        this.getAnimationManager().getLayoutData().moveGapIndexBefore = null;
        this.getAnimationManager().getLayoutData().moveGapIndexAfter = null;
        this.relayout();
        if (bl) {
            this.refreshViewport();
        }
    }

    public void cancelMoveMode() {
        menuLogCh.log(-2137614336, "MenuController#cancelMoveMode: move source: %1, current focus: %2", (Object)this.moveItemIndex, (Object)this.focusedIndex);
        this.focusItemImmediately(this.moveItemIndex, FocusAdvice.KEEP_POSITION);
        KeyEvent keyEvent = new KeyEvent(null, 10401, 17, this.getTerminal().getTerminalID());
        AbstractWidget abstractWidget = this.getChild(this.focusedIndex.widget);
        this.fireKeyPressedToChild(keyEvent, abstractWidget);
    }

    public void moveGapToFocusedIndex() {
        this.getAnimationManager().getLayoutData().moveGapIndexBefore = this.getAnimationManager().getLayoutData().moveGapIndexAfter;
        this.getAnimationManager().getLayoutData().moveGapIndexAfter = this.focusedIndex;
        this.getAnimationManager().startMoveGapAnimation();
    }

    public boolean hasMoveItem() {
        return this.moveItemIndex != null;
    }

    public void setRegisterAsFocusPropertyProvider(boolean bl) {
        this.registerAsFocusPropertyProvider = bl;
    }

    public float getContentTransX() {
        return this.contentTransX;
    }

    public float getContentTransY() {
        return this.contentTransY;
    }

    public void setContentTranslation(float f2, float f3) {
        this.contentTransX = f2;
        this.contentTransY = f3;
    }

    public void setContentOpacity(float f2) {
        this.contentOpacity = f2;
    }

    public float getContentOpacity() {
        return this.contentOpacity;
    }

    public boolean isComboBoxOpen() {
        return this.comboBoxOpen;
    }

    public void setComboBoxOpen(boolean bl) {
        this.comboBoxOpen = bl;
    }

    public boolean isHideOverlayDecoratorDuringScrolling() {
        return this.hideOverlayDecoratorDuringScrolling;
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
        this.hideOverlayDecoratorDuringScrolling = bl;
    }

    public boolean isClipContent() {
        return this.clipContent;
    }

    public void setClipContent(boolean bl) {
        this.clipContent = bl;
    }

    public InfolineController getInfoline() {
        return this.infoline;
    }

    public InfolineTimerController getInfolineTimer() {
        Iterator iterator = this.otherNonMenuItems.iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!(abstractWidget instanceof InfolineTimerController)) continue;
            return (InfolineTimerController)abstractWidget;
        }
        return null;
    }

    public void setInfolineText(String string) {
        if (this.infoline == null) {
            menuLogCh.log(-1601830656, "MenuController#setInfolineText: there is no infoLine widget in this menu");
            return;
        }
        this.infoline.setText(string);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Menu[").append(this.hashCode());
        if (this.modelID > 0) {
            buffer.append(",").append(this.modelID);
        }
        buffer.append(",").append(this.getScreenId());
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public boolean isLongpressAvailable() {
        return this.longpressAvailable;
    }

    public void setLongpressAvailable(boolean bl) {
        this.longpressAvailable = bl;
    }

    public int getDefaultDisabledInfolineTextId() {
        return this.defaultDisabledInfolineTextId;
    }

    public void setDefaultDisabledInfolineTextId(int n) {
        this.defaultDisabledInfolineTextId = n;
    }

    public void setCoverStack(CoverStackController coverStackController) {
        this.coverStack = coverStackController;
    }

    public CoverStackController getCoverStack() {
        return this.coverStack;
    }

    public void setOpenComboboxOpacity(float f2) {
        this.openComboboxOpacity = f2;
    }

    public float getOpenComboboxOpacity() {
        return this.openComboboxOpacity;
    }

    @Override
    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
        this.currentOptionIconVisibilityForViewSize = this.isOptionsIconVisibleForViewSize();
    }

    public int getClipOffsetTop() {
        return this.clipOffsetTop;
    }

    public void setClipOffsetTop(int n) {
        this.clipOffsetTop = n;
    }

    public int getClipOffsetBottom() {
        return this.clipOffsetBottom;
    }

    public void setClipOffsetBottom(int n) {
        this.clipOffsetBottom = n;
    }

    public boolean isFireNotFocusedToModelOnAnimationStart() {
        return this.fireNotFocusedToModelOnAnimationStart;
    }

    public void setFireNotFocusedToModelOnAnimationStart(boolean bl) {
        this.fireNotFocusedToModelOnAnimationStart = bl;
    }

    public int[] getInfolineTextIdsDisabled() {
        return this.infolineTextIdsDisabled;
    }

    public void setInfolineTextIdsDisabled(int[] nArray) {
        this.infolineTextIdsDisabled = nArray;
    }

    public boolean isRadiotextMenu() {
        return this.modelID == -829947648 || this.modelID == -813170432 || this.modelID == 1854472448 || this.modelID == -796393216 || this.modelID == -1450704640;
    }
}

