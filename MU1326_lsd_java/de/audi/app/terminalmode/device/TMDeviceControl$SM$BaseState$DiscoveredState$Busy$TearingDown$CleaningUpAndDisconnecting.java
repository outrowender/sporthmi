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

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown this$5;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown) {
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
        TMDeviceControl$SM.access$3100(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5))))).disconnectDevice(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))))).getDeviceId());
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))).sendMessageDelayed(12, "DETACHING_TIMEOUT", TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4800(this.this$5));
    }

    @Override
    protected void connectionStateStopped() {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))))).log(1078071040, "[%1.Disconnecting.connectionStateStopped] waiting for Disconnected", (Object)this.getName());
    }

    @Override
    protected void connectionStateDisconnected() {
        TMDeviceControl$SM.access$4900(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
    }

    @Override
    public void exit(Message message) {
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))).removeMessages(12);
    }

    @Override
    protected void timeout(String string) {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))))).log(-1601830656, "[%1.CleaningUpAndDisconnecting.timeout] Waited for disconnected but never got it!");
        TMDeviceControl$SM.access$5000(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
    }
}

