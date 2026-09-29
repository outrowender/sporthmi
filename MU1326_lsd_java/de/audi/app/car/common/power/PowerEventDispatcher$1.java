/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.power;

import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.power.PowerEventDispatcher;

class PowerEventDispatcher$1
implements Runnable {
    private final /* synthetic */ IPowerEventListener val$listener;
    private final /* synthetic */ PowerEventDispatcher this$0;

    PowerEventDispatcher$1(PowerEventDispatcher powerEventDispatcher, IPowerEventListener iPowerEventListener) {
        this.this$0 = powerEventDispatcher;
        this.val$listener = iPowerEventListener;
    }

    @Override
    public void run() {
        PowerEventDispatcher.access$000(this.this$0).log(1078071040, "[PowerEventDispatcher#addPowerEventListener] starting asynchroneous job to send current data");
        PowerEventDispatcher.access$100(this.this$0, this.val$listener);
    }
}

