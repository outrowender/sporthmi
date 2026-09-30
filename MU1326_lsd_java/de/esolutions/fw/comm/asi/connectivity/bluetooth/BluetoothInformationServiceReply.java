/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothDevice;
import de.esolutions.fw.comm.core.method.MethodException;

public interface BluetoothInformationServiceReply {
    public static final String IPL_COMM_UUID = "0d9b5586-8f24-4a93-8c53-d5cdaef1e111";
    public static final String IPL_COMM_INTERFACE_KEY = "4a7a95f3-5ac7-5d3b-b84d-85008994e7bf";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.10";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void updateBluetoothState(int var1) throws MethodException;

    public void updateBluetoothDevices(BluetoothDevice[] var1) throws MethodException;
}

