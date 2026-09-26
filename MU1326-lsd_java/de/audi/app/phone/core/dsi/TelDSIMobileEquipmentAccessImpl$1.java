/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentAccessImpl;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentAccessImpl$1$1;
import de.audi.app.phone.core.dsi.TelDSIUtils;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;

class TelDSIMobileEquipmentAccessImpl$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ ITelDSIMobileEquipmentDeviceState val$nonCallLeadingDevice;
    private final /* synthetic */ boolean val$useDefaultErrorHandling;
    private final /* synthetic */ ITelDSIResponseListener val$listener;
    private final /* synthetic */ TelDSIMobileEquipmentAccessImpl this$0;

    TelDSIMobileEquipmentAccessImpl$1(TelDSIMobileEquipmentAccessImpl telDSIMobileEquipmentAccessImpl, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        this.this$0 = telDSIMobileEquipmentAccessImpl;
        this.val$nonCallLeadingDevice = iTelDSIMobileEquipmentDeviceState;
        this.val$useDefaultErrorHandling = bl;
        this.val$listener = iTelDSIResponseListener;
    }

    @Override
    public void responseHangupCall(int n, int n2) {
        if (n == 0) {
            TelDSIMobileEquipmentAccessImpl.access$000(this.this$0).log(1078071040, "[TelDSIMobileEquipmentAccessImpl.acceptIncomingCallOnNonCallLeadingDevice(...).new TelDefaultDSIResponseListener() {...}#responseHangupCall] accepting call on %1", (Object)TelDSIUtils.getRoleName(this.val$nonCallLeadingDevice.getDeviceRole()));
            TelDSIMobileEquipmentAccessImpl.access$500(this.this$0).acceptCall(TelDSIUtils.getAcceptMode(this.val$nonCallLeadingDevice), this.val$useDefaultErrorHandling, n2, new TelDSIMobileEquipmentAccessImpl$1$1(this), TelDSIMobileEquipmentAccessImpl.access$400(this.this$0));
        } else {
            TelDSIMobileEquipmentAccessImpl.access$600(this.this$0).log(1078071040, "[TelDSIMobileEquipmentAccessImpl#acceptCall] hanging up calls on call leading device not successfull. Not accepting call on non leading device.");
        }
        if (this.val$listener != null) {
            this.val$listener.responseHangupCall(n, n2);
        }
    }

    static /* synthetic */ TelDSIMobileEquipmentAccessImpl access$100(TelDSIMobileEquipmentAccessImpl$1 telDSIMobileEquipmentAccessImpl$1) {
        return telDSIMobileEquipmentAccessImpl$1.this$0;
    }

    static /* synthetic */ ITelDSIResponseListener access$300(TelDSIMobileEquipmentAccessImpl$1 telDSIMobileEquipmentAccessImpl$1) {
        return telDSIMobileEquipmentAccessImpl$1.val$listener;
    }
}

