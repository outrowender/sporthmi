/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.core.method.MethodException;

public interface NetworkingBluetoothBridgeC {
    public void updateConnectionState(long var1, int var3, int var4) throws MethodException;

    public void updateBluetoothAddress(long var1) throws MethodException;
}

