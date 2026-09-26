/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.power.PowerFSM;
import de.audi.tghu.power.PowerManager;
import org.dsi.ifc.powermanagement.ClampSignal;

public final class ExtPowerState {
    private final PowerManager pwrMgr;
    private boolean climateActive;
    private boolean phoneActive;
    private boolean q21active;
    private boolean q4active;
    private boolean rearviewActive;
    private boolean steeringInterventionActive;
    private boolean customerDownloadActive;
    private boolean seatControlActive;
    private boolean driveSelectActive;
    private boolean wirelessChargingActive;
    private boolean onlineHintActive;
    private boolean telMaxActive;
    private boolean onlinePannenrufActive;
    private boolean sosActive;
    private boolean urgentTmcActive;
    private ClampSignal carClampState = new ClampSignal();
    private boolean hmiReady;
    private PowerFSM powerFSM;
    private final LogChannel fsmLog;
    private final LogChannel extLog;
    private int terminalID;

    public ExtPowerState(PowerManager powerManager, LogChannel logChannel, LogChannel logChannel2, int n) {
        this.pwrMgr = powerManager;
        this.fsmLog = logChannel;
        this.extLog = logChannel2;
        this.terminalID = n;
    }

    public boolean isHMIReady() {
        return this.hmiReady;
    }

    public void setHMIReady(boolean bl) {
        this.hmiReady = bl;
    }

    public boolean isClimateActive() {
        return this.climateActive;
    }

    public boolean isPhoneActive() {
        return this.phoneActive;
    }

    public boolean isQ21MessageActive() {
        return this.q21active;
    }

    public boolean isQ4Active() {
        return this.q4active;
    }

    public boolean isRearviewActive() {
        return this.rearviewActive;
    }

    public boolean isCustomerDownloadActive() {
        return this.customerDownloadActive;
    }

    public boolean isSeatControlActive() {
        return this.seatControlActive;
    }

    public boolean isDriveSelectActive() {
        return this.driveSelectActive;
    }

    public boolean isSteeringInterventionActive() {
        return this.steeringInterventionActive;
    }

    public boolean isWirelessChargingActive() {
        return this.wirelessChargingActive;
    }

    public void setWirelessChargingActive() {
        this.wirelessChargingActive = true;
    }

    public void setOnlineHintActive() {
        this.onlineHintActive = true;
    }

    public boolean isOnlineHintActive() {
        return this.onlineHintActive;
    }

    public boolean isTelMaxActive() {
        return this.telMaxActive;
    }

    public boolean isOnlinePannenrufActive() {
        return this.onlinePannenrufActive;
    }

    public boolean isSosActive() {
        return this.sosActive;
    }

    public boolean isUrgentTmcActive() {
        return this.urgentTmcActive;
    }

    public void setCarClampState(ClampSignal clampSignal) {
        this.carClampState = clampSignal;
    }

    public ClampSignal getCarClampState() {
        return this.carClampState;
    }

    void setExtendedPowerState(int n, PowerFSM powerFSM) {
        this.fsmLog.log(-2137614336, "processSetExtendedPowerState(state=%1, terminalID=%2)", (long)n, (long)this.terminalID);
        this.extLog.log(-2137614336, "processSetExtendedPowerState(state=%1, terminalID=%2)", (long)n, (long)this.terminalID);
        this.powerFSM = powerFSM;
        if (this.terminalID == 0) {
            switch (n) {
                case 140: {
                    this.processRearview(true);
                    break;
                }
                case 141: {
                    powerFSM.setOriginHMIStateOnRVCtoOn();
                    this.processRearview(false);
                    break;
                }
                case 142: {
                    this.processRearview(false);
                    break;
                }
                case 102: {
                    this.processClimate(true);
                    break;
                }
                case 103: {
                    this.processClimate(false);
                    break;
                }
                case 114: {
                    this.processSeatControl(true);
                    break;
                }
                case 115: {
                    this.processSeatControl(false);
                    break;
                }
                case 132: {
                    this.processDriveSelect(true);
                    break;
                }
                case 133: {
                    this.processDriveSelect(false);
                    break;
                }
                case 150: {
                    this.processSteeringIntervention(true);
                    break;
                }
                case 151: {
                    this.processSteeringIntervention(false);
                    break;
                }
                case 160: {
                    this.processWirelessCharging(true);
                    break;
                }
                case 161: {
                    this.processWirelessCharging(false);
                    break;
                }
                case 166: {
                    this.processOnlineHint(true);
                    break;
                }
                case 167: {
                    this.processOnlineHint(false);
                    break;
                }
                case 162: {
                    this.processOnlinePannenruf(true);
                    break;
                }
                case 163: {
                    this.processOnlinePannenruf(false);
                    break;
                }
                case 164: {
                    this.processSos(true);
                    break;
                }
                case 165: {
                    this.processSos(false);
                    break;
                }
                case 200: {
                    this.processUrgentTmc(true);
                    break;
                }
                case 201: {
                    this.processUrgentTmc(false);
                    break;
                }
            }
        }
        switch (n) {
            case 106: {
                this.processQ21(true);
                break;
            }
            case 107: {
                this.processQ4(true);
                break;
            }
            case 108: {
                if (this.q4active) {
                    this.processQ4(false);
                }
                if (!this.q21active) break;
                this.processQ21(false);
                break;
            }
            case 130: {
                this.processTelMaxPopup(true);
                break;
            }
            case 131: {
                this.processTelMaxPopup(false);
                break;
            }
        }
    }

