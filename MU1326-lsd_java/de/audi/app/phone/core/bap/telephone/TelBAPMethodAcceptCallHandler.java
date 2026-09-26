/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodAcceptCallHandler$1;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodAcceptCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodAcceptCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void acceptCall() {
        this.log.log(-2137614336, "[TelBAPMethodAcceptCallHandler#acceptCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodAcceptCallHandler#acceptCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodAcceptCallHandler#acceptCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && iTelDSIMobileEquipmentDeviceState.getCallState().isHasIncomingCall()) {
            this.log.log(-2137614336, "[TelBAPMethodAcceptCallHandler#acceptCall] accepting call on call leading device.");
            this.getApplication().getTelephoneDSIAccess().acceptCall(1, true, this);
            this.getApplication().getCallControl().acceptIncomingCall(1);
        } else if (iTelDSIMobileEquipmentDeviceState2 != null && iTelDSIMobileEquipmentDeviceState2.getCallState() != null && iTelDSIMobileEquipmentDeviceState2.getCallState().isHasIncomingCall()) {
            this.log.log(-2137614336, "[TelBAPMethodAcceptCallHandler#acceptCall] accepting call on non call leading device.");
            this.getApplication().getTelephoneDSIAccess().acceptIncomingCallOnNonCallLeadingDevice(1, true, this);
            this.getApplication().getCallControl().acceptIncomingCall(1);
        } else {
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    @Override
    public void responseAcceptCall(int n, int n2) {
        this.log.log(-2137614336, "[TelBAPMethodAcceptCallHandler#responseAcceptCall] result=%1", (long)n);
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(int n) {
        this.enqueueResultNotification(new TelBAPMethodAcceptCallHandler$1(this, n));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodAcceptCallHandler telBAPMethodAcceptCallHandler) {
        return telBAPMethodAcceptCallHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodAcceptCallHandler telBAPMethodAcceptCallHandler) {
        return telBAPMethodAcceptCallHandler.log;
    }
}

