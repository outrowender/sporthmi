/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders.evo;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiIconedListRow
extends LiValueListRow {
    private static final int COLUMN_ICON;
    private static final int COLUMN_CATEGORY_NAME;
    private static final int COLUMN_COUNT;

    public PoiIconedListRow(IconHandler iconHandler, LIValueListElement lIValueListElement, int n) {
        super(n, 2, lIValueListElement);
        int n2 = iconHandler.resolvePOIIconResourceID(lIValueListElement.getIconIndex(), lIValueListElement.getSubIconIndex());
        IconCell iconCell = new IconCell(new HMIResourceLocator(n2));
        this.setIconCell(0, iconCell);
        Buffer buffer = new Buffer(lIValueListElement.data);
        if (Util.isHURegionNAR() && PoiUtil.isPoi24h(lIValueListElement)) {
            buffer.append(" ").append(TextUtil.getPoi24hMarker());
        }
        this.setText(1, buffer.toString());
    }

    protected PoiIconedListRow(PoiIconedListRow poiIconedListRow) {
        super(poiIconedListRow);
    }

    @Override
    public EvoListRow copy() {
        return new PoiIconedListRow(this);
    }
}

