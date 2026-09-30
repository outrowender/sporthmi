/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.reconnect;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

class CommandSetPriorizedDeviceReconnect
extends AbstractBluetoothCommand {
    private final String address;
    private final boolean setActive;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandSetPriorizedDeviceReconnect;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, boolean bl) {
        CommandSetPriorizedDeviceReconnect commandSetPriorizedDeviceReconnect = new CommandSetPriorizedDeviceReconnect(iBluetoothApplication.getLogChannel(), dSIBluetooth, string, bl);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandSetPriorizedDeviceReconnect);
    }

    private CommandSetPriorizedDeviceReconnect(LogChannel logChannel, DSIBluetooth dSIBluetooth, String string, boolean bl) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandSetPriorizedDeviceReconnect == null ? (class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandSetPriorizedDeviceReconnect = CommandSetPriorizedDeviceReconnect.class$("de.audi.app.bluetooth.core.connectivity.reconnect.CommandSetPriorizedDeviceReconnect")) : class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandSetPriorizedDeviceReconnect).getName());
        this.address = string;
        this.setActive = bl;
    }

    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestSetPriorizedDeviceReconnect(this.setActive, this.address);
        } else {
            this.logger.log(100000, "CommandSetPriorizedDeviceReconnect#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    public void responseSetPriorizedDeviceReconnect(int n) {
        this.commandList.commandFinished();
        this.logger.log(10000000, "CommandSetPriorizedDeviceReconnect#responseSetPriorizedDeviceReconnect(): result=%1", (long)n);
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

