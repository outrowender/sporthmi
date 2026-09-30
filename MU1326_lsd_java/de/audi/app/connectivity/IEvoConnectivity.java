/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity;

import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.app.connectivity.core.IConnectivity;
import de.audi.app.connectivity.manager.IConnectivityManager;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.wlan.evo.IEvoWlanApplication;

public interface IEvoConnectivity
extends IConnectivity {
    public IEvoBluetoothApplication getBluetooth();

    public IConnectivityManager getConnectivityManager();

    public IDataApplication getData();

    public IEvoWlanApplication getWlan();
}

