/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown this$5;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown) {
        this.this$5 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown;
        super(null);
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$4500(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5));
    }

    @Override
    protected void cleanupDone() {
        TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$4600(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5));
        TMDeviceControl$SM.access$4700(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
    }
}

