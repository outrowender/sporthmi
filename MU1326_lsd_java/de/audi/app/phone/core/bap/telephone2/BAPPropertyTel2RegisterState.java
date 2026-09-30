/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.BAPPropertyRegisterStateUtil;
import de.audi.app.phone.core.bap.telephone2.AbstractTel2EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone2.TelBAPManagerTel2Utils;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class BAPPropertyTel2RegisterState
extends AbstractTel2EnqueuedBAPPropertyHandler {
    private int registerState = -1;
    private int networkType = -1;
    private int packetDataNetworkType = -1;

    BAPPropertyTel2RegisterState(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null;
    }

    protected int getRegisterState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            return iGlobalTelephoneStateStruct.getNadInstanceState().getRegisterState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getRegisterState().getTelRegisterState() : 0;
        }
        this.log.log(10000, "BAPPropertyTel2RegisterState#getRegisterState stateStruct or NAD instance state is null");
        return 0;
    }

    protected int getNetworkType(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            return iGlobalTelephoneStateStruct.getNadInstanceState().getNetworkType();
        }
        this.log.log(10000, "BAPPropertyTel2RegisterState#getNetworkType stateStruct or NAD instance state is null");
        return 0;
    }

    protected void updateRegisterState(int n, int n2, int n3) {
        CombiBAPServicePhone2 combiBAPServicePhone2 = this.getCombiService();
        if (combiBAPServicePhone2 != null) {
            this.log.log(1000000, "[BAPPropertyTel2RegisterState#updateRegisterState] updating combi: combiRegisterState=%1, combiNetworkType=%2", (long)n, (long)n2);
            combiBAPServicePhone2.updateRegisterState(n, n2, n3);
        } else {
            this.log.log(100000, "[BAPPropertyTel2RegisterState#updateRegisterState] CombiBAPServicePhone2 is null --> NOP!");
        }
    }

    protected int getNetworkType(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getNetworkType() : 0;
    }

    protected void updateAsync() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        int n = BAPPropertyRegisterStateUtil.getCombiRegisterState(this.getRegisterState(iGlobalTelephoneStateStruct));
        int n2 = BAPPropertyRegisterStateUtil.getCombiNetworkType(this.getNetworkType(iGlobalTelephoneStateStruct));
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getNadInstanceState() : null;
        int n3 = this.getNetworkType(iTelDSIMobileEquipmentDeviceState);
        int n4 = BAPPropertyRegisterStateUtil.getCombiDataNetworkType(n3);
        if (!(this.registerState == n && this.networkType == n2 && this.packetDataNetworkType == n4 || iTelDSIMobileEquipmentDeviceState == null || !TelBAPManagerTel2Utils.telModeSupportsData(iTelDSIMobileEquipmentDeviceState.getTelMode()) && iTelDSIMobileEquipmentDeviceState.isPhoneReady())) {
            this.updateRegisterState(n, n2, n4);
            this.packetDataNetworkType = n4;
            this.registerState = n;
            this.networkType = n2;
        }
    }
}

