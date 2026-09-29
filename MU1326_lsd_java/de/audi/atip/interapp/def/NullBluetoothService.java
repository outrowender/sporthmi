/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.BluetoothHeadPhoneInfo;
import de.audi.atip.interapp.BluetoothService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullBluetoothService
extends NullService
implements BluetoothService {
    public NullBluetoothService(LogChannel logChannel) {
        super(logChannel, "BluetoothService");
    }

    @Override
    public String[] getBthsDevices() {
        this.log();
        return new String[0];
    }

    @Override
    public void updateTelMode(int n) {
        this.log();
    }

    @Override
    public void setTransitionToBtDevices() {
        this.log();
    }

    @Override
    public void enableAudioPlayer(boolean bl) {
        this.log();
    }

    @Override
    public void activateBluetooth() {
        this.log();
    }

    @Override
    public void updateHPActivity(BluetoothHeadPhoneInfo bluetoothHeadPhoneInfo) {
        this.log();
    }

    @Override
    public void setTelSwitchedOn(boolean bl) {
        this.log();
    }

    @Override
    public void setDataConnectionsEnabled(boolean bl) {
        this.log();
    }

    public void setNADAvailable(boolean bl) {
        this.log();
    }

    @Override
    public void setCallStateIdle(boolean bl) {
        this.log();
    }

    @Override
    public String getMapDeviceAddress() {
        this.log();
        return "";
    }

    @Override
    public String getSapDeviceAddress() {
        this.log();
        return "";
    }

    @Override
    public String getMapDeviceName() {
        this.log();
        return null;
    }

    @Override
    public boolean isTrusted(String string) {
        return true;
    }
}

