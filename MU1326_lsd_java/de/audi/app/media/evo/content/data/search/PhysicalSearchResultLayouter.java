/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public class PhysicalSearchResultLayouter
extends AbstractSearchResultLayouter {
    private static final String LOGCLASS;

    public PhysicalSearchResultLayouter(LogChannel logChannel) {
        super(logChannel, 1);
    }

    @Override
    public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "[%1.getTextCell] line='%2'", (Object)"PhysicalSearchResultLayouter", (long)n);
            }
            return this.getListCellForWordtype(searchResult, 5);
        }
        return null;
    }

    @Override
    public int getSymbol(int n) {
        switch (n) {
            case 7: {
                return 0;
            }
            case 11: {
                return 3;
            }
            case 10: {
                return 5;
            }
        }
        return 6;
    }

    @Override
    public int getI18NValue(SearchResult searchResult, int n) {
        if (this.isLineRelevant(n)) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "[%1.getI18NValue] line='%2'", (Object)"PhysicalSearchResultLayouter", (long)n);
            }
            return 0;
        }
        return 99;
    }
}

