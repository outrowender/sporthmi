/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import org.dsi.ifc.global.ResourceLocator;

public interface ADBListRow {
    public static final int ADB_LIST_ROW_MAX_COLUMNS = 11;
    public static final int COL_IDX_ENABLED_STATE = 0;
    public static final int ENABLED_STATE_DISABLED = 0;
    public static final int ENABLED_STATE_ENABLED = 1;
    public static final int COL_IDX_DATA_TYPE = 1;
    public static final int DATA_TYPE_PHONE_NUMBER = 0;
    public static final int DATA_TYPE_ADDRESS = 1;
    public static final int DATA_TYPE_EMAIL = 2;
    public static final int DATA_TYPE_NO_PHONE_NUMBER = 3;
    public static final int DATA_TYPE_NO_ADDRESS = 4;
    public static final int DATA_TYPE_NO_EMAIL = 5;
    public static final int DATA_TYPE_ADB_ENTRY = 6;
    public static final int DATA_TYPE_ADB_MATCH_NAME = 7;
    public static final int DATA_TYPE_ADB_MATCH_NUMBER = 8;
    public static final int DATA_TYPE_ADB_MATCH_COMPANY = 9;
    public static final int COL_IDX_ICON_ID = 2;
    public static final int COL_IDX_TEXT = 3;
    public static final int COL_IDX_PROPERTY_CELL_ADB_INCLUDE = 4;
    public static final int COL_IDX_PROPERTY_CELL_ADB_POPUP = 5;
    public static final int COL_IDX_CHECKBOX = 6;
    public static final int COL_IDX_TEXT_SECONDARY = 7;
    public static final int COL_IDX_OPEN_CLOSED_STATE = 8;
    public static final int STATE_CLOSED = 0;
    public static final int STATE_OPEN = 1;
    public static final int COL_IDX_TEXT_SECONDARY_AVAILABLE_CHOICE = 9;
    public static final int SECONDARY_TEXT_NOT_AVAILABLE = 0;
    public static final int SECONDARY_TEXT_AVAILABLE = 1;
    public static final int COL_IDX_TEXT_SINGLE_LINE = 10;

    public long getEntryId();

    public String getCombinedName();

    public int getEntryType();

    public ResourceLocator getContactPicture();

    public long getUniqueID();
}

