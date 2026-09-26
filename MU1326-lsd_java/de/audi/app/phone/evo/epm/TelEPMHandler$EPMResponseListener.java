/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.epm;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.app.phone.evo.epm.TelEPMHandler;
import de.audi.app.phone.evo.epm.TelEPMHandler$1;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelEPMHandler$EPMResponseListener
extends TelDefaultDSIResponseListener
implements ITelEPMHandler {
    private final /* synthetic */ TelEPMHandler this$0;

    private TelEPMHandler$EPMResponseListener(TelEPMHandler telEPMHandler) {
        this.this$0 = telEPMHandler;
    }

    @Override
    public void responseAcceptCall(int n, int n2) {
        if (TelEPMHandler.access$200(this.this$0)) {
            TelEPMHandler.access$300(this.this$0).log(-2137614336, "[TelEPMHandler.EPMResponseListener#responseAcceptCall] call accepted but already in telephone --> NOP!");
        } else if (n == 0 && TelEPMHandler.access$400(this.this$0, n2)) {
            TelEPMHandler.access$500(this.this$0).log(1078071040, "[TelEPMHandler.EPMResponseListener#responseAcceptCall] call accepted - switching to telephone.");
            this.triggerSwitchToTelephoneIncomingCall();
        } else {
            TelEPMHandler.access$600(this.this$0).log(1078071040, "[TelEPMHandler.EPMResponseListener#responseAcceptCall] result=%1, terminalID=%2 --> NOP!", (long)n, (long)n2);
        }
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        TelEPMHandler.access$700(this.this$0).log(1078071040, "[TelEPMHandler.EPMResponseListener#responseDialNumber]");
        this.triggerSwitchToTelephoneOutgoingCall();
    }

    private void triggerSwitchToTelephoneOutgoingCall() {
        TelEPMHandler.access$800(this.this$0, -1818885120).setStatus(1);
    }

    private void triggerSwitchToTelephoneIncomingCall() {
        TelEPMHandler.access$900(this.this$0, 3996).setValue(1);
    }

    @Override
    public void responseSetMICMuteState(int n, int n2) {
        if (n == 0 && TelEPMHandler.access$400(this.this$0, n2)) {
            TelEPMHandler.access$1000(this.this$0).log(1078071040, "[TelEPMHandler.EPMResponseListener#setMICMuteStateResponse] staying in telephone");
            TelEPMHandler.access$1100(this.this$0);
        }
    }

    @Override
    public void responseSetHandsFreeMode(int n, int n2) {
        if (n == 0 && TelEPMHandler.access$400(this.this$0, n2)) {
            TelEPMHandler.access$1200(this.this$0).log(1078071040, "[TelEPMHandler.EPMResponseListener#responseSetHandsFreeMode] staying in telephone");
            TelEPMHandler.access$1100(this.this$0);
        }
    }

    @Override
    public void responseSwapCalls(int n, int n2) {
        if (n == 0 && TelEPMHandler.access$400(this.this$0, n2)) {
            TelEPMHandler.access$1300(this.this$0).log(1078071040, "[TelEPMHandler.EPMResponseListener#responseSwapCalls] staying in telephone");
            TelEPMHandler.access$1100(this.this$0);
        }
    }

    /* synthetic */ TelEPMHandler$EPMResponseListener(TelEPMHandler telEPMHandler, TelEPMHandler$1 telEPMHandler$1) {
        this(telEPMHandler);
    }
}

