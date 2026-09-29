/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import de.audi.tghu.power.PowerFSM;

class PowerCommandFactory$16
implements Runnable {
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$16(PowerCommandFactory powerCommandFactory) {
        this.this$0 = powerCommandFactory;
    }

    @Override
    public final void run() {
        PowerFSM powerFSM = PowerCommandFactory.access$100(this.this$0).getPowerFSM(0);
        if (powerFSM != null) {
            powerFSM.notifyListenersOnClampStateChange();
        }
    }

    public final String toString() {
        return "notifyListenersOnClampStateChangeCmd";
    }
}

