/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.AbstractGetEntryCommand;
import de.audi.app.addressbook.core.main.tts.AddressBookTTSUtils;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class GetAndReadoutEntryCommand
extends AbstractGetEntryCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$GetAndReadoutEntryCommand;

    public GetAndReadoutEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l) {
        super(abstractAddressBookApplication, l);
    }

    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        this.logger.log(1000000, "GetAndReadoutEntryCommand#handleGetEntryResult(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
        this.appAdr.getTTSHandler().speak(AddressBookTTSUtils.getSSMLMessage(adbEntry.getCombinedName(), this.logger));
        return true;
    }

    public static void createGetAndReadoutEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l) {
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(new GetAndReadoutEntryCommand(abstractAddressBookApplication, l));
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetAndReadoutEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetAndReadoutEntryCommand = GetAndReadoutEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetAndReadoutEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetAndReadoutEntryCommand).getName());
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

