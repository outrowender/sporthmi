/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.BluetoothHeadPhoneInfo;

public interface BluetoothService {
    default public String[] getBthsDevices() {
    }

    default public void updateTelMode(int n) {
    }

    default public void setTransitionToBtDevices() {
    }

    default public void enableAudioPlayer(boolean bl) {
    }

    default public void activateBluetooth() {
    }

    default public void updateHPActivity(BluetoothHeadPhoneInfo bluetoothHeadPhoneInfo) {
    }

    default public void setTelSwitchedOn(boolean bl) {
    }

    default public void setDataConnectionsEnabled(boolean bl) {
    }

    default public void setCallStateIdle(boolean bl) {
    }

    default public String getMapDeviceAddress() {
    }

    default public String getSapDeviceAddress() {
    }

    default public String getMapDeviceName() {
    }

    default public boolean isTrusted(String string) {
    }
}

