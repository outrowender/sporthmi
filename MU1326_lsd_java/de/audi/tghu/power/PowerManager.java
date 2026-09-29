/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.base.FwServices;
import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.IPowerManager;
import de.audi.tghu.power.ExtPowerState;
import de.audi.tghu.power.PowerAudioHandler;
import de.audi.tghu.power.PowerCommandFactory;
import de.audi.tghu.power.PowerDSIHandler;
import de.audi.tghu.power.PowerDisplayHandler;
import de.audi.tghu.power.PowerFSM;
import org.dsi.ifc.powermanagement.ClampSignal;

public final class PowerManager
implements IPowerManager {
    private final FwServices fwServices;
    private final IFrameworkAccess fw;
    private final LogChannel lc;
    private PowerFSM mainUnitFSM;
    private PowerFSM rearSeatLeftFSM;
    private PowerFSM rearSeatRightFSM;
    private final PowerDSIHandler pwrDSIHandler;
    private final PowerDisplayHandler nativeDisplayHandler;
    private final PowerAudioHandler audioHandler;
    private final PowerCommandFactory pwrCmdFactory;
    final boolean IS_FRONT_MU;

    PowerManager(FwServices fwServices) {
        this.fwServices = fwServices;
        this.fw = fwServices.getFramework();
        this.lc = this.fw.getLogChannel("Fw.Power.Manager");
        this.IS_FRONT_MU = this.fw.isFrontMU();
        this.audioHandler = new PowerAudioHandler(this);
        this.pwrDSIHandler = new PowerDSIHandler(this);
        this.nativeDisplayHandler = new PowerDisplayHandler(this);
        this.pwrCmdFactory = new PowerCommandFactory(this, this.lc);
    }

    FwServices getFwServices() {
        return this.fwServices;
    }

    IFrameworkAccess getFramework() {
        return this.fw;
    }

    public PowerCommandFactory getPwrCmdFactory() {
        return this.pwrCmdFactory;
    }

    public PowerFSM getPowerFSM(int n) {
        PowerFSM powerFSM = null;
        if (n == 0) {
            if (this.mainUnitFSM == null) {
                this.mainUnitFSM = new PowerFSM(n, this);
            }
            powerFSM = this.mainUnitFSM;
        } else if (n == 3) {
            if (this.rearSeatLeftFSM == null) {
                this.rearSeatLeftFSM = new PowerFSM(n, this);
            }
            powerFSM = this.rearSeatLeftFSM;
        } else if (n == 4) {
            if (this.rearSeatRightFSM == null) {
                this.rearSeatRightFSM = new PowerFSM(n, this);
            }
            powerFSM = this.rearSeatRightFSM;
        }
        return powerFSM;
    }

    public PowerDisplayHandler getNativeDisplayHandler() {
        return this.nativeDisplayHandler;
    }

    public PowerDSIHandler getPwrDSIHandler() {
        return this.pwrDSIHandler;
    }

    public PowerAudioHandler getPwrAudioHandler() {
        return this.audioHandler;
    }

    void processOn(ExtPowerState extPowerState, int n) {
        this.lc.log(-2137614336, "processOn() # terminalID=%1", (long)n);
        this.audioHandler.demute(n);
        this.nativeDisplayHandler.activateDisplay(n, extPowerState);
        this.showNoPowerPopups(extPowerState.isHMIReady(), n);
    }

    void processOnNoDisplay(ExtPowerState extPowerState, int n) {
        this.lc.log(-2137614336, "processOnNoDisplay() # terminalID=%1", (long)n);
        this.audioHandler.demute(n);
        this.showBlackScreenLEDsOn(extPowerState.isHMIReady(), n);
        this.nativeDisplayHandler.deactivateDisplay(n);
    }

    void processStandby(ExtPowerState extPowerState, int n) {
        this.lc.log(-2137614336, "processStandby() # terminalID=%1", (long)n);
        this.audioHandler.mute(n);
        this.showBlackScreenLEDsOff(extPowerState.isHMIReady(), n);
        this.nativeDisplayHandler.deactivateDisplay(n);
    }

    void processOnMute(ExtPowerState extPowerState, int n) {
        this.lc.log(-2137614336, "processOnMute() # terminalID=%1", (long)n);
        this.audioHandler.mute(n);
        this.showNoPowerPopups(extPowerState.isHMIReady(), n);
        this.nativeDisplayHandler.activateDisplay(n, extPowerState);
    }

    private IAppSystem getAppSystemVariant() {
        return this.fw.getSysApp().getVariantAppSystem();
    }

    private void showNoPowerPopups(boolean bl, int n) {
        if (bl) {
            this.lc.log(-2137614336, "show no power pop-ups");
            this.getAppSystemVariant().showNoPowerPopups(n);
        }
    }

    private void showBlackScreenLEDsOn(boolean bl, int n) {
        if (bl) {
            this.lc.log(-2137614336, "show black screen (LED=on)");
            this.getAppSystemVariant().showBlackScreenLEDsOn(n);
        }
    }

    private void showBlackScreenLEDsOff(boolean bl, int n) {
        if (bl) {
            this.lc.log(-2137614336, "show black screen (LED=off)");
            this.getAppSystemVariant().showBlackScreenLEDsOff(n);
        }
    }

    protected void showQ21Warning(boolean bl, int n) {
        if (bl) {
            this.lc.log(-2137614336, "show Q21 warning");
            this.getAppSystemVariant().showQ21Warning(n);
        }
    }

    protected void removeQ21Warning(boolean bl, int n) {
        if (bl) {
            this.lc.log(-2137614336, "remove Q21 warning");
            this.getAppSystemVariant().removeQ21Warning(n);
        }
    }

    public void processCritcalTemperature(boolean bl, int n) {
        if (bl) {
            this.lc.log(-2137614336, "show temperature warning | show no power pop-ups | system will shut down");
            this.getAppSystemVariant().showCritcalTemperature(n);
            this.nativeDisplayHandler.processCriticalTemreture(n);
        }
    }

    public void updateDiag(boolean bl, boolean bl2, int n) {
        if (bl2) {
            if (bl) {
                this.getAppSystemVariant().showDiagPopup(n);
            } else {
                this.getAppSystemVariant().removeDiagPopup(n);
            }
        }
    }

    @Override
    public void setHMIReady() {
        this.lc.log(-2137614336, "setHMIReady()");
        this.pwrCmdFactory.setHMIReadyCmd();
    }

    @Override
    public void releaseStandbyMute() {
        this.lc.log(-2137614336, "releaseStandbyMute()");
        this.pwrCmdFactory.releaseStandbyMuteCmd();
    }

    @Override
    public void displayButtonTyped(int n, int n2) {
        this.lc.log(-2137614336, "displayButtonTyped(terminalID=%1, key=%2)", (long)n, (long)n2);
        this.pwrCmdFactory.setDispButtonTypedCmd(n2, n);
    }

    @Override
    public void hardKeyTyped(int n, int n2) {
        this.lc.log(-2137614336, "hardKeyTyped(terminalID=%1, key=%2)", (long)n, (long)n2);
        this.pwrCmdFactory.setHardKeyTypedCmd(n2, n);
    }

    public String getCurrentPowerStateName(int n) {
        return this.getPowerFSM(n).getCurrentPSName();
    }

    @Override
    public void setExtendedPowerState(int n, int n2) {
        this.lc.log(-2137614336, "setExtendedPowerState(state=%1, terminalID=%2)", (long)n, (long)n2);
        if (n == 160) {
            this.getPowerFSM(n2).getExtPowerState().setWirelessChargingActive();
            this.lc.log(-2137614336, "setExtendedPowerState(): set WirelessChargingActive");
        }
        if (n == 166) {
            this.getPowerFSM(n2).getExtPowerState().setOnlineHintActive();
            this.lc.log(-2137614336, "setExtendedPowerState(): set OnlineHintActive");
        }
        this.pwrCmdFactory.setExtPwrStateCmd(n, n2);
    }

    @Override
    public void setPowerState(int n, int n2) {
        this.lc.log(-2137614336, "setPowerState(state=%1, terminalID=%2)", (long)n, (long)n2);
        switch (n2) {
            case 0: 
            case 3: {
                this.getPwrDSIHandler().updatePowerManagementState(n, -1, 1);
                break;
            }
            case 4: {
                this.getPwrDSIHandler().updatePowerManagementStateRight(n, -1, 1);
                break;
            }
            default: {
                this.lc.log(-2137614336, "Power state is ignored! (state=%1, terminal=%2)", (long)n, (long)n2);
            }
        }
    }

    @Override
    public void comboKeyLastonMmiIocPressed() {
        this.pwrDSIHandler.setLaston(3);
    }

    @Override
    public void rebootSystem() {
        this.pwrDSIHandler.rebootSystem();
    }

    @Override
    public void rebootSystemCritical(boolean bl) {
        this.pwrDSIHandler.rebootSystem(bl);
    }

    @Override
    public void keyPTTPressed() {
        this.pwrCmdFactory.setKeyPTTPressedCmd();
    }

    @Override
    public void updateClampSignal(boolean bl, boolean bl2) {
        this.getPwrCmdFactory().setClampSStateCmd(new ClampSignal(bl, bl2, false, false));
    }

    public void clamp15TurnedOff(int n) {
        this.getAppSystemVariant().showEngineOffPopup(n);
    }

    public void clamp15TurnedOn(int n) {
        this.getAppSystemVariant().removeEngineOffPopup(n);
    }
}

