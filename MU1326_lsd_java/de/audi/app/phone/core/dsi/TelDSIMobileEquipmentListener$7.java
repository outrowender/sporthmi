/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelDSIMobileEquipmentListener$7
extends CommandResponse {
    private final /* synthetic */ int val$telCLIRState;
    private final /* synthetic */ int val$telCLIRNWState;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$7(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, int n, int n2, int n3) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$telCLIRState = n;
        this.val$telCLIRNWState = n2;
        this.val$result = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).responseCLIR(this.val$telCLIRState, this.val$telCLIRNWState, this.val$result);
    }
}

