/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.search.truffles;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchListRow;
import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchUtils;
import de.audi.app.addressbook.core.common.search.truffles.AbstractADBTruffleSearchGuiHandler;
import de.audi.app.addressbook.core.main.models.EntryDetailsRowSelectionHandler;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.app.addressbook.evo.main.search.truffles.AddressBookEvoSearchResultFormatter;
import de.audi.app.addressbook.evo.main.search.truffles.AddressBookEvoTruffleSearch;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class AddressBookEvoTruffleSearchGuiHandler
extends AbstractADBTruffleSearchGuiHandler {
    private final AddressBookEvoApplication appAdr;

    public AddressBookEvoTruffleSearchGuiHandler(LogChannel logChannel, LogChannel logChannel2, AddressBookEvoApplication addressBookEvoApplication, AddressBookEvoTruffleSearch addressBookEvoTruffleSearch) {
        super(logChannel, logChannel2, addressBookEvoApplication, addressBookEvoTruffleSearch, addressBookEvoApplication.getHMIService().getBaseListModel(-1280308736), addressBookEvoApplication.getHMIService().getSpellerModel(-1330640384), addressBookEvoApplication.getHMIService().getChoiceModel(1739590144), addressBookEvoApplication.getHMIService().getResourceLocatorModel(1555040768));
        this.appAdr = addressBookEvoApplication;
        this.registryFormatter.put(new Integer(3), new AddressBookEvoSearchResultFormatter(logChannel, addressBookEvoApplication));
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow == null) {
            this.log.log(10000, "AddressBookEvoTruffleSearchGuiHandler#itemFocused() row is null");
            return;
        }
        if (evoListRow instanceof ADBEntryDetailsListRow) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
            this.log.log(1078071040, "AddressBookEvoTruffleSearchGuiHandler#itemFocused(): index: %1, entryId: %2", (long)n2, aDBEntryDetailsListRow.getEntry().getEntryId());
            EntryDetailsRowSelectionHandler.entryDetailsRowFocused(this.appAdr, aDBEntryDetailsListRow);
        } else {
            EntryDetailsRowSelectionHandler.entryDetailsRowDefocused(this.appAdr);
            this.checkIfFocusedEntryHasValidData(evoListRow);
        }
        super.itemFocused(evoListRow, n, n2, n3, n4);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "AddressBookEvoTruffleSearchGuiHandler#keyTyped(): modelID: %1", (long)n);
        if (this.mdlListSearchResults.getLength() == 1) {
            EvoListRow evoListRow = this.mdlListSearchResults.getRow(0);
            this.itemSelected(evoListRow, this.mdlListSearchResults.getID(), 0, 0, n3);
            this.appAdr.getHMIService().getMenuModel(1571817984).setFocusedItem(-1280308736, FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
        }
        super.keyTyped(n, n2, n3);
    }

    private void checkIfFocusedEntryHasValidData(EvoListRow evoListRow) {
        SearchResult searchResult;
        if (evoListRow instanceof ADBTruffleSearchListRow && (searchResult = ((ADBTruffleSearchListRow)evoListRow).getSearchResult()) != null) {
            int n = ADBTruffleSearchUtils.hasRelevantData(searchResult, this.appAdr.getAdbMode()) ? 1 : 0;
            this.log.log(-2137614336, "AddressBookEvoTruffleSearchGuiHandler#checkIfFocusedEntryHasValidData() %1", (long)n);
            this.appAdr.getHMIService().getChoiceModel(-1246754304).setValue(n);
        }
    }
}

