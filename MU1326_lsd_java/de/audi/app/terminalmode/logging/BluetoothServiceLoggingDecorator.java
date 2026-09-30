/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.atip.interapp.IBluetoothService;
import de.audi.atip.log.LogChannel;

public class BluetoothServiceLoggingDecorator
implements IBluetoothService {
    private final IBluetoothService wrappee;
    private LogChannel lc;
    private int level;

    public BluetoothServiceLoggingDecorator(IBluetoothService iBluetoothService, LogChannel logChannel, int n) {
        this.wrappee = iBluetoothService;
        this.lc = logChannel;
        this.level = n;
    }

    public void activateBluetooth() {
        this.lc.log(this.level, "-> [IBluetoothService.activateBluetooth]");
        this.wrappee.activateBluetooth();
    }

    public void activateBluetoothAudio() {
        this.lc.log(this.level, "-> [IBluetoothService.activateBluetoothAudio]");
        this.wrappee.activateBluetoothAudio();
    }

    public void deactivateBluetoothAudio() {
        this.lc.log(this.level, "-> [IBluetoothService.deactivateBluetoothAudio]");
        this.wrappee.deactivateBluetoothAudio();
    }

    public void connectService(String string, int n, String string2, boolean bl) {
        this.lc.log(this.level, "-> [IBluetoothService.connectService] %1, %2", (Object)string, (Object)string2);
        this.wrappee.connectService(string, n, string2, bl);
    }

    public void disconnectService(String string, int n) {
        this.lc.log(this.level, "-> [IBluetoothService.disconnectService] %1", (Object)string);
        this.wrappee.disconnectService(string, n);
    }
}

