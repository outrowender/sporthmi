/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class OnlineSearchResultListRow
extends SearchResultListRow {
    public static int MAX_COLUMNS = 4;
    private static final int COL_IDX_INDEX = 0;
    private static final int COL_IDX_APPID = 1;
    private static final int COL_IDX_ICONID = 2;
    private static final int COL_IDX_TEXTLINE1 = 3;
    private static final int COL_IDX_TEXTLINE2 = 4;

    public OnlineSearchResultListRow(SearchResult searchResult) {
        super(searchResult, MAX_COLUMNS, -1L);
    }

    public EvoListRow copy() {
        return null;
    }
}

