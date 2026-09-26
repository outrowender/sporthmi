/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.details;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.details.IStackDetailsRowBuilder;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiStackListRow
extends LiValueListRow
implements IStackDetailsRowBuilder {
    private static final int COLUMN_ICON;
    public static final int COLUMN_TEXT;
    private static final int COLUMN_LAYOUT;
    private static final int COLUMN_PROPERTIES;
    private static final int COLUMN_COUNT;

    public PoiStackListRow(IconHandler iconHandler, LIValueListElement lIValueListElement, int n) {
        super(n, 4, lIValueListElement);
        int n2 = iconHandler.resolvePOIIconResourceID(lIValueListElement.getIconIndex(), lIValueListElement.getSubIconIndex());
        IconCell iconCell = new IconCell(new HMIResourceLocator(n2));
        this.setIconCell(0, iconCell);
        PropertyListCell propertyListCell = PropertyListCell.create(1308021667, new int[0]);
        this.setPropertyCell(3, propertyListCell);
        Buffer buffer = new Buffer(lIValueListElement.data);
        if (Util.isHURegionNAR() && PoiUtil.isPoi24h(lIValueListElement)) {
            buffer.append(" ").append(TextUtil.getPoi24hMarker());
        }
        this.setText(1, buffer.toString());
        this.setInteger(2, 1);
    }

    protected PoiStackListRow(PoiStackListRow poiStackListRow) {
        super(poiStackListRow);
    }

    @Override
    public EvoListRow copy() {
        return new PoiStackListRow(this);
    }
}

