/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodHoldActiveCallAcceptWaitingCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodHoldActiveCallAcceptWaitingCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void callHoldActiveAcceptWaitingCall() {
        CallStateStruct callStateStruct;
        this.log.log(10000000, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldActiveAcceptWaitingCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        CallStateStruct callStateStruct2 = callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        if (callStateStruct != null && callStateStruct.isHasActiveCall() && callStateStruct.isHasIncomingCall() && !callStateStruct.isHasOnHoldCall()) {
            this.log.log(1000000, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldAcceptWaitingCall] invoking accept call (mod = ACCEPTMODE_HOLD).");
            this.getApplication().getTelephoneDSIAccess().acceptCall(1, true, this);
        } else {
            this.log.log(100000, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#callHoldAcceptWaitingCall] There is already a held call, returning MPCHAWC_RESULT_NOT_SUCCESSFUL");
            this.sendResultNotSuccessful();
        }
    }

    public void responseAcceptCall(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodHoldActiveCallAcceptWaitingCallHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodHoldActiveCallAcceptWaitingCallHandler.this.log.log(1000000, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#sendResult] returning result %1 to combi.", (long)n);
                    combiBAPServicePhone.callHoldAcceptWaitingCallResult(n);
                } else {
                    TelBAPMethodHoldActiveCallAcceptWaitingCallHandler.this.log.log(100000, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#sendResult] CombiService is null!");
                }
            }
        });
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }
}

