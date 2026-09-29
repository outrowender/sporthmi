/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.BAPPropertyRegisterStateUtil;
import de.audi.app.phone.core.bap.TelBapRegisterStateStruct;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BAPPropertyTelRegisterState
extends AbstractTel1EnqueuedBAPPropertyHandler {
    private volatile TelBapRegisterStateStruct registerStateStruct;

    public BAPPropertyTelRegisterState(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected void updateAsync() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        int n;
        int n2;
        int n3;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = this.getCallLeadingDeviceState();
        int n4 = BAPPropertyRegisterStateUtil.getCombiRegisterState(this.getRegisterState(iTelDSIMobileEquipmentDeviceState2));
        TelBapRegisterStateStruct telBapRegisterStateStruct = new TelBapRegisterStateStruct(n4, n3 = BAPPropertyRegisterStateUtil.getCombiNetworkType(this.getNetworkType(iTelDSIMobileEquipmentDeviceState2)), n2 = BAPPropertyRegisterStateUtil.getCombiDataNetworkType(n = this.getNetworkType(iTelDSIMobileEquipmentDeviceState = this.getTelephoneState() != null ? this.getTelephoneState().getNadInstanceState() : null)));
        if (!telBapRegisterStateStruct.equals(this.registerStateStruct)) {
            this.updateRegisterState(telBapRegisterStateStruct);
            this.registerStateStruct = telBapRegisterStateStruct;
        }
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null;
    }

    protected int getRegisterState(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getRegisterState() != null ? iTelDSIMobileEquipmentDeviceState.getRegisterState().getTelRegisterState() : 0;
    }

    protected int getNetworkType(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getNetworkType() : 0;
    }

    protected void updateRegisterState(TelBapRegisterStateStruct telBapRegisterStateStruct) {
        if (telBapRegisterStateStruct == null) {
            this.log.log(10000, "BAPPropertyTelRegisterState#updateRegisterState registerStateStruct is null");
            return;
        }
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        if (combiBAPServicePhone != null) {
            this.log.log(1078071040, "[BAPPropertyTelRegisterState#updateRegisterState] updating combi: %1", (Object)telBapRegisterStateStruct);
            combiBAPServicePhone.updateRegisterState(telBapRegisterStateStruct.getRegisterState(), telBapRegisterStateStruct.getNetworkType(), telBapRegisterStateStruct.getPacketDataNetworkType());
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelRegisterState#updateRegisterState] CombiBAPServicePhone is null --> NOP!");
        }
    }
}

