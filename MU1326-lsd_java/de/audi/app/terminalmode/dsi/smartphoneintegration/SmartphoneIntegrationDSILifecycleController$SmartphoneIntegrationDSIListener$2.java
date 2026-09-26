/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$deviceID;
    private final /* synthetic */ int val$connectionState;
    private final /* synthetic */ int val$connectionMethod;
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener this$1;

    SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$2(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener, String string, int n, int n2, int n3) {
        this.this$1 = smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
        this.val$deviceID = n;
        this.val$connectionState = n2;
        this.val$connectionMethod = n3;
        super(string);
    }

    @Override
    public void run() {
        SmartphoneIntegrationDSILifecycleController.access$1900(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).log(1078071040, "<- [%1.updateDeviceConnectionState] id=%2 %3 %4", (Object)"SmartphoneIntegrationDSIListener", (Object)Integer.toString(this.val$deviceID), (Object)TerminalModeUtils.logConnectionState((int)this.val$connectionState), (Object)TerminalModeUtils.logConnectionMethod((int)this.val$connectionMethod));
        SmartphoneIntegrationDSILifecycleController.access$700(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).updateDeviceConnectionState(this.val$deviceID, this.val$connectionState, this.val$connectionMethod);
    }
}

