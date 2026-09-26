/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.events.DefaultEventListener;

class SmartphoneIntegrationDSILifecycleController$2
extends DefaultEventListener {
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController this$0;

    SmartphoneIntegrationDSILifecycleController$2(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        this.this$0 = smartphoneIntegrationDSILifecycleController;
    }

    @Override
    public void startupFinished() {
        SmartphoneIntegrationDSILifecycleController.access$400(this.this$0).completeRequirement("STARTUP_FINISHED");
        SmartphoneIntegrationDSILifecycleController.access$500(this.this$0).unregisterListener(this);
    }
}

