/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.security.AbstractCommandRequestPasskeyResponse;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandRequestPasskeyResponse
extends AbstractCommandRequestPasskeyResponse {
    private final IBluetoothApplication bluetoothApplication;
    private String passkey;
    private boolean accept;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$security$CommandRequestPasskeyResponse;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, String string2, boolean bl) {
        CommandRequestPasskeyResponse commandRequestPasskeyResponse = new CommandRequestPasskeyResponse(iBluetoothApplication, dSIBluetooth, string, string2, bl);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandRequestPasskeyResponse);
    }

    private CommandRequestPasskeyResponse(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, String string2, boolean bl) {
        super(iBluetoothApplication.getLogChannel(), dSIBluetooth, string, (class$de$audi$app$bluetooth$core$security$CommandRequestPasskeyResponse == null ? (class$de$audi$app$bluetooth$core$security$CommandRequestPasskeyResponse = CommandRequestPasskeyResponse.class$("de.audi.app.bluetooth.core.security.CommandRequestPasskeyResponse")) : class$de$audi$app$bluetooth$core$security$CommandRequestPasskeyResponse).getName());
        this.bluetoothApplication = iBluetoothApplication;
        this.passkey = string2;
        this.accept = bl;
    }

    public void execute() {
        this.requestPasskeyResponse(this.passkey, this.accept);
    }

    protected void pairingFinished() {
        this.finishCommand();
        this.commandList.commandFinished();
    }

    public void abort() {
        super.abort();
        this.finishCommand();
    }

    private void finishCommand() {
        this.bluetoothApplication.getBondingState().updateBondingState(0);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

