/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$success;
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener this$1;

    SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$3(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener, String string, boolean bl) {
        this.this$1 = smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
        this.val$success = bl;
        super(string);
    }

    @Override
    public void run() {
        SmartphoneIntegrationDSILifecycleController.access$2000(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).log(1078071040, "<- [%1.responseFactorySettings] success=%2", (Object)"SmartphoneIntegrationDSIListener", (Object)this.val$success);
        SmartphoneIntegrationDSILifecycleController.access$700(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).responseFactorySettings(this.val$success);
    }
}

