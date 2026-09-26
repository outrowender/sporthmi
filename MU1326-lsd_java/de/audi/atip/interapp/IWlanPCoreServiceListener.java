/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.connectivity.wlan.TrustedNetwork;
import org.dsi.ifc.networking.Node;

public interface IWlanPCoreServiceListener {
    default public void updateRFActive(int n, int n2) {
    }

    default public void updateRole(int n, int n2) {
    }

    default public void responseSetRFActive() {
    }

    default public void responseSetRole() {
    }

    default public void updateTrustedNetworks(TrustedNetwork[] trustedNetworkArray) {
    }

    default public void updateNodeList(Node[] nodeArray, int n) {
    }

    default public void responseDeleteTrustedNetwork() {
    }
}

