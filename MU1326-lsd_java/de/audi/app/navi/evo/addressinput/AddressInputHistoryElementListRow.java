/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
import de.audi.tghu.navi.app.addressinput.AbstractAddressInputHistoryElementListRow;

public class AddressInputHistoryElementListRow
extends AbstractAddressInputHistoryElementListRow {
    public static final int COLUMN_BEAUTIFIED_TEXT;
    public static final int COLUMN_IS_VALID_DEST;
    public static final int COLUMN_IS_TO_REFINE;
    public static final int COLUMN_IS_HISTORY_ELEMENT;
    public static final int COLUMN_PROPERTY;
    public static final int MAX_COLUMNS;
    private CityHistory$HistoryEntry historyEntry;

    public AddressInputHistoryElementListRow(AddressInputHistoryElementListRow addressInputHistoryElementListRow) {
        super(addressInputHistoryElementListRow);
        this.historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
    }

    public AddressInputHistoryElementListRow(CityHistory$HistoryEntry cityHistory$HistoryEntry, long l) {
        super(l, 5);
        this.historyEntry = cityHistory$HistoryEntry;
        this.setText(0, cityHistory$HistoryEntry.getEntryName());
        this.setInteger(1, 0);
        this.setInteger(2, 1);
        this.setInteger(3, 1);
        this.setPropertyCell(4, new PropertyListCell(160082217, new int[0]));
    }

    @Override
    public CityHistory$HistoryEntry getHistoryEntry() {
        return this.historyEntry;
    }

    @Override
    public EvoListRow copy() {
        return new AddressInputHistoryElementListRow(this);
    }
}

