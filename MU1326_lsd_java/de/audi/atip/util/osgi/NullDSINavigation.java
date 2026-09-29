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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void afaRepeat(int n) {
        this.log();
    }

    @Override
    public void createExportFile(String string, int n) {
        this.log();
    }

    @Override
    public void dmFlagDestinationSet(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void dmFlagDestinationRemove() {
        this.log();
    }

    @Override
    public void dmFlagDestinationSetName(String string) {
        this.log();
    }

    @Override
    public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
        this.log();
    }

    @Override
    public void dmLastDestinationsDelete(long l) {
        this.log();
    }

    @Override
    public void dmLastDestinationsDeleteAll() {
        this.log();
    }

    @Override
    public void dmLastDestinationsGet(long l) {
        this.log();
    }

    @Override
    public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
        this.log();
    }

    @Override
    public void dmRecentRoutesAdd(Route route, String string) {
        this.log();
    }

    @Override
    public void dmRecentRoutesDelete(long l) {
        this.log();
    }

    @Override
    public void dmRecentRoutesDeleteAll() {
        this.log();
    }

    @Override
    public void dmRecentRoutesGet(long l) {
        this.log();
    }

    @Override
    public void dmRecentRoutesReplace(long l, Route route, String string) {
        this.log();
    }

    @Override
    public void enableRgStreetLists(boolean bl) {
        this.log();
    }

    @Override
    public void enableRgLaneGuidance(boolean bl) {
        this.log();
    }

    @Override
    public void enableRgPoiInfo(boolean bl) {
        this.log();
    }

    @Override
    public void etcGetCountryAbbreviation(String string) {
        this.log();
    }

    @Override
    public void etcSetDemoMode(boolean bl) {
        this.log();
    }

    @Override
    public void etcSetDemoModeSpeed(long l) {
        this.log();
    }

    @Override
    public void etcSetMetricSystem(int n) {
        this.log();
    }

    @Override
    public void etcSelectDatabase(int n) {
        this.log();
    }

    @Override
    public void etcSelectNavDataBase(int n) {
        this.log();
    }

    @Override
    public void importFile(String string, int n) {
        this.log();
    }

    @Override
    public void languageSpellableCharacters(String string) {
        this.log();
    }

    @Override
    public void liGetCurrentState() {
        this.log();
    }

    @Override
    public void liGetLastCityHistoryEntry(long l) {
        this.log();
    }

    @Override
    public void liGetLastStreetHistoryEntry(long l) {
        this.log();
    }

    @Override
    public void liGetLocationDescriptionTransform(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void liGetState() {
        this.log();
    }

    @Override
    public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        this.log();
    }

    @Override
    public void liLastCityHistoryDelete(long l) {
        this.log();
    }

    @Override
    public void liLastCityHistoryDeleteAll() {
        this.log();
    }

    @Override
    public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
        this.log();
    }

    @Override
    public void liLastStreetHistoryDelete(long l) {
        this.log();
    }

    @Override
    public void liLastStreetHistoryDeleteAll() {
        this.log();
    }

    @Override
    public void liRestoreState(LISpellerData lISpellerData) {
        this.log();
    }

    @Override
    public void liSetCountryForCityAndStreetHistory(String string) {
        this.log();
    }

    @Override
    public void liSetCurrentLD(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void lispAddCharacter(String string) {
        this.log();
    }

    @Override
    public void lispCancelSpeller() {
        this.log();
    }

    @Override
    public void lispDeleteAllCharacters() {
        this.log();
    }

    @Override
    public void lispRequestValueListByListIndex(int n, boolean bl) {
        this.log();
    }

    @Override
    public void lispSelectListItem(int n) {
        this.log();
    }

    @Override
    public void lispSelectByCategoryUid(int n) {
        this.log();
    }

    @Override
    public void lispSetInput(String string, boolean bl) {
        this.log();
    }

    @Override
    public void lispUndoCharacter() {
        this.log();
    }

    @Override
    public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.log();
    }

    @Override
    public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
        this.log();
    }

    @Override
    public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
        this.log();
    }

    @Override
    public void liValueListFilename(String string) {
        this.log();
    }

    @Override
    public void liValueListOutputMethod(int n) {
        this.log();
    }

    @Override
    public void locationToStream(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void poiSelectSelectionCriteria(long l) {
        this.log();
    }

    @Override
    public void poiSetContext(NavLocation navLocation) {
        this.log();
    }

    public void poiSetSortOrder(boolean bl) {
        this.log();
    }

    @Override
    public void poiSetSortOrder2(int n) {
        this.log();
    }

    @Override
    public void poiStartSpellerAlongRoute(int n, long l, long l2) {
        this.log();
    }

    @Override
    public void requestSoPosPositionDescriptionVehicle() {
        this.log();
    }

    @Override
    public void rgCalculateRoute(Route route, int n) {
        this.log();
    }

    public void rgSetDefaultRouteOptions(RouteOptions routeOptions) {
        this.log();
    }

    @Override
    public void rgSetPosition(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void rgSetRouteGuidanceMode(int n) {
        this.log();
    }

    @Override
    public void rgSetRouteOptions(RouteOptions routeOptions) {
        this.log();
    }

    @Override
    public void rgStartGuidanceCalculatedRoute(int n) {
        this.log();
    }

    @Override
    public void rgStopGuidance() {
        this.log();
    }

    @Override
    public void rmMakeRoutePersistent(Route route) {
        this.log();
    }

    @Override
    public void rmRouteAdd(int n, Route route, String string) {
        this.log();
    }

    @Override
    public void rmRouteDelete(int n, long l) {
        this.log();
    }

    @Override
    public void rmRouteDeleteAll(int n) {
        this.log();
    }

    @Override
    public void rmRouteGet(int n, long l) {
        this.log();
    }

    @Override
    public void rmRouteRename(int n, long l, String string) {
        this.log();
    }

    @Override
    public void rrdStartCalculationByListIndex(int n, long l) {
        this.log();
    }

    @Override
    public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
        this.log();
    }

    @Override
    public void rrdStopCalculation() {
        this.log();
    }

    @Override
    public void setLanguage(String string) {
        this.log();
    }

    @Override
    public void streamToLocation(byte[] byArray) {
        this.log();
    }

    @Override
    public void translateRoute(Route route) {
        this.log();
    }

    @Override
    public void trCreateWaypoint() {
        this.log();
    }

    @Override
    public void trDeleteAllTraces() {
        this.log();
    }

    @Override
    public void trDeleteTrace(NavSegmentID navSegmentID) {
        this.log();
    }

    @Override
    public void trRenameTrace(NavSegmentID navSegmentID, String string) {
        this.log();
    }

    @Override
    public void trStartTraceRecording(int n) {
        this.log();
    }

    @Override
    public void trStopTraceRecording() {
        this.log();
    }

    @Override
    public void trStoreTrace(String string) {
        this.log();
    }

    @Override
    public void liStripLocation(NavLocation navLocation, int n) {
        this.log();
    }

    @Override
    public void requestAudioTrigger(int n) {
        this.log();
    }

    @Override
    public void liThesaurusHistoryAdd(String string) {
        this.log();
    }

    @Override
    public void liThesaurusHistoryGetEntry(int n) {
        this.log();
    }

    @Override
    public void liThesaurusHistoryDelete(int n) {
        this.log();
    }

    @Override
    public void liThesaurusHistoryDeleteAll() {
        this.log();
    }

    @Override
    public void ehGetAllCategories(int n) {
        this.log();
    }

    @Override
    public void ehGetAllBrandsOfCategory(int n, int n2) {
        this.log();
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    @Override
    public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    @Override
    public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
        this.log();
    }

    @Override
    public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    @Override
    public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
        this.log();
    }

    @Override
    public void setRemainingRangeOfVehicle(int n) {
        this.log();
    }

    @Override
    public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
        this.log();
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        this.log();
    }

    @Override
    public void requestCountryInfo(String string) {
        this.log();
    }

    @Override
    public void jumpToNextManeuver() {
        this.log();
    }

    @Override
    public void liGetViaPointList(int n, int n2, int n3, int n4) {
        this.log();
    }

    @Override
    public void liSelectViaPoint(int n) {
        this.log();
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        this.log();
    }

    public void getSpellableCharacters(String string, String string2, int n) {
        this.log();
    }

    @Override
    public void liGetSpellableCharacters(NavLocation navLocation, int n) {
        this.log();
    }

    @Override
    public void liStopSpeller() {
        this.log();
    }

    @Override
    public void liValueListMaximumLength(int n) {
        this.log();
    }

    @Override
    public void setPathsToPersonalPOIDataBases(String[] stringArray) {
        this.log();
    }

    @Override
    public void deletePersonalPOIDataBases(String[] stringArray) {
        this.log();
    }

    @Override
    public void rgStopRouteCalculation() {
        this.log();
    }

    @Override
    public void setVehicleFuelType(int n) {
        this.log();
    }

    @Override
    public void createNavLocationOfPOIUID(long l) {
        this.log();
    }

    @Override
    public void lispSelectListItemByIdent(String string) {
        this.log();
    }

    @Override
    public void rmRouteReplace(int n, long l, Route route) {
        this.log();
    }

    @Override
    public void liGetLastStateHistoryEntry(long l) {
        this.log();
    }

    @Override
    public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        this.log();
    }

    @Override
    public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        this.log();
    }

    @Override
    public void liLastStateHistoryDelete(long l) {
        this.log();
    }

    @Override
    public void liLastStateHistoryDeleteAll() {
        this.log();
    }

    @Override
    public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        this.log();
    }

    @Override
    public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
        this.log();
    }

    @Override
    public void liSetHistory(String string, String string2) {
        this.log();
    }

    @Override
    public void liDeleteHistory() {
        this.log();
    }

    @Override
    public void lispSelectItemFromLocation(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void rgSwitchToNextPossibleRoad() {
        this.log();
    }

    @Override
    public void lispSelectByMultipleCategoryUids(int[] nArray) {
        this.log();
    }

    @Override
    public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
        this.log();
    }

    @Override
    public void liValueListWindowSize(int n) {
        this.log();
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        this.log();
    }

    @Override
    public void setNavInternalDataToFactorySettings() {
        this.log();
    }

    @Override
    public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
        this.log();
    }

    @Override
    public void liSetStreetForCityHistory(String string) {
        this.log();
    }

    @Override
    public void liGetViaPointCountryList() {
        this.log();
    }

    @Override
    public void liSetViaPointCountry(String string) {
        this.log();
    }

    @Override
    public void trImportTrails(String string) {
        this.log();
    }

    @Override
    public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
        this.log();
    }

    @Override
    public void rgSkipNextWayPoints(int n) {
        this.log();
    }

    @Override
    public void rgReverseTrailDirection() {
        this.log();
    }

    @Override
    public void rgPrepareRubberbandManipulation(boolean bl) {
        this.log();
    }

    @Override
    public void rgStartRubberbandManipulation(int n) {
        this.log();
    }

    @Override
    public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        this.log();
    }

    @Override
    public void rgGetRouteBoundingRectangle(boolean bl, int n) {
        this.log();
    }

    @Override
    public void rgGetLocationOnRoute(long l) {
        this.log();
    }

    @Override
    public void rgStopRubberbandManipulation() {
        this.log();
    }

    @Override
    public void rgEnableEnhancedSignPostInfo(boolean bl) {
        this.log();
    }

    @Override
    public void rgDeleteCalculatedRubberbandPoint() {
        this.log();
    }

    @Override
    public void rgGetRubberBandPointPosition() {
        this.log();
    }

    @Override
    public void lispGetMatchingNVC(String string) {
        this.log();
    }

    @Override
    public void liSetNVCRange(int n) {
        this.log();
    }

    @Override
    public void lispGetLocationFromLiValueListElement(int n) {
        this.log();
    }

    @Override
    public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void rgSetTurnListMode(int n) {
        this.log();
    }

    @Override
    public void liHistoryAddLocation(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void liLastCityHistorySetStreet(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void liLastStreetHistorySetCity(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void enableRgMotorwayInfo(boolean bl) {
        this.log();
    }

    @Override
    public void rgTriggerRCCIUpdate() {
        this.log();
    }

    @Override
    public void poiGetXt9LDBs(NavLocation navLocation, int n) {
        this.log();
    }

    @Override
    public void poiSetListStyle(int n) {
        this.log();
    }

    @Override
    public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
        this.log();
    }

    @Override
    public void poiGetCategoryTypesFromUId(int n) {
        this.log();
    }

    @Override
    public void rgDeletePersistedRouteData() {
        this.log();
    }

    @Override
    public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
        this.log();
    }

    @Override
    public void liDisambiguateLocation(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        this.log();
    }

    @Override
    public void lispAddStroke(String string) {
        this.log();
    }

    @Override
    public void lispRequestNVCList(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
        this.log();
    }

    @Override
    public void etcTriggerNavigationRestart(int n) {
        this.log();
    }

    @Override
    public void rmImportToursFromGpxFile(int n, String string) {
        this.log();
    }

    @Override
    public void rmAbortImportToursFromGpxFile() {
        this.log();
    }

    @Override
    public void importRouteFromGpxFile(String string) {
        this.log();
    }

    @Override
    public void poiRequestExtendedInfo(NavLocation navLocation) {
        this.log();
    }

    @Override
    public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
        this.log();
    }

    @Override
    public void trClearRecordedTraceCache() {
        this.log();
    }

    @Override
    public void profileChange(int n) {
        this.log();
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.log();
    }

    @Override
    public void profileReset(int n) {
        this.log();
    }

    @Override
    public void profileResetAll() {
        this.log();
    }

    @Override
    public void setVirtualRouteGuidance(boolean bl) {
        this.log();
    }

    @Override
    public void deleteSatelliteCache() {
        this.log();
    }
}

