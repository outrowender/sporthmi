/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.readout.AppTMCReadOut;

public class InfoHMIApplication
implements HMIApplication,
I18NTarget {
    private int xUrgentPopUpId;
    private AppTMC tmcApp;
    private AppTMCReadOut tmcAppReadOut;
    private LogChannel logger;
    private final InfoEnv env;

    public InfoHMIApplication(AppTMC appTMC, AppTMCReadOut appTMCReadOut, LogChannel logChannel, InfoEnv infoEnv) {
        this.env = infoEnv;
        this.tmcApp = appTMC;
        this.tmcAppReadOut = appTMCReadOut;
        this.logger = logChannel;
    }

    public int getId() {
        return 5;
    }

    public ButtonModelApp getVirtualButton(int n) {
        switch (n) {
            case 0: {
                return this.env.getButtonModel(500169);
            }
            case 1: {
                return this.env.getButtonModel(500167);
            }
        }
        return null;
    }

    public void popupHidden(int n, int n2) {
        this.tmcApp.popupRemoved(n, n2);
    }

    public void popupRemoved(int n, int n2) {
        this.tmcApp.popupRemoved(n, n2);
        if (n == this.xUrgentPopUpId) {
            this.tmcAppReadOut.urgentPopupRemoved();
        }
    }

    public void popupVisible(int n, int n2) {
        this.tmcApp.popupVisible(n, n2);
    }

    public void screenHidden(int n, int n2) {
    }

    public void screenVisible(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }

    public void setLanguage(Language language) {
        this.tmcApp.setLanguage(language);
    }

    public void showPopup() {
        this.tmcApp.getFramework().getHmiServiceApp().showPopup(this.xUrgentPopUpId);
    }

    public void showPartialPopup() {
        this.env.getFramework().getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new Runnable(){

            public void run() {
                InfoHMIApplication.this.env.getFramework().getHmiServiceApp().showPartialPopup(0, InfoHMIApplication.this.xUrgentPopUpId);
            }
        }));
    }

    public void removePopup() {
        this.tmcApp.getFramework().getHmiServiceApp().removePopup(this.xUrgentPopUpId);
    }

    public void setXUrgentPopupId(int n) {
        this.xUrgentPopUpId = n;
    }
}

