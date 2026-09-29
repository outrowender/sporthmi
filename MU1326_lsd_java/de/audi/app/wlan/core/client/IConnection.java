/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;

public interface IConnection {
    default public void connectNetwork(DiscoveredNetwork discoveredNetwork) {
    }

    default public void connectNetwork(DiscoveredNetwork discoveredNetwork, DSIWLANListener dSIWLANListener) {
    }

    default public void disconnectNetwork(String string, String string2) {
    }

    default public void disconnectNetwork(String string, String string2, DSIWLANListener dSIWLANListener) {
    }
}

