/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.reset;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandRestoreFactorySettings
extends AbstractBluetoothCommand {
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$reset$CommandRestoreFactorySettings;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth) {
        CommandRestoreFactorySettings commandRestoreFactorySettings = new CommandRestoreFactorySettings(iBluetoothApplication.getLogChannel(), dSIBluetooth);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandRestoreFactorySettings);
    }

    private CommandRestoreFactorySettings(LogChannel logChannel, DSIBluetooth dSIBluetooth) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$reset$CommandRestoreFactorySettings == null ? (class$de$audi$app$bluetooth$core$reset$CommandRestoreFactorySettings = CommandRestoreFactorySettings.class$("de.audi.app.bluetooth.core.reset.CommandRestoreFactorySettings")) : class$de$audi$app$bluetooth$core$reset$CommandRestoreFactorySettings).getName());
    }

    @Override
    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestRestoreFactorySettings();
        } else {
            this.logger.log(-1601830656, "CommandRestoreFactorySettings#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        this.commandList.commandFinished();
        if (n != 0) {
            this.logger.log(10000, "[CommandRestoreFactorySettings#responseRestoreFactorySettings]: Result=%1", (long)n);
        }
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

