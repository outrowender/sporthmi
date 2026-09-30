/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.reconnect;

import de.audi.app.bluetooth.core.connectivity.reconnect.AbstractReconnectInfo;
import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.app.data.core.IDataApplication;

public class ReconnectInfo
extends AbstractReconnectInfo {
    private final IEvoBluetoothApplication bluetoothApplication;

    public ReconnectInfo(IEvoBluetoothApplication iEvoBluetoothApplication) {
        super(iEvoBluetoothApplication);
        this.bluetoothApplication = iEvoBluetoothApplication;
    }

    public void updateReconnectIndicator(org.dsi.ifc.bluetooth.ReconnectInfo reconnectInfo, int n) {
        super.updateReconnectIndicator(reconnectInfo, n);
        if (n != 1 || reconnectInfo == null) {
            return;
        }
        IDataApplication iDataApplication = this.bluetoothApplication.getConnectivity().getData();
        if (iDataApplication != null) {
            iDataApplication.getOnline().updateReconnectInfo(reconnectInfo);
        }
    }
}

