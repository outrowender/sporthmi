/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DeviceLocked
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState this$2;

    public TMDeviceControl$SM$BaseState$DeviceLocked(TMDeviceControl$SM$BaseState tMDeviceControl$SM$BaseState) {
        this.this$2 = tMDeviceControl$SM$BaseState;
        super(null);
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).log(-1601830656, "[%1.DeviceLocked.enter] %2", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))), (Object)TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))));
        TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).setConnectionState(TMDevice$ConnectionState.NOT_ATTACHED);
        TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))).notifyAboutChange(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(this.this$2))), "DeviceLocked");
    }

    @Override
    protected void activate() {
        this.enter(TMDeviceControl$SM$BaseState.access$400(this.this$2).getCurrentMessage());
    }
}

