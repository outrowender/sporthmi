/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.POIHistoryRowBuilder$POIHistoryRow;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.navi.app.addressinput.poi.modelaccess.IHistoryRowBuilder;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class POIHistoryRowBuilder
implements IHistoryRowBuilder {
    protected static final int COLUMN_CITY_NAME;
    protected static final int COLUMN_HISTORY_ENTRY;
    public static final int COLUMN_COUNT;

    @Override
    public ListCell[] buildListRow(LICityHistoryEntry lICityHistoryEntry) {
        return new POIHistoryRowBuilder$POIHistoryRow(this, lICityHistoryEntry).getCells();
    }

    @Override
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
}

