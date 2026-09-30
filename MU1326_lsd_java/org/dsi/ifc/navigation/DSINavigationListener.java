/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIListener;
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

public interface DSINavigationListener
extends DSIListener {
    public void updateAfaMode(int var1, int var2);

    public void updateAfaSpeaking(boolean var1, int var2);

    public void updateEtcDemoModeState(boolean var1, int var2);

    public void updateEtcLanguageLoadProgress(long var1, int var3);

    public void updateEtcLanguageLoadStatus(int var1, int var2);

    public void updateEtcMetricSystem(int var1, int var2);

    public void updateDmLastDestinationsList(LDListElement[] var1, int var2);

    public void updateDmRecentRoutesList(RRListElement[] var1, int var2);

    public void updateLispIsSpellerActive(boolean var1, int var2);

    public void updateRgActive(boolean var1, int var2);

    public void updateRgInfoForNextDestination(RgInfoForNextDestination var1, int var2);

    public void updateRgCurrentRoute(Route var1, int var2);

    public void updateRgCurrentRouteOptions(RouteOptions var1, int var2);

    public void updateRgLaneGuidance(NavLaneGuidanceData[] var1, boolean var2, int var3);

    public void updateRgTurnToStreet(String var1, boolean var2, int var3);

    public void updateRgUnfulfilledRouteOptions(RouteOptions var1, int var2);

    public void updateRgDestinationInfo(NavRouteListData[] var1, int var2);

    public void updateRgStreetList(NavRouteListData[] var1, int var2);

    public void updateRgPoiInfo(NavPoiInfo[] var1, int var2);

    public void rgException(int var1);

    public void updateRgRouteProperties(RouteProperties var1, int var2);

    public void updateSoPosPosition(PosPosition var1, int var2);

    public void updateSoPosPositionDescription(NavLocation var1, boolean var2, int var3);

    public void updateSoPosTimeInformation(PosTimeInfo var1, int var2);

    public void updateRrdActive(boolean var1, int var2);

    public void updateRrdCalculationInfo(RrdCalculationInfo[] var1, int var2);

    public void updateEtcVersionInfo(NavVersionInfo var1, int var2);

    public void updateEtcAvailableNavDataBases(NavDataBase[] var1, int var2);

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] var1, int var2);

    public void updateBapTurnToInfo(BapTurnToInfo[] var1, int var2);

    public void updateRgiString(short[] var1, int var2);

    public void updateRgDetailedStreetList(NavRouteListData[] var1, int var2);

    public void updateRmPersistentRoute(Route var1, int var2);

    public void updateRgTimeAfaToDestination(long var1, int var3);

    public void etcSensorDataReplayRoute(Route var1);

    public void etcSensorDataReplayGuidance(boolean var1);

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] var1, int var2);

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation var1, int var2);

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization var1, int var2);

    public void updateTrOperatingMode(int var1, int var2);

    public void updateTrTraceList(NavTraceListData[] var1, int var2);

    public void updateRmRouteList(NavRmRouteListArrayData[] var1, int var2);

    public void updateRgRouteCalculationState(int var1, int var2);

    public void updateNavstateOfOperation(int var1, int var2);

    public void updateNavMedia(String[] var1, int var2);

    public void updateRgTurnList(TurnListElement[] var1, int var2);

    public void updateAvailableLanguages(String[] var1, int var2);

    public void updateLanguage(String var1, int var2);

    public void updateDistanceToNextManeuver(DistanceToNextManeuver var1, int var2);

    public void updateEtcCurrentNavDataBase(NavDataBase var1, int var2);

    public void updateTrDirectionToWaypoint(DirectionToWaypoint var1, int var2);

    public void updatePoiSubstringSearchStatus(ValueListStatus var1, int var2);

    public void updateTrRecordingState(int var1, int var2);

    public void rgSetRouteGuidanceModeResult();

    public void dmLastDestinationsGetResult(long var1, NavLocation var3);

    public void dmRecentRoutesGetResult(long var1, Route var3);

    public void dmResult(long var1, long var3);

    public void liGetStateResult(LISpellerData var1);

    public void liResult(long var1);

    public void lispUpdateSpellerResult(String var1, int var2, boolean var3, boolean var4, String var5, int var6, int var7, boolean var8, boolean var9, int var10, long var11);

    public void liCurrentState(NavLocation var1, int[] var2, int[] var3, long var4);

    public void liValueList(LIValueList var1, long var2);

    public void poiValueList(LIValueList var1, long var2);

    public void liGetLocationDescriptionTransformResult(NavLocation var1);

    public void rmMakeRoutePersistentResult(long var1);

    public void liTryBestMatchResult(TryBestMatchResultData[] var1);

    public void etcGetCountryAbbreviationResult(String var1, long var2);

    public void trStartTraceRecordingResult(int var1, long var2, int var4);

    public void trStopTraceRecordingResult(int var1, long var2, int var4);

    public void trStoreTraceResult(int var1, NavSegmentID var2, int var3);

    public void trRenameTraceResult(int var1, int var2);

    public void trDeleteTraceResult(int var1, int var2);

    public void trDeleteAllTracesResult(int var1, int var2);

    public void rmRouteAddResult(int var1, long var2);

    public void rmRouteDeleteResult(int var1);

    public void rmRouteDeleteAllResult(int var1);

    public void rmRouteGetResult(int var1, Route var2);

    public void rmRouteRenameResult(int var1);

    public void createExportFileResult(int var1, boolean var2);

    public void importFileResult(int var1, boolean var2);

    public void languageSpellableCharactersResult(String var1);

    public void rgNotPossible(int var1);

    public void translateRouteResult(Route var1);

    public void locationToStreamResult(boolean var1, byte[] var2);

    public void streamToLocationResult(boolean var1, NavLocation var2);

    public void liValueListFileStatus(int var1, int var2, String var3);

    public void liValueListOutputMethod(int var1);

    public void updateDmFlagDestination(NavLocation var1, int var2);

    public void liGetLastCityHistoryEntryResult(NavLocation var1, boolean var2);

    public void liGetLastStreetHistoryEntryResult(NavLocation var1, boolean var2);

    public void updateLiCityHistory(LICityHistoryEntry[] var1, int var2);

    public void updateLiCountryForCityAndStreetHistory(String var1, int var2);

    public void liLastCityAndStreetHistoryResult(long var1);

    public void updateLiStreetHistory(LIStreetHistoryEntry[] var1, int var2);

    public void updateLiStateHistory(LIStateHistoryEntry[] var1, int var2);

    public void liHistoryResult(int var1);

    public void liGetLastStateHistoryEntryResult(NavLocation var1, boolean var2);

    public void updateRgTurnListCalculationHorizon(long var1, int var3);

    public void updateRgPoiInfoCalculationHorizon(long var1, int var3);

    public void soPosPositionDescriptionVehicleResult(NavLocation var1);

    public void liStripLocationResult(NavLocation var1);

    public void responseAudioTrigger(int var1);

    public void updateAudioRequest(int var1, int var2);

    public void liSetCountryForCityAndStreetHistoryResult(int var1);

    public void rgStartGuidanceCalculatedRouteResult(int var1);

    public void rgSwitchToNextPossibleRoadResult(boolean var1);

    public void liThesaurusHistoryAddResult(int var1, int var2);

    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry var1, int var2);

    public void liThesaurusHistoryDeleteResult(int var1, int var2);

    public void liThesaurusHistoryDeleteAllResult(int var1);

    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] var1, int var2);

    public void updateCountryInfo(CountryInfo[] var1, int var2);

    public void requestCountryInfoResult(CountryInfo var1, int var2);

    public void ehGetAllCategoriesResult(int var1, Category[] var2, int var3);

    public void ehGetAllBrandsOfCategoryResult(int var1, int var2, Brand[] var3, int var4);

    public void ehResult(int var1, int var2);

    public void setRemainingRangeOfVehicleResult(int var1);

    public void setVehicleConsumptionInfoResult(int var1);

    public void setUserDefinedPOIsResult(int var1);

    public void setTrailerStatusResult(int var1);

    public void liGetViaPointListResult(int var1, ViaPointListElement[] var2, int var3, int var4);

    public void liSelectViaPointResult(NavLocation var1, int var2);

    public void updateStyleDBPaths(String[] var1, int var2);

    public void updateRouteResumePossible(boolean var1, int var2);

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID var1, int var2);

    public void updatePOIsEnteringProximityRange(NavLocation[] var1, int var2);

    public void liGetSpellableCharactersResult(NavLocation var1, int var2, String var3, int var4);

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] var1, int var2);

    public void updatePersonalPOISearchStatus(int var1, int var2);

    public void deletePersonalPOIDataBasesResult(int var1);

    public void setVehicleFuelTypeResult(int var1, int var2);

    public void createNavLocationOfPOIUIDResult(long var1, NavLocation var3, int var4);

    public void rmRouteReplaceResult(int var1, long var2, int var4);

    public void setNavInternalDataToFactorySettingsResult(int var1);

    public void liTryMatchLocationResult(TryMatchLocationResultData[] var1);

    public void updateNavDbRegionsState(int var1, String[] var2, int var3);

    public void trImportTrailsResult(NavSegmentID[] var1, int var2);

    public void trExportTrailsResult(int var1);

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo var1, int var2);

    public void rgStartRubberbandManipulationResult(int var1);

    public void rgGetRouteBoundingRectangleResult(NavRectangle var1, int var2);

    public void rgGetLocationOnRouteResult(NavLocation var1, int var2);

    public void rgResult(int var1);

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 var1, boolean var2, int var3);

    public void updateRgEnhancedSignPostInfoStatus(boolean var1, int var2);

    public void etcSetDemoModeResult(int var1);

    public void lispGetLocationFromLiValueListResult(int var1, NavLocation var2);

    public void lispGetMatchingNVCResult(String var1);

    public void poiGetXt9LDBsResult(String[] var1);

    public void updateRgMotorwayInfo(NavPoiInfo[] var1, int var2);

    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination var1, int var2);

    public void rgTriggerRCCIUpdateResult(int var1);

    public void liGetLocationDescriptionTransformNearByResult(NavLocation var1);

    public void updateRgTurnToInfo(RgTurnToInfo var1, int var2);

    public void etcGetPositionTimeInfoResult(PosTimeInfo var1, int var2);

    public void poiGetCategoryTypesFromUIdResult(int[] var1);

    public void updateRgPersistedRouteDataAvailable(boolean var1, int var2);

    public void liDisambiguateLocationResult(int[] var1, NavLocation[] var2);

    public void triggerEventAudioMessageResult(int var1);

    public void updateMapIntegrationState(int var1, int var2);

    public void updateMapIntegrationProgress(int var1, int var2);

    public void etcTriggerNavigationRestartResult(int var1, int var2);

    public void lispRequestNVCListResult(int var1, String var2, int var3);

    public void updateBapManeuverState(int var1, int var2);

    public void rmImportToursFromGpxFileResult(int var1);

    public void updateRmImportToursFromGpxFileStatus(TourImportStatus var1, int var2);

    public void importRouteFromGpxFileResult(NavLocation var1);

    public void updateBapManeuverInformation(BapManeuverDescriptor[] var1, int var2, int var3);

    public void poiRequestExtendedInfoResult(PoiExtendedInfo var1, boolean var2);

    public void trClearRecordedTraceCacheResult();

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);

    public void deleteSatelliteCacheResult(int var1);
}

