/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;

public interface IDSIMapViewerControlListener
extends DSIListener {
    public void updateReady(boolean var1);

    public void updateCurrentViewType(int var1);

    public void updateDayNightView(boolean var1);

    public void updateViewScreenViewPort(Rect var1);

    public void updateViewScreenViewPortMaximum(Rect var1);

    public void updateViewVisible(boolean var1);

    public void updateViewFreeze(boolean var1);

    public void updateZoomLevel(float var1);

    public void updateZoomList(float[] var1);

    public void updateZoomListIndex(int var1);

    public void updateMapRotation(short var1);

    public void updateMapPosition(NavLocationWgs84 var1);

    public void updateMapOrientation(int var1);

    public void updateCarPosition(Point var1);

    public void updateTmcVisible(boolean var1);

    public void updateMapMode(int var1);

    public void updateSelectedPoi(PosInfo var1);

    public void updateSpeedAndFlowVisible(boolean var1);

    public void updateAvailableRoutes(AvailableRoute[] var1);

    public void updateViewPort(ViewPort var1);

    public void updateSoftJumpEnabled(boolean var1);

    public void updateSoftRotationEnabled(boolean var1);

    public void updateSoftTiltEnabled(boolean var1);

    public void updateSoftZoomEnabled(boolean var1);

    public void updateSoftJumpRunning(boolean var1);

    public void updateSoftRotationRunning(boolean var1);

    public void updateSoftTiltRunning(boolean var1);

    public void updateSoftZoomRunning(boolean var1);

    public void updateRouteCalcModeEnabled(boolean var1);

    public void configureFlags(long[] var1);

    public void getInfoForPosition(PosInfo[] var1);

    public void getNumberOfPOIs(long var1);

    public void unpackPOIContainerResult(boolean var1);

    public void updateCurrentLanduseStyle(int var1);

    public void updateCurrentMetricSystem(int var1);

    public void setViewFocusOnBlockResult(int var1);

    public void startToDrawNewRectangleInMapResult(int var1, NavLocationWgs84 var2, NavLocationWgs84 var3);

    public void setSouthWestCornerOfRectangleInMapResult(int var1, NavLocationWgs84 var2);

    public void setNorthEastCornerOfRectangleInMapResult(int var1, NavLocationWgs84 var2);

    public void finishDrawRectangleInMapResult(int var1, NavLocationWgs84 var2, NavLocationWgs84 var3);

    public void updateCityModelMode(int var1);

    public void displayRemainingRangeOfVehicleResult(boolean var1);

    public void touchApproachResult(boolean var1);

    public void setBrandIconStyleResult(int var1);

    public void setGuidanceSymbolResult(int var1);

    public void setHOVLaneVisibilityResult(int var1);

    public void rbGetIDOfSelectedSegmentResult(long var1, int var3);

    public void rbGetRRDToSelectedSegmentResult(long var1, int var3, int var4);

    public void setTollRoadHighLightingResult(boolean var1, int var2);

    public void setMountainPeakMarkerResult(boolean var1, int var2);

    public void setViewFocusOnCombinedRouteListElementsResult(int var1);

    public void suspendMapViewerResult(int var1);

    public void wakeupMapViewerResult(int var1);

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 var1, boolean var2);

    public void updateMapViewerRunLevel(int var1);

    public void updateMapViewerSuspensionSupported(int var1);

    public void updateMapViewerSuspensionAndWakeUpProgress(int var1);

    public void updateAvailableCountryOverviews(String[] var1);

    public void updateGeneralPoiVisibility(boolean var1);

    public void updateHorizonMarkerVisibility(boolean var1);

    public void updateEhCategoryVisibility(int[] var1);
}

