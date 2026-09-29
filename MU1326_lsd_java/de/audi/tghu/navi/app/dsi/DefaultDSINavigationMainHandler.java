/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.ResetSMCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.command.StartGuidanceCommand;
import de.audi.tghu.navi.app.dsi.AbstractDSINavigationHandler;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.util.RouteUtil;
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

public class DefaultDSINavigationMainHandler
extends AbstractDSINavigationHandler {
    private static final boolean ETC_SENSOR_DATA_REPLAY_ENABLED = Boolean.getBoolean("ETC_SENSOR_DATA_REPLAY");
    private final ICommandListFactory commandListFactory;

    public DefaultDSINavigationMainHandler(NavigationEnv navigationEnv, Navigation navigation, ICommandListFactory iCommandListFactory) {
        super(navigationEnv, navigation, 0);
        this.commandListFactory = iCommandListFactory;
        navigationEnv.getLabelModel(341).setText("");
    }

    @Override
    protected DSIResponseContainer getContainer() {
        return this.env.getContainer();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#asyncException received: errorCode: %2, errorMsg: %1, requestType: %3 ", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#dmLastDestinationsGetResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#dmRecentRoutesGetResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void dmResult(long l, long l2) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#dmResult() - ignored ");
        }
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#liGetLocationDescriptionTransformResult() - ignored ");
        }
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#liGetLocationDescriptionTransformNearByResult() - ignored ");
        }
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liGetStateResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void liResult(long l) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#liResult( %1 ) - ignored", l);
        }
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.logChannel.log(-1601830656, "DefaultDSINavigationMainHandler#liValueList() - must not be handled by the default handler!!! ");
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logChannel.log(-1601830656, "DefaultDSINavigationMainHandler#lispUpdateSpellerResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#poiValueList() - ignored ");
        }
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgRouteCalculationState(%1) ", (long)n);
        this.env.getChoiceModel(-1893595648).setValue(n);
        this.env.getContainer().setRgRouteCalculationState(n);
        this.navigation.getMapInterface().updateRgRouteCalculationState(n);
        this.navigation.getPredictiveNavController().updateRgRouteCalculationState();
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rmMakeRoutePersistentResult() - must not be handled by the default handler!!!");
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rmRouteAddResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rmRouteDeleteAllResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rmRouteDeleteResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rmRouteGetResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void rmRouteRenameResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rmRouteRenameResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rmRouteReplaceResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void translateRouteResult(Route route) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#translateRouteResult() - must not be handled by the default handler!!!");
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trDeleteAllTracesResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trDeleteTraceResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void trExportTrailsResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trExportTrailsResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trImportTrailsResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trRenameTraceResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trStartTraceRecordingResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trStopTraceRecordingResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#trStoreTraceResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgSetRouteGuidanceModeResult() - must not be handled by the default handler!!!");
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#locationToStreamResult() - must not be handled by the default handler!!!");
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#streamToLocationResult() - must not be handled by the default handler!!!");
    }

    @Override
    public void updateAfaMode(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateAfaMode() - ignored ");
        }
    }

    @Override
    public void updateAudioRequest(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateAudioRequest( %1 )", (long)n);
        this.navigation.getAudioStateMachine().updateAudioRequest(n);
        this.navigation.getAudioStateMachine().getLastAnnouncementHandler().updateAudioRequest(n);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateAudioRequest() - exit ");
    }

    @Override
    public void updateAfaSpeaking(boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateAfaSpeaking( %1 )", bl);
        this.env.getContainer().setAfaSpeaking(bl);
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#getLastDestinationsResult() - entry ");
        this.env.getContainer().setDmLastDestinations(lDListElementArray);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#getLastDestinationsResult() - exit ");
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateDmRecentRoutesList() - ignored ");
        }
    }

    @Override
    public void updateEtcDemoModeState(boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcDemoModeState() - entry ");
        this.env.getContainer().setEtcDemoMode(bl);
        this.navigation.getDemoModeManager().updateEtcDemoModeState(bl);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcDemoModeState() - exit ");
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateAvailableLanguages( %1 )", (Object)stringArray);
        this.env.getFramework().getLanguageMgr().updateAvailableLanguages("LANG_COMPONENT_NAVI", stringArray);
        this.env.getContainer().setAvailableLanguages(stringArray);
    }

    @Override
    public void updateLanguage(String string) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateLanguage( %1 ) ", (Object)string);
        this.env.getContainer().setLanguage(string);
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateEtcLanguage_LoadProgress( %1 ) - ignored", l);
        }
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateEtcLanguage_LoadStatus( %1 ) - ignored", (long)n);
        }
    }

    @Override
    public void updateEtcMetricSystem(int n) {
        int n2;
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcMetricSystem( %1 ) ", (long)n);
        this.env.getContainer().setEtcMetricSystem(n);
        switch (n) {
            case 2: {
                n2 = 0;
                break;
            }
            case 3: 
            case 4: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        this.env.getChoiceModel(-1189345792).setValue(n2);
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcSensorDataReplayRoute( %1 ) ", (Object)RouteUtil.formatRouteShort(route));
        if (!ETC_SENSOR_DATA_REPLAY_ENABLED) {
            this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcSensorDataReplayRoute() - failed to load replay route! Sensor data replay not enabled! ");
            return;
        }
        if (!this.navigation.getOperationManager().isFullyOperable()) {
            this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcSensorDataReplayRoute() - failed to load replay route! We are not fully operable! ");
            return;
        }
        if (RouteUtil.getRouteLength(route) <= 0) {
            this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcSensorDataReplayRoute() - failed to load replay route! Length: 0 ");
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RGStopGuidanceCommand());
        commandList.add(new RmMakeRoutePersistentCommand(route));
        commandList.add(new ResetSMCommand());
        commandList.execute("DefaultDSINavigationMainHandler#etcSensorDataReplayRoute");
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcSensorDataReplayGuidance( %1 ) ", bl);
        if (!ETC_SENSOR_DATA_REPLAY_ENABLED) {
            this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcSensorDataReplayGuidance() - failed to replay route! Sensor data replay not enabled! ");
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (bl) {
            commandList.add(new StartGuidanceCommand(2, false, false));
        } else {
            commandList.add(new RGStopGuidanceCommand());
        }
        commandList.execute("DefaultDSINavigationMainHandler#etcSensorDataReplayGuidance");
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcVersionInfo() - length: %1", navVersionInfo != null && navVersionInfo.getNavVersion() != null ? (long)navVersionInfo.getNavVersion().length : 0L);
        if (navVersionInfo != null) {
            String[] stringArray = navVersionInfo.getNavVersion();
            this.navigation.getNavVersionInfoHandler().setNavVersionInfo(stringArray);
            if (stringArray != null && stringArray.length > 0) {
                String string;
                if (stringArray.length < 5) {
                    this.logChannel.log(-1601830656, "DefaultDSINavigationMainHandler#updateEtcVersionInfo() - version info not complete! Using string at index 0.");
                    string = stringArray[0];
                } else {
                    Buffer buffer = new Buffer(100);
                    if (!Util.isEmpty(stringArray[1])) {
                        buffer.append(stringArray[1]);
                    }
                    if (!Util.isEmpty(stringArray[2])) {
                        if (buffer.length() != 0) {
                            buffer.append(' ');
                        }
                        buffer.append(stringArray[2]);
                    }
                    if (!Util.isEmpty(stringArray[3])) {
                        if (buffer.length() != 0) {
                            buffer.append(' ');
                        }
                        buffer.append(stringArray[3]);
                    }
                    if (!Util.isEmpty(stringArray[4])) {
                        if (buffer.length() != 0) {
                            buffer.append(' ');
                        }
                        buffer.append(stringArray[4]);
                    }
                    if (buffer.length() != 0) {
                        string = buffer.toString();
                        if (this.logChannel.isDebug2()) {
                            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateEtcVersionInfo() - version info label: \"%1\"", (Object)string);
                        }
                    } else {
                        this.logChannel.log(-1601830656, "DefaultDSINavigationMainHandler#updateEtcVersionInfo() - version info not present! Using string at index 0.");
                        string = stringArray[0];
                    }
                }
                this.env.getLabelModel(341).setText(string);
                if (Util.isHURegionKR() && stringArray.length > 5) {
                    this.env.getLabelModel(4637).setText(stringArray[5]);
                } else if (Util.isHURegionCN() && stringArray.length > 7) {
                    this.env.getLabelModel(4637).setText(stringArray[5]);
                    this.env.getLabelModel(4636).setText(stringArray[6]);
                    this.env.getLabelModel(5612).setText(stringArray[7]);
                }
                if (null != this.navigation && null != this.navigation.getAsiaDbPartialMapUpdateController()) {
                    this.navigation.getAsiaDbPartialMapUpdateController().updateDatabaseVersionInfo(stringArray);
                }
            } else {
                this.logChannel.log(10000, "DefaultDSINavigationMainHandler#updateEtcVersionInfo() - navVersion array is null or empty!");
            }
        } else {
            this.logChannel.log(10000, "DefaultDSINavigationMainHandler#updateEtcVersionInfo() - etcVersionInfo is null!");
        }
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateLispIsSpellerActive( %1 )", bl);
        this.env.getContainer().setLiIsSpellerActive(bl);
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updatePoiSubstringSearchStatus( %1 )", (Object)valueListStatus);
        if (valueListStatus != null) {
            this.navigation.getPoiDSIHandler().updatePoiSubstringSearchStatus(valueListStatus);
        }
    }

    @Override
    public void rgNotPossible(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgNotPossible() - got error code %1 !", (long)n);
        this.navigation.getMapInterface().abortRouteCalculation(true);
        this.navigation.getNavigationStartup().rgNotPossible(n);
        this.navigation.getClusterService().setRouteGuidanceAborted();
        this.navigation.getRouteDSIHandler().rgNotPossible(n);
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        int n = calculatedRouteListElementArray == null ? 0 : calculatedRouteListElementArray.length;
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgCalculatedRoutes() - length: %1 ", (long)n);
        this.env.getContainer().setCalculatedRoutes(calculatedRouteListElementArray);
        this.navigation.getMapInterface().updateRgCalculatedRoutes(calculatedRouteListElementArray);
    }

    @Override
    public void updateRgCurrentRoute(Route route) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgCurrentRoute()");
        this.navigation.getRouteDSIHandler().updateRgCurrentRoute(route);
        this.navigation.getInterAppService().updateRgCurrentRoute(route);
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgCurrentRouteOptions()");
        if (routeOptions != null && this.navigation.getRouteCriteriaManager() != null) {
            IRouteCriteria iRouteCriteria = this.navigation.getRouteCriteriaManager().getRouteCriteria();
            iRouteCriteria.setVignetteCountries(routeOptions.getVignetteCountryList());
            this.navigation.getRouteCriteriaManager().setRouteCriteria(iRouteCriteria);
            this.navigation.getRouteCriteriaManager().persistState();
            this.navigation.getMapManager().getRouteCalculationHandler().updateRGCurrentRouteOptions(routeOptions);
            this.navigation.getTmcGateway().updateRouteCriteria(iRouteCriteria);
        }
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgDetailedStreetList() ");
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgStreetList() ");
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgLaneGuidance()");
        this.navigation.getClusterService().updateLaneGuidance(navLaneGuidanceDataArray, bl);
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateBapManeuverDescriptor()");
        this.navigation.getPoiDSIHandler().updateBapManeuverDescriptor(bapManeuverDescriptorArray);
        this.navigation.getClusterService().updateManeuverDescriptor(bapManeuverDescriptorArray);
        this.navigation.getMapInterface().updateBapManeuverDescriptor(bapManeuverDescriptorArray);
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgRouteCostChangeInformation() - entry ");
        this.navigation.getSemidynamicRouteGuidance().updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
        this.navigation.getMapInterface().updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgRouteCostChangeInformation() - exit ");
    }

    @Override
    public void updateRgTimeAfaToDestination(long l) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgTimeAfaToDestination( %1 ) ", l);
        this.env.getContainer().setRgTimeAfaToDestination(l);
        this.navigation.getTmcGateway().refreshTimeToNextAnnouncement();
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgTurnToStreet( %1 ) ", (Object)string);
        this.navigation.getClusterService().updateTurnToStreet(string, bl);
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateRgUnfulfilledRouteOptions() - ignored ");
        }
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRmRouteList() - entry ");
        this.navigation.getTourHandler().updateRmRouteList(navRmRouteListArrayDataArray);
        this.navigation.getIntelliDestAccess().updateRmRoutesPress();
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRmRouteList() - exit ");
    }

    @Override
    public void updateRgiString(short[] sArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRgiString() ");
        this.env.getContainer().setRGIString(sArray);
        this.navigation.getClusterService().updateRGIString(sArray);
    }

    @Override
    public void updateRrdActive(boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRrdActive() - entry ");
        this.env.getContainer().setRRDActive(bl);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRrdActive() - exit ");
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRrdCalculationInfo() - entry ");
        this.navigation.getRrdListener().updateRrdCalculationInfo(rrdCalculationInfoArray);
        this.navigation.getIntelliDestAccess().updateRrdCalculationInfo(rrdCalculationInfoArray);
        this.navigation.getInterAppService().updateRrdCalculationInfo(rrdCalculationInfoArray);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRrdCalculationInfo() - exit ");
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrMemoryUtilization() - entry ");
        this.navigation.getTourHandler().updateTrMemoryUtilization(navTraceMemoryUtilization);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrMemoryUtilization() - exit ");
    }

    @Override
    public void updateTrRecordingState(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrRecordingState() - entry ");
        this.navigation.getTourHandler().updateTrRecordingState(n);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrRecordingState() - exit ");
    }

    @Override
    public void updateTrOperatingMode(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrOperatingMode() - entry ");
        this.navigation.getTourHandler().updateTrOperatingMode(n);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrOperatingMode() - exit ");
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrTraceList() - entry ");
        this.env.getContainer().setTrTraceList(navTraceListDataArray);
        this.navigation.getTourHandler().updateTrTraceList(navTraceListDataArray);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrTraceList() - exit ");
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrDirectionToWaypoint() - entry ");
        this.navigation.getTourHandler().updateTrDirectionToWaypoint(directionToWaypoint);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrDirectionToWaypoint() - exit ");
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrInfoForNextWaypoint() - entry ");
        this.navigation.getTourHandler().updateTrInfoForNextWaypoint(navNextWayPointInfo);
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateTrInfoForNextWaypoint() - exit ");
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liTryBestMatchResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liTryMatchLocationResult() - must not be handled by the default handler!!! ");
    }

    @Override
    public void updateNavstateOfOperation(int n) {
        this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateNavstateOfOperation - state is %1 ", (long)n);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("DefaultDSINavigationMainHandler#updateNavstateOfOperation( ").append(n).append(" )"));
        this.env.getContainer().setNavstateOfOperation(n);
        this.navigation.getOperationManager().updateNavstateOfOperation(n);
    }

    @Override
    public void updateNavMedia(String[] stringArray) {
        this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateNavMedia( %1 )", (Object)stringArray);
        this.env.getContainer().setNavMedia(stringArray);
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase) {
        this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcCurrentNavDataBase( %1 ) ", (Object)navDataBase);
        this.env.getContainer().setNavDataBase(navDataBase);
        this.env.getChoiceModel(2065434112).setValue(Util.mountPathToMediumID(navDataBase.getPath()));
    }

    @Override
    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateRenderingInfoProvider( %1 ) ", (Object)renderingInfoProvider);
        this.navigation.getIconHandler().setRenderingInfoProvider(renderingInfoProvider);
        if (this.navigation.getMapManager() != null) {
            this.navigation.getMapManager().getSatelliteMapsMediator().getMmuSatellitemapsmanagerFSM().setRenderingInfoProvider(renderingInfoProvider);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#rgStartGuidanceCalculatedRouteByUIDResult( %1, %2 ) ", (Object)navSegmentID, (long)n);
        this.navigation.getMapInterface().rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
        this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateNavDbRegionsState( %1, %2 ) ", (long)n, (long)n2);
        if (this.navigation != null && this.navigation.getDbIncompleteController() != null) {
            this.navigation.getDbIncompleteController().updateNavDbRegionsState(n, stringArray, n2);
        }
    }

    @Override
    public void updateMapIntegrationState(int n) {
        this.env.getLogChannel().log(-2137614336, "DefaultDSINavigationMainHandler#updateMapIntegrationState( %1 ) ", (long)n);
        if (null != this.navigation && null != this.navigation.getAsiaDbPartialMapUpdateController()) {
            this.navigation.getAsiaDbPartialMapUpdateController().updateMapIntegrationState(n);
        } else if (null == this.navigation) {
            this.env.getLogChannel().log(-1601830656, "DefaultDSINavigationMainHandler#updateMapIntegrationState( %1 ) nulled navigation!", (long)n);
        } else {
            this.env.getLogChannel().log(-1601830656, "DefaultDSINavigationMainHandler#updateMapIntegrationState AsiaDbPartialMapUpdateController=%1", (Object)this.navigation.getAsiaDbPartialMapUpdateController());
        }
    }

    @Override
    public void updateClockAdjusted(boolean bl) {
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
    }

    @Override
    public void responseAudioTrigger(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#responseAudioTrigger()");
        this.navigation.getAudioStateMachine().responseAudioTrigger(n);
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liCurrentState() - must not be handled by default handler!!!");
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liGetLastStateHistoryEntryResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liGetLastCityHistoryEntryResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liGetLastStreetHistoryEntryResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liLastCityAndStreetHistoryResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liStripLocationResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liValueListFileStatus() - must not be handled by default handler!!!");
    }

    @Override
    public void liValueListOutputMethod(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liValueListOutputMethod() - must not be handled by default handler!!!");
    }

    @Override
    public void rgException(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgException() - must not be handled by default handler!!!");
    }

    @Override
    public void rgStartGuidanceRouteResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgStartGuidanceRouteResult() - must not be handled by default handler!!!");
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgStartGuidanceCalculatedRouteResult() - must not be handled by default handler!!!");
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#soPosPositionDescriptionVehicleResult() - must not be handled by default handler!!!");
    }

    @Override
    public void updateCityVignettes(int[] nArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateCityVignettes() - ignored");
        }
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateDmFlagDestination() - ignored");
        }
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateLiStateHistory()");
        this.navigation.getCityHistory().updateLastState(lIStateHistoryEntryArray);
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateLiCityHistory()");
        this.navigation.getCityHistory().updateLastCity(lICityHistoryEntryArray);
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateLiCountryForCityAndStreetHistory( %1 ) - ignored", (Object)string);
        }
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateLiStreetHistory()");
        this.navigation.getCityHistory().updateLastStreet(lIStreetHistoryEntryArray);
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateRgPoiInfoCalculationHorizon( %1 ) - ignored", l);
        }
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateRgRouteProperties( %1 ) - ignored", (Object)routeProperties);
        }
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateRgTurnListCalculationHorizon( %1 ) - ignored", l);
        }
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liSetCountryForCityAndStreetHistoryResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liHistoryResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liHistoryResult() - must not be handled by default handler!!!");
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#ehGetAllCategoriesResult() - must not be handled by default handler!!!");
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#ehGetAllBrandsOfCategoryResult() - must not be handled by default handler!!!");
    }

    @Override
    public void ehResult(int n, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#ehResult() - must not be handled by default handler!!!");
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#updateEtcAvailableNavDataBases() - must not be handled by default handler!!!");
    }

    @Override
    public void blockAreaResult(long l, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#blockAreaResult() - must not be handled by default handler!!!");
    }

    @Override
    public void blockRoadSegmentsResult(long l, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#blockRoadSegmentsResult() - must not be handled by default handler!!!");
    }

    @Override
    public void blockRouteBasedOnLengthResult(long l, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#blockRouteBasedOnLengthResult() - must not be handled by default handler!!!");
    }

    @Override
    public void blockRouteSegmentsResult(long l, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#blockRouteSegmentsResult() - must not be handled by default handler!!!");
    }

    @Override
    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#combinedRouteListResult() - must not be handled by default handler!!!");
    }

    @Override
    public void deleteBlockResult(long[] lArray, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#deleteBlockResult() - must not be handled by default handler!!!");
    }

    @Override
    public void persistBlockResult(long[] lArray, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#persistBlockResult() - must not be handled by default handler!!!");
    }

    @Override
    public void setBlockDescriptionResult(long[] lArray, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#setBlockDescriptionResult() - must not be handled by default handler!!!");
    }

    @Override
    public void updateListOfBlocks(BlockElement[] blockElementArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateListOfBlocks()");
        this.navigation.getSimpleDetourHandler().updateListOfBlocks(blockElementArray);
    }

    @Override
    public void updateNaviCoreAvailableToSetBlocks(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateNaviCoreAvailableToSetBlocks( %1 )", (long)n);
        this.navigation.getSimpleDetourHandler().updateNaviCoreAvailableToSetBlocks(n);
    }

    @Override
    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateMaximumLengthOfBlockRouteBasedOnLength( %1 )", (long)n);
        this.navigation.getSimpleDetourHandler().updateMaximumLengthOfBlockRouteBasedOnLength(n);
    }

    @Override
    public void windowChanged(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#windowChanged( %1 )", (long)n);
        this.navigation.getRMLDSIHandler().windowChanged(n);
    }

    @Override
    public void updateElementsTotal(long l, long l2, int n) {
        this.navigation.getRMLDSIHandler().updateElementsTotal(l, l2, n);
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray) {
        int n = countryInfoArray == null ? 0 : countryInfoArray.length;
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateCountryInfo() - length: %1 ", (long)n);
        this.env.getContainer().setCountryInfo(countryInfoArray);
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateBapTurnToInfo()");
        this.navigation.getClusterService().updateBapTurnToInfo(bapTurnToInfoArray);
    }

    @Override
    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#poiInformationResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liGetViaPointListResult() - must not be handled by default handler!!!");
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liSelectViaPointResult() - must not be handled by default handler!!!");
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#requestCountryInfoResult() - must not be handled by default handler!!!");
    }

    @Override
    public void setTrailerStatusResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#setTrailerStatusResult() - must not be handled by default handler!!!");
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#setUserDefinedPOIsResult() - must not be handled by default handler!!!");
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#setVehicleConsumptionInfoResult() - must not be handled by default handler!!!");
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "DefaultDSINavigationMainHandler#updateStyleDBPaths( %1 ) - ignored", (Object)Util.formatStringArray(stringArray));
        }
    }

    @Override
    public void updateRouteResumePossible(boolean bl) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateRouteResumePossible( %1 )", bl);
        this.env.getContainer().setRouteResumePossible(bl);
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liGetSpellableCharactersResult() - must not be handled by default handler!!!");
    }

    @Override
    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#getSpellableCharactersResult() - must not be handled by default handler!!!");
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateEtcAvailablePersonalPOIDataBases( %1, %2 )", (Object)navDataBaseArray, (long)n);
        if (n != 1) {
            return;
        }
        this.navigation.getPoiDSIHandler().updateEtcAvailablePersonalPOIDataBases(navDataBaseArray);
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#deletePersonalPOIDataBasesResult( %1 ) - must not be handled by default handler!!!", (long)n);
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updatePersonalPOISearchStatus( %1, %2 )", (long)n, (long)n2);
        if (n2 != 1) {
            return;
        }
        this.env.getContainer().setPersonalPOISearchStatus(n);
        this.navigation.getPoiDSIHandler().updatePersonalPOISearchStatus(n);
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetLocationOnRouteResult( ) - unexpected call!!!");
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetRouteBoundingRectangleResult( ) - unexpected call!!!");
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#rgStartRubberbandManipulationResult( ) - resultCode: %1 ", (long)n);
        this.navigation.getMapManager().getRouteCalculationHandler().rgStartRubberbandManipulationResult(n);
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetRubberBandPointPositionResult( ) - unexpected call!!!");
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#rgGetRubberBandPointPositionResult( ) - unexpected call!!!");
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray) {
        if (null != this.navigation.getPoiService().getPoiWarningManager()) {
            if (this.env.getPoiApproachWarningLogChannel().isDebug2()) {
                this.env.getPoiApproachWarningLogChannel().log(14808325, "DefaultDSINavigationMainHandler#updatePOIsEnteringProximityRange()");
            }
            this.navigation.getPoiService().getPoiWarningManager().poiEntersProximityRange(navLocationArray);
        } else {
            this.env.getPoiApproachWarningLogChannel().log(10000, "DefaultDSINavigationMainHandler#updatePOIsEnteringProximityRange()");
            this.env.getPoiApproachWarningLogChannel().log(10000, "   --> navigation.getPoiService().getPoiWarningManager() is NULL!");
        }
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#lispGetLocationFromLiValueListResult( ) - unexpected call!!!");
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#poiGetCategoryTypesFromUIdResult( ) - unexpected call!!!");
    }

    @Override
    public void rgResult(int n) {
        this.logChannel.log(-1601830656, "DefaultDSINavigationMainHandler#rgResult( ) - unexpected call!!!");
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        this.logChannel.log(-1601830656, "DefaultDSINavigationMainHandler#rgSwitchToNextPossibleRoadResult( ) - unexpected call!!!");
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#lispGetMatchingNVCResult( ) - unexpected call!!!");
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#lispRequestNVCListResult() - unexpected call!!!");
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#liDisambiguateLocationResult() - unexpected call!!!");
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#triggerEventAudioMessageResult() - unexpected call!!!");
    }

    @Override
    public void updateBapManeuverState(int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateBapManeuverState( %1 ) ", (long)n);
        this.navigation.getClusterService().updateBapManeuverState(n);
        this.navigation.getMapInterface().updateBapManeuverState(n);
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.logChannel.log(-2137614336, "DefaultDSINavigationMainHandler#updateBapManeuverInformation()");
        this.navigation.getPoiDSIHandler().updateBapManeuverDescriptor(bapManeuverDescriptorArray);
        this.navigation.getMapInterface().updateBapManeuverDescriptor(bapManeuverDescriptorArray);
        this.navigation.getClusterService().updateManeuverDescriptor(bapManeuverDescriptorArray, n);
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#poiGetXt9LDBsResult( ) - unexpected call!!!");
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#poiRequestExtendedInfoResult( ) - unexpected call!!!");
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        this.logChannel.log(10000, "DefaultDSINavigationMainHandler#importRouteFromGpxFileResult( ) - unexpected call!!!");
    }
}

