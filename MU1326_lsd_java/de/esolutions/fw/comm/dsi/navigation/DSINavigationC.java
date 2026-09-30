/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public interface DSINavigationC {
    public void afaRepeat(int var1) throws MethodException;

    public void createExportFile(String var1, int var2) throws MethodException;

    public void dmFlagDestinationSet(NavLocation var1) throws MethodException;

    public void dmFlagDestinationRemove() throws MethodException;

    public void dmFlagDestinationSetName(String var1) throws MethodException;

    public void dmLastDestinationsAddList(NavLastDest[] var1) throws MethodException;

    public void dmLastDestinationsDelete(long var1) throws MethodException;

    public void dmLastDestinationsDeleteAll() throws MethodException;

    public void dmLastDestinationsGet(long var1) throws MethodException;

    public void dmLastDestinationsReplace(long var1, NavLocation var3, String var4) throws MethodException;

    public void dmRecentRoutesAdd(Route var1, String var2) throws MethodException;

    public void dmRecentRoutesDelete(long var1) throws MethodException;

    public void dmRecentRoutesDeleteAll() throws MethodException;

    public void dmRecentRoutesGet(long var1) throws MethodException;

    public void dmRecentRoutesReplace(long var1, Route var3, String var4) throws MethodException;

    public void enableRgStreetLists(boolean var1) throws MethodException;

    public void enableRgLaneGuidance(boolean var1) throws MethodException;

    public void enableRgPoiInfo(boolean var1) throws MethodException;

    public void etcGetCountryAbbreviation(String var1) throws MethodException;

    public void etcSetDemoMode(boolean var1) throws MethodException;

    public void etcSetDemoModeSpeed(long var1) throws MethodException;

    public void etcSetMetricSystem(int var1) throws MethodException;

    public void etcSelectDatabase(int var1) throws MethodException;

    public void etcSelectNavDataBase(int var1) throws MethodException;

    public void importFile(String var1, int var2) throws MethodException;

    public void languageSpellableCharacters(String var1) throws MethodException;

    public void liGetCurrentState() throws MethodException;

    public void liGetLastCityHistoryEntry(long var1) throws MethodException;

    public void liGetLastStreetHistoryEntry(long var1) throws MethodException;

    public void liGetLocationDescriptionTransform(NavLocation var1) throws MethodException;

    public void liGetLocationDescriptionTransformNearBy(NavLocation var1) throws MethodException;

    public void liGetState() throws MethodException;

    public void liGetLastStateHistoryEntry(long var1) throws MethodException;

    public void liLastStateHistoryAdd(NavLocation var1, boolean var2, String var3) throws MethodException;

    public void liLastStateHistoryAddExtended(NavLocation var1, boolean var2, String var3, LIExtData[] var4) throws MethodException;

    public void liLastStateHistoryDelete(long var1) throws MethodException;

    public void liLastStateHistoryDeleteAll() throws MethodException;

    public void liLastCityHistoryAdd(NavLocation var1, boolean var2, String var3) throws MethodException;

    public void liLastCityHistoryAddExtended(NavLocation var1, boolean var2, String var3, LIExtData[] var4) throws MethodException;

    public void liLastCityHistoryDelete(long var1) throws MethodException;

    public void liLastCityHistoryDeleteAll() throws MethodException;

    public void liLastStreetHistoryAdd(NavLocation var1, String var2) throws MethodException;

    public void liLastStreetHistoryAddExtended(NavLocation var1, String var2, LIExtData[] var3) throws MethodException;

    public void liLastStreetHistoryDelete(long var1) throws MethodException;

    public void liLastStreetHistoryDeleteAll() throws MethodException;

    public void liRestoreState(LISpellerData var1) throws MethodException;

    public void liSetCountryForCityAndStreetHistory(String var1) throws MethodException;

    public void liSetHistory(String var1, String var2) throws MethodException;

    public void liSetStreetForCityHistory(String var1) throws MethodException;

    public void liDeleteHistory() throws MethodException;

    public void liSetCurrentLD(NavLocation var1) throws MethodException;

    public void lispAddCharacter(String var1) throws MethodException;

    public void lispCancelSpeller() throws MethodException;

    public void lispDeleteAllCharacters() throws MethodException;

    public void lispRequestValueListByListIndex(int var1, boolean var2) throws MethodException;

    public void lispSelectListItem(int var1) throws MethodException;

    public void lispSelectItemFromLocation(NavLocation var1) throws MethodException;

    public void lispSelectByCategoryUid(int var1) throws MethodException;

    public void lispSelectByMultipleCategoryUids(int[] var1) throws MethodException;

    public void lispSetInput(String var1, boolean var2) throws MethodException;

    public void lispGetMatchingNVC(String var1) throws MethodException;

    public void lispUndoCharacter() throws MethodException;

    public void liStartMultiCriteriaSpeller(int var1, int var2, boolean var3, boolean var4, boolean var5) throws MethodException;

    public void liStartSpeller(int var1, boolean var2, boolean var3, boolean var4) throws MethodException;

    public void liTryBestMatch(TryBestMatchData var1) throws MethodException;

    public void liValueListFilename(String var1) throws MethodException;

    public void liValueListOutputMethod(int var1) throws MethodException;

    public void locationToStream(NavLocation var1) throws MethodException;

    public void poiSelectSelectionCriteria(long var1) throws MethodException;

    public void poiSetContext(NavLocation var1) throws MethodException;

    public void poiSetSortOrder2(int var1) throws MethodException;

    public void poiStartSpellerAlongRoute(int var1, long var2, long var4) throws MethodException;

    public void poiStartSpellerAlongRouteAdvanced(int var1, long var2, long var4, long var6, boolean var8) throws MethodException;

    public void requestSoPosPositionDescriptionVehicle() throws MethodException;

    public void rgCalculateRoute(Route var1, int var2) throws MethodException;

    public void rgSetPosition(NavLocation var1) throws MethodException;

    public void rgSetRouteGuidanceMode(int var1) throws MethodException;

    public void rgSetRouteOptions(RouteOptions var1) throws MethodException;

    public void rgStartGuidanceCalculatedRoute(int var1) throws MethodException;

    public void rgStopGuidance() throws MethodException;

    public void rmMakeRoutePersistent(Route var1) throws MethodException;

    public void rmRouteAdd(int var1, Route var2, String var3) throws MethodException;

    public void rmRouteDelete(int var1, long var2) throws MethodException;

    public void rmRouteDeleteAll(int var1) throws MethodException;

    public void rmRouteGet(int var1, long var2) throws MethodException;

    public void rmRouteRename(int var1, long var2, String var4) throws MethodException;

    public void rrdStartCalculationByListIndex(int var1, long var2) throws MethodException;

    public void rrdStartCalculationForPosition(NavLocationWgs84[] var1) throws MethodException;

    public void rrdStopCalculation() throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void streamToLocation(byte[] var1) throws MethodException;

    public void translateRoute(Route var1) throws MethodException;

    public void trCreateWaypoint() throws MethodException;

    public void trDeleteAllTraces() throws MethodException;

    public void trDeleteTrace(NavSegmentID var1) throws MethodException;

    public void trRenameTrace(NavSegmentID var1, String var2) throws MethodException;

    public void trStartTraceRecording(int var1) throws MethodException;

    public void trStopTraceRecording() throws MethodException;

    public void trStoreTrace(String var1) throws MethodException;

    public void liStripLocation(NavLocation var1, int var2) throws MethodException;

    public void liSetNVCRange(int var1) throws MethodException;

    public void liValueListWindowSize(int var1) throws MethodException;

    public void requestAudioTrigger(int var1) throws MethodException;

    public void liThesaurusHistoryAdd(String var1) throws MethodException;

    public void liThesaurusHistoryGetEntry(int var1) throws MethodException;

    public void liThesaurusHistoryDelete(int var1) throws MethodException;

    public void liThesaurusHistoryDeleteAll() throws MethodException;

    public void ehGetAllCategories(int var1) throws MethodException;

    public void ehGetAllBrandsOfCategory(int var1, int var2) throws MethodException;

    public void ehSetCategoryVisibility(int var1, int[] var2, boolean[] var3) throws MethodException;

    public void ehSetCategoryVisibilityToDefault(int var1) throws MethodException;

    public void ehSetCategoryAudioWarning(int var1, int[] var2, boolean[] var3) throws MethodException;

    public void ehSetCategoryMonitoring(int[] var1, boolean[] var2) throws MethodException;

    public void ehSetBrandVisibility(int var1, int[] var2, boolean[] var3) throws MethodException;

    public void ehSetBrandPreference(int var1, int[] var2, boolean[] var3) throws MethodException;

    public void setRemainingRangeOfVehicle(int var1) throws MethodException;

    public void setUserDefinedPOIs(NavLocation[] var1) throws MethodException;

    public void setTrailerStatus(boolean var1) throws MethodException;

    public void requestCountryInfo(String var1) throws MethodException;

    public void jumpToNextManeuver() throws MethodException;

    public void liGetViaPointCountryList() throws MethodException;

    public void liSetViaPointCountry(String var1) throws MethodException;

    public void liGetViaPointList(int var1, int var2, int var3, int var4) throws MethodException;

    public void liSelectViaPoint(int var1) throws MethodException;

    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID var1) throws MethodException;

    public void liGetSpellableCharacters(NavLocation var1, int var2) throws MethodException;

    public void liStopSpeller() throws MethodException;

    public void liValueListMaximumLength(int var1) throws MethodException;

    public void setPathsToPersonalPOIDataBases(String[] var1) throws MethodException;

    public void deletePersonalPOIDataBases(String[] var1) throws MethodException;

    public void rgStopRouteCalculation() throws MethodException;

    public void rgSwitchToNextPossibleRoad() throws MethodException;

    public void setVehicleFuelType(int var1) throws MethodException;

    public void createNavLocationOfPOIUID(long var1) throws MethodException;

    public void lispSelectListItemByIdent(String var1) throws MethodException;

    public void rmRouteReplace(int var1, long var2, Route var4) throws MethodException;

    public void setNavInternalDataToFactorySettings() throws MethodException;

    public void liTryMatchLocation(TryMatchLocationData var1) throws MethodException;

    public void trImportTrails(String var1) throws MethodException;

    public void trExportTrails(NavSegmentID[] var1, String var2) throws MethodException;

    public void rgSkipNextWayPoints(int var1) throws MethodException;

    public void rgReverseTrailDirection() throws MethodException;

    public void rgPrepareRubberbandManipulation(boolean var1) throws MethodException;

    public void rgStartRubberbandManipulation(int var1) throws MethodException;

    public void rgSetRubberbandPosition(NavLocationWgs84 var1) throws MethodException;

    public void rgGetRouteBoundingRectangle(boolean var1, int var2) throws MethodException;

    public void rgGetLocationOnRoute(long var1) throws MethodException;

    public void rgStopRubberbandManipulation() throws MethodException;

    public void rgDeleteCalculatedRubberbandPoint() throws MethodException;

    public void rgGetRubberBandPointPosition() throws MethodException;

    public void rgEnableEnhancedSignPostInfo(boolean var1) throws MethodException;

    public void lispGetLocationFromLiValueListElement(int var1) throws MethodException;

    public void rgSetTurnListMode(int var1) throws MethodException;

    public void liHistoryAddLocation(NavLocation var1) throws MethodException;

    public void liLastCityHistorySetStreet(NavLocation var1) throws MethodException;

    public void liLastStreetHistorySetCity(NavLocation var1) throws MethodException;

    public void enableRgMotorwayInfo(boolean var1) throws MethodException;

    public void rgTriggerRCCIUpdate() throws MethodException;

    public void poiGetXt9LDBs(NavLocation var1, int var2) throws MethodException;

    public void poiSetListStyle(int var1) throws MethodException;

    public void etcGetPositionTimeInfo(NavLocationWgs84 var1) throws MethodException;

    public void poiGetCategoryTypesFromUId(int var1) throws MethodException;

    public void rgDeletePersistedRouteData() throws MethodException;

    public void rgCalculate1stRouteAndPostponeRemaining(Route var1, int var2, boolean var3) throws MethodException;

    public void liDisambiguateLocation(NavLocation var1) throws MethodException;

    public void triggerEventAudioMessage(int var1) throws MethodException;

    public void lispAddStroke(String var1) throws MethodException;

    public void lispRequestNVCList(int var1, int var2, int var3) throws MethodException;

    public void poiConfigureContext(String var1, int var2, NavLocation var3, int[] var4) throws MethodException;

    public void etcTriggerNavigationRestart(int var1) throws MethodException;

    public void rmImportToursFromGpxFile(int var1, String var2) throws MethodException;

    public void rmAbortImportToursFromGpxFile() throws MethodException;

    public void importRouteFromGpxFile(String var1) throws MethodException;

    public void poiRequestExtendedInfo(NavLocation var1) throws MethodException;

    public void rgConfigurePoiInfo(NavPoiInfoConfiguration var1) throws MethodException;

    public void trClearRecordedTraceCache() throws MethodException;

    public void setVirtualRouteGuidance(boolean var1) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void deleteSatelliteCache() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

