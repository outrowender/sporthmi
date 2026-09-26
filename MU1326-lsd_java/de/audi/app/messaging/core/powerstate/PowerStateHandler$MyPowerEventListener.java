/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.powerstate;

import de.audi.app.messaging.core.powerstate.PowerStateHandler;
import de.audi.app.messaging.core.powerstate.PowerStateHandler$1;
import de.audi.atip.power.DefaultPowerEventListener;

final class PowerStateHandler$MyPowerEventListener
extends DefaultPowerEventListener {
    private final /* synthetic */ PowerStateHandler this$0;

    private PowerStateHandler$MyPowerEventListener(PowerStateHandler powerStateHandler) {
        this.this$0 = powerStateHandler;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        PowerStateHandler.access$100(this.this$0).log(1078071040, "[PowerStateHandler#notifyPowerListenerOnEnterState] event = %1", (long)n);
        if (n == 2 || n == 3) {
            PowerStateHandler.access$200(this.this$0);
        }
    }

    /* synthetic */ PowerStateHandler$MyPowerEventListener(PowerStateHandler powerStateHandler, PowerStateHandler$1 powerStateHandler$1) {
        this(powerStateHandler);
    }
}

