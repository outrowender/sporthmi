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

public class NavigateFocusedEntryCommand
extends AbstractGetEntryCommand {
    private AddressBookEvoApplication appAdr;
    static /* synthetic */ Class class$de$audi$app$addressbook$evo$main$commands$NavigateFocusedEntryCommand;

    public NavigateFocusedEntryCommand(AddressBookEvoApplication addressBookEvoApplication, long l) {
        super(addressBookEvoApplication, l);
        this.appAdr = addressBookEvoApplication;
    }

    @Override
    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        BaseListModelApp baseListModelApp = this.appAdr.getSelectedEntryDetails().getAddressList();
        if (baseListModelApp.getLength() == 1) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)baseListModelApp.getRow(0);
            return EntryDetailsRowSelectionHandler.entryDetailsRowSelected(this.appAdr, aDBEntryDetailsListRow);
        }
        return true;
    }

    public static void createNavigateFocusedEntryCommand(AddressBookEvoApplication addressBookEvoApplication, long l) {
        CommandList commandList = new CommandList(addressBookEvoApplication.getCommandListManager());
        commandList.add(new NavigateFocusedEntryCommand(addressBookEvoApplication, l));
        commandList.execute((class$de$audi$app$addressbook$evo$main$commands$NavigateFocusedEntryCommand == null ? (class$de$audi$app$addressbook$evo$main$commands$NavigateFocusedEntryCommand = NavigateFocusedEntryCommand.class$("de.audi.app.addressbook.evo.main.commands.NavigateFocusedEntryCommand")) : class$de$audi$app$addressbook$evo$main$commands$NavigateFocusedEntryCommand).getName());
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

