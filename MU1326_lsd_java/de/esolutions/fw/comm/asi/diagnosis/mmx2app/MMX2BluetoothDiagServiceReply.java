/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2BluetoothDiagServiceReply {
    public static final String IPL_COMM_UUID = "a2aba5f9-4aae-436e-802a-26bbd44eec8e";
    public static final String IPL_COMM_INTERFACE_KEY = "53cec102-0ba4-570c-9109-ebc8f698e1cf";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestBluetoothState(long var1) throws MethodException;

    public void requestBluetoothMAC(long var1) throws MethodException;

    public void requestBluetoothDevices(long var1) throws MethodException;

    public void requestLastPairedBtDevices(long var1, short var3) throws MethodException;

    public void requestPairedBtDevices(long var1) throws MethodException;

    public void requestConnectedBtDevices(long var1) throws MethodException;

    public void requestConnectedBtDevice(long var1, short var3) throws MethodException;

    public void requestAutoConnectBtHandset(long var1, int var3) throws MethodException;

    public void requestBtDeleteLinkKeys(long var1, int var3, int var4) throws MethodException;

    public void requestBtDeviceSearch(long var1, short var3, short var4) throws MethodException;

    public void requestConnectionToLastBtDevice(long var1, short var3, short var4) throws MethodException;
}

