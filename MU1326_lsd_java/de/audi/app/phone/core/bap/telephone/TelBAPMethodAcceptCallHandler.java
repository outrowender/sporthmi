/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodAcceptCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodAcceptCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void acceptCall() {
        this.log.log(10000000, "[TelBAPMethodAcceptCallHandler#acceptCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodAcceptCallHandler#acceptCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodAcceptCallHandler#acceptCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && iTelDSIMobileEquipmentDeviceState.getCallState().isHasIncomingCall()) {
            this.log.log(10000000, "[TelBAPMethodAcceptCallHandler#acceptCall] accepting call on call leading device.");
            this.getApplication().getTelephoneDSIAccess().acceptCall(1, true, this);
            this.getApplication().getCallControl().acceptIncomingCall(1);
        } else if (iTelDSIMobileEquipmentDeviceState2 != null && iTelDSIMobileEquipmentDeviceState2.getCallState() != null && iTelDSIMobileEquipmentDeviceState2.getCallState().isHasIncomingCall()) {
            this.log.log(10000000, "[TelBAPMethodAcceptCallHandler#acceptCall] accepting call on non call leading device.");
            this.getApplication().getTelephoneDSIAccess().acceptIncomingCallOnNonCallLeadingDevice(1, true, this);
            this.getApplication().getCallControl().acceptIncomingCall(1);
        } else {
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseAcceptCall(int n, int n2) {
        this.log.log(10000000, "[TelBAPMethodAcceptCallHandler#responseAcceptCall] result=%1", (long)n);
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodAcceptCallHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodAcceptCallHandler.this.log.log(1000000, "[TelBAPMethodAcceptCallHandler#sendResult] sending result %1 to combi", (long)n);
                    combiBAPServicePhone.acceptCallResult(n);
                } else {
                    TelBAPMethodAcceptCallHandler.this.log.log(100000, "[TelBAPMethodAcceptCallHandler#sendResult] CombiService is null!");
                }
            }
        });
    }
}

