/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.setup;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IListRowBuilder;
import org.dsi.ifc.navigation.LIValueListElement;

public class VignetteCountriesRowBuilder
implements IListRowBuilder {
    public static final int COLUMN_NAME = 0;
    public static final int COLUMN_CHECKED = 1;
    public static final int COLUMN_ELEMENT = 2;
    public static final int COLUMN_COUNT = 3;
    private static final int CHECKBOX_OFF = 0;
    private static final int CHECKBOX_ON = 1;

    public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
        return new VignetteCountriesRow(lIValueListElement, false, n).getCells();
    }

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

    public EvoListRow buildEvoListRow(LIValueListElement lIValueListElement, int n) {
        return null;
    }

    private class VignetteCountriesRow
    extends ListRow {
        private int index;

        public VignetteCountriesRow(LIValueListElement lIValueListElement, boolean bl, int n) {
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

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof VignetteCountriesRow)) {
                return false;
            }
            int n = ((VignetteCountriesRow)object).index;
            return n == this.index;
        }

        public int hashCode() {
            return this.index;
        }
    }
}

