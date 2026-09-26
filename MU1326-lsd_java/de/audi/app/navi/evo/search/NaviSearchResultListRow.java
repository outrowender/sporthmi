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
    public static final int MAX_COLUMNS;
    public static final int COL_IDX_LAYOUT;
    public static final int COL_IDX_ICONID;
    public static final int COL_IDX_TEXTLINE1;
    public static final int COL_IDX_TEXTLINE2;
    public static final int COL_IDX_PROPERTIES;
    public static final int COL_IDX_DISTANCE;
    public static final int COL_IDX_ARROW;
    public static final int COL_IDX_MISSING_PRIMARY_FUEL;
    public static final int COL_IDX_MISSING_SECONDARY_FUEL;
    public static final int LAYOUT_CITY_PART;
    public static final int LAYOUT_DB_ADDRESS;
    public static final int LAYOUT_POI_DYNAMIC_ICON;
    public static final int LAYOUT_ADB_CONTACT;
    public static final int LAYOUT_POI_LAST_DEST;
    public static final int LAYOUT_POI_GENERIC_ICON;
    public static final int LAYOUT_CITY_PART_WITH_DIRECTION;
    public static final int LAYOUT_DB_ADDRESS_WITH_DIRECTION;
    public static final int ICON_ADB_CONTACT;
    public static final int ICON_DB_ADDRESS;
    public static final int ICON_LAST_DEST;
    public static final int ICON_CITY_PART;
    public static final int ICON_FAVORITE;
    public static final int ICON_PRESSROUTE;
    public static final int ICON_INTERSECTION;
    public static final int ICON_POI_CALL;
    private static final int ADB_ARROW_STATE_CLOSED;
    private static final int ADB_ARROW_STATE_OPEN;
    public static final int ICON_FUELTYPE_MISSING_NON;
    public static final int ICON_FUELTYPE_MISSING_PETROL;
    public static final int ICON_FUELTYPE_MISSING_DIESEL;
    public static final int ICON_FUELTYPE_MISSING_LPG;
    public static final int ICON_FUELTYPE_MISSING_CNG;
    public static final int ICON_FUELTYPE_MISSING_E85;
    public static final int ICON_FUELTYPE_MISSING_HYDROGEN;
    public static final int ICON_FUELTYPE_MISSING_ADBLUE;
    public static final int ICON_FUELTYPE_MISSING_ELECTRIC;
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

    @Override
    public EvoListRow copy() {
        return new NaviSearchResultListRow(this);
    }

    public static long generateID() {
        return id_counter++;
    }

    @Override
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

    @Override
    public boolean hasGeoCoordinates() {
        return this.hasGeoCoordinates;
    }

    @Override
    public void setHasGeoCoordinates(boolean bl) {
        this.hasGeoCoordinates = bl;
    }

    @Override
    public boolean hasRRD() {
        return this.showsRRD;
    }

    @Override
    public void setHasRRD(boolean bl) {
        this.showsRRD = bl;
    }

    @Override
    public int getLongitude() {
        return this.longitude;
    }

    @Override
    public int getLatitude() {
        return this.latitude;
    }

    @Override
    public void setLongitude(int n) {
        this.longitude = n;
    }

    @Override
    public void setLatitude(int n) {
        this.latitude = n;
    }

    @Override
    public void setDistanceColumn(Distance distance) {
        this.setMetrics(5, distance);
    }

    @Override
    public void setArrowColumn(int n) {
        this.setInteger(6, n);
    }

    @Override
    public void setLayoutWithDirection() {
        this.setLayout(8);
    }
}

