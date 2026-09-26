/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState$1;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState
extends TMDeviceControl$TMDeviceControlState {
    private Subscription subscribe;
    private final /* synthetic */ TMDeviceControl$SM$BaseState this$2;

    public TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState(TMDeviceControl$SM$BaseState tMDeviceControl$SM$BaseState) {
        this.this$2 = tMDeviceControl$SM$BaseState;
        super(null);
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl.access$1400(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).disconnectDevice(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2)));
        this.subscribe = TMDeviceControl.access$1600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).getStateApplicationProperty(Application.PHONE).subscribe(new TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState$1(this));
    }

    @Override
    public void exit(Message message) {
        this.subscribe.cancel();
    }

    @Override
    public void phoneCallEnded() {
        TMDeviceControl$SM.access$1700(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
    }

    @Override
    protected void deviceNotDiscovered() {
        TMDeviceControl$SM.access$1800(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotDiscoveredState")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState);
    }

    @Override
    protected void deviceDiscoveredPhoneCallActive(PhysicalDevice physicalDevice) {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).log(-2137614336, "[TMDeviceControl.deviceDiscoveredPhoneCallActive] device already on hold");
    }

    static /* synthetic */ TMDeviceControl$SM$BaseState access$1500(TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState tMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState) {
        return tMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState.this$2;
    }
}

