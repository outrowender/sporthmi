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

class TelBAPMethodSetWaitingCallonHoldHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodSetWaitingCallonHoldHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void setWaitingCallOnHold() {
        this.log.log(10000000, "[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && !iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldCall() && iTelDSIMobileEquipmentDeviceState.isResponseAndHoldSupported()) {
            int n = iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState();
            boolean bl = iTelDSIMobileEquipmentDeviceState.isResponseAndHoldSupported();
            if ((n == 15 || n == 27) && bl) {
                this.log.log(10000000, "[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold] placing incoming call on hold on call leading device.");
                this.getApplication().getTelephoneDSIAccess().placeIncomingCallOnHold(1, true, this);
            }
        } else {
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
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodSetWaitingCallonHoldHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodSetWaitingCallonHoldHandler.this.log.log(1000000, "[TelBAPMethodSetWaitingCallonHoldHandler#sendResult] returning result %1 to combi.", (long)n);
                    combiBAPServicePhone.setWaitingCallOnHoldResult(n);
                } else {
                    TelBAPMethodSetWaitingCallonHoldHandler.this.log.log(100000, "[TelBAPMethodSetWaitingCallonHoldHandler#sendResult] CombiService is null!");
                }
            }
        });
    }
}

