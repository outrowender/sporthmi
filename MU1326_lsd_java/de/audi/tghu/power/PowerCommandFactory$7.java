/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.tghu.power.PowerCommandFactory;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

class PowerCommandFactory$7
implements Runnable {
    private final /* synthetic */ DSIPowerManagement val$powerManagement;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$7(PowerCommandFactory powerCommandFactory, DSIPowerManagement dSIPowerManagement) {
        this.this$0 = powerCommandFactory;
        this.val$powerManagement = dSIPowerManagement;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getPwrDSIHandler().setPwrMgmtDsi(this.val$powerManagement);
    }

    public final String toString() {
        return new StringBuffer().append("setPowerDeviceServiceCmd: powerManagement=").append(this.val$powerManagement).toString();
    }
}

