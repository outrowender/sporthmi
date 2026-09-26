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

    @Override
    protected AbstractAppManagerCore getAppManager() {
        return this.appManagerEvo;
    }

    @Override
    public void fireInitialEvent() {
        this.getLog().log(1078071040, "AppSystemEvo.fireInitialEvent()");
        this.fireSMEvent(0, -7);
        if (this.getFramework().isShowDDP2Combi()) {
            this.fireSMEvent(1, -7);
        }
        if (this.getFramework().isDualView()) {
            this.fireSMEvent(2, -7);
        }
    }

    @Override
    public void fireHKReturn(int n) {
        this.fireSMEvent(n, 1741);
        if (n == 0) {
            this.fireSMEvent(1, 1741);
        }
    }

    @Override
    public void fireHKSelection(int n) {
        this.fireSMEvent(n, 1750);
    }

    @Override
    public void fireJoystickLeft(int n) {
        this.fireSMEvent(n, 1742);
    }

    @Override
    public void jumpToCustomerDownload(int n) {
        this.fireSMEvent(n, -6);
    }

    @Override
    public void cancelCustomerDownload(int n) {
        this.fireSMEvent(n, 1741);
    }

    @Override
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

    @Override
    public boolean isEventSubterminalSensitive(int n) {
        switch (n) {
            case -5: {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showNoPowerPopups(int n) {
        this.getHMIService().removePopup(6, n);
    }

    @Override
    public void showBlackScreenLEDsOn(int n) {
        this.getHMIService().showPopup(6, n);
    }

    @Override
    public void showBlackScreenLEDsOff(int n) {
        this.getHMIService().showPopup(6, n);
    }

    @Override
    public void showQ21Warning(int n) {
        this.getHMIService().showPopup(7, n);
    }

    @Override
    public void removeQ21Warning(int n) {
        this.getHMIService().removePopup(7, n);
    }

    @Override
    public void showCritcalTemperature(int n) {
        this.getHMIService().showPopup(8, n);
    }

    @Override
    public void removeCritcalTemperature(int n) {
        this.getHMIService().removePopup(8, n);
    }

    @Override
    public void showTelMaxWarning(int n) {
        this.getHMIService().showPopup(-1071183616, n);
    }

    @Override
    public void removeTelMaxWarning(int n) {
        this.getHMIService().removePopup(-1071183616, n);
    }

    @Override
    public void showStandbyWarning(int n) {
        if (this.getFramework().isEvoHighMMIKombi()) {
            this.getHMIService().showPopup(22, n);
        } else {
            this.getHMIService().showPartialPopup(n, 72);
        }
    }

    @Override
    public void removeStandbyWarning(int n) {
        if (this.getFramework().isEvoHighMMIKombi()) {
            this.getHMIService().removePopup(22, n);
        } else {
            this.getHMIService().removePartialPopup(n, 72);
        }
    }

    @Override
    public void showLegalDisclaimer(int n) {
    }

    @Override
    public void removeLegalDisclaimer(int n) {
    }

    private int getLastmode() {
        ILastmodeHandler iLastmodeHandler = this.getFramework().getStartupMgr().getLastmodeHandler();
        return iLastmodeHandler != null ? iLastmodeHandler.getLastmode(0) : -1;
    }

    @Override
    public void switch2Tuner() {
        if (this.getLastmode() != 1) {
            this.fireSMEvent(0, 101);
        }
    }

    @Override
    public void switch2Media() {
        if (this.getLastmode() != 2 && this.getLastmode() != 38) {
            this.fireSMEvent(0, 102);
        }
    }

    @Override
    public void showSdsStatusPopup(int n) {
    }

    @Override
    public void showDiagPopup(int n) {
    }

    public void removeDiagPopup() {
    }

    @Override
    public void showEngineOffPopup(int n) {
    }

    @Override
    public void removeEngineOffPopup(int n) {
    }

    @Override
    public void removeDiagPopup(int n) {
    }
}

