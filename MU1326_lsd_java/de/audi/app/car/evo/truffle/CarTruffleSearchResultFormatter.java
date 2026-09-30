/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.truffle;

import de.audi.app.car.evo.truffle.CarSearchResultListRow;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class CarTruffleSearchResultFormatter
extends AbstractSearchResultFormatter {
    private final LogChannel logChannel;

    protected CarTruffleSearchResultFormatter(LogChannel logChannel, int n) {
        this.logChannel = logChannel;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        this.logChannel.log(1000000, "[CarTruffleSearchResultFormatter#formatResult] result='%1'", (Object)searchResult);
        CarSearchResultListRow carSearchResultListRow = new CarSearchResultListRow(searchResult);
        Token[] tokenArray = searchResult.getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 5);
        Token token2 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 22);
        Token token3 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 23);
        if (token3 != null && token3.getHighlights() != null && token3.getHighlights().length > 0) {
            carSearchResultListRow.setTextLine2SynonymMatch(this.createLine(token3));
        } else {
            carSearchResultListRow.setTextLine2SynonymMatch(this.createLine(null));
        }
        carSearchResultListRow.setID(searchResult.getEntryType());
        carSearchResultListRow.setTextLine1(this.createLine(token));
        carSearchResultListRow.setTextLine2(this.createLine(token2));
        return carSearchResultListRow;
    }

    private TextListCellHighlightText createLine(Token token) {
        if (token == null) {
            return new TextListCellHighlightText("", null);
        }
        int[] nArray = null;
        int[] nArray2 = new int[token.getHighlights().length * 2];
        int n = 0;
        for (int i2 = 0; i2 < token.getHighlights().length; ++i2) {
            if (token.getHighlights()[i2] == null) continue;
            nArray2[n] = token.getHighlights()[i2].highlightStart;
            nArray2[n + 1] = token.getHighlights()[i2].highlightEnd;
            n += 2;
        }
        if (n != 0) {
            nArray = new int[n];
            System.arraycopy((Object)nArray2, 0, (Object)nArray, 0, n);
        }
        return new TextListCellHighlightText(token != null ? token.getToken() : "-", nArray);
    }
}

