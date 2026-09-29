/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCDefaultListener;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.audi.tghu.info.app.tmc.TMCListener$1;
import de.audi.tghu.info.app.tmc.TMCListener$10;
import de.audi.tghu.info.app.tmc.TMCListener$11;
import de.audi.tghu.info.app.tmc.TMCListener$12;
import de.audi.tghu.info.app.tmc.TMCListener$13;
import de.audi.tghu.info.app.tmc.TMCListener$14;
import de.audi.tghu.info.app.tmc.TMCListener$15;
import de.audi.tghu.info.app.tmc.TMCListener$16;
import de.audi.tghu.info.app.tmc.TMCListener$17;
import de.audi.tghu.info.app.tmc.TMCListener$2;
import de.audi.tghu.info.app.tmc.TMCListener$3;
import de.audi.tghu.info.app.tmc.TMCListener$4;
import de.audi.tghu.info.app.tmc.TMCListener$5;
import de.audi.tghu.info.app.tmc.TMCListener$6;
import de.audi.tghu.info.app.tmc.TMCListener$7;
import de.audi.tghu.info.app.tmc.TMCListener$8;
import de.audi.tghu.info.app.tmc.TMCListener$9;
import de.audi.tghu.info.app.tmc.TMCSimulation;
import de.audi.tghu.info.app.tmc.TMCTitleLineManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public class TMCListener
implements DSITmcListener,
ICommandResponseSupplier {
    private CommandListManager cmdListManagerOverview;
    private LogChannel logCh;
    private IFrameworkAccess framework;
    private TMCDefaultListener defaultListener;
    private DSITmc dsiTmc;
    private AppTMC app;

    public TMCListener(CommandListManager commandListManager, InfoEnv infoEnv, AppTMC appTMC, IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.cmdListManagerOverview = commandListManager;
        this.app = appTMC;
        this.defaultListener = new TMCDefaultListener(infoEnv, appTMC);
        this.logCh = iFrameworkAccess.getLogChannel("App.TMC.DSI");
        this.logCh.log(-2137614336, "[TMCListener#TMCListener] Finished. ");
    }

    @Override
    public void tmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
        String string = tmcListElementArray == null ? "null" : String.valueOf(tmcListElementArray.length);
        this.logCh.log(-2137614336, "[TMCListener#tmcWindowResult] Called, windowId: %2, usedAnchorId: %3, tmcListElements.length: %1 ", (Object)string, (long)n, (long)n2);
        CommandResponse.execute(this, new TMCListener$1(this, n, n2, tmcListElementArray));
    }

    @Override
    public void updateEventsOnRoute(long l, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateEventsOnRoute] Called, eventsOnRoute: %1, validFlag: %2 ", l, (long)n);
        CommandResponse.execute(this, new TMCListener$2(this, l, n));
    }

    @Override
    public void updateEventsTotal(int n, long l, long l2, int n2) {
        this.logCh.log(-2137614336, "[TMCListener#updateEventsTotal] Called, windowId: %1, eventsTotal: %2, eventsVisible: %3", (long)n, l, l2);
        this.logCh.log(-2137614336, "[TMCListener#updateEventsTotal] validFlag: %1 ", (long)n2);
        CommandResponse.execute(this, new TMCListener$3(this, n, l, l2, n2));
    }

    @Override
    public void updateIsEngineeringMode(boolean bl, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateIsEngineeringMode] Called, isEngineeringMode: %1, validFlag: %2 ", bl, (long)n);
        CommandResponse.execute(this, new TMCListener$4(this, bl, n));
    }

    @Override
    public void updateIsTmcProAvailable(boolean bl, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateIsTmcProAvailable] Called, isTmcAvailable: %1, validFlag: %2 ", bl, (long)n);
        CommandResponse.execute(this, new TMCListener$5(this, bl, n));
    }

    @Override
    public void windowChange(int n) {
        this.logCh.log(-2137614336, "[TMCListener#windowChange] Called, windowId: %1 ", (long)n);
        switch (n) {
            case 0: {
                this.logCh.log(-2137614336, "[TMCListener#windowChange] Forward to overview list cmd manager. ");
                CommandResponse.execute(this, new TMCListener$6(this, n));
                break;
            }
            case 1: {
                if (this.framework.isFrontMU()) break;
                this.logCh.log(-2137614336, "[TMCListener#windowChange] Forward to RSE overview list cmd manager.");
                CommandResponse.execute(this, new TMCListener$7(this, n));
                break;
            }
            case 2: {
                if (this.framework.isFrontMU()) break;
                this.logCh.log(-2137614336, "[TMCListener#windowChange] Forward to RSE overview list cmd manager.");
                CommandResponse.execute(this, new TMCListener$8(this, n));
                break;
            }
            default: {
                this.logCh.log(-2137614336, "[TMCListener#windowChange] Unknown window ID, do nothing. ");
                return;
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logCh.log(-2137614336, "[TMCListener#asyncException] Called, errorCode: %2, errorMsg: %1, requestType: %3 ", (Object)string, (long)n, (long)n2);
        CommandResponse.execute(this, new TMCListener$9(this, n, string, n2));
    }

    @Override
    public void updateCurrentLanguage(String string, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateCurrentLanguage] Called, currentLanguage: %1, validFlag: %2 ", (Object)string, (long)n);
        CommandResponse.execute(this, new TMCListener$10(this, string, n));
    }

    @Override
    public void updateTmcState(int n, int n2) {
        this.logCh.log(-2137614336, "[TMCListener#tmcState] Called, tmcStatus: %1, validFlag: %2 ", (long)n, (long)n2);
        CommandResponse.execute(this, new TMCListener$11(this, n, n2));
    }

    @Override
    public void setMessageFilterResult(int n, int n2) {
        this.logCh.log(-2137614336, "[TMCListener#setMessageFilterResult] Called, windowId: %1, messageFilter: %2", (long)n, (long)n2);
        CommandResponse.execute(this, new TMCListener$12(this, n, n2));
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManagerOverview.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logCh;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public void updateActiveTrafficSources(int[] nArray, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateActiveTrafficSources] Called, activeTrafficSources.length: %1", nArray != null ? (long)nArray.length : 0L);
        CommandResponse.execute(this, new TMCListener$13(this, nArray, n));
    }

    @Override
    public void updateTrafficSourceInformation(TrafficSource[] trafficSourceArray, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateTrafficSourceInformation] %1 trafficSources validFlag=%2", (Object)(null == trafficSourceArray ? "null" : String.valueOf(trafficSourceArray.length)), (long)n);
        CommandResponse.execute(this, new TMCListener$14(this, trafficSourceArray, n));
    }

    public void requestTMCWindow(int n, int n2, int[] nArray, int n3, int n4, boolean bl) {
        if (this.dsiTmc == null) {
            this.logCh.log(1078071040, "[TMCListener#requestTMCWindow] No TMC DSI available!");
            return;
        }
        if (!bl) {
            this.logCh.log(1078071040, "[TMCListener#requestTMCWindow] Navigation is not fully operable!");
            return;
        }
        if (this.logCh.isInfo()) {
            this.logCh.log(1078071040, "[TMCListener#requestTMCWindow] windowId: %1, windowSize: %2, offset: %3", (long)n4, (long)n, (long)n2);
            this.logCh.log(1078071040, "[TMCListener#requestTMCWindow] %1, openedListAnchorId: %2", (Object)TMCHelper.arrayToString("anchorID", nArray), (long)n3);
        }
        try {
            this.logCh.log(-2137614336, "[TMCListener#requestTMCWindow] Call for list window %1", (long)n4);
            this.dsiTmc.requestTmcWindow(n4, n, n2, nArray, n3);
        }
        catch (Exception exception) {
            this.logCh.log(10000, "[TMCListener#requestTMCWindow] ERROR = %1", (Throwable)exception);
        }
    }

    public void getBoundingRectangle(long[] lArray) {
        if (this.dsiTmc == null) {
            this.logCh.log(1078071040, "[TMCListener#getBoundingRectangle] No TMC DSI available!");
            return;
        }
        try {
            this.logCh.log(-2137614336, "[TMCListener#getBoundingRectangle] Call for getBoundingRectangleForTrafficMessages %1", (Object)lArray);
            this.dsiTmc.getBoundingRectangleForTrafficMessages(lArray);
        }
        catch (Exception exception) {
            this.logCh.log(10000, "[TMCListener#getBoundingRectangle] ERROR = %1", (Throwable)exception);
        }
    }

    public void setMessageFilter(int n, int n2) {
        if (this.dsiTmc == null) {
            this.logCh.log(1078071040, "[TMCListener#setMessageFilter] No TMC DSI available!");
            return;
        }
        try {
            this.logCh.log(-2137614336, "[TMCListener#setMessageFilter] Call for setMessageFilter %1, %2", (long)n, (long)n2);
            this.dsiTmc.setMessageFilter(n, n2);
        }
        catch (Exception exception) {
            this.logCh.log(10000, "[TMCListener#setMessageFilter] ERROR = %1", (Throwable)exception);
        }
    }

    public void setTmcService(DSIBase dSIBase) {
        this.logCh.log(1078071040, "[TMCListener#setTmcService] TMC DSI was found and is set on TMC application");
        this.dsiTmc = (DSITmc)dSIBase;
        try {
            this.dsiTmc.setNotification(new int[]{1, 2, 5, 6, 7, 11, 16, 8, 14}, (DSIListener)this);
        }
        catch (Exception exception) {
            this.logCh.log(10000, "[TMCListener#setTmcService] ERROR = %1", (Throwable)exception);
        }
        this.app.checkWindowRequest();
    }

    public void stop() {
        this.defaultListener.stop();
        this.defaultListener = null;
    }

    public TMCTitleLineManager getTitleLineManager() {
        return this.defaultListener.getTitleLineManager();
    }

    public boolean isDSITmcReady() {
        return this.dsiTmc != null;
    }

    public void removeMsg(int n, int n2) {
        try {
            if (n2 == -1) {
                ((TMCSimulation)this.dsiTmc).removeMsg(n);
            } else {
                ((TMCSimulation)this.dsiTmc).removeMsg(n, n2);
            }
        }
        catch (Exception exception) {
            this.logCh.log(10000, "[TMCListener#removeMsg] ERROR = %1", (Throwable)exception);
        }
    }

    public void releaseTmcService() {
        try {
            this.dsiTmc.clearNotification(this);
        }
        catch (Exception exception) {
            this.logCh.log(10000, "[TMCListener#releaseTmcService] ERROR = %1", (Throwable)exception);
        }
        this.dsiTmc = null;
    }

    public void getMessageIdsForListElement(long l) {
        this.logCh.log(-2137614336, "[TMCListener#getMessageIdsForListElement] listElementUId = %1", l);
        this.dsiTmc.getMessageIdsForListElement(l);
    }

    @Override
    public void getMessageIdsForListElementResult(long[] lArray) {
        this.logCh.log(-2137614336, "[TMCListener#getMessageIdsForListElementResult] messageIds = %1", (Object)lArray);
        CommandResponse.execute(this, new TMCListener$15(this, lArray));
    }

    @Override
    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        this.logCh.log(-2137614336, "[TMCListener#getBoundingRectangleForTrafficMessagesResult] rectangle = %1", (Object)navRectangle);
        CommandResponse.execute(this, new TMCListener$16(this, navRectangle));
    }

    @Override
    public void updateAreaWarning(AreaWarningInfo areaWarningInfo, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateAreaWarning]");
    }

    @Override
    public void updateAreaWarnings(AreaWarningInfo[] areaWarningInfoArray, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateAreaWarnings]");
    }

    @Override
    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateLocalHazardInformation]");
        CommandResponse.execute(this, new TMCListener$17(this, localHazardInformationArray, n));
    }

    @Override
    public void updateTrafficFlowStatisticsStatus(boolean bl, int n) {
        this.logCh.log(-2137614336, "[TMCListener#updateTrafficFlowStatisticsStatus]");
    }
}

