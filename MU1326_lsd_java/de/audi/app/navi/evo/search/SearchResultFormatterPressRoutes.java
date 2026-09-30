/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.search.util.TextLineList;
import de.audi.tghu.navi.app.NavigationEnv;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class SearchResultFormatterPressRoutes
extends AbstractSearchResultFormatter {
    private final LogChannel lc;

    public SearchResultFormatterPressRoutes(LogChannel logChannel, NavigationEnv navigationEnv) {
        this.lc = logChannel;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        if (null == searchResult) {
            this.lc.log(10000, "SearchResultFormatterNavDb#formatResult - Search-result parameter is null");
            return null;
        }
        NaviSearchResultListRow naviSearchResultListRow = new NaviSearchResultListRow(searchResult);
        naviSearchResultListRow.setLayout(1);
        naviSearchResultListRow.setStaticIcon(5);
        TextLineList textLineList = new TextLineList();
        Token token = SearchResultFormatterPressRoutes.getTokenForType(searchResult.tokens, 5);
        textLineList.addToken(token);
        naviSearchResultListRow.setTextLine1Column(new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices()));
        return naviSearchResultListRow;
    }
}

