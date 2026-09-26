/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.evo.search.SearchResultFormatterADB;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.NavigationEnv;

public class NoPropertyFormatterADB
extends SearchResultFormatterADB {
    public NoPropertyFormatterADB(ADBInterAppService aDBInterAppService, NavigationEnv navigationEnv) {
        super(aDBInterAppService, navigationEnv);
    }

    @Override
    protected void setPropertyCell(NaviSearchResultListRow naviSearchResultListRow) {
        naviSearchResultListRow.setPropertiesColumn(null);
    }

    @Override
    protected PropertyListCell createPropertyListCell(int n) {
        return null;
    }
}

