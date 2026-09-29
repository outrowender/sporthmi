/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodCallResumeHandler$1;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodCallResumeHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodCallResumeHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void resumeCall() {
        this.log.log(-2137614336, "[TelBAPMethodCallResumeHandler#resumeCall]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodCallResumeHandler#resumeCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodCallResumeHandler#resumeCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldCall()) {
            if (iTelDSIMobileEquipmentDeviceState.getCallState().getHeldCall().getTelCallState() == 8) {
                this.getApplication().getTelephoneDSIAccess().acceptCall(1, true, this);
            } else {
                this.log.log(1078071040, "[TelBAPMethodCallResumeHandler#resumeCall] invoking swapCalls()");
                this.getApplication().getTelephoneDSIAccess().swapCalls(1, true, this);
            }
        } else if (combiBAPServicePhone != null) {
            this.log.log(-1601830656, "[TelBAPMethodCallResumeHandler#resumeCall] There is currently no held call, returning RESUME_CALL_RESULT_NOT_SUCCESSFUL");
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    @Override
    public void responseSwapCalls(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(int n) {
        this.enqueueResultNotification(new TelBAPMethodCallResumeHandler$1(this, n));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodCallResumeHandler telBAPMethodCallResumeHandler) {
        return telBAPMethodCallResumeHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodCallResumeHandler telBAPMethodCallResumeHandler) {
        return telBAPMethodCallResumeHandler.log;
    }
}

