/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$1;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$NullDSISmarthphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;

final class DSISmartphoneManagerProxy$ActiveDeviceListener
implements IActiveDeviceStateListener {
    private final /* synthetic */ DSISmartphoneManagerProxy this$0;

    private DSISmartphoneManagerProxy$ActiveDeviceListener(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        this.this$0 = dSISmartphoneManagerProxy;
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        if (tMDevice.isSelected()) {
            DSISmartphoneManagerProxy.access$402(this.this$0, (IDSISmartphoneManager)DSISmartphoneManagerProxy.access$500(this.this$0).get((Object)tMDevice.smartphoneType()));
        } else {
            DSISmartphoneManagerProxy.access$402(this.this$0, new DSISmartphoneManagerProxy$NullDSISmarthphoneManager(null));
        }
        DSISmartphoneManagerProxy.access$702(this.this$0, DSISmartphoneManagerProxy.access$400(this.this$0).getSpeechRequestHandler());
        DSISmartphoneManagerProxy.access$802(this.this$0, DSISmartphoneManagerProxy.access$400(this.this$0).getPlayerModificationListener());
        DSISmartphoneManagerProxy.access$902(this.this$0, DSISmartphoneManagerProxy.access$400(this.this$0).getPhoneCallController());
    }

    /* synthetic */ DSISmartphoneManagerProxy$ActiveDeviceListener(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, DSISmartphoneManagerProxy$1 dSISmartphoneManagerProxy$1) {
        this(dSISmartphoneManagerProxy);
    }
}

