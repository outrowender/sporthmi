/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class RemoteHmiCityHistoryListRow
extends EvoListRow {
    private static final int COLUMN_ID = 0;
    private static final int COLUMN_NAME = 1;
    private static final int COLUMN_COUNT = 2;
    private LICityHistoryEntry entry;

    public RemoteHmiCityHistoryListRow(LICityHistoryEntry lICityHistoryEntry) {
        super(lICityHistoryEntry.getId(), 2);
        this.entry = lICityHistoryEntry;
        this.setInteger(0, (int)lICityHistoryEntry.getId());
        this.setText(1, lICityHistoryEntry.getName());
    }

    public RemoteHmiCityHistoryListRow(RemoteHmiCityHistoryListRow remoteHmiCityHistoryListRow) {
        super(remoteHmiCityHistoryListRow);
        this.entry = remoteHmiCityHistoryListRow.entry;
    }

    public LICityHistoryEntry getHistoryElement() {
        return this.entry;
    }

    public EvoListRow copy() {
        return new RemoteHmiCityHistoryListRow(this);
    }
}

