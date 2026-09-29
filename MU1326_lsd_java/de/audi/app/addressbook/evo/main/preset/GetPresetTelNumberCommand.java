/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.preset;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.evo.main.preset.AddressBookEvoPresetHandler;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class GetPresetTelNumberCommand
extends AbstractADBCommand {
    protected AddressBookEvoPresetHandler presetHandler;
    protected long entryId;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand;

    public GetPresetTelNumberCommand(AddressBookEvoPresetHandler addressBookEvoPresetHandler, long l) {
        super(addressBookEvoPresetHandler.getAppAdr());
        this.presetHandler = addressBookEvoPresetHandler;
        this.entryId = l;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "GetPresetTelNumberCommand#execute(): entryId: %1", this.entryId);
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetPresetTelNumberCommand#execute(): dsi call was not successful, finishing command.");
            this.presetHandler.setPresetTelNumberData(null);
            this.commandList.commandFinished();
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(-2137614336, "GetPresetTelNumberCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0 && adbEntryArray != null && adbEntryArray.length == 1 && adbEntryArray[0].phoneData != null && adbEntryArray[0].phoneData.length > 0) {
            this.logger.log(1078071040, "GetPresetTelNumberCommand#getEntriesResult(): entryList[0].phoneData[0]: %1", (Object)adbEntryArray[0].phoneData[0]);
            this.presetHandler.setPresetTelNumberData(adbEntryArray[0].phoneData[0]);
        } else {
            this.logger.log(10000, "GetPresetTelNumberCommand#getEntriesResult(): #getEntries() was not successful!");
            this.presetHandler.setPresetTelNumberData(null);
        }
        this.commandList.commandFinished();
    }

    public static void createGetPresetTelNumberCommand(AddressBookEvoPresetHandler addressBookEvoPresetHandler, long l) {
        GetPresetTelNumberCommand getPresetTelNumberCommand = new GetPresetTelNumberCommand(addressBookEvoPresetHandler, l);
        CommandList commandList = new CommandList(addressBookEvoPresetHandler.getAppAdr().getCommandListManager());
        commandList.add(getPresetTelNumberCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand = GetPresetTelNumberCommand.class$("de.audi.app.addressbook.core.main.commands.edit.DeleteEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$DeleteEntryCommand).getName());
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

