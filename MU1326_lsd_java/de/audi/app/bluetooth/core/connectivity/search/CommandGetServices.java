/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.search.IDiscoveredServiceHandler;
import de.audi.app.bluetooth.core.security.AbstractCommandRequestPasskeyResponse;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandGetServices
extends AbstractCommandRequestPasskeyResponse {
    private final IBluetoothApplication bluetoothApplication;
    private final IDiscoveredServiceHandler responseHandler;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$connectivity$search$CommandGetServices;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, IDiscoveredServiceHandler iDiscoveredServiceHandler) {
        CommandGetServices commandGetServices = new CommandGetServices(iBluetoothApplication, dSIBluetooth, string, iDiscoveredServiceHandler);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandGetServices);
    }

    private CommandGetServices(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, IDiscoveredServiceHandler iDiscoveredServiceHandler) {
        super(iBluetoothApplication.getLogChannel(), dSIBluetooth, string, (class$de$audi$app$bluetooth$core$connectivity$search$CommandGetServices == null ? (class$de$audi$app$bluetooth$core$connectivity$search$CommandGetServices = CommandGetServices.class$("de.audi.app.bluetooth.core.connectivity.search.CommandGetServices")) : class$de$audi$app$bluetooth$core$connectivity$search$CommandGetServices).getName());
        this.bluetoothApplication = iBluetoothApplication;
        this.responseHandler = iDiscoveredServiceHandler;
    }

    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestGetServices(this.deviceAddress);
        } else {
            this.logger.log(100000, "CommandGetServices#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    protected void pairingFinished() {
        this.logger.log(10000000, "CommandGetServices#pairingFinished(): Resuming connection attempt.");
        this.bluetoothApplication.getBondingState().updateBondingState(1);
    }

    public void abort() {
        this.logger.log(100000, "CommandGetServices#abort(): resetting serviceDiscoveryActive!");
        this.bluetoothApplication.getSecurity().serviceDiscoveryActive(false);
        this.bluetoothApplication.getMediaBluetoothStateProvider().serviceDiscoveryStopped();
    }

    public void responseGetServices(String string, String string2, int n, int n2) {
        if (n2 == 0) {
            this.logger.log(1000000, "CommandGetServices#responseGetServices(): %1 %2 supports services: %3", (Object)string2, (Object)string, (long)n);
        } else {
            this.logger.log(10000, "CommandGetServices#responseGetServices(): %1 %2 supports services: %3", (Object)string2, (Object)string, (long)n);
        }
        if (this.responseHandler != null) {
            this.responseHandler.updateDiscoveredServices(string, string2, n, n2);
        }
        this.bluetoothApplication.getSecurity().serviceDiscoveryActive(false);
        this.bluetoothApplication.getMediaBluetoothStateProvider().serviceDiscoveryStopped();
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

