/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import org.dsi.ifc.displaycontroller.DSIDisplayController;

class PowerCommandFactory$13
implements Runnable {
    private final /* synthetic */ DSIDisplayController val$service;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$13(PowerCommandFactory powerCommandFactory, DSIDisplayController dSIDisplayController) {
        this.this$0 = powerCommandFactory;
        this.val$service = dSIDisplayController;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getNativeDisplayHandler().setDSIDisplayController(this.val$service);
    }

    public final String toString() {
        return new StringBuffer().append("setDSIDisplayManagement: displayManagement=").append(this.val$service).toString();
    }
}

