/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Times;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TextListCell;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.MessageListEntry;

final class EntryListToolTipRow
extends ListRow {
    static final int COLUMN_COUNT = 5;
    static final int RECORDSET_COUNT = 3;
    static final int RECORDSET_DESCRIPTOR_ROW = 0;
    static final int RECORDSET_TIMESTAMP_ROW = 1;
    static final int RECORDSET_SUBJECT_ROW = 2;
    private static final int CELL_ID_ICON = 0;
    private static final int CELL_ID_DESCRIPTOR = 1;
    private static final int CELL_ID_DATETIME = 2;
    private static final int CELL_ID_SUBJECT = 3;
    private static final int CELL_ID_RECORDSET = 4;

    EntryListToolTipRow(EntryListRow entryListRow, int n, ITextLookup iTextLookup) throws IllegalArgumentException {
        ListCell[] listCellArray = new ListCell[5];
        MessageListEntry messageListEntry = entryListRow.getListEntry().getMessageListEntry();
        switch (n) {
            case 0: {
                listCellArray[0] = IntegerListCell.create(entryListRow.getIconId());
                listCellArray[1] = TextListCell.create(EntryListToolTipRow.getDescriptorCellText(entryListRow, iTextLookup));
                break;
            }
            case 1: {
                long l = messageListEntry.getDateTime();
                Buffer buffer = new Buffer(15);
                buffer.append(Times.formatDate(l));
                buffer.append(' ');
                buffer.append(Times.formatTime(l));
                listCellArray[2] = TextListCell.create(buffer.toString());
                break;
            }
            case 2: {
                String string = messageListEntry.getSubject();
                listCellArray[3] = TextListCell.create(string);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unexpected recordset = " + n);
            }
        }
        listCellArray[4] = IntegerListCell.create(n);
        this.setCells(listCellArray);
    }

    public int getRecordset() {
        return ((IntegerListCell)this.getCell(4)).getValue();
    }

    private static String getDescriptorCellText(EntryListRow entryListRow, ITextLookup iTextLookup) {
        String string = "";
        MessageListEntry messageListEntry = entryListRow.getListEntry().getMessageListEntry();
        if (messageListEntry.getType() == 2) {
            string = MessageContacts.getPrimaryContactInfo(messageListEntry, iTextLookup);
        }
        return string;
    }

    public boolean equals(Object object) {
        boolean bl = false;
        try {
            int n = ((EntryListToolTipRow)object).getRecordset();
            int n2 = this.getRecordset();
            bl = n == n2;
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return this.getRecordset();
    }
}

