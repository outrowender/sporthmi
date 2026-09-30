/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.interapp.NaviOnlineService;
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
    public void activateOrientationAccordingToSetup();

    public void adaptDisplayContext(int var1);

    public void automaticOrientateMap();

    public void cleanup();

    public void displayCurrentRoute();

    public void enter();

    public void enterEpilogue();

    public void enterMapScreen(int var1);

    public void enterNavSetup();

    public void enterPrologue();

    public void exit();

    public void exitMapContentList();

    public void exitMapScreen();

    public void exitNavSetup();

    public void freezeMap();

    public void freezeMapLevel1();

    public int getDistanceToNextManeuver();

    public String getDistString();

    public NavLocation getEnterInMapLocation();

    public boolean getManoeuvreZoomDisabledWithReturn();

    public int getNightDesign();

    public boolean getRGActive();

    public boolean getRouteActiveOrRangeMapReady();

    public boolean getSDSDialogActive();

    public void initAdditionalInfos();

    public boolean isUserZoomEnabled();

    public void navigationEntered();

    public void rbGetIDOfSelectedSegmentResult(long var1);

    public void rbGetRRDToSelectedSegmentResult(long var1, int var3);

    public void refreshDistanceToNextManeuver();

    public void refreshRoutes();

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID var1, int var2);

    public void screenHidden();

    public void screenVisible();

    public void sdsSetZoomLevel(int var1);

    public void setEnterInMapLocation(NavLocation var1, boolean var2, boolean var3, IFavorite var4, boolean var5);

    public void setIsInVia(boolean var1);

    public void setNightDesign(int var1);

    public void setOnlineResultFlags(OnlinePOIResultList var1);

    public void setWeatherOverlaysData(int var1, NaviOnlineService.NaviOnlineMapOverlay[] var2, int var3);

    public void setPicNavMapLocation(NavLocation var1, boolean var2, int var3, ResourceLocator var4);

    public void setRemoteHMIResultFlags(OnlinePOIResultList var1);

    public void setRequestedFreeze(boolean var1);

    public void setRequestedVisibility(boolean var1);

    public void setSDSDialogActive(boolean var1);

    public void signalNaviNotOperable();

    public void stopoverHasBeenPassed();

    public void storeKeptContextIndex(int var1);

    public boolean supportsAdditionalInfo();

    public void switchDisplayContext(int var1);

    public void switchDisplayContextKombi(int var1);

    public void switchToMap();

    public void unfreezeMapLevel1();

    public void requestPreferredViewType();

    public void sdsChangedMapType();

    public void switchDayNight();

    public MapPin[] getDynamicPins();

    public OnlinePOIResultList getOnlinePOIResultList();

    public void incrementGesture(int var1);

    public void initViewPort();

    public void setBackgroundRenderingMode(boolean var1);

    public void indicateTrafficEventNoticeMap(TmcMessage var1, NavRectangle var2, int var3);

    public void showTMC(boolean var1);

    public void showSpeedAndFlowFreeflow(boolean var1);

    public void showSpeedAndFlowFreeflow(boolean var1, boolean var2);

    public void showSpeedAndFlowCongestions(boolean var1);

    public void showSpeedAndFlowCongestions(boolean var1, boolean var2);

    public void setSpeedAndFlowRoadClass(int var1);

    public void setLandmarksVisible(boolean var1);

    public void setCityModelMode(int var1);

    public void showBrandIcons(int var1);

    public void showPictureNavigationIcons(boolean var1);

    public void showWeatherIcons(boolean var1);

    public void onFiredRGAutoStartTimer();

    public void resolvedSelectedValue(MapItemSelectionInfo var1);

    public void onEvent(int var1);

    public void onEvent(int var1, Object var2);

    public boolean isRangeMapReadyToShow();

    public void hkBackPressed();

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] var1);

    public void updateZoomLevel(float var1);

    public void belowLowerThreshold(int var1);

    public void exceedsUpperThreshold(int var1);

    public void updateLockingState(boolean var1);

    public void vehicleMoved();

    public void setOperatorCallResultLocation(NavLocationWgs84 var1);

    public void adjustCarPosition();

    public void informTENMPopupPosition(int var1, int var2, int var3, int var4);

    public void hideTENM();

    public void recalculateVisibleArea();

    public void switchAutoZoomOnOff(int var1);

    public void updateRgInfoForNextDestination(RgInfoForNextDestination var1);
}

