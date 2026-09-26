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
    default public boolean configureFlagsIsActive(boolean bl) {
    }

    default public Point getHotPointPosition() {
    }

    default public boolean getInfoForPositionIsActive() {
    }

    default public boolean getQueueGetInfoForPosition() {
    }

    default public Point getQueueGetInfoForScreenPositionPoint() {
    }

    default public Rect getPendingScreenViewport() {
    }

    default public void setPendingScreenViewport(Rect rect) {
    }

    default public Rect getQueuedScreenViewport() {
    }

    default public void setQueuedScreenViewport(Rect rect) {
    }

    default public void configureFlags(int n, MapFlag[] mapFlagArray) {
    }

    default public void displayRemainingRangeOfVehicle(boolean bl) {
    }

    default public void dragMap(short s, short s2) {
    }

    default public void dragRoute(short s, short s2) {
    }

    default public void ensureTMCVisibility(long l) {
    }

    default public void ensureTrafficEventIconsVisibility(long[] lArray) {
    }

    default public void ensurePoiVisibility(NavLocation[] navLocationArray) {
    }

    default public void getInfoForPosition() {
    }

    default public void getInfoForScreenPosition(Point point) {
    }

    default public void goToTMCMessage(long l) {
    }

    default public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84) {
    }

    default public void setViewPortBorder(int n) {
    }

    default public void rbGetIDOfSelectedSegment() {
    }

    default public void rbGetRRDToSelectedSegment(long l) {
    }

    default public void rbSelectAlternativeRoute(int n) {
    }

    default public void rbSelectNextSegment() {
    }

    default public void rbSelectPreviousSegment() {
    }

    default public void rbSetPosition(int n) {
    }

    default public void selectNextPOI() {
    }

    default public void selectPrevPOI() {
    }

    default public void setBrandIconStyle(int[] nArray, int n) {
    }

    default public void setCarPosition(Point point) {
    }

    default public void setCityModelMode(int n) {
    }

    default public void setCrossHairsColor(boolean bl) {
    }

    default public void setDayView() {
    }

    default public void setEnableRouteCalcMode(boolean bl) {
    }

    default public void setEnableSoftJump(boolean bl) {
    }

    default public void setEnableSoftRotation(boolean bl) {
    }

    default public void setEnableSoftTilt(boolean bl) {
    }

    default public void setEnableSoftZoom(boolean bl) {
    }

    default public void setEnableSoftZoomConditional(boolean bl) {
    }

    default public void setGeneralPoiVisibility(boolean bl) {
    }

    default public void setHotPoint(Point point) {
    }

    default public void setInfoForPositionIsActive(boolean bl) {
    }

    default public void setLandmarksVisible(boolean bl) {
    }

    default public void setLocation(int n, int n2) {
    }

    default public void setLocationByLocation(NavLocation navLocation) {
    }

    default public void setMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void setMapViewportByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
    }

    default public void setMetricSystem(int n) {
    }

    default public void setTemperatureScale(int n) {
    }

    default public void setMobilityHorizonVisibility(boolean bl) {
    }

    default public void setMobilityHorizonZoomMode(int n) {
    }

    default public void setMode(int n) {
    }

    default public void setNightView() {
    }

    default public void setOrientation(int n) {
    }

    default public void setPictureNavigationIconVisibility(boolean bl, int n) {
    }

    default public void setRotation(short s) {
    }

    default public void setScrollByCrossHairs(boolean bl) {
    }

    default public void setScrollByCrossHairsBoundingBox(Rect rect) {
    }

    default public void setTrafficMapStyle(boolean bl) {
    }

    default public void setViewType(int n) {
    }

    default public void setZoomArea(Rect rect) {
    }

    default public void setZoomListIndex(int n) {
    }

    default public void showSpeedAndFlowCongestions(boolean bl) {
    }

    default public void showSpeedAndFlowFreeflow(boolean bl) {
    }

    default public void showTMCMessages(boolean bl) {
    }

    default public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
    }

    default public void startScrollToDirection(int n) {
    }

    default public void stopScrollToDirection() {
    }

    default public void suspendMapViewer() {
    }

    default public void viewFreeze(boolean bl) {
    }

    default public void viewSetScreenViewport(Rect rect) {
    }

    default public void viewSetScreenViewportMaximum(Rect rect) {
    }

    default public void viewSetVisible(boolean bl) {
    }

    default public void wakeupMapViewer() {
    }

    default public void setZoomLevel(float f2) {
    }

    default public void setDragRouteMarker(int n) {
    }

    default public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
    }

    default public void highlightRouteBasedOnLength(long l, long l2, int n) {
    }

    default public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetCategoryVisibilityToDefault(int n) {
    }

    default public void setWeatherVisualization(boolean bl) {
    }

    default public void setHorizonMarkerVisibility(boolean bl) {
    }

    default public void setRouteColoringPolicy(int n) {
    }

    default public void setFrameRateMode(int n) {
    }

    default public void setSpeedAndFlowRoadClass(int n) {
    }

    default public void setMapOverlays(int n, MapOverlay[] mapOverlayArray, int n2, int n3) {
    }

    default public void setRouteVisibility(boolean bl) {
    }

    default public void setVisibleRoutes(NavSegmentID[] navSegmentIDArray) {
    }

    default public float getRequestedZoomLevel() {
    }
}

