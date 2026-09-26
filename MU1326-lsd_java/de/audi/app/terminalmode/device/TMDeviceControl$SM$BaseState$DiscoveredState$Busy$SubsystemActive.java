/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy this$4;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive(TMDeviceControl$SM$BaseState$DiscoveredState$Busy tMDeviceControl$SM$BaseState$DiscoveredState$Busy) {
        this.this$4 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy;
        super(null);
    }

    @Override
    protected void connectionStateFailed(int n) {
        if (n == 4) {
            TMDeviceControl$SM$BaseState$DiscoveredState.access$3308(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4));
        }
        this.handleError();
    }

    @Override
    protected void connectionStateStopped() {
        this.handleError();
    }

    @Override
    protected void connectionStateDisconnected() {
        this.handleError();
    }

    private void handleError() {
        TMDeviceControl$SM.access$4200(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp);
    }

    static /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy access$3600(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive tMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive) {
        return tMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.this$4;
    }
}

