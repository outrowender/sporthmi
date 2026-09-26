/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.LockStateStruct;

class TelDSIMobileEquipmentListener$36
extends CommandResponse {
    private final /* synthetic */ LockStateStruct val$lockState;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$36(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, LockStateStruct lockStateStruct, int n) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$lockState = lockStateStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).updateLockState(this.val$lockState, this.val$validFlag);
    }
}

