/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.AbstractAppManagerCore;
import de.audi.app.system.AbstractAppSystemCore;
import de.audi.app.system.AppManagerEvo;
import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.start.ILastmodeHandler;

public class AppSystemEvo
extends AbstractAppSystemCore
implements HMIApplication,
IAppSystem {
    private final AppManagerEvo appManagerEvo;

    AppSystemEvo(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        this.appManagerEvo = new AppManagerEvo(iFrameworkAccess);
    }

    protected AbstractAppManagerCore getAppManager() {
        return this.appManagerEvo;
    }

    public void fireInitialEvent() {
        this.getLog().log(1000000, "AppSystemEvo.fireInitialEvent()");
        this.fireSMEvent(0, -7);
        if (this.getFramework().isShowDDP2Combi()) {
            this.fireSMEvent(1, -7);
        }
        if (this.getFramework().isDualView()) {
            this.fireSMEvent(2, -7);
        }
    }

    public void fireHKReturn(int n) {
        this.fireSMEvent(n, 1741);
        if (n == 0) {
            this.fireSMEvent(1, 1741);
        }
    }

    public void fireHKSelection(int n) {
        this.fireSMEvent(n, 1750);
    }

    public void fireJoystickLeft(int n) {
        this.fireSMEvent(n, 1742);
    }

    public void jumpToCustomerDownload(int n) {
        this.fireSMEvent(n, -6);
    }

    public void cancelCustomerDownload(int n) {
        this.fireSMEvent(n, 1741);
    }

    public boolean isEventContextSensitive(int n) {
        switch (n) {
            case -5: 
            case -4: 
            case -3: 
            case -2: 
            case -1: 
            case 1741: {
                return true;
            }
        }
        return false;
    }

    public boolean isEventSubterminalSensitive(int n) {
        switch (n) {
            case -5: {
                return true;
            }
        }
        return false;
    }

    public void showNoPowerPopups(int n) {
        this.getHMIService().removePopup(6, n);
    }

    public void showBlackScreenLEDsOn(int n) {
        this.getHMIService().showPopup(6, n);
    }

    public void showBlackScreenLEDsOff(int n) {
        this.getHMIService().showPopup(6, n);
    }

    public void showQ21Warning(int n) {
        this.getHMIService().showPopup(7, n);
    }

    public void removeQ21Warning(int n) {
        this.getHMIService().removePopup(7, n);
    }

    public void showCritcalTemperature(int n) {
        this.getHMIService().showPopup(8, n);
    }

    public void removeCritcalTemperature(int n) {
        this.getHMIService().removePopup(8, n);
    }

    public void showTelMaxWarning(int n) {
        this.getHMIService().showPopup(600000, n);
    }

    public void removeTelMaxWarning(int n) {
        this.getHMIService().removePopup(600000, n);
    }

    public void showStandbyWarning(int n) {
        if (this.getFramework().isEvoHighMMIKombi()) {
            this.getHMIService().showPopup(22, n);
        } else {
            this.getHMIService().showPartialPopup(n, 72);
        }
    }

    public void removeStandbyWarning(int n) {
        if (this.getFramework().isEvoHighMMIKombi()) {
            this.getHMIService().removePopup(22, n);
        } else {
            this.getHMIService().removePartialPopup(n, 72);
        }
    }

    public void showLegalDisclaimer(int n) {
    }

    public void removeLegalDisclaimer(int n) {
    }

    private int getLastmode() {
        ILastmodeHandler iLastmodeHandler = this.getFramework().getStartupMgr().getLastmodeHandler();
        return iLastmodeHandler != null ? iLastmodeHandler.getLastmode(0) : -1;
    }

    public void switch2Tuner() {
        if (this.getLastmode() != 1) {
            this.fireSMEvent(0, 101);
        }
    }

    public void switch2Media() {
        if (this.getLastmode() != 2 && this.getLastmode() != 38) {
            this.fireSMEvent(0, 102);
        }
    }

    public void showSdsStatusPopup(int n) {
    }

    public void showDiagPopup(int n) {
    }

    public void removeDiagPopup() {
    }

    public void showEngineOffPopup(int n) {
    }

    public void removeEngineOffPopup(int n) {
    }

    public void removeDiagPopup(int n) {
    }
}

