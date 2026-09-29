/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.FavoriteSearchResultLayouter;
import de.audi.app.media.evo.content.data.favorites.FavoritesSearchListRow;
import de.audi.app.media.evo.content.data.search.AbstractMediaSearchResultFormatter;
import de.audi.app.media.evo.content.data.search.IMediaSearchResultLayouter;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class FavoritesSearchFormatter
extends AbstractMediaSearchResultFormatter {
    private static final String LOGCLASS;
    private final IMediaSearchResultLayouter favoriteSearchResultLayouter;

    public FavoritesSearchFormatter(LogChannel logChannel, int n) {
        super(logChannel, n);
        this.favoriteSearchResultLayouter = new FavoriteSearchResultLayouter(logChannel);
    }

    @Override
    public void setLayout(int n) {
    }

    @Override
    public SearchResultListRow formatResult(SearchResult searchResult) {
        this.logger.log(1078071040, "[%1.formatResult] '%2'", (Object)"FavoritesSearchFormatter", (Object)searchResult);
        switch (searchResult.getEntryType()) {
            case 6: {
                this.favoriteSearchResultLayouter.setLayout(2);
                break;
            }
            default: {
                this.favoriteSearchResultLayouter.setLayout(1);
            }
        }
        return new FavoritesSearchListRow(searchResult, this.favoriteSearchResultLayouter);
    }
}

