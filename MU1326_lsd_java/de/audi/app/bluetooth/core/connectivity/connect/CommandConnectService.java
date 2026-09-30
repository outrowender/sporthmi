/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.connect;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.security.AbstractCommandRequestPasskeyResponse;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandConnectService
extends AbstractCommandRequestPasskeyResponse {
    private static final int TIMEOUT = 300000;
    private final IBluetoothApplication bluetoothApplication;
    private final int service;
    private final int deviceRole;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$connectivity$connect$CommandConnectService;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, int n, int n2) {
        CommandConnectService commandConnectService = new CommandConnectService(iBluetoothApplication, dSIBluetooth, string, n, n2);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandConnectService);
    }

    private CommandConnectService(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, int n, int n2) {
        super(iBluetoothApplication.getLogChannel(), dSIBluetooth, string, (class$de$audi$app$bluetooth$core$connectivity$connect$CommandConnectService == null ? (class$de$audi$app$bluetooth$core$connectivity$connect$CommandConnectService = CommandConnectService.class$("de.audi.app.bluetooth.core.connectivity.connect.CommandConnectService")) : class$de$audi$app$bluetooth$core$connectivity$connect$CommandConnectService).getName());
        this.service = n;
        this.deviceRole = n2;
        this.bluetoothApplication = iBluetoothApplication;
    }

    public long getTimeout() {
        return 300000L;
    }

    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestConnectService(this.deviceAddress, this.service, this.deviceRole);
        } else {
            this.logger.log(100000, "CommandConnectService#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    public void abort() {
        this.bluetoothApplication.getBondingState().updateBondingResult(4);
        this.bluetoothApplication.getBondingState().updateBondingState(0);
    }

    protected void pairingFinished() {
        this.logger.log(10000000, "CommandConnectService#pairingFinished()");
        this.bluetoothApplication.getBondingState().updateBondingState(1);
    }

    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
        if (n3 == 0) {
            this.logger.log(1000000, "CommandConnectService#responseConnectService(): result=%1", (long)n3);
        } else {
            this.logger.log(10000, "CommandConnectService#responseConnectService(): result=%1", (long)n3);
        }
        this.bluetoothApplication.getConnection().responseConnectService(string, this.service, n, n3);
        this.commandList.commandFinished();
    }

    void abortConnectService() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.abortConnectService(this.deviceAddress);
        } else {
            this.logger.log(100000, "CommandConnectService#abortConnectService(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    public void responseAbortConnectService(int n) {
        if (n == 0) {
            this.logger.log(1000000, "CommandConnectService#responseAbortConnectService(): result=%1", (long)n);
        } else {
            this.logger.log(10000, "CommandConnectService#responseAbortConnectService(): result=%1", (long)n);
        }
        this.bluetoothApplication.getConnection().responseConnectService(this.deviceAddress, this.service, 0, n);
        this.commandList.commandFinished();
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

