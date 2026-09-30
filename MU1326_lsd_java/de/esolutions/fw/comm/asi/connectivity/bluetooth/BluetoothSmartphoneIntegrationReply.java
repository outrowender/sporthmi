/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface BluetoothSmartphoneIntegrationReply {
    public static final String IPL_COMM_UUID = "e89f426d-df36-46c9-b54d-712527c0309a";
    public static final String IPL_COMM_INTERFACE_KEY = "fa60e661-b204-58e6-937d-484b8a10b0e4";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.2";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void responseLocalBluetoothAddress(String var1) throws MethodException;

    public void updateSpiBtState(int var1) throws MethodException;

    public void responsePrepareConnect(String var1, boolean var2, boolean var3) throws MethodException;

    public void reportSharedSecret(String var1, String var2) throws MethodException;

    public void reportParingSuccess(String var1, boolean var2) throws MethodException;

    public void reportConnectionEstablished(String var1, boolean var2) throws MethodException;
}

