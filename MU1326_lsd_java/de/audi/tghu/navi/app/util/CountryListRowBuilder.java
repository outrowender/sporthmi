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
    public static final int COLUMN_NAME = 0;
    public static final int COLUMN_ELEMENT = 1;
    public static final int COLUMN_MAX = 2;

    public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
        return new ListCell[]{new TextListCell(lIValueListElement.getData()), new ObjectListCell(lIValueListElement)};
    }

    public int getMaxColumns() {
        return 2;
    }

    public int getElementIndex() {
        return 1;
    }
}

