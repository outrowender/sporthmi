/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.power.IPowerManager;
import de.audi.tghu.power.PowerFSM;
import de.audi.tghu.power.PowerFSM$State;

final class PowerFSM$On
extends PowerFSM$State {
    private final /* synthetic */ PowerFSM this$0;

    public PowerFSM$On(PowerFSM powerFSM) {
        this.this$0 = powerFSM;
        super(powerFSM, 0, IPowerManager.HMI_STATE_NAMES[0]);
    }

    @Override
    protected void onEnter() {
        super.onEnter();
        PowerFSM.access$500(this.this$0).processOn(PowerFSM.access$600(this.this$0), PowerFSM.access$200(this.this$0));
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
        switch (PowerFSM.access$900(this.this$0)) {
            case 1: {
                this.setDSIDisplayManagement();
                break;
            }
            case 2: {
                if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive()) {
                    PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore On.triggerOn() # isSeatControlActive=%1, isRearviewActive=%2, isDriveSelectActive=%3", PowerFSM.access$600(this.this$0).isSeatControlActive(), PowerFSM.access$600(this.this$0).isRearviewActive(), PowerFSM.access$600(this.this$0).isDriveSelectActive());
                    break;
                }
                PowerFSM.access$800(this.this$0, PowerFSM.access$1300(this.this$0));
                break;
            }
        }
    }

    @Override
    protected void triggerOnDiag() {
        PowerFSM.access$1402(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerOnTel() {
        PowerFSM.access$1402(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerOnSWDL() {
        PowerFSM.access$1402(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerStandby(int n) {
        if (PowerFSM.access$600(this.this$0).isSteeringInterventionActive()) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
        } else if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive() && n != 6) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
        } else if (!PowerFSM.access$600(this.this$0).getCarClampState().isClampS()) {
            this.sendWLCMessage();
            if ((PowerFSM.access$600(this.this$0).isWirelessChargingActive() || PowerFSM.access$600(this.this$0).isOnlineHintActive()) && n != 6) {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
            } else {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
            }
        } else {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerStandbyRestricted() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1000(this.this$0));
    }

    @Override
    protected void triggerCustomerSWDL() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
    }

    @Override
    protected void triggerStandbyPwrSave() {
        if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive() || PowerFSM.access$600(this.this$0).isSteeringInterventionActive()) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore On.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2, isDriveSelectActive=%3", PowerFSM.access$600(this.this$0).isSeatControlActive(), PowerFSM.access$600(this.this$0).isRearviewActive(), PowerFSM.access$600(this.this$0).isDriveSelectActive());
        } else if (!PowerFSM.access$600(this.this$0).getCarClampState().isClampS()) {
            if (!PowerFSM.access$600(this.this$0).isWirelessChargingActive()) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "PowerFSM: On.triggerStandbyPwrSave(): sendWLCMessage() because !extPSData.isWirelessChargingActive()");
                this.sendWLCMessage();
            } else {
                PowerFSM.access$300(this.this$0).log(-2137614336, "PowerFSM: On.triggerStandbyPwrSave(): sendWLCMessage() suppressed");
            }
            if (PowerFSM.access$600(this.this$0).isWirelessChargingActive()) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore On.triggerStandbyPwrSave() # isWirelessChargingActive=%1", PowerFSM.access$600(this.this$0).isWirelessChargingActive());
            } else {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
            }
        } else {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerUrgentTmc(boolean bl) {
        if (!bl) {
            if (PowerFSM.access$1500(this.this$0)) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore On.triggerUrgentTmc() while phone is active!");
            } else if (this.checkOnCondition()) {
                PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore On.triggerUrgentTmc() while relevant external power states are active!");
            } else {
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
    }

    private boolean checkOnCondition() {
        return PowerFSM.access$600(this.this$0).isSeatControlActive() || PowerFSM.access$600(this.this$0).isRearviewActive() || PowerFSM.access$600(this.this$0).isQ21MessageActive() || PowerFSM.access$600(this.this$0).isUrgentTmcActive() || PowerFSM.access$600(this.this$0).isWirelessChargingActive();
    }

    @Override
    protected void setAudioDeviceService() {
        PowerFSM.access$500(this.this$0).getPwrAudioHandler().demute(PowerFSM.access$200(this.this$0));
    }

    @Override
    protected void setHMIReady() {
        if (PowerFSM.access$600(this.this$0).isQ21MessageActive()) {
            PowerFSM.access$500(this.this$0).showQ21Warning(PowerFSM.access$600(this.this$0).isHMIReady(), PowerFSM.access$200(this.this$0));
        }
    }

    @Override
    protected void setAMAvailable() {
        PowerFSM.access$500(this.this$0).getPwrAudioHandler().demute(PowerFSM.access$200(this.this$0));
    }

    @Override
    protected void releaseStanbyMute() {
        PowerFSM.access$500(this.this$0).getPwrAudioHandler().demute(PowerFSM.access$200(this.this$0));
    }

    @Override
    protected void displayButtonTyped() {
        PowerFSM.access$902(this.this$0, 2);
        PowerFSM.access$800(this.this$0, PowerFSM.access$1300(this.this$0));
    }

    @Override
    protected void hardKeyTyped() {
        PowerFSM.access$902(this.this$0, 1);
    }

    @Override
    protected void setDSIDisplayManagement() {
        PowerFSM.access$500(this.this$0).getNativeDisplayHandler().activateDisplay(PowerFSM.access$200(this.this$0), PowerFSM.access$600(this.this$0));
    }

    @Override
    protected void triggerQ0() {
        if (!PowerFSM.access$600(this.this$0).isAnyCarPopupActive() && !PowerFSM.access$1600(this.this$0)) {
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
    protected void triggerCarStateChange(boolean bl) {
        if (!(bl || PowerFSM.access$600(this.this$0).isAnyCarPopupActive() || PowerFSM.access$1600(this.this$0) || PowerFSM.access$600(this.this$0).isQ21MessageActive())) {
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
}

