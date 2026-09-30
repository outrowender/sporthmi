/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

import de.esolutions.fw.comm.core.IEnum;

public interface eBluetoothAccessMode
extends IEnum {
    public static final int AM_NOT_ACCESSIBLE = 0;
    public static final int AM_DISCOVERABLE_ONLY = 1;
    public static final int AM_CONNECTABLE_ONLY = 2;
    public static final int AM_GENERAL_ACCESSIBLE = 3;
    public static final int AM_AUTO_DISCOVERABLE_FULL_ACCESSIBLE = 4;
    public static final int AM_LIMITED_DISCOVERABLE = 5;
    public static final int AM_NOT_AVAILABLE = 255;
}

