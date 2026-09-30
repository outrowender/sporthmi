/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.MatchedAddress;

public class AddressSelectionListRow
extends EvoListRow {
    private static final int COLUMN_COUNT = 3;
    private static final int CELL_IDX_ADDRESS_ICON = 0;
    private static final int CELL_IDX_ADDRESS = 1;
    private static final int CELL_IDX_RECORDSET = 2;
    private final MatchedAddress matchedAddress;
    private final int iconId;
    private final int recordset;

    public AddressSelectionListRow(MatchedAddress matchedAddress, int n, long l, boolean bl) {
        super(l, 3);
        this.matchedAddress = matchedAddress;
        this.iconId = n;
        this.recordset = bl ? 1 : 0;
        this.setInteger(0, n);
        this.setText(1, matchedAddress.getAddress());
        this.setInteger(2, this.recordset);
    }

    public MatchedAddress getMatchedAddress() {
        return this.matchedAddress;
    }

    public int getIconId() {
        return this.iconId;
    }

    public EvoListRow copy() {
        return new AddressSelectionListRow(this.matchedAddress, this.iconId, this.getUniqueID(), this.recordset == 1);
    }
}

