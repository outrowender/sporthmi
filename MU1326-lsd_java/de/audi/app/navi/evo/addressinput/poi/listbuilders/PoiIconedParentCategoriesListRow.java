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
    protected static final int PARENT_LAYOUT;
    protected static final int CATEGORIES_LAYOUT;
    public static final int COLUMN_LAYOUT;
    public static final int COLUMN_ICON;
    public static final int COLUMN_CATEGORY_NAME;
    public static final int COLUMN_IS_PARENT;
    public static final int COLUMN_PROPERTY;
    public static final int COLUMN_DIRECTION;
    public static final int COLUMN_DISTANCE;
    public static final int COLUMN_COUNT;
    protected static final int IS_PARENT;
    protected static final int IS_CHILD;

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

    @Override
    public EvoListRow copy() {
        return new PoiIconedParentCategoriesListRow(this);
    }
}

