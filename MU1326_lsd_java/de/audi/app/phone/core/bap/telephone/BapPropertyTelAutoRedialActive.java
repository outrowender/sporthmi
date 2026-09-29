/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BapPropertyTelAutoRedialActive
extends AbstractTel1EnqueuedBAPPropertyHandler {
    public BapPropertyTelAutoRedialActive(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return n == 0x5000100 || n == 0x5000200 || n == 0x5000300;
    }

    @Override
    protected void updateAsync() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.getCallLeadingDeviceState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        if (combiBAPServicePhone != null && iTelDSIMobileEquipmentDeviceState != null) {
            boolean bl = iTelDSIMobileEquipmentDeviceState.isAutomaticRedialActive();
            combiBAPServicePhone.updateAutomaticRedialActive(bl);
        }
    }
}

