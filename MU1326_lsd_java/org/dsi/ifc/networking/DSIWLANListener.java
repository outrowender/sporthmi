/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public interface DSIWLANListener
extends DSIListener {
    public void updateRole(int var1, int var2);

    public void updateRFActive(int var1, int var2);

    public void updateNodeList(Node[] var1, int var2);

    public void updateProfile(Profile var1, int var2);

    public void updateWlanEnabled(boolean var1, int var2);

    public void updateStartupState(int var1, int var2);

    public void updateTrustedNetworks(String[] var1, String[] var2, int[] var3, int var4);

    public void updateDiscoveredNetwork(DiscoveredNetwork var1, int var2);

    public void updateConnectedNetwork(String var1, String var2, int var3, int var4);

    public void responseFactoryReset(int var1);

    public void responseSetRole(int var1);

    public void responseSetRFActive(int var1);

    public void responseSetProfile(int var1);

    public void responseNetworkSearch(int var1, int var2);

    public void responseAbortSearch(int var1);

    public void responseConnectNetwork(String var1, String var2, int var3);

    public void responseDisconnectNetwork(String var1, String var2, int var3);

    public void responseDeleteTrustedNetwork(String var1, String var2, int var3);

    public void responseActivateWps(int var1);

    public void updateWPSRunning(int var1, int var2);

    public void updateWPSStoppedAndConnecting(String var1, String var2, int var3);
}

