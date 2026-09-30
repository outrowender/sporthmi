/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tv.app.interapp.ITVRowFactory;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.truffles.TVSearchListRow;
import org.dsi.ifc.search.SearchResult;

class SearchResultFormatter
extends AbstractSearchResultFormatter {
    private final LogChannel log;
    private final IFavoritesList favoritesList;
    private final IStationList stationList;
    private final ITVRowFactory rowFactory;

    SearchResultFormatter(LogChannel logChannel, IFavoritesList iFavoritesList, IStationList iStationList, ITVRowFactory iTVRowFactory) {
        this.log = logChannel;
        this.favoritesList = iFavoritesList;
        this.stationList = iStationList;
        this.rowFactory = iTVRowFactory;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        this.log.log(10000000, "[SearchResultFormatter.formatResult] %1", (Object)searchResult);
        return new TVSearchListRow(searchResult, this.favoritesList, this.stationList, this.rowFactory);
    }
}

