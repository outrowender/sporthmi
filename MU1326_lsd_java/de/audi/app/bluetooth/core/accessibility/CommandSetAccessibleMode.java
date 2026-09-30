/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandSetAccessibleMode
extends AbstractBluetoothCommand {
    private final int accessibleMode;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$accessibility$CommandSetAccessibleMode;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, int n) {
        CommandSetAccessibleMode commandSetAccessibleMode = new CommandSetAccessibleMode(iBluetoothApplication.getLogChannel(), dSIBluetooth, n);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandSetAccessibleMode);
    }

    private CommandSetAccessibleMode(LogChannel logChannel, DSIBluetooth dSIBluetooth, int n) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$accessibility$CommandSetAccessibleMode == null ? (class$de$audi$app$bluetooth$core$accessibility$CommandSetAccessibleMode = CommandSetAccessibleMode.class$("de.audi.app.bluetooth.core.accessibility.CommandSetAccessibleMode")) : class$de$audi$app$bluetooth$core$accessibility$CommandSetAccessibleMode).getName());
        this.accessibleMode = n;
    }

    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.setAccessibleMode(this.accessibleMode);
        } else {
            this.logger.log(100000, "CommandSetAccessibleMode#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    public void responseSetAccessibleMode(int n) {
        this.logger.log(1000000, "CommandSetAccessibleMode#responseSetAccessibleMode(): result=%1", (long)n);
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

