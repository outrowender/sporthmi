/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$3
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener this$1;

    TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$3(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener, int n) {
        this.this$1 = telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).responseChangeTopology(this.val$result);
    }
}

