/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

public class TouchEvent {
    public static final int TOUCH_STATE_PRESSED;
    public static final int TOUCH_STATE_RELEASED;
    public static final int TOUCH_STATE_MOVED;
    public static final int GESTURE_UNKNOWN;
    public static final int GESTURE_ROTATE;
    public static final int GESTURE_DRAG;
    private final int touchState;
    private final int startX;
    private final int startY;
    private final int currentX;
    private final int currentY;
    private final boolean touchScreen;
    private final int gesture;

    public TouchEvent(int n, int n2, int n3, int n4, boolean bl) {
        this.touchState = 2;
        this.startX = n;
        this.startY = n2;
        this.currentX = n3;
        this.currentY = n4;
        this.touchScreen = bl;
        this.gesture = 0;
    }

    public TouchEvent(boolean bl, int n, int n2, boolean bl2) {
        this.touchState = bl ? 0 : 1;
        this.startX = 0;
        this.startY = 0;
        this.currentX = n;
        this.currentY = n2;
        this.touchScreen = bl2;
        this.gesture = 0;
    }

    public int getTouchState() {
        return this.touchState;
    }

    public int getStartX() {
        return this.startX;
    }

    public int getStartY() {
        return this.startY;
    }

    public int getCurrentX() {
        return this.currentX;
    }

    public int getCurrentY() {
        return this.currentY;
    }

    public boolean isTouchScreen() {
        return this.touchScreen;
    }

    public int getGesture() {
        return this.gesture;
    }

    public String toString() {
        return new StringBuffer().append("TouchEvent [touchState=").append(this.touchState).append(", startX=").append(this.startX).append(", startY=").append(this.startY).append(", currentX=").append(this.currentX).append(", currentY=").append(this.currentY).append(", touchScreen=").append(this.touchScreen).append(", gesture=").append(this.gesture).append("]").toString();
    }
}

