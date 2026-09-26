/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;

public class PoiOnlineSearchArea {
    private LogChannel logger;
    public static final int SEARCH_CONTEXT_LOCATION_VICINITY;
    public static final int SEARCH_CONTEXT_DESTINATION_VICINITY;
    public static final int SEARCH_CONTEXT_STOPOVER_VICINITY;
    public static final int SEARCH_CONTEXT_NEW_LOCATION;
    private int searchContext = 0;
    private NavLocation poiContext = null;

    public PoiOnlineSearchArea(LogChannel logChannel) {
        this.logger = logChannel;
        logChannel.log(1078071040, "PoiOnlineSearchArea#PoiOnlineSearchArea()");
    }

    public int getSearchContext() {
        return this.searchContext;
    }

    public void setSearchContext(int n, NavLocation navLocation) {
        this.logger.log(1078071040, "PoiOnlineSearchArea#setSearchContext()");
        this.searchContext = n;
        this.poiContext = navLocation;
    }

    public NavLocation getNavLocation() {
        return this.poiContext;
    }

    public void setNavLocation(NavLocation navLocation) {
        this.logger.log(1078071040, "PoiOnlineSearchArea#setPoiContext()");
        this.poiContext = navLocation;
    }

    public boolean useRRD() {
        return this.getSearchContext() == 0;
    }
}

