/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.GeoCoordinates;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordinatesAdapter
implements GeoCoordinates {
    private final NavLocationExctractor navlocationExtractor;
    protected final NavigationEnv env;

    public GeoCoordinatesAdapter(NavLocationExctractor navLocationExctractor, NavigationEnv navigationEnv) {
        if (navLocationExctractor == null) {
            throw new IllegalArgumentException("NavLocationExtractor cannot be null!");
        }
        if (navigationEnv == null) {
            throw new IllegalArgumentException("NavigationEnv cannot be null!");
        }
        this.navlocationExtractor = navLocationExctractor;
        this.env = navigationEnv;
    }

    public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
        EvoListRow evoListRow = this.env.getBaseListModel(n).getRow(n2);
        return this.navlocationExtractor.extractNavLocationFromRow(evoListRow);
    }
}

