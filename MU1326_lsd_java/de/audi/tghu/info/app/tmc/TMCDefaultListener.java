/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.audi.tghu.info.app.tmc.TMCTitleLineManager;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public class TMCDefaultListener
implements DSITmcListener {
    private AppTMC tmcApp;
    private LogChannel logCh;
    private TMCTitleLineManager titleLineManager;

    TMCDefaultListener(InfoEnv infoEnv, AppTMC appTMC) {
        this.tmcApp = appTMC;
        this.titleLineManager = new TMCTitleLineManager(this.tmcApp.getFramework().getLogChannel("App.TMC.Main"), infoEnv);
        this.logCh = this.tmcApp.getFramework().getLogChannel("App.TMC.DSI");
    }

    public void stop() {
        this.tmcApp = null;
        this.titleLineManager = null;
    }

    TMCTitleLineManager getTitleLineManager() {
        return this.titleLineManager;
    }

    public void tmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
        String string = tmcListElementArray == null ? "null" : String.valueOf(tmcListElementArray.length);
        this.logCh.log(10000000, "[TMCDefaultListener#tmcWindowResult] Called, windowId: %2, usedAnchorId: %3, number of messages: %1", (Object)string, (long)n, (long)n2);
    }

    public void windowChange(int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#windowChange] called, window ID: %1 ", (long)n);
        TMCAbstractListManager tMCAbstractListManager = this.tmcApp.listManager;
        if (tMCAbstractListManager == null) {
            this.logCh.log(10000, "[TMCDefaultListener#windowChange] no list model");
            return;
        }
        tMCAbstractListManager.tmcWindowChanged();
    }

    public void updateEventsOnRoute(long l, int n) {
        if (n == 1) {
            this.logCh.log(10000000, "[TMCDefaultListener#updateEventsOnRoute] Called, eventsOnRoute: %1 ", l);
            this.tmcApp.updateEventsOnRoute(l);
        } else {
            this.logCh.log(10000000, "[TMCDefaultListener#updateEventsOnRoute] Called but invalid! ");
        }
    }

    public void updateEventsTotal(int n, long l, long l2, int n2) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateEventsTotal] Called. ");
        if (n2 == 1) {
            if (this.tmcApp == null) {
                this.logCh.log(10000, "[TMCDefaultListener#updateEventsTotal] no TMC App ");
                return;
            }
            this.tmcApp.listManager.updateEventsTotal((int)l2);
        } else {
            this.logCh.log(10000000, "[TMCDefaultListener#updateEventsTotal] Invalid value. ");
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.logCh.log(10000, "[TMCDefaultListener#asyncException] Called, error Msg: %1, error Code: %2, requestType: %3 ", (Object)string, (long)n, (long)n2);
    }

    public void updateIsEngineeringMode(boolean bl, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateIsEngineeringMode] Called. ");
    }

    public void updateCurrentLanguage(String string, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateCurrentLanguage] Called. ");
        if (n == 1) {
            this.logCh.log(10000000, "[TMCDefaultListener#updateCurrentLanguage] Current language updated, currentLanguage: %1. ", (Object)string);
        } else {
            this.logCh.log(10000000, "[TMCDefaultListener#updateCurrentLanguage] Invalid value. ");
        }
    }

    public void updateTmcState(int n, int n2) {
        if (n2 == 1) {
            this.logCh.log(10000000, "[TMCDefaultListener#updateTmcState] Called, tmcStatus: %1", (long)n);
        } else {
            this.logCh.log(10000000, "[TMCDefaultListener#updateTmcState] Called but invalid! ");
        }
    }

    public void updateActiveTrafficSources(int[] nArray, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateActiveTrafficSources] activeTrafficSources=%1, validFlag=%2", (Object)nArray, (long)n);
        if (n != 1 || nArray == null || nArray.length < 1) {
            return;
        }
        int n2 = nArray[0];
        this.titleLineManager.setActiveTrafficSource(n2);
    }

    public void updateTrafficSourceInformation(TrafficSource[] trafficSourceArray, int n) {
        if (!TMCHelper.isHURegionAsia()) {
            return;
        }
        if (trafficSourceArray == null || trafficSourceArray.length < 1 || trafficSourceArray[0] == null) {
            this.logCh.log(10000000, "[TMCDefaultListener#updateTrafficSourceInformation] trafficSources is empty.");
            this.titleLineManager.setTitleLineIconsForAsia(0);
            return;
        }
        this.logCh.log(10000000, "[TMCDefaultListener#updateTrafficSourceInformation] %1 trafficSources validFlag=%2", (Object)trafficSourceArray[0].toString(), (long)n);
        this.titleLineManager.setTitleLineIconsForAsia(trafficSourceArray[0].getTrafficSourceType());
    }

    public void setMessageFilterResult(int n, int n2) {
        this.logCh.log(10000000, "[TMCDefaultListener#setMessageFilterResult] Not in use ");
    }

    public void getMessageIdsForListElementResult(long[] lArray) {
        this.logCh.log(10000000, "[TMCDefaultListener#getMessageIdsForListElementResult] Not in use ");
    }

    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        this.logCh.log(10000000, "[TMCDefaultListener#getBoundingRectangleForTrafficMessagesResult] Not in use ");
    }

    public void updateAreaWarning(AreaWarningInfo areaWarningInfo, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateAreaWarning]");
    }

    public void updateAreaWarnings(AreaWarningInfo[] areaWarningInfoArray, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateAreaWarnings]");
    }

    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateLocalHazardInformation]");
        if (n != 1) {
            return;
        }
        this.tmcApp.getNaviService().updateLocalHazardInformation(localHazardInformationArray);
    }

    public void updateTrafficFlowStatisticsStatus(boolean bl, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateTrafficFlowStatisticsStatus]");
    }

    public void updateIsTmcProAvailable(boolean bl, int n) {
        this.logCh.log(10000000, "[TMCDefaultListener#updateIsTmcProAvailable] not used, TMC pro available=%1, validFlag=%2", bl, (long)n);
    }
}

