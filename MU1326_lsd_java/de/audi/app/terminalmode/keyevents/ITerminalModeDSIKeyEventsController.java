/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.keyevents.KeyState;
import de.audi.app.terminalmode.keyevents.TouchEvent;

public interface ITerminalModeDSIKeyEventsController {
    public static final int TOUCHINPUT_UNKNOWN = 0;
    public static final int TOUCHINPUT_PAD = 1;
    public static final int TOUCHINPUT_SCREEN = 2;
    public static final int GESTURE_UNKNOWN = 0;
    public static final int GESTURE_ROTATE = 1;
    public static final int GESTURE_DRAG = 2;

    public void updateKey(Key var1, KeyState var2);

    public void updateTouchEvents(TouchEvent[] var1);

    public void updateRotary(int var1);

    public void updateCharacterEvent(String[] var1, int[] var2);
}

