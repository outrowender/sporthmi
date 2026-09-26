/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.AutomaticDeviceActivator$LastModeTracker$1;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.atip.utils.collections.Predicate;

class AutomaticDeviceActivator$LastModeTracker$1$1
implements Predicate {
    private final /* synthetic */ AutomaticDeviceActivator$LastModeTracker$1 this$2;

    AutomaticDeviceActivator$LastModeTracker$1$1(AutomaticDeviceActivator$LastModeTracker$1 automaticDeviceActivator$LastModeTracker$1) {
        this.this$2 = automaticDeviceActivator$LastModeTracker$1;
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.connectionState().is(TMDevice$ConnectionState.ATTACHED) && tMDevice.userAcceptState().is(TMDevice$UserAcceptState.DISCLAIMER_ACCEPTED);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

