/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.call.CommandCallResponse;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.dsi.AbstractDSINavigationHandler;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$1;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$10;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$100;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$101;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$102;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$103;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$104;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$105;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$106;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$107;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$108;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$109;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$11;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$110;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$111;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$112;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$113;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$114;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$115;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$116;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$117;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$118;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$119;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$12;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$120;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$121;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$122;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$123;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$124;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$125;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$126;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$127;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$128;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$129;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$13;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$130;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$131;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$132;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$133;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$134;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$135;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$136;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$137;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$138;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$139;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$14;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$140;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$141;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$142;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$143;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$144;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$145;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$146;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$147;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$148;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$149;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$15;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$150;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$151;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$152;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$153;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$154;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$155;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$156;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$157;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$158;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$159;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$16;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$160;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$161;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$17;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$18;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$19;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$2;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$20;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$21;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$22;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$23;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$24;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$25;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$26;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$27;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$28;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$29;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$3;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$30;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$31;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$32;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$33;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$34;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$35;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$36;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$37;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$38;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$39;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$4;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$40;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$41;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$42;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$43;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$44;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$45;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$46;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$47;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$48;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$49;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$5;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$50;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$51;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$52;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$53;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$54;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$55;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$56;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$57;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$58;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$59;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$6;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$60;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$61;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$62;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$63;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$64;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$65;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$66;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$67;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$68;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$69;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$7;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$70;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$71;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$72;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$73;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$74;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$75;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$76;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$77;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$78;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$79;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$8;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$80;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$81;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$82;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$83;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$84;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$85;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$86;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$87;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$88;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$89;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$9;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$90;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$91;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$92;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$93;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$94;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$95;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$96;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$97;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$98;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher$99;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import de.audi.tghu.navi.app.dsi.NonDSIFunctionality;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavPriceInfo;
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
import org.dsi.ifc.navigation.DSIBlockingListener;
import org.dsi.ifc.navigation.DSICombinedRouteListListener;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
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
import org.dsi.ifc.tmc.TmcMessage;

