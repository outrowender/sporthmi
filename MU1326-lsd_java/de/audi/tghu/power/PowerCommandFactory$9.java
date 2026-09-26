/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;

class PowerCommandFactory$9
implements Runnable {
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$9(PowerCommandFactory powerCommandFactory) {
        this.this$0 = powerCommandFactory;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getPowerFSM(0).releaseStanbyMute();
    }

    public final String toString() {
        return "releaseStanbyMuteCmd";
    }
}

