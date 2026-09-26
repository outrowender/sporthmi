/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import org.dsi.ifc.powermanagement.ClampSignal;

class PowerCommandFactory$5
implements Runnable {
    private final /* synthetic */ ClampSignal val$state;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$5(PowerCommandFactory powerCommandFactory, ClampSignal clampSignal) {
        this.this$0 = powerCommandFactory;
        this.val$state = clampSignal;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getPowerFSM(0).setClampState(this.val$state);
    }

    public final String toString() {
        return new StringBuffer().append("setClampSStateCmd(").append(this.val$state).toString();
    }
}

