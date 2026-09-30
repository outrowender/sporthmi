/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public final class GetEntryForMessageOptionsCommand
extends AbstractADBCommand {
    private long entryId;
    private HMIModelApp syncModel;
    private MessagingAdbHandler adbHandler;
    static /* synthetic */ Class class$de$audi$app$messaging$core$addressbook$GetEntryForMessageOptionsCommand;

    public GetEntryForMessageOptionsCommand(MessagingAdbHandler messagingAdbHandler, long l, HMIModelApp hMIModelApp) {
        super(messagingAdbHandler);
        this.adbHandler = messagingAdbHandler;
        this.syncModel = hMIModelApp;
        this.entryId = l;
    }

    public void execute() {
        this.logger.log(1000000, "GetEntryForMessageOptionsCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetEntryForMessageOptionsCommand#execute(): dsi call was not successful, finishing command.");
            this.signalResult(1, null);
        }
    }

    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(1000000, "GetEntryForMessageOptionsCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.signalResult(n, adbEntryArray);
    }

    public static void schedule(MessagingAdbHandler messagingAdbHandler, long l, HMIModelApp hMIModelApp) {
        hMIModelApp.setStatus(0);
        GetEntryForMessageOptionsCommand getEntryForMessageOptionsCommand = new GetEntryForMessageOptionsCommand(messagingAdbHandler, l, hMIModelApp);
        CommandList commandList = new CommandList(messagingAdbHandler.getCommandListManager());
        commandList.add(getEntryForMessageOptionsCommand);
        commandList.setErrorCommand(getEntryForMessageOptionsCommand.getErrorCommand());
        commandList.execute((class$de$audi$app$messaging$core$addressbook$GetEntryForMessageOptionsCommand == null ? (class$de$audi$app$messaging$core$addressbook$GetEntryForMessageOptionsCommand = GetEntryForMessageOptionsCommand.class$("de.audi.app.messaging.core.addressbook.GetEntryForMessageOptionsCommand")) : class$de$audi$app$messaging$core$addressbook$GetEntryForMessageOptionsCommand).getName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n, AdbEntry[] adbEntryArray) {
        try {
            this.logger.log(10000000, "[GetEntryForMessageOptionsCommand#signalResult] success = %1", (long)n);
            if (n == 0) {
                if (adbEntryArray.length == 1) {
                    this.logger.log(10000000, "GetEntryForMessageOptionsCommand#signalResult(): got entry: %1", (Object)ADBDbgUtils.dbg(adbEntryArray[0]));
                    this.adbHandler.getModelUpdater().updateMessageOptions(adbEntryArray[0]);
                    this.syncModel.setStatus(1);
                } else {
                    this.logger.log(10000, "GetEntryForMessageOptionsCommand#signalResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(this.logger, exception, "[GetEntryCommand#signalResult]");
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    protected Command getErrorCommand() {
        return new AbstractADBCommand(this.adbHandler){

            public void execute() {
                this.logger.log(10000000, "[GetEntryForMessageOptionsCommand#execute]");
                GetEntryForMessageOptionsCommand.this.signalResult(1, null);
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
}

