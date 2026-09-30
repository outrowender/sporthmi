/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.main.AddressBookDSIDefaultListener;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.atip.log.LogChannel;

public class AddressBookEvoDSIDefaultListener
extends AddressBookDSIDefaultListener {
    private AddressBookEvoApplication appAdr;

    public AddressBookEvoDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, AddressBookEvoApplication addressBookEvoApplication) {
        super(logChannel, aDBStartupHandler, addressBookEvoApplication);
        this.appAdr = addressBookEvoApplication;
    }

    public void updateContextSpecificVisibility(boolean bl, int n) {
        this.log.log(ADBDbgUtils.getLLInfo(n), "AddressBookEvoDSIDefaultListener#updateContextSpecificVisibility(): showOnlyUsableContacts: %1, validFlag: %2", bl, (Object)ADBDbgUtils.dbgValidFlag(n));
        if (n == 1) {
            this.appAdr.getADBOrganizerSearch().enableFiltering(bl);
            this.appAdr.getADBOrganizerSearch().startSearch();
            ADBSearch aDBSearch = this.appAdr.getADBTrufflesSearch();
            if (aDBSearch != null) {
                this.appAdr.getADBTrufflesSearch().enableFiltering(bl);
                this.appAdr.getADBTrufflesSearch().startSearch();
            }
            this.appAdr.getHMIService().getChoiceModel(700507).setValue(bl ? 1 : 0);
        }
    }
}

