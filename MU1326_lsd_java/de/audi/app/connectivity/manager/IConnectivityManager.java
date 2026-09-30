/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.wlan.core.client.Network;

public interface IConnectivityManager {
    public static final int MEDIATYPE_OTHER = 0;
    public static final int MEDIATYPE_BLUETOOTH = 1;
    public static final int MEDIATYPE_WLAN = 2;

    public void connectivityManagerEntered();

    public void responseConnectService(int var1, int var2);

    public void updateTrustedWlanNetworks(Network[] var1);

    public void updateUPnPState(String var1);

    public void updateActiveMediaDevice(int var1, String var2);
}

