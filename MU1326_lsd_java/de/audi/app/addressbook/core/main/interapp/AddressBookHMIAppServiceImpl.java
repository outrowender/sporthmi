/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.interapp;

import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.GetEntryCommand;
import de.audi.app.addressbook.core.main.commands.edit.GetSpeedDialEntryCommand;
import de.audi.app.addressbook.core.main.commands.edit.InsertEntryCommand;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.app.addressbook.core.vcardexchange.commands.ParseVCardCommand;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;

public class AddressBookHMIAppServiceImpl
implements ADBHMIAppService {
    private AbstractAddressBookApplication appAdr;
    private LogChannel log;

    public AddressBookHMIAppServiceImpl(AbstractAddressBookApplication abstractAddressBookApplication, LogChannel logChannel) {
        this.appAdr = abstractAddressBookApplication;
        this.log = logChannel;
    }

    @Override
    public void showEntryDetails(long l, int n) {
        this.log.log(1078071040, "AddressBookHMIAppServiceImpl#showEntryDetails(): entryId: %1, context: %2", l, (long)n);
        this.setAdbModeFromCallingContext(n);
        GetEntryCommand.createGetEntryCommand(this.appAdr, l);
    }

    @Override
    public void showSpeedDialEntryDetails(long l, int n) {
        this.log.log(1078071040, "AddressBookHMIAppServiceImpl#showSpeedDialEntryDetails(): entryId: %1, context: %2", l, (long)n);
        this.setAdbModeFromCallingContext(n);
        GetSpeedDialEntryCommand.createGetSpeedDialEntryCommand(this.appAdr, l);
    }

    @Override
    public void showEntryDetails(AdbEntry adbEntry, int n) {
        this.log.log(1078071040, "AddressBookHMIAppServiceImpl#showEntryDetails(): entry: %1", (Object)adbEntry);
        this.setAdbModeFromCallingContext(n);
        this.appAdr.setCurrentEntry(adbEntry);
        this.appAdr.setFocusedEntryId(adbEntry.entryId);
        this.appAdr.setFocusedEntryType(adbEntry.entryType);
        this.appAdr.getSelectedEntryDetails().updateEntryDetails(adbEntry);
    }

    private void setAdbModeFromCallingContext(int n) {
        switch (n) {
            case 0: {
                this.appAdr.setAdbMode(0);
                break;
            }
            case 1: {
                this.appAdr.setAdbMode(1);
                break;
            }
            case 2: {
                this.appAdr.setAdbMode(2);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookHMIAppServiceImpl#setAdbModeFromCallingContext(): unknown context: %1", (long)n);
            }
        }
    }

    @Override
    public void requestParseVCards(String string, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
        this.log.log(-2137614336, "AddressBookHMIAppServiceImpl#requestParseVCards(): fullPathToVCards: %1", (Object)string);
        VCardExchangeADBHandler vCardExchangeADBHandler = this.appAdr.getVCardExchangeADBHandler();
        ParseVCardCommand.createParseVCardCommand(vCardExchangeADBHandler, string, aDBHMIAppServiceListener);
    }

    @Override
    public void requestInsertEntry(AdbEntry adbEntry, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
        this.log.log(1078071040, "AddressBookHMIAppServiceImpl#requestInsertEntry(): adbEntry: %1", (Object)adbEntry);
        InsertEntryCommand.createInsertEntryCommand(this.appAdr, adbEntry, aDBHMIAppServiceListener);
    }
}

