/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.power.IPowerManager;
import de.audi.tghu.power.PowerFSM;
import de.audi.tghu.power.PowerFSM$State;

final class PowerFSM$Standby
extends PowerFSM$State {
    private final /* synthetic */ PowerFSM this$0;

    public PowerFSM$Standby(PowerFSM powerFSM) {
        this.this$0 = powerFSM;
        super(powerFSM, 2, IPowerManager.HMI_STATE_NAMES[2]);
    }

    @Override
    protected void onEnter() {
        PowerFSM.access$500(this.this$0).processStandby(PowerFSM.access$600(this.this$0), PowerFSM.access$200(this.this$0));
        super.onEnter();
    }

    @Override
    protected void onExit() {
        super.onExit();
    }

    @Override
    protected void displayButtonTyped() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void hardKeyTyped() {
        PowerFSM.access$902(this.this$0, 1);
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerOn() {
        if (PowerFSM.access$900(this.this$0) == 0 || PowerFSM.access$900(this.this$0) == 1) {
            PowerFSM.access$902(this.this$0, 1);
            PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
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
    protected void triggerOnTel() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
    }

    @Override
    protected void triggerOnSWDL() {
        PowerFSM.access$800(this.this$0, PowerFSM.access$700(this.this$0));
    }

    @Override
    protected void triggerCarStateChange(boolean bl) {
        if (bl) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
        }
    }

    @Override
    protected void triggerClimateChange(boolean bl) {
        if (bl) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
        }
    }

    @Override
    protected void setHMIReady() {
        this.onEnter();
    }

    @Override
    protected void setAMAvailable() {
        PowerFSM.access$500(this.this$0).getPwrAudioHandler().updateAMAvailableFromFSMStandby();
    }

    @Override
    void triggerStandby(int n) {
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

    @Override
    protected void triggerUrgentTmc(boolean bl) {
        if (bl) {
            PowerFSM.access$800(this.this$0, PowerFSM.access$1100(this.this$0));
        }
    }
}

