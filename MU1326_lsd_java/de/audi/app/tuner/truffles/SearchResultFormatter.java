/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.RadioSearchListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

class SearchResultFormatter
extends AbstractSearchResultFormatter {
    private final LogChannel log;

    SearchResultFormatter(LogChannel logChannel) {
        this.log = logChannel;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        this.log.log(10000000, "[SearchResultFormatter.formatResult] %1", (Object)searchResult);
        return new RadioSearchListRow(searchResult);
    }
}

