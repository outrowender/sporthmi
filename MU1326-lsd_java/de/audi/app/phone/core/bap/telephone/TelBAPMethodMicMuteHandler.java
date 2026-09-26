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

class TelBAPMethodMicMuteHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodMicMuteHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void setMicMuteState(boolean bl) {
        this.log.log(-2137614336, "[TelBAPMethodMicMuteHandler#dialNumber] micMuteState=%1", bl);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodMicMuteHandler#dialNumber] telState is null --> NOP!");
            return;
        }
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodMicMuteHandler#dialNumber] combiService is null --> NOP!");
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null) {
            int n = bl ? 0 : 1;
            int n2 = iTelDSIMobileEquipmentDeviceState.getmICMuteState();
            if (n2 == n) {
                this.log.log(-2137614336, "[TelBAPMethodMicMuteHandler#setMicMuteState] request to set mic state %1 aborted,  this is the current state", (long)n2);
                return;
            }
            this.log.log(1078071040, "[TelBAPMethodMicMuteHandler#setMicMuteState] invoking mic mute, setting value %1", (long)n);
            this.getApplication().getTelephoneDSIAccess().requestSetMICMuteState(n, 1, true, this);
        }
    }

    @Override
    public void responseSetMICMuteState(int n, int n2) {
        this.log.log(-2137614336, "[TelBAPMethodMicMuteHandler#setMICMuteStateResponse] recieved result result %1 (no ivokokation on combi)", (long)n);
    }
}

