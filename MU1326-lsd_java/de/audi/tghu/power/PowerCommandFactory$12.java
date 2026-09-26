/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

class PowerCommandFactory$12
implements Runnable {
    private final /* synthetic */ DSIDisplayManagement val$displayManagement;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$12(PowerCommandFactory powerCommandFactory, DSIDisplayManagement dSIDisplayManagement) {
        this.this$0 = powerCommandFactory;
        this.val$displayManagement = dSIDisplayManagement;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getNativeDisplayHandler().setDSIDisplayManagement(this.val$displayManagement);
    }

    public final String toString() {
        return new StringBuffer().append("setDSIDisplayManagement: displayManagement=").append(this.val$displayManagement).toString();
    }
}

