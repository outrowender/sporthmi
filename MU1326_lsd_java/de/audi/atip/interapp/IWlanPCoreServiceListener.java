/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.connectivity.wlan.TrustedNetwork;
import org.dsi.ifc.networking.Node;

public interface IWlanPCoreServiceListener {
    public void updateRFActive(int var1, int var2);

    public void updateRole(int var1, int var2);

    public void responseSetRFActive();

    public void responseSetRole();

    public void updateTrustedNetworks(TrustedNetwork[] var1);

    public void updateNodeList(Node[] var1, int var2);

    public void responseDeleteTrustedNetwork();
}

