/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.truffles;

import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchUtils;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class ADBTruffleSearchListRow
extends SearchResultListRow
implements ADBSearchListRow {
    protected int adbMode;

    public ADBTruffleSearchListRow(SearchResult searchResult, int n) {
        super(searchResult, 11, searchResult.getDataId());
        this.adbMode = n;
        this.setInteger(0, ADBTruffleSearchUtils.hasRelevantData(searchResult, n) ? 1 : 0);
        this.setInteger(1, 6);
        this.setInteger(2, ADBTruffleSearchUtils.getEntryTypeModelValue(searchResult));
        this.setHighlightTextCell(3, ADBTruffleSearchUtils.getCombinedNameListCell(searchResult));
    }

    public EvoListRow copy() {
        return new ADBTruffleSearchListRow(this.getSearchResult(), this.adbMode);
    }

    public long getEntryId() {
        return this.getSearchResult().getDataId();
    }

    public String getCombinedName() {
        Token[] tokenArray = this.getSearchResult().getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 5);
        return token == null ? null : token.getToken();
    }

    public int getEntryType() {
        return ADBTruffleSearchUtils.getDsiEntryType(this.getSearchResult());
    }

    public ResourceLocator getContactPicture() {
        return ADBTruffleSearchUtils.getContactPicture(this.getSearchResult());
    }

    public int getPhoneCount() {
        return ADBTruffleSearchUtils.getPhoneCount(this.getSearchResult());
    }
}

