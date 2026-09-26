/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelDSIMobileEquipmentListener$9
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ SuppServiceResponseStruct val$telSuppServResult;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$9(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$result = n;
        this.val$telSuppServResult = suppServiceResponseStruct;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).responseDialOperator(this.val$result, this.val$telSuppServResult);
    }
}

