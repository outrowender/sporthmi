/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler$1;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void releaseActiveCallAcceptWaitingCall() {
        CallStateStruct callStateStruct;
        this.log.log(-2137614336, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        CallStateStruct callStateStruct2 = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        CallStateStruct callStateStruct3 = callStateStruct = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.getCallState() : null;
        if (callStateStruct2 != null && callStateStruct2.isHasIncomingCall() && callStateStruct2.isHasActiveCall()) {
            this.log.log(1078071040, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall]");
            this.getApplication().getTelephoneDSIAccess().acceptWaitingCallReplaceActiveCall(1, true, this);
        } else if (callStateStruct != null && callStateStruct.isHasIncomingCall()) {
            this.log.log(-2137614336, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] accepting call on non call leading device.");
            this.getApplication().getTelephoneDSIAccess().acceptIncomingCallOnNonCallLeadingDevice(1, true, this);
            this.getApplication().getCallControl().acceptIncomingCall(1);
        } else {
            this.log.log(1078071040, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] There is no incoming and active call, returning MPRACAWC_RESULT_NOT_SUCCESSFUL");
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    @Override
    public void responseHangupCall(int n, int n2) {
        if (n == 0) {
            this.getApplication().getCallControl().acceptOnNCLDOngoing(true);
        }
    }

    @Override
    public void responseAcceptCall(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
        this.getApplication().getCallControl().acceptOnNCLDOngoing(false);
    }

    private void sendResult(int n) {
        this.enqueueResultNotification(new TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler$1(this, n));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler telBAPMethodReleaseActiveCallAcceptWaitingCallHandler) {
        return telBAPMethodReleaseActiveCallAcceptWaitingCallHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler telBAPMethodReleaseActiveCallAcceptWaitingCallHandler) {
        return telBAPMethodReleaseActiveCallAcceptWaitingCallHandler.log;
    }
}

