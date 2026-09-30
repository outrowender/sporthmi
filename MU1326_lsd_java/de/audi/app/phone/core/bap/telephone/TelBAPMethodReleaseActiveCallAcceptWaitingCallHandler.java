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

class TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void releaseActiveCallAcceptWaitingCall() {
        CallStateStruct callStateStruct;
        this.log.log(10000000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        CallStateStruct callStateStruct2 = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        CallStateStruct callStateStruct3 = callStateStruct = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.getCallState() : null;
        if (callStateStruct2 != null && callStateStruct2.isHasIncomingCall() && callStateStruct2.isHasActiveCall()) {
            this.log.log(1000000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall]");
            this.getApplication().getTelephoneDSIAccess().acceptWaitingCallReplaceActiveCall(1, true, this);
        } else if (callStateStruct != null && callStateStruct.isHasIncomingCall()) {
            this.log.log(10000000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] accepting call on non call leading device.");
            this.getApplication().getTelephoneDSIAccess().acceptIncomingCallOnNonCallLeadingDevice(1, true, this);
            this.getApplication().getCallControl().acceptIncomingCall(1);
        } else {
            this.log.log(1000000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] There is no incoming and active call, returning MPRACAWC_RESULT_NOT_SUCCESSFUL");
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseHangupCall(int n, int n2) {
        if (n == 0) {
            this.getApplication().getCallControl().acceptOnNCLDOngoing(true);
        }
    }

    public void responseAcceptCall(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
        this.getApplication().getCallControl().acceptOnNCLDOngoing(false);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler.this.log.log(1000000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#AcceptCallsResponse] returning result %1 to combi.", (long)n);
                    combiBAPServicePhone.releaseActiveCallAcceptWaitingCallResult(n);
                } else {
                    TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler.this.log.log(10000000, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#AcceptCallsResponse] CombiService is null!");
                }
            }
        });
    }
}

