/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public interface IRouteGuidanceListener {
    public void routeGuidanceRequested(Route var1, NavLocation var2);

    public void cancelStartRouteCalculation();
}

