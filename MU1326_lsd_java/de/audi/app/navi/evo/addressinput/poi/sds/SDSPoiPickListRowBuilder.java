/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.sds;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.addressinput.poi.sds.ISDSListRowBuilder;

public class SDSPoiPickListRowBuilder
implements ISDSListRowBuilder {
    private static final int COLUMN_POI_NAME = 0;
    private static final int COLUMN_ELEMENT = 1;
    private static final int COLUMN_COUNT = 2;

    public ListCell[] buildListRow(long l, String string, int n) {
        return new SDSPoiPickListRow(l, string, n).getCells();
    }

    public EvoListRow buildEvoListRow(long l, String string, int n) {
        return new SDSPoiPickEvoListRow(l, string, n);
    }

    public int getColumnCount() {
        return 2;
    }

    public static int getPoiId(ListCell[] listCellArray) {
        IntegerListCell integerListCell = (IntegerListCell)listCellArray[1];
        return integerListCell.getValue();
    }

    public static long getPoiId(EvoListRow evoListRow) {
        return evoListRow.getLong(1);
    }

    public static String getPoiCategoryName(ListCell[] listCellArray) {
        TextListCell textListCell = (TextListCell)listCellArray[0];
        return textListCell.getText();
    }

    public static String getPoiCategoryName(EvoListRow evoListRow) {
        return (String)evoListRow.getCell(0);
    }

    private class SDSPoiPickListRow
    extends ListRow {
        private int index;

        public SDSPoiPickListRow(long l, String string, int n) {
            this.index = n;
            ListCell[] listCellArray = new ListCell[]{new TextListCell(string), new LongListCell(l)};
            this.setCells(listCellArray);
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof SDSPoiPickListRow)) {
                return false;
            }
            int n = ((SDSPoiPickListRow)object).index;
            return n == this.index;
        }

        public int hashCode() {
            return this.index;
        }
    }

    private class SDSPoiPickEvoListRow
    extends EvoListRow {
        private int index;
        private String entryName;
        private long entryID;

        public SDSPoiPickEvoListRow(long l, String string, int n) {
            super(l, 2);
            this.index = n;
            this.entryName = string;
            this.entryID = l;
            this.setText(0, string);
            this.setLong(1, l);
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof SDSPoiPickEvoListRow)) {
                return false;
            }
            int n = ((SDSPoiPickEvoListRow)object).index;
            return n == this.index;
        }

        public int hashCode() {
            return this.index;
        }

        public EvoListRow copy() {
            return new SDSPoiPickEvoListRow(this.entryID, this.entryName, this.index);
        }
    }
}

