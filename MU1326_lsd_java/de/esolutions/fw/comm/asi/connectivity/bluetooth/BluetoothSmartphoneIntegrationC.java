/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface BluetoothSmartphoneIntegrationC {
    public void updateSmartphoneMode(int var1, String[] var2) throws MethodException;

    public void requestLocalBluetoothAddress() throws MethodException;

    public void requestPrepareConnect(String var1) throws MethodException;
}

