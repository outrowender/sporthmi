/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.navi.app.map.command.AbstractMapCommand;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;

public abstract class MapCommand
extends AbstractMapCommand
implements IDSIMapViewerControlListener {
    public MapCommand(String string) {
        super(string);
    }

    public MapCommand() {
        this((String)null);
    }

    public void configureFlags(long[] lArray) {
        this.getDispatcher().getDefaultHandler().configureFlags(lArray);
    }

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.getDispatcher().getDefaultHandler().isDetailedMapMaterialAvailable(navLocationWgs84, bl);
    }

    public void updateReady(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateReady(bl);
    }

    public void updateCurrentViewType(int n) {
        this.getDispatcher().getDefaultHandler().updateCurrentViewType(n);
    }

    public void updateDayNightView(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateDayNightView(bl);
    }

    public void updateViewScreenViewPort(Rect rect) {
        this.getDispatcher().getDefaultHandler().updateViewScreenViewPort(rect);
    }

    public void updateViewScreenViewPortMaximum(Rect rect) {
        this.getDispatcher().getDefaultHandler().updateViewScreenViewPortMaximum(rect);
    }

    public void updateViewVisible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateViewVisible(bl);
    }

    public void updateViewFreeze(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateViewFreeze(bl);
    }

    public void updateZoomLevel(float f2) {
        this.getDispatcher().getDefaultHandler().updateZoomLevel(f2);
    }

    public void updateZoomList(float[] fArray) {
        this.getDispatcher().getDefaultHandler().updateZoomList(fArray);
    }

    public void updateZoomListIndex(int n) {
        this.getDispatcher().getDefaultHandler().updateZoomListIndex(n);
    }

    public void updateMapRotation(short s) {
        this.getDispatcher().getDefaultHandler().updateMapRotation(s);
    }

    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        this.getDispatcher().getDefaultHandler().updateMapPosition(navLocationWgs84);
    }

    public void updateMapOrientation(int n) {
        this.getDispatcher().getDefaultHandler().updateMapOrientation(n);
    }

    public void updateCarPosition(Point point) {
        this.getDispatcher().getDefaultHandler().updateCarPosition(point);
    }

    public void updateTmcVisible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateTmcVisible(bl);
    }

    public void updateMapMode(int n) {
        this.getDispatcher().getDefaultHandler().updateMapMode(n);
    }

    public void updateSelectedPoi(PosInfo posInfo) {
        this.getDispatcher().getDefaultHandler().updateSelectedPoi(posInfo);
    }

    public void updateSpeedAndFlowVisible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSpeedAndFlowVisible(bl);
    }

    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
        this.getDispatcher().getDefaultHandler().updateAvailableRoutes(availableRouteArray);
    }

    public void updateViewPort(ViewPort viewPort) {
        this.getDispatcher().getDefaultHandler().updateViewPort(viewPort);
    }

    public void updateSoftJumpEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftJumpEnabled(bl);
    }

    public void updateSoftRotationEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftRotationEnabled(bl);
    }

    public void updateSoftTiltEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftTiltEnabled(bl);
    }

    public void updateSoftZoomEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftZoomEnabled(bl);
    }

    public void updateSoftJumpRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftJumpRunning(bl);
    }

    public void updateSoftRotationRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftRotationRunning(bl);
    }

    public void updateSoftTiltRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftTiltRunning(bl);
    }

    public void updateSoftZoomRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftZoomRunning(bl);
    }

    public void updateRouteCalcModeEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRouteCalcModeEnabled(bl);
    }

    public void getInfoForPosition(PosInfo[] posInfoArray) {
        this.getDispatcher().getDefaultHandler().getInfoForPosition(posInfoArray);
    }

    public void getNumberOfPOIs(long l) {
        this.getDispatcher().getDefaultHandler().getNumberOfPOIs(l);
    }

    public void unpackPOIContainerResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().unpackPOIContainerResult(bl);
    }

    public void updateCurrentLanduseStyle(int n) {
        this.getDispatcher().getDefaultHandler().updateCurrentLanduseStyle(n);
    }

    public void updateCurrentMetricSystem(int n) {
        this.getDispatcher().getDefaultHandler().updateCurrentMetricSystem(n);
    }

    public void setViewFocusOnBlockResult(int n) {
        this.getDispatcher().getDefaultHandler().setViewFocusOnBlockResult(n);
    }

    public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.getDispatcher().getDefaultHandler().startToDrawNewRectangleInMapResult(n, navLocationWgs84, navLocationWgs842);
    }

    public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.getDispatcher().getDefaultHandler().setSouthWestCornerOfRectangleInMapResult(n, navLocationWgs84);
    }

    public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.getDispatcher().getDefaultHandler().setNorthEastCornerOfRectangleInMapResult(n, navLocationWgs84);
    }

    public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.getDispatcher().getDefaultHandler().finishDrawRectangleInMapResult(n, navLocationWgs84, navLocationWgs842);
    }

    public void updateCityModelMode(int n) {
        this.getDispatcher().getDefaultHandler().updateCityModelMode(n);
    }

    public void displayRemainingRangeOfVehicleResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().displayRemainingRangeOfVehicleResult(bl);
    }

    public void touchApproachResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().touchApproachResult(bl);
    }

    public void setBrandIconStyleResult(int n) {
        this.getDispatcher().getDefaultHandler().setBrandIconStyleResult(n);
    }

    public void setGuidanceSymbolResult(int n) {
        this.getDispatcher().getDefaultHandler().setGuidanceSymbolResult(n);
    }

    public void setHOVLaneVisibilityResult(int n) {
        this.getDispatcher().getDefaultHandler().setHOVLaneVisibilityResult(n);
    }

    public void rbGetIDOfSelectedSegmentResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().rbGetIDOfSelectedSegmentResult(l, n);
    }

    public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
        this.getDispatcher().getDefaultHandler().rbGetRRDToSelectedSegmentResult(l, n, n2);
    }

    public void setTollRoadHighLightingResult(boolean bl, int n) {
        this.getDispatcher().getDefaultHandler().setTollRoadHighLightingResult(bl, n);
    }

    public void setMountainPeakMarkerResult(boolean bl, int n) {
        this.getDispatcher().getDefaultHandler().setMountainPeakMarkerResult(bl, n);
    }

    public void setViewFocusOnCombinedRouteListElementsResult(int n) {
        this.getDispatcher().getDefaultHandler().setViewFocusOnCombinedRouteListElementsResult(n);
    }

    public void suspendMapViewerResult(int n) {
        this.getDispatcher().getDefaultHandler().suspendMapViewerResult(n);
    }

    public void wakeupMapViewerResult(int n) {
        this.getDispatcher().getDefaultHandler().wakeupMapViewerResult(n);
    }

    public void updateMapViewerRunLevel(int n) {
        this.getDispatcher().getDefaultHandler().updateMapViewerRunLevel(n);
    }

    public void updateMapViewerSuspensionSupported(int n) {
        this.getDispatcher().getDefaultHandler().updateMapViewerSuspensionSupported(n);
    }

    public void updateMapViewerSuspensionAndWakeUpProgress(int n) {
        this.getDispatcher().getDefaultHandler().updateMapViewerSuspensionAndWakeUpProgress(n);
    }

    public void updateAvailableCountryOverviews(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateAvailableCountryOverviews(stringArray);
    }

    public void updateGeneralPoiVisibility(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateGeneralPoiVisibility(bl);
    }

    public void updateHorizonMarkerVisibility(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateHorizonMarkerVisibility(bl);
    }

    public void updateEhCategoryVisibility(int[] nArray) {
        this.getDispatcher().getDefaultHandler().updateEhCategoryVisibility(nArray);
    }
}

