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
    private static final String LOGCLASS = "FavoritesSearchHandler";
    private final IFavoritesBrowserList favoritesBrowserList;
    private final AbstractSearchResultFormatter searchResultFormatter;

    public FavoritesSearchHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, AbstractSearch abstractSearch, IFavoritesBrowserList iFavoritesBrowserList, ChoiceModelApp choiceModelApp3) {
        super(logChannel, baseListModelApp, spellerModelApp, choiceModelApp, choiceModelApp2, new int[]{20011}, abstractSearch, choiceModelApp3);
        this.favoritesBrowserList = iFavoritesBrowserList;
        this.searchResultFormatter = new FavoritesSearchFormatter(logChannel, 10);
    }

    public void init() {
        super.init();
        this.lc.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.registryFormatter.put(new Integer(20011), this.searchResultFormatter);
    }

    public void deinit() {
        super.deinit();
        this.lc.log(1000000, "[%1.searchResultSelected]", (Object)LOGCLASS);
    }

    protected String getLogClass() {
        return LOGCLASS;
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.lc.log(1000000, "[%1.searchResultSelected]", (Object)LOGCLASS);
        this.appSearch.addToHistory(searchResultListRow.getSearchResult());
        this.favoritesBrowserList.selectFavoriteEntry((int)searchResultListRow.getSearchResult().getDataId());
        this.mdlListSearchResults.fireEvent(n);
    }

    public int getMaxColumns() {
        return FavoritesSearchListRow.getMaxColumns();
    }
}

