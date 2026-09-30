/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.connect;

public interface IConnection {
    public void connectService(String var1, int var2, String var3, boolean var4);

    public void connectService(String var1, int var2, String var3, boolean var4, boolean var5);

    public void abortConnectService();

    public void disconnectService(String var1, int var2);

    public void responseConnectService(String var1, int var2, int var3, int var4);

    public void connectionExitAction();

    public void updateHfpSupport(boolean var1);
}

