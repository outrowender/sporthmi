/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class TelADBDeleteSpecificSpeedDialFavoritesCommand
extends AbstractADBCommand {
    private long[] speedDialIDs;
    static /* synthetic */ Class class$de$audi$app$phone$core$adb$TelADBDeleteSpecificSpeedDialFavoritesCommand;

    private TelADBDeleteSpecificSpeedDialFavoritesCommand(ADBApplication aDBApplication, long[] lArray) {
        super(aDBApplication);
        this.speedDialIDs = lArray;
    }

    public void execute() {
        this.logger.log(1000000, "TelADBDeleteSpecificSpeedDialFavoritesCommand#execute()");
        boolean bl = this.adbDSIAccess.deleteEntries(this.speedDialIDs, 4, 0);
        if (!bl) {
            this.logger.log(10000, "TelADBDeleteSpecificSpeedDialFavoritesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void deleteEntriesResult(int n) {
        this.logger.log(1000000, "TelADBDeleteSpecificSpeedDialFavoritesCommand#deleteEntriesResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createTelADBDeleteSpecificSpeedDialFavoriteCommand(ADBApplication aDBApplication, long[] lArray) {
        TelADBDeleteSpecificSpeedDialFavoritesCommand telADBDeleteSpecificSpeedDialFavoritesCommand = new TelADBDeleteSpecificSpeedDialFavoritesCommand(aDBApplication, lArray);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(telADBDeleteSpecificSpeedDialFavoritesCommand);
        commandList.execute((class$de$audi$app$phone$core$adb$TelADBDeleteSpecificSpeedDialFavoritesCommand == null ? (class$de$audi$app$phone$core$adb$TelADBDeleteSpecificSpeedDialFavoritesCommand = TelADBDeleteSpecificSpeedDialFavoritesCommand.class$("de.audi.app.phone.core.adb.TelADBDeleteSpecificSpeedDialFavoritesCommand")) : class$de$audi$app$phone$core$adb$TelADBDeleteSpecificSpeedDialFavoritesCommand).getName());
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

