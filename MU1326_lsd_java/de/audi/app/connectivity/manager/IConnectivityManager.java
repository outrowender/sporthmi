/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.wlan.core.client.Network;

public interface IConnectivityManager {
    public static final int MEDIATYPE_OTHER;
    public static final int MEDIATYPE_BLUETOOTH;
    public static final int MEDIATYPE_WLAN;

    default public void connectivityManagerEntered() {
    }

    default public void responseConnectService(int n, int n2) {
    }

    default public void updateTrustedWlanNetworks(Network[] networkArray) {
    }

    default public void updateUPnPState(String string) {
    }

    default public void updateActiveMediaDevice(int n, String string) {
    }
}

