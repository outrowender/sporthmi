/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange.search.organizer;

import de.audi.app.addressbook.core.common.search.organizer.AbstractADBOrganizerSearch;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.app.addressbook.core.vcardexchange.search.organizer.VCardExchangeOrganizerSearchListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.log.LogChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.organizer.DataSet;

public class VCardExchangeOrganizerSearch
extends AbstractADBOrganizerSearch {
    private final VCardExchangeADBHandler vCardExchangeADBHandler;
    private boolean listModePositive = true;
    private Set selectedEntries = new HashSet();

    public VCardExchangeOrganizerSearch(TiledListModelApp tiledListModelApp, VCardExchangeADBHandler vCardExchangeADBHandler, LogChannel logChannel) {
        super(tiledListModelApp, vCardExchangeADBHandler.getHMIService().getModelApp(700459), vCardExchangeADBHandler, logChannel);
        this.vCardExchangeADBHandler = vCardExchangeADBHandler;
        this.setViewType(6);
    }

    public EvoListRow[] createSearchListRows(DataSet[] dataSetArray) {
        return VCardExchangeOrganizerSearchListRow.createFromDataSets(dataSetArray, this.listModePositive, this.selectedEntries);
    }

    public void toggleEntrySelection(VCardExchangeOrganizerSearchListRow vCardExchangeOrganizerSearchListRow) {
        this.log.log(1000000, "VCardExchangeOrganizerSearch#toggleEntrySelection(): \"%1\", entryId: %2", (Object)vCardExchangeOrganizerSearchListRow.getCombinedName(), vCardExchangeOrganizerSearchListRow.getEntryId());
        this.addRemoveSelectedEntry(vCardExchangeOrganizerSearchListRow.getEntryId());
        vCardExchangeOrganizerSearchListRow.toggleCheckBox();
        this.updateRow(vCardExchangeOrganizerSearchListRow);
    }

    public long[] getSelectedEntries() {
        Set set = this.selectedEntries;
        long[] lArray = new long[set.size()];
        Iterator iterator = set.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            Long l = (Long)iterator.next();
            lArray[n] = l;
            ++n;
        }
        return lArray;
    }

    public int getExportMemoryType() {
        return this.currentViewType;
    }

    public int getListMode() {
        return this.listModePositive ? 0 : 1;
    }

    private void addRemoveSelectedEntry(long l) {
        Set set = this.selectedEntries;
        Long l2 = new Long(l);
        if (set.contains(l2)) {
            set.remove(l2);
        } else {
            set.add(l2);
        }
        this.enableDisableStartButton();
    }

    public void reset() {
        this.listModePositive = true;
        this.selectedEntries.clear();
        this.enableDisableStartButton();
    }

    public void toggleListMode(boolean bl) {
        this.listModePositive = bl;
        this.selectedEntries.clear();
        this.enableDisableStartButton();
        this.refreshFromStart();
    }

    public boolean isExchangeSetEmpty() {
        return this.listModePositive && this.selectedEntries.isEmpty() || !this.listModePositive && this.selectedEntries.size() >= this.getListLength();
    }

    private void enableDisableStartButton() {
        this.vCardExchangeADBHandler.getHMIService().getButtonModel(700461).setStatus(this.isExchangeSetEmpty() ? 0 : 1);
        boolean bl = this.listModePositive && this.selectedEntries.size() == this.getListLength() || !this.listModePositive && this.selectedEntries.isEmpty();
        this.vCardExchangeADBHandler.getHMIService().getChoiceModel(700535).setValue(bl ? 1 : 0);
    }
}

