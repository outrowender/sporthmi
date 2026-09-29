/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.tghu.navi.app.NavigationEnv;
import org.dsi.ifc.global.NavLocation;

public interface GeoCoordinates {
    default public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
    }
}

