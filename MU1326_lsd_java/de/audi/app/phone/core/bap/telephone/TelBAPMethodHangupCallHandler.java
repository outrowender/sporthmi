/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPCall;
import de.audi.app.phone.core.bap.telephone.TelBAPCallArrayAccess;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodHangupCallHandler$1;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodHangupServiceHandlerCall;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodHangupCallHandler
extends AbstractTel1BAPMethodHandler {
    private final TelBAPMethodHangupServiceHandlerCall connectedGatewayHangupCall;
    private final TelBAPCallArrayAccess callArrayAccess;

    TelBAPMethodHangupCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase, TelBAPCallArrayAccess telBAPCallArrayAccess) {
        super(iTelApplication, dispatcherBase);
        this.callArrayAccess = telBAPCallArrayAccess;
        this.connectedGatewayHangupCall = new TelBAPMethodHangupServiceHandlerCall(iTelApplication);
    }

    void hangupCall(int n) {
        PhoneCall phoneCall;
        this.log.log(-2137614336, "[TelBAPMethodHangupCallHandler#hangupCall] bapCallID=%1", (long)n);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodHangupCallHandler#hangupCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodHangupCallHandler#hangupCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        TelBAPCall telBAPCall = null;
        PhoneCall phoneCall2 = phoneCall = iGlobalTelephoneStateStruct.getConnectedGatewayState() != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState().getCall() : null;
        if (phoneCall != null && phoneCall.isServiceCall()) {
            this.log.log(1078071040, "TelBAPMethodHangupCallHandler#hangupCall(): hangup ServiceCall");
            this.connectedGatewayHangupCall.hangupServiceCall();
            combiBAPServicePhone.hangupCallResult(0);
            return;
        }
        if (phoneCall != null && phoneCall.isLowPrioritySOSCall()) {
            this.log.log(1078071040, "TelBAPMethodHangupCallHandler#hangupCall(): hangup low priority SOS call");
            this.connectedGatewayHangupCall.hangupLowPrioritySOSCall();
            combiBAPServicePhone.hangupCallResult(0);
            return;
        }
        switch (n) {
            case 252: 
            case 253: {
                this.getApplication().getTelephoneDSIAccess().hangupCall(254, 1, true, this);
                this.getApplication().getCallControl().hangupCall(1);
                break;
            }
            case 254: 
            case 255: {
                this.getApplication().getTelephoneDSIAccess().hangupCall(255, 1, true, this);
                this.getApplication().getCallControl().hangupCall(1);
                break;
            }
            default: {
                telBAPCall = this.callArrayAccess.getBAPCall(n);
                if (telBAPCall != null) {
                    int n2 = telBAPCall.getCallID();
                    this.log.log(-2137614336, "[TelBAPMethodHangupCallHandler#hangupCall] invoking hangupCall() for call with id %1", (long)n2);
                    this.getApplication().getTelephoneDSIAccess().hangupCall(telBAPCall.getDeviceRole(), n2, 1, true, this);
                    this.getApplication().getCallControl().hangupCall(1);
                    break;
                }
                this.log.log(-1601830656, "[TelBAPMethodHangupCallHandler#hangupCall] call id for index %1 could not be determined --> NOP!", (long)n);
                this.sendResultNotSuccessful();
            }
        }
    }

    @Override
    protected void setCombiBapService(CombiBAPServicePhone combiBAPServicePhone) {
        super.setCombiBapService(combiBAPServicePhone);
        this.connectedGatewayHangupCall.onCombiServiceChanged(combiBAPServicePhone);
    }

    void setCombiService(CombiBAPServicePhone combiBAPServicePhone) {
        super.setCombiBapService(combiBAPServicePhone);
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    @Override
    public void responseHangupCall(int n, int n2) {
        this.log.log(-2137614336, "[TelBAPMethodHangupCallHandler#responseHangupCall] result=%1", (long)n);
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(int n) {
        this.enqueueResultNotification(new TelBAPMethodHangupCallHandler$1(this, n));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodHangupCallHandler telBAPMethodHangupCallHandler) {
        return telBAPMethodHangupCallHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodHangupCallHandler telBAPMethodHangupCallHandler) {
        return telBAPMethodHangupCallHandler.log;
    }
}

