/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.power;

import de.audi.app.phone.core.event.AbstractTelPowerEvent;
import de.audi.app.phone.core.power.IPowerEventListener;
import de.audi.app.phone.core.power.PowerEventDispatcher;
import java.util.Iterator;

class PowerEventDispatcher$1
extends AbstractTelPowerEvent {
    private final /* synthetic */ int val$pwrevt;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ PowerEventDispatcher this$0;

    PowerEventDispatcher$1(PowerEventDispatcher powerEventDispatcher, String string, int n, int n2) {
        this.this$0 = powerEventDispatcher;
        this.val$pwrevt = n;
        this.val$terminalID = n2;
        super(string);
    }

    @Override
    public void run() {
        PowerEventDispatcher.access$000(this.this$0).log(1078071040, "[PowerEventDispatcher#notifyPowerListenerOnEnterState] pwrevt='%1', terminalID='%2'", (long)this.val$pwrevt, (long)this.val$terminalID);
        Iterator iterator = PowerEventDispatcher.access$100(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((IPowerEventListener)iterator.next()).notifyPowerListenerOnEnterState(this.val$pwrevt);
        }
    }
}

