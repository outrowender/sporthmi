/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.i18n.I18NString;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TextListCell;

public final class MediaListTooltipRow
extends ListRow {
    private static final int MAX_COLS = 4;
    private static final int COL_RECORDSET = 0;
    private static final int COL_TITLE = 1;
    private static final int COL_TITLE_I18N = 2;
    private static final int COL_ERROR_TYPE = 3;
    private static final int RECORDSET_TITLE = 0;
    private static final int RECORDSET_TITLE_I18N = 1;
    private static final int RECORDSET_ERROR_TYPE = 2;

    private MediaListTooltipRow() {
    }

    public static int getMaxColumns() {
        return 4;
    }

    public static MediaListTooltipRow createTracknameRow(I18NString i18NString) {
        MediaListTooltipRow mediaListTooltipRow = new MediaListTooltipRow();
        ListCell[] listCellArray = new ListCell[4];
        if (i18NString != null) {
            if (i18NString.isInternationalized()) {
                listCellArray[0] = IntegerListCell.create(1);
                listCellArray[1] = new TextListCell(i18NString.getI18NString());
                listCellArray[2] = IntegerListCell.create(i18NString.getI18NKey());
            } else {
                listCellArray[0] = IntegerListCell.create(0);
                listCellArray[1] = new TextListCell(i18NString.getI18NString());
                listCellArray[2] = IntegerListCell.create(0);
            }
        } else {
            listCellArray[0] = IntegerListCell.create(0);
            listCellArray[1] = new TextListCell("");
            listCellArray[2] = IntegerListCell.create(0);
        }
        listCellArray[3] = IntegerListCell.create(0);
        mediaListTooltipRow.setCells(listCellArray);
        return mediaListTooltipRow;
    }

    public static MediaListTooltipRow createErrorTypeRow(int n) {
        MediaListTooltipRow mediaListTooltipRow = new MediaListTooltipRow();
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(2), new TextListCell(""), IntegerListCell.create(0), IntegerListCell.create(n)};
        mediaListTooltipRow.setCells(listCellArray);
        return mediaListTooltipRow;
    }

    public static MediaListTooltipRow createRow() {
        MediaListTooltipRow mediaListTooltipRow = new MediaListTooltipRow();
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(0), new TextListCell(""), IntegerListCell.create(0), IntegerListCell.create(0)};
        mediaListTooltipRow.setCells(listCellArray);
        return mediaListTooltipRow;
    }

    public boolean equals(Object object) {
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

