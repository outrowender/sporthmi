/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class TelADBDeleteAllSpeedDialFavoritesCommand
extends AbstractADBCommand {
    static /* synthetic */ Class class$de$audi$app$phone$core$adb$TelADBDeleteAllSpeedDialFavoritesCommand;

    private TelADBDeleteAllSpeedDialFavoritesCommand(ADBApplication aDBApplication) {
        super(aDBApplication);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "TelADBDeleteAllSpeedDialFavoritesCommand#execute()");
        boolean bl = this.adbDSIAccess.deleteEntries(new long[0], 4, 1);
        if (!bl) {
            this.logger.log(10000, "TelADBDeleteAllSpeedDialFavoritesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void deleteEntriesResult(int n) {
        this.logger.log(1078071040, "TelADBDeleteAllSpeedDialFavoritesCommand#deleteEntriesResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createTelADBDeleteAllSpeedDialFavoriteCommand(ADBApplication aDBApplication) {
        TelADBDeleteAllSpeedDialFavoritesCommand telADBDeleteAllSpeedDialFavoritesCommand = new TelADBDeleteAllSpeedDialFavoritesCommand(aDBApplication);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(telADBDeleteAllSpeedDialFavoritesCommand);
        commandList.execute((class$de$audi$app$phone$core$adb$TelADBDeleteAllSpeedDialFavoritesCommand == null ? (class$de$audi$app$phone$core$adb$TelADBDeleteAllSpeedDialFavoritesCommand = TelADBDeleteAllSpeedDialFavoritesCommand.class$("de.audi.app.phone.core.adb.TelADBDeleteAllSpeedDialFavoritesCommand")) : class$de$audi$app$phone$core$adb$TelADBDeleteAllSpeedDialFavoritesCommand).getName());
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

