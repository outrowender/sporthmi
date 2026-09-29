/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.navi.app.dsi.NonDSIFunctionality;
import org.dsi.ifc.base.DSIListener;
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

public interface IDSINavigationHandler
extends DSIListener,
NonDSIFunctionality {
    default public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver) {
    }

    default public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
    }

    default public void dmRecentRoutesGetResult(long l, Route route) {
    }

    default public void dmResult(long l, long l2) {
    }

    default public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
    }

    default public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    default public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    default public void liGetStateResult(LISpellerData lISpellerData) {
    }

    default public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    default public void liResult(long l) {
    }

    default public void liValueList(LIValueList lIValueList, long l) {
    }

    default public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    default public void lispGetMatchingNVCResult(String string) {
    }

    default public void poiValueList(LIValueList lIValueList, long l) {
    }

    default public void translateRouteResult(Route route) {
    }

    default public void trDeleteAllTracesResult(int n, int n2) {
    }

    default public void trDeleteTraceResult(int n, int n2) {
    }

    default public void trExportTrailsResult(int n) {
    }

    default public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    default public void trRenameTraceResult(int n, int n2) {
    }

    default public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    default public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    default public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    default public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    default public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    default public void updateAfaMode(int n) {
    }

    default public void updateAfaSpeaking(boolean bl) {
    }

    default public void updateDmLastDestinationsList(LDListElement[] lDListElementArray) {
    }

    default public void updateDmRecentRoutesList(RRListElement[] rRListElementArray) {
    }

    default public void updateEtcDemoModeState(boolean bl) {
    }

    default public void updateLanguage(String string) {
    }

    default public void updateAvailableLanguages(String[] stringArray) {
    }

    default public void updateEtcLanguageLoadProgress(long l) {
    }

    default public void updateEtcLanguageLoadStatus(int n) {
    }

    default public void updateEtcMetricSystem(int n) {
    }

    default public void etcSensorDataReplayRoute(Route route) {
    }

    default public void etcSensorDataReplayGuidance(boolean bl) {
    }

    default public void updateEtcVersionInfo(NavVersionInfo navVersionInfo) {
    }

    default public void updateLispIsSpellerActive(boolean bl) {
    }

    default public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    default public void updateRgCurrentRoute(Route route) {
    }

    default public void updateRgCurrentRouteOptions(RouteOptions routeOptions) {
    }

    default public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
    }

    default public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
    }

    default public void updateRgStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    default public void updateRgTimeAfaToDestination(long l) {
    }

    default public void updateRgTurnList(TurnListElement[] turnListElementArray) {
    }

    default public void updateRgTurnToStreet(String string, boolean bl) {
    }

    default public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions) {
    }

    default public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
    }

    default public void updateRrdActive(boolean bl) {
    }

    default public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    default public void updateRmPersistentRoute(Route route) {
    }

    default public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
    }

    default public void updateSoPosPosition(PosPosition posPosition) {
    }

    default public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl) {
    }

    default public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
    }

    default public void updateTrRecordingState(int n) {
    }

    default public void updateTrOperatingMode(int n) {
    }

    default public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
    }

    default public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
    }

    default public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
    }

    default public void updateRgRouteCalculationState(int n) {
    }

    default public void rmMakeRoutePersistentResult(long l) {
    }

    default public void rmRouteAddResult(int n, long l) {
    }

    default public void rmRouteDeleteAllResult(int n) {
    }

    default public void rmRouteDeleteResult(int n) {
    }

    default public void rmRouteGetResult(int n, Route route) {
    }

    default public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    default public void rmRouteRenameResult(int n) {
    }

    default public void rgSetRouteGuidanceModeResult() {
    }

    default public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    default public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    default public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    default public void updateNavstateOfOperation(int n) {
    }

    default public void updateNavMedia(String[] stringArray) {
    }

    default public void rgNotPossible(int n) {
    }

    default public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    default public void responseAudioTrigger(int n) {
    }

    default public void liStripLocationResult(NavLocation navLocation) {
    }

    default public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    default public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    default public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    default public void liLastCityAndStreetHistoryResult(long l) {
    }

    default public void liValueListFileStatus(int n, int n2, String string) {
    }

    default public void liValueListOutputMethod(int n) {
    }

    default public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    default public void rgStartGuidanceRouteResult(int n) {
    }

    default public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    default public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    default public void updateDmFlagDestination(NavLocation navLocation) {
    }

    default public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
    }

    default public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray) {
    }

    default public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
    }

    default public void updateLiCountryForCityAndStreetHistory(String string) {
    }

    default public void rgException(int n) {
    }

    default public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
    }

    default public void updateBapManeuverState(int n) {
    }

    default public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    default public void updateRgRouteProperties(RouteProperties routeProperties) {
    }

    default public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
    }

    default public void updateRgPoiInfoCalculationHorizon(long l) {
    }

    default public void updateRgTurnListCalculationHorizon(long l) {
    }

    default public void updateCityVignettes(int[] nArray) {
    }

    default public void updateCountryInfo(CountryInfo[] countryInfoArray) {
    }

    default public void updateEtcCurrentNavDataBase(NavDataBase navDataBase) {
    }

    default public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray) {
    }

    default public void updateAudioRequest(int n) {
    }

    default public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    default public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    default public void liHistoryResult(int n) {
    }

    default public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    default public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    default public void ehResult(int n, int n2) {
    }

    default public void setTrailerStatusResult(int n) {
    }

    default public void setUserDefinedPOIsResult(int n) {
    }

    default public void setVehicleConsumptionInfoResult(int n) {
    }

    default public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray) {
    }

    default public void updateRgiString(short[] sArray) {
    }

    default public void updateStyleDBPaths(String[] stringArray) {
    }

    default public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    default public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    default public void updateRouteResumePossible(boolean bl) {
    }

    default public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    default public void deletePersonalPOIDataBasesResult(int n) {
    }

    default public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    default public void rgGetLocationOnRouteResult(NavLocation navLocation) {
    }

    default public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
    }

    default public void rgStartRubberbandManipulationResult(int n) {
    }

    default public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }

    default public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    default public void updateMapIntegrationState(int n) {
    }

    default public void blockAreaResult(long l, int n) {
    }

    default public void blockRoadSegmentsResult(long l, int n) {
    }

    default public void blockRouteBasedOnLengthResult(long l, int n) {
    }

    default public void blockRouteSegmentsResult(long l, int n) {
    }

    default public void deleteBlockResult(long[] lArray, int n) {
    }

    default public void persistBlockResult(long[] lArray, int n) {
    }

    default public void setBlockDescriptionResult(long[] lArray, int n) {
    }

    default public void updateListOfBlocks(BlockElement[] blockElementArray) {
    }

    default public void updateNaviCoreAvailableToSetBlocks(int n) {
    }

    default public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
    }

    default public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
    }

    default public void windowChanged(int n) {
    }

    default public void updateElementsTotal(long l, long l2, int n) {
    }

    default public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
    }

    default public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
    }

    default public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray) {
    }

    default public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    default public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    default public void rgResult(int n) {
    }

    default public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    default public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    default public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    default public void triggerEventAudioMessageResult(int n) {
    }

    default public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    default public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    default public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    default public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }
}

