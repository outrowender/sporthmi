/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.DSIWirelessChargingResponseHandler;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;

class DSIWirelessChargingResponseHandler$1
implements IDSIClient {
    private final /* synthetic */ DSIWirelessChargingResponseHandler this$0;

    DSIWirelessChargingResponseHandler$1(DSIWirelessChargingResponseHandler dSIWirelessChargingResponseHandler) {
        this.this$0 = dSIWirelessChargingResponseHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
    }

    @Override
    public int[] getAutoNotifications() {
        return DSIActivator.ATTR_ALL;
    }
}

