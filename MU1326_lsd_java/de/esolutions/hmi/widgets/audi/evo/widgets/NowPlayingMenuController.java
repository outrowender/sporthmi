/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.TransitionLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import java.util.Iterator;
import java.util.List;

public class NowPlayingMenuController
extends MenuController
implements AnimationListener,
ATIPEventListener {
    public static final int DEFAULT_LAYOUT_INDEX = 0;
    private static final int NOW_PLAYING_LAYOUT_INDEX = 1;
    private boolean nowPlayingActive;
    private boolean transitionAnimationRunning;
    private MenuItemMetaData nowPlayingItem;
    private TimerEvent nowPlayingTimerEvent;
    private Job nowPlayingTimer;
    private long nowPlayingActivationTime = 10000L;
    private boolean nowPlayingActivationTimeEnabled = true;
    private float fakeAnimationStart;
    private boolean expectDestroyNowPlayingItem = false;
    private TitleBarWidget titleBar;

    protected void initializeWidget() {
        super.initializeWidget();
        this.resetNowPlaying();
        this.nowPlayingTimerEvent = new TimerEvent(this);
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.restartNowPlayingTimer();
        ((ScreenWidgetEVO)initializationContext.getScreen()).setOptionIconVisible(this.isInstructionTextVisible() || this.isNowPlayingActive());
    }

    private boolean isInstructionTextVisible() {
        AbstractWidget abstractWidget = this.getParent();
        boolean bl = false;
        if (abstractWidget != null) {
            List list = abstractWidget.getChildren();
            Iterator iterator = list.iterator();
            while (iterator.hasNext() && !bl) {
                Object object = iterator.next();
                if (!(object instanceof InstructionTextContoller)) continue;
                bl = ((InstructionTextContoller)object).isVisible();
            }
        }
        return bl;
    }

    public void disconnecting() {
        this.cancelNowPlayingTimer();
        this.nowPlayingTimer = null;
        this.nowPlayingTimerEvent = null;
        this.titleBar = null;
        if (this.isNowPlayingActive()) {
            this.deactivateNowPlayingInternal(true);
        }
        super.disconnecting();
    }

    public void predisconnecting() {
        super.predisconnecting();
        if (this.isNowPlayingActive()) {
            ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().showSideOptionIcon(false);
        }
    }

    public void animate(int n, float f2) {
        if (n == 78 && this.isNowPlayingAnimationRunning()) {
            float f3 = this.getNowPlayingAnimationProgress();
            if (this.nowPlayingItem != null) {
                this.getNowPlayingWidget().animateLayoutTransition(f3);
            }
            float f4 = this.nowPlayingActive ? f3 : 1.0f - f3;
            this.setGlassplateMinimized(f4);
            this.propagateNowPlayingProgressToTitleBar();
            this.setCompositesDirty(true);
        }
    }

    public float getNowPlayingAnimationProgress() {
        float f2 = 1.0f - this.fakeAnimationStart;
        return this.fakeAnimationStart + f2 * this.getAnimationManager().getAnimationProgress();
    }

    public void adjustAnimationStartValuesForRestart() {
        super.adjustAnimationStartValuesForRestart();
        if (this.isNowPlayingAnimationRunning() && this.animationManager.isShortAnimationRunning()) {
            this.fakeAnimationStart = this.getNowPlayingAnimationProgress();
        }
    }

    public float getNowPlayingFadeOutOpacity() {
        float f2 = this.isNowPlayingAnimationRunning() ? this.getNowPlayingAnimationProgress() : 1.0f;
        float f3 = this.isNowPlayingActive() ? 1.0f - f2 : f2;
        return f3 * f3 * f3 * f3;
    }

    private void propagateNowPlayingProgressToTitleBar() {
        this.findTitleBarWidget();
        if (this.titleBar != null) {
            float f2 = this.isNowPlayingAnimationRunning() ? this.getNowPlayingAnimationProgress() : 1.0f;
            float f3 = this.nowPlayingActive ? f2 : 1.0f - f2;
            this.titleBar.setNowPlayingState(f3);
        }
    }

    private void findTitleBarWidget() {
        if (this.titleBar != null) {
            return;
        }
        if (!this.isConnected()) {
            return;
        }
        Screen screen = this.getInitContext().getScreen();
        if (!(screen instanceof ScreenWidgetEVO)) {
            return;
        }
        ScreenWidgetEVO screenWidgetEVO = (ScreenWidgetEVO)screen;
        ScreenMainArea screenMainArea = screenWidgetEVO.getTitleArea();
        if (!(screenMainArea instanceof ContainerController)) {
            return;
        }
        ContainerController containerController = (ContainerController)screenMainArea;
        if (containerController.getChildrenSize() == 0) {
            return;
        }
        AbstractWidget abstractWidget = containerController.getChild(0);
        if (abstractWidget instanceof TitleBarWidget) {
            this.titleBar = (TitleBarWidget)abstractWidget;
        } else {
            menuLogCh.log(10000, "NowPlayingMenuController#findTitleBarWidget: expected titleBar widget, but found: %1", (Object)abstractWidget);
        }
    }

    private void setGlassplateMinimized(float f2) {
        AbstractWidget abstractWidget = this.getChildOfRole(4);
        if (abstractWidget instanceof GlassplateController) {
            ((GlassplateController)abstractWidget).setMinimized(f2);
        }
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        this.nowPlayingAnimationFinished();
    }

    private void nowPlayingAnimationFinished() {
        if (this.transitionAnimationRunning) {
            this.transitionAnimationRunning = false;
            if (this.nowPlayingItem != null) {
                this.getNowPlayingWidget().layoutTransitionFinished();
            }
            this.setGlassplateMinimized(this.nowPlayingActive ? 1.0f : 0.0f);
            this.propagateNowPlayingProgressToTitleBar();
            if (!this.nowPlayingActive) {
                this.resetNowPlayingItemWidget(this.nowPlayingItem);
                this.nowPlayingItem = null;
            }
        }
    }

    public boolean isNowPlayingActive() {
        return this.nowPlayingActive;
    }

    public boolean isNowPlayingAnimationRunning() {
        return this.transitionAnimationRunning && this.getAnimationManager().isShortAnimationRunning();
    }

    public boolean isNowPlayingItem(MenuItemIndex menuItemIndex) {
        return this.nowPlayingItem != null && this.nowPlayingItem.index.equals(menuItemIndex);
    }

    private MenuItemController getNowPlayingWidget() {
        if (!this.nowPlayingItem.isRealized()) {
            menuLogCh.log(100000, "NowPlayingMenuController#getNowPlayingWidget: NPS-item %1 was not realized. Realize it now.", (Object)this.nowPlayingItem);
            this.realizeMenuItem(this.nowPlayingItem);
        }
        return (MenuItemController)this.nowPlayingItem.widget;
    }

    public void activateNowPlayingOnFocus(boolean bl) {
        if (!this.hasFocusedItem()) {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlayingLayout: no item focused");
            return;
        }
        MenuItemIndex menuItemIndex = this.getFocusedIndex();
        if (!menuItemIndex.equals(this.getSelectedIndex())) {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlayingLayout: focus is not on selected item. Focus: %1, selection: %2", (Object)menuItemIndex, (Object)this.getSelectedIndex());
            return;
        }
        MenuItemMetaData menuItemMetaData = this.getAnimationManager().getLayoutData().findAnimationItem(menuItemIndex);
        if (menuItemMetaData == null) {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlayingLayout: focused item not visible: %1", (Object)menuItemIndex);
            return;
        }
        if (!menuItemMetaData.isRealized()) {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlayingLayout: focused item is not realized: %1", (Object)menuItemIndex);
            return;
        }
        if (!(menuItemMetaData.widget instanceof MenuItemController)) {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlayingLayout: focused item is not a MenuItemController: %1", (Object)menuItemMetaData.widget);
            return;
        }
        this.activateNowPlaying(menuItemMetaData, bl);
        if (this.isNowPlayingActive()) {
            this.animationManager.heightChanged(this.getFocusedIndex(), FocusAdvice.KEEP_POSITION, true);
            this.setGlassplateMinimized(this.isNowPlayingActive() ? 1.0f : 0.0f);
        }
    }

    private void activateNowPlaying(MenuItemMetaData menuItemMetaData, boolean bl) {
        if (this.nowPlayingActive) {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlaying: nowPlaying-Mode is already active. nowPlayingItem: %1, requested item: %2", (Object)this.nowPlayingItem, (Object)menuItemMetaData);
            if (Util.equals(menuItemMetaData, this.nowPlayingItem)) {
                return;
            }
            this.deactivateNowPlaying(bl);
        }
        if (!this.isNowPlayingModeEnabled(menuItemMetaData)) {
            menuLogCh.log(10000000, "NowPlayingMenuController#activateNowPlaying: nowPlayingMode is disabled for item %1 ", (Object)menuItemMetaData);
            return;
        }
        if (menuItemMetaData.widget == null) {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlaying: the controller of the requested item: %1 is null", (Object)menuItemMetaData);
            return;
        }
        if (((MenuItemController)menuItemMetaData.widget).hasLayoutChoice(1)) {
            this.activateNowPlayingWithLayoutChange(menuItemMetaData, bl);
            ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().showSideOptionIcon(true);
        } else if (this.event != 0) {
            this.fireEventForNowPlaying(menuItemMetaData);
        } else {
            menuLogCh.log(100000, "NowPlayingMenuController#activateNowPlaying: item %1 has no layout for nowPlayingMode and no SM event configured", (Object)menuItemMetaData.index);
        }
    }

    private boolean isNowPlayingModeEnabled(MenuItemMetaData menuItemMetaData) {
        AbstractWidget abstractWidget = this.getChild(menuItemMetaData.index.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidget)).isNowPlayingModeEnabled(menuItemMetaData.index.widgetPart);
        }
        return true;
    }

    private void startTransitionAnimation(MenuItemMetaData menuItemMetaData, FocusAdvice focusAdvice) {
        this.transitionAnimationRunning = true;
        this.getAnimationManager().heightChanged(menuItemMetaData.index, focusAdvice, false);
        if (!this.getAnimationManager().isShortAnimationRunning()) {
            menuLogCh.log(100000, "NowPlayingMenuController#startTransitionAnimation: no animation was started for item: %1", (Object)menuItemMetaData);
            this.nowPlayingAnimationFinished();
            this.relayout();
            this.transitionAnimationRunning = false;
        }
    }

    private void fireEventForNowPlaying(MenuItemMetaData menuItemMetaData) {
        menuLogCh.log(10000000, "NowPlayingMenuController#fireEventForNowPlaying: fire SM event for nowPlaying item: %1, event: %2, terminalID: %3", (Object)menuItemMetaData, (long)this.event, (long)this.initContext.getTerminalID());
        this.fireSMEvent(this.initContext.getTerminalID(), this.event);
    }

    private void activateNowPlayingWithLayoutChange(MenuItemMetaData menuItemMetaData, boolean bl) {
        this.hideInfoline(bl);
        this.cancelFocusDetailTimers();
        this.nowPlayingActive = true;
        this.nowPlayingItem = menuItemMetaData;
        MenuItemController menuItemController = this.getNowPlayingWidget();
        int n = this.getNowPlayingItemHeight(menuItemMetaData);
        menuLogCh.log(10000000, "NowPlayingMenuController#activateNowPlayingWithLayoutChange: activate nowPlayingScreen on item: %2, height: %3, immediately: %1", (Object)bl, (Object)menuItemMetaData, (long)n);
        menuItemController.setPreferredHeight(n);
        if (bl) {
            menuItemController.selectLayoutManager(1);
            this.propagateNowPlayingProgressToTitleBar();
            this.relayout();
            this.setCompositesDirty(true);
        } else {
            menuItemController.selectLayoutManagerWithTransition(1, -2, n);
            this.fakeAnimationStart = 0.0f;
            this.startTransitionAnimation(menuItemMetaData, FocusAdvice.KEEP_POSITION);
        }
    }

    public void deactivateNowPlaying(boolean bl) {
        if (!this.nowPlayingActive) {
            menuLogCh.log(100000, "NowPlayingMenuController#deactivateNowPlaying: nowPlaying-Mode is not active. nowPlayingItem: %1", (Object)this.nowPlayingItem);
            return;
        }
        menuLogCh.log(10000000, "NowPlayingMenuController#deactivateNowPlaying: deactivate nowPlayingScreen from item: %1", (Object)this.nowPlayingItem);
        MenuItemIndex menuItemIndex = this.nowPlayingItem.index;
        this.deactivateNowPlayingInternal(bl);
        if (bl) {
            this.animationManager.heightChanged(menuItemIndex, this.createFocusAdviceForDeactivateNowPlayingMode(), true);
            this.setGlassplateMinimized(0.0f);
        } else {
            this.fakeAnimationStart = 0.0f;
            this.startTransitionAnimation(this.nowPlayingItem, this.createFocusAdviceForDeactivateNowPlayingMode());
        }
        this.restartNowPlayingTimer();
        this.restartNowPlayingTimerWidget();
        ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().showSideOptionIcon(false);
    }

    private FocusAdvice createFocusAdviceForDeactivateNowPlayingMode() {
        int n = this.getLayout().getContentAreaHeight() / 2;
        MenuItemIndex menuItemIndex = this.getFocusedIndex();
        if (menuItemIndex != null) {
            n -= this.getMenuItemHeight(menuItemIndex, this.isExpanded(menuItemIndex));
        }
        return new WidgetFocusAdvice(n, true);
    }

    public void mergeCursors(FocusAdvice focusAdvice) {
        MenuItemIndex menuItemIndex = this.getFocusedIndex();
        super.mergeCursors(focusAdvice);
        if (!Util.equals(menuItemIndex, this.getFocusedIndex())) {
            this.restartNowPlayingTimer();
            this.restartNowPlayingTimerWidget();
        }
    }

    private void restartNowPlayingTimerWidget() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof NowPlayingMenuTimerController)) continue;
            ((NowPlayingMenuTimerController)abstractWidgetController).restartTimer();
        }
    }

    private void deactivateNowPlayingInternal(boolean bl) {
        MenuItemController menuItemController = this.getNowPlayingWidget();
        this.nowPlayingActive = false;
        this.restartFocusDetailTimers();
        menuItemController.setPreferredHeight(-1);
        if (bl) {
            this.resetNowPlayingItemWidget(this.nowPlayingItem);
            this.nowPlayingItem = null;
            this.propagateNowPlayingProgressToTitleBar();
        } else {
            TransitionLayout transitionLayout = menuItemController.selectLayoutManagerWithTransition(0, -2, -1);
            if (transitionLayout != null) {
                transitionLayout.setAnimatePreferredSize(false);
            }
        }
    }

    private void resetNowPlaying() {
        menuLogCh.log(10000000, "NowPlayingMenuController#resetNowPlaying: reset nowPlaying state. old old nowPlayingFlag: %1, nowPlayingItem: %2", this.nowPlayingActive, (Object)this.nowPlayingItem);
        this.resetNowPlayingItemWidget(this.nowPlayingItem);
        this.nowPlayingActive = false;
        this.transitionAnimationRunning = false;
        this.nowPlayingItem = null;
        ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().showSideOptionIcon(false);
        this.setGlassplateMinimized(0.0f);
    }

    private void resetNowPlayingItemWidget(MenuItemMetaData menuItemMetaData) {
        MenuItemController menuItemController;
        if (menuItemMetaData == null || !menuItemMetaData.isRealized()) {
            return;
        }
        menuItemMetaData.widget.setPreferredHeight(-1);
        if (menuItemMetaData.widget instanceof MenuItemController && (menuItemController = (MenuItemController)menuItemMetaData.widget).hasMultipleLayouts()) {
            menuItemController.selectLayoutManager(0);
        }
    }

    private int getNowPlayingItemHeight(MenuItemMetaData menuItemMetaData) {
        return this.getLayout().getContentAreaHeight() - this.getMenuItemGlassplateInsets(menuItemMetaData, true) - this.getMenuItemGlassplateInsets(menuItemMetaData, false);
    }

    protected void focusedItemHasChanged(boolean bl, boolean bl2) {
        super.focusedItemHasChanged(bl, bl2);
        if (this.isNowPlayingActive()) {
            this.deactivateNowPlaying(true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected MenuItemMetaData replaceItem(MenuItemMetaData menuItemMetaData) {
        MenuItemMetaData menuItemMetaData2;
        this.expectDestroyNowPlayingItem = Util.equals(menuItemMetaData, this.nowPlayingItem);
        try {
            menuItemMetaData2 = super.replaceItem(menuItemMetaData);
        }
        finally {
            this.expectDestroyNowPlayingItem = false;
        }
        if (Util.equals(menuItemMetaData, this.nowPlayingItem)) {
            if (menuItemMetaData2 != null) {
                this.resetNowPlayingItemWidget(this.nowPlayingItem);
                this.nowPlayingItem = menuItemMetaData2;
                menuLogCh.log(10000000, "NowPlayingMenuController#replaceItem: nowPlayingItem was replaced: %1", (Object)menuItemMetaData2);
                this.realizeMenuItem(menuItemMetaData2);
                this.nowPlayingActive = false;
                this.activateNowPlaying(menuItemMetaData2, true);
                this.nowPlayingActive = true;
                this.nowPlayingItem = menuItemMetaData2;
            } else {
                menuLogCh.log(100000, "NowPlayingMenuController#replaceItem: nowPlayingItem was destroyed: %1, focus: %2", (Object)menuItemMetaData, (Object)this.getFocusedIndex());
                this.resetNowPlaying();
            }
        }
        return menuItemMetaData2;
    }

    public void destroyMenuItem(MenuItemMetaData menuItemMetaData) {
        if (Util.equals(menuItemMetaData, this.nowPlayingItem)) {
            this.resetNowPlayingItemWidget(menuItemMetaData);
            if (!this.expectDestroyNowPlayingItem) {
                this.resetNowPlaying();
                int n = this.getNowPlayingItemHeight(menuItemMetaData);
                if (menuItemMetaData.heightAfter == n) {
                    menuLogCh.log(100000, "NowPlayingMenuController#destroyMenuItem: nowPlayingItem destroyed: %1, focus: %2", (Object)menuItemMetaData, (Object)this.getFocusedIndex());
                    int n2 = this.getMenuItemHeight(menuItemMetaData, this.isExpanded(menuItemMetaData.index));
                    if (menuItemMetaData.heightAfter == menuItemMetaData.heightBefore) {
                        menuItemMetaData.heightBefore = n2;
                    }
                    menuItemMetaData.heightAfter = n2;
                    if (this.animationManager.getCursorHeightAfter() == n) {
                        int n3 = n2 - this.getMenuItemNoCursorArea(menuItemMetaData, true) - this.getMenuItemNoCursorArea(menuItemMetaData, false);
                        this.animationManager.setCursorHeightAfter(n3);
                    }
                }
            }
        }
        super.destroyMenuItem(menuItemMetaData);
    }

    public int getMenuItemHeight(MenuItemIndex menuItemIndex, boolean bl) {
        if (this.nowPlayingActive && menuItemIndex.equals(this.nowPlayingItem.index)) {
            return this.getNowPlayingItemHeight(this.nowPlayingItem);
        }
        return super.getMenuItemHeight(menuItemIndex, bl);
    }

    public int getMenuItemHeight(MenuItemMetaData menuItemMetaData, boolean bl) {
        if (this.nowPlayingActive && menuItemMetaData.index.equals(this.nowPlayingItem.index)) {
            return this.getNowPlayingItemHeight(this.nowPlayingItem);
        }
        return super.getMenuItemHeight(menuItemMetaData, bl);
    }

    public void keyPressed(KeyEvent keyEvent) {
        this.cancelNowPlayingTimer();
        if (this.isNowPlayingActive() && keyEvent.getKeyCode() == 15) {
            menuLogCh.log(10000000, "NowPlayingMenuController#keyPressed: Back clicked, deactivate nowPlayingMode (%1)", (Object)this);
            this.deactivateNowPlaying(false);
            keyEvent.consume();
            return;
        }
        super.keyPressed(keyEvent);
    }

    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        this.restartNowPlayingTimer();
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.isNowPlayingActive()) {
            if (wheelButtonEvent.getClickCount() == 0) {
                menuLogCh.log(10000000, "NowPlayingMenuController#keyTurned: ignore hDDS turn on nowPlayingScreen. subticks: %2, event: %1", (Object)wheelButtonEvent, (long)wheelButtonEvent.getSubClickCount());
                return;
            }
            this.deactivateNowPlaying(false);
            return;
        }
        this.restartNowPlayingTimer();
        super.keyTurned(wheelButtonEvent);
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.cancelNowPlayingTimer();
        super.touchPadPressed(touchEvent);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        super.touchPadReleased(touchEvent);
        this.restartNowPlayingTimer();
    }

    public void focusItemImmediately(MenuItemIndex menuItemIndex, FocusAdvice focusAdvice) {
        if (this.isNowPlayingActive() && !Util.equals(menuItemIndex, this.getFocusedIndex())) {
            this.deactivateNowPlaying(true);
        }
        super.focusItemImmediately(menuItemIndex, focusAdvice);
    }

    protected void restartNowPlayingTimer() {
        this.cancelNowPlayingTimer();
        if (this.nowPlayingActive) {
            menuLogCh.log(10000000, "NowPlayingMenuController#restartNowPlayingTimer: nowPlaying already active on item: %1", (Object)this.nowPlayingItem);
            return;
        }
        if (!this.nowPlayingActivationTimeEnabled) {
            menuLogCh.log(10000000, "NowPlayingMenuController#restartNowPlayingTimer: nowPlayingTimer is disabled");
            return;
        }
        if (this.nowPlayingActivationTime > 0L) {
            menuLogCh.log(10000000, "NowPlayingMenuController#restartNowPlayingTimer: timeout: %1", this.nowPlayingActivationTime);
            this.nowPlayingTimer = hmiService.getEventDispatcher().postEvent(this.nowPlayingTimerEvent, this.nowPlayingActivationTime);
        } else {
            menuLogCh.log(10000, "NowPlayingMenuController#restartNowPlayingTimer: timeout is invalid: %1", this.nowPlayingActivationTime);
        }
    }

    private void cancelNowPlayingTimer() {
        if (this.isNowPlayingTimerRunning()) {
            menuLogCh.log(10000000, "NowPlayingMenuController#cancelNowPlayingTimer");
            this.nowPlayingTimer.cancel();
            this.nowPlayingTimer = null;
        }
    }

    public boolean isNowPlayingTimerRunning() {
        return this.nowPlayingTimer != null && !this.nowPlayingTimer.isCanceled();
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        menuLogCh.log(10000000, "NowPlayingMenuController#processEvent is called - event: %1 expectedEvent: %2, timer: %3", (Object)aTIPEvent, (Object)this.nowPlayingTimerEvent, (Object)this.nowPlayingTimer);
        if (Util.equals(aTIPEvent, this.nowPlayingTimerEvent)) {
            this.activateNowPlayingOnFocus(false);
        }
    }

    public long getNowPlayingActivationTime() {
        return this.nowPlayingActivationTime;
    }

    public void setNowPlayingActivationTime(long l) {
        if (this.nowPlayingActivationTime == l) {
            return;
        }
        menuLogCh.log(10000000, "NowPlayingMenuController#setNowPlayingActivationTime: changed timeout from %1 to %2", this.nowPlayingActivationTime, l);
        this.nowPlayingActivationTime = l;
        if (this.isConnected()) {
            this.restartNowPlayingTimer();
        }
    }

    public boolean isNowPlayingActivationTimeEnabled() {
        return this.nowPlayingActivationTimeEnabled;
    }

    public void setNowPlayingActivationTimeEnabled(boolean bl) {
        if (this.nowPlayingActivationTimeEnabled == bl) {
            return;
        }
        menuLogCh.log(10000000, "NowPlayingMenuController#setNowPlayingActivationTimeEnabled: changed timeout-enabled from %1 to %2", this.nowPlayingActivationTimeEnabled, bl);
        this.nowPlayingActivationTimeEnabled = bl;
        if (this.isConnected()) {
            this.restartNowPlayingTimer();
        }
    }

    public void setSDSActive(boolean bl) {
        super.setSDSActive(bl);
        if (bl && this.isNowPlayingActive()) {
            menuLogCh.log(1000000, "NowPlayingMenuController#setSDSActive: SDS activated, deactivate NowPlayingScreen.");
            this.deactivateNowPlaying(false);
        }
    }
}

