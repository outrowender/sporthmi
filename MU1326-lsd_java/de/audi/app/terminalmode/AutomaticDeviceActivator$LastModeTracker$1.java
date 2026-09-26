/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.AutomaticDeviceActivator;
import de.audi.app.terminalmode.AutomaticDeviceActivator$LastModeTracker;
import de.audi.app.terminalmode.AutomaticDeviceActivator$LastModeTracker$1$1;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;

class AutomaticDeviceActivator$LastModeTracker$1
implements Runnable {
    private final /* synthetic */ AutomaticDeviceActivator$LastModeTracker this$1;

    AutomaticDeviceActivator$LastModeTracker$1(AutomaticDeviceActivator$LastModeTracker automaticDeviceActivator$LastModeTracker) {
        this.this$1 = automaticDeviceActivator$LastModeTracker;
    }

    @Override
    public void run() {
        Optional optional = AutomaticDeviceActivator$LastModeTracker.access$1100(this.this$1).fluent().tryFind((Predicate)new AutomaticDeviceActivator$LastModeTracker$1$1(this));
        if (optional.exists()) {
            AutomaticDeviceActivator.access$700(AutomaticDeviceActivator$LastModeTracker.access$1200(this.this$1)).log(1078071040, "<!> [%1.LastModeHandler.lastModeTimer.run] Activate device which was skipped during lastmode tracking - %2", (Object)"AutomaticDeviceActivator", (Object)optional);
            AutomaticDeviceActivator.access$800(AutomaticDeviceActivator$LastModeTracker.access$1200(this.this$1)).control((TMDevice)optional.get()).activateDevice();
        }
        AutomaticDeviceActivator.access$700(AutomaticDeviceActivator$LastModeTracker.access$1200(this.this$1)).log(1078071040, "[%1.LastModeHandler.lastModeTimer.run] Last mode tracking is finished. Resuming normal operation.", (Object)"AutomaticDeviceActivator");
        AutomaticDeviceActivator$LastModeTracker.access$1300(this.this$1);
    }
}

