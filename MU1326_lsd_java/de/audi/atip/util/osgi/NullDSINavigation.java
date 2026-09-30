/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public class NullDSINavigation
extends NullService
implements DSINavigation {
    public NullDSINavigation(LogChannel logChannel) {
        super(logChannel, "DSINavigation");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    public void afaRepeat(int n) {
        this.log();
    }

    public void createExportFile(String string, int n) {
        this.log();
    }

    public void dmFlagDestinationSet(NavLocation navLocation) {
        this.log();
    }

    public void dmFlagDestinationRemove() {
        this.log();
    }

    public void dmFlagDestinationSetName(String string) {
        this.log();
    }

    public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
        this.log();
    }

    public void dmLastDestinationsDelete(long l) {
        this.log();
    }

    public void dmLastDestinationsDeleteAll() {
        this.log();
    }

    public void dmLastDestinationsGet(long l) {
        this.log();
    }

    public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
        this.log();
    }

    public void dmRecentRoutesAdd(Route route, String string) {
        this.log();
    }

    public void dmRecentRoutesDelete(long l) {
        this.log();
    }

    public void dmRecentRoutesDeleteAll() {
        this.log();
    }

    public void dmRecentRoutesGet(long l) {
        this.log();
    }

    public void dmRecentRoutesReplace(long l, Route route, String string) {
        this.log();
    }

    public void enableRgStreetLists(boolean bl) {
        this.log();
    }

    public void enableRgLaneGuidance(boolean bl) {
        this.log();
    }

    public void enableRgPoiInfo(boolean bl) {
        this.log();
    }

    public void etcGetCountryAbbreviation(String string) {
        this.log();
    }

    public void etcSetDemoMode(boolean bl) {
        this.log();
    }

    public void etcSetDemoModeSpeed(long l) {
        this.log();
    }

    public void etcSetMetricSystem(int n) {
        this.log();
    }

    public void etcSelectDatabase(int n) {
        this.log();
    }

    public void etcSelectNavDataBase(int n) {
        this.log();
    }

    public void importFile(String string, int n) {
        this.log();
    }

    public void languageSpellableCharacters(String string) {
        this.log();
    }

    public void liGetCurrentState() {
        this.log();
    }

    public void liGetLastCityHistoryEntry(long l) {
        this.log();
    }

    public void liGetLastStreetHistoryEntry(long l) {
        this.log();
    }

    public void liGetLocationDescriptionTransform(NavLocation navLocation) {
        this.log();
    }

    public void liGetState() {
        this.log();
    }

    public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        this.log();
    }

    public void liLastCityHistoryDelete(long l) {
        this.log();
    }

    public void liLastCityHistoryDeleteAll() {
        this.log();
    }

    public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
        this.log();
    }

    public void liLastStreetHistoryDelete(long l) {
        this.log();
    }

    public void liLastStreetHistoryDeleteAll() {
        this.log();
    }

    public void liRestoreState(LISpellerData lISpellerData) {
        this.log();
    }

    public void liSetCountryForCityAndStreetHistory(String string) {
        this.log();
    }

    public void liSetCurrentLD(NavLocation navLocation) {
        this.log();
    }

    public void lispAddCharacter(String string) {
        this.log();
    }

    public void lispCancelSpeller() {
        this.log();
    }

    public void lispDeleteAllCharacters() {
        this.log();
    }

    public void lispRequestValueListByListIndex(int n, boolean bl) {
        this.log();
    }

    public void lispSelectListItem(int n) {
        this.log();
    }

    public void lispSelectByCategoryUid(int n) {
        this.log();
    }

    public void lispSetInput(String string, boolean bl) {
        this.log();
    }

    public void lispUndoCharacter() {
        this.log();
    }

    public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.log();
    }

    public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
        this.log();
    }

    public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
        this.log();
    }

    public void liValueListFilename(String string) {
        this.log();
    }

    public void liValueListOutputMethod(int n) {
        this.log();
    }

    public void locationToStream(NavLocation navLocation) {
        this.log();
    }

    public void poiSelectSelectionCriteria(long l) {
        this.log();
    }

    public void poiSetContext(NavLocation navLocation) {
        this.log();
    }

    public void poiSetSortOrder(boolean bl) {
        this.log();
    }

    public void poiSetSortOrder2(int n) {
        this.log();
    }

    public void poiStartSpellerAlongRoute(int n, long l, long l2) {
        this.log();
    }

    public void requestSoPosPositionDescriptionVehicle() {
        this.log();
    }

    public void rgCalculateRoute(Route route, int n) {
        this.log();
    }

    public void rgSetDefaultRouteOptions(RouteOptions routeOptions) {
        this.log();
    }

    public void rgSetPosition(NavLocation navLocation) {
        this.log();
    }

    public void rgSetRouteGuidanceMode(int n) {
        this.log();
    }

    public void rgSetRouteOptions(RouteOptions routeOptions) {
        this.log();
    }

    public void rgStartGuidanceCalculatedRoute(int n) {
        this.log();
    }

    public void rgStopGuidance() {
        this.log();
    }

    public void rmMakeRoutePersistent(Route route) {
        this.log();
    }

    public void rmRouteAdd(int n, Route route, String string) {
        this.log();
    }

    public void rmRouteDelete(int n, long l) {
        this.log();
    }

    public void rmRouteDeleteAll(int n) {
        this.log();
    }

    public void rmRouteGet(int n, long l) {
        this.log();
    }

    public void rmRouteRename(int n, long l, String string) {
        this.log();
    }

    public void rrdStartCalculationByListIndex(int n, long l) {
        this.log();
    }

    public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
        this.log();
    }

    public void rrdStopCalculation() {
        this.log();
    }

    public void setLanguage(String string) {
        this.log();
    }

    public void streamToLocation(byte[] byArray) {
        this.log();
    }

    public void translateRoute(Route route) {
        this.log();
    }

    public void trCreateWaypoint() {
        this.log();
    }

    public void trDeleteAllTraces() {
        this.log();
    }

    public void trDeleteTrace(NavSegmentID navSegmentID) {
        this.log();
    }

    public void trRenameTrace(NavSegmentID navSegmentID, String string) {
        this.log();
    }

    public void trStartTraceRecording(int n) {
        this.log();
    }

    public void trStopTraceRecording() {
        this.log();
    }

    public void trStoreTrace(String string) {
        this.log();
    }

    public void liStripLocation(NavLocation navLocation, int n) {
        this.log();
    }

    public void requestAudioTrigger(int n) {
        this.log();
    }

    public void liThesaurusHistoryAdd(String string) {
        this.log();
    }

    public void liThesaurusHistoryGetEntry(int n) {
        this.log();
    }

    public void liThesaurusHistoryDelete(int n) {
        this.log();
    }

    public void liThesaurusHistoryDeleteAll() {
        this.log();
    }

    public void ehGetAllCategories(int n) {
        this.log();
    }

    public void ehGetAllBrandsOfCategory(int n, int n2) {
        this.log();
    }

    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
        this.log();
    }

    public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    public void setRemainingRangeOfVehicle(int n) {
        this.log();
    }

    public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
        this.log();
    }

    public void setTrailerStatus(boolean bl) {
        this.log();
    }

    public void requestCountryInfo(String string) {
        this.log();
    }

    public void jumpToNextManeuver() {
        this.log();
    }

    public void liGetViaPointList(int n, int n2, int n3, int n4) {
        this.log();
    }

    public void liSelectViaPoint(int n) {
        this.log();
    }

    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        this.log();
    }

    public void getSpellableCharacters(String string, String string2, int n) {
        this.log();
    }

    public void liGetSpellableCharacters(NavLocation navLocation, int n) {
        this.log();
    }

    public void liStopSpeller() {
        this.log();
    }

    public void liValueListMaximumLength(int n) {
        this.log();
    }

    public void setPathsToPersonalPOIDataBases(String[] stringArray) {
        this.log();
    }

    public void deletePersonalPOIDataBases(String[] stringArray) {
        this.log();
    }

    public void rgStopRouteCalculation() {
        this.log();
    }

    public void setVehicleFuelType(int n) {
        this.log();
    }

    public void createNavLocationOfPOIUID(long l) {
        this.log();
    }

    public void lispSelectListItemByIdent(String string) {
        this.log();
    }

    public void rmRouteReplace(int n, long l, Route route) {
        this.log();
    }

    public void liGetLastStateHistoryEntry(long l) {
        this.log();
    }

    public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        this.log();
    }

    public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        this.log();
    }

    public void liLastStateHistoryDelete(long l) {
        this.log();
    }

    public void liLastStateHistoryDeleteAll() {
        this.log();
    }

    public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        this.log();
    }

    public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
        this.log();
    }

    public void liSetHistory(String string, String string2) {
        this.log();
    }

    public void liDeleteHistory() {
        this.log();
    }

    public void lispSelectItemFromLocation(NavLocation navLocation) {
        this.log();
    }

    public void rgSwitchToNextPossibleRoad() {
        this.log();
    }

    public void lispSelectByMultipleCategoryUids(int[] nArray) {
        this.log();
    }

    public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
        this.log();
    }

    public void liValueListWindowSize(int n) {
        this.log();
    }

    public void ehSetCategoryVisibilityToDefault(int n) {
        this.log();
    }

    public void setNavInternalDataToFactorySettings() {
        this.log();
    }

    public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
        this.log();
    }

    public void liSetStreetForCityHistory(String string) {
        this.log();
    }

    public void liGetViaPointCountryList() {
        this.log();
    }

    public void liSetViaPointCountry(String string) {
        this.log();
    }

    public void trImportTrails(String string) {
        this.log();
    }

    public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
        this.log();
    }

    public void rgSkipNextWayPoints(int n) {
        this.log();
    }

    public void rgReverseTrailDirection() {
        this.log();
    }

    public void rgPrepareRubberbandManipulation(boolean bl) {
        this.log();
    }

    public void rgStartRubberbandManipulation(int n) {
        this.log();
    }

    public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        this.log();
    }

    public void rgGetRouteBoundingRectangle(boolean bl, int n) {
        this.log();
    }

    public void rgGetLocationOnRoute(long l) {
        this.log();
    }

    public void rgStopRubberbandManipulation() {
        this.log();
    }

    public void rgEnableEnhancedSignPostInfo(boolean bl) {
        this.log();
    }

    public void rgDeleteCalculatedRubberbandPoint() {
        this.log();
    }

    public void rgGetRubberBandPointPosition() {
        this.log();
    }

    public void lispGetMatchingNVC(String string) {
        this.log();
    }

    public void liSetNVCRange(int n) {
        this.log();
    }

    public void lispGetLocationFromLiValueListElement(int n) {
        this.log();
    }

    public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
        this.log();
    }

    public void rgSetTurnListMode(int n) {
        this.log();
    }

    public void liHistoryAddLocation(NavLocation navLocation) {
        this.log();
    }

    public void liLastCityHistorySetStreet(NavLocation navLocation) {
        this.log();
    }

    public void liLastStreetHistorySetCity(NavLocation navLocation) {
        this.log();
    }

    public void enableRgMotorwayInfo(boolean bl) {
        this.log();
    }

    public void rgTriggerRCCIUpdate() {
        this.log();
    }

    public void poiGetXt9LDBs(NavLocation navLocation, int n) {
        this.log();
    }

    public void poiSetListStyle(int n) {
        this.log();
    }

    public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
        this.log();
    }

    public void poiGetCategoryTypesFromUId(int n) {
        this.log();
    }

    public void rgDeletePersistedRouteData() {
        this.log();
    }

    public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
        this.log();
    }

    public void liDisambiguateLocation(NavLocation navLocation) {
        this.log();
    }

    public void triggerEventAudioMessage(int n) {
        this.log();
    }

    public void lispAddStroke(String string) {
        this.log();
    }

    public void lispRequestNVCList(int n, int n2, int n3) {
        this.log();
    }

    public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
        this.log();
    }

    public void etcTriggerNavigationRestart(int n) {
        this.log();
    }

    public void rmImportToursFromGpxFile(int n, String string) {
        this.log();
    }

    public void rmAbortImportToursFromGpxFile() {
        this.log();
    }

    public void importRouteFromGpxFile(String string) {
        this.log();
    }

    public void poiRequestExtendedInfo(NavLocation navLocation) {
        this.log();
    }

    public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
        this.log();
    }

    public void trClearRecordedTraceCache() {
        this.log();
    }

    public void profileChange(int n) {
        this.log();
    }

    public void profileCopy(int n, int n2) {
        this.log();
    }

    public void profileReset(int n) {
        this.log();
    }

    public void profileResetAll() {
        this.log();
    }

    public void setVirtualRouteGuidance(boolean bl) {
        this.log();
    }

    public void deleteSatelliteCache() {
        this.log();
    }
}

