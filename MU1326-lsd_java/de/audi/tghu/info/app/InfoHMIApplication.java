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
import de.audi.tghu.info.app.InfoHMIApplication$1;
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

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        switch (n) {
            case 0: {
                return this.env.getButtonModel(-912193792);
            }
            case 1: {
                return this.env.getButtonModel(-945748224);
            }
        }
        return null;
    }

    @Override
    public void popupHidden(int n, int n2) {
        this.tmcApp.popupRemoved(n, n2);
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.tmcApp.popupRemoved(n, n2);
        if (n == this.xUrgentPopUpId) {
            this.tmcAppReadOut.urgentPopupRemoved();
        }
    }

    @Override
    public void popupVisible(int n, int n2) {
        this.tmcApp.popupVisible(n, n2);
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
    }

    @Override
    public void setLanguage(Language language) {
        this.tmcApp.setLanguage(language);
    }

    public void showPopup() {
        this.tmcApp.getFramework().getHmiServiceApp().showPopup(this.xUrgentPopUpId);
    }

    public void showPartialPopup() {
        this.env.getFramework().getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new InfoHMIApplication$1(this)));
    }

    public void removePopup() {
        this.tmcApp.getFramework().getHmiServiceApp().removePopup(this.xUrgentPopUpId);
    }

    public void setXUrgentPopupId(int n) {
        this.xUrgentPopUpId = n;
    }

    static /* synthetic */ int access$000(InfoHMIApplication infoHMIApplication) {
        return infoHMIApplication.xUrgentPopUpId;
    }

    static /* synthetic */ InfoEnv access$100(InfoHMIApplication infoHMIApplication) {
        return infoHMIApplication.env;
    }
}

