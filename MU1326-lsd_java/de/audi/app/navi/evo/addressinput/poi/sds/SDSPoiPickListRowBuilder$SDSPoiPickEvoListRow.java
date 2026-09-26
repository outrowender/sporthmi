/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.sds;

import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiPickListRowBuilder;
import de.audi.atip.hmi.model.list.EvoListRow;

class SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow
extends EvoListRow {
    private int index;
    private String entryName;
    private long entryID;
    private final /* synthetic */ SDSPoiPickListRowBuilder this$0;

    public SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow(SDSPoiPickListRowBuilder sDSPoiPickListRowBuilder, long l, String string, int n) {
        this.this$0 = sDSPoiPickListRowBuilder;
        super(l, 2);
        this.index = n;
        this.entryName = string;
        this.entryID = l;
        this.setText(0, string);
        this.setLong(1, l);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow)) {
            return false;
        }
        int n = ((SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow)object).index;
        return n == this.index;
    }

    @Override
    public int hashCode() {
        return this.index;
    }

    @Override
    public EvoListRow copy() {
        return new SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow(this.this$0, this.entryID, this.entryName, this.index);
    }
}

