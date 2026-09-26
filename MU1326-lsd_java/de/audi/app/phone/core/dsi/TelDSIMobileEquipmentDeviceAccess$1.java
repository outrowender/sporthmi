/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentDeviceAccess;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;

class TelDSIMobileEquipmentDeviceAccess$1
implements IDSIClient {
    private final /* synthetic */ TelDSIMobileEquipmentDeviceAccess this$0;

    TelDSIMobileEquipmentDeviceAccess$1(TelDSIMobileEquipmentDeviceAccess telDSIMobileEquipmentDeviceAccess) {
        this.this$0 = telDSIMobileEquipmentDeviceAccess;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        TelDSIMobileEquipmentDeviceAccess.access$002(this.this$0, (DSIMobileEquipment)dSIBase);
    }

    @Override
    public int[] getAutoNotifications() {
        return DSIActivator.ATTR_ALL;
    }
}

