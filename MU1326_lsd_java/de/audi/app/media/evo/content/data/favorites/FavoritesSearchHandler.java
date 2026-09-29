/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.FavoritesSearchFormatter;
import de.audi.app.media.evo.content.data.favorites.FavoritesSearchListRow;
import de.audi.app.media.evo.content.data.favorites.IFavoritesBrowserList;
import de.audi.app.media.evo.content.data.search.AbstractSearchHandlerEvo;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;

public class FavoritesSearchHandler
extends AbstractSearchHandlerEvo {
    private static final String LOGCLASS;
    private final IFavoritesBrowserList favoritesBrowserList;
    private final AbstractSearchResultFormatter searchResultFormatter;

    public FavoritesSearchHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, AbstractSearch abstractSearch, IFavoritesBrowserList iFavoritesBrowserList, ChoiceModelApp choiceModelApp3) {
        super(logChannel, baseListModelApp, spellerModelApp, choiceModelApp, choiceModelApp2, new int[]{20011}, abstractSearch, choiceModelApp3);
        this.favoritesBrowserList = iFavoritesBrowserList;
        this.searchResultFormatter = new FavoritesSearchFormatter(logChannel, 10);
    }

    @Override
    public void init() {
        super.init();
        this.lc.log(1078071040, "[%1.init]", (Object)"FavoritesSearchHandler");
        this.registryFormatter.put(new Integer(20011), this.searchResultFormatter);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.lc.log(1078071040, "[%1.searchResultSelected]", (Object)"FavoritesSearchHandler");
    }

    @Override
    protected String getLogClass() {
        return "FavoritesSearchHandler";
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.lc.log(1078071040, "[%1.searchResultSelected]", (Object)"FavoritesSearchHandler");
        this.appSearch.addToHistory(searchResultListRow.getSearchResult());
        this.favoritesBrowserList.selectFavoriteEntry((int)searchResultListRow.getSearchResult().getDataId());
        this.mdlListSearchResults.fireEvent(n);
    }

    public int getMaxColumns() {
        return FavoritesSearchListRow.getMaxColumns();
    }
}

