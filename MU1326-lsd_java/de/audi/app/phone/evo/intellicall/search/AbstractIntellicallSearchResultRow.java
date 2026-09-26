/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.search.AbstractTelSearchResultRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.SearchResult;

public abstract class AbstractIntellicallSearchResultRow
extends AbstractTelSearchResultRow {
    public static final int MAX_COLUMNS;
    static final int COL_RECORDSET;
    static final int COL_UNIQUE_LIST_ID;
    static final int COL_MAIN_ICON_ID;
    static final int COL_NAME;
    static final int COL_NUMBER;
    static final int COL_PROPERTIES;
    static final int COL_PHONENUMBERTYPE_ICON;
    static final int COL_OPEN_CLOSE_STATUS;
    static final int RECORDSET_CALLSTACK_ADBMATCH;
    static final int RECORDSET_CALLSTACK_ADBMATCH_SAME_NAME_NUMBER;
    static final int RECORDSET_CALLSTACK_NO_ADBMATCH;
    static final int RECORDSET_CALLSTACK_NO_ADBMATCH_UNKNOWN_NUMBER;
    static final int RECORDSET_FAVORITE;
    static final int RECORDSET_ADB_PARENT;
    static final int RECORDSET_ADB_CHILD;

    public AbstractIntellicallSearchResultRow(SearchResult searchResult, LogChannel logChannel) {
        super(searchResult, 10, searchResult.getListPosition(), logChannel);
    }

    protected void setRecordSetColumn(int n) {
        this.setInteger(0, n);
    }
}

