/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.INaviComponent;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceStateModelAccess;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.routeguidance.RouteEventListener;
import de.audi.tghu.navi.app.rp.TripHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public interface IRouteManager
extends IStartGuidanceManager,
INaviComponent {
    public int getMaxNumberOfDestinations();

    public boolean canAddHardDestinations();

    public boolean canAddSoftDestinations();

    public Route getRoute();

    public Route getFilteredRoute();

    public void resetSettings();

    public TripHandler.TripData getTripDataAuto();

    public void rgNotPossible(int var1);

    public void setTimeMode(int var1);

    public void toggleTimeMode(int var1);

    public void tripDataRefreshed();

    public Route getOffroadRouteFromNavLocation(NavLocation var1, int var2);

    public IRouteGuidanceStateModelAccess getModelAccess();

    public void setRouteEventListener(RouteEventListener var1);

    public void refreshTripData();

    public int getLastSelectedRouteIndex();

    public boolean isDestIndexMatching();
}

