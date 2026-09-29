/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

public interface IVisibility {
    public static final int STATE_NOT_CODED;
    public static final int STATE_INVISIBLE;
    public static final int STATE_NORMAL;
    public static final int STATE_HINT_ERROR;
    public static final int STATE_HINT_CLAMP15;
    public static final int STATE_HINT_VTHR;
    public static final int STATE_HINT_STANDSTILL;
    public static final int STATE_HINT_ENGINE;
    public static final int STATE_HINT_SYSTEM_OFF;
    public static final int STATE_SPECIAL_ERROR;
    public static final String[] TEXT_TO_STATE;

    static {
        TEXT_TO_STATE = new String[]{"STATE_NOT_CODED", "STATE_INVISIBLE", "STATE_NORMAL", "STATE_HINT_ERROR", "STATE_HINT_CLAMP15", "STATE_HINT_VTHR", "STATE_HINT_STANDSTILL", "STATE_HINT_ENGINE", "STATE_HINT_SYSTEM_OFF", "STATE_SPECIAL_ERROR"};
    }
}

