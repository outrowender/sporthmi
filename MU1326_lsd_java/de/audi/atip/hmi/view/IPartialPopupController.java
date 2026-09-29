/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.TouchPadEventListener;

public interface IPartialPopupController
extends TouchPadEventListener,
KeyListener {
    public static final int ON_HK_APP_CHANGE_DONT_CONSUME;
    public static final int ON_HK_APP_CHANGE_DONT_CONSUME_BUT_HIDE;
    public static final int ON_HKRETURN_DONT_CONSUME;
    public static final int ON_HKRETURN_CONSUME_AND_HIDE;
    public static final int ON_HKRETURN_CONSUME_AND_DO_NOTHING;
    public static final int ON_HKRETURN_CONSUME_AND_FIRE_EVENT;
    public static final int ON_HKRETURN_DONT_CONSUME_AND_PROPAGATE;
    public static final int ON_HKRETURN_PROPAGATE_AND_CONSUME;
    public static final int ON_HKRETURN_DONT_CONSUME_BUT_HIDE;
    public static final int ON_HKRETURN_PROPAGATE_AND_CONSUME_AND_HIDE;
    public static final int ON_HKRETURN_CONSUME_WITHOUT_CHECKING_AND_HIDE;
    public static final int ON_DDSPRESS_DONT_CONSUME;
    public static final int ON_DDSPRESS_CONSUME_AND_HIDE;
    public static final int ON_DDSPRESS_CONSUME_AND_DO_NOTHING;
    public static final int ON_DDSPRESS_CONSUME_AND_FIRE_EVENT;
    public static final int ON_DDSPRESS_DONT_CONSUME_AND_PROPAGATE;
    public static final int ON_DDSPRESS_PROPAGATE_AND_CONSUME;
    public static final int ON_DDSPRESS_PROPAGATE_AND_CONSUME_AND_HIDE;
    public static final int ON_DDSPRESS_CONSUME_AND_FIRE_EVENT_AND_HIDE;
    public static final int ON_DDSPRESS_DONT_CONSUME_BUT_HIDE;
    public static final int ON_DDSPRESS_CONSUME_WITHOUT_CHECKING_AND_HIDE;
    public static final int ON_KEYTURNED_DONT_CONSUME;
    public static final int ON_KEYTURNED_CONSUME_AND_HIDE;
    public static final int ON_KEYTURNED_CONSUME_AND_DO_NOTHING;
    public static final int ON_KEYTURNED_DONT_CONSUME_BUT_HIDE;
    public static final int ON_KEYTURNED_DONT_CONSUME_AND_PROPAGATE;
    public static final int ON_KEYTURNED_PROPAGATE_AND_CONSUME;
    public static final int ON_SOFTKEY_PRESSED_DONT_CONSUME;
    public static final int ON_SOFTKEY_PRESSED_DONT_CONSUME_AND_PROPAGATE;
    public static final int ON_SOFTKEY_PRESSED_CONSUME_AND_HIDE;
    public static final int ON_SOFTKEY_PRESSED_DONT_CONSUME_BUT_HIDE;
    public static final int ON_SOFTKEY_PRESSED_CONSUME_AND_DO_NOTHING;
    public static final int ON_JOYSTICK_DONT_CONSUME;
    public static final int ON_JOYSTICK_CONSUME_AND_HIDE;
    public static final int ON_JOYSTICK_CONSUME_AND_DO_NOTHING;
    public static final int ON_JOYSTICK_DONT_CONSUME_BUT_HIDE;
    public static final int ON_JOYSTICK_DONT_CONSUME_AND_PROPAGATE;
    public static final int ON_JOYSTICK_PROPAGATE_AND_CONSUME;
    public static final int ON_TOUCHPAD_DONT_CONSUME;
    public static final int ON_TOUCHPAD_DONT_CONSUME_AND_PROPAGATE;
    public static final int ON_TOUCHPAD_CONSUME_AND_HIDE;
    public static final int ON_TOUCHPAD_DONT_CONSUME_BUT_HIDE;
    public static final int ON_TOUCHPAD_CONSUME_AND_DO_NOTHING;
    public static final int ON_GENERIC_DONT_CONSUME;
    public static final int ON_GENERIC_CONSUME_AND_HIDE;
    public static final int ON_GENERIC_CONSUME_AND_DO_NOTHING;
    public static final int ON_GENERIC_CONSUME_AND_FIRE_EVENT;
    public static final int ON_GENERIC_DONT_CONSUME_AND_PROPAGATE;
    public static final int ON_GENERIC_PROPAGATE_AND_CONSUME;
    public static final int ON_GENERIC_DONT_CONSUME_BUT_HIDE;
    public static final int ON_GENERIC_PROPAGATE_AND_CONSUME_AND_HIDE;

    default public int getID() {
    }

    default public int getPriority() {
    }
}

