/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchUtils;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public final class RecipientSearchListRow
extends SearchResultListRow {
    private static final int COLUMN_COUNT;
    private static final int CELL_IDX_RECORDSET;
    private static final int CELL_IDX_ENABLED;
    private static final int CELL_IDX_ICON;
    private static final int CELL_IDX_COMBINED_NAME;
    private static final int CELL_IDX_ADDRESS;
    private static final int CELL_IDX_EXPANDED;
    private static final int RECORDSET_CONTACT;
    private static final int RECORDSET_ADDRESS;

    public RecipientSearchListRow(SearchResult searchResult) {
        super(searchResult, 6, searchResult.getDataId());
        this.setNodeType(1);
        this.setInteger(0, 0);
        this.setInteger(1, 1);
        this.setInteger(2, ADBTruffleSearchUtils.getEntryTypeModelValue(searchResult));
        this.setHighlightTextCell(3, ADBTruffleSearchUtils.getCombinedNameListCell(searchResult));
        this.setInteger(5, 0);
    }

    @Override
    public EvoListRow copy() {
        RecipientSearchListRow recipientSearchListRow = new RecipientSearchListRow(this.getSearchResult());
        recipientSearchListRow.setOpen(this.isOpen());
        return recipientSearchListRow;
    }

    @Override
    public void setOpen(boolean bl) {
        super.setOpen(bl);
        this.setInteger(5, bl ? 1 : 0);
    }

    public long getEntryId() {
        return this.getSearchResult().getDataId();
    }
}

