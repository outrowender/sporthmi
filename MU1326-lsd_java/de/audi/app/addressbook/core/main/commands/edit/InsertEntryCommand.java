/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class InsertEntryCommand
extends AbstractADBCommand {
    private AdbEntry adbEntry;
    private ADBHMIAppServiceListener serviceListener;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand;

    public InsertEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
        super(abstractAddressBookApplication);
        this.adbEntry = adbEntry;
        this.serviceListener = aDBHMIAppServiceListener;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "InsertEntryCommand#execute()");
        boolean bl = this.adbDSIAccess.insertEntry(this.adbEntry, 0);
        if (!bl) {
            this.logger.log(10000, "InsertEntryCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void insertEntryResult(int n, AdbEntry adbEntry) {
        this.logger.log(-2137614336, "InsertEntryCommand#insertEntryResult(): adbEntry: %1, success: %2", (Object)adbEntry, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        try {
            this.serviceListener.responseInsertEntry(n);
        }
        catch (Exception exception) {
            this.logger.log(10000, "InsertEntryCommand#insertEntryResult(): ex: ", (Throwable)exception);
        }
        this.commandList.commandFinished();
    }

    public static void createInsertEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
        InsertEntryCommand insertEntryCommand = new InsertEntryCommand(abstractAddressBookApplication, adbEntry, aDBHMIAppServiceListener);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(insertEntryCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand = InsertEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.SaveEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand).getName());
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

