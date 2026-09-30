/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class TitleSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS = "TitleSearchResultLayouter";

    public TitleSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 3);
    }

    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (!this.isLineRelevant(n)) {
            return null;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.getTextCell] line='%2'", (Object)LOGCLASS, (long)n);
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

    public int getSymbol(int n) {
        return 0;
    }

    public int getI18NValue(SearchResult searchResult, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(10000000, "[%1.getI18NValue] line='%2'", (Object)LOGCLASS, (long)n);
        }
        if (1 == n) {
            return TitleSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 0x21);
        }
        if (2 == n) {
            return TitleSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 6);
        }
        return TitleSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 8);
    }
}

