/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$active;
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener this$1;

    SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$6(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener, String string, boolean bl) {
        this.this$1 = smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
        this.val$active = bl;
        super(string);
    }

    @Override
    public void run() {
        SmartphoneIntegrationDSILifecycleController.access$2700(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).log(1078071040, "<- [%1.updateUSBResetActive] %2", (Object)"SmartphoneIntegrationDSIListener", (Object)new Boolean(this.val$active));
        SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1).updateUSBResetActive(this.val$active);
    }
}

