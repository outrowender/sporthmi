/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface NetworkingBluetoothBridgeS {
    public void updateConnectionState(long var1, int var3, int var4, NetworkingBluetoothBridgeReply var5) throws MethodException;

    public void updateBluetoothAddress(long var1, NetworkingBluetoothBridgeReply var3) throws MethodException;
}

