/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.setup;

import de.audi.app.navi.evo.setup.VignetteCountriesRowBuilder$VignetteCountriesRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IListRowBuilder;
import org.dsi.ifc.navigation.LIValueListElement;

public class VignetteCountriesRowBuilder
implements IListRowBuilder {
    public static final int COLUMN_NAME;
    public static final int COLUMN_CHECKED;
    public static final int COLUMN_ELEMENT;
    public static final int COLUMN_COUNT;
    private static final int CHECKBOX_OFF;
    private static final int CHECKBOX_ON;

    @Override
    public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
        return new VignetteCountriesRowBuilder$VignetteCountriesRow(this, lIValueListElement, false, n).getCells();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public static LIValueListElement getLiValueListElement(ListCell[] listCellArray) {
        ObjectListCell objectListCell = (ObjectListCell)listCellArray[2];
        return (LIValueListElement)objectListCell.getValue();
    }

    public static boolean isChecked(ListCell[] listCellArray) {
        IntegerListCell integerListCell = (IntegerListCell)listCellArray[1];
        return integerListCell.getValue() == 1;
    }

    @Override
    public EvoListRow buildEvoListRow(LIValueListElement lIValueListElement, int n) {
        return null;
    }
}

