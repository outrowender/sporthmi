/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class GenreSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS;

    public GenreSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 1);
    }

    @Override
    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "[%1.getTextCell] line='%2'", (Object)"GenreSearchResultLayouter", (long)n);
            }
            return this.getListCellForWordtype(searchResult, 14);
        }
        return null;
    }

    @Override
    public int getSymbol(int n) {
        return 4;
    }

    @Override
    public int getI18NValue(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "[%1.getI18NValue] line='%2'", (Object)"GenreSearchResultLayouter", (long)n);
            }
            return GenreSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 0x10);
        }
        return 99;
    }
}

