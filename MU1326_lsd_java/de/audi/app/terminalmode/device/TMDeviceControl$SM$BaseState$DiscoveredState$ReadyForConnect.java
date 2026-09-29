/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect
extends TMDeviceControl$TMDeviceControlState {
    private boolean isDisconnectedInSameState;
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState this$3;

    public TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect(TMDeviceControl$SM$BaseState$DiscoveredState tMDeviceControl$SM$BaseState$DiscoveredState) {
        this.this$3 = tMDeviceControl$SM$BaseState$DiscoveredState;
        super(null);
        this.isDisconnectedInSameState = false;
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl.access$1000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3))), TMDevice$ConnectionState.ATTACHED, message.toString());
        if (!(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)).getCurrentMessage().getCode() != 16 && TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)).getCurrentMessage().getCode() != 18 || TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)).hasMessages(15))) {
            TMDeviceControl.access$2300(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).readyForActivation(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))));
        } else {
            TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(-2137614336, "[%1.ReadyForConnect.enter] skipped readyForActivation, reason %2%3", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), (Object)message.tag, (Object)(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)).hasMessages(15) ? ", SUPRESS_AUTOMATIC_ACTIVATIONS_TIMER" : ""));
        }
    }

    @Override
    protected void activate() {
        TMDeviceControl$SM.access$2400(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting);
    }

    @Override
    protected void connectionStateFailed(int n) {
        if (n == 7) {
            TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(1078071040, "[%1.ReadyForConnect.connectionStateFailed] CONNECTIONSTATE_FAILED_NO_GAL_DEVICE while ReadyForConnect", (Object)this.getName());
            TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).setUserAcceptState(TMDevice$UserAcceptState.NATIVE_SELECTED);
        }
    }

    @Override
    protected void deviceDiscovered(PhysicalDevice physicalDevice) {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(-2137614336, "[%1.deviceDiscovered] was disconnected in same state: %2", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), (Object)(this.isDisconnectedInSameState ? "true" : "false"));
        if (this.isDisconnectedInSameState && TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).userAcceptState().isNot(TMDevice$UserAcceptState.NATIVE_SELECTED)) {
            TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(-2137614336, "[%1.deviceDiscovered] re-activate device", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))));
            TMDeviceControl.access$2300(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).readyForActivation(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))));
        }
    }

    @Override
    protected void connectionStateDisconnected() {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(-2137614336, "[%1.connectionStateDisconnected] set disconnected flag", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))));
        this.isDisconnectedInSameState = true;
    }

    @Override
    protected void deviceNotDiscovered() {
        TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).getChoiceModel(4552).setValue(0);
        TMDeviceControl$SM.access$2500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotDiscoveredState")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState);
    }

    @Override
    protected void connectionStateConnected() {
        TMDeviceControl$SM.access$2600(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem);
    }

    @Override
    protected void deactivate() {
        if (TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).getConfiguration().usesOldMediaConnector()) {
            TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)).sendMessageDelayed(15, (long)0);
        }
        TMDeviceControl.access$1400(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).disconnectDevice(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3))));
    }

    @Override
    protected void handleDelete() {
        TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).setUserAcceptState(TMDevice$UserAcceptState.INITIAL).setWasDisclaimerPreviouslyAccepted(false).setConnectionState(TMDevice$ConnectionState.ATTACHED);
        TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).notifyAboutChange(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), "handleDelete");
        TMDeviceControl.access$2300(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).readyForActivation(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))));
    }
}

