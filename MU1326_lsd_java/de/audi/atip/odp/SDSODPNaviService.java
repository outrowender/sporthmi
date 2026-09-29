/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SDSListEntry;

public interface SDSODPNaviService {
    public static final int POI_CATEGORY_ID_PARKING;
    public static final int POI_CATEGORY_ID_RESTAURANT;
    public static final int POI_CATEGORY_ID_CHINESE;
    public static final int POI_CATEGORY_ID_ITALIAN;
    public static final byte POI_SEARCH_AREA_NATIONWIDE;
    public static final byte POI_SEARCH_AREA_CURRENT_POSITION;
    public static final byte POI_SEARCH_AREA_TARGET_POSITION;
    public static final byte POI_SEARCH_AREA_ALONG_ROUTE;
    public static final byte POI_SEARCH_AREA_OTHER_TOWN;
    public static final byte POI_SEARCH_AREA_OTHER_COUNTRY;
    public static final byte POI_SEARCH_AREA_STOPOVER_POSITION;

    default public void startRouteGuidance() {
    }

    default public void stopRouteGuidance() {
    }

    default public void setDestination(SDSListEntry sDSListEntry, SDSListEntry sDSListEntry2, SDSListEntry sDSListEntry3) {
    }

    default public byte setPOISearchArea(byte by) {
    }

    default public void selectPOIByUID(int n) {
    }

    default public void selectPOIByListIndex(int n) {
    }
}

