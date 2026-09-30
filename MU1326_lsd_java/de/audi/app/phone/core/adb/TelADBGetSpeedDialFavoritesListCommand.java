/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.phone.core.adb.ITelADBGetSpeedDialListFavoritesListener;
import de.audi.app.phone.core.adb.TelAddressbookHandlerImpl;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class TelADBGetSpeedDialFavoritesListCommand
extends AbstractADBCommand {
    private final ITelADBGetSpeedDialListFavoritesListener listener;
    static /* synthetic */ Class class$de$audi$app$phone$core$adb$TelADBGetSpeedDialFavoritesListCommand;

    private TelADBGetSpeedDialFavoritesListCommand(TelAddressbookHandlerImpl telAddressbookHandlerImpl, ITelADBGetSpeedDialListFavoritesListener iTelADBGetSpeedDialListFavoritesListener) {
        super(telAddressbookHandlerImpl);
        this.listener = iTelADBGetSpeedDialListFavoritesListener;
    }

    public void execute() {
        this.logger.log(1000000, "TelADBGetSpeedDialFavoritesListCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[0], 4, 1);
        if (!bl) {
            this.logger.log(10000, "TelADBGetSpeedDialFavoritesListCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(1000000, "TelADBGetSpeedDialFavoritesListCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0 && this.listener != null) {
            this.listener.resultGetADBSpeedDialFavoritesList(adbEntryArray);
        }
        this.commandList.commandFinished();
    }

    public static void createTelADBGetSpeedDialFavoritesListCommand(TelAddressbookHandlerImpl telAddressbookHandlerImpl, ITelADBGetSpeedDialListFavoritesListener iTelADBGetSpeedDialListFavoritesListener) {
        TelADBGetSpeedDialFavoritesListCommand telADBGetSpeedDialFavoritesListCommand = new TelADBGetSpeedDialFavoritesListCommand(telAddressbookHandlerImpl, iTelADBGetSpeedDialListFavoritesListener);
        CommandList commandList = new CommandList(telAddressbookHandlerImpl.getCommandListManager());
        commandList.add(telADBGetSpeedDialFavoritesListCommand);
        commandList.execute((class$de$audi$app$phone$core$adb$TelADBGetSpeedDialFavoritesListCommand == null ? (class$de$audi$app$phone$core$adb$TelADBGetSpeedDialFavoritesListCommand = TelADBGetSpeedDialFavoritesListCommand.class$("de.audi.app.phone.core.adb.TelADBGetSpeedDialFavoritesListCommand")) : class$de$audi$app$phone$core$adb$TelADBGetSpeedDialFavoritesListCommand).getName());
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

