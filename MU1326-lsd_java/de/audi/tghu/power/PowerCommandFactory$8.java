/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.tghu.power.PowerCommandFactory;

class PowerCommandFactory$8
implements Runnable {
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$8(PowerCommandFactory powerCommandFactory) {
        this.this$0 = powerCommandFactory;
    }

    @Override
    public final void run() {
        try {
            IFrameworkAccess iFrameworkAccess = PowerCommandFactory.access$100(this.this$0).getFramework();
            int n = iFrameworkAccess.getLastmodeHandler().getLastmodeStorage().getBrightness();
            IDisplayManager iDisplayManager = iFrameworkAccess.getHMIService().getDisplayManager();
            iDisplayManager.setDisplayBrightness(0, n);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        PowerCommandFactory.access$100(this.this$0).getPowerFSM(0).setHMIReady();
    }

    public final String toString() {
        return "setHMIReadyCmd";
    }
}

