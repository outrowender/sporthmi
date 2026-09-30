/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.BluetoothHeadPhoneInfo;

public interface BluetoothService {
    public String[] getBthsDevices();

    public void updateTelMode(int var1);

    public void setTransitionToBtDevices();

    public void enableAudioPlayer(boolean var1);

    public void activateBluetooth();

    public void updateHPActivity(BluetoothHeadPhoneInfo var1);

    public void setTelSwitchedOn(boolean var1);

    public void setDataConnectionsEnabled(boolean var1);

    public void setCallStateIdle(boolean var1);

    public String getMapDeviceAddress();

    public String getSapDeviceAddress();

    public String getMapDeviceName();

    public boolean isTrusted(String var1);
}

