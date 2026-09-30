/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.search.SearchResult;

public class EntryListRowDataEvo
extends AbstractEntryListRowData {
    public static final int COLUMN_COUNT = 12;
    private static final int CELL_IDX_RECORDSET = 0;
    private static final int CELL_IDX_ENABLED = 1;
    private static final int CELL_IDX_PROPERTIES = 2;
    private static final int CELL_IDX_ICON = 3;
    private static final int CELL_IDX_ENTRY_TYPE = 4;
    private static final int CELL_IDX_FOLDER_NAME = 5;
    private static final int CELL_IDX_UNREAD_MESSAGE_COUNT = 6;
    private static final int CELL_IDX_CONTACT_INFO = 7;
    private static final int CELL_IDX_SUBJECT = 8;
    private static final int CELL_IDX_TIME_PRIMARY = 9;
    private static final int CELL_IDX_TIME_SECONDARY = 10;
    private static final int CELL_IDX_HAS_ATTACHMENT = 11;

    public EntryListRowDataEvo(ListEntry listEntry, IEntryPropertyFactory iEntryPropertyFactory, int n, long l, ITextLookup iTextLookup) {
        super(listEntry, iEntryPropertyFactory, n, l, iTextLookup);
    }

    public int getIconId() {
        return this.getIcon(this.getListEntry());
    }

    public void setColumns(EvoListRow evoListRow, AbstractEntryListRowData abstractEntryListRowData, SearchResult searchResult) {
        ListEntry listEntry = abstractEntryListRowData.getListEntry();
        IEntryPropertyFactory iEntryPropertyFactory = abstractEntryListRowData.getEntryPropertyFactory();
        ITextLookup iTextLookup = abstractEntryListRowData.getTextLookup();
        long l = abstractEntryListRowData.getCurrentTime();
        evoListRow.setInteger(0, this.getRecordSet(listEntry));
        evoListRow.setInteger(1, 1);
        evoListRow.setPropertyCell(2, EntryListRowDataEvo.getProperties(listEntry, iEntryPropertyFactory));
        evoListRow.setInteger(3, this.getIcon(listEntry));
        evoListRow.setInteger(4, this.getEntryType(listEntry));
        evoListRow.setText(5, this.getFolderName(listEntry, iTextLookup));
        evoListRow.setText(6, this.getUnreadMessageCount(listEntry));
        if (searchResult != null) {
            evoListRow.setHighlightTextCell(7, this.getContactInfoHighlighted(searchResult, listEntry, iTextLookup));
            evoListRow.setHighlightTextCell(8, this.getSubjectHighlighted(searchResult, listEntry, iTextLookup));
        } else {
            evoListRow.setText(7, this.getContactInfo(listEntry, iTextLookup));
            evoListRow.setText(8, this.getSubject(listEntry, iTextLookup));
        }
        evoListRow.setText(9, this.getTimePrimary(listEntry, l, iTextLookup));
        evoListRow.setText(10, this.getTimeSecondary(listEntry, iTextLookup));
        evoListRow.setInteger(11, EntryListRowDataEvo.hasAttachments(listEntry) ? 1 : 0);
    }

    private static PropertyListCell getProperties(ListEntry listEntry, IEntryPropertyFactory iEntryPropertyFactory) {
        return iEntryPropertyFactory.create(listEntry);
    }

    public int getColumnCount() {
        return 12;
    }
}

