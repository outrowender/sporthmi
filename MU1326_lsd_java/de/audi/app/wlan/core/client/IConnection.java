/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;

public interface IConnection {
    public void connectNetwork(DiscoveredNetwork var1);

    public void connectNetwork(DiscoveredNetwork var1, DSIWLANListener var2);

    public void disconnectNetwork(String var1, String var2);

    public void disconnectNetwork(String var1, String var2, DSIWLANListener var3);
}

