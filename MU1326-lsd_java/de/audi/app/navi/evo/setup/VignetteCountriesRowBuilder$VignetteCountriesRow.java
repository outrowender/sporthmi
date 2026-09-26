/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.setup;

import de.audi.app.navi.evo.setup.VignetteCountriesRowBuilder;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import org.dsi.ifc.navigation.LIValueListElement;

class VignetteCountriesRowBuilder$VignetteCountriesRow
extends ListRow {
    private int index;
    private final /* synthetic */ VignetteCountriesRowBuilder this$0;

    public VignetteCountriesRowBuilder$VignetteCountriesRow(VignetteCountriesRowBuilder vignetteCountriesRowBuilder, LIValueListElement lIValueListElement, boolean bl, int n) {
        this.this$0 = vignetteCountriesRowBuilder;
        this.index = n;
        if (lIValueListElement == null) {
            return;
        }
        ListCell[] listCellArray = new ListCell[3];
        listCellArray[0] = new TextListCell(lIValueListElement.getData());
        int n2 = bl ? 1 : 0;
        listCellArray[1] = IntegerListCell.create(n2);
        listCellArray[2] = new ObjectListCell(lIValueListElement);
        this.setCells(listCellArray);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof VignetteCountriesRowBuilder$VignetteCountriesRow)) {
            return false;
        }
        int n = ((VignetteCountriesRowBuilder$VignetteCountriesRow)object).index;
        return n == this.index;
    }

    @Override
    public int hashCode() {
        return this.index;
    }
}

