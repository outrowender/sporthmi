/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.rows.AdbEntryListRow;
import org.dsi.ifc.organizer.AdbEntry;

public class NaviAdbEntryListRow
extends AdbEntryListRow {
    private static final int MAX_COLUMNS;
    public static final int COL_IDX_LAYOUT;
    public static final int COL_IDX_ICONID;
    public static final int COL_IDX_TEXTLINE1;
    public static final int COL_IDX_PROPERTIES;
    public static final int LAYOUT_ADB_ADDRESS_DATA;
    private final String addressLine;

    public NaviAdbEntryListRow(AdbEntry adbEntry, String string, int n, PropertyListCell propertyListCell) {
        super(NaviSearchResultListRow.generateID(), 7, adbEntry, n);
        this.addressLine = string;
        this.setLayOut(6);
        this.setTextLine(string);
        this.setIconID(n);
        this.setProperty(propertyListCell);
    }

    protected NaviAdbEntryListRow(NaviAdbEntryListRow naviAdbEntryListRow) {
        this(naviAdbEntryListRow.getAdbEntry(), naviAdbEntryListRow.getAddressLine(), naviAdbEntryListRow.getAdbType(), (PropertyListCell)naviAdbEntryListRow.getCell(4));
    }

    @Override
    public EvoListRow copy() {
        return new NaviAdbEntryListRow(this);
    }

    public String getAddressLine() {
        return this.addressLine;
    }

    public final void setLayOut(int n) {
        this.setInteger(0, n);
    }

    public final void setIconID(int n) {
        this.setInteger(1, n);
    }

    public final void setTextLine(String string) {
        this.setText(2, string);
    }

    public final void setProperty(PropertyListCell propertyListCell) {
        this.setPropertyCell(4, propertyListCell);
    }
}

