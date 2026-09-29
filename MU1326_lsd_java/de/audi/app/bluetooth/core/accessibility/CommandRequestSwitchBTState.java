/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandRequestSwitchBTState
extends AbstractBluetoothCommand {
    private final int btStateTarget;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$accessibility$CommandRequestSwitchBTState;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, int n) {
        CommandRequestSwitchBTState commandRequestSwitchBTState = new CommandRequestSwitchBTState(iBluetoothApplication.getLogChannel(), dSIBluetooth, n);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandRequestSwitchBTState);
    }

    private CommandRequestSwitchBTState(LogChannel logChannel, DSIBluetooth dSIBluetooth, int n) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$accessibility$CommandRequestSwitchBTState == null ? (class$de$audi$app$bluetooth$core$accessibility$CommandRequestSwitchBTState = CommandRequestSwitchBTState.class$("de.audi.app.bluetooth.core.accessibility.CommandRequestSwitchBTState")) : class$de$audi$app$bluetooth$core$accessibility$CommandRequestSwitchBTState).getName());
        this.btStateTarget = n;
    }

    @Override
    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestSwitchBTState(this.btStateTarget);
        } else {
            this.logger.log(-1601830656, "CommandRequestSwitchBTState#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void responseSwitchBTState(int n) {
        this.logger.log(1078071040, "CommandRequestSwitchBTState#responseSwitchBTState(): result=%1", (long)n);
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

