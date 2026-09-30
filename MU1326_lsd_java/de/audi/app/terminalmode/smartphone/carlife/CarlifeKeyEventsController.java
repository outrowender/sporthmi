/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.keyevents.KeyState;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.TouchEvent;

public final class CarlifeKeyEventsController
implements ITerminalModeDSIKeyEventsController {
    private static final String LOGCLASS = "CarlifeKeyEventsController";
    private volatile Key lastJoystickkey;
    private final DSICarlife dsi;
    private final LogChannel lc;

    public CarlifeKeyEventsController(DSICarlife dSICarlife, LogChannel logChannel) {
        this.dsi = dSICarlife;
        this.lc = logChannel;
    }

    public void updateKey(Key key, KeyState keyState) {
        if (TerminalModeUtils.isJoystickMiddleposition(key)) {
            if (null == this.lastJoystickkey) {
                return;
            }
            this.lc.log(1000000, "[%1.updateKey] joystick middle position, release button %2", (Object)LOGCLASS, (Object)this.lastJoystickkey);
            this.dsi.postButtonEvent(this.getKeyId(this.lastJoystickkey), 1);
            this.lastJoystickkey = null;
            return;
        }
        int n = this.getKeyId(key);
        if (0 == n) {
            this.lc.log(1000000, "[%1.updateKey] unknown key id", (Object)LOGCLASS);
            return;
        }
        this.lc.log(1000000, "[%1.updateKey] %2", (Object)LOGCLASS, (long)n);
        if (TerminalModeUtils.isJoystick(key)) {
            this.lastJoystickkey = key;
        }
        this.dsi.postButtonEvent(n, this.getKeyState(keyState));
    }

    public void updateTouchEvents(de.audi.app.terminalmode.keyevents.TouchEvent[] touchEventArray) {
        this.lc.log(1000000, "[%1.updateTouchEvents] %2 %3", (Object)LOGCLASS, (Object)Integer.toString(touchEventArray.length), (Object)touchEventArray[0]);
        TouchEvent[] touchEventArray2 = new TouchEvent[touchEventArray.length];
        int n = 0;
        for (int i2 = 0; i2 < touchEventArray.length; ++i2) {
            de.audi.app.terminalmode.keyevents.TouchEvent touchEvent = touchEventArray[i2];
            touchEventArray2[i2] = new TouchEvent(touchEvent.getCurrentX(), touchEvent.getCurrentY(), i2);
        }
        switch (touchEventArray[0].getTouchState()) {
            case 0: {
                n = 1;
                break;
            }
            case 1: {
                n = 3;
                break;
            }
            default: {
                n = 1 == touchEventArray[0].getGesture() ? 4 : 5;
            }
        }
        this.dsi.postTouchEvent(touchEventArray[0].isTouchScreen() ? 1 : 0, touchEventArray2, n);
    }

    public void updateRotary(int n) {
        this.dsi.postRotaryEvent(n);
    }

    private int getKeyState(KeyState keyState) {
        if (keyState.is(KeyState.PRESSED)) {
            return 0;
        }
        if (keyState.is(KeyState.RELEASED)) {
            return 1;
        }
        this.lc.log(1000000, "[%1.getKeyState] Unsupported key state %2", (Object)LOGCLASS, (Object)keyState);
        return -1;
    }

    private int getKeyId(Key key) {
        if (key.is(Key.BACK)) {
            return 2;
        }
        if (key.is(Key.DDS_SELECT)) {
            return 1;
        }
        if (key.isOneOf(Key.JS_NORTH, Key.SOFTKEY_SOUTHWEST)) {
            return 5;
        }
        if (key.isOneOf(Key.JS_EAST, Key.SOFTKEY_NORTHEAST)) {
            return 4;
        }
        if (key.isOneOf(Key.JS_SOUTH, Key.SOFTKEY_SOUTHEAST)) {
            return 6;
        }
        if (key.isOneOf(Key.JS_WEST, Key.SOFTKEY_NORTHWEST)) {
            return 3;
        }
        if (key.is(Key.SOFTKEY_EAST)) {
            return 11;
        }
        if (key.is(Key.SOFTKEY_WEST)) {
            return 12;
        }
        this.lc.log(1000000, "[%1.getKeyId] Unsupport %2", (Object)LOGCLASS, (Object)key);
        return 0;
    }

    public void updateCharacterEvent(String[] stringArray, int[] nArray) {
        this.lc.log(1000000, "[%1.updateCharacterEvent]", (Object)LOGCLASS);
        this.dsi.postCharacterEvent(stringArray.length, stringArray);
    }
}

