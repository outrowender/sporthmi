/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$1;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;

class DSISmartphoneManagerProxy$PhoneCallControllerProxy
implements IPhoneCallController {
    private final /* synthetic */ DSISmartphoneManagerProxy this$0;

    private DSISmartphoneManagerProxy$PhoneCallControllerProxy(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        this.this$0 = dSISmartphoneManagerProxy;
    }

    @Override
    public void hook(boolean bl) {
        DSISmartphoneManagerProxy.access$900(this.this$0).hook(bl);
    }

    @Override
    public void hangup(boolean bl) {
        DSISmartphoneManagerProxy.access$900(this.this$0).hangup(bl);
    }

    @Override
    public void flash(boolean bl) {
        DSISmartphoneManagerProxy.access$900(this.this$0).flash(bl);
    }

    /* synthetic */ DSISmartphoneManagerProxy$PhoneCallControllerProxy(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, DSISmartphoneManagerProxy$1 dSISmartphoneManagerProxy$1) {
        this(dSISmartphoneManagerProxy);
    }
}

