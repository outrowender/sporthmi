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

    @Override
    public void configureFlags(long[] lArray) {
        this.getDispatcher().getDefaultHandler().configureFlags(lArray);
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.getDispatcher().getDefaultHandler().isDetailedMapMaterialAvailable(navLocationWgs84, bl);
    }

    @Override
    public void updateReady(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateReady(bl);
    }

    @Override
    public void updateCurrentViewType(int n) {
        this.getDispatcher().getDefaultHandler().updateCurrentViewType(n);
    }

    @Override
    public void updateDayNightView(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateDayNightView(bl);
    }

    @Override
    public void updateViewScreenViewPort(Rect rect) {
        this.getDispatcher().getDefaultHandler().updateViewScreenViewPort(rect);
    }

    @Override
    public void updateViewScreenViewPortMaximum(Rect rect) {
        this.getDispatcher().getDefaultHandler().updateViewScreenViewPortMaximum(rect);
    }

    @Override
    public void updateViewVisible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateViewVisible(bl);
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateViewFreeze(bl);
    }

    @Override
    public void updateZoomLevel(float f2) {
        this.getDispatcher().getDefaultHandler().updateZoomLevel(f2);
    }

    @Override
    public void updateZoomList(float[] fArray) {
        this.getDispatcher().getDefaultHandler().updateZoomList(fArray);
    }

    @Override
    public void updateZoomListIndex(int n) {
        this.getDispatcher().getDefaultHandler().updateZoomListIndex(n);
    }

    @Override
    public void updateMapRotation(short s) {
        this.getDispatcher().getDefaultHandler().updateMapRotation(s);
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        this.getDispatcher().getDefaultHandler().updateMapPosition(navLocationWgs84);
    }

    @Override
    public void updateMapOrientation(int n) {
        this.getDispatcher().getDefaultHandler().updateMapOrientation(n);
    }

    @Override
    public void updateCarPosition(Point point) {
        this.getDispatcher().getDefaultHandler().updateCarPosition(point);
    }

    @Override
    public void updateTmcVisible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateTmcVisible(bl);
    }

    @Override
    public void updateMapMode(int n) {
        this.getDispatcher().getDefaultHandler().updateMapMode(n);
    }

    @Override
    public void updateSelectedPoi(PosInfo posInfo) {
        this.getDispatcher().getDefaultHandler().updateSelectedPoi(posInfo);
    }

    @Override
    public void updateSpeedAndFlowVisible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSpeedAndFlowVisible(bl);
    }

    @Override
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
        this.getDispatcher().getDefaultHandler().updateAvailableRoutes(availableRouteArray);
    }

    @Override
    public void updateViewPort(ViewPort viewPort) {
        this.getDispatcher().getDefaultHandler().updateViewPort(viewPort);
    }

    @Override
    public void updateSoftJumpEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftJumpEnabled(bl);
    }

    @Override
    public void updateSoftRotationEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftRotationEnabled(bl);
    }

    @Override
    public void updateSoftTiltEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftTiltEnabled(bl);
    }

    @Override
    public void updateSoftZoomEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftZoomEnabled(bl);
    }

    @Override
    public void updateSoftJumpRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftJumpRunning(bl);
    }

    @Override
    public void updateSoftRotationRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftRotationRunning(bl);
    }

    @Override
    public void updateSoftTiltRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftTiltRunning(bl);
    }

    @Override
    public void updateSoftZoomRunning(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoftZoomRunning(bl);
    }

    @Override
    public void updateRouteCalcModeEnabled(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRouteCalcModeEnabled(bl);
    }

    @Override
    public void getInfoForPosition(PosInfo[] posInfoArray) {
        this.getDispatcher().getDefaultHandler().getInfoForPosition(posInfoArray);
    }

    @Override
    public void getNumberOfPOIs(long l) {
        this.getDispatcher().getDefaultHandler().getNumberOfPOIs(l);
    }

    @Override
    public void unpackPOIContainerResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().unpackPOIContainerResult(bl);
    }

    @Override
    public void updateCurrentLanduseStyle(int n) {
        this.getDispatcher().getDefaultHandler().updateCurrentLanduseStyle(n);
    }

    @Override
    public void updateCurrentMetricSystem(int n) {
        this.getDispatcher().getDefaultHandler().updateCurrentMetricSystem(n);
    }

    @Override
    public void setViewFocusOnBlockResult(int n) {
        this.getDispatcher().getDefaultHandler().setViewFocusOnBlockResult(n);
    }

    @Override
    public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.getDispatcher().getDefaultHandler().startToDrawNewRectangleInMapResult(n, navLocationWgs84, navLocationWgs842);
    }

    @Override
    public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.getDispatcher().getDefaultHandler().setSouthWestCornerOfRectangleInMapResult(n, navLocationWgs84);
    }

    @Override
    public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.getDispatcher().getDefaultHandler().setNorthEastCornerOfRectangleInMapResult(n, navLocationWgs84);
    }

    @Override
    public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.getDispatcher().getDefaultHandler().finishDrawRectangleInMapResult(n, navLocationWgs84, navLocationWgs842);
    }

    @Override
    public void updateCityModelMode(int n) {
        this.getDispatcher().getDefaultHandler().updateCityModelMode(n);
    }

    @Override
    public void displayRemainingRangeOfVehicleResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().displayRemainingRangeOfVehicleResult(bl);
    }

    @Override
    public void touchApproachResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().touchApproachResult(bl);
    }

    @Override
    public void setBrandIconStyleResult(int n) {
        this.getDispatcher().getDefaultHandler().setBrandIconStyleResult(n);
    }

    @Override
    public void setGuidanceSymbolResult(int n) {
        this.getDispatcher().getDefaultHandler().setGuidanceSymbolResult(n);
    }

    @Override
    public void setHOVLaneVisibilityResult(int n) {
        this.getDispatcher().getDefaultHandler().setHOVLaneVisibilityResult(n);
    }

    @Override
    public void rbGetIDOfSelectedSegmentResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().rbGetIDOfSelectedSegmentResult(l, n);
    }

    @Override
    public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
        this.getDispatcher().getDefaultHandler().rbGetRRDToSelectedSegmentResult(l, n, n2);
    }

    @Override
    public void setTollRoadHighLightingResult(boolean bl, int n) {
        this.getDispatcher().getDefaultHandler().setTollRoadHighLightingResult(bl, n);
    }

    @Override
    public void setMountainPeakMarkerResult(boolean bl, int n) {
        this.getDispatcher().getDefaultHandler().setMountainPeakMarkerResult(bl, n);
    }

    @Override
    public void setViewFocusOnCombinedRouteListElementsResult(int n) {
        this.getDispatcher().getDefaultHandler().setViewFocusOnCombinedRouteListElementsResult(n);
    }

    @Override
    public void suspendMapViewerResult(int n) {
        this.getDispatcher().getDefaultHandler().suspendMapViewerResult(n);
    }

    @Override
    public void wakeupMapViewerResult(int n) {
        this.getDispatcher().getDefaultHandler().wakeupMapViewerResult(n);
    }

    @Override
    public void updateMapViewerRunLevel(int n) {
        this.getDispatcher().getDefaultHandler().updateMapViewerRunLevel(n);
    }

    @Override
    public void updateMapViewerSuspensionSupported(int n) {
        this.getDispatcher().getDefaultHandler().updateMapViewerSuspensionSupported(n);
    }

    @Override
    public void updateMapViewerSuspensionAndWakeUpProgress(int n) {
        this.getDispatcher().getDefaultHandler().updateMapViewerSuspensionAndWakeUpProgress(n);
    }

    @Override
    public void updateAvailableCountryOverviews(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateAvailableCountryOverviews(stringArray);
    }

    @Override
    public void updateGeneralPoiVisibility(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateGeneralPoiVisibility(bl);
    }

    @Override
    public void updateHorizonMarkerVisibility(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateHorizonMarkerVisibility(bl);
    }

    @Override
    public void updateEhCategoryVisibility(int[] nArray) {
        this.getDispatcher().getDefaultHandler().updateEhCategoryVisibility(nArray);
    }
}

