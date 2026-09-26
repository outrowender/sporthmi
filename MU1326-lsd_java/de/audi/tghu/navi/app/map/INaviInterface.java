/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.PreviewMapCallback;
import de.audi.atip.interapp.navtmc.TMCService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.call.INavCall;
import de.audi.tghu.navi.app.car.AEAService;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.cluster.KOMOService;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.NaviInterface$INotifyWhenRealRouteCalulcationisDone;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.tmc.TmcMessage;

public interface INaviInterface {
    default public void calculateRealRouteDistanceTo(NavLocationWgs84 navLocationWgs84, NaviInterface$INotifyWhenRealRouteCalulcationisDone naviInterface$INotifyWhenRealRouteCalulcationisDone) {
    }

    default public void mapReady(boolean bl) {
    }

    default public void mapInitialized(boolean bl) {
    }

    default public void updateMapFreeze(boolean bl) {
    }

    default public void alternativeRoutesScreenEntered() {
    }

    default public void alternativeRoutesChangedToSingleRG() {
    }

    default public HomeAddressHandler getHomeAddressHandler() {
    }

    default public void startGuidanceCalculatedRoute(int n) {
    }

    default public CommandList startGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
    }

    default public void abortSDSSession() {
    }

    default public CalculatedRouteListElement[] getCalculatedRoutes() {
    }

    default public int getRouteListLength() {
    }

    default public int getIndexOfCurrentDestination() {
    }

    default public void addressbookMapActive(boolean bl) {
    }

    default public void requestTmcMessage(int n) {
    }

    default public void requestOnlineResultFlagDetails(int n, OnlinePOIResultList onlinePOIResultList, AbstractMap abstractMap) {
    }

    default public void stopRouteGuidance() {
    }

    default public boolean isOffroad() {
    }

    default public POICategoryManager getPOICategoryManager() {
    }

    default public void setDemoModeSpeed(long l) {
    }

    default public boolean isDemoModeActive() {
    }

    default public KOMOService getKOMOService() {
    }

    default public void updateTMCMapFreeze(boolean bl) {
    }

    default public CountryInfo[] getCountryInfo() {
    }

    default public TrafficRegulationService getTrafficRegulationService() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public void resetEditInputMode() {
    }

    default public INaviAudioHandler getNaviAudioHandler() {
    }

    default public DSINavigationManager getDSINavigationManager() {
    }

    default public void startPoiStackSequence(NavLocation navLocation) {
    }

    default public void startDestinationDetails(NavLocation navLocation) {
    }

    default public void startDestinationDetailsTMC(TmcMessage tmcMessage) {
    }

    default public void googleEarthUpdateStatusCompleted(int n, boolean bl) {
    }

    default public void setOperationTaskCompleted(int n) {
    }

    default public IVehicle getVehicle() {
    }

    default public NavLocation streamToLocation(byte[] byArray) {
    }

    default public void resetDetour() {
    }

    default public Route getRoute() {
    }

    default public IRouteManager getRouteManager() {
    }

    default public NaviOnlineService getNaviOnlineService() {
    }

    default public int getNavigationMode() {
    }

    default public void setNavigationMode(int n) {
    }

    default public void showMapDestination(NavLocation navLocation, String string) {
    }

    default public void executeCallDiscardOld(INavCall iNavCall, String string) {
    }

    default public int getConfiguredTimeMode() {
    }

    default public void updateKombiMapReady(boolean bl) {
    }

    default public OperationManager getOperationManager() {
    }

    default public INavigationInputModeManager getInputModeManager() {
    }

    default public ClusterService getClusterService() {
    }

    default public void calculateAlternativeRoutes() {
    }

    default public TMCService getTMCGateWay() {
    }

    default public void updateDelayOnCurrentRoute(long l) {
    }

    default public CommandList createCommandList() {
    }

    default public IViewSizeChangeHandler getViewSizeChangeHandler() {
    }

    default public IFavorite[] getFavorites() {
    }

    default public void stopRouteCalculation() {
    }

    default public PreviewMapCallback getDetailsScreen() {
    }

    default public void updateInfoForNextTmcEvent(long l, TmcMessage tmcMessage) {
    }

    default public void sdsSessionAborted() {
    }

    default public void sdsDialogStarted() {
    }

    default public void sdsDialogEnded() {
    }

    default public IRouteCriteria getRouteCriteria() {
    }

    default public void triggerEventAudioMessage(int n) {
    }

    default public AEAService getAeaService() {
    }

    default public void triggerUpdateRcci() {
    }

    default public void afaRepeat(int n) {
    }

    default public void sdsDialogAborting() {
    }

    default public ITrafficMiniMap getTrafficMiniMap() {
    }

    default public OnlineTrafficHandler getOnlineTrafficHandler() {
    }

    default public void stopRrdMonitor() {
    }

    default public void setAddressInputFormModelAccessHelper(IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
    }

    default public void sendCalculatateAltRoutesResult(byte by) {
    }

    default public NavLocation getCurrentPoiProximityWarningLocation() {
    }

    default public void hideCurrentPoiProximityWarningAfterSelection() {
    }

    default public void focusSelenaRoutes(boolean bl) {
    }

    default public boolean isFeatureToBeLocked() {
    }

    default public void setFeatureToBeLocked(boolean bl) {
    }
}

