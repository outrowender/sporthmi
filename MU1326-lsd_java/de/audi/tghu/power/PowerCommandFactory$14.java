/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import org.dsi.ifc.keypanel.DSIKeyPanel;

class PowerCommandFactory$14
implements Runnable {
    private final /* synthetic */ DSIKeyPanel val$keyPanel;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$14(PowerCommandFactory powerCommandFactory, DSIKeyPanel dSIKeyPanel) {
        this.this$0 = powerCommandFactory;
        this.val$keyPanel = dSIKeyPanel;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getNativeDisplayHandler().setDSIKeyPanel(this.val$keyPanel);
    }

    public final String toString() {
        return new StringBuffer().append("setDSIKeyPanel: keyPanel=").append(this.val$keyPanel).toString();
    }
}

