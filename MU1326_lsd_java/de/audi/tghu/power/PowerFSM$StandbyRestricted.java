/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.power.IPowerManager;
import de.audi.tghu.power.PowerFSM;
import de.audi.tghu.power.PowerFSM$State;

final class PowerFSM$StandbyRestricted
extends PowerFSM$State {
    private final /* synthetic */ PowerFSM this$0;

    public PowerFSM$StandbyRestricted(PowerFSM powerFSM) {
        this.this$0 = powerFSM;
        super(powerFSM, 3, IPowerManager.HMI_STATE_NAMES[3]);
    }

    @Override
    protected void onEnter() {
        super.onEnter();
        PowerFSM.access$500(this.this$0).processStandby(PowerFSM.access$600(this.this$0), PowerFSM.access$200(this.this$0));
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
    protected void triggerStandby(int n) {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
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
    protected void triggerOnTel() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerCritTempr() {
        PowerFSM.access$300(this.this$0).log(-2137614336, "[StandbyResticted.triggerCritTempr]");
        PowerFSM.access$500(this.this$0).processCritcalTemperature(PowerFSM.access$600(this.this$0).isHMIReady(), PowerFSM.access$200(this.this$0));
    }

    @Override
    protected void triggerStandbyPwrSave() {
        if (PowerFSM.access$600(this.this$0).isAnyCarPopupActive() || PowerFSM.access$600(this.this$0).isSteeringInterventionActive()) {
            PowerFSM.access$300(this.this$0).log(-2137614336, "Ignore StandbyResticted.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.access$600(this.this$0).isSeatControlActive(), PowerFSM.access$600(this.this$0).isRearviewActive());
        } else {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1200(this.this$0));
        }
    }

    @Override
    protected void triggerCarClampState() {
        if (!PowerFSM.access$600(this.this$0).getCarClampState().isClampS()) {
            this.sendWLCMessage();
            if (PowerFSM.access$600(this.this$0).isWirelessChargingActive()) {
                PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
            }
        }
    }
}

