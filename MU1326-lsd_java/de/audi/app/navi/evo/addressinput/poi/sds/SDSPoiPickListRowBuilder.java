/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.sds;

import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow;
import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiPickListRowBuilder$SDSPoiPickListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.addressinput.poi.sds.ISDSListRowBuilder;

public class SDSPoiPickListRowBuilder
implements ISDSListRowBuilder {
    private static final int COLUMN_POI_NAME;
    private static final int COLUMN_ELEMENT;
    private static final int COLUMN_COUNT;

    public ListCell[] buildListRow(long l, String string, int n) {
        return new SDSPoiPickListRowBuilder$SDSPoiPickListRow(this, l, string, n).getCells();
    }

    @Override
    public EvoListRow buildEvoListRow(long l, String string, int n) {
        return new SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow(this, l, string, n);
    }

    @Override
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
}

