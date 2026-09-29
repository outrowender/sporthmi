/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import de.audi.tghu.power.PowerFSM;

class PowerCommandFactory$1
implements Runnable {
    private final /* synthetic */ int val$state;
    private final /* synthetic */ int val$powerEvent;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$1(PowerCommandFactory powerCommandFactory, int n, int n2, int n3) {
        this.this$0 = powerCommandFactory;
        this.val$state = n;
        this.val$powerEvent = n2;
        this.val$terminal = n3;
    }

    @Override
    public final void run() {
        try {
            PowerCommandFactory.access$000(this.this$0, this.val$state, this.val$powerEvent, this.val$terminal);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        PowerFSM powerFSM = PowerCommandFactory.access$100(this.this$0).getPowerFSM(this.val$terminal);
        if (powerFSM != null) {
            powerFSM.triggerPowerState(this.val$state, this.val$powerEvent);
        }
    }

    public final String toString() {
        return new StringBuffer().append("setPwrStateCmd: state=").append(this.val$state).append(" powerEvent=").append(this.val$powerEvent).toString();
    }
}

