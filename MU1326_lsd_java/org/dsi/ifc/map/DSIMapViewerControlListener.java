/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public interface DSIMapViewerControlListener
extends DSIListener {
    public void updateReady(boolean var1, int var2);

    public void updateCurrentViewType(int var1, int var2);

    public void updateDayNightView(boolean var1, int var2);

    public void updateViewScreenViewPort(Rect var1, int var2);

    public void updateViewScreenViewPortMaximum(Rect var1, int var2);

    public void updateViewVisible(boolean var1, int var2);

    public void updateViewFreeze(boolean var1, int var2);

    public void updateZoomLevel(float var1, int var2);

    public void updateZoomList(float[] var1, int var2);

    public void updateZoomListIndex(int var1, int var2);

    public void updateMapRotation(short var1, int var2);

    public void updateMapPosition(NavLocationWgs84 var1, int var2);

    public void updateMapOrientation(int var1, int var2);

    public void updateCarPosition(Point var1, int var2);

    public void updateTmcVisible(boolean var1, int var2);

    public void updateMapMode(int var1, int var2);

    public void updateSelectedPoi(PosInfo var1, int var2);

    public void updateSpeedAndFlowVisible(boolean var1, int var2);

    public void updateAvailableRoutes(AvailableRoute[] var1, int var2);

    public void updateViewPort(ViewPort var1, int var2);

    public void updateSoftJumpEnabled(boolean var1, int var2);

    public void updateSoftRotationEnabled(boolean var1, int var2);

    public void updateSoftTiltEnabled(boolean var1, int var2);

    public void updateSoftZoomEnabled(boolean var1, int var2);

    public void updateSoftJumpRunning(boolean var1, int var2);

    public void updateSoftRotationRunning(boolean var1, int var2);

    public void updateSoftTiltRunning(boolean var1, int var2);

    public void updateSoftZoomRunning(boolean var1, int var2);

    public void updateRouteCalcModeEnabled(boolean var1, int var2);

    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo var1, int var2);

    public void configureFlags(long[] var1);

    public void getInfoForPosition(PosInfo[] var1);

    public void getNumberOfPOIs(long var1);

    public void unpackPOIContainerResult(boolean var1);

    public void updateCurrentLanduseStyle(int var1, int var2);

    public void updateCurrentMetricSystem(int var1, int var2);

    public void setViewFocusOnBlockResult(int var1);

    public void startToDrawNewRectangleInMapResult(int var1, NavLocationWgs84 var2, NavLocationWgs84 var3);

    public void setSouthWestCornerOfRectangleInMapResult(int var1, NavLocationWgs84 var2);

    public void setNorthEastCornerOfRectangleInMapResult(int var1, NavLocationWgs84 var2);

    public void finishDrawRectangleInMapResult(int var1, NavLocationWgs84 var2, NavLocationWgs84 var3);

    public void updateCityModelMode(int var1, int var2);

    public void displayRemainingRangeOfVehicleResult(boolean var1);

    public void touchApproachResult(boolean var1);

    public void setBrandIconStyleResult(int var1);

    public void setGuidanceSymbolResult(int var1);

    public void setHOVLaneVisibilityResult(int var1);

    public void rbGetIDOfSelectedSegmentResult(long var1, int var3);

    public void rbGetRRDToSelectedSegmentResult(long var1, int var3, int var4);

    public void setTollRoadHighLightingResult(boolean var1, int var2);

    public void setMountainPeakMarkerResult(boolean var1, int var2);

    public void suspendMapViewerResult(int var1);

    public void wakeupMapViewerResult(int var1);

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 var1, boolean var2);

    public void updateMapViewerRunLevel(int var1, int var2);

    public void updateMapViewerSuspensionSupported(int var1, int var2);

    public void updateMapViewerSuspensionAndWakeUpProgress(int var1, int var2);

    public void updateAvailableCountryOverviews(String[] var1, int var2);

    public void updateGeneralPoiVisibility(boolean var1, int var2);

    public void updateHorizonMarkerVisibility(boolean var1, int var2);

    public void updateDragRoutePosition(NavLocationWgs84 var1, int var2);

    public void updateEhCategoryVisibility(int[] var1, int var2);

    public void setMapOverlaysResult(int var1, int var2);

    public void updateMapLayerAvailable(int[] var1, int var2);

    public void updateMapLayerVisible(int[] var1, int var2);

    public void updateTemperatureScale(int var1, int var2);

    public void updateSpeedAndFlowRoadClass(int var1, int var2);

    public void updateRouteVisibility(boolean var1, int var2);

    public void updateSoftAnimationSpeed(int var1, int var2);

    public void updateMapStyle(int var1, int var2);
}

