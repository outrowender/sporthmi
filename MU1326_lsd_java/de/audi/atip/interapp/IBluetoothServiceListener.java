/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IBluetoothServiceListener {
    public void responseConnectService(String var1, int var2, String var3, boolean var4, int var5);

    public void responseDisconnectService(String var1, int var2, int var3);
}

