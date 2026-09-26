/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.Command;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.call.INavCall;
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

public abstract class NavSimpleCall
extends Command
implements IDSINavigationHandler,
INavCall {
    private boolean handled = false;
    private CommandListCallManager manager = null;

    public NavSimpleCall(LogChannel logChannel) {
        this(logChannel, null);
    }

    public NavSimpleCall(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    @Override
    public void execute(String string) {
        this.logger.log(-2137614336, "%1#execute() - Starting execution of %2", (Object)this, (Object)string);
        this.execute();
    }

    @Override
    public void setManager(CommandListCallManager commandListCallManager) {
        this.manager = commandListCallManager;
    }

    @Override
    public boolean didHandle() {
        return this.handled;
    }

    @Override
    public void setHandled(boolean bl) {
        this.handled = bl;
    }

    public void callFinished() {
        this.setHandled(true);
        if (this.manager != null) {
            this.manager.removeCall(this);
        }
    }

    @Override
    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
    }

    @Override
    public void updateClockAdjusted(boolean bl) {
    }

    @Override
    public void fireTimer(Timer timer) {
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver) {
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
    }

    @Override
    public void dmResult(long l, long l2) {
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
    }

    @Override
    public void liResult(long l) {
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
    }

    @Override
    public void translateRouteResult(Route route) {
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
    }

    @Override
    public void trExportTrailsResult(int n) {
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    @Override
    public void updateAfaMode(int n) {
    }

    @Override
    public void updateAfaSpeaking(boolean bl) {
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray) {
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray) {
    }

    @Override
    public void updateEtcDemoModeState(boolean bl) {
    }

    @Override
    public void updateLanguage(String string) {
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray) {
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l) {
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n) {
    }

    @Override
    public void updateEtcMetricSystem(int n) {
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo) {
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl) {
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
    }

    @Override
    public void updateRgActive(boolean bl) {
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    @Override
    public void updateRgCurrentRoute(Route route) {
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions) {
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    @Override
    public void updateRgTimeAfaToDestination(long l) {
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl) {
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions) {
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
    }

    @Override
    public void updateRrdActive(boolean bl) {
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    @Override
    public void updateRmPersistentRoute(Route route) {
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition) {
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
    }

    @Override
    public void updateTrRecordingState(int n) {
    }

    @Override
    public void updateTrOperatingMode(int n) {
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
    }

    @Override
    public void rmRouteDeleteResult(int n) {
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
    }

    @Override
    public void rmRouteRenameResult(int n) {
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    @Override
    public void updateNavstateOfOperation(int n) {
    }

    @Override
    public void updateNavMedia(String[] stringArray) {
    }

    @Override
    public void rgNotPossible(int n) {
    }

    @Override
    public void responseAudioTrigger(int n) {
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
    }

    @Override
    public void liValueListOutputMethod(int n) {
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    @Override
    public void rgStartGuidanceRouteResult(int n) {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation) {
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray) {
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string) {
    }

    @Override
    public void rgException(int n) {
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties) {
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
    }

    @Override
    public void updateBapManeuverState(int n) {
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l) {
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l) {
    }

    @Override
    public void updateCityVignettes(int[] nArray) {
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase) {
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray) {
    }

    @Override
    public void updateAudioRequest(int n) {
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    @Override
    public void liHistoryResult(int n) {
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    @Override
    public void ehResult(int n, int n2) {
    }

    @Override
    public void blockAreaResult(long l, int n) {
    }

    @Override
    public void blockRoadSegmentsResult(long l, int n) {
    }

    @Override
    public void blockRouteBasedOnLengthResult(long l, int n) {
    }

    @Override
    public void blockRouteSegmentsResult(long l, int n) {
    }

    @Override
    public void deleteBlockResult(long[] lArray, int n) {
    }

    @Override
    public void persistBlockResult(long[] lArray, int n) {
    }

    @Override
    public void setBlockDescriptionResult(long[] lArray, int n) {
    }

    @Override
    public void updateListOfBlocks(BlockElement[] blockElementArray) {
    }

    @Override
    public void updateNaviCoreAvailableToSetBlocks(int n) {
    }

    @Override
    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
    }

    @Override
    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
    }

    @Override
    public void windowChanged(int n) {
    }

    @Override
    public void updateElementsTotal(long l, long l2, int n) {
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray) {
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray) {
    }

    @Override
    public void updateRgiString(short[] sArray) {
    }

    @Override
    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    @Override
    public void setTrailerStatusResult(int n) {
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray) {
    }

    @Override
    public void updateRouteResumePossible(boolean bl) {
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    @Override
    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray) {
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    @Override
    public void rgResult(int n) {
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    @Override
    public void updateMapIntegrationState(int n) {
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }
}

