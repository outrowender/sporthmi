/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.atip.hmi.model.TextListCellHighlightText;
import org.dsi.ifc.search.SearchResult;

public interface IMediaSearchResultLayouter {
    public static final int FIRST_LINE;
    public static final int SECOND_LINE_LEFTSIDE;
    public static final int SECOND_LINE_RIGHTSIDE;
    public static final int LAYOUT_ONE_LINE;
    public static final int LAYOUT_TWO_LINES_LEFTSIDE_ONLY;
    public static final int LAYOUT_TWO_LINES_BOTHSIDES;

    default public void setLayout(int n) {
    }

    default public int getRecordSet(int n) {
    }

    default public TextListCellHighlightText getTextCell(SearchResult searchResult, int n) {
    }

    default public int getI18NValue(SearchResult searchResult, int n) {
    }

    default public int getSymbol(int n) {
    }
}

