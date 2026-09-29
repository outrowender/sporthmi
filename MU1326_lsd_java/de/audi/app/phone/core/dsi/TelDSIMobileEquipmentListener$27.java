/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelDSIMobileEquipmentListener$27
extends CommandResponse {
    private final /* synthetic */ int val$optMode;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$27(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, int n, int n2) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$optMode = n;
        this.val$result = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetOptimizationMode(this.val$optMode, this.val$result);
    }
}

