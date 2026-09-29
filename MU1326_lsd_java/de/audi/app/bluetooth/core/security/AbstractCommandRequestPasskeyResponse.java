/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

public abstract class AbstractCommandRequestPasskeyResponse
extends AbstractBluetoothCommand {
    protected final String deviceAddress;

    protected AbstractCommandRequestPasskeyResponse(LogChannel logChannel, DSIBluetooth dSIBluetooth, String string, String string2) {
        super(logChannel, dSIBluetooth, string2);
        this.deviceAddress = string;
    }

    protected abstract void pairingFinished() {
    }

    final void requestPasskeyResponse(String string, boolean bl) {
        this.logger.log(-2137614336, "%3#requestPasskeyResponse(): Accept pairing to device %2: %1", bl, (Object)this.deviceAddress, (Object)this.name);
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestPasskeyResponse(string, this.deviceAddress, bl ? 1 : 0);
        } else {
            this.logger.log(-1601830656, "%1#execute(): dsiBluetooth is NULL", (Object)this.name);
            this.commandList.commandFinished();
        }
    }

    @Override
    public final void responsePasskeyResponse(String string, String string2, int n) {
        if (n == 0) {
            this.logger.log(1078071040, "%1#responsePasskeyResponse(): %2, result=%3", (Object)this.name, (Object)string2, (long)n);
        } else {
            this.logger.log(10000, "%1#responsePasskeyResponse(): %2, result=%3", (Object)this.name, (Object)string2, (long)n);
        }
        this.pairingFinished();
    }
}