    private void processOnlinePannenruf(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processOnlinePannenruf(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processOnlinePannenruf(%1)", bl);
        if (this.onlinePannenrufActive != bl) {
            this.onlinePannenrufActive = bl;
            this.powerFSM.triggerCarStateChange(this.onlinePannenrufActive);
        }
    }

    private void processSos(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processSos(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processSos(%1)", bl);
        if (this.sosActive != bl) {
            this.sosActive = bl;
            this.powerFSM.triggerCarStateChange(this.sosActive);
        }
    }

    private void processRearview(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processRearview(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processRearview(%1)", bl);
        if (this.rearviewActive != bl) {
            this.rearviewActive = bl;
            this.powerFSM.triggerCarStateChange(this.rearviewActive);
        }
    }

    private void processSeatControl(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processSeatControl(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processSeatControl(%1)", bl);
        if (this.seatControlActive != bl) {
            this.seatControlActive = bl;
            this.powerFSM.triggerCarStateChange(this.seatControlActive);
        }
    }

    private void processSteeringIntervention(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processSteeringIntervention(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processSteeringIntervention(%1)", bl);
        if (this.steeringInterventionActive != bl) {
            this.steeringInterventionActive = bl;
        }
    }

    private void processDriveSelect(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processDriveSelect(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processDriveSelect(%1)", bl);
        if (this.driveSelectActive != bl) {
            this.driveSelectActive = bl;
            this.powerFSM.triggerCarStateChange(this.driveSelectActive);
        }
    }

    private void processWirelessCharging(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processWirelessCharging(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processWirelessCharging(%1)", bl);
        if (this.wirelessChargingActive != bl) {
            this.wirelessChargingActive = bl;
            this.powerFSM.triggerWirelessCharging();
        }
    }

    private void processOnlineHint(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processOnlineHint(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processOnlineHint(%1)", bl);
        if (this.onlineHintActive != bl) {
            this.onlineHintActive = bl;
            this.powerFSM.triggerOnlineHint();
        }
    }

    public boolean isAnyCarPopupActive() {
        return this.driveSelectActive || this.seatControlActive || this.rearviewActive || this.onlinePannenrufActive || this.sosActive;
    }

    private void processQ4(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processQ4(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processQ4(%1)", bl);
        if (this.q4active != bl) {
            this.q4active = bl;
        }
    }

    private void processQ21(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processQ21(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processQ21(%1)", bl);
        if (this.q21active != bl) {
            this.q21active = bl;
            if (this.q21active) {
                this.pwrMgr.showQ21Warning(this.hmiReady, this.terminalID);
                this.powerFSM.triggerQ21();
            } else {
                this.powerFSM.triggerQ0();
                this.pwrMgr.removeQ21Warning(this.hmiReady, this.terminalID);
            }
        }
    }

    private void processClimate(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processClimate(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processClimate(%1)", bl);
        if (this.climateActive != bl) {
            this.climateActive = bl;
            this.powerFSM.triggerClimateChange(this.climateActive);
        }
    }

    private IAppSystem getAppSystemVariant() {
        return this.pwrMgr.getFramework().getSysApp().getVariantAppSystem();
    }

    private void processTelMaxPopup(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processTelMaxPopup(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processTelMaxPopup(%1)", bl);
        if (this.telMaxActive != bl) {
            this.telMaxActive = bl;
            if (this.telMaxActive) {
                if (this.isHMIReady()) {
                    this.getAppSystemVariant().showTelMaxWarning(0);
                }
            } else if (this.isHMIReady()) {
                this.getAppSystemVariant().removeTelMaxWarning(0);
            }
        }
    }

    private void processUrgentTmc(boolean bl) {
        this.fsmLog.log(-2137614336, "ExtPowerState.processUrgentTmc(%1)", bl);
        this.extLog.log(-2137614336, "ExtPowerState.processUrgentTmc(%1)", bl);
        if (this.urgentTmcActive != bl) {
            this.urgentTmcActive = bl;
            this.powerFSM.triggerUrgentTmc(this.urgentTmcActive);
        }
    }
}

