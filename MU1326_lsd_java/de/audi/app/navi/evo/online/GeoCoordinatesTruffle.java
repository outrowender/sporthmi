/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.GeoCoordinates;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordinatesTruffle
implements GeoCoordinates {
    private int[] latitudeLongitude;
    private LogChannel logChannel;
    private static final String LOGCLASS = "GeoCoordinatesTruffle";
    private final NavLocationExctractor locationExtractor;

    public GeoCoordinatesTruffle(LogChannel logChannel, NavLocationExctractor navLocationExctractor) {
        this.logChannel = logChannel;
        this.locationExtractor = navLocationExctractor;
    }

    public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
        NavLocation navLocation = this.locationExtractor.extractNavLocationFromRow(navigationEnv.getBaseListModel(n).getRow(n2));
        this.logChannel.log(1000000, "GeoCoordinatesTruffle#extractGeoCoordinates: position is %1", (Object)navLocation);
        if (navLocation != null) {
            return navLocation;
        }
        return null;
    }
}

