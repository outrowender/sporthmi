/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.evo.search.SearchResultFormatterNavDb;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import org.dsi.ifc.search.SearchResult;

public class NoPropertyFormatterFavorites
extends SearchResultFormatterNavDb {
    public NoPropertyFormatterFavorites(InterAppService interAppService, IconHandler iconHandler, LogChannel logChannel, INaviFavoriteHandler iNaviFavoriteHandler, NavigationEnv navigationEnv) {
        super(interAppService, iconHandler, logChannel, iNaviFavoriteHandler, navigationEnv);
    }

    protected void setPropertyCell(NaviSearchResultListRow naviSearchResultListRow, SearchResult searchResult) {
        naviSearchResultListRow.setPropertiesColumn(null);
    }

    protected void configureLayout(SearchResult searchResult, NaviSearchResultListRow naviSearchResultListRow) {
        if (searchResult.source == 5) {
            naviSearchResultListRow.setLayout(1);
            naviSearchResultListRow.setStaticIcon(4);
        } else {
            this.lc.log(100000, "FavoriteSearchFormatter#configureLayout wrong source for result: %1", (Object)searchResult);
        }
    }
}

