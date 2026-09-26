/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;

public class WheelButtonEvent
extends KeyEvent {
    public static final int RIGHTTURN;
    public static final int LEFTTURN;
    public static final int TURN_UP;
    public static final int TURN_DOWN;
    private int direction;
    private int clickCount;
    private int subClickCount;

    public WheelButtonEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, int n5, int n6) {
        super(aTIPEventListener, n, l, n2, n6);
        this.direction = n3;
        this.clickCount = n4;
        this.subClickCount = n5;
    }

    public WheelButtonEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, int n5) {
        this(aTIPEventListener, n, l, n2, n3, n4, 0, n5);
    }

    public int getDirection() {
        return this.direction;
    }

    public int getClickCount() {
        return this.clickCount;
    }

    public int getSubClickCount() {
        return this.subClickCount;
    }

    private String direction2Text() {
        switch (this.direction) {
            case 0: {
                return "RIGHTTURN";
            }
            case 1: {
                return "LEFTTURN";
            }
        }
        return "<UNKNOWN>";
    }

    public boolean isVerticalDirection() {
        return this.getKeyCode() == 20;
    }

    public String toStringWithDetails() {
        return new StringBuffer().append("WheelButtonEvent: keyCode = ").append(this.keycode2Text()).append('(').append(this.getKeyCode()).append("), direction = ").append(this.direction2Text()).append('(').append(this.direction).append("), count = ").append(this.clickCount).append(", subClickCount = ").append(this.subClickCount).toString();
    }

    @Override
    public String toString() {
        return "WheelButtonEvent";
    }
}

