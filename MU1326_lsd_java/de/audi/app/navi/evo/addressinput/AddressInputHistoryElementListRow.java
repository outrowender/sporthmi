/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.addressinput.AbstractAddressInputHistoryElementListRow;

public class AddressInputHistoryElementListRow
extends AbstractAddressInputHistoryElementListRow {
    public static final int COLUMN_BEAUTIFIED_TEXT = 0;
    public static final int COLUMN_IS_VALID_DEST = 1;
    public static final int COLUMN_IS_TO_REFINE = 2;
    public static final int COLUMN_IS_HISTORY_ELEMENT = 3;
    public static final int COLUMN_PROPERTY = 4;
    public static final int MAX_COLUMNS = 5;
    private CityHistory.HistoryEntry historyEntry;

    public AddressInputHistoryElementListRow(AddressInputHistoryElementListRow addressInputHistoryElementListRow) {
        super(addressInputHistoryElementListRow);
        this.historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
    }

    public AddressInputHistoryElementListRow(CityHistory.HistoryEntry historyEntry, long l) {
        super(l, 5);
        this.historyEntry = historyEntry;
        this.setText(0, historyEntry.getEntryName());
        this.setInteger(1, 0);
        this.setInteger(2, 1);
        this.setInteger(3, 1);
        this.setPropertyCell(4, new PropertyListCell(698976777, new int[0]));
    }

    public CityHistory.HistoryEntry getHistoryEntry() {
        return this.historyEntry;
    }

    public EvoListRow copy() {
        return new AddressInputHistoryElementListRow(this);
    }
}

