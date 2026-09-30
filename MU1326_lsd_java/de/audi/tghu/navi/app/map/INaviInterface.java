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
import de.audi.tghu.navi.app.map.NaviInterface;
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
    public void calculateRealRouteDistanceTo(NavLocationWgs84 var1, NaviInterface.INotifyWhenRealRouteCalulcationisDone var2);

    public void mapReady(boolean var1);

    public void mapInitialized(boolean var1);

    public void updateMapFreeze(boolean var1);

    public void alternativeRoutesScreenEntered();

    public void alternativeRoutesChangedToSingleRG();

    public HomeAddressHandler getHomeAddressHandler();

    public void startGuidanceCalculatedRoute(int var1);

    public CommandList startGuidanceCalculatedRouteByUID(NavSegmentID var1);

    public void abortSDSSession();

    public CalculatedRouteListElement[] getCalculatedRoutes();

    public int getRouteListLength();

    public int getIndexOfCurrentDestination();

    public void addressbookMapActive(boolean var1);

    public void requestTmcMessage(int var1);

    public void requestOnlineResultFlagDetails(int var1, OnlinePOIResultList var2, AbstractMap var3);

    public void stopRouteGuidance();

    public boolean isOffroad();

    public POICategoryManager getPOICategoryManager();

    public void setDemoModeSpeed(long var1);

    public boolean isDemoModeActive();

    public KOMOService getKOMOService();

    public void updateTMCMapFreeze(boolean var1);

    public CountryInfo[] getCountryInfo();

    public TrafficRegulationService getTrafficRegulationService();

    public IFrameworkAccess getFramework();

    public void resetEditInputMode();

    public INaviAudioHandler getNaviAudioHandler();

    public DSINavigationManager getDSINavigationManager();

    public void startPoiStackSequence(NavLocation var1);

    public void startDestinationDetails(NavLocation var1);

    public void startDestinationDetailsTMC(TmcMessage var1);

    public void googleEarthUpdateStatusCompleted(int var1, boolean var2);

    public void setOperationTaskCompleted(int var1);

    public IVehicle getVehicle();

    public NavLocation streamToLocation(byte[] var1);

    public void resetDetour();

    public Route getRoute();

    public IRouteManager getRouteManager();

    public NaviOnlineService getNaviOnlineService();

    public int getNavigationMode();

    public void setNavigationMode(int var1);

    public void showMapDestination(NavLocation var1, String var2);

    public void executeCallDiscardOld(INavCall var1, String var2);

    public int getConfiguredTimeMode();

    public void updateKombiMapReady(boolean var1);

    public OperationManager getOperationManager();

    public INavigationInputModeManager getInputModeManager();

    public ClusterService getClusterService();

    public void calculateAlternativeRoutes();

    public TMCService getTMCGateWay();

    public void updateDelayOnCurrentRoute(long var1);

    public CommandList createCommandList();

    public IViewSizeChangeHandler getViewSizeChangeHandler();

    public IFavorite[] getFavorites();

    public void stopRouteCalculation();

    public PreviewMapCallback getDetailsScreen();

    public void updateInfoForNextTmcEvent(long var1, TmcMessage var3);

    public void sdsSessionAborted();

    public void sdsDialogStarted();

    public void sdsDialogEnded();

    public IRouteCriteria getRouteCriteria();

    public void triggerEventAudioMessage(int var1);

    public AEAService getAeaService();

    public void triggerUpdateRcci();

    public void afaRepeat(int var1);

    public void sdsDialogAborting();

    public ITrafficMiniMap getTrafficMiniMap();

    public OnlineTrafficHandler getOnlineTrafficHandler();

    public void stopRrdMonitor();

    public void setAddressInputFormModelAccessHelper(IAddressInputFormModelAccessHelper var1);

    public void sendCalculatateAltRoutesResult(byte var1);

    public NavLocation getCurrentPoiProximityWarningLocation();

    public void hideCurrentPoiProximityWarningAfterSelection();

    public void focusSelenaRoutes(boolean var1);

    public boolean isFeatureToBeLocked();

    public void setFeatureToBeLocked(boolean var1);
}

