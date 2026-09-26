/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.CFResponseData;

class TelDSIMobileEquipmentListener$4
extends CommandResponse {
    private final /* synthetic */ CFResponseData[] val$telCFResponseData;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$4(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, CFResponseData[] cFResponseDataArray, int n) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$telCFResponseData = cFResponseDataArray;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).responseCallForward(this.val$telCFResponseData, this.val$result);
    }
}

