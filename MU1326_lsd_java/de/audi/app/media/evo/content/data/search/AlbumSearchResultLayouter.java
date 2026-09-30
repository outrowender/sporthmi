/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class AlbumSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS = "AlbumSearchResultLayouter";

    public AlbumSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 2);
    }

    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.getTextCell] line='%2'", (Object)LOGCLASS, (long)n);
        }
        if (this.layout == 1) {
            if (n == 1) {
                return this.getListCellForWordtype(searchResult, 15);
            }
            return null;
        }
        if (n == 1) {
            return this.getListCellForWordtype(searchResult, 15);
        }
        if (n == 2) {
            return this.getListCellForWordtype(searchResult, 16);
        }
        return null;
    }

    public int getSymbol(int n) {
        return 1;
    }

    public int getI18NValue(SearchResult searchResult, int n) {
        if (1 == n) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "[%1.getI18NValue] line='%2'", (Object)LOGCLASS, (long)n);
            }
            return AlbumSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 8);
        }
        if (2 == n) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "[%1.getI18NValue] line='%2'", (Object)LOGCLASS, (long)n);
            }
            return AlbumSearchResultLayouter.getI18NKey(searchResult.getEntryFlags() & 6);
        }
        return 99;
    }
}

