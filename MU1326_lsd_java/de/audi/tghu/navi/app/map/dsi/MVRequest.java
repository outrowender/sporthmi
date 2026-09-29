/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.MVRequestGoogleCtrl;
import de.audi.tghu.navi.app.map.dsi.MVRequestManeuverView;
import de.audi.tghu.navi.app.map.dsi.MVRequestZoomEngine;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MVRequest
implements IMapRequest {
    private LogChannel mDSILogChannel;
    private AbstractMap naviMap;
    private MVRequestControl mMVRequestStd = null;
    private MVRequestGoogleCtrl mMVRequestGoogleCtrl = null;
    private MVRequestManeuverView mMVRequestManeuverView = null;
    private MVRequestZoomEngine mMVRequestZoomEngine = null;

    public MVRequest(AbstractMap abstractMap, MapConfig mapConfig, NavigationEnv navigationEnv) {
        this.naviMap = abstractMap;
        int n = mapConfig.getMapInstanceId();
        this.mDSILogChannel = abstractMap.getMapDSILogChannel();
        this.mMVRequestStd = new MVRequestControl(mapConfig.getMapInstanceId(), abstractMap.getMapDSILogChannel(), abstractMap.getMapDSICtrlLogChannel());
        this.mMVRequestStd.bind(abstractMap);
        if (mapConfig.hasGoogleEarth()) {
            this.mMVRequestGoogleCtrl = new MVRequestGoogleCtrl(mapConfig.getMapInstanceIdGoogle(), mapConfig.getLogDSIGoogle(), mapConfig.getLogDSIGoogleListener());
            this.mMVRequestGoogleCtrl.bind(abstractMap);
        }
        if (mapConfig.hasManeuverView()) {
            this.mMVRequestManeuverView = new MVRequestManeuverView(n, abstractMap.getMapDSILogChannel(), abstractMap.getMapDSICtrlLogChannel());
            this.mMVRequestManeuverView.bind(abstractMap);
        }
        if (mapConfig.hasZoomEngine()) {
            this.mMVRequestZoomEngine = new MVRequestZoomEngine(n, abstractMap.getMapDSILogChannel(), abstractMap.getMapDSICtrlLogChannel());
            this.mMVRequestZoomEngine.bind(abstractMap);
        }
    }

    protected LogChannel getLogger() {
        return this.mDSILogChannel;
    }

    @Override
    public boolean areAllBoundDSIReady() {
        boolean bl = true;
        boolean bl2 = bl = this.mMVRequestStd != null && this.mMVRequestStd.isReady();
        if (this.mMVRequestGoogleCtrl != null) {
            bl = bl && this.mMVRequestGoogleCtrl.isReady();
        }
        return bl;
    }

    @Override
    public MVRequestControl getMVRequestControlActive() {
        ISatelliteMapsManager iSatelliteMapsManager = this.naviMap.getSatellitemapsManager();
        if (iSatelliteMapsManager != null) {
            return this.getMVRequestStd();
        }
        this.getLogger().log(10000, "MVRequest#getMVRequestControlActive() - No SatMapsManager");
        return null;
    }

    @Override
    public MVRequestControl getMVRequestStd() {
        return this.mMVRequestStd;
    }

    @Override
    public MVRequestGoogleCtrl getMVRequestGoogleCtrl() {
        return this.mMVRequestGoogleCtrl;
    }

    @Override
    public MVRequestManeuverView getMVRequestManeuverView() {
        return this.mMVRequestManeuverView;
    }

    @Override
    public MVRequestZoomEngine getMVRequestZoomEngine() {
        return this.mMVRequestZoomEngine;
    }

    @Override
    public void viewSetScreenViewport(Rect rect) {
        this.getMVRequestControlActive().viewSetScreenViewport(rect);
    }

    @Override
    public void viewSetScreenViewportMaximum(Rect rect) {
        this.getMVRequestControlActive().viewSetScreenViewportMaximum(rect);
    }

    @Override
    public void viewSetVisible(boolean bl) {
        this.getMVRequestControlActive().viewSetVisible(bl);
    }

    @Override
    public void viewFreeze(boolean bl) {
        this.getMVRequestControlActive().viewFreeze(bl);
    }

    @Override
    public void setFrameRateMode(int n) {
        this.getMVRequestControlActive().setFrameRateMode(n);
    }

    @Override
    public void setDayView() {
        this.getMVRequestControlActive().setDayView();
    }

    @Override
    public void setNightView() {
        this.getMVRequestControlActive().setNightView();
    }

    @Override
    public void setViewType(int n) {
        this.getMVRequestControlActive().setViewType(n);
        if (this.getMVRequestZoomEngine() != null) {
            this.getMVRequestZoomEngine().setViewType(n);
        }
    }

    @Override
    public void setMode(int n) {
        this.getMVRequestControlActive().setMode(n);
    }

    @Override
    public void setMapPosition(NavLocationWgs84 navLocationWgs84) {
        if (navLocationWgs84 != null) {
            NavLocation navLocation = Util.getLocationFromGeoPos(navLocationWgs84.getLongitude(), navLocationWgs84.getLatitude());
            this.getMVRequestControlActive().setLocationByLocation(navLocation);
        }
    }

    @Override
    public void setZoomListIndex(int n) {
        this.getMVRequestControlActive().setZoomListIndex(n);
    }

    @Override
    public void setRotation(short s) {
        this.getMVRequestControlActive().setRotation(s);
    }

    @Override
    public void setOrientation(int n) {
        this.getMVRequestControlActive().setOrientation(n);
        if (this.getMVRequestZoomEngine() != null) {
            this.getMVRequestZoomEngine().setMapOrientation(n);
        }
    }

    @Override
    public void setMapViewportByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
        this.getMVRequestControlActive().setMapViewPortByLD(navLocation, navLocation2, n);
    }

    @Override
    public void setLocation(int n, int n2) {
        this.getMVRequestControlActive().setLocation(n, (short)n2);
    }

    @Override
    public void setLocationByLocation(NavLocation navLocation) {
        this.getMVRequestControlActive().setLocationByLocation(navLocation);
    }

    @Override
    public void setCarPosition(Point point) {
        this.getMVRequestControlActive().setCarPosition(point);
        if (this.getMVRequestZoomEngine() != null) {
            this.getMVRequestZoomEngine().setCarPosition(point);
        }
    }

    @Override
    public void setHotPoint(Point point) {
        this.getMVRequestControlActive().setHotPoint(point);
    }

    @Override
    public Point getHotPointPosition() {
        return this.getMVRequestControlActive().getHotPointPosition();
    }

    @Override
    public void setZoomArea(Rect rect) {
        this.getMVRequestControlActive().setZoomArea(rect);
        if (this.getMVRequestZoomEngine() != null) {
            this.getMVRequestZoomEngine().setZoomArea(rect);
        }
    }

    @Override
    public void setTrafficMapStyle(boolean bl) {
        this.getMVRequestControlActive().setTrafficMapStyle(bl);
    }

    @Override
    public void showSpeedAndFlowFreeflow(boolean bl) {
        this.getMVRequestControlActive().showSpeedAndFlowFreeFlow(bl);
    }

    @Override
    public void showSpeedAndFlowCongestions(boolean bl) {
        this.getMVRequestControlActive().showSpeedAndFlowCongestions(bl);
    }

    @Override
    public void setCityModelMode(int n) {
        if (Util.isHURegionAsia() && n == 0) {
            this.getMVRequestControlActive().setCityModelMode(1);
            return;
        }
        this.getMVRequestControlActive().setCityModelMode(n);
    }

    @Override
    public void setLandmarksVisible(boolean bl) {
        this.getMVRequestControlActive().setLandmarksVisible(bl);
    }

    @Override
    public void setBrandIconStyle(int[] nArray, int n) {
        this.getMVRequestControlActive().setBrandIconStyle(nArray, n);
    }

    @Override
    public void displayRemainingRangeOfVehicle(boolean bl) {
        this.getMVRequestControlActive().displayRemainingRangeOfVehicle(bl);
    }

    @Override
    public void setMobilityHorizonZoomMode(int n) {
        this.getMVRequestControlActive().setMobilityHorizonZoomMode(n);
    }

    @Override
    public void setMobilityHorizonVisibility(boolean bl) {
        this.getMVRequestControlActive().setMobilityHorizonVisibility(bl);
    }

    @Override
    public void setCrossHairsColor(boolean bl) {
        this.getMVRequestControlActive().setCrossHairsColor(bl);
    }

    @Override
    public void suspendMapViewer() {
        this.getMVRequestControlActive().suspendMapViewer();
    }

    @Override
    public void wakeupMapViewer() {
        this.getMVRequestControlActive().wakeupMapViewer();
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84) {
        this.getMVRequestControlActive().isDetailedMapMaterialAvailable(navLocationWgs84);
    }

    @Override
    public void setViewPortBorder(int n) {
        this.getMVRequestControlActive().setViewPortBorder(n);
    }

    @Override
    public void showTMCMessages(boolean bl) {
        this.mDSILogChannel.log(14808325, "MVRequest#showTMCMessages(%1) ", bl);
        this.getMVRequestControlActive().showTMCMessages(bl);
    }

    @Override
    public void goToTMCMessage(long l) {
        this.getMVRequestControlActive().goToTMCMessage(l);
    }

    @Override
    public void ensureTMCVisibility(long l) {
        this.getMVRequestControlActive().ensureTMCVisibility(l);
    }

    @Override
    public void ensureTrafficEventIconsVisibility(long[] lArray) {
        this.getMVRequestControlActive().ensureTrafficEventIconsVisibility(lArray);
    }

    @Override
    public void setEnableSoftZoom(boolean bl) {
        this.getMVRequestControlActive().setEnableSoftZoom(bl);
    }

    @Override
    public void setEnableSoftZoomConditional(boolean bl) {
        this.getMVRequestControlActive().setEnableSoftZoomConditional(bl);
    }

    @Override
    public void setEnableSoftRotation(boolean bl) {
        this.getMVRequestControlActive().setEnableSoftRotation(bl);
    }

    @Override
    public void setEnableSoftJump(boolean bl) {
        this.getMVRequestControlActive().setEnableSoftJump(bl);
    }

    @Override
    public void setEnableSoftTilt(boolean bl) {
        this.getMVRequestControlActive().setEnableSoftTilt(bl);
    }

    @Override
    public void setScrollByCrossHairs(boolean bl) {
        this.getMVRequestControlActive().setScrollByCrossHairs(bl);
    }

    @Override
    public void setScrollByCrossHairsBoundingBox(Rect rect) {
        this.getMVRequestControlActive().setScrollByCrossHairsBoundingBox(rect);
    }

    @Override
    public void rbSelectNextSegment() {
        this.getMVRequestControlActive().rbSelectNextSegment();
    }

    @Override
    public void rbSelectPreviousSegment() {
        this.getMVRequestControlActive().rbSelectPreviousSegment();
    }

    @Override
    public void rbGetIDOfSelectedSegment() {
        this.getMVRequestControlActive().rbGetIDOfSelectedSegment();
    }

    @Override
    public void rbGetRRDToSelectedSegment(long l) {
        this.getMVRequestControlActive().rbGetRRDToSelectedSegment(l);
    }

    @Override
    public void rbSelectAlternativeRoute(int n) {
        this.getMVRequestControlActive().rbSelectAlternativeRoute(n);
    }

    @Override
    public void rbSetPosition(int n) {
        this.getMVRequestControlActive().rbSetPosition(n);
    }

    @Override
    public void highlightRouteBasedOnLength(long l, long l2, int n) {
        this.getMVRequestControlActive().highlightRouteBasedOnLength(l, l2, n);
    }

    @Override
    public void setRouteColoringPolicy(int n) {
        this.getMVRequestControlActive().setRouteColoringPolicy(n);
    }

    @Override
    public void dragMap(short s, short s2) {
        this.getMVRequestControlActive().dragMap(s, s2);
    }

    @Override
    public void dragRoute(short s, short s2) {
        this.getMVRequestControlActive().dragRoute(s, s2);
    }

    @Override
    public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
        this.getMVRequestControlActive().startRouteDragging(navLocationWgs84);
    }

    @Override
    public void startScrollToDirection(int n) {
        this.getMVRequestControlActive().startScrollToDirection(n);
    }

    @Override
    public void stopScrollToDirection() {
        this.getMVRequestControlActive().stopScrollToDirection();
    }

    @Override
    public void getInfoForPosition() {
        this.getMVRequestControlActive().getInfoForPosition();
    }

    @Override
    public void getInfoForScreenPosition(Point point) {
        this.getMVRequestControlActive().getInfoForScreenPosition(point);
    }

    @Override
    public boolean getInfoForPositionIsActive() {
        boolean bl = this.getMVRequestControlActive().getInfoForPositionIsActive();
        this.mDSILogChannel.log(-2137614336, "MVRequest#getInfoForPositionIsActive() - was: %1", bl);
        return bl;
    }

    @Override
    public void setInfoForPositionIsActive(boolean bl) {
        this.getMVRequestControlActive().setInfoForPositionIsActive(bl);
    }

    @Override
    public boolean getQueueGetInfoForPosition() {
        return this.getMVRequestControlActive().getQueueGetInfoForPosition();
    }

    @Override
    public Point getQueueGetInfoForScreenPositionPoint() {
        return this.getMVRequestControlActive().getQueueGetInfoForScreenPositionPoint();
    }

    @Override
    public Rect getPendingScreenViewport() {
        return this.getMVRequestControlActive().getPendingScreenViewport();
    }

    @Override
    public void setPendingScreenViewport(Rect rect) {
        this.getMVRequestControlActive().setPendingScreenViewport(rect);
    }

    @Override
    public Rect getQueuedScreenViewport() {
        return this.getMVRequestControlActive().getQueuedScreenViewport();
    }

    @Override
    public void setQueuedScreenViewport(Rect rect) {
        this.getMVRequestControlActive().setQueuedScreenViewport(rect);
    }

    @Override
    public void ensurePoiVisibility(NavLocation[] navLocationArray) {
        this.getMVRequestControlActive().ensurePoiVisibility(navLocationArray);
    }

    @Override
    public void setGeneralPoiVisibility(boolean bl) {
        this.getMVRequestControlActive().setGeneralPoiVisibility(bl);
    }

    @Override
    public void selectNextPOI() {
        this.getMVRequestControlActive().selectNextPOI();
    }

    @Override
    public void selectPrevPOI() {
        this.getMVRequestControlActive().selectPrevPOI();
    }

    @Override
    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        this.getMVRequestControlActive().configureFlags(n, mapFlagArray);
    }

    @Override
    public boolean configureFlagsIsActive(boolean bl) {
        boolean bl2 = this.getMVRequestControlActive().configureFlagsIsActive(bl);
        this.mDSILogChannel.log(-2137614336, "MVRequest#configureFlagsIsActive( %1 ) - result: %2", bl, bl2);
        return bl2;
    }

    @Override
    public void setPictureNavigationIconVisibility(boolean bl, int n) {
        this.getMVRequestControlActive().setPictureNavigationIconVisibility(bl, n);
    }

    @Override
    public void setWeatherVisualization(boolean bl) {
        this.getMVRequestControlActive().setWeatherVisualization(bl);
    }

    @Override
    public void setEnableRouteCalcMode(boolean bl) {
        this.getMVRequestControlActive().setEnableRouteCalcMode(bl);
    }

    void loadKml(String[] stringArray) {
        if (this.naviMap.getMapConfig().hasGoogleEarth()) {
            this.mMVRequestGoogleCtrl.loadKml(stringArray);
        }
    }

    void requestClearCache() {
        if (this.naviMap.getMapConfig().hasGoogleEarth()) {
            this.mMVRequestGoogleCtrl.requestClearCache();
        }
    }

    void setConnectionInformation(int n) {
        if (this.naviMap.getMapConfig().hasGoogleEarth()) {
            this.mMVRequestGoogleCtrl.setConnectionInformation(n);
        }
    }

    void setLanguage(String string) {
        if (this.naviMap.getMapConfig().hasGoogleEarth()) {
            this.mMVRequestGoogleCtrl.setLanguage(string);
        }
    }

    @Override
    public void setLayerVisibility(int[] nArray) {
        if (this.naviMap.getMapConfig().hasGoogleEarth()) {
            this.mMVRequestGoogleCtrl.setLayerVisibility(nArray);
        }
    }

    @Override
    public void clearIsActiveFlags() {
        this.setInfoForPositionIsActive(false);
        this.configureFlagsIsActive(false);
        Rect rect = this.getPendingScreenViewport();
        if (rect != null) {
            this.getMVRequestControlActive().getMVResponseControl().setViewScreenViewPort(rect);
        }
        this.setPendingScreenViewport(null);
        this.setQueuedScreenViewport(null);
    }

    @Override
    public void setMetricSystem(int n) {
        this.getMVRequestControlActive().setMetricSystem(n);
    }

    @Override
    public void setTemperatureScale(int n) {
        this.getMVRequestControlActive().setTemperatureScale(n);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        MVRequestControl[] mVRequestControlArray = this.mMVRequestGoogleCtrl != null ? new MVRequestControl[]{this.mMVRequestStd, this.mMVRequestGoogleCtrl} : new MVRequestControl[]{this.mMVRequestStd};
        for (int i2 = 0; i2 < mVRequestControlArray.length; ++i2) {
            MVRequestControl mVRequestControl = mVRequestControlArray[i2];
            if (i2 > 0) {
                buffer.append(", ");
            }
            if (mVRequestControl.getMap() != this.naviMap) {
                buffer.append("?");
            }
            if (mVRequestControl.getID() == this.getMVRequestStd().getID()) {
                buffer.append("#");
            }
            buffer.append(mVRequestControl.getID()).append("[");
            buffer.append(mVRequestControl.isReady() ? "r" : "-");
            buffer.append(", ");
            buffer.append(mVRequestControl.isOperable() ? "o" : "-");
            buffer.append("]");
        }
        return buffer.toString();
    }

    @Override
    public void setZoomLevel(float f2) {
        this.getMVRequestControlActive().setZoomLevel(f2);
    }

    @Override
    public void setDragRouteMarker(int n) {
        this.getMVRequestControlActive().setDragRouteMarker(n);
    }

    @Override
    public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
        int n2 = navRectangle != null ? navRectangle.xLeft : 0;
        int n3 = navRectangle != null ? navRectangle.xRight : 0;
        int n4 = navRectangle != null ? navRectangle.yBottom : 0;
        int n5 = navRectangle != null ? navRectangle.yUp : 0;
        NavLocation navLocation = Util.getLocationFromGeoPos(n2, n5);
        NavLocation navLocation2 = Util.getLocationFromGeoPos(n3, n4);
        this.setMapViewportByLD(navLocation, navLocation2, n);
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        this.getMVRequestStd().ehSetCategoryVisibility(0, nArray, blArray);
        this.getMVRequestStd().ehSetCategoryVisibility(2, nArray, blArray);
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        this.getMVRequestStd().ehSetCategoryVisibilityToDefault(0);
        this.getMVRequestStd().ehSetCategoryVisibilityToDefault(2);
    }

    @Override
    public void setHorizonMarkerVisibility(boolean bl) {
        this.getMVRequestControlActive().setHorizonMarkerVisibility(bl);
    }

    @Override
    public void setSpeedAndFlowRoadClass(int n) {
        this.getMVRequestControlActive().setSpeedAndFlowRoadClass(n);
    }

    @Override
    public void setMapOverlays(int n, MapOverlay[] mapOverlayArray, int n2, int n3) {
        this.getMVRequestControlActive().setMapOverlays(n, mapOverlayArray, n2, n3);
    }

    public void cleanup() {
        if (this.mMVRequestGoogleCtrl != null) {
            this.mMVRequestGoogleCtrl.cleanup();
        }
        if (this.mMVRequestManeuverView != null) {
            this.mMVRequestManeuverView.cleanup();
        }
        if (this.mMVRequestStd != null) {
            this.mMVRequestStd.cleanup();
        }
        if (this.mMVRequestZoomEngine != null) {
            this.mMVRequestZoomEngine.cleanup();
        }
    }

    @Override
    public void setRouteVisibility(boolean bl) {
        this.getMVRequestControlActive().setRouteVisibility(bl);
    }

    @Override
    public void setVisibleRoutes(NavSegmentID[] navSegmentIDArray) {
        this.getMVRequestControlActive().setVisibleRoutes(navSegmentIDArray);
    }

    @Override
    public float getRequestedZoomLevel() {
        return this.getMVRequestControlActive().getRequestedZoomLevel();
    }
}

