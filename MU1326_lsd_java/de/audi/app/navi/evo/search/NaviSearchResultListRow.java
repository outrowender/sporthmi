/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.metrics.Distance;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.search.IntelliDestDistanceRow;
import org.dsi.ifc.search.SearchResult;

public class NaviSearchResultListRow
extends SearchResultListRow
implements IntelliDestDistanceRow {
    private static long id_counter = 0L;
    public static final int MAX_COLUMNS = 9;
    public static final int COL_IDX_LAYOUT = 0;
    public static final int COL_IDX_ICONID = 1;
    public static final int COL_IDX_TEXTLINE1 = 2;
    public static final int COL_IDX_TEXTLINE2 = 3;
    public static final int COL_IDX_PROPERTIES = 4;
    public static final int COL_IDX_DISTANCE = 5;
    public static final int COL_IDX_ARROW = 6;
    public static final int COL_IDX_MISSING_PRIMARY_FUEL = 7;
    public static final int COL_IDX_MISSING_SECONDARY_FUEL = 8;
    public static final int LAYOUT_CITY_PART = 0;
    public static final int LAYOUT_DB_ADDRESS = 1;
    public static final int LAYOUT_POI_DYNAMIC_ICON = 2;
    public static final int LAYOUT_ADB_CONTACT = 3;
    public static final int LAYOUT_POI_LAST_DEST = 4;
    public static final int LAYOUT_POI_GENERIC_ICON = 5;
    public static final int LAYOUT_CITY_PART_WITH_DIRECTION = 7;
    public static final int LAYOUT_DB_ADDRESS_WITH_DIRECTION = 8;
    public static final int ICON_ADB_CONTACT = 0;
    public static final int ICON_DB_ADDRESS = 1;
    public static final int ICON_LAST_DEST = 2;
    public static final int ICON_CITY_PART = 3;
    public static final int ICON_FAVORITE = 4;
    public static final int ICON_PRESSROUTE = 5;
    public static final int ICON_INTERSECTION = 6;
    public static final int ICON_POI_CALL = 7;
    private static final int ADB_ARROW_STATE_CLOSED = 0;
    private static final int ADB_ARROW_STATE_OPEN = 1;
    public static final int ICON_FUELTYPE_MISSING_NON = 0;
    public static final int ICON_FUELTYPE_MISSING_PETROL = 1;
    public static final int ICON_FUELTYPE_MISSING_DIESEL = 2;
    public static final int ICON_FUELTYPE_MISSING_LPG = 3;
    public static final int ICON_FUELTYPE_MISSING_CNG = 4;
    public static final int ICON_FUELTYPE_MISSING_E85 = 5;
    public static final int ICON_FUELTYPE_MISSING_HYDROGEN = 6;
    public static final int ICON_FUELTYPE_MISSING_ADBLUE = 7;
    public static final int ICON_FUELTYPE_MISSING_ELECTRIC = 8;
    private boolean hasGeoCoordinates;
    private boolean showsRRD;
    private int latitude;
    private int longitude;

    public NaviSearchResultListRow(SearchResult searchResult) {
        super(searchResult, 9, NaviSearchResultListRow.generateID());
    }

    protected NaviSearchResultListRow(NaviSearchResultListRow naviSearchResultListRow) {
        super(naviSearchResultListRow);
        this.hasGeoCoordinates = naviSearchResultListRow.hasGeoCoordinates;
        this.latitude = naviSearchResultListRow.latitude;
        this.longitude = naviSearchResultListRow.longitude;
        this.showsRRD = naviSearchResultListRow.showsRRD;
    }

    public EvoListRow copy() {
        return new NaviSearchResultListRow(this);
    }

    public static long generateID() {
        return id_counter++;
    }

    public void setOpen(boolean bl) {
        super.setOpen(bl);
        this.setInteger(1, bl ? 1 : 0);
    }

    public void setLayout(int n) {
        this.setInteger(0, n);
    }

    public void setDynamicIcon(IconCell iconCell) {
        this.setIconCell(1, iconCell);
    }

    public void setStaticIcon(int n) {
        this.setInteger(1, n);
    }

    public void setTextLine1Column(TextListCellHighlightText textListCellHighlightText) {
        this.setHighlightTextCell(2, textListCellHighlightText);
    }

    public void setTextLine2Column(TextListCellHighlightText textListCellHighlightText) {
        this.setHighlightTextCell(3, textListCellHighlightText);
    }

    public void setPropertiesColumn(PropertyListCell propertyListCell) {
        this.setPropertyCell(4, propertyListCell);
    }

    public boolean hasGeoCoordinates() {
        return this.hasGeoCoordinates;
    }

    public void setHasGeoCoordinates(boolean bl) {
        this.hasGeoCoordinates = bl;
    }

    public boolean hasRRD() {
        return this.showsRRD;
    }

    public void setHasRRD(boolean bl) {
        this.showsRRD = bl;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public void setLongitude(int n) {
        this.longitude = n;
    }

    public void setLatitude(int n) {
        this.latitude = n;
    }

    public void setDistanceColumn(Distance distance) {
        this.setMetrics(5, distance);
    }

    public void setArrowColumn(int n) {
        this.setInteger(6, n);
    }

    public void setLayoutWithDirection() {
        this.setLayout(8);
    }
}

