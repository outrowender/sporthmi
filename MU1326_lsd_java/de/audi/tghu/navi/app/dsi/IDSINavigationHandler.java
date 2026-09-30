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
    public void updateDistanceToNextManeuver(DistanceToNextManeuver var1);

    public void dmLastDestinationsGetResult(long var1, NavLocation var3);

    public void dmRecentRoutesGetResult(long var1, Route var3);

    public void dmResult(long var1, long var3);

    public void liCurrentState(NavLocation var1, int[] var2, int[] var3, long var4);

    public void liGetLocationDescriptionTransformResult(NavLocation var1);

    public void liGetLocationDescriptionTransformNearByResult(NavLocation var1);

    public void liGetStateResult(LISpellerData var1);

    public void liGetViaPointListResult(int var1, ViaPointListElement[] var2, int var3, int var4);

    public void liResult(long var1);

    public void liValueList(LIValueList var1, long var2);

    public void lispUpdateSpellerResult(String var1, int var2, boolean var3, boolean var4, String var5, int var6, int var7, boolean var8, boolean var9, int var10, long var11);

    public void lispGetMatchingNVCResult(String var1);

    public void poiValueList(LIValueList var1, long var2);

    public void translateRouteResult(Route var1);

    public void trDeleteAllTracesResult(int var1, int var2);

    public void trDeleteTraceResult(int var1, int var2);

    public void trExportTrailsResult(int var1);

    public void trImportTrailsResult(NavSegmentID[] var1, int var2);

    public void trRenameTraceResult(int var1, int var2);

    public void trStartTraceRecordingResult(int var1, long var2, int var4);

    public void trStopTraceRecordingResult(int var1, long var2, int var4);

    public void trStoreTraceResult(int var1, NavSegmentID var2, int var3);

    public void locationToStreamResult(boolean var1, byte[] var2);

    public void streamToLocationResult(boolean var1, NavLocation var2);

    public void updateAfaMode(int var1);

    public void updateAfaSpeaking(boolean var1);

    public void updateDmLastDestinationsList(LDListElement[] var1);

    public void updateDmRecentRoutesList(RRListElement[] var1);

    public void updateEtcDemoModeState(boolean var1);

    public void updateLanguage(String var1);

    public void updateAvailableLanguages(String[] var1);

    public void updateEtcLanguageLoadProgress(long var1);

    public void updateEtcLanguageLoadStatus(int var1);

    public void updateEtcMetricSystem(int var1);

    public void etcSensorDataReplayRoute(Route var1);

    public void etcSensorDataReplayGuidance(boolean var1);

    public void updateEtcVersionInfo(NavVersionInfo var1);

    public void updateLispIsSpellerActive(boolean var1);

    public void updatePoiSubstringSearchStatus(ValueListStatus var1);

    public void updateRgActive(boolean var1);

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] var1);

    public void updateRgCurrentRoute(Route var1);

    public void updateRgCurrentRouteOptions(RouteOptions var1);

    public void updateRgDestinationInfo(NavRouteListData[] var1);

    public void updateRgPoiInfo(NavPoiInfo[] var1);

    public void updateRgStreetList(NavRouteListData[] var1);

    public void updateRgTimeAfaToDestination(long var1);

    public void updateRgTurnList(TurnListElement[] var1);

    public void updateRgTurnToStreet(String var1, boolean var2);

    public void updateRgUnfulfilledRouteOptions(RouteOptions var1);

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation var1);

    public void updateRrdActive(boolean var1);

    public void updateRrdCalculationInfo(RrdCalculationInfo[] var1);

    public void updateRmPersistentRoute(Route var1);

    public void updateRmRouteList(NavRmRouteListArrayData[] var1);

    public void updateSoPosPosition(PosPosition var1);

    public void updateSoPosPositionDescription(NavLocation var1, boolean var2);

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization var1);

    public void updateTrRecordingState(int var1);

    public void updateTrOperatingMode(int var1);

    public void updateTrTraceList(NavTraceListData[] var1);

    public void updateTrDirectionToWaypoint(DirectionToWaypoint var1);

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo var1);

    public void updateRgRouteCalculationState(int var1);

    public void rmMakeRoutePersistentResult(long var1);

    public void rmRouteAddResult(int var1, long var2);

    public void rmRouteDeleteAllResult(int var1);

    public void rmRouteDeleteResult(int var1);

    public void rmRouteGetResult(int var1, Route var2);

    public void rmRouteReplaceResult(int var1, long var2, int var4);

    public void rmRouteRenameResult(int var1);

    public void rgSetRouteGuidanceModeResult();

    public void updateRgDetailedStreetList(NavRouteListData[] var1);

    public void liTryBestMatchResult(TryBestMatchResultData[] var1);

    public void liTryMatchLocationResult(TryMatchLocationResultData[] var1);

    public void updateNavstateOfOperation(int var1);

    public void updateNavMedia(String[] var1);

    public void rgNotPossible(int var1);

    public void requestCountryInfoResult(CountryInfo var1, int var2);

    public void responseAudioTrigger(int var1);

    public void liStripLocationResult(NavLocation var1);

    public void liGetLastStateHistoryEntryResult(NavLocation var1, boolean var2);

    public void liGetLastCityHistoryEntryResult(NavLocation var1, boolean var2);

    public void liGetLastStreetHistoryEntryResult(NavLocation var1, boolean var2);

    public void liLastCityAndStreetHistoryResult(long var1);

    public void liValueListFileStatus(int var1, int var2, String var3);

    public void liValueListOutputMethod(int var1);

    public void soPosPositionDescriptionVehicleResult(NavLocation var1);

    public void rgStartGuidanceRouteResult(int var1);

    public void rgStartGuidanceCalculatedRouteResult(int var1);

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID var1, int var2);

    public void updateDmFlagDestination(NavLocation var1);

    public void updateLiStateHistory(LIStateHistoryEntry[] var1);

    public void updateLiCityHistory(LICityHistoryEntry[] var1);

    public void updateLiStreetHistory(LIStreetHistoryEntry[] var1);

    public void updateLiCountryForCityAndStreetHistory(String var1);

    public void rgException(int var1);

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] var1);

    public void updateBapManeuverState(int var1);

    public void updateRgInfoForNextDestination(RgInfoForNextDestination var1);

    public void updateRgRouteProperties(RouteProperties var1);

    public void updateRgLaneGuidance(NavLaneGuidanceData[] var1, boolean var2);

    public void updateRgPoiInfoCalculationHorizon(long var1);

    public void updateRgTurnListCalculationHorizon(long var1);

    public void updateCityVignettes(int[] var1);

    public void updateCountryInfo(CountryInfo[] var1);

    public void updateEtcCurrentNavDataBase(NavDataBase var1);

    public void updateEtcAvailableNavDataBases(NavDataBase[] var1);

    public void updateAudioRequest(int var1);

    public void liSelectViaPointResult(NavLocation var1, int var2);

    public void liSetCountryForCityAndStreetHistoryResult(int var1);

    public void liHistoryResult(int var1);

    public void ehGetAllCategoriesResult(int var1, Category[] var2, int var3);

    public void ehGetAllBrandsOfCategoryResult(int var1, int var2, Brand[] var3, int var4);

    public void ehResult(int var1, int var2);

    public void setTrailerStatusResult(int var1);

    public void setUserDefinedPOIsResult(int var1);

    public void setVehicleConsumptionInfoResult(int var1);

    public void updateBapTurnToInfo(BapTurnToInfo[] var1);

    public void updateRgiString(short[] var1);

    public void updateStyleDBPaths(String[] var1);

    public void liGetSpellableCharactersResult(NavLocation var1, int var2, String var3, int var4);

    public void getSpellableCharactersResult(String var1, String var2, int var3, String var4, int var5);

    public void updateRouteResumePossible(boolean var1);

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] var1, int var2);

    public void deletePersonalPOIDataBasesResult(int var1);

    public void updatePersonalPOISearchStatus(int var1, int var2);

    public void rgGetLocationOnRouteResult(NavLocation var1);

    public void rgGetRouteBoundingRectangleResult(NavRectangle var1);

    public void rgStartRubberbandManipulationResult(int var1);

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 var1, boolean var2);

    public void updateNavDbRegionsState(int var1, String[] var2, int var3);

    public void updateMapIntegrationState(int var1);

    public void blockAreaResult(long var1, int var3);

    public void blockRoadSegmentsResult(long var1, int var3);

    public void blockRouteBasedOnLengthResult(long var1, int var3);

    public void blockRouteSegmentsResult(long var1, int var3);

    public void deleteBlockResult(long[] var1, int var2);

    public void persistBlockResult(long[] var1, int var2);

    public void setBlockDescriptionResult(long[] var1, int var2);

    public void updateListOfBlocks(BlockElement[] var1);

    public void updateNaviCoreAvailableToSetBlocks(int var1);

    public void updateMaximumLengthOfBlockRouteBasedOnLength(int var1);

    public void combinedRouteListResult(long var1, CombinedRouteListElement[] var3, int var4);

    public void windowChanged(int var1);

    public void updateElementsTotal(long var1, long var3, int var5);

    public void poiInformationResult(NavPoiInfo var1, int var2);

    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] var1, NavRectangle var2);

    public void updatePOIsEnteringProximityRange(NavLocation[] var1);

    public void lispGetLocationFromLiValueListResult(int var1, NavLocation var2);

    public void poiGetCategoryTypesFromUIdResult(int[] var1);

    public void rgResult(int var1);

    public void rgSwitchToNextPossibleRoadResult(boolean var1);

    public void lispRequestNVCListResult(int var1, String var2, int var3);

    public void liDisambiguateLocationResult(int[] var1, NavLocation[] var2);

    public void triggerEventAudioMessageResult(int var1);

    public void updateBapManeuverInformation(BapManeuverDescriptor[] var1, int var2);

    public void poiRequestExtendedInfoResult(PoiExtendedInfo var1, boolean var2);

    public void poiGetXt9LDBsResult(String[] var1);

    public void importRouteFromGpxFileResult(NavLocation var1);
}

