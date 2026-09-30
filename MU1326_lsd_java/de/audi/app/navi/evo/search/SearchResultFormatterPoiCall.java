/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.evo.util.NaviCellPropsContainer;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.search.util.TextLineList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.search.SearchResult;

public class SearchResultFormatterPoiCall
extends AbstractSearchResultFormatter {
    private final LogChannel lc;
    private final NavigationEnv env;

    public SearchResultFormatterPoiCall(LogChannel logChannel, NavigationEnv navigationEnv) {
        this.lc = logChannel;
        this.env = navigationEnv;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        if (searchResult == null) {
            this.lc.log(10000, "SearchResultFormatterPoiCall#formatResult - search-result parameter is null");
            return null;
        }
        searchResult.entryType = 2;
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(searchResult, this.env);
        TextLineList textLineList = locationFormattingResponse.getFirstLineForTruffles();
        TextLineList textLineList2 = locationFormattingResponse.getSecondLineForTruffles();
        NaviCellPropsContainer naviCellPropsContainer = new NaviCellPropsContainer();
        naviCellPropsContainer.setCategory(1055316784);
        PropertyListCell propertyListCell = new PropertyListCell(naviCellPropsContainer.getCategory(), naviCellPropsContainer.getProperties());
        NaviSearchResultListRow naviSearchResultListRow = new NaviSearchResultListRow(searchResult);
        naviSearchResultListRow.setLayout(4);
        naviSearchResultListRow.setStaticIcon(7);
        naviSearchResultListRow.setTextLine1Column(new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices()));
        naviSearchResultListRow.setTextLine2Column(new TextListCellHighlightText(textLineList2.getText(), textLineList2.getTextHighlightIndices()));
        naviSearchResultListRow.setPropertiesColumn(propertyListCell);
        return naviSearchResultListRow;
    }
}

