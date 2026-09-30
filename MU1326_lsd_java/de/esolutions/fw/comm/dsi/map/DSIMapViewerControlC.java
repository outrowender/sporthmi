/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerControlC {
    public void configureFlags(int var1, MapFlag[] var2) throws MethodException;

    public void dragMap(short var1, short var2) throws MethodException;

    public void ensureTMCVisibility(long var1) throws MethodException;

    public void getInfoForPosition() throws MethodException;

    public void getInfoForScreenPosition(Point var1) throws MethodException;

    public void getNumberOfPOIs() throws MethodException;

    public void goToTMCMessage(long var1) throws MethodException;

    public void packPOIContainer() throws MethodException;

    public void rbSelectAlternativeRoute(int var1) throws MethodException;

    public void rbSelectNextSegment() throws MethodException;

    public void rbSelectPreviousSegment() throws MethodException;

    public void rbSetPosition(int var1) throws MethodException;

    public void scrollToDirection(short var1, int var2, short var3) throws MethodException;

    public void selectNextPOI() throws MethodException;

    public void selectPrevPOI() throws MethodException;

    public void set3DLandmarksVisible(boolean var1) throws MethodException;

    public void setCarPosition(Point var1) throws MethodException;

    public void setDayView() throws MethodException;

    public void setEnableRouteCalcMode(boolean var1) throws MethodException;

    public void setEnableSoftJump(boolean var1) throws MethodException;

    public void setEnableSoftRotation(boolean var1) throws MethodException;

    public void setEnableSoftTilt(boolean var1) throws MethodException;

    public void setEnableSoftZoom(boolean var1) throws MethodException;

    public void setHotPoint(Point var1) throws MethodException;

    public void setLocation(int var1, short var2) throws MethodException;

    public void setLocationByLocation(NavLocation var1) throws MethodException;

    public void setLocationByLocationAndView(NavLocation var1, short var2, int var3) throws MethodException;

    public void setMapPosition(NavLocationWgs84 var1) throws MethodException;

    public void setMapViewPort(NavLocationWgs84 var1, short var2, int var3) throws MethodException;

    public void setMapViewPortByLD(NavLocation var1, NavLocation var2, int var3) throws MethodException;

    public void setMode(int var1) throws MethodException;

    public void setNightView() throws MethodException;

    public void setOrientation(int var1, Point var2) throws MethodException;

    public void setRotation(short var1) throws MethodException;

    public void setViewType(int var1) throws MethodException;

    public void setZoomArea(Rect var1) throws MethodException;

    public void setZoomLevel(float var1, int var2) throws MethodException;

    public void setCountryOverviewCountry(String var1) throws MethodException;

    public void showTMCMessages(boolean var1) throws MethodException;

    public void startScrollToDirection(int var1) throws MethodException;

    public void stopScrollToDirection() throws MethodException;

    public void unpackPOIContainer(long var1) throws MethodException;

    public void viewFreeze(boolean var1) throws MethodException;

    public void viewSetScreenViewport(Rect var1) throws MethodException;

    public void viewSetScreenViewportMaximum(Rect var1) throws MethodException;

    public void viewSetVisible(boolean var1) throws MethodException;

    public void setMetricSystem(int var1) throws MethodException;

    public void setViewFocusOnBlock(long[] var1) throws MethodException;

    public void setViewFocusOnPoi(PoiListElement[] var1) throws MethodException;

    public void startToDrawNewRectangleInMap() throws MethodException;

    public void editRectangleInMap(long var1) throws MethodException;

    public void setSouthWestCornerOfRectangleInMap(Point var1) throws MethodException;

    public void setNorthEastCornerOfRectangleInMap(Point var1) throws MethodException;

    public void finishDrawRectangleInMap() throws MethodException;

    public void setCityModelMode(int var1) throws MethodException;

    public void displayRemainingRangeOfVehicle(boolean var1) throws MethodException;

    public void touchApproach(boolean var1) throws MethodException;

    public void setBrandIconStyle(int[] var1, int var2) throws MethodException;

    public void startScrollByVector(int var1, int var2) throws MethodException;

    public void setGuidanceSymbol(int var1) throws MethodException;

    public void setHOVLaneVisibility(boolean var1) throws MethodException;

    public void rbGetIDOfSelectedSegment() throws MethodException;

    public void rbGetRRDToSelectedSegment(long var1) throws MethodException;

    public void setTollRoadHighLighting(boolean var1) throws MethodException;

    public void setMountainPeakMarker(boolean var1) throws MethodException;

    public void setViewFocusOnCombinedRouteListElements(long[] var1) throws MethodException;

    public void setFrameRateMode(int var1) throws MethodException;

    public void setScrollByCrossHairs(boolean var1) throws MethodException;

    public void setScrollByCrossHairsBoundingBox(Rect var1) throws MethodException;

    public void setRouteColoringPolicy(int var1) throws MethodException;

    public void setWeatherVisualization(boolean var1) throws MethodException;

    public void setPictureNavigationIconVisibility(boolean var1, int var2) throws MethodException;

    public void setMobilityHorizonVisibility(boolean var1) throws MethodException;

    public void setTrafficMapStyle(boolean var1) throws MethodException;

    public void showSpeedAndFlowFreeFlow(boolean var1) throws MethodException;

    public void showSpeedAndFlowCongestions(boolean var1) throws MethodException;

    public void showRichContent(boolean var1) throws MethodException;

    public void setGeneralPoiVisibility(boolean var1) throws MethodException;

    public void setCrossHairsColor(int var1) throws MethodException;

    public void setViewPortBorder(int var1) throws MethodException;

    public void setTerrainElevation(boolean var1) throws MethodException;

    public void ensurePoiVisibility(NavLocation[] var1) throws MethodException;

    public void suspendMapViewer() throws MethodException;

    public void wakeupMapViewer() throws MethodException;

    public void setMobilityHorizonZoomMode(int var1) throws MethodException;

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 var1) throws MethodException;

    public void setHorizonMarkerVisibility(boolean var1) throws MethodException;

    public void ensureTrafficEventIconsVisibility(long[] var1) throws MethodException;

    public void setMapViewPortByWGS84Rectangle(NavRectangle var1, int var2) throws MethodException;

    public void startRouteDragging(NavLocationWgs84 var1) throws MethodException;

    public void dragRoute(short var1, short var2) throws MethodException;

    public void setDragRouteMarker(int var1) throws MethodException;

    public void highlightRouteBasedOnLength(long var1, long var3, int var5) throws MethodException;

    public void ehSetCategoryVisibility(int var1, int[] var2, boolean[] var3) throws MethodException;

    public void ehSetCategoryVisibilityToDefault(int var1) throws MethodException;

    public void setMapOverlays(int var1, MapOverlay[] var2, int var3, int var4) throws MethodException;

    public void setMapLayerVisible(int[] var1) throws MethodException;

    public void setTemperatureScale(int var1) throws MethodException;

    public void setSoftAnimationSpeed(int var1) throws MethodException;

    public void setSpeedAndFlowRoadClass(int var1) throws MethodException;

    public void setRouteVisibility(boolean var1) throws MethodException;

    public void setVisibleRoutes(NavSegmentID[] var1) throws MethodException;

    public void showTrafficEventListView(long[] var1, boolean var2, boolean var3) throws MethodException;

    public void setMapStyle(int var1) throws MethodException;

    public void setCopyrightPosition(NavRectangle var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

