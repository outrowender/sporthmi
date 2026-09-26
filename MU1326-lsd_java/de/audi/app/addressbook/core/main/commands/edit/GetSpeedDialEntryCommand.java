/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.AbstractGetEntryCommand;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class GetSpeedDialEntryCommand
extends AbstractGetEntryCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$GetSpeedDialEntryCommand;

    public GetSpeedDialEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp) {
        super(abstractAddressBookApplication, l, hMIModelApp);
    }

    public GetSpeedDialEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l) {
        super(abstractAddressBookApplication, l);
    }

    @Override
    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        this.logger.log(1078071040, "GetSpeedDialEntryCommand#handleGetEntryResult(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
        return true;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "GetSpeedDialEntryCommand#execute(): entryId: %1, viewtype: SPEED_DIALS", this.entryId);
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 4, 0);
        if (!bl) {
            this.logger.log(10000, "GetSpeedDialEntryCommand#execute(): dsi call was not successful, finishing command and setting syncModel status to ERROR!.");
            this.syncModel.setStatus(2);
            this.commandList.commandFinished();
        }
    }

    public static void createGetSpeedDialEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp) {
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(new GetSpeedDialEntryCommand(abstractAddressBookApplication, l, hMIModelApp));
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetSpeedDialEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetSpeedDialEntryCommand = GetSpeedDialEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetSpeedDialEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetSpeedDialEntryCommand).getName());
    }

    public static void createGetSpeedDialEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l) {
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(new GetSpeedDialEntryCommand(abstractAddressBookApplication, l));
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetSpeedDialEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetSpeedDialEntryCommand = GetSpeedDialEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetSpeedDialEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetSpeedDialEntryCommand).getName());
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

