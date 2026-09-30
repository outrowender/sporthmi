/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IBluetoothService {
    public void activateBluetooth();

    public void activateBluetoothAudio();

    public void deactivateBluetoothAudio();

    public void connectService(String var1, int var2, String var3, boolean var4);

    public void disconnectService(String var1, int var2);
}

