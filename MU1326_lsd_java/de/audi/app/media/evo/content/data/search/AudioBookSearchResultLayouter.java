/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class AudioBookSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS;

    public AudioBookSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 3);
    }

    @Override
    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (!this.isLineRelevant(n)) {
            return null;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.getTextCell] line='%2'", (Object)"AudioBookSearchResultLayouter", (long)n);
        }
        if (this.layout == 1) {
            if (n == 1) {
                return this.getListCellForWordtype(searchResult, 5);
            }
            return null;
        }
        if (n == 1) {
            return this.getListCellForWordtype(searchResult, 5);
        }
        if (n == 2) {
            return this.getListCellForWordtype(searchResult, 16);
        }
        return this.getListCellForWordtype(searchResult, 15);
    }

    @Override
    public int getSymbol(int n) {
        return 9;
    }

    @Override
    public int getI18NValue(SearchResult searchResult, int n) {
        return 99;
    }
}

