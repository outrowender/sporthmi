/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.core.IEnum;

public interface SpiBtState
extends IEnum {
    public static final int BT_UNKNOWN = 0;
    public static final int BT_ACTIVE = 1;
    public static final int BT_NOT_READY = 2;
    public static final int BT_NOT_ACTIVE = 3;
    public static final int BT_NOT_AVAILABLE_CODING = 4;
    public static final int BT_NOT_AVAILABLE_ADAPTATION = 5;
    public static final int BT_NOT_AVAILABLE_FEC = 6;
    public static final int BT_NOT_AVAILABLE_ERROR = 7;
}

