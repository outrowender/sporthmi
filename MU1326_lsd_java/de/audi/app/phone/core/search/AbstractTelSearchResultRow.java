/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search;

import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.search.util.TextLineList;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public abstract class AbstractTelSearchResultRow
extends SearchResultListRow {
    protected final LogChannel log;

    public AbstractTelSearchResultRow(SearchResult searchResult, int n, long l, LogChannel logChannel) {
        super(searchResult, n, l);
        this.log = logChannel;
    }

    public String getTelephoneNumber() {
        SearchResult searchResult = this.getSearchResult();
        if (searchResult != null) {
            Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 11);
            return token != null ? token.getToken() : "";
        }
        return "";
    }

    public String getName() {
        SearchResult searchResult = this.getSearchResult();
        if (searchResult != null) {
            Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 5);
            return token != null ? token.getToken() : "";
        }
        return "";
    }

    protected TextListCellHighlightText getHighlightedNumberCell() {
        return this.getHighlightedCell(11);
    }

    protected TextListCellHighlightText getHighlightedNameCell() {
        return this.getHighlightedCell(5);
    }

    private TextListCellHighlightText getHighlightedCell(int n) {
        SearchResult searchResult = this.getSearchResult();
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), n);
        TextLineList textLineList = new TextLineList();
        textLineList.addToken(token);
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }
}

