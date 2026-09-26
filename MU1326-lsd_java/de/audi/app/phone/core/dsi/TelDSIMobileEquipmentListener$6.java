/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelDSIMobileEquipmentListener$6
extends CommandResponse {
    private final /* synthetic */ int val$telLockCode;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$6(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, int n, int n2) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$telLockCode = n;
        this.val$result = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).responseChangeSIMCode(this.val$telLockCode, this.val$result);
    }
}

