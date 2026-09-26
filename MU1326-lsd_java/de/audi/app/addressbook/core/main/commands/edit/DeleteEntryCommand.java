/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;

public class DeleteEntryCommand
extends AbstractADBCommand {
    private AbstractAddressBookApplication appAdr;
    private long entryId;
    private int numDSIResponsesReceived = 0;
    private HMIModelApp syncModel;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand;

    public DeleteEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp) {
        super(abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
        this.entryId = l;
        this.syncModel = hMIModelApp;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "DeleteEntryCommand#execute()");
        boolean bl = this.adbDSIAccess.deleteEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "DeleteEntryCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void deleteEntriesResult(int n) {
        this.logger.log(1078071040, "DeleteEntryCommand#deleteEntriesResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.appAdr.getADBOrganizerSearch().refreshByPosition();
        }
        ++this.numDSIResponsesReceived;
        this.checkCommandFinished();
    }

    @Override
    public void invalidData(int n) {
        this.appAdr.handleInvalidData(n, false);
        ++this.numDSIResponsesReceived;
        this.checkCommandFinished();
    }

    private void checkCommandFinished() {
        if (this.numDSIResponsesReceived == 2) {
            this.logger.log(-2137614336, "DeleteEntryCommand#checkCommandFinished(): finishing command.");
            this.syncModel.setStatus(1);
            this.commandList.commandFinished();
        }
    }

    public static void createDeleteEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp) {
        hMIModelApp.setStatus(0);
        DeleteEntryCommand deleteEntryCommand = new DeleteEntryCommand(abstractAddressBookApplication, l, hMIModelApp);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(deleteEntryCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand = DeleteEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.DeleteEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand).getName());
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

