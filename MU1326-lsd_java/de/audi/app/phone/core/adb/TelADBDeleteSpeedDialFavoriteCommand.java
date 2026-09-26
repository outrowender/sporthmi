/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class TelADBDeleteSpeedDialFavoriteCommand
extends AbstractADBCommand {
    private int speedDialKey;
    static /* synthetic */ Class class$de$audi$app$phone$core$adb$TelADBDeleteSpeedDialFavoriteCommand;

    private TelADBDeleteSpeedDialFavoriteCommand(ADBApplication aDBApplication, int n) {
        super(aDBApplication);
        this.speedDialKey = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "TelADBDeleteSpeedDialFavoriteCommand#execute()");
        boolean bl = this.adbDSIAccess.deleteSpeedDial(this.speedDialKey);
        if (!bl) {
            this.logger.log(10000, "TelADBDeleteSpeedDialFavoriteCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void deleteSpeedDialResult(int n) {
        this.logger.log(1078071040, "TelADBDeleteSpeedDialFavoriteCommand#deleteSpeedDialResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createTelADBDeleteSpeedDialFavoriteCommand(ADBApplication aDBApplication, int n) {
        TelADBDeleteSpeedDialFavoriteCommand telADBDeleteSpeedDialFavoriteCommand = new TelADBDeleteSpeedDialFavoriteCommand(aDBApplication, n);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(telADBDeleteSpeedDialFavoriteCommand);
        commandList.execute((class$de$audi$app$phone$core$adb$TelADBDeleteSpeedDialFavoriteCommand == null ? (class$de$audi$app$phone$core$adb$TelADBDeleteSpeedDialFavoriteCommand = TelADBDeleteSpeedDialFavoriteCommand.class$("de.audi.app.phone.core.adb.TelADBDeleteSpeedDialFavoriteCommand")) : class$de$audi$app$phone$core$adb$TelADBDeleteSpeedDialFavoriteCommand).getName());
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

