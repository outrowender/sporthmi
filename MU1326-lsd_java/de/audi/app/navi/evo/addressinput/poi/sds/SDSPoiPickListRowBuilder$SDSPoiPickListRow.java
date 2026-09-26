/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.sds;

import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiPickListRowBuilder;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;

class SDSPoiPickListRowBuilder$SDSPoiPickListRow
extends ListRow {
    private int index;
    private final /* synthetic */ SDSPoiPickListRowBuilder this$0;

    public SDSPoiPickListRowBuilder$SDSPoiPickListRow(SDSPoiPickListRowBuilder sDSPoiPickListRowBuilder, long l, String string, int n) {
        this.this$0 = sDSPoiPickListRowBuilder;
        this.index = n;
        ListCell[] listCellArray = new ListCell[]{new TextListCell(string), new LongListCell(l)};
        this.setCells(listCellArray);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof SDSPoiPickListRowBuilder$SDSPoiPickListRow)) {
            return false;
        }
        int n = ((SDSPoiPickListRowBuilder$SDSPoiPickListRow)object).index;
        return n == this.index;
    }

    @Override
    public int hashCode() {
        return this.index;
    }
}

