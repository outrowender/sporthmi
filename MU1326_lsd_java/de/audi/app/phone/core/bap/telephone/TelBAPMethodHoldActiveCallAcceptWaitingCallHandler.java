/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodHoldActiveCallAcceptWaitingCallHandler$1;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodHoldActiveCallAcceptWaitingCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodHoldActiveCallAcceptWaitingCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void callHoldActiveAcceptWaitingCall() {
        CallStateStruct callStateStruct;
        this.log.log(-2137614336, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        CallStateStruct callStateStruct2 = callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        if (callStateStruct != null && callStateStruct.isHasActiveCall() && callStateStruct.isHasIncomingCall() && !callStateStruct.isHasOnHoldCall()) {
            this.log.log(1078071040, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldAcceptWaitingCall] invoking accept call (mod = ACCEPTMODE_HOLD).");
            this.getApplication().getTelephoneDSIAccess().acceptCall(1, true, this);
        } else {
            this.log.log(-1601830656, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldAcceptWaitingCall] There is already a held call, returning MPCHAWC_RESULT_NOT_SUCCESSFUL");
            this.sendResultNotSuccessful();
        }
    }

    @Override
    public void responseAcceptCall(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(int n) {
        this.enqueueResultNotification(new TelBAPMethodHoldActiveCallAcceptWaitingCallHandler$1(this, n));
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodHoldActiveCallAcceptWaitingCallHandler telBAPMethodHoldActiveCallAcceptWaitingCallHandler) {
        return telBAPMethodHoldActiveCallAcceptWaitingCallHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodHoldActiveCallAcceptWaitingCallHandler telBAPMethodHoldActiveCallAcceptWaitingCallHandler) {
        return telBAPMethodHoldActiveCallAcceptWaitingCallHandler.log;
    }
}

