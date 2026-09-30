/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

import de.esolutions.fw.comm.core.IEnum;

public interface eSimLockstate
extends IEnum {
    public static final int SIM_LOCKSTATE_NOT_KNOWN = 0;
    public static final int SIM_LOCKSTATE_UNLOCK_IN_PROGRESS = 1;
    public static final int SIM_LOCKSTATE_NO_LOCK = 2;
    public static final int SIM_LOCKSTATE_PIN_REQUIRED = 3;
    public static final int SIM_LOCKSTATE_PIN2_REQUIRED = 4;
    public static final int SIM_LOCKSTATE_PUK_REQUIRED = 5;
    public static final int SIM_LOCKSTATE_PUK2_REQUIRED = 6;
    public static final int SIM_LOCKSTATE_PUK_BLOCKED = 7;
    public static final int SIM_LOCKSTATE_PUK2_BLOCKED = 8;
    public static final int SIM_LOCKSTATE_NO_FUNCTION = 11;
}

