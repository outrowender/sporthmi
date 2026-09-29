/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.power.IPowerManager;
import de.audi.tghu.power.PowerFSM;
import de.audi.tghu.power.PowerFSM$State;

final class PowerFSM$OnMute
extends PowerFSM$State {
    private final /* synthetic */ PowerFSM this$0;

    public PowerFSM$OnMute(PowerFSM powerFSM) {
        this.this$0 = powerFSM;
        super(powerFSM, 4, IPowerManager.HMI_STATE_NAMES[4]);
    }

    @Override
    protected void onEnter() {
        super.onEnter();
        PowerFSM.access$500(this.this$0).processOnMute(PowerFSM.access$600(this.this$0), PowerFSM.access$200(this.this$0));
    }

    @Override
    protected void onExit() {
        super.onExit();
    }

    @Override
    protected void triggerOff() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
    }

    @Override
    protected void triggerOn() {
        if (PowerFSM.access$900(this.this$0) == 0 || PowerFSM.access$900(this.this$0) == 1) {
            PowerFSM.access$902(this.this$0, 1);
            PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
        }
    }

    @Override
    protected void displayButtonTyped() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
    }

    @Override
    protected void hardKeyTyped() {
        PowerFSM.access$902(this.this$0, 1);
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerStandby(int n) {
        if (PowerFSM.access$600(this.this$0).isSteeringInterventionActive()) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerStandby() # steeringInterventionActive");
        } else if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive() && n != 6) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerStandby() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.access$600(this.this$0).isSeatControlActive(), PowerFSM.access$600(this.this$0).isRearviewActive());
        } else if (!PowerFSM.access$600(this.this$0).getCarClampState().isClampS()) {
            this.sendWLCMessage();
            if (PowerFSM.access$600(this.this$0).isWirelessChargingActive() && n != 6) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerStandby() # isWirelessChargingActive=%1", PowerFSM.access$600(this.this$0).isWirelessChargingActive());
            } else {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
            }
        } else if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive()) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerStandby() # isSeatControlActive=%1, isRearviewActive=%2, isDriveSelectActive=%3", PowerFSM.access$600(this.this$0).isSeatControlActive(), PowerFSM.access$600(this.this$0).isRearviewActive(), PowerFSM.access$600(this.this$0).isDriveSelectActive());
        } else {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerStandbyRestricted() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1000(this.this$0));
    }

    @Override
    protected void triggerOnDiag() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerOnSWDL() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerStandbyPwrSave() {
        if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive() || PowerFSM.access$600(this.this$0).isSteeringInterventionActive()) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.access$600(this.this$0).isSeatControlActive(), PowerFSM.access$600(this.this$0).isRearviewActive());
        } else if (!PowerFSM.access$600(this.this$0).getCarClampState().isClampS()) {
            if (!PowerFSM.access$600(this.this$0).isWirelessChargingActive()) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "PowerFSM: OnMute.triggerStandbyPwrSave(): sendWLCMessage() because !extPSData.isWirelessChargingActive()");
                this.sendWLCMessage();
            } else {
                PowerFSM.access$300(this.this$0).log(-2137614336, "PowerFSM: OnMute.triggerStandbyPwrSave(): sendWLCMessage() suppressed");
            }
            if (PowerFSM.access$600(this.this$0).isWirelessChargingActive()) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerStandbyPwrSave() # isWirelessChargingActive=%1", PowerFSM.access$600(this.this$0).isWirelessChargingActive());
            } else {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
            }
        } else {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void setDSIDisplayManagement() {
        PowerFSM.access$500(this.this$0).getNativeDisplayHandler().activateDisplay(PowerFSM.access$200(this.this$0), PowerFSM.access$600(this.this$0));
    }

    @Override
    protected void triggerCarStateChange(boolean bl) {
        if (!(bl || PowerFSM.access$600(this.this$0).isAnyCarPopupActive() || PowerFSM.access$1600(this.this$0) || PowerFSM.access$600(this.this$0).isQ21MessageActive())) {
            switch (PowerFSM.access$900(this.this$0)) {
                case 0: {
                    if (!PowerFSM.access$600(this.this$0).getCarClampState().isClampS()) {
                        this.sendWLCMessage();
                        if (PowerFSM.access$600(this.this$0).isWirelessChargingActive()) {
                            PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
                            break;
                        }
                        PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
                        break;
                    }
                    PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
                    break;
                }
                case 1: {
                    PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
                    break;
                }
                case 2: {
                    PowerFSM.access$800(this.this$0, PowerFSM.access$1300(this.this$0));
                    break;
                }
            }
        }
    }

    @Override
    protected void triggerClimateChange(boolean bl) {
        if (!bl) {
            switch (PowerFSM.access$900(this.this$0)) {
                case 0: {
                    PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
                    break;
                }
                case 1: {
                    PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
                    break;
                }
                case 2: {
                    PowerFSM.access$800(this.this$0, PowerFSM.access$1300(this.this$0));
                    break;
                }
            }
        }
    }

    @Override
    protected void triggerCritTempr() {
        PowerFSM.access$500(this.this$0).processCritcalTemperature(PowerFSM.access$600(this.this$0).isHMIReady(), PowerFSM.access$200(this.this$0));
    }

    @Override
    protected void setAMAvailable() {
        PowerFSM.access$500(this.this$0).getPwrAudioHandler().updateAMAvailableFromFSMStandby();
    }

    @Override
    protected void triggerWirelessCharging() {
        if (!(PowerFSM.access$600(this.this$0).isWirelessChargingActive() || PowerFSM.access$600(this.this$0).getCarClampState().isClampS() || PowerFSM.access$600(this.this$0).isAnyCarPopupActive())) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerOnlineHint() {
        if (!(PowerFSM.access$600(this.this$0).isOnlineHintActive() || PowerFSM.access$600(this.this$0).getCarClampState().isClampS() || PowerFSM.access$600(this.this$0).isAnyCarPopupActive())) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerUrgentTmc(boolean bl) {
        if (!bl) {
            if (PowerFSM.access$1500(this.this$0)) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerUrgentTmc() while phone is active!");
            } else if (PowerFSM.access$600(this.this$0).isRearviewActive() || PowerFSM.access$600(this.this$0).isWirelessChargingActive()) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnMute.triggerUrgentTmc() while relevant external power states are active!");
            } else {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
            }
        }
    }
}

