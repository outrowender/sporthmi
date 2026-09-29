/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentAccessImpl;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentAccessImpl$1;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;

class TelDSIMobileEquipmentAccessImpl$1$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelDSIMobileEquipmentAccessImpl$1 this$1;

    TelDSIMobileEquipmentAccessImpl$1$1(TelDSIMobileEquipmentAccessImpl$1 telDSIMobileEquipmentAccessImpl$1) {
        this.this$1 = telDSIMobileEquipmentAccessImpl$1;
    }

    @Override
    public void responseAcceptCall(int n, int n2) {
        TelDSIMobileEquipmentAccessImpl.access$200(TelDSIMobileEquipmentAccessImpl$1.access$100(this.this$1)).getGlobalTelephoneStateManager().setAcceptIncomingCallOnNonCallLeadingDevicePending(false);
        if (TelDSIMobileEquipmentAccessImpl$1.access$300(this.this$1) != null) {
            TelDSIMobileEquipmentAccessImpl$1.access$300(this.this$1).responseAcceptCall(n, n2);
        }
    }
}

