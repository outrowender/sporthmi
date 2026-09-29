/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class MoveEvent
extends ATIPEvent {
    public static final int TOUCH_SCREEN_EVENT_FIRST;
    public static final int TOUCH_SCREEN_MOVED;
    public static final int TOUCH_SCREEN_LAST;
    private long when;
    private int moveCode;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean repaintNeeded = false;

    public MoveEvent(ATIPEventListener aTIPEventListener, int n, int n2) {
        super(aTIPEventListener, n);
        this.moveCode = n2;
    }

    public MoveEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2) {
        super(aTIPEventListener, n);
        this.when = l;
        this.moveCode = n2;
    }

    public MoveEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, int n5, int n6) {
        super(aTIPEventListener, n);
        this.when = l;
        this.moveCode = n2;
        this.x1 = n3;
        this.y1 = n4;
        this.x2 = n5;
        this.y2 = n6;
    }

    public String toString() {
        return new StringBuffer().append("MoveEvent: [").append(this.getPosted()).append("] type = ").append(this.type2Text()).append(" (").append(this.getID()).append("), motionCode = ").append(this.motionCode2Text()).append(" (").append(this.moveCode).append(")").toString();
    }

    String motionCode2Text() {
        switch (this.moveCode) {
            case 10464: {
                return "TOUCH_SCREEN_MOVED";
            }
        }
        return null;
    }

    String type2Text() {
        switch (this.moveCode) {
            case 10464: {
                return "TOUCH_SCREEN_MOVED";
            }
        }
        return null;
    }

    public int startX() {
        return this.x1;
    }

    public int startY() {
        return this.y1;
    }

    public int endX() {
        return this.x2;
    }

    public int endY() {
        return this.y2;
    }

    public long getWhen() {
        return this.when;
    }

    public boolean isRepaintNeeded() {
        return this.repaintNeeded;
    }

    @Override
    public void consume() {
        super.consume();
        this.repaintNeeded = true;
    }

    public void consume(boolean bl) {
        super.consume();
        if (!this.repaintNeeded) {
            this.repaintNeeded = bl;
        }
    }
}

