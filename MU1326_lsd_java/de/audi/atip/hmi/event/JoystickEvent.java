/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;

public class JoystickEvent
extends KeyEvent {
    public static final int JOYSTICK_IDLE = 0;
    public static final int JOYSTICK_NW = 1;
    public static final int JOYSTICK_N = 2;
    public static final int JOYSTICK_NE = 3;
    public static final int JOYSTICK_E = 4;
    public static final int JOYSTICK_SE = 5;
    public static final int JOYSTICK_S = 6;
    public static final int JOYSTICK_SW = 7;
    public static final int JOYSTICK_W = 8;
    private int direction;

    public JoystickEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4) {
        super(aTIPEventListener, n, l, n2, n4);
        this.direction = n3;
        this.setSdsAction(3);
    }

    public int getDirection() {
        return this.direction;
    }

    private String direction2Text() {
        switch (this.direction) {
            case 0: {
                return "IDLE";
            }
            case 1: {
                return "North West";
            }
            case 2: {
                return "North";
            }
            case 3: {
                return "North East";
            }
            case 4: {
                return "East";
            }
            case 5: {
                return "South East";
            }
            case 6: {
                return "South";
            }
            case 7: {
                return "South West";
            }
            case 8: {
                return "West";
            }
        }
        return "<UNKNOWN>";
    }

    public String toString() {
        return "JoystickEvent: keyCode = " + this.keycode2Text() + '(' + this.getKeyCode() + "), direction = " + this.direction2Text() + '(' + this.direction + ')';
    }
}

