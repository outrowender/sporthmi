/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.hmi.KbdService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.util.CommandLineExecuter;
import de.audi.tghu.power.PowerManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;
import org.osgi.framework.ServiceReference;

public final class PowerDSIHandler
implements DSIPowerManagementListener,
MsgListener {
    private final PowerManager pwrMgr;
    private DSIPowerManagement dsiPwr;
    private final Object syncDSI = new Object();
    private final LogChannel lc;
    private boolean dsiAvailable;
    private boolean slayJ9Pending;
    private ChoiceModelApp powerWarningPopupStateModel;
    static /* synthetic */ Class class$de$audi$atip$hmi$KbdService;

    PowerDSIHandler(PowerManager powerManager) {
        this.pwrMgr = powerManager;
        this.lc = powerManager.getFramework().getLogChannel("Fw.Power.DSI");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void waitForDSIPower() {
        this.lc.log(-2137614336, "waitForDSIPower()");
        Object object = this.syncDSI;
        synchronized (object) {
            if (!this.dsiAvailable) {
                this.lc.log(-2137614336, "Wait up to 5 seconds for DSIPowerManagement");
                try {
                    this.syncDSI.wait(0);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            if (this.dsiAvailable) {
                this.lc.log(-2137614336, "DSIPowerManagement is available");
            } else {
                this.lc.log(-2137614336, "DSIPowerManagement is not available!");
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "errorCode=%2, errorMsg=%1, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updatePowerManagementStateRight(int n, int n2, int n3) {
        this.lc.log(-2137614336, "-> updatePowerManagementStateRight(stateRight=%1, powerEvent=%2, validFlag=%2)", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            if (!this.pwrMgr.IS_FRONT_MU) {
                this.pwrMgr.getPwrCmdFactory().setPwrStateCmd(n, n2, 4);
            }
            if (n == 2 && this.slayJ9Pending) {
                this.slayJ9Pending = false;
                this.slayJ9();
            }
        }
    }

    @Override
    public void updatePowerManagementState(int n, int n2, int n3) {
        this.lc.log(-2137614336, "-> updatePowerManagementState(state=%1, powerEvent=%2, validFlag=%3)", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            if (this.pwrMgr.IS_FRONT_MU) {
                this.pwrMgr.getPwrCmdFactory().setPwrStateCmd(n, n2, 0);
            } else {
                this.pwrMgr.getPwrCmdFactory().setPwrStateCmd(n, n2, 3);
            }
            if (n == 2 && this.slayJ9Pending) {
                this.slayJ9Pending = false;
                this.slayJ9();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setPwrMgmtDsi(DSIPowerManagement dSIPowerManagement) {
        this.lc.log(-2137614336, "dsi=%1", (Object)dSIPowerManagement);
        this.dsiPwr = dSIPowerManagement;
        this.dsiPwr.setNotification(new int[]{1, 5, 3, 4, 6, 8, 11}, (DSIListener)this);
        Object object = this.syncDSI;
        synchronized (object) {
            this.dsiAvailable = true;
            this.syncDSI.notifyAll();
        }
    }

    void setHMIReady() {
        this.lc.log(-2137614336, "setHMIReady()");
        try {
            this.waitForDSIPower();
            if (this.dsiPwr != null) {
                this.dsiPwr.setHMIReady();
            } else {
                this.lc.log(10000, "DSIPowerManagement is not yet available!");
            }
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NullPointerException: ", (Throwable)nullPointerException);
        }
    }

    void rebootSystem() {
        this.lc.log(-2137614336, "rebootSystem()");
        if (this.dsiPwr != null) {
            this.dsiPwr.rebootSystem();
        }
    }

    void rebootSystem(boolean bl) {
        this.lc.log(-2137614336, "rebootSystem # slayJ9Flag=%1", bl);
        if (this.dsiPwr != null) {
            if (bl) {
                this.pwrMgr.getFramework().getHMIService().getEventDispatcherAdmin().setPriority(5);
                this.slayJ9Pending = true;
                this.slayJ9();
            }
            this.dsiPwr.rebootSystemCritical();
        }
    }

    void setLaston(int n) {
    }

    void setChildProtectionStatus(boolean bl) {
        this.lc.log(-2137614336, "setChildProtectionStatus # isProtected=%1", bl);
        if (this.dsiPwr != null) {
            this.dsiPwr.setChildLockRSE(bl ? 1 : 0);
        }
    }

    private void slayJ9() {
        System.out.println("Slaying the J9 with SIGNAL 11");
        CommandLineExecuter.executeCommand("slay", new String[]{System.getProperty("jvm.kill.signal", "-s11"), "j9"});
    }

    @Override
    public void updateBEMState(int n, int n2) {
        this.lc.log(-2137614336, "-> updateBEMState(updateBEMState=%1, validFlag=%2)", (long)n, (long)n2);
        if (n2 == 1) {
            switch (n) {
                case 6: {
                    if (this.pwrMgr.IS_FRONT_MU) {
                        this.pwrMgr.setExtendedPowerState(106, 0);
                        break;
                    }
                    this.pwrMgr.setExtendedPowerState(106, 3);
                    this.pwrMgr.setExtendedPowerState(106, 4);
                    break;
                }
                case 4: {
                    if (this.pwrMgr.IS_FRONT_MU) {
                        this.pwrMgr.setExtendedPowerState(107, 0);
                        break;
                    }
                    this.pwrMgr.setExtendedPowerState(107, 3);
                    this.pwrMgr.setExtendedPowerState(107, 4);
                    break;
                }
                case 0: {
                    if (this.pwrMgr.IS_FRONT_MU) {
                        this.pwrMgr.setExtendedPowerState(108, 0);
                        break;
                    }
                    this.pwrMgr.setExtendedPowerState(108, 3);
                    this.pwrMgr.setExtendedPowerState(108, 4);
                    break;
                }
            }
        }
    }

    @Override
    public void updateClampSignal(ClampSignal clampSignal, int n) {
        this.lc.log(-2137614336, "-> updateClampSignal(clampSignal=%1, validFlag=%2)", (Object)clampSignal, (long)n);
        if (n == 1) {
            this.pwrMgr.getPwrCmdFactory().setClampSStateCmd(clampSignal);
        }
    }

    @Override
    public void updateLastOn(int n, int n2) {
        this.lc.log(-2137614336, "updateLastOn(lastOn=%1, validFlag=%2)", (long)n, (long)n2);
    }

    @Override
    public void updateRVCActive(boolean bl, int n) {
        this.lc.log(-2137614336, "updateRVCActive(active=%1, validFlag=%2)", bl, (long)n);
        if (n == 1) {
            this.lc.log(-2137614336, "ignore updateRVCActive, RVC is triggerd from CAR_APP!");
        }
    }

    @Override
    public void updateTelMaxPopup(boolean bl, int n) {
        this.lc.log(-2137614336, "updateTelMaxPopup(showPopup=%1, validFlag=%2)", bl, (long)n);
        if (n == 1) {
            if (bl) {
                this.pwrMgr.setExtendedPowerState(130, 0);
            } else {
                this.pwrMgr.setExtendedPowerState(131, 0);
            }
        }
    }

    @Override
    public void updateSplashScreenAnimation(int n, int n2) {
    }

    @Override
    public void updateChildLockState(int n, int n2) {
        this.lc.log(-2137614336, "updateChildLockState(childLockState=%1, validFlag=%2)", (long)n, (long)n2);
    }

    public void updateSplashScreenAnimationFinished(boolean bl, int n) {
    }

    public void updateCriticalTemperature(boolean bl, int n) {
        this.lc.log(-2137614336, "updateCriticalTemperature(showPopup=%1, validFlag=%2)", bl, (long)n);
        if (n == 1 && bl) {
            this.pwrMgr.getPwrCmdFactory().setPwrStateCmd(3, 7, 0);
        }
    }

    @Override
    public void updateTStandbyPopup(boolean bl, int n) {
        this.lc.log(-2137614336, "updateTStandbyPopup(showPopup=%1, validFlag=%2)", bl, (long)n);
        if (n == 1) {
            try {
                if (bl) {
                    this.setIgnoreFlagForNextMutePress();
                    this.pwrMgr.getFramework().getSysApp().getVariantAppSystem().showStandbyWarning(0);
                    if (this.powerWarningPopupStateModel != null) {
                        this.powerWarningPopupStateModel.setValue(1);
                    }
                } else {
                    this.pwrMgr.getFramework().getSysApp().getVariantAppSystem().removeStandbyWarning(0);
                    if (this.powerWarningPopupStateModel != null) {
                        this.powerWarningPopupStateModel.setValue(0);
                    }
                }
            }
            catch (Exception exception) {
                this.lc.log(-1601830656, "updateTStandbyPopup Exception: %1", (Object)exception.getMessage());
            }
        }
    }

    private void setIgnoreFlagForNextMutePress() {
        try {
            ServiceReference serviceReference = this.pwrMgr.getFramework().getBundleCxt().getServiceReference((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = PowerDSIHandler.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName());
            if (serviceReference != null) {
                KbdService kbdService = (KbdService)this.pwrMgr.getFramework().getBundleCxt().getService(serviceReference);
                kbdService.setIgnoreNextMutePressButtonFlag();
            }
            this.pwrMgr.getFramework().getBundleCxt().ungetService(serviceReference);
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception in setIgnoreFlagForNextMutePress: ", (Throwable)exception);
        }
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 101: {
                this.powerWarningPopupStateModel = this.pwrMgr.getFramework().getHMIService().getChoiceModel(4228);
                this.lc.log(1078071040, "PowerDSIHandler: Modelbank is initialized. Got powerWarningPopupStateModel reference");
                break;
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

