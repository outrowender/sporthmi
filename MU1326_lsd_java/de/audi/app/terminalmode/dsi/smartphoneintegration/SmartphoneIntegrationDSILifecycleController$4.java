/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.atip.utils.generics.Generics;

class SmartphoneIntegrationDSILifecycleController$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController this$0;

    SmartphoneIntegrationDSILifecycleController$4(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, String string) {
        this.this$0 = smartphoneIntegrationDSILifecycleController;
        super(string);
    }

    @Override
    public void run() {
        SmartphoneIntegrationDSILifecycleController.access$600(this.this$0).log(1078071040, "<- [SmartphoneIntegrationDSILifecycleController.removeDSIService] send an empty device list");
        SmartphoneIntegrationDSILifecycleController.access$700(this.this$0).updateDiscoveredDevices(Generics.newArrayList());
    }
}

