/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.INaviComponent;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceStateModelAccess;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.routeguidance.RouteEventListener;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public interface IRouteManager
extends IStartGuidanceManager,
INaviComponent {
    default public int getMaxNumberOfDestinations() {
    }

    default public boolean canAddHardDestinations() {
    }

    default public boolean canAddSoftDestinations() {
    }

    default public Route getRoute() {
    }

    default public Route getFilteredRoute() {
    }

    default public void resetSettings() {
    }

    default public TripHandler$TripData getTripDataAuto() {
    }

    default public void rgNotPossible(int n) {
    }

    default public void setTimeMode(int n) {
    }

    default public void toggleTimeMode(int n) {
    }

    default public void tripDataRefreshed() {
    }

    default public Route getOffroadRouteFromNavLocation(NavLocation navLocation, int n) {
    }

    default public IRouteGuidanceStateModelAccess getModelAccess() {
    }

    default public void setRouteEventListener(RouteEventListener routeEventListener) {
    }

    default public void refreshTripData() {
    }

    default public int getLastSelectedRouteIndex() {
    }

    default public boolean isDestIndexMatching() {
    }
}

