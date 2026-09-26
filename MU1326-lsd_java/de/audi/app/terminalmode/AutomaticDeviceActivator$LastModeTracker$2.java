/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.AutomaticDeviceActivator;
import de.audi.app.terminalmode.AutomaticDeviceActivator$LastModeTracker;

class AutomaticDeviceActivator$LastModeTracker$2
implements Runnable {
    private final /* synthetic */ AutomaticDeviceActivator$LastModeTracker this$1;

    AutomaticDeviceActivator$LastModeTracker$2(AutomaticDeviceActivator$LastModeTracker automaticDeviceActivator$LastModeTracker) {
        this.this$1 = automaticDeviceActivator$LastModeTracker;
    }

    @Override
    public void run() {
        AutomaticDeviceActivator.access$900(AutomaticDeviceActivator$LastModeTracker.access$1200(this.this$1)).registerListener(AutomaticDeviceActivator.access$1500(AutomaticDeviceActivator$LastModeTracker.access$1200(this.this$1)));
    }
}

