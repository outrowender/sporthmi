/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.command.AbstractNavCommand;
import de.audi.tghu.navi.app.command.NavCommandList;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
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
import org.dsi.ifc.navigation.DSIBlocking;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.dsi.ifc.navigation.DSINavigation;
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

public abstract class NavCommand
extends AbstractNavCommand
implements IDSINavigationHandler {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public NavCommand() {
        this((String)null);
    }

    public NavCommand(String string) {
        super(string);
    }

    public void setCommandList(ICommandList iCommandList) {
        super.setCommandList(iCommandList);
        if (!(iCommandList instanceof NavCommandList)) {
            throw new ClassCastException("Expected NavCommandList!");
        }
        NavCommandList navCommandList = (NavCommandList)iCommandList;
        this.init(navCommandList.getEnv(), navCommandList.getDSINavigationManager(), navCommandList.getNavigation());
    }

    public long getTimeout() {
        return 60000L;
    }

    protected int getDSIType() {
        int n;
        if (this.getCommandList() != null) {
            n = DSINavigationManager.getDSIType(this.getCommandList());
        } else {
            this.logger.log(100000, "NavCommand#getDSIType() - command list currently not set!");
            n = 0;
        }
        return n;
    }

    public DSINavigation getDSINavigation() {
        return this.getDSINavigation(this.getDSIType());
    }

    public DSIBlocking getDSIBlocking() {
        return this.getDSIBlocking(this.getDSIType());
    }

    public DSICombinedRouteList getDSICombinedRouteList() {
        return this.getDSICombinedRouteList(this.getDSIType());
    }

    protected DSINavigationDispatcher getDispatcher() {
        return ((NavCommandList)this.getCommandList()).getDSINavigationManager().getDispatcher(this.getDSIType());
    }

    public abstract void execute();

    public void asyncException(int n, String string, int n2) {
        this.getDispatcher().getDefaultHandler().asyncException(n, string, n2);
        String string2 = new Buffer().append("asyncException(").append(n).append(", ").append(string).append(", ").append(n2).append(")").toString();
        this.getCommandList().commandAborted(string2);
    }

    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver) {
        this.getDispatcher().getDefaultHandler().updateDistanceToNextManeuver(distanceToNextManeuver);
    }

    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().dmLastDestinationsGetResult(l, navLocation);
    }

    public void dmRecentRoutesGetResult(long l, Route route) {
        this.getDispatcher().getDefaultHandler().dmRecentRoutesGetResult(l, route);
    }

    public void dmResult(long l, long l2) {
        this.getDispatcher().getDefaultHandler().dmResult(l, l2);
    }

    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().liGetLocationDescriptionTransformResult(navLocation);
    }

    public void liGetStateResult(LISpellerData lISpellerData) {
        this.getDispatcher().getDefaultHandler().liGetStateResult(lISpellerData);
    }

    public void liResult(long l) {
        this.getDispatcher().getDefaultHandler().liResult(l);
    }

    public void liValueList(LIValueList lIValueList, long l) {
        this.getDispatcher().getDefaultHandler().liValueList(lIValueList, l);
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.getDispatcher().getDefaultHandler().lispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4, l);
    }

    public void poiValueList(LIValueList lIValueList, long l) {
        this.getDispatcher().getDefaultHandler().poiValueList(lIValueList, l);
    }

    public void updateRgRouteCalculationState(int n) {
        this.getDispatcher().getDefaultHandler().updateRgRouteCalculationState(n);
    }

    public void rmMakeRoutePersistentResult(long l) {
        this.getDispatcher().getDefaultHandler().rmMakeRoutePersistentResult(l);
    }

    public void rmRouteAddResult(int n, long l) {
        this.getDispatcher().getDefaultHandler().rmRouteAddResult(n, l);
    }

    public void rmRouteDeleteAllResult(int n) {
        this.getDispatcher().getDefaultHandler().rmRouteDeleteAllResult(n);
    }

    public void rmRouteDeleteResult(int n) {
        this.getDispatcher().getDefaultHandler().rmRouteDeleteResult(n);
    }

    public void rmRouteGetResult(int n, Route route) {
        this.getDispatcher().getDefaultHandler().rmRouteGetResult(n, route);
    }

    public void rmRouteRenameResult(int n) {
        this.getDispatcher().getDefaultHandler().rmRouteRenameResult(n);
    }

    public void rmRouteReplaceResult(int n, long l, int n2) {
        this.getDispatcher().getDefaultHandler().rmRouteReplaceResult(n, l, n2);
    }

    public void translateRouteResult(Route route) {
        this.getDispatcher().getDefaultHandler().translateRouteResult(route);
    }

    public void trDeleteAllTracesResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().trDeleteAllTracesResult(n, n2);
    }

    public void trExportTrailsResult(int n) {
        this.getDispatcher().getDefaultHandler().trExportTrailsResult(n);
    }

    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        this.getDispatcher().getDefaultHandler().trImportTrailsResult(navSegmentIDArray, n);
    }

    public void trDeleteTraceResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().trDeleteTraceResult(n, n2);
    }

    public void trRenameTraceResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().trRenameTraceResult(n, n2);
    }

    public void trStartTraceRecordingResult(int n, long l, int n2) {
        this.getDispatcher().getDefaultHandler().trStartTraceRecordingResult(n, l, n2);
    }

    public void trStopTraceRecordingResult(int n, long l, int n2) {
        this.getDispatcher().getDefaultHandler().trStopTraceRecordingResult(n, l, n2);
    }

    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        this.getDispatcher().getDefaultHandler().trStoreTraceResult(n, navSegmentID, n2);
    }

    public void rgSetRouteGuidanceModeResult() {
        this.getDispatcher().getDefaultHandler().rgSetRouteGuidanceModeResult();
    }

    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.getDispatcher().getDefaultHandler().locationToStreamResult(bl, byArray);
    }

    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().streamToLocationResult(bl, navLocation);
    }

    public void updateAfaMode(int n) {
        this.getDispatcher().getDefaultHandler().updateAfaMode(n);
    }

    public void updateAfaSpeaking(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateAfaSpeaking(bl);
    }

    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray) {
        this.getDispatcher().getDefaultHandler().updateDmLastDestinationsList(lDListElementArray);
    }

    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray) {
        this.getDispatcher().getDefaultHandler().updateDmRecentRoutesList(rRListElementArray);
    }

    public void updateEtcDemoModeState(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateEtcDemoModeState(bl);
    }

    public void updateLanguage(String string) {
        this.getDispatcher().getDefaultHandler().updateLanguage(string);
    }

    public void updateAvailableLanguages(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateAvailableLanguages(stringArray);
    }

    public void updateEtcLanguageLoadProgress(long l) {
        this.getDispatcher().getDefaultHandler().updateEtcLanguageLoadProgress(l);
    }

    public void updateEtcLanguageLoadStatus(int n) {
        this.getDispatcher().getDefaultHandler().updateEtcLanguageLoadStatus(n);
    }

    public void updateEtcMetricSystem(int n) {
        this.getDispatcher().getDefaultHandler().updateEtcMetricSystem(n);
    }

    public void etcSensorDataReplayRoute(Route route) {
        this.getDispatcher().getDefaultHandler().etcSensorDataReplayRoute(route);
    }

    public void etcSensorDataReplayGuidance(boolean bl) {
        this.getDispatcher().getDefaultHandler().etcSensorDataReplayGuidance(bl);
    }

    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo) {
        this.getDispatcher().getDefaultHandler().updateEtcVersionInfo(navVersionInfo);
    }

    public void updateLispIsSpellerActive(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateLispIsSpellerActive(bl);
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.getDispatcher().getDefaultHandler().updatePoiSubstringSearchStatus(valueListStatus);
    }

    public void rgNotPossible(int n) {
        this.getDispatcher().getDefaultHandler().rgNotPossible(n);
    }

    public void updateRgActive(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRgActive(bl);
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.getDispatcher().getDefaultHandler().updateRgCalculatedRoutes(calculatedRouteListElementArray);
    }

    public void updateRgCurrentRoute(Route route) {
        this.getDispatcher().getDefaultHandler().updateRgCurrentRoute(route);
    }

    public void updateRgCurrentRouteOptions(RouteOptions routeOptions) {
        this.getDispatcher().getDefaultHandler().updateRgCurrentRouteOptions(routeOptions);
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.getDispatcher().getDefaultHandler().updateRgDestinationInfo(navRouteListDataArray);
    }

    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray) {
        this.getDispatcher().getDefaultHandler().updateRgDetailedStreetList(navRouteListDataArray);
    }

    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRgLaneGuidance(navLaneGuidanceDataArray, bl);
    }

    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
        this.getDispatcher().getDefaultHandler().updateRgPoiInfo(navPoiInfoArray);
    }

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.getDispatcher().getDefaultHandler().updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
    }

    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray) {
        this.getDispatcher().getDefaultHandler().updateRgStreetList(navRouteListDataArray);
    }

    public void updateRgTimeAfaToDestination(long l) {
        this.getDispatcher().getDefaultHandler().updateRgTimeAfaToDestination(l);
    }

    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        this.getDispatcher().getDefaultHandler().updateRgTurnList(turnListElementArray);
    }

    public void updateRgTurnToStreet(String string, boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRgTurnToStreet(string, bl);
    }

    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions) {
        this.getDispatcher().getDefaultHandler().updateRgUnfulfilledRouteOptions(routeOptions);
    }

    public void updateRmPersistentRoute(Route route) {
        this.getDispatcher().getDefaultHandler().updateRmPersistentRoute(route);
    }

    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
        this.getDispatcher().getDefaultHandler().updateRmRouteList(navRmRouteListArrayDataArray);
    }

    public void updateRrdActive(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRrdActive(bl);
    }

    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.getDispatcher().getDefaultHandler().updateRrdCalculationInfo(rrdCalculationInfoArray);
    }

    public void updateSoPosPosition(PosPosition posPosition) {
        this.getDispatcher().getDefaultHandler().updateSoPosPosition(posPosition);
    }

    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoPosPositionDescription(navLocation, bl);
    }

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
        this.getDispatcher().getDefaultHandler().updateTrMemoryUtilization(navTraceMemoryUtilization);
    }

    public void updateTrRecordingState(int n) {
        this.getDispatcher().getDefaultHandler().updateTrRecordingState(n);
    }

    public void updateTrOperatingMode(int n) {
        this.getDispatcher().getDefaultHandler().updateTrOperatingMode(n);
    }

    public void updateBapManeuverState(int n) {
        this.getDispatcher().getDefaultHandler().updateBapManeuverState(n);
    }

    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
        this.getDispatcher().getDefaultHandler().updateTrTraceList(navTraceListDataArray);
    }

    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
        this.getDispatcher().getDefaultHandler().updateTrDirectionToWaypoint(directionToWaypoint);
    }

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
        this.getDispatcher().getDefaultHandler().updateTrInfoForNextWaypoint(navNextWayPointInfo);
    }

    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.getDispatcher().getDefaultHandler().liTryBestMatchResult(tryBestMatchResultDataArray);
    }

    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.getDispatcher().getDefaultHandler().liTryMatchLocationResult(tryMatchLocationResultDataArray);
    }

    public void updateNavstateOfOperation(int n) {
        this.getDispatcher().getDefaultHandler().updateNavstateOfOperation(n);
    }

    public void updateNavMedia(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateNavMedia(stringArray);
    }

    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.getDispatcher().getDefaultHandler().updateRenderingInfoProvider(renderingInfoProvider);
    }

    public void updateClockAdjusted(boolean bl) {
        this.logger.log(1000000, "NavCommand#updateClockAdjusted()");
    }

    public void fireTimer(Timer timer) {
        this.logger.log(1000000, "NavCommand#fireTimer()");
    }

    public void cancelTimer(Timer timer) {
        this.logger.log(1000000, "NavCommand#cancelTimer()");
    }

    public void responseAudioTrigger(int n) {
        this.getDispatcher().getDefaultHandler().responseAudioTrigger(n);
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.getDispatcher().getDefaultHandler().liCurrentState(navLocation, nArray, nArray2, l);
    }

    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().liGetLastStateHistoryEntryResult(navLocation, bl);
    }

    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().liGetLastCityHistoryEntryResult(navLocation, bl);
    }

    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().liGetLastStreetHistoryEntryResult(navLocation, bl);
    }

    public void liLastCityAndStreetHistoryResult(long l) {
        this.getDispatcher().getDefaultHandler().liLastCityAndStreetHistoryResult(l);
    }

    public void liStripLocationResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().liStripLocationResult(navLocation);
    }

    public void liValueListFileStatus(int n, int n2, String string) {
        this.getDispatcher().getDefaultHandler().liValueListFileStatus(n, n2, string);
    }

    public void liValueListOutputMethod(int n) {
        this.getDispatcher().getDefaultHandler().liValueListOutputMethod(n);
    }

    public void rgException(int n) {
        this.getDispatcher().getDefaultHandler().rgException(n);
    }

    public void rgStartGuidanceRouteResult(int n) {
        this.getDispatcher().getDefaultHandler().rgStartGuidanceRouteResult(n);
    }

    public void rgStartGuidanceCalculatedRouteResult(int n) {
        this.getDispatcher().getDefaultHandler().rgStartGuidanceCalculatedRouteResult(n);
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        this.getDispatcher().getDefaultHandler().rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
    }

    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().soPosPositionDescriptionVehicleResult(navLocation);
    }

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        this.getDispatcher().getDefaultHandler().updateBapManeuverDescriptor(bapManeuverDescriptorArray);
    }

    public void updateCityVignettes(int[] nArray) {
        this.getDispatcher().getDefaultHandler().updateCityVignettes(nArray);
    }

    public void updateCountryInfo(CountryInfo[] countryInfoArray) {
        this.getDispatcher().getDefaultHandler().updateCountryInfo(countryInfoArray);
    }

    public void updateDmFlagDestination(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().updateDmFlagDestination(navLocation);
    }

    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray) {
        this.getDispatcher().getDefaultHandler().updateLiCityHistory(lICityHistoryEntryArray);
    }

    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
        this.getDispatcher().getDefaultHandler().updateLiStateHistory(lIStateHistoryEntryArray);
    }

    public void updateLiCountryForCityAndStreetHistory(String string) {
        this.getDispatcher().getDefaultHandler().updateLiCountryForCityAndStreetHistory(string);
    }

    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
        this.getDispatcher().getDefaultHandler().updateLiStreetHistory(lIStreetHistoryEntryArray);
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.getDispatcher().getDefaultHandler().updateRgInfoForNextDestination(rgInfoForNextDestination);
    }

    public void updateRgPoiInfoCalculationHorizon(long l) {
        this.getDispatcher().getDefaultHandler().updateRgPoiInfoCalculationHorizon(l);
    }

    public void updateRgRouteProperties(RouteProperties routeProperties) {
        this.getDispatcher().getDefaultHandler().updateRgRouteProperties(routeProperties);
    }

    public void updateRgTurnListCalculationHorizon(long l) {
        this.getDispatcher().getDefaultHandler().updateRgTurnListCalculationHorizon(l);
    }

    public void updateAudioRequest(int n) {
        this.getDispatcher().getDefaultHandler().updateAudioRequest(n);
    }

    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray) {
        this.getDispatcher().getDefaultHandler().updateEtcAvailableNavDataBases(navDataBaseArray);
    }

    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase) {
        this.getDispatcher().getDefaultHandler().updateEtcCurrentNavDataBase(navDataBase);
    }

    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        this.getDispatcher().getDefaultHandler().liSetCountryForCityAndStreetHistoryResult(n);
    }

    public void liHistoryResult(int n) {
        this.getDispatcher().getDefaultHandler().liHistoryResult(n);
    }

    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        this.getDispatcher().getDefaultHandler().ehGetAllCategoriesResult(n, categoryArray, n2);
    }

    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        this.getDispatcher().getDefaultHandler().ehGetAllBrandsOfCategoryResult(n, n2, brandArray, n3);
    }

    public void ehResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().ehResult(n, n2);
    }

    public void blockAreaResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockAreaResult(l, n);
    }

    public void blockRoadSegmentsResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockRoadSegmentsResult(l, n);
    }

    public void blockRouteBasedOnLengthResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockRouteBasedOnLengthResult(l, n);
    }

    public void blockRouteSegmentsResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockRouteSegmentsResult(l, n);
    }

    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        this.getDispatcher().getDefaultHandler().combinedRouteListResult(l, combinedRouteListElementArray, n);
    }

    public void deleteBlockResult(long[] lArray, int n) {
        this.getDispatcher().getDefaultHandler().deleteBlockResult(lArray, n);
    }

    public void persistBlockResult(long[] lArray, int n) {
        this.getDispatcher().getDefaultHandler().persistBlockResult(lArray, n);
    }

    public void setBlockDescriptionResult(long[] lArray, int n) {
        this.getDispatcher().getDefaultHandler().setBlockDescriptionResult(lArray, n);
    }

    public void updateListOfBlocks(BlockElement[] blockElementArray) {
        this.getDispatcher().getDefaultHandler().updateListOfBlocks(blockElementArray);
    }

    public void updateNaviCoreAvailableToSetBlocks(int n) {
        this.getDispatcher().getDefaultHandler().updateNaviCoreAvailableToSetBlocks(n);
    }

    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
        this.getDispatcher().getDefaultHandler().updateMaximumLengthOfBlockRouteBasedOnLength(n);
    }

    public void windowChanged(int n) {
        this.getDispatcher().getDefaultHandler().windowChanged(n);
    }

    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        this.getDispatcher().getDefaultHandler().getBoundingRectangleOfCombinedRouteListElementsResult(lArray, navRectangle);
    }

    public void updateElementsTotal(long l, long l2, int n) {
        this.getDispatcher().getDefaultHandler().updateElementsTotal(l, l2, n);
    }

    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
        this.getDispatcher().getDefaultHandler().poiInformationResult(navPoiInfo, n);
    }

    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray) {
        this.getDispatcher().getDefaultHandler().updateBapTurnToInfo(bapTurnToInfoArray);
    }

    public void updateRgiString(short[] sArray) {
        this.getDispatcher().getDefaultHandler().updateRgiString(sArray);
    }

    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        this.getDispatcher().getDefaultHandler().liGetViaPointListResult(n, viaPointListElementArray, n2, n3);
    }

    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        this.getDispatcher().getDefaultHandler().liSelectViaPointResult(navLocation, n);
    }

    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        this.getDispatcher().getDefaultHandler().requestCountryInfoResult(countryInfo, n);
    }

    public void setTrailerStatusResult(int n) {
        this.getDispatcher().getDefaultHandler().setTrailerStatusResult(n);
    }

    public void setUserDefinedPOIsResult(int n) {
        this.getDispatcher().getDefaultHandler().setUserDefinedPOIsResult(n);
    }

    public void setVehicleConsumptionInfoResult(int n) {
        this.getDispatcher().getDefaultHandler().setVehicleConsumptionInfoResult(n);
    }

    public void updateStyleDBPaths(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateStyleDBPaths(stringArray);
    }

    public void updateRouteResumePossible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRouteResumePossible(bl);
    }

    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
        this.getDispatcher().getDefaultHandler().liGetSpellableCharactersResult(navLocation, n, string, n2);
    }

    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
        this.getDispatcher().getDefaultHandler().getSpellableCharactersResult(string, string2, n, string3, n2);
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.getDispatcher().getDefaultHandler().updateEtcAvailablePersonalPOIDataBases(navDataBaseArray, n);
    }

    public void deletePersonalPOIDataBasesResult(int n) {
        this.getDispatcher().getDefaultHandler().deletePersonalPOIDataBasesResult(n);
    }

    public void updatePersonalPOISearchStatus(int n, int n2) {
        this.getDispatcher().getDefaultHandler().updatePersonalPOISearchStatus(n, n2);
    }

    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().rgGetLocationOnRouteResult(navLocation);
    }

    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
        this.getDispatcher().getDefaultHandler().rgGetRouteBoundingRectangleResult(navRectangle);
    }

    public void rgStartRubberbandManipulationResult(int n) {
        this.getDispatcher().getDefaultHandler().rgStartRubberbandManipulationResult(n);
    }

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.getDispatcher().getDefaultHandler().rgGetRubberBandPointPositionResult(navLocationWgs84, bl);
    }

    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
        this.getDispatcher().getDefaultHandler().updateNavDbRegionsState(n, stringArray, n2);
    }

    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray) {
        this.getDispatcher().getDefaultHandler().updatePOIsEnteringProximityRange(navLocationArray);
    }

    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().lispGetLocationFromLiValueListResult(n, navLocation);
    }

    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        this.getDispatcher().getDefaultHandler().poiGetCategoryTypesFromUIdResult(nArray);
    }

    public void rgResult(int n) {
        this.getDispatcher().getDefaultHandler().rgResult(n);
    }

    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().rgSwitchToNextPossibleRoadResult(bl);
    }

    public void lispGetMatchingNVCResult(String string) {
        this.getDispatcher().getDefaultHandler().lispGetMatchingNVCResult(string);
    }

    public void updateMapIntegrationState(int n) {
        this.getDispatcher().getDefaultHandler().updateMapIntegrationState(n);
    }

    public void lispRequestNVCListResult(int n, String string, int n2) {
        this.getDispatcher().getDefaultHandler().lispRequestNVCListResult(n, string, n2);
    }

    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        this.getDispatcher().getDefaultHandler().liDisambiguateLocationResult(nArray, navLocationArray);
    }

    public void triggerEventAudioMessageResult(int n) {
        this.getDispatcher().getDefaultHandler().triggerEventAudioMessageResult(n);
    }

    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.getDispatcher().getDefaultHandler().updateBapManeuverInformation(bapManeuverDescriptorArray, n);
    }

    public void poiGetXt9LDBsResult(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().poiGetXt9LDBsResult(stringArray);
    }

    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        this.getDispatcher().getDefaultHandler().poiRequestExtendedInfoResult(poiExtendedInfo, bl);
    }

    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().liGetLocationDescriptionTransformNearByResult(navLocation);
    }

    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().importRouteFromGpxFileResult(navLocation);
    }
}

