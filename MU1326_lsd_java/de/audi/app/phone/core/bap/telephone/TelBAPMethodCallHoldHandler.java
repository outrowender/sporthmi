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

class TelBAPMethodCallHoldHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodCallHoldHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void callHold() {
        this.log.log(10000000, "[TelBAPMethodCallHoldHandler#callHold]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodCallHoldHandler#callHold] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodCallHoldHandler#callHold] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && !iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldCall()) {
            int n = iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState();
            boolean bl = iTelDSIMobileEquipmentDeviceState.isResponseAndHoldSupported();
            if ((n == 15 || n == 27) && bl) {
                this.log.log(1000000, "[TelBAPMethodCallHoldHandler#callHold] accepting call for Response & Hold!");
                this.getApplication().getTelephoneDSIAccess().placeIncomingCallOnHold(1, true, this);
            } else {
                this.log.log(10000000, "[TelBAPMethodCallHoldHandler#callHold] invoking swapCalls().");
                this.getApplication().getTelephoneDSIAccess().swapCalls(1, true, this);
            }
        } else if (combiBAPServicePhone != null) {
            this.log.log(100000, "[TelBAPMethodCallHoldHandler#callHold] There is already a held call, returning CALL_HOLD_RESULT_NOT_SUCCESSFUL");
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseAcceptCall(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodCallHoldHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodCallHoldHandler.this.log.log(1000000, "[TelBAPMethodCallHoldHandler#sendResult] returning result %1 to combi.", (long)n);
                    combiBAPServicePhone.callHoldResult(n);
                } else {
                    TelBAPMethodCallHoldHandler.this.log.log(10000000, "[TelBAPMethodCallHoldHandler#sendResult] CombiService is null!");
                }
            }
        });
    }

    public void responseSwapCalls(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }
}

