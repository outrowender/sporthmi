/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class ArtistSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS = "ArtistSearchResultLayouter";

    public ArtistSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 1);
    }

    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "[%1.getTextCell] line='%2'", (Object)LOGCLASS, (long)n);
            }
            return this.getListCellForWordtype(searchResult, 16);
        }
        return null;
    }

    public int getSymbol(int n) {
        return 2;
    }

    public int getI18NValue(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            this.logger.log(10000000, "[%1.getI18NValue] line='%2'", (Object)LOGCLASS, (long)n);
            return ArtistSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 6);
        }
        return 99;
    }
}

