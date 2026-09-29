/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public interface IRouteGuidanceListener {
    default public void routeGuidanceRequested(Route route, NavLocation navLocation) {
    }

    default public void cancelStartRouteCalculation() {
    }
}

