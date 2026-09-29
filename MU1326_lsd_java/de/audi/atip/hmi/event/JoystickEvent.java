/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;

public class JoystickEvent
extends KeyEvent {
    public static final int JOYSTICK_IDLE;
    public static final int JOYSTICK_NW;
    public static final int JOYSTICK_N;
    public static final int JOYSTICK_NE;
    public static final int JOYSTICK_E;
    public static final int JOYSTICK_SE;
    public static final int JOYSTICK_S;
    public static final int JOYSTICK_SW;
    public static final int JOYSTICK_W;
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

    @Override
    public String toString() {
        return new StringBuffer().append("JoystickEvent: keyCode = ").append(this.keycode2Text()).append('(').append(this.getKeyCode()).append("), direction = ").append(this.direction2Text()).append('(').append(this.direction).append(')').toString();
    }
}

