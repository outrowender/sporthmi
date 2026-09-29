/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$1;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIController
implements ISmartphoneIntegrationDSIController {
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController this$0;

    private SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIController(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        this.this$0 = smartphoneIntegrationDSILifecycleController;
    }

    @Override
    public void connectDevice(int n, SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType) {
        int n2;
        SmartphoneIntegrationDSILifecycleController.access$802(this.this$0, n);
        int n3 = smartphoneManager$SmartphoneType.is(SmartphoneManager$SmartphoneType.CARPLAY) ? 2 : (n2 = smartphoneManager$SmartphoneType.is(SmartphoneManager$SmartphoneType.CARLIFE) ? 32 : 8);
        if (SmartphoneIntegrationDSILifecycleController.access$900(this.this$0)) {
            SmartphoneIntegrationDSILifecycleController.access$1002(this.this$0, n);
            SmartphoneIntegrationDSILifecycleController.access$1102(this.this$0, n2);
        } else {
            SmartphoneIntegrationDSILifecycleController.access$300(this.this$0).connectDevice(n, n2);
        }
    }

    @Override
    public void disconnectDevice(int n) {
        SmartphoneIntegrationDSILifecycleController.access$300(this.this$0).disconnectDevice(n);
    }

    @Override
    public void requestFactorySettings() {
        SmartphoneIntegrationDSILifecycleController.access$300(this.this$0).requestFactorySettings(1);
    }

    /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIController(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, SmartphoneIntegrationDSILifecycleController$1 smartphoneIntegrationDSILifecycleController$1) {
        this(smartphoneIntegrationDSILifecycleController);
    }
}

