/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.reconnect;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

public final class CommandRequestReconnectSuspend
extends AbstractBluetoothCommand {
    private boolean suspend;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandRequestReconnectSuspend;

    public static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, boolean bl) {
        CommandRequestReconnectSuspend commandRequestReconnectSuspend = new CommandRequestReconnectSuspend(iBluetoothApplication.getLogChannel(), dSIBluetooth, bl);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandRequestReconnectSuspend);
    }

    private CommandRequestReconnectSuspend(LogChannel logChannel, DSIBluetooth dSIBluetooth, boolean bl) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandRequestReconnectSuspend == null ? (class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandRequestReconnectSuspend = CommandRequestReconnectSuspend.class$("de.audi.app.bluetooth.core.connectivity.reconnect.CommandRequestReconnectSuspend")) : class$de$audi$app$bluetooth$core$connectivity$reconnect$CommandRequestReconnectSuspend).getName());
        this.suspend = bl;
    }

    @Override
    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestReconnectSuspend(this.suspend);
        } else {
            this.logger.log(-1601830656, "CommandRequestReconnectSuspend#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void responseReconnectSuspend(int n) {
        this.commandList.commandFinished();
        this.logger.log(1078071040, "CommandRequestReconnectSuspend#responseReconnectSuspend(): result=%1", (long)n);
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

