/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import org.dsi.ifc.base.DSIListener;

class SmartphoneIntegrationDSILifecycleController$1
implements Runnable {
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController this$0;

    SmartphoneIntegrationDSILifecycleController$1(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        this.this$0 = smartphoneIntegrationDSILifecycleController;
    }

    @Override
    public void run() {
        SmartphoneIntegrationDSILifecycleController.access$300(this.this$0).setNotification(new int[]{1, 2, 4}, (DSIListener)SmartphoneIntegrationDSILifecycleController.access$200(this.this$0));
    }
}

