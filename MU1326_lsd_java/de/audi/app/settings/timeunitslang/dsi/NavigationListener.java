/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang.dsi;

import de.audi.app.settings.SettingsEnv;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;
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
import org.dsi.ifc.navigation.DSINavigationListener;
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

public class NavigationListener
implements DSINavigationListener {
    private SettingsEnv env;
    private LogChannel lc;
    private volatile PosTimeInfo posTimeInfo;

    public NavigationListener(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.lc = settingsEnv.getFw().getLogChannel("App.Settings.DSI");
    }

    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
        this.lc.log(10000000, "NavigationListener.updateSoPosTimeInformation(%1, %2)", (Object)posTimeInfo, (long)n);
        if (n != 1 || posTimeInfo == null) {
            return;
        }
        this.posTimeInfo = posTimeInfo;
        this.setClockSummerTimeData();
        this.activateTimeZoneAutomatic();
    }

    public void setClockSummerTimeData() {
        this.lc.log(10000000, "NavigationListener.setClockSummerTimeData(%1)", (Object)this.posTimeInfo);
        if (this.posTimeInfo != null) {
            if (this.env.getChoiceModel(1100139).getValue() == 1) {
                ClockSummerTimeData clockSummerTimeData = new ClockSummerTimeData();
                clockSummerTimeData.validity = this.posTimeInfo.summerTimeValidity;
                clockSummerTimeData.dayFrom = (byte)this.posTimeInfo.summerTimeDayFrom;
                clockSummerTimeData.dayTo = (byte)this.posTimeInfo.summerTimeDayTo;
                clockSummerTimeData.hourFrom = (byte)this.posTimeInfo.summerTimeHourFrom;
                clockSummerTimeData.hourTo = (byte)this.posTimeInfo.summerTimeHourTo;
                if (this.posTimeInfo.summerTimeMonthTo > 24000) {
                    clockSummerTimeData.yearTo = NavigationListener.extractYear(this.posTimeInfo.summerTimeMonthTo);
                    clockSummerTimeData.monthTo = NavigationListener.extractMonth(this.posTimeInfo.summerTimeMonthTo);
                } else {
                    clockSummerTimeData.monthTo = (byte)this.posTimeInfo.summerTimeMonthTo;
                }
                if (this.posTimeInfo.summerTimeMonthFrom > 24000) {
                    clockSummerTimeData.yearFrom = NavigationListener.extractYear(this.posTimeInfo.summerTimeMonthFrom);
                    clockSummerTimeData.monthFrom = NavigationListener.extractMonth(this.posTimeInfo.summerTimeMonthFrom);
                } else {
                    clockSummerTimeData.monthFrom = (byte)this.posTimeInfo.summerTimeMonthFrom;
                }
                this.env.getDSIManager().getDSI().setClockSummerTimeData(clockSummerTimeData);
            } else {
                this.lc.log(10000000, "NavigationListener.setClockSummerTimeData ignore SETTINGS_TIME_MANUAL_MODE_CHOICE=0");
            }
        } else {
            this.lc.log(10000000, "NavigationListener.setClockSummerTimeData ignore posTimeInfo=null");
        }
    }

    public static byte extractYear(short s) {
        return (byte)((s - 1) / 12 - 2000);
    }

    public static byte extractMonth(short s) {
        return (byte)((s - 1) % 12 + 1);
    }

    public void activateTimeZoneAutomatic() {
        if (this.posTimeInfo != null) {
            if (this.env.getChoiceModel(1100180).getValue() == 1) {
                this.lc.log(10000000, "NavigationListener.updateSoPosTimeInformation DSI.setClockTimeZoneOffset(%1)", (long)this.posTimeInfo.timeZoneOffset);
                this.env.getDSIManager().getDSI().setClockTimeZoneOffset(NavigationListener.convertTimeZoneOffset(this.posTimeInfo.timeZoneOffset));
            } else {
                this.lc.log(10000000, "NavigationListener.updateSoPosTimeInformation ignore update TIMEZONE_AUTOMATIC_CHOICE=0");
            }
        } else {
            this.lc.log(10000000, "NavigationListener.activateTimeZoneAutomatic ignore posTimeInfo=null");
        }
    }

    public static float convertTimeZoneOffset(int n) {
        return (float)n / 60.0f;
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateAfaMode(int n, int n2) {
    }

    public void updateAfaSpeaking(boolean bl, int n) {
    }

    public void updateEtcDemoModeState(boolean bl, int n) {
    }

    public void updateEtcLanguageLoadProgress(long l, int n) {
    }

    public void updateEtcLanguageLoadStatus(int n, int n2) {
    }

    public void updateEtcMetricSystem(int n, int n2) {
    }

    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
    }

    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
    }

    public void updateLispIsSpellerActive(boolean bl, int n) {
    }

    public void updateRgActive(boolean bl, int n) {
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    public void updateRgCurrentRoute(Route route, int n) {
    }

    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
    }

    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
    }

    public void updateRgTurnToStreet(String string, boolean bl, int n) {
    }

    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
    }

    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    public void rgException(int n) {
    }

    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
    }

    public void updateSoPosPosition(PosPosition posPosition, int n) {
    }

    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
    }

    public void updateRrdActive(boolean bl, int n) {
    }

    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
    }

    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
    }

    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
    }

    public void updateRgiString(short[] sArray, int n) {
    }

    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    public void updateRmPersistentRoute(Route route, int n) {
    }

    public void updateRgTimeAfaToDestination(long l, int n) {
    }

    public void etcSensorDataReplayRoute(Route route) {
    }

    public void etcSensorDataReplayGuidance(boolean bl) {
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
    }

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
    }

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
    }

    public void updateTrOperatingMode(int n, int n2) {
    }

    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
    }

    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
    }

    public void updateRgRouteCalculationState(int n, int n2) {
    }

    public void updateNavstateOfOperation(int n, int n2) {
    }

    public void updateNavMedia(String[] stringArray, int n) {
    }

    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
    }

    public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    public void updateLanguage(String string, int n) {
    }

    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
    }

    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
    }

    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
    }

    public void updateTrRecordingState(int n, int n2) {
    }

    public void rgSetRouteGuidanceModeResult() {
    }

    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
    }

    public void dmRecentRoutesGetResult(long l, Route route) {
    }

    public void dmResult(long l, long l2) {
    }

    public void liGetStateResult(LISpellerData lISpellerData) {
    }

    public void liResult(long l) {
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
    }

    public void liValueList(LIValueList lIValueList, long l) {
    }

    public void poiValueList(LIValueList lIValueList, long l) {
    }

    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    public void rmMakeRoutePersistentResult(long l) {
    }

    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    public void etcGetCountryAbbreviationResult(String string, long l) {
    }

    public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    public void trRenameTraceResult(int n, int n2) {
    }

    public void trDeleteTraceResult(int n, int n2) {
    }

    public void trDeleteAllTracesResult(int n, int n2) {
    }

    public void rmRouteAddResult(int n, long l) {
    }

    public void rmRouteDeleteResult(int n) {
    }

    public void rmRouteDeleteAllResult(int n) {
    }

    public void rmRouteGetResult(int n, Route route) {
    }

    public void rmRouteRenameResult(int n) {
    }

    public void createExportFileResult(int n, boolean bl) {
    }

    public void importFileResult(int n, boolean bl) {
    }

    public void languageSpellableCharactersResult(String string) {
    }

    public void rgNotPossible(int n) {
    }

    public void translateRouteResult(Route route) {
    }

    public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    public void liValueListFileStatus(int n, int n2, String string) {
    }

    public void liValueListOutputMethod(int n) {
    }

    public void updateDmFlagDestination(NavLocation navLocation, int n) {
    }

    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
    }

    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
    }

    public void liLastCityAndStreetHistoryResult(long l) {
    }

    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
    }

    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
    }

    public void liHistoryResult(int n) {
    }

    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void updateRgTurnListCalculationHorizon(long l, int n) {
    }

    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
    }

    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    public void liStripLocationResult(NavLocation navLocation) {
    }

    public void responseAudioTrigger(int n) {
    }

    public void updateAudioRequest(int n, int n2) {
    }

    public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    public void liThesaurusHistoryAddResult(int n, int n2) {
    }

    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
    }

    public void liThesaurusHistoryDeleteResult(int n, int n2) {
    }

    public void liThesaurusHistoryDeleteAllResult(int n) {
    }

    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
    }

    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
    }

    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    public void ehResult(int n, int n2) {
    }

    public void setRemainingRangeOfVehicleResult(int n) {
    }

    public void setVehicleConsumptionInfoResult(int n) {
    }

    public void setUserDefinedPOIsResult(int n) {
    }

    public void setTrailerStatusResult(int n) {
    }

    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    public void updateStyleDBPaths(String[] stringArray, int n) {
    }

    public void updateRouteResumePossible(boolean bl, int n) {
    }

    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
    }

    public void updatePOIsInsideProximityRange(NavLocation[] navLocationArray, int n) {
    }

    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    public void deletePersonalPOIDataBasesResult(int n) {
    }

    public void setVehicleFuelTypeResult(int n, int n2) {
    }

    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
    }

    public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    public void setNavInternalDataToFactorySettingsResult(int n) {
    }

    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    public void trExportTrailsResult(int n) {
    }

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
    }

    public void rgStartRubberbandManipulationResult(int n) {
    }

    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
    }

    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
    }

    public void rgResult(int n) {
    }

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
    }

    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
    }

    public void lispGetMatchingNVCResult(String string) {
    }

    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    public void etcSetDemoModeResult(int n) {
    }

    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    public void rgTriggerRCCIUpdateResult(int n) {
    }

    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    public void triggerEventAudioMessageResult(int n) {
    }

    public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    public void updateMapIntegrationState(int n, int n2) {
    }

    public void updateMapIntegrationProgress(int n, int n2) {
    }

    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    public void updateBapManeuverState(int n, int n2) {
    }

    public void rmImportToursFromGpxFileResult(int n) {
    }

    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }

    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
    }

    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    public void trClearRecordedTraceCacheResult() {
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }

    public void deleteSatelliteCacheResult(int n) {
    }
}

