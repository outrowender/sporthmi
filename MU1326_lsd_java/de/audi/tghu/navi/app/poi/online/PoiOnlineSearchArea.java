/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;

public class PoiOnlineSearchArea {
    private LogChannel logger;
    public static final int SEARCH_CONTEXT_LOCATION_VICINITY = 0;
    public static final int SEARCH_CONTEXT_DESTINATION_VICINITY = 1;
    public static final int SEARCH_CONTEXT_STOPOVER_VICINITY = 2;
    public static final int SEARCH_CONTEXT_NEW_LOCATION = 3;
    private int searchContext = 0;
    private NavLocation poiContext = null;

    public PoiOnlineSearchArea(LogChannel logChannel) {
        this.logger = logChannel;
        logChannel.log(1000000, "PoiOnlineSearchArea#PoiOnlineSearchArea()");
    }

    public int getSearchContext() {
        return this.searchContext;
    }

    public void setSearchContext(int n, NavLocation navLocation) {
        this.logger.log(1000000, "PoiOnlineSearchArea#setSearchContext()");
        this.searchContext = n;
        this.poiContext = navLocation;
    }

    public NavLocation getNavLocation() {
        return this.poiContext;
    }

    public void setNavLocation(NavLocation navLocation) {
        this.logger.log(1000000, "PoiOnlineSearchArea#setPoiContext()");
        this.poiContext = navLocation;
    }

    public boolean useRRD() {
        return this.getSearchContext() == 0;
    }
}

