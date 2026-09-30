/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class FavoriteSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS = "FavoriteSearchResultLayouter";

    public FavoriteSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 1);
    }

    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "[%1.getTextCell] line='%2'", (Object)LOGCLASS, (long)n);
            }
            if (1 == n) {
                return this.getListCellForWordtype(searchResult, 5);
            }
            return this.getListCellForWordtype(searchResult, 16);
        }
        return null;
    }

    public int getI18NValue(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "[%1.getI18NCell] line='%2'", (Object)LOGCLASS, (long)n);
            }
            switch (searchResult.getEntryType()) {
                case 5: {
                    return FavoriteSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 6);
                }
                case 6: {
                    if (1 == n) {
                        return FavoriteSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 8);
                    }
                    return FavoriteSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 6);
                }
                case 9: {
                    return FavoriteSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 0x10);
                }
            }
            return 99;
        }
        return 99;
    }

    public int getSymbol(int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.getI18NCell] entryType='%2'", (Object)LOGCLASS, (long)n);
        }
        switch (n) {
            case 5: {
                return 2;
            }
            case 6: {
                return 1;
            }
            case 9: {
                return 4;
            }
            case 12: {
                return 6;
            }
            case 10: {
                return 5;
            }
        }
        return -1;
    }
}

