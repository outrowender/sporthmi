/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.keyevents.KeyState;
import de.audi.app.terminalmode.keyevents.TouchEvent;

public interface ITerminalModeDSIKeyEventsController {
    public static final int TOUCHINPUT_UNKNOWN;
    public static final int TOUCHINPUT_PAD;
    public static final int TOUCHINPUT_SCREEN;
    public static final int GESTURE_UNKNOWN;
    public static final int GESTURE_ROTATE;
    public static final int GESTURE_DRAG;

    default public void updateKey(Key key, KeyState keyState) {
    }

    default public void updateTouchEvents(TouchEvent[] touchEventArray) {
    }

    default public void updateRotary(int n) {
    }

    default public void updateCharacterEvent(String[] stringArray, int[] nArray) {
    }
}

