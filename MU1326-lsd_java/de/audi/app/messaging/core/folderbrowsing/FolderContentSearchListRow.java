/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingMappings;
import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.IEntryListRow;
import de.audi.app.messaging.core.folderbrowsing.IEntryListRowDataFactory;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.folderbrowsing.ListEntryFactory;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.search.SearchResult;

final class FolderContentSearchListRow
extends SearchResultListRow
implements IEntryListRow {
    private final AbstractEntryListRowData entryListRowData;
    private final IEntryListRowDataFactory entryListRowDataFactory;

    private FolderContentSearchListRow(SearchResult searchResult, AbstractEntryListRowData abstractEntryListRowData, IEntryListRowDataFactory iEntryListRowDataFactory) {
        super(searchResult, abstractEntryListRowData.getColumnCount(), searchResult.getDataId());
        this.entryListRowData = abstractEntryListRowData;
        this.entryListRowDataFactory = iEntryListRowDataFactory;
    }

    public static FolderContentSearchListRow create(SearchResult searchResult, IEntryPropertyFactory iEntryPropertyFactory, IEntryListRowDataFactory iEntryListRowDataFactory, int n, long l, ITextLookup iTextLookup) {
        ListEntry listEntry = ListEntryFactory.createListEntry(searchResult);
        ListEntry[] listEntryArray = new ListEntry[]{listEntry};
        ListEntry[] listEntryArray2 = DsiMessagingMappings.mmsToSms(null, listEntryArray);
        ListEntry listEntry2 = listEntryArray2 != null && listEntryArray2.length > 0 && listEntryArray2[0] != null ? listEntryArray2[0] : listEntry;
        AbstractEntryListRowData abstractEntryListRowData = iEntryListRowDataFactory.create(listEntry2, iEntryPropertyFactory, n, l, iTextLookup);
        FolderContentSearchListRow folderContentSearchListRow = new FolderContentSearchListRow(searchResult, abstractEntryListRowData, iEntryListRowDataFactory);
        abstractEntryListRowData.setColumns(folderContentSearchListRow, abstractEntryListRowData, searchResult);
        return folderContentSearchListRow;
    }

    @Override
    public EvoListRow copy() {
        return FolderContentSearchListRow.create(this.getSearchResult(), this.entryListRowData.getEntryPropertyFactory(), this.entryListRowDataFactory, this.entryListRowData.getItemOffset(), this.entryListRowData.getCurrentTime(), this.entryListRowData.getTextLookup());
    }

    @Override
    public ListEntry getListEntry() {
        return this.entryListRowData.getListEntry();
    }

    @Override
    public int getItemOffset() {
        return this.entryListRowData.getItemOffset();
    }

    @Override
    public int getIconId() {
        return this.entryListRowData.getIconId();
    }
}

