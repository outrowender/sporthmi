/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.search;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.main.commands.edit.AbstractGetEntryCommand;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.app.addressbook.evo.main.models.EntryDetailsListRowBuilder;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class SetListDetailsCommand
extends AbstractGetEntryCommand {
    private int adbMode;
    private EntryDetailsListRowBuilder rowBuilder;
    private ADBSearchListRow selectedRow;
    private ADBSearch adbSearch;
    static /* synthetic */ Class class$de$audi$app$addressbook$evo$main$search$SetListDetailsCommand;

    public SetListDetailsCommand(AddressBookEvoApplication addressBookEvoApplication, long l, int n, ADBSearchListRow aDBSearchListRow, ADBSearch aDBSearch) {
        super(addressBookEvoApplication, l);
        this.adbMode = n;
        this.rowBuilder = new EntryDetailsListRowBuilder(addressBookEvoApplication);
        this.selectedRow = aDBSearchListRow;
        this.adbSearch = aDBSearch;
    }

    @Override
    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        if (adbEntry == null) {
            this.logger.log(10000, "SetListDetailsCommand#handleGetEntryResult(): entry is null");
            return false;
        }
        this.logger.log(1078071040, "SetListDetailsCommand#handleGetEntryResult(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
        ADBEntryDetailsListRow[] aDBEntryDetailsListRowArray = null;
        switch (this.adbMode) {
            case 0: {
                aDBEntryDetailsListRowArray = EntryDetailsListRowBuilder.getTelDetailsRows(adbEntry, this.rowBuilder);
                break;
            }
            case 1: {
                aDBEntryDetailsListRowArray = EntryDetailsListRowBuilder.getAddressDetailsRows(adbEntry, this.rowBuilder);
                break;
            }
            case 2: {
                aDBEntryDetailsListRowArray = EntryDetailsListRowBuilder.getEmailDetailsRows(adbEntry, this.rowBuilder);
                break;
            }
            default: {
                this.logger.log(10000, "SetListDetailsCommand#handleGetEntryResult(): unknown adbMode: %1", (long)this.adbMode);
                return false;
            }
        }
        this.adbSearch.setSearchResultDetails(aDBEntryDetailsListRowArray, this.selectedRow);
        return true;
    }

    public static void createSetListDetailsCommand(AddressBookEvoApplication addressBookEvoApplication, long l, int n, ADBSearchListRow aDBSearchListRow, ADBSearch aDBSearch) {
        CommandList commandList = new CommandList(addressBookEvoApplication.getCommandListManager());
        commandList.add(new SetListDetailsCommand(addressBookEvoApplication, l, n, aDBSearchListRow, aDBSearch));
        commandList.execute((class$de$audi$app$addressbook$evo$main$search$SetListDetailsCommand == null ? (class$de$audi$app$addressbook$evo$main$search$SetListDetailsCommand = SetListDetailsCommand.class$("de.audi.app.addressbook.evo.main.search.SetListDetailsCommand")) : class$de$audi$app$addressbook$evo$main$search$SetListDetailsCommand).getName());
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

