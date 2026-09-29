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

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy this$4;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown(TMDeviceControl$SM$BaseState$DiscoveredState$Busy tMDeviceControl$SM$BaseState$DiscoveredState$Busy) {
        this.this$4 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy;
        super(null);
    }

    @Override
    protected void handleDelete() {
        TMDeviceControl$SM.access$4300(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))), TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))).getCurrentMessage());
    }

    private long getTimeoutConnectorDependent() {
        return TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))).getConfiguration().usesOldMediaConnector() ? 0 : 0;
    }

    static /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy access$4400(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown) {
        return tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.this$4;
    }

    static /* synthetic */ long access$4800(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown) {
        return tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.getTimeoutConnectorDependent();
    }
}

