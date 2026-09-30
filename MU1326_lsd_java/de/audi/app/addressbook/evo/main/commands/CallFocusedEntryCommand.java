/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.commands;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.main.commands.edit.AbstractGetEntryCommand;
import de.audi.app.addressbook.core.main.models.EntryDetailsRowSelectionHandler;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class CallFocusedEntryCommand
extends AbstractGetEntryCommand {
    private AddressBookEvoApplication appAdr;
    static /* synthetic */ Class class$de$audi$app$addressbook$evo$main$commands$CallFocusedEntryCommand;

    public CallFocusedEntryCommand(AddressBookEvoApplication addressBookEvoApplication, long l) {
        super(addressBookEvoApplication, l);
        this.appAdr = addressBookEvoApplication;
    }

    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        BaseListModelApp baseListModelApp = this.appAdr.getSelectedEntryDetails().getTelNumberList();
        if (baseListModelApp.getLength() == 1) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)baseListModelApp.getRow(0);
            return EntryDetailsRowSelectionHandler.entryDetailsRowSelected(this.appAdr, aDBEntryDetailsListRow);
        }
        return true;
    }

    public static void createCallFocusedEntryCommand(AddressBookEvoApplication addressBookEvoApplication, long l) {
        CommandList commandList = new CommandList(addressBookEvoApplication.getCommandListManager());
        commandList.add(new CallFocusedEntryCommand(addressBookEvoApplication, l));
        commandList.execute((class$de$audi$app$addressbook$evo$main$commands$CallFocusedEntryCommand == null ? (class$de$audi$app$addressbook$evo$main$commands$CallFocusedEntryCommand = CallFocusedEntryCommand.class$("de.audi.app.addressbook.evo.main.commands.CallFocusedEntryCommand")) : class$de$audi$app$addressbook$evo$main$commands$CallFocusedEntryCommand).getName());
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

