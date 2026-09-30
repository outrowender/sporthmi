/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;

public class WheelButtonEvent
extends KeyEvent {
    public static final int RIGHTTURN = 0;
    public static final int LEFTTURN = 1;
    public static final int TURN_UP = 1;
    public static final int TURN_DOWN = 0;
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
        return "WheelButtonEvent: keyCode = " + this.keycode2Text() + '(' + this.getKeyCode() + "), direction = " + this.direction2Text() + '(' + this.direction + "), count = " + this.clickCount + ", subClickCount = " + this.subClickCount;
    }

    public String toString() {
        return "WheelButtonEvent";
    }
}

