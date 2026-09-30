/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPCallArrayAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodSplitCallHandler
extends AbstractTel1BAPMethodHandler {
    private final TelBAPCallArrayAccess callArrayAccess;

    TelBAPMethodSplitCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase, TelBAPCallArrayAccess telBAPCallArrayAccess) {
        super(iTelApplication, dispatcherBase);
        this.callArrayAccess = telBAPCallArrayAccess;
    }

    void splitCall(int n) {
        this.log.log(10000000, "[TelBAPMethodSplitCallHandler#splitCall] bapCallID=%1", (long)n);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodSplitCallHandler#splitCall] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodSplitCallHandler#splitCall] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            int n2 = this.callArrayAccess.getDSICallID(n);
            if (n2 != -1) {
                this.log.log(10000000, "[TelBAPMethodSplitCallHandler#splitCall] bapCallID=%1, dsiCallID=%2", (long)n, (long)n2);
                this.getApplication().getTelephoneDSIAccess().splitCall(n2, 1, true, this);
            } else {
                this.log.log(100000, "[TelBAPMethodSplitCallHandler#splitCall] call id could not be determined.");
                this.sendResultNotSuccessful();
            }
        } else {
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseSplitCall(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodSplitCallHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodSplitCallHandler.this.log.log(1000000, "[TelBAPMethodSplitCallHandler#sendResult] returning result %1 to combi.", (long)n);
                    combiBAPServicePhone.splitCallResult(n);
                } else {
                    TelBAPMethodSplitCallHandler.this.log.log(100000, "[TelBAPMethodSplitCallHandler#sendResult] CombiService is null!");
                }
            }
        });
    }
}

