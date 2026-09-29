/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.interapp.NaviOnlineService$NaviOnlineMapOverlay;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.context.ContextGUIListener;
import de.audi.tghu.navi.app.map.context.ContextUpdateListener;
import de.audi.tghu.navi.app.map.context.SetupChangeListener;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.tmc.TmcMessage;

public interface IContext
extends ContextGUIListener,
ContextUpdateListener,
SetupChangeListener,
IViewSizeListener {
    default public void activateOrientationAccordingToSetup() {
    }

    default public void adaptDisplayContext(int n) {
    }

    default public void automaticOrientateMap() {
    }

    default public void cleanup() {
    }

    default public void displayCurrentRoute() {
    }

    default public void enter() {
    }

    default public void enterEpilogue() {
    }

    default public void enterMapScreen(int n) {
    }

    default public void enterNavSetup() {
    }

    default public void enterPrologue() {
    }

    default public void exit() {
    }

    default public void exitMapContentList() {
    }

    default public void exitMapScreen() {
    }

    default public void exitNavSetup() {
    }

    default public void freezeMap() {
    }

    default public void freezeMapLevel1() {
    }

    default public int getDistanceToNextManeuver() {
    }

    default public String getDistString() {
    }

    default public NavLocation getEnterInMapLocation() {
    }

    default public boolean getManoeuvreZoomDisabledWithReturn() {
    }

    default public int getNightDesign() {
    }

    default public boolean getRGActive() {
    }

    default public boolean getRouteActiveOrRangeMapReady() {
    }

    default public boolean getSDSDialogActive() {
    }

    default public void initAdditionalInfos() {
    }

    default public boolean isUserZoomEnabled() {
    }

    default public void navigationEntered() {
    }

    default public void rbGetIDOfSelectedSegmentResult(long l) {
    }

    default public void rbGetRRDToSelectedSegmentResult(long l, int n) {
    }

    default public void refreshDistanceToNextManeuver() {
    }

    default public void refreshRoutes() {
    }

    default public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    default public void screenHidden() {
    }

    default public void screenVisible() {
    }

    default public void sdsSetZoomLevel(int n) {
    }

    default public void setEnterInMapLocation(NavLocation navLocation, boolean bl, boolean bl2, IFavorite iFavorite, boolean bl3) {
    }

    default public void setIsInVia(boolean bl) {
    }

    default public void setNightDesign(int n) {
    }

    default public void setOnlineResultFlags(OnlinePOIResultList onlinePOIResultList) {
    }

    default public void setWeatherOverlaysData(int n, NaviOnlineService$NaviOnlineMapOverlay[] naviOnlineService$NaviOnlineMapOverlayArray, int n2) {
    }

    default public void setPicNavMapLocation(NavLocation navLocation, boolean bl, int n, ResourceLocator resourceLocator) {
    }

    default public void setRemoteHMIResultFlags(OnlinePOIResultList onlinePOIResultList) {
    }

    default public void setRequestedFreeze(boolean bl) {
    }

    default public void setRequestedVisibility(boolean bl) {
    }

    default public void setSDSDialogActive(boolean bl) {
    }

    default public void signalNaviNotOperable() {
    }

    default public void stopoverHasBeenPassed() {
    }

    default public void storeKeptContextIndex(int n) {
    }

    default public boolean supportsAdditionalInfo() {
    }

    default public void switchDisplayContext(int n) {
    }

    default public void switchDisplayContextKombi(int n) {
    }

    default public void switchToMap() {
    }

    default public void unfreezeMapLevel1() {
    }

    default public void requestPreferredViewType() {
    }

    default public void sdsChangedMapType() {
    }

    default public void switchDayNight() {
    }

    default public MapPin[] getDynamicPins() {
    }

    default public OnlinePOIResultList getOnlinePOIResultList() {
    }

    default public void incrementGesture(int n) {
    }

    default public void initViewPort() {
    }

    default public void setBackgroundRenderingMode(boolean bl) {
    }

    default public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
    }

    default public void showTMC(boolean bl) {
    }

    default public void showSpeedAndFlowFreeflow(boolean bl) {
    }

    default public void showSpeedAndFlowFreeflow(boolean bl, boolean bl2) {
    }

    default public void showSpeedAndFlowCongestions(boolean bl) {
    }

    default public void showSpeedAndFlowCongestions(boolean bl, boolean bl2) {
    }

    default public void setSpeedAndFlowRoadClass(int n) {
    }

    default public void setLandmarksVisible(boolean bl) {
    }

    default public void setCityModelMode(int n) {
    }

    default public void showBrandIcons(int n) {
    }

    default public void showPictureNavigationIcons(boolean bl) {
    }

    default public void showWeatherIcons(boolean bl) {
    }

    default public void onFiredRGAutoStartTimer() {
    }

    default public void resolvedSelectedValue(MapItemSelectionInfo mapItemSelectionInfo) {
    }

    default public void onEvent(int n) {
    }

    default public void onEvent(int n, Object object) {
    }

    default public boolean isRangeMapReadyToShow() {
    }

    default public void hkBackPressed() {
    }

    default public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
    }

    default public void updateZoomLevel(float f2) {
    }

    default public void belowLowerThreshold(int n) {
    }

    default public void exceedsUpperThreshold(int n) {
    }

    default public void updateLockingState(boolean bl) {
    }

    default public void vehicleMoved() {
    }

    default public void setOperatorCallResultLocation(NavLocationWgs84 navLocationWgs84) {
    }

    default public void adjustCarPosition() {
    }

    default public void informTENMPopupPosition(int n, int n2, int n3, int n4) {
    }

    default public void hideTENM() {
    }

    default public void recalculateVisibleArea() {
    }

    default public void switchAutoZoomOnOff(int n) {
    }

    default public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }
}

