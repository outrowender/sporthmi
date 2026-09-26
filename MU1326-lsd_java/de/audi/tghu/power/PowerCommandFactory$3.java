/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.PowerCommandFactory;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

class PowerCommandFactory$3
implements Runnable {
    private final /* synthetic */ PowerEventListener val$peListener;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$3(PowerCommandFactory powerCommandFactory, PowerEventListener powerEventListener) {
        this.this$0 = powerCommandFactory;
        this.val$peListener = powerEventListener;
    }

    @Override
    public final void run() {
        if (this.val$peListener instanceof DSIKeyPanelListener) {
            PowerCommandFactory.access$202(this.this$0, (DSIKeyPanelListener)((Object)this.val$peListener));
        }
        PowerCommandFactory.access$100(this.this$0).getPowerFSM(0).addListener(this.val$peListener);
    }

    public final String toString() {
        return new StringBuffer().append("setRegListenerCmd: peListener=").append(this.val$peListener).toString();
    }
}

