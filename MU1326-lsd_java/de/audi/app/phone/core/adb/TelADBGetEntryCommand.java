/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.phone.core.adb.ITelADBGetADBEntryListener;
import de.audi.app.phone.core.adb.TelAddressbookHandlerImpl;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class TelADBGetEntryCommand
extends AbstractADBCommand {
    private final TelAddressbookHandlerImpl adbHandler;
    private final long entryId;
    private final ITelADBGetADBEntryListener listener;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand;

    private TelADBGetEntryCommand(TelAddressbookHandlerImpl telAddressbookHandlerImpl, long l, ITelADBGetADBEntryListener iTelADBGetADBEntryListener) {
        super(telAddressbookHandlerImpl);
        this.adbHandler = telAddressbookHandlerImpl;
        this.entryId = l;
        this.listener = iTelADBGetADBEntryListener;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "TelADBGetEntryCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "TelADBGetEntryCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (adbEntryArray == null) {
            this.logger.log(10000, "TelADBGetEntryCommand#getEntriesResult(): entryList is null");
            return;
        }
        this.logger.log(-2137614336, "TelADBGetEntryCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            if (adbEntryArray.length == 1) {
                AdbEntry adbEntry = adbEntryArray[0];
                this.logger.log(-2137614336, "TelADBGetEntryCommand#getEntriesResult(): got entry: %1", (Object)ADBDbgUtils.dbg(adbEntry));
                this.adbHandler.setCurrentEntry(adbEntry);
                if (this.listener != null) {
                    this.listener.resultGetADBEntry(adbEntry);
                }
            } else {
                this.logger.log(10000, "TelADBGetEntryCommand#getEntriesResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
            }
        }
        this.commandList.commandFinished();
    }

    public static void createGetEntryCommand(TelAddressbookHandlerImpl telAddressbookHandlerImpl, long l, ITelADBGetADBEntryListener iTelADBGetADBEntryListener) {
        TelADBGetEntryCommand telADBGetEntryCommand = new TelADBGetEntryCommand(telAddressbookHandlerImpl, l, iTelADBGetADBEntryListener);
        CommandList commandList = new CommandList(telAddressbookHandlerImpl.getCommandListManager());
        commandList.add(telADBGetEntryCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand = TelADBGetEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand).getName());
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

