/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;

class TelDSIMobileEquipementTopologyAccess$1
implements IDSIClient {
    private final /* synthetic */ TelDSIMobileEquipementTopologyAccess this$0;

    TelDSIMobileEquipementTopologyAccess$1(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        this.this$0 = telDSIMobileEquipementTopologyAccess;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.this$0.setDsiMobileEquipmentTopology((DSIMobileEquipmentTopology)dSIBase);
    }

    @Override
    public int[] getAutoNotifications() {
        return DSIActivator.ATTR_ALL;
    }
}

