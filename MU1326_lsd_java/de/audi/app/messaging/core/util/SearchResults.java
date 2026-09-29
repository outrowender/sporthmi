/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.Strings;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.Token;

public final class SearchResults {
    public static Token trimForSingleLineDisplay(Token token) {
        String string;
        boolean bl = false;
        int n = 0;
        String string2 = null;
        Highlight[] highlightArray = null;
        if (token != null && !Strings.isNullOrEmpty(string = token.getToken())) {
            n = token.getWordType();
            string2 = string.trim();
            if (!string2.equals(string)) {
                bl = true;
                highlightArray = SearchResults.fillTrimmedHighlightsArray(token, string, string2);
            }
        }
        return bl ? new Token(n, string2, highlightArray) : token;
    }

    private static Highlight[] fillTrimmedHighlightsArray(Token token, String string, String string2) {
        Highlight[] highlightArray;
        if (string2.length() < 1) {
            highlightArray = new Highlight[]{};
        } else {
            int n = string.indexOf(string2);
            if (n > 0) {
                Highlight[] highlightArray2;
                Highlight[] highlightArray3 = highlightArray2 = token != null ? token.getHighlights() : null;
                if (highlightArray2 != null) {
                    highlightArray = new Highlight[highlightArray2.length];
                    for (int i2 = 0; i2 < highlightArray2.length; ++i2) {
                        Highlight highlight = highlightArray2[i2];
                        highlightArray[i2] = new Highlight(highlight.getHighlightStart() - n, highlight.getHighlightEnd() - n);
                    }
                } else {
                    highlightArray = new Highlight[]{};
                }
            } else {
                highlightArray = token.getHighlights();
            }
        }
        return highlightArray;
    }
}

