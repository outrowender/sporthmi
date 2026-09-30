/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import org.dsi.ifc.networking.DiscoveredNetwork;

interface IFoundNetworkList {
    public void add(DiscoveredNetwork var1);

    public void clear();

    public DiscoveredNetwork getNetwork(int var1);
}

