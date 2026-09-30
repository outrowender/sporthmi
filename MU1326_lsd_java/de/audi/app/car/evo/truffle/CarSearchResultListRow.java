/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.truffle;

import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class CarSearchResultListRow
extends SearchResultListRow {
    private static final int MAX_COLUMNS = 4;
    private static final int COL_INDEX_ID = 0;
    private static final int COL_INDEX_TEXT1 = 1;
    private static final int COL_INDEX_TEXT2 = 2;
    private static final int COL_INDEX_TEXT3 = 3;

    public CarSearchResultListRow(SearchResult searchResult) {
        super(searchResult, 4, searchResult.getDataId());
    }

    public CarSearchResultListRow(CarSearchResultListRow carSearchResultListRow) {
        super(carSearchResultListRow);
    }

    protected void setID(int n) {
        this.setInteger(0, n);
    }

    protected void setTextLine1(TextListCellHighlightText textListCellHighlightText) {
        this.setHighlightTextCell(1, textListCellHighlightText);
    }

    protected void setTextLine2(TextListCellHighlightText textListCellHighlightText) {
        this.setHighlightTextCell(2, textListCellHighlightText);
    }

    protected void setTextLine2SynonymMatch(TextListCellHighlightText textListCellHighlightText) {
        this.setHighlightTextCell(3, textListCellHighlightText);
    }

    protected TextListCellHighlightText getTextLine1() {
        return (TextListCellHighlightText)this.getCell(1);
    }

    protected TextListCellHighlightText getTextLine2() {
        return (TextListCellHighlightText)this.getCell(2);
    }

    protected TextListCellHighlightText getTextLine2SynonymMatch() {
        return (TextListCellHighlightText)this.getCell(3);
    }

    protected static int getMaxColumns() {
        return 4;
    }

    public EvoListRow copy() {
        return new CarSearchResultListRow(this);
    }
}

