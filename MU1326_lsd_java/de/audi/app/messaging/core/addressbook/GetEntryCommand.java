/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public final class GetEntryCommand
extends AbstractADBCommand {
    private long entryId;
    private MessagingAdbHandler adbHandler;
    private ResultHandler resultHandler;
    private int viewtype;
    static /* synthetic */ Class class$de$audi$app$messaging$core$addressbook$GetEntryCommand;

    GetEntryCommand(MessagingAdbHandler messagingAdbHandler, long l, ResultHandler resultHandler, int n) {
        super(messagingAdbHandler);
        this.adbHandler = messagingAdbHandler;
        this.entryId = l;
        this.resultHandler = resultHandler;
        this.viewtype = n;
    }

    public void execute() {
        this.logger.log(1000000, "GetEntryCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, this.viewtype, 0);
        if (!bl) {
            this.logger.log(10000, "GetEntryCommand#execute(): dsi call was not successful, finishing command.");
            this.signalResult(1, null);
        }
    }

    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (adbEntryArray != null && adbEntryArray.length == 1) {
            this.logger.log(1000000, "GetEntryCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
            ADBUtils.checkAndFixADBEntry(adbEntryArray[0], this.adbHandler.getFramework());
            this.signalResult(n, adbEntryArray[0]);
        } else {
            this.logger.log(10000, "GetEntryCommand#signalResult: dsi call was not successful (not resulting in exactly one AdbEntry), finishing command.");
            this.signalResult(1, null);
        }
    }

    public static void schedule(MessagingAdbHandler messagingAdbHandler, long l, ResultHandler resultHandler) {
        GetEntryCommand.schedule(messagingAdbHandler, l, resultHandler, 0);
    }

    public static void schedule(MessagingAdbHandler messagingAdbHandler, long l, ResultHandler resultHandler, int n) {
        GetEntryCommand getEntryCommand = new GetEntryCommand(messagingAdbHandler, l, resultHandler, n);
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
            this.logger.log(10000000, "[GetEntryCommand#signalResult] success = %1", (long)n);
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
        return new AbstractADBCommand(this.adbHandler){

            public void execute() {
                this.logger.log(10000000, "[GetEntryErrorCommand#execute]");
                GetEntryCommand.this.signalResult(1, null);
            }
        };
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static interface ResultHandler {
        public void handleResult(int var1, AdbEntry var2);
    }
}

