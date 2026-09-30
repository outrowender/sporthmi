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

public class NoPropertyFormatterNavDb
extends SearchResultFormatterNavDb {
    public NoPropertyFormatterNavDb(InterAppService interAppService, IconHandler iconHandler, LogChannel logChannel, INaviFavoriteHandler iNaviFavoriteHandler, NavigationEnv navigationEnv) {
        super(interAppService, iconHandler, logChannel, iNaviFavoriteHandler, navigationEnv);
    }

    protected void setPropertyCell(NaviSearchResultListRow naviSearchResultListRow, SearchResult searchResult) {
        naviSearchResultListRow.setPropertiesColumn(null);
    }
}

