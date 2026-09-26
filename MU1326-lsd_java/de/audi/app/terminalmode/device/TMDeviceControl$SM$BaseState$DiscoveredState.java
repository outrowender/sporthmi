/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DiscoveredState
extends TMDeviceControl$TMDeviceControlState {
    private int deviceLockedRetriesCounter;
    private final /* synthetic */ TMDeviceControl$SM$BaseState this$2;

    public TMDeviceControl$SM$BaseState$DiscoveredState(TMDeviceControl$SM$BaseState tMDeviceControl$SM$BaseState) {
        this.this$2 = tMDeviceControl$SM$BaseState;
        super(null);
        this.deviceLockedRetriesCounter = 0;
    }

    @Override
    public void enter(Message message) {
        if (TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).userAcceptState().isOneOf(TMDevice$UserAcceptState.TM_SELECTED, TMDevice$UserAcceptState.NATIVE) || !TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).isStoreUserAcceptState()) {
            TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).log(-2137614336, "[TMDeviceControl.deviceDiscovered] user accept state change: %1 -> %2", (Object)TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).userAcceptState(), (Object)TMDevice$UserAcceptState.INITIAL);
            TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).setUserAcceptState(TMDevice$UserAcceptState.INITIAL);
        }
        if (TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).userAcceptState().is(TMDevice$UserAcceptState.NATIVE_SELECTED)) {
            TMDeviceControl.access$1400(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).disconnectDevice(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2)));
        }
        if (this.deviceLockedRetriesCounter > 2) {
            TMDeviceControl$SM.access$1900(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DeviceLocked == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DeviceLocked = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DeviceLocked")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DeviceLocked);
        }
        TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).setAttachTime(TMDeviceControl.access$2000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).getCurrentTime());
    }

    @Override
    protected void deviceDiscovered(PhysicalDevice physicalDevice) {
        TMDeviceControl$SM$BaseState.access$800(this.this$2, physicalDevice);
        if (TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).smartphoneType().is(SmartphoneManager$SmartphoneType.UNKNOWN)) {
            TMDeviceControl$SM.access$2100(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotSupportedState")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState);
        }
    }

    static /* synthetic */ TMDeviceControl$SM$BaseState access$2200(TMDeviceControl$SM$BaseState$DiscoveredState tMDeviceControl$SM$BaseState$DiscoveredState) {
        return tMDeviceControl$SM$BaseState$DiscoveredState.this$2;
    }

    static /* synthetic */ int access$3308(TMDeviceControl$SM$BaseState$DiscoveredState tMDeviceControl$SM$BaseState$DiscoveredState) {
        return tMDeviceControl$SM$BaseState$DiscoveredState.deviceLockedRetriesCounter++;
    }
}

