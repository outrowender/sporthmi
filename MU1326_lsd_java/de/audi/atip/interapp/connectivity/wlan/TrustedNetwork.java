/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.connectivity.wlan;

import org.dsi.ifc.networking.DiscoveredNetwork;

public class TrustedNetwork
extends DiscoveredNetwork {
    private boolean isConnected;

    public TrustedNetwork(String string, String string2, int n, boolean bl, boolean bl2) {
        super(string, string2, -1, n, bl2);
        this.isConnected = bl;
    }

    void setActive(boolean bl) {
        this.isConnected = bl;
    }

    public boolean isActive() {
        return this.isConnected;
    }
}

