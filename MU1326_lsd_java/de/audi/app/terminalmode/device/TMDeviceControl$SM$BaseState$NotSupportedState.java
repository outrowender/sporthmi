/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$NotSupportedState
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState this$2;

    public TMDeviceControl$SM$BaseState$NotSupportedState(TMDeviceControl$SM$BaseState tMDeviceControl$SM$BaseState) {
        this.this$2 = tMDeviceControl$SM$BaseState;
        super(null);
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).log(-1601830656, "[%1.NotSupportedState.enter] %2", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))), (Object)TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))));
        TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).setConnectionState(TMDevice$ConnectionState.NOT_ATTACHED);
        TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).notifyAboutChange(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))), "NotSupportedState");
    }

    @Override
    protected void deviceDiscovered(PhysicalDevice physicalDevice) {
        TMDeviceControl$SM$BaseState.access$800(this.this$2, physicalDevice);
        if (TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).smartphoneType().isNot(SmartphoneManager$SmartphoneType.UNKNOWN)) {
            TMDeviceControl$SM.access$900(TMDeviceControl$SM$BaseState.access$400(this.this$2), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
        }
    }

    @Override
    protected void handleDelete() {
        TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).deleteMe(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2)));
    }
}

