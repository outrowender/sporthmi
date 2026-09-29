/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.trusted;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandRemoveAuthentication
extends AbstractBluetoothCommand {
    private final String deviceAddress;
    private final ChoiceModelApp commandMonitor;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$connectivity$trusted$CommandRemoveAuthentication;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, ChoiceModelApp choiceModelApp) {
        CommandRemoveAuthentication commandRemoveAuthentication = new CommandRemoveAuthentication(iBluetoothApplication.getLogChannel(), dSIBluetooth, string, choiceModelApp);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandRemoveAuthentication);
    }

    private CommandRemoveAuthentication(LogChannel logChannel, DSIBluetooth dSIBluetooth, String string, ChoiceModelApp choiceModelApp) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$connectivity$trusted$CommandRemoveAuthentication == null ? (class$de$audi$app$bluetooth$core$connectivity$trusted$CommandRemoveAuthentication = CommandRemoveAuthentication.class$("de.audi.app.bluetooth.core.connectivity.trusted.CommandRemoveAuthentication")) : class$de$audi$app$bluetooth$core$connectivity$trusted$CommandRemoveAuthentication).getName());
        this.deviceAddress = string;
        this.commandMonitor = choiceModelApp;
        if (choiceModelApp != null) {
            choiceModelApp.setStatus(0);
            choiceModelApp.setValue(-1);
        } else {
            this.logger.log(-1601830656, "CommandRemoveAuthentication(): commandMonitor is NULL");
        }
    }

    @Override
    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestRemoveAuthentication(this.deviceAddress);
        } else {
            this.logger.log(-1601830656, "CommandRemoveAuthentication#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void abort() {
        this.logger.log(-1601830656, "CommandRemoveAuthentication#abort()");
        if (this.commandMonitor != null) {
            this.commandMonitor.setStatus(2);
        } else {
            this.logger.log(-1601830656, "CommandRemoveAuthentication#execute(): commandMonitor is NULL");
        }
    }

    @Override
    public void responseRemoveAuthentication(String string, String string2, int n) {
        this.logger.log(1078071040, "CommandRemoveAuthentication#responseRemoveAuthentication() btDeviceName=%1, result=%2", (Object)string2, (long)n);
        if (this.commandMonitor != null) {
            this.commandMonitor.setValue(n);
            if (n == 0) {
                this.commandMonitor.setStatus(1);
            } else {
                this.commandMonitor.setStatus(2);
            }
        } else {
            this.logger.log(-1601830656, "CommandRemoveAuthentication#responseRemoveAuthentication(): commandMonitor is NULL");
        }
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

