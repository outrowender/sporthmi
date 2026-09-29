/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import org.dsi.ifc.networking.DiscoveredNetwork;

interface IFoundNetworkList {
    default public void add(DiscoveredNetwork discoveredNetwork) {
    }

    default public void clear() {
    }

    default public DiscoveredNetwork getNetwork(int n) {
    }
}

