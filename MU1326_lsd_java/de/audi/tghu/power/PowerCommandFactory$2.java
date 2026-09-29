/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import de.audi.tghu.power.PowerFSM;

class PowerCommandFactory$2
implements Runnable {
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ int val$state;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$2(PowerCommandFactory powerCommandFactory, int n, int n2) {
        this.this$0 = powerCommandFactory;
        this.val$terminal = n;
        this.val$state = n2;
    }

    @Override
    public final void run() {
        PowerFSM powerFSM = PowerCommandFactory.access$100(this.this$0).getPowerFSM(this.val$terminal);
        if (powerFSM != null) {
            powerFSM.triggerExtendedPowerState(this.val$state);
        }
    }

    public final String toString() {
        return new StringBuffer().append("setExtPwrStateCmd: state=").append(this.val$state).toString();
    }
}

