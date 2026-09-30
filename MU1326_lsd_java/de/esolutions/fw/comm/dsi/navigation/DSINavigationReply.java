/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
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
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public interface DSINavigationReply {
    public static final String IPL_COMM_UUID = "efe47dec-8a76-5eaf-8f4c-7c62f0c19ca2";
    public static final String IPL_COMM_INTERFACE_KEY = "e075b476-7c2d-52f4-9708-34e9ea134eb4";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.71";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.71";

    public void updateAfaMode(int var1, int var2) throws MethodException;

    public void updateAfaSpeaking(boolean var1, int var2) throws MethodException;

    public void updateEtcDemoModeState(boolean var1, int var2) throws MethodException;

    public void updateEtcLanguageLoadProgress(long var1, int var3) throws MethodException;

    public void updateEtcLanguageLoadStatus(int var1, int var2) throws MethodException;

    public void updateEtcMetricSystem(int var1, int var2) throws MethodException;

    public void updateDmLastDestinationsList(LDListElement[] var1, int var2) throws MethodException;

    public void updateDmRecentRoutesList(RRListElement[] var1, int var2) throws MethodException;

    public void updateLispIsSpellerActive(boolean var1, int var2) throws MethodException;

    public void updateRgActive(boolean var1, int var2) throws MethodException;

    public void updateRgInfoForNextDestination(RgInfoForNextDestination var1, int var2) throws MethodException;

    public void updateRgCurrentRoute(Route var1, int var2) throws MethodException;

    public void updateRgCurrentRouteOptions(RouteOptions var1, int var2) throws MethodException;

    public void updateRgLaneGuidance(NavLaneGuidanceData[] var1, boolean var2, int var3) throws MethodException;

    public void updateRgTurnToStreet(String var1, boolean var2, int var3) throws MethodException;

    public void updateRgUnfulfilledRouteOptions(RouteOptions var1, int var2) throws MethodException;

    public void updateRgDestinationInfo(NavRouteListData[] var1, int var2) throws MethodException;

    public void updateRgStreetList(NavRouteListData[] var1, int var2) throws MethodException;

    public void updateRgPoiInfo(NavPoiInfo[] var1, int var2) throws MethodException;

    public void rgException(int var1) throws MethodException;

    public void updateRgRouteProperties(RouteProperties var1, int var2) throws MethodException;

    public void updateSoPosPosition(PosPosition var1, int var2) throws MethodException;

    public void updateSoPosPositionDescription(NavLocation var1, boolean var2, int var3) throws MethodException;

    public void updateSoPosTimeInformation(PosTimeInfo var1, int var2) throws MethodException;

    public void updateRrdActive(boolean var1, int var2) throws MethodException;

    public void updateRrdCalculationInfo(RrdCalculationInfo[] var1, int var2) throws MethodException;

    public void updateEtcVersionInfo(NavVersionInfo var1, int var2) throws MethodException;

    public void updateEtcAvailableNavDataBases(NavDataBase[] var1, int var2) throws MethodException;

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] var1, int var2) throws MethodException;

    public void updateBapTurnToInfo(BapTurnToInfo[] var1, int var2) throws MethodException;

    public void updateRgiString(short[] var1, int var2) throws MethodException;

    public void updateRgDetailedStreetList(NavRouteListData[] var1, int var2) throws MethodException;

    public void updateRmPersistentRoute(Route var1, int var2) throws MethodException;

    public void updateRgTimeAfaToDestination(long var1, int var3) throws MethodException;

    public void etcSensorDataReplayRoute(Route var1) throws MethodException;

    public void etcSensorDataReplayGuidance(boolean var1) throws MethodException;

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] var1, int var2) throws MethodException;

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation var1, int var2) throws MethodException;

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization var1, int var2) throws MethodException;

    public void updateTrOperatingMode(int var1, int var2) throws MethodException;

    public void updateTrTraceList(NavTraceListData[] var1, int var2) throws MethodException;

    public void updateRmRouteList(NavRmRouteListArrayData[] var1, int var2) throws MethodException;

    public void updateRgRouteCalculationState(int var1, int var2) throws MethodException;

    public void updateNavstateOfOperation(int var1, int var2) throws MethodException;

    public void updateNavMedia(String[] var1, int var2) throws MethodException;

    public void updateRgTurnList(TurnListElement[] var1, int var2) throws MethodException;

    public void updateAvailableLanguages(String[] var1, int var2) throws MethodException;

    public void updateLanguage(String var1, int var2) throws MethodException;

    public void updateDistanceToNextManeuver(DistanceToNextManeuver var1, int var2) throws MethodException;

    public void updateEtcCurrentNavDataBase(NavDataBase var1, int var2) throws MethodException;

    public void updateTrDirectionToWaypoint(DirectionToWaypoint var1, int var2) throws MethodException;

    public void updatePoiSubstringSearchStatus(ValueListStatus var1, int var2) throws MethodException;

    public void updateTrRecordingState(int var1, int var2) throws MethodException;

    public void rgSetRouteGuidanceModeResult() throws MethodException;

    public void dmLastDestinationsGetResult(long var1, NavLocation var3) throws MethodException;

    public void dmRecentRoutesGetResult(long var1, Route var3) throws MethodException;

    public void dmResult(long var1, long var3) throws MethodException;

    public void liGetStateResult(LISpellerData var1) throws MethodException;

    public void liResult(long var1) throws MethodException;

    public void lispUpdateSpellerResult(String var1, int var2, boolean var3, boolean var4, String var5, int var6, int var7, boolean var8, boolean var9, int var10, long var11) throws MethodException;

    public void liCurrentState(NavLocation var1, int[] var2, int[] var3, long var4) throws MethodException;

    public void liValueList(LIValueList var1, long var2) throws MethodException;

    public void poiValueList(LIValueList var1, long var2) throws MethodException;

    public void liGetLocationDescriptionTransformResult(NavLocation var1) throws MethodException;

    public void rmMakeRoutePersistentResult(long var1) throws MethodException;

    public void liTryBestMatchResult(TryBestMatchResultData[] var1) throws MethodException;

    public void etcGetCountryAbbreviationResult(String var1, long var2) throws MethodException;

    public void trStartTraceRecordingResult(int var1, long var2, int var4) throws MethodException;

    public void trStopTraceRecordingResult(int var1, long var2, int var4) throws MethodException;

    public void trStoreTraceResult(int var1, NavSegmentID var2, int var3) throws MethodException;

    public void trRenameTraceResult(int var1, int var2) throws MethodException;

    public void trDeleteTraceResult(int var1, int var2) throws MethodException;

    public void trDeleteAllTracesResult(int var1, int var2) throws MethodException;

    public void rmRouteAddResult(int var1, long var2) throws MethodException;

    public void rmRouteDeleteResult(int var1) throws MethodException;

    public void rmRouteDeleteAllResult(int var1) throws MethodException;

    public void rmRouteGetResult(int var1, Route var2) throws MethodException;

    public void rmRouteRenameResult(int var1) throws MethodException;

    public void createExportFileResult(int var1, boolean var2) throws MethodException;

    public void importFileResult(int var1, boolean var2) throws MethodException;

    public void languageSpellableCharactersResult(String var1) throws MethodException;

    public void rgNotPossible(int var1) throws MethodException;

    public void translateRouteResult(Route var1) throws MethodException;

    public void locationToStreamResult(boolean var1, byte[] var2) throws MethodException;

    public void streamToLocationResult(boolean var1, NavLocation var2) throws MethodException;

    public void liValueListFileStatus(int var1, int var2, String var3) throws MethodException;

    public void liValueListOutputMethod(int var1) throws MethodException;

    public void updateDmFlagDestination(NavLocation var1, int var2) throws MethodException;

    public void liGetLastCityHistoryEntryResult(NavLocation var1, boolean var2) throws MethodException;

    public void liGetLastStreetHistoryEntryResult(NavLocation var1, boolean var2) throws MethodException;

    public void updateLiCityHistory(LICityHistoryEntry[] var1, int var2) throws MethodException;

    public void updateLiCountryForCityAndStreetHistory(String var1, int var2) throws MethodException;

    public void liLastCityAndStreetHistoryResult(long var1) throws MethodException;

    public void updateLiStreetHistory(LIStreetHistoryEntry[] var1, int var2) throws MethodException;

    public void updateLiStateHistory(LIStateHistoryEntry[] var1, int var2) throws MethodException;

    public void liHistoryResult(int var1) throws MethodException;

    public void liGetLastStateHistoryEntryResult(NavLocation var1, boolean var2) throws MethodException;

    public void updateRgTurnListCalculationHorizon(long var1, int var3) throws MethodException;

    public void updateRgPoiInfoCalculationHorizon(long var1, int var3) throws MethodException;

    public void soPosPositionDescriptionVehicleResult(NavLocation var1) throws MethodException;

    public void liStripLocationResult(NavLocation var1) throws MethodException;

    public void responseAudioTrigger(int var1) throws MethodException;

    public void updateAudioRequest(int var1, int var2) throws MethodException;

    public void liSetCountryForCityAndStreetHistoryResult(int var1) throws MethodException;

    public void rgStartGuidanceCalculatedRouteResult(int var1) throws MethodException;

    public void rgSwitchToNextPossibleRoadResult(boolean var1) throws MethodException;

    public void liThesaurusHistoryAddResult(int var1, int var2) throws MethodException;

    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry var1, int var2) throws MethodException;

    public void liThesaurusHistoryDeleteResult(int var1, int var2) throws MethodException;

    public void liThesaurusHistoryDeleteAllResult(int var1) throws MethodException;

    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] var1, int var2) throws MethodException;

    public void updateCountryInfo(CountryInfo[] var1, int var2) throws MethodException;

    public void requestCountryInfoResult(CountryInfo var1, int var2) throws MethodException;

    public void ehGetAllCategoriesResult(int var1, Category[] var2, int var3) throws MethodException;

    public void ehGetAllBrandsOfCategoryResult(int var1, int var2, Brand[] var3, int var4) throws MethodException;

    public void ehResult(int var1, int var2) throws MethodException;

    public void setRemainingRangeOfVehicleResult(int var1) throws MethodException;

    public void setVehicleConsumptionInfoResult(int var1) throws MethodException;

    public void setUserDefinedPOIsResult(int var1) throws MethodException;

    public void setTrailerStatusResult(int var1) throws MethodException;

    public void liGetViaPointListResult(int var1, ViaPointListElement[] var2, int var3, int var4) throws MethodException;

    public void liSelectViaPointResult(NavLocation var1, int var2) throws MethodException;

    public void updateStyleDBPaths(String[] var1, int var2) throws MethodException;

    public void updateRouteResumePossible(boolean var1, int var2) throws MethodException;

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID var1, int var2) throws MethodException;

    public void updatePOIsEnteringProximityRange(NavLocation[] var1, int var2) throws MethodException;

    public void liGetSpellableCharactersResult(NavLocation var1, int var2, String var3, int var4) throws MethodException;

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] var1, int var2) throws MethodException;

    public void updatePersonalPOISearchStatus(int var1, int var2) throws MethodException;

    public void deletePersonalPOIDataBasesResult(int var1) throws MethodException;

    public void setVehicleFuelTypeResult(int var1, int var2) throws MethodException;

    public void createNavLocationOfPOIUIDResult(long var1, NavLocation var3, int var4) throws MethodException;

    public void rmRouteReplaceResult(int var1, long var2, int var4) throws MethodException;

    public void setNavInternalDataToFactorySettingsResult(int var1) throws MethodException;

    public void liTryMatchLocationResult(TryMatchLocationResultData[] var1) throws MethodException;

    public void updateNavDbRegionsState(int var1, String[] var2, int var3) throws MethodException;

    public void trImportTrailsResult(NavSegmentID[] var1, int var2) throws MethodException;

    public void trExportTrailsResult(int var1) throws MethodException;

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo var1, int var2) throws MethodException;

    public void rgStartRubberbandManipulationResult(int var1) throws MethodException;

    public void rgGetRouteBoundingRectangleResult(NavRectangle var1, int var2) throws MethodException;

    public void rgGetLocationOnRouteResult(NavLocation var1, int var2) throws MethodException;

    public void rgResult(int var1) throws MethodException;

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 var1, boolean var2, int var3) throws MethodException;

    public void updateRgEnhancedSignPostInfoStatus(boolean var1, int var2) throws MethodException;

    public void etcSetDemoModeResult(int var1) throws MethodException;

    public void lispGetLocationFromLiValueListResult(int var1, NavLocation var2) throws MethodException;

    public void lispGetMatchingNVCResult(String var1) throws MethodException;

    public void poiGetXt9LDBsResult(String[] var1) throws MethodException;

    public void updateRgMotorwayInfo(NavPoiInfo[] var1, int var2) throws MethodException;

    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination var1, int var2) throws MethodException;

    public void rgTriggerRCCIUpdateResult(int var1) throws MethodException;

    public void liGetLocationDescriptionTransformNearByResult(NavLocation var1) throws MethodException;

    public void updateRgTurnToInfo(RgTurnToInfo var1, int var2) throws MethodException;

    public void etcGetPositionTimeInfoResult(PosTimeInfo var1, int var2) throws MethodException;

    public void poiGetCategoryTypesFromUIdResult(int[] var1) throws MethodException;

    public void updateRgPersistedRouteDataAvailable(boolean var1, int var2) throws MethodException;

    public void liDisambiguateLocationResult(int[] var1, NavLocation[] var2) throws MethodException;

    public void triggerEventAudioMessageResult(int var1) throws MethodException;

    public void updateMapIntegrationState(int var1, int var2) throws MethodException;

    public void updateMapIntegrationProgress(int var1, int var2) throws MethodException;

    public void etcTriggerNavigationRestartResult(int var1, int var2) throws MethodException;

    public void lispRequestNVCListResult(int var1, String var2, int var3) throws MethodException;

    public void updateBapManeuverState(int var1, int var2) throws MethodException;

    public void rmImportToursFromGpxFileResult(int var1) throws MethodException;

    public void updateRmImportToursFromGpxFileStatus(TourImportStatus var1, int var2) throws MethodException;

    public void importRouteFromGpxFileResult(NavLocation var1) throws MethodException;

    public void updateBapManeuverInformation(BapManeuverDescriptor[] var1, int var2, int var3) throws MethodException;

    public void poiRequestExtendedInfoResult(PoiExtendedInfo var1, boolean var2) throws MethodException;

    public void trClearRecordedTraceCacheResult() throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void deleteSatelliteCacheResult(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

