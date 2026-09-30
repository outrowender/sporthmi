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

class TelBAPMethodCallResumeHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodCallResumeHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void resumeCall() {
        this.log.log(10000000, "[TelBAPMethodCallResumeHandler#resumeCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodCallResumeHandler#resumeCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodCallResumeHandler#resumeCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldCall()) {
            if (iTelDSIMobileEquipmentDeviceState.getCallState().getHeldCall().getTelCallState() == 8) {
                this.getApplication().getTelephoneDSIAccess().acceptCall(1, true, this);
            } else {
                this.log.log(1000000, "[TelBAPMethodCallResumeHandler#resumeCall] invoking swapCalls()");
                this.getApplication().getTelephoneDSIAccess().swapCalls(1, true, this);
            }
        } else if (combiBAPServicePhone != null) {
            this.log.log(100000, "[TelBAPMethodCallResumeHandler#resumeCall] There is currently no held call, returning RESUME_CALL_RESULT_NOT_SUCCESSFUL");
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseSwapCalls(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodCallResumeHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodCallResumeHandler.this.log.log(1000000, "[TelBAPMethodCallResumeHandler#sendResult] returning result %1 to combi.", (long)n);
                    combiBAPServicePhone.resumeCallResult(n);
                } else {
                    TelBAPMethodCallResumeHandler.this.log.log(100000, "[TelBAPMethodCallResumeHandler#sendResult] CombiService is null!");
                }
            }
        });
    }
}

