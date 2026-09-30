/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.power.ExtPowerState;
import de.audi.tghu.power.PowerManager;
import org.dsi.ifc.displaycontroller.DSIDisplayController;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;

final class PowerDisplayHandler
implements DSIDisplayManagementListener,
TimerListener {
    private final PowerManager pwrMgr;
    private final LogChannel lc;
    private DSIKeyPanel dsiKeyPanel;
    private DSIDisplayManagement dsiDisplay;
    private DSIDisplayController dsiDisplayController;
    private Timer displayOvertempCloseTimer;

    PowerDisplayHandler(PowerManager powerManager) {
        this.pwrMgr = powerManager;
        this.lc = powerManager.getFramework().getLogChannel("Fw.Power.Display");
    }

    void processCriticalTemreture(int n) {
        if (this.displayOvertempCloseTimer == null) {
            this.displayOvertempCloseTimer = new Timer("DisplayCloseTimer", 11000L, true, this);
        }
        this.displayOvertempCloseTimer.restart();
        this.lc.log(10000000, "displayOvertempCloseTimer started");
    }

    public void cancelTimer(Timer timer) {
    }

    private IAppSystem getAppSystemVariant() {
        return this.pwrMgr.getFramework().getSysApp().getVariantAppSystem();
    }

    public void fireTimer(Timer timer) {
        if (timer.equals(this.displayOvertempCloseTimer)) {
            this.lc.log(10000000, "displayOvertempCloseTimer fired");
            if (this.pwrMgr.IS_FRONT_MU) {
                if (!this.pwrMgr.getFramework().getSysApp().isEngineeringDownloadActive()) {
                    this.pwrMgr.getPwrCmdFactory().setPwrStateCmd(2, -1, 0);
                }
                this.getAppSystemVariant().removeCritcalTemperature(0);
            } else {
                if (!this.pwrMgr.getFramework().getSysApp().isEngineeringDownloadActive()) {
                    this.pwrMgr.getPwrCmdFactory().setPwrStateCmd(2, -1, 3);
                    this.pwrMgr.getPwrCmdFactory().setPwrStateCmd(2, -1, 4);
                }
                this.getAppSystemVariant().removeCritcalTemperature(3);
                this.getAppSystemVariant().removeCritcalTemperature(4);
            }
        }
    }

    public void setDSIKeyPanel(DSIKeyPanel dSIKeyPanel) {
        this.lc.log(10000000, "setDSIKeyPanel # dsi=%1", (Object)dSIKeyPanel);
        this.dsiKeyPanel = dSIKeyPanel;
    }

    public void setDSIDisplayManagement(DSIDisplayManagement dSIDisplayManagement) {
        this.lc.log(10000000, "setDSIDisplayManagement # dsi=%1", (Object)dSIDisplayManagement);
        this.dsiDisplay = dSIDisplayManagement;
        this.pwrMgr.getPowerFSM(0).setDSIDisplayManagement();
    }

    public void setDSIDisplayController(DSIDisplayController dSIDisplayController) {
        this.lc.log(10000000, "setDSIDisplayManagement # dsi=%1", (Object)dSIDisplayController);
        this.dsiDisplayController = dSIDisplayController;
    }

    void activateDisplay(int n, ExtPowerState extPowerState) {
        this.lc.log(10000000, "activateDisplay # terminalID=%1", (long)n);
        this.switchDisplayPowerState(n, 1);
        this.switchDisplayTurnState(true);
        if (this.dsiDisplayController != null) {
            this.dsiDisplayController.switchDisplayPower(0, 1, extPowerState.isRearviewActive() ? 2 : 1);
        }
    }

    void deactivateDisplay(int n) {
        this.lc.log(10000000, "deactivateDisplay # terminalID=%1", (long)n);
        this.switchDisplayPowerState(n, 0);
        this.switchDisplayTurnState(false);
        if (this.dsiDisplayController != null) {
            this.dsiDisplayController.switchDisplayPower(0, 0, 0);
        }
    }

    private void switchDisplayPowerState(int n, int n2) {
        int n3 = n == 0 ? 0 : (n == 3 ? 2 : 2);
        this.lc.log(10000000, "switchDisplayPowerState # displayID=%1, state=%2", (long)n3, (long)n2);
        if (this.dsiDisplay != null) {
            this.dsiDisplay.switchDisplayPower(n3, n2);
        }
    }

    private void switchDisplayTurnState(boolean bl) {
        this.lc.log(10000000, "switchDisplayTurnState # state=%1", bl);
        if (this.dsiKeyPanel != null) {
            this.lc.log(10000000, "DSIKeyPanel <- setTMDisplayState(displayState=%1)", bl);
            this.dsiKeyPanel.setTMDisplayState(bl);
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "errorCode=%2, errorMsg=%, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public void getDisplayPower(int n, int n2) {
        this.lc.log(10000000, "-> DSIDisplayManagement.getDisplayPower(displayID=%1, state=%2)", (long)n, (long)n2);
    }

    public void fadeComplete(int n, int n2) {
        this.lc.log(10000000, "fadeComplete(cid=%1, displayID=%2)", (long)n, (long)n2);
    }

    public void fadeStarted(int n, int n2) {
        this.lc.log(10000000, "fadeStarted(cid=%1, displayID=%2)", (long)n, (long)n2);
    }

    public void getBrightness(int n, int n2) {
    }

    public void getColor(int n, int n2) {
    }

    public void getContrast(int n, int n2) {
    }

    public void getExtents(int n, int n2, int n3) {
    }

    public void getTint(int n, int n2) {
    }

    public void activeContext(int n, int n2, int n3) {
    }

    public void getDisplayBrightness(int n, int n2) {
    }

    public void lockDisplayResult(int n) {
    }

    public void unlockDisplayResult(int n) {
    }

    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
    }

    public void getDisplayableInfo(int n, int n2, int n3) {
    }

    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
    }

    public void setDisplayTypeResult(int n, int n2) {
    }

    public void getDisplayTypeResult(int n, int n2) {
    }

    public void setUpdateRateResult(int n, int n2) {
    }

    public void getUpdateRateResult(int n, int n2) {
    }

    public void startComponentResult(int n, int n2, int n3, int n4) {
    }

    public void stopComponentResult(int n, int n2, int n3, int n4) {
    }

    public void setAnnotationDataResponse(int n, int n2) {
    }

    public void initAnnotationsResponse(int n, int n2) {
    }

    public void destroyImageDisplayableResponse(int n, int n2) {
    }

    public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    public void createImageDisplayableResponse(int n, int n2) {
    }
}

