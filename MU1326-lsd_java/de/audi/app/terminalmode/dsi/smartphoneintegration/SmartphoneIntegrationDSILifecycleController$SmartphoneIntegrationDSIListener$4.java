/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener this$1;

    SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$4(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener, String string) {
        this.this$1 = smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
        super(string);
    }

    @Override
    public void run() {
        SmartphoneIntegrationDSILifecycleController.access$2300(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).log(1078071040, "<- [%1.asyncException] RT_REQUESTFACTORYSETTINGS", (Object)"SmartphoneIntegrationDSIListener");
        SmartphoneIntegrationDSILifecycleController.access$700(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).responseFactorySettings(false);
    }
}

