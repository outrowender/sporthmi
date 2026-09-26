/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import org.dsi.ifc.networking.DiscoveredNetwork;

public class Network
extends DiscoveredNetwork {
    private boolean isConnected;

    Network(String string, String string2, int n, boolean bl, boolean bl2) {
        this.networkName = string;
        this.bssidAddress = string2;
        this.signalStrength = -1;
        this.encryptionType = n;
        this.isConnected = bl;
    }

    Network(String string, String string2, int n, boolean bl) {
        this.networkName = string;
        this.bssidAddress = string2;
        this.signalStrength = -1;
        this.encryptionType = n;
        this.isConnected = bl;
    }

    void setActive(boolean bl) {
        this.isConnected = bl;
    }

    public boolean isActive() {
        return this.isConnected;
    }
}

