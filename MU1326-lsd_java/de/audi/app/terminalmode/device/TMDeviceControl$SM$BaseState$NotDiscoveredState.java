/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$NotDiscoveredState
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState this$2;

    public TMDeviceControl$SM$BaseState$NotDiscoveredState(TMDeviceControl$SM$BaseState tMDeviceControl$SM$BaseState) {
        this.this$2 = tMDeviceControl$SM$BaseState;
        super(null);
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl.access$1000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2)), TMDevice$ConnectionState.NOT_ATTACHED, "deviceIsNotDiscovered");
    }

    @Override
    public void exit(Message message) {
        TMDeviceControl$SM$BaseState.access$400(this.this$2).removeMessages(16);
    }

    @Override
    protected void deviceDiscoveredDebounced(PhysicalDevice physicalDevice) {
        TMDeviceControl$SM$BaseState.access$800(this.this$2, physicalDevice);
        if (TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).smartphoneType().isNot(SmartphoneManager$SmartphoneType.UNKNOWN)) {
            TMDeviceControl$SM.access$1100(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
        } else {
            TMDeviceControl$SM.access$1200(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotSupportedState")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState);
        }
    }

    @Override
    protected void deviceDiscovered(PhysicalDevice physicalDevice) {
        int n = TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).getConfiguration().usesOldMediaConnector() && !TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).isStoreUserAcceptState() ? 2000 : 0;
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).log(1078071040, "[%1.deviceDiscovered] %2", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))), (long)n);
        TMDeviceControl$SM$BaseState.access$400(this.this$2).sendMessageDelayed(16, physicalDevice, n);
    }

    @Override
    protected void deviceNotDiscovered() {
        TMDeviceControl$SM$BaseState.access$400(this.this$2).removeMessages(16);
    }

    @Override
    protected void deactivate() {
        TMDeviceControl$SM$BaseState.access$400(this.this$2).removeMessages(16);
    }

    @Override
    protected void handleDelete() {
        TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).deleteMe(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2)));
    }

    @Override
    protected void connectionStateFailed(int n) {
        if (n == 6) {
            TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).setUserAcceptState(TMDevice$UserAcceptState.INITIAL).setWasDisclaimerPreviouslyAccepted(false).setStoreUserAcceptState(false).setConnectionState(TMDevice$ConnectionState.ATTACHED);
            TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).notifyAboutChange(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))), "handleNoCarplayDeviceError");
        }
    }

    @Override
    protected void deviceDiscoveredPhoneCallActive(PhysicalDevice physicalDevice) {
        TMDeviceControl$SM$BaseState.access$800(this.this$2, physicalDevice);
        TMDeviceControl$SM.access$1300(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState);
    }
}

