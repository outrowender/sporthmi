/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.search.AbstractTelSearchResultRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public abstract class AbstractIntellicallSearchResultRow
extends AbstractTelSearchResultRow {
    public static final int MAX_COLUMNS = 10;
    static final int COL_RECORDSET = 0;
    static final int COL_UNIQUE_LIST_ID = 1;
    static final int COL_MAIN_ICON_ID = 2;
    static final int COL_NAME = 3;
    static final int COL_NUMBER = 4;
    static final int COL_PROPERTIES = 7;
    static final int COL_PHONENUMBERTYPE_ICON = 8;
    static final int COL_OPEN_CLOSE_STATUS = 9;
    static final int RECORDSET_CALLSTACK_ADBMATCH = 0;
    static final int RECORDSET_CALLSTACK_ADBMATCH_SAME_NAME_NUMBER = 1;
    static final int RECORDSET_CALLSTACK_NO_ADBMATCH = 2;
    static final int RECORDSET_CALLSTACK_NO_ADBMATCH_UNKNOWN_NUMBER = 3;
    static final int RECORDSET_FAVORITE = 4;
    static final int RECORDSET_ADB_PARENT = 5;
    static final int RECORDSET_ADB_CHILD = 6;

    public AbstractIntellicallSearchResultRow(SearchResult searchResult, LogChannel logChannel) {
        super(searchResult, 10, searchResult.getListPosition(), logChannel);
    }

    protected void setRecordSetColumn(int n) {
        this.setInteger(0, n);
    }
}

