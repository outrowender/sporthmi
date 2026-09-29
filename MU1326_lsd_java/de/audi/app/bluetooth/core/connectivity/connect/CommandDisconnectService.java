/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.connect;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandDisconnectService
extends AbstractBluetoothCommand {
    private final String deviceAddress;
    private final int service;
    private ChoiceModelApp commandMonitor;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$connectivity$connect$CommandDisconnectService;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, String string, int n, ChoiceModelApp choiceModelApp) {
        CommandDisconnectService commandDisconnectService = new CommandDisconnectService(iBluetoothApplication.getLogChannel(), dSIBluetooth, string, n, choiceModelApp);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandDisconnectService);
    }

    private CommandDisconnectService(LogChannel logChannel, DSIBluetooth dSIBluetooth, String string, int n, ChoiceModelApp choiceModelApp) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$connectivity$connect$CommandDisconnectService == null ? (class$de$audi$app$bluetooth$core$connectivity$connect$CommandDisconnectService = CommandDisconnectService.class$("de.audi.app.bluetooth.core.connectivity.connect.CommandDisconnectService")) : class$de$audi$app$bluetooth$core$connectivity$connect$CommandDisconnectService).getName());
        this.deviceAddress = string;
        this.service = n;
        this.commandMonitor = choiceModelApp;
        if (choiceModelApp != null) {
            choiceModelApp.setStatus(0);
            choiceModelApp.setValue(-1);
        } else {
            this.logger.log(-1601830656, "CommandDisconnectService(): commandMonitor is NULL");
        }
    }

    @Override
    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestDisconnectService(this.deviceAddress, this.service);
        } else {
            this.logger.log(-1601830656, "CommandDisconnectService#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void abort() {
        this.logger.log(-1601830656, "CommandDisconnectService#abort()");
        if (this.commandMonitor != null) {
            this.commandMonitor.setStatus(2);
        } else {
            this.logger.log(-1601830656, "CommandDisconnectService#abort(): monitor is NULL");
        }
    }

    @Override
    public void responseDisconnectService(String string, int n, int n2) {
        this.logger.log(1078071040, "CommandDisconnectService#responseDisconnectService(): result=%1", (long)n2);
        if (this.commandMonitor != null) {
            this.commandMonitor.setValue(n2);
            if (n2 == 0) {
                this.commandMonitor.setStatus(1);
            } else {
                this.commandMonitor.setStatus(2);
            }
        } else {
            this.logger.log(-1601830656, "CommandDisconnectService#responseDisconnectService(): monitor is NULL");
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

