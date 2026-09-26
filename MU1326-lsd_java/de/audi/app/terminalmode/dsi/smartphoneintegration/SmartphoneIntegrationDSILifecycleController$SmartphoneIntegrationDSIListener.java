/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$1;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$1;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$2;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$3;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$4;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$5;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$6;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener;
import org.dsi.ifc.smartphoneintegration.Device;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener
implements DSISmartphoneIntegrationListener {
    private static final String LOGCLASS;
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController this$0;

    private SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        this.this$0 = smartphoneIntegrationDSILifecycleController;
    }

    @Override
    public void updateDiscoveredDevices(Device[] deviceArray, int n) {
        if (!SmartphoneIntegrationDSILifecycleController.access$1200(this.this$0, n)) {
            SmartphoneIntegrationDSILifecycleController.access$1300(this.this$0).log(-2137614336, "<- [%1.updateDiscoveredDevices] Invalid.", (Object)"SmartphoneIntegrationDSIListener");
            return;
        }
        SmartphoneIntegrationDSILifecycleController.access$1600(this.this$0).execute(new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$1(this, "smartphoneIntegrationListener.updateDiscoveredDevices", deviceArray));
    }

    @Override
    public void updateDeviceConnectionState(int n, int n2, int n3, int n4) {
        if (!SmartphoneIntegrationDSILifecycleController.access$1700(this.this$0, n4)) {
            SmartphoneIntegrationDSILifecycleController.access$1800(this.this$0).log(-2137614336, "<- [%1.updateDeviceConnectionState] Invalid.", (Object)"SmartphoneIntegrationDSIListener");
            return;
        }
        SmartphoneIntegrationDSILifecycleController.access$1600(this.this$0).execute(new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$2(this, "smartphoneIntegrationListener.updateDeviceConnectionState", n, n2, n3));
    }

    @Override
    public void responseFactorySettings(int n, boolean bl) {
        SmartphoneIntegrationDSILifecycleController.access$1600(this.this$0).execute(new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$3(this, "smartphoneIntegrationListener.responseFactorySettings", bl));
    }

    @Override
    public void updateSWaPStatus(int n, int n2) {
        SmartphoneIntegrationDSILifecycleController.access$2100(this.this$0).log(1078071040, "<- [%1.updateSWaPStatus] %2", (Object)"SmartphoneIntegrationDSIListener", (long)n);
        if (SmartphoneIntegrationDSILifecycleController.access$2200(this.this$0, n2) && n >= 2) {
            SmartphoneIntegrationDSILifecycleController.access$400(this.this$0).completeRequirement("SWAPSTATUS_CARPLAY");
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1003) {
            SmartphoneIntegrationDSILifecycleController.access$1600(this.this$0).execute(new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$4(this, "smartphoneIntegrationListener.asyncException"));
        } else if (n2 == 1001) {
            SmartphoneIntegrationDSILifecycleController.access$1600(this.this$0).execute(new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$5(this, "smartphoneIntegrationListener.asyncException", n));
        } else {
            SmartphoneIntegrationDSILifecycleController.access$2500(this.this$0).log(1078071040, "<- [%1.asyncException] %2, code=%3, RT=%4", (Object)"SmartphoneIntegrationDSIListener", (Object)string, (Object)Integer.toString(n), (long)n2);
        }
    }

    @Override
    public void updateUSBResetActive(boolean bl, int n) {
        if (SmartphoneIntegrationDSILifecycleController.access$2600(this.this$0, n)) {
            SmartphoneIntegrationDSILifecycleController.access$1600(this.this$0).execute(new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$6(this, "smartphoneIntegrationListener.updateUSBResetActive", bl));
        }
    }

    @Override
    public void updateAppConnectContextRequested(boolean bl, int n) {
    }

    /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, SmartphoneIntegrationDSILifecycleController$1 smartphoneIntegrationDSILifecycleController$1) {
        this(smartphoneIntegrationDSILifecycleController);
    }

    static /* synthetic */ SmartphoneIntegrationDSILifecycleController access$1400(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener) {
        return smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.this$0;
    }
}

