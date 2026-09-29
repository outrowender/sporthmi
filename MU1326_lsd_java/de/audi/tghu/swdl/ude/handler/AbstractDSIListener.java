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
    protected final Timer longRunningTaskTimer = new Timer("LongRunningTaskTimer", 0, true, this);
    protected final LogChannel lc;

    public AbstractDSIListener(LogChannel logChannel) {
        this.lc = logChannel;
    }

    protected abstract void longRunningTaskAborted() {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.lc.log(10000, "[%1] [DSIListenerHandler.fireTimer] Abort long running task!", (Object)this);
        this.longRunningTaskAborted();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, new StringBuffer().append(this).append(" [DSIListenerHandler.asyncException] msg:%1 code:%2 request:%3").toString(), (Object)string, (long)n, (long)n2);
    }

    @Override
    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
    }

    @Override
    public void menuVolEntRange(int n, int n2, int n3) {
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateBalance(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateBalanceRange(int n, int n2, int n3) {
    }

    @Override
    public void updateBass(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateBassRange(int n, int n2, int n3) {
    }

    public void updateDynSoundControl(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateFader(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateFaderRange(int n, int n2, int n3) {
    }

    @Override
    public void importFileResponse(int n, boolean bl) {
    }

    @Override
    public void updateInputGainOffset(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
    }

    @Override
    public void updateMutePinState(boolean bl, int n) {
    }

    public void updateSoundSet(int n, int n2, long l, int n3) {
    }

    public void updateSoundSetList(long l, int n) {
    }

    @Override
    public void updateSubwoofer(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateSubwooferRange(int n, int n2, int n3) {
    }

    @Override
    public void updateSurrLevelRange(int n, int n2, int n3) {
    }

    @Override
    public void updateSurroundLevel(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateTreble(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateTrebleRange(int n, int n2, int n3) {
    }

    public void updateVolLevelRange(int n, int n2, int n3) {
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
    }

    public void updateVolumeLeveling(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
    }

    @Override
    public void updateMiddle(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateMiddleRange(int n, int n2, int n3) {
    }

    @Override
    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
    }

    @Override
    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
    }

    @Override
    public void updateOnVolumeLimit(int n, int n2) {
    }

    @Override
    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
    }

    @Override
    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
    }

    @Override
    public void updateMuteTheftProtection(boolean bl, int n) {
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
    }

    @Override
    public void updateAfaMode(int n, int n2) {
    }

    @Override
    public void updateAfaSpeaking(boolean bl, int n) {
    }

    @Override
    public void updateEtcDemoModeState(boolean bl, int n) {
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l, int n) {
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n, int n2) {
    }

    @Override
    public void updateEtcMetricSystem(int n, int n2) {
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl, int n) {
    }

    @Override
    public void updateRgActive(boolean bl, int n) {
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void updateRgCurrentRoute(Route route, int n) {
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl, int n) {
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void rgException(int n) {
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition, int n) {
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
    }

    @Override
    public void updateRrdActive(boolean bl, int n) {
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
    }

    @Override
    public void updateRgiString(short[] sArray, int n) {
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRmPersistentRoute(Route route, int n) {
    }

    @Override
    public void updateRgTimeAfaToDestination(long l, int n) {
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
    }

    @Override
    public void updateTrOperatingMode(int n, int n2) {
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
    }

    @Override
    public void updateRgRouteCalculationState(int n, int n2) {
    }

    @Override
    public void updateNavstateOfOperation(int n, int n2) {
    }

    @Override
    public void updateNavMedia(String[] stringArray, int n) {
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    @Override
    public void updateLanguage(String string, int n) {
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
    }

    @Override
    public void updateTrRecordingState(int n, int n2) {
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
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
    public void liGetStateResult(LISpellerData lISpellerData) {
    }

    @Override
    public void liResult(long l) {
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    @Override
    public void etcGetCountryAbbreviationResult(String string, long l) {
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
    }

    @Override
    public void rmRouteDeleteResult(int n) {
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
    }

    @Override
    public void rmRouteRenameResult(int n) {
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
    }

    @Override
    public void importFileResult(int n, boolean bl) {
    }

    @Override
    public void languageSpellableCharactersResult(String string) {
    }

    @Override
    public void rgNotPossible(int n) {
    }

    @Override
    public void translateRouteResult(Route route) {
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
    }

    @Override
    public void liValueListOutputMethod(int n) {
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation, int n) {
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l, int n) {
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
    }

    @Override
    public void responseAudioTrigger(int n) {
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    @Override
    public void liThesaurusHistoryAddResult(int n, int n2) {
    }

    @Override
    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
    }

    @Override
    public void liThesaurusHistoryDeleteResult(int n, int n2) {
    }

    @Override
    public void liThesaurusHistoryDeleteAllResult(int n) {
    }

    @Override
    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
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
    public void setRemainingRangeOfVehicleResult(int n) {
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
    }

    @Override
    public void setTrailerStatusResult(int n) {
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray, int n) {
    }

    @Override
    public void updateRouteResumePossible(boolean bl, int n) {
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
    }

    @Override
    public void setVehicleFuelTypeResult(int n, int n2) {
    }

    @Override
    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
    }

    @Override
    public void liHistoryResult(int n) {
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    @Override
    public void updateAdbState(int n, int n2) {
    }

    @Override
    public void updateSortOrder(int n, int n2) {
    }

    @Override
    public void setLanguageResult(int n) {
    }

    @Override
    public void setSortOrderResult(int n) {
    }

    @Override
    public void setPublicProfileVisibilityResult(int n) {
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
    }

    @Override
    public void resetTopDestinationResult(int n) {
    }

    @Override
    public void createBackupFileResult(int n, String string) {
    }

    @Override
    public void importBackupFileResult(int n, String string) {
    }

    @Override
    public void updateSoftwareEnabling(int[] nArray, int n) {
    }

    @Override
    public void updateIllegalFSCs(int[] nArray, int n) {
    }

    @Override
    public void updateAreFSCsSigned(boolean bl, int n) {
    }

    @Override
    public void updateLimitedLifetime(boolean bl, int n) {
    }

    @Override
    public void updateConfigCheck(ConfigInfo configInfo, int n) {
    }

    @Override
    public void updateConfigPrepare(String string, int n) {
    }

    @Override
    public void updateConfigFinalize(ConfigInfo configInfo, int n) {
    }

    @Override
    public void updateFscList(SFscStatus[] sFscStatusArray, int n) {
    }

    @Override
    public void encryptFile(String string, int n) {
    }

    @Override
    public void checkSignature(boolean bl, String string) {
    }

    @Override
    public void getPublicKey(short[] sArray, boolean bl) {
    }

    @Override
    public void checkSingleFsc(int n, int n2) {
    }

    @Override
    public void decryptFile(String string, int n) {
    }

    @Override
    public void getFscDetail(SFscDetails sFscDetails) {
    }

    @Override
    public void importFSCs(int n, SFscImportStatus sFscImportStatus) {
    }

    @Override
    public void exportCCD(int n) {
    }

    @Override
    public void getHistory(SFscHistory sFscHistory) {
    }

    @Override
    public void importFSCsList(int n, SFscImportStatus[] sFscImportStatusArray) {
    }

    @Override
    public void getHistoryList(SFscHistory[] sFscHistoryArray) {
    }

    @Override
    public void listBookmarksResult(String string, Bookmark[] bookmarkArray, int n) {
    }

    @Override
    public void bookmarkListInvalid() {
    }

    @Override
    public void addBookmarkResult(Bookmark bookmark, int n) {
    }

    @Override
    public void editBookmarkResult(Bookmark bookmark, int n) {
    }

    @Override
    public void deleteBookmarkResult(Bookmark bookmark, int n) {
    }

    @Override
    public void createFolderResult(Bookmark bookmark, int n) {
    }

    @Override
    public void deleteFolderResult(String string, int n) {
    }

    @Override
    public void renameFolderResult(String string, int n) {
    }

    @Override
    public void exportBookmarksResult(PathInfo pathInfo, int n) {
    }

    @Override
    public void updateExportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
    }

    @Override
    public void importBookmarksResult(PathInfo pathInfo, ImportReport importReport, int n) {
    }

    @Override
    public void updateImportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
    }

    @Override
    public void getQuotaInformationResult(int n, int n2, int n3) {
    }

    @Override
    public void updateBrowserState(int n, int n2) {
    }

    @Override
    public void updatePageTitle(String string, int n) {
    }

    @Override
    public void updateActiveUrl(String string, int n) {
    }

    @Override
    public void updateZoomFactor(int n, int n2) {
    }

    @Override
    public void updateVirtualKeyboardStatus(boolean bl, int n) {
    }

    @Override
    public void updateEncryption(boolean bl, int n) {
    }

    @Override
    public void updateHasFocus(boolean bl, int n) {
    }

    @Override
    public void updateButtonState(int n, int n2, int n3) {
    }

    @Override
    public void updateProgress(int n, int n2) {
    }

    @Override
    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateScrollbarY(int n, int n2, int n3, int n4) {
    }

    @Override
    public void getPreferenceResult(int n, int n2, String string) {
    }

    @Override
    public void resumeBrowserResult(int n) {
    }

    @Override
    public void indicateEfiUrl(String string) {
    }

    @Override
    public void indicateUnknownMimeType(String string, String string2) {
    }

    @Override
    public void indicateDownloadUrl(String string) {
    }

    @Override
    public void indicatePopup(String string) {
    }

    @Override
    public void indicateDownloadProgress(String string, String string2, int n) {
    }

    @Override
    public void javascriptAlert(String string) {
    }

    @Override
    public void javascriptConfirm(String string) {
    }

    @Override
    public void javascriptPrompt(String string, String string2) {
    }

    @Override
    public void updateSelectionListContent(SelectionEntry[] selectionEntryArray, boolean bl, int n) {
    }

    @Override
    public void exportBrowserDataResult(int n) {
    }

    @Override
    public void importBrowserDataResult(int n) {
    }

    @Override
    public void getHistoryResult(TimePeriod timePeriod, HistoryEntry[] historyEntryArray, int n) {
    }

    @Override
    public void updateVolumeFocus(int n, int n2, int n3) {
    }

    @Override
    public void setNavInternalDataToFactorySettingsResult(int n) {
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    @Override
    public void updateNoiseCompensationRange(int n, int n2, int n3) {
    }

    @Override
    public void updatePresetPosition(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updatePresetPositionList(int n, int n2) {
    }

    @Override
    public void updatePresetEQList(int n, int n2) {
    }

    @Override
    public void updatePresetEQ(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
    }

    @Override
    public void updateThreeDMode(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateThreeDModeRange(int n, int n2, int n3) {
    }

    @Override
    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    @Override
    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
    }

    @Override
    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
    }

    @Override
    public void responseWidebandSpeech(int n, boolean bl) {
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    @Override
    public void trExportTrailsResult(int n) {
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
    }

    @Override
    public void rgResult(int n) {
    }

    @Override
    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
    }

    @Override
    public void etcSetDemoModeResult(int n) {
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
    }

    @Override
    public void updatePictureVisibility(boolean bl, int n) {
    }

    @Override
    public void setPictureVisibilityResult(int n) {
    }

    @Override
    public void setContextSpecificVisibilityResult(int n) {
    }

    @Override
    public void updateContextSpecificVisibility(boolean bl, int n) {
    }

    @Override
    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    @Override
    public void rgTriggerRCCIUpdateResult(int n) {
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    @Override
    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    @Override
    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    @Override
    public void updateMapIntegrationState(int n, int n2) {
    }

    @Override
    public void updateMapIntegrationProgress(int n, int n2) {
    }

    @Override
    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    @Override
    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    @Override
    public void rmImportToursFromGpxFileResult(int n) {
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }

    @Override
    public void updateBapManeuverState(int n, int n2) {
    }

    @Override
    public void deleteSatelliteCacheResult(int n) {
    }

    @Override
    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    @Override
    public void trClearRecordedTraceCacheResult() {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    @Override
    public void updateSoundShapeActive(boolean bl, int n) {
    }

    @Override
    public void updateSoundShape(short s, short s2, short s3, int n) {
    }

    @Override
    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    @Override
    public void updateICCAvailable(boolean bl, int n, int n2) {
    }
}

