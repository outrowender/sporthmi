/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.power;

import de.audi.app.phone.core.event.AbstractTelPowerEvent;
import de.audi.app.phone.core.power.IPowerEventListener;
import de.audi.app.phone.core.power.PowerEventDispatcher;
import de.esolutions.fw.util.commons.Buffer;

class PowerEventDispatcher$4
extends AbstractTelPowerEvent {
    private final /* synthetic */ boolean val$clmps;
    private final /* synthetic */ boolean val$clmp15;
    private final /* synthetic */ boolean val$clmpX;
    private final /* synthetic */ boolean val$clmp50;
    private final /* synthetic */ PowerEventDispatcher this$0;

    PowerEventDispatcher$4(PowerEventDispatcher powerEventDispatcher, String string, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.this$0 = powerEventDispatcher;
        this.val$clmps = bl;
        this.val$clmp15 = bl2;
        this.val$clmpX = bl3;
        this.val$clmp50 = bl4;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object;
        if (PowerEventDispatcher.access$000(this.this$0).isInfo()) {
            object = new Buffer(30);
            ((Buffer)object).append("clampS=").append(PowerEventDispatcher.access$500(this.this$0)).append(", clamp15=").append(PowerEventDispatcher.access$400(this.this$0)).append(", clampX=").append(PowerEventDispatcher.access$300(this.this$0)).append(", clamp50=").append(PowerEventDispatcher.access$200(this.this$0));
            PowerEventDispatcher.access$000(this.this$0).log(1078071040, "[PowerEventDispatcher#updateClampState] %1", (Object)((Buffer)object).toString());
        }
        object = PowerEventDispatcher.access$600(this.this$0);
        synchronized (object) {
            PowerEventDispatcher.access$502(this.this$0, this.val$clmps);
            PowerEventDispatcher.access$402(this.this$0, this.val$clmp15);
            PowerEventDispatcher.access$302(this.this$0, this.val$clmpX);
            PowerEventDispatcher.access$202(this.this$0, this.val$clmp50);
        }
        object = PowerEventDispatcher.access$100(this.this$0).iterator();
        while (object.hasNext()) {
            ((IPowerEventListener)object.next()).updateClampState(PowerEventDispatcher.access$500(this.this$0), PowerEventDispatcher.access$400(this.this$0), PowerEventDispatcher.access$300(this.this$0), PowerEventDispatcher.access$200(this.this$0));
        }
    }
}

