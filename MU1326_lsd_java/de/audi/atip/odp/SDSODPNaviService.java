/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SDSListEntry;
import de.audi.atip.odp.SpeechGrammarListItem;

public interface SDSODPNaviService {
    public static final int POI_CATEGORY_ID_PARKING = 102;
    public static final int POI_CATEGORY_ID_RESTAURANT = 104;
    public static final int POI_CATEGORY_ID_CHINESE = 60127;
    public static final int POI_CATEGORY_ID_ITALIAN = 60134;
    public static final byte POI_SEARCH_AREA_NATIONWIDE = 0;
    public static final byte POI_SEARCH_AREA_CURRENT_POSITION = 1;
    public static final byte POI_SEARCH_AREA_TARGET_POSITION = 2;
    public static final byte POI_SEARCH_AREA_ALONG_ROUTE = 3;
    public static final byte POI_SEARCH_AREA_OTHER_TOWN = 4;
    public static final byte POI_SEARCH_AREA_OTHER_COUNTRY = 5;
    public static final byte POI_SEARCH_AREA_STOPOVER_POSITION = 6;

    public void startRouteGuidance();

    public void stopRouteGuidance();

    public void setDestination(SDSListEntry var1, SDSListEntry var2, SDSListEntry var3);

    public byte setPOISearchArea(byte var1);

    public void selectPOIByUID(int var1);

    public void selectPOIByListIndex(int var1);

    public static class POIEntry
    extends SpeechGrammarListItem {
        private final int distance;
        private final int categoryID;

        public POIEntry(long l, String string, int n, int n2) {
            super(l, string);
            this.categoryID = n;
            this.distance = n2;
        }

        public int getCategoryID() {
            return this.categoryID;
        }

        public int getDistance() {
            return this.distance;
        }

        public String toString() {
            return super.toString() + ", poiCategoryID=" + this.categoryID + ", poiDistance=" + this.distance;
        }
    }
}

