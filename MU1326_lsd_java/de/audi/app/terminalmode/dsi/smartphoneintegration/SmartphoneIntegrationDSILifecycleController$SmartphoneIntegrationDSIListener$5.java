/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$ErrorCode;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener this$1;

    SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$5(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener, String string, int n) {
        this.this$1 = smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
        this.val$errorCode = n;
        super(string);
    }

    @Override
    public void run() {
        SmartphoneIntegrationDSILifecycleController$ErrorCode smartphoneIntegrationDSILifecycleController$ErrorCode = SmartphoneIntegrationDSILifecycleController$ErrorCode.valueOf(this.val$errorCode);
        SmartphoneIntegrationDSILifecycleController.access$2400(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).log(1078071040, "<- [%1.asyncException] RT_CONNECTDEVICE, %2", (Object)"SmartphoneIntegrationDSIListener", (Object)smartphoneIntegrationDSILifecycleController$ErrorCode);
        SmartphoneIntegrationDSILifecycleController.access$700(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).connectDeviceFailed(SmartphoneIntegrationDSILifecycleController.access$800(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)), smartphoneIntegrationDSILifecycleController$ErrorCode);
    }
}

