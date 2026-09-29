/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;

class TelDSIMobileEquipmentListener$37
extends CommandResponse {
    private final /* synthetic */ ServiceCodeTypeStruct val$serviceCodeType;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$37(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$serviceCodeType = serviceCodeTypeStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).updateServiceCodeType(this.val$serviceCodeType, this.val$validFlag);
    }
}

