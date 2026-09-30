/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

public interface IVisibility {
    public static final int STATE_NOT_CODED = 0;
    public static final int STATE_INVISIBLE = 1;
    public static final int STATE_NORMAL = 2;
    public static final int STATE_HINT_ERROR = 3;
    public static final int STATE_HINT_CLAMP15 = 4;
    public static final int STATE_HINT_VTHR = 5;
    public static final int STATE_HINT_STANDSTILL = 6;
    public static final int STATE_HINT_ENGINE = 7;
    public static final int STATE_HINT_SYSTEM_OFF = 8;
    public static final int STATE_SPECIAL_ERROR = 9;
    public static final String[] TEXT_TO_STATE = new String[]{"STATE_NOT_CODED", "STATE_INVISIBLE", "STATE_NORMAL", "STATE_HINT_ERROR", "STATE_HINT_CLAMP15", "STATE_HINT_VTHR", "STATE_HINT_STANDSTILL", "STATE_HINT_ENGINE", "STATE_HINT_SYSTEM_OFF", "STATE_SPECIAL_ERROR"};
}

