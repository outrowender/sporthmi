/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiNameListRow
extends LiValueListRow {
    private static final int COLUMN_CLASS_NAME;
    private static final int COLUMN_COUNT;

    public PoiNameListRow(LIValueListElement lIValueListElement, int n) {
        super(n, 1, lIValueListElement);
        this.setText(0, lIValueListElement.data);
    }

    protected PoiNameListRow(PoiNameListRow poiNameListRow) {
        super(poiNameListRow);
    }

    @Override
    public EvoListRow copy() {
        return new PoiNameListRow(this);
    }
}

