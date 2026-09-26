/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;

class SmartphoneIntegrationDSILifecycleController$3
implements IDSIClient {
    private final /* synthetic */ Class val$dsiClazz;
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController this$0;

    SmartphoneIntegrationDSILifecycleController$3(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, Class clazz) {
        this.this$0 = smartphoneIntegrationDSILifecycleController;
        this.val$dsiClazz = clazz;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase != null) {
            SmartphoneIntegrationDSILifecycleController.access$400(this.this$0).completeRequirement(this.val$dsiClazz);
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return null;
    }
}

