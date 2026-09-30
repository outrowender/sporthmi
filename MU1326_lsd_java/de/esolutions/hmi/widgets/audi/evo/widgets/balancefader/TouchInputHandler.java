/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.balancefader;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.tghu.hmi.evo.IBalFadeTouchpadConfig;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.BalanceFaderController;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.AxisLockWithTimer;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.ValuePair;

public class TouchInputHandler
implements IWidgetLogChannel,
IBalFadeTouchpadConfig {
    private static final int MIN_MOVEMENT_FOR_AIT = 16;
    private static final long LOCK_DURATION = 1000L;
    private static final long TIME_BETWEEN_LOCKS = 2000L;
    private static final ValuePair WIDGET_ON_SCREEN_SIZE_CM = new ValuePair(4.0f, 4.0f);
    private static final String TOUCHPAD_TYPE_TOUCHWHEEL = "TOUCHWHEEL";
    private static final String TOUCHPAD_TYPE_AIT = "AIT";
    private String touchPadType = "TOUCHWHEEL";
    private BalanceFaderController controller;
    private AxisLockWithTimer xAxis;
    private AxisLockWithTimer yAxis;
    private ValuePair previousEventPosition = new ValuePair();
    private ValuePair oldCursorPosition = new ValuePair(-1.0f, -1.0f);
    private ValuePair touchPadSizeInCm;
    private ValuePair touchPadSensitivity;
    private ValuePair normalizedTouchPadSensitivity;
    private ValuePair initialPosition = new ValuePair();
    private ValuePair touchPadSize;
    private boolean deadDistanceAbandoned;

    public TouchInputHandler(BalanceFaderController balanceFaderController, IFrameworkAccess iFrameworkAccess) {
        if (balanceFaderController != null && balanceFaderController.isConnected()) {
            this.controller = balanceFaderController;
            this.evaluateTouchPadType();
            this.initializeTouchPadConstants();
            this.updateNormalizedTouchPadSensitivity();
            this.xAxis = new AxisLockWithTimer(1000L, 2000L, 0.5f, iFrameworkAccess);
            this.yAxis = new AxisLockWithTimer(1000L, 2000L, 0.5f, iFrameworkAccess);
        }
    }

    private void evaluateTouchPadType() {
        this.touchPadType = 6 == this.controller.getTerminalImpl().getKbdService().getCurrentKeyboardType() ? TOUCHPAD_TYPE_AIT : TOUCHPAD_TYPE_TOUCHWHEEL;
        logBalanceFader.log(10000000, "TouchInputHandler#evaluateTouchPadType touchPadType = %1", (Object)this.touchPadType);
    }

    private void initializeTouchPadConstants() {
        if (this.isTouchPadTypeAIT()) {
            ValuePair valuePair = new ValuePair(34.0f, 48.0f);
            ValuePair valuePair2 = new ValuePair(910.0f, 722.0f);
            this.touchPadSize = valuePair2.subtract(valuePair);
            this.touchPadSizeInCm = new ValuePair(11.5f, 8.5f);
            this.touchPadSensitivity = new ValuePair(0.5f, 0.5f);
        } else {
            ValuePair valuePair = new ValuePair(59.0f, 59.0f);
            ValuePair valuePair3 = new ValuePair(955.0f, 955.0f);
            this.touchPadSize = valuePair3.subtract(valuePair);
            this.touchPadSizeInCm = new ValuePair(4.8f, 4.8f);
            this.touchPadSensitivity = new ValuePair(0.5f, 0.5f);
        }
    }

    private void updateNormalizedTouchPadSensitivity() {
        this.normalizedTouchPadSensitivity = this.touchPadSizeInCm.multiplyWith(this.touchPadSensitivity);
        this.normalizedTouchPadSensitivity = this.normalizedTouchPadSensitivity.divideBy(WIDGET_ON_SCREEN_SIZE_CM);
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.oldCursorPosition.setXY(-1.0f, -1.0f);
        this.previousEventPosition.setXY(touchEvent.getX(), touchEvent.getY());
        if (this.isTouchPadTypeAIT()) {
            this.initialPosition.setXY(touchEvent.getX(), touchEvent.getY());
            this.deadDistanceAbandoned = false;
        }
    }

    private boolean isTouchPadTypeAIT() {
        return this.touchPadType.equals(TOUCHPAD_TYPE_AIT);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        this.oldCursorPosition.setXY(-1.0f, -1.0f);
        this.xAxis.reset();
        this.yAxis.reset();
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        ValuePair valuePair = new ValuePair(touchEvent.getX(), touchEvent.getY());
        if (this.isTouchPadTypeAIT() && !this.deadDistanceAbandoned && this.isInDeadDistance(valuePair)) {
            return;
        }
        ValuePair valuePair2 = valuePair.subtract(this.previousEventPosition);
        this.previousEventPosition.setXY(valuePair);
        ValuePair valuePair3 = valuePair2.divideBy(this.touchPadSize);
        valuePair3 = valuePair3.multiplyWith(this.normalizedTouchPadSensitivity);
        ValuePair valuePair4 = this.controller.getCrosshairPosition().add(valuePair3);
        this.xAxis.tryToLock(valuePair4.getX(), this.oldCursorPosition.getX());
        this.yAxis.tryToLock(valuePair4.getY(), this.oldCursorPosition.getY());
        if (this.xAxis.isLocked()) {
            valuePair4.setX(0.5f);
        }
        if (this.yAxis.isLocked()) {
            valuePair4.setY(0.5f);
        }
        this.oldCursorPosition.setXY(valuePair4);
        this.updateCrosshairMode();
        this.controller.setCrosshairPosition(valuePair4);
    }

    private boolean isInDeadDistance(ValuePair valuePair) {
        float f2 = Math.abs(this.initialPosition.getX() - valuePair.getX());
        float f3 = Math.abs(this.initialPosition.getY() - valuePair.getY());
        if (f2 < 16.0f && f3 < 16.0f) {
            return true;
        }
        this.deadDistanceAbandoned = true;
        return false;
    }

    private void updateCrosshairMode() {
        int n = 0;
        if (this.xAxis.isLocked() && !this.yAxis.isLocked()) {
            n = 2;
        }
        if (this.yAxis.isLocked() && !this.xAxis.isLocked()) {
            n = 1;
        }
        this.controller.setCrosshairMode(n);
    }

    public String bftp_getConfigs() {
        return this.configToString();
    }

    public String bftp_getKbType() {
        return this.touchPadType;
    }

    public void bftp_setTouchSensitivity(float f2, float f3) {
        this.touchPadSensitivity.setXY(f2, f3);
        this.updateNormalizedTouchPadSensitivity();
    }

    public void bftp_setLockBreakDist(float f2, float f3, float f4) {
    }

    private String configToString() {
        Buffer buffer = new Buffer(200);
        buffer.append("BalanceFaderController: touchPadType = ").append(this.touchPadType);
        buffer.append(", touchPadSensitivity = ").append(this.touchPadSensitivity);
        return buffer.toString();
    }

    public void disconnect() {
        this.previousEventPosition.setXY(0.0f, 0.0f);
        this.oldCursorPosition.setXY(-1.0f, -1.0f);
    }
}