public class DSINavigationDispatcher
implements DSINavigationListener,
DSIBlockingListener,
DSICombinedRouteListListener,
NonDSIFunctionality,
ICommandResponseSupplier {
    private final IDSINavigationHandler defaultHandler;
    private final CommandListManager manager;
    private final int dsiType;
    private final String listenerName;
    private final LogChannel logChannel;
    private final DispatcherBase dispatcher;

    public DSINavigationDispatcher(NavigationEnv navigationEnv, CommandListManager commandListManager, IDSINavigationHandler iDSINavigationHandler, int n, DispatcherBase dispatcherBase) {
        this.manager = commandListManager;
        this.defaultHandler = iDSINavigationHandler;
        this.dsiType = n;
        this.listenerName = new StringBuffer().append("DSINavigationDispatcher[").append(DSINavigationManager.dsiTypeToString(n)).append("]").toString();
        this.logChannel = navigationEnv.getDSILogChannel();
        this.dispatcher = dispatcherBase;
    }

    public IDSINavigationHandler getDefaultHandler() {
        return this.defaultHandler;
    }

    public void cleanUp() {
        if (this.defaultHandler instanceof AbstractDSINavigationHandler) {
            ((AbstractDSINavigationHandler)this.defaultHandler).cleanUp();
        }
    }

    private void logEnter(int n, String string) {
        if (n == 14808325 && this.logChannel.isDebug2() || n != 14808325) {
            this.logChannel.log(n, "%1#%2() - enter", (Object)this.listenerName, (Object)string);
        }
    }

    private void logExit(int n, String string) {
        if (n == 14808325 && this.logChannel.isDebug2() || n != 14808325) {
            this.logChannel.log(n, "%1#%2() - exit", (Object)this.listenerName, (Object)string);
        }
    }

    private void logEnter(String string) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#%2() - enter", (Object)this.listenerName, (Object)string);
        }
    }

    private void logExit(String string) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#%2() - exit", (Object)this.listenerName, (Object)string);
        }
    }

    public void propagateDSIData() {
        if (this.defaultHandler instanceof AbstractDSINavigationHandler) {
            this.logChannel.log(-2137614336, "%1#triggerRSEData()", (Object)this.listenerName);
            ((AbstractDSINavigationHandler)this.defaultHandler).propagateDSIData();
        } else {
            this.logChannel.log(10000, "%1#triggerRSEData() - could not trigger handler!", (Object)this.listenerName);
        }
    }

    public AbstractDSINavigationHandler getDSINavigationDefaultHandler() {
        if (this.defaultHandler instanceof AbstractDSINavigationHandler) {
            return (AbstractDSINavigationHandler)this.defaultHandler;
        }
        this.logChannel.log(10000, "%1#getDSINavigationDefaultHandler() - could not get handler!", (Object)this.listenerName);
        return null;
    }

    @Override
    public CommandList getActiveCommandList() {
        CommandList commandList = this.manager.getActiveCommandList();
        return commandList != null && DSINavigationManager.getDSIType(commandList) == this.dsiType ? commandList : null;
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultHandler;
    }

    @Override
    public String getHandlerName() {
        return this.listenerName;
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logEnter("asyncException");
        CommandResponse.execute(this, new DSINavigationDispatcher$1(this, n, string, n2));
        this.logExit("asyncException");
    }

    @Override
    public void responseAudioTrigger(int n) {
        this.logEnter("responseAudioTrigger");
        CommandResponse.execute(this, new DSINavigationDispatcher$2(this, n));
        this.logExit("responseAudioTrigger");
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
        this.logEnter(-2137614336, "updateDistanceToNextManeuver");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$3(this, distanceToNextManeuver));
        }
        this.logExit(14808325, "updateDistanceToNextManeuver");
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        this.logEnter("dmLastDestinationsGetResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$4(this, l, navLocation));
        this.logExit("dmLastDestinationsGetResult");
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
        this.logEnter("dmRecentRoutesGetResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$5(this, l, route));
        this.logExit("dmRecentRoutesGetResult");
    }

    @Override
    public void dmResult(long l, long l2) {
        this.logEnter("dmResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$6(this, l, l2));
        this.logExit("dmResult");
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logEnter("liCurrentState");
        CommandResponse.executeTryCatch(this, new DSINavigationDispatcher$7(this, navLocation, nArray, nArray2, l), "liCurrentState");
        this.logExit("liCurrentState");
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.logEnter("liGetLocationDescriptionTransformResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new DSINavigationDispatcher$8(this, navLocation));
        this.logExit("liGetLocationDescriptionTransformResult");
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        this.logEnter("liGetStateResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$9(this, lISpellerData));
        this.logExit("liGetStateResult");
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        this.logEnter("liStripLocationResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$10(this, navLocation));
        this.logExit("liStripLocationResult");
    }

    @Override
    public void liResult(long l) {
        this.logEnter("liResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$11(this, l));
        this.logExit("liResult");
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        LIValueList lIValueList2;
        this.logEnter("liValueList");
        if (lIValueList != null && lIValueList.getList() != null) {
            if (l < (long)lIValueList.getList().length) {
                LIValueListElement[] lIValueListElementArray = new LIValueListElement[(int)l];
                System.arraycopy((Object)lIValueList.getList(), 0, (Object)lIValueListElementArray, 0, (int)l);
                lIValueList2 = new LIValueList(lIValueListElementArray, lIValueList.isHasNextPage(), lIValueList.isHasPrevPage());
            } else {
                lIValueList2 = lIValueList;
            }
        } else {
            lIValueList2 = lIValueList;
            this.logChannel.log(-1601830656, "%1#liValueList() - either lispValueList or lispValueList.getList() is null! lispValueListCount = %2", (Object)this.listenerName, l);
        }
        CommandResponse.executeTryCatch(this, new DSINavigationDispatcher$12(this, lIValueList2, l), "liValueList");
        this.logExit("liValueList");
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logEnter("lispUpdateSpellerResult");
        CommandResponse.executeTryCatch(this, new DSINavigationDispatcher$13(this, string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4, l), "lispUpdateSpellerResult");
        this.logExit("lispUpdateSpellerResult");
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logEnter("liGetLastCityHistoryEntryResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$14(this, navLocation, bl));
        this.logExit("liGetLastCityHistoryEntryResult");
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logEnter("liGetLastStreetHistoryEntryResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$15(this, navLocation, bl));
        this.logExit("liGetLastStreetHistoryEntry");
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        this.logEnter("liLastCityAndStreetHistoryResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$16(this, l));
        this.logExit("liLastCityAndStreetHistoryResult");
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
        this.logEnter("liValueListFileStatus");
        CommandResponse.execute(this, new DSINavigationDispatcher$17(this, n, n2, string));
        this.logExit("liValueListFileStatus");
    }

    @Override
    public void liValueListOutputMethod(int n) {
        this.logEnter("liValueListOutputMethod");
        CommandResponse.execute(this, new DSINavigationDispatcher$18(this, n));
        this.logExit("liValueListOutputMethod");
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        this.logEnter("liSetCountryForCityAndStreetHistoryResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$19(this, n));
        this.logExit("liSetCountryForCityAndStreetHistoryResult");
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        this.logEnter("poiValueList");
        CommandResponse.execute(this, new DSINavigationDispatcher$20(this, lIValueList, l));
        this.logExit("poiValueList");
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        this.logEnter("rmRouteAddResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$21(this, n, l));
        this.logExit("rmRouteAddResult");
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
        this.logEnter("rmRouteDeleteAllResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$22(this, n));
        this.logExit("rmRouteDeleteAllResult");
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        this.logEnter("rmRouteDeleteResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$23(this, n));
        this.logExit("rmRouteDeleteResult");
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
        this.logEnter("rmRouteGetResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$24(this, n, route));
        this.logExit("rmRouteGetResult");
    }

    @Override
    public void rmRouteRenameResult(int n) {
        this.logEnter("rmRouteRenameResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$25(this, n));
        this.logExit("rmRouteRenameResult");
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
        this.logEnter("rmRouteReplaceResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$26(this, n, l, n2));
        this.logExit("rmRouteReplaceResult");
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
        this.logEnter("soPosPositionDescriptionVehicleResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$27(this, navLocation));
        this.logExit("soPosPositionDescriptionVehicleResult");
    }

    @Override
    public void translateRouteResult(Route route) {
        this.logEnter("translateRouteResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$28(this, route));
        this.logExit("translateRouteResult");
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
        this.logEnter("trDeleteAllTracesResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$29(this, n, n2));
        this.logExit("trDeleteAllTracesResult");
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
        this.logEnter("trDeleteTraceResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$30(this, n, n2));
        this.logExit("trDeleteTraceResult");
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
        this.logEnter("trRenameTraceResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$31(this, n, n2));
        this.logExit("trRenameTraceResult");
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
        this.logEnter("trStartTraceRecordingResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$32(this, n, l, n2));
        this.logExit("trStartTraceRecordingResult");
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
        this.logEnter("trStopTraceRecordingResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$33(this, n, l, n2));
        this.logExit("trStopTraceRecordingResult");
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        this.logEnter("trStoreTraceResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$34(this, n, navSegmentID, n2));
        this.logExit("trStoreTraceResult");
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
        this.logEnter("rgSetRouteGuidanceModeResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$35(this));
        this.logExit("rgSetRouteGuidanceModeResult");
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
        this.logEnter("rgStartGuidanceCalculatedRouteResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$36(this, n));
        this.logExit("rgStartGuidanceCalculatedRouteResult");
    }

    @Override
    public void updateAfaMode(int n, int n2) {
        this.logEnter("updateAfaMode");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$37(this, n));
        }
        this.logExit("updateAfaMode");
    }

    @Override
    public void updateAfaSpeaking(boolean bl, int n) {
        this.logEnter("updateAfaSpeaking");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$38(this, bl));
        }
        this.logExit("updateAfaSpeaking");
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        this.logEnter("updateDmLastDestinationsList");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$39(this, lDListElementArray));
        }
        this.logExit("updateDmLastDestinationsList");
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
        this.logEnter("updateDmRecentRoutesList");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$40(this, rRListElementArray));
        }
        this.logExit("updateDmRecentRoutesList");
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation, int n) {
        this.logEnter("updateDmFlagDestination");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$41(this, navLocation));
        }
        this.logExit("updateDmFlagDestination");
    }

    @Override
    public void updateEtcDemoModeState(boolean bl, int n) {
        this.logEnter("updateEtcDemoModeState");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$42(this, bl));
        }
        this.logExit("updateEtcDemoModeState");
    }

    @Override
    public void updateEtcMetricSystem(int n, int n2) {
        this.logEnter("updateEtcMetricSystem");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$43(this, n));
        }
        this.logExit("updateEtcMetricSystem");
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
        this.logEnter("etcSensorDataReplayRoute");
        CommandResponse.execute(this, new DSINavigationDispatcher$44(this, route));
        this.logExit("etcSensorDataReplayRoute");
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
        this.logEnter("etcSensorDataReplayGuidance");
        CommandResponse.execute(this, new DSINavigationDispatcher$45(this, bl));
        this.logExit("etcSensorDataReplayGuidance");
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
        this.logEnter("updateEtcVersionInfo");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$46(this, navVersionInfo));
        }
        this.logExit("updateEtcVersionInfo");
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
        this.logEnter("updateEtcCurrentNavDataBase");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$47(this, navDataBase));
        }
        this.logExit("updateEtcCurrentNavDataBase");
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.logEnter("updateEtcAvailableNavDataBases");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$48(this, navDataBaseArray));
        }
        this.logExit("updateEtcAvailableNavDataBases");
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl, int n) {
        this.logEnter("updateLispIsSpellerActive");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$49(this, bl));
        }
        this.logExit("updateLispIsSpellerActive");
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
        this.logEnter("updateLiCityHistory");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$50(this, lICityHistoryEntryArray));
        }
        this.logExit("updateLiCityHistory");
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
        this.logEnter("updateLiStreetHistory");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$51(this, lIStreetHistoryEntryArray));
        }
        this.logExit("updateLiStreetHistory");
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
        this.logEnter("updateLiCountryForCityAndStreetHistory");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$52(this, string));
        }
        this.logExit("updateLiCountryForCityAndStreetHistory");
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
        this.logEnter("updatePoiSubstringSearchStatus");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$53(this, valueListStatus));
        }
        this.logExit("updatePoiSubstringSearchStatus");
    }

    @Override
    public void rgNotPossible(int n) {
        this.logEnter("rgNotPossible");
        CommandResponse.execute(this, new DSINavigationDispatcher$54(this, n));
        this.logExit("rgNotPossible");
    }

    @Override
    public void rgException(int n) {
        this.logEnter("rgException");
        CommandResponse.execute(this, new DSINavigationDispatcher$55(this, n));
        this.logExit("rgException");
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.logEnter("updateBapManeuverDescriptor");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$56(this, bapManeuverDescriptorArray));
        }
        this.logExit("updateBapManeuverDescriptor");
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.logEnter(14808325, "updateRgInfoForNextDestination");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$57(this, rgInfoForNextDestination));
        }
        this.logExit(14808325, "updateRgInfoForNextDestination");
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
        this.logEnter("updateRgRouteProperties");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$58(this, routeProperties));
        }
        this.logExit("updateRgRouteProperties");
    }

    @Override
    public void updateRgActive(boolean bl, int n) {
        this.logEnter("updateRgActive");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$59(this, bl));
        }
        this.logExit("updateRgActive");
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        this.logEnter("updateRgCalculatedRoutes");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$60(this, calculatedRouteListElementArray));
        }
        this.logExit("updateRgCalculatedRoutes");
    }

    @Override
    public void updateRgCurrentRoute(Route route, int n) {
        this.logEnter("updateRgCurrentRoute");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$61(this, route));
        }
        this.logExit("updateRgCurrentRoute");
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
        this.logEnter("updateRgCurrentRouteOptions");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$62(this, routeOptions));
        }
        this.logExit("updateRgCurrentRouteOptions");
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        this.logEnter("updateRgDestinationInfo");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$63(this, navRouteListDataArray));
        }
        this.logExit("updateRgDestinationInfo");
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
        this.logEnter("updateRgLaneGuidance");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$64(this, navLaneGuidanceDataArray, bl));
        }
        this.logExit("updateRgLaneGuidance");
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        this.logEnter("updateRgPoiInfo");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$65(this, navPoiInfoArray));
        }
        this.logExit("updateRgPoiInfo");
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
        this.logEnter("updateRgPoiInfoCalculationHorizon");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$66(this, l));
        }
        this.logExit("updateRgPoiInfoCalculationHorizon");
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l, int n) {
        this.logEnter("updateRgTurnListCalculationHorizon");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$67(this, l));
        }
        this.logExit("updateRgTurnListCalculationHorizon");
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        this.logEnter("updateRgStreetList");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$68(this, navRouteListDataArray));
        }
        this.logExit("updateRgStreetList");
    }

    @Override
    public void updateRgTimeAfaToDestination(long l, int n) {
        this.logEnter("updateRgTimeAfaToDestination");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$69(this, l));
        }
        this.logExit("updateRgTimeAfaToDestination");
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
        this.logEnter("updateRgTurnList");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$70(this, turnListElementArray));
        }
        this.logExit("updateRgTurnList");
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl, int n) {
        this.logEnter("updateRgTurnToStreet");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$71(this, string, bl));
        }
        this.logExit("updateRgTurnToStreet");
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
        this.logEnter("updateRgUnfulfilledRouteOptions");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$72(this, routeOptions));
        }
        this.logExit("updateRgUnfulfilledRouteOptions");
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
        this.logEnter("updateRmRouteList");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$73(this, navRmRouteListArrayDataArray));
        }
        this.logExit("updateRmRouteList");
    }

    @Override
    public void updateRrdActive(boolean bl, int n) {
        this.logEnter("updateRrdActive");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$74(this, bl));
        }
        this.logExit("updateRrdActive");
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
        this.logEnter("updateRrdCalculationInfo");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$75(this, rrdCalculationInfoArray));
        }
        this.logExit("updateRrdCalculationInfo");
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition, int n) {
        this.logEnter(14808325, "updateSoPosPosition");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$76(this, posPosition));
        }
        this.logExit(14808325, "updateSoPosPosition");
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        this.logEnter("updateSoPosPositionDescription");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$77(this, navLocation, bl));
        }
        this.logExit("updateSoPosPositionDescription");
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
        this.logEnter("updateTrMemoryUtilization");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$78(this, navTraceMemoryUtilization));
        }
        this.logExit("updateTrMemoryUtilization");
    }

    @Override
    public void updateTrRecordingState(int n, int n2) {
        this.logEnter("updateTrRecordingState");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$79(this, n));
        }
        this.logExit("updateTrRecordingState");
    }

    @Override
    public void updateTrOperatingMode(int n, int n2) {
        this.logEnter("updateTrOperatingMode");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$80(this, n));
        }
        this.logExit("updateTrOperatingMode");
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
        this.logEnter("updateTrTraceList");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$81(this, navTraceListDataArray));
        }
        this.logExit("updateTrTraceList");
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
        this.logEnter("updateTrDirectionToWaypoint");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$82(this, directionToWaypoint));
        }
        this.logExit("updateTrDirectionToWaypoint");
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
        this.logEnter("rmMakeRoutePersistentResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$83(this, l));
        this.logExit("rmMakeRoutePersistentResult");
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        this.logEnter("updateAudioRequest");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$84(this, n));
        }
        this.logExit("updateAudioRequest");
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        this.logEnter("updateRgDetailedStreetList");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$85(this, navRouteListDataArray));
        }
        this.logExit("updateRgDetailedStreetList");
    }

    @Override
    public void updateRmPersistentRoute(Route route, int n) {
        this.logEnter("updateRmPersistentRoute");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$86(this, route));
        }
        this.logExit("updateRmPersistentRoute");
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.logEnter("liTryBestMatchResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$87(this, tryBestMatchResultDataArray));
        this.logExit("liTryBestMatchResult");
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.logEnter("liTryMatchLocationResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new DSINavigationDispatcher$88(this, tryMatchLocationResultDataArray));
        this.logExit("liTryMatchLocationResult");
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
        this.logEnter("updateRgRouteCostChangeInformation");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$89(this, rgRouteCostChangeInformation));
        }
        this.logExit("updateRgRouteCostChangeInformation");
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.logEnter("locationToStreamResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new DSINavigationDispatcher$90(this, bl, byArray));
        this.logExit("locationToStreamResult");
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        this.logEnter("streamToLocationResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new DSINavigationDispatcher$91(this, bl, navLocation));
        this.logExit("streamToLocationResult");
    }

    @Override
    public void updateRgRouteCalculationState(int n, int n2) {
        this.logEnter("updateRgRouteCalculationState");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$92(this, n));
        }
        this.logExit("updateRgRouteCalculationState");
    }

    @Override
    public void updateNavstateOfOperation(int n, int n2) {
        this.logEnter("updateNavstateOfOperation");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$93(this, n));
        }
        this.logExit("updateNavstateOfOperation");
    }

    @Override
    public void updateNavMedia(String[] stringArray, int n) {
        this.logEnter("updateNavMedia");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$94(this, stringArray));
        }
        this.logExit("updateNavMedia");
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        this.logEnter("updateAvailableLanguages");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$95(this, stringArray));
        }
        this.logExit("updateAvailableLanguages");
    }

    @Override
    public void updateLanguage(String string, int n) {
        this.logEnter("updateLanguage");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$96(this, string));
        }
        this.logExit("updateLanguage");
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l, int n) {
        this.logEnter("updateEtcLanguageLoadProgress");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$97(this, l));
        }
        this.logExit("updateEtcLanguageLoadProgress");
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n, int n2) {
        this.logEnter("updateEtcLanguageLoadStatus");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$98(this, n));
        }
        this.logExit("updateEtcLanguageLoadStatus");
    }

    @Override
    public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.logEnter("updateRenderingInfoProvider");
        CommandResponse.execute(this, new DSINavigationDispatcher$99(this, renderingInfoProvider));
        this.logExit("updateRenderingInfoProvider");
    }

    @Override
    public void updateClockAdjusted(boolean bl) {
        this.logEnter("updateClockAdjusted");
        CommandResponse.execute(this, new DSINavigationDispatcher$100(this, bl));
        this.logExit("updateClockAdjusted");
    }

    public void updateCityVignettes(int[] nArray, int n) {
        this.logEnter("updateCityVignettes");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$101(this, nArray));
        }
        this.logExit("updateCityVignettes");
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logEnter("fireTimer");
        CommandResponse.execute(this, new DSINavigationDispatcher$102(this, timer));
        this.logExit("fireTimer");
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        this.logEnter("ehGetAllCategoriesResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$103(this, n, categoryArray, n2));
        this.logExit("ehGetAllCategoriesResult");
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        this.logEnter("ehGetAllBrandsOfCategoryResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$104(this, n, n2, brandArray, n3));
        this.logExit("ehGetAllBrandsOfCategoryResult");
    }

    @Override
    public void ehResult(int n, int n2) {
        this.logEnter("ehResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$105(this, n, n2));
        this.logExit("ehResult");
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
        this.logEnter("updateCountryInfo");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$106(this, countryInfoArray));
        }
        this.logExit("updateCountryInfo");
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
        this.logEnter("updateBapTurnToInfo");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$107(this, bapTurnToInfoArray));
        }
        this.logExit("updateBapTurnToInfo");
    }

    @Override
    public void updateRgiString(short[] sArray, int n) {
        this.logEnter("updateRgiString");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$108(this, sArray));
        }
        this.logExit("updateRgiString");
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        this.logEnter("liGetViaPointListResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$109(this, n, viaPointListElementArray, n2, n3));
        this.logExit("liGetViaPointListResult");
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        this.logEnter("liSelectViaPointResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$110(this, navLocation, n));
        this.logExit("liSelectViaPointResult");
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        this.logEnter("requestCountryInfoResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$111(this, countryInfo, n));
        this.logExit("requestCountryInfoResult");
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray, int n) {
        this.logEnter("updateStyleDBPaths");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$112(this, stringArray));
        }
        this.logExit("updateStyleDBPaths");
    }

    @Override
    public void updateRouteResumePossible(boolean bl, int n) {
        this.logEnter("updateRouteResumePossible");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$113(this, bl));
        }
        this.logExit("updateRouteResumePossible");
    }

    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
        this.logEnter("getSpellableCharactersResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$114(this, string, string2, n, string3, n2));
        this.logExit("getSpellableCharactersResult");
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
        this.logEnter("liGetSpellableCharactersResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$115(this, navLocation, n, string, n2));
        this.logExit("liGetSpellableCharactersResult");
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void etcGetCountryAbbreviationResult(String string, long l) {
    }

    @Override
    public void languageSpellableCharactersResult(String string) {
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
    }

    @Override
    public void importFileResult(int n, boolean bl) {
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
    public void setRemainingRangeOfVehicleResult(int n) {
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
        this.logEnter("setUserDefinedPOIsResult");
        this.logExit("setUserDefinedPOIsResult");
    }

    @Override
    public void setTrailerStatusResult(int n) {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        this.logEnter("rgStartGuidanceCalculatedRouteByUIDResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$116(this, navSegmentID, n));
        this.logExit("rgStartGuidanceCalculatedRouteByUIDResult");
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
        this.logEnter("updatePOIsEnteringProximityRange");
        CommandResponse.execute(this, new DSINavigationDispatcher$117(this, navLocationArray));
        this.logExit("updatePOIsEnteringProximityRange");
    }

    public void updatePOIsInsideProximityRange(NavLocation[] navLocationArray, int n) {
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.logEnter("updateEtcAvailablePersonalPOIDataBases");
        CommandResponse.execute(this, new DSINavigationDispatcher$118(this, navDataBaseArray, n));
        this.logExit("updateEtcAvailablePersonalPOIDataBases");
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
        this.logEnter("updatePersonalPOISearchStatus");
        CommandResponse.execute(this, new DSINavigationDispatcher$119(this, n, n2));
        this.logExit("updatePersonalPOISearchStatus");
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
        this.logEnter("deletePersonalPOIDataBasesResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$120(this, n));
        this.logExit("deletePersonalPOIDataBasesResult");
    }

    @Override
    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
        this.logChannel.log(-1601830656, "%1#createNavLocationOfPOIUIDResult() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void setVehicleFuelTypeResult(int n, int n2) {
        this.logChannel.log(-1601830656, "%1#setVehicleFuelTypeResult() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
        this.logEnter("updateLiStateHistory");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$121(this, lIStateHistoryEntryArray));
        }
        this.logExit("updateLiStateHistory");
    }

    @Override
    public void liHistoryResult(int n) {
        this.logEnter("liHistoryResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$122(this, n));
        this.logExit("liHistoryResult");
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logEnter("liGetLastStateHistoryEntryResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$123(this, navLocation, bl));
        this.logExit("liGetLastStateHistoryEntryResult");
    }

    @Override
    public void setNavInternalDataToFactorySettingsResult(int n) {
        this.logChannel.log(-1601830656, "%1#setNavInternalDataToFactorySettingsResult() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        this.logEnter("rgSwitchToNextPossibleRoadResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$124(this, bl));
        this.logExit("rgSwitchToNextPossibleRoadResult");
    }

    @Override
    public void blockAreaResult(long l, int n) {
        this.logEnter("blockAreaResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$125(this, l, n));
        this.logExit("blockAreaResult");
    }

    @Override
    public void blockRoadSegmentsResult(long l, int n) {
        this.logEnter("blockRoadSegmentsResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$126(this, l, n));
        this.logExit("blockRoadSegmentsResult");
    }

    @Override
    public void blockRouteBasedOnLengthResult(long l, int n) {
        this.logEnter("blockRouteBasedOnLengthResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$127(this, l, n));
        this.logExit("blockRouteBasedOnLengthResult");
    }

    @Override
    public void blockRouteSegmentsResult(long l, int n) {
        this.logEnter("blockRouteSegmentsResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$128(this, l, n));
        this.logExit("blockRouteSegmentsResult");
    }

    @Override
    public void deleteBlockResult(long[] lArray, int n) {
        this.logEnter("deleteBlockResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$129(this, lArray, n));
        this.logExit("deleteBlockResult");
    }

    @Override
    public void persistBlockResult(long[] lArray, int n) {
        this.logEnter("persistBlockResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$130(this, lArray, n));
        this.logExit("persistBlockResult");
    }

    @Override
    public void setBlockDescriptionResult(long[] lArray, int n) {
        this.logEnter("setBlockDescriptionResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$131(this, lArray, n));
        this.logExit("setBlockDescriptionResult");
    }

    @Override
    public void updateListOfBlocks(BlockElement[] blockElementArray, int n) {
        this.logEnter("updateListOfBlocks");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$132(this, blockElementArray));
        }
        this.logExit("updateListOfBlocks");
    }

    @Override
    public void updateMaximumDimensionsOfBlockedArea(int n, int n2, int n3) {
        this.logChannel.log(-1601830656, "%1#updateMaximumDimensionsOfBlockedArea() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n, int n2) {
        this.logEnter("updateMaximumLengthOfBlockRouteBasedOnLength");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$133(this, n));
        }
        this.logExit("updateMaximumLengthOfBlockRouteBasedOnLength");
    }

    @Override
    public void updateMaximumNumberOfBlockedAreas(int n, int n2) {
        this.logChannel.log(-1601830656, "%1#updateMaximumNumberOfBlockedAreas() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void updateMaximumNumberOfBlockedRoadSegments(int n, int n2) {
        this.logChannel.log(-1601830656, "%1#updateMaximumNumberOfBlockedRoadSegments() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void updateMaximumNumberOfBlockedRouteSegments(int n, int n2) {
        this.logChannel.log(-1601830656, "%1#updateMaximumNumberOfBlockedRouteSegments() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void updateMaximumSegmentLengthOfBlockedRouteSegment(int n, int n2) {
        this.logChannel.log(-1601830656, "%1#updateMaximumSegmentLengthOfBlockedRouteSegment() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void updateNaviCoreAvailableToSetBlocks(int n, int n2) {
        this.logEnter("updateNaviCoreAvailableToSetBlocks");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$134(this, n));
        }
        this.logExit("updateNaviCoreAvailableToSetBlocks");
    }

    @Override
    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        this.logEnter("combinedRouteListResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$135(this, l, combinedRouteListElementArray, n));
        this.logExit("combinedRouteListResult");
    }

    @Override
    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
        this.logEnter("poiInformationResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$136(this, navPoiInfo, n));
        this.logExit("poiInformationResult");
    }

    @Override
    public void trafficInformationResult(TmcMessage tmcMessage, int n) {
        this.logChannel.log(-1601830656, "%1#trafficInformationResult() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void updateElementsTotal(long l, long l2, int n) {
        this.logEnter("updateElementsTotal");
        CommandResponse.execute(this, new DSINavigationDispatcher$137(this, l, l2, n));
        this.logExit("updateElementsTotal");
    }

    @Override
    public void windowChanged(int n) {
        this.logEnter("windowChanged");
        CommandResponse.execute(this, new DSINavigationDispatcher$138(this, n));
        this.logExit("windowChanged");
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
        this.logEnter("updateNavDbRegionsState");
        CommandResponse.execute(this, new DSINavigationDispatcher$139(this, n, stringArray, n2));
        this.logExit("updateNavDbRegionsState");
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        this.logEnter("getBoundingRectangleOfCombinedRouteListElementsResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$140(this, lArray, navRectangle));
        this.logExit("getBoundingRectangleOfCombinedRouteListElementsResult");
    }

    @Override
    public void getBoundingRectangleOfBlocksResult(long[] lArray, NavRectangle navRectangle) {
        this.logChannel.log(-1601830656, "%1#getBoundingRectangleOfBlocksResult() - unexpected call!", (Object)this.listenerName);
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        this.logEnter("trImportTrailsResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$141(this, navSegmentIDArray, n));
        this.logExit("trImportTrailsResult");
    }

    @Override
    public void trExportTrailsResult(int n) {
        this.logEnter("trExportTrailsResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$142(this, n));
        this.logExit("trExportTrailsResult");
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
        this.logEnter("updateTrInfoForNextWaypoint");
        if (n == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$143(this, navNextWayPointInfo));
        }
        this.logExit("updateTrInfoForNextWaypoint");
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
        this.logEnter("rgStartRubberbandManipulationResult");
        if (n == 0) {
            CommandResponse.execute(this, new DSINavigationDispatcher$144(this, n));
        }
        this.logExit("rgStartRubberbandManipulationResult");
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
        this.logEnter("rgGetRouteBoundingRectangleResult");
        if (n == 0) {
            CommandResponse.execute(this, new DSINavigationDispatcher$145(this, navRectangle));
        }
        this.logExit("rgGetRouteBoundingRectangleResult");
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
        this.logEnter("rgGetLocationOnRouteResult");
        if (n == 0) {
            CommandResponse.execute(this, new DSINavigationDispatcher$146(this, navLocation));
        }
        this.logExit("rgGetLocationOnRouteResult");
    }

    @Override
    public void rgResult(int n) {
        this.logEnter("rgResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$147(this, n));
        this.logExit("rgResult");
    }

    @Override
    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
        this.logChannel.log(-1601830656, "%1#updateRgEnhancedSignPostInfoStatus", (Object)this.listenerName);
    }

    @Override
    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
        this.logChannel.log(-1601830656, "%1#updateSoPosTimeInformation", (Object)this.listenerName);
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
        this.logEnter("rgGetRubberBandPointPositionResult");
        if (n == 0) {
            CommandResponse.execute(this, new DSINavigationDispatcher$148(this, navLocationWgs84, bl));
        }
        this.logExit("rgGetRubberBandPointPositionResult");
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
        this.logEnter("lispGetMatchingNVCResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$149(this, string));
        this.logExit("lispGetMatchingNVCResult");
    }

    @Override
    public void etcSetDemoModeResult(int n) {
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        this.logEnter("lispGetLocationFromLiValueListResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$150(this, n, navLocation));
        this.logExit("lispGetLocationFromLiValueListResult");
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
        this.logEnter("poiGetXt9LDBsResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$151(this, stringArray));
        this.logExit("poiGetXt9LDBsResult");
    }

    @Override
    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void rgTriggerRCCIUpdateResult(int n) {
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
        this.logEnter("liGetLocationDescriptionTransformNearByResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$152(this, navLocation));
        this.logExit("liGetLocationDescriptionTransformNearByResult");
    }

    @Override
    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    @Override
    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        this.logEnter("poiGetCategoryTypesFromUIdResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$153(this, nArray));
        this.logExit("poiGetCategoryTypesFromUIdResult");
    }

    @Override
    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        this.logEnter("liDisambiguateLocationResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$154(this, nArray, navLocationArray));
        this.logExit("liDisambiguateLocationResult");
    }

    @Override
    public void requestPriceInfoResult(NavPriceInfo navPriceInfo, int n) {
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
        this.logEnter("triggerEventAudioMessageResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$155(this, n));
        this.logExit("triggerEventAudioMessageResult");
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
        this.logEnter("lispRequestNVCListResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$156(this, n, string, n2));
        this.logExit("lispRequestNVCListResult");
    }

    @Override
    public void updateMapIntegrationState(int n, int n2) {
        this.logEnter("updateMapIntegrationState");
        if (1 == n2) {
            CommandResponse.execute(this, new DSINavigationDispatcher$157(this, n));
        }
        this.logExit("updateMapIntegrationState");
    }

    @Override
    public void deleteSatelliteCacheResult(int n) {
    }

    @Override
    public void updateMapIntegrationProgress(int n, int n2) {
    }

    @Override
    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    @Override
    public void updateBapManeuverState(int n, int n2) {
        this.logEnter("updateBapManeuverState");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$158(this, n));
        }
        this.logExit("updateBapManeuverState");
    }

    @Override
    public void rmImportToursFromGpxFileResult(int n) {
    }

    @Override
    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        this.logEnter("importRouteFromGpxFileResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$159(this, navLocation));
        this.logExit("importRouteFromGpxFileResult");
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
        this.logEnter("updateBapManeuverInformation");
        if (n2 == 1) {
            CommandResponse.execute(this, new DSINavigationDispatcher$160(this, bapManeuverDescriptorArray, n));
        }
        this.logExit("updateBapManeuverInformation");
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        this.logEnter("poiRequestExtendedInfoResult");
        CommandResponse.execute(this, new DSINavigationDispatcher$161(this, poiExtendedInfo, bl));
        this.logExit("poiRequestExtendedInfoResult");
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
}

