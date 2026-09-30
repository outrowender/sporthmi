/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.tmc.TmcMessage;

public interface ContextUpdateListener {
    public void updateAvailableLanguages(String[] var1);

    public void updateAvailableLayers(LayerProperty[] var1);

    public void updateAvailableRoutes(AvailableRoute[] var1);

    public void updateCarPosition(Point var1);

    public void updateCurrentLanguage(String var1);

    public void updateCurrentViewType(int var1);

    public void updateDayNightView(boolean var1);

    public void updateDestDistance(int var1);

    public void updateDistanceToNextManeuver(int var1);

    public void updateGoogleDataStatus(int var1);

    public void updateLoadKml(boolean[] var1);

    public void updateManoeuvreViewActive(int var1);

    public void updateManoeuvreViewsAvailable(short[] var1);

    public void updateMapMode(int var1);

    public void updateMapOrientation(int var1);

    public void updateMapPosition(NavLocationWgs84 var1);

    public void updateMapRotation(short var1);

    public void updateOnlineResultFlagDetails(int var1);

    public void updatePicNavLocation(NavLocation var1, ResourceLocator var2);

    public void updateReady(boolean var1, int var2);

    public void updateRecommendedZoom(float var1);

    public void updateRgActive(boolean var1);

    public void updateRgRouteCalculationState(int var1);

    public void updateRouteCalcModeEnabled(boolean var1);

    public void updateSoftJumpEnabled(boolean var1);

    public void updateSoftRotationEnabled(boolean var1);

    public void updateSoftTiltEnabled(boolean var1);

    public void updateSoftTiltRunning(boolean var1);

    public void updateTmcMessage(TmcMessage var1);

    public void updateTmcMessagesAhead(TmcMessage[] var1);

    public void updateTmcVisible(boolean var1);

    public void updateViewFreeze(boolean var1);

    public void updateViewPort(ViewPort var1);

    public void updateViewScreenViewPort(Rect var1);

    public void updateViewVisible(boolean var1);

    public void updateVisibleLayers(int[] var1);

    public void updateXTRepresentation(NavLocation var1, String var2);

    public void updateZoomEngineState(int var1);

    public void updateZoomList(float[] var1, int var2, float[] var3);

    public void updateZoomListIndex(int var1);

    public void updateSatelliteDataVisible(boolean var1);

    public void updateDragRoutePosition(NavLocationWgs84 var1);

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation var1);

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] var1);

    public void updateBapManeuverState(int var1);

    public void updateMobilityHorizonStatus(int var1);
}

