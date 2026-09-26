/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.navi.app.util.ListRowBuilder;
import org.dsi.ifc.navigation.LIValueListElement;

public class CountryListRowBuilder
implements ListRowBuilder {
    public static final int COLUMN_NAME;
    public static final int COLUMN_ELEMENT;
    public static final int COLUMN_MAX;

    @Override
    public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
        return new ListCell[]{new TextListCell(lIValueListElement.getData()), new ObjectListCell(lIValueListElement)};
    }

    @Override
    public int getMaxColumns() {
        return 2;
    }

    @Override
    public int getElementIndex() {
        return 1;
    }
}

