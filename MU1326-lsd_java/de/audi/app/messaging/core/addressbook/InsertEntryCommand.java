/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.messaging.core.addressbook.InsertEntryCommand$1;
import de.audi.app.messaging.core.addressbook.InsertEntryCommand$Result;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public final class InsertEntryCommand
extends AbstractADBCommand {
    private final MessagingAdbHandler adbHandler;
    private final ICommandCallback commandCallback;
    private final AdbEntry entry;
    private volatile boolean hasTerminated = false;
    private volatile InsertEntryCommand$Result result = null;
    static /* synthetic */ Class class$de$audi$app$messaging$core$addressbook$InsertEntryCommand;

    public InsertEntryCommand(MessagingAdbHandler messagingAdbHandler, ICommandCallback iCommandCallback, AdbEntry adbEntry) {
        super(messagingAdbHandler);
        this.adbHandler = messagingAdbHandler;
        this.commandCallback = iCommandCallback;
        this.entry = adbEntry;
    }

    public static void schedule(MessagingAdbHandler messagingAdbHandler, AdbEntry adbEntry, ICommandCallback iCommandCallback) {
        InsertEntryCommand insertEntryCommand = new InsertEntryCommand(messagingAdbHandler, iCommandCallback, adbEntry);
        CommandList commandList = new CommandList(messagingAdbHandler.getCommandListManager());
        commandList.add(insertEntryCommand);
        commandList.setErrorCommand(insertEntryCommand.getErrorCommand());
        commandList.execute((class$de$audi$app$messaging$core$addressbook$InsertEntryCommand == null ? (class$de$audi$app$messaging$core$addressbook$InsertEntryCommand = InsertEntryCommand.class$("de.audi.app.messaging.core.addressbook.InsertEntryCommand")) : class$de$audi$app$messaging$core$addressbook$InsertEntryCommand).getName());
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[InsertEntryCommand#execute] called");
        boolean bl = this.adbDSIAccess.insertEntry(this.entry, 0);
        if (!bl) {
            this.logger.log(-2137614336, "[InsertEntryCommand#execute] dsi call was not successful, finishing command");
            this.signalResult(1);
        }
    }

    @Override
    public void insertEntryResult(int n, AdbEntry adbEntry) {
        this.logger.log(1078071040, "InsertEntryCommand#insertEntryResult(): success: %1, adbEntry: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)ADBDbgUtils.dbg(adbEntry));
        this.signalResult(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(-2137614336, "[InsertEntryCommand#signalResult] success = %1", (long)n);
            this.result = new InsertEntryCommand$Result(this, n, null);
            if (!this.hasTerminated && this.commandCallback != null) {
                this.commandCallback.terminating(this);
            }
        }
        catch (Exception exception) {
            Logs.logException(this.logger, exception, "[InsertEntryCommand#signalResult]");
        }
        finally {
            this.hasTerminated = true;
            if (this.getCommandList().getActiveCommand() == this) {
                this.getCommandList().commandFinished();
            }
        }
    }

    public Command getErrorCommand() {
        return new InsertEntryCommand$1(this, this.adbHandler);
    }

    public InsertEntryCommand$Result getResult() {
        return this.result;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$100(InsertEntryCommand insertEntryCommand, int n) {
        insertEntryCommand.signalResult(n);
    }
}

