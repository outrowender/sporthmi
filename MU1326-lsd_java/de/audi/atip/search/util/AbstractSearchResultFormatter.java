/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search.util;

import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public abstract class AbstractSearchResultFormatter {
    public static final int LLD_ONETEXTLINES_GENERAL;
    public static final int LLD_TWOTEXTLINES_GENERAL;
    public static final int LLD_THREETEXTLINES_GENERAL;

    public abstract SearchResultListRow formatResult(SearchResult searchResult) {
    }

    public static Token getTokenForType(Token[] tokenArray, int n) {
        Token token = null;
        if (tokenArray != null) {
            for (int i2 = 0; i2 < tokenArray.length; ++i2) {
                if (tokenArray[i2].getWordType() != n) continue;
                token = tokenArray[i2];
                break;
            }
        }
        return token;
    }

    public static boolean isEmpty(Token token) {
        return token == null || token.getToken() == null || token.getToken().length() == 0;
    }

    protected boolean hasHighlight(Token token) {
        return token != null && token.getHighlights() != null && token.getHighlights().length > 0;
    }

    protected int determineTextLineFormatID(TextListCellHighlightText[] textListCellHighlightTextArray) {
        if (textListCellHighlightTextArray.length == 1 || textListCellHighlightTextArray[1] == null || textListCellHighlightTextArray[1].getText().length() == 0) {
            return 0;
        }
        if (textListCellHighlightTextArray.length == 2 || textListCellHighlightTextArray[2] == null || textListCellHighlightTextArray[2].getText().length() == 0) {
            return 1;
        }
        return 2;
    }
}

