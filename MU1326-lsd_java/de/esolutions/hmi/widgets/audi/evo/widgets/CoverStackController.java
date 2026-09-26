/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ResourceLocatorListCell;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.ILockingListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.CoverStackRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.DABSlideShowHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoverStackController
extends AbstractWidgetController
implements IMenuCallback,
AnimationListener,
ILockingListener {
    public static final int COVER_IMAGES_COUNT;
    private static final int MAX_LIST_MODEL_LOOK_AHEAD;
    public static final int DEFAULT_IMAGE_MODE_SINGLE;
    public static final int DEFAULT_IMAGE_MODE_MULTI;
    private int defaultImageMode = 0;
    private MenuItemIndex stackTopItem;
    private boolean firstSecondBitmapsEqual;
    private float animationProgress;
    private AbstractAnimation crossFadeAnimation;
    private float crossFadingProgress = 0.0f;
    private boolean crossFadingActive = false;
    static final int ANIMATION_TYPE;
    private boolean interruptCrossFading = false;
    private int crossFadeState = 0;
    private boolean updateState = true;
    private List coverBitmaps;
    private int bitmapColumn = -1;
    private int defaultBitmapColumn = -1;
    private DABSlideShowHandler dabSlsHandler = null;
    private CoverStackRenderer renderer;
    private int modelStaus = 1;
    private boolean expandable = true;
    private boolean nowPlayingMode;
    private boolean isCrossFadeNeeded = false;
    private boolean onlyUpdateOfNowPlayingProgressNeeded = false;
    private float appliedNowPlayingProgress = 0.0f;
    private int primaryBitmapsDefaultIndex = 0;
    private boolean lockingActive;
    private int lockingAction = 0;
    private float lockingShadingOpacity = (float)Integer.getInteger("imageOpacityIfLockingActive", 50).intValue() / 51266;
    private ModelStubController modelStubLockingShade;
    private ModelStubController modelStubLockingInvisible;

    public CoverStackController() {
        IWidgetLogChannel.logLocking.log(-2137614336, "CoverStackController#CoverStackController lockingOpacity=%1", (double)this.lockingShadingOpacity);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(CoverStackRenderer coverStackRenderer) {
        this.renderer = coverStackRenderer;
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.resetStack();
        this.coverBitmaps = new ArrayList(5);
        this.updateFromModel();
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.resetStack();
        this.coverBitmaps = null;
        if (this.dabSlsHandler != null) {
            this.dabSlsHandler.cancelSlsTimer();
        }
        if (this.crossFadeAnimation != null) {
            this.crossFadeAnimation.stopAnimation();
        }
        if (LockingManager.isRegisteredListener(this)) {
            LockingManager.deregisterListener(this);
            this.lockingActive = false;
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        super.processModelUpdateEvent(modelUpdateEvent);
        logChannelCoverStack.log(-2137614336, "CoverStackController#processModelUpdateEvent updateStatus is: %1", this.updateState);
        this.updateLockingAction(modelUpdateEvent);
        if (!this.updateState || modelUpdateEvent != null && modelUpdateEvent.getModelId() != this.modelID) {
            return;
        }
        this.updateFromModel();
        this.setCompositesDirty(true);
    }

    private void updateFromModel() {
        if (this.model instanceof ResourceLocatorModelGUI) {
            this.animationProgress = 0.0f;
            HMIResourceLocator hMIResourceLocator = ((ResourceLocatorModelGUI)this.model).getResourceLocator();
            logChannelCoverStack.log(-2137614336, "CoverStackController#updateFromModel : model value: %1", (Object)hMIResourceLocator);
            this.coverBitmaps.clear();
            this.coverBitmaps.add(hMIResourceLocator);
        } else if (this.model != null) {
            logChannelCoverStack.log(-1601830656, "CoverStackController#updateFromModel: unknown model type. ModelID: %2, Model: %1", this.model, (long)this.modelID);
        }
    }

    @Override
    public void menuLayouted() {
        boolean bl;
        Object object;
        Object object2 = object = this.coverBitmaps.isEmpty() ? null : this.coverBitmaps.get(0);
        if (this.model != null) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#menuLayouted: ignore menu, because coverstack has its own model: %1", this.model);
            return;
        }
        if (!this.shouldRender()) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#menuLayouted: cover stack not visible");
            return;
        }
        if (this.getMenu().hasMoveItem()) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#menuLayouted: Do not update bitmaps because moveitem mode is active in menu");
            return;
        }
        this.calculateStack();
        if (this.dabSlsHandler != null && this.stackTopItem != null && !this.dabSlsHandler.isUpdateEventProccessable(this.getBitmapModel(this.stackTopItem))) {
            if (this.getNowPlayingAnimationProgress() != this.appliedNowPlayingProgress) {
                this.onlyUpdateOfNowPlayingProgressNeeded = true;
                logChannel.log(-2137614336, "CoverStackController#menuLayouted: only update progression for NowPlayingAnimation, DABSlideShow Timer is running");
                this.setCompositesDirty(true);
            } else {
                logChannel.log(-2137614336, "CoverStackController#menuLayouted: blocked processing ResourceLocator UpdateEvent , DABSlideShow Timer is running");
            }
            return;
        }
        this.updateBitmaps(this.stackTopItem);
        Object object3 = this.coverBitmaps.isEmpty() ? null : this.coverBitmaps.get(0);
        logChannelCoverStack.log(-2137614336, "CoverStackController#menuLayouted check for covers: previous= %1, following %2", object, object3);
        boolean bl2 = bl = !this.equalsCovers(object, object3);
        if (bl) {
            this.isCrossFadeNeeded = true;
        }
        if (!this.isExpandable() && bl || this.getNowPlayingAnimationProgress() == 1.0f) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#menuLayouted cover not equals update Covers");
            if (this.crossFadingActive) {
                logChannelCoverStack.log(-2137614336, "CoverStackController#menuLayouted stopAnimation");
                return;
            }
            if (this.isCrossFadeNeeded) {
                this.startCrossFadingAnimation();
                this.isCrossFadeNeeded = false;
            }
        } else {
            logChannelCoverStack.log(-2137614336, "CoverStackController#menuLayouted check failed for covers: previous= %1, following %2", object, object3);
        }
        if (!this.crossFadingActive) {
            this.setCompositesDirty(true);
        }
    }

    private void resetStack() {
        this.stackTopItem = null;
        this.animationProgress = 0.0f;
    }

    private void calculateStack() {
        MenuController menuController = this.getMenu();
        if (menuController.getLayout().getFirstVisibleItem() == -1) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#calculateStack: no items are visible");
            this.resetStack();
            return;
        }
        if (this.isCursorVisibleInViewport()) {
            AbstractWidget abstractWidget = menuController.getChildOfRole(1);
            this.calculateStackForVisibleCursor(abstractWidget);
        } else if (menuController.isFocusCursorVisible()) {
            this.calculateStackForFastScroll();
        } else {
            logChannelCoverStack.log(-2137614336, "CoverStackController#calculateStack: cursor is hidden by menu");
            this.resetStack();
        }
        this.adjustForCursorBeforeFirstItem();
    }

    private boolean isCursorVisibleInViewport() {
        if (!this.shouldRender()) {
            return false;
        }
        return this.getMenu().getLayout().isFocusCursorVisible();
    }

    private void calculateStackForVisibleCursor(AbstractWidget abstractWidget) {
        int n = abstractWidget.getY();
        MenuItemMetaData menuItemMetaData = this.findItemUnderCursor(n);
        if (menuItemMetaData != null) {
            this.stackTopItem = menuItemMetaData.index;
            this.animationProgress = this.calculateAnimationProgress(menuItemMetaData.widget, n);
        } else {
            logChannelCoverStack.log(10000, "CoverStackController#calculateStackForVisibleCursor: no item found under cursor. cursorY: %1", (long)n);
            this.resetStack();
        }
    }

    private void adjustForCursorBeforeFirstItem() {
        while (this.animationProgress < 0.0f) {
            Iterator iterator = this.getMenu().iterator(this.stackTopItem, false, false);
            if (iterator.hasNext()) {
                this.stackTopItem = (MenuItemIndex)iterator.next();
                this.animationProgress += 1.0f;
                continue;
            }
            this.animationProgress = 0.0f;
        }
    }

    MenuItemMetaData findItemUnderCursor(int n) {
        MenuController menuController = this.getMenu();
        int n2 = menuController.getLayout().getFirstVisibleItem();
        int n3 = menuController.getLayout().getLastVisibleItem();
        if (n2 == -1 || n3 == -1) {
            logChannelCoverStack.log(10000, "CoverStackController#findItemUnderCursor: visible items bounds are invalid. first: %1, last: %2", (long)n2, (long)n3);
            return null;
        }
        List list = menuController.getAnimationManager().getLayoutItems();
        MenuItemMetaData menuItemMetaData = null;
        for (int i2 = n2; i2 <= n3; ++i2) {
            MenuItemMetaData menuItemMetaData2 = (MenuItemMetaData)list.get(i2);
            if (menuItemMetaData2.isRealized()) {
                int n4 = menuItemMetaData2.widget.getY();
                if (n4 > n && menuItemMetaData != null) break;
                menuItemMetaData = menuItemMetaData2;
                continue;
            }
            logChannelCoverStack.log(-2137614336, "CoverStackController#findItemUnderCursor: item %1 is not realized", (Object)menuItemMetaData2.index);
        }
        return menuItemMetaData;
    }

    float calculateAnimationProgress(AbstractWidget abstractWidget, int n) {
        if (!this.expandable) {
            return 0.0f;
        }
        int n2 = this.getMenu().getAnimationManager().getCursorBounceOffset();
        int n3 = abstractWidget.getY() + n2;
        int n4 = abstractWidget.getHeight();
        int n5 = n3 + n4 + this.getMenu().getLayout().getItemsGap();
        int n6 = n5 - n3;
        int n7 = n - n3;
        return (float)n7 / (float)n6;
    }

    private void calculateStackForFastScroll() {
        int n;
        MenuController menuController = this.getMenu();
        List list = menuController.getAnimationManager().getLayoutItems();
        boolean bl = menuController.getAnimationManager().isViewportScrollingDownward();
        int n2 = n = bl ? menuController.getLayout().getLastVisibleItem() : menuController.getLayout().getFirstVisibleItem();
        if (n == -1) {
            logChannelCoverStack.log(10000, "CoverStackController#calculateStackForFastScroll: no item in visible area. layoutItems: %1", (long)list.size());
            this.resetStack();
            return;
        }
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)list.get(n);
        if (!menuItemMetaData.isRealized()) {
            logChannelCoverStack.log(-1601830656, "CoverStackController#calculateStackForFastScroll: item %1 is not realized", (Object)menuItemMetaData.index);
            this.stackTopItem = menuItemMetaData.index;
            this.animationProgress = 0.0f;
            return;
        }
        int n3 = bl ? menuController.getHeight() : -menuItemMetaData.widget.getHeight();
        this.stackTopItem = menuItemMetaData.index;
        this.animationProgress = this.calculateAnimationProgress(menuItemMetaData.widget, n3);
    }

    void updateBitmaps(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#updateBitmaps: top item is null, so no cover bitmaps");
            if (!this.getMenu().isFocusCursorVisible()) {
                this.coverBitmaps.clear();
            }
            return;
        }
        MenuController menuController = this.getMenu();
        Object object = null;
        Object object2 = null;
        if (this.coverBitmaps != null) {
            if (!this.coverBitmaps.isEmpty() && !this.isExpandable()) {
                object2 = this.coverBitmaps.get(0);
            }
            this.coverBitmaps.clear();
        }
        int n = 0;
        this.firstSecondBitmapsEqual = false;
        Iterator iterator = menuController.iterator(menuItemIndex, true, true);
        while (iterator.hasNext()) {
            MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
            if (this.isCoverItem(menuItemIndex2)) {
                Object object3;
                boolean bl = n < 100;
                Object object4 = object3 = bl ? this.getBitmapModel(menuItemIndex2) : null;
                if (n == 0) {
                    object = object3;
                    if (this.equalsCovers(object2, object3)) {
                        this.firstSecondBitmapsEqual = true;
                    }
                } else if (n == 1 && this.equalsCovers(object, object3)) {
                    this.firstSecondBitmapsEqual = true;
                }
                if (!bl || !this.equalsCovers(object2, object3) || this.coverBitmaps.isEmpty()) {
                    this.coverBitmaps.add(object3);
                    object2 = object3;
                    if (!this.expandable || this.coverBitmaps.size() >= 5) {
                        if (object3 instanceof HMIResourceLocator && ((HMIResourceLocator)object3).getMinDisplayDuration() > 0) {
                            if (this.dabSlsHandler == null) {
                                this.dabSlsHandler = new DABSlideShowHandler(this);
                            }
                            if (this.dabSlsHandler.startSlsTimer((HMIResourceLocator)object3) == 0) {
                                logChannel.log(-2137614336, "CoverStackController#updateBitmaps : (re)started DABSlideShow Timer ");
                            }
                        }
                        if (logChannelCoverStack.isDebug()) {
                            logChannelCoverStack.log(-2137614336, "CoverStackController#updateBitmaps: updated %4 bitmaps from top item %1 until %2, images: %3", (Object)menuItemIndex, (Object)menuItemIndex2, (Object)this.coverBitmaps, (Object)Util.createInteger(this.coverBitmaps.size()));
                        }
                        return;
                    }
                }
            } else if (n == 0) {
                this.firstSecondBitmapsEqual = true;
            }
            ++n;
        }
        logChannelCoverStack.log(-2137614336, "CoverStackController#updateBitmaps: updated %3 bitmaps until end of menu. stackTopItem: %1, images: %2", (Object)menuItemIndex, (Object)this.coverBitmaps, (long)this.coverBitmaps.size());
    }

    boolean equalsCovers(Object object, Object object2) {
        if (object instanceof ResourceLocatorListCell) {
            object = ((ResourceLocatorListCell)object).getResourceLocator();
        }
        if (object2 instanceof ResourceLocatorListCell) {
            object2 = ((ResourceLocatorListCell)object2).getResourceLocator();
        }
        if (!this.hasCover(object) && !this.hasCover(object2)) {
            return true;
        }
        if (object instanceof HMIResourceLocator && object2 instanceof HMIResourceLocator) {
            HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object;
            HMIResourceLocator hMIResourceLocator2 = (HMIResourceLocator)object2;
            if (hMIResourceLocator.containsResourceURI()) {
                return hMIResourceLocator.getResourceURI().equals(hMIResourceLocator2.getResourceURI());
            }
            if (hMIResourceLocator2.containsResourceURI()) {
                return false;
            }
            return hMIResourceLocator.getResourceID() == hMIResourceLocator2.getResourceID();
        }
        return Util.equals(object, object2);
    }

    private boolean hasCover(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof HMIResourceLocator) {
            HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object;
            return hMIResourceLocator.containsResourceID() || hMIResourceLocator.containsResourceURI();
        }
        return true;
    }

    private boolean isCoverItem(MenuItemIndex menuItemIndex) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getMenu().getChild(menuItemIndex.widget);
        Object object = abstractWidgetController.getModel();
        return object instanceof ListModelGUI || object instanceof TiledListModelGUI;
    }

    private Object getBitmapModel(MenuItemIndex menuItemIndex) {
        if (this.bitmapColumn == -1) {
            logChannelCoverStack.log(10000, "CoverStackController#getBitmapModel: no bitmapColumn configured.");
            return null;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getMenu().getChild(menuItemIndex.widget);
        Object object = abstractWidgetController.getModel();
        if (object instanceof ListModelGUI) {
            ListModelGUI listModelGUI = (ListModelGUI)object;
            if (this.bitmapColumn >= listModelGUI.getMaxColumns()) {
                logChannelCoverStack.log(-1601830656, "CoverStackController#getBitmapModel: bitmapColumn %1 is too high. MaxColumns: %2", (long)this.bitmapColumn, (long)listModelGUI.getMaxColumns());
                return null;
            }
            ListCell[] listCellArray = new ListCell[listModelGUI.getMaxColumns()];
            boolean bl = listModelGUI.getRow(menuItemIndex.widgetPart, listCellArray);
            if (bl) {
                ListCell listCell = listCellArray[this.bitmapColumn];
                if (!(listCell instanceof ResourceLocatorListCell)) {
                    logChannelCoverStack.log(-1601830656, "CoverStackController#getBitmapModel: cover for item %1 (listModel column %3) is not a ResourceLocatorCell: %2", (Object)menuItemIndex, (Object)listCell, (long)this.bitmapColumn);
                }
                return listCell;
            }
            logChannelCoverStack.log(-1601830656, "CoverStackController#getBitmapModel: can not access list model row %2 of model: %1", (Object)listModelGUI, (long)menuItemIndex.widgetPart);
            return null;
        }
        if (object instanceof TiledListModelGUI) {
            TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)object;
            GuiListRow guiListRow = tiledListModelGUI.getGuiRow(menuItemIndex.widgetPart);
            int n = -1;
            if (guiListRow != null) {
                n = this.defaultBitmapColumn > -1 && this.defaultBitmapColumn < guiListRow.getColumnCount() ? guiListRow.getInteger(this.defaultBitmapColumn) : (int)guiListRow.getUniqueID();
                if (this.bitmapColumn >= guiListRow.getColumnCount()) {
                    logChannelCoverStack.log(-1601830656, "CoverStackController#getBitmapModel: bitmapColumn %1 is too high. row's columns: %2", (long)this.bitmapColumn, (long)guiListRow.getColumnCount());
                    return null;
                }
                Object object2 = guiListRow.getCell(this.bitmapColumn);
                if (object2 == null && n > -1) {
                    return new ResourceLocatorListCell(n, null);
                }
                if (object2 instanceof HMIResourceLocator) {
                    HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object2;
                    if (hMIResourceLocator.containsResourceID() || hMIResourceLocator.containsResourceURI()) {
                        return object2;
                    }
                    return new ResourceLocatorListCell(n, null);
                }
                logChannelCoverStack.log(-1601830656, "CoverStackController#getBitmapModel: cover for item %1 (listModel column %3) is not a ResourceLocatorCell: %2", (Object)menuItemIndex, object2, (long)this.bitmapColumn);
                return object2;
            }
            logChannelCoverStack.log(-2137614336, "CoverStackController#getBitmapModel: list row %2 is null in model: %1", (Object)tiledListModelGUI, (long)menuItemIndex.widgetPart);
            return null;
        }
        logChannelCoverStack.log(10000, "CoverStackController#getBitmapModel: menuItem's model is not a list model. item index: %1, model: %2", (Object)menuItemIndex, object);
        return null;
    }

    public float getTopMoveProgress() {
        if (this.firstSecondBitmapsEqual) {
            return 0.0f;
        }
        if (!this.expandable) {
            return 0.0f;
        }
        return this.animationProgress;
    }

    public float getNowPlayingAnimationProgress() {
        if (this.nowPlayingMode) {
            return 1.0f;
        }
        if (this.parent instanceof NowPlayingMenuController) {
            float f2;
            NowPlayingMenuController nowPlayingMenuController = (NowPlayingMenuController)this.parent;
            float f3 = f2 = nowPlayingMenuController.isNowPlayingAnimationRunning() ? nowPlayingMenuController.getNowPlayingAnimationProgress() : 1.0f;
            if (nowPlayingMenuController.isNowPlayingActive()) {
                return f2;
            }
            return 1.0f - f2;
        }
        return 0.0f;
    }

    public boolean shouldLoadCoversBitmaps() {
        return !this.isInMenu() || !this.getMenu().getAnimationManager().isScrollAnimationRunning();
    }

    private boolean isInMenu() {
        return this.getParent() instanceof MenuController;
    }

    private MenuController getMenu() {
        return (MenuController)this.getParent();
    }

    public List getCoverBitmaps() {
        return this.coverBitmaps;
    }

    public int getBitmapColumn() {
        return this.bitmapColumn;
    }

    public void setBitmapColumn(int n) {
        this.bitmapColumn = n;
    }

    public int getDefaultImageMode() {
        return this.defaultImageMode;
    }

    public void setDefaultImageMode(int n) {
        this.defaultImageMode = n;
    }

    public boolean isFirstSecondBitmapsEqual() {
        return this.firstSecondBitmapsEqual;
    }

    public boolean isExpandable() {
        return this.expandable;
    }

    public void setExpandable(boolean bl) {
        this.expandable = bl;
    }

    @Override
    public void viewportUpdated(boolean bl) {
    }

    @Override
    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    @Override
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    @Override
    public void menuFocusChangeFinished() {
    }

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
    }

    public boolean isNowPlayingMode() {
        return this.nowPlayingMode;
    }

    public void setNowPlayingMode(boolean bl) {
        this.nowPlayingMode = bl;
    }

    public void setDefaultBitmapColumn(int n) {
        this.defaultBitmapColumn = n;
    }

    public int getDefaultBitmapColumn() {
        return this.defaultBitmapColumn;
    }

    public void startCrossFadingAnimation() {
        this.crossFadingActive = true;
        if (this.getAnimation().isAnimating()) {
            this.getAnimation().setTarget(this.crossFadeAnimation.getTarget());
            logChannelCoverStack.log(-2137614336, "CoverStackController#startCrossFadingAnimation crossFading started state: %1", (long)this.crossFadeState);
        } else {
            this.getAnimation().startDynamicAnimation(0.0f, 31300, 104, true, this);
            logChannelCoverStack.log(-2137614336, "CoverStackController#startCrossFadingAnimation crossFading started state: %1", (long)this.crossFadeState);
        }
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        if (this.crossFadingActive) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#animationFinished");
            this.stopCrossFadeAnimation(false);
        }
    }

    @Override
    public void animate(int n, float f2, int n2) {
        logChannelCoverStack.log(-2137614336, "CoverStackController#animate");
        switch (this.crossFadeState) {
            case 1: {
                this.crossFadingProgress = this.crossFadeAnimation.getProgress();
                break;
            }
            case 0: {
                this.crossFadingProgress = 1.0f - this.crossFadeAnimation.getProgress();
                break;
            }
            default: {
                logChannelCoverStack.log(-1601830656, "CoverStackController#animate untreated crossFadeState: %1", (long)this.crossFadeState);
            }
        }
        if (this.isInterruptCrossFading()) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#animate interrupt");
        }
        if (this.getNowPlayingAnimationProgress() != 1.0f) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#animate nowPlayingProgress");
        }
        this.setCompositesDirty(true);
    }

    private void stopCrossFadeAnimation(boolean bl) {
        if (this.crossFadeAnimation == null) {
            logChannelCoverStack.log(-2137614336, "CoverStackController#stopCrossFadeAnimation crossFading stopping failed ");
        } else if (!this.crossFadeAnimation.isAnimating()) {
            this.crossFadingActive = false;
            this.interruptCrossFading = false;
            if (this.crossFadeState == 1) {
                this.crossFadingProgress = 1.0f;
                this.crossFadeState = 0;
            } else {
                this.crossFadingProgress = 0.0f;
                this.crossFadeState = 1;
            }
        } else if (this.crossFadeAnimation.isAnimating()) {
            this.crossFadeAnimation.stopAnimation();
            if (logChannelCoverStack.isDebug()) {
                logChannelCoverStack.log(-2137614336, "CoverStackController#stopCrossFadeAnimation crossFading stopped new state: %1 emergencyInterrupt: %2", (Object)String.valueOf(this.crossFadeState), (Object)String.valueOf(bl));
            }
        }
    }

    private AbstractAnimationController getAnimationController() {
        if (this.getTerminal() != null) {
            return (AbstractAnimationController)this.getTerminal().getIAnimationController();
        }
        return null;
    }

    private AbstractAnimation getAnimation() {
        if (this.crossFadeAnimation == null) {
            this.crossFadeAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(104);
            this.crossFadeAnimation.addListener(this);
        }
        return this.crossFadeAnimation;
    }

    public float getCrossFadingProgress() {
        return this.crossFadingProgress;
    }

    public void setCrossFadingProgress(float f2) {
        this.crossFadingProgress = f2;
    }

    public boolean isCrossFadingActive() {
        return this.crossFadingActive;
    }

    public void setCrossFadingActive(boolean bl) {
        this.crossFadingActive = bl;
    }

    public int getCrossFadeState() {
        return this.crossFadeState;
    }

    public void setCrossFadeState(int n) {
        this.crossFadeState = n;
    }

    public boolean isInterruptCrossFading() {
        return this.interruptCrossFading;
    }

    public void setInterruptCrossFading(boolean bl) {
        this.interruptCrossFading = bl;
    }

    public void setUpdateState(boolean bl) {
        logChannelCoverStack.log(-2137614336, "CoverStackController#setUpdateState status is: %1", bl);
        this.updateState = bl;
        if (bl) {
            this.processModelUpdateEvent(null);
        }
    }

    public boolean isUpdateState() {
        return this.updateState;
    }

    public int getModelStatus() {
        return this.modelStaus;
    }

    public final boolean isOnlyUpdateOfNowPlayingProgressNeeded() {
        return this.onlyUpdateOfNowPlayingProgressNeeded;
    }

    public final void nowPlayingProgessUpdateDone(float f2) {
        this.onlyUpdateOfNowPlayingProgressNeeded = false;
        this.appliedNowPlayingProgress = f2;
    }

    public void setPrimaryBitmapsDefaultIndex(int n) {
        this.primaryBitmapsDefaultIndex = n;
    }

    public int getPrimaryBitmapsDefaultIndex() {
        if (this.primaryBitmapsDefaultIndex == 0) {
            return 0;
        }
        if (this.hasBitmap(this.primaryBitmapsDefaultIndex)) {
            return this.primaryBitmapsDefaultIndex;
        }
        logChannelCoverStack.log(-2137614336, "CoverStackController#getDfeaultBitmapIndexToUse: primaryBitmapsDefaultIndex (%1) not valid, index 0 used instead", (long)this.primaryBitmapsDefaultIndex);
        return 0;
    }

    @Override
    public void isLockingActive(boolean bl, boolean bl2) {
        this.lockingActive = bl && bl2;
        this.setCompositesDirty(true);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.modelStubLockingInvisible != null || this.modelStubLockingShade != null) {
            this.calculateLockingAction();
            LockingManager.registerListener(this);
        }
    }

    private void calculateLockingAction() {
        this.evaluateModelStub(this.modelStubLockingShade, 1);
        this.evaluateModelStub(this.modelStubLockingInvisible, 2);
        IWidgetLogChannel.logLocking.log(-2137614336, "CoverStackController#calculateLockingAction new lockingAction=%1", (long)this.lockingAction);
    }

    private void evaluateModelStub(ModelStubController modelStubController, int n) {
        int n2;
        Object object;
        if (modelStubController != null && (object = modelStubController.getModel()) instanceof ChoiceModelGUI && (n2 = ((ChoiceModelGUI)object).getValue()) == 1) {
            this.lockingAction = n;
        }
    }

    @Override
    public float getRenderOpacity() {
        float f2 = super.getRenderOpacity();
        if (this.lockingActive) {
            if (this.lockingAction == 1) {
                f2 *= this.lockingShadingOpacity;
            } else if (this.lockingAction == 2) {
                f2 = 0.0f;
            }
            IWidgetLogChannel.logLocking.log(-2137614336, "CoverStackController#getRenderOpacity return opacity=%1", (double)f2);
        }
        return f2;
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof ModelStubController) {
            if (n == 2) {
                this.modelStubLockingShade = (ModelStubController)abstractWidget;
            } else if (n == 4) {
                this.modelStubLockingInvisible = (ModelStubController)abstractWidget;
            }
        }
        super.add(abstractWidget);
    }

    private void updateLockingAction(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent == null) {
            return;
        }
        int n = modelUpdateEvent.getModelId();
        if (this.modelStubLockingInvisible != null && n == this.modelStubLockingInvisible.getModelID() || this.modelStubLockingShade != null && n == this.modelStubLockingShade.getModelID()) {
            this.calculateLockingAction();
            this.setCompositesDirty(true);
        }
    }

    @Override
    public boolean isInterestedOnTimerEvents() {
        return true;
    }
}

