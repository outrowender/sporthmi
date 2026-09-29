/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.search.LastDestSearch;
import org.dsi.ifc.search.SearchResult;

class LastDestSearch$1
extends SearchResultListRow {
    private final /* synthetic */ LastDestSearch this$0;

    LastDestSearch$1(LastDestSearch lastDestSearch, SearchResult searchResult, int n, long l) {
        this.this$0 = lastDestSearch;
        super(searchResult, n, l);
    }

    @Override
    public EvoListRow copy() {
        return null;
    }
}

