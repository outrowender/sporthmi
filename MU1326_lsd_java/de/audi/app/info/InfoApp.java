/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info;

import de.audi.app.info.tmc.InfoOverviewListManager;
import de.audi.app.info.tmc.InfoRowBuilder;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.readout.AppTMCReadOut;
import java.util.Date;

public class InfoApp
extends AppTMC {
    public static final int NO_REROUTING_HINT = 0;
    public static final int REROUTING_HINT_NO_MESSAGES_ON_ROUTE = 1;
    public static final int REROUTING_HINT_BETTER_ROUTE_AVAILABLE = 2;
    public static final int REROUTING_HINT_NO_BETTER_ROUTE = 3;
    private ChoiceModelApp reroutingChoice;
    private final int tmcPopupId;

    public InfoApp(InfoEnv infoEnv, AppTMCReadOut appTMCReadOut) {
        super(infoEnv, appTMCReadOut);
        this.tmcPopupId = 500001;
        this.logMain.log(10000000, "[InfoApp#contructor]");
        this.rowBuilder = new InfoRowBuilder(this, infoEnv);
        this.listManager = new InfoOverviewListManager(infoEnv, this, infoEnv.getTiledListModel(500129), this.rowBuilder);
        this.reroutingChoice = infoEnv.getChoiceModel(500144);
    }

    public void showHideTMCPopup() {
        boolean bl;
        this.logMain.log(1000000, "[InfoApp#showHideTMCPopup] tmcPopupId %1", 500001L);
        int n = this.getFramework().getHmiServiceApp().getCurrentPopup(0);
        boolean bl2 = bl = n == 500001;
        if (bl) {
            this.logMain.log(1000000, "[InfoApp#showHideTMCPopup] tmcPopupShown");
            this.getFramework().getHmiServiceApp().removePopup(500001);
        } else {
            this.logMain.log(1000000, "[InfoApp#showHideTMCPopup] !tmcPopupShown");
            if (!this.listManager.isTmcScreenShown()) {
                this.env.getChoiceModel(500192).setValue(1);
                this.logMain.log(1000000, "[InfoApp#showHideTMCPopup] !tmcScreenShown");
                this.getFramework().getHmiServiceApp().showPopup(500001);
            }
        }
    }

    public void leaveMapSemidynamicRouteScreen() {
        int n = this.getFramework().getHmiServiceApp().getCurrentPopup(0);
        this.logMain.log(1000000, "[InfoApp#leaveMapSemidynamicRouteScreen] tmcPopupShown %1", n == 500001);
        this.getFramework().getHmiServiceApp().removePopup(500001);
    }

    public void popupRemoved(int n, int n2) {
        this.logMain.log(1000000, "[InfoApp#popupRemoved] id %1, terminalID %2", (long)n, (long)n2);
    }

    public void popupVisible(int n, int n2) {
        this.logMain.log(1000000, "[InfoApp#popupVisible] id %1, terminalID %2", (long)n, (long)n2);
    }

    public void updateEventsOnRoute(long l) {
        super.updateEventsOnRoute(l);
        this.updateReroutingStatus();
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.updateReroutingStatus();
    }

    public void updateTrafficRerouting(int n) {
        super.updateTrafficRerouting(n);
        this.updateReroutingStatus();
    }

    public void updateSemidynamicRouteGuidance(long l, boolean bl, boolean bl2, int n) {
        super.updateSemidynamicRouteGuidance(l, bl, bl2, n);
        this.updateReroutingStatus();
    }

    private void updateReroutingStatus() {
        this.logMain.log(10000000, "InfoApp#updateReroutingStatus trafficRerouting=%1, eventsOnRoute=%2, rgActive=%3", (long)this.trafficRerouting, this.eventsOnRoute, this.rgActive);
        this.logMain.log(10000000, "InfoApp#updateReroutingStatus savingTime=%1, trafficDelayOnCurrentRoute=%2, hasBetterRoute=%3", (long)this.savingTime, this.trafficDelayOnCurrentRoute, this.hasBetterRoute);
        if (!this.rgActive) {
            this.reroutingChoice.setValue(0);
        } else if (this.rgActive && (this.trafficRerouting == 0 || this.trafficRerouting == 2)) {
            if (this.eventsOnRoute == 0L) {
                this.reroutingChoice.setValue(1);
            } else {
                this.reroutingChoice.setValue(0);
            }
        } else if (this.rgActive && this.trafficRerouting == 1) {
            if (this.hasBetterRoute) {
                long l = this.savingTime * 60 * 1000;
                DateMetric dateMetric = new DateMetric(new Date(l), 11);
                dateMetric.setDate(l);
                this.env.getMetricsModel(500106).setMetric(dateMetric);
                this.reroutingChoice.setValue(2);
            } else {
                DateMetric dateMetric = new DateMetric(new Date(this.trafficDelayOnCurrentRoute), 11);
                dateMetric.setDate(this.trafficDelayOnCurrentRoute);
                this.env.getMetricsModel(500106).setMetric(dateMetric);
                this.reroutingChoice.setValue(3);
            }
        }
    }
}

