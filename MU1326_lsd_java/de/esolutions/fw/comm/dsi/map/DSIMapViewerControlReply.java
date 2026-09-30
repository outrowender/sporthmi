/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public interface DSIMapViewerControlReply {
    public static final String IPL_COMM_UUID = "e30ae106-0f98-5a42-ab6e-6d13db6eb9c9";
    public static final String IPL_COMM_INTERFACE_KEY = "e68a4e75-d2e3-5fbd-a4ae-20e01e394b5c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public void updateReady(boolean var1, int var2) throws MethodException;

    public void updateCurrentViewType(int var1, int var2) throws MethodException;

    public void updateDayNightView(boolean var1, int var2) throws MethodException;

    public void updateViewScreenViewPort(Rect var1, int var2) throws MethodException;

    public void updateViewScreenViewPortMaximum(Rect var1, int var2) throws MethodException;

    public void updateViewVisible(boolean var1, int var2) throws MethodException;

    public void updateViewFreeze(boolean var1, int var2) throws MethodException;

    public void updateZoomLevel(float var1, int var2) throws MethodException;

    public void updateZoomList(float[] var1, int var2) throws MethodException;

    public void updateZoomListIndex(int var1, int var2) throws MethodException;

    public void updateMapRotation(short var1, int var2) throws MethodException;

    public void updateMapPosition(NavLocationWgs84 var1, int var2) throws MethodException;

    public void updateMapOrientation(int var1, int var2) throws MethodException;

    public void updateCarPosition(Point var1, int var2) throws MethodException;

    public void updateTmcVisible(boolean var1, int var2) throws MethodException;

    public void updateMapMode(int var1, int var2) throws MethodException;

    public void updateSelectedPoi(PosInfo var1, int var2) throws MethodException;

    public void updateSpeedAndFlowVisible(boolean var1, int var2) throws MethodException;

    public void updateAvailableRoutes(AvailableRoute[] var1, int var2) throws MethodException;

    public void updateViewPort(ViewPort var1, int var2) throws MethodException;

    public void updateSoftJumpEnabled(boolean var1, int var2) throws MethodException;

    public void updateSoftRotationEnabled(boolean var1, int var2) throws MethodException;

    public void updateSoftTiltEnabled(boolean var1, int var2) throws MethodException;

    public void updateSoftZoomEnabled(boolean var1, int var2) throws MethodException;

    public void updateSoftJumpRunning(boolean var1, int var2) throws MethodException;

    public void updateSoftRotationRunning(boolean var1, int var2) throws MethodException;

    public void updateSoftTiltRunning(boolean var1, int var2) throws MethodException;

    public void updateSoftZoomRunning(boolean var1, int var2) throws MethodException;

    public void updateRouteCalcModeEnabled(boolean var1, int var2) throws MethodException;

    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo var1, int var2) throws MethodException;

    public void configureFlags(long[] var1) throws MethodException;

    public void getInfoForPosition(PosInfo[] var1) throws MethodException;

    public void getNumberOfPOIs(long var1) throws MethodException;

    public void unpackPOIContainerResult(boolean var1) throws MethodException;

    public void updateCurrentLanduseStyle(int var1, int var2) throws MethodException;

    public void updateCurrentMetricSystem(int var1, int var2) throws MethodException;

    public void setViewFocusOnBlockResult(int var1) throws MethodException;

    public void startToDrawNewRectangleInMapResult(int var1, NavLocationWgs84 var2, NavLocationWgs84 var3) throws MethodException;

    public void setSouthWestCornerOfRectangleInMapResult(int var1, NavLocationWgs84 var2) throws MethodException;

    public void setNorthEastCornerOfRectangleInMapResult(int var1, NavLocationWgs84 var2) throws MethodException;

    public void finishDrawRectangleInMapResult(int var1, NavLocationWgs84 var2, NavLocationWgs84 var3) throws MethodException;

    public void updateCityModelMode(int var1, int var2) throws MethodException;

    public void displayRemainingRangeOfVehicleResult(boolean var1) throws MethodException;

    public void touchApproachResult(boolean var1) throws MethodException;

    public void setBrandIconStyleResult(int var1) throws MethodException;

    public void setGuidanceSymbolResult(int var1) throws MethodException;

    public void setHOVLaneVisibilityResult(int var1) throws MethodException;

    public void rbGetIDOfSelectedSegmentResult(long var1, int var3) throws MethodException;

    public void rbGetRRDToSelectedSegmentResult(long var1, int var3, int var4) throws MethodException;

    public void setTollRoadHighLightingResult(boolean var1, int var2) throws MethodException;

    public void setMountainPeakMarkerResult(boolean var1, int var2) throws MethodException;

    public void suspendMapViewerResult(int var1) throws MethodException;

    public void wakeupMapViewerResult(int var1) throws MethodException;

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 var1, boolean var2) throws MethodException;

    public void updateMapViewerRunLevel(int var1, int var2) throws MethodException;

    public void updateMapViewerSuspensionSupported(int var1, int var2) throws MethodException;

    public void updateMapViewerSuspensionAndWakeUpProgress(int var1, int var2) throws MethodException;

    public void updateAvailableCountryOverviews(String[] var1, int var2) throws MethodException;

    public void updateGeneralPoiVisibility(boolean var1, int var2) throws MethodException;

    public void updateHorizonMarkerVisibility(boolean var1, int var2) throws MethodException;

    public void updateDragRoutePosition(NavLocationWgs84 var1, int var2) throws MethodException;

    public void updateEhCategoryVisibility(int[] var1, int var2) throws MethodException;

    public void setMapOverlaysResult(int var1, int var2) throws MethodException;

    public void updateMapLayerAvailable(int[] var1, int var2) throws MethodException;

    public void updateMapLayerVisible(int[] var1, int var2) throws MethodException;

    public void updateTemperatureScale(int var1, int var2) throws MethodException;

    public void updateSpeedAndFlowRoadClass(int var1, int var2) throws MethodException;

    public void updateRouteVisibility(boolean var1, int var2) throws MethodException;

    public void updateSoftAnimationSpeed(int var1, int var2) throws MethodException;

    public void updateMapStyle(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

