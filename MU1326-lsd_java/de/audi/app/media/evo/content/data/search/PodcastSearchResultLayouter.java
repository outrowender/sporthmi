/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class PodcastSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS;

    public PodcastSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 2);
    }

    @Override
    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "[%1.getTextCell] line='%2'", (Object)"PodcastSearchResultLayouter", (long)n);
            }
            return this.getListCellForWordtype(searchResult, 5);
        }
        return null;
    }

    @Override
    public int getSymbol(int n) {
        return 8;
    }

    @Override
    public int getI18NValue(SearchResult searchResult, int n) {
        return 99;
    }
}

