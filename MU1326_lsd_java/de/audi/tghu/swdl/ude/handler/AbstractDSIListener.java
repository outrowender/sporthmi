/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBookmarkListener;
import org.dsi.ifc.browser.DSIBrowserListener;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;
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
import org.dsi.ifc.organizer.DSIAdbSetupListener;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.DSISWaPListener;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public abstract class AbstractDSIListener
implements DSISWaPListener,
DSIAdbSetupListener,
DSINavigationListener,
DSISoundListener,
TimerListener,
DSIBrowserListener,
DSIBrowserBookmarkListener {
    protected final Timer longRunningTaskTimer = new Timer("LongRunningTaskTimer", 60000L, true, this);
    protected final LogChannel lc;

    public AbstractDSIListener(LogChannel logChannel) {
        this.lc = logChannel;
    }

    protected abstract void longRunningTaskAborted();

    public void fireTimer(Timer timer) {
        this.lc.log(10000, "[%1] [DSIListenerHandler.fireTimer] Abort long running task!", (Object)this);
        this.longRunningTaskAborted();
    }

    public void cancelTimer(Timer timer) {
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, this + " [DSIListenerHandler.asyncException] msg:%1 code:%2 request:%3", (Object)string, (long)n, (long)n2);
    }

    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
    }

    public void menuVolEntRange(int n, int n2, int n3) {
    }

    public void menuVolumeRange(int n, int n2, int n3, int n4) {
    }

    public void updateBalance(int n, int n2, short s, int n3) {
    }

    public void updateBalanceRange(int n, int n2, int n3) {
    }

    public void updateBass(int n, int n2, short s, int n3) {
    }

    public void updateBassRange(int n, int n2, int n3) {
    }

    public void updateDynSoundControl(int n, int n2, short s, int n3) {
    }

    public void updateFader(int n, int n2, short s, int n3) {
    }

    public void updateFaderRange(int n, int n2, int n3) {
    }

    public void importFileResponse(int n, boolean bl) {
    }

    public void updateInputGainOffset(int n, int n2, short s, int n3) {
    }

    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
    }

    public void updateMutePinState(boolean bl, int n) {
    }

    public void updateSoundSet(int n, int n2, long l, int n3) {
    }

    public void updateSoundSetList(long l, int n) {
    }

    public void updateSubwoofer(int n, int n2, short s, int n3) {
    }

    public void updateSubwooferRange(int n, int n2, int n3) {
    }

    public void updateSurrLevelRange(int n, int n2, int n3) {
    }

    public void updateSurroundLevel(int n, int n2, short s, int n3) {
    }

    public void updateTreble(int n, int n2, short s, int n3) {
    }

    public void updateTrebleRange(int n, int n2, int n3) {
    }

    public void updateVolLevelRange(int n, int n2, int n3) {
    }

    public void updateVolume(int n, int n2, short s, int n3) {
    }

    public void updateVolumeLeveling(int n, int n2, short s, int n3) {
    }

    public void updateVolumeRange(int n, int n2, int n3) {
    }

    public void updateMiddle(int n, int n2, short s, int n3) {
    }

    public void updateMiddleRange(int n, int n2, int n3) {
    }

    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
    }

    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
    }

    public void updateOnVolumeLimit(int n, int n2) {
    }

    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
    }

    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
    }

    public void updateMuteTheftProtection(boolean bl, int n) {
    }

    public void updateMicGainLevel(int n, int n2) {
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

    public void rmRouteReplaceResult(int n, long l, int n2) {
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

    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
    }

    public void liHistoryResult(int n) {
    }

    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    public void updateAdbState(int n, int n2) {
    }

    public void updateSortOrder(int n, int n2) {
    }

    public void setLanguageResult(int n) {
    }

    public void setSortOrderResult(int n) {
    }

    public void setPublicProfileVisibilityResult(int n) {
    }

    public void resetToFactorySettingsResult(int n) {
    }

    public void resetTopDestinationResult(int n) {
    }

    public void createBackupFileResult(int n, String string) {
    }

    public void importBackupFileResult(int n, String string) {
    }

    public void updateSoftwareEnabling(int[] nArray, int n) {
    }

    public void updateIllegalFSCs(int[] nArray, int n) {
    }

    public void updateAreFSCsSigned(boolean bl, int n) {
    }

    public void updateLimitedLifetime(boolean bl, int n) {
    }

    public void updateConfigCheck(ConfigInfo configInfo, int n) {
    }

    public void updateConfigPrepare(String string, int n) {
    }

    public void updateConfigFinalize(ConfigInfo configInfo, int n) {
    }

    public void updateFscList(SFscStatus[] sFscStatusArray, int n) {
    }

    public void encryptFile(String string, int n) {
    }

    public void checkSignature(boolean bl, String string) {
    }

    public void getPublicKey(short[] sArray, boolean bl) {
    }

    public void checkSingleFsc(int n, int n2) {
    }

    public void decryptFile(String string, int n) {
    }

    public void getFscDetail(SFscDetails sFscDetails) {
    }

    public void importFSCs(int n, SFscImportStatus sFscImportStatus) {
    }

    public void exportCCD(int n) {
    }

    public void getHistory(SFscHistory sFscHistory) {
    }

    public void importFSCsList(int n, SFscImportStatus[] sFscImportStatusArray) {
    }

    public void getHistoryList(SFscHistory[] sFscHistoryArray) {
    }

    public void listBookmarksResult(String string, Bookmark[] bookmarkArray, int n) {
    }

    public void bookmarkListInvalid() {
    }

    public void addBookmarkResult(Bookmark bookmark, int n) {
    }

    public void editBookmarkResult(Bookmark bookmark, int n) {
    }

    public void deleteBookmarkResult(Bookmark bookmark, int n) {
    }

    public void createFolderResult(Bookmark bookmark, int n) {
    }

    public void deleteFolderResult(String string, int n) {
    }

    public void renameFolderResult(String string, int n) {
    }

    public void exportBookmarksResult(PathInfo pathInfo, int n) {
    }

    public void updateExportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
    }

    public void importBookmarksResult(PathInfo pathInfo, ImportReport importReport, int n) {
    }

    public void updateImportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
    }

    public void getQuotaInformationResult(int n, int n2, int n3) {
    }

    public void updateBrowserState(int n, int n2) {
    }

    public void updatePageTitle(String string, int n) {
    }

    public void updateActiveUrl(String string, int n) {
    }

    public void updateZoomFactor(int n, int n2) {
    }

    public void updateVirtualKeyboardStatus(boolean bl, int n) {
    }

    public void updateEncryption(boolean bl, int n) {
    }

    public void updateHasFocus(boolean bl, int n) {
    }

    public void updateButtonState(int n, int n2, int n3) {
    }

    public void updateProgress(int n, int n2) {
    }

    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    public void updateScrollbarY(int n, int n2, int n3, int n4) {
    }

    public void getPreferenceResult(int n, int n2, String string) {
    }

    public void resumeBrowserResult(int n) {
    }

    public void indicateEfiUrl(String string) {
    }

    public void indicateUnknownMimeType(String string, String string2) {
    }

    public void indicateDownloadUrl(String string) {
    }

    public void indicatePopup(String string) {
    }

    public void indicateDownloadProgress(String string, String string2, int n) {
    }

    public void javascriptAlert(String string) {
    }

    public void javascriptConfirm(String string) {
    }

    public void javascriptPrompt(String string, String string2) {
    }

    public void updateSelectionListContent(SelectionEntry[] selectionEntryArray, boolean bl, int n) {
    }

    public void exportBrowserDataResult(int n) {
    }

    public void importBrowserDataResult(int n) {
    }

    public void getHistoryResult(TimePeriod timePeriod, HistoryEntry[] historyEntryArray, int n) {
    }

    public void updateVolumeFocus(int n, int n2, int n3) {
    }

    public void setNavInternalDataToFactorySettingsResult(int n) {
    }

    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    public void updateNoiseCompensationRange(int n, int n2, int n3) {
    }

    public void updatePresetPosition(int n, int n2, int n3, int n4) {
    }

    public void updatePresetPositionList(int n, int n2) {
    }

    public void updatePresetEQList(int n, int n2) {
    }

    public void updatePresetEQ(int n, int n2, int n3, int n4) {
    }

    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
    }

    public void updateThreeDMode(int n, int n2, int n3, int n4) {
    }

    public void updateThreeDModeRange(int n, int n2, int n3) {
    }

    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
    }

    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
    }

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
    }

    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
    }

    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
    }

    public void responseWidebandSpeech(int n, boolean bl) {
    }

    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    public void trExportTrailsResult(int n) {
    }

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
    }

    public void rgStartRubberbandManipulationResult(int n) {
    }

    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
    }

    public void rgResult(int n) {
    }

    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
    }

    public void etcSetDemoModeResult(int n) {
    }

    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    public void lispGetMatchingNVCResult(String string) {
    }

    public void updatePictureVisibility(boolean bl, int n) {
    }

    public void setPictureVisibilityResult(int n) {
    }

    public void setContextSpecificVisibilityResult(int n) {
    }

    public void updateContextSpecificVisibility(boolean bl, int n) {
    }

    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    public void rgTriggerRCCIUpdateResult(int n) {
    }

    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
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

    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    public void rmImportToursFromGpxFileResult(int n) {
    }

    public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }

    public void updateBapManeuverState(int n, int n2) {
    }

    public void deleteSatelliteCacheResult(int n) {
    }

    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
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

    public void updateSoundShapeActive(boolean bl, int n) {
    }

    public void updateSoundShape(short s, short s2, short s3, int n) {
    }

    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    public void updateICCAvailable(boolean bl, int n, int n2) {
    }
}

