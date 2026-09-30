/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class PoiSearchArea {
    public static final int SEARCH_CONTEXT_LOCATION_VICINITY = 0;
    public static final int SEARCH_CONTEXT_ALONG_ROUTE = 1;
    public static final int SEARCH_CONTEXT_DESTINATION_VICINITY = 2;
    public static final int SEARCH_CONTEXT_STOPOVER_VICINITY = 3;
    public static final int SEARCH_CONTEXT_CITY = 4;
    public static final int SEARCH_CONTEXT_COUNTRY = 5;
    private volatile int searchContext = 0;
    private volatile NavLocation location = null;
    private final LogChannel logChannel;

    public PoiSearchArea(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public int getSearchContext() {
        return this.searchContext;
    }

    public void setSearchContext(int n) {
        this.searchContext = n;
    }

    public NavLocation getLocation() {
        return this.location;
    }

    public void setLocation(NavLocation navLocation) {
        this.location = navLocation;
    }

    public PosPosition getLocationAsPosPosition() {
        if (this.location == null) {
            this.logChannel.log(100000, "PoiSearchArea#getLocationAsPosPosition call but location is null");
            return null;
        }
        PosPosition posPosition = new PosPosition();
        posPosition.longitude = this.location.longitude;
        posPosition.latitude = this.location.latitude;
        return posPosition;
    }
}

