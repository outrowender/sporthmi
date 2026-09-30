/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.dsi.AbstractDSINavigationHandler;
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
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public class DefaultDSINavigationRemoteHandler
extends AbstractDSINavigationHandler {
    public DefaultDSINavigationRemoteHandler(NavigationEnv navigationEnv, Navigation navigation) {
        super(navigationEnv, navigation, 1);
    }

    protected DSIResponseContainer getContainer() {
        return this.env.getRemoteContainer();
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
    }

    public void dmRecentRoutesGetResult(long l, Route route) {
    }

    public void dmResult(long l, long l2) {
    }

    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    public void liGetStateResult(LISpellerData lISpellerData) {
    }

    public void liResult(long l) {
    }

    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    public void liValueList(LIValueList lIValueList, long l) {
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    public void poiValueList(LIValueList lIValueList, long l) {
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
    }

    public void rgNotPossible(int n) {
    }

    public void rgSetRouteGuidanceModeResult() {
    }

    public void rmMakeRoutePersistentResult(long l) {
    }

    public void rmRouteAddResult(int n, long l) {
    }

    public void rmRouteDeleteAllResult(int n) {
    }

    public void rmRouteDeleteResult(int n) {
    }

    public void rmRouteGetResult(int n, Route route) {
    }

    public void rmRouteRenameResult(int n) {
    }

    public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    public void trDeleteAllTracesResult(int n, int n2) {
    }

    public void trDeleteTraceResult(int n, int n2) {
    }

    public void trExportTrailsResult(int n) {
    }

    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    public void trRenameTraceResult(int n, int n2) {
    }

    public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    public void translateRouteResult(Route route) {
    }

    public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    public void updateAfaMode(int n) {
    }

    public void updateAfaSpeaking(boolean bl) {
    }

    public void updateAvailableLanguages(String[] stringArray) {
    }

    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray) {
    }

    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray) {
    }

    public void updateEtcDemoModeState(boolean bl) {
    }

    public void updateEtcLanguageLoadProgress(long l) {
    }

    public void updateEtcLanguageLoadStatus(int n) {
    }

    public void updateEtcMetricSystem(int n) {
    }

    public void etcSensorDataReplayGuidance(boolean bl) {
    }

    public void etcSensorDataReplayRoute(Route route) {
    }

    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo) {
    }

    public void updateLanguage(String string) {
    }

    public void updateLispIsSpellerActive(boolean bl) {
    }

    public void updateNavMedia(String[] stringArray) {
    }

    public void updateNavstateOfOperation(int n) {
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    public void updateRgCurrentRoute(Route route) {
    }

    public void updateRgCurrentRouteOptions(RouteOptions routeOptions) {
    }

    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
    }

    public void updateRgRouteCalculationState(int n) {
    }

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
    }

    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray) {
    }

    public void updateRgTimeAfaToDestination(long l) {
    }

    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions) {
    }

    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
    }

    public void updateRrdActive(boolean bl) {
    }

    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
    }

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
    }

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
    }

    public void updateTrRecordingState(int n) {
    }

    public void updateTrOperatingMode(int n) {
    }

    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
    }

    public void updateClockAdjusted(boolean bl) {
    }

    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
    }

    public void responseAudioTrigger(int n) {
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
    }

    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    public void liLastCityAndStreetHistoryResult(long l) {
    }

    public void liStripLocationResult(NavLocation navLocation) {
    }

    public void liValueListFileStatus(int n, int n2, String string) {
    }

    public void liValueListOutputMethod(int n) {
    }

    public void rgException(int n) {
    }

    public void rgStartGuidanceRouteResult(int n) {
    }

    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
    }

    public void updateCityVignettes(int[] nArray) {
    }

    public void updateDmFlagDestination(NavLocation navLocation) {
    }

    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
    }

    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray) {
    }

    public void updateLiCountryForCityAndStreetHistory(String string) {
    }

    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
    }

    public void updateRgPoiInfoCalculationHorizon(long l) {
    }

    public void updateRgRouteProperties(RouteProperties routeProperties) {
    }

    public void updateRgTurnListCalculationHorizon(long l) {
    }

    public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    public void liHistoryResult(int n) {
    }

    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    public void ehResult(int n, int n2) {
    }

    public void updateAudioRequest(int n) {
    }

    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray) {
    }

    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase) {
    }

    public void blockAreaResult(long l, int n) {
    }

    public void blockRoadSegmentsResult(long l, int n) {
    }

    public void blockRouteBasedOnLengthResult(long l, int n) {
    }

    public void blockRouteSegmentsResult(long l, int n) {
    }

    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
    }

    public void deleteBlockResult(long[] lArray, int n) {
    }

    public void persistBlockResult(long[] lArray, int n) {
    }

    public void setBlockDescriptionResult(long[] lArray, int n) {
    }

    public void updateListOfBlocks(BlockElement[] blockElementArray) {
    }

    public void updateNaviCoreAvailableToSetBlocks(int n) {
    }

    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
    }

    public void updateElementsTotal(long l, long l2, int n) {
    }

    public void windowChanged(int n) {
    }

    public void updateRgTurnToStreet(String string, boolean bl) {
    }

    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    public void updateCountryInfo(CountryInfo[] countryInfoArray) {
    }

    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray) {
    }

    public void updateRgiString(short[] sArray) {
    }

    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
    }

    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    public void setTrailerStatusResult(int n) {
    }

    public void setUserDefinedPOIsResult(int n) {
    }

    public void setVehicleConsumptionInfoResult(int n) {
    }

    public void updateStyleDBPaths(String[] stringArray) {
    }

    public void updateRouteResumePossible(boolean bl) {
    }

    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    public void deletePersonalPOIDataBasesResult(int n) {
    }

    public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetLocationOnRouteResult( ) - unexpected call!!!");
    }

    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetRouteBoundingRectangleResult( ) - unexpected call!!!");
    }

    public void rgStartRubberbandManipulationResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgStartRubberbandManipulationResult( ) - unexpected call!!!");
    }

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetRubberBandPointPositionResult( ) - unexpected call!!!");
    }

    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetRubberBandPointPositionResult( ) - unexpected call!!!");
    }

    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#lispGetLocationFromLiValueListResult( ) - unexpected call!!!");
    }

    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#poiGetCategoryTypesFromUIdResult( ) - unexpected call!!!");
    }

    public void rgResult(int n) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#rgResult( ) - unexpected call!!!");
    }

    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#rgSwitchToNextPossibleRoadResult( ) - unexpected call!!!");
    }

    public void lispGetMatchingNVCResult(String string) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#lispGetMatchingNVCResult( ) - unexpected call!!!");
    }

    public void updateMapIntegrationState(int n) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#updateMapIntegrationState( ) - unexpected call!!!");
    }

    public void lispRequestNVCListResult(int n, String string, int n2) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#lispRequestNVCListResult( ) - unexpected call!!!");
    }

    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#liDisambiguateLocationResult( ) - unexpected call!!!");
    }

    public void triggerEventAudioMessageResult(int n) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#triggerEventAudioMessageResult( ) - unexpected call!!!");
    }

    public void updateBapManeuverState(int n) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#updateBapManeuverState( ) - unexpected call!!!");
    }

    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#updateBapManeuverInformation( ) - unexpected call!!!");
    }

    public void poiGetXt9LDBsResult(String[] stringArray) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#poiGetXt9LDBsResult( ) - unexpected call!!!");
    }

    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#poiRequestExtendedInfoResult( ) - unexpected call!!!");
    }

    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        this.logChannel.log(100000, "DefaultDSINavigationRemoteHandler#importRouteFromGpxFileResult( ) - unexpected call!!!");
    }
}

