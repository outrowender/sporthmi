/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public class ScrollSubticksFilter
implements WidgetConstants {
    static final int STATE_INIT = 0;
    static final int STATE_STABLE = 1;
    static final int STATE_MOVE = 2;
    private static final int HDDS_SUBCLICKS_PER_MAINCLICK = 100;
    private static final int HDDS_SNAP_IN_SUBTICKS = 15;
    private static final float HDDS_START_THRESHOLD_BIG = 0.15f;
    private static final float HDDS_START_THRESHOLD_SMALL = 0.015f;
    private static final int HDDS_START_THRESHOLD_CHANGE_TIME = 500;
    private static final int HDDS_CLICK_DELAY = 250;
    private static final int UNDEFINED_SUBTICKS = 999999;
    private int state;
    private boolean fingersOnTouchpad;
    private boolean handsOnRing;
    private boolean ddsPressed;
    private long lastClickTime;
    private long thresholdChangeStartTime;
    private int lastSubticks;
    private int stableOriginPosition;
    private int mainTickSum;
    private boolean originSnapIn;
    private boolean hddsLockedForListEnd = false;
    private final LogChannel lc;

    public ScrollSubticksFilter(LogChannel logChannel) {
        this.lc = logChannel;
    }

    public void reset() {
        this.state = 0;
        this.ddsPressed = false;
        this.handsOnRing = false;
        this.fingersOnTouchpad = false;
        this.lastClickTime = this.getCurrentTime();
        this.lastSubticks = 999999;
        this.hddsLockedForListEnd = false;
    }

    public float calculateSubticksProgress(int n, int n2, boolean bl) {
        long l = this.getCurrentTime();
        boolean bl2 = this.isLastClickTimeoutRunning(l);
        if (!this.handsOnRing || this.ddsPressed || bl2) {
            this.lastSubticks = n2;
            this.state = 0;
            this.lc.log(10000000, "ScrollSubticksFilter#calculateSubticksProgress: ignore subticks. HandsOnRing: %1, DDS Pressed: %2, click delay running: %3", this.handsOnRing, this.ddsPressed, bl2);
            return 0.0f;
        }
        this.initialize(n2, l);
        this.mainTickSum += bl ? n : -n;
        this.lastSubticks = n2;
        if (this.state == 1) {
            return this.handleStableState(n != 0, n2, l);
        }
        if (this.state == 2) {
            return this.handleMoveState(n2);
        }
        this.lc.log(10000, "ScrollSubticksFilter#calculateSubticksProgress: unknown state %1", (long)this.state);
        return 0.0f;
    }

    private void initialize(int n, long l) {
        if (this.state != 0) {
            return;
        }
        this.stableOriginPosition = this.calculateInitialStableOriginPosition(n);
        this.thresholdChangeStartTime = l;
        this.mainTickSum = 0;
        this.originSnapIn = false;
        this.state = 1;
    }

    private int calculateInitialStableOriginPosition(int n) {
        if (this.lastSubticks != 999999) {
            return this.lastSubticks;
        }
        return n;
    }

    private float handleStableState(boolean bl, int n, long l) {
        float f2 = this.getCurrentStartThreshold(l);
        float f3 = f2 * 100.0f;
        if (!bl && (float)Math.abs(n - this.stableOriginPosition) < f3) {
            this.lc.log(10000000, "ScrollSubticksFilter#handleStableState: ignore subticks, because subtickCount (%1) is below start threshhold (%2). Stable origin: %3", (double)n, (double)f3, (double)this.stableOriginPosition);
            return 0.0f;
        }
        this.state = 2;
        return this.handleMoveState(n);
    }

    private float handleMoveState(int n) {
        int n2 = this.getSnapInRange();
        if (Math.abs(n) < n2) {
            if (this.hddsLockedForListEnd) {
                this.hddsLockedForListEnd = false;
                this.lc.log(10000000, "ScrollSubticksFilter#handleMoveState: unlock hDDS, because focus reached snap-in area");
            }
            this.originSnapIn = true;
            return 0.0f;
        }
        if (this.hasSkippedNextMainTick(n)) {
            this.originSnapIn = true;
        }
        if (this.hddsLockedForListEnd) {
            this.lc.log(10000000, "ScrollSubticksFilter#handleMoveState: ignore subticks, because hDDS is locked. (subticks from event: %1)", (long)n);
            return 0.0f;
        }
        int n3 = this.getNearestZeroOffset(n);
        int n4 = this.getOppositeZeroPos(n);
        int n5 = n - n3;
        int n6 = n5 > 0 ? 1 : -1;
        int n7 = Math.abs(100 * n6 - n3 + n4);
        float f2 = (float)n5 / (float)n7;
        f2 = Math.min(f2, 1.0f);
        f2 = Math.max(f2, -1.0f);
        return f2;
    }

    private boolean hasSkippedNextMainTick(int n) {
        if (this.mainTickSum > 1 || this.mainTickSum < -1) {
            return true;
        }
        if (this.mainTickSum == 1) {
            return n > 0;
        }
        if (this.mainTickSum == -1) {
            return n < 0;
        }
        return false;
    }

    private int getNearestZeroOffset(int n) {
        if (this.isNearOriginWithoutSnapIn()) {
            return this.stableOriginPosition;
        }
        int n2 = n > 0 ? 1 : -1;
        return 15 * n2;
    }

    private int getOppositeZeroPos(int n) {
        if (this.isNearOriginWithoutSnapIn()) {
            n -= this.stableOriginPosition;
        }
        if (this.isOppositeOriginWithoutSnapIn(n)) {
            return this.stableOriginPosition;
        }
        int n2 = n > 0 ? 1 : -1;
        return 15 * n2 * -1;
    }

    private int getSnapInRange() {
        if (this.isNearOriginWithoutSnapIn()) {
            return 0;
        }
        return 15;
    }

    private boolean isNearOriginWithoutSnapIn() {
        return this.mainTickSum == 0 && !this.originSnapIn;
    }

    private boolean isOppositeOriginWithoutSnapIn(int n) {
        if (this.originSnapIn) {
            return false;
        }
        if (this.mainTickSum == 1 && n < 0) {
            return true;
        }
        return this.mainTickSum == -1 && n > 0;
    }

    float getCurrentStartThreshold(long l) {
        if (this.fingersOnTouchpad) {
            this.thresholdChangeStartTime = l;
            return 0.15f;
        }
        int n = (int)(l - this.thresholdChangeStartTime);
        float f2 = (float)n / 500.0f;
        f2 = Math.min(1.0f, f2);
        return 0.15f - 0.135f * f2;
    }

    private boolean isLastClickTimeoutRunning(long l) {
        long l2 = l - this.lastClickTime;
        return l2 < 250L;
    }

    protected long getCurrentTime() {
        return AbstractWidget.framework.getMonotonicTime();
    }

    public boolean isDdsPressed() {
        return this.ddsPressed;
    }

    public void setDdsPressed(boolean bl) {
        this.ddsPressed = bl;
        if (!bl) {
            this.lastClickTime = this.getCurrentTime();
        }
    }

    public boolean isFingersOnTouchpad() {
        return this.fingersOnTouchpad;
    }

    public void setFingersOnTouchpad(boolean bl) {
        this.fingersOnTouchpad = bl;
    }

    public boolean isHandsOnRing() {
        return this.handsOnRing;
    }

    public void setHandsOnRing(boolean bl) {
        this.handsOnRing = bl;
        if (!bl) {
            this.state = 0;
        }
    }

    public int getStableOriginPosition() {
        return this.stableOriginPosition;
    }

    public int getState() {
        return this.state;
    }

    public boolean isHddsLockedForListEnd() {
        return this.hddsLockedForListEnd;
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.setFingersOnTouchpad(true);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        if (touchEvent.getFingerCount() == 0) {
            this.setFingersOnTouchpad(false);
        }
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
        if (this.isHandsOnRingEvent(touchEvent)) {
            this.setHandsOnRing(false);
        }
    }

    public void touchPadApproached(TouchEvent touchEvent) {
        if (this.isHandsOnRingEvent(touchEvent)) {
            this.setHandsOnRing(true);
        }
    }

    public boolean isHandsOnRingEvent(TouchEvent touchEvent) {
        return touchEvent.getCode() == 85;
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 17) {
            this.setDdsPressed(true);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 17) {
            this.setDdsPressed(false);
        }
    }

    public void endOfListReached() {
        this.hddsLockedForListEnd = true;
    }
}

