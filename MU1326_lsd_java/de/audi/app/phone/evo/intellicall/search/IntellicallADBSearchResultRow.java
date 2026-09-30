/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchUtils;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.search.SearchResult;

public class IntellicallADBSearchResultRow
extends AbstractIntellicallSearchResultRow {
    final long adbEntryId;

    public IntellicallADBSearchResultRow(SearchResult searchResult, LogChannel logChannel) {
        super(searchResult, logChannel);
        this.adbEntryId = searchResult.getDataId();
        this.setNodeType(1);
        this.setRecordSetColumn(5);
        this.setInteger(2, ADBTruffleSearchUtils.getEntryTypeModelValue(searchResult));
        this.setHighlightTextCell(3, ADBTruffleSearchUtils.getCombinedNameListCell(searchResult));
        this.setPropertyCell(7, PropertyListCell.create(1859627275, new int[]{-1571551967}));
    }

    public EvoListRow copy() {
        IntellicallADBSearchResultRow intellicallADBSearchResultRow = new IntellicallADBSearchResultRow(this.getSearchResult(), this.log);
        intellicallADBSearchResultRow.setOpen(this.isOpen());
        intellicallADBSearchResultRow.setChildrenCount(this.getChildrenCount());
        return intellicallADBSearchResultRow;
    }

    public long getAdbEntryId() {
        return this.adbEntryId;
    }

    public ResourceLocator getContactPicture() {
        return ADBTruffleSearchUtils.getContactPicture(this.getSearchResult());
    }

    public void setOpen(boolean bl) {
        super.setOpen(bl);
        int n = bl ? 1 : 0;
        this.log.log(10000000, "[IntellicallADBSearchResultRow#setOpen] isOpen=%1, setting column value to %1", bl, (long)n);
        this.setInteger(9, n);
    }
}

