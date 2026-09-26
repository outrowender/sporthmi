/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.power.IPowerManager;
import de.audi.tghu.power.PowerFSM;
import de.audi.tghu.power.PowerFSM$State;

final class PowerFSM$OnNoDisplay
extends PowerFSM$State {
    private final /* synthetic */ PowerFSM this$0;

    public PowerFSM$OnNoDisplay(PowerFSM powerFSM) {
        this.this$0 = powerFSM;
        super(powerFSM, 1, IPowerManager.HMI_STATE_NAMES[1]);
    }

    @Override
    protected void onEnter() {
        super.onEnter();
        PowerFSM.access$500(this.this$0).processOnNoDisplay(PowerFSM.access$600(this.this$0), PowerFSM.access$200(this.this$0));
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
    protected void triggerStandby(int n) {
        if (PowerFSM.access$600(this.this$0).isSteeringInterventionActive()) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "[OnNoDisplay.triggerStandby]-->HMI_ON_MUTE because of isSteeringInterventionActive=%1", PowerFSM.access$600(this.this$0).isSteeringInterventionActive());
            PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
        } else if (!PowerFSM.access$600(this.this$0).getCarClampState().isClampS()) {
            this.sendWLCMessage();
            if (PowerFSM.access$600(this.this$0).isWirelessChargingActive() && n != 6) {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
            } else {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
            }
        } else {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerCritTempr() {
        PowerFSM.access$300(this.this$0).log(-2137614336, "[OnNoDisplay.triggerCritTempr]");
        PowerFSM.access$500(this.this$0).processCritcalTemperature(PowerFSM.access$600(this.this$0).isHMIReady(), PowerFSM.access$200(this.this$0));
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
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
    protected void triggerOnTel() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerCustomerSWDL() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
    }

    @Override
    protected void triggerOnSWDL() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerStandbyPwrSave() {
        if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive() || PowerFSM.access$600(this.this$0).isSteeringInterventionActive()) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore OnNoDisplay.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.access$600(this.this$0).isSeatControlActive(), PowerFSM.access$600(this.this$0).isRearviewActive());
        } else {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerQ21() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerUrgentTmc(boolean bl) {
        if (bl) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
        }
    }

    @Override
    protected void displayButtonTyped() {
        PowerFSM.access$902(this.this$0, 1);
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
        PowerFSM.access$1402(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void hardKeyTyped() {
        PowerFSM.access$902(this.this$0, 1);
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void setHMIReady() {
        PowerFSM.access$500(this.this$0).getPwrAudioHandler().demute(PowerFSM.access$200(this.this$0));
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
    protected void keyPTTPressed() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerCarStateChange(boolean bl) {
        if (bl) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
        }
    }

    @Override
    protected void triggerClimateChange(boolean bl) {
        if (bl) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
        }
    }
}

