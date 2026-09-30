/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.search;

import de.audi.app.online.evo.search.OnlineSearchResultListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class OnlineSearchResultFormatter
extends AbstractSearchResultFormatter {
    private LogChannel log;

    public OnlineSearchResultFormatter(LogChannel logChannel) {
        this.log = logChannel;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        this.log.log(10000000, "OnlineSearchResultFormatter#formatResult(): result: %1", (Object)searchResult);
        return new OnlineSearchResultListRow(searchResult);
    }
}

