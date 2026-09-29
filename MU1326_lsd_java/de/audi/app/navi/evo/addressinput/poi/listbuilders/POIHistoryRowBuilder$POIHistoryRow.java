/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.POIHistoryRowBuilder;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import org.dsi.ifc.navigation.LICityHistoryEntry;

class POIHistoryRowBuilder$POIHistoryRow
extends ListRow {
    private LICityHistoryEntry element;
    private final /* synthetic */ POIHistoryRowBuilder this$0;

    public POIHistoryRowBuilder$POIHistoryRow(POIHistoryRowBuilder pOIHistoryRowBuilder, LICityHistoryEntry lICityHistoryEntry) {
        this.this$0 = pOIHistoryRowBuilder;
        this.element = lICityHistoryEntry;
        ListCell[] listCellArray = new ListCell[]{new TextListCell(lICityHistoryEntry.getName()), new ObjectListCell(lICityHistoryEntry)};
        this.setCells(listCellArray);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof POIHistoryRowBuilder$POIHistoryRow)) {
            return false;
        }
        return ((POIHistoryRowBuilder$POIHistoryRow)object).element.equals(this.element);
    }

    @Override
    public int hashCode() {
        return this.element.hashCode();
    }
}

