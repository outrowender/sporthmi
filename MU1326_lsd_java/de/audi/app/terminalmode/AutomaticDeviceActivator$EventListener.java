/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.AutomaticDeviceActivator;
import de.audi.app.terminalmode.AutomaticDeviceActivator$1;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.events.DefaultEventListener;

final class AutomaticDeviceActivator$EventListener
extends DefaultEventListener {
    private final /* synthetic */ AutomaticDeviceActivator this$0;

    private AutomaticDeviceActivator$EventListener(AutomaticDeviceActivator automaticDeviceActivator) {
        this.this$0 = automaticDeviceActivator;
    }

    @Override
    public void readyForActivation(TMDevice tMDevice) {
        boolean bl;
        boolean bl2 = bl = tMDevice.userAcceptState().is(TMDevice$UserAcceptState.DISCLAIMER_ACCEPTED) || AutomaticDeviceActivator.access$300(this.this$0).isAutoConnect();
        if (bl) {
            if (!AutomaticDeviceActivator.access$400(this.this$0).isValid()) {
                String string;
                String string2 = (String)AutomaticDeviceActivator.access$500(this.this$0).get();
                int n = string2.lastIndexOf("#");
                String string3 = string = n == -1 ? string2 : string2.substring(0, n);
                if (string2.equals("no_lastmode_id") || !string.equals(tMDevice.getUniqueID().address) || string2.equals(AutomaticDeviceActivator.access$600(this.this$0, tMDevice, false))) {
                    AutomaticDeviceActivator.access$700(this.this$0).log(1078071040, "<!> [%1.EventListener.readyForActivation] Activate known detected device %2 as %3", (Object)"AutomaticDeviceActivator", (Object)tMDevice, (long)tMDevice.smartphoneType().ordinal());
                    AutomaticDeviceActivator.access$800(this.this$0).control(tMDevice).activateDevice();
                }
            } else {
                AutomaticDeviceActivator.access$700(this.this$0).log(1078071040, "[%1.EventListener.readyForActivation] already active - %2", (Object)"AutomaticDeviceActivator", (Object)AutomaticDeviceActivator.access$400(this.this$0));
                AutomaticDeviceActivator.access$700(this.this$0).log(1078071040, "<!> [%1.EventListener.readyForActivation] cannot be activated right now - %2", (Object)"AutomaticDeviceActivator", (Object)tMDevice);
                AutomaticDeviceActivator.access$800(this.this$0).control(tMDevice).deactivateDevice();
            }
        }
    }

    /* synthetic */ AutomaticDeviceActivator$EventListener(AutomaticDeviceActivator automaticDeviceActivator, AutomaticDeviceActivator$1 automaticDeviceActivator$1) {
        this(automaticDeviceActivator);
    }
}

