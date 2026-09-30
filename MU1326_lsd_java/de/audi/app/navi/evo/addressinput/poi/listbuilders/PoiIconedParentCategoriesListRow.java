/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.PosPosition;

public class PoiIconedParentCategoriesListRow
extends LiValueListRow {
    protected static final int PARENT_LAYOUT = 0;
    protected static final int CATEGORIES_LAYOUT = 1;
    public static final int COLUMN_LAYOUT = 0;
    public static final int COLUMN_ICON = 1;
    public static final int COLUMN_CATEGORY_NAME = 2;
    public static final int COLUMN_IS_PARENT = 4;
    public static final int COLUMN_PROPERTY = 5;
    public static final int COLUMN_DIRECTION = 6;
    public static final int COLUMN_DISTANCE = 7;
    public static final int COLUMN_COUNT = 8;
    protected static final int IS_PARENT = 1;
    protected static final int IS_CHILD = 0;

    public PoiIconedParentCategoriesListRow(IconHandler iconHandler, LIValueListElement lIValueListElement, int n, PosPosition posPosition) {
        super(n, 8, lIValueListElement);
        this.setInteger(0, 1);
        this.setInteger(4, 0);
        int n2 = iconHandler.resolvePOIIconResourceID(lIValueListElement.getIconIndex(), lIValueListElement.getSubIconIndex());
        IconCell iconCell = new IconCell(new HMIResourceLocator(n2));
        this.setIconCell(1, iconCell);
        this.setText(2, lIValueListElement.data);
    }

    protected PoiIconedParentCategoriesListRow(PoiIconedParentCategoriesListRow poiIconedParentCategoriesListRow) {
        super(poiIconedParentCategoriesListRow);
    }

    public boolean isParent() {
        int n = this.getInteger(4);
        return 1 == n;
    }

    public EvoListRow copy() {
        return new PoiIconedParentCategoriesListRow(this);
    }
}

