/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.commands;

import de.audi.app.addressbook.core.main.commands.edit.AbstractGetEntryCommand;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class CreateTelFavoriteCommand
extends AbstractGetEntryCommand {
    private AddressBookEvoApplication appAdr;
    public static final int PHONE_DATA_INDEX_NONE = -1;
    private int phoneDataIndex;
    static /* synthetic */ Class class$de$audi$app$addressbook$evo$main$commands$CreateTelFavoriteCommand;

    public CreateTelFavoriteCommand(AddressBookEvoApplication addressBookEvoApplication, long l, int n) {
        super(addressBookEvoApplication, l);
        this.appAdr = addressBookEvoApplication;
        this.phoneDataIndex = n;
    }

    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        if (adbEntry != null) {
            if (this.phoneDataIndex != -1 && adbEntry.phoneData[this.phoneDataIndex] != null) {
                String string = adbEntry.phoneData[this.phoneDataIndex].number;
                int n = adbEntry.phoneData[this.phoneDataIndex].numberType;
                this.appAdr.getPhoneGateway().addToFavorites(new TelFavoriteStruct(adbEntry.getCombinedName(), string, n));
            }
            return true;
        }
        return false;
    }

    public static void createCreateTelFavoriteCommand(AddressBookEvoApplication addressBookEvoApplication, long l, int n) {
        CommandList commandList = new CommandList(addressBookEvoApplication.getCommandListManager());
        commandList.add(new CreateTelFavoriteCommand(addressBookEvoApplication, l, n));
        commandList.execute((class$de$audi$app$addressbook$evo$main$commands$CreateTelFavoriteCommand == null ? (class$de$audi$app$addressbook$evo$main$commands$CreateTelFavoriteCommand = CreateTelFavoriteCommand.class$("de.audi.app.addressbook.evo.main.commands.CreateTelFavoriteCommand")) : class$de$audi$app$addressbook$evo$main$commands$CreateTelFavoriteCommand).getName());
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

