/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import org.dsi.ifc.global.ResourceLocator;

public interface ADBListRow {
    public static final int ADB_LIST_ROW_MAX_COLUMNS;
    public static final int COL_IDX_ENABLED_STATE;
    public static final int ENABLED_STATE_DISABLED;
    public static final int ENABLED_STATE_ENABLED;
    public static final int COL_IDX_DATA_TYPE;
    public static final int DATA_TYPE_PHONE_NUMBER;
    public static final int DATA_TYPE_ADDRESS;
    public static final int DATA_TYPE_EMAIL;
    public static final int DATA_TYPE_NO_PHONE_NUMBER;
    public static final int DATA_TYPE_NO_ADDRESS;
    public static final int DATA_TYPE_NO_EMAIL;
    public static final int DATA_TYPE_ADB_ENTRY;
    public static final int DATA_TYPE_ADB_MATCH_NAME;
    public static final int DATA_TYPE_ADB_MATCH_NUMBER;
    public static final int DATA_TYPE_ADB_MATCH_COMPANY;
    public static final int COL_IDX_ICON_ID;
    public static final int COL_IDX_TEXT;
    public static final int COL_IDX_PROPERTY_CELL_ADB_INCLUDE;
    public static final int COL_IDX_PROPERTY_CELL_ADB_POPUP;
    public static final int COL_IDX_CHECKBOX;
    public static final int COL_IDX_TEXT_SECONDARY;
    public static final int COL_IDX_OPEN_CLOSED_STATE;
    public static final int STATE_CLOSED;
    public static final int STATE_OPEN;
    public static final int COL_IDX_TEXT_SECONDARY_AVAILABLE_CHOICE;
    public static final int SECONDARY_TEXT_NOT_AVAILABLE;
    public static final int SECONDARY_TEXT_AVAILABLE;
    public static final int COL_IDX_TEXT_SINGLE_LINE;

    default public long getEntryId() {
    }

    default public String getCombinedName() {
    }

    default public int getEntryType() {
    }

    default public ResourceLocator getContactPicture() {
    }

    default public long getUniqueID() {
    }
}

