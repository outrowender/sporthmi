/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SpeechGrammarListItem;

public class SDSODPNaviService$POIEntry
extends SpeechGrammarListItem {
    private final int distance;
    private final int categoryID;

    public SDSODPNaviService$POIEntry(long l, String string, int n, int n2) {
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

    @Override
    public String toString() {
        return new StringBuffer(super.toString()).append(", poiCategoryID=").append(this.categoryID).append(", poiDistance=").append(this.distance).toString();
    }
}

