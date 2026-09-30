/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.call.INavCall;
import de.audi.tghu.navi.app.command.AbstractNavCommand;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.BlockElement;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public abstract class NavCall
extends AbstractNavCommand
implements IDSINavigationHandler,
INavCall {
    protected int dsiType = 0;
    private boolean handled = false;
    private CommandListCallManager manager = null;

    public NavCall(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, Navigation navigation) {
        this.init(navigationEnv, dSINavigationManager, navigation);
    }

    public NavCall(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, Navigation navigation, String string) {
        super(string);
        this.init(navigationEnv, dSINavigationManager, navigation);
    }

    public void execute(String string) {
        this.logger.log(10000000, "%1#execute() - Starting execution of %2 on %3", (Object)this, (Object)string, (Object)DSINavigationManager.dsiTypeToString(this.dsiType));
        this.execute();
    }

    public void setManager(CommandListCallManager commandListCallManager) {
        this.manager = commandListCallManager;
    }

    public boolean didHandle() {
        return this.handled;
    }

    public void setHandled(boolean bl) {
        this.handled = bl;
    }

    public void callFinished() {
        this.setHandled(true);
        if (this.manager != null) {
            this.manager.removeCall(this);
        }
    }

    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
    }

    public void updateClockAdjusted(boolean bl) {
    }

    public void fireTimer(Timer timer) {
    }

    public void cancelTimer(Timer timer) {
    }

    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver) {
    }

    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
    }

    public void dmRecentRoutesGetResult(long l, Route route) {
    }

    public void dmResult(long l, long l2) {
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
    }

    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    public void liGetStateResult(LISpellerData lISpellerData) {
    }

    public void liResult(long l) {
    }

    public void liValueList(LIValueList lIValueList, long l) {
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    public void poiValueList(LIValueList lIValueList, long l) {
    }

    public void translateRouteResult(Route route) {
    }

    public void trDeleteAllTracesResult(int n, int n2) {
    }

    public void trDeleteTraceResult(int n, int n2) {
    }

    public void trExportTrailsResult(int n) {
    }

    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    public void trRenameTraceResult(int n, int n2) {
    }

    public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    public void updateAfaMode(int n) {
    }

    public void updateAfaSpeaking(boolean bl) {
    }

    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray) {
    }

    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray) {
    }

    public void updateEtcDemoModeState(boolean bl) {
    }

    public void updateLanguage(String string) {
    }

    public void updateAvailableLanguages(String[] stringArray) {
    }

    public void updateEtcLanguageLoadProgress(long l) {
    }

    public void updateEtcLanguageLoadStatus(int n) {
    }

    public void updateEtcMetricSystem(int n) {
    }

    public void etcSensorDataReplayRoute(Route route) {
    }

    public void etcSensorDataReplayGuidance(boolean bl) {
    }

    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo) {
    }

    public void updateLispIsSpellerActive(boolean bl) {
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
    }

    public void updateRgActive(boolean bl) {
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    public void updateRgCurrentRoute(Route route) {
    }

    public void updateRgCurrentRouteOptions(RouteOptions routeOptions) {
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
    }

    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
    }

    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    public void updateRgTimeAfaToDestination(long l) {
    }

    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
    }

    public void updateRgTurnToStreet(String string, boolean bl) {
    }

    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions) {
    }

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
    }

    public void updateRrdActive(boolean bl) {
    }

    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    public void updateRmPersistentRoute(Route route) {
    }

    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
    }

    public void updateSoPosPosition(PosPosition posPosition) {
    }

    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl) {
    }

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
    }

    public void updateTrRecordingState(int n) {
    }

    public void updateTrOperatingMode(int n) {
    }

    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
    }

    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
    }

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
    }

    public void updateRgRouteCalculationState(int n) {
    }

    public void rmMakeRoutePersistentResult(long l) {
    }

    public void rmRouteAddResult(int n, long l) {
    }

    public void rmRouteDeleteAllResult(int n) {
    }

    public void rmRouteDeleteResult(int n) {
    }

    public void rmRouteGetResult(int n, Route route) {
    }

    public void rgSetRouteGuidanceModeResult() {
    }

    public void rmRouteRenameResult(int n) {
    }

    public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    public void updateNavstateOfOperation(int n) {
    }

    public void updateNavMedia(String[] stringArray) {
    }

    public void rgNotPossible(int n) {
    }

    public void responseAudioTrigger(int n) {
    }

    public void liStripLocationResult(NavLocation navLocation) {
    }

    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void liLastCityAndStreetHistoryResult(long l) {
    }

    public void liValueListFileStatus(int n, int n2, String string) {
    }

    public void liValueListOutputMethod(int n) {
    }

    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    public void rgStartGuidanceRouteResult(int n) {
    }

    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    public void updateDmFlagDestination(NavLocation navLocation) {
    }

    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
    }

    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray) {
    }

    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
    }

    public void updateLiCountryForCityAndStreetHistory(String string) {
    }

    public void rgException(int n) {
    }

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    public void updateRgRouteProperties(RouteProperties routeProperties) {
    }

    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
    }

    public void updateRgPoiInfoCalculationHorizon(long l) {
    }

    public void updateRgTurnListCalculationHorizon(long l) {
    }

    public void updateCityVignettes(int[] nArray) {
    }

    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase) {
    }

    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray) {
    }

    public void updateAudioRequest(int n) {
    }

    public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    public void liHistoryResult(int n) {
    }

    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    public void ehResult(int n, int n2) {
    }

    public void blockAreaResult(long l, int n) {
    }

    public void blockRoadSegmentsResult(long l, int n) {
    }

    public void blockRouteBasedOnLengthResult(long l, int n) {
    }

    public void blockRouteSegmentsResult(long l, int n) {
    }

    public void deleteBlockResult(long[] lArray, int n) {
    }

    public void persistBlockResult(long[] lArray, int n) {
    }

    public void setBlockDescriptionResult(long[] lArray, int n) {
    }

    public void updateListOfBlocks(BlockElement[] blockElementArray) {
    }

    public void updateNaviCoreAvailableToSetBlocks(int n) {
    }

    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
    }

    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
    }

    public void windowChanged(int n) {
    }

    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
    }

    public void updateElementsTotal(long l, long l2, int n) {
    }

    public void updateCountryInfo(CountryInfo[] countryInfoArray) {
    }

    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray) {
    }

    public void updateRgiString(short[] sArray) {
    }

    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
    }

    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    public void setTrailerStatusResult(int n) {
    }

    public void setUserDefinedPOIsResult(int n) {
    }

    public void setVehicleConsumptionInfoResult(int n) {
    }

    public void updateStyleDBPaths(String[] stringArray) {
    }

    public void updateRouteResumePossible(boolean bl) {
    }

    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    public void deletePersonalPOIDataBasesResult(int n) {
    }

    public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
    }

    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
    }

    public void rgStartRubberbandManipulationResult(int n) {
    }

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }

    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray) {
    }

    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    public void rgResult(int n) {
    }

    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    public void lispGetMatchingNVCResult(String string) {
    }

    public void updateMapIntegrationState(int n) {
    }

    public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    public void triggerEventAudioMessageResult(int n) {
    }

    public void updateBapManeuverState(int n) {
    }

    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }
}

