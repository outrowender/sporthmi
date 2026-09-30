/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;

public class MapViewerDefaultHandler
implements IDSIMapViewerControlListener {
    protected final LogChannel logChannel;

    public MapViewerDefaultHandler(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    protected void warn(String string) {
        this.logChannel.log(10000000, "MapViewerDefaultHandler#%1() - unexpected call", (Object)string);
    }

    public void configureFlags(long[] lArray) {
        this.warn("configureFlags");
    }

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.warn("isDetailedMapMaterialAvailable");
    }

    public void asyncException(int n, String string, int n2) {
        this.warn("asyncException");
    }

    public void updateReady(boolean bl) {
        this.warn("updateReady");
    }

    public void updateCurrentViewType(int n) {
        this.warn("updateCurrentViewType");
    }

    public void updateDayNightView(boolean bl) {
        this.warn("updateDayNightView");
    }

    public void updateViewScreenViewPort(Rect rect) {
        this.warn("updateViewScreenViewPort");
    }

    public void updateViewScreenViewPortMaximum(Rect rect) {
        this.warn("updateViewScreenViewPortMaximum");
    }

    public void updateViewVisible(boolean bl) {
        this.warn("updateViewVisible");
    }

    public void updateViewFreeze(boolean bl) {
        this.warn("updateViewFreeze");
    }

    public void updateZoomLevel(float f2) {
        this.warn("updateZoomLevel");
    }

    public void updateZoomList(float[] fArray) {
        this.warn("updateZoomList");
    }

    public void updateZoomListIndex(int n) {
        this.warn("updateZoomListIndex");
    }

    public void updateMapRotation(short s) {
        this.warn("updateMapRotation");
    }

    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        this.warn("updateMapPosition");
    }

    public void updateMapOrientation(int n) {
        this.warn("updateMapOrientation");
    }

    public void updateCarPosition(Point point) {
        this.warn("updateCarPosition");
    }

    public void updateTmcVisible(boolean bl) {
        this.warn("updateTmcVisible");
    }

    public void updateMapMode(int n) {
        this.warn("updateMapMode");
    }

    public void updateSelectedPoi(PosInfo posInfo) {
        this.warn("updateSelectedPoi");
    }

    public void updateSpeedAndFlowVisible(boolean bl) {
        this.warn("updateSpeedAndFlowVisible");
    }

    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
        this.warn("updateAvailableRoutes");
    }

    public void updateViewPort(ViewPort viewPort) {
        this.warn("updateViewPort");
    }

    public void updateSoftJumpEnabled(boolean bl) {
        this.warn("updateSoftJumpEnabled");
    }

    public void updateSoftRotationEnabled(boolean bl) {
        this.warn("updateSoftRotationEnabled");
    }

    public void updateSoftTiltEnabled(boolean bl) {
        this.warn("updateSoftTiltEnabled");
    }

    public void updateSoftZoomEnabled(boolean bl) {
        this.warn("updateSoftZoomEnabled");
    }

    public void updateSoftJumpRunning(boolean bl) {
        this.warn("updateSoftJumpRunning");
    }

    public void updateSoftRotationRunning(boolean bl) {
        this.warn("updateSoftRotationRunning");
    }

    public void updateSoftTiltRunning(boolean bl) {
        this.warn("updateSoftTiltRunning");
    }

    public void updateSoftZoomRunning(boolean bl) {
        this.warn("updateSoftZoomRunning");
    }

    public void updateRouteCalcModeEnabled(boolean bl) {
        this.warn("updateRouteCalcModeEnabled");
    }

    public void getInfoForPosition(PosInfo[] posInfoArray) {
        this.warn("getInfoForPosition");
    }

    public void getNumberOfPOIs(long l) {
        this.warn("getNumberOfPOIs");
    }

    public void unpackPOIContainerResult(boolean bl) {
        this.warn("unpackPOIContainerResult");
    }

    public void updateCurrentLanduseStyle(int n) {
        this.warn("updateCurrentLanduseStyle");
    }

    public void updateCurrentMetricSystem(int n) {
        this.warn("updateCurrentMetricSystem");
    }

    public void setViewFocusOnBlockResult(int n) {
        this.warn("setViewFocusOnBlockResult");
    }

    public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.warn("startToDrawNewRectangleInMapResult");
    }

    public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.warn("setSouthWestCornerOfRectangleInMapResult");
    }

    public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.warn("setNorthEastCornerOfRectangleInMapResult");
    }

    public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.warn("finishDrawRectangleInMapResult");
    }

    public void updateCityModelMode(int n) {
        this.warn("updateCityModelMode");
    }

    public void displayRemainingRangeOfVehicleResult(boolean bl) {
        this.warn("displayRemainingRangeOfVehicleResult");
    }

    public void touchApproachResult(boolean bl) {
        this.warn("touchApproachResult");
    }

    public void setBrandIconStyleResult(int n) {
        this.warn("setBrandIconStyleResult");
    }

    public void setGuidanceSymbolResult(int n) {
        this.warn("setGuidanceSymbolResult");
    }

    public void setHOVLaneVisibilityResult(int n) {
        this.warn("setHOVLaneVisibilityResult");
    }

    public void rbGetIDOfSelectedSegmentResult(long l, int n) {
        this.warn("rbGetIDOfSelectedSegmentResult");
    }

    public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
        this.warn("rbGetRRDToSelectedSegmentResult");
    }

    public void setTollRoadHighLightingResult(boolean bl, int n) {
        this.warn("setTollRoadHighLightingResult");
    }

    public void setMountainPeakMarkerResult(boolean bl, int n) {
        this.warn("setMountainPeakMarkerResult");
    }

    public void setViewFocusOnCombinedRouteListElementsResult(int n) {
        this.warn("setViewFocusOnCombinedRouteListElementsResult");
    }

    public void suspendMapViewerResult(int n) {
        this.warn("suspendMapViewerResult");
    }

    public void wakeupMapViewerResult(int n) {
        this.warn("wakeupMapViewerResult");
    }

    public void updateMapViewerRunLevel(int n) {
        this.warn("updateMapViewerRunLevel");
    }

    public void updateMapViewerSuspensionSupported(int n) {
        this.warn("updateMapViewerSuspensionSupported");
    }

    public void updateMapViewerSuspensionAndWakeUpProgress(int n) {
        this.warn("updateMapViewerSuspensionAndWakeUpProgress");
    }

    public void updateAvailableCountryOverviews(String[] stringArray) {
        this.warn("updateAvailableCountryOverviews");
    }

    public void updateGeneralPoiVisibility(boolean bl) {
        this.warn("updateGeneralPoiVisibility");
    }

    public void updateHorizonMarkerVisibility(boolean bl) {
        this.warn("updateHorizonMarkerVisibility");
    }

    public void updateEhCategoryVisibility(int[] nArray) {
        this.warn("updateEhCategoryVisibility");
    }
}

