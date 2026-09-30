/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

import de.esolutions.fw.comm.core.IEnum;

public interface VoltageLevel
extends IEnum {
    public static final int ONOFF_VOLTAGE_NORMAL = 0;
    public static final int ONOFF_VOLTAGE_HIGH = 1;
    public static final int ONOFF_VOLTAGE_BELOW_9V = 2;
    public static final int ONOFF_VOLTAGE_BELOW_6V = 3;
}

