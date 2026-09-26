/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.PowerCommandFactory;

class PowerCommandFactory$4
implements Runnable {
    private final /* synthetic */ PowerEventListener val$peListener;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$4(PowerCommandFactory powerCommandFactory, PowerEventListener powerEventListener) {
        this.this$0 = powerCommandFactory;
        this.val$peListener = powerEventListener;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getPowerFSM(0).removeListener(this.val$peListener);
    }

    public final String toString() {
        return new StringBuffer().append("setUnregListenerCmd peListener=").append(this.val$peListener).toString();
    }
}

