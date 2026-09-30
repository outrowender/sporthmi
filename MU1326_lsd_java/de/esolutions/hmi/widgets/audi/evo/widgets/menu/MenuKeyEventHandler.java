/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.ScrollSubticksFilter;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuFastScrollClickAccumulator;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateRequest;
import java.util.Iterator;

public class MenuKeyEventHandler
implements WidgetConstants,
IWidgetLogChannel,
TimerListener,
AnimationListener {
    private static final int CURSOR_GLASSPLATE_DISTANCE_SCROLL_TRIGGER = 3;
    private static final float SWIPE_SPEED_FOR_FAST_SCROLL = 2.0f;
    private static final int TURN_GESTURE_MAX_CLICK_PAUSE = 100;
    private static final long BRAKE_TOUCH_TIMEOUT = 300L;
    private static final long LONGPRESS_DURATION = 500L;
    private static final long FASTSCROLL_TOUCH_GESTURE_END_TIMEOUT = 300L;
    static final boolean USE_TOUCHEVENT_DELTATIME = !Boolean.getBoolean("ignoreToucheventDeltatime");
    private static final boolean NEW_SCROLL_ALGORITHM = !"old".equals(System.getProperty("MenuScrollAlgorithm"));
    private boolean touchScrollEnabled = false;
    public static final int DEFAULT_TOUCH_REPAINT_INTERVAL = 50;
    public static final int FASTSCROLL_ACCUMULATION_TIME = 250;
    private static final int FASTSCROLL_MIN_DISTANCE = 3;
    public static final int FASTSCROLL_MIN_TICKS = 4;
    private static final int FASTSCROLL_MIN_TIME = 20;
    private static final int FASTSCROLL_MAX_TIME = 500;
    private static final float FASTSCROLL_MIN_ACCELERATION = 0.5f;
    private static final float FASTSCROLL_MAX_ACCELERATION = 3.5f;
    private static final int FASTSCROLL_TOTAL_TICKS = 28;
    private static final int TOUCH_REPAINT_INTERVAL = Integer.getInteger("touchRepaintInterval", 50);
    public static final int BRAKE_SCROLL_IN_ITEMS = 2;
    private MenuController menu;
    protected ScrollSubticksFilter subticksFilter;
    Timer brakeTimer;
    private Timer longpressTimer;
    public int cursorSwipeOffset = 0;
    public int cursorSwipeHeightOffset = 0;
    private int currentFocusedItemHeight = -1;
    private int nextSwipeItemHeight = -1;
    private int lastTouchY = -1;
    private long lastTouchTime = -1L;
    private int lastFastTouchTime;
    private int lastTouchFingerCount = -1;
    private int touchDuration;
    private boolean touchContainsSwipeGesture;
    private int touchGestureDistanceY = 0;
    private boolean cursorSwipeRunning;
    private long lastTurnTime;
    private MenuFastScrollClickAccumulator fastScrollClickAccumulator = new MenuFastScrollClickAccumulator();
    private boolean fastScrollAccelerationActive;
    private boolean clickAccumulationDownward;
    private ScrollAccelerationData keyTurnFastScrollData;
    private ScrollAccelerationData touchFastScrollData;
    private int previousSubClickCount;
    private MenuItemIndex swipeSlowScrollScrolledInItem;
    private AbstractAnimation touchRepaintAnimation;

    public MenuKeyEventHandler(MenuController menuController) {
        this.menu = menuController;
        this.subticksFilter = new ScrollSubticksFilter(menuLogCh);
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.touchGestureFinished();
        this.touchDuration = 0;
        this.lastFastTouchTime = 0;
        this.lastTouchTime = this.getCurrentTime();
        this.touchGestureDistanceY = 0;
        this.lastTouchY = this.getAbsoluteY(touchEvent);
        this.lastTouchFingerCount = touchEvent.getFingerCount();
        this.subticksFilter.touchPadPressed(touchEvent);
        if (this.isCursorSwipeGesture(touchEvent)) {
            this.touchContainsSwipeGesture = true;
            this.startBrakeTimer();
            this.startCursorSwipe();
            this.startTouchRepaintAnimation();
        } else {
            this.touchContainsSwipeGesture = false;
        }
        touchEvent.consume(false);
        menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadPressed: start touch gesture (%1)", (Object)this.menu);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        this.subticksFilter.touchPadReleased(touchEvent);
        int n = this.getDeltaTime(touchEvent);
        if (this.hasCoordinates(touchEvent)) {
            this.touchDuration += n;
        }
        int n2 = this.getRelativeSwipeDistance(touchEvent);
        float f2 = this.getSwipeSpeed(n, n2);
        menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadReleased: deltatime: %1, distance: %2, finger: %3", (long)n, (long)n2, (long)touchEvent.getFingerCount());
        this.stopTouchRepaintAnimation();
        this.stopCursorSwipe();
        this.cancelBrakeTimer();
        this.checkBrakeOnRelease();
        if (this.hasCoordinates(touchEvent)) {
            if (this.isCursorSwipeGesture(touchEvent) && f2 > 2.0f) {
                ScrollAccelerationData scrollAccelerationData = this.getFastScrollDataTouch(n2);
                scrollAccelerationData.currentGestureDistance += n2;
            }
        } else {
            menuLogCh.log(100000, "MenuKeyEventHandler#touchPadReleased: event doesn't contain coordinates");
        }
        if (!this.hasCoordinates(touchEvent)) {
            this.touchDuration += n;
        }
        if (this.shouldStartTouchFastScroll()) {
            this.executeTouchFastScroll();
        }
        touchEvent.consume();
        this.touchDuration = 0;
        this.touchContainsSwipeGesture = false;
    }

    private void checkBrakeOnRelease() {
        if (!this.touchContainsSwipeGesture) {
            return;
        }
        if (this.touchDuration < 0) {
            menuLogCh.log(100000, "MenuKeyEventHandler#checkBrakeOnRelease: touchDuration is invalid: %1", (long)this.touchDuration);
        } else if ((long)this.touchDuration < 300L) {
            float f2 = this.getSwipeSpeed(this.touchDuration, this.touchGestureDistanceY);
            if (f2 < 2.0f && this.isFastViewportScrollRunning() && !this.shouldStartTouchFastScroll() && !this.isCursorVisibleInViewport()) {
                menuLogCh.log(10000000, "MenuKeyEventHandler#checkBrakeOnRelease: brake fast scroll because total gesture speed %1 below fast scroll limit, total distance: %2", (double)f2, (double)this.touchGestureDistanceY, 0.0);
                this.brakeFastViewportScrolling(true);
            } else {
                menuLogCh.log(10000000, "MenuKeyEventHandler#checkBrakeOnRelease: don't brake fast scroll. gesture speed: %1, total distance: %2", (double)f2, (double)this.touchGestureDistanceY, 0.0);
            }
        } else {
            menuLogCh.log(10000000, "MenuKeyEventHandler#checkBrakeOnRelease: gesture time %1 over timer-timeout (%2)", (long)this.touchDuration, 300L);
        }
    }

    private boolean isCursorVisibleInViewport() {
        return this.menu.getLayout().isFocusCursorVisible();
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (!touchEvent.isConsumed() && touchEvent.getFingerCount() == 0) {
            this.touchPadReleased(touchEvent);
            return;
        }
        int n = this.getDeltaTime(touchEvent);
        this.touchDuration += n;
        if (touchEvent.isConsumed()) {
            return;
        }
        touchEvent.consume(false);
        if (this.menu.getViewport().isEmpty() || !this.menu.hasFocusedItem()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadPositionMoved: menu is empty, ignore touch event. Viewport: %1, focus: %2, (%3)", (Object)this.menu.getViewport(), (Object)this.menu.getFocusedIndex(), (Object)this.menu);
            return;
        }
        int n2 = this.getRelativeSwipeDistance(touchEvent);
        float f2 = this.getSwipeSpeed(n, n2);
        if (this.isCursorSwipeGesture(touchEvent)) {
            this.touchContainsSwipeGesture = true;
            this.startTouchRepaintAnimation();
            if (f2 > 2.0f) {
                this.lastFastTouchTime = this.touchDuration;
                if (this.isFastViewportScrollRunning()) {
                    this.startBrakeTimer();
                }
                ScrollAccelerationData scrollAccelerationData = this.getFastScrollDataTouch(n2);
                scrollAccelerationData.currentGestureDistance += n2;
                menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadPositionMoved: fast scroll touch speed reached. deltatime: %1, distance: %2", (long)n, (long)n2);
            } else if (!this.isFastViewportScrollRunning() || (long)this.touchDuration > 300L) {
                if (!this.isCursorSwipeRunning()) {
                    menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadPositionMoved: start cursor swipe");
                    this.startCursorSwipe();
                    return;
                }
                if (n2 != 0) {
                    menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadPositionMoved: do cursor swipe. deltatime: %1, distance: %2", (long)n, (long)n2);
                    this.doCursorSwipe(n2);
                }
            } else {
                menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadPositionMoved: ignore slow move during gesture start. touchDuration: %1", (long)this.touchDuration);
            }
        } else {
            menuLogCh.log(10000000, "MenuKeyEventHandler#touchPadPositionMoved: stop cursor swipe. finger: %1", (long)touchEvent.getFingerCount());
            this.stopCursorSwipe();
        }
    }

    private int getDeltaTime(TouchEvent touchEvent) {
        long l = this.getCurrentTime();
        long l2 = l - this.lastTouchTime;
        this.lastTouchTime = l;
        int n = (int)Math.min(l2, Integer.MAX_VALUE);
        if (USE_TOUCHEVENT_DELTATIME) {
            int n2 = touchEvent.getDeltaTime();
            if (n2 > 0) {
                return n2;
            }
            menuLogCh.log(100000, "MenuKeyEventHandler#getDeltaTime: event has no deltatime. time since last event: %2, event: %1", (Object)touchEvent, (long)n);
            return n;
        }
        return n;
    }

    public void touchPadApproached(TouchEvent touchEvent) {
        this.subticksFilter.touchPadApproached(touchEvent);
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
        this.subticksFilter.touchPadAbandoned(touchEvent);
        if (this.isHandsOnRingEvent(touchEvent)) {
            menuLogCh.log(100000, "MenuKeyEventHandler#touchPadAbandoned: Hands left ring, so reset hDDS offset");
            this.resetHDDSSubticks();
        }
    }

    private boolean isHandsOnRingEvent(TouchEvent touchEvent) {
        return touchEvent.getCode() == 85;
    }

    public void keyPressed(KeyEvent keyEvent) {
        this.subticksFilter.keyPressed(keyEvent);
        if (this.shouldBrakeOnPress()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#keyPressed: brake fast scroll");
            this.brakeFastViewportScrolling(false);
            this.resetFastScroll();
            keyEvent.setSdsAction(3);
            keyEvent.consume();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        this.subticksFilter.keyReleased(keyEvent);
        if (this.shouldBrakeOnPress()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#keyReleased: consume event, because fast scroll is running");
            keyEvent.consume();
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        boolean bl;
        boolean bl2;
        int n = wheelButtonEvent.getSubClickCount();
        int n2 = wheelButtonEvent.getClickCount();
        boolean bl3 = bl2 = n != this.previousSubClickCount;
        if (n2 == 0 && !bl2) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#keyTurned: received duplicate event for subClickCount %1", (long)n);
            wheelButtonEvent.consume(false);
            return;
        }
        menuLogCh.log(10000000, "MenuKeyEventHandler#keyTurned: direction: %1, clickCount: %2, subClickCount %3", (long)wheelButtonEvent.getDirection(), (long)n2, (long)n);
        wheelButtonEvent.consume(false);
        this.previousSubClickCount = n;
        if (this.menu.getViewport().isEmpty()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#keyTurned: viewport is empty");
            return;
        }
        if (wheelButtonEvent.isVerticalDirection()) {
            bl = wheelButtonEvent.getDirection() == 0;
        } else {
            HMITerminalImpl hMITerminalImpl = this.menu.getTerminalImpl();
            boolean bl4 = hMITerminalImpl.getFramework().getLanguageMgr().isLeftToRightOrientation();
            boolean bl5 = bl = hMITerminalImpl.getLayout().getRotationalDirection(wheelButtonEvent.getDirection()) == (bl4 ? 1 : 2);
        }
        if (this.shouldBrakeOnTurn(n2, bl)) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#keyTurned: brake fast scroll because keyTurn in opposite direction");
            this.brakeFastViewportScrolling(false);
            this.resetFastScroll();
            return;
        }
        int n3 = NEW_SCROLL_ALGORITHM ? this.calculateFocusChangeKeyTurnNew(n2, bl) : this.calculateFocusChangeKeyTurnOld(n2, bl);
        MenuItemIndex menuItemIndex = this.getNewFocusItem(bl, n3, true);
        if (menuItemIndex == null) {
            menuLogCh.log(100000, "MenuKeyEventHandler#keyTurned: no focused item can be calculated (menu empty?).");
            this.resetHDDSSubticks();
            return;
        }
        if (menuItemIndex.equals(this.menu.getFocusedIndex())) {
            if (bl2) {
                this.menu.getAnimationManager().subclicksChanged();
            }
        } else {
            this.menu.focusItem(menuItemIndex);
        }
        this.calculateHDDSCursorOffset(menuItemIndex, n2, n, bl);
    }

    private boolean shouldBrakeOnTurn(int n, boolean bl) {
        if (n == 0) {
            return false;
        }
        if (!this.isFastViewportScrollRunning()) {
            return false;
        }
        boolean bl2 = this.menu.getAnimationManager().isViewportScrollingDownward();
        if (bl2 == bl) {
            return false;
        }
        return !this.isAlreadyBraking(bl2);
    }

    private boolean shouldBrakeOnPress() {
        if (!this.isFastViewportScrollRunning()) {
            return false;
        }
        boolean bl = this.menu.getAnimationManager().isViewportScrollingDownward();
        return !this.isAlreadyBraking(bl);
    }

    private boolean isAlreadyBraking(boolean bl) {
        int n;
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        this.menu.manageLayout();
        int n2 = n = bl ? this.menu.getLayout().getLastVisibleItem() : this.menu.getLayout().getFirstVisibleItem();
        if (n == -1 || menuItemIndex == null) {
            menuLogCh.log(100000, "MenuKeyEventHandler#isAlreadyBraking: focus (%1) or visible edge item (%2) not defined", (Object)menuItemIndex, (long)n);
            return false;
        }
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.menu.getAnimationManager().getLayoutData().layoutItems.get(n);
        MenuItemIndex menuItemIndex2 = menuItemMetaData.index;
        if (!MenuLayoutData.isBefore(menuItemIndex2, menuItemIndex, bl)) {
            return true;
        }
        if (menuItemIndex2.widget == menuItemIndex.widget) {
            int n3 = Math.abs(menuItemIndex2.widgetPart - menuItemIndex.widgetPart);
            return n3 <= 2;
        }
        Iterator iterator = this.menu.iterator(menuItemIndex2, bl, false);
        for (int i2 = 0; i2 <= 2 && iterator.hasNext(); ++i2) {
            MenuItemIndex menuItemIndex3 = (MenuItemIndex)iterator.next();
            if (!menuItemIndex.equals(menuItemIndex3)) continue;
            return true;
        }
        return false;
    }

    private void accumulateClicks(int n, boolean bl, long l) {
        if (bl != this.clickAccumulationDownward) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#accumulateClicks: direction changed. new direction: %1", (Object)(bl ? "down" : "up"));
            this.resetFastScroll();
        }
        this.clickAccumulationDownward = bl;
        if (this.fastScrollAccelerationActive) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#accumulateClicks: fast scroll already active");
            return;
        }
        this.fastScrollAccelerationActive = this.fastScrollClickAccumulator.keyTurned(n, l);
        if (this.fastScrollAccelerationActive) {
            this.fastScrollClickAccumulator.clear();
        }
    }

    private int calculateFastScrollInitialAcceleration(int n) {
        int n2 = n * 3;
        menuLogCh.log(10000000, "MenuKeyEventHandler#calculateFastScrollInitialAcceleration: clickCount: %1, => accelerated clickCount: %2", (long)n, (long)n2);
        return n2;
    }

    private int calculateFastScrollAcceleration(int n, long l, boolean bl) {
        double d2 = l > 500L ? 0.01785714365541935 : (l < 20L ? 0.125 : (0.5 + 3.0 * Math.log(500.0 / (double)l) / Math.log(25.0)) / 28.0);
        if (n > 1) {
            d2 = (d2 + 1.0) * Math.pow(1.125, n - 1) - 1.0;
        }
        int n2 = this.getDestinationDistance(bl);
        int n3 = (int)Math.floor((double)n2 * d2 + 1.5);
        menuLogCh.log(10000000, "MenuKeyEventHandler#calculateFastScrollAcceleration: time: %1, distance: %2, => accelerated clickCount: %3", l, (long)n2, (long)n3);
        return n3;
    }

    private int getDestinationDistance(boolean bl) {
        int n;
        this.menu.manageLayout();
        int n2 = n = bl ? this.menu.getLayout().getLastVisibleItem() : this.menu.getLayout().getFirstVisibleItem();
        if (n == -1 || this.menu.getViewport().isEmpty()) {
            return 0;
        }
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)this.menu.getAnimationManager().getLayoutData().layoutItems.get(n);
        MenuItemIndex menuItemIndex = bl ? this.menu.getViewport().end : this.menu.getViewport().start;
        int n3 = this.menu.getFlatIndex(menuItemMetaData.index);
        int n4 = this.menu.getFlatIndex(menuItemIndex);
        return Math.abs(n4 - n3);
    }

    private void calculateHDDSCursorOffset(MenuItemIndex menuItemIndex, int n, int n2, boolean bl) {
        boolean bl2 = n2 > 0;
        float f2 = this.subticksFilter.calculateSubticksProgress(n, n2, bl);
        if (f2 == 0.0f) {
            this.setHDDSCursorOffset(0, 0);
            return;
        }
        Iterator iterator = this.menu.iterator(menuItemIndex, bl2, false);
        MenuItemIndex menuItemIndex2 = (MenuItemIndex)(iterator.hasNext() ? iterator.next() : menuItemIndex);
        int n3 = this.getMenuItemHeight(menuItemIndex);
        int n4 = this.getMenuItemHeight(menuItemIndex2);
        int n5 = bl2 ? n3 : n4;
        int n6 = n5 + this.menu.getLayout().getItemsGap();
        int n7 = Math.round((float)n6 * f2);
        int n8 = n4 - this.menu.getMenuItemMargin(menuItemIndex2, true) - this.menu.getMenuItemMargin(menuItemIndex2, false) + this.menu.getMenuItemFilledInsets(menuItemIndex2, true) + this.menu.getMenuItemFilledInsets(menuItemIndex2, false);
        int n9 = n3 - this.menu.getMenuItemMargin(menuItemIndex, true) - this.menu.getMenuItemMargin(menuItemIndex, false) + this.menu.getMenuItemFilledInsets(menuItemIndex, true) + this.menu.getMenuItemFilledInsets(menuItemIndex, false);
        int n10 = n8 - n9;
        int n11 = Math.round((float)n10 * Math.abs(f2));
        menuLogCh.log(10000000, "MenuKeyEventHandler#calculateHDDSCursorOffset: cursorOffsetHDDS: %1, cursorHeightOffsetHDDS: %2, subClickProgress: %3", (double)n7, (double)n11, (double)f2);
        this.setHDDSCursorOffset(n7, n11);
    }

    private void setHDDSCursorOffset(int n, int n2) {
        MenuAnimationManager menuAnimationManager = this.menu.getAnimationManager();
        if (this.menu.hasFocusedItem()) {
            MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
            MenuItemMetaData menuItemMetaData = menuAnimationManager.getLayoutData().findAnimationItem(menuItemIndex);
            if (menuItemMetaData == null) {
                menuLogCh.log(100000, "MenuKeyEventHandler#setHDDSCursorOffset: focused itemMetaData not found for index: %1", (Object)menuItemIndex);
            } else {
                menuAnimationManager.adjustCursorLayoutAfter(menuItemMetaData);
                menuAnimationManager.setCursorHeightAfter(menuAnimationManager.getLayoutData().cursorHeightAfter + n2);
                menuAnimationManager.setCursorOffsetAfter(menuAnimationManager.getLayoutData().cursorOffsetAfter + n);
            }
        } else {
            menuLogCh.log(10000000, "MenuKeyEventHandler#setHDDSCursorOffset: no focused item");
            menuAnimationManager.setCursorHeightAfter(0);
            menuAnimationManager.setCursorOffsetAfter(0);
        }
    }

    private void resetHDDSSubticks() {
        this.setHDDSCursorOffset(0, 0);
    }

    private void executeTouchFastScroll() {
        int n = this.getLastSpeedUpdateDuration(this.touchFastScrollData, this.getCurrentTime());
        this.calculateAcceleratedSpeed(this.touchFastScrollData, n, AccelerationFunctionParameters.TOUCH_PARAMS);
        int n2 = this.touchFastScrollData.speed * this.touchFastScrollData.currentGestureDistance / this.getTouchpadPixelsPerMenuItem();
        MenuItemIndex menuItemIndex = this.getNewFocusItem(this.touchFastScrollData.down, n2, false);
        menuLogCh.log(10000000, "MenuKeyEventHandler#executeTouchFastScroll: start fast scroll to item: %1", (Object)menuItemIndex);
        if (menuItemIndex != null) {
            this.menu.focusItem(menuItemIndex);
        }
        this.touchGestureFinished();
    }

    private boolean shouldStartTouchFastScroll() {
        if (this.touchFastScrollData == null) {
            return false;
        }
        if (this.touchFastScrollData == null || this.touchFastScrollData.currentGestureDistance == 0) {
            return false;
        }
        int n = this.touchDuration - this.lastFastTouchTime;
        if ((long)n > 300L) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#shouldStartTouchFastScroll: ignore fastscroll by distance %1, because time since last fast event is %2", (long)this.touchFastScrollData.currentGestureDistance, (long)n);
            return false;
        }
        return true;
    }

    private int getTouchpadPixelsPerMenuItem() {
        if (this.isAllInTouchKeyPanel()) {
            return 50;
        }
        return 100;
    }

    private ScrollAccelerationData getFastScrollDataTouch(int n) {
        boolean bl;
        boolean bl2 = bl = n > 0;
        if (this.touchFastScrollData == null || this.touchFastScrollData.down != bl) {
            this.touchFastScrollData = new ScrollAccelerationData(bl);
        }
        return this.touchFastScrollData;
    }

    private int calculateFocusChangeKeyTurnNew(int n, boolean bl) {
        if (n == 0) {
            return n;
        }
        long l = this.getCurrentTime();
        long l2 = l - this.lastTurnTime;
        this.lastTurnTime = l;
        boolean bl2 = this.fastScrollAccelerationActive;
        this.accumulateClicks(n, bl, l);
        if (!this.fastScrollAccelerationActive) {
            return n;
        }
        if (!bl2) {
            return this.calculateFastScrollInitialAcceleration(n);
        }
        return this.calculateFastScrollAcceleration(n, l2, bl);
    }

    private int calculateFocusChangeKeyTurnOld(int n, boolean bl) {
        int n2;
        if (this.keyTurnFastScrollData == null || this.keyTurnFastScrollData.down != bl) {
            this.keyTurnFastScrollData = new ScrollAccelerationData(bl);
        }
        if (n != 0) {
            n2 = this.getLastSpeedUpdateDuration(this.keyTurnFastScrollData, this.getCurrentTime());
            if (n2 < 100) {
                ++this.keyTurnFastScrollData.currentGestureDistance;
            } else {
                this.keyTurnFastScrollData.currentGestureDistance = 1;
                this.keyTurnFastScrollData.currentGestureAccelerated = false;
            }
            this.calculateAcceleratedSpeed(this.keyTurnFastScrollData, n2, AccelerationFunctionParameters.TURN_PARAMS);
        }
        n2 = n * this.keyTurnFastScrollData.speed;
        return n2;
    }

    private void calculateAcceleratedSpeed(ScrollAccelerationData scrollAccelerationData, int n, AccelerationFunctionParameters accelerationFunctionParameters) {
        int n2 = Math.round((float)(accelerationFunctionParameters.accelerationPerStep * n) / (float)accelerationFunctionParameters.decelerateTimePerStep);
        scrollAccelerationData.speed -= n2;
        scrollAccelerationData.speed = Math.max(scrollAccelerationData.speed, 1);
        if (Math.abs(scrollAccelerationData.currentGestureDistance) >= accelerationFunctionParameters.minDistanceForAccelerate && !scrollAccelerationData.currentGestureAccelerated) {
            scrollAccelerationData.currentGestureAccelerated = true;
            scrollAccelerationData.speed += accelerationFunctionParameters.accelerationPerStep;
            scrollAccelerationData.speed = Math.min(scrollAccelerationData.speed, accelerationFunctionParameters.maxSpeed);
            menuLogCh.log(10000000, "MenuKeyEventHandler#calculateAcceleratedSpeed: fast scroll with speed factor: %1, gesture distance: %2", (long)scrollAccelerationData.speed, (long)scrollAccelerationData.currentGestureDistance);
        }
    }

    private MenuItemIndex getNewFocusItem(boolean bl, int n, boolean bl2) {
        MenuItemIndex menuItemIndex;
        MenuItemIndex menuItemIndex2 = menuItemIndex = this.menu.hasFocusedItem() ? this.menu.getFocusedIndex() : this.menu.getFirstMenuItem();
        if (menuItemIndex == null) {
            return null;
        }
        if (n == 0) {
            return menuItemIndex;
        }
        for (int i2 = 0; i2 < Math.abs(n); ++i2) {
            Iterator iterator = this.menu.iterator(menuItemIndex = this.menu.getUnfocusableVisibleEdge(menuItemIndex, bl), bl, false);
            if (!iterator.hasNext()) {
                if (!bl2) break;
                menuLogCh.log(10000000, "MenuKeyEventHandler#getNewFocusItem: end of menu reached at %1. Bounce cursor, lock hDDS.", (Object)menuItemIndex);
                this.subticksFilter.endOfListReached();
                this.menu.getAnimationManager().startCursorBounce(bl);
                break;
            }
            menuItemIndex = (MenuItemIndex)iterator.next();
        }
        return menuItemIndex;
    }

    public void clearCache() {
        this.currentFocusedItemHeight = -1;
        this.nextSwipeItemHeight = -1;
    }

    private void touchGestureFinished() {
        if (this.touchFastScrollData != null) {
            this.touchFastScrollData.currentGestureAccelerated = false;
            this.touchFastScrollData.currentGestureDistance = 0;
        }
    }

    protected long getCurrentTime() {
        return AbstractWidget.framework.getMonotonicTime();
    }

    private void startCursorSwipe() {
        this.cursorSwipeRunning = true;
    }

    private void stopCursorSwipe() {
        if (!this.cursorSwipeRunning) {
            return;
        }
        this.cursorSwipeRunning = false;
        this.stopSlowViewportScrolling();
        this.changeCursorSwipeOffset(-this.cursorSwipeOffset);
        this.cursorSwipeHeightOffset = 0;
        this.swipeSlowScrollScrolledInItem = null;
        this.menu.relayout();
    }

    public boolean isCursorSwipeRunning() {
        return this.cursorSwipeRunning;
    }

    private void doCursorSwipe(int n) {
        this.changeCursorSwipeOffset(n);
        menuLogCh.log(10000000, "MenuKeyEventHandler#doCursorSwipe: moved by %2, now offset %3 from item %1", (Object)this.menu.getFocusedIndex(), (long)n, (long)this.cursorSwipeOffset);
        this.checkSlowViewportAnimation();
        this.checkCursorSwipeFocusChange();
        this.adjustCursorHeight();
        this.menu.relayout();
    }

    private void changeCursorSwipeOffset(int n) {
        boolean bl = this.isDownwardCursorSwipe();
        this.cursorSwipeOffset += n;
        boolean bl2 = this.isDownwardCursorSwipe();
        if (bl != bl2) {
            this.clearCache();
        }
    }

    private void adjustCursorHeight() {
        float f2 = this.getCursorSwipeProgress();
        int n = this.getNextSwipeItemHeight() - this.getCurrentFocusedItemHeight();
        this.cursorSwipeHeightOffset = Math.round((float)n * f2);
        if (menuLogCh.isDebug()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#adjustCursorHeight: current swipe item " + this.menu.getFocusedIndex() + " with height: %1, next swipe item " + this.getNextSwipeItemIndex() + " with height: %2, offset: " + this.cursorSwipeOffset + ", progress: " + f2, (long)this.getCurrentFocusedItemHeight(), (long)this.getNextSwipeItemHeight());
        }
    }

    private void checkCursorSwipeFocusChange() {
        if (this.getCursorSwipeProgress() > 0.5f) {
            MenuItemIndex menuItemIndex = this.getNextSwipeItemIndex();
            if (menuItemIndex != null) {
                if (this.menu.getViewport().contains(menuItemIndex)) {
                    int n = this.getSwipeDistanceToNextItem();
                    menuLogCh.log(10000000, "MenuKeyEventHandler#checkCursorSwipeFocusChange: moved to next item: %1, new offset: %2", (Object)menuItemIndex, (long)this.cursorSwipeOffset);
                    int n2 = this.nextSwipeItemHeight;
                    int n3 = this.currentFocusedItemHeight;
                    MenuItemIndex menuItemIndex2 = this.menu.getFocusedIndex();
                    MenuUpdateRequest menuUpdateRequest = new MenuUpdateRequest(menuItemIndex, FocusAdvice.KEEP_POSITION, MenuUpdateRequest.UPDATE_NONE);
                    this.menu.getAnimationManager().focus(menuUpdateRequest, true, false);
                    if (Util.equals(menuItemIndex2, this.menu.getFocusedIndex())) {
                        MenuItemMetaData menuItemMetaData = this.menu.getAnimationManager().getLayoutData().findAnimationItem(menuItemIndex2);
                        this.menu.getAnimationManager().adjustCursor(menuItemMetaData, menuItemMetaData, false);
                    } else {
                        this.cursorSwipeOffset += this.isDownwardCursorSwipe() ? n * -1 : n;
                        this.nextSwipeItemHeight = n3;
                        this.currentFocusedItemHeight = n2;
                    }
                }
            } else {
                menuLogCh.log(10000000, "MenuKeyEventHandler#checkCursorSwipeFocusChange: end of menu reached at item: %1", (Object)this.menu.getFocusedIndex());
                int n = this.getCurrentFocusedItemHeight() + this.menu.getLayout().getItemsGap();
                int n4 = n / 2;
                this.cursorSwipeOffset = this.isDownwardCursorSwipe() ? n4 : -n4;
            }
        }
    }

    private void checkSlowViewportAnimation() {
        menuLayoutLogCh.log(10000000, "MenuKeyEventHandler#checkSlowViewportAnimation: relayout menu to get current cursorGlassplateDistance");
        this.menu.relayout();
        this.menu.manageLayout();
        int[] nArray = this.menu.getLayout().getFocusCursorDistanceFromGlassplate();
        if (nArray == null) {
            menuLogCh.log(100000, "MenuKeyEventHandler#checkSlowViewportAnimation: cursor is not visible");
            return;
        }
        int n = nArray[0] + this.cursorSwipeOffset;
        int n2 = nArray[1] - this.cursorSwipeOffset - this.cursorSwipeHeightOffset;
        boolean bl = this.isBrakeTimerRunning();
        if (n < 3) {
            if (n < 0) {
                this.cursorSwipeOffset -= n;
                menuLogCh.log(10000000, "MenuKeyEventHandler#checkSlowViewportAnimation: change offset by %1 to %2 to limit cursor at glassplate top", (long)n, (long)this.cursorSwipeOffset);
            }
            if (!bl && this.isFocusOutsideViewport(true)) {
                this.startSlowViewportScroll(false);
            }
        } else if (n2 < 3) {
            if (n2 < 0) {
                this.cursorSwipeOffset += n2;
                menuLogCh.log(10000000, "MenuKeyEventHandler#checkSlowViewportAnimation: change offset by %1 to %2 to limit cursor at glassplate bottom", (long)n2, (long)this.cursorSwipeOffset);
            }
            if (!bl && this.isFocusOutsideViewport(false)) {
                this.startSlowViewportScroll(true);
            }
        }
    }

    private boolean isFocusOutsideViewport(boolean bl) {
        MenuItemIndex menuItemIndex = bl ? this.menu.getViewport().start : this.menu.getViewport().end;
        MenuItemMetaData menuItemMetaData = this.menu.getAnimationManager().getLayoutData().findAnimationItem(menuItemIndex);
        if (!menuItemMetaData.isRealized()) {
            menuLogCh.log(100000, "MenuKeyEventHandler#isFocusOutsideViewport: viewport edge item %1 is not realized", (Object)menuItemMetaData);
            return false;
        }
        if (bl) {
            int n = this.menu.getLayout().getLastFocusPosition() + this.cursorSwipeOffset;
            return n <= menuItemMetaData.widget.getY();
        }
        int n = menuItemMetaData.widget.getY() + menuItemMetaData.widget.getHeight();
        int n2 = this.menu.getLayout().getLastFocusPosition() + this.menu.getLayout().getLastFocusHeight() + this.cursorSwipeOffset + this.cursorSwipeHeightOffset;
        return n2 >= n;
    }

    private void startSlowViewportScroll(boolean bl) {
        MenuItemIndex menuItemIndex;
        boolean bl2 = this.isDownwardCursorSwipe() == bl;
        MenuItemIndex menuItemIndex2 = menuItemIndex = bl2 ? this.getNextSwipeItemIndex() : this.menu.getFocusedIndex();
        if (menuItemIndex == null) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#startSlowViewportScroll: cant scroll any more because of end of menu. Focused item: %1", (Object)this.menu.getFocusedIndex());
            return;
        }
        this.swipeSlowScrollScrolledInItem = menuItemIndex;
        this.menu.getAnimationManager().startSlowViewportScrolling(menuItemIndex);
    }

    private void stopSlowViewportScrolling() {
        if (this.isSlowViewportScrollRunning()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#stopSlowViewportScrolling: stop slow scrolling");
            this.menu.getAnimationManager().deactivateSlowViewportScrolling();
        }
    }

    protected void brakeFastViewportScrolling(boolean bl) {
        this.menu.getAnimationManager().brakeFastViewportScrolling(bl);
    }

    private boolean isSlowViewportScrollRunning() {
        return this.menu.getAnimationManager().isSlowViewportScrollingRunning();
    }

    private boolean isFastViewportScrollRunning() {
        return this.menu.getAnimationManager().isFastViewportScrollingRunning();
    }

    public void animateSlowViewportScrolling(int n) {
        if (this.isCursorSwipeRunning() && this.isSlowViewportScrollRunning()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#animateSlowViewportScrolling: animate slow scroll by %2 (%1)", (Object)this.menu, (long)n);
            this.doCursorSwipe(-n);
        }
    }

    float getCursorSwipeProgress() {
        int n = this.getSwipeDistanceToNextItem();
        return Math.abs((float)this.cursorSwipeOffset / (float)n);
    }

    private int getSwipeDistanceToNextItem() {
        if (this.isSlowScrollingInsideUnfocusableItem()) {
            return this.getFocusedMultiLineItemLineHeight();
        }
        int n = this.isDownwardCursorSwipe() ? this.getCurrentFocusedItemHeight() : this.getNextSwipeItemHeight();
        return n + this.menu.getLayout().getItemsGap();
    }

    private int getFocusedMultiLineItemLineHeight() {
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        AbstractWidget abstractWidget = this.menu.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiLine) {
            return ((IMenuItemMultiLine)((Object)abstractWidget)).getPreferredLineHeight(menuItemIndex.widgetPart);
        }
        menuLogCh.log(10000, "MenuKeyEventHandler#getFocusedMultiLineItemLineHeight: item %1 is not a MultiLine-Widget: %2", (Object)menuItemIndex, (Object)abstractWidget);
        return 42;
    }

    int getCurrentFocusedItemHeight() {
        if (this.currentFocusedItemHeight == -1) {
            this.currentFocusedItemHeight = this.calculateUncachedCurrentFocusedItemHeight();
        }
        return this.currentFocusedItemHeight;
    }

    int getNextSwipeItemHeight() {
        if (this.nextSwipeItemHeight == -1) {
            this.nextSwipeItemHeight = this.calculateUncachedNextSwipeItemHeight();
        }
        return this.nextSwipeItemHeight;
    }

    private int calculateUncachedCurrentFocusedItemHeight() {
        if (!this.menu.hasFocusedItem()) {
            return 0;
        }
        MenuItemIndex menuItemIndex = this.menu.getFocusedIndex();
        int n = this.getMenuItemHeight(menuItemIndex) - this.menu.getMenuItemMargin(menuItemIndex, true) - this.menu.getMenuItemMargin(menuItemIndex, false) + this.menu.getMenuItemFilledInsets(menuItemIndex, true) + this.menu.getMenuItemFilledInsets(menuItemIndex, false);
        if (this.isSlowScrollingInsideUnfocusableItem()) {
            n -= this.getFocusedMultiLineItemLineHeight();
        }
        return n;
    }

    private int calculateUncachedNextSwipeItemHeight() {
        if (!this.menu.hasFocusedItem()) {
            return 0;
        }
        MenuItemIndex menuItemIndex = this.getNextSwipeItemIndex();
        if (menuItemIndex != null) {
            int n = this.getMenuItemHeight(menuItemIndex) - this.menu.getMenuItemMargin(menuItemIndex, true) - this.menu.getMenuItemMargin(menuItemIndex, false) + this.menu.getMenuItemFilledInsets(menuItemIndex, true) + this.menu.getMenuItemFilledInsets(menuItemIndex, false);
            return n;
        }
        return this.getCurrentFocusedItemHeight();
    }

    private boolean isSlowScrollingInsideUnfocusableItem() {
        if (!this.menu.getAnimationManager().isSlowViewportScrollingRunning()) {
            return false;
        }
        if (!this.menu.hasFocusedItem()) {
            return false;
        }
        if (this.menu.isMenuItemFocusable(this.menu.getFocusedIndex())) {
            return false;
        }
        MenuItemIndex menuItemIndex = this.getNextSwipeItemIndex();
        if (menuItemIndex == null) {
            return false;
        }
        return !this.menu.isMenuItemFocusable(menuItemIndex);
    }

    private int getMenuItemHeight(MenuItemIndex menuItemIndex) {
        return this.menu.getAnimationManager().getFocusableHeightForItem(menuItemIndex);
    }

    private MenuItemIndex getNextSwipeItemIndex() {
        Iterator iterator;
        MenuItemIndex menuItemIndex;
        MenuItemIndex menuItemIndex2 = this.menu.getFocusedIndex();
        if (!Util.equals(menuItemIndex2, menuItemIndex = this.menu.getUnfocusableVisibleEdge(menuItemIndex2, this.isDownwardCursorSwipe()))) {
            if (Util.equals(menuItemIndex, this.swipeSlowScrollScrolledInItem)) {
                iterator = this.menu.iterator(menuItemIndex, !this.isDownwardCursorSwipe(), false);
                if (iterator.hasNext()) {
                    menuItemIndex = (MenuItemIndex)iterator.next();
                }
            } else if (Util.equals(menuItemIndex2, this.swipeSlowScrollScrolledInItem)) {
                menuItemIndex = menuItemIndex2;
            }
        }
        if ((iterator = this.menu.iterator(menuItemIndex, this.isDownwardCursorSwipe(), false)).hasNext()) {
            return (MenuItemIndex)iterator.next();
        }
        return null;
    }

    private boolean isDownwardCursorSwipe() {
        return this.cursorSwipeOffset > 0;
    }

    private int getRelativeSwipeDistance(TouchEvent touchEvent) {
        if (!this.touchScrollEnabled) {
            return 0;
        }
        int n = this.getAbsoluteY(touchEvent);
        int n2 = touchEvent.getFingerCount() == this.lastTouchFingerCount ? n - this.lastTouchY : 0;
        this.lastTouchFingerCount = touchEvent.getFingerCount();
        int n3 = Math.round((float)n2 * this.getSwipeDistanceFactor());
        menuLogCh.log(10000000, "MenuKeyEventHandler#getRelativeSwipeDistance: raw swipe distance: %1, adjusted distance: %2", (long)n2, (long)n3);
        if (this.hasCoordinates(touchEvent) && n3 != 0) {
            this.lastTouchY = n;
            this.touchGestureDistanceY += n2;
        }
        return n3;
    }

    protected float getSwipeDistanceFactor() {
        return this.menu.getTerminalImpl().getLayout().getFloatConstant(17);
    }

    private int getAbsoluteY(TouchEvent touchEvent) {
        if (touchEvent.getID() == 10911 || touchEvent.getID() == 10905 || touchEvent.getID() == 10904) {
            return touchEvent.getY();
        }
        if (touchEvent.getID() == 10912) {
            return this.lastTouchY + touchEvent.getY();
        }
        menuLogCh.log(100000, "MenuKeyEventHandler#getAbsoluteY: unknown touch event type %2 for event: %1", (Object)touchEvent, (long)touchEvent.getID());
        return 0;
    }

    private float getSwipeSpeed(int n, int n2) {
        if (n == 0) {
            menuLogCh.log(100000, "MenuKeyEventHandler#getSwipeSpeed: can not measure speed (duration=0).");
            return 0.0f;
        }
        return (float)Math.abs(n2) / (float)n;
    }

    private int getLastSpeedUpdateDuration(ScrollAccelerationData scrollAccelerationData, long l) {
        int n = (int)Math.min(l - scrollAccelerationData.lastSpeedUpdateTime, Integer.MAX_VALUE);
        scrollAccelerationData.lastSpeedUpdateTime = l;
        return n;
    }

    public boolean isCursorSwipeGesture(TouchEvent touchEvent) {
        return this.touchScrollEnabled && touchEvent.getFingerCount() == 2;
    }

    private boolean hasCoordinates(TouchEvent touchEvent) {
        return touchEvent.getX() != 0 || touchEvent.getY() != 0;
    }

    public void connect() {
        this.clearCache();
        this.subticksFilter.reset();
        this.setTouchScrollEnabled(false);
        this.resetFastScroll();
        if (!this.touchScrollEnabled) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#connect: touch scrolling is disabled");
        }
    }

    protected boolean isAllInTouchKeyPanel() {
        if (this.menu.getTerminal() == null || this.menu.getTerminal().getKbdService() == null) {
            return false;
        }
        return this.menu.getTerminal().getKbdService().getCurrentKeyboardType() == 6;
    }

    public void disconnect() {
        this.resetTouchHandling();
        this.cancelLongpressTimer();
    }

    private void resetFastScroll() {
        this.fastScrollClickAccumulator.clear();
        this.fastScrollAccelerationActive = false;
    }

    private void resetTouchHandling() {
        this.stopCursorSwipe();
        this.stopTouchRepaintAnimation();
        this.touchRepaintAnimation = null;
        this.cancelBrakeTimer();
        this.clearCache();
        this.touchDuration = 0;
        this.touchContainsSwipeGesture = false;
        this.lastFastTouchTime = 0;
        this.lastTouchTime = -1L;
        this.swipeSlowScrollScrolledInItem = null;
        this.previousSubClickCount = 0;
    }

    public void focusGained() {
        this.subticksFilter.reset();
    }

    public void focusLost() {
        this.resetTouchHandling();
        this.cancelLongpressTimer();
    }

    Timer getBrakeTimer() {
        if (this.brakeTimer == null) {
            this.brakeTimer = new Timer("BrakeGestureTimer", 300L, true, new TimerSyncer(this));
        }
        return this.brakeTimer;
    }

    private Timer getLongpressTimer() {
        if (this.longpressTimer == null) {
            this.longpressTimer = new Timer("LongpressTimer", 500L, true, new TimerSyncer(this));
        }
        return this.longpressTimer;
    }

    void setTouchScrollEnabled(boolean bl) {
        this.touchScrollEnabled = bl;
    }

    protected boolean isBrakeTimerRunning() {
        return this.brakeTimer != null && this.brakeTimer.isRunning();
    }

    protected boolean isLongpressTimerRunning() {
        return this.longpressTimer != null && this.longpressTimer.isRunning() && !this.longpressTimer.isCanceled();
    }

    protected void startLongpressTimer() {
        if (!this.isLongpressTimerRunning()) {
            this.getLongpressTimer().restart();
            menuLogCh.log(10000000, "MenuKeyEventHandler#startLongpressTimer: Key pressed, LongpressTimer started.");
        }
    }

    protected void startBrakeTimer() {
        this.getBrakeTimer().restart();
    }

    protected void cancelBrakeTimer() {
        if (this.brakeTimer != null) {
            this.brakeTimer.cancel();
            this.brakeTimer = null;
        }
    }

    protected boolean cancelLongpressTimer() {
        if (this.longpressTimer != null) {
            boolean bl = this.longpressTimer.cancel();
            menuLogCh.log(10000000, "MenuKeyEventHandler#cancelLongpressTimer: Key released, cancel LongpressTimer (was running: %1)", bl);
            return bl;
        }
        menuLogCh.log(10000000, "MenuKeyEventHandler#cancelLongpress: long press timer is not running");
        return false;
    }

    public void fireTimer(Timer timer) {
        if (timer == this.brakeTimer) {
            if (this.isFastViewportScrollRunning()) {
                menuLogCh.log(10000000, "MenuKeyEventHandler#fireTimer: brake fast scroll because of brake timer (%1)", (Object)this.menu);
                this.brakeFastViewportScrolling(true);
            } else {
                menuLogCh.log(10000000, "MenuKeyEventHandler#fireTimer: brake timer fired, but no fast scroll running (%1)", (Object)this.menu);
            }
        }
        if (timer == this.longpressTimer) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#fireTimer: Longpress timer fired (%1)", (Object)this.menu);
            ((DrawerFocusManager)this.menu.getTerminalImpl().getDrawerFocusManager()).getLongpressKeyHandler().handleLongpressStarted(this.menu);
        }
    }

    public void cancelTimer(Timer timer) {
        menuLogCh.log(10000000, "MenuKeyEventHandler#cancelTimer called. timer: %1, menu: %2", (Object)timer, (Object)this.menu);
    }

    private void startTouchRepaintAnimation() {
        if (this.touchRepaintAnimation == null) {
            this.touchRepaintAnimation = (AbstractAnimation)this.menu.getTerminal().getIAnimationController().getIAnimation(1);
            this.touchRepaintAnimation.addListener(this);
        }
        if (!this.touchRepaintAnimation.isAnimating()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#startTouchRepaintAnimation");
            this.touchRepaintAnimation.startEndlessAnimation(TOUCH_REPAINT_INTERVAL, this.menu);
        }
    }

    private void stopTouchRepaintAnimation() {
        if (this.touchRepaintAnimation != null && this.touchRepaintAnimation.isAnimating()) {
            menuLogCh.log(10000000, "MenuKeyEventHandler#stopTouchRepaintAnimation");
            this.touchRepaintAnimation.stopAnimation();
        }
    }

    public void animate(int n, float f2, int n2) {
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
    }

    public void scrollAnimationFinished() {
        menuLogCh.log(10000000, "MenuKeyEventHandler#scrollAnimationFinished. Fast scroll was active: %1", this.fastScrollAccelerationActive);
        this.resetFastScroll();
    }

    public ScrollSubticksFilter getSubticksFilter() {
        return this.subticksFilter;
    }

    public boolean isFastScrollAccelerationActive() {
        return this.fastScrollAccelerationActive;
    }

    public static class ScrollAccelerationData {
        public static final int DEFAULT_SPEED = 1;
        long lastSpeedUpdateTime = -1L;
        int speed = 1;
        int currentGestureDistance = 0;
        boolean currentGestureAccelerated = false;
        boolean down;

        public ScrollAccelerationData(boolean bl) {
            this.down = bl;
        }
    }

    public static class AccelerationFunctionParameters {
        static final AccelerationFunctionParameters TURN_PARAMS = new AccelerationFunctionParameters();
        static final AccelerationFunctionParameters TOUCH_PARAMS = new AccelerationFunctionParameters();
        public int decelerateTimePerStep = 800;
        public int minDistanceForAccelerate = 5;
        public int accelerationPerStep = 3;
        public int maxAccelerationSteps = 3;
        public int maxSpeed = 1 + this.accelerationPerStep * this.maxAccelerationSteps;
    }
}

