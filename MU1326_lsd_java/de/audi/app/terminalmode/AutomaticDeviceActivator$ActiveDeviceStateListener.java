/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.AutomaticDeviceActivator;
import de.audi.app.terminalmode.AutomaticDeviceActivator$1;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;

class AutomaticDeviceActivator$ActiveDeviceStateListener
implements IActiveDeviceStateListener {
    private final /* synthetic */ AutomaticDeviceActivator this$0;

    private AutomaticDeviceActivator$ActiveDeviceStateListener(AutomaticDeviceActivator automaticDeviceActivator) {
        this.this$0 = automaticDeviceActivator;
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        AutomaticDeviceActivator.access$402(this.this$0, tMDevice);
        if (AutomaticDeviceActivator.access$400(this.this$0).isActive()) {
            AutomaticDeviceActivator.access$500(this.this$0).store(AutomaticDeviceActivator.access$600(this.this$0, tMDevice, false));
        }
    }

    /* synthetic */ AutomaticDeviceActivator$ActiveDeviceStateListener(AutomaticDeviceActivator automaticDeviceActivator, AutomaticDeviceActivator$1 automaticDeviceActivator$1) {
        this(automaticDeviceActivator);
    }
}

