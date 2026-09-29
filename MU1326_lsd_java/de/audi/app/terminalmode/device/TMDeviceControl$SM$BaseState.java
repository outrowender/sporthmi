/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;

public class TMDeviceControl$SM$BaseState
extends TMDeviceControl$TMDeviceControlState {
    private static final String APPLE_INC;
    private final /* synthetic */ TMDeviceControl$SM this$1;

    public TMDeviceControl$SM$BaseState(TMDeviceControl$SM tMDeviceControl$SM) {
        this.this$1 = tMDeviceControl$SM;
        super(null);
    }

    @Override
    protected void connectionStateStopped() {
    }

    @Override
    protected void connectionStateDisconnected() {
    }

    private void updateDevice(PhysicalDevice physicalDevice) {
        if (!TMDeviceControl.access$1400(TMDeviceControl$SM.access$500(this.this$1)).equals(physicalDevice)) {
            TMDeviceControl.access$600(TMDeviceControl$SM.access$500(this.this$1)).setId(physicalDevice.getDevice().deviceID);
            if ("Apple Inc.-iPhone".equals(physicalDevice.getDevice().getDeviceName()) && TMDeviceControl.access$600(TMDeviceControl$SM.access$500(this.this$1)).getDevicename().length() > 0) {
                TMDeviceControl.access$100(TMDeviceControl$SM.access$500(this.this$1)).log(-2137614336, "[%1.deviceDiscovered] Device changed: %2 -> %3, retaining old name %4", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(this.this$1)), (Object)TMDeviceControl.access$1400(TMDeviceControl$SM.access$500(this.this$1)), (Object)physicalDevice, (Object)TMDeviceControl.access$600(TMDeviceControl$SM.access$500(this.this$1)).getDevicename());
            } else {
                TMDeviceControl.access$100(TMDeviceControl$SM.access$500(this.this$1)).log(-2137614336, "[%1.deviceDiscovered] Device changed: %2 -> %3", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(this.this$1)), (Object)TMDeviceControl.access$1400(TMDeviceControl$SM.access$500(this.this$1)), (Object)physicalDevice);
                TMDeviceControl.access$600(TMDeviceControl$SM.access$500(this.this$1)).setName(physicalDevice.getDevice().getDeviceName());
            }
            TMDeviceControl.access$002(TMDeviceControl$SM.access$500(this.this$1), new StringBuffer().append("TMDeviceControl(").append(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(this.this$1)).getDevicename()).append(")").toString());
            TMDeviceControl.access$1402(TMDeviceControl$SM.access$500(this.this$1), physicalDevice);
        }
    }

    static /* synthetic */ TMDeviceControl$SM access$400(TMDeviceControl$SM$BaseState tMDeviceControl$SM$BaseState) {
        return tMDeviceControl$SM$BaseState.this$1;
    }

    static /* synthetic */ void access$800(TMDeviceControl$SM$BaseState tMDeviceControl$SM$BaseState, PhysicalDevice physicalDevice) {
        tMDeviceControl$SM$BaseState.updateDevice(physicalDevice);
    }
}

