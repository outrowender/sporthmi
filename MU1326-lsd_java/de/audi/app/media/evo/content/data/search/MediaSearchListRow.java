/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.IMediaSearchResultLayouter;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class MediaSearchListRow
extends SearchResultListRow {
    private static final int ROWCELLS_COUNT;
    private static final int COL_IDX_RECORDSET;
    private static final int COL_IDX_ICONID;
    private static final int COL_IDX_TEXTLINE1;
    private static final int COL_IDX_TEXTLINE2_LEFT;
    private static final int COL_IDX_TEXTLINE2_RIGHT;
    private static final int COL_IDX_I18N_LINE1;
    private static final int COL_IDX_I18N_LINE2_LEFT;
    private static final int COL_IDX_I18N_LINE2_RIGHT;
    private static final int COL_IDX_COVERART_URL;
    public static final int RECORDSET_FOLDER_ONE_LINE;
    public static final int RECORDSET_FOLDER_TWO_LINES_BOTH;
    public static final int RECORDSET_FOLDER_TWO_LINES_LEFT;
    public static final int RECORDSET_FILE_ONE_LINE;
    public static final int RECORDSET_FILE_TWO_LINES_BOTH;
    public static final int RECORDSET_FILE_TWO_LINES_LEFT;

    public MediaSearchListRow(SearchResult searchResult, IMediaSearchResultLayouter iMediaSearchResultLayouter, String string) {
        super(searchResult, 14, searchResult.getListPosition());
        this.setInteger(0, iMediaSearchResultLayouter.getRecordSet(searchResult.getEntryType()));
        this.setInteger(1, iMediaSearchResultLayouter.getSymbol(searchResult.getEntryType()));
        this.setHighlightTextCell(2, iMediaSearchResultLayouter.getTextCell(searchResult, 1));
        this.setHighlightTextCell(3, iMediaSearchResultLayouter.getTextCell(searchResult, 2));
        this.setHighlightTextCell(4, iMediaSearchResultLayouter.getTextCell(searchResult, 3));
        this.setInteger(5, iMediaSearchResultLayouter.getI18NValue(searchResult, 1));
        this.setInteger(6, iMediaSearchResultLayouter.getI18NValue(searchResult, 2));
        this.setInteger(7, iMediaSearchResultLayouter.getI18NValue(searchResult, 3));
        this.setHMIResourceLocator(13, new HMIResourceLocator(-1, string == null ? ResourceLocatorModelApp.UNDEFINED_URI : string));
    }

    public MediaSearchListRow(MediaSearchListRow mediaSearchListRow) {
        super(mediaSearchListRow);
    }

    public HMIResourceLocator getCoverArtResourceLocator() {
        return (HMIResourceLocator)this.getCell(13);
    }

    public static int getColumnSize() {
        return 14;
    }

    @Override
    public EvoListRow copy() {
        return new MediaSearchListRow(this);
    }
}

