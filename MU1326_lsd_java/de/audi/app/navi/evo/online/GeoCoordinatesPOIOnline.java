/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.GeoCoordinates;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.OnlineSearchController;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordinatesPOIOnline
implements GeoCoordinates {
    private final LogChannel logChannel;
    private final OnlineSearchController onlineSearchController;

    public GeoCoordinatesPOIOnline(LogChannel logChannel, OnlineSearchController onlineSearchController) {
        this.logChannel = logChannel;
        this.onlineSearchController = onlineSearchController;
    }

    public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
        NavLocation navLocation = this.onlineSearchController.getOnlineSearchSequence().getSearchContext().getResultList().getTransformedLocationAt(n2);
        this.logChannel.log(1000000, "GeoCoordinatesPOIOnline#extractGeoCoordinates: position is %1", (Object)navLocation);
        return navLocation;
    }
}

