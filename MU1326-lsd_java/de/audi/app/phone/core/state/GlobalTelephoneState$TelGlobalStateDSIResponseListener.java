/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.GlobalTelephoneState$1;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class GlobalTelephoneState$TelGlobalStateDSIResponseListener
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ GlobalTelephoneState this$0;

    private GlobalTelephoneState$TelGlobalStateDSIResponseListener(GlobalTelephoneState globalTelephoneState) {
        this.this$0 = globalTelephoneState;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        GlobalTelephoneState.access$400(this.this$0, 0x1A000100);
    }

    /* synthetic */ GlobalTelephoneState$TelGlobalStateDSIResponseListener(GlobalTelephoneState globalTelephoneState, GlobalTelephoneState$1 globalTelephoneState$1) {
        this(globalTelephoneState);
    }
}

