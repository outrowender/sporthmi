/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodSwapCallsHandler$1;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodSwapCallsHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodSwapCallsHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void swapCalls() {
        CallStateStruct callStateStruct;
        this.log.log(-2137614336, "[TelBAPMethodSwapCallsHandler#swapCalls]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodSwapCallsHandler#swapCalls] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodSwapCallsHandler#swapCalls] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        CallStateStruct callStateStruct2 = callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        if (callStateStruct != null && callStateStruct.isMultipartyActive()) {
            this.log.log(1078071040, "[TelBAPMethodSwapCallsHandler#swapCalls] invoking swapCalls()");
            this.getApplication().getTelephoneDSIAccess().swapCalls(1, true, this);
        } else {
            this.sendResultNotSuccessful();
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    @Override
    public void responseSwapCalls(int n, int n2) {
        this.log.log(-2137614336, "[TelBAPMethodSwapCallsHandler#responseSwapCalls] result=%1", (long)n);
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(int n) {
        this.enqueueResultNotification(new TelBAPMethodSwapCallsHandler$1(this, n));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodSwapCallsHandler telBAPMethodSwapCallsHandler) {
        return telBAPMethodSwapCallsHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodSwapCallsHandler telBAPMethodSwapCallsHandler) {
        return telBAPMethodSwapCallsHandler.log;
    }
}

