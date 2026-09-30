/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface IDSIMVControl {
    public boolean configureFlagsIsActive(boolean var1);

    public Point getHotPointPosition();

    public boolean getInfoForPositionIsActive();

    public boolean getQueueGetInfoForPosition();

    public Point getQueueGetInfoForScreenPositionPoint();

    public Rect getPendingScreenViewport();

    public void setPendingScreenViewport(Rect var1);

    public Rect getQueuedScreenViewport();

    public void setQueuedScreenViewport(Rect var1);

    public void configureFlags(int var1, MapFlag[] var2);

    public void displayRemainingRangeOfVehicle(boolean var1);

    public void dragMap(short var1, short var2);

    public void dragRoute(short var1, short var2);

    public void ensureTMCVisibility(long var1);

    public void ensureTrafficEventIconsVisibility(long[] var1);

    public void ensurePoiVisibility(NavLocation[] var1);

    public void getInfoForPosition();

    public void getInfoForScreenPosition(Point var1);

    public void goToTMCMessage(long var1);

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 var1);

    public void setViewPortBorder(int var1);

    public void rbGetIDOfSelectedSegment();

    public void rbGetRRDToSelectedSegment(long var1);

    public void rbSelectAlternativeRoute(int var1);

    public void rbSelectNextSegment();

    public void rbSelectPreviousSegment();

    public void rbSetPosition(int var1);

    public void selectNextPOI();

    public void selectPrevPOI();

    public void setBrandIconStyle(int[] var1, int var2);

    public void setCarPosition(Point var1);

    public void setCityModelMode(int var1);

    public void setCrossHairsColor(boolean var1);

    public void setDayView();

    public void setEnableRouteCalcMode(boolean var1);

    public void setEnableSoftJump(boolean var1);

    public void setEnableSoftRotation(boolean var1);

    public void setEnableSoftTilt(boolean var1);

    public void setEnableSoftZoom(boolean var1);

    public void setEnableSoftZoomConditional(boolean var1);

    public void setGeneralPoiVisibility(boolean var1);

    public void setHotPoint(Point var1);

    public void setInfoForPositionIsActive(boolean var1);

    public void setLandmarksVisible(boolean var1);

    public void setLocation(int var1, int var2);

    public void setLocationByLocation(NavLocation var1);

    public void setMapPosition(NavLocationWgs84 var1);

    public void setMapViewportByLD(NavLocation var1, NavLocation var2, int var3);

    public void setMetricSystem(int var1);

    public void setTemperatureScale(int var1);

    public void setMobilityHorizonVisibility(boolean var1);

    public void setMobilityHorizonZoomMode(int var1);

    public void setMode(int var1);

    public void setNightView();

    public void setOrientation(int var1);

    public void setPictureNavigationIconVisibility(boolean var1, int var2);

    public void setRotation(short var1);

    public void setScrollByCrossHairs(boolean var1);

    public void setScrollByCrossHairsBoundingBox(Rect var1);

    public void setTrafficMapStyle(boolean var1);

    public void setViewType(int var1);

    public void setZoomArea(Rect var1);

    public void setZoomListIndex(int var1);

    public void showSpeedAndFlowCongestions(boolean var1);

    public void showSpeedAndFlowFreeflow(boolean var1);

    public void showTMCMessages(boolean var1);

    public void startRouteDragging(NavLocationWgs84 var1);

    public void startScrollToDirection(int var1);

    public void stopScrollToDirection();

    public void suspendMapViewer();

    public void viewFreeze(boolean var1);

    public void viewSetScreenViewport(Rect var1);

    public void viewSetScreenViewportMaximum(Rect var1);

    public void viewSetVisible(boolean var1);

    public void wakeupMapViewer();

    public void setZoomLevel(float var1);

    public void setDragRouteMarker(int var1);

    public void setMapViewPortByWGS84Rectangle(NavRectangle var1, int var2);

    public void highlightRouteBasedOnLength(long var1, long var3, int var5);

    public void ehSetCategoryVisibility(int var1, int[] var2, boolean[] var3);

    public void ehSetCategoryVisibilityToDefault(int var1);

    public void setWeatherVisualization(boolean var1);

    public void setHorizonMarkerVisibility(boolean var1);

    public void setRouteColoringPolicy(int var1);

    public void setFrameRateMode(int var1);

    public void setSpeedAndFlowRoadClass(int var1);

    public void setMapOverlays(int var1, MapOverlay[] var2, int var3, int var4);

    public void setRouteVisibility(boolean var1);

    public void setVisibleRoutes(NavSegmentID[] var1);

    public float getRequestedZoomLevel();
}

