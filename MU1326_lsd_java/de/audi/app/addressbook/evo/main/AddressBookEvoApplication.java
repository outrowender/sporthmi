/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.models.AddressBookEntryDetails;
import de.audi.app.addressbook.core.main.models.EntryDetailsRowSelectionHandler;
import de.audi.app.addressbook.evo.common.ADBEvoApplication;
import de.audi.app.addressbook.evo.main.AddressBookEvoDSIDefaultListener;
import de.audi.app.addressbook.evo.main.models.AddressBookEvoViewListener;
import de.audi.app.addressbook.evo.main.models.EntryDetailsListRowBuilder;
import de.audi.app.addressbook.evo.main.search.SetListDetailsCommand;
import de.audi.app.addressbook.evo.main.search.organizer.AddressBookEvoOrganizerSearch;
import de.audi.app.addressbook.evo.main.search.truffles.AddressBookEvoTruffleSearch;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public class AddressBookEvoApplication
extends AbstractAddressBookApplication
implements ADBEvoApplication {
    private ADBOrganizerSearch adbOrganizerSearch;
    private ADBSearch adbTrufflesSearch;
    private AddressBookEntryDetails entryDetails;

    public AddressBookEvoApplication(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        new AddressBookEvoViewListener(this, this.log);
        this.entryDetails = new AddressBookEntryDetails(this, new EntryDetailsListRowBuilder(this), this.log, this.getHMIService().getBaseListModel(700527), this.getHMIService().getBaseListModel(700525), this.getHMIService().getBaseListModel(700526));
    }

    public void init(BundleContext bundleContext) {
        LogChannel logChannel = this.framework.getLogChannel("App.AddressBook.Main.Search");
        this.adbOrganizerSearch = new AddressBookEvoOrganizerSearch(this);
        this.adbOrganizerSearch.init();
        if (this.framework.getSysConst(4249) == 1) {
            this.adbTrufflesSearch = new AddressBookEvoTruffleSearch(bundleContext, this, logChannel, 5);
            this.adbTrufflesSearch.init();
        }
    }

    public void deinit(BundleContext bundleContext) {
        this.adbOrganizerSearch.deinit(bundleContext);
        if (this.framework.getSysConst(4249) == 1) {
            this.adbTrufflesSearch.deinit(bundleContext);
        }
    }

    protected ADBDSIDefaultListener getNewADBDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, ADBApplication aDBApplication) {
        return new AddressBookEvoDSIDefaultListener(logChannel, aDBStartupHandler, this);
    }

    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
        this.log.log(1000000, "AddressBookEvoApplication#entrySelected(): \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
        SetListDetailsCommand.createSetListDetailsCommand(this, aDBSearchListRow.getEntryId(), this.getAdbMode(), aDBSearchListRow, aDBSearch);
    }

    public void detailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
        this.log.log(1000000, "AddressBookEvoApplication#detailsSelected(): \"%1\", entryId: %2", (Object)aDBEntryDetailsListRow.getCombinedName(), aDBEntryDetailsListRow.getEntryId());
        boolean bl = EntryDetailsRowSelectionHandler.entryDetailsRowSelected(this, aDBEntryDetailsListRow);
        if (bl) {
            this.getFramework().getHmiServiceApp().getModelApp(n).fireEvent(n2);
        }
    }

    public AddressBookEntryDetails getSelectedEntryDetails() {
        return this.entryDetails;
    }

    public ADBOrganizerSearch getADBOrganizerSearch() {
        return this.adbOrganizerSearch;
    }

    public ADBSearch getADBTrufflesSearch() {
        return this.adbTrufflesSearch;
    }

    public void loadMainList(int n) {
        this.log.log(1000000, "AddressBookEvoApplication#loadMainList(): adbMode: %1", (Object)ADBDbgUtils.dbgAdbMode(n));
        this.setAdbMode(n);
        this.adbOrganizerSearch.enableFiltering(this.framework.getHmiServiceApp().getChoiceModel(700507).getValue() != 0);
        this.adbOrganizerSearch.startSearch();
        if (this.adbTrufflesSearch != null) {
            this.adbTrufflesSearch.enableFiltering(this.framework.getHmiServiceApp().getChoiceModel(700507).getValue() != 0);
            this.adbTrufflesSearch.startSearch();
        }
        if (n == 2) {
            this.getHMIService().getChoiceModel(3995).setValue(0);
        }
    }
}

