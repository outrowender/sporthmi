/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public interface DSIWLANReply {
    public static final String IPL_COMM_UUID = "15f2fca3-02cf-5877-9cdc-5e1b1d2c45ee";
    public static final String IPL_COMM_INTERFACE_KEY = "cb229820-4319-510c-aa41-f4274d5a45c4";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.14";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.14";

    public void updateRole(int var1, int var2) throws MethodException;

    public void updateRFActive(int var1, int var2) throws MethodException;

    public void updateNodeList(Node[] var1, int var2) throws MethodException;

    public void updateProfile(Profile var1, int var2) throws MethodException;

    public void updateWlanEnabled(boolean var1, int var2) throws MethodException;

    public void updateStartupState(int var1, int var2) throws MethodException;

    public void updateTrustedNetworks(String[] var1, String[] var2, int[] var3, int var4) throws MethodException;

    public void updateDiscoveredNetwork(DiscoveredNetwork var1, int var2) throws MethodException;

    public void updateConnectedNetwork(String var1, String var2, int var3, int var4) throws MethodException;

    public void responseFactoryReset(int var1) throws MethodException;

    public void responseSetRole(int var1) throws MethodException;

    public void responseSetRFActive(int var1) throws MethodException;

    public void responseSetProfile(int var1) throws MethodException;

    public void responseNetworkSearch(int var1, int var2) throws MethodException;

    public void responseAbortSearch(int var1) throws MethodException;

    public void responseConnectNetwork(String var1, String var2, int var3) throws MethodException;

    public void responseDisconnectNetwork(String var1, String var2, int var3) throws MethodException;

    public void responseDeleteTrustedNetwork(String var1, String var2, int var3) throws MethodException;

    public void responseActivateWps(int var1) throws MethodException;

    public void updateWPSRunning(int var1, int var2) throws MethodException;

    public void updateWPSStoppedAndConnecting(String var1, String var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

