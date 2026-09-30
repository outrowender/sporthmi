/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.search.organizer;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearchListRow;
import de.audi.app.addressbook.core.main.models.EntryDetailsRowSelectionHandler;
import de.audi.app.addressbook.evo.common.search.organizer.ADBEvoOrganizerSearch;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import org.dsi.ifc.organizer.DataSet;

public class AddressBookEvoOrganizerSearch
extends ADBEvoOrganizerSearch {
    private final AddressBookEvoApplication appAdr;

    public AddressBookEvoOrganizerSearch(AddressBookEvoApplication addressBookEvoApplication) {
        super(addressBookEvoApplication.getFramework().getHmiServiceApp().getTiledListModel(700594), addressBookEvoApplication.getFramework().getHmiServiceApp().getMatchSpellerModel(700510), addressBookEvoApplication.getFramework().getHmiServiceApp().getResourceLocatorModel(700508), addressBookEvoApplication.getListSyncModel(), addressBookEvoApplication, addressBookEvoApplication.getLog(), 692197399);
        this.appAdr = addressBookEvoApplication;
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow == null) {
            this.log.log(1000000, "AddressBookEvoOrganizerSearch#itemFocused(): row is null");
            return;
        }
        if (evoListRow instanceof ADBEntryDetailsListRow) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
            this.log.log(1000000, "AddressBookEvoOrganizerSearch#itemFocused(): index: %1, entryId: %2", (long)n2, aDBEntryDetailsListRow.getEntry().getEntryId());
            EntryDetailsRowSelectionHandler.entryDetailsRowFocused(this.appAdr, aDBEntryDetailsListRow);
        } else {
            EntryDetailsRowSelectionHandler.entryDetailsRowDefocused(this.appAdr);
            this.checkIfFocusedEntryHasValidData(evoListRow);
        }
        super.itemFocused(evoListRow, n, n2, n3, n4);
    }

    public void keyTyped(int n, int n2, int n3) {
        EvoListRow evoListRow;
        this.log.log(1000000, "AddressBookEvoOrganizerSearch#keyTyped(): modelID: %1", (long)n);
        if (this.getListLength() == 1 && (evoListRow = this.getRow(0)) != null) {
            this.itemSelected(evoListRow, 700594, 0, 0, n3);
            this.appAdr.getHMIService().getMenuModel(700509).setFocusedItem(700594, FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
        }
    }

    private void checkIfFocusedEntryHasValidData(EvoListRow evoListRow) {
        DataSet dataSet;
        this.log.log(10000000, "AddressBookEvoOrganizerSearch#checkIfFocusedEntryHasValidData()");
        if (evoListRow instanceof ADBOrganizerSearchListRow && (dataSet = ((ADBOrganizerSearchListRow)evoListRow).getDataSet()) != null) {
            int n = ADBUtils.hasRelevantData(dataSet, this.appAdr.getAdbMode()) ? 1 : 0;
            this.log.log(10000000, "AddressBookEvoOrganizerSearch#checkIfFocusedEntryHasValidData() %1", (long)n);
            this.appAdr.getHMIService().getChoiceModel(700597).setValue(n);
        }
    }
}

