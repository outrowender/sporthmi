/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.ecall;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.ecall.IEcallBluetoothService;
import de.audi.atip.log.LogChannel;

public class NullEcallBluetoothService
extends NullService
implements IEcallBluetoothService {
    public NullEcallBluetoothService(LogChannel logChannel) {
        super(logChannel, "EcallBluetoothService");
    }

    @Override
    public void switchOnBluetooth() {
        this.log();
    }

    @Override
    public void switchOffBluetooth() {
        this.log();
    }
}

