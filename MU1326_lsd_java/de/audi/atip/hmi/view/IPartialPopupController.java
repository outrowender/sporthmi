/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.TouchPadEventListener;

public interface IPartialPopupController
extends TouchPadEventListener,
KeyListener {
    public static final int ON_HK_APP_CHANGE_DONT_CONSUME = 0;
    public static final int ON_HK_APP_CHANGE_DONT_CONSUME_BUT_HIDE = 1;
    public static final int ON_HKRETURN_DONT_CONSUME = 0;
    public static final int ON_HKRETURN_CONSUME_AND_HIDE = 1;
    public static final int ON_HKRETURN_CONSUME_AND_DO_NOTHING = 2;
    public static final int ON_HKRETURN_CONSUME_AND_FIRE_EVENT = 3;
    public static final int ON_HKRETURN_DONT_CONSUME_AND_PROPAGATE = 4;
    public static final int ON_HKRETURN_PROPAGATE_AND_CONSUME = 5;
    public static final int ON_HKRETURN_DONT_CONSUME_BUT_HIDE = 6;
    public static final int ON_HKRETURN_PROPAGATE_AND_CONSUME_AND_HIDE = 7;
    public static final int ON_HKRETURN_CONSUME_WITHOUT_CHECKING_AND_HIDE = 8;
    public static final int ON_DDSPRESS_DONT_CONSUME = 0;
    public static final int ON_DDSPRESS_CONSUME_AND_HIDE = 1;
    public static final int ON_DDSPRESS_CONSUME_AND_DO_NOTHING = 2;
    public static final int ON_DDSPRESS_CONSUME_AND_FIRE_EVENT = 3;
    public static final int ON_DDSPRESS_DONT_CONSUME_AND_PROPAGATE = 4;
    public static final int ON_DDSPRESS_PROPAGATE_AND_CONSUME = 5;
    public static final int ON_DDSPRESS_PROPAGATE_AND_CONSUME_AND_HIDE = 6;
    public static final int ON_DDSPRESS_CONSUME_AND_FIRE_EVENT_AND_HIDE = 7;
    public static final int ON_DDSPRESS_DONT_CONSUME_BUT_HIDE = 8;
    public static final int ON_DDSPRESS_CONSUME_WITHOUT_CHECKING_AND_HIDE = 9;
    public static final int ON_KEYTURNED_DONT_CONSUME = 0;
    public static final int ON_KEYTURNED_CONSUME_AND_HIDE = 1;
    public static final int ON_KEYTURNED_CONSUME_AND_DO_NOTHING = 2;
    public static final int ON_KEYTURNED_DONT_CONSUME_BUT_HIDE = 3;
    public static final int ON_KEYTURNED_DONT_CONSUME_AND_PROPAGATE = 4;
    public static final int ON_KEYTURNED_PROPAGATE_AND_CONSUME = 5;
    public static final int ON_SOFTKEY_PRESSED_DONT_CONSUME = 0;
    public static final int ON_SOFTKEY_PRESSED_DONT_CONSUME_AND_PROPAGATE = 1;
    public static final int ON_SOFTKEY_PRESSED_CONSUME_AND_HIDE = 2;
    public static final int ON_SOFTKEY_PRESSED_DONT_CONSUME_BUT_HIDE = 3;
    public static final int ON_SOFTKEY_PRESSED_CONSUME_AND_DO_NOTHING = 4;
    public static final int ON_JOYSTICK_DONT_CONSUME = 0;
    public static final int ON_JOYSTICK_CONSUME_AND_HIDE = 1;
    public static final int ON_JOYSTICK_CONSUME_AND_DO_NOTHING = 2;
    public static final int ON_JOYSTICK_DONT_CONSUME_BUT_HIDE = 3;
    public static final int ON_JOYSTICK_DONT_CONSUME_AND_PROPAGATE = 4;
    public static final int ON_JOYSTICK_PROPAGATE_AND_CONSUME = 5;
    public static final int ON_TOUCHPAD_DONT_CONSUME = 0;
    public static final int ON_TOUCHPAD_DONT_CONSUME_AND_PROPAGATE = 1;
    public static final int ON_TOUCHPAD_CONSUME_AND_HIDE = 2;
    public static final int ON_TOUCHPAD_DONT_CONSUME_BUT_HIDE = 3;
    public static final int ON_TOUCHPAD_CONSUME_AND_DO_NOTHING = 4;
    public static final int ON_GENERIC_DONT_CONSUME = 0;
    public static final int ON_GENERIC_CONSUME_AND_HIDE = 1;
    public static final int ON_GENERIC_CONSUME_AND_DO_NOTHING = 2;
    public static final int ON_GENERIC_CONSUME_AND_FIRE_EVENT = 3;
    public static final int ON_GENERIC_DONT_CONSUME_AND_PROPAGATE = 4;
    public static final int ON_GENERIC_PROPAGATE_AND_CONSUME = 5;
    public static final int ON_GENERIC_DONT_CONSUME_BUT_HIDE = 6;
    public static final int ON_GENERIC_PROPAGATE_AND_CONSUME_AND_HIDE = 7;

    public int getID();

    public int getPriority();
}

