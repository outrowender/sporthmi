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
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public NavCommand() {
        this((String)null);
    }

    public NavCommand(String string) {
        super(string);
    }

    @Override
    public void setCommandList(ICommandList iCommandList) {
        super.setCommandList(iCommandList);
        if (!(iCommandList instanceof NavCommandList)) {
            throw new ClassCastException("Expected NavCommandList!");
        }
        NavCommandList navCommandList = (NavCommandList)iCommandList;
        this.init(navCommandList.getEnv(), navCommandList.getDSINavigationManager(), navCommandList.getNavigation());
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    protected int getDSIType() {
        int n;
        if (this.getCommandList() != null) {
            n = DSINavigationManager.getDSIType(this.getCommandList());
        } else {
            this.logger.log(-1601830656, "NavCommand#getDSIType() - command list currently not set!");
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

    @Override
    public abstract void execute() {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getDispatcher().getDefaultHandler().asyncException(n, string, n2);
        String string2 = new Buffer().append("asyncException(").append(n).append(", ").append(string).append(", ").append(n2).append(")").toString();
        this.getCommandList().commandAborted(string2);
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver) {
        this.getDispatcher().getDefaultHandler().updateDistanceToNextManeuver(distanceToNextManeuver);
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().dmLastDestinationsGetResult(l, navLocation);
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
        this.getDispatcher().getDefaultHandler().dmRecentRoutesGetResult(l, route);
    }

    @Override
    public void dmResult(long l, long l2) {
        this.getDispatcher().getDefaultHandler().dmResult(l, l2);
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().liGetLocationDescriptionTransformResult(navLocation);
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        this.getDispatcher().getDefaultHandler().liGetStateResult(lISpellerData);
    }

    @Override
    public void liResult(long l) {
        this.getDispatcher().getDefaultHandler().liResult(l);
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.getDispatcher().getDefaultHandler().liValueList(lIValueList, l);
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.getDispatcher().getDefaultHandler().lispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4, l);
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        this.getDispatcher().getDefaultHandler().poiValueList(lIValueList, l);
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
        this.getDispatcher().getDefaultHandler().updateRgRouteCalculationState(n);
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
        this.getDispatcher().getDefaultHandler().rmMakeRoutePersistentResult(l);
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        this.getDispatcher().getDefaultHandler().rmRouteAddResult(n, l);
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
        this.getDispatcher().getDefaultHandler().rmRouteDeleteAllResult(n);
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        this.getDispatcher().getDefaultHandler().rmRouteDeleteResult(n);
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
        this.getDispatcher().getDefaultHandler().rmRouteGetResult(n, route);
    }

    @Override
    public void rmRouteRenameResult(int n) {
        this.getDispatcher().getDefaultHandler().rmRouteRenameResult(n);
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
        this.getDispatcher().getDefaultHandler().rmRouteReplaceResult(n, l, n2);
    }

    @Override
    public void translateRouteResult(Route route) {
        this.getDispatcher().getDefaultHandler().translateRouteResult(route);
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().trDeleteAllTracesResult(n, n2);
    }

    @Override
    public void trExportTrailsResult(int n) {
        this.getDispatcher().getDefaultHandler().trExportTrailsResult(n);
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        this.getDispatcher().getDefaultHandler().trImportTrailsResult(navSegmentIDArray, n);
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().trDeleteTraceResult(n, n2);
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().trRenameTraceResult(n, n2);
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
        this.getDispatcher().getDefaultHandler().trStartTraceRecordingResult(n, l, n2);
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
        this.getDispatcher().getDefaultHandler().trStopTraceRecordingResult(n, l, n2);
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        this.getDispatcher().getDefaultHandler().trStoreTraceResult(n, navSegmentID, n2);
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
        this.getDispatcher().getDefaultHandler().rgSetRouteGuidanceModeResult();
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.getDispatcher().getDefaultHandler().locationToStreamResult(bl, byArray);
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().streamToLocationResult(bl, navLocation);
    }

    @Override
    public void updateAfaMode(int n) {
        this.getDispatcher().getDefaultHandler().updateAfaMode(n);
    }

    @Override
    public void updateAfaSpeaking(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateAfaSpeaking(bl);
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray) {
        this.getDispatcher().getDefaultHandler().updateDmLastDestinationsList(lDListElementArray);
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray) {
        this.getDispatcher().getDefaultHandler().updateDmRecentRoutesList(rRListElementArray);
    }

    @Override
    public void updateEtcDemoModeState(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateEtcDemoModeState(bl);
    }

    @Override
    public void updateLanguage(String string) {
        this.getDispatcher().getDefaultHandler().updateLanguage(string);
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateAvailableLanguages(stringArray);
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l) {
        this.getDispatcher().getDefaultHandler().updateEtcLanguageLoadProgress(l);
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n) {
        this.getDispatcher().getDefaultHandler().updateEtcLanguageLoadStatus(n);
    }

    @Override
    public void updateEtcMetricSystem(int n) {
        this.getDispatcher().getDefaultHandler().updateEtcMetricSystem(n);
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
        this.getDispatcher().getDefaultHandler().etcSensorDataReplayRoute(route);
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
        this.getDispatcher().getDefaultHandler().etcSensorDataReplayGuidance(bl);
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo) {
        this.getDispatcher().getDefaultHandler().updateEtcVersionInfo(navVersionInfo);
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateLispIsSpellerActive(bl);
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.getDispatcher().getDefaultHandler().updatePoiSubstringSearchStatus(valueListStatus);
    }

    @Override
    public void rgNotPossible(int n) {
        this.getDispatcher().getDefaultHandler().rgNotPossible(n);
    }

    @Override
    public void updateRgActive(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRgActive(bl);
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.getDispatcher().getDefaultHandler().updateRgCalculatedRoutes(calculatedRouteListElementArray);
    }

    @Override
    public void updateRgCurrentRoute(Route route) {
        this.getDispatcher().getDefaultHandler().updateRgCurrentRoute(route);
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions) {
        this.getDispatcher().getDefaultHandler().updateRgCurrentRouteOptions(routeOptions);
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.getDispatcher().getDefaultHandler().updateRgDestinationInfo(navRouteListDataArray);
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray) {
        this.getDispatcher().getDefaultHandler().updateRgDetailedStreetList(navRouteListDataArray);
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRgLaneGuidance(navLaneGuidanceDataArray, bl);
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
        this.getDispatcher().getDefaultHandler().updateRgPoiInfo(navPoiInfoArray);
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.getDispatcher().getDefaultHandler().updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray) {
        this.getDispatcher().getDefaultHandler().updateRgStreetList(navRouteListDataArray);
    }

    @Override
    public void updateRgTimeAfaToDestination(long l) {
        this.getDispatcher().getDefaultHandler().updateRgTimeAfaToDestination(l);
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        this.getDispatcher().getDefaultHandler().updateRgTurnList(turnListElementArray);
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRgTurnToStreet(string, bl);
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions) {
        this.getDispatcher().getDefaultHandler().updateRgUnfulfilledRouteOptions(routeOptions);
    }

    @Override
    public void updateRmPersistentRoute(Route route) {
        this.getDispatcher().getDefaultHandler().updateRmPersistentRoute(route);
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
        this.getDispatcher().getDefaultHandler().updateRmRouteList(navRmRouteListArrayDataArray);
    }

    @Override
    public void updateRrdActive(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRrdActive(bl);
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.getDispatcher().getDefaultHandler().updateRrdCalculationInfo(rrdCalculationInfoArray);
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition) {
        this.getDispatcher().getDefaultHandler().updateSoPosPosition(posPosition);
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().updateSoPosPositionDescription(navLocation, bl);
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
        this.getDispatcher().getDefaultHandler().updateTrMemoryUtilization(navTraceMemoryUtilization);
    }

    @Override
    public void updateTrRecordingState(int n) {
        this.getDispatcher().getDefaultHandler().updateTrRecordingState(n);
    }

    @Override
    public void updateTrOperatingMode(int n) {
        this.getDispatcher().getDefaultHandler().updateTrOperatingMode(n);
    }

    @Override
    public void updateBapManeuverState(int n) {
        this.getDispatcher().getDefaultHandler().updateBapManeuverState(n);
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
        this.getDispatcher().getDefaultHandler().updateTrTraceList(navTraceListDataArray);
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
        this.getDispatcher().getDefaultHandler().updateTrDirectionToWaypoint(directionToWaypoint);
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
        this.getDispatcher().getDefaultHandler().updateTrInfoForNextWaypoint(navNextWayPointInfo);
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.getDispatcher().getDefaultHandler().liTryBestMatchResult(tryBestMatchResultDataArray);
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.getDispatcher().getDefaultHandler().liTryMatchLocationResult(tryMatchLocationResultDataArray);
    }

    @Override
    public void updateNavstateOfOperation(int n) {
        this.getDispatcher().getDefaultHandler().updateNavstateOfOperation(n);
    }

    @Override
    public void updateNavMedia(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateNavMedia(stringArray);
    }

    @Override
    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.getDispatcher().getDefaultHandler().updateRenderingInfoProvider(renderingInfoProvider);
    }

    @Override
    public void updateClockAdjusted(boolean bl) {
        this.logger.log(1078071040, "NavCommand#updateClockAdjusted()");
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.log(1078071040, "NavCommand#fireTimer()");
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.logger.log(1078071040, "NavCommand#cancelTimer()");
    }

    @Override
    public void responseAudioTrigger(int n) {
        this.getDispatcher().getDefaultHandler().responseAudioTrigger(n);
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.getDispatcher().getDefaultHandler().liCurrentState(navLocation, nArray, nArray2, l);
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().liGetLastStateHistoryEntryResult(navLocation, bl);
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().liGetLastCityHistoryEntryResult(navLocation, bl);
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.getDispatcher().getDefaultHandler().liGetLastStreetHistoryEntryResult(navLocation, bl);
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        this.getDispatcher().getDefaultHandler().liLastCityAndStreetHistoryResult(l);
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().liStripLocationResult(navLocation);
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
        this.getDispatcher().getDefaultHandler().liValueListFileStatus(n, n2, string);
    }

    @Override
    public void liValueListOutputMethod(int n) {
        this.getDispatcher().getDefaultHandler().liValueListOutputMethod(n);
    }

    @Override
    public void rgException(int n) {
        this.getDispatcher().getDefaultHandler().rgException(n);
    }

    @Override
    public void rgStartGuidanceRouteResult(int n) {
        this.getDispatcher().getDefaultHandler().rgStartGuidanceRouteResult(n);
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
        this.getDispatcher().getDefaultHandler().rgStartGuidanceCalculatedRouteResult(n);
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        this.getDispatcher().getDefaultHandler().rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().soPosPositionDescriptionVehicleResult(navLocation);
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        this.getDispatcher().getDefaultHandler().updateBapManeuverDescriptor(bapManeuverDescriptorArray);
    }

    @Override
    public void updateCityVignettes(int[] nArray) {
        this.getDispatcher().getDefaultHandler().updateCityVignettes(nArray);
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray) {
        this.getDispatcher().getDefaultHandler().updateCountryInfo(countryInfoArray);
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().updateDmFlagDestination(navLocation);
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray) {
        this.getDispatcher().getDefaultHandler().updateLiCityHistory(lICityHistoryEntryArray);
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
        this.getDispatcher().getDefaultHandler().updateLiStateHistory(lIStateHistoryEntryArray);
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string) {
        this.getDispatcher().getDefaultHandler().updateLiCountryForCityAndStreetHistory(string);
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
        this.getDispatcher().getDefaultHandler().updateLiStreetHistory(lIStreetHistoryEntryArray);
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.getDispatcher().getDefaultHandler().updateRgInfoForNextDestination(rgInfoForNextDestination);
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l) {
        this.getDispatcher().getDefaultHandler().updateRgPoiInfoCalculationHorizon(l);
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties) {
        this.getDispatcher().getDefaultHandler().updateRgRouteProperties(routeProperties);
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l) {
        this.getDispatcher().getDefaultHandler().updateRgTurnListCalculationHorizon(l);
    }

    @Override
    public void updateAudioRequest(int n) {
        this.getDispatcher().getDefaultHandler().updateAudioRequest(n);
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray) {
        this.getDispatcher().getDefaultHandler().updateEtcAvailableNavDataBases(navDataBaseArray);
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase) {
        this.getDispatcher().getDefaultHandler().updateEtcCurrentNavDataBase(navDataBase);
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        this.getDispatcher().getDefaultHandler().liSetCountryForCityAndStreetHistoryResult(n);
    }

    @Override
    public void liHistoryResult(int n) {
        this.getDispatcher().getDefaultHandler().liHistoryResult(n);
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        this.getDispatcher().getDefaultHandler().ehGetAllCategoriesResult(n, categoryArray, n2);
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        this.getDispatcher().getDefaultHandler().ehGetAllBrandsOfCategoryResult(n, n2, brandArray, n3);
    }

    @Override
    public void ehResult(int n, int n2) {
        this.getDispatcher().getDefaultHandler().ehResult(n, n2);
    }

    @Override
    public void blockAreaResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockAreaResult(l, n);
    }

    @Override
    public void blockRoadSegmentsResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockRoadSegmentsResult(l, n);
    }

    @Override
    public void blockRouteBasedOnLengthResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockRouteBasedOnLengthResult(l, n);
    }

    @Override
    public void blockRouteSegmentsResult(long l, int n) {
        this.getDispatcher().getDefaultHandler().blockRouteSegmentsResult(l, n);
    }

    @Override
    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        this.getDispatcher().getDefaultHandler().combinedRouteListResult(l, combinedRouteListElementArray, n);
    }

    @Override
    public void deleteBlockResult(long[] lArray, int n) {
        this.getDispatcher().getDefaultHandler().deleteBlockResult(lArray, n);
    }

    @Override
    public void persistBlockResult(long[] lArray, int n) {
        this.getDispatcher().getDefaultHandler().persistBlockResult(lArray, n);
    }

    @Override
    public void setBlockDescriptionResult(long[] lArray, int n) {
        this.getDispatcher().getDefaultHandler().setBlockDescriptionResult(lArray, n);
    }

    @Override
    public void updateListOfBlocks(BlockElement[] blockElementArray) {
        this.getDispatcher().getDefaultHandler().updateListOfBlocks(blockElementArray);
    }

    @Override
    public void updateNaviCoreAvailableToSetBlocks(int n) {
        this.getDispatcher().getDefaultHandler().updateNaviCoreAvailableToSetBlocks(n);
    }

    @Override
    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
        this.getDispatcher().getDefaultHandler().updateMaximumLengthOfBlockRouteBasedOnLength(n);
    }

    @Override
    public void windowChanged(int n) {
        this.getDispatcher().getDefaultHandler().windowChanged(n);
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        this.getDispatcher().getDefaultHandler().getBoundingRectangleOfCombinedRouteListElementsResult(lArray, navRectangle);
    }

    @Override
    public void updateElementsTotal(long l, long l2, int n) {
        this.getDispatcher().getDefaultHandler().updateElementsTotal(l, l2, n);
    }

    @Override
    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
        this.getDispatcher().getDefaultHandler().poiInformationResult(navPoiInfo, n);
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray) {
        this.getDispatcher().getDefaultHandler().updateBapTurnToInfo(bapTurnToInfoArray);
    }

    @Override
    public void updateRgiString(short[] sArray) {
        this.getDispatcher().getDefaultHandler().updateRgiString(sArray);
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        this.getDispatcher().getDefaultHandler().liGetViaPointListResult(n, viaPointListElementArray, n2, n3);
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        this.getDispatcher().getDefaultHandler().liSelectViaPointResult(navLocation, n);
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        this.getDispatcher().getDefaultHandler().requestCountryInfoResult(countryInfo, n);
    }

    @Override
    public void setTrailerStatusResult(int n) {
        this.getDispatcher().getDefaultHandler().setTrailerStatusResult(n);
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
        this.getDispatcher().getDefaultHandler().setUserDefinedPOIsResult(n);
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
        this.getDispatcher().getDefaultHandler().setVehicleConsumptionInfoResult(n);
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().updateStyleDBPaths(stringArray);
    }

    @Override
    public void updateRouteResumePossible(boolean bl) {
        this.getDispatcher().getDefaultHandler().updateRouteResumePossible(bl);
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
        this.getDispatcher().getDefaultHandler().liGetSpellableCharactersResult(navLocation, n, string, n2);
    }

    @Override
    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
        this.getDispatcher().getDefaultHandler().getSpellableCharactersResult(string, string2, n, string3, n2);
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.getDispatcher().getDefaultHandler().updateEtcAvailablePersonalPOIDataBases(navDataBaseArray, n);
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
        this.getDispatcher().getDefaultHandler().deletePersonalPOIDataBasesResult(n);
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
        this.getDispatcher().getDefaultHandler().updatePersonalPOISearchStatus(n, n2);
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().rgGetLocationOnRouteResult(navLocation);
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
        this.getDispatcher().getDefaultHandler().rgGetRouteBoundingRectangleResult(navRectangle);
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
        this.getDispatcher().getDefaultHandler().rgStartRubberbandManipulationResult(n);
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.getDispatcher().getDefaultHandler().rgGetRubberBandPointPositionResult(navLocationWgs84, bl);
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
        this.getDispatcher().getDefaultHandler().updateNavDbRegionsState(n, stringArray, n2);
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray) {
        this.getDispatcher().getDefaultHandler().updatePOIsEnteringProximityRange(navLocationArray);
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().lispGetLocationFromLiValueListResult(n, navLocation);
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        this.getDispatcher().getDefaultHandler().poiGetCategoryTypesFromUIdResult(nArray);
    }

    @Override
    public void rgResult(int n) {
        this.getDispatcher().getDefaultHandler().rgResult(n);
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        this.getDispatcher().getDefaultHandler().rgSwitchToNextPossibleRoadResult(bl);
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
        this.getDispatcher().getDefaultHandler().lispGetMatchingNVCResult(string);
    }

    @Override
    public void updateMapIntegrationState(int n) {
        this.getDispatcher().getDefaultHandler().updateMapIntegrationState(n);
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
        this.getDispatcher().getDefaultHandler().lispRequestNVCListResult(n, string, n2);
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        this.getDispatcher().getDefaultHandler().liDisambiguateLocationResult(nArray, navLocationArray);
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
        this.getDispatcher().getDefaultHandler().triggerEventAudioMessageResult(n);
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.getDispatcher().getDefaultHandler().updateBapManeuverInformation(bapManeuverDescriptorArray, n);
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
        this.getDispatcher().getDefaultHandler().poiGetXt9LDBsResult(stringArray);
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        this.getDispatcher().getDefaultHandler().poiRequestExtendedInfoResult(poiExtendedInfo, bl);
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().liGetLocationDescriptionTransformNearByResult(navLocation);
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        this.getDispatcher().getDefaultHandler().importRouteFromGpxFileResult(navLocation);
    }
}

