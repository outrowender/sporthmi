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
        this.logChannel.log(-2137614336, "MapViewerDefaultHandler#%1() - unexpected call", (Object)string);
    }

    @Override
    public void configureFlags(long[] lArray) {
        this.warn("configureFlags");
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.warn("isDetailedMapMaterialAvailable");
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.warn("asyncException");
    }

    @Override
    public void updateReady(boolean bl) {
        this.warn("updateReady");
    }

    @Override
    public void updateCurrentViewType(int n) {
        this.warn("updateCurrentViewType");
    }

    @Override
    public void updateDayNightView(boolean bl) {
        this.warn("updateDayNightView");
    }

    @Override
    public void updateViewScreenViewPort(Rect rect) {
        this.warn("updateViewScreenViewPort");
    }

    @Override
    public void updateViewScreenViewPortMaximum(Rect rect) {
        this.warn("updateViewScreenViewPortMaximum");
    }

    @Override
    public void updateViewVisible(boolean bl) {
        this.warn("updateViewVisible");
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        this.warn("updateViewFreeze");
    }

    @Override
    public void updateZoomLevel(float f2) {
        this.warn("updateZoomLevel");
    }

    @Override
    public void updateZoomList(float[] fArray) {
        this.warn("updateZoomList");
    }

    @Override
    public void updateZoomListIndex(int n) {
        this.warn("updateZoomListIndex");
    }

    @Override
    public void updateMapRotation(short s) {
        this.warn("updateMapRotation");
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        this.warn("updateMapPosition");
    }

    @Override
    public void updateMapOrientation(int n) {
        this.warn("updateMapOrientation");
    }

    @Override
    public void updateCarPosition(Point point) {
        this.warn("updateCarPosition");
    }

    @Override
    public void updateTmcVisible(boolean bl) {
        this.warn("updateTmcVisible");
    }

    @Override
    public void updateMapMode(int n) {
        this.warn("updateMapMode");
    }

    @Override
    public void updateSelectedPoi(PosInfo posInfo) {
        this.warn("updateSelectedPoi");
    }

    @Override
    public void updateSpeedAndFlowVisible(boolean bl) {
        this.warn("updateSpeedAndFlowVisible");
    }

    @Override
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
        this.warn("updateAvailableRoutes");
    }

    @Override
    public void updateViewPort(ViewPort viewPort) {
        this.warn("updateViewPort");
    }

    @Override
    public void updateSoftJumpEnabled(boolean bl) {
        this.warn("updateSoftJumpEnabled");
    }

    @Override
    public void updateSoftRotationEnabled(boolean bl) {
        this.warn("updateSoftRotationEnabled");
    }

    @Override
    public void updateSoftTiltEnabled(boolean bl) {
        this.warn("updateSoftTiltEnabled");
    }

    @Override
    public void updateSoftZoomEnabled(boolean bl) {
        this.warn("updateSoftZoomEnabled");
    }

    @Override
    public void updateSoftJumpRunning(boolean bl) {
        this.warn("updateSoftJumpRunning");
    }

    @Override
    public void updateSoftRotationRunning(boolean bl) {
        this.warn("updateSoftRotationRunning");
    }

    @Override
    public void updateSoftTiltRunning(boolean bl) {
        this.warn("updateSoftTiltRunning");
    }

    @Override
    public void updateSoftZoomRunning(boolean bl) {
        this.warn("updateSoftZoomRunning");
    }

    @Override
    public void updateRouteCalcModeEnabled(boolean bl) {
        this.warn("updateRouteCalcModeEnabled");
    }

    @Override
    public void getInfoForPosition(PosInfo[] posInfoArray) {
        this.warn("getInfoForPosition");
    }

    @Override
    public void getNumberOfPOIs(long l) {
        this.warn("getNumberOfPOIs");
    }

    @Override
    public void unpackPOIContainerResult(boolean bl) {
        this.warn("unpackPOIContainerResult");
    }

    @Override
    public void updateCurrentLanduseStyle(int n) {
        this.warn("updateCurrentLanduseStyle");
    }

    @Override
    public void updateCurrentMetricSystem(int n) {
        this.warn("updateCurrentMetricSystem");
    }

    @Override
    public void setViewFocusOnBlockResult(int n) {
        this.warn("setViewFocusOnBlockResult");
    }

    @Override
    public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.warn("startToDrawNewRectangleInMapResult");
    }

    @Override
    public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.warn("setSouthWestCornerOfRectangleInMapResult");
    }

    @Override
    public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.warn("setNorthEastCornerOfRectangleInMapResult");
    }

    @Override
    public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.warn("finishDrawRectangleInMapResult");
    }

    @Override
    public void updateCityModelMode(int n) {
        this.warn("updateCityModelMode");
    }

    @Override
    public void displayRemainingRangeOfVehicleResult(boolean bl) {
        this.warn("displayRemainingRangeOfVehicleResult");
    }

    @Override
    public void touchApproachResult(boolean bl) {
        this.warn("touchApproachResult");
    }

    @Override
    public void setBrandIconStyleResult(int n) {
        this.warn("setBrandIconStyleResult");
    }

    @Override
    public void setGuidanceSymbolResult(int n) {
        this.warn("setGuidanceSymbolResult");
    }

    @Override
    public void setHOVLaneVisibilityResult(int n) {
        this.warn("setHOVLaneVisibilityResult");
    }

    @Override
    public void rbGetIDOfSelectedSegmentResult(long l, int n) {
        this.warn("rbGetIDOfSelectedSegmentResult");
    }

    @Override
    public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
        this.warn("rbGetRRDToSelectedSegmentResult");
    }

    @Override
    public void setTollRoadHighLightingResult(boolean bl, int n) {
        this.warn("setTollRoadHighLightingResult");
    }

    @Override
    public void setMountainPeakMarkerResult(boolean bl, int n) {
        this.warn("setMountainPeakMarkerResult");
    }

    @Override
    public void setViewFocusOnCombinedRouteListElementsResult(int n) {
        this.warn("setViewFocusOnCombinedRouteListElementsResult");
    }

    @Override
    public void suspendMapViewerResult(int n) {
        this.warn("suspendMapViewerResult");
    }

    @Override
    public void wakeupMapViewerResult(int n) {
        this.warn("wakeupMapViewerResult");
    }

    @Override
    public void updateMapViewerRunLevel(int n) {
        this.warn("updateMapViewerRunLevel");
    }

    @Override
    public void updateMapViewerSuspensionSupported(int n) {
        this.warn("updateMapViewerSuspensionSupported");
    }

    @Override
    public void updateMapViewerSuspensionAndWakeUpProgress(int n) {
        this.warn("updateMapViewerSuspensionAndWakeUpProgress");
    }

    @Override
    public void updateAvailableCountryOverviews(String[] stringArray) {
        this.warn("updateAvailableCountryOverviews");
    }

    @Override
    public void updateGeneralPoiVisibility(boolean bl) {
        this.warn("updateGeneralPoiVisibility");
    }

    @Override
    public void updateHorizonMarkerVisibility(boolean bl) {
        this.warn("updateHorizonMarkerVisibility");
    }

    @Override
    public void updateEhCategoryVisibility(int[] nArray) {
        this.warn("updateEhCategoryVisibility");
    }
}

