/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.GeoCoordinates;
import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.tghu.navi.app.NavigationEnv;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordinatesActiveDestinations
implements GeoCoordinates {
    private final ActiveDestinationsManager activeDestinationsManager;

    public GeoCoordinatesActiveDestinations(ActiveDestinationsManager activeDestinationsManager) {
        this.activeDestinationsManager = activeDestinationsManager;
    }

    public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
        return this.activeDestinationsManager.getNavLocation(n2);
    }
}

