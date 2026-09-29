/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public interface IRMLModelAccess {
    public static final int SCROLL_DIRECTION_UP;
    public static final int SCROLL_DIRECTION_DOWN;
    public static final int SCROLL_DIRECTION_NO_DIRECTION;

    default public void onUpdateList(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n, long l2, Route route) {
    }

    default public void onStart() {
    }

    default public void updateInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    default public void onUpdateListLength(long l) {
    }

    default public void onStop() {
    }

    default public void onDetailsSelected() {
    }

    default public void onCountryInfoSelected() {
    }

    default public void onTrafficInfoSelected() {
    }

    default public void onNoDetailsSelected() {
    }

    default public void onElementFocused(NavRectangle navRectangle, CombinedRouteListElement combinedRouteListElement) {
    }

    default public void onPoiFocused(NavLocation navLocation, CombinedRouteListElement combinedRouteListElement) {
    }
}

