/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface BluetoothSmartphoneIntegrationS {
    public void updateSmartphoneMode(int var1, String[] var2, BluetoothSmartphoneIntegrationReply var3) throws MethodException;

    public void requestLocalBluetoothAddress(BluetoothSmartphoneIntegrationReply var1) throws MethodException;

    public void requestPrepareConnect(String var1, BluetoothSmartphoneIntegrationReply var2) throws MethodException;
}

