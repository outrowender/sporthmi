/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.atip.hmi.model.TextListCellHighlightText;
import org.dsi.ifc.search.SearchResult;

public interface IMediaSearchResultLayouter {
    public static final int FIRST_LINE = 1;
    public static final int SECOND_LINE_LEFTSIDE = 2;
    public static final int SECOND_LINE_RIGHTSIDE = 3;
    public static final int LAYOUT_ONE_LINE = 1;
    public static final int LAYOUT_TWO_LINES_LEFTSIDE_ONLY = 2;
    public static final int LAYOUT_TWO_LINES_BOTHSIDES = 3;

    public void setLayout(int var1);

    public int getRecordSet(int var1);

    public TextListCellHighlightText getTextCell(SearchResult var1, int var2);

    public int getI18NValue(SearchResult var1, int var2);

    public int getSymbol(int var1);
}

