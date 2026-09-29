/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.InfoHMIApplication;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRowBuilder;
import de.audi.tghu.info.app.tmc.readout.UrgentMessageFilter;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class UrgentPopupHandler {
    protected LogChannel logger;
    protected InfoHMIApplication hmiApp;
    protected List msgs;
    protected UrgentMessageFilter msgFilter;
    protected TMCAbstractListRowBuilder listRowBuilder;
    protected final InfoEnv env;
    protected AppTMC appTMC;

    public UrgentPopupHandler(LogChannel logChannel, InfoEnv infoEnv) {
        this.env = infoEnv;
        this.logger = logChannel;
        this.msgs = new ArrayList(10);
        this.msgFilter = new UrgentMessageFilter(logChannel);
    }

    protected abstract boolean showNextPopup() {
    }

    public void setHmiApplication(InfoHMIApplication infoHMIApplication) {
        this.hmiApp = infoHMIApplication;
    }

    public void setListRowBuilder(TMCAbstractListRowBuilder tMCAbstractListRowBuilder) {
        this.listRowBuilder = tMCAbstractListRowBuilder;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void urgentPopupRemoved() {
        boolean bl = false;
        UrgentPopupHandler urgentPopupHandler = this;
        synchronized (urgentPopupHandler) {
            this.logger.log(-2137614336, "[UrgentPopupHandler#urgentPopupRemoved] Called. ");
            bl = this.showNextPopup();
        }
        if (bl) {
            this.logger.log(-2137614336, "[UrgentPopupHandler#urgentPopupRemoved] Call HMI application for showing popup.");
            this.showPopup(bl);
        } else {
            this.logger.log(-2137614336, "[UrgentPopupHandler#urgentPopupRemoved] Do not show popup.");
            this.env.getFramework().getPowerMgr().setExtendedPowerState(201, 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateTmcUrgentMessages(TmcMessage[] tmcMessageArray) {
        boolean bl = false;
        UrgentPopupHandler urgentPopupHandler = this;
        synchronized (urgentPopupHandler) {
            this.logger.log(-2137614336, "[UrgentPopupHandler#updateTmcUrgentMessages] Called. ");
            this.msgFilter.filterMessages(tmcMessageArray);
            this.msgs = this.msgFilter.getMessagesForShowing();
            this.env.getFramework().getPowerMgr().setExtendedPowerState(200, 0);
            bl = this.showNextPopup();
        }
        this.showPopup(bl);
    }

    protected void showPopup(boolean bl) {
        if (bl) {
            this.logger.log(-2137614336, "[UrgentPopupHandler#updateTmcUrgentMessages] Call HMI application for showing popup.");
            this.hmiApp.showPopup();
        } else {
            this.logger.log(-2137614336, "[UrgentPopupHandler#updateTmcUrgentMessages] Do not show popup.");
        }
    }

    public TMCAbstractListRowBuilder getRowBuilder() {
        return this.listRowBuilder;
    }

    public void setTmcApp(AppTMC appTMC) {
        this.appTMC = appTMC;
    }
}

