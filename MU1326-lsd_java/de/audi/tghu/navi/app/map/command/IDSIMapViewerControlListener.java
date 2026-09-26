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
    default public void updateReady(boolean bl) {
    }

    default public void updateCurrentViewType(int n) {
    }

    default public void updateDayNightView(boolean bl) {
    }

    default public void updateViewScreenViewPort(Rect rect) {
    }

    default public void updateViewScreenViewPortMaximum(Rect rect) {
    }

    default public void updateViewVisible(boolean bl) {
    }

    default public void updateViewFreeze(boolean bl) {
    }

    default public void updateZoomLevel(float f2) {
    }

    default public void updateZoomList(float[] fArray) {
    }

    default public void updateZoomListIndex(int n) {
    }

    default public void updateMapRotation(short s) {
    }

    default public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void updateMapOrientation(int n) {
    }

    default public void updateCarPosition(Point point) {
    }

    default public void updateTmcVisible(boolean bl) {
    }

    default public void updateMapMode(int n) {
    }

    default public void updateSelectedPoi(PosInfo posInfo) {
    }

    default public void updateSpeedAndFlowVisible(boolean bl) {
    }

    default public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
    }

    default public void updateViewPort(ViewPort viewPort) {
    }

    default public void updateSoftJumpEnabled(boolean bl) {
    }

    default public void updateSoftRotationEnabled(boolean bl) {
    }

    default public void updateSoftTiltEnabled(boolean bl) {
    }

    default public void updateSoftZoomEnabled(boolean bl) {
    }

    default public void updateSoftJumpRunning(boolean bl) {
    }

    default public void updateSoftRotationRunning(boolean bl) {
    }

    default public void updateSoftTiltRunning(boolean bl) {
    }

    default public void updateSoftZoomRunning(boolean bl) {
    }

    default public void updateRouteCalcModeEnabled(boolean bl) {
    }

    default public void configureFlags(long[] lArray) {
    }

    default public void getInfoForPosition(PosInfo[] posInfoArray) {
    }

    default public void getNumberOfPOIs(long l) {
    }

    default public void unpackPOIContainerResult(boolean bl) {
    }

    default public void updateCurrentLanduseStyle(int n) {
    }

    default public void updateCurrentMetricSystem(int n) {
    }

    default public void setViewFocusOnBlockResult(int n) {
    }

    default public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    default public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
    }

    default public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
    }

    default public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    default public void updateCityModelMode(int n) {
    }

    default public void displayRemainingRangeOfVehicleResult(boolean bl) {
    }

    default public void touchApproachResult(boolean bl) {
    }

    default public void setBrandIconStyleResult(int n) {
    }

    default public void setGuidanceSymbolResult(int n) {
    }

    default public void setHOVLaneVisibilityResult(int n) {
    }

    default public void rbGetIDOfSelectedSegmentResult(long l, int n) {
    }

    default public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
    }

    default public void setTollRoadHighLightingResult(boolean bl, int n) {
    }

    default public void setMountainPeakMarkerResult(boolean bl, int n) {
    }

    default public void setViewFocusOnCombinedRouteListElementsResult(int n) {
    }

    default public void suspendMapViewerResult(int n) {
    }

    default public void wakeupMapViewerResult(int n) {
    }

    default public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }

    default public void updateMapViewerRunLevel(int n) {
    }

    default public void updateMapViewerSuspensionSupported(int n) {
    }

    default public void updateMapViewerSuspensionAndWakeUpProgress(int n) {
    }

    default public void updateAvailableCountryOverviews(String[] stringArray) {
    }

    default public void updateGeneralPoiVisibility(boolean bl) {
    }

    default public void updateHorizonMarkerVisibility(boolean bl) {
    }

    default public void updateEhCategoryVisibility(int[] nArray) {
    }
}

