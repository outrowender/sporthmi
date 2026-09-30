/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.navi.app.addressinput.poi.modelaccess.IHistoryRowBuilder;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class POIHistoryRowBuilder
implements IHistoryRowBuilder {
    protected static final int COLUMN_CITY_NAME = 0;
    protected static final int COLUMN_HISTORY_ENTRY = 1;
    public static final int COLUMN_COUNT = 2;

    public ListCell[] buildListRow(LICityHistoryEntry lICityHistoryEntry) {
        return new POIHistoryRow(lICityHistoryEntry).getCells();
    }

    public int getColumnCount() {
        return 2;
    }

    public static LICityHistoryEntry getLiCityHistoryEntry(ListCell[] listCellArray) {
        ObjectListCell objectListCell = (ObjectListCell)listCellArray[1];
        return (LICityHistoryEntry)objectListCell.getValue();
    }

    public static String getCityName(ListCell[] listCellArray) {
        TextListCell textListCell = (TextListCell)listCellArray[0];
        return textListCell.getText();
    }

    private class POIHistoryRow
    extends ListRow {
        private LICityHistoryEntry element;

        public POIHistoryRow(LICityHistoryEntry lICityHistoryEntry) {
            this.element = lICityHistoryEntry;
            ListCell[] listCellArray = new ListCell[]{new TextListCell(lICityHistoryEntry.getName()), new ObjectListCell(lICityHistoryEntry)};
            this.setCells(listCellArray);
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof POIHistoryRow)) {
                return false;
            }
            return ((POIHistoryRow)object).element.equals(this.element);
        }

        public int hashCode() {
            return this.element.hashCode();
        }
    }
}

