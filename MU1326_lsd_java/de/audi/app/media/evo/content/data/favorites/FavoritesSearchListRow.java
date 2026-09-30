/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.search.IMediaSearchResultLayouter;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class FavoritesSearchListRow
extends SearchResultListRow {
    private static final int MAX_COLUMNS = 6;
    private static final int CELL_ID_RECORDSET = 0;
    private static final int CELL_ID_FAV_FIRST_ROW = 1;
    private static final int CELL_ID_FAV_FIRST_ROW_I18N = 2;
    private static final int CELL_ID_FAV_SECOND_ROW = 3;
    private static final int CELL_ID_FAV_SECOND_ROW_I18N = 4;
    private static final int CELL_ID_FAV_SYMBOL = 5;

    public FavoritesSearchListRow(SearchResult searchResult, IMediaSearchResultLayouter iMediaSearchResultLayouter) {
        super(searchResult, 6, searchResult.getListPosition());
        this.setInteger(0, iMediaSearchResultLayouter.getRecordSet(searchResult.getEntryType()));
        this.setHighlightTextCell(1, iMediaSearchResultLayouter.getTextCell(searchResult, 1));
        this.setHighlightTextCell(3, iMediaSearchResultLayouter.getTextCell(searchResult, 2));
        this.setInteger(2, iMediaSearchResultLayouter.getI18NValue(searchResult, 1));
        this.setInteger(4, iMediaSearchResultLayouter.getI18NValue(searchResult, 2));
        this.setInteger(5, iMediaSearchResultLayouter.getSymbol(searchResult.getEntryType()));
    }

    public FavoritesSearchListRow(FavoritesSearchListRow favoritesSearchListRow) {
        super(favoritesSearchListRow);
    }

    public static int getMaxColumns() {
        return 6;
    }

    public EvoListRow copy() {
        return new FavoritesSearchListRow(this);
    }
}

