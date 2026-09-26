/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.messaging.core.addressbook.GetEntryCommand$1;
import de.audi.app.messaging.core.addressbook.GetEntryCommand$ResultHandler;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public final class GetEntryCommand
extends AbstractADBCommand {
    private long entryId;
    private MessagingAdbHandler adbHandler;
    private GetEntryCommand$ResultHandler resultHandler;
    private int viewtype;
    static /* synthetic */ Class class$de$audi$app$messaging$core$addressbook$GetEntryCommand;

    GetEntryCommand(MessagingAdbHandler messagingAdbHandler, long l, GetEntryCommand$ResultHandler getEntryCommand$ResultHandler, int n) {
        super(messagingAdbHandler);
        this.adbHandler = messagingAdbHandler;
        this.entryId = l;
        this.resultHandler = getEntryCommand$ResultHandler;
        this.viewtype = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "GetEntryCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, this.viewtype, 0);
        if (!bl) {
            this.logger.log(10000, "GetEntryCommand#execute(): dsi call was not successful, finishing command.");
            this.signalResult(1, null);
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (adbEntryArray != null && adbEntryArray.length == 1) {
            this.logger.log(1078071040, "GetEntryCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
            ADBUtils.checkAndFixADBEntry(adbEntryArray[0], this.adbHandler.getFramework());
            this.signalResult(n, adbEntryArray[0]);
        } else {
            this.logger.log(10000, "GetEntryCommand#signalResult: dsi call was not successful (not resulting in exactly one AdbEntry), finishing command.");
            this.signalResult(1, null);
        }
    }

    public static void schedule(MessagingAdbHandler messagingAdbHandler, long l, GetEntryCommand$ResultHandler getEntryCommand$ResultHandler) {
        GetEntryCommand.schedule(messagingAdbHandler, l, getEntryCommand$ResultHandler, 0);
    }

    public static void schedule(MessagingAdbHandler messagingAdbHandler, long l, GetEntryCommand$ResultHandler getEntryCommand$ResultHandler, int n) {
        GetEntryCommand getEntryCommand = new GetEntryCommand(messagingAdbHandler, l, getEntryCommand$ResultHandler, n);
        CommandList commandList = new CommandList(messagingAdbHandler.getCommandListManager());
        commandList.add(getEntryCommand);
        commandList.setErrorCommand(getEntryCommand.getErrorCommand());
        commandList.execute((class$de$audi$app$messaging$core$addressbook$GetEntryCommand == null ? (class$de$audi$app$messaging$core$addressbook$GetEntryCommand = GetEntryCommand.class$("de.audi.app.messaging.core.addressbook.GetEntryCommand")) : class$de$audi$app$messaging$core$addressbook$GetEntryCommand).getName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n, AdbEntry adbEntry) {
        try {
            this.logger.log(-2137614336, "[GetEntryCommand#signalResult] success = %1", (long)n);
            this.resultHandler.handleResult(n, adbEntry);
        }
        catch (Exception exception) {
            Logs.logException(this.logger, exception, "[GetEntryCommand#signalResult]");
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    Command getErrorCommand() {
        return new GetEntryCommand$1(this, this.adbHandler);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$000(GetEntryCommand getEntryCommand, int n, AdbEntry adbEntry) {
        getEntryCommand.signalResult(n, adbEntry);
    }
}

