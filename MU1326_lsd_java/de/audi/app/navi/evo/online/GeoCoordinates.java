/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.tghu.navi.app.NavigationEnv;
import org.dsi.ifc.global.NavLocation;

public interface GeoCoordinates {
    public NavLocation extractGeoCoordinates(int var1, int var2, NavigationEnv var3);
}

