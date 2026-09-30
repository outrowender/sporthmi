/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.core.IEnum;

public interface BluetoothState
extends IEnum {
    public static final int INIT = 0;
    public static final int OFF = 1;
    public static final int ON = 2;
    public static final int CODED_OUT = 3;
    public static final int FAILURE = 4;
}

